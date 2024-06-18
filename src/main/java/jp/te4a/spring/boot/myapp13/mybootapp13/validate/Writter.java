package jp.te4a.spring.boot.myapp13.mybootapp13.validate;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Documented
@Constraint(validatedBy = TestWritter.class)
@Target({ElementType.METHOD,ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface Writter {
    String ok();
    String message() default "Input {ok}.";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}
