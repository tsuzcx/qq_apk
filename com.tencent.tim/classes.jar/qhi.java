import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.biz.qqstory.base.ErrorMessage;
import com.tencent.biz.qqstory.model.item.StoryVideoItem;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.2;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.3;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.4;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.5;
import com.tencent.biz.qqstory.playvideo.dataprovider.SimpleDataProvider.6;
import com.tencent.biz.qqstory.storyHome.model.GeneralFeedItem;
import com.tencent.mobileqq.app.ThreadManager;
import com.tribe.async.async.Boss;
import com.tribe.async.async.Bosses;
import com.tribe.async.dispatch.Dispatcher;
import com.tribe.async.dispatch.IEventReceiver;
import com.tribe.async.dispatch.Subscriber.SingleEventSubscriberNoRefect;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class qhi
  implements IEventReceiver, qgy, qgz.b, qgz.c.a
{
  private final plx.d<qgz.c> jdField_a_of_type_Plx$d;
  private qgz jdField_a_of_type_Qgz;
  private qhi.a jdField_a_of_type_Qhi$a;
  private qhi.b jdField_a_of_type_Qhi$b;
  private qhi.c jdField_a_of_type_Qhi$c;
  protected boolean aDs;
  private AtomicInteger am = new AtomicInteger(0);
  private final qgy.a b = new qgy.a();
  private ConcurrentHashMap<qgy.c, ErrorMessage> cd = new ConcurrentHashMap();
  private ConcurrentHashMap<qgy.c, Long> ce = new ConcurrentHashMap();
  private qgy.c e;
  protected ErrorMessage j = new ErrorMessage();
  private CopyOnWriteArrayList<qgy.e> t = new CopyOnWriteArrayList();
  
  public qhi(qgz paramqgz)
  {
    ram.b("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramqgz);
    this.jdField_a_of_type_Qgz = paramqgz;
    this.jdField_a_of_type_Plx$d = new plx.d(new qhj(this));
  }
  
  private void N(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.b)
    {
      Iterator localIterator = this.b.nP.iterator();
      while (localIterator.hasNext())
      {
        qgy.d locald = (qgy.d)localIterator.next();
        if (locald.nv != null)
        {
          int i = locald.nv.indexOf(paramString1);
          if (i >= 0)
          {
            ram.w("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { locald });
            locald.nv.add(i, paramString2);
            locald.nv.remove(paramString1);
            locald.fR.put(paramString2, paramString3);
            ram.w("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { locald });
            boo();
            return;
          }
        }
      }
      return;
    }
  }
  
  private int a(@Nullable qgy.c paramc)
  {
    int k;
    if (paramc == null)
    {
      k = -1;
      return k;
    }
    Iterator localIterator = this.b.nP.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      k = i;
      if (((qgy.d)localIterator.next()).d.equals(paramc)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private qgy.d a(@Nullable qgy.c paramc)
  {
    int i = this.b.nP.indexOf(new qgy.d(paramc));
    if (i < 0) {
      return null;
    }
    return (qgy.d)this.b.nP.get(i);
  }
  
  private void a(@Nullable qgy.c paramc)
  {
    ram.b("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramc.toString());
    synchronized (this.b)
    {
      int k = a(paramc);
      int i = k;
      if (k < 0) {
        i = 0;
      }
      if ((i + 5 > this.b.nP.size()) && (!this.aDs))
      {
        ram.d("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.j = new ErrorMessage();
        this.e = paramc;
        this.jdField_a_of_type_Qgz.a(20, this);
      }
      ep(b(i, 2));
      return;
    }
  }
  
  private List<qgy.c> b(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    qgy.a locala = this.b;
    int k = paramInt1 - paramInt2;
    int i = k;
    if (k < 0) {
      i = 0;
    }
    paramInt1 += paramInt2;
    for (;;)
    {
      try
      {
        if (paramInt1 >= this.b.nP.size())
        {
          paramInt1 = this.b.nP.size();
          if (i < paramInt1)
          {
            qgy.d locald = (qgy.d)this.b.nP.get(i);
            if (locald.JB()) {
              break label133;
            }
            localArrayList.add(locald.d);
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
  
  private void b(@Nullable qgy.c paramc, int paramInt1, int paramInt2, String arg4)
  {
    int k = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.b)
      {
        localObject = this.b.nP;
        localArrayList = new ArrayList();
        int m = a(paramc);
        i = m;
        if (m == -1) {
          i = 0;
        }
        if (paramInt1 != 2) {
          break label401;
        }
        k = i + paramInt2;
        paramInt2 = k;
        if (k >= ((List)localObject).size()) {
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
          if ((paramInt1 == 2) && (!this.aDs))
          {
            this.e = paramc;
            ram.d("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.j = new ErrorMessage();
            this.jdField_a_of_type_Qgz.a(20, this);
            return;
          }
          boo();
        }
      }
      paramc = localArrayList.iterator();
      while (paramc.hasNext())
      {
        localObject = (qgy.d)paramc.next();
        if ((((qgy.d)localObject).JB()) && (((qgy.d)localObject).isEnd()))
        {
          ram.b("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          boo();
        }
        else if (!((qgy.d)localObject).isEnd())
        {
          ram.b("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((qgy.d)localObject).d);
          localArrayList = new ArrayList(1);
          localArrayList.add(((qgy.d)localObject).d);
          ep(localArrayList);
        }
        else
        {
          ram.b("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((qgy.d)localObject).d);
          localArrayList = new ArrayList(1);
          localArrayList.add(((qgy.d)localObject).d);
          ep(localArrayList);
        }
      }
      continue;
      label401:
      do
      {
        break;
        paramInt2 = i - paramInt2;
      } while (paramInt2 >= 0);
      paramInt2 = k;
    }
  }
  
  private void bop()
  {
    ThreadManager.getUIHandler().post(new SimpleDataProvider.5(this));
  }
  
  private void ep(List<qgy.c> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      qgy.c localc = (qgy.c)localIterator.next();
      qgy.d locald = a(localc);
      if ((locald != null) && (!this.jdField_a_of_type_Qgz.a(locald)))
      {
        localIterator.remove();
        ram.d("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", locald);
      }
      else
      {
        this.cd.remove(localc);
        if (this.ce.containsKey(localc))
        {
          ram.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localc);
          localIterator.remove();
        }
        else
        {
          this.ce.put(localc, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      ram.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Plx$d.dR(this.jdField_a_of_type_Qgz.ap(paramList));
      return;
    }
    boo();
  }
  
  public void C(List<qgy.d> arg1, boolean paramBoolean)
  {
    ram.d("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    qgy.d locald;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      locald = (qgy.d)localIterator1.next();
      localObject2 = (Long)this.ce.remove(locald.d);
      if (localObject2 != null) {
        ram.b("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), locald.d);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      locald = (qgy.d)localIterator1.next();
      for (;;)
      {
        synchronized (this.b)
        {
          int i = this.b.nP.indexOf(locald);
          if (i < 0) {
            break label367;
          }
          localObject2 = (qgy.d)this.b.nP.get(i);
          if (((qgy.d)localObject2).nv == null) {
            ((qgy.d)localObject2).nv = new ArrayList();
          }
          if (paramBoolean)
          {
            ((qgy.d)localObject2).nv = locald.nv;
            ((qgy.d)localObject2).fR = locald.fR;
            ((qgy.d)localObject2).axq = locald.axq;
            ram.b("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", locald.d);
          }
        }
        Iterator localIterator2 = locald.nv.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((qgy.d)localObject2).nv.contains(str))
          {
            ((qgy.d)localObject2).nv.add(str);
          }
          else
          {
            ((qgy.d)localObject2).nv.add(str);
            ram.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((qgy.d)localObject2).fR.putAll(locald.fR);
        ((qgy.d)localObject2).axq = locald.axq;
        continue;
        label367:
        ram.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { locald.d });
      }
    }
    boo();
  }
  
  public qgy.a a(@Nullable qgy.c paramc, int paramInt)
  {
    boolean bool;
    long l;
    qgy.a locala2;
    if (paramInt >= 0)
    {
      bool = true;
      rom.assertTrue(bool);
      l = System.currentTimeMillis();
      locala2 = new qgy.a();
    }
    for (;;)
    {
      int n;
      label211:
      int m;
      int k;
      qgy.d locald;
      synchronized (this.b)
      {
        n = this.b.nP.size();
        if (n == 0)
        {
          if (paramc != null) {
            locala2.nP.add(new qgy.b(paramc, (ErrorMessage)this.cd.get(paramc)));
          }
          if (this.aDs)
          {
            locala2.aDp = true;
            locala2.aDq = true;
            ram.w("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramc, Integer.valueOf(paramInt), locala2 });
            return locala2;
          }
          locala2.aDp = true;
          locala2.aDq = false;
          locala2.h = this.j;
          ram.w("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramc, Integer.valueOf(paramInt), locala2 });
          return locala2;
        }
        i = a(paramc);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (m >= k)
        {
          locald = (qgy.d)this.b.nP.get(m);
          if (locald.JB())
          {
            if (locald.nv.size() > 0) {
              locala2.nP.add(0, locald.a());
            }
            if (m != 0) {
              break label694;
            }
            locala2.aDp = true;
            break label694;
          }
          locala2.g = ((ErrorMessage)this.cd.get(locald.d));
          locala2.aDp = false;
        }
        locald = (qgy.d)this.b.nP.get(i);
        if (!locald.JB()) {
          break label515;
        }
        if (locald.nv.size() > 0)
        {
          locala2.nP.add(locald.a());
          break label703;
          label372:
          if (k >= i) {
            break label582;
          }
          locald = (qgy.d)this.b.nP.get(k);
          if (!locald.JB()) {
            break label556;
          }
          if (locald.nv.size() > 0) {
            locala2.nP.add(locald.a());
          }
          if (i != n) {
            break label732;
          }
          locala2.aDq = this.aDs;
          locala2.h = this.j;
          break label732;
          label461:
          locala2.aDp = true;
        }
      }
      locala2.nP.add(new qgy.b(locald.d, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      locala2.nP.add(new qgy.b(locald.d, (ErrorMessage)this.cd.get(locald.d)));
      break label703;
      label556:
      locala2.h = ((ErrorMessage)this.cd.get(locald.d));
      locala2.aDq = false;
      for (;;)
      {
        label582:
        ram.w("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramc, locala2 });
        ram.b("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return locala2;
        label633:
        locala2.aDq = this.aDs;
        locala2.h = this.j;
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
          k = i - paramInt;
          if (k < 0) {
            k = 0;
          }
        }
        m = i - 1;
        break label211;
        m -= 1;
        break label211;
        k = i + 1;
        if (k >= n) {
          break label633;
        }
        i = k + paramInt;
      } while (i <= n);
      int i = n;
      continue;
      label732:
      k += 1;
    }
  }
  
  public void a(ErrorMessage arg1, List<qgy.c> paramList, boolean paramBoolean)
  {
    Object localObject;
    qgy.c localc;
    if (paramList == null)
    {
      localObject = "";
      ram.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.aDs = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localc = (qgy.c)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.b)
        {
          qgy.d locald = new qgy.d(localc);
          if (this.b.nP.contains(locald)) {
            break label149;
          }
          this.b.nP.add(locald);
          ram.b("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localc);
        }
        localObject = paramList;
        break;
        label149:
        ram.w("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localc });
      }
    }
    if (paramList.size() > 0) {
      if (this.e != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (qgy.c)paramList.get(0);; ??? = this.e)
    {
      a(???);
      return;
    }
    label210:
    this.j = ???;
    boo();
  }
  
  public void a(@Nullable qgy.c paramc, int paramInt1, int paramInt2, String paramString)
  {
    ram.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramc, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramc, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(qgy.e parame)
  {
    if (!this.t.contains(parame)) {
      this.t.add(parame);
    }
  }
  
  public qgy.f b()
  {
    qgy.f localf = this.jdField_a_of_type_Qgz.b();
    ram.b("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localf);
    return localf;
  }
  
  public void b(ErrorMessage paramErrorMessage, List<qgy.c> paramList)
  {
    ram.d("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      qgy.c localc = (qgy.c)paramList.next();
      Long localLong = (Long)this.ce.remove(localc);
      if (localLong != null) {
        ram.b("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localc);
      }
      this.cd.put(localc, paramErrorMessage);
    }
    boo();
  }
  
  public void b(ErrorMessage arg1, List<qgy.d> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      ram.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        qgy.d locald = (qgy.d)paramList.next();
        Long localLong = (Long)this.ce.remove(locald.d);
        if (localLong != null) {
          ram.b("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), locald.d);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (qgy.d)paramList.next();
        for (;;)
        {
          synchronized (this.b)
          {
            if (!this.b.nP.contains(localObject))
            {
              this.b.nP.add(localObject);
              ram.b("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((qgy.d)localObject).d);
            }
          }
          ram.w("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((qgy.d)localObject).d });
        }
      }
      this.aDs = paramBoolean;
    }
    for (;;)
    {
      boo();
      return;
      this.j = ???;
    }
  }
  
  public void b(qgy.e parame)
  {
    this.t.remove(parame);
  }
  
  protected void boo()
  {
    if (this.am.getAndIncrement() == 0) {}
    for (int i = 1; i != 0; i = 0)
    {
      bop();
      return;
    }
    ThreadManager.getSubThreadHandler().postDelayed(new SimpleDataProvider.4(this), 500L);
  }
  
  public void c(@Nullable qgy.c paramc, String paramString)
  {
    if (paramc == null) {}
    for (Object localObject = "";; localObject = paramc)
    {
      ram.b("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramc), 0);
      return;
    }
  }
  
  public void create()
  {
    this.jdField_a_of_type_Qhi$c = new qhi.c(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qhi$c);
    this.jdField_a_of_type_Qhi$a = new qhi.a(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qhi$a);
    this.jdField_a_of_type_Qhi$b = new qhi.b(this);
    pmi.a().registerSubscriber(this.jdField_a_of_type_Qhi$b);
    this.jdField_a_of_type_Qgz.create();
  }
  
  public void destroy()
  {
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhi$c);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhi$a);
    pmi.a().unRegisterSubscriber(this.jdField_a_of_type_Qhi$b);
    this.jdField_a_of_type_Qgz.destroy();
    this.t.clear();
  }
  
  public boolean isValidate()
  {
    return true;
  }
  
  void rJ(String paramString)
  {
    boolean bool = true;
    label218:
    for (;;)
    {
      synchronized (this.b)
      {
        Iterator localIterator1 = this.b.nP.iterator();
        if (localIterator1.hasNext())
        {
          qgy.d locald = (qgy.d)localIterator1.next();
          if (locald.nv == null) {
            continue;
          }
          Iterator localIterator2 = locald.nv.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            ram.w("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (locald.nv.size() == 0)
          {
            this.b.nP.remove(locald);
            ram.w("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, locald.d });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, locald, paramString, bool));
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
  
  public static class a
    extends Subscriber.SingleEventSubscriberNoRefect<psg>
  {
    qhi a;
    
    public a(@NonNull qhi paramqhi)
    {
      this.a = paramqhi;
    }
    
    public Class acceptEventClass()
    {
      return psg.class;
    }
    
    protected void c(@NonNull psg parampsg)
    {
      if (parampsg.b.isSuccess()) {
        this.a.rJ(parampsg.vid);
      }
    }
  }
  
  public static class b
    extends Subscriber.SingleEventSubscriberNoRefect<pxy.c>
  {
    qhi a;
    
    public b(@NonNull qhi paramqhi)
    {
      this.a = paramqhi;
    }
    
    protected void a(@NonNull pxy.c paramc)
    {
      if (paramc.b.isSuccess()) {
        this.a.rJ(paramc.vid);
      }
    }
    
    public Class acceptEventClass()
    {
      return pxy.c.class;
    }
  }
  
  public static class c
    extends Subscriber.SingleEventSubscriberNoRefect<pnx.d>
  {
    qhi a;
    
    public c(@NonNull qhi paramqhi)
    {
      this.a = paramqhi;
    }
    
    public Class acceptEventClass()
    {
      return pnx.d.class;
    }
    
    protected void c(@NonNull pnx.d paramd)
    {
      if ((paramd.c != null) && (paramd.b != null)) {
        qhi.a(this.a, paramd.b.mVid, paramd.c.mVid, paramd.a.feedId);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     qhi
 * JD-Core Version:    0.7.0.1
 */