import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.TMG.utils.QLog;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.1;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.2;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.3;
import com.tencent.biz.pubaccount.readinjoy.engine.ReadInJoyFollowingMemberPrefetcher.4;
import com.tencent.biz.pubaccount.readinjoy.struct.ReadinjoyFollowingUserBriefInfo;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.ref.WeakReference;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class lby
  extends lce
{
  private Set<Long> T = new HashSet();
  private boolean aiU = true;
  private boolean aiV;
  private boolean aiW;
  private WeakReference<lhy> cf;
  private WeakReference<AppInterface> n;
  private long tt;
  
  public lby(AppInterface paramAppInterface, lhy paramlhy)
  {
    this.n = new WeakReference(paramAppInterface);
    this.cf = new WeakReference(paramlhy);
    ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.1(this));
  }
  
  private void a(EntityManager paramEntityManager, long paramLong, int paramInt)
  {
    if (paramEntityManager == null)
    {
      if (QLog.isColorLevel()) {
        QLog.e("ReadInJoyFollowingMemberPrefetcher", 0, "update follow status error, entity manager is null!");
      }
      return;
    }
    if ((paramInt == 1) || (paramInt == 0))
    {
      ReadinjoyFollowingUserBriefInfo localReadinjoyFollowingUserBriefInfo = (ReadinjoyFollowingUserBriefInfo)paramEntityManager.find(ReadinjoyFollowingUserBriefInfo.class, String.valueOf(paramLong));
      if (localReadinjoyFollowingUserBriefInfo != null) {
        paramEntityManager.remove(localReadinjoyFollowingUserBriefInfo);
      }
      this.T.remove(Long.valueOf(paramLong));
      return;
    }
    paramEntityManager.persistOrReplace(new ReadinjoyFollowingUserBriefInfo(paramLong, paramInt));
    this.T.add(Long.valueOf(paramLong));
  }
  
  private void aJe()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "clear all following members in cache and db");
    }
    this.T.clear();
    AppInterface localAppInterface = (AppInterface)this.n.get();
    if (localAppInterface != null) {
      localAppInterface.getEntityManagerFactory().createEntityManager().drop(ReadinjoyFollowingUserBriefInfo.class);
    }
  }
  
  private void aJf()
  {
    Object localObject1 = (AppInterface)this.n.get();
    if (localObject1 != null)
    {
      Object localObject2 = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject1).getAccount(), 4);
      if (localObject2 != null) {
        this.tt = ((SharedPreferences)localObject2).getLong("readinjoy_last_request_prefetch_following_time", 0L);
      }
      this.T.clear();
      localObject1 = ((AppInterface)localObject1).getEntityManagerFactory().createEntityManager().query(ReadinjoyFollowingUserBriefInfo.class);
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          localObject2 = (ReadinjoyFollowingUserBriefInfo)((Iterator)localObject1).next();
          this.T.add(Long.valueOf(((ReadinjoyFollowingUserBriefInfo)localObject2).uin));
        }
      }
    }
  }
  
  private void er(long paramLong)
  {
    Object localObject = (AppInterface)this.n.get();
    if (localObject != null)
    {
      this.tt = paramLong;
      localObject = BaseApplicationImpl.getContext().getSharedPreferences("sp_public_account_with_cuin_" + ((AppInterface)localObject).getAccount(), 4);
      if (localObject != null) {
        ((SharedPreferences)localObject).edit().putLong("readinjoy_last_request_prefetch_following_time", paramLong).commit();
      }
    }
  }
  
  private void k(List<mhg> paramList, int paramInt)
  {
    if (paramList == null) {}
    for (;;)
    {
      return;
      Object localObject = (AppInterface)this.n.get();
      if (localObject != null)
      {
        localObject = ((AppInterface)localObject).getEntityManagerFactory().createEntityManager();
        paramList = paramList.iterator();
        while (paramList.hasNext()) {
          a((EntityManager)localObject, ((mhg)paramList.next()).getUin().longValue(), paramInt);
        }
      }
    }
  }
  
  private void m(List<mhg> paramList, boolean paramBoolean)
  {
    if (this.aiU)
    {
      aJe();
      this.aiU = false;
    }
    er(System.currentTimeMillis());
    k(paramList, 2);
    if (!paramBoolean) {
      this.aiV = false;
    }
    do
    {
      return;
      paramList = (lhy)this.cf.get();
    } while (paramList == null);
    paramList.j(1000, 1, true);
  }
  
  public boolean BH()
  {
    return System.currentTimeMillis() - cx() > 86400000L;
  }
  
  public void a(boolean paramBoolean1, List<mhg> paramList, long paramLong, boolean paramBoolean2)
  {
    if ((!this.aiV) || (!paramBoolean1)) {
      return;
    }
    ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.2(this, paramList, paramBoolean2));
  }
  
  public void aEL()
  {
    try
    {
      if (QLog.isColorLevel()) {
        QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "uninitialize");
      }
      this.aiW = true;
      lcc.a().c(this);
      return;
    }
    finally {}
  }
  
  public void aJd()
  {
    this.aiU = true;
  }
  
  public void aa(long paramLong, int paramInt)
  {
    AppInterface localAppInterface = (AppInterface)this.n.get();
    if (localAppInterface != null) {
      a(localAppInterface.getEntityManagerFactory().createEntityManager(), paramLong, paramInt);
    }
  }
  
  public void b(boolean paramBoolean1, List<mhg> paramList, long paramLong, boolean paramBoolean2)
  {
    if (paramBoolean1) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.3(this, paramList));
    }
  }
  
  public boolean c(Long paramLong)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ReadInJoyFollowingMemberPrefetcher", 0, "[isFollowingPgcUin] uin:" + paramLong + ", size:" + this.T.size());
    }
    return this.T.contains(paramLong);
  }
  
  public long cx()
  {
    return this.tt;
  }
  
  public void mW(boolean paramBoolean)
  {
    if ((this.cf.get() != null) && ((BH()) || (paramBoolean))) {
      ThreadManager.executeOnSubThread(new ReadInJoyFollowingMemberPrefetcher.4(this, paramBoolean));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lby
 * JD-Core Version:    0.7.0.1
 */