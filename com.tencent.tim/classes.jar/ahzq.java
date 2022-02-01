import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.qphone.base.util.QLog;

public class ahzq
{
  public static ahzq a;
  public boolean RU;
  public int dcK = 0;
  public int dcL = 1;
  public int dcM = 256;
  
  public static int Fw()
  {
    ahzq localahzq = a();
    if (localahzq != null) {
      return localahzq.dcM;
    }
    return 256;
  }
  
  public static int Z(String paramString, int paramInt)
  {
    if (paramString == null) {}
    do
    {
      return paramInt;
      try
      {
        int i = Integer.valueOf(paramString).intValue();
        return i;
      }
      catch (Exception paramString) {}
    } while (!QLog.isColorLevel());
    QLog.d("HotVideoDPC", 2, "StringToInt Exception! " + paramString);
    return paramInt;
  }
  
  public static ahzq a()
  {
    if ((a == null) || (a.RU)) {
      a = b();
    }
    return a;
  }
  
  public static boolean aoD()
  {
    ahzq localahzq = a();
    return (localahzq != null) && (localahzq.dcL == 1);
  }
  
  public static ahzq b()
  {
    int i1 = 256;
    boolean bool = false;
    if (QLog.isColorLevel()) {
      QLog.d("HotVideoDPC", 2, "loadHotVideoDPC!");
    }
    String str = DeviceProfileManager.a().jf(DeviceProfileManager.DpcNames.HotVCfg.name());
    QLog.i("HotVideoDPC", 2, "loadHotVideoDPC dpcValue: " + str);
    if (!TextUtils.isEmpty(str)) {}
    for (;;)
    {
      int k;
      int m;
      int i;
      int j;
      int n;
      try
      {
        localObject = str.split("\\|");
        if ((localObject != null) && (localObject.length >= 3))
        {
          k = Z(localObject[0], 0);
          m = k;
        }
      }
      catch (Exception localException2)
      {
        Object localObject;
        m = 0;
        j = 1;
        continue;
      }
      try
      {
        i = Z(localObject[1], 0);
        j = i;
        m = k;
        try
        {
          n = Z(localObject[2], 256);
          localObject = new ahzq();
          ((ahzq)localObject).dcK = k;
          ((ahzq)localObject).dcL = i;
          ((ahzq)localObject).dcM = n;
          if ((str == null) || (str.isEmpty())) {
            bool = true;
          }
          ((ahzq)localObject).RU = bool;
          return localObject;
        }
        catch (Exception localException1) {}
        if ((localObject != null) && (localObject.length == 1)) {
          k = Z(localObject[0], 0);
        }
      }
      catch (Exception localException3)
      {
        j = 1;
        continue;
      }
      try
      {
        QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 1");
        i = 1;
        n = i1;
      }
      catch (Exception localException4)
      {
        m = k;
        j = 1;
        continue;
      }
      if ((localObject != null) && (localObject.length == 2))
      {
        k = Z(localObject[0], 0);
        m = k;
        i = Z(localObject[1], 0);
        j = i;
        m = k;
        QLog.i("HotVideoDPC", 2, "loadHotVideoDPC configs.length == 2");
        n = i1;
        continue;
        n = i1;
        i = j;
        k = m;
        if (QLog.isColorLevel())
        {
          QLog.e("HotVideoDPC", 2, "loadHotVideoDPC exception:", localException1);
          n = i1;
          i = j;
          k = m;
        }
      }
      else
      {
        i = 1;
        k = 0;
        n = i1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("hotVideoSwitch: ").append(this.dcK);
    localStringBuilder.append(" hotVideoBlurSwitch: ").append(this.dcL);
    localStringBuilder.append(" hotVideoBlurMemory: ").append(this.dcM);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ahzq
 * JD-Core Version:    0.7.0.1
 */