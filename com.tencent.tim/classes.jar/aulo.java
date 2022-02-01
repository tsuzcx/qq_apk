import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.CustomWebView;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.teamwork.SharePolicyInfo;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aulo
  implements View.OnClickListener
{
  aulo(auln paramauln) {}
  
  public void onClick(View paramView)
  {
    if ((auln.a(this.this$0) instanceof CustomWebView))
    {
      if (2 != auln.a(this.this$0).taskType) {
        break label57;
      }
      ((CustomWebView)auln.a(this.this$0)).callJs("openAdvPermissionsMobile()");
      this.this$0.dismiss();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      label57:
      ((CustomWebView)auln.a(this.this$0)).callJs("openCooperationMobile()");
      this.this$0.dismiss();
      anot.a(((SplashActivity)auln.a(this.this$0)).app, "dc00898", "", "", "0x8009412", "0x8009412", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aulo
 * JD-Core Version:    0.7.0.1
 */