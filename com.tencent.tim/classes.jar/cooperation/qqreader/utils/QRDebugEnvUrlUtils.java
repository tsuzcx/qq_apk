package cooperation.qqreader.utils;

import android.content.Context;
import android.text.TextUtils;
import avob.b;

public final class QRDebugEnvUrlUtils
{
  private static String cMp;
  private static boolean dnH;
  
  public static String getTestEnv()
  {
    return cMp;
  }
  
  public static boolean getTestMode()
  {
    return dnH;
  }
  
  public static String getTestUrl(String paramString)
  {
    if ((!dnH) || (TextUtils.isEmpty(paramString))) {}
    while ((!paramString.contains("cdn.vip.qq.com")) || (paramString.contains("h5.books.qq.com"))) {
      return paramString;
    }
    StringBuilder localStringBuilder = new StringBuilder().append("h5.books.qq.com/proxy/domain/cdn.vip.qq.com");
    if (TextUtils.isEmpty(cMp)) {}
    for (String str = "";; str = "/" + cMp) {
      return paramString.replace("cdn.vip.qq.com", str);
    }
  }
  
  public static void initTestEnv(Context paramContext)
  {
    dnH = avob.b.cS(paramContext);
    cMp = avob.b.bK(paramContext);
  }
  
  public static boolean isDebugEnv()
  {
    return false;
  }
  
  public static void setTestEnv(Context paramContext, boolean paramBoolean, String paramString)
  {
    avob.b.g(paramContext, paramBoolean, paramString);
    dnH = paramBoolean;
    cMp = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     cooperation.qqreader.utils.QRDebugEnvUrlUtils
 * JD-Core Version:    0.7.0.1
 */