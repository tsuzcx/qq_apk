import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.view.ViolaLazyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nxn
  implements View.OnClickListener
{
  public nxn(ViolaLazyFragment paramViolaLazyFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.doOnBackPressed();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nxn
 * JD-Core Version:    0.7.0.1
 */