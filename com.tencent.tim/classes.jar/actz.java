import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class actz
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acty(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "groupvideo";
    if (paramString.contains("openroom")) {
      paramQQAppInterface.ctj = "openroom";
    }
    for (;;)
    {
      paramContext = paramString.split("\\?");
      if (paramContext.length == 2) {
        break;
      }
      return paramQQAppInterface;
      if (paramString.contains("preload")) {
        paramQQAppInterface.ctj = "preload";
      }
    }
    paramContext = paramContext[1].split("&");
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if ((paramString != null) && (paramString.length == 2)) {
          paramQQAppInterface.fj(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     actz
 * JD-Core Version:    0.7.0.1
 */