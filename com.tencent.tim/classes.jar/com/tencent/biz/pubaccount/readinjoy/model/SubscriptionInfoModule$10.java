package com.tencent.biz.pubaccount.readinjoy.model;

import aalb;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import awit;
import com.tencent.imcore.message.QQMessageFacade;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import liz;
import oal;
import oan;
import ocp;

public class SubscriptionInfoModule$10
  implements Runnable
{
  public void run()
  {
    Object localObject = oan.a().c((QQAppInterface)this.this$0.mApp).iterator();
    while (((Iterator)localObject).hasNext())
    {
      oal localoal = (oal)((Iterator)localObject).next();
      if (localoal.mUin != null)
      {
        localoal.aOr = 0;
        int i = ocp.e((QQAppInterface)this.this$0.mApp, localoal.mUin);
        aalb.l((QQAppInterface)this.this$0.mApp, localoal.mUin, i);
        ((QQAppInterface)this.this$0.mApp).b().ca(localoal.mUin, 1008);
      }
    }
    localObject = awit.a(this.this$0.mApp, true, true).edit();
    ((SharedPreferences.Editor)localObject).putBoolean("subscribe_unread_clear_status", false);
    ((SharedPreferences.Editor)localObject).commit();
    liz.a(this.this$0, false);
    if (QLog.isColorLevel()) {
      QLog.d("SubscriptionInfoModule", 2, "clearSubscriptionUnreadForUpgrade end");
    }
    this.this$0.aJk();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.10
 * JD-Core Version:    0.7.0.1
 */