import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.msf.core.NetConnInfoCenter;
import com.tencent.qphone.base.util.QLog;
import java.net.URLEncoder;

public class vqb
  implements abcy.a
{
  public vqb(QQSettingMe paramQQSettingMe) {}
  
  public void b(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.this$0.isResume)
    {
      if (!paramBoolean) {
        break label387;
      }
      paramInt = paramBundle.getInt("show_flag");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult show_flag:" + paramInt);
      }
      if (paramInt != 0) {
        break label91;
      }
      this.this$0.gr.setVisibility(8);
      this.this$0.gr.setClickable(false);
      this.this$0.Fn.setVisibility(4);
    }
    label90:
    label91:
    do
    {
      int i;
      do
      {
        String str1;
        String str2;
        Object localObject;
        do
        {
          break label90;
          do
          {
            return;
          } while (paramInt != 1);
          str1 = paramBundle.getString("KEY_TEMPER");
          str2 = paramBundle.getString("o_wea_code");
          localObject = paramBundle.getString("area_info");
          paramInt = paramBundle.getInt("adcode");
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult temp:" + str1 + " o_wea_code:" + str2 + " area_name:" + (String)localObject + "adcode:" + paramInt);
          }
        } while ((str1 == null) || (str1.equals("")) || (TextUtils.isEmpty((CharSequence)localObject)));
        this.this$0.gr.setVisibility(0);
        this.this$0.Fn.setVisibility(0);
        this.this$0.gr.setClickable(true);
        this.this$0.Fk.setText(str1);
        paramBundle = ((String)localObject).split("-");
        TextView localTextView = this.this$0.Fn;
        if (paramBundle.length == 2) {
          paramBundle = paramBundle[1];
        }
        for (;;)
        {
          localTextView.setText(paramBundle);
          try
          {
            paramBundle = URLEncoder.encode((String)localObject, "utf-8");
            localObject = new StringBuilder();
            ((StringBuilder)localObject).append("&city=").append(paramBundle).append("&adcode=").append(paramInt);
            this.this$0.Fn.setTag(((StringBuilder)localObject).toString());
            this.this$0.Fm.setText("o");
            QQSettingMe.a(this.this$0, str1);
            QQSettingMe.b(this.this$0, str2);
            return;
            paramBundle = paramBundle[0];
          }
          catch (Exception paramBundle)
          {
            for (;;)
            {
              paramBundle = (Bundle)localObject;
            }
          }
        }
        i = paramBundle.getInt("uint32_result");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult resultCode:" + i);
        }
      } while ((paramInt != 6666) || (i != 191005));
      if (Build.VERSION.SDK_INT < 23) {
        break label602;
      }
      if (this.this$0.c.checkSelfPermission("android.permission.ACCESS_FINE_LOCATION") == 0) {
        break label594;
      }
      paramBundle = this.this$0.c.getSharedPreferences("apollo_sp" + this.this$0.app.getCurrentUin(), 0);
      long l = paramBundle.getLong("sp_key_request_permission", 0L);
      if (NetConnInfoCenter.getServerTime() - l >= 86400L) {
        break;
      }
    } while (!QLog.isColorLevel());
    label387:
    QLog.e("QQSettingRedesign", 2, "User requestPermissions but has requested in 24 h");
    return;
    this.this$0.c.requestPermissions(new vqc(this), 1, new String[] { "android.permission.ACCESS_FINE_LOCATION" });
    paramBundle.edit().putLong("sp_key_request_permission", NetConnInfoCenter.getServerTime()).commit();
    return;
    label594:
    this.this$0.bTE();
    return;
    label602:
    this.this$0.bTE();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     vqb
 * JD-Core Version:    0.7.0.1
 */