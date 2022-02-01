import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.webkit.URLUtil;
import com.tencent.mobileqq.activity.PhoneUnityBindInfoActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aaiq
  implements View.OnClickListener
{
  aaiq(aahb paramaahb, yut paramyut) {}
  
  public void onClick(View paramView)
  {
    anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8005B73", "0X8005B73", 0, 0, "", "", "", "");
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Intent localIntent;
    if (localBaseActivity != null)
    {
      if (!URLUtil.isValidUrl(this.b.url)) {
        break label151;
      }
      localIntent = new Intent(localBaseActivity, QQBrowserActivity.class);
      localIntent.putExtra("hide_operation_bar", true);
      localIntent.putExtra("url", this.b.url);
      localIntent.putExtra("hideRightButton", true);
      localBaseActivity.startActivity(localIntent);
    }
    for (;;)
    {
      this.this$0.gm(6, 0);
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 5, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label151:
      localIntent = new Intent(localBaseActivity, PhoneUnityBindInfoActivity.class);
      localIntent.putExtra("kSrouce", 0);
      localBaseActivity.startActivity(localIntent);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaiq
 * JD-Core Version:    0.7.0.1
 */