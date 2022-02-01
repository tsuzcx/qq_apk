package mqq.app;

import android.app.Activity;
import android.content.Intent;
import android.os.Handler;
import com.tencent.mobileqq.msf.sdk.MsfServiceSdk;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import mqq.util.WeakReference;

class MobileQQ$3
  implements Runnable
{
  MobileQQ$3(MobileQQ paramMobileQQ) {}
  
  private boolean isAllActEmpty()
  {
    Iterator localIterator;
    WeakReference localWeakReference;
    if (!MobileQQ.access$500(this.this$0).isEmpty())
    {
      localIterator = MobileQQ.access$500(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((BaseActivity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    if (!this.this$0.appActivities.isEmpty())
    {
      localIterator = this.this$0.appActivities.iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((AppActivity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    if (!this.this$0.otherTypeActivitys.isEmpty())
    {
      localIterator = this.this$0.otherTypeActivitys.iterator();
      while (localIterator.hasNext())
      {
        localWeakReference = (WeakReference)localIterator.next();
        if ((localWeakReference != null) && (!((Activity)localWeakReference.get()).isFinishing())) {
          return false;
        }
      }
    }
    return true;
  }
  
  public void run()
  {
    if (isAllActEmpty())
    {
      localObject1 = new Intent("mqq.intent.action.EXIT_" + MobileQQ.processName);
      this.this$0.sendBroadcast((Intent)localObject1);
      if (this.this$0.getQQProcessName().endsWith(":video"))
      {
        MobileQQ.access$100(this.this$0).msfSub.unbindMsfService();
        MobileQQ.access$000(this.this$0).onDestroy();
      }
      this.this$0.mHandler.postDelayed(new MobileQQ.3.1(this), 300L);
      return;
    }
    Object localObject1 = new StringBuffer();
    Iterator localIterator = MobileQQ.access$500(this.this$0).iterator();
    Object localObject2;
    while (localIterator.hasNext())
    {
      localObject2 = (BaseActivity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localIterator = this.this$0.appActivities.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (AppActivity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    localIterator = this.this$0.otherTypeActivitys.iterator();
    while (localIterator.hasNext())
    {
      localObject2 = (Activity)((WeakReference)localIterator.next()).get();
      if (localObject2 != null)
      {
        ((StringBuffer)localObject1).append(localObject2.getClass().getSimpleName());
        ((StringBuffer)localObject1).append(",");
      }
    }
    if ((!MobileQQ.access$700()) && (QLog.isColorLevel()))
    {
      QLog.i("mqq", 2, "do exit ->" + ((StringBuffer)localObject1).toString());
      MobileQQ.access$702(true);
    }
    ((StringBuffer)localObject1).delete(0, ((StringBuffer)localObject1).length());
    this.this$0.mHandler.postDelayed(this, 50L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     mqq.app.MobileQQ.3
 * JD-Core Version:    0.7.0.1
 */