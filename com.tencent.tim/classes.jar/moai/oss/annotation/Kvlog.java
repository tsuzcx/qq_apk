package moai.oss.annotation;

import java.lang.annotation.Annotation;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import moai.oss.ReportType;

@Retention(RetentionPolicy.SOURCE)
@Target({java.lang.annotation.ElementType.FIELD, java.lang.annotation.ElementType.TYPE})
public @interface Kvlog
{
  String alias() default "";
  
  boolean apply() default false;
  
  boolean enable() default true;
  
  boolean itemNameFixed() default true;
  
  boolean merge() default true;
  
  int statKey();
  
  boolean table() default false;
  
  String title() default "";
  
  ReportType type() default ReportType.NORMAL;
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.oss.annotation.Kvlog
 * JD-Core Version:    0.7.0.1
 */