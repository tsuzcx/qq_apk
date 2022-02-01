import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.c;
import com.tencent.qphone.base.util.QLog;

public class adbu
{
  static final String TAG = adca.TAG;
  static int cCc = -1;
  static int cCd = -1;
  
  public static boolean a(int paramInt1, long paramLong1, long paramLong2, int paramInt2)
  {
    int i = aqgz.getOsVersion();
    if (i < paramInt2)
    {
      QLog.w(TAG, 1, "isSupportOfDevice, error OSversion[" + paramInt2 + "->" + i + "]");
      return false;
    }
    paramInt2 = aqgz.getCpuNumber();
    if (paramInt2 < paramInt1)
    {
      QLog.w(TAG, 1, "isSupportOfDevice, error cpucount[" + paramInt1 + "->" + paramInt2 + "]");
      return false;
    }
    long l = aqgz.getCpuFrequency();
    if (l < paramLong1)
    {
      QLog.w(TAG, 1, "isSupportOfDevice, error cpuFrequency[" + paramLong1 + "->" + l + "]");
      return false;
    }
    paramLong1 = aqgz.getSystemTotalMemory();
    if (paramLong1 < paramLong2)
    {
      QLog.w(TAG, 1, "isSupportOfDevice, error memory[" + paramLong2 + "->" + paramLong1 + "]");
      return false;
    }
    return true;
  }
  
  public static boolean adu()
  {
    return (adw()) && (adx()) && (adv());
  }
  
  public static boolean adv()
  {
    return (!Build.MODEL.equalsIgnoreCase("ATH-AL00")) && (!Build.MODEL.equalsIgnoreCase("BND-AL10")) && (!Build.MODEL.equalsIgnoreCase("ASK-AL00x")) && (!Build.MODEL.equalsIgnoreCase("vivo X6S A"));
  }
  
  public static boolean adw()
  {
    if (cCc == -1) {
      if (Build.VERSION.SDK_INT <= 20) {
        break label118;
      }
    }
    label111:
    label116:
    label118:
    for (int i = 1;; i = 0)
    {
      int j;
      if ((a(8, 1367L, 2800000000L, 15)) || (a(4, 2099L, 2800000000L, 15)))
      {
        j = 1;
        if ((j == 0) || (i == 0)) {
          break label111;
        }
      }
      for (i = 1;; i = 0)
      {
        cCc = i;
        QLog.w(TAG, 1, "isDevicesSupport, DeviceSupportFromLocal[" + cCc + "]");
        if (cCc != 1) {
          break label116;
        }
        return true;
        j = 0;
        break;
      }
      return false;
    }
  }
  
  public static boolean adx()
  {
    String str;
    Object localObject;
    int j;
    boolean bool;
    if (cCd == -1)
    {
      str = DeviceProfileManager.b().jf(DeviceProfileManager.DpcNames.ARCfg.name());
      if (TextUtils.isEmpty(str)) {
        break label160;
      }
      localObject = new String[13];
      j = DeviceProfileManager.a(str, (Object[])localObject, new DeviceProfileManager.c());
      if (localObject.length <= 12) {
        break label173;
      }
      localObject = localObject[12];
      if (TextUtils.equals((CharSequence)localObject, "1")) {
        break label150;
      }
      bool = true;
    }
    for (;;)
    {
      if (bool) {}
      for (int i = 1;; i = 0)
      {
        cCd = i;
        QLog.w(TAG, 1, "isEnableInDPC, isEnable[" + bool + "], arCfg[" + str + "], size[" + j + "], params[" + (String)localObject + "]");
        if (cCd != 1) {
          break label171;
        }
        return true;
        label150:
        bool = false;
        break;
      }
      label160:
      QLog.w(TAG, 1, "isEnableInDPC, 没拉到dpc配置");
      return true;
      label171:
      return false;
      label173:
      localObject = null;
      bool = true;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     adbu
 * JD-Core Version:    0.7.0.1
 */