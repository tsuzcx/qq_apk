package com.tencent.mobileqq.startup.step;

import acfp;
import actf;
import android.app.Activity;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.pm.ApplicationInfo;
import android.os.Build.VERSION;
import android.os.Environment;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Looper;
import android.os.Message;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewGroup.LayoutParams;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import anmo;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import mqq.app.AppActivity;

public class Update
  extends Step
  implements Handler.Callback
{
  private static final int[] of = { 37, 23, 24, 25, 34, 35, 36 };
  private double cZ;
  private int dKm;
  private int dKn;
  private ViewGroup decorView;
  private RelativeLayout loadingLayout;
  private TextView loadingTv;
  private Handler mHandler;
  private int mStartProgress;
  private long mStartTime;
  private ProgressBar progressBar;
  
  private void aAt()
  {
    if ((this.decorView != null) && (this.loadingLayout != null)) {}
    try
    {
      this.decorView.removeView(this.loadingLayout);
      this.decorView = null;
      this.loadingLayout = null;
      this.progressBar = null;
      this.loadingTv = null;
      return;
    }
    catch (Throwable localThrowable)
    {
      for (;;)
      {
        QLog.d("AutoMonitor", 1, "", localThrowable);
      }
    }
  }
  
  private int getPercentage()
  {
    double d2 = (System.currentTimeMillis() - this.mStartTime) * 1.0D / this.dKn * (this.dKm - this.mStartProgress) + this.mStartProgress;
    double d1;
    if (d2 < this.mStartProgress) {
      d1 = this.mStartProgress;
    }
    do
    {
      return (int)d1;
      d1 = d2;
    } while (d2 <= this.dKm - 10);
    if (this.cZ < this.dKm - 10) {}
    for (this.cZ = (this.dKm - 10);; this.cZ += (this.dKm - this.cZ) / 10.0D)
    {
      d1 = this.cZ;
      break;
    }
  }
  
  protected boolean doStep()
  {
    this.dKn = 13500;
    Object localObject1;
    if (!"Success".equals(BaseApplicationImpl.sInjectResult))
    {
      this.mHandler = new Handler(Looper.getMainLooper(), this);
      this.mHandler.sendEmptyMessage(1);
      if (Build.VERSION.SDK_INT < 21)
      {
        localObject1 = System.getProperty("java.vm.version");
        if ((localObject1 != null) && (!((String)localObject1).startsWith("1"))) {
          this.dKn += 30000;
        }
      }
    }
    for (;;)
    {
      String str1;
      String str2;
      try
      {
        Thread.sleep(300L);
        bool1 = Step.a.b(4, this.mDirector, null).step();
        if (!bool1) {
          break label839;
        }
        localObject1 = BaseApplicationImpl.sApplication.getSharedPreferences("StepUpdate", 4);
        str1 = "ProcFirstLaunch" + BaseApplicationImpl.processName;
        localObject2 = ((SharedPreferences)localObject1).getString(str1, "null");
        QLog.i("AutoMonitor", 1, String.format("updateVersion %s %s %s", new Object[] { str1, localObject2, String.valueOf(AppSetting.getRevision()) }));
        if (TextUtils.equals(AppSetting.getRevision(), (CharSequence)localObject2)) {
          break label839;
        }
        BaseApplicationImpl.isCurrentVersionFirstLaunch = true;
        BaseApplicationImpl.sLaunchTime = 0L;
        BaseApplicationImpl.sShowTime = 0L;
        if (TextUtils.isEmpty((CharSequence)localObject2)) {
          BaseApplicationImpl.isFirstLaunchNew = true;
        }
        Step.a.b(28, this.mDirector, null).step();
        if (BaseApplicationImpl.sProcessId != 1) {
          break label907;
        }
        if (((SharedPreferences)localObject1).getBoolean("HasDelSharppSo", false)) {
          break label895;
        }
        QLog.d("DelSharpp", 1, "start del sharpp");
      }
      catch (InterruptedException localInterruptedException)
      {
        try
        {
          str2 = Environment.getExternalStorageDirectory().getAbsolutePath();
          Object localObject2 = new String[8];
          localObject2[0] = (BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/libTcHevcDec.so");
          localObject2[1] = (BaseApplicationImpl.getContext().getApplicationInfo().nativeLibraryDir + "/libTcHevcDec.so");
          localObject2[2] = (BaseApplicationImpl.getContext().getFilesDir() + "/pddata/prd/early/qq.android.qav.sov8_826");
          localObject2[3] = (str2 + "/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826");
          localObject2[4] = (str2 + "/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/qq.android.qav.sov8_826");
          localObject2[5] = (BaseApplicationImpl.getContext().getFilesDir().getParent() + "/txlib/cmshow/libTcHevcDec.so");
          localObject2[6] = (str2 + "/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800");
          localObject2[7] = (str2 + "/Android/data/com.tencent.mobileqq/Tencent/MobileQQ/pddata/prd/early/android.qq.apollo.jsc800");
          int j = localObject2.length;
          int i = 0;
          if (i < j)
          {
            str2 = localObject2[i];
            bool2 = true;
            File localFile = new File(str2);
            if (localFile.exists())
            {
              bool2 = localFile.delete();
              QLog.d("DelSharpp", 1, "exist" + str2);
              if (bool2) {
                break label865;
              }
              QLog.d("DelSharpp", 1, " del fail" + str2);
              i += 1;
              continue;
              localInterruptedException = localInterruptedException;
              localInterruptedException.printStackTrace();
              continue;
            }
            QLog.d("DelSharpp", 1, "not exist" + str2);
            continue;
          }
          if (Looper.getMainLooper() == Looper.myLooper()) {
            break label839;
          }
        }
        catch (Throwable localThrowable)
        {
          QLog.e("DelSharpp", 1, "Fail to del files." + localThrowable);
          QLog.d("DelSharpp", 1, "end del sharpp");
          localInterruptedException.edit().putBoolean("HasDelSharppSo", true).commit();
        }
      }
      label718:
      if (this.mHandler == null)
      {
        this.mHandler = new Handler(Looper.getMainLooper(), this);
        this.mHandler.sendEmptyMessage(1);
      }
      boolean bool2 = Step.a.b(0, this.mDirector, of).step();
      QLog.e("AutoMonitor", 1, "UPDATE_STEPS " + bool2);
      localInterruptedException.edit().putString(str1, AppSetting.getRevision()).commit();
      if (!BaseApplicationImpl.isFirstLaunchNew) {
        actf.a().dT(BaseApplicationImpl.getContext());
      }
      for (;;)
      {
        label839:
        if (this.mHandler != null)
        {
          this.mHandler.removeMessages(2);
          this.mHandler.sendEmptyMessage(3);
        }
        return bool1;
        label865:
        QLog.d("DelSharpp", 1, " del succ" + str2);
        break;
        label895:
        QLog.d("DelSharpp", 1, "has del sharpp");
        break label718;
        label907:
        localInterruptedException.edit().putString(str1, AppSetting.getRevision()).commit();
      }
      boolean bool1 = true;
    }
  }
  
  public boolean handleMessage(Message paramMessage)
  {
    QLog.i("AutoMonitor", 1, "updateMessage " + paramMessage);
    AppActivity localAppActivity = this.mDirector.d;
    switch (paramMessage.what)
    {
    default: 
    case 1: 
    case 2: 
      int i;
      do
      {
        do
        {
          do
          {
            return true;
          } while (localAppActivity == null);
          try
          {
            this.decorView = ((ViewGroup)localAppActivity.getWindow().getDecorView());
            if (this.decorView != null)
            {
              this.loadingLayout = ((RelativeLayout)View.inflate(this.mDirector.d.getApplicationContext(), 2131563106, null));
              this.loadingLayout.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
              this.progressBar = ((ProgressBar)this.loadingLayout.findViewById(2131368614));
              this.loadingTv = ((TextView)this.loadingLayout.findViewById(2131370818));
              this.loadingTv.setText(acfp.m(2131716251));
              this.decorView.addView(this.loadingLayout);
            }
            this.mHandler.sendEmptyMessage(2);
            this.mStartTime = System.currentTimeMillis();
            this.mStartProgress = 0;
            this.dKm = 99;
            return true;
          }
          catch (Throwable paramMessage)
          {
            for (;;)
            {
              QLog.d("AutoMonitor", 1, "", paramMessage);
              aAt();
            }
          }
          i = getPercentage();
          if (this.progressBar == null) {
            break;
          }
        } while (this.progressBar.getProgress() > i);
        this.progressBar.setProgress(i);
        if (this.loadingTv != null) {
          this.loadingTv.setText(String.format(this.mDirector.d.getString(2131693748), new Object[] { Integer.valueOf(i) }));
        }
      } while (i >= 99);
      this.mHandler.sendEmptyMessageDelayed(2, 100L);
      return true;
    }
    aAt();
    this.mHandler.removeMessages(2);
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.startup.step.Update
 * JD-Core Version:    0.7.0.1
 */