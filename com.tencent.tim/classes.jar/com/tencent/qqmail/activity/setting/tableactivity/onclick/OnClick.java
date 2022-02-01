package com.tencent.qqmail.activity.setting.tableactivity.onclick;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OnClick
{
  boolean canCallFromSchema() default false;
  
  int value();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.tableactivity.onclick.OnClick
 * JD-Core Version:    0.7.0.1
 */