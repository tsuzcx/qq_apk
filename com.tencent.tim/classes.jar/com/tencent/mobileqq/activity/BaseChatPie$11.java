package com.tencent.mobileqq.activity;

import android.content.Context;
import android.content.Intent;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;

class BaseChatPie$11
  implements Runnable
{
  BaseChatPie$11(BaseChatPie paramBaseChatPie, boolean paramBoolean, Intent paramIntent1, Intent paramIntent2) {}
  
  public void run()
  {
    if (QLog.isDevelopLevel()) {
      QLog.i("forward", 1, "updateSession_forwardType, postDelayed Run! needToBottom=" + this.aTc);
    }
    this.this$0.bu(this.A);
    if (this.aTc) {
      this.this$0.bHF();
    }
    if (this.val$intent.getBooleanExtra("isFromShare", false))
    {
      this.val$intent.removeExtra("forward_type");
      this.val$intent.removeExtra("isFromShare");
      String str2 = this.val$intent.getStringExtra("leftBackText");
      String str1;
      if (str2 != null)
      {
        str1 = str2;
        if (!"".equals(str2)) {}
      }
      else
      {
        str1 = this.this$0.mContext.getString(2131691039);
      }
      if (QLog.isColorLevel()) {
        QLog.i(this.this$0.TAG, 2, "set left text from forward: " + str1);
      }
      this.this$0.Cr.setText(str1);
      this.this$0.bIL();
      if (this.this$0.a != null) {
        this.this$0.a.ejF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.11
 * JD-Core Version:    0.7.0.1
 */