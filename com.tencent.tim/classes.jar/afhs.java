import android.text.TextUtils;

public class afhs
{
  public static int cQV = 300;
  public static int cQW = 300;
  
  public static String B(String paramString1, String paramString2, String paramString3)
  {
    if ((TextUtils.isEmpty(paramString1)) || (TextUtils.isEmpty(paramString2)) || (TextUtils.isEmpty(paramString3))) {
      return null;
    }
    StringBuilder localStringBuilder = new StringBuilder("https://p.qpic.cn/");
    localStringBuilder.append(paramString2).append("/").append(paramString3).append("/").append(paramString1).append("/0");
    return localStringBuilder.toString();
  }
  
  public static String kC(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {
      return null;
    }
    return acbn.bmd + aczs.jH(paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     afhs
 * JD-Core Version:    0.7.0.1
 */