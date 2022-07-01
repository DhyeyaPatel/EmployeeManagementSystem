package com.EmployeeManagementSystem.EmployeeManagementSystem.CustomAnnotations;

import java.lang.annotation.*;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@Documented
public @interface CustomS {
    String name();
    Class<?> type();
}
