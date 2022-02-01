package com.tencent.mobileqq.app.automator;

public class LinearGroup
  extends StepGroup
{
  protected int od()
  {
    while (this.mResult != 8)
    {
      AsyncStep localAsyncStep = a();
      if (localAsyncStep == null) {
        break;
      }
      localAsyncStep.run();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.LinearGroup
 * JD-Core Version:    0.7.0.1
 */