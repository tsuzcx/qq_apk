package com.tencent.mobileqq.troop.logic;

import acms;
import acxw;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.selectmember.ResultRecord;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.data.TroopMemberInfo;
import com.tencent.mobileqq.utils.ChnToSpell;
import com.tencent.mobileqq.utils.ChnToSpell.b;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class TroopSearchLogic
{
  TroopManager a = (TroopManager)this.app.getManager(52);
  QQAppInterface app = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
  
  public void a(ArrayList<ResultRecord> paramArrayList, b paramb)
  {
    ThreadManager.postImmediately(new TroopSearchTask(paramb, paramArrayList), null, false);
  }
  
  class TroopSearchTask
    implements Runnable
  {
    ArrayList<ResultRecord> Ce;
    TroopSearchLogic.b a;
    
    TroopSearchTask(ArrayList<ResultRecord> paramArrayList)
    {
      this.a = paramArrayList;
      Object localObject;
      this.Ce = localObject;
    }
    
    private void fc(ArrayList<TroopSearchLogic.a> paramArrayList)
    {
      if (this.a != null) {
        this.a.onResult(paramArrayList);
      }
    }
    
    public boolean bs(int paramInt1, int paramInt2)
    {
      if (paramInt2 <= 5)
      {
        if (paramInt1 <= 20) {}
      }
      else {
        do
        {
          return false;
          if ((paramInt2 <= 6) || (paramInt2 >= 20) || (paramInt1 <= 50)) {
            break;
          }
        } while (paramInt1 > 50);
      }
      while ((paramInt2 < 20) || (paramInt1 <= 100)) {
        return true;
      }
      return false;
    }
    
    public void run()
    {
      Object localObject1 = (acms)TroopSearchLogic.this.app.getBusinessHandler(20);
      localObject1 = new ArrayList();
      Object localObject2 = new ArrayList(TroopSearchLogic.this.a.cE());
      if ((localObject2 == null) || (((List)localObject2).size() == 0))
      {
        fc((ArrayList)localObject1);
        return;
      }
      int i = ((List)localObject2).size() - 1;
      TroopInfo localTroopInfo;
      while (i >= 0)
      {
        localTroopInfo = (TroopInfo)((List)localObject2).get(i);
        if (!bs(localTroopInfo.wMemberNum, this.Ce.size())) {
          ((List)localObject2).remove(localTroopInfo);
        }
        i -= 1;
      }
      int k = this.Ce.size();
      localObject2 = ((List)localObject2).iterator();
      List localList;
      Object localObject3;
      for (;;)
      {
        if (((Iterator)localObject2).hasNext())
        {
          localTroopInfo = (TroopInfo)((Iterator)localObject2).next();
          localList = TroopSearchLogic.this.a.al(localTroopInfo.troopuin);
          if ((localList != null) && (localList.size() > 0) && (bs(localList.size(), this.Ce.size())) && (this.Ce.size() == localList.size()))
          {
            localObject3 = this.Ce.iterator();
            i = 1;
            label253:
            if (((Iterator)localObject3).hasNext())
            {
              ResultRecord localResultRecord = (ResultRecord)((Iterator)localObject3).next();
              Iterator localIterator = localList.iterator();
              TroopMemberInfo localTroopMemberInfo;
              do
              {
                if (!localIterator.hasNext()) {
                  break;
                }
                localTroopMemberInfo = (TroopMemberInfo)localIterator.next();
              } while (!TextUtils.equals(localResultRecord.uin, localTroopMemberInfo.memberuin));
            }
          }
        }
      }
      for (int j = 1;; j = 0)
      {
        if (j == 0) {
          i = 0;
        }
        for (;;)
        {
          break label253;
          if (i == 0) {
            break label451;
          }
          localObject3 = new TroopSearchLogic.a();
          ((TroopSearchLogic.a)localObject3).troopInfo = localTroopInfo;
          ((TroopSearchLogic.a)localObject3).memberCount = localList.size();
          ((TroopSearchLogic.a)localObject3).cqc = ChnToSpell.a(localTroopInfo.getTroopName(), 1).csX;
          localTroopInfo.lastMsgTime = TroopSearchLogic.this.app.a().a().a(localTroopInfo.troopuin, 1).lastmsgtime;
          if (k != ((TroopSearchLogic.a)localObject3).memberCount) {
            break;
          }
          ((TroopSearchLogic.a)localObject3).matchType = 1;
          ((ArrayList)localObject1).add(localObject3);
          break;
          Collections.sort((List)localObject1);
          fc((ArrayList)localObject1);
          return;
        }
        label451:
        break;
      }
    }
  }
  
  public static class a
    implements Comparable<a>
  {
    String cqc;
    int matchType;
    int memberCount;
    public TroopInfo troopInfo;
    
    public int a(@NonNull a parama)
    {
      if (this.matchType != parama.matchType) {
        return this.matchType - parama.matchType;
      }
      if (this.troopInfo.lastMsgTime != parama.troopInfo.lastMsgTime) {
        return (int)(parama.troopInfo.lastMsgTime - this.troopInfo.lastMsgTime);
      }
      if (parama.troopInfo.troopCreateTime != this.troopInfo.troopCreateTime) {
        return (int)(parama.troopInfo.troopCreateTime - this.troopInfo.troopCreateTime);
      }
      if (this.memberCount != parama.memberCount) {
        return this.memberCount - parama.memberCount;
      }
      return this.cqc.compareTo(parama.cqc);
    }
  }
  
  public static abstract interface b
  {
    public abstract void onResult(ArrayList<TroopSearchLogic.a> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.logic.TroopSearchLogic
 * JD-Core Version:    0.7.0.1
 */