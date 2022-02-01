package org.junit.rules;

import org.junit.runners.model.Statement;

class Verifier$1
  extends Statement
{
  Verifier$1(Verifier paramVerifier, Statement paramStatement)
    throws Throwable
  {}
  
  public void evaluate()
    throws Throwable
  {
    this.val$base.evaluate();
    this.this$0.verify();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.rules.Verifier.1
 * JD-Core Version:    0.7.0.1
 */