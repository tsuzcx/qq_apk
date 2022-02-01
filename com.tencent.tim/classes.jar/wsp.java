import android.text.TextUtils;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.DeviceProfileManager.a;
import com.tencent.qphone.base.util.QLog;

public class wsp
{
  public static DeviceProfileManager.a a;
  private static wsp a;
  private static final String aUb = DeviceProfileManager.DpcNames.aio_config.name();
  private String aUc;
  public boolean bfO = true;
  public boolean isSupport = true;
  
  static
  {
    jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a = new wsq();
  }
  
  private wsp()
  {
    DeviceProfileManager.a(jdField_a_of_type_ComTencentMobileqqAppDeviceProfileManager$a);
  }
  
  public static boolean RN()
  {
    wsp localwsp = a();
    if (localwsp != null) {
      return localwsp.bfO;
    }
    return true;
  }
  
  public static wsp a()
  {
    if (jdField_a_of_type_Wsp == null) {
      yX(false);
    }
    if (QLog.isColorLevel()) {
      QLog.d("AIODrawerDpc", 2, "getInstance: " + jdField_a_of_type_Wsp);
    }
    return jdField_a_of_type_Wsp;
  }
  
  public static boolean isSupport()
  {
    return false;
  }
  
  private static void yX(boolean paramBoolean)
  {
    for (;;)
    {
      try
      {
        long l1 = System.currentTimeMillis();
        if (jdField_a_of_type_Wsp == null)
        {
          jdField_a_of_type_Wsp = new wsp();
          paramBoolean = true;
        }
        if (paramBoolean) {}
        try
        {
          Object localObject1 = DeviceProfileManager.b().jf(aUb);
          jdField_a_of_type_Wsp.aUc = ((String)localObject1);
          if (!TextUtils.isEmpty((CharSequence)localObject1))
          {
            localObject1 = ((String)localObject1).split("\\|");
            if (localObject1.length < 19) {
              break label243;
            }
            if (Integer.valueOf(localObject1[18]).intValue() != 1) {
              continue;
            }
            jdField_a_of_type_Wsp.isSupport = true;
            if (localObject1.length < 20) {
              break label263;
            }
            if (Integer.valueOf(localObject1[19]).intValue() != 1) {
              break label253;
            }
            jdField_a_of_type_Wsp.bfO = true;
          }
        }
        catch (Exception localException)
        {
          long l2;
          QLog.d("AIODrawerDpc", 1, "load exp:" + localException.getMessage());
          jdField_a_of_type_Wsp.isSupport = true;
          jdField_a_of_type_Wsp.bfO = true;
          continue;
        }
        if (QLog.isColorLevel())
        {
          l2 = System.currentTimeMillis();
          QLog.d("AIODrawerDpc", 2, "loadDpc: " + jdField_a_of_type_Wsp + ", costMills: " + (l2 - l1));
        }
        return;
      }
      finally {}
      jdField_a_of_type_Wsp.isSupport = false;
      continue;
      label243:
      jdField_a_of_type_Wsp.isSupport = true;
      continue;
      label253:
      jdField_a_of_type_Wsp.bfO = false;
      continue;
      label263:
      jdField_a_of_type_Wsp.bfO = true;
    }
  }
  
  public String toString()
  {
    return "AIODrawerDpc{dpcValue='" + this.aUc + '\'' + ", isSupport=" + this.isSupport + ", needPreInflate=" + this.bfO + '}';
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     wsp
 * JD-Core Version:    0.7.0.1
 */