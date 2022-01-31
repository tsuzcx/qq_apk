import android.content.Context;
import android.content.Intent;
import android.text.style.ClickableSpan;
import android.view.View;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.aio.item.DeviceTextItemBuilder;
import com.tencent.mobileqq.utils.NetworkUtil;
import com.tencent.mobileqq.widget.QQToast;

public class utc
  extends ClickableSpan
{
  public utc(DeviceTextItemBuilder paramDeviceTextItemBuilder) {}
  
  public void onClick(View paramView)
  {
    if (!NetworkUtil.d(this.a.a))
    {
      QQToast.a(this.a.a, "当前网络连接不可用，请确认后再使用", 2000).a();
      return;
    }
    paramView = new Intent(this.a.a, QQBrowserActivity.class);
    paramView.putExtra("url", "http://kf.qq.com/touch/apifaq/1211147RVfAV140617UV3MZn.html?ADTAG=veda.mobileqq.en");
    paramView.putExtra("hide_more_button", true);
    this.a.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     utc
 * JD-Core Version:    0.7.0.1
 */