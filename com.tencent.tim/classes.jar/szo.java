import android.os.Bundle;
import android.os.Handler;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.2.1;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.a;
import java.util.ArrayList;
import mqq.observer.BusinessObserver;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class szo
  implements BusinessObserver
{
  public szo(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    this.a.mProgress.dismiss();
    if (!paramBoolean)
    {
      arxa.a().showToast(this.a.getString(2131694322));
      DeviceMsgSettingActivity.b(this.a);
      return;
    }
    if (paramBundle.getInt("cgiResultCode", -1) != 0)
    {
      arxa.a().showToast(this.a.getString(2131694322));
      return;
    }
    for (;;)
    {
      try
      {
        paramBundle = new JSONObject(new String(paramBundle.getByteArray("data")));
        if (paramBundle.optInt("ret", -1) != 0)
        {
          arxa.a().showToast(this.a.getString(2131694322));
          this.a.mHandler.post(new DeviceMsgSettingActivity.2.1(this));
          return;
        }
        paramBundle = paramBundle.optJSONArray("data");
        if (paramBundle == null)
        {
          arxa.a().showToast(this.a.getString(2131696361));
          DeviceMsgSettingActivity.b(this.a);
          return;
        }
      }
      catch (JSONException paramBundle)
      {
        arwt.e("DeviceMsgSettingActivity", "get msg setting json format faild!");
        arxa.a().showToast(this.a.getString(2131694322));
        continue;
        paramInt = 0;
      }
      while (paramInt < paramBundle.length())
      {
        JSONObject localJSONObject = paramBundle.getJSONObject(paramInt);
        DeviceMsgSettingActivity.a locala = new DeviceMsgSettingActivity.a(this.a, null);
        locala.id = localJSONObject.getInt("id");
        locala.name = localJSONObject.getString("name");
        locala.enable = localJSONObject.getInt("enable");
        this.a.ox.add(locala);
        paramInt += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szo
 * JD-Core Version:    0.7.0.1
 */