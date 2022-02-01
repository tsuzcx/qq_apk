package com.alibaba.fastjson.annotation;

import com.alibaba.fastjson.parser.Feature;
import com.alibaba.fastjson.serializer.SerializerFeature;
import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD, java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.PARAMETER})
public @interface JSONField
{
  boolean deserialize() default true;
  
  String format() default "";
  
  String name() default "";
  
  int ordinal() default 0;
  
  Feature[] parseFeatures() default {};
  
  boolean serialize() default true;
  
  SerializerFeature[] serialzeFeatures() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.alibaba.fastjson.annotation.JSONField
 * JD-Core Version:    0.7.0.1
 */