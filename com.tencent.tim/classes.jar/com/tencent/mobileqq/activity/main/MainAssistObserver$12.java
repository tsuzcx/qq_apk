package com.tencent.mobileqq.activity.main;

import aciu;
import akjp;
import altq;
import android.os.Handler;
import android.os.Message;
import aqap;
import aqep;
import com.tencent.mobileqq.app.CardHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.nearby.redtouch.RedTouchItem;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.pb.getbusiinfo.BusinessInfoCheckUpdate.RedTypeInfo;
import com.tencent.qphone.base.util.QLog;
import zju;

public class MainAssistObserver$12
  implements Runnable
{
  public MainAssistObserver$12(zju paramzju, QQAppInterface paramQQAppInterface) {}
  
  public void run()
  {
    int j = 2;
    for (;;)
    {
      Object localObject2;
      try
      {
        altq localaltq = (altq)this.l.getManager(36);
        BusinessInfoCheckUpdate.RedTypeInfo localRedTypeInfo = localaltq.c(1);
        if (localRedTypeInfo != null) {
          break label398;
        }
        akjp localakjp = (akjp)this.l.getManager(160);
        localakjp.n(100601, false);
        boolean bool1 = localakjp.n(10015, false);
        boolean bool2 = localakjp.n(10016, false);
        aqep.ev(this.l);
        localObject2 = localakjp.a(-3);
        if (!localakjp.a((RedTouchItem)localObject2, true)) {
          break label398;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        if ((bool1 | bool2)) {
          zju.a(this.this$0, this.l);
        }
        QLog.d("MainAssistObserver", 1, "updateTabSettingNotify me count=" + ((RedTouchItem)localObject2).count);
        i = 1;
        if ((localRedTypeInfo != null) || (!aqap.bW(this.l))) {
          break label395;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        i = j;
        localObject2 = (CardHandler)this.l.getBusinessHandler(2);
        if ((localRedTypeInfo != null) || (((CardHandler)localObject2).ZI()) || (!((CardHandler)localObject2).ZH())) {
          break label390;
        }
        localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
        j = 3;
        i = j;
        localObject2 = localRedTypeInfo;
        if (localRedTypeInfo == null)
        {
          i = j;
          localObject2 = localRedTypeInfo;
          if (aciu.ix(1))
          {
            localObject2 = new BusinessInfoCheckUpdate.RedTypeInfo();
            i = 4;
          }
        }
        j = localaltq.iL(1);
        if (localObject2 != null) {
          ((BusinessInfoCheckUpdate.RedTypeInfo)localObject2).red_type.set(0);
        }
        if (j > 0)
        {
          localRedTypeInfo = new BusinessInfoCheckUpdate.RedTypeInfo();
          localRedTypeInfo.red_type.set(0);
          i = 5;
          if (QLog.isColorLevel()) {
            QLog.d("MainAssistObserver", 2, "updateTabSettingNotify: showRedFromWhere=" + i);
          }
          localObject2 = this.this$0.ce.obtainMessage(0);
          ((Message)localObject2).obj = localRedTypeInfo;
          this.this$0.ce.sendMessage((Message)localObject2);
          return;
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        return;
      }
      Object localObject1 = localObject2;
      continue;
      label390:
      j = i;
      continue;
      label395:
      continue;
      label398:
      int i = 0;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.main.MainAssistObserver.12
 * JD-Core Version:    0.7.0.1
 */