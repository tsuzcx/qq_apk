import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.ui.TouchWebView;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class avok
  implements View.OnClickListener
{
  avok(avoj paramavoj) {}
  
  public void onClick(View paramView)
  {
    avof.c(avoj.a(this.a), avoj.b(this.a), "5", "27", "", "3", "", "", "");
    this.a.a.c.j.loadUrl("jsbridge://JSTittlebarAction/managerBtnSingleClick");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     avok
 * JD-Core Version:    0.7.0.1
 */