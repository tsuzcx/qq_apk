import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.mobileqq.activity.QQSettingMe;
import com.tencent.mobileqq.apollo.drawer.ApolloDrawerContext;
import com.tencent.mobileqq.apollo.drawer.ApolloWeatherInfo;
import com.tencent.mobileqq.apollo.drawer.WeatherDrawerStatus;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.utils.VipUtils;
import com.tencent.mobileqq.vas.VasExtensionObserver;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;
import org.json.JSONObject;

public class tra
  extends VasExtensionObserver
{
  public tra(QQSettingMe paramQQSettingMe) {}
  
  protected void c(boolean paramBoolean, Object paramObject)
  {
    if (paramBoolean) {
      try
      {
        paramObject = (String)paramObject;
        Object localObject1 = new JSONObject(paramObject);
        int j = ((JSONObject)localObject1).optInt("actId");
        int k = ((JSONObject)localObject1).optInt("priority", 99);
        int i = ((JSONObject)localObject1).optInt("expts");
        Object localObject2 = ((JSONObject)localObject1).optString("wording");
        Object localObject3 = ((JSONObject)localObject1).optString("url");
        String str = ((JSONObject)localObject1).optString("subDesc");
        localObject1 = new ApolloWeatherInfo();
        ((ApolloWeatherInfo)localObject1).jdField_a_of_type_Int = j;
        ((ApolloWeatherInfo)localObject1).jdField_c_of_type_Int = k;
        ((ApolloWeatherInfo)localObject1).jdField_b_of_type_Int = i;
        ((ApolloWeatherInfo)localObject1).jdField_b_of_type_JavaLangString = ((String)localObject2);
        ((ApolloWeatherInfo)localObject1).jdField_a_of_type_JavaLangString = ((String)localObject3);
        ((ApolloWeatherInfo)localObject1).jdField_c_of_type_JavaLangString = str;
        if ((this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity != null) && (this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) && (this.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext != null))
        {
          localObject2 = this.a.jdField_a_of_type_ComTencentMobileqqAppBaseActivity.getSharedPreferences("apollo_sp", 0);
          localObject3 = Calendar.getInstance();
          j = ((Calendar)localObject3).get(6);
          k = ((Calendar)localObject3).get(11);
          if (((SharedPreferences)localObject2).getInt(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sp_key_apollo_weather_flag", 0) == i)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QQSettingRedesign", 2, "pull weatherInfo recycle expts=" + i);
            }
          }
          else
          {
            ((SharedPreferences)localObject2).edit().putString("sp_key_apollo_weather_show", "").commit();
            ((SharedPreferences)localObject2).edit().putInt(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sp_key_apollo_weather_flag", i).commit();
            ((SharedPreferences)localObject2).edit().putString(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.c() + "sp_key_apollo_weather_data", paramObject).commit();
            paramObject = new WeatherDrawerStatus(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, (ApolloWeatherInfo)localObject1);
            this.a.jdField_a_of_type_ComTencentMobileqqApolloDrawerApolloDrawerContext.a(paramObject);
            i = (int)(System.currentTimeMillis() / 1000L);
            VipUtils.a(this.a.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, "cmshow", "Apollo", "ask_weather", i, 0, new String[0]);
            if (QLog.isColorLevel())
            {
              QLog.d("QQSettingRedesign", 2, "getWeaterInfo day=" + j + ",hour=" + k + ",info=" + ((ApolloWeatherInfo)localObject1).toString());
              return;
            }
          }
        }
      }
      catch (Exception paramObject) {}
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes6.jar
 * Qualified Name:     tra
 * JD-Core Version:    0.7.0.1
 */