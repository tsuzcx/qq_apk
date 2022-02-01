import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.3;
import com.tencent.mobileqq.utils.ShareActionSheetBuilder;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class siq
  implements View.OnClickListener
{
  public siq(SubscribeQRCodeShareHelper.3 param3) {}
  
  public void onClick(View paramView)
  {
    this.a.this$0.a.dismiss();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     siq
 * JD-Core Version:    0.7.0.1
 */