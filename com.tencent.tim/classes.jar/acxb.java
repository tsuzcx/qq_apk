import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import java.util.Iterator;
import java.util.Set;

public class acxb
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acxa(paramQQAppInterface, paramContext);
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
    paramString = paramContext.getQueryParameterNames().iterator();
    while (paramString.hasNext())
    {
      paramacuo = (String)paramString.next();
      if (!TextUtils.isEmpty(paramacuo))
      {
        String str = paramContext.getQueryParameter(paramacuo);
        if (!TextUtils.isEmpty(str)) {
          paramQQAppInterface.fj(paramacuo.toLowerCase(), str);
        }
      }
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acxb
 * JD-Core Version:    0.7.0.1
 */