package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({java.lang.annotation.ElementType.METHOD})
public @interface OssReport
{
  String checkSum();
  
  boolean enable();
  
  boolean fixed();
  
  int logId();
  
  String taskId();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.OssReport
 * JD-Core Version:    0.7.0.1
 */