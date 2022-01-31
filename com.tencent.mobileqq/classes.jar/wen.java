import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class wen
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, wes paramwes)
  {
    a(paramContext, paramString1, true, paramString2, 2131631029, paramwes);
  }
  
  public static void a(Context paramContext, String paramString, wes paramwes)
  {
    a(paramContext, paramString, false, "", 2131629935, paramwes);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, wes paramwes)
  {
    if (paramContext == null) {}
    begr localbegr;
    do
    {
      return;
      localbegr = begr.a(paramContext);
      if (paramBoolean) {
        localbegr.a(String.format(paramContext.getResources().getString(2131629937), new Object[] { paramString2 }));
      }
      localbegr.a(paramInt, 3);
      localbegr.c(2131625035);
      localbegr.setOnDismissListener(new weo());
      localbegr.a(new wep(paramwes, paramString1, localbegr));
      localbegr.a(new weq(paramContext, paramString1, paramwes, localbegr));
    } while (localbegr.isShowing());
    a = false;
    localbegr.show();
  }
  
  public static void b(Context paramContext, String paramString, wes paramwes)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "unfollow user failed! user is null");
    }
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        rtr.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new wer(paramwes), true);
        return;
      }
    } while (paramwes == null);
    paramwes.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wen
 * JD-Core Version:    0.7.0.1
 */