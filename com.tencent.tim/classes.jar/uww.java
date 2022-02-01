import android.app.Dialog;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uww
  implements View.OnClickListener
{
  public uww(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    FontSettingActivity.a(this.a).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uww
 * JD-Core Version:    0.7.0.1
 */