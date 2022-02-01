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

public class woz
  implements IEventReceiver, woa, woj, wol
{
  protected ErrorMessage a;
  private ConcurrentHashMap<wod, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<wof> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final vkw<wok> jdField_a_of_type_Vkw;
  private final wob jdField_a_of_type_Wob = new wob();
  private wod jdField_a_of_type_Wod;
  private woh jdField_a_of_type_Woh;
  private wpc jdField_a_of_type_Wpc;
  private wpd jdField_a_of_type_Wpd;
  private wpe jdField_a_of_type_Wpe;
  protected boolean a;
  private ConcurrentHashMap<wod, Long> b = new ConcurrentHashMap();
  
  public woz(woh paramwoh)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    xvv.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramwoh);
    this.jdField_a_of_type_Woh = paramwoh;
    this.jdField_a_of_type_Vkw = new vkw(new wpa(this));
  }
  
  private int a(@Nullable wod paramwod)
  {
    int j;
    if (paramwod == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((woe)localIterator.next()).jdField_a_of_type_Wod.equals(paramwod)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<wod> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    wob localwob = this.jdField_a_of_type_Wob;
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
        if (paramInt1 >= this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            woe localwoe = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
            if (localwoe.d()) {
              break label133;
            }
            localArrayList.add(localwoe.jdField_a_of_type_Wod);
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
  
  private woe a(@Nullable wod paramwod)
  {
    int i = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.indexOf(new woe(paramwod));
    if (i < 0) {
      return null;
    }
    return (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Wob)
    {
      Iterator localIterator = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        woe localwoe = (woe)localIterator.next();
        if (localwoe.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localwoe.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            xvv.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localwoe });
            localwoe.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localwoe.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localwoe.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            xvv.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localwoe });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<wod> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      wod localwod = (wod)localIterator.next();
      woe localwoe = a(localwod);
      if ((localwoe != null) && (!this.jdField_a_of_type_Woh.a(localwoe)))
      {
        localIterator.remove();
        xvv.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localwoe);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localwod);
        if (this.b.containsKey(localwod))
        {
          xvv.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localwod);
          localIterator.remove();
        }
        else
        {
          this.b.put(localwod, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      xvv.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Vkw.a(this.jdField_a_of_type_Woh.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable wod paramwod)
  {
    xvv.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramwod.toString());
    synchronized (this.jdField_a_of_type_Wob)
    {
      int j = a(paramwod);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        xvv.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Wod = paramwod;
        this.jdField_a_of_type_Woh.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable wod paramwod, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Wob)
      {
        localObject = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramwod);
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
            this.jdField_a_of_type_Wod = paramwod;
            xvv.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Woh.a(20, this);
            return;
          }
          c();
        }
      }
      paramwod = localArrayList.iterator();
      while (paramwod.hasNext())
      {
        localObject = (woe)paramwod.next();
        if ((((woe)localObject).d()) && (((woe)localObject).e()))
        {
          xvv.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((woe)localObject).e())
        {
          xvv.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((woe)localObject).jdField_a_of_type_Wod);
          localArrayList = new ArrayList(1);
          localArrayList.add(((woe)localObject).jdField_a_of_type_Wod);
          a(localArrayList);
        }
        else
        {
          xvv.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((woe)localObject).jdField_a_of_type_Wod);
          localArrayList = new ArrayList(1);
          localArrayList.add(((woe)localObject).jdField_a_of_type_Wod);
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
  
  public wob a(@Nullable wod paramwod, int paramInt)
  {
    boolean bool;
    long l;
    wob localwob2;
    if (paramInt >= 0)
    {
      bool = true;
      yos.a(bool);
      l = System.currentTimeMillis();
      localwob2 = new wob();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      woe localwoe;
      synchronized (this.jdField_a_of_type_Wob)
      {
        m = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramwod != null) {
            localwob2.jdField_a_of_type_JavaUtilList.add(new woc(paramwod, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramwod)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localwob2.jdField_a_of_type_Boolean = true;
            localwob2.jdField_b_of_type_Boolean = true;
            xvv.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramwod, Integer.valueOf(paramInt), localwob2 });
            return localwob2;
          }
          localwob2.jdField_a_of_type_Boolean = true;
          localwob2.jdField_b_of_type_Boolean = false;
          localwob2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          xvv.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramwod, Integer.valueOf(paramInt), localwob2 });
          return localwob2;
        }
        i = a(paramwod);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localwoe = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(k);
          if (localwoe.d())
          {
            if (localwoe.jdField_a_of_type_JavaUtilList.size() > 0) {
              localwob2.jdField_a_of_type_JavaUtilList.add(0, localwoe.a());
            }
            if (k != 0) {
              break label694;
            }
            localwob2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localwob2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localwoe.jdField_a_of_type_Wod));
          localwob2.jdField_a_of_type_Boolean = false;
        }
        localwoe = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
        if (!localwoe.d()) {
          break label515;
        }
        if (localwoe.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localwob2.jdField_a_of_type_JavaUtilList.add(localwoe.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localwoe = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(j);
          if (!localwoe.d()) {
            break label556;
          }
          if (localwoe.jdField_a_of_type_JavaUtilList.size() > 0) {
            localwob2.jdField_a_of_type_JavaUtilList.add(localwoe.a());
          }
          if (i != m) {
            break label732;
          }
          localwob2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localwob2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localwob2.jdField_a_of_type_Boolean = true;
        }
      }
      localwob2.jdField_a_of_type_JavaUtilList.add(new woc(localwoe.jdField_a_of_type_Wod, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localwob2.jdField_a_of_type_JavaUtilList.add(new woc(localwoe.jdField_a_of_type_Wod, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localwoe.jdField_a_of_type_Wod)));
      break label703;
      label556:
      localwob2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localwoe.jdField_a_of_type_Wod));
      localwob2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        xvv.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramwod, localwob2 });
        xvv.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localwob2;
        label633:
        localwob2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localwob2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public wog a()
  {
    wog localwog = this.jdField_a_of_type_Woh.a();
    xvv.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localwog);
    return localwog;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Wpe = new wpe(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wpe);
    this.jdField_a_of_type_Wpc = new wpc(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wpc);
    this.jdField_a_of_type_Wpd = new wpd(this);
    vli.a().registerSubscriber(this.jdField_a_of_type_Wpd);
    this.jdField_a_of_type_Woh.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<wod> paramList)
  {
    xvv.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      wod localwod = (wod)paramList.next();
      Long localLong = (Long)this.b.remove(localwod);
      if (localLong != null) {
        xvv.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localwod);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localwod, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<wod> paramList, boolean paramBoolean)
  {
    Object localObject;
    wod localwod;
    if (paramList == null)
    {
      localObject = "";
      xvv.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localwod = (wod)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Wob)
        {
          woe localwoe = new woe(localwod);
          if (this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.contains(localwoe)) {
            break label149;
          }
          this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.add(localwoe);
          xvv.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localwod);
        }
        localObject = paramList;
        break;
        label149:
        xvv.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localwod });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Wod != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (wod)paramList.get(0);; ??? = this.jdField_a_of_type_Wod)
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
      synchronized (this.jdField_a_of_type_Wob)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          woe localwoe = (woe)localIterator1.next();
          if (localwoe.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localwoe.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            xvv.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localwoe.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.remove(localwoe);
            xvv.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localwoe.jdField_a_of_type_Wod });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localwoe, paramString, bool));
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
  
  public void a(List<woe> arg1, boolean paramBoolean)
  {
    xvv.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    woe localwoe;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localwoe = (woe)localIterator1.next();
      localObject2 = (Long)this.b.remove(localwoe.jdField_a_of_type_Wod);
      if (localObject2 != null) {
        xvv.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localwoe.jdField_a_of_type_Wod);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localwoe = (woe)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Wob)
        {
          int i = this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.indexOf(localwoe);
          if (i < 0) {
            break label367;
          }
          localObject2 = (woe)this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.get(i);
          if (((woe)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((woe)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((woe)localObject2).jdField_a_of_type_JavaUtilList = localwoe.jdField_a_of_type_JavaUtilList;
            ((woe)localObject2).jdField_a_of_type_JavaUtilMap = localwoe.jdField_a_of_type_JavaUtilMap;
            ((woe)localObject2).jdField_a_of_type_JavaLangString = localwoe.jdField_a_of_type_JavaLangString;
            xvv.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localwoe.jdField_a_of_type_Wod);
          }
        }
        Iterator localIterator2 = localwoe.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((woe)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((woe)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((woe)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            xvv.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((woe)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localwoe.jdField_a_of_type_JavaUtilMap);
        ((woe)localObject2).jdField_a_of_type_JavaLangString = localwoe.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        xvv.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localwoe.jdField_a_of_type_Wod });
      }
    }
    c();
  }
  
  public void a(@Nullable wod paramwod, int paramInt1, int paramInt2, String paramString)
  {
    xvv.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramwod, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramwod, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable wod paramwod, String paramString)
  {
    if (paramwod == null) {}
    for (Object localObject = "";; localObject = paramwod)
    {
      xvv.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramwod), 0);
      return;
    }
  }
  
  public void a(wof paramwof)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramwof)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramwof);
    }
  }
  
  public void b()
  {
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wpe);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wpc);
    vli.a().unRegisterSubscriber(this.jdField_a_of_type_Wpd);
    this.jdField_a_of_type_Woh.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<woe> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      xvv.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        woe localwoe = (woe)paramList.next();
        Long localLong = (Long)this.b.remove(localwoe.jdField_a_of_type_Wod);
        if (localLong != null) {
          xvv.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localwoe.jdField_a_of_type_Wod);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (woe)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Wob)
          {
            if (!this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Wob.jdField_a_of_type_JavaUtilList.add(localObject);
              xvv.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((woe)localObject).jdField_a_of_type_Wod);
            }
          }
          xvv.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((woe)localObject).jdField_a_of_type_Wod });
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
  
  public void b(wof paramwof)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramwof);
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
 * Qualified Name:     woz
 * JD-Core Version:    0.7.0.1
 */