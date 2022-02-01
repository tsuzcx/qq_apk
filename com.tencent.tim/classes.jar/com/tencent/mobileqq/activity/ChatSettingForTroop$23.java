package com.tencent.mobileqq.activity;

import android.os.Handler;
import aqft;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.troopinfo.TroopInfoData;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ChatSettingForTroop$23
  implements Runnable
{
  ChatSettingForTroop$23(ChatSettingForTroop paramChatSettingForTroop) {}
  
  public void run()
  {
    Object localObject1 = null;
    if ((this.this$0.a == null) || (this.this$0.mUIHandler == null)) {}
    do
    {
      return;
      localObject2 = this.this$0.app.a().createEntityManager();
      if (localObject2 != null)
      {
        localObject1 = ((EntityManager)localObject2).query(TroopMemberInfo.class, false, "troopuin=? ", new String[] { this.this$0.a.troopUin }, null, null, null, null);
        ((EntityManager)localObject2).close();
      }
    } while (localObject1 == null);
    Object localObject2 = new ArrayList(((List)localObject1).size());
    localObject1 = ((List)localObject1).iterator();
    while (((Iterator)localObject1).hasNext())
    {
      TroopMemberInfo localTroopMemberInfo = (TroopMemberInfo)((Iterator)localObject1).next();
      if (aqft.rl(localTroopMemberInfo.memberuin)) {
        ((ArrayList)localObject2).add(localTroopMemberInfo.memberuin);
      }
    }
    this.this$0.mUIHandler.post(new ChatSettingForTroop.23.1(this, (ArrayList)localObject2));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatSettingForTroop.23
 * JD-Core Version:    0.7.0.1
 */