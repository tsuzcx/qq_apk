import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class anhz
{
  public static boolean cGj;
  public static boolean cGk;
  public static int dGl = 1500;
  
  public static boolean axf()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportHwCodec=" + cGj);
    }
    boolean bool = anii.isFoundProductFeature(anii.KEY_HW_HARDENCODE_NOT_SUPPORT_MODEL);
    if (bool) {
      if (QLog.isColorLevel()) {
        QLog.d("HwEnvData", 2, "[@] supportHardWareCodec:black=" + bool);
      }
    }
    while (Build.VERSION.SDK_INT < 18) {
      return false;
    }
    return cGj;
  }
  
  public static boolean axg()
  {
    if (QLog.isColorLevel()) {
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:SDK_INT=" + Build.VERSION.SDK_INT + "dpcSupportPre_SendEncode=" + cGk + "dpcSupportHwCodec=" + cGj);
    }
    if (Build.VERSION.SDK_INT < 18) {}
    do
    {
      boolean bool;
      do
      {
        do
        {
          return false;
          bool = anii.isFoundProductManufacturer(anii.KEY_HW_PRE_SEND_NOT_SUPPORT_MODEL);
          if (!bool) {
            break;
          }
        } while (!QLog.isColorLevel());
        QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool);
        return false;
        bool = anii.isFoundProductFeature(anii.KEY_HW_HARDENCODE_NOT_SUPPORT_MODEL);
        if (!bool) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.d("HwEnvData", 2, "[@] supportRecordAndEncode:black=" + bool + " hardware Black");
      return false;
    } while ((!cGk) || (!cGj));
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anhz
 * JD-Core Version:    0.7.0.1
 */