package org.junit.experimental.results;

import org.hamcrest.BaseMatcher;
import org.hamcrest.Description;
import org.hamcrest.Matcher;

class ResultMatchers$2
  extends BaseMatcher<Object>
{
  ResultMatchers$2(String paramString) {}
  
  public void describeTo(Description paramDescription)
  {
    paramDescription.appendText("has single failure containing " + this.val$string);
  }
  
  public boolean matches(Object paramObject)
  {
    return (paramObject.toString().contains(this.val$string)) && (ResultMatchers.failureCountIs(1).matches(paramObject));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.experimental.results.ResultMatchers.2
 * JD-Core Version:    0.7.0.1
 */