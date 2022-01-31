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

public class vqi
  implements IEventReceiver, vpj, vps, vpu
{
  protected ErrorMessage a;
  private ConcurrentHashMap<vpm, ErrorMessage> jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap = new ConcurrentHashMap();
  private CopyOnWriteArrayList<vpo> jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList = new CopyOnWriteArrayList();
  private AtomicInteger jdField_a_of_type_JavaUtilConcurrentAtomicAtomicInteger = new AtomicInteger(0);
  private final ulq<vpt> jdField_a_of_type_Ulq;
  private final vpk jdField_a_of_type_Vpk = new vpk();
  private vpm jdField_a_of_type_Vpm;
  private vpq jdField_a_of_type_Vpq;
  private vql jdField_a_of_type_Vql;
  private vqm jdField_a_of_type_Vqm;
  private vqn jdField_a_of_type_Vqn;
  protected boolean a;
  private ConcurrentHashMap<vpm, Long> b = new ConcurrentHashMap();
  
  public vqi(vpq paramvpq)
  {
    this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
    wxe.a("Q.qqstory.player.data.SimpleDataProvider", "use loader %s", paramvpq);
    this.jdField_a_of_type_Vpq = paramvpq;
    this.jdField_a_of_type_Ulq = new ulq(new vqj(this));
  }
  
  private int a(@Nullable vpm paramvpm)
  {
    int j;
    if (paramvpm == null)
    {
      j = -1;
      return j;
    }
    Iterator localIterator = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.iterator();
    int i = 0;
    for (;;)
    {
      if (!localIterator.hasNext()) {
        break label63;
      }
      j = i;
      if (((vpn)localIterator.next()).jdField_a_of_type_Vpm.equals(paramvpm)) {
        break;
      }
      i += 1;
    }
    label63:
    return -1;
  }
  
  private List<vpm> a(int paramInt1, int paramInt2)
  {
    ArrayList localArrayList = new ArrayList(paramInt2 * 2);
    vpk localvpk = this.jdField_a_of_type_Vpk;
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
        if (paramInt1 >= this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size())
        {
          paramInt1 = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size();
          if (i < paramInt1)
          {
            vpn localvpn = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
            if (localvpn.d()) {
              break label133;
            }
            localArrayList.add(localvpn.jdField_a_of_type_Vpm);
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
  
  private vpn a(@Nullable vpm paramvpm)
  {
    int i = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.indexOf(new vpn(paramvpm));
    if (i < 0) {
      return null;
    }
    return (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
  }
  
  private void a(String paramString1, String paramString2, String paramString3)
  {
    synchronized (this.jdField_a_of_type_Vpk)
    {
      Iterator localIterator = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.iterator();
      while (localIterator.hasNext())
      {
        vpn localvpn = (vpn)localIterator.next();
        if (localvpn.jdField_a_of_type_JavaUtilList != null)
        {
          int i = localvpn.jdField_a_of_type_JavaUtilList.indexOf(paramString1);
          if (i >= 0)
          {
            wxe.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success old group=%s", new Object[] { localvpn });
            localvpn.jdField_a_of_type_JavaUtilList.add(i, paramString2);
            localvpn.jdField_a_of_type_JavaUtilList.remove(paramString1);
            localvpn.jdField_a_of_type_JavaUtilMap.put(paramString2, paramString3);
            wxe.d("Q.qqstory.player.data.SimpleDataProvider", "on publish success new group=%s", new Object[] { localvpn });
            c();
            return;
          }
        }
      }
      return;
    }
  }
  
  private void a(List<vpm> paramList)
  {
    if (paramList.size() == 0) {
      return;
    }
    Iterator localIterator = paramList.iterator();
    while (localIterator.hasNext())
    {
      vpm localvpm = (vpm)localIterator.next();
      vpn localvpn = a(localvpm);
      if ((localvpn != null) && (!this.jdField_a_of_type_Vpq.a(localvpn)))
      {
        localIterator.remove();
        wxe.b("Q.qqstory.player.data.SimpleDataProvider", "synVid. remove no need sync group=%s", localvpn);
      }
      else
      {
        this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.remove(localvpm);
        if (this.b.containsKey(localvpm))
        {
          wxe.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. ignore same request group info request:%s", localvpm);
          localIterator.remove();
        }
        else
        {
          this.b.put(localvpm, Long.valueOf(System.currentTimeMillis()));
        }
      }
    }
    if (paramList.size() > 0)
    {
      wxe.a("Q.qqstory.player.data.SimpleDataProvider", "synVid. start sync group:%s", paramList);
      this.jdField_a_of_type_Ulq.a(this.jdField_a_of_type_Vpq.a(paramList));
      return;
    }
    c();
  }
  
  private void a(@Nullable vpm paramvpm)
  {
    wxe.a("Q.qqstory.player.data.SimpleDataProvider", "triggerSyncData curGroupId=%s", paramvpm.toString());
    synchronized (this.jdField_a_of_type_Vpk)
    {
      int j = a(paramvpm);
      int i = j;
      if (j < 0) {
        i = 0;
      }
      if ((i + 5 > this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size()) && (!this.jdField_a_of_type_Boolean))
      {
        wxe.b("Q.qqstory.player.data.SimpleDataProvider", "request next group key");
        this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
        this.jdField_a_of_type_Vpm = paramvpm;
        this.jdField_a_of_type_Vpq.a(20, this);
      }
      a(a(i, 2));
      return;
    }
  }
  
  private void b(@Nullable vpm paramvpm, int paramInt1, int paramInt2, String arg4)
  {
    int j = 0;
    for (;;)
    {
      Object localObject;
      ArrayList localArrayList;
      int i;
      synchronized (this.jdField_a_of_type_Vpk)
      {
        localObject = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList;
        localArrayList = new ArrayList();
        int k = a(paramvpm);
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
            this.jdField_a_of_type_Vpm = paramvpm;
            wxe.b("Q.qqstory.player.data.SimpleDataProvider", "request new group key list");
            this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = new ErrorMessage();
            this.jdField_a_of_type_Vpq.a(20, this);
            return;
          }
          c();
        }
      }
      paramvpm = localArrayList.iterator();
      while (paramvpm.hasNext())
      {
        localObject = (vpn)paramvpm.next();
        if ((((vpn)localObject).d()) && (((vpn)localObject).e()))
        {
          wxe.a("Q.qqstory.player.data.SimpleDataProvider", "group data is ok, %s", localObject);
          c();
        }
        else if (!((vpn)localObject).e())
        {
          wxe.a("Q.qqstory.player.data.SimpleDataProvider.VASH", "not is end so request group vid, %s", ((vpn)localObject).jdField_a_of_type_Vpm);
          localArrayList = new ArrayList(1);
          localArrayList.add(((vpn)localObject).jdField_a_of_type_Vpm);
          a(localArrayList);
        }
        else
        {
          wxe.a("Q.qqstory.player.data.SimpleDataProvider", "request group vid, %s", ((vpn)localObject).jdField_a_of_type_Vpm);
          localArrayList = new ArrayList(1);
          localArrayList.add(((vpn)localObject).jdField_a_of_type_Vpm);
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
  
  public vpk a(@Nullable vpm paramvpm, int paramInt)
  {
    boolean bool;
    long l;
    vpk localvpk2;
    if (paramInt >= 0)
    {
      bool = true;
      xqq.a(bool);
      l = System.currentTimeMillis();
      localvpk2 = new vpk();
    }
    for (;;)
    {
      int m;
      label211:
      int k;
      int j;
      vpn localvpn;
      synchronized (this.jdField_a_of_type_Vpk)
      {
        m = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.size();
        if (m == 0)
        {
          if (paramvpm != null) {
            localvpk2.jdField_a_of_type_JavaUtilList.add(new vpl(paramvpm, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(paramvpm)));
          }
          if (this.jdField_a_of_type_Boolean)
          {
            localvpk2.jdField_a_of_type_Boolean = true;
            localvpk2.jdField_b_of_type_Boolean = true;
            wxe.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramvpm, Integer.valueOf(paramInt), localvpk2 });
            return localvpk2;
          }
          localvpk2.jdField_a_of_type_Boolean = true;
          localvpk2.jdField_b_of_type_Boolean = false;
          localvpk2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          wxe.d("Q.qqstory.player.data.SimpleDataProvider", "get data cur:%s, step:%d, %s", new Object[] { paramvpm, Integer.valueOf(paramInt), localvpk2 });
          return localvpk2;
        }
        i = a(paramvpm);
        if (i >= 0) {
          break label660;
        }
        i = 0;
        break label669;
        if (k >= j)
        {
          localvpn = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(k);
          if (localvpn.d())
          {
            if (localvpn.jdField_a_of_type_JavaUtilList.size() > 0) {
              localvpk2.jdField_a_of_type_JavaUtilList.add(0, localvpn.a());
            }
            if (k != 0) {
              break label694;
            }
            localvpk2.jdField_a_of_type_Boolean = true;
            break label694;
          }
          localvpk2.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvpn.jdField_a_of_type_Vpm));
          localvpk2.jdField_a_of_type_Boolean = false;
        }
        localvpn = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
        if (!localvpn.d()) {
          break label515;
        }
        if (localvpn.jdField_a_of_type_JavaUtilList.size() > 0)
        {
          localvpk2.jdField_a_of_type_JavaUtilList.add(localvpn.a());
          break label703;
          label372:
          if (j >= i) {
            break label582;
          }
          localvpn = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(j);
          if (!localvpn.d()) {
            break label556;
          }
          if (localvpn.jdField_a_of_type_JavaUtilList.size() > 0) {
            localvpk2.jdField_a_of_type_JavaUtilList.add(localvpn.a());
          }
          if (i != m) {
            break label732;
          }
          localvpk2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
          localvpk2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
          break label732;
          label461:
          localvpk2.jdField_a_of_type_Boolean = true;
        }
      }
      localvpk2.jdField_a_of_type_JavaUtilList.add(new vpl(localvpn.jdField_a_of_type_Vpm, new ErrorMessage(97000000, "no data")));
      break label703;
      label515:
      localvpk2.jdField_a_of_type_JavaUtilList.add(new vpl(localvpn.jdField_a_of_type_Vpm, (ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvpn.jdField_a_of_type_Vpm)));
      break label703;
      label556:
      localvpk2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = ((ErrorMessage)this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.get(localvpn.jdField_a_of_type_Vpm));
      localvpk2.jdField_b_of_type_Boolean = false;
      for (;;)
      {
        label582:
        wxe.d("Q.qqstory.player.data.SimpleDataProvider", "get data step:%d, cur:%s,  %s", new Object[] { Integer.valueOf(paramInt), paramvpm, localvpk2 });
        wxe.a("Q.qqstory.player.data.SimpleDataProvider", "get data take time:%dms", Long.valueOf(System.currentTimeMillis() - l));
        return localvpk2;
        label633:
        localvpk2.jdField_b_of_type_Boolean = this.jdField_a_of_type_Boolean;
        localvpk2.jdField_b_of_type_ComTencentBizQqstoryBaseErrorMessage = this.jdField_a_of_type_ComTencentBizQqstoryBaseErrorMessage;
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
  
  public vpp a()
  {
    vpp localvpp = this.jdField_a_of_type_Vpq.a();
    wxe.a("Q.qqstory.player.data.SimpleDataProvider", "start info:%s", localvpp);
    return localvpp;
  }
  
  public void a()
  {
    this.jdField_a_of_type_Vqn = new vqn(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vqn);
    this.jdField_a_of_type_Vql = new vql(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vql);
    this.jdField_a_of_type_Vqm = new vqm(this);
    umc.a().registerSubscriber(this.jdField_a_of_type_Vqm);
    this.jdField_a_of_type_Vpq.a();
  }
  
  public void a(ErrorMessage paramErrorMessage, List<vpm> paramList)
  {
    wxe.a("Q.qqstory.player.data.SimpleDataProvider", "on vid respond fail %s", paramErrorMessage);
    paramList = paramList.iterator();
    while (paramList.hasNext())
    {
      vpm localvpm = (vpm)paramList.next();
      Long localLong = (Long)this.b.remove(localvpm);
      if (localLong != null) {
        wxe.a("Q.qqstory.player.data.SimpleDataProvider", "get group groupId take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localvpm);
      }
      this.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(localvpm, paramErrorMessage);
    }
    c();
  }
  
  public void a(ErrorMessage arg1, List<vpm> paramList, boolean paramBoolean)
  {
    Object localObject;
    vpm localvpm;
    if (paramList == null)
    {
      localObject = "";
      wxe.a("Q.qqstory.player.data.SimpleDataProvider", "onGroupKeyFinish respond %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      if (!???.isSuccess()) {
        break label210;
      }
      this.jdField_a_of_type_Boolean = paramBoolean;
      if (paramList == null) {
        break label201;
      }
      localObject = paramList.iterator();
      if (((Iterator)localObject).hasNext()) {
        localvpm = (vpm)((Iterator)localObject).next();
      }
    }
    else
    {
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Vpk)
        {
          vpn localvpn = new vpn(localvpm);
          if (this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.contains(localvpn)) {
            break label149;
          }
          this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.add(localvpn);
          wxe.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", localvpm);
        }
        localObject = paramList;
        break;
        label149:
        wxe.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { localvpm });
      }
    }
    if (paramList.size() > 0) {
      if (this.jdField_a_of_type_Vpm != null) {
        break label202;
      }
    }
    label201:
    label202:
    for (??? = (vpm)paramList.get(0);; ??? = this.jdField_a_of_type_Vpm)
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
      synchronized (this.jdField_a_of_type_Vpk)
      {
        Iterator localIterator1 = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.iterator();
        if (localIterator1.hasNext())
        {
          vpn localvpn = (vpn)localIterator1.next();
          if (localvpn.jdField_a_of_type_JavaUtilList == null) {
            continue;
          }
          Iterator localIterator2 = localvpn.jdField_a_of_type_JavaUtilList.iterator();
          int i = 0;
          if (localIterator2.hasNext())
          {
            if (!((String)localIterator2.next()).equals(paramString)) {
              break label218;
            }
            localIterator2.remove();
            wxe.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s", new Object[] { paramString });
            i = 1;
            break label218;
          }
          if (i == 0) {
            continue;
          }
          if (localvpn.jdField_a_of_type_JavaUtilList.size() == 0)
          {
            this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.remove(localvpn);
            wxe.d("Q.qqstory.player.data.SimpleDataProvider", "delete vid=%s and group=%s", new Object[] { paramString, localvpn.jdField_a_of_type_Vpm });
            ThreadManager.getUIHandler().post(new SimpleDataProvider.6(this, localvpn, paramString, bool));
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
  
  public void a(List<vpn> arg1, boolean paramBoolean)
  {
    wxe.b("Q.qqstory.player.data.SimpleDataProvider", "on vid respond suc");
    Iterator localIterator1 = ???.iterator();
    vpn localvpn;
    Object localObject2;
    while (localIterator1.hasNext())
    {
      localvpn = (vpn)localIterator1.next();
      localObject2 = (Long)this.b.remove(localvpn.jdField_a_of_type_Vpm);
      if (localObject2 != null) {
        wxe.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - ((Long)localObject2).longValue()), localvpn.jdField_a_of_type_Vpm);
      }
    }
    localIterator1 = ???.iterator();
    if (localIterator1.hasNext())
    {
      localvpn = (vpn)localIterator1.next();
      for (;;)
      {
        synchronized (this.jdField_a_of_type_Vpk)
        {
          int i = this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.indexOf(localvpn);
          if (i < 0) {
            break label367;
          }
          localObject2 = (vpn)this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.get(i);
          if (((vpn)localObject2).jdField_a_of_type_JavaUtilList == null) {
            ((vpn)localObject2).jdField_a_of_type_JavaUtilList = new ArrayList();
          }
          if (paramBoolean)
          {
            ((vpn)localObject2).jdField_a_of_type_JavaUtilList = localvpn.jdField_a_of_type_JavaUtilList;
            ((vpn)localObject2).jdField_a_of_type_JavaUtilMap = localvpn.jdField_a_of_type_JavaUtilMap;
            ((vpn)localObject2).jdField_a_of_type_JavaLangString = localvpn.jdField_a_of_type_JavaLangString;
            wxe.a("Q.qqstory.player.data.SimpleDataProvider", "add group vid %s", localvpn.jdField_a_of_type_Vpm);
          }
        }
        Iterator localIterator2 = localvpn.jdField_a_of_type_JavaUtilList.iterator();
        while (localIterator2.hasNext())
        {
          String str = (String)localIterator2.next();
          if (!((vpn)localObject2).jdField_a_of_type_JavaUtilList.contains(str))
          {
            ((vpn)localObject2).jdField_a_of_type_JavaUtilList.add(str);
          }
          else
          {
            ((vpn)localObject2).jdField_a_of_type_JavaUtilList.add(str);
            wxe.e("Q.qqstory.player.data.SimpleDataProvider", "!!! vid is equal %s", new Object[] { str });
          }
        }
        ((vpn)localObject2).jdField_a_of_type_JavaUtilMap.putAll(localvpn.jdField_a_of_type_JavaUtilMap);
        ((vpn)localObject2).jdField_a_of_type_JavaLangString = localvpn.jdField_a_of_type_JavaLangString;
        continue;
        label367:
        wxe.e("Q.qqstory.player.data.SimpleDataProvider", "should happen with group not exist:%s", new Object[] { localvpn.jdField_a_of_type_Vpm });
      }
    }
    c();
  }
  
  public void a(@Nullable vpm paramvpm, int paramInt1, int paramInt2, String paramString)
  {
    wxe.a("Q.qqstory.player.data.SimpleDataProvider", "requestGroupData %s direction=%d, stepSize=%d, curGroupVid=%s", paramvpm, Integer.valueOf(paramInt1), Integer.valueOf(paramInt2), paramString);
    Bosses.get().postLightWeightJob(new SimpleDataProvider.2(this, paramvpm, paramInt1, paramInt2, paramString), 0);
  }
  
  public void a(@Nullable vpm paramvpm, String paramString)
  {
    if (paramvpm == null) {}
    for (Object localObject = "";; localObject = paramvpm)
    {
      wxe.a("Q.qqstory.player.data.SimpleDataProvider", "markCurrentGroup %s, curGroupVid=%s", localObject, paramString);
      Bosses.get().postLightWeightJob(new SimpleDataProvider.3(this, paramvpm), 0);
      return;
    }
  }
  
  public void a(vpo paramvpo)
  {
    if (!this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.contains(paramvpo)) {
      this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.add(paramvpo);
    }
  }
  
  public void b()
  {
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vqn);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vql);
    umc.a().unRegisterSubscriber(this.jdField_a_of_type_Vqm);
    this.jdField_a_of_type_Vpq.b();
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.clear();
  }
  
  public void b(ErrorMessage arg1, List<vpn> paramList, boolean paramBoolean)
  {
    if (paramList == null) {}
    for (Object localObject = "";; localObject = paramList)
    {
      wxe.a("Q.qqstory.player.data.SimpleDataProvider", "on group info respond  %s, is end:%b %s", localObject, Boolean.valueOf(paramBoolean), ???.toString());
      localObject = paramList;
      if (paramList == null) {
        localObject = new ArrayList(0);
      }
      paramList = ((List)localObject).iterator();
      while (paramList.hasNext())
      {
        vpn localvpn = (vpn)paramList.next();
        Long localLong = (Long)this.b.remove(localvpn.jdField_a_of_type_Vpm);
        if (localLong != null) {
          wxe.a("Q.qqstory.player.data.SimpleDataProvider", "get group info take time：%d, %s", Long.valueOf(System.currentTimeMillis() - localLong.longValue()), localvpn.jdField_a_of_type_Vpm);
        }
      }
    }
    if (???.isSuccess())
    {
      paramList = ((List)localObject).iterator();
      if (paramList.hasNext())
      {
        localObject = (vpn)paramList.next();
        for (;;)
        {
          synchronized (this.jdField_a_of_type_Vpk)
          {
            if (!this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.contains(localObject))
            {
              this.jdField_a_of_type_Vpk.jdField_a_of_type_JavaUtilList.add(localObject);
              wxe.a("Q.qqstory.player.data.SimpleDataProvider", "add group %s", ((vpn)localObject).jdField_a_of_type_Vpm);
            }
          }
          wxe.d("Q.qqstory.player.data.SimpleDataProvider", "data repeat group %s", new Object[] { ((vpn)localObject).jdField_a_of_type_Vpm });
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
  
  public void b(vpo paramvpo)
  {
    this.jdField_a_of_type_JavaUtilConcurrentCopyOnWriteArrayList.remove(paramvpo);
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
 * Qualified Name:     vqi
 * JD-Core Version:    0.7.0.1
 */