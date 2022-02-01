import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

public class acfq
{
  private static acfq a;
  private static final String aUb = DeviceProfileManager.DpcNames.headDpcCfg.name();
  private DeviceProfileManager.a b = new acfr(this);
  private int cvP = 1;
  
  private acfq()
  {
    DeviceProfileManager.a(this.b);
    loadConfig();
  }
  
  public static acfq a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new acfq();
      }
      return a;
    }
    finally {}
  }
  
  public boolean aal()
  {
    QLog.d("HeadDpcCfg", 1, String.format("preferIpv6 mDualStackPrefIpv6=%d", new Object[] { Integer.valueOf(this.cvP) }));
    return this.cvP != 0;
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
        this.cvP = Integer.valueOf(arrayOfString[0]).intValue();
        if (QLog.isColorLevel()) {
          QLog.d("HeadDpcCfg", 2, String.format("loadConfig, mDualStackPrefIpv6: %s, dpc=%s", new Object[] { Integer.valueOf(this.cvP), str }));
        }
        return;
      }
      catch (Exception localException)
      {
        QLog.d("HeadDpcCfg", 1, "loadConfig exception :" + localException.getMessage());
        this.cvP = 1;
        continue;
      }
      this.cvP = 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acfq
 * JD-Core Version:    0.7.0.1
 */