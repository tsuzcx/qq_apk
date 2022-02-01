package com.tencent.mobileqq.activity;

import android.text.TextUtils;
import android.widget.TextView;
import com.tencent.mobileqq.widget.navbar.NavBarAIO;
import com.tencent.qphone.base.util.QLog;
import ujs;

class BaseChatPie$19
  implements Runnable
{
  BaseChatPie$19(BaseChatPie paramBaseChatPie, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.i(this.this$0.TAG, 2, "set left text from update unread: " + this.aLC);
    }
    if (this.this$0.aey)
    {
      this.this$0.Cs.setText(String.valueOf(this.aLD));
      if (TextUtils.isEmpty(this.aLD)) {
        this.this$0.Cs.setVisibility(8);
      }
    }
    for (;;)
    {
      this.this$0.bIL();
      if (ujs.aTl) {
        this.this$0.a.setLeftContentDescription(this.aLE);
      }
      return;
      this.this$0.Cs.setVisibility(0);
      continue;
      this.this$0.tU.setText(this.aLD);
      if (this.this$0.a != null) {
        this.this$0.a.ejF();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.BaseChatPie.19
 * JD-Core Version:    0.7.0.1
 */