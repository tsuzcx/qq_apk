import android.content.Context;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;

public class acud
  extends acul
{
  public acuk a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, acuo paramacuo)
  {
    paramQQAppInterface = new acuc(paramQQAppInterface, paramContext);
    paramQQAppInterface.source = paramString;
    paramQQAppInterface.cti = "microapp";
    paramQQAppInterface.ctj = "open";
    if (QLog.isColorLevel()) {
      QLog.d("HttpOpenMicroAppParser", 2, "[miniapp-scheme], open microapp scheme=" + paramString);
    }
    paramContext = paramString.split("\\?");
    if ((paramContext.length < 2) || (paramContext[0].length() == 0)) {
      return paramQQAppInterface;
    }
    paramContext = paramString.substring(paramContext[0].length() + 1).split("&");
    if (paramContext != null)
    {
      int i = 0;
      while (i < paramContext.length)
      {
        paramString = paramContext[i].split("=");
        if ((paramString != null) && (paramString.length == 2))
        {
          paramQQAppInterface.fj(paramString[0], paramString[1]);
          if (QLog.isColorLevel()) {
            QLog.d("HttpOpenMicroAppParser", 2, "[miniapp-scheme], open microapp key=" + paramString[0] + ", value=" + paramString[1]);
          }
        }
        i += 1;
      }
    }
    paramContext = paramQQAppInterface.getAttribute("fakeUrl");
    if ((TextUtils.isEmpty(paramQQAppInterface.getAttribute("scene"))) && (!TextUtils.isEmpty(paramContext))) {
      paramQQAppInterface.fj("scene", String.valueOf(2003));
    }
    return paramQQAppInterface;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     acud
 * JD-Core Version:    0.7.0.1
 */