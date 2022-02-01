package com.tencent.mobileqq.activity;

import acjf;
import com.tencent.mobileqq.app.QQAppInterface;
import zju;

public class MainFragment$1
  implements Runnable
{
  MainFragment$1(MainFragment paramMainFragment) {}
  
  public void run()
  {
    if (this.this$0.a != null) {
      this.this$0.a.cpF();
    }
    if (MainFragment.a(this.this$0) != null)
    {
      ((acjf)MainFragment.a(this.this$0).getManager(257)).a(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
      MainFragment.a(this.this$0).registObserver(MainFragment.a(this.this$0));
    }
    MainFragment.a(this.this$0, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.MainFragment.1
 * JD-Core Version:    0.7.0.1
 */