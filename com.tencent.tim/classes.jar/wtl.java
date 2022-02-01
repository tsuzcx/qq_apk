import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.1;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.2;
import com.tencent.mobileqq.activity.aio.helper.AIOIconChangeByTimeHelper.TimeChangeReceiver.1;
import com.tencent.mobileqq.activity.aio.panel.PanelIconLinearLayout;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.Calendar;
import java.util.concurrent.atomic.AtomicInteger;
import mqq.os.MqqHandler;

public class wtl
  implements wvs
{
  private wtl.a a;
  private volatile AtomicInteger aE = new AtomicInteger(0);
  private acku b = new wtm(this);
  private BaseChatPie f;
  private final Object lock = new Object();
  
  wtl(BaseChatPie paramBaseChatPie)
  {
    this.f = paramBaseChatPie;
  }
  
  public int[] C()
  {
    return new int[] { 3, 7, 13 };
  }
  
  public void Ck(int paramInt)
  {
    Object localObject = null;
    switch (paramInt)
    {
    }
    for (;;)
    {
      if (localObject != null) {}
      try
      {
        ((Runnable)localObject).run();
        return;
      }
      catch (Exception localException)
      {
        QLog.e("AIOIconChangeByTimeHelper", 1, localException, new Object[0]);
      }
      this.a = new wtl.a(this.f, null);
      wtl.a.a(this.a);
      continue;
      this.f.app.addObserver(this.b);
      localObject = new AIOIconChangeByTimeHelper.1(this);
      continue;
      this.f.app.removeObserver(this.b);
      localObject = new AIOIconChangeByTimeHelper.2(this);
    }
  }
  
  public static final class a
    extends BroadcastReceiver
  {
    private WeakReference<BaseChatPie> dT;
    private Calendar mCalendar;
    
    private a(BaseChatPie paramBaseChatPie)
    {
      this.dT = new WeakReference(paramBaseChatPie);
    }
    
    private void cbI()
    {
      BaseChatPie localBaseChatPie = (BaseChatPie)this.dT.get();
      if (localBaseChatPie != null)
      {
        if (this.mCalendar == null) {
          this.mCalendar = Calendar.getInstance();
        }
        this.mCalendar.setTimeInMillis(System.currentTimeMillis());
        int i = this.mCalendar.get(11);
        if ((i < 19) && (i >= 7)) {
          break label81;
        }
      }
      label81:
      for (boolean bool = true; Looper.getMainLooper() == Looper.myLooper(); bool = false)
      {
        localBaseChatPie.b.zy(bool);
        return;
      }
      localBaseChatPie.getUIHandler().post(new AIOIconChangeByTimeHelper.TimeChangeReceiver.1(this, localBaseChatPie, bool));
    }
    
    public void onReceive(Context paramContext, Intent paramIntent)
    {
      paramContext = paramIntent.getAction();
      if ("android.intent.action.TIME_TICK".equals(paramContext)) {
        cbI();
      }
      do
      {
        return;
        if ("android.intent.action.TIME_SET".equals(paramContext))
        {
          cbI();
          return;
        }
      } while (!"android.intent.action.TIMEZONE_CHANGED".equals(paramContext));
      cbI();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wtl
 * JD-Core Version:    0.7.0.1
 */