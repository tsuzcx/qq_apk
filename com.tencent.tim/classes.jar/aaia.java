import android.content.Intent;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aaia
  implements View.OnClickListener
{
  aaia(aahb paramaahb, String paramString) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), QQBrowserActivity.class);
    localIntent.putExtra("individuation_url_type", 40100);
    VasWebviewUtil.openQQBrowserWithoutAD(aahb.a(this.this$0), aqqj.e(aahb.a(this.this$0), "themeDetail", this.val$themeId, ""), 32L, localIntent, true, -1);
    aahb.a(this.this$0).obtainMessage(12).sendToTarget();
    anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X8005B9F", "0X8005B9F", 0, 0, "", "", "", "");
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 16, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaia
 * JD-Core Version:    0.7.0.1
 */