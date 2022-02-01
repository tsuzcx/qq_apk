import android.os.IBinder;
import android.telephony.TelephonyManager;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import java.lang.reflect.Method;

public class aqon
{
  private static aqon jdField_a_of_type_Aqon;
  public static String cuA;
  public static String cuB = "0";
  public static String cuC = "1";
  public static int eaJ = -1;
  private TelephonyManager[] jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager;
  private s[] jdField_a_of_type_ArrayOfS;
  private Object fw;
  private Object fx;
  
  private aqon()
  {
    try
    {
      eeH();
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public static aqon a()
  {
    if (jdField_a_of_type_Aqon == null) {}
    try
    {
      jdField_a_of_type_Aqon = new aqon();
      return jdField_a_of_type_Aqon;
    }
    finally {}
  }
  
  private void eeH()
  {
    this.jdField_a_of_type_ArrayOfS = new s[2];
    switch (eaJ)
    {
    case 0: 
    case 1: 
    case 4: 
    default: 
    case 2: 
    case 3: 
      for (;;)
      {
        return;
        try
        {
          this.fw = aqos.invokeStaticMethod("android.telephony.MSimTelephonyManager", "getDefault", null, null);
          this.fx = aqos.invokeStaticMethod("android.telephony.MSimSmsManager", "getDefault", null, null);
          return;
        }
        catch (Exception localException1)
        {
          localException1.printStackTrace();
          return;
        }
        try
        {
          this.jdField_a_of_type_ArrayOfS[0] = s.a.a(aqot.getService("isms"));
          this.jdField_a_of_type_ArrayOfS[1] = s.a.a(aqot.getService("isms2"));
          if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null)
          {
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager = new TelephonyManager[2];
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[0] = ((TelephonyManager)aqos.invokeStaticMethod("android.telephony.TelephonyManager", "getDefault"));
            this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[1] = ((TelephonyManager)aqos.invokeStaticMethod("android.telephony.TelephonyManager", "getSecondary"));
            return;
          }
        }
        catch (Exception localException2)
        {
          localException2.printStackTrace();
          return;
        }
        catch (Error localError)
        {
          localError.printStackTrace();
          return;
        }
      }
    }
    try
    {
      this.fw = BaseApplicationImpl.getContext().getSystemService("phone");
      s locals = s.a.a((IBinder)Class.forName("android.os.ServiceManager").getMethod("getService", new Class[] { String.class }).invoke(null, new Object[] { "isms" }));
      this.jdField_a_of_type_ArrayOfS[0] = locals;
      return;
    }
    catch (Throwable localThrowable)
    {
      localThrowable.printStackTrace();
    }
  }
  
  public int getSimState(int paramInt)
  {
    int i = 1;
    switch (eaJ)
    {
    }
    for (;;)
    {
      return 0;
      if (this.fw == null) {
        continue;
      }
      try
      {
        paramInt = ((Integer)aqos.invokeMethod(this.fw, "getSimState", new Object[] { Integer.valueOf(paramInt) })).intValue();
        return paramInt;
      }
      catch (Exception localException1)
      {
        localException1.printStackTrace();
      }
      continue;
      if (this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager == null) {
        continue;
      }
      return this.jdField_a_of_type_ArrayOfAndroidTelephonyTelephonyManager[paramInt].getSimState();
      if (this.fw == null) {
        continue;
      }
      try
      {
        Object localObject = this.fw;
        if (paramInt == 0) {}
        for (paramInt = i;; paramInt = 5)
        {
          paramInt = ((Integer)aqos.invokeMethod(localObject, "getIccState", new Object[] { Integer.valueOf(paramInt) })).intValue();
          return paramInt;
        }
      }
      catch (Exception localException2)
      {
        localException2.printStackTrace();
      }
    }
  }
  
  public boolean mC(int paramInt)
  {
    return getSimState(paramInt) == 5;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqon
 * JD-Core Version:    0.7.0.1
 */