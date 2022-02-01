import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class alah
{
  public String RU;
  public boolean cvG = true;
  public int drd = 3;
  public int dre = 1000;
  public int drf = 3600;
  public int drg = 5;
  public int network = 0;
  public int open = 1;
  
  public static alah a()
  {
    alah localalah3 = new alah();
    str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.precover.name());
    localalah3.RU = str;
    localalah3.cvG = true;
    alah localalah1 = localalah3;
    try
    {
      if (!TextUtils.isEmpty(str))
      {
        String[] arrayOfString = str.split("\\|");
        localalah1 = localalah3;
        if (arrayOfString.length >= 6)
        {
          localalah3.cvG = false;
          localalah3.network = aa(arrayOfString[0], 0);
          localalah3.drd = aa(arrayOfString[1], 3);
          localalah3.dre = aa(arrayOfString[2], 1000);
          localalah3.drf = aa(arrayOfString[3], 3600);
          localalah3.open = aa(arrayOfString[4], 1);
          localalah3.drg = aa(arrayOfString[5], 5);
          if ((localalah3.network != 0) && (localalah3.network != 1) && (localalah3.network != 2)) {
            localalah3.network = 0;
          }
          localalah1 = localalah3;
          if (localalah3.open != 0)
          {
            localalah1 = localalah3;
            if (localalah3.open != 1)
            {
              localalah3.open = 1;
              localalah1 = localalah3;
            }
          }
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QLog.d("PrecoverControl", 1, "create Exception:" + localException.toString());
        if (QLog.isColorLevel()) {
          localException.printStackTrace();
        }
        alah localalah2 = new alah();
        localalah2.RU = str;
        localalah2.cvG = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("PrecoverControl", 2, "PrecoverControl.create, control=" + localalah1);
    }
    return localalah1;
  }
  
  private static int aa(String paramString, int paramInt)
  {
    int i;
    try
    {
      i = Integer.parseInt(paramString);
      if (i < 0) {
        return paramInt;
      }
    }
    catch (Throwable paramString)
    {
      return paramInt;
    }
    return i;
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("");
    localStringBuilder.append("PrecoverControl:isUsingDefaultValue=").append(this.cvG).append(", network=").append(this.network).append(", itemRetry=").append(this.drd).append(", totalRetry=").append(this.dre).append(", lbsExpire=").append(this.drf).append(", open=").append(this.open);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     alah
 * JD-Core Version:    0.7.0.1
 */