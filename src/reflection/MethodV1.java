package reflection;

import reflection.data.BasicData;

import java.lang.reflect.Method;

public class MethodV1 {

    public static void main(String[] args) {
        Class<BasicData> helloClass = BasicData.class;
        System.out.println("==== methods() ====");
        Method[] methods = helloClass.getMethods();  // 상속 포함 public 메소드만
        for (Method method : methods) {
            System.out.println("method = " + method);
        }

        System.out.println("==== decleared methods() ====");
        Method[] declaredMethods = helloClass.getDeclaredMethods(); // 상속 빼고 내 메소드들 모두
        for (Method declaredMethod : declaredMethods) {
            System.out.println("declaredMethod = " + declaredMethod);
        }
    }
}
