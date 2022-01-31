import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class wtb
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, wth paramwth)
  {
    a(paramContext, paramString1, true, paramString2, 2131696742, paramwth);
  }
  
  public static void a(Context paramContext, String paramString, wth paramwth)
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
        sgg.a((QQAppInterface)localAppRuntime, paramContext, paramString, new wtf(paramwth), false, 0, true);
        return;
      }
    } while (paramwth == null);
    paramwth.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, wth paramwth)
  {
    if (paramContext == null) {}
    bfpc localbfpc;
    do
    {
      return;
      localbfpc = bfpc.a(paramContext);
      if (paramBoolean) {
        localbfpc.a(String.format(paramContext.getResources().getString(2131695619), new Object[] { paramString2 }));
      }
      localbfpc.a(paramInt, 3);
      localbfpc.c(2131690596);
      localbfpc.setOnDismissListener(new wtc());
      localbfpc.a(new wtd(paramwth, paramString1, localbfpc));
      localbfpc.a(new wte(paramContext, paramString1, paramwth, localbfpc));
    } while (localbfpc.isShowing());
    a = false;
    localbfpc.show();
  }
  
  public static void b(Context paramContext, String paramString, wth paramwth)
  {
    a(paramContext, paramString, false, "", 2131695617, paramwth);
  }
  
  public static void c(Context paramContext, String paramString, wth paramwth)
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
        sgg.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new wtg(paramwth), true);
        return;
      }
    } while (paramwth == null);
    paramwth.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes5.jar
 * Qualified Name:     wtb
 * JD-Core Version:    0.7.0.1
 */