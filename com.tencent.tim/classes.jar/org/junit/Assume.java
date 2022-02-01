package org.junit;

import java.util.Arrays;
import org.hamcrest.CoreMatchers;
import org.hamcrest.Matcher;

public class Assume
{
  public static void assumeFalse(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      assumeTrue(paramString, paramBoolean);
      return;
    }
  }
  
  public static void assumeFalse(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      assumeTrue(paramBoolean);
      return;
    }
  }
  
  public static void assumeNoException(String paramString, Throwable paramThrowable)
  {
    assumeThat(paramString, paramThrowable, CoreMatchers.nullValue());
  }
  
  public static void assumeNoException(Throwable paramThrowable)
  {
    assumeThat(paramThrowable, CoreMatchers.nullValue());
  }
  
  public static void assumeNotNull(Object... paramVarArgs)
  {
    assumeThat(Arrays.asList(paramVarArgs), CoreMatchers.everyItem(CoreMatchers.notNullValue()));
  }
  
  public static <T> void assumeThat(T paramT, Matcher<T> paramMatcher)
  {
    if (!paramMatcher.matches(paramT)) {
      throw new AssumptionViolatedException(paramT, paramMatcher);
    }
  }
  
  public static <T> void assumeThat(String paramString, T paramT, Matcher<T> paramMatcher)
  {
    if (!paramMatcher.matches(paramT)) {
      throw new AssumptionViolatedException(paramString, paramT, paramMatcher);
    }
  }
  
  public static void assumeTrue(String paramString, boolean paramBoolean)
  {
    if (!paramBoolean) {
      throw new AssumptionViolatedException(paramString);
    }
  }
  
  public static void assumeTrue(boolean paramBoolean)
  {
    assumeThat(Boolean.valueOf(paramBoolean), CoreMatchers.is(Boolean.valueOf(true)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.Assume
 * JD-Core Version:    0.7.0.1
 */