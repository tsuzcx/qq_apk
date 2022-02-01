import android.os.Build;
import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;
import java.util.HashMap;

public class aeag
{
  private static String TAG = aeag.class.getSimpleName();
  private static final aeag a = new aeag();
  private static final String[] eB = { "motorola", "mot", "FIH", "Sony Ericsson", "samsung", "HTC", "HUN", "LGE", "alps", "OPPO", "TCL", "LENOVO", "ZTE", "Meizu", "Xiaomi", "HUAWEI", "TIANYU", "sprd", "K-Touch", "YuLong", "CoolPad", "Amazon", "Hisense", "Acer", "GIONEE", "Philips", "asus", "snda.com", "koobee", "AMOI", "Fason", "ainol", "Dell", "dlkjl12389", "haier", "sharp", "BBK", "nubia", "KONKA" };
  private static final String[] eC = { "MOTOROLA", "MOTOROLA", "MOTOROLA", "SONYERICSSON", "SAMSUNG", "HTC", "HTC", "LG", "OPPO", "OPPO", "TCL", "LENOVO", "ZTE", "MEIZU", "XIAOMI", "HUAWEI", "TIANYU", "TIANYU", "TIANYU", "COOLPAD", "COOLPAD", "AMAZON", "HISENSE", "ACER", "JINLI", "PHILIPS", "GOOGLE", "SHENGDA", "KUBI", "XIAXIN", "FANSHANG", "AINUO", "DELL", "DPD", "HAIER", "SHARP", "BBK", "NUBIA", "KONKA" };
  private HashMap<String, String> jS = new HashMap();
  
  private aeag()
  {
    int i = 0;
    while (i < eB.length)
    {
      this.jS.put(eB[i].toUpperCase(), eC[i]);
      i += 1;
    }
    showDeviceInfo();
  }
  
  public static aeag a()
  {
    return a;
  }
  
  private void showDeviceInfo()
  {
    if (QLog.isColorLevel())
    {
      QLog.i(TAG, 2, "****** DeviceInfo  (+) *****");
      QLog.i(TAG, 2, "BRAND_KEYS.len = " + eB.length);
      QLog.i(TAG, 2, "BRAND_NAMES.len = " + eC.length);
      QLog.i(TAG, 2, "DeviceTypeName = " + ta());
      QLog.i(TAG, 2, "SubTagName = " + ta() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase());
      QLog.i(TAG, 2, "MODEL = " + Build.MODEL);
      QLog.i(TAG, 2, "SDK_INT = " + Build.VERSION.SDK_INT);
      QLog.i(TAG, 2, "BRAND = " + Build.BRAND);
      QLog.i(TAG, 2, "DEVICE = " + Build.DEVICE);
      QLog.i(TAG, 2, "DISPLAY = " + Build.DISPLAY);
      QLog.i(TAG, 2, "HARDWARE = " + Build.HARDWARE);
      QLog.i(TAG, 2, "MANUFACTURER = " + Build.MANUFACTURER);
      QLog.i(TAG, 2, "PRODUCT = " + Build.PRODUCT);
      QLog.i(TAG, 2, "TAGS = " + Build.TAGS);
      QLog.i(TAG, 2, "USER = " + Build.USER);
      QLog.i(TAG, 2, "TYPE = " + Build.TYPE);
      QLog.i(TAG, 2, "****** DeviceInfo (-) *****");
    }
  }
  
  public String ta()
  {
    String str;
    if (Build.MODEL.equalsIgnoreCase("K-Touch W619")) {
      str = (String)this.jS.get("TIANYU") + " " + Build.MODEL;
    }
    for (;;)
    {
      return str.replace(" ", "_").replace("+", "").replace("(t)", "");
      if ((Build.MODEL.equalsIgnoreCase("8150")) && (Build.BRAND.equalsIgnoreCase("COOLPAD"))) {
        str = (String)this.jS.get("COOLPAD") + " " + Build.MODEL;
      } else {
        str = (String)this.jS.get(Build.MANUFACTURER.toUpperCase()) + " " + Build.MODEL;
      }
    }
  }
  
  public String tb()
  {
    return ta() + "_" + Build.DISPLAY.replace(" ", "_").toUpperCase();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     aeag
 * JD-Core Version:    0.7.0.1
 */