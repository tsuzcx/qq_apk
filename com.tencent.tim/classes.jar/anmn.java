import android.app.Activity;
import android.content.Intent;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.webview.swift.WebViewPlugin;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qphone.base.util.QLog;
import java.util.Map;

public class anmn
  extends WebViewPlugin
{
  private boolean cIu;
  
  public anmn()
  {
    this.mPluginNameSpace = "splashADPlugin";
  }
  
  public boolean handleEvent(String paramString, long paramLong, Map<String, Object> paramMap)
  {
    if (paramLong == 8589934598L)
    {
      QLog.i("QSplash@QbossSplashUtil", 1, "handleEvent finish or destroy. isFromSP:" + this.cIu);
      if (this.cIu) {
        this.mRuntime.getActivity().startActivity(new Intent(this.mRuntime.getActivity(), SplashActivity.class));
      }
      return true;
    }
    return false;
  }
  
  public void onWebViewCreated(CustomWebView paramCustomWebView)
  {
    super.onWebViewCreated(paramCustomWebView);
    if (this.mRuntime.getActivity().getIntent() != null) {
      this.cIu = this.mRuntime.getActivity().getIntent().getBooleanExtra("key_from_splash_ad", false);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anmn
 * JD-Core Version:    0.7.0.1
 */