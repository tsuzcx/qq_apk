package org.junit.runner.notification;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.junit.runner.Description;
import org.junit.runner.Result;

public class RunListener
{
  public void testAssumptionFailure(Failure paramFailure) {}
  
  public void testFailure(Failure paramFailure)
    throws Exception
  {}
  
  public void testFinished(Description paramDescription)
    throws Exception
  {}
  
  public void testIgnored(Description paramDescription)
    throws Exception
  {}
  
  public void testRunFinished(Result paramResult)
    throws Exception
  {}
  
  public void testRunStarted(Description paramDescription)
    throws Exception
  {}
  
  public void testStarted(Description paramDescription)
    throws Exception
  {}
  
  @Documented
  @Retention(RetentionPolicy.RUNTIME)
  @Target({java.lang.annotation.ElementType.TYPE})
  public static @interface ThreadSafe {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.notification.RunListener
 * JD-Core Version:    0.7.0.1
 */