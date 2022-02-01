import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.viola.ViolaFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class ntv
  implements View.OnClickListener
{
  public ntv(ViolaFragment paramViolaFragment) {}
  
  public void onClick(View paramView)
  {
    this.b.a.bbC();
    this.b.reloadPage();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     ntv
 * JD-Core Version:    0.7.0.1
 */