package cooperation.qqreader.ui;

import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.view.Window;
import avoc;
import avoj;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewTabBarData;

public class ReaderContentPageActivity
  extends ReaderBaseWebActivity
{
  private boolean dnF;
  
  public WebViewFragment a(WebViewTabBarData paramWebViewTabBarData)
  {
    if (this.dnF) {
      return ReaderSplashPageFragment.a(getIntent());
    }
    return super.a(paramWebViewTabBarData);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.dnF) {}
    Object localObject;
    Window localWindow;
    do
    {
      do
      {
        return;
        localObject = (ReaderBaseFragment)c();
      } while ((localObject == null) || (!((ReaderBaseFragment)localObject).dnD));
      localObject = (avoj)((ReaderBaseFragment)localObject).a;
      localWindow = getWindow();
    } while ((localObject == null) || (localWindow == null));
    ((avoj)localObject).b(false, localWindow);
  }
  
  public void onCreate(Bundle paramBundle)
  {
    this.dnF = getIntent().getBooleanExtra("is_to_splash_activity", false);
    if (this.dnF) {
      bSL();
    }
    super.onCreate(paramBundle);
    if (Build.VERSION.SDK_INT < 26) {
      setRequestedOrientation(1);
    }
    avoc.u("ReaderContentPageActivity", "mIsSplash = " + this.dnF);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.ui.ReaderContentPageActivity
 * JD-Core Version:    0.7.0.1
 */