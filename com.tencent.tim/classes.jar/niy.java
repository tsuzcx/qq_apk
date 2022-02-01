import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyNewFeedsActivity;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabbar;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.BubblePopupWindow;

public class niy
  implements View.OnClickListener
{
  public niy(ReadinjoyTabbar paramReadinjoyTabbar) {}
  
  public void onClick(View paramView)
  {
    if ((ReadinjoyTabbar.a(this.this$0) != null) && (ReadinjoyTabbar.a(this.this$0).isShowing())) {}
    try
    {
      ReadinjoyTabbar.a(this.this$0).a(3, 257, null, true);
      ReadinjoyTabbar.a(this.this$0).dismiss();
      label49:
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    catch (Exception localException)
    {
      break label49;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     niy
 * JD-Core Version:    0.7.0.1
 */