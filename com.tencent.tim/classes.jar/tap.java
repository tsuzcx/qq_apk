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

class tap
  implements BusinessObserver
{
  tap(tao paramtao) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    if ((this.a.mProgress != null) && (!this.a.mActivity.isFinishing())) {
      this.a.mProgress.dismiss();
    }
    if (!paramBoolean)
    {
      arxa.a().showToast(2131692579);
      if (this.a.jdField_a_of_type_Tao$a != null) {
        this.a.jdField_a_of_type_Tao$a.onResult(false);
      }
    }
    do
    {
      return;
      if (paramBundle.getInt("cgiResultCode", -1) == 0) {
        break;
      }
      arxa.a().showToast(2131692579);
    } while (this.a.jdField_a_of_type_Tao$a == null);
    this.a.jdField_a_of_type_Tao$a.onResult(false);
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
          arwt.v("LightAppUtil", "GETLightAppSettingCallBack failed,resultCode=" + j);
          arxa.a().showToast(2131692579);
          if (this.a.jdField_a_of_type_Tao$a != null) {
            this.a.jdField_a_of_type_Tao$a.onResult(false);
          }
          if (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo == null) {
            break label920;
          }
          paramInt = this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId;
          label223:
          if (!this.a.aOo) {
            break label909;
          }
          tar.a(this.a.mApp, "Net_Get_LiteappSetting", 0, j, paramInt);
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
        if (((paramBundle != null) && (paramBundle.length() != 0)) || (!this.a.aOn)) {
          break label429;
        }
        arxa.a().showToast(2131692579);
        if ((this.a.mProgress != null) && (this.a.mProgress.isShowing()) && (this.a.mActivity != null) && (!this.a.mActivity.isFinishing())) {
          this.a.mProgress.dismiss();
        }
        if (this.a.jdField_a_of_type_Tao$a != null) {
          this.a.jdField_a_of_type_Tao$a.onResult(true);
        }
        tar.a(null, "Net_LiteApp_Setting", 0, 1, this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId);
        return;
      }
      catch (Exception paramBundle)
      {
        paramBundle.printStackTrace();
        arxa.a().showToast(2131692579);
      }
      if (this.a.jdField_a_of_type_Tao$a != null)
      {
        this.a.jdField_a_of_type_Tao$a.onResult(false);
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
        localLightAppSettingInfo.productId = ((JSONObject)localObject1).optInt("pid");
        localLightAppSettingInfo.templateType = ((JSONObject)localObject1).optInt("template_type");
        localLightAppSettingInfo.bAP = ((JSONObject)localObject1).optInt("has_own_app");
        localLightAppSettingInfo.aIC = ((JSONObject)localObject1).optString("h5_url");
        localLightAppSettingInfo.aIB = ((JSONObject)localObject1).optString("public_url");
        localLightAppSettingInfo.appId = ((JSONObject)localObject1).optString("own_appid");
        localLightAppSettingInfo.deviceType = ((JSONObject)localObject1).optInt("device_type");
        localLightAppSettingInfo.packageName = ((JSONObject)localObject1).optString("own_pkgname");
        localLightAppSettingInfo.openId = ((JSONObject)localObject1).optString("openid");
        localLightAppSettingInfo.openKey = ((JSONObject)localObject1).optString("openkey");
        localLightAppSettingInfo.appName = ((JSONObject)localObject1).optString("appname");
        localLightAppSettingInfo.bindType = ((JSONObject)localObject1).optInt("bindtype", 1);
        Object localObject2 = ((JSONObject)localObject1).optString("pub_propertyids");
        JSONArray localJSONArray = ((JSONObject)localObject1).getJSONArray("config_list");
        localLightAppSettingInfo.gs = this.a.a(localJSONArray);
        localLightAppSettingInfo.aID = ((JSONObject)localObject1).optString("comment");
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
          localLightAppSettingInfo.oA = ((ArrayList)localObject2);
        }
        for (;;)
        {
          if (!tao.cG.containsKey(Integer.valueOf(localLightAppSettingInfo.productId)))
          {
            tao.cG.put(Integer.valueOf(localLightAppSettingInfo.productId), localLightAppSettingInfo);
            tao.oB.add(localLightAppSettingInfo);
          }
          if ((!this.a.aOn) || (this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo.productId != localLightAppSettingInfo.productId)) {
            break;
          }
          this.a.a(this.a.jdField_a_of_type_ComTencentDeviceDatadefDeviceInfo, this.a.mExtras, this.a.aOp);
          break label925;
          arwt.e("LightAppUtil", "no ids!");
        }
        if (this.a.jdField_a_of_type_Tao$a != null) {
          this.a.jdField_a_of_type_Tao$a.onResult(false);
        }
      }
      else
      {
        if ((this.a.aOo) || (tao.oB.size() <= 0)) {
          break;
        }
        paramBundle = BaseApplicationImpl.getApplication().getRuntime();
        if (!(paramBundle instanceof QQAppInterface)) {
          break;
        }
        ((syw)((QQAppInterface)paramBundle).getBusinessHandler(51)).cG(tao.oB);
        break;
        label909:
        tar.a(null, "Net_Get_LiteappSetting", 0, j, paramInt);
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     tap
 * JD-Core Version:    0.7.0.1
 */