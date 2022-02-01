package org.junit.internal.builders;

import junit.framework.TestCase;
import org.junit.internal.runners.JUnit38ClassRunner;
import org.junit.runner.Runner;
import org.junit.runners.model.RunnerBuilder;

public class JUnit3Builder
  extends RunnerBuilder
{
  boolean isPre4Test(Class<?> paramClass)
  {
    return TestCase.class.isAssignableFrom(paramClass);
  }
  
  public Runner runnerForClass(Class<?> paramClass)
    throws Throwable
  {
    if (isPre4Test(paramClass)) {
      return new JUnit38ClassRunner(paramClass);
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.builders.JUnit3Builder
 * JD-Core Version:    0.7.0.1
 */