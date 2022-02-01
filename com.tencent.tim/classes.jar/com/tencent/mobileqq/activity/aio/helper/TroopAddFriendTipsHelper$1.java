package com.tencent.mobileqq.activity.aio.helper;

import acms;
import apuh;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import wxf;

public class TroopAddFriendTipsHelper$1
  implements Runnable
{
  public TroopAddFriendTipsHelper$1(wxf paramwxf, String paramString) {}
  
  public void run()
  {
    acms localacms = (acms)wxf.a(this.this$0).getBusinessHandler(20);
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = localacms.a();
    localTroopBatchAddFriendMgr.TG(this.Uf);
    localTroopBatchAddFriendMgr.b(this.Uf, null, 1);
    localTroopBatchAddFriendMgr.TJ(this.Uf);
    long l1 = apuh.e(wxf.a(this.this$0), this.Uf);
    if (l1 <= 0L) {
      apuh.l(wxf.a(this.this$0), this.Uf, 5L);
    }
    long l2;
    do
    {
      return;
      l2 = NetConnInfoCenter.getServerTime() - l1;
      if (l2 > 0L) {
        localacms.af(this.Uf, 1, 0);
      }
    } while (!QLog.isColorLevel());
    QLog.i("TroopAddFriendTipsHelper", 2, "check recommend gray time " + l2 + " " + l1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.1
 * JD-Core Version:    0.7.0.1
 */