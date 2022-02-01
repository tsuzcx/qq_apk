import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.util.VersionUtils;

class aahl
  implements View.OnClickListener
{
  aahl(aahb paramaahb) {}
  
  public void onClick(View paramView)
  {
    if (VersionUtils.isHoneycomb()) {
      aahb.a(this.this$0).startActivity(new Intent("android.settings.SETTINGS"));
    }
    for (;;)
    {
      anot.c(aahb.a(this.this$0).app, "dc00898", "", "", "0X8009EE2", "0X8009EE2", 1, 0, "", "", "", "");
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      aahb.a(this.this$0).startActivity(new Intent("android.settings.WIRELESS_SETTINGS"));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aahl
 * JD-Core Version:    0.7.0.1
 */