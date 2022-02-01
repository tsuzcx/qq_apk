import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class awhf
  implements View.OnClickListener
{
  awhf(awhe paramawhe) {}
  
  public void onClick(View paramView)
  {
    if ((this.a.mRuntime.a() != null) && (this.a.mRuntime.getWebView() != null))
    {
      String str = avpw.a.l("qzone", String.valueOf(1), this.a.mRuntime.a().getAccount(), this.a.mRuntime.a().getAccount());
      this.a.mRuntime.getWebView().loadUrl(str);
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awhf
 * JD-Core Version:    0.7.0.1
 */