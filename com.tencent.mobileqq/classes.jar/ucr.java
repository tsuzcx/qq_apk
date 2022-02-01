import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ucr
  implements View.OnClickListener
{
  public ucr(ViolaLazyFragment paramViolaLazyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     ucr
 * JD-Core Version:    0.7.0.1
 */