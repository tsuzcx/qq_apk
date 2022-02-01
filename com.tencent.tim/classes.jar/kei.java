import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.ecshopassit.ShopWebViewFragment;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class kei
  implements View.OnClickListener
{
  public kei(ShopWebViewFragment paramShopWebViewFragment) {}
  
  public void onClick(View paramView)
  {
    if (this.b.a != null) {
      this.b.a.aG(this.b.getActivity(), this.b.bf[0]);
    }
    try
    {
      this.b.a.a.a(134248548, null, null, null, null, 0L, false);
      label57:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label57;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kei
 * JD-Core Version:    0.7.0.1
 */