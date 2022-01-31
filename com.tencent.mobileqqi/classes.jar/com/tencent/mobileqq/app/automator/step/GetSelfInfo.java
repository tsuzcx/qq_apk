package com.tencent.mobileqq.app.automator.step;

import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;
import com.tencent.mobileqq.subaccount.SubAccountAssistantImpl;

public class GetSelfInfo
  extends AsyncStep
{
  protected int a()
  {
    FriendListHandler localFriendListHandler = (FriendListHandler)this.a.a.a(1);
    if (this.a.a.d)
    {
      String str = SubAccountAssistantImpl.a().a(this.a.a);
      if ((str != null) && (str.length() > 0))
      {
        this.a.a.d = false;
        localFriendListHandler.a(str);
      }
    }
    this.a.a.b(this.a.a.getAccount());
    return 7;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.GetSelfInfo
 * JD-Core Version:    0.7.0.1
 */