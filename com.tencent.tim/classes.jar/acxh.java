import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class acxh
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acxg(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "commonBuddyGroup";
    paramQQAppInterface.ctj = "open";
    paramContext = paramString.split("\\?");
    if (paramContext.length != 2) {}
    for (;;)
    {
      return paramQQAppInterface;
      paramContext = paramContext[1].split("&");
      int j = paramContext.length;
      int i = 0;
      while (i < j)
      {
        paramString = paramContext[i].split("=");
        if (paramString.length == 2) {
          paramQQAppInterface.fj(paramString[0], paramString[1]);
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxh
 * JD-Core Version:    0.7.0.1
 */