import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.troop.homework.entry.ui.BeginnerGuideFragment;
import com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class apix
  implements View.OnClickListener
{
  public apix(ReciteFragment paramReciteFragment) {}
  
  public void onClick(View paramView)
  {
    this.b.eag();
    BeginnerGuideFragment.f(ReciteFragment.a(this.b), null, 4);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apix
 * JD-Core Version:    0.7.0.1
 */