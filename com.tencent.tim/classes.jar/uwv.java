import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.FontSettingActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class uwv
  implements View.OnClickListener
{
  public uwv(FontSettingActivity paramFontSettingActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.showDialog();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     uwv
 * JD-Core Version:    0.7.0.1
 */