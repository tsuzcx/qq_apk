package com.tencent.mobileqq.activity.selectmember;

import android.os.Handler;
import android.os.Message;
import aqft;
import aqgv;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

class TroopMemberListInnerFrame$5
  implements Runnable
{
  TroopMemberListInnerFrame$5(TroopMemberListInnerFrame paramTroopMemberListInnerFrame, List paramList, int paramInt1, int paramInt2, String paramString1, String paramString2, TroopInfo paramTroopInfo, Map paramMap, AtomicInteger paramAtomicInteger) {}
  
  public void run()
  {
    Iterator localIterator = this.vE.subList(this.bLT, this.bLU).iterator();
    int i = 0;
    TroopMemberInfo localTroopMemberInfo;
    if (localIterator.hasNext())
    {
      localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
      if (!this.beH.equals(this.this$0.mTroopUin)) {
        if (QLog.isColorLevel()) {
          QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread, curTroopUin != mTroopUin, return, " + this.beH + "," + this.this$0.mTroopUin);
        }
      }
    }
    label321:
    do
    {
      for (;;)
      {
        return;
        if (((!this.this$0.a.bAV) || (this.this$0.a.bBa)) && (this.val$selfUin.equalsIgnoreCase(localTroopMemberInfo.memberuin)))
        {
          this.this$0.d = localTroopMemberInfo;
          break;
        }
        if ((this.this$0.a.sr.contains(localTroopMemberInfo.memberuin)) || (!aqft.rl(localTroopMemberInfo.memberuin))) {
          break;
        }
        if ((this.h != null) && (this.this$0.CP == 2) && (!this.h.isTroopAdmin(localTroopMemberInfo.memberuin)) && (!this.h.isTroopOwner(localTroopMemberInfo.memberuin)))
        {
          this.this$0.a.sr.add(localTroopMemberInfo.memberuin);
          break;
        }
        localTroopMemberInfo.displayedNamePinyinFirst = ChnToSpell.aJ(aqgv.h(this.this$0.e, localTroopMemberInfo.troopuin, localTroopMemberInfo.memberuin), 2);
        String str;
        if ((localTroopMemberInfo.displayedNamePinyinFirst == null) || (localTroopMemberInfo.displayedNamePinyinFirst.length() == 0))
        {
          str = "#";
          int j = str.charAt(0);
          if (((65 > j) || (j > 90)) && ((97 > j) || (j > 122))) {
            break label441;
          }
          str = str.toUpperCase();
        }
        synchronized (this.iM)
        {
          if (this.iM.get(str) == null) {
            this.iM.put(str, new ArrayList());
          }
          ((List)this.iM.get(str)).add(localTroopMemberInfo);
          i += 1;
          break;
          str = localTroopMemberInfo.displayedNamePinyinFirst.substring(0, 1);
          break label321;
          str = "#";
        }
      }
      if (QLog.isColorLevel()) {
        QLog.d("TroopMemberListInnerFrame.thread", 2, "subThread end, id=" + Thread.currentThread().getId() + ", threadCnt=" + this.aQ.get() + ", curTroopUin=" + this.beH);
      }
    } while (this.aQ.getAndDecrement() > 1);
    label441:
    Message localMessage = this.this$0.mHandler.obtainMessage(3);
    localMessage.arg1 = i;
    localMessage.obj = new Object[] { this.iM, this.beH };
    this.this$0.mHandler.sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopMemberListInnerFrame.5
 * JD-Core Version:    0.7.0.1
 */