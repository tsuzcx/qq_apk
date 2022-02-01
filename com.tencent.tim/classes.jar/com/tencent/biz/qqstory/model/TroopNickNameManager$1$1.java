package com.tencent.biz.qqstory.model;

import com.tencent.mobileqq.data.TroopMemberCardInfo;
import com.tencent.qphone.base.util.QLog;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.Dispatcher.Dispatchable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import pmi;
import ptc;
import ptc.a;
import ptd;

public class TroopNickNameManager$1$1
  implements Runnable
{
  public TroopNickNameManager$1$1(ptd paramptd, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str1 = ((TroopMemberCardInfo)this.val$list.get(0)).troopuin;
    ArrayList localArrayList = new ArrayList(this.val$list.size());
    Object localObject = this.val$list.iterator();
    if (((Iterator)localObject).hasNext())
    {
      localTroopMemberCardInfo = (TroopMemberCardInfo)((Iterator)localObject).next();
      str2 = ptc.ae(str1, localTroopMemberCardInfo.memberuin);
      if ((this.a.this$0.fK.remove(str2) == null) && (QLog.isColorLevel())) {
        QLog.d("TroopNickNameManager", 2, "loading not match, return");
      }
    }
    while (localArrayList.size() <= 0)
    {
      TroopMemberCardInfo localTroopMemberCardInfo;
      String str2;
      return;
      localArrayList.add(localTroopMemberCardInfo.memberuin);
      break;
    }
    localObject = new ptc.a();
    ((ptc.a)localObject).uinList = localArrayList;
    ((ptc.a)localObject).troopUin = str1;
    pmi.a().dispatch((Dispatcher.Dispatchable)localObject);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.qqstory.model.TroopNickNameManager.1.1
 * JD-Core Version:    0.7.0.1
 */