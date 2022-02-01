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

public class xno
  implements IEventReceiver, xmp, xmy, xna
{
  protected ErrorMessage a;
  private ConcurrentHashMap<xms, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<xmu> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final wix<xmz> jdField_a_of_type_Wix;
  private final xmq jdField_a_of_type_Xmq = new xmq();
  private xms jdField_a_of_type_Xms;
  private xmw jdField_a_of_type_Xmw;
  private xnr jdField_a_of_type_Xnr;
  private xns jdField_a_of_type_Xns;
  private xnt jdField_a_of_type_Xnt;
  protected boolean a;
  private ConcurrentHashMap<xms, Long> b = new ConcurrentHashMap();
  
  public xno(xmw paramxmw)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    yuk.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramxmw);
    this.jdField_a_of_type_Xmw = paramxmw;
    this.jdField_a_of_type_Wix = new wix(new xnp(this));
  }
  
  private int a(@Nullable xms paramxms)
  {
    int j;
    if (paramxms == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((xmt)localIterator.next()).jdField_a_of_type_Xms.equals(paramxms)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<xms> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    xmq localxmq = this.jdField_a_of_type_Xmq;
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
        if (paramInt1 >= this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            xmt localxmt = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
            if (localxmt.d()) {
              break label133;
            }
            localArrayList.add(localxmt.jdField_a_of_type_Xms);
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
  
  private xmt a(@Nullable xms paramxms)
  {
    int i = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.indexOf(new xmt(paramxms));
    if (i < 0) {
      return null;
    }
    return (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Xmq)
    {
      Iterator localIterator = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        xmt localxmt = (xmt)localIterator.next();
        if (localxmt.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localxmt.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            yuk.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localxmt });
            localxmt.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localxmt.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localxmt.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            yuk.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localxmt });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<xms> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xms localxms = (xms)localIterator.next();
      xmt localxmt = a(localxms);
      if ((localxmt != null) && (!this.jdField_a_of_type_Xmw.a(localxmt)))
      {
        localIterator.remove();
        yuk.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localxmt);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localxms);
        if (this.b.containsKey(localxms))
        {
          yuk.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localxms);
          localIterator.remove();
        }
        else
        {
          this.b.put(localxms, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      yuk.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Wix.a(this.jdField_a_of_type_Xmw.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable xms paramxms)
  {
    yuk.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramxms.toString());
    synchronized (this.jdField_a_of_type_Xmq)
    {
      int j = a(paramxms);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        yuk.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Xms = paramxms;
        this.jdField_a_of_type_Xmw.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable xms paramxms, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Xmq)
      {
        localObject = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramxms);
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
            this.jdField_a_of_type_Xms = paramxms;
            yuk.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Xmw.a(20, this);
            return;
          }
          c();
        }
      }
      paramxms = localArrayList.iterator();
      while (paramxms.hasNext())
      {
        localObject = (xmt)paramxms.next();
        if ((((xmt)localObject).d()) && (((xmt)localObject).e()))
        {
          yuk.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((xmt)localObject).e())
        {
          yuk.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((xmt)localObject).jdField_a_of_type_Xms);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xmt)localObject).jdField_a_of_type_Xms);
          a(localArrayList);
        }
        else
        {
          yuk.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((xmt)localObject).jdField_a_of_type_Xms);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xmt)localObject).jdField_a_of_type_Xms);
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
  
  public xmq a(@Nullable xms paramxms, int paramInt)
  {
    boolean bool;
    long l;
    xmq localxmq2;
    if (paramInt >= 0)
    {
      bool = true;
      znw.a(bool);
      l = System.currentTimeMillis();
      localxmq2 = new xmq();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      xmt localxmt;
      synchronized (this.jdField_a_of_type_Xmq)
      {
        m = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramxms != null) {
            localxmq2.jdField_a_of_type_JavaUtilList.add(new xmr(paramxms, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxms)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localxmq2.jdField_a_of_type_Boolean = true;
            localxmq2.jdField_b_of_type_Boolean = true;
            yuk.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxms, Integer.valueOf(paramInt), localxmq2 });
            return localxmq2;
          }
          localxmq2.jdField_a_of_type_Boolean = true;
          localxmq2.jdField_b_of_type_Boolean = false;
          localxmq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          yuk.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxms, Integer.valueOf(paramInt), localxmq2 });
          return localxmq2;
        }
        i = a(paramxms);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localxmt = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(k);
          if (localxmt.d())
          {
            if (localxmt.jdField_a_of_type_JavaUtilList.size() > 0) {
              localxmq2.jdField_a_of_type_JavaUtilList.add(0, localxmt.a());
            }
            if (k != 0) {
              break label694;
            }
            localxmq2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localxmq2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxmt.jdField_a_of_type_Xms));
          localxmq2.jdField_a_of_type_Boolean = false;
        }
        localxmt = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
        if (!localxmt.d()) {
          break label515;
        }
        if (localxmt.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localxmq2.jdField_a_of_type_JavaUtilList.add(localxmt.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localxmt = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(j);
          if (!localxmt.d()) {
            break label556;
          }
          if (localxmt.jdField_a_of_type_JavaUtilList.size() > 0) {
            localxmq2.jdField_a_of_type_JavaUtilList.add(localxmt.a());
          }
          if (i != m) {
            break label732;
          }
          localxmq2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localxmq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localxmq2.jdField_a_of_type_Boolean = true;
        }
      }
      localxmq2.jdField_a_of_type_JavaUtilList.add(new xmr(localxmt.jdField_a_of_type_Xms, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localxmq2.jdField_a_of_type_JavaUtilList.add(new xmr(localxmt.jdField_a_of_type_Xms, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxmt.jdField_a_of_type_Xms)));
      break label703;
      label556:
      localxmq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxmt.jdField_a_of_type_Xms));
      localxmq2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        yuk.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramxms, localxmq2 });
        yuk.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localxmq2;
        label633:
        localxmq2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localxmq2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public xmv a()
  {
    xmv localxmv = this.jdField_a_of_type_Xmw.a();
    yuk.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localxmv);
    return localxmv;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xnt = new xnt(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xnt);
    this.jdField_a_of_type_Xnr = new xnr(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xnr);
    this.jdField_a_of_type_Xns = new xns(this);
    wjj.a().registerSubscriber(this.jdField_a_of_type_Xns);
    this.jdField_a_of_type_Xmw.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<xms> paramList)
  {
    yuk.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xms localxms = (xms)paramList.next();
      Long localLong = (Long)this.b.remove(localxms);
      if (localLong != null) {
        yuk.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxms);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localxms, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<xms> paramList, boolean paramBoolean)
  {
    Object localObject;
    xms localxms;
    if (paramList == null)
    {
      localObject = "";
      yuk.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localxms = (xms)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xmq)
        {
          xmt localxmt = new xmt(localxms);
          if (this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.contains(localxmt)) {
            break label149;
          }
          this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.add(localxmt);
          yuk.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localxms);
        }
        localObject = paramList;
        break;
        label149:
        yuk.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localxms });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Xms != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (xms)paramList.get(0);; ??? = this.jdField_a_of_type_Xms)
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
      synchronized (this.jdField_a_of_type_Xmq)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          xmt localxmt = (xmt)localIterator1.next();
          if (localxmt.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localxmt.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            yuk.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localxmt.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.remove(localxmt);
            yuk.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localxmt.jdField_a_of_type_Xms });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localxmt, paramString, bool));
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
  
  public void a(List<xmt> arg1, boolean paramBoolean)
  {
    yuk.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    xmt localxmt;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localxmt = (xmt)localIterator1.next();
      localObject2 = (Long)this.b.remove(localxmt.jdField_a_of_type_Xms);
      if (localObject2 != null) {
        yuk.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localxmt.jdField_a_of_type_Xms);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localxmt = (xmt)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xmq)
        {
          int i = this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.indexOf(localxmt);
          if (i < 0) {
            break label367;
          }
          localObject2 = (xmt)this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.get(i);
          if (((xmt)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((xmt)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((xmt)localObject2).jdField_a_of_type_JavaUtilList = localxmt.jdField_a_of_type_JavaUtilList;
            ((xmt)localObject2).jdField_a_of_type_JavaUtilMap = localxmt.jdField_a_of_type_JavaUtilMap;
            ((xmt)localObject2).jdField_a_of_type_JavaLangString = localxmt.jdField_a_of_type_JavaLangString;
            yuk.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localxmt.jdField_a_of_type_Xms);
          }
        }
        Iterator localIterator2 = localxmt.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((xmt)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((xmt)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((xmt)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            yuk.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((xmt)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localxmt.jdField_a_of_type_JavaUtilMap);
        ((xmt)localObject2).jdField_a_of_type_JavaLangString = localxmt.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        yuk.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localxmt.jdField_a_of_type_Xms });
      }
    }
    c();
  }
  
  public void a(@Nullable xms paramxms, int paramInt1, int paramInt2, String paramString)
  {
    yuk.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramxms, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramxms, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable xms paramxms, String paramString)
  {
    if (paramxms == null) {}
    for (Object localObject = "";; localObject = paramxms)
    {
      yuk.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramxms), 0);
      return;
    }
  }
  
  public void a(xmu paramxmu)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramxmu)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramxmu);
    }
  }
  
  public void b()
  {
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xnt);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xnr);
    wjj.a().unRegisterSubscriber(this.jdField_a_of_type_Xns);
    this.jdField_a_of_type_Xmw.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<xmt> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      yuk.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        xmt localxmt = (xmt)paramList.next();
        Long localLong = (Long)this.b.remove(localxmt.jdField_a_of_type_Xms);
        if (localLong != null) {
          yuk.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxmt.jdField_a_of_type_Xms);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (xmt)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Xmq)
          {
            if (!this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Xmq.jdField_a_of_type_JavaUtilList.add(localObject);
              yuk.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((xmt)localObject).jdField_a_of_type_Xms);
            }
          }
          yuk.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((xmt)localObject).jdField_a_of_type_Xms });
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
  
  public void b(xmu paramxmu)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramxmu);
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
 * Qualified Name:     xno
 * JD-Core Version:    0.7.0.1
 */