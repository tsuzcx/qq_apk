import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.registerGuideLogin.TimLoginQQView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aaod
  implements View.OnClickListener
{
  public aaod(TimLoginQQView paramTimLoginQQView) {}
  
  public void onClick(View paramView)
  {
    anot.c(this.this$0.mAppInterface, "dc00898", "", "", "0X800AA2E", "0X800AA2E", 0, 0, "", "", "", "");
    TimLoginQQView.a(this.this$0).dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aaod
 * JD-Core Version:    0.7.0.1
 */