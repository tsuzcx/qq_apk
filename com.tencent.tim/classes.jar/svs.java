import android.app.Activity;
import android.content.res.Resources;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.WindowManager;
import android.view.WindowManager.LayoutParams;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.biz.webviewplugin.UrlCheckPlugin.1;
import com.tencent.biz.webviewplugin.UrlCheckPlugin.4;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class svs
  extends WebViewPlugin
{
  public static int bzq;
  public static int bzr = 1;
  public static int bzs = 2;
  public static int bzt = 3;
  TextView Bb = null;
  public jnn a;
  boolean aNy = false;
  public int bzu = bzq;
  int code = 0;
  WindowManager.LayoutParams d = null;
  int delay = 0;
  int duration = 0;
  RelativeLayout gd = null;
  BaseActivity mActivity = null;
  ImageView oQ = null;
  public Runnable task = new UrlCheckPlugin.4(this);
  CustomWebView webView = null;
  WindowManager windowManager = null;
  
  public svs()
  {
    this.mPluginNameSpace = "URL_CHECK";
  }
  
  private void bBm()
  {
    if (this.a == null) {
      this.a = new jnn(this.webView, new svt(this));
    }
  }
  
  public void bBn()
  {
    Object localObject = this.mRuntime.getActivity();
    if ((localObject != null) && (!((Activity)localObject).isFinishing()) && (this.gd != null) && (this.bzu == bzs))
    {
      localObject = ((Activity)localObject).getWindowManager();
      this.bzu = bzt;
    }
    try
    {
      ((WindowManager)localObject).removeView(this.gd);
      return;
    }
    catch (IllegalArgumentException localIllegalArgumentException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e(this.TAG, 2, "removeView Error:" + localIllegalArgumentException.getMessage());
    }
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    this.webView = this.mRuntime.getWebView();
    if (this.webView == null) {}
    do
    {
      do
      {
        do
        {
          return false;
          paramString = this.mRuntime.getActivity();
        } while (!(paramString instanceof BaseActivity));
        this.mActivity = ((BaseActivity)paramString);
        bBm();
        if (paramLong != 8589934597L) {
          break;
        }
        if (this.a != null)
        {
          this.a.destroy();
          this.a = null;
        }
      } while ((this.bzu != bzs) || (this.oQ == null));
      this.oQ.setOnClickListener(null);
      this.webView.removeCallbacks(this.task);
      bBn();
      return false;
    } while ((paramLong != 8589934594L) || (this.code != 2) || (this.bzu == bzs));
    this.webView.postDelayed(new UrlCheckPlugin.1(this), this.delay);
    return false;
  }
  
  public void onDestroy()
  {
    if (this.a != null)
    {
      this.a.destroy();
      this.a = null;
    }
    super.onDestroy();
  }
  
  public void setData(int paramInt1, int paramInt2, int paramInt3)
  {
    this.code = paramInt1;
    this.delay = paramInt2;
    this.duration = paramInt3;
  }
  
  public void yR(int paramInt)
  {
    Object localObject = this.mRuntime.getActivity();
    if (!(localObject instanceof BaseActivity)) {}
    for (;;)
    {
      return;
      if (this.webView == null) {
        continue;
      }
      if (this.gd == null)
      {
        this.mActivity = ((BaseActivity)localObject);
        this.gd = ((RelativeLayout)this.mActivity.getLayoutInflater().inflate(2131559173, null));
        this.Bb = ((TextView)this.gd.findViewById(2131379951));
        this.oQ = ((ImageView)this.gd.findViewById(2131379945));
        this.windowManager = this.mActivity.getWindowManager();
        this.d = new WindowManager.LayoutParams();
        localObject = this.mActivity.getResources();
      }
      try
      {
        i = Resources.getSystem().getDimensionPixelSize(Resources.getSystem().getIdentifier("status_bar_height", "dimen", "android"));
        this.d.gravity = 49;
        this.d.y = (i + this.mActivity.getTitleBarHeight());
        this.d.type = 1002;
        this.d.format = 1;
        this.d.flags = 262664;
        this.d.width = -1;
        this.d.height = -2;
        if (this.oQ != null) {
          this.oQ.setOnClickListener(new svu(this));
        }
        if (this.windowManager == null) {
          this.windowManager = this.mActivity.getWindowManager();
        }
        if (this.Bb != null) {
          this.Bb.setText(this.mActivity.getResources().getText(paramInt));
        }
        this.webView.postDelayed(this.task, this.duration + this.delay);
        this.bzu = bzs;
        try
        {
          this.windowManager.addView(this.gd, this.d);
          return;
        }
        catch (Exception localException1) {}
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.e(this.TAG, 2, "addView exception:" + localException1.getMessage());
        return;
      }
      catch (Exception localException2)
      {
        for (;;)
        {
          int i = (int)(localException1.getDisplayMetrics().density * 25.0F + 0.5D);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     svs
 * JD-Core Version:    0.7.0.1
 */