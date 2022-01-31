import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class yht
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, yhz paramyhz)
  {
    a(paramContext, paramString1, true, paramString2, 2131696917, paramyhz);
  }
  
  public static void a(Context paramContext, String paramString, yhz paramyhz)
  {
    if (TextUtils.isEmpty(paramString)) {
      QLog.e("SubscribeFollowUserUtil", 2, "follow user failed! user is null");
    }
    do
    {
      return;
      AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
      if ((localAppRuntime instanceof QQAppInterface))
      {
        syb.a((QQAppInterface)localAppRuntime, paramContext, paramString, new yhx(paramyhz), false, 0, true);
        return;
      }
    } while (paramyhz == null);
    paramyhz.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, yhz paramyhz)
  {
    if (paramContext == null) {}
    bhpy localbhpy;
    do
    {
      return;
      localbhpy = bhpy.a(paramContext);
      if (paramBoolean) {
        localbhpy.a(String.format(paramContext.getResources().getString(2131695777), new Object[] { paramString2 }));
      }
      localbhpy.a(paramInt, 3);
      localbhpy.c(2131690648);
      localbhpy.setOnDismissListener(new yhu());
      localbhpy.a(new yhv(paramyhz, paramString1, localbhpy));
      localbhpy.a(new yhw(paramContext, paramString1, paramyhz, localbhpy));
    } while (localbhpy.isShowing());
    a = false;
    localbhpy.show();
  }
  
  public static void b(Context paramContext, String paramString, yhz paramyhz)
  {
    a(paramContext, paramString, false, "", 2131695775, paramyhz);
  }
  
  public static void c(Context paramContext, String paramString, yhz paramyhz)
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
        syb.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new yhy(paramyhz), true);
        return;
      }
    } while (paramyhz == null);
    paramyhz.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     yht
 * JD-Core Version:    0.7.0.1
 */