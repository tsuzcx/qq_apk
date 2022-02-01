import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.HongbaoShowerActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vdu
  implements View.OnClickListener
{
  public vdu(HongbaoShowerActivity paramHongbaoShowerActivity) {}
  
  public void onClick(View paramView)
  {
    if (System.currentTimeMillis() - this.this$0.mCreateTime < 2000L)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    this.this$0.finish();
    this.this$0.overridePendingTransition(0, 0);
    QQAppInterface localQQAppInterface = this.this$0.app;
    if (HongbaoShowerActivity.a(this.this$0) == 0) {}
    for (String str = "1";; str = "2")
    {
      anot.a(localQQAppInterface, "dc01440", "", "", "0X80077EA", "0X80077EA", 0, 0, str, "", "", "");
      break;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vdu
 * JD-Core Version:    0.7.0.1
 */