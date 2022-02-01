import android.os.Build.VERSION;
import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

public class awjq
{
  private static awjq a;
  private static final String aUb = DeviceProfileManager.DpcNames.homeworkCfg.name();
  private DeviceProfileManager.a b = new awjr(this);
  private int eBr = 22;
  
  private awjq()
  {
    DeviceProfileManager.a(this.b);
    loadConfig();
  }
  
  public static awjq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new awjq();
      }
      return a;
    }
    finally {}
  }
  
  public boolean aNc()
  {
    QLog.d("HomeworkDpcCfg", 1, String.format("hwUseNewAPI thisVer=%d cfgVer=%d", new Object[] { Integer.valueOf(Build.VERSION.SDK_INT), Integer.valueOf(this.eBr) }));
    return Build.VERSION.SDK_INT <= this.eBr;
  }
  
  public void loadConfig()
  {
    String str = DeviceProfileManager.b().jf(aUb);
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length < 1) {}
    }
    for (;;)
    {
      try
      {
        this.eBr = Integer.valueOf(arrayOfString[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HomeworkDpcCfg", 2, String.format("loadConfig, mUseNewApiLevel: %s, dpc=%s", new Object[] { Integer.valueOf(this.eBr), str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HomeworkDpcCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.eBr = 22;
        continue;
      }
      this.eBr = 22;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     awjq
 * JD-Core Version:    0.7.0.1
 */