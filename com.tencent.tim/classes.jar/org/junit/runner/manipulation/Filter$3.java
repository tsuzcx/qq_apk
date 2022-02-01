package org.junit.runner.manipulation;

import org.junit.runner.Description;

class Filter$3
  extends Filter
{
  Filter$3(Filter paramFilter1, Filter paramFilter2, Filter paramFilter3) {}
  
  public String describe()
  {
    return this.val$first.describe() + " and " + this.val$second.describe();
  }
  
  public boolean shouldRun(Description paramDescription)
  {
    return (this.val$first.shouldRun(paramDescription)) && (this.val$second.shouldRun(paramDescription));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.junit.runner.manipulation.Filter.3
 * JD-Core Version:    0.7.0.1
 */