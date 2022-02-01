import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3;
import com.tencent.mobileqq.widget.share.ShareActionSheet;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zlr
  implements View.OnClickListener
{
  public zlr(SubscribeQRCodeShareHelper.3 param3) {}
  
  public void onClick(View paramView)
  {
    zlp.a(this.a.this$0).dismiss();
    zlp.a(this.a.this$0, null);
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlr
 * JD-Core Version:    0.7.0.1
 */