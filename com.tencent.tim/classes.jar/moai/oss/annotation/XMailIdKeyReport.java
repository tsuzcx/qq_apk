package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface XMailIdKeyReport
{
  String description();
  
  boolean enable();
  
  int idKey();
  
  int subLogId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.XMailIdKeyReport
 * JD-Core Version:    0.7.0.1
 */