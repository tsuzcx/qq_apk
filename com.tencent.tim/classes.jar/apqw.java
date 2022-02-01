import android.text.TextUtils;
import com.tencent.qphone.base.util.QLog;

public class apqw
{
  public static boolean isAvatarUrl(String paramString)
  {
    if (paramString == null) {
      return false;
    }
    return paramString.startsWith("https://p.qlogo.cn/gh/");
  }
  
  public static boolean isNumeric(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    if (((paramString.length() > 1) && (paramString.startsWith("+"))) || (paramString.startsWith("-"))) {}
    for (int i = 1;; i = 0)
    {
      int j = paramString.length();
      int k;
      do
      {
        k = j - 1;
        if (k < i) {
          break;
        }
        j = k;
      } while (Character.isDigit(paramString.charAt(k)));
      return false;
      return true;
    }
  }
  
  public static String oK(String paramString)
  {
    if (isAvatarUrl(paramString)) {
      return paramString + 140;
    }
    return null;
  }
  
  public static String oL(String paramString)
  {
    if (isAvatarUrl(paramString)) {
      return paramString + 0;
    }
    return null;
  }
  
  public static String p(String paramString1, String paramString2, int paramInt)
  {
    if (TextUtils.isEmpty(paramString2)) {
      QLog.d("AvatarTroopUtil", 1, "getAvatarAddress troopUin is empty");
    }
    do
    {
      return "https://p.qlogo.cn/gh/dir/file/";
      if (1 == paramInt) {
        return "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2 + "_" + paramString1);
      }
    } while (paramInt != 0);
    return "https://p.qlogo.cn/gh/dir/file/".replace("dir", paramString2).replace("file", paramString2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     apqw
 * JD-Core Version:    0.7.0.1
 */