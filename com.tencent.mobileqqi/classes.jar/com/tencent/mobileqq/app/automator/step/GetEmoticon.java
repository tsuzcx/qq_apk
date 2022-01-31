package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.EmosmHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetEmoticon
  extends AsyncStep
{
  protected int a()
  {
    if (!this.a.e) {
      ((EmosmHandler)this.a.a.a(11)).a();
    }
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetEmoticon
 * JD-Core Version:    0.7.0.1
 */