import android.view.View;
import android.view.View.OnClickListener;
import android.widget.PopupWindow;
import com.tencent.mobileqq.widget.GuideViewBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class arfw
  implements View.OnClickListener
{
  public arfw(GuideViewBuilder paramGuideViewBuilder, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    if (this.dah) {
      this.a.m.dismiss();
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     arfw
 * JD-Core Version:    0.7.0.1
 */