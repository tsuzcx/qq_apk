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

public class vlz
  implements IEventReceiver, vla, vlj, vll
{
  protected ErrorMessage a;
  private ConcurrentHashMap<vld, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<vlf> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final uhh<vlk> jdField_a_of_type_Uhh;
  private final vlb jdField_a_of_type_Vlb = new vlb();
  private vld jdField_a_of_type_Vld;
  private vlh jdField_a_of_type_Vlh;
  private vmc jdField_a_of_type_Vmc;
  private vmd jdField_a_of_type_Vmd;
  private vme jdField_a_of_type_Vme;
  protected boolean a;
  private ConcurrentHashMap<vld, Long> b = new ConcurrentHashMap();
  
  public vlz(vlh paramvlh)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    wsv.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramvlh);
    this.jdField_a_of_type_Vlh = paramvlh;
    this.jdField_a_of_type_Uhh = new uhh(new vma(this));
  }
  
  private int a(@Nullable vld paramvld)
  {
    int j;
    if (paramvld == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((vle)localIterator.next()).jdField_a_of_type_Vld.equals(paramvld)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<vld> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    vlb localvlb = this.jdField_a_of_type_Vlb;
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
        if (paramInt1 >= this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            vle localvle = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
            if (localvle.d()) {
              break label133;
            }
            localArrayList.add(localvle.jdField_a_of_type_Vld);
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
  
  private vle a(@Nullable vld paramvld)
  {
    int i = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.indexOf(new vle(paramvld));
    if (i < 0) {
      return null;
    }
    return (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Vlb)
    {
      Iterator localIterator = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        vle localvle = (vle)localIterator.next();
        if (localvle.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localvle.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            wsv.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localvle });
            localvle.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localvle.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localvle.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            wsv.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localvle });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<vld> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vld localvld = (vld)localIterator.next();
      vle localvle = a(localvld);
      if ((localvle != null) && (!this.jdField_a_of_type_Vlh.a(localvle)))
      {
        localIterator.remove();
        wsv.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localvle);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localvld);
        if (this.b.containsKey(localvld))
        {
          wsv.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localvld);
          localIterator.remove();
        }
        else
        {
          this.b.put(localvld, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      wsv.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Uhh.a(this.jdField_a_of_type_Vlh.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable vld paramvld)
  {
    wsv.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramvld.toString());
    synchronized (this.jdField_a_of_type_Vlb)
    {
      int j = a(paramvld);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        wsv.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Vld = paramvld;
        this.jdField_a_of_type_Vlh.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable vld paramvld, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Vlb)
      {
        localObject = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramvld);
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
            this.jdField_a_of_type_Vld = paramvld;
            wsv.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Vlh.a(20, this);
            return;
          }
          c();
        }
      }
      paramvld = localArrayList.iterator();
      while (paramvld.hasNext())
      {
        localObject = (vle)paramvld.next();
        if ((((vle)localObject).d()) && (((vle)localObject).e()))
        {
          wsv.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((vle)localObject).e())
        {
          wsv.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((vle)localObject).jdField_a_of_type_Vld);
          localArrayList = new ArrayList(1);
          localArrayList.add(((vle)localObject).jdField_a_of_type_Vld);
          a(localArrayList);
        }
        else
        {
          wsv.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((vle)localObject).jdField_a_of_type_Vld);
          localArrayList = new ArrayList(1);
          localArrayList.add(((vle)localObject).jdField_a_of_type_Vld);
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
  
  public vlb a(@Nullable vld paramvld, int paramInt)
  {
    boolean bool;
    long l;
    vlb localvlb2;
    if (paramInt >= 0)
    {
      bool = true;
      xmh.a(bool);
      l = System.currentTimeMillis();
      localvlb2 = new vlb();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      vle localvle;
      synchronized (this.jdField_a_of_type_Vlb)
      {
        m = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramvld != null) {
            localvlb2.jdField_a_of_type_JavaUtilList.add(new vlc(paramvld, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvld)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localvlb2.jdField_a_of_type_Boolean = true;
            localvlb2.jdField_b_of_type_Boolean = true;
            wsv.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramvld, Integer.valueOf(paramInt), localvlb2 });
            return localvlb2;
          }
          localvlb2.jdField_a_of_type_Boolean = true;
          localvlb2.jdField_b_of_type_Boolean = false;
          localvlb2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          wsv.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramvld, Integer.valueOf(paramInt), localvlb2 });
          return localvlb2;
        }
        i = a(paramvld);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localvle = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(k);
          if (localvle.d())
          {
            if (localvle.jdField_a_of_type_JavaUtilList.size() > 0) {
              localvlb2.jdField_a_of_type_JavaUtilList.add(0, localvle.a());
            }
            if (k != 0) {
              break label694;
            }
            localvlb2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localvlb2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvle.jdField_a_of_type_Vld));
          localvlb2.jdField_a_of_type_Boolean = false;
        }
        localvle = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
        if (!localvle.d()) {
          break label515;
        }
        if (localvle.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localvlb2.jdField_a_of_type_JavaUtilList.add(localvle.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localvle = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(j);
          if (!localvle.d()) {
            break label556;
          }
          if (localvle.jdField_a_of_type_JavaUtilList.size() > 0) {
            localvlb2.jdField_a_of_type_JavaUtilList.add(localvle.a());
          }
          if (i != m) {
            break label732;
          }
          localvlb2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localvlb2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localvlb2.jdField_a_of_type_Boolean = true;
        }
      }
      localvlb2.jdField_a_of_type_JavaUtilList.add(new vlc(localvle.jdField_a_of_type_Vld, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localvlb2.jdField_a_of_type_JavaUtilList.add(new vlc(localvle.jdField_a_of_type_Vld, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvle.jdField_a_of_type_Vld)));
      break label703;
      label556:
      localvlb2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvle.jdField_a_of_type_Vld));
      localvlb2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        wsv.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramvld, localvlb2 });
        wsv.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localvlb2;
        label633:
        localvlb2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localvlb2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public vlg a()
  {
    vlg localvlg = this.jdField_a_of_type_Vlh.a();
    wsv.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localvlg);
    return localvlg;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vme = new vme(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vme);
    this.jdField_a_of_type_Vmc = new vmc(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vmc);
    this.jdField_a_of_type_Vmd = new vmd(this);
    uht.a().registerSubscriber(this.jdField_a_of_type_Vmd);
    this.jdField_a_of_type_Vlh.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<vld> paramList)
  {
    wsv.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vld localvld = (vld)paramList.next();
      Long localLong = (Long)this.b.remove(localvld);
      if (localLong != null) {
        wsv.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localvld);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localvld, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<vld> paramList, boolean paramBoolean)
  {
    Object localObject;
    vld localvld;
    if (paramList == null)
    {
      localObject = "";
      wsv.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localvld = (vld)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Vlb)
        {
          vle localvle = new vle(localvld);
          if (this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.contains(localvle)) {
            break label149;
          }
          this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.add(localvle);
          wsv.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localvld);
        }
        localObject = paramList;
        break;
        label149:
        wsv.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localvld });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Vld != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (vld)paramList.get(0);; ??? = this.jdField_a_of_type_Vld)
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
      synchronized (this.jdField_a_of_type_Vlb)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          vle localvle = (vle)localIterator1.next();
          if (localvle.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localvle.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            wsv.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localvle.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.remove(localvle);
            wsv.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localvle.jdField_a_of_type_Vld });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localvle, paramString, bool));
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
  
  public void a(List<vle> arg1, boolean paramBoolean)
  {
    wsv.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    vle localvle;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localvle = (vle)localIterator1.next();
      localObject2 = (Long)this.b.remove(localvle.jdField_a_of_type_Vld);
      if (localObject2 != null) {
        wsv.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localvle.jdField_a_of_type_Vld);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localvle = (vle)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Vlb)
        {
          int i = this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.indexOf(localvle);
          if (i < 0) {
            break label367;
          }
          localObject2 = (vle)this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.get(i);
          if (((vle)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((vle)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((vle)localObject2).jdField_a_of_type_JavaUtilList = localvle.jdField_a_of_type_JavaUtilList;
            ((vle)localObject2).jdField_a_of_type_JavaUtilMap = localvle.jdField_a_of_type_JavaUtilMap;
            ((vle)localObject2).jdField_a_of_type_JavaLangString = localvle.jdField_a_of_type_JavaLangString;
            wsv.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localvle.jdField_a_of_type_Vld);
          }
        }
        Iterator localIterator2 = localvle.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((vle)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((vle)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((vle)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            wsv.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((vle)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localvle.jdField_a_of_type_JavaUtilMap);
        ((vle)localObject2).jdField_a_of_type_JavaLangString = localvle.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        wsv.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localvle.jdField_a_of_type_Vld });
      }
    }
    c();
  }
  
  public void a(@Nullable vld paramvld, int paramInt1, int paramInt2, String paramString)
  {
    wsv.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramvld, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramvld, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable vld paramvld, String paramString)
  {
    if (paramvld == null) {}
    for (Object localObject = "";; localObject = paramvld)
    {
      wsv.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramvld), 0);
      return;
    }
  }
  
  public void a(vlf paramvlf)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramvlf)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramvlf);
    }
  }
  
  public void b()
  {
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vme);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vmc);
    uht.a().unRegisterSubscriber(this.jdField_a_of_type_Vmd);
    this.jdField_a_of_type_Vlh.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<vle> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      wsv.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        vle localvle = (vle)paramList.next();
        Long localLong = (Long)this.b.remove(localvle.jdField_a_of_type_Vld);
        if (localLong != null) {
          wsv.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localvle.jdField_a_of_type_Vld);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (vle)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Vlb)
          {
            if (!this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Vlb.jdField_a_of_type_JavaUtilList.add(localObject);
              wsv.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((vle)localObject).jdField_a_of_type_Vld);
            }
          }
          wsv.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((vle)localObject).jdField_a_of_type_Vld });
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
  
  public void b(vlf paramvlf)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramvlf);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     vlz
 * JD-Core Version:    0.7.0.1
 */