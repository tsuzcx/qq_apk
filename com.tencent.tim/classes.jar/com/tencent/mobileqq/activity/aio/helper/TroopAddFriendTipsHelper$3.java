package com.tencent.mobileqq.activity.aio.helper;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import wxf;

public class TroopAddFriendTipsHelper$3
  implements Runnable
{
  public TroopAddFriendTipsHelper$3(wxf paramwxf, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    acms localacms = (acms)wxf.a(this.this$0).getBusinessHandler(20);
    if (this.bgp)
    {
      localacms.a().TH(this.Uf);
      return;
    }
    localacms.a().qN(this.Uf);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.3
 * JD-Core Version:    0.7.0.1
 */