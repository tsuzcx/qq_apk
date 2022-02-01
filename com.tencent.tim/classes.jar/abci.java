import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.tim.timme.TimLeba;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class abci
  implements View.OnClickListener
{
  public abci(TimLeba paramTimLeba) {}
  
  public void onClick(View paramView)
  {
    TimLeba.a(this.this$0).onItemClick(paramView);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     abci
 * JD-Core Version:    0.7.0.1
 */