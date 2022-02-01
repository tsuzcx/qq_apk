import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;
import java.util.Random;

public class ahfg
{
  private static ahfg a;
  private static final String aUb = DeviceProfileManager.DpcNames.qflutterCfg.name();
  private static Random sRandom = new Random();
  private boolean aNp;
  private boolean mNeedReport;
  
  private ahfg()
  {
    DeviceProfileManager.a(new ahfh(this));
    loadConfig();
  }
  
  public static ahfg a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new ahfg();
      }
      return a;
    }
    finally {}
  }
  
  public boolean ane()
  {
    return this.aNp;
  }
  
  public void loadConfig()
  {
    String str = DeviceProfileManager.b().jf(aUb);
    String[] arrayOfString;
    if (!TextUtils.isEmpty(str))
    {
      arrayOfString = str.split("\\|");
      if (arrayOfString.length < 2) {}
    }
    for (;;)
    {
      try
      {
        if (Integer.valueOf(arrayOfString[0]).intValue() != 1) {
          continue;
        }
        this.aNp = true;
        if (sRandom.nextFloat() >= Float.valueOf(arrayOfString[1]).floatValue()) {
          continue;
        }
        this.mNeedReport = true;
      }
      catch (Exception localException)
      {
        QLog.d("QFlutterDPC", 1, "loadConfig exception :" + localException.getMessage());
        this.mNeedReport = true;
        this.aNp = true;
        continue;
        this.mNeedReport = false;
        continue;
      }
      if (QLog.isColorLevel()) {
        QLog.d("QFlutterDPC", 2, String.format("loadConfig, dpcValue: %s, mIsSupport: %s, mNeedReport: %s", new Object[] { str, Boolean.valueOf(this.aNp), Boolean.valueOf(this.mNeedReport) }));
      }
      return;
      this.aNp = false;
      continue;
      this.mNeedReport = true;
      this.aNp = true;
    }
  }
  
  public boolean needReport()
  {
    return this.mNeedReport;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahfg
 * JD-Core Version:    0.7.0.1
 */