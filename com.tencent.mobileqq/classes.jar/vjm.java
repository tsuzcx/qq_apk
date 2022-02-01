import android.util.SparseIntArray;
import com.tencent.util.VersionUtils;

public class vjm
{
  public static String a(String paramString)
  {
    if (VersionUtils.isIceScreamSandwich()) {
      return paramString;
    }
    if (paramString == null) {
      return "";
    }
    if (paramString.length() <= 0) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    int k = paramString.length();
    int i = 0;
    if (i < k)
    {
      int m = paramString.codePointAt(i);
      if (begd.a.get(m, -1) != -1)
      {
        int j = i;
        if (m > 65535) {
          j = i + 1;
        }
        localStringBuilder.append("*");
        i = j;
      }
      for (;;)
      {
        i += 1;
        break;
        localStringBuilder.append(paramString.charAt(i));
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vjm
 * JD-Core Version:    0.7.0.1
 */