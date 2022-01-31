package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class GetSelfInfo
  extends AsyncStep
{
  protected int a()
  {
    Object localObject = (FriendListHandler)this.a.a.a(1);
    if (this.a.a.d) {}
    localObject = (CardHandler)this.a.a.a(2);
    if (localObject != null) {
      ((CardHandler)localObject).e();
    }
    this.a.a.b(this.a.a.getAccount());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */