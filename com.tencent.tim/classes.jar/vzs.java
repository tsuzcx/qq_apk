import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.TroopInfoActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vzs
  implements View.OnClickListener
{
  public vzs(TroopInfoActivity paramTroopInfoActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.bWB();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vzs
 * JD-Core Version:    0.7.0.1
 */