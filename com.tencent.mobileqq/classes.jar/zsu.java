import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.2.1;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class zsu
  implements BusinessObserver
{
  public zsu(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Bepp.dismiss();
    if (!paramBoolean)
    {
      bfhq.a().a(this.a.getString(2131693123));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      bfhq.a().a(this.a.getString(2131693123));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          bfhq.a().a(this.a.getString(2131693123));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.2.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          bfhq.a().a(this.a.getString(2131694839));
          DeviceMsgSettingActivity.b(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        bfhg.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        bfhq.a().a(this.a.getString(2131693123));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        zsw localzsw = new zsw(this.a, null);
        localzsw.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localzsw.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localzsw.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localzsw);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     zsu
 * JD-Core Version:    0.7.0.1
 */