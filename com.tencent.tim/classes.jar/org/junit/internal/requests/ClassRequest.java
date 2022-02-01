package org.junit.internal.requests;

import org.junit.internal.builders.AllDefaultPossibilitiesBuilder;
import org.junit.runner.Request;
import org.junit.runner.Runner;

public class ClassRequest
  extends Request
{
  private final boolean canUseSuiteMethod;
  private final Class<?> fTestClass;
  private volatile Runner runner;
  private final Object runnerLock = new Object();
  
  public ClassRequest(Class<?> paramClass)
  {
    this(paramClass, true);
  }
  
  public ClassRequest(Class<?> paramClass, boolean paramBoolean)
  {
    this.fTestClass = paramClass;
    this.canUseSuiteMethod = paramBoolean;
  }
  
  public Runner getRunner()
  {
    if (this.runner == null) {}
    synchronized (this.runnerLock)
    {
      if (this.runner == null) {
        this.runner = new AllDefaultPossibilitiesBuilder(this.canUseSuiteMethod).safeRunnerForClass(this.fTestClass);
      }
      return this.runner;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.requests.ClassRequest
 * JD-Core Version:    0.7.0.1
 */