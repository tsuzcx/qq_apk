import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.logic.HomeworkTroopController.1;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apmm
  implements View.OnClickListener
{
  public apmm(HomeworkTroopController.1 param1) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.dZr();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apmm
 * JD-Core Version:    0.7.0.1
 */