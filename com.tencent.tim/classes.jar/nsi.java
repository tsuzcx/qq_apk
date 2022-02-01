import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.view.widget.banner.BannerAdapter;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class nsi
  implements View.OnClickListener
{
  public nsi(BannerAdapter paramBannerAdapter, int paramInt) {}
  
  public void onClick(View paramView)
  {
    this.a.rr(this.val$position);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     nsi
 * JD-Core Version:    0.7.0.1
 */