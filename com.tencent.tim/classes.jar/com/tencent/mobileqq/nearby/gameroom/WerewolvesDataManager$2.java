package com.tencent.mobileqq.nearby.gameroom;

import acff;
import acxw;
import ajpd;
import ajtw;
import ajtw.a;
import ajtw.b;
import aqft;
import aqgv;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.TroopManager;
import com.tencent.mobileqq.app.proxy.ProxyManager;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.data.RecentUser;
import com.tencent.mobileqq.data.TroopInfo;
import com.tencent.mobileqq.persistence.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Random;
import jqs;

public class WerewolvesDataManager$2
  implements Runnable
{
  public WerewolvesDataManager$2(ajtw paramajtw, String paramString1, String paramString2, ArrayList paramArrayList, ajtw.a parama) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList();
    ArrayList localArrayList2 = new ArrayList();
    Random localRandom = new Random(System.currentTimeMillis());
    Object localObject1 = (TroopManager)this.this$0.app.getManager(52);
    Object localObject2 = ((TroopManager)localObject1).cE();
    ((List)localObject2).size();
    Object localObject3 = this.this$0.fK();
    int i = 0;
    while ((i < ((List)localObject3).size()) && (localArrayList2.size() < 8))
    {
      localObject4 = (RecentInviteUser)((List)localObject3).get(i);
      localObject5 = new ajtw.b(this.this$0);
      if (((TroopManager)localObject1).b(((RecentInviteUser)localObject4).uin) == null)
      {
        i += 1;
      }
      else
      {
        ((ajtw.b)localObject5).uin = ((RecentInviteUser)localObject4).uin;
        ((ajtw.b)localObject5).uinType = ((RecentInviteUser)localObject4).uinType;
        ((ajtw.b)localObject5).displayName = aqgv.a(this.this$0.app, ((ajtw.b)localObject5).uin, false);
        ((ajtw.b)localObject5).cqf = this.this$0.k(((ajtw.b)localObject5).uin, ((ajtw.b)localObject5).uinType, this.bSs);
        if ((!localArrayList2.contains(localObject5)) && (!((ajtw.b)localObject5).uin.equals(this.bSt))) {
          localArrayList2.add(localObject5);
        }
        i += 1;
      }
    }
    localObject1 = this.this$0.app.a().a().q(true);
    i = 0;
    while ((localArrayList2.size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject3 = (RecentUser)((List)localObject1).get(i);
      if ((((RecentUser)localObject3).getType() == 1) && (!ajpd.d(this.this$0.app, (RecentUser)localObject3)) && (!aqft.ri(((RecentUser)localObject3).uin)) && (((RecentUser)localObject3).lFlag != 16L))
      {
        localObject4 = new ajtw.b(this.this$0);
        ((ajtw.b)localObject4).uin = ((RecentUser)localObject3).uin;
        ((ajtw.b)localObject4).uinType = ((RecentUser)localObject3).getType();
        ((ajtw.b)localObject4).displayName = aqgv.a(this.this$0.app, ((ajtw.b)localObject4).uin, false);
        ((ajtw.b)localObject4).cqf = this.this$0.k(((ajtw.b)localObject4).uin, ((ajtw.b)localObject4).uinType, this.bSs);
        if ((!localArrayList2.contains(localObject4)) && (!((ajtw.b)localObject4).uin.equals(this.bSt))) {
          localArrayList2.add(localObject4);
        }
      }
      i += 1;
    }
    if (((List)localObject2).size() > 0)
    {
      i = 0;
      while ((localArrayList2.size() < 8) && (i < 100))
      {
        localObject3 = (Entity)((List)localObject2).get(localRandom.nextInt(((List)localObject2).size()));
        if ((localObject3 instanceof TroopInfo))
        {
          localObject3 = (TroopInfo)localObject3;
          localObject4 = new ajtw.b(this.this$0);
          ((ajtw.b)localObject4).uin = ((TroopInfo)localObject3).troopuin;
          ((ajtw.b)localObject4).uinType = 1;
          ((ajtw.b)localObject4).displayName = ((TroopInfo)localObject3).getTroopName();
          ((ajtw.b)localObject4).cqf = this.this$0.k(((ajtw.b)localObject4).uin, ((ajtw.b)localObject4).uinType, this.bSs);
          if ((!localArrayList2.contains(localObject4)) && (!((ajtw.b)localObject4).uin.equals(this.bSt))) {
            localArrayList2.add(localObject4);
          }
        }
        i += 1;
      }
    }
    localObject2 = this.this$0.app.getCurrentAccountUin();
    localObject3 = new ArrayList();
    Object localObject5 = (acff)this.this$0.app.getManager(51);
    Object localObject4 = ((acff)localObject5).cq();
    int j;
    Object localObject7;
    if (localObject4 == null)
    {
      j = 0;
      if ((localObject4 != null) && (((List)localObject4).size() > 0)) {
        i = 0;
      }
    }
    else
    {
      for (;;)
      {
        if ((((List)localObject3).size() >= 8) || (i >= 100)) {
          break label951;
        }
        localObject6 = (Entity)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
        if ((localObject6 instanceof Friends))
        {
          localObject6 = (Friends)localObject6;
          if (((String)localObject2).equals(((Friends)localObject6).uin))
          {
            i += 1;
            continue;
            j = ((List)localObject4).size();
            break;
          }
          int k = aqgv.aU(((Friends)localObject6).detalStatusFlag, ((Friends)localObject6).iTermType);
          if ((k != 4) && (k != 3))
          {
            i += 1;
            continue;
          }
          localObject7 = new ajtw.b(this.this$0);
          ((ajtw.b)localObject7).uin = ((Friends)localObject6).uin;
          ((ajtw.b)localObject7).uinType = 0;
          ((ajtw.b)localObject7).displayName = aqgv.o(this.this$0.app, ((ajtw.b)localObject7).uin);
          ((ajtw.b)localObject7).cqf = this.this$0.k(((ajtw.b)localObject7).uin, ((ajtw.b)localObject7).uinType, this.bSs);
          if (!((List)localObject3).contains(localObject7)) {
            ((List)localObject3).add(localObject7);
          }
        }
        i += 1;
      }
    }
    label951:
    Object localObject6 = this.this$0.fJ();
    i = 0;
    while ((((List)localObject3).size() < 8) && (i < ((List)localObject6).size()))
    {
      localObject7 = (RecentInviteUser)((List)localObject6).get(i);
      if (((String)localObject2).equals(((RecentInviteUser)localObject7).uin))
      {
        i += 1;
      }
      else if ((j < 1000) && (!((acff)localObject5).isFriend(((RecentInviteUser)localObject7).uin)))
      {
        i += 1;
      }
      else
      {
        ajtw.b localb = new ajtw.b(this.this$0);
        localb.uin = ((RecentInviteUser)localObject7).uin;
        localb.uinType = ((RecentInviteUser)localObject7).uinType;
        localb.displayName = aqgv.o(this.this$0.app, localb.uin);
        localb.cqf = this.this$0.k(localb.uin, localb.uinType, this.bSs);
        if (!((List)localObject3).contains(localb)) {
          ((List)localObject3).add(localb);
        }
        i += 1;
      }
    }
    if ((this.ya != null) && (this.ya.size() > 0))
    {
      i = 0;
      while ((((List)localObject3).size() < 8) && (i < this.ya.size()))
      {
        localObject6 = (String)this.ya.get(i);
        if ((((String)localObject2).equals(localObject6)) || (!((acff)localObject5).isFriend((String)localObject6)))
        {
          i += 1;
        }
        else
        {
          localObject7 = new ajtw.b(this.this$0);
          ((ajtw.b)localObject7).uin = ((String)localObject6);
          ((ajtw.b)localObject7).uinType = 0;
          ((ajtw.b)localObject7).displayName = aqgv.o(this.this$0.app, ((ajtw.b)localObject7).uin);
          ((ajtw.b)localObject7).cqf = this.this$0.k(((ajtw.b)localObject7).uin, ((ajtw.b)localObject7).uinType, this.bSs);
          if (!((List)localObject3).contains(localObject7)) {
            ((List)localObject3).add(localObject7);
          }
          i += 1;
        }
      }
    }
    i = 0;
    while ((((List)localObject3).size() < 8) && (i < ((List)localObject1).size()))
    {
      localObject6 = (RecentUser)((List)localObject1).get(i);
      if (((String)localObject2).equals(((RecentUser)localObject6).uin))
      {
        i += 1;
      }
      else
      {
        if ((((RecentUser)localObject6).getType() == 0) && (!aqft.ri(((RecentUser)localObject6).uin)) && (((RecentUser)localObject6).lFlag != 16L) && (!jqs.d(this.this$0.app, ((RecentUser)localObject6).uin, ((RecentUser)localObject6).getType())))
        {
          localObject7 = new ajtw.b(this.this$0);
          ((ajtw.b)localObject7).uin = ((RecentUser)localObject6).uin;
          ((ajtw.b)localObject7).uinType = ((RecentUser)localObject6).getType();
          ((ajtw.b)localObject7).displayName = aqgv.o(this.this$0.app, ((ajtw.b)localObject7).uin);
          ((ajtw.b)localObject7).cqf = this.this$0.k(((ajtw.b)localObject7).uin, ((ajtw.b)localObject7).uinType, this.bSs);
          if ((!((List)localObject3).contains(localObject7)) && (((acff)localObject5).isFriend(((RecentUser)localObject6).uin))) {
            ((List)localObject3).add(localObject7);
          }
        }
        i += 1;
      }
    }
    if ((localObject4 != null) && (((List)localObject4).size() > 0))
    {
      i = 0;
      while ((((List)localObject3).size() < 8) && (i < 100))
      {
        localObject1 = (Entity)((List)localObject4).get(localRandom.nextInt(((List)localObject4).size()));
        if ((localObject1 instanceof Friends))
        {
          localObject1 = (Friends)localObject1;
          if (((String)localObject2).equals(((Friends)localObject1).uin))
          {
            i += 1;
            continue;
          }
          localObject5 = new ajtw.b(this.this$0);
          ((ajtw.b)localObject5).uin = ((Friends)localObject1).uin;
          ((ajtw.b)localObject5).uinType = 0;
          ((ajtw.b)localObject5).displayName = aqgv.o(this.this$0.app, ((ajtw.b)localObject5).uin);
          ((ajtw.b)localObject5).cqf = this.this$0.k(((ajtw.b)localObject5).uin, ((ajtw.b)localObject5).uinType, this.bSs);
          if (!((List)localObject3).contains(localObject5)) {
            ((List)localObject3).add(localObject5);
          }
        }
        i += 1;
      }
    }
    if ((localArrayList2.size() >= 4) && (((List)localObject3).size() >= 4))
    {
      localArrayList1.addAll(localArrayList2.subList(0, 4));
      localArrayList1.addAll(((List)localObject3).subList(0, 4));
    }
    for (;;)
    {
      this.a.au(localArrayList1, true);
      return;
      if ((localArrayList2.size() < 4) && (((List)localObject3).size() < 4))
      {
        localArrayList1.addAll(localArrayList2);
        localArrayList1.addAll((Collection)localObject3);
      }
      else
      {
        if ((localArrayList2.size() >= 4) && (((List)localObject3).size() < 4))
        {
          i = 8 - ((List)localObject3).size();
          if (localArrayList2.size() >= i) {
            localArrayList1.addAll(localArrayList2.subList(0, i));
          }
          for (;;)
          {
            localArrayList1.addAll((Collection)localObject3);
            break;
            localArrayList1.addAll(localArrayList2);
          }
        }
        i = 8 - localArrayList2.size();
        localArrayList1.addAll(localArrayList2);
        if (((List)localObject3).size() >= i) {
          localArrayList1.addAll(((List)localObject3).subList(0, i));
        } else {
          localArrayList1.addAll((Collection)localObject3);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.gameroom.WerewolvesDataManager.2
 * JD-Core Version:    0.7.0.1
 */