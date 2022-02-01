package com.tencent.mobileqq.activity.recent;

import aakp;
import aalb;
import acja;
import aqiy;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.AccountDetail;
import com.tencent.qphone.base.util.QLog;
import kaw;

public class RecentPubAccHelper$4
  implements Runnable
{
  public RecentPubAccHelper$4(aakp paramaakp, QQAppInterface paramQQAppInterface, RecentBaseData paramRecentBaseData) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("RecentPubAccHelper", 2, "updateUnfollowInfo");
    }
    kaw.a().e(this.val$appInterface, this.d.qx());
    Object localObject = (acja)this.val$appInterface.getManager(56);
    if (localObject != null)
    {
      ((acja)localObject).EA(this.d.qx());
      ((acja)localObject).Ez(this.d.qx());
      localObject = ((acja)localObject).a(this.d.qx());
      if (localObject != null) {
        aakp.a(this.this$0, (AccountDetail)localObject, this.val$appInterface);
      }
    }
    this.val$appInterface.b().N(this.d.qx(), 1008);
    aalb.l(this.val$appInterface, this.d.qx(), 1008);
    aqiy.bk(" pubAcc_follow_cancel", null, this.d.qx());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.recent.RecentPubAccHelper.4
 * JD-Core Version:    0.7.0.1
 */