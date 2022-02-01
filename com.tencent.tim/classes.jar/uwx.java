import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uwx
  implements View.OnClickListener
{
  public uwx(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    if (acej.a(this.a, FontSettingActivity.a(this.a), true)) {
      acej.cIt();
    }
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwx
 * JD-Core Version:    0.7.0.1
 */