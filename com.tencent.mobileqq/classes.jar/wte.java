import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class wte
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, wtk paramwtk)
  {
    a(paramContext, paramString1, true, paramString2, 2131696741, paramwtk);
  }
  
  public static void a(Context paramContext, String paramString, wtk paramwtk)
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
        sgj.a((QQAppInterface)localAppRuntime, paramContext, paramString, new wti(paramwtk), false, 0, true);
        return;
      }
    } while (paramwtk == null);
    paramwtk.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, wtk paramwtk)
  {
    if (paramContext == null) {}
    bfol localbfol;
    do
    {
      return;
      localbfol = bfol.a(paramContext);
      if (paramBoolean) {
        localbfol.a(String.format(paramContext.getResources().getString(2131695618), new Object[] { paramString2 }));
      }
      localbfol.a(paramInt, 3);
      localbfol.c(2131690596);
      localbfol.setOnDismissListener(new wtf());
      localbfol.a(new wtg(paramwtk, paramString1, localbfol));
      localbfol.a(new wth(paramContext, paramString1, paramwtk, localbfol));
    } while (localbfol.isShowing());
    a = false;
    localbfol.show();
  }
  
  public static void b(Context paramContext, String paramString, wtk paramwtk)
  {
    a(paramContext, paramString, false, "", 2131695616, paramwtk);
  }
  
  public static void c(Context paramContext, String paramString, wtk paramwtk)
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
        sgj.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new wtj(paramwtk), true);
        return;
      }
    } while (paramwtk == null);
    paramwtk.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wte
 * JD-Core Version:    0.7.0.1
 */