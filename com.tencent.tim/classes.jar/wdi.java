import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopRequestActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class wdi
  implements View.OnClickListener
{
  public wdi(TroopRequestActivity paramTroopRequestActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bFN();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wdi
 * JD-Core Version:    0.7.0.1
 */