package reflection;

import reflection.data.User;

import java.lang.reflect.Field;

public class FieldV2 {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        User userA = new User("id1", "userA", 20);
        System.out.println("기존 이름: " + userA.getName());

        Class<User> userClass = User.class;
        Field nameField = userClass.getDeclaredField("name");

        // private 필드에 접근 허용, private 메소드도 이렇게 호출 가능
        nameField.setAccessible(true); // private 접근 허용
        nameField.set(userA, "userB");
        System.out.println("변경된 이름: " + userA.getName());
    }
}
