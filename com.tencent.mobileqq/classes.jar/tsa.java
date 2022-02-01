import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoyAd.ad.fragment.ReadinjoyAdHippyFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class tsa
  implements View.OnClickListener
{
  public tsa(ReadinjoyAdHippyFragment paramReadinjoyAdHippyFragment) {}
  
  public void onClick(View paramView)
  {
    ReadinjoyAdHippyFragment.a(this.a).d();
    ReadinjoyAdHippyFragment.a(this.a);
    ReadinjoyAdHippyFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     tsa
 * JD-Core Version:    0.7.0.1
 */