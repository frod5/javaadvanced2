package annotation.basic;

import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME) // 자바 실행중에도 읽을 수 있다.
@Target({ElementType.TYPE, ElementType.METHOD}) // 애노테이션 대상 -> 클래스, 메소드에 적용가능.
@Documented
public @interface AnnoMeta {
}
