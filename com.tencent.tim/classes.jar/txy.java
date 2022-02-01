import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import com.tencent.mobileqq.javahooksdk.JavaHookBridge;
import com.tencent.qapmsdk.battery.BatteryMonitor;
import com.tencent.qapmsdk.battery.monitor.HookMethodCallback;
import com.tencent.qphone.base.util.QLog;

class txy
  extends txv
{
  public HookMethodCallback a()
  {
    return BatteryMonitor.getInstance().getWakeLockHook();
  }
  
  public void onHookReady()
  {
    try
    {
      JavaHookBridge.findAndHookMethod(PowerManager.class, "newWakeLock", new Object[] { Integer.TYPE, String.class, this });
      JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { this });
      JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "acquire", new Object[] { Long.TYPE, this });
      JavaHookBridge.findAndHookMethod(PowerManager.WakeLock.class, "release", new Object[] { Integer.TYPE, this });
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("MagnifierSDK.QAPM.QAPMBatteryWrapper", 2, "", localThrowable);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     txy
 * JD-Core Version:    0.7.0.1
 */