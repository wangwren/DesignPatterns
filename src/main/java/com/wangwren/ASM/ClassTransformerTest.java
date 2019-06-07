package com.wangwren.ASM;

import org.objectweb.asm.*;

import java.io.File;
import java.io.FileOutputStream;
import java.io.OutputStream;

import static org.objectweb.asm.Opcodes.*;

public class ClassTransformerTest {
    public static void main(String[] args) throws Exception {
        //使用ASM读指定的class文件
        ClassReader cr = new ClassReader(
                ClassPrinter.class.getClassLoader().getResourceAsStream("com/wangwren/ASM/Tank.class"));

        //创建一个写class文件的类
        ClassWriter cw = new ClassWriter(0);
        ClassVisitor cv = new ClassVisitor(ASM4, cw) {
            @Override
            public MethodVisitor visitMethod(int access, String name, String descriptor, String signature, String[] exceptions) {
                MethodVisitor mv = super.visitMethod(access, name, descriptor, signature, exceptions);
                //return mv;
                return new MethodVisitor(ASM4, mv) {
                    @Override
                    public void visitCode() {
                        visitMethodInsn(INVOKESTATIC, "com/wangwren/ASM/TimeProxy","before", "()V", false);
                        super.visitCode();
                    }
                };
            }
        };

        cr.accept(cv, 0);
        byte[] b2 = cw.toByteArray();

        MyClassLoader cl = new MyClassLoader();
        //Class c = cl.loadClass("com.mashibing.dp.ASM.Tank");
        cl.loadClass("com.wangwren.ASM.TimeProxy");
        Class c2 = cl.defineClass("com.wangwren.ASM.Tank", b2);
        c2.getConstructor().newInstance();


        String path = (String)System.getProperties().get("user.dir");
        File f = new File(path + "/com/wangwren/ASM/");
        f.mkdirs();

        FileOutputStream fos = new FileOutputStream(new File(path + "/com/wangwren/ASM/Tank_0.class"));
        fos.write(b2);
        fos.flush();
        fos.close();

    }
}
