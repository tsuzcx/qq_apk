import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class utb
  extends ClickableSpan
{
  public utb(DeviceTextItemBuilder paramDeviceTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.a.a))
    {
      QQToast.a(this.a.a, "当前网络连接不可用，请确认后再使用", 2000).a();
      return;
    }
    paramView = new Intent();
    paramView.setFlags(268435456);
    paramView.setAction("android.intent.action.VIEW");
    paramView.putExtra("devlock_open_source", "SmartDeviceMsg");
    paramView.setData(Uri.parse("mqqdevlock://devlock/open?"));
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utb
 * JD-Core Version:    0.7.0.1
 */