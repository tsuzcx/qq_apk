package android.support.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.ANNOTATION_TYPE})
public @interface LongDef
{
  boolean flag() default false;
  
  long[] value() default {};
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.annotation.LongDef
 * JD-Core Version:    0.7.0.1
 */