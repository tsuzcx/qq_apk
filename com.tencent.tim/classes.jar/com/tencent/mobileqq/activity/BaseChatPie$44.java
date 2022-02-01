package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.res.Resources;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.widget.XEditTextEx;

class BaseChatPie$44
  implements Runnable
{
  BaseChatPie$44(BaseChatPie paramBaseChatPie, boolean paramBoolean) {}
  
  public void run()
  {
    this.this$0.setRequestedOrientation4Recording(true);
    this.this$0.bIK();
    this.this$0.zY(0);
    this.this$0.a.setEnabled(true);
    if (this.Jx)
    {
      this.this$0.afq();
      return;
    }
    QQToast.a(this.this$0.app.getApp(), 2131690276, 1).show(this.this$0.mContext.getResources().getDimensionPixelSize(2131299627));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.44
 * JD-Core Version:    0.7.0.1
 */