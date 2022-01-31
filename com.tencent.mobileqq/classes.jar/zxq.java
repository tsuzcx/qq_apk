import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;
import com.tencent.mobileqq.widget.QQToast;

public class zxq
  implements View.OnClickListener
{
  public zxq(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bdin.g(this.a)) {
      QQToast.a(this.a, alud.a(2131703623), 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes13.jar
 * Qualified Name:     zxq
 * JD-Core Version:    0.7.0.1
 */