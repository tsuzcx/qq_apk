import android.app.Activity;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.app.ToolAppRuntime;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public abstract class uaz
  extends tzh
{
  protected uaz.a a;
  
  protected void bFe()
  {
    this.a = new uaz.a(this.b.getActivity());
  }
  
  public static class a
  {
    WeakReference<aqzv> ds = null;
    WeakReference<Activity> mActivity;
    WeakReference<WebViewFragment> mFragment = null;
    WeakReference<CustomWebView> mWebView;
    WeakReference<AppInterface> n;
    
    public a(Activity paramActivity)
    {
      this.mActivity = new WeakReference(paramActivity);
    }
    
    public aqzv a()
    {
      Activity localActivity;
      if (this.ds == null)
      {
        localActivity = getActivity();
        if (!(localActivity instanceof aqzv)) {
          break label45;
        }
      }
      label45:
      for (this.ds = new WeakReference((aqzv)localActivity);; this.ds = new WeakReference(b())) {
        return (aqzv)this.ds.get();
      }
    }
    
    public AppInterface a()
    {
      AppRuntime localAppRuntime;
      if (this.n == null)
      {
        localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
        if (!(localAppRuntime instanceof ToolAppRuntime)) {
          break label52;
        }
        this.n = new WeakReference((AppInterface)localAppRuntime.getAppRuntime("modular_web"));
      }
      for (;;)
      {
        return (AppInterface)this.n.get();
        label52:
        if ((localAppRuntime instanceof AppInterface)) {
          this.n = new WeakReference((AppInterface)localAppRuntime);
        } else {
          this.n = new WeakReference(null);
        }
      }
    }
    
    public WebViewFragment b()
    {
      Activity localActivity;
      if (this.mFragment == null)
      {
        localActivity = getActivity();
        if (!(localActivity instanceof aqzs)) {
          break label50;
        }
      }
      label50:
      for (this.mFragment = new WeakReference(((aqzs)localActivity).c());; this.mFragment = new WeakReference(null)) {
        return (WebViewFragment)this.mFragment.get();
      }
    }
    
    public Activity getActivity()
    {
      return (Activity)this.mActivity.get();
    }
    
    public CustomWebView getWebView()
    {
      WebViewFragment localWebViewFragment;
      if (this.mWebView == null)
      {
        localWebViewFragment = b();
        if (localWebViewFragment == null) {
          break label42;
        }
      }
      label42:
      for (this.mWebView = new WeakReference(localWebViewFragment.getWebView());; this.mWebView = new WeakReference(null)) {
        return (CustomWebView)this.mWebView.get();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uaz
 * JD-Core Version:    0.7.0.1
 */