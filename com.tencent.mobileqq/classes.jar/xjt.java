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

public class xjt
  implements IEventReceiver, xiu, xjd, xjf
{
  protected ErrorMessage a;
  private ConcurrentHashMap<xix, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<xiz> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final wfc<xje> jdField_a_of_type_Wfc;
  private final xiv jdField_a_of_type_Xiv = new xiv();
  private xix jdField_a_of_type_Xix;
  private xjb jdField_a_of_type_Xjb;
  private xjw jdField_a_of_type_Xjw;
  private xjx jdField_a_of_type_Xjx;
  private xjy jdField_a_of_type_Xjy;
  protected boolean a;
  private ConcurrentHashMap<xix, Long> b = new ConcurrentHashMap();
  
  public xjt(xjb paramxjb)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    yqp.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramxjb);
    this.jdField_a_of_type_Xjb = paramxjb;
    this.jdField_a_of_type_Wfc = new wfc(new xju(this));
  }
  
  private int a(@Nullable xix paramxix)
  {
    int j;
    if (paramxix == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((xiy)localIterator.next()).jdField_a_of_type_Xix.equals(paramxix)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<xix> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    xiv localxiv = this.jdField_a_of_type_Xiv;
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
        if (paramInt1 >= this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            xiy localxiy = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
            if (localxiy.d()) {
              break label133;
            }
            localArrayList.add(localxiy.jdField_a_of_type_Xix);
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
  
  private xiy a(@Nullable xix paramxix)
  {
    int i = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.indexOf(new xiy(paramxix));
    if (i < 0) {
      return null;
    }
    return (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Xiv)
    {
      Iterator localIterator = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        xiy localxiy = (xiy)localIterator.next();
        if (localxiy.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localxiy.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            yqp.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localxiy });
            localxiy.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localxiy.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localxiy.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            yqp.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localxiy });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<xix> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      xix localxix = (xix)localIterator.next();
      xiy localxiy = a(localxix);
      if ((localxiy != null) && (!this.jdField_a_of_type_Xjb.a(localxiy)))
      {
        localIterator.remove();
        yqp.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localxiy);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localxix);
        if (this.b.containsKey(localxix))
        {
          yqp.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localxix);
          localIterator.remove();
        }
        else
        {
          this.b.put(localxix, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      yqp.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Wfc.a(this.jdField_a_of_type_Xjb.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable xix paramxix)
  {
    yqp.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramxix.toString());
    synchronized (this.jdField_a_of_type_Xiv)
    {
      int j = a(paramxix);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        yqp.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Xix = paramxix;
        this.jdField_a_of_type_Xjb.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable xix paramxix, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Xiv)
      {
        localObject = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramxix);
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
            this.jdField_a_of_type_Xix = paramxix;
            yqp.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Xjb.a(20, this);
            return;
          }
          c();
        }
      }
      paramxix = localArrayList.iterator();
      while (paramxix.hasNext())
      {
        localObject = (xiy)paramxix.next();
        if ((((xiy)localObject).d()) && (((xiy)localObject).e()))
        {
          yqp.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((xiy)localObject).e())
        {
          yqp.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((xiy)localObject).jdField_a_of_type_Xix);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xiy)localObject).jdField_a_of_type_Xix);
          a(localArrayList);
        }
        else
        {
          yqp.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((xiy)localObject).jdField_a_of_type_Xix);
          localArrayList = new ArrayList(1);
          localArrayList.add(((xiy)localObject).jdField_a_of_type_Xix);
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
  
  public xiv a(@Nullable xix paramxix, int paramInt)
  {
    boolean bool;
    long l;
    xiv localxiv2;
    if (paramInt >= 0)
    {
      bool = true;
      zkb.a(bool);
      l = System.currentTimeMillis();
      localxiv2 = new xiv();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      xiy localxiy;
      synchronized (this.jdField_a_of_type_Xiv)
      {
        m = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramxix != null) {
            localxiv2.jdField_a_of_type_JavaUtilList.add(new xiw(paramxix, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramxix)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localxiv2.jdField_a_of_type_Boolean = true;
            localxiv2.jdField_b_of_type_Boolean = true;
            yqp.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxix, Integer.valueOf(paramInt), localxiv2 });
            return localxiv2;
          }
          localxiv2.jdField_a_of_type_Boolean = true;
          localxiv2.jdField_b_of_type_Boolean = false;
          localxiv2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          yqp.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramxix, Integer.valueOf(paramInt), localxiv2 });
          return localxiv2;
        }
        i = a(paramxix);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localxiy = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(k);
          if (localxiy.d())
          {
            if (localxiy.jdField_a_of_type_JavaUtilList.size() > 0) {
              localxiv2.jdField_a_of_type_JavaUtilList.add(0, localxiy.a());
            }
            if (k != 0) {
              break label694;
            }
            localxiv2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localxiv2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxiy.jdField_a_of_type_Xix));
          localxiv2.jdField_a_of_type_Boolean = false;
        }
        localxiy = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
        if (!localxiy.d()) {
          break label515;
        }
        if (localxiy.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localxiv2.jdField_a_of_type_JavaUtilList.add(localxiy.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localxiy = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(j);
          if (!localxiy.d()) {
            break label556;
          }
          if (localxiy.jdField_a_of_type_JavaUtilList.size() > 0) {
            localxiv2.jdField_a_of_type_JavaUtilList.add(localxiy.a());
          }
          if (i != m) {
            break label732;
          }
          localxiv2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localxiv2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localxiv2.jdField_a_of_type_Boolean = true;
        }
      }
      localxiv2.jdField_a_of_type_JavaUtilList.add(new xiw(localxiy.jdField_a_of_type_Xix, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localxiv2.jdField_a_of_type_JavaUtilList.add(new xiw(localxiy.jdField_a_of_type_Xix, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxiy.jdField_a_of_type_Xix)));
      break label703;
      label556:
      localxiv2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localxiy.jdField_a_of_type_Xix));
      localxiv2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        yqp.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramxix, localxiv2 });
        yqp.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localxiv2;
        label633:
        localxiv2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localxiv2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public xja a()
  {
    xja localxja = this.jdField_a_of_type_Xjb.a();
    yqp.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localxja);
    return localxja;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Xjy = new xjy(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xjy);
    this.jdField_a_of_type_Xjw = new xjw(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xjw);
    this.jdField_a_of_type_Xjx = new xjx(this);
    wfo.a().registerSubscriber(this.jdField_a_of_type_Xjx);
    this.jdField_a_of_type_Xjb.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<xix> paramList)
  {
    yqp.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      xix localxix = (xix)paramList.next();
      Long localLong = (Long)this.b.remove(localxix);
      if (localLong != null) {
        yqp.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxix);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localxix, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<xix> paramList, boolean paramBoolean)
  {
    Object localObject;
    xix localxix;
    if (paramList == null)
    {
      localObject = "";
      yqp.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localxix = (xix)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xiv)
        {
          xiy localxiy = new xiy(localxix);
          if (this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.contains(localxiy)) {
            break label149;
          }
          this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.add(localxiy);
          yqp.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localxix);
        }
        localObject = paramList;
        break;
        label149:
        yqp.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localxix });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Xix != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (xix)paramList.get(0);; ??? = this.jdField_a_of_type_Xix)
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
      synchronized (this.jdField_a_of_type_Xiv)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          xiy localxiy = (xiy)localIterator1.next();
          if (localxiy.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localxiy.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            yqp.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localxiy.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.remove(localxiy);
            yqp.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localxiy.jdField_a_of_type_Xix });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localxiy, paramString, bool));
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
  
  public void a(List<xiy> arg1, boolean paramBoolean)
  {
    yqp.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    xiy localxiy;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localxiy = (xiy)localIterator1.next();
      localObject2 = (Long)this.b.remove(localxiy.jdField_a_of_type_Xix);
      if (localObject2 != null) {
        yqp.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localxiy.jdField_a_of_type_Xix);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localxiy = (xiy)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Xiv)
        {
          int i = this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.indexOf(localxiy);
          if (i < 0) {
            break label367;
          }
          localObject2 = (xiy)this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.get(i);
          if (((xiy)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((xiy)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((xiy)localObject2).jdField_a_of_type_JavaUtilList = localxiy.jdField_a_of_type_JavaUtilList;
            ((xiy)localObject2).jdField_a_of_type_JavaUtilMap = localxiy.jdField_a_of_type_JavaUtilMap;
            ((xiy)localObject2).jdField_a_of_type_JavaLangString = localxiy.jdField_a_of_type_JavaLangString;
            yqp.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localxiy.jdField_a_of_type_Xix);
          }
        }
        Iterator localIterator2 = localxiy.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((xiy)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((xiy)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((xiy)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            yqp.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((xiy)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localxiy.jdField_a_of_type_JavaUtilMap);
        ((xiy)localObject2).jdField_a_of_type_JavaLangString = localxiy.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        yqp.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localxiy.jdField_a_of_type_Xix });
      }
    }
    c();
  }
  
  public void a(@Nullable xix paramxix, int paramInt1, int paramInt2, String paramString)
  {
    yqp.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramxix, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramxix, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable xix paramxix, String paramString)
  {
    if (paramxix == null) {}
    for (Object localObject = "";; localObject = paramxix)
    {
      yqp.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramxix), 0);
      return;
    }
  }
  
  public void a(xiz paramxiz)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramxiz)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramxiz);
    }
  }
  
  public void b()
  {
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xjy);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xjw);
    wfo.a().unRegisterSubscriber(this.jdField_a_of_type_Xjx);
    this.jdField_a_of_type_Xjb.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<xiy> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      yqp.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        xiy localxiy = (xiy)paramList.next();
        Long localLong = (Long)this.b.remove(localxiy.jdField_a_of_type_Xix);
        if (localLong != null) {
          yqp.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localxiy.jdField_a_of_type_Xix);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (xiy)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Xiv)
          {
            if (!this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Xiv.jdField_a_of_type_JavaUtilList.add(localObject);
              yqp.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((xiy)localObject).jdField_a_of_type_Xix);
            }
          }
          yqp.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((xiy)localObject).jdField_a_of_type_Xix });
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
  
  public void b(xiz paramxiz)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramxiz);
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
 * Qualified Name:     xjt
 * JD-Core Version:    0.7.0.1
 */