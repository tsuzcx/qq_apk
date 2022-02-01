package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import moai.oss.ReportType;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface XMailOsslog
{
  String alias() default "";
  
  String[] columns() default {};
  
  boolean enable() default true;
  
  boolean lateDefineItemName() default false;
  
  int logId();
  
  ReportType type() default ReportType.NORMAL;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.XMailOsslog
 * JD-Core Version:    0.7.0.1
 */