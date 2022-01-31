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

public class tko
  implements IEventReceiver, tjp, tjy, tka
{
  protected ErrorMessage a;
  private ConcurrentHashMap<tjs, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<tju> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final sfw<tjz> jdField_a_of_type_Sfw;
  private final tjq jdField_a_of_type_Tjq = new tjq();
  private tjs jdField_a_of_type_Tjs;
  private tjw jdField_a_of_type_Tjw;
  private tkr jdField_a_of_type_Tkr;
  private tks jdField_a_of_type_Tks;
  private tkt jdField_a_of_type_Tkt;
  protected boolean a;
  private ConcurrentHashMap<tjs, Long> b = new ConcurrentHashMap();
  
  public tko(tjw paramtjw)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    urk.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramtjw);
    this.jdField_a_of_type_Tjw = paramtjw;
    this.jdField_a_of_type_Sfw = new sfw(new tkp(this));
  }
  
  private int a(@Nullable tjs paramtjs)
  {
    int j;
    if (paramtjs == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((tjt)localIterator.next()).jdField_a_of_type_Tjs.equals(paramtjs)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<tjs> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    tjq localtjq = this.jdField_a_of_type_Tjq;
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
        if (paramInt1 >= this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            tjt localtjt = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
            if (localtjt.d()) {
              break label133;
            }
            localArrayList.add(localtjt.jdField_a_of_type_Tjs);
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
  
  private tjt a(@Nullable tjs paramtjs)
  {
    int i = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.indexOf(new tjt(paramtjs));
    if (i < 0) {
      return null;
    }
    return (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Tjq)
    {
      Iterator localIterator = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        tjt localtjt = (tjt)localIterator.next();
        if (localtjt.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localtjt.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            urk.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localtjt });
            localtjt.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localtjt.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localtjt.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            urk.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localtjt });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<tjs> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      tjs localtjs = (tjs)localIterator.next();
      tjt localtjt = a(localtjs);
      if ((localtjt != null) && (!this.jdField_a_of_type_Tjw.a(localtjt)))
      {
        localIterator.remove();
        urk.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localtjt);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localtjs);
        if (this.b.containsKey(localtjs))
        {
          urk.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localtjs);
          localIterator.remove();
        }
        else
        {
          this.b.put(localtjs, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      urk.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Sfw.a(this.jdField_a_of_type_Tjw.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable tjs paramtjs)
  {
    urk.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramtjs.toString());
    synchronized (this.jdField_a_of_type_Tjq)
    {
      int j = a(paramtjs);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        urk.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Tjs = paramtjs;
        this.jdField_a_of_type_Tjw.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable tjs paramtjs, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Tjq)
      {
        localObject = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramtjs);
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
            this.jdField_a_of_type_Tjs = paramtjs;
            urk.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Tjw.a(20, this);
            return;
          }
          c();
        }
      }
      paramtjs = localArrayList.iterator();
      while (paramtjs.hasNext())
      {
        localObject = (tjt)paramtjs.next();
        if ((((tjt)localObject).d()) && (((tjt)localObject).e()))
        {
          urk.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((tjt)localObject).e())
        {
          urk.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((tjt)localObject).jdField_a_of_type_Tjs);
          localArrayList = new ArrayList(1);
          localArrayList.add(((tjt)localObject).jdField_a_of_type_Tjs);
          a(localArrayList);
        }
        else
        {
          urk.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((tjt)localObject).jdField_a_of_type_Tjs);
          localArrayList = new ArrayList(1);
          localArrayList.add(((tjt)localObject).jdField_a_of_type_Tjs);
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
  
  public tjq a(@Nullable tjs paramtjs, int paramInt)
  {
    boolean bool;
    long l;
    tjq localtjq2;
    if (paramInt >= 0)
    {
      bool = true;
      vkw.a(bool);
      l = System.currentTimeMillis();
      localtjq2 = new tjq();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      tjt localtjt;
      synchronized (this.jdField_a_of_type_Tjq)
      {
        m = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramtjs != null) {
            localtjq2.jdField_a_of_type_JavaUtilList.add(new tjr(paramtjs, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramtjs)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localtjq2.jdField_a_of_type_Boolean = true;
            localtjq2.jdField_b_of_type_Boolean = true;
            urk.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtjs, Integer.valueOf(paramInt), localtjq2 });
            return localtjq2;
          }
          localtjq2.jdField_a_of_type_Boolean = true;
          localtjq2.jdField_b_of_type_Boolean = false;
          localtjq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          urk.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtjs, Integer.valueOf(paramInt), localtjq2 });
          return localtjq2;
        }
        i = a(paramtjs);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localtjt = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(k);
          if (localtjt.d())
          {
            if (localtjt.jdField_a_of_type_JavaUtilList.size() > 0) {
              localtjq2.jdField_a_of_type_JavaUtilList.add(0, localtjt.a());
            }
            if (k != 0) {
              break label694;
            }
            localtjq2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localtjq2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtjt.jdField_a_of_type_Tjs));
          localtjq2.jdField_a_of_type_Boolean = false;
        }
        localtjt = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
        if (!localtjt.d()) {
          break label515;
        }
        if (localtjt.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localtjq2.jdField_a_of_type_JavaUtilList.add(localtjt.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localtjt = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(j);
          if (!localtjt.d()) {
            break label556;
          }
          if (localtjt.jdField_a_of_type_JavaUtilList.size() > 0) {
            localtjq2.jdField_a_of_type_JavaUtilList.add(localtjt.a());
          }
          if (i != m) {
            break label732;
          }
          localtjq2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localtjq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localtjq2.jdField_a_of_type_Boolean = true;
        }
      }
      localtjq2.jdField_a_of_type_JavaUtilList.add(new tjr(localtjt.jdField_a_of_type_Tjs, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localtjq2.jdField_a_of_type_JavaUtilList.add(new tjr(localtjt.jdField_a_of_type_Tjs, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtjt.jdField_a_of_type_Tjs)));
      break label703;
      label556:
      localtjq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtjt.jdField_a_of_type_Tjs));
      localtjq2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        urk.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramtjs, localtjq2 });
        urk.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localtjq2;
        label633:
        localtjq2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localtjq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public tjv a()
  {
    tjv localtjv = this.jdField_a_of_type_Tjw.a();
    urk.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localtjv);
    return localtjv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Tkt = new tkt(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tkt);
    this.jdField_a_of_type_Tkr = new tkr(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tkr);
    this.jdField_a_of_type_Tks = new tks(this);
    sgi.a().registerSubscriber(this.jdField_a_of_type_Tks);
    this.jdField_a_of_type_Tjw.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<tjs> paramList)
  {
    urk.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      tjs localtjs = (tjs)paramList.next();
      Long localLong = (Long)this.b.remove(localtjs);
      if (localLong != null) {
        urk.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtjs);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localtjs, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<tjs> paramList, boolean paramBoolean)
  {
    Object localObject;
    tjs localtjs;
    if (paramList == null)
    {
      localObject = "";
      urk.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localtjs = (tjs)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Tjq)
        {
          tjt localtjt = new tjt(localtjs);
          if (this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.contains(localtjt)) {
            break label149;
          }
          this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.add(localtjt);
          urk.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localtjs);
        }
        localObject = paramList;
        break;
        label149:
        urk.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localtjs });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Tjs != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (tjs)paramList.get(0);; ??? = this.jdField_a_of_type_Tjs)
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
      synchronized (this.jdField_a_of_type_Tjq)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          tjt localtjt = (tjt)localIterator1.next();
          if (localtjt.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localtjt.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            urk.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localtjt.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.remove(localtjt);
            urk.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localtjt.jdField_a_of_type_Tjs });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localtjt, paramString, bool));
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
  
  public void a(List<tjt> arg1, boolean paramBoolean)
  {
    urk.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    tjt localtjt;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localtjt = (tjt)localIterator1.next();
      localObject2 = (Long)this.b.remove(localtjt.jdField_a_of_type_Tjs);
      if (localObject2 != null) {
        urk.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localtjt.jdField_a_of_type_Tjs);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localtjt = (tjt)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Tjq)
        {
          int i = this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.indexOf(localtjt);
          if (i < 0) {
            break label367;
          }
          localObject2 = (tjt)this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.get(i);
          if (((tjt)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((tjt)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((tjt)localObject2).jdField_a_of_type_JavaUtilList = localtjt.jdField_a_of_type_JavaUtilList;
            ((tjt)localObject2).jdField_a_of_type_JavaUtilMap = localtjt.jdField_a_of_type_JavaUtilMap;
            ((tjt)localObject2).jdField_a_of_type_JavaLangString = localtjt.jdField_a_of_type_JavaLangString;
            urk.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localtjt.jdField_a_of_type_Tjs);
          }
        }
        Iterator localIterator2 = localtjt.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((tjt)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((tjt)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((tjt)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            urk.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((tjt)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localtjt.jdField_a_of_type_JavaUtilMap);
        ((tjt)localObject2).jdField_a_of_type_JavaLangString = localtjt.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        urk.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localtjt.jdField_a_of_type_Tjs });
      }
    }
    c();
  }
  
  public void a(@Nullable tjs paramtjs, int paramInt1, int paramInt2, String paramString)
  {
    urk.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramtjs, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramtjs, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable tjs paramtjs, String paramString)
  {
    if (paramtjs == null) {}
    for (Object localObject = "";; localObject = paramtjs)
    {
      urk.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramtjs), 0);
      return;
    }
  }
  
  public void a(tju paramtju)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramtju)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramtju);
    }
  }
  
  public void b()
  {
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tkt);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tkr);
    sgi.a().unRegisterSubscriber(this.jdField_a_of_type_Tks);
    this.jdField_a_of_type_Tjw.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<tjt> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      urk.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        tjt localtjt = (tjt)paramList.next();
        Long localLong = (Long)this.b.remove(localtjt.jdField_a_of_type_Tjs);
        if (localLong != null) {
          urk.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtjt.jdField_a_of_type_Tjs);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (tjt)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Tjq)
          {
            if (!this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Tjq.jdField_a_of_type_JavaUtilList.add(localObject);
              urk.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((tjt)localObject).jdField_a_of_type_Tjs);
            }
          }
          urk.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((tjt)localObject).jdField_a_of_type_Tjs });
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
  
  public void b(tju paramtju)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramtju);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes9.jar
 * Qualified Name:     tko
 * JD-Core Version:    0.7.0.1
 */