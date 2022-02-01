package com.tencent.qqmail.annotation.database;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ORMField
{
  String columnName() default "";
  
  String expression() default "";
  
  boolean inline() default false;
  
  String javaFieldType() default "";
  
  String tableName() default "";
  
  int transation() default 1;
  
  boolean updateKey() default false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.annotation.database.ORMField
 * JD-Core Version:    0.7.0.1
 */