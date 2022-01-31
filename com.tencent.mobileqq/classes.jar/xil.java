import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.recent.BannerManager;
import cooperation.qqdataline.QQProxyForDataline;

public class xil
  implements View.OnClickListener
{
  public xil(BannerManager paramBannerManager) {}
  
  public void onClick(View paramView)
  {
    switch (paramView.getId())
    {
    default: 
      return;
    }
    paramView = new Bundle();
    paramView.putBoolean("string_from", false);
    paramView.putBoolean("string_uin", true);
    paramView.putLong("device_din", 0L);
    paramView.putInt("sTitleID", 0);
    QQProxyForDataline.a(BannerManager.a(this.a), paramView, "com.qqdataline.activity.LiteWifiphotoActivity");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     xil
 * JD-Core Version:    0.7.0.1
 */