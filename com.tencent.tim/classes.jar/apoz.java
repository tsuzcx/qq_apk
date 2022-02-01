import com.tencent.mobileqq.pb.PBInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import mqq.manager.Manager;
import tencent.im.oidb.oidb_0x8c9.oidb_0x8c9.GroupAppUnreadInfo;

public class apoz
  implements Manager
{
  private HashMap<Long, apoy> om = new HashMap();
  private HashMap<Long, apoy> on = new HashMap();
  
  public apoz()
  {
    this.om.clear();
    this.on.clear();
  }
  
  public apoy a(Long paramLong)
  {
    return (apoy)this.om.get(paramLong);
  }
  
  public void a(apov paramapov, boolean paramBoolean) {}
  
  public void a(Long paramLong, apoy paramapoy)
  {
    Object localObject = (apoy)this.om.get(paramLong);
    if ((localObject != null) && (paramapoy != null))
    {
      paramapoy.lP(((apoy)localObject).hy());
      localObject = ((apoy)localObject).dU();
      Iterator localIterator1 = paramapoy.dU().iterator();
      for (;;)
      {
        if (!localIterator1.hasNext()) {
          break label119;
        }
        apou localapou1 = (apou)localIterator1.next();
        Iterator localIterator2 = ((ArrayList)localObject).iterator();
        if (localIterator2.hasNext())
        {
          apou localapou2 = (apou)localIterator2.next();
          if (localapou1.hw() != localapou2.hw()) {
            break;
          }
          localapou1.WT(localapou2.LA());
        }
      }
    }
    label119:
    this.om.put(paramLong, paramapoy);
  }
  
  public apoy b(Long paramLong)
  {
    return (apoy)this.on.get(paramLong);
  }
  
  public void b(Long paramLong, apoy paramapoy)
  {
    this.on.put(paramLong, paramapoy);
  }
  
  public void b(Long paramLong, List<oidb_0x8c9.GroupAppUnreadInfo> paramList)
  {
    paramLong = (apoy)this.om.get(paramLong);
    if (paramLong == null) {}
    label129:
    for (;;)
    {
      return;
      paramLong.lP(paramLong.LE() + System.currentTimeMillis());
      paramLong = paramLong.dU().iterator();
      for (;;)
      {
        if (!paramLong.hasNext()) {
          break label129;
        }
        apou localapou = (apou)paramLong.next();
        long l1 = localapou.hw();
        Iterator localIterator = paramList.iterator();
        if (localIterator.hasNext())
        {
          oidb_0x8c9.GroupAppUnreadInfo localGroupAppUnreadInfo = (oidb_0x8c9.GroupAppUnreadInfo)localIterator.next();
          long l2 = localGroupAppUnreadInfo.opt_uint64_appid.get();
          int i = localGroupAppUnreadInfo.opt_int32_group_unread_num.get();
          if (l2 != l1) {
            break;
          }
          localapou.WT(i);
        }
      }
    }
  }
  
  public void h(long paramLong, int paramInt, boolean paramBoolean)
  {
    Object localObject = (apoy)this.om.get(Long.valueOf(paramLong));
    if (localObject != null) {
      ((apoy)localObject).WW(0);
    }
    localObject = (apoy)this.on.get(Long.valueOf(paramLong));
    if (localObject == null) {}
    for (;;)
    {
      return;
      ((apoy)localObject).WU(paramInt);
      if (paramBoolean) {
        ((apoy)localObject).WV(paramInt);
      }
      if (paramInt == 0)
      {
        localObject = ((apoy)localObject).dU().iterator();
        while (((Iterator)localObject).hasNext())
        {
          apou localapou = (apou)((Iterator)localObject).next();
          localapou.WS(localapou.LB());
        }
      }
      else
      {
        localObject = ((apoy)localObject).dU().iterator();
        while (((Iterator)localObject).hasNext()) {
          ((apou)((Iterator)localObject).next()).WS(1);
        }
      }
    }
  }
  
  public void lQ(long paramLong)
  {
    apoy localapoy = (apoy)this.om.get(Long.valueOf(paramLong));
    if (localapoy != null) {
      localapoy.WW(0);
    }
  }
  
  public void onDestroy() {}
  
  public void q(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = (apoy)this.om.get(Long.valueOf(paramLong1));
    if (localObject != null) {
      ((apoy)localObject).WW(0);
    }
    localObject = (apoy)this.on.get(Long.valueOf(paramLong1));
    if (localObject != null)
    {
      localObject = ((apoy)localObject).dU().iterator();
      while (((Iterator)localObject).hasNext())
      {
        apou localapou = (apou)((Iterator)localObject).next();
        if (localapou.hw() == paramLong2) {
          localapou.WS(paramInt);
        }
      }
    }
  }
  
  public void r(long paramLong1, long paramLong2, int paramInt)
  {
    Object localObject = a(Long.valueOf(paramLong1));
    if (localObject == null) {}
    apou localapou;
    do
    {
      return;
      while (!((Iterator)localObject).hasNext())
      {
        do
        {
          localObject = ((apoy)localObject).dU();
        } while (localObject == null);
        localObject = ((List)localObject).iterator();
      }
      localapou = (apou)((Iterator)localObject).next();
    } while (localapou.hw() != paramLong2);
    localapou.WT(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apoz
 * JD-Core Version:    0.7.0.1
 */