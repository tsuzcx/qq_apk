import android.text.TextUtils;

public class acdx
{
  public static String jh(String paramString)
  {
    String str2 = "";
    String str1 = str2;
    int i;
    if (!TextUtils.isEmpty(paramString))
    {
      i = paramString.lastIndexOf("diydoutu@");
      str1 = str2;
      if (i >= 0) {
        str1 = paramString.substring(i, paramString.length());
      }
    }
    paramString = str1;
    if (!TextUtils.isEmpty(str1))
    {
      i = str1.lastIndexOf(".");
      paramString = str1;
      if (i >= 0) {
        paramString = str1.substring(0, i);
      }
    }
    return paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acdx
 * JD-Core Version:    0.7.0.1
 */