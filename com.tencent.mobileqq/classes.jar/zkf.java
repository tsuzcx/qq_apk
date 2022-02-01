import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class zkf
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, zkl paramzkl)
  {
    a(paramContext, paramString1, true, paramString2, 2131695924, paramzkl);
  }
  
  public static void a(Context paramContext, String paramString, zkl paramzkl)
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
        ugf.a((QQAppInterface)localAppRuntime, paramContext, paramString, new zkj(paramzkl), false, 0, true);
        return;
      }
    } while (paramzkl == null);
    paramzkl.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, zkl paramzkl)
  {
    if (paramContext == null) {}
    bjnw localbjnw;
    do
    {
      return;
      localbjnw = bjnw.a(paramContext);
      if (paramBoolean) {
        localbjnw.a(String.format(paramContext.getResources().getString(2131694820), new Object[] { paramString2 }));
      }
      localbjnw.a(paramInt, 3);
      localbjnw.c(2131690620);
      localbjnw.setOnDismissListener(new zkg());
      localbjnw.a(new zkh(paramzkl, paramString1, localbjnw));
      localbjnw.a(new zki(paramContext, paramString1, paramzkl, localbjnw));
    } while (localbjnw.isShowing());
    a = false;
    localbjnw.show();
  }
  
  public static void b(Context paramContext, String paramString, zkl paramzkl)
  {
    a(paramContext, paramString, false, "", 2131694818, paramzkl);
  }
  
  public static void c(Context paramContext, String paramString, zkl paramzkl)
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
        ugf.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new zkk(paramzkl), true);
        return;
      }
    } while (paramzkl == null);
    paramzkl.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zkf
 * JD-Core Version:    0.7.0.1
 */