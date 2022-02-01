package com.tencent.mobileqq.activity.selectmember;

import aayt;
import abge;
import abge.a;
import abge.c;
import abge.e;
import acxw;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.data.CommonlyUsedTroop;
import com.tencent.mobileqq.data.DiscussionInfo;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ExpandableListView;
import com.tencent.widget.PinnedHeaderExpandableListView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;

class TroopListBaseAdapter$3$1
  implements Runnable
{
  TroopListBaseAdapter$3$1(TroopListBaseAdapter.3 param3, ArrayList paramArrayList, List paramList) {}
  
  public void run()
  {
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "load data troopListInfo.size: " + this.sw.size() + " discussions.size:" + this.vJ.size());
    }
    this.a.this$0.oW.clear();
    this.a.this$0.tJ.clear();
    this.a.this$0.tL.clear();
    this.a.this$0.tK.clear();
    this.a.this$0.tI.clear();
    this.a.this$0.tM.clear();
    this.a.this$0.vI.clear();
    Object localObject1 = this.a.e.eg();
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "getCommonlyUsedTroopList troops size= " + ((List)localObject1).size());
    }
    Object localObject3;
    if (localObject1 != null)
    {
      Collections.sort((List)localObject1, new abge.a());
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (CommonlyUsedTroop)((Iterator)localObject1).next();
        localObject3 = this.a.e.b(((CommonlyUsedTroop)localObject2).troopUin);
        if (localObject3 != null)
        {
          this.a.this$0.a((TroopInfo)localObject3, this.a.b);
          this.a.this$0.tI.add(localObject3);
        }
        else if (QLog.isColorLevel())
        {
          QLog.d("TroopListBaseAdapter", 2, "findTroopInfo troopInfo==null item.troopUin:" + ((CommonlyUsedTroop)localObject2).troopUin);
        }
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "mSetTopTroopList1 size= " + this.a.this$0.tI.size());
    }
    localObject1 = this.a.this$0.mApp.getCurrentUin();
    Object localObject2 = this.sw.iterator();
    if (((Iterator)localObject2).hasNext())
    {
      localObject3 = (TroopInfo)((Iterator)localObject2).next();
      this.a.this$0.a((TroopInfo)localObject3, this.a.b);
      i = abge.fS(this.a.this$0.mApp.cs(((TroopInfo)localObject3).troopuin));
      if (((((TroopInfo)localObject3).dwAdditionalFlag & 1L) == 1L) || ((((TroopInfo)localObject3).troopowneruin != null) && (((TroopInfo)localObject3).troopowneruin.equals(localObject1)))) {
        this.a.this$0.tJ.add(new abge.e(i, (Entity)localObject3));
      }
      for (;;)
      {
        if (!((TroopInfo)localObject3).hasSetTroopName()) {
          this.a.this$0.tM.add(new abge.e(i, (Entity)localObject3));
        }
        if (!aayt.a(this.a.this$0, ((TroopInfo)localObject3).troopuin, 1)) {
          break;
        }
        this.a.this$0.vI.add(new abge.e(i, (Entity)localObject3));
        break;
        if ((((TroopInfo)localObject3).dwCmdUinUinFlag & 1L) == 1L) {
          this.a.this$0.tK.add(new abge.e(i, (Entity)localObject3));
        } else {
          this.a.this$0.tL.add(new abge.e(i, (Entity)localObject3));
        }
      }
    }
    localObject1 = this.vJ.iterator();
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (DiscussionInfo)((Iterator)localObject1).next();
      localObject3 = this.a.b.a(((DiscussionInfo)localObject2).uin, 3000);
      ((DiscussionInfo)localObject2).lastMsgTime = ((RecentUser)localObject3).lastmsgtime;
      if (((RecentUser)localObject3).showUpTime != 0L) {
        this.a.this$0.tI.add(localObject2);
      }
      if (this.a.this$0.mApp.getCurrentUin().equals(((DiscussionInfo)localObject2).ownerUin)) {
        this.a.this$0.tJ.add(new abge.e(1, (Entity)localObject2));
      }
      for (;;)
      {
        if (!((DiscussionInfo)localObject2).hasRenamed()) {
          this.a.this$0.tM.add(new abge.e(1, (Entity)localObject2));
        }
        if (!aayt.a(this.a.this$0, ((DiscussionInfo)localObject2).uin, 3000)) {
          break;
        }
        this.a.this$0.vI.add(new abge.e(1, (Entity)localObject2));
        break;
        this.a.this$0.tL.add(new abge.e(1, (Entity)localObject2));
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("TroopListBaseAdapter", 2, "mSetTopTroopList2 size= " + this.a.this$0.tI.size());
    }
    localObject1 = new abge.c();
    Collections.sort(this.a.this$0.tJ, (Comparator)localObject1);
    Collections.sort(this.a.this$0.tK, (Comparator)localObject1);
    Collections.sort(this.a.this$0.tL, (Comparator)localObject1);
    Collections.sort(this.a.this$0.tM, (Comparator)localObject1);
    Collections.sort(this.a.this$0.vI, (Comparator)localObject1);
    if (!this.a.this$0.vI.isEmpty()) {
      this.a.this$0.oW.add(Integer.valueOf(13));
    }
    if (!this.a.this$0.tI.isEmpty()) {}
    for (int i = 1;; i = 0)
    {
      if (i != 0) {
        this.a.this$0.oW.add(Integer.valueOf(0));
      }
      if (this.a.this$0.tM.size() > 0) {
        this.a.this$0.oW.add(Integer.valueOf(8));
      }
      if (this.a.this$0.tJ.size() > 0) {
        this.a.this$0.oW.add(Integer.valueOf(4));
      }
      if (this.a.this$0.tK.size() > 0) {
        this.a.this$0.oW.add(Integer.valueOf(6));
      }
      if (this.a.this$0.tL.size() > 0) {
        this.a.this$0.oW.add(Integer.valueOf(2));
      }
      localObject1 = new HashSet(5);
      localObject2 = this.a.this$0.aJ.iterator();
      while (((Iterator)localObject2).hasNext())
      {
        localObject3 = (Integer)((Iterator)localObject2).next();
        if (this.a.this$0.oW.contains(localObject3)) {
          ((HashSet)localObject1).add(localObject3);
        }
      }
    }
    this.a.this$0.aJ = ((HashSet)localObject1);
    aayt.b(this.a.this$0);
    if (aayt.a(this.a.this$0))
    {
      if (this.a.this$0.oW.size() > 0)
      {
        this.a.this$0.aJ.add(this.a.this$0.oW.get(0));
        aayt.a(this.a.this$0).expandGroup(0);
      }
      aayt.a(this.a.this$0, false);
    }
    for (;;)
    {
      if ((aayt.e(this.a.this$0) instanceof PinnedHeaderExpandableListView))
      {
        localObject1 = (PinnedHeaderExpandableListView)aayt.f(this.a.this$0);
        if (this.a.this$0.oW.size() > 1) {
          bool = true;
        }
        ((PinnedHeaderExpandableListView)localObject1).setHeaderViewShouldShow(bool);
      }
      return;
      if (this.a.this$0.oW.size() != 1) {
        break;
      }
      aayt.b(this.a.this$0).expandGroup(0);
      this.a.this$0.aJ.add(this.a.this$0.oW.get(0));
    }
    i = 0;
    label1621:
    if (i < this.a.this$0.oW.size())
    {
      if (!this.a.this$0.aJ.contains(this.a.this$0.oW.get(i))) {
        break label1694;
      }
      aayt.c(this.a.this$0).expandGroup(i);
    }
    for (;;)
    {
      i += 1;
      break label1621;
      break;
      label1694:
      aayt.d(this.a.this$0).collapseGroup(i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.selectmember.TroopListBaseAdapter.3.1
 * JD-Core Version:    0.7.0.1
 */