package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import com.tencent.qphone.base.util.QLog;

class PermisionPrivacyActivity$12
  implements Runnable
{
  PermisionPrivacyActivity$12(PermisionPrivacyActivity paramPermisionPrivacyActivity, boolean paramBoolean) {}
  
  public void run()
  {
    acff localacff = (acff)this.this$0.app.getManager(51);
    Card localCard = localacff.b(this.this$0.app.getCurrentAccountUin());
    if (localCard != null)
    {
      if (!this.aYV) {}
      for (boolean bool = true;; bool = false)
      {
        localCard.isHidePrettyGroutIdentity = bool;
        if (localacff.a(localCard)) {
          break;
        }
        QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card flag=" + this.aYV + " failed");
        return;
      }
      QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card flag=" + this.aYV + " success");
      return;
    }
    QLog.e("vip_pretty.Q.security", 1, "onGetPrettyOwnerFlag save card failed because card is null");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PermisionPrivacyActivity.12
 * JD-Core Version:    0.7.0.1
 */