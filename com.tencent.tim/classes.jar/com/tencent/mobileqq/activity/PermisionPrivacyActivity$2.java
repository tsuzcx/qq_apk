package com.tencent.mobileqq.activity;

import aqqb;
import com.tencent.mobileqq.widget.FormSimpleItem;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$2
  implements Runnable
{
  PermisionPrivacyActivity$2(PermisionPrivacyActivity paramPermisionPrivacyActivity, FormSimpleItem paramFormSimpleItem) {}
  
  public void run()
  {
    this.X.setRightText(aqqb.a().Ct());
    if (QLog.isDevelopLevel()) {
      QLog.d("CustomOnlineStatusManager", 4, "permision activity -> updateCustomOnlineStatus text");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.2
 * JD-Core Version:    0.7.0.1
 */