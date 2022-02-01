import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class zlp
  implements View.OnClickListener
{
  public zlp(QRLoginBaseActivity paramQRLoginBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zlp
 * JD-Core Version:    0.7.0.1
 */