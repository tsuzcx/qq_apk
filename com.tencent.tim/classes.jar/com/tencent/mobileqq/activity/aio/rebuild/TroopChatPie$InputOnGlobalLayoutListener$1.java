package com.tencent.mobileqq.activity.aio.rebuild;

import acms;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.troop.utils.TroopBatchAddFriendMgr;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

class TroopChatPie$InputOnGlobalLayoutListener$1
  implements Runnable
{
  TroopChatPie$InputOnGlobalLayoutListener$1(TroopChatPie.a parama) {}
  
  public void run()
  {
    String str1 = this.a.this$0.sessionInfo.aTl;
    TroopBatchAddFriendMgr localTroopBatchAddFriendMgr = ((acms)this.a.this$0.app.getBusinessHandler(20)).a();
    Object localObject = localTroopBatchAddFriendMgr.ad(str1);
    ArrayList localArrayList = new ArrayList();
    if ((localObject != null) && (((ArrayList)localObject).size() > 0))
    {
      localObject = ((ArrayList)localObject).iterator();
      while (((Iterator)localObject).hasNext())
      {
        String str2 = (String)((Iterator)localObject).next();
        if (this.a.this$0.hV(str2)) {
          localArrayList.add(str2);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d(this.a.this$0.TAG, 2, "CheckNewMemberDataWhenEnterAIO visibleUins size = " + localArrayList.size() + ",visibleUins = " + localArrayList);
    }
    if (localArrayList.size() > 0) {
      localTroopBatchAddFriendMgr.b(str1, localArrayList, 4);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.rebuild.TroopChatPie.InputOnGlobalLayoutListener.1
 * JD-Core Version:    0.7.0.1
 */