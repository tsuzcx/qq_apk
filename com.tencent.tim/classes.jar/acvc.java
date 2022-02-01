import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class acvc
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acvb(paramQQAppInterface, paramContext);
    paramContext = paramString.split("\\?");
    if (paramContext.length < 1) {
      return paramQQAppInterface;
    }
    paramContext = paramContext[0].substring("mqqapi://".length()).split("/");
    if (paramContext.length != 2) {
      return paramQQAppInterface;
    }
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = paramContext[0];
    paramQQAppInterface.ctj = paramContext[1];
    paramContext = Uri.parse(paramString);
    paramacuo = paramContext.getQueryParameterNames().iterator();
    while (paramacuo.hasNext())
    {
      String str1 = (String)paramacuo.next();
      if (!TextUtils.isEmpty(str1))
      {
        String str2 = paramContext.getQueryParameter(str1);
        if (!TextUtils.isEmpty(str2)) {
          paramQQAppInterface.fj(str1.toLowerCase(), str2);
        }
      }
    }
    paramQQAppInterface.fj("key_scheme", paramString);
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acvc
 * JD-Core Version:    0.7.0.1
 */