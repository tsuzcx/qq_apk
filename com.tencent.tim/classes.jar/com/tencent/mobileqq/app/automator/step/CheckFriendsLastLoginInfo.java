package com.tencent.mobileqq.app.automator.step;

import acfd;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.automator.AsyncStep;
import com.tencent.mobileqq.app.automator.Automator;

public class CheckFriendsLastLoginInfo
  extends AsyncStep
{
  private acfd l;
  
  public int od()
  {
    if (((FriendListHandler)this.a.app.getBusinessHandler(1)).aab())
    {
      if (this.l == null)
      {
        this.l = new a(null);
        this.a.app.addObserver(this.l);
      }
      return 2;
    }
    return 7;
  }
  
  public void onDestroy()
  {
    if (this.l != null)
    {
      this.a.app.removeObserver(this.l);
      this.l = null;
    }
  }
  
  class a
    extends acfd
  {
    private a() {}
    
    public void onUpdateLastLoginInfo(boolean paramBoolean1, boolean paramBoolean2)
    {
      int i = 0;
      if (!paramBoolean1) {
        CheckFriendsLastLoginInfo.this.setResult(6);
      }
      for (;;)
      {
        if (i != 0) {
          CheckFriendsLastLoginInfo.this.setResult(7);
        }
        return;
        if (paramBoolean2) {
          i = 1;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.automator.step.CheckFriendsLastLoginInfo
 * JD-Core Version:    0.7.0.1
 */