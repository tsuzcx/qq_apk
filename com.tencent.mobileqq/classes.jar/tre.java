import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.activity.weather.WeatherManager.WeatherUpdaterListener;
import com.tencent.mobileqq.apollo.ApolloManager;
import com.tencent.mobileqq.app.soso.SosoInterface;
import com.tencent.qphone.base.util.QLog;

public class tre
  implements WeatherManager.WeatherUpdaterListener
{
  public tre(QQSettingMe paramQQSettingMe) {}
  
  public void a(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if (this.a.c)
    {
      if (!paramBoolean) {
        break label343;
      }
      if ((this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface == null) || (ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "drawer", null) <= 0) || (!ApolloManager.a(this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity, Boolean.valueOf(false)))) {
        break label72;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "weatherUpdateResult update but show cmShow");
      }
    }
    label72:
    label343:
    int i;
    do
    {
      String str1;
      String str2;
      do
      {
        do
        {
          return;
          paramInt = paramBundle.getInt("show_flag");
          if (QLog.isColorLevel()) {
            QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult show_flag:" + paramInt);
          }
          if (paramInt == 0)
          {
            this.a.b.setVisibility(8);
            this.a.b.setClickable(false);
            this.a.h.setVisibility(4);
            return;
          }
        } while (paramInt != 1);
        str1 = paramBundle.getString("KEY_TEMPER");
        str2 = paramBundle.getString("o_wea_code");
        paramBundle = paramBundle.getString("area_name");
        if (QLog.isColorLevel()) {
          QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult temp:" + str1 + " o_wea_code:" + str2 + " area_name:" + paramBundle);
        }
      } while ((str1 == null) || (str1.equals("")) || (paramBundle == null) || (paramBundle.equals("")));
      this.a.b.setVisibility(0);
      this.a.h.setVisibility(0);
      this.a.b.setClickable(true);
      this.a.e.setText(str1);
      this.a.h.setText(paramBundle);
      this.a.g.setText("o");
      QQSettingMe.b(this.a, str1);
      QQSettingMe.c(this.a, str2);
      return;
      i = paramBundle.getInt("uint32_result");
      if (QLog.isColorLevel()) {
        QLog.d("QQSettingRedesign", 2, "onWeatherUpdateResult resultCode:" + i);
      }
    } while ((paramInt != 6666) || (i != 191005));
    SosoInterface.a(new trf(this, 0, true, true, 60000L, true, false, "QQSettingRedesign"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tre
 * JD-Core Version:    0.7.0.1
 */