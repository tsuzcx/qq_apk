import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.mobileqq.activity.AssistantSettingActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.vaswebviewplugin.VasWebviewUtil;
import com.tencent.qphone.base.util.QLog;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class atdn
  implements View.OnClickListener
{
  atdn(atdh paramatdh, BaseActivity paramBaseActivity) {}
  
  public void onClick(View paramView)
  {
    this.this$0.eti();
    Object localObject = "";
    if (atda.a() != null) {
      localObject = atda.a().mJumpUrl;
    }
    if (QLog.isColorLevel()) {
      QLog.d("RecentCallHelper", 2, "gotoLightalkWeb() url = " + (String)localObject);
    }
    if (aqmr.isEmpty((String)localObject))
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    Intent localIntent = new Intent(this.e, QQBrowserActivity.class);
    localIntent.putExtra("hide_left_button", false);
    localIntent.putExtra("show_right_close_button", false);
    localIntent.putExtra("startOpenPageTime", System.currentTimeMillis());
    aqmj.l(this.this$0.x.getCurrentAccountUin()).edit().putInt("show_tab_lightalk_tips", 4).commit();
    if (((String)localObject).startsWith("mqqapi://avtipsbanner/"))
    {
      localObject = new Intent(this.e, AssistantSettingActivity.class);
      this.e.startActivity((Intent)localObject);
    }
    for (;;)
    {
      anot.a(this.this$0.x, "CliOper", "", "", "0X800510D", "0X800510D", 0, 0, "", "", "", "");
      break;
      VasWebviewUtil.openQQBrowserWithoutAD(this.e, (String)localObject, 524288L, localIntent, false, -1);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     atdn
 * JD-Core Version:    0.7.0.1
 */