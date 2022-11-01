package hello.aop.member.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME) // 애플리케이션이 살아있을때까지 살아있음
@Target(ElementType.METHOD)
public @interface MethodAop {
    String value();
}
