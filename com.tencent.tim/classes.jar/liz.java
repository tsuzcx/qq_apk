import android.content.Context;
import android.os.Handler;
import com.tencent.biz.pubaccount.readinjoy.engine.KandianMergeManager;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.1;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.2;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.3;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.5;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.6;
import com.tencent.biz.pubaccount.readinjoy.model.SubscriptionInfoModule.7;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import mqq.os.MqqHandler;

public class liz
  extends lir
{
  private Handler aY = new ljb(this, ThreadManager.getSubThreadLooper());
  private volatile boolean akz;
  private acje b = new lja(this);
  private List<oal> ge;
  protected long uC = 2000L;
  
  public liz(AppInterface paramAppInterface, EntityManager paramEntityManager, ExecutorService paramExecutorService, lun paramlun, Handler paramHandler)
  {
    super(paramAppInterface, paramEntityManager, paramExecutorService, paramlun, paramHandler);
  }
  
  private void cp(int paramInt1, int paramInt2)
  {
    this.mMainThreadHandler.post(new SubscriptionInfoModule.7(this, paramInt1, paramInt2));
  }
  
  public void Rt()
  {
    if (!(this.mApp instanceof QQAppInterface)) {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface init model failed!");
      }
    }
    while (this.mExecutorService == null) {
      return;
    }
    this.mExecutorService.execute(new SubscriptionInfoModule.1(this));
  }
  
  public void aEL()
  {
    this.b = null;
    if (this.aY != null)
    {
      this.aY.removeCallbacksAndMessages(null);
      this.aY = null;
    }
  }
  
  public void aJk()
  {
    if ((this.mApp instanceof QQAppInterface)) {
      this.mExecutorService.execute(new SubscriptionInfoModule.2(this));
    }
    while (!QLog.isColorLevel()) {
      return;
    }
    QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface");
  }
  
  public void aJm()
  {
    cp(((KandianMergeManager)((QQAppInterface)this.mApp).getManager(162)).dd(1), 1);
  }
  
  public void aMk() {}
  
  public void bR(List<oal> paramList)
  {
    if (this.mMainThreadHandler == null) {
      return;
    }
    this.mMainThreadHandler.post(new SubscriptionInfoModule.3(this, paramList));
  }
  
  public void doOnStart() {}
  
  public void doOnStop()
  {
    if ((this.mApp instanceof QQAppInterface)) {}
  }
  
  public void h(String paramString, Context paramContext)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    this.mExecutorService.execute(new SubscriptionInfoModule.5(this, paramString, paramContext));
    paramContext = this.ge.iterator();
    oal localoal;
    do
    {
      if (!paramContext.hasNext()) {
        break;
      }
      localoal = (oal)paramContext.next();
    } while ((localoal.mUin == null) || (!localoal.mUin.equals(paramString)));
    for (int i = localoal.aOr;; i = 0)
    {
      anot.a(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CF", "0X80064CF", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public void mO(String paramString)
  {
    int j;
    oal localoal;
    if (!oan.a().a(paramString, (QQAppInterface)this.mApp))
    {
      oan.a().e(paramString, (QQAppInterface)this.mApp);
      kbp.b(null, "CliOper", "", "", "0X8006112", "0X8006112", 0, 0, "", "", "", "");
      j = oan.a().rd();
      Iterator localIterator = this.ge.iterator();
      do
      {
        if (!localIterator.hasNext()) {
          break;
        }
        localoal = (oal)localIterator.next();
      } while ((localoal.mUin == null) || (!localoal.mUin.equals(paramString)));
    }
    for (int i = localoal.aOr;; i = 0)
    {
      aJk();
      anot.a(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CD", "0X80064CD", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void mP(String paramString)
  {
    oan.a().f(paramString, (QQAppInterface)this.mApp);
    int j = oan.a().rd();
    Iterator localIterator = this.ge.iterator();
    oal localoal;
    do
    {
      if (!localIterator.hasNext()) {
        break;
      }
      localoal = (oal)localIterator.next();
    } while ((localoal.mUin == null) || (!localoal.mUin.equals(paramString)));
    for (int i = localoal.aOr;; i = 0)
    {
      aJk();
      anot.a(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064CE", "0X80064CE", 0, 0, "" + i, "" + j, "", "");
      return;
    }
  }
  
  public void mQ(String paramString)
  {
    if (!(this.mApp instanceof QQAppInterface))
    {
      if (QLog.isColorLevel()) {
        QLog.d("SubscriptionInfoModule", 2, "mApp isn't instanceof QQAppInterface unFollowSubscribeAccount failed!");
      }
      return;
    }
    oan.a().d(paramString, (QQAppInterface)this.mApp);
    aJk();
    this.mExecutorService.execute(new SubscriptionInfoModule.6(this, paramString));
    Object localObject = this.mApp.getHandler(Conversation.class);
    if (localObject != null) {
      ((MqqHandler)localObject).sendEmptyMessage(1014);
    }
    localObject = this.ge.iterator();
    oal localoal;
    do
    {
      if (!((Iterator)localObject).hasNext()) {
        break;
      }
      localoal = (oal)((Iterator)localObject).next();
    } while ((localoal.mUin == null) || (!localoal.mUin.equals(paramString)));
    for (int i = localoal.aOr;; i = 0)
    {
      anot.a(null, "dc00899", "Pb_account_lifeservice", paramString, "0X80064D0", "0X80064D0", 0, 0, "" + i, "", "", "");
      return;
    }
  }
  
  public int om()
  {
    int i = 0;
    int j = 0;
    if (!(this.mApp instanceof QQAppInterface)) {
      return j;
    }
    Iterator localIterator = oan.a().c((QQAppInterface)this.mApp).iterator();
    for (;;)
    {
      j = i;
      if (!localIterator.hasNext()) {
        break;
      }
      i = ((oal)localIterator.next()).aOr + i;
    }
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     liz
 * JD-Core Version:    0.7.0.1
 */