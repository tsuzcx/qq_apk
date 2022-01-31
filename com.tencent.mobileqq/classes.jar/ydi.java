import android.app.Activity;
import android.os.Bundle;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.device.utils.LightAppSettingInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

class ydi
  implements BusinessObserver
{
  ydi(ydh paramydh) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.jdField_a_of_type_Bbms != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
      this.a.jdField_a_of_type_Bbms.dismiss();
    }
    if (!paramBoolean)
    {
      bcec.a().a(2131626000);
      if (this.a.jdField_a_of_type_Ydj != null) {
        this.a.jdField_a_of_type_Ydj.a(false);
      }
    }
    do
    {
      return;
      if (paramBundle.getInt("cgiResultCode", -1) == 0) {
        break;
      }
      bcec.a().a(2131626000);
    } while (this.a.jdField_a_of_type_Ydj == null);
    this.a.jdField_a_of_type_Ydj.a(false);
    return;
    int j;
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        j = paramBundle.optInt("ret", -1);
        if (j != 0)
        {
          bcds.a("LightAppUtil", "GETLightAppSettingCallBack failed,resultCode=" + j);
          bcec.a().a(2131626000);
          if (this.a.jdField_a_of_type_Ydj != null) {
            this.a.jdField_a_of_type_Ydj.a(false);
          }
          if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
            break label920;
          }
          paramInt = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
          label223:
          if (!this.a.c) {
            break label909;
          }
          yds.a(this.a.jdField_a_of_type_MqqAppAppRuntime, "Net_Get_LiteappSetting", 0, j, paramInt);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
      try
      {
        paramBundle = paramBundle.getJSONArray("list");
        if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.b)) {
          break label429;
        }
        bcec.a().a(2131626000);
        if ((this.a.jdField_a_of_type_Bbms != null) && (this.a.jdField_a_of_type_Bbms.isShowing()) && (this.a.jdField_a_of_type_AndroidAppActivity != null) && (!this.a.jdField_a_of_type_AndroidAppActivity.isFinishing())) {
          this.a.jdField_a_of_type_Bbms.dismiss();
        }
        if (this.a.jdField_a_of_type_Ydj != null) {
          this.a.jdField_a_of_type_Ydj.a(true);
        }
        yds.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        bcec.a().a(2131626000);
      }
      if (this.a.jdField_a_of_type_Ydj != null)
      {
        this.a.jdField_a_of_type_Ydj.a(false);
        continue;
        label429:
        if (paramBundle != null) {
          paramInt = 0;
        }
      }
    }
    for (;;)
    {
      if (paramInt < paramBundle.length())
      {
        Object localObject1 = paramBundle.getJSONObject(paramInt);
        LightAppSettingInfo localLightAppSettingInfo = new LightAppSettingInfo();
        localLightAppSettingInfo.jdField_c_of_type_Int = ((JSONObject)localObject1).optInt("pid");
        localLightAppSettingInfo.jdField_a_of_type_Int = ((JSONObject)localObject1).optInt("template_type");
        localLightAppSettingInfo.jdField_b_of_type_Int = ((JSONObject)localObject1).optInt("has_own_app");
        localLightAppSettingInfo.jdField_d_of_type_JavaLangString = ((JSONObject)localObject1).optString("h5_url");
        localLightAppSettingInfo.jdField_c_of_type_JavaLangString = ((JSONObject)localObject1).optString("public_url");
        localLightAppSettingInfo.jdField_a_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_appid");
        localLightAppSettingInfo.jdField_d_of_type_Int = ((JSONObject)localObject1).optInt("device_type");
        localLightAppSettingInfo.jdField_b_of_type_JavaLangString = ((JSONObject)localObject1).optString("own_pkgname");
        localLightAppSettingInfo.jdField_e_of_type_JavaLangString = ((JSONObject)localObject1).optString("openid");
        localLightAppSettingInfo.f = ((JSONObject)localObject1).optString("openkey");
        localLightAppSettingInfo.g = ((JSONObject)localObject1).optString("appname");
        localLightAppSettingInfo.jdField_e_of_type_Int = ((JSONObject)localObject1).optInt("bindtype", 1);
        Object localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
        localLightAppSettingInfo.jdField_a_of_type_JavaUtilHashMap = this.a.a(localJSONArray);
        localLightAppSettingInfo.h = ((JSONObject)localObject1).optString("comment");
        localObject1 = ((String)localObject2).split(",");
        if (localObject1 != null)
        {
          localObject2 = new ArrayList();
          int k = localObject1.length;
          int i = 0;
          while (i < k)
          {
            ((ArrayList)localObject2).add(Integer.valueOf(localObject1[i]));
            i += 1;
          }
          localLightAppSettingInfo.jdField_a_of_type_JavaUtilArrayList = ((ArrayList)localObject2);
        }
        for (;;)
        {
          if (!ydh.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.containsKey(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int)))
          {
            ydh.jdField_a_of_type_JavaUtilConcurrentConcurrentHashMap.put(Integer.valueOf(localLightAppSettingInfo.jdField_c_of_type_Int), localLightAppSettingInfo);
            ydh.jdField_a_of_type_JavaUtilArrayList.add(localLightAppSettingInfo);
          }
          if ((!this.a.b) || (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId != localLightAppSettingInfo.jdField_c_of_type_Int)) {
            break;
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, this.a.jdField_a_of_type_AndroidOsBundle, this.a.d);
          break label925;
          bcds.e("LightAppUtil", "no ids!");
        }
        if (this.a.jdField_a_of_type_Ydj != null) {
          this.a.jdField_a_of_type_Ydj.a(false);
        }
      }
      else
      {
        if ((this.a.c) || (ydh.jdField_a_of_type_JavaUtilArrayList.size() <= 0)) {
          break;
        }
        paramBundle = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramBundle instanceof QQAppInterface)) {
          break;
        }
        ((xrh)((QQAppInterface)paramBundle).a(51)).a(ydh.jdField_a_of_type_JavaUtilArrayList);
        break;
        label909:
        yds.a(null, "Net_Get_LiteappSetting", 0, j, paramInt);
        return;
        label920:
        paramInt = 0;
        break label223;
      }
      label925:
      paramInt += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     ydi
 * JD-Core Version:    0.7.0.1
 */