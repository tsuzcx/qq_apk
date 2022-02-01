import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.2;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.3;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class xdu
  implements IEventReceiver, xcv, xde, xdg
{
  protected ErrorMessage a;
  private ConcurrentHashMap<xcy, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<xda> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final vzr<xdf> jdField_a_of_type_Vzr;
  private final xcw jdField_a_of_type_Xcw = new xcw();
  private xcy jdField_a_of_type_Xcy;
  private xdc jdField_a_of_type_Xdc;
  private xdx jdField_a_of_type_Xdx;
  private xdy jdField_a_of_type_Xdy;
  private xdz jdField_a_of_type_Xdz;
  protected boolean a;
  private ConcurrentHashMap<xcy, Long> b = new ConcurrentHashMap();
  
  public xdu(xdc paramxdc)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ykq.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramxdc);
    this.jdField_a_of_type_Xdc = paramxdc;
    this.jdField_a_of_type_Vzr = new vzr(new xdv(this));
  }
  
  private int a(@Nullable xcy paramxcy)
  {
    int j;
    if (paramxcy == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((xcz)localIterator.next()).jdField_a_of_type_Xcy.equals(paramxcy)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<xcy> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    xcw localxcw = this.jdField_a_of_type_Xcw;
    int j = paramInt1 - paramInt2;
    int i = j;
    if (j < 0) {
      i = 0;
    }
    paramInt1 += paramInt2;
    for (;;)
    {
      try
      {
        if (paramInt1 >= this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            xcz localxcz = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
            if (localxcz.d()) {
              break label133;
            }
            localArrayList.add(localxcz.jdField_a_of_type_Xcy);
            break label133;
          }
          return localArrayList;
        }
      }
      finally {}
      continue;
      label133:
      i += 1;
    }
  }
  
  private xcz a(@Nullable xcy paramxcy)
  {
    int i = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.indexOf(new xcz(paramxcy));
    if (i < 0) {
      return null;
    }
    return (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Xcw)
    {
      Iterator localIterator = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        xcz localxcz = (xcz)localIterator.next();
        if (localxcz.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localxcz.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            ykq.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localxcz });
            localxcz.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localxcz.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localxcz.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            ykq.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localxcz });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<xcy> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xcy localxcy = (xcy)localIterator.next();
      xcz localxcz = a(localxcy);
      if ((localxcz != null) && (!this.jdField_a_of_type_Xdc.a(localxcz)))
      {
        localIterator.remove();
        ykq.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localxcz);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localxcy);
        if (this.b.containsKey(localxcy))
        {
          ykq.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localxcy);
          localIterator.remove();
        }
        else
        {
          this.b.put(localxcy, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      ykq.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Vzr.a(this.jdField_a_of_type_Xdc.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable xcy paramxcy)
  {
    ykq.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramxcy.toString());
    synchronized (this.jdField_a_of_type_Xcw)
    {
      int j = a(paramxcy);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        ykq.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Xcy = paramxcy;
        this.jdField_a_of_type_Xdc.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable xcy paramxcy, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Xcw)
      {
        localObject = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramxcy);
        i = k;
        if (k == -1) {
          i = 0;
        }
        if (paramInt1 != 2) {
          break label406;
        }
        j = i + paramInt2;
        paramInt2 = j;
        if (j >= ((List)localObject).size()) {
          paramInt2 = ((List)localObject).size();
        }
        if (((List)localObject).size() > 0) {
          if (i < paramInt2)
          {
            localArrayList.add(((List)localObject).get(i));
            i += 1;
            continue;
            if (((List)localObject).size() > 0) {
              if (i >= paramInt2)
              {
                localArrayList.add(((List)localObject).get(i));
                i -= 1;
                continue;
              }
            }
          }
        }
        if (localArrayList.size() == 0)
        {
          if ((paramInt1 == 2) && (!this.jdField_a_of_type_Boolean))
          {
            this.jdField_a_of_type_Xcy = paramxcy;
            ykq.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Xdc.a(20, this);
            return;
          }
          c();
        }
      }
      paramxcy = localArrayList.iterator();
      while (paramxcy.hasNext())
      {
        localObject = (xcz)paramxcy.next();
        if ((((xcz)localObject).d()) && (((xcz)localObject).e()))
        {
          ykq.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((xcz)localObject).e())
        {
          ykq.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((xcz)localObject).jdField_a_of_type_Xcy);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xcz)localObject).jdField_a_of_type_Xcy);
          a(localArrayList);
        }
        else
        {
          ykq.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((xcz)localObject).jdField_a_of_type_Xcy);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xcz)localObject).jdField_a_of_type_Xcy);
          a(localArrayList);
        }
      }
      continue;
      label406:
      do
      {
        break;
        paramInt2 = i - paramInt2;
      } while (paramInt2 >= 0);
      paramInt2 = j;
    }
  }
  
  private void d()
  {
    ThreadManager.getUIHandler().post(new SimpleDataProvider.5(this));
  }
  
  public xcw a(@Nullable xcy paramxcy, int paramInt)
  {
    boolean bool;
    long l;
    xcw localxcw2;
    if (paramInt >= 0)
    {
      bool = true;
      zdl.a(bool);
      l = System.currentTimeMillis();
      localxcw2 = new xcw();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      xcz localxcz;
      synchronized (this.jdField_a_of_type_Xcw)
      {
        m = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramxcy != null) {
            localxcw2.jdField_a_of_type_JavaUtilList.add(new xcx(paramxcy, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxcy)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localxcw2.jdField_a_of_type_Boolean = true;
            localxcw2.jdField_b_of_type_Boolean = true;
            ykq.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxcy, Integer.valueOf(paramInt), localxcw2 });
            return localxcw2;
          }
          localxcw2.jdField_a_of_type_Boolean = true;
          localxcw2.jdField_b_of_type_Boolean = false;
          localxcw2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          ykq.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxcy, Integer.valueOf(paramInt), localxcw2 });
          return localxcw2;
        }
        i = a(paramxcy);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localxcz = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(k);
          if (localxcz.d())
          {
            if (localxcz.jdField_a_of_type_JavaUtilList.size() > 0) {
              localxcw2.jdField_a_of_type_JavaUtilList.add(0, localxcz.a());
            }
            if (k != 0) {
              break label694;
            }
            localxcw2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localxcw2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxcz.jdField_a_of_type_Xcy));
          localxcw2.jdField_a_of_type_Boolean = false;
        }
        localxcz = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
        if (!localxcz.d()) {
          break label515;
        }
        if (localxcz.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localxcw2.jdField_a_of_type_JavaUtilList.add(localxcz.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localxcz = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(j);
          if (!localxcz.d()) {
            break label556;
          }
          if (localxcz.jdField_a_of_type_JavaUtilList.size() > 0) {
            localxcw2.jdField_a_of_type_JavaUtilList.add(localxcz.a());
          }
          if (i != m) {
            break label732;
          }
          localxcw2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localxcw2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localxcw2.jdField_a_of_type_Boolean = true;
        }
      }
      localxcw2.jdField_a_of_type_JavaUtilList.add(new xcx(localxcz.jdField_a_of_type_Xcy, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localxcw2.jdField_a_of_type_JavaUtilList.add(new xcx(localxcz.jdField_a_of_type_Xcy, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxcz.jdField_a_of_type_Xcy)));
      break label703;
      label556:
      localxcw2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxcz.jdField_a_of_type_Xcy));
      localxcw2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        ykq.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramxcy, localxcw2 });
        ykq.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localxcw2;
        label633:
        localxcw2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localxcw2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
      }
      label660:
      label669:
      label686:
      label694:
      label703:
      do
      {
        break label372;
        for (;;)
        {
          break label686;
          break label669;
          bool = false;
          break;
          if (i <= 0) {
            break label461;
          }
          j = i - paramInt;
          if (j < 0) {
            j = 0;
          }
        }
        k = i - 1;
        break label211;
        k -= 1;
        break label211;
        j = i + 1;
        if (j >= m) {
          break label633;
        }
        i = j + paramInt;
      } while (i <= m);
      int i = m;
      continue;
      label732:
      j += 1;
    }
  }
  
  public xdb a()
  {
    xdb localxdb = this.jdField_a_of_type_Xdc.a();
    ykq.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localxdb);
    return localxdb;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xdz = new xdz(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xdz);
    this.jdField_a_of_type_Xdx = new xdx(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xdx);
    this.jdField_a_of_type_Xdy = new xdy(this);
    wad.a().registerSubscriber(this.jdField_a_of_type_Xdy);
    this.jdField_a_of_type_Xdc.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<xcy> paramList)
  {
    ykq.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xcy localxcy = (xcy)paramList.next();
      Long localLong = (Long)this.b.remove(localxcy);
      if (localLong != null) {
        ykq.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxcy);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localxcy, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<xcy> paramList, boolean paramBoolean)
  {
    Object localObject;
    xcy localxcy;
    if (paramList == null)
    {
      localObject = "";
      ykq.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localxcy = (xcy)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xcw)
        {
          xcz localxcz = new xcz(localxcy);
          if (this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.contains(localxcz)) {
            break label149;
          }
          this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.add(localxcz);
          ykq.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localxcy);
        }
        localObject = paramList;
        break;
        label149:
        ykq.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localxcy });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Xcy != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (xcy)paramList.get(0);; ??? = this.jdField_a_of_type_Xcy)
    {
      a(???);
      return;
    }
    label210:
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ???;
    c();
  }
  
  void a(String paramString)
  {
    boolean bool = true;
    label218:
    for (;;)
    {
      synchronized (this.jdField_a_of_type_Xcw)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          xcz localxcz = (xcz)localIterator1.next();
          if (localxcz.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localxcz.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            ykq.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localxcz.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.remove(localxcz);
            ykq.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localxcz.jdField_a_of_type_Xcy });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localxcz, paramString, bool));
          }
        }
        else
        {
          return;
        }
      }
      bool = false;
    }
  }
  
  public void a(List<xcz> arg1, boolean paramBoolean)
  {
    ykq.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    xcz localxcz;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localxcz = (xcz)localIterator1.next();
      localObject2 = (Long)this.b.remove(localxcz.jdField_a_of_type_Xcy);
      if (localObject2 != null) {
        ykq.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localxcz.jdField_a_of_type_Xcy);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localxcz = (xcz)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xcw)
        {
          int i = this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.indexOf(localxcz);
          if (i < 0) {
            break label367;
          }
          localObject2 = (xcz)this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.get(i);
          if (((xcz)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((xcz)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((xcz)localObject2).jdField_a_of_type_JavaUtilList = localxcz.jdField_a_of_type_JavaUtilList;
            ((xcz)localObject2).jdField_a_of_type_JavaUtilMap = localxcz.jdField_a_of_type_JavaUtilMap;
            ((xcz)localObject2).jdField_a_of_type_JavaLangString = localxcz.jdField_a_of_type_JavaLangString;
            ykq.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localxcz.jdField_a_of_type_Xcy);
          }
        }
        Iterator localIterator2 = localxcz.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((xcz)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((xcz)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((xcz)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            ykq.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((xcz)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localxcz.jdField_a_of_type_JavaUtilMap);
        ((xcz)localObject2).jdField_a_of_type_JavaLangString = localxcz.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        ykq.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localxcz.jdField_a_of_type_Xcy });
      }
    }
    c();
  }
  
  public void a(@Nullable xcy paramxcy, int paramInt1, int paramInt2, String paramString)
  {
    ykq.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramxcy, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramxcy, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable xcy paramxcy, String paramString)
  {
    if (paramxcy == null) {}
    for (Object localObject = "";; localObject = paramxcy)
    {
      ykq.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramxcy), 0);
      return;
    }
  }
  
  public void a(xda paramxda)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramxda)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramxda);
    }
  }
  
  public void b()
  {
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xdz);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xdx);
    wad.a().unRegisterSubscriber(this.jdField_a_of_type_Xdy);
    this.jdField_a_of_type_Xdc.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<xcz> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      ykq.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        xcz localxcz = (xcz)paramList.next();
        Long localLong = (Long)this.b.remove(localxcz.jdField_a_of_type_Xcy);
        if (localLong != null) {
          ykq.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxcz.jdField_a_of_type_Xcy);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (xcz)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Xcw)
          {
            if (!this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Xcw.jdField_a_of_type_JavaUtilList.add(localObject);
              ykq.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((xcz)localObject).jdField_a_of_type_Xcy);
            }
          }
          ykq.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((xcz)localObject).jdField_a_of_type_Xcy });
        }
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
    }
    for (;;)
    {
      c();
      return;
      this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ???;
    }
  }
  
  public void b(xda paramxda)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramxda);
  }
  
  protected void c()
  {
    if (this.jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger.getAndIncrement() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      d();
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SimpleDataProvider.4(this), 500L);
  }
  
  public boolean isValidate()
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     xdu
 * JD-Core Version:    0.7.0.1
 */