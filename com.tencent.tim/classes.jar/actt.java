import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class actt
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acts(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "ftssearch";
    paramQQAppInterface.ctj = "openmixweb";
    paramContext = paramString.replace("mqqapi://ftssearch/openmixweb?", "").replace("^?", "").split("&");
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
 * Qualified Name:     actt
 * JD-Core Version:    0.7.0.1
 */