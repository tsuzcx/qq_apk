import android.os.Bundle;
import android.os.Handler.Callback;
import android.os.Message;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.device.datadef.DeviceInfo;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.ArrayList;
import java.util.Arrays;

class syx
  implements Handler.Callback
{
  syx(syw paramsyw) {}
  
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
      this.this$0.bCa();
      return true;
      try
      {
        paramMessage = (QQAppInterface)BaseApplicationImpl.getApplication().getRuntime();
        boolean bool2 = awjb.a().cF(paramMessage);
        boolean bool3 = aqiw.isWifiConnected(BaseApplicationImpl.getContext());
        boolean bool4 = aqgz.aCG();
        if (aqhq.getAvailableInnernalMemorySize() <= 1.048576E+008F) {
          bool1 = true;
        }
        syw.a(this.this$0, "SmartDeviceProxyMgr check plugin: isInstalled " + bool2 + " isWifiConnected " + bool3 + " lowPhone = " + bool4 + " lowMemory = " + bool1);
        if ((bool2) || (!bool3) || (bool4) || (bool1)) {
          continue;
        }
        awjb.a().eDT();
        return true;
      }
      catch (Exception paramMessage)
      {
        return true;
      }
      try
      {
        if (syw.a(this.this$0) != null)
        {
          paramMessage = new Bundle();
          paramMessage.putString("notify_cmd", "getServerDeviceList");
          paramMessage = syw.a(this.this$0).o(paramMessage);
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
              syw.a(this.this$0, arrayOfDeviceInfo);
              if (arrayOfDeviceInfo != null)
              {
                this.this$0.notifyUI(1, true, new ArrayList(Arrays.asList(arrayOfDeviceInfo)));
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


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     syx
 * JD-Core Version:    0.7.0.1
 */