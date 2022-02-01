import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.fragment.CommonTabFragment;
import com.tencent.mobileqq.fragment.CommonTabFragment.a;
import com.tencent.mobileqq.webview.swift.WebViewPluginEngine;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ahms
  implements View.OnClickListener
{
  public ahms(CommonTabFragment paramCommonTabFragment) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.a == null) || (this.a.a.mWebview == null)) {}
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      WebViewPluginEngine localWebViewPluginEngine = this.a.a.mWebview.getPluginEngine();
      if (localWebViewPluginEngine != null) {
        localWebViewPluginEngine.handleEvent(this.a.a.mWebview.getUrl(), 8589934606L, null);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahms
 * JD-Core Version:    0.7.0.1
 */