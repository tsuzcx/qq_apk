import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.createNewTroop.NewTroopCreateActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class aozb
  implements View.OnClickListener
{
  public aozb(NewTroopCreateActivity paramNewTroopCreateActivity) {}
  
  public void onClick(View paramView)
  {
    this.b.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aozb
 * JD-Core Version:    0.7.0.1
 */