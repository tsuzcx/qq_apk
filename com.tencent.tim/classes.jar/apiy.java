import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apiy
  implements View.OnClickListener
{
  public apiy(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.b.eag();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apiy
 * JD-Core Version:    0.7.0.1
 */