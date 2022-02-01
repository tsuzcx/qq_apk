import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.phone.GuideBindPhoneActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import mqq.os.MqqHandler;

class aaij
  implements View.OnClickListener
{
  aaij(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    Intent localIntent = new Intent(aahb.a(this.this$0), GuideBindPhoneActivity.class);
    localIntent.putExtra("fromKeyForContactBind", 4);
    aahb.a(this.this$0).startActivity(localIntent);
    aahb.a(this.this$0).getSharedPreferences("contact_bind_info" + aahb.a(this.this$0).app.getAccount(), 0).edit().putBoolean("key_show_contact_banner", false).commit();
    this.this$0.gm(15, 0);
    aahb.a(this.this$0).removeMessages(11);
    anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 13, 0, "", "", "", "");
    anot.a(aahb.a(this.this$0).app, "CliOper", "", "", "0X80053D9", "0X80053D9", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaij
 * JD-Core Version:    0.7.0.1
 */