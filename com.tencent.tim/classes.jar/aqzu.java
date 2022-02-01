import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.webview.swift.WebViewFragment;
import com.tencent.mobileqq.webview.ui.WebViewTopTabView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aqzu
  implements RadioGroup.OnCheckedChangeListener
{
  aqzu(aqzt paramaqzt) {}
  
  public void onCheckedChanged(RadioGroup paramRadioGroup, int paramInt)
  {
    int i = this.a.a(paramRadioGroup);
    if (((QQBrowserActivity)this.a.a.s).bJk != i)
    {
      WebViewFragment localWebViewFragment = QQBrowserActivity.a(i, (QQBrowserActivity)this.a.a.s);
      ((QQBrowserActivity)this.a.a.s).bJk = i;
      if ((localWebViewFragment.a != null) && (localWebViewFragment.a.a != null)) {
        localWebViewFragment.a.a.setSelectedTab(i);
      }
    }
    EventCollector.getInstance().onCheckedChanged(paramRadioGroup, paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqzu
 * JD-Core Version:    0.7.0.1
 */