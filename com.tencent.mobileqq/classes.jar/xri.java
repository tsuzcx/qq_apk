import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Arrays;

class xri
  implements Handler.Callback
{
  xri(xrh paramxrh) {}
  
  public boolean handleMessage(Message paramMessage)
  {
    int i = 0;
    boolean bool1 = false;
    switch (paramMessage.what)
    {
    }
    for (;;)
    {
      return true;
      this.a.a();
      return true;
      try
      {
        paramMessage = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        boolean bool2 = bgnd.a().a(paramMessage);
        boolean bool3 = badq.h(BaseApplicationImpl.getContext());
        boolean bool4 = babp.e();
        if (bace.a() <= 1.048576E+008F) {
          bool1 = true;
        }
        xrh.a(this.a, "SmartDeviceProxyMgr check plugin: isInstalled " + bool2 + " isWifiConnected " + bool3 + " lowPhone = " + bool4 + " lowMemory = " + bool1);
        if ((bool2) || (!bool3) || (bool4) || (bool1)) {
          continue;
        }
        bgnd.a().a();
        return true;
      }
      catch (Exception paramMessage)
      {
        return true;
      }
      try
      {
        if (xrh.a(this.a) != null)
        {
          paramMessage = new Bundle();
          paramMessage.putString("notify_cmd", "getServerDeviceList");
          paramMessage = xrh.a(this.a).a(paramMessage);
          if (paramMessage != null)
          {
            paramMessage = paramMessage.getParcelableArray("devicelist");
            if (paramMessage != null)
            {
              DeviceInfo[] arrayOfDeviceInfo = new DeviceInfo[paramMessage.length];
              while (i < paramMessage.length)
              {
                arrayOfDeviceInfo[i] = ((DeviceInfo)paramMessage[i]);
                i += 1;
              }
              xrh.a(this.a, arrayOfDeviceInfo);
              if (arrayOfDeviceInfo != null)
              {
                this.a.notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
                return true;
              }
            }
          }
        }
      }
      catch (Exception paramMessage) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes4.jar
 * Qualified Name:     xri
 * JD-Core Version:    0.7.0.1
 */