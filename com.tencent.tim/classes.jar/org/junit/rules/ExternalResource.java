package org.junit.rules;

import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public abstract class ExternalResource
  implements TestRule
{
  private Statement statement(Statement paramStatement)
  {
    return new ExternalResource.1(this, paramStatement);
  }
  
  protected void after() {}
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    return statement(paramStatement);
  }
  
  protected void before()
    throws Throwable
  {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.rules.ExternalResource
 * JD-Core Version:    0.7.0.1
 */