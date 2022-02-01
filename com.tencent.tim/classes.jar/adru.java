import android.app.Dialog;
import android.text.TextUtils;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.swift.WebViewPlugin.a;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import java.util.concurrent.ConcurrentHashMap;

class adru
  implements View.OnClickListener
{
  adru(adrt paramadrt) {}
  
  public void onClick(View paramView)
  {
    if ((adrt.a(this.a) == 0) && (!TextUtils.isEmpty(adrt.a(this.a))))
    {
      adrt.a(this.a).put(adrt.b(this.a), Integer.valueOf(1));
      WebViewFragment localWebViewFragment = this.a.mRuntime.b();
      if (localWebViewFragment != null) {
        localWebViewFragment.j.loadUrl(adrt.a(this.a));
      }
      adrt.a(this.a, null);
    }
    adrt.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adru
 * JD-Core Version:    0.7.0.1
 */