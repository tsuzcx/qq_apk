import android.os.Build;
import android.os.Build.VERSION;
import android.text.TextUtils;

public class aqom
{
  public static boolean C(String paramString1, String paramString2, String paramString3)
  {
    boolean bool1 = false;
    if (!TextUtils.isEmpty(paramString1)) {
      bool1 = paramString1.equalsIgnoreCase(Build.MANUFACTURER);
    }
    boolean bool2;
    if (!bool1) {
      bool2 = bool1;
    }
    do
    {
      do
      {
        return bool2;
        if (!TextUtils.isEmpty(paramString2)) {
          bool1 = paramString2.equalsIgnoreCase(Build.BRAND);
        }
        bool2 = bool1;
      } while (!bool1);
      bool2 = bool1;
    } while (TextUtils.isEmpty(paramString3));
    return paramString3.equalsIgnoreCase(Build.MODEL);
  }
  
  public static boolean aFr()
  {
    return (C("meizu", null, null)) && (Build.VERSION.SDK_INT > 20);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqom
 * JD-Core Version:    0.7.0.1
 */