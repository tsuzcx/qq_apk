package org.junit.rules;

import org.junit.runners.model.Statement;

class ExternalResource$1
  extends Statement
{
  ExternalResource$1(ExternalResource paramExternalResource, Statement paramStatement)
    throws Throwable
  {}
  
  public void evaluate()
    throws Throwable
  {
    this.this$0.before();
    try
    {
      this.val$base.evaluate();
      return;
    }
    finally
    {
      this.this$0.after();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.rules.ExternalResource.1
 * JD-Core Version:    0.7.0.1
 */