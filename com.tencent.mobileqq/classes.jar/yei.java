import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.device.msg.activities.DeviceTipActivity;

public class yei
  implements View.OnClickListener
{
  public yei(DeviceTipActivity paramDeviceTipActivity) {}
  
  public void onClick(View paramView)
  {
    if (!bbfj.g(this.a)) {
      bcql.a(this.a, ajya.a(2131703239), 2000).a();
    }
    DeviceTipActivity.a(this.a, 2);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yei
 * JD-Core Version:    0.7.0.1
 */