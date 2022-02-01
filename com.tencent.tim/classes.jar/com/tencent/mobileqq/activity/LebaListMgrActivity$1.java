package com.tencent.mobileqq.activity;

import acgu;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.List;
import zjq;

class LebaListMgrActivity$1
  implements Runnable
{
  LebaListMgrActivity$1(LebaListMgrActivity paramLebaListMgrActivity) {}
  
  public void run()
  {
    zjq.a().a(this.this$0, this.this$0.app);
    boolean bool = this.this$0.app.a().aav();
    List localList = zjq.a().dp();
    this.this$0.runOnUiThread(new LebaListMgrActivity.1.1(this, bool, localList));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.LebaListMgrActivity.1
 * JD-Core Version:    0.7.0.1
 */