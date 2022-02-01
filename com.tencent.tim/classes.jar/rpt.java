import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class rpt
{
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
    throws IllegalArgumentException
  {
    boolean bool1 = false;
    paramQQAppInterface = aqik.c(paramQQAppInterface, paramContext, paramString);
    if (paramQQAppInterface != null) {
      bool1 = paramQQAppInterface.ace();
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) && (paramBoolean))
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("selfSet_leftViewText", acfp.m(2131716274));
        paramContext.startActivity(localIntent);
      }
      ram.b("UrlJumpUtils", "jump %s, actionResult = %b, handled = %b", paramQQAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     rpt
 * JD-Core Version:    0.7.0.1
 */