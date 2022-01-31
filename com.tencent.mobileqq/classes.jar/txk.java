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

public class txk
  implements IEventReceiver, twl, twu, tww
{
  protected ErrorMessage a;
  private ConcurrentHashMap<two, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<twq> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final sss<twv> jdField_a_of_type_Sss;
  private final twm jdField_a_of_type_Twm = new twm();
  private two jdField_a_of_type_Two;
  private tws jdField_a_of_type_Tws;
  private txn jdField_a_of_type_Txn;
  private txo jdField_a_of_type_Txo;
  private txp jdField_a_of_type_Txp;
  protected boolean a;
  private ConcurrentHashMap<two, Long> b = new ConcurrentHashMap();
  
  public txk(tws paramtws)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    veg.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramtws);
    this.jdField_a_of_type_Tws = paramtws;
    this.jdField_a_of_type_Sss = new sss(new txl(this));
  }
  
  private int a(@Nullable two paramtwo)
  {
    int j;
    if (paramtwo == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((twp)localIterator.next()).jdField_a_of_type_Two.equals(paramtwo)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<two> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    twm localtwm = this.jdField_a_of_type_Twm;
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
        if (paramInt1 >= this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            twp localtwp = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
            if (localtwp.d()) {
              break label133;
            }
            localArrayList.add(localtwp.jdField_a_of_type_Two);
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
  
  private twp a(@Nullable two paramtwo)
  {
    int i = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.indexOf(new twp(paramtwo));
    if (i < 0) {
      return null;
    }
    return (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Twm)
    {
      Iterator localIterator = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        twp localtwp = (twp)localIterator.next();
        if (localtwp.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localtwp.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            veg.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localtwp });
            localtwp.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localtwp.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localtwp.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            veg.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localtwp });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<two> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      two localtwo = (two)localIterator.next();
      twp localtwp = a(localtwo);
      if ((localtwp != null) && (!this.jdField_a_of_type_Tws.a(localtwp)))
      {
        localIterator.remove();
        veg.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localtwp);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localtwo);
        if (this.b.containsKey(localtwo))
        {
          veg.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localtwo);
          localIterator.remove();
        }
        else
        {
          this.b.put(localtwo, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      veg.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Sss.a(this.jdField_a_of_type_Tws.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable two paramtwo)
  {
    veg.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramtwo.toString());
    synchronized (this.jdField_a_of_type_Twm)
    {
      int j = a(paramtwo);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        veg.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Two = paramtwo;
        this.jdField_a_of_type_Tws.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable two paramtwo, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Twm)
      {
        localObject = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramtwo);
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
            this.jdField_a_of_type_Two = paramtwo;
            veg.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Tws.a(20, this);
            return;
          }
          c();
        }
      }
      paramtwo = localArrayList.iterator();
      while (paramtwo.hasNext())
      {
        localObject = (twp)paramtwo.next();
        if ((((twp)localObject).d()) && (((twp)localObject).e()))
        {
          veg.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((twp)localObject).e())
        {
          veg.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((twp)localObject).jdField_a_of_type_Two);
          localArrayList = new ArrayList(1);
          localArrayList.add(((twp)localObject).jdField_a_of_type_Two);
          a(localArrayList);
        }
        else
        {
          veg.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((twp)localObject).jdField_a_of_type_Two);
          localArrayList = new ArrayList(1);
          localArrayList.add(((twp)localObject).jdField_a_of_type_Two);
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
  
  public twm a(@Nullable two paramtwo, int paramInt)
  {
    boolean bool;
    long l;
    twm localtwm2;
    if (paramInt >= 0)
    {
      bool = true;
      vxs.a(bool);
      l = System.currentTimeMillis();
      localtwm2 = new twm();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      twp localtwp;
      synchronized (this.jdField_a_of_type_Twm)
      {
        m = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramtwo != null) {
            localtwm2.jdField_a_of_type_JavaUtilList.add(new twn(paramtwo, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramtwo)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localtwm2.jdField_a_of_type_Boolean = true;
            localtwm2.jdField_b_of_type_Boolean = true;
            veg.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtwo, Integer.valueOf(paramInt), localtwm2 });
            return localtwm2;
          }
          localtwm2.jdField_a_of_type_Boolean = true;
          localtwm2.jdField_b_of_type_Boolean = false;
          localtwm2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          veg.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramtwo, Integer.valueOf(paramInt), localtwm2 });
          return localtwm2;
        }
        i = a(paramtwo);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localtwp = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(k);
          if (localtwp.d())
          {
            if (localtwp.jdField_a_of_type_JavaUtilList.size() > 0) {
              localtwm2.jdField_a_of_type_JavaUtilList.add(0, localtwp.a());
            }
            if (k != 0) {
              break label694;
            }
            localtwm2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localtwm2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwp.jdField_a_of_type_Two));
          localtwm2.jdField_a_of_type_Boolean = false;
        }
        localtwp = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
        if (!localtwp.d()) {
          break label515;
        }
        if (localtwp.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localtwm2.jdField_a_of_type_JavaUtilList.add(localtwp.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localtwp = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(j);
          if (!localtwp.d()) {
            break label556;
          }
          if (localtwp.jdField_a_of_type_JavaUtilList.size() > 0) {
            localtwm2.jdField_a_of_type_JavaUtilList.add(localtwp.a());
          }
          if (i != m) {
            break label732;
          }
          localtwm2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localtwm2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localtwm2.jdField_a_of_type_Boolean = true;
        }
      }
      localtwm2.jdField_a_of_type_JavaUtilList.add(new twn(localtwp.jdField_a_of_type_Two, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localtwm2.jdField_a_of_type_JavaUtilList.add(new twn(localtwp.jdField_a_of_type_Two, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwp.jdField_a_of_type_Two)));
      break label703;
      label556:
      localtwm2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localtwp.jdField_a_of_type_Two));
      localtwm2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        veg.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramtwo, localtwm2 });
        veg.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localtwm2;
        label633:
        localtwm2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localtwm2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public twr a()
  {
    twr localtwr = this.jdField_a_of_type_Tws.a();
    veg.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localtwr);
    return localtwr;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Txp = new txp(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Txp);
    this.jdField_a_of_type_Txn = new txn(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Txn);
    this.jdField_a_of_type_Txo = new txo(this);
    ste.a().registerSubscriber(this.jdField_a_of_type_Txo);
    this.jdField_a_of_type_Tws.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<two> paramList)
  {
    veg.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      two localtwo = (two)paramList.next();
      Long localLong = (Long)this.b.remove(localtwo);
      if (localLong != null) {
        veg.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtwo);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localtwo, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<two> paramList, boolean paramBoolean)
  {
    Object localObject;
    two localtwo;
    if (paramList == null)
    {
      localObject = "";
      veg.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localtwo = (two)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Twm)
        {
          twp localtwp = new twp(localtwo);
          if (this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.contains(localtwp)) {
            break label149;
          }
          this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.add(localtwp);
          veg.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localtwo);
        }
        localObject = paramList;
        break;
        label149:
        veg.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localtwo });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Two != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (two)paramList.get(0);; ??? = this.jdField_a_of_type_Two)
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
      synchronized (this.jdField_a_of_type_Twm)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          twp localtwp = (twp)localIterator1.next();
          if (localtwp.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localtwp.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            veg.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localtwp.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.remove(localtwp);
            veg.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localtwp.jdField_a_of_type_Two });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localtwp, paramString, bool));
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
  
  public void a(List<twp> arg1, boolean paramBoolean)
  {
    veg.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    twp localtwp;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localtwp = (twp)localIterator1.next();
      localObject2 = (Long)this.b.remove(localtwp.jdField_a_of_type_Two);
      if (localObject2 != null) {
        veg.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localtwp.jdField_a_of_type_Two);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localtwp = (twp)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Twm)
        {
          int i = this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.indexOf(localtwp);
          if (i < 0) {
            break label367;
          }
          localObject2 = (twp)this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.get(i);
          if (((twp)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((twp)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((twp)localObject2).jdField_a_of_type_JavaUtilList = localtwp.jdField_a_of_type_JavaUtilList;
            ((twp)localObject2).jdField_a_of_type_JavaUtilMap = localtwp.jdField_a_of_type_JavaUtilMap;
            ((twp)localObject2).jdField_a_of_type_JavaLangString = localtwp.jdField_a_of_type_JavaLangString;
            veg.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localtwp.jdField_a_of_type_Two);
          }
        }
        Iterator localIterator2 = localtwp.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((twp)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((twp)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((twp)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            veg.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((twp)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localtwp.jdField_a_of_type_JavaUtilMap);
        ((twp)localObject2).jdField_a_of_type_JavaLangString = localtwp.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        veg.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localtwp.jdField_a_of_type_Two });
      }
    }
    c();
  }
  
  public void a(@Nullable two paramtwo, int paramInt1, int paramInt2, String paramString)
  {
    veg.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramtwo, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramtwo, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable two paramtwo, String paramString)
  {
    if (paramtwo == null) {}
    for (Object localObject = "";; localObject = paramtwo)
    {
      veg.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramtwo), 0);
      return;
    }
  }
  
  public void a(twq paramtwq)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramtwq)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramtwq);
    }
  }
  
  public void b()
  {
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Txp);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Txn);
    ste.a().unRegisterSubscriber(this.jdField_a_of_type_Txo);
    this.jdField_a_of_type_Tws.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<twp> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      veg.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        twp localtwp = (twp)paramList.next();
        Long localLong = (Long)this.b.remove(localtwp.jdField_a_of_type_Two);
        if (localLong != null) {
          veg.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localtwp.jdField_a_of_type_Two);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (twp)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Twm)
          {
            if (!this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Twm.jdField_a_of_type_JavaUtilList.add(localObject);
              veg.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((twp)localObject).jdField_a_of_type_Two);
            }
          }
          veg.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((twp)localObject).jdField_a_of_type_Two });
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
  
  public void b(twq paramtwq)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramtwq);
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
 * Qualified Name:     txk
 * JD-Core Version:    0.7.0.1
 */