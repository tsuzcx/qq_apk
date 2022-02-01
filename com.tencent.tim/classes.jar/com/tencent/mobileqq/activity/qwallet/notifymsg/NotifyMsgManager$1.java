package com.tencent.mobileqq.activity.qwallet.notifymsg;

import aabz;
import aabz.a;
import aaca;
import aaca.a;
import aagd;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import zyn;

public final class NotifyMsgManager$1
  implements Runnable
{
  public void run()
  {
    long l1;
    long l2;
    do
    {
      synchronized (aaca.ca)
      {
        if (aaca.a == null) {
          aaca.a = new aabz(BaseApplicationImpl.getContext());
        }
        ??? = aagd.getQQAppInterface();
        if (??? == null) {
          return;
        }
      }
      if (aaca.a != null) {
        aaca.a.v(((QQAppInterface)???).getCurrentUin(), aaca.rY);
      }
      if (QLog.isColorLevel()) {
        QLog.i("NotifyMsgManager", 2, "loadFromDb completed");
      }
      Object localObject3 = new ArrayList();
      Object localObject4 = new ArrayList();
      int i = 0;
      if (i < aaca.rX.size())
      {
        aabz.a locala1 = (aabz.a)aaca.rX.get(i);
        if (locala1 == null) {}
        for (;;)
        {
          i += 1;
          break;
          aabz.a locala2 = aaca.a(aaca.rY, locala1.EP, locala1.mBusinessId);
          if (locala2 != null)
          {
            ((ArrayList)localObject4).add(aaca.a(locala1, locala2));
          }
          else
          {
            aaca.rY.add(locala1);
            ((ArrayList)localObject3).add(locala1);
          }
        }
      }
      aaca.rX.clear();
      if (((ArrayList)localObject3).size() > 0) {
        aaca.y((ArrayList)localObject3, true);
      }
      if (((ArrayList)localObject4).size() > 0) {
        aaca.y((ArrayList)localObject4, false);
      }
      aaca.cgc = 2;
      aaca.hx(aaca.rW);
      localObject3 = aaca.rW.iterator();
      while (((Iterator)localObject3).hasNext())
      {
        localObject4 = (aaca.a)((Iterator)localObject3).next();
        if (localObject4 != null) {
          aaca.a((aaca.a)localObject4);
        }
      }
      aaca.rW.clear();
      l1 = zyn.getLong(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", 0L);
      l2 = NetConnInfoCenter.getServerTime();
    } while ((aaca.a == null) || ((l1 <= l2) && (l2 - l1 <= 172800L)));
    aaca.a.a(2592000L, null);
    if (aaca.a != null) {
      aaca.a.a(172800L, new int[] { 2 });
    }
    zyn.putLong(((QQAppInterface)???).getCurrentUin(), "qwallet_last_clear_notify_time_", l2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.qwallet.notifymsg.NotifyMsgManager.1
 * JD-Core Version:    0.7.0.1
 */