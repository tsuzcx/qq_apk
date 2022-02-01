import com.tencent.mobileqq.utils.SecUtil;
import java.util.concurrent.ConcurrentHashMap;

public class twz
{
  private static ConcurrentHashMap<String, String> aB = new ConcurrentHashMap();
  
  public static String getFileMd5(String paramString)
  {
    String str2 = (String)aB.get(paramString);
    String str1 = str2;
    if (str2 == null)
    {
      str2 = SecUtil.getFileMd5(paramString);
      str1 = str2;
      if (str2 != null)
      {
        aB.put(paramString, str2);
        str1 = str2;
      }
    }
    return str1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     twz
 * JD-Core Version:    0.7.0.1
 */