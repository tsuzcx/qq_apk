import android.os.Bundle;
import android.widget.CompoundButton;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity;
import com.tencent.device.msg.activities.DeviceMsgSettingActivity.a;
import java.util.ArrayList;
import java.util.Iterator;
import mqq.observer.BusinessObserver;
import org.json.JSONException;
import org.json.JSONObject;

public class szp
  implements BusinessObserver
{
  public szp(DeviceMsgSettingActivity paramDeviceMsgSettingActivity) {}
  
  public void onReceive(int paramInt, boolean paramBoolean, Bundle paramBundle)
  {
    boolean bool2 = true;
    int i = 1;
    boolean bool1 = false;
    this.a.mProgress.dismiss();
    if (!paramBoolean)
    {
      paramBundle = this.a.a;
      paramBoolean = bool1;
      if (!this.a.a.isChecked()) {
        paramBoolean = true;
      }
      paramBundle.setChecked(paramBoolean);
      arxa.a().showToast(this.a.getString(2131719604));
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
        if (paramBundle.optInt("ret", -1) != 0) {
          break label280;
        }
        int j = ((Integer)this.a.a.getTag()).intValue();
        paramBundle = this.a.ox.iterator();
        if (!paramBundle.hasNext()) {
          break;
        }
        localObject = (DeviceMsgSettingActivity.a)paramBundle.next();
        if (((DeviceMsgSettingActivity.a)localObject).id == j) {
          if (this.a.a.isChecked())
          {
            paramInt = 1;
            ((DeviceMsgSettingActivity.a)localObject).enable = paramInt;
          }
          else
          {
            paramInt = 0;
          }
        }
      }
      catch (JSONException paramBundle)
      {
        paramBundle.printStackTrace();
        return;
      }
    }
    paramBundle = this.a.app;
    long l = Long.parseLong(this.a.fH);
    paramInt = i;
    if (this.a.a.isChecked()) {
      paramInt = 2;
    }
    tar.a(paramBundle, l, "Usr_MsgMgr_Setting", paramInt, 0, Integer.parseInt(this.a.mPid));
    return;
    label280:
    Object localObject = this.a.a;
    if (!this.a.a.isChecked()) {}
    for (paramBoolean = bool2;; paramBoolean = false)
    {
      ((CompoundButton)localObject).setChecked(paramBoolean);
      arwt.v("DeviceMsgSettingActivity", "msg:" + paramBundle.optString("msg"));
      arxa.a().showToast(this.a.getString(2131719604));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     szp
 * JD-Core Version:    0.7.0.1
 */