package com.tencent.qqmail.utilities.schedule;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnScheduled
{
  public static final int BACKGROUND = 8;
  public static final int CHARGE = 4;
  public static final int NETWORK = 1;
  public static final int WIFI = 2;
  
  boolean allowExclude() default false;
  
  long deadline() default 9223372036854775807L;
  
  long interval() default 28800000L;
  
  int status() default 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.schedule.OnScheduled
 * JD-Core Version:    0.7.0.1
 */