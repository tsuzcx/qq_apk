import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class ajri
{
  public static String decode(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("decode src should not be null");
    }
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyURLSafeUtil", 4, "decode src:" + paramString);
    }
    String str = paramString;
    if (nG(paramString))
    {
      paramString = new String(aqct.decode(paramString.substring("*S1*".length()), 11));
      str = paramString;
      if (QLog.isDevelopLevel())
      {
        QLog.i("NearbyURLSafeUtil", 4, "decode result:" + paramString);
        str = paramString;
      }
    }
    return str;
  }
  
  public static String encode(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return paramString;
    }
    String str = "*S1*" + aqct.encodeToString(paramString.getBytes(), 11);
    if (QLog.isDevelopLevel()) {
      QLog.i("NearbyURLSafeUtil", 4, "encode:" + paramString + " to:" + str);
    }
    return str;
  }
  
  public static boolean nG(String paramString)
  {
    if (paramString == null) {
      throw new NullPointerException("isBase64 src should not be null");
    }
    return paramString.startsWith("*S1*");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     ajri
 * JD-Core Version:    0.7.0.1
 */