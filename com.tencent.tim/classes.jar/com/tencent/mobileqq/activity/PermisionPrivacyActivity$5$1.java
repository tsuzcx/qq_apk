package com.tencent.mobileqq.activity;

import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$5$1
  implements Runnable
{
  PermisionPrivacyActivity$5$1(PermisionPrivacyActivity.5 param5, int paramInt) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {
      return;
    }
    if (QLog.isColorLevel()) {
      QLog.i("Q.security", 2, "updateIntimateRelationshipFriendCount number:" + this.aJh);
    }
    if (this.aJh > 0)
    {
      this.a.this$0.W.setRightText(this.a.this$0.getString(2131701624, new Object[] { Integer.valueOf(this.aJh) }));
      return;
    }
    this.a.this$0.W.setRightText("");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.5.1
 * JD-Core Version:    0.7.0.1
 */