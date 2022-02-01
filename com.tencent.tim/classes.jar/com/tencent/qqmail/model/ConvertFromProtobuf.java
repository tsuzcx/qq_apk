package com.tencent.qqmail.model;

import com.tencent.qqmail.protocol.UMA.DefaultProtoWrap;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.FIELD})
public @interface ConvertFromProtobuf
{
  Class<?> getProtoType() default DefaultProtoWrap.class;
  
  boolean isConvert() default false;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.ConvertFromProtobuf
 * JD-Core Version:    0.7.0.1
 */