import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.widget.QQToast;

public class ztb
  implements View.OnClickListener
{
  public ztb(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bdee.g(this.a)) {
      QQToast.a(this.a, alpo.a(2131703611), 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ztb
 * JD-Core Version:    0.7.0.1
 */