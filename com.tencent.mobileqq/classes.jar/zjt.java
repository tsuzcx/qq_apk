import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class zjt
  extends BroadcastReceiver
{
  public zjt(DeviceProfileManager paramDeviceProfileManager) {}
  
  public void onReceive(Context paramContext, Intent paramIntent)
  {
    if (QLog.isDevelopLevel()) {
      QLog.e("DeviceProfileManager", 4, "onReceive");
    }
    if (paramIntent == null) {}
    do
    {
      for (;;)
      {
        return;
        try
        {
          paramContext = paramIntent.getExtras();
          if (paramContext != null)
          {
            DeviceProfileManager.a(this.a, (HashMap)paramContext.getSerializable("featureMapLV2"));
            if (DeviceProfileManager.a() != null)
            {
              DeviceProfileManager.a().a = ((HashMap)paramContext.getSerializable("featureAccountMapLV2"));
              return;
            }
          }
        }
        catch (Exception paramContext) {}
      }
    } while (!QLog.isDevelopLevel());
    paramContext.printStackTrace();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes.jar
 * Qualified Name:     zjt
 * JD-Core Version:    0.7.0.1
 */