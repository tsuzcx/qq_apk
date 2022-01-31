import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.1.1;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class xvb
  implements BusinessObserver
{
  public xvb(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Bbms.dismiss();
    if (!paramBoolean)
    {
      bcec.a().a(this.a.getString(2131627381));
      DeviceMsgSettingActivity.a(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      bcec.a().a(this.a.getString(2131627381));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          bcec.a().a(this.a.getString(2131627381));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.1.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          bcec.a().a(this.a.getString(2131629018));
          DeviceMsgSettingActivity.a(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        bcds.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        bcec.a().a(this.a.getString(2131627381));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        xvd localxvd = new xvd(this.a, null);
        localxvd.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localxvd.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localxvd.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localxvd);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xvb
 * JD-Core Version:    0.7.0.1
 */