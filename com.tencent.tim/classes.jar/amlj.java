import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.search.activity.MixSearchWebFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class amlj
  implements View.OnClickListener
{
  public amlj(MixSearchWebFragment paramMixSearchWebFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.Ux(1);
    this.a.biT();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     amlj
 * JD-Core Version:    0.7.0.1
 */