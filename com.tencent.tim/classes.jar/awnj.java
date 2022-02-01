import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import cooperation.qzone.util.QZLog;
import cooperation.vip.webview.controller.BaseTranslucentController.2;

public class awnj
{
  private volatile boolean auZ;
  protected QQBrowserActivity d;
  private volatile boolean dqX;
  private Runnable iF = new BaseTranslucentController.2(this);
  private BroadcastReceiver mReceiver = new awnk(this);
  private long mStartTime;
  protected Handler mUIHandler;
  
  public awnj(QQBrowserActivity paramQQBrowserActivity)
  {
    QZLog.i("BaseTranslucentControll", "current controller = " + getClass().getName());
    this.d = paramQQBrowserActivity;
    this.mUIHandler = new Handler(Looper.getMainLooper());
  }
  
  private void eDB()
  {
    try
    {
      if (this.auZ)
      {
        QZLog.i("BaseTranslucentControll", "removeBroadcast");
        try
        {
          this.d.unregisterReceiver(this.mReceiver);
          this.auZ = false;
          return;
        }
        catch (Exception localException1)
        {
          for (;;)
          {
            QZLog.e("BaseTranslucentControll", "unregisterReceiver error ", localException1);
          }
        }
      }
      return;
    }
    catch (Exception localException2)
    {
      QZLog.e("BaseTranslucentControll", "removeBroadcast error", localException2);
    }
  }
  
  private void registerBroadcast()
  {
    if (this.auZ) {}
    for (;;)
    {
      return;
      try
      {
        QZLog.i("BaseTranslucentControll", "registerBroadcast");
        IntentFilter localIntentFilter = new IntentFilter();
        String[] arrayOfString = ac();
        if (arrayOfString != null)
        {
          int j = arrayOfString.length;
          int i = 0;
          while (i < j)
          {
            localIntentFilter.addAction(arrayOfString[i]);
            i += 1;
          }
        }
        boolean bool = this.auZ;
        if (bool) {
          continue;
        }
        try
        {
          this.d.registerReceiver(this.mReceiver, localIntentFilter, "com.tencent.tim.msg.permission.pushnotify", null);
          this.auZ = true;
          return;
        }
        catch (Exception localException1)
        {
          QZLog.e("BaseTranslucentControll", "regist receiver error:", localException1);
          return;
        }
        return;
      }
      catch (Exception localException2)
      {
        QZLog.e("BaseTranslucentControll", "registerBroadcast error", localException2);
      }
    }
  }
  
  public void Xn(boolean paramBoolean)
  {
    View localView = this.d.findViewById(2131365379);
    if (localView == null) {
      return;
    }
    if (!paramBoolean)
    {
      if (System.currentTimeMillis() - this.mStartTime < 6000L)
      {
        localView.setAlpha(0.0F);
        this.dqX = false;
        QZLog.i("BaseTranslucentControll", "setAlpha(0)");
        return;
      }
      QZLog.i("BaseTranslucentControll", "isLoadSuccess = true，setAlpha(1)");
      jj(localView);
      return;
    }
    QZLog.i("BaseTranslucentControll", "isLoadSuccess = false，setAlpha(1)");
    jj(localView);
  }
  
  public String[] ac()
  {
    return null;
  }
  
  public void eEx()
  {
    Xn(true);
  }
  
  public void et(Intent paramIntent) {}
  
  protected void jj(View paramView)
  {
    if (!this.dqX)
    {
      this.dqX = true;
      QZLog.i("BaseTranslucentControll", "setAlpha(1)");
      if (paramView != null) {
        paramView.setAlpha(1.0F);
      }
    }
    for (;;)
    {
      try
      {
        if (this.d.c() != null)
        {
          paramView = this.d.c().getWebView();
          if (paramView != null)
          {
            Object localObject = paramView.getTag(2131376500);
            if ((localObject == null) || (!((Boolean)localObject).booleanValue())) {
              break label119;
            }
            i = 1;
            paramView.setTag(2131376497, Boolean.TRUE);
            if (i != 0)
            {
              QZLog.i("BaseTranslucentControll", "tiantai jsReady true,notify webview.");
              awfv.g(paramView);
              return;
            }
            QZLog.i("BaseTranslucentControll", "tiantai jsReady false,not notify webview.");
            return;
          }
        }
      }
      catch (Exception paramView)
      {
        QZLog.e("BaseTranslucentControll", "notify webview qzRoofStartAnimation fail.", paramView);
      }
      return;
      label119:
      int i = 0;
    }
  }
  
  public boolean onBackPressed()
  {
    return true;
  }
  
  public void onCreate()
  {
    this.mStartTime = System.currentTimeMillis();
    Xn(false);
    registerBroadcast();
    this.mUIHandler.postDelayed(this.iF, 6100L);
  }
  
  public void onDestory()
  {
    eDB();
    this.mUIHandler.removeCallbacks(this.iF);
  }
  
  public void onPause() {}
  
  public void onResume() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awnj
 * JD-Core Version:    0.7.0.1
 */