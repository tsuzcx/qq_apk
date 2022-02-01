import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.biz.qrcode.activity.QRLoginBaseActivity;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class rvh
  implements View.OnClickListener
{
  public rvh(QRLoginBaseActivity paramQRLoginBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.a.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rvh
 * JD-Core Version:    0.7.0.1
 */