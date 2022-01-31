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

public class txh
  implements IEventReceiver, twi, twr, twt
{
  protected ErrorMessage a;
  private ConcurrentHashMap<twl, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<twn> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final ssp<tws> jdField_a_of_type_Ssp;
  private final twj jdField_a_of_type_Twj = new twj();
  private twl jdField_a_of_type_Twl;
  private twp jdField_a_of_type_Twp;
  private txk jdField_a_of_type_Txk;
  private txl jdField_a_of_type_Txl;
  private txm jdField_a_of_type_Txm;
  protected boolean a;
  private ConcurrentHashMap<twl, Long> b = new ConcurrentHashMap();
  
  public txh(twp paramtwp)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    ved.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramtwp);
    this.jdField_a_of_type_Twp = paramtwp;
    this.jdField_a_of_type_Ssp = new ssp(new txi(this));
  }
  
  private int a(@Nullable twl paramtwl)
  {
    int j;
    if (paramtwl == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((twm)localIterator.next()).jdField_a_of_type_Twl.equals(paramtwl)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<twl> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    twj localtwj = this.jdField_a_of_type_Twj;
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
        if (paramInt1 >= this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            twm localtwm = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
            if (localtwm.d()) {
              break label133;
            }
            localArrayList.add(localtwm.jdField_a_of_type_Twl);
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
  
  private twm a(@Nullable twl paramtwl)
  {
    int i = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.indexOf(new twm(paramtwl));
    if (i < 0) {
      return null;
    }
    return (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Twj)
    {
      Iterator localIterator = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        twm localtwm = (twm)localIterator.next();
        if (localtwm.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localtwm.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            ved.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localtwm });
            localtwm.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localtwm.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localtwm.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            ved.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localtwm });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<twl> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      twl localtwl = (twl)localIterator.next();
      twm localtwm = a(localtwl);
      if ((localtwm != null) && (!this.jdField_a_of_type_Twp.a(localtwm)))
      {
        localIterator.remove();
        ved.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localtwm);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localtwl);
        if (this.b.containsKey(localtwl))
        {
          ved.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localtwl);
          localIterator.remove();
        }
        else
        {
          this.b.put(localtwl, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      ved.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Ssp.a(this.jdField_a_of_type_Twp.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable twl paramtwl)
  {
    ved.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramtwl.toString());
    synchronized (this.jdField_a_of_type_Twj)
    {
      int j = a(paramtwl);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        ved.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Twl = paramtwl;
        this.jdField_a_of_type_Twp.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable twl paramtwl, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Twj)
      {
        localObject = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramtwl);
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
            this.jdField_a_of_type_Twl = paramtwl;
            ved.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Twp.a(20, this);
            return;
          }
          c();
        }
      }
      paramtwl = localArrayList.iterator();
      while (paramtwl.hasNext())
      {
        localObject = (twm)paramtwl.next();
        if ((((twm)localObject).d()) && (((twm)localObject).e()))
        {
          ved.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((twm)localObject).e())
        {
          ved.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((twm)localObject).jdField_a_of_type_Twl);
          localArrayList = new ArrayList(1);
          localArrayList.add(((twm)localObject).jdField_a_of_type_Twl);
          a(localArrayList);
        }
        else
        {
          ved.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((twm)localObject).jdField_a_of_type_Twl);
          localArrayList = new ArrayList(1);
          localArrayList.add(((twm)localObject).jdField_a_of_type_Twl);
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
  
  public twj a(@Nullable twl paramtwl, int paramInt)
  {
    boolean bool;
    long l;
    twj localtwj2;
    if (paramInt >= 0)
    {
      bool = true;
      vxp.a(bool);
      l = System.currentTimeMillis();
      localtwj2 = new twj();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      twm localtwm;
      synchronized (this.jdField_a_of_type_Twj)
      {
        m = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramtwl != null) {
            localtwj2.jdField_a_of_type_JavaUtilList.add(new twk(paramtwl, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramtwl)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localtwj2.jdField_a_of_type_Boolean = true;
            localtwj2.jdField_b_of_type_Boolean = true;
            ved.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtwl, Integer.valueOf(paramInt), localtwj2 });
            return localtwj2;
          }
          localtwj2.jdField_a_of_type_Boolean = true;
          localtwj2.jdField_b_of_type_Boolean = false;
          localtwj2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          ved.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtwl, Integer.valueOf(paramInt), localtwj2 });
          return localtwj2;
        }
        i = a(paramtwl);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localtwm = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(k);
          if (localtwm.d())
          {
            if (localtwm.jdField_a_of_type_JavaUtilList.size() > 0) {
              localtwj2.jdField_a_of_type_JavaUtilList.add(0, localtwm.a());
            }
            if (k != 0) {
              break label694;
            }
            localtwj2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localtwj2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwm.jdField_a_of_type_Twl));
          localtwj2.jdField_a_of_type_Boolean = false;
        }
        localtwm = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
        if (!localtwm.d()) {
          break label515;
        }
        if (localtwm.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localtwj2.jdField_a_of_type_JavaUtilList.add(localtwm.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localtwm = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(j);
          if (!localtwm.d()) {
            break label556;
          }
          if (localtwm.jdField_a_of_type_JavaUtilList.size() > 0) {
            localtwj2.jdField_a_of_type_JavaUtilList.add(localtwm.a());
          }
          if (i != m) {
            break label732;
          }
          localtwj2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localtwj2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localtwj2.jdField_a_of_type_Boolean = true;
        }
      }
      localtwj2.jdField_a_of_type_JavaUtilList.add(new twk(localtwm.jdField_a_of_type_Twl, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localtwj2.jdField_a_of_type_JavaUtilList.add(new twk(localtwm.jdField_a_of_type_Twl, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwm.jdField_a_of_type_Twl)));
      break label703;
      label556:
      localtwj2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwm.jdField_a_of_type_Twl));
      localtwj2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        ved.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramtwl, localtwj2 });
        ved.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localtwj2;
        label633:
        localtwj2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localtwj2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public two a()
  {
    two localtwo = this.jdField_a_of_type_Twp.a();
    ved.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localtwo);
    return localtwo;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Txm = new txm(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Txm);
    this.jdField_a_of_type_Txk = new txk(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Txk);
    this.jdField_a_of_type_Txl = new txl(this);
    stb.a().registerSubscriber(this.jdField_a_of_type_Txl);
    this.jdField_a_of_type_Twp.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<twl> paramList)
  {
    ved.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      twl localtwl = (twl)paramList.next();
      Long localLong = (Long)this.b.remove(localtwl);
      if (localLong != null) {
        ved.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtwl);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localtwl, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<twl> paramList, boolean paramBoolean)
  {
    Object localObject;
    twl localtwl;
    if (paramList == null)
    {
      localObject = "";
      ved.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localtwl = (twl)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Twj)
        {
          twm localtwm = new twm(localtwl);
          if (this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.contains(localtwm)) {
            break label149;
          }
          this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.add(localtwm);
          ved.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localtwl);
        }
        localObject = paramList;
        break;
        label149:
        ved.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localtwl });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Twl != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (twl)paramList.get(0);; ??? = this.jdField_a_of_type_Twl)
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
      synchronized (this.jdField_a_of_type_Twj)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          twm localtwm = (twm)localIterator1.next();
          if (localtwm.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localtwm.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            ved.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localtwm.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.remove(localtwm);
            ved.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localtwm.jdField_a_of_type_Twl });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localtwm, paramString, bool));
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
  
  public void a(List<twm> arg1, boolean paramBoolean)
  {
    ved.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    twm localtwm;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localtwm = (twm)localIterator1.next();
      localObject2 = (Long)this.b.remove(localtwm.jdField_a_of_type_Twl);
      if (localObject2 != null) {
        ved.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localtwm.jdField_a_of_type_Twl);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localtwm = (twm)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Twj)
        {
          int i = this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.indexOf(localtwm);
          if (i < 0) {
            break label367;
          }
          localObject2 = (twm)this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.get(i);
          if (((twm)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((twm)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((twm)localObject2).jdField_a_of_type_JavaUtilList = localtwm.jdField_a_of_type_JavaUtilList;
            ((twm)localObject2).jdField_a_of_type_JavaUtilMap = localtwm.jdField_a_of_type_JavaUtilMap;
            ((twm)localObject2).jdField_a_of_type_JavaLangString = localtwm.jdField_a_of_type_JavaLangString;
            ved.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localtwm.jdField_a_of_type_Twl);
          }
        }
        Iterator localIterator2 = localtwm.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((twm)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((twm)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((twm)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            ved.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((twm)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localtwm.jdField_a_of_type_JavaUtilMap);
        ((twm)localObject2).jdField_a_of_type_JavaLangString = localtwm.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        ved.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localtwm.jdField_a_of_type_Twl });
      }
    }
    c();
  }
  
  public void a(@Nullable twl paramtwl, int paramInt1, int paramInt2, String paramString)
  {
    ved.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramtwl, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramtwl, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable twl paramtwl, String paramString)
  {
    if (paramtwl == null) {}
    for (Object localObject = "";; localObject = paramtwl)
    {
      ved.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramtwl), 0);
      return;
    }
  }
  
  public void a(twn paramtwn)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramtwn)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramtwn);
    }
  }
  
  public void b()
  {
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Txm);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Txk);
    stb.a().unRegisterSubscriber(this.jdField_a_of_type_Txl);
    this.jdField_a_of_type_Twp.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<twm> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      ved.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        twm localtwm = (twm)paramList.next();
        Long localLong = (Long)this.b.remove(localtwm.jdField_a_of_type_Twl);
        if (localLong != null) {
          ved.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtwm.jdField_a_of_type_Twl);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (twm)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Twj)
          {
            if (!this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Twj.jdField_a_of_type_JavaUtilList.add(localObject);
              ved.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((twm)localObject).jdField_a_of_type_Twl);
            }
          }
          ved.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((twm)localObject).jdField_a_of_type_Twl });
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
  
  public void b(twn paramtwn)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramtwn);
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
 * Qualified Name:     txh
 * JD-Core Version:    0.7.0.1
 */