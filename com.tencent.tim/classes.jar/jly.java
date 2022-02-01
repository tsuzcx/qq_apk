import android.os.Build.VERSION;
import com.tencent.qphone.base.util.QLog;

public class jly
{
  public static String Pb;
  public static String SY;
  public static String SZ = key_test + SY;
  public static String key_root = "sharp/video_effect/";
  public static String key_test = key_root + "test/";
  public static String key_test_disable_sdk;
  public static String str_disable_sdk;
  public static String str_min_sdk = "min_sdk";
  @Deprecated
  imf a = null;
  
  static
  {
    str_disable_sdk = "disable_sdk";
    SY = "flag";
    Pb = key_test + str_min_sdk;
    key_test_disable_sdk = key_test + str_disable_sdk;
  }
  
  public int a(imf paramimf)
  {
    if (QLog.isColorLevel()) {
      QLog.d("VideoEffectConfigParser", 2, "getVideoEffectTestFlag sdk: " + Build.VERSION.SDK_INT);
    }
    try
    {
      int[] arrayOfInt = paramimf.getIntValues(SZ);
      if (arrayOfInt != null)
      {
        if ((arrayOfInt[0] & 0x1) != 1) {
          return 0;
        }
        arrayOfInt = paramimf.getIntValues(Pb);
        if ((arrayOfInt != null) && (Build.VERSION.SDK_INT >= arrayOfInt[0]))
        {
          boolean bool = jjd.contains(paramimf.getIntValues(key_test_disable_sdk), Build.VERSION.SDK_INT);
          if (!bool) {
            return 1;
          }
        }
      }
    }
    catch (Exception paramimf) {}
    return 0;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     jly
 * JD-Core Version:    0.7.0.1
 */