import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avnc
  implements View.OnClickListener
{
  avnc(avna paramavna) {}
  
  public void onClick(View paramView)
  {
    if (this.a.mRuntime.getWebView() != null) {
      this.a.mRuntime.getWebView().loadUrl("javascript:" + avna.a(this.a) + "()");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avnc
 * JD-Core Version:    0.7.0.1
 */