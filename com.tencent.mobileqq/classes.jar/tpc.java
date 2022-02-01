import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tpc
  implements View.OnClickListener
{
  public tpc(ViolaLazyFragment paramViolaLazyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tpc
 * JD-Core Version:    0.7.0.1
 */