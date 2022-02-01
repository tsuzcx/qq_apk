import android.content.Intent;
import android.content.SharedPreferences;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.PermisionPrivacyActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

public class vkz
  implements View.OnClickListener
{
  public vkz(PermisionPrivacyActivity paramPermisionPrivacyActivity, SharedPreferences paramSharedPreferences, boolean paramBoolean) {}
  
  public void onClick(View paramView)
  {
    String str = aqqj.getUrl("gameIconSetupH5Url");
    Intent localIntent = new Intent(this.this$0.app.getApp(), QQBrowserActivity.class);
    localIntent.setFlags(268435456);
    localIntent.putExtra("vasUsePreWebview", true);
    VasWebviewUtil.openQQBrowserWithoutAD(this.this$0.app.getApp(), str, -1L, localIntent, false, -1);
    anot.a(this.this$0.app, "CliOper", "", "", "Setting_tab", "0X8009C07", 0, 0, "", "", "", "");
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vkz
 * JD-Core Version:    0.7.0.1
 */