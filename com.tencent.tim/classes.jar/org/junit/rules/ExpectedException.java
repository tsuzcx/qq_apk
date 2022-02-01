package org.junit.rules;

import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;
import org.hamcrest.StringDescription;
import org.junit.Assert;
import org.junit.internal.matchers.ThrowableCauseMatcher;
import org.junit.internal.matchers.ThrowableMessageMatcher;
import org.junit.runner.Description;
import org.junit.runners.model.Statement;

public class ExpectedException
  implements TestRule
{
  private final ExpectedExceptionMatcherBuilder matcherBuilder = new ExpectedExceptionMatcherBuilder();
  private String missingExceptionMessage = "Expected test to throw %s";
  
  private void failDueToMissingException()
    throws AssertionError
  {
    Assert.fail(missingExceptionMessage());
  }
  
  private void handleException(Throwable paramThrowable)
    throws Throwable
  {
    if (isAnyExceptionExpected())
    {
      Assert.assertThat(paramThrowable, this.matcherBuilder.build());
      return;
    }
    throw paramThrowable;
  }
  
  private boolean isAnyExceptionExpected()
  {
    return this.matcherBuilder.expectsThrowable();
  }
  
  private String missingExceptionMessage()
  {
    String str = StringDescription.toString(this.matcherBuilder.build());
    return String.format(this.missingExceptionMessage, new Object[] { str });
  }
  
  public static ExpectedException none()
  {
    return new ExpectedException();
  }
  
  public Statement apply(Statement paramStatement, Description paramDescription)
  {
    return new ExpectedExceptionStatement(paramStatement);
  }
  
  public void expect(Class<? extends Throwable> paramClass)
  {
    expect(CoreMatchers.instanceOf(paramClass));
  }
  
  public void expect(Matcher<?> paramMatcher)
  {
    this.matcherBuilder.add(paramMatcher);
  }
  
  public void expectCause(Matcher<? extends Throwable> paramMatcher)
  {
    expect(ThrowableCauseMatcher.hasCause(paramMatcher));
  }
  
  public void expectMessage(String paramString)
  {
    expectMessage(CoreMatchers.containsString(paramString));
  }
  
  public void expectMessage(Matcher<String> paramMatcher)
  {
    expect(ThrowableMessageMatcher.hasMessage(paramMatcher));
  }
  
  @Deprecated
  public ExpectedException handleAssertionErrors()
  {
    return this;
  }
  
  @Deprecated
  public ExpectedException handleAssumptionViolatedExceptions()
  {
    return this;
  }
  
  public ExpectedException reportMissingExceptionWithMessage(String paramString)
  {
    this.missingExceptionMessage = paramString;
    return this;
  }
  
  class ExpectedExceptionStatement
    extends Statement
  {
    private final Statement next;
    
    public ExpectedExceptionStatement(Statement paramStatement)
    {
      this.next = paramStatement;
    }
    
    public void evaluate()
      throws Throwable
    {
      try
      {
        this.next.evaluate();
        if (ExpectedException.this.isAnyExceptionExpected()) {
          ExpectedException.this.failDueToMissingException();
        }
        return;
      }
      catch (Throwable localThrowable)
      {
        ExpectedException.this.handleException(localThrowable);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.rules.ExpectedException
 * JD-Core Version:    0.7.0.1
 */