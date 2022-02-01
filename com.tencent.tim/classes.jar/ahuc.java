import android.os.Handler;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.ThreadManagerV2;
import com.tencent.mobileqq.gamecenter.util.QQGameHelper.2.2;
import com.tencent.mobileqq.gamecenter.web.view.QQGamePubWebView;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.smtt.sdk.WebSettings;

public final class ahuc
  extends arcj.a
{
  ahuc(int paramInt)
  {
    super(paramInt);
  }
  
  public int run()
  {
    for (;;)
    {
      try
      {
        QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> do preloadsw ");
        if (!ahua.access$000()) {
          return 0;
        }
        ahua.jY(NetConnInfoCenter.getServerTimeMillis());
        QQGamePubWebView localQQGamePubWebView = new QQGamePubWebView(BaseApplicationImpl.sApplication);
        WebSettings localWebSettings = localQQGamePubWebView.getSettings();
        String str = localWebSettings.getUserAgentString();
        if (localQQGamePubWebView.getX5WebViewExtension() != null)
        {
          bool = true;
          localWebSettings.setUserAgentString(arcp.b(str, "", bool));
          localWebSettings.setJavaScriptEnabled(true);
          localQQGamePubWebView.loadUrl(ahty.getPreloadUrl());
          QLog.i("QQGameHelper", 1, "SwiftBrowserIdleTask--> loadUrl " + ahty.getPreloadUrl());
          localQQGamePubWebView.setWebChromeClient(new ahud(this));
          ThreadManagerV2.getUIHandlerV2().postDelayed(new QQGameHelper.2.2(this, localQQGamePubWebView), 15000L);
          return 0;
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.e("QQGameHelper", 1, QLog.getStackTraceString(localThrowable));
        return 0;
      }
      boolean bool = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahuc
 * JD-Core Version:    0.7.0.1
 */