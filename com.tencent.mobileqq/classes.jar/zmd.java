import android.content.Context;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.app.QQAppInterface;

public class zmd
{
  public static boolean a(QQAppInterface paramQQAppInterface, Context paramContext, String paramString, boolean paramBoolean)
  {
    boolean bool1 = false;
    paramQQAppInterface = bgng.a(paramQQAppInterface, paramContext, paramString);
    if (paramQQAppInterface != null) {
      bool1 = paramQQAppInterface.a();
    }
    for (boolean bool2 = true;; bool2 = false)
    {
      if ((!bool2) && (paramBoolean))
      {
        Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
        localIntent.putExtra("url", paramString);
        localIntent.putExtra("selfSet_leftViewText", anni.a(2131714602));
        paramContext.startActivity(localIntent);
      }
      yqp.b("UrlJumpUtils", "jump %s, actionResult = %b, handled = %b", paramQQAppInterface, Boolean.valueOf(bool1), Boolean.valueOf(bool2));
      return bool2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zmd
 * JD-Core Version:    0.7.0.1
 */