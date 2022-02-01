package org.junit.internal;

import org.junit.Assert;

public class ExactComparisonCriteria
  extends ComparisonCriteria
{
  protected void assertElementsEqual(Object paramObject1, Object paramObject2)
  {
    Assert.assertEquals(paramObject1, paramObject2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.internal.ExactComparisonCriteria
 * JD-Core Version:    0.7.0.1
 */