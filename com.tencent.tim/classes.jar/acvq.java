import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.net.URLDecoder;

public class acvq
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acvp(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "qboss";
    paramQQAppInterface.ctj = "qboss_load";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[1].split("&");
    int i = 0;
    for (;;)
    {
      if (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2) {}
        try
        {
          paramString[1] = URLDecoder.decode(paramString[1], "UTF-8");
          paramQQAppInterface.fj(paramString[0], paramString[1]);
          i += 1;
        }
        catch (Exception paramacuo)
        {
          for (;;)
          {
            if (QLog.isColorLevel()) {
              QLog.d("QbossLoaderParser", 2, "failed to decode param value,tmps[1] is:" + paramString[0] + ",tmps[1] is:" + paramString[1], paramacuo);
            }
          }
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvq
 * JD-Core Version:    0.7.0.1
 */