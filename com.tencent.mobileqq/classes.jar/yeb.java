import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.2.1;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class yeb
  implements BusinessObserver
{
  public yeb(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.jdField_a_of_type_Bcqf.dismiss();
    if (!paramBoolean)
    {
      bdis.a().a(this.a.getString(2131693022));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      bdis.a().a(this.a.getString(2131693022));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          bdis.a().a(this.a.getString(2131693022));
          this.a.jdField_a_of_type_AndroidOsHandler.post(new DeviceMsgSettingActivity.2.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          bdis.a().a(this.a.getString(2131694683));
          DeviceMsgSettingActivity.b(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        bdii.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        bdis.a().a(this.a.getString(2131693022));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        yed localyed = new yed(this.a, null);
        localyed.jdField_a_of_type_Int = localJSONObject.getInt("id");
        localyed.jdField_a_of_type_JavaLangString = localJSONObject.getString("name");
        localyed.b = localJSONObject.getInt("enable");
        this.a.jdField_a_of_type_JavaUtilArrayList.add(localyed);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     yeb
 * JD-Core Version:    0.7.0.1
 */