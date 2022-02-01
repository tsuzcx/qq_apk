import android.text.TextUtils;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class aejd
{
  private static volatile aejd a;
  
  public static aejd a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new aejd();
      }
      return a;
    }
    finally {}
  }
  
  public String kh(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = Pattern.compile("^\\[(\\d+)\\]$").matcher(paramString);
    } while (!paramString.find());
    return paramString.group(1);
  }
  
  public String ki(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    do
    {
      return null;
      paramString = Pattern.compile("^\\[('|\")(.+)('|\")\\]$").matcher(paramString);
    } while (!paramString.find());
    return paramString.group(2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     aejd
 * JD-Core Version:    0.7.0.1
 */