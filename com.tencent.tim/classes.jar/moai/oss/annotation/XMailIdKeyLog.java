package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface XMailIdKeyLog
{
  String alias() default "";
  
  boolean apply() default false;
  
  boolean enable() default true;
  
  int idKey();
  
  int subLogId() default 0;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.XMailIdKeyLog
 * JD-Core Version:    0.7.0.1
 */