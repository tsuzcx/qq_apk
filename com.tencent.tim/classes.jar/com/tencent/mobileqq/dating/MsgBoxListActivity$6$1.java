package com.tencent.mobileqq.dating;

import acfp;
import afcs;
import com.tencent.mobileqq.widget.QQToast;

public class MsgBoxListActivity$6$1
  implements Runnable
{
  public MsgBoxListActivity$6$1(afcs paramafcs, int paramInt) {}
  
  public void run()
  {
    if (this.val$errorCode == 0)
    {
      QQToast.a(this.a.this$0, 2, acfp.m(2131708510), 1).show();
      return;
    }
    QQToast.a(this.a.this$0, 1, acfp.m(2131708511), 1).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.dating.MsgBoxListActivity.6.1
 * JD-Core Version:    0.7.0.1
 */