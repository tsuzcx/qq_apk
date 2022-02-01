import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class acus
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acuq(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "lightapp";
    paramQQAppInterface.ctj = "open";
    paramContext = Uri.parse(paramString);
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramacuo = (String)paramString.next();
      if (!TextUtils.isEmpty(paramacuo))
      {
        String str = paramContext.getQueryParameter(paramacuo);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.fj(paramacuo, str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acus
 * JD-Core Version:    0.7.0.1
 */