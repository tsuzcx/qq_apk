import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.MoveToGroupActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vht
  implements View.OnClickListener
{
  public vht(MoveToGroupActivity paramMoveToGroupActivity) {}
  
  public void onClick(View paramView)
  {
    MoveToGroupActivity.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vht
 * JD-Core Version:    0.7.0.1
 */