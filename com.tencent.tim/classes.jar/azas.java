import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class azas
{
  public static boolean cGj;
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
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     azas
 * JD-Core Version:    0.7.0.1
 */