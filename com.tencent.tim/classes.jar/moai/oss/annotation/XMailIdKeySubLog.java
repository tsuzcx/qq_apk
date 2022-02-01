package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Target;

@Target({java.lang.annotation.ElementType.FIELD})
public @interface XMailIdKeySubLog
{
  int id();
  
  int multiFactor() default 1;
  
  int operationKey1() default 0;
  
  int operationKey2() default 0;
  
  int operationType() default 0;
  
  String title();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.XMailIdKeySubLog
 * JD-Core Version:    0.7.0.1
 */