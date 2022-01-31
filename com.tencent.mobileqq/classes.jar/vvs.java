import java.net.URLEncoder;

public class vvs
{
  public static final String a = baht.a() + "/Tencent/MobileQQ/qsubscribe/";
  
  public static String a(String paramString)
  {
    return String.format("https://h5.qzone.qq.com/subscription/openshop/%s?_proxy=1&_wv=3", new Object[] { paramString });
  }
  
  public static String a(String paramString1, String paramString2)
  {
    String str = String.format("http://h5.qzone.qq.com/subscription/addgoods/%s?_proxy=1&_wv=3", new Object[] { paramString1 });
    paramString1 = str;
    if (paramString2 != null)
    {
      paramString1 = str;
      if (!baip.a(paramString2)) {
        paramString1 = str + "&id=" + URLEncoder.encode(paramString2);
      }
    }
    return paramString1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     vvs
 * JD-Core Version:    0.7.0.1
 */