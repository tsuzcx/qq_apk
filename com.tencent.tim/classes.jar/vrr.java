import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.RegisterNewBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vrr
  implements View.OnClickListener
{
  public vrr(RegisterNewBaseActivity paramRegisterNewBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.onBackEvent();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vrr
 * JD-Core Version:    0.7.0.1
 */