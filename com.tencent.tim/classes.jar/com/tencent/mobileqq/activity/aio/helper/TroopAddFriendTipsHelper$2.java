package com.tencent.mobileqq.activity.aio.helper;

import acms;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import java.util.ArrayList;
import wxf;

public class TroopAddFriendTipsHelper$2
  implements Runnable
{
  public TroopAddFriendTipsHelper$2(wxf paramwxf, String paramString1, String paramString2) {}
  
  public void run()
  {
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)wxf.a(this.this$0).getBusinessHandler(20)).a();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(this.aUl);
    localTroopBatchAddFriendMgr.b(this.Uf, localArrayList, 4);
    localTroopBatchAddFriendMgr.id(this.Uf, this.aUl);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.TroopAddFriendTipsHelper.2
 * JD-Core Version:    0.7.0.1
 */