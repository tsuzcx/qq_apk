package org.junit;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface Test
{
  Class<? extends Throwable> expected() default None.class;
  
  long timeout() default 0L;
  
  public static class None
    extends Throwable
  {
    private static final long serialVersionUID = 1L;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.Test
 * JD-Core Version:    0.7.0.1
 */