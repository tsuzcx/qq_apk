import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amlk
  implements View.OnClickListener
{
  public amlk(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.Ux(3);
    this.a.biT();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlk
 * JD-Core Version:    0.7.0.1
 */