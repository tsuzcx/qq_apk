import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tuf
  implements View.OnClickListener
{
  public tuf(ViolaFragment paramViolaFragment) {}
  
  public void onClick(View paramView)
  {
    this.a.mViolaUiDelegate.d();
    this.a.reloadPage();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     tuf
 * JD-Core Version:    0.7.0.1
 */