package com.tencent.mobileqq.activity;

import acff;
import android.text.TextUtils;
import com.tencent.mobileqq.app.FriendListHandler;
import com.tencent.mobileqq.app.QQAppInterface;

class AutoRemarkActivity$3
  implements Runnable
{
  AutoRemarkActivity$3(AutoRemarkActivity paramAutoRemarkActivity) {}
  
  public void run()
  {
    if (TextUtils.isEmpty(this.this$0.aLx)) {}
    while (((acff)this.this$0.app.getManager(51)).b(this.this$0.aLx) != null) {
      return;
    }
    ((FriendListHandler)this.this$0.app.getBusinessHandler(1)).DG(this.this$0.aLx);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AutoRemarkActivity.3
 * JD-Core Version:    0.7.0.1
 */