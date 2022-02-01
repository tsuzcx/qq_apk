import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyViolaChannelFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class lfb
  implements View.OnClickListener
{
  public lfb(ReadInJoyViolaChannelFragment paramReadInJoyViolaChannelFragment) {}
  
  public void onClick(View paramView)
  {
    ReadInJoyViolaChannelFragment.a(this.a).bbC();
    ReadInJoyViolaChannelFragment.a(this.a);
    ReadInJoyViolaChannelFragment.b(this.a);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     lfb
 * JD-Core Version:    0.7.0.1
 */