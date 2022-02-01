import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class wit
  implements Handler.Callback
{
  public static long HK;
  private static wit a;
  public static int bND;
  public static boolean bcB = true;
  private static boolean bcC;
  private Handler mUIHandler = new auru(Looper.getMainLooper(), this);
  
  static
  {
    HK = -1L;
    a = new wit();
    bYq();
  }
  
  public static wit a()
  {
    try
    {
      wit localwit = a;
      return localwit;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public static void bYq()
  {
    boolean bool1 = true;
    for (;;)
    {
      Object localObject1;
      try
      {
        boolean bool2 = bcC;
        if (bool2) {
          return;
        }
      }
      finally {}
      try
      {
        localObject1 = DeviceProfileManager.b().aJ(DeviceProfileManager.DpcNames.aio_config.name(), "-1|1=0,2=0,3=0,4=0,5=1|1");
        if (QLog.isColorLevel()) {
          QLog.i("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc thumbConfig:" + (String)localObject1);
        }
        localObject1 = ((String)localObject1).split("\\|");
        if (localObject1.length > 2)
        {
          if (!"1".equals(localObject1[2])) {
            break label137;
          }
          bcB = bool1;
        }
      }
      catch (Exception localException)
      {
        label137:
        bcB = false;
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc error|" + bcB);
        continue;
      }
      bcC = true;
      if (QLog.isColorLevel())
      {
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "initAIOPreloadFlagByDpc|" + bcB);
        continue;
        bool1 = false;
      }
    }
  }
  
  @TargetApi(17)
  private void by(Activity paramActivity)
  {
    SplashActivity localSplashActivity;
    label122:
    FragmentManager localFragmentManager;
    Fragment localFragment;
    if ((paramActivity != null) && ((paramActivity instanceof SplashActivity)))
    {
      if ((bND == 1) || (QQAppInterface.bIQ)) {
        if (QLog.isColorLevel()) {
          QLog.e("Q.aio.AIOPreLoadEngine", 2, "sPreloadedAIOType:" + bND + "|AIO_HAD_OPEN:" + QQAppInterface.bIQ);
        }
      }
      do
      {
        return;
        localSplashActivity = (SplashActivity)paramActivity;
        if ((localSplashActivity.app != null) && (localSplashActivity.app.isRunning()) && (localSplashActivity.app.isLogin())) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.e("Q.aio.AIOPreLoadEngine", 2, "app is not valid");
      return;
      if (!QLog.isColorLevel())
      {
        localFragmentManager = localSplashActivity.getSupportFragmentManager();
        localFragment = localFragmentManager.findFragmentByTag(ChatFragment.class.getName());
        if (((Build.VERSION.SDK_INT <= 16) || (!paramActivity.isDestroyed())) && (!paramActivity.isFinishing())) {
          break label296;
        }
      }
    }
    label296:
    for (boolean bool = false;; bool = true)
    {
      if ((localFragment == null) && (bool))
      {
        HK = SystemClock.uptimeMillis();
        aqmq.track(null, "AIO_preLoad_Cost");
        try
        {
          paramActivity = localFragmentManager.beginTransaction();
          paramActivity.add(16908290, ChatFragment.a(), ChatFragment.class.getName());
          localSplashActivity.setIntent(new Intent());
          paramActivity.commitAllowingStateLoss();
          bND = 1;
          return;
        }
        catch (Exception paramActivity)
        {
          QLog.e("Q.aio.AIOPreLoadEngine", 1, "AIO preLoad:", paramActivity);
          return;
        }
        QLog.d("Q.aio.AIOPreLoadEngine", 2, "doRealPreLoadAIO");
        break label122;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "AIO cannot peload:" + bool);
      return;
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.i("Q.aio.AIOPreLoadEngine", 2, "activity is not splashActivity");
      return;
    }
  }
  
  public void bYr()
  {
    if (this.mUIHandler.hasMessages(1)) {
      this.mUIHandler.removeMessages(1);
    }
  }
  
  public void f(BaseActivity paramBaseActivity)
  {
    if (!bcB) {
      if (QLog.isColorLevel()) {
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO return");
      }
    }
    for (;;)
    {
      return;
      if (!QLog.isColorLevel()) {}
      while (paramBaseActivity != null)
      {
        Message localMessage = this.mUIHandler.obtainMessage();
        localMessage.what = 1;
        localMessage.obj = paramBaseActivity;
        this.mUIHandler.sendMessage(localMessage);
        return;
        QLog.i("Q.aio.AIOPreLoadEngine", 2, "startPreLoadAIO");
      }
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return false;
      if (paramMessage.obj != null) {
        by((Activity)paramMessage.obj);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wit
 * JD-Core Version:    0.7.0.1
 */