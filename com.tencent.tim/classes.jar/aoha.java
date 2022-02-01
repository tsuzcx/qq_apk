import android.app.Activity;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.e;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.theme.ThemeCleaner;
import com.tencent.mobileqq.theme.ThemeSwitchManager.1;
import com.tencent.mobileqq.theme.diy.ThemeDiyStyleLogic.a;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import java.util.concurrent.atomic.AtomicBoolean;
import mqq.app.AppRuntime;
import mqq.manager.Manager;

public class aoha
  implements Manager
{
  public ImageView DU;
  arhz T;
  private ThemeCleaner a;
  public AppInterface app;
  public ThemeDiyStyleLogic.a c;
  public AtomicBoolean dT = new AtomicBoolean(false);
  public Bitmap gq;
  WeakReference<Activity> mActivityRef;
  Handler mUiHandler = new aohb(this, Looper.getMainLooper());
  View rootView;
  
  public aoha(AppRuntime paramAppRuntime)
  {
    if ((paramAppRuntime instanceof AppInterface)) {
      this.app = ((AppInterface)paramAppRuntime);
    }
    if ((paramAppRuntime instanceof QQAppInterface))
    {
      this.a = new ThemeCleaner();
      this.app.getApplication().registerReceiver(this.a, new IntentFilter("com.tencent.qplus.THEME_INVALIDATE"), "com.tencent.tim.msg.permission.pushnotify", null);
    }
  }
  
  public static boolean F(Bundle paramBundle)
  {
    boolean bool3 = false;
    String str = DeviceProfileManager.a().aJ(DeviceProfileManager.DpcNames.theme_profile.name(), "1|1|1");
    if (QLog.isColorLevel()) {
      QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate profileStr:" + str);
    }
    if (!TextUtils.isEmpty(str))
    {
      Integer[] arrayOfInteger = new Integer[3];
      arrayOfInteger[0] = Integer.valueOf(0);
      arrayOfInteger[1] = Integer.valueOf(0);
      arrayOfInteger[2] = Integer.valueOf(0);
      int i = DeviceProfileManager.a(str, arrayOfInteger, new DeviceProfileManager.e());
      if (QLog.isColorLevel()) {
        QLog.i("ThemeSwitchManager", 2, "getIsEnableAnimate size:" + i + ", params:" + arrayOfInteger);
      }
      if (i >= 3)
      {
        boolean bool1;
        if (arrayOfInteger[0].intValue() == 1)
        {
          bool1 = true;
          if (arrayOfInteger[1].intValue() != 1) {
            break label223;
          }
        }
        label223:
        for (boolean bool2 = true;; bool2 = false)
        {
          if (arrayOfInteger[2].intValue() == 1) {
            bool3 = true;
          }
          if (paramBundle != null)
          {
            paramBundle.putBoolean("dynamic_switch", bool1);
            paramBundle.putBoolean("dynamic_enable", bool2);
            paramBundle.putBoolean("dynamic_webview_enable", bool3);
          }
          return true;
          bool1 = false;
          break;
        }
      }
    }
    return false;
  }
  
  public void ci(Activity paramActivity)
  {
    this.mActivityRef = new WeakReference(paramActivity);
    this.mUiHandler.sendEmptyMessage(200);
  }
  
  public void dUB()
  {
    try
    {
      if ((this.mActivityRef == null) || (this.mActivityRef.get() == null))
      {
        QLog.e("ThemeSwitchManager", 1, "doScreenShot, currActivityRef is null");
        return;
      }
      Activity localActivity = (Activity)this.mActivityRef.get();
      if (this.rootView == null)
      {
        localObject = localActivity.getWindow();
        if (localObject != null)
        {
          localObject = ((Window)localObject).getDecorView();
          if (localObject != null) {
            this.rootView = ((View)localObject).getRootView();
          }
        }
      }
      if (this.rootView == null)
      {
        if (!QLog.isColorLevel()) {
          return;
        }
        QLog.d("ThemeSwitchManager", 2, "doScreenShot, rootView is null");
      }
    }
    catch (Throwable localThrowable)
    {
      Object localObject;
      QLog.e("ThemeSwitchManager", 1, "doScreenShot oom, no animation", localThrowable);
      this.gq = null;
      if ((this.DU != null) && (this.DU.getParent() != null)) {
        ((ViewGroup)this.DU.getParent()).removeView(this.DU);
      }
      this.DU = null;
      while (QLog.isColorLevel())
      {
        QLog.d("ThemeSwitchManager", 2, "drawingCache is:" + this.gq);
        return;
        boolean bool1 = this.rootView.isDrawingCacheEnabled();
        boolean bool2 = this.rootView.willNotCacheDrawing();
        this.rootView.setDrawingCacheEnabled(true);
        this.rootView.setWillNotCacheDrawing(false);
        localObject = this.rootView.getDrawingCache();
        if (localObject != null)
        {
          this.gq = Bitmap.createBitmap((Bitmap)localObject);
          this.DU = new ImageView(localThrowable);
          this.DU.setImageBitmap(this.gq);
          if ((localThrowable instanceof QQBrowserActivity))
          {
            this.DU.setAlpha(220);
            if (QLog.isColorLevel()) {
              QLog.d("ThemeSwitchManager", 2, "doScreenShot, refActivity is QQBrowserActivity");
            }
          }
          ViewGroup localViewGroup = (ViewGroup)this.rootView;
          this.DU.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
          localViewGroup.addView(this.DU);
        }
        this.rootView.setDrawingCacheEnabled(bool1);
        this.rootView.setWillNotCacheDrawing(bool2);
      }
    }
  }
  
  public void dUC()
  {
    this.mUiHandler.sendEmptyMessage(201);
  }
  
  public void onDestroy()
  {
    if (this.a != null) {
      this.app.getApplication().unregisterReceiver(this.a);
    }
    this.app = null;
    if ((this.T != null) && (this.T.isShowing()))
    {
      this.T.dismiss();
      this.T = null;
    }
  }
  
  public void onPostThemeChanged()
  {
    if ((this.T != null) && (this.T.isShowing()))
    {
      this.T.dismiss();
      this.T = null;
    }
    if (this.rootView == null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged rootView is null");
      }
      return;
    }
    if (this.gq != null) {
      if ((!this.dT.get()) && (this.DU != null))
      {
        this.dT.set(true);
        AlphaAnimation localAlphaAnimation = new AlphaAnimation(1.0F, 0.1F);
        localAlphaAnimation.setDuration(501L);
        localAlphaAnimation.setInterpolator(new LinearInterpolator());
        localAlphaAnimation.setFillAfter(true);
        this.DU.setAnimation(localAlphaAnimation);
        this.rootView.postDelayed(new ThemeSwitchManager.1(this), 601L);
      }
    }
    for (;;)
    {
      this.rootView = null;
      return;
      if (QLog.isColorLevel()) {
        QLog.d("ThemeSwitchManager", 2, "onPostThemeChanged drawingCache is null");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aoha
 * JD-Core Version:    0.7.0.1
 */