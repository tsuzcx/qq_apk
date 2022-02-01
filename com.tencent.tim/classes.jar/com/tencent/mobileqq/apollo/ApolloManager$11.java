package com.tencent.mobileqq.apollo;

import abhh;
import abkd;
import abkd.a;
import abmm;
import abto;
import aqrb;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ApolloBaseInfo;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;

public class ApolloManager$11
  implements Runnable
{
  public ApolloManager$11(abhh paramabhh, List paramList) {}
  
  public void run()
  {
    ArrayList localArrayList1 = new ArrayList(8);
    ArrayList localArrayList2 = new ArrayList(16);
    Iterator localIterator = this.wd.iterator();
    while (localIterator.hasNext())
    {
      ApolloBaseInfo localApolloBaseInfo = (ApolloBaseInfo)localIterator.next();
      if ((this.this$0.mApp != null) && (localApolloBaseInfo != null))
      {
        int i = 0;
        Object localObject4 = localApolloBaseInfo.getApolloDress();
        StringBuilder localStringBuilder;
        int j;
        long l;
        Object localObject2;
        Object localObject3;
        if (localObject4 != null)
        {
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((abkd)localObject4).toString());
          }
          j = -1;
          l = this.this$0.f(1, ((abkd)localObject4).roleId) / 1000L;
          i = j;
          if (l != ((abkd)localObject4).NM)
          {
            i = j;
            if (!localArrayList1.contains(Integer.valueOf(((abkd)localObject4).roleId)))
            {
              j = ((abkd)localObject4).roleId;
              localArrayList1.add(Integer.valueOf(((abkd)localObject4).roleId));
              i = j;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\nrole id: ").append(((abkd)localObject4).roleId).append(", local TS: ").append(l).append(", svr TS: ").append(((abkd)localObject4).NM);
                i = j;
              }
            }
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (((abkd)localObject4).in != null)
          {
            localObject3 = new ArrayList();
            localObject1 = ((abkd)localObject4).in.entrySet().iterator();
            while (((Iterator)localObject1).hasNext())
            {
              localObject4 = (abkd.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
              l = this.this$0.f(2, ((abkd.a)localObject4).id) / 1000L;
              if ((l != ((abkd.a)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((abkd.a)localObject4).id))))
              {
                ((ArrayList)localObject3).add(Integer.valueOf(((abkd.a)localObject4).id));
                localArrayList2.add(Integer.valueOf(((abkd.a)localObject4).id));
                if (QLog.isColorLevel()) {
                  localStringBuilder.append("\ndress id: ").append(((abkd.a)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((abkd.a)localObject4).ts);
                }
              }
            }
            localObject1 = localApolloBaseInfo.getApolloPetDress();
            if ((localObject1 != null) && (((abkd)localObject1).in != null))
            {
              localObject1 = ((abkd)localObject1).in.entrySet().iterator();
              while (((Iterator)localObject1).hasNext())
              {
                localObject4 = (abkd.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
                l = this.this$0.f(2, ((abkd.a)localObject4).id) / 1000L;
                if ((l != ((abkd.a)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((abkd.a)localObject4).id))))
                {
                  ((ArrayList)localObject3).add(Integer.valueOf(((abkd.a)localObject4).id));
                  localArrayList2.add(Integer.valueOf(((abkd.a)localObject4).id));
                  if (QLog.isColorLevel()) {
                    localStringBuilder.append("\npet dress id: ").append(((abkd.a)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((abkd.a)localObject4).ts);
                  }
                }
              }
            }
            localObject1 = localObject2;
            if (((ArrayList)localObject3).size() > 0)
            {
              localObject2 = new int[((ArrayList)localObject3).size()];
              localObject3 = ((ArrayList)localObject3).iterator();
              j = 0;
              for (;;)
              {
                localObject1 = localObject2;
                if (!((Iterator)localObject3).hasNext()) {
                  break;
                }
                localObject2[j] = ((Integer)((Iterator)localObject3).next()).intValue();
                j += 1;
              }
            }
          }
          if ((i != -1) || ((localObject1 != null) && (localObject1.length != 0))) {
            break label1108;
          }
          i = 1;
          localStringBuilder.append("\nlocal dress is OK");
        }
        int k;
        for (;;)
        {
          if (QLog.isColorLevel()) {
            QLog.d("ApolloManager", 2, localStringBuilder.toString());
          }
          localObject4 = localApolloBaseInfo.getApolloDress3D();
          k = i;
          if (localObject4 == null) {
            break label1270;
          }
          localStringBuilder = new StringBuilder();
          if (QLog.isColorLevel()) {
            localStringBuilder.append("3d updateUserDress uin: ").append(localApolloBaseInfo.uin).append(", dress info: ").append(((abkd)localObject4).toString());
          }
          k = -1;
          l = this.this$0.f(1, ((abkd)localObject4).roleId) / 1000L;
          j = k;
          if (l != ((abkd)localObject4).NM)
          {
            j = k;
            if (!localArrayList1.contains(Integer.valueOf(((abkd)localObject4).roleId)))
            {
              k = ((abkd)localObject4).roleId;
              localArrayList1.add(Integer.valueOf(((abkd)localObject4).roleId));
              j = k;
              if (QLog.isColorLevel())
              {
                localStringBuilder.append("\n3d role id: ").append(((abkd)localObject4).roleId).append(", local TS: ").append(l).append(", svr TS: ").append(((abkd)localObject4).NM);
                j = k;
              }
            }
          }
          localObject2 = null;
          localObject1 = localObject2;
          if (((abkd)localObject4).in == null) {
            break label1223;
          }
          localObject3 = new ArrayList();
          localObject1 = ((abkd)localObject4).in.entrySet().iterator();
          while (((Iterator)localObject1).hasNext())
          {
            localObject4 = (abkd.a)((Map.Entry)((Iterator)localObject1).next()).getValue();
            l = this.this$0.f(2, ((abkd.a)localObject4).id) / 1000L;
            if ((l != ((abkd.a)localObject4).ts) && (!localArrayList2.contains(Integer.valueOf(((abkd.a)localObject4).id))))
            {
              ((ArrayList)localObject3).add(Integer.valueOf(((abkd.a)localObject4).id));
              localArrayList2.add(Integer.valueOf(((abkd.a)localObject4).id));
              if (QLog.isColorLevel()) {
                localStringBuilder.append("\n3d dress id: ").append(((abkd.a)localObject4).id).append(", local TS: ").append(l).append(", svr TS: ").append(((abkd.a)localObject4).ts);
              }
            }
          }
          label1108:
          abto.a(this.this$0.mApp, localApolloBaseInfo.uin, this.this$0.a(), i, (int[])localObject1, -1, -1, true);
          if (QLog.isColorLevel()) {
            localStringBuilder.append("\ndown load dress");
          }
          i = 0;
        }
        Object localObject1 = localObject2;
        if (((ArrayList)localObject3).size() > 0)
        {
          localObject2 = new int[((ArrayList)localObject3).size()];
          localObject3 = ((ArrayList)localObject3).iterator();
          k = 0;
          for (;;)
          {
            localObject1 = localObject2;
            if (!((Iterator)localObject3).hasNext()) {
              break;
            }
            localObject2[k] = ((Integer)((Iterator)localObject3).next()).intValue();
            k += 1;
          }
        }
        label1223:
        if ((j == -1) && ((localObject1 == null) || (localObject1.length == 0)))
        {
          j = 1;
          localStringBuilder.append("\nlocal dress is OK");
        }
        for (;;)
        {
          k = j;
          if (QLog.isColorLevel())
          {
            QLog.d("ApolloManager", 2, localStringBuilder.toString());
            k = j;
          }
          label1270:
          if (k == 0) {
            break;
          }
          localObject1 = new ArrayList(1);
          ((ArrayList)localObject1).add(localApolloBaseInfo.uin);
          localObject2 = (aqrb)this.this$0.mApp.getBusinessHandler(71);
          ((aqrb)localObject2).notifyUI(2, true, localObject1);
          abmm.a().dt((ArrayList)localObject1);
          ((aqrb)localObject2).a(localApolloBaseInfo.uin, localApolloBaseInfo);
          break;
          abto.a(this.this$0.mApp, localApolloBaseInfo.uin, this.this$0.a(), j, (int[])localObject1, -1, -1, true);
          j = i;
          if (QLog.isColorLevel())
          {
            localStringBuilder.append("\n3d download dress");
            j = i;
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.ApolloManager.11
 * JD-Core Version:    0.7.0.1
 */