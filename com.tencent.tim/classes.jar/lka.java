import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.engine.MonitorTimeExecutor;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.2;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.3;
import com.tencent.biz.pubaccount.readinjoy.preload.FeedsPreloadManager.4;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.io.Serializable;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class lka
{
  private static volatile lka a;
  private lcm.e b = new lkb(this);
  private ExecutorService mExecutorService = MonitorTimeExecutor.e();
  
  public static lka a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new lka();
      }
      return a;
    }
    finally {}
  }
  
  private void a(ljz.a parama, long paramLong)
  {
    parama = new FeedsPreloadManager.4(this, parama, paramLong);
    kxm.p().post(parama);
  }
  
  private void aMK()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    KandianMergeManager localKandianMergeManager = (KandianMergeManager)localQQAppInterface.getManager(162);
    if (localKandianMergeManager == null)
    {
      QLog.d("FeedsPreloadManager", 1, "preloadFeedsImp, km is null.");
      return;
    }
    long l1 = 0L;
    long l2 = 0L;
    String str = null;
    int i = -1;
    Object localObject = localKandianMergeManager.aA();
    if ((localObject != null) && (((List)localObject).size() > 2))
    {
      l1 = ((Long)((List)localObject).get(((List)localObject).size() - 2)).longValue();
      l2 = ((Long)((List)localObject).get(((List)localObject).size() - 1)).longValue();
      localObject = ((List)localObject).subList(0, ((List)localObject).size() - 2);
      i = 1;
      str = localKandianMergeManager.jd();
    }
    for (;;)
    {
      ((lcd)localQQAppInterface.getManager(163)).b().a(0, (List)localObject, i, true, false, 1, null, -1L, null, 0, l1, l2, str, 1, false, null, 256);
      if ((localObject != null) && (((List)localObject).size() > 0)) {}
      for (localObject = (Serializable)((List)localObject).get(0);; localObject = "")
      {
        QLog.d("FeedsPreloadManager", 1, new Object[] { "preloadFeedsImp, algorithmID = ", Long.valueOf(l1), ", strategyID = ", Long.valueOf(l2), ", articleID = ", localObject, ", articleListFrom = ", Integer.valueOf(i), ", pushContext = ", str });
        return;
      }
    }
  }
  
  public void F(Runnable paramRunnable)
  {
    if ((this.mExecutorService.isShutdown()) || (this.mExecutorService.isTerminated()))
    {
      QLog.d("FeedsPreloadManager", 1, "runOnSingleThreadPool, executorService is not available, init a new one.");
      this.mExecutorService = MonitorTimeExecutor.e();
    }
    this.mExecutorService.execute(paramRunnable);
  }
  
  public ljz.a b(luq.b paramb)
  {
    boolean bool2 = false;
    ljz localljz = ljz.b();
    if (localljz != null)
    {
      ljz.a locala = localljz.a(paramb);
      localljz.clearCache();
      if (locala != null)
      {
        QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, hit cache.");
        if (locala.il != null) {}
        for (int i = locala.il.size();; i = 0)
        {
          boolean bool1 = bool2;
          if (paramb.iu != null)
          {
            bool1 = bool2;
            if (paramb.iu.size() > 0) {
              bool1 = true;
            }
          }
          lkc.S(bool1, i);
          return locala;
        }
      }
      QLog.d("FeedsPreloadManager", 1, "getFeedsPreloadCache, cache is null.");
    }
    return null;
  }
  
  public void b(ljz.a parama)
  {
    boolean bool2 = false;
    QLog.d("FeedsPreloadManager", 1, new Object[] { "handleFeedsPreloadRequest, cache = ", parama });
    long l;
    int i;
    if (parama != null)
    {
      Object localObject = parama.h;
      l = 0L;
      localObject = (Long)((ToServiceMsg)localObject).getAttribute("recPackageSize");
      if (localObject != null) {
        l = ((Long)localObject).longValue();
      }
      a(parama, l);
      lke.aMM();
      if (parama.il == null) {
        break label135;
      }
      i = parama.il.size();
      if (parama.h == null) {
        break label140;
      }
    }
    label135:
    label140:
    for (parama = (List)parama.h.getAttribute("SubscriptionArticles");; parama = null)
    {
      boolean bool1 = bool2;
      if (parama != null)
      {
        bool1 = bool2;
        if (parama.size() > 0) {
          bool1 = true;
        }
      }
      lkc.b(bool1, i, l);
      return;
      i = 0;
      break;
    }
  }
  
  public void nD(boolean paramBoolean)
  {
    F(new FeedsPreloadManager.3(this, paramBoolean));
  }
  
  public void reset()
  {
    QLog.d("FeedsPreloadManager", 1, "reset, feeds preload.");
    if (a != null) {
      try
      {
        a.mExecutorService.shutdownNow();
        a.mExecutorService = MonitorTimeExecutor.e();
        QLog.d("FeedsPreloadManager", 1, "remove foreground, background callback.");
        lcm.d.b(this.b);
        return;
      }
      finally {}
    }
  }
  
  public void start()
  {
    QQAppInterface localQQAppInterface = (QQAppInterface)kxm.getAppRuntime();
    if ((localQQAppInterface == null) || (!localQQAppInterface.isLogin()))
    {
      QLog.d("FeedsPreloadManager", 1, "app is null or not login, don't do feeds preload.");
      return;
    }
    QLog.d("FeedsPreloadManager", 1, "start, feeds preload.");
    nD(false);
    ThreadManager.getSubThreadHandler().postDelayed(new FeedsPreloadManager.2(this), 3000L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lka
 * JD-Core Version:    0.7.0.1
 */