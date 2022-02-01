import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class szu
  implements View.OnClickListener
{
  public szu(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!aqiw.isNetworkAvailable(this.this$0)) {
      QQToast.a(this.this$0, acfp.m(2131705026), 2000).show();
    }
    DeviceTipActivity.a(this.this$0, 2);
    this.this$0.finish();
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szu
 * JD-Core Version:    0.7.0.1
 */