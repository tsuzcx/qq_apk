import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.QQBrowserDelegationActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class aair
  implements View.OnClickListener
{
  aair(aahb paramaahb, String paramString) {}
  
  public void onClick(View paramView)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.recent.banner", 2, "click move to url:" + this.bdh);
    }
    Intent localIntent = new Intent(aahb.a(this.this$0), QQBrowserDelegationActivity.class);
    localIntent.putExtra("injectrecommend", true);
    aahb.a(this.this$0).startActivity(localIntent.putExtra("url", this.bdh));
    anot.c(aahb.a(this.this$0).app, "CliOper", "", "", "0X8004029", "0X8004029", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aair
 * JD-Core Version:    0.7.0.1
 */