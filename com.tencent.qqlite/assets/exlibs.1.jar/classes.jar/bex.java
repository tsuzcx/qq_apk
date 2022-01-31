import android.app.Dialog;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.QQSetting;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import cooperation.plugin.IPluginManager;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import mqq.app.AppRuntime;

public class bex
  implements View.OnClickListener
{
  public bex(QQSetting paramQQSetting) {}
  
  public void onClick(View paramView)
  {
    if (((IPluginManager)BaseApplicationImpl.a.a().getManager(25)).a())
    {
      QQSetting.a(this.a, QQSetting.a(this.a, 2131363278, 2131363283, 2131362801, 2131363459, (float)Math.round(25.673103332519531D) / 100.0F + "", new bey(this), new bez(this)));
      QQSetting.a(this.a).setOnDismissListener(new bfa(this));
      QQSetting.a(this.a).show();
    }
    String str;
    do
    {
      return;
      QfavHelper.b(this.a.a(), this.a.a.getAccount(), null, -1);
      QfavReport.c(this.a.a, 1);
      paramView = this.a.a().getSharedPreferences("QQLite", 0);
      str = "favorites_click_red_point_" + this.a.a.a();
    } while (paramView.getBoolean(str, false));
    paramView.edit().putBoolean(str, true).commit();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     bex
 * JD-Core Version:    0.7.0.1
 */