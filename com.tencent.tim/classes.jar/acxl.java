import android.content.Context;
import com.tencent.mobileqq.app.QQAppInterface;

public class acxl
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    if (paramString.startsWith("mqqapi://gamecenter/install"))
    {
      paramQQAppInterface = new acxk(paramQQAppInterface, paramContext);
      paramQQAppInterface.source = paramString;
      paramQQAppInterface.cti = "gamecenter";
      paramQQAppInterface.ctj = "install";
      return paramQQAppInterface;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxl
 * JD-Core Version:    0.7.0.1
 */