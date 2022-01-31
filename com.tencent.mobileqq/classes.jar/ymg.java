import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class ymg
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, ymm paramymm)
  {
    a(paramContext, paramString1, true, paramString2, 2131696919, paramymm);
  }
  
  public static void a(Context paramContext, String paramString, ymm paramymm)
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
        syb.a((QQAppInterface)localAppRuntime, paramContext, paramString, new ymk(paramymm), false, 0, true);
        return;
      }
    } while (paramymm == null);
    paramymm.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, ymm paramymm)
  {
    if (paramContext == null) {}
    bhuf localbhuf;
    do
    {
      return;
      localbhuf = bhuf.a(paramContext);
      if (paramBoolean) {
        localbhuf.a(String.format(paramContext.getResources().getString(2131695779), new Object[] { paramString2 }));
      }
      localbhuf.a(paramInt, 3);
      localbhuf.c(2131690648);
      localbhuf.setOnDismissListener(new ymh());
      localbhuf.a(new ymi(paramymm, paramString1, localbhuf));
      localbhuf.a(new ymj(paramContext, paramString1, paramymm, localbhuf));
    } while (localbhuf.isShowing());
    a = false;
    localbhuf.show();
  }
  
  public static void b(Context paramContext, String paramString, ymm paramymm)
  {
    a(paramContext, paramString, false, "", 2131695777, paramymm);
  }
  
  public static void c(Context paramContext, String paramString, ymm paramymm)
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
        syb.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new yml(paramymm), true);
        return;
      }
    } while (paramymm == null);
    paramymm.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes12.jar
 * Qualified Name:     ymg
 * JD-Core Version:    0.7.0.1
 */