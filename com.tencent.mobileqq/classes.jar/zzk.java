import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class zzk
{
  private static boolean a;
  
  public static void a(Context paramContext, String paramString1, String paramString2, zzq paramzzq)
  {
    a(paramContext, paramString1, true, paramString2, 2131696176, paramzzq);
  }
  
  public static void a(Context paramContext, String paramString, zzq paramzzq)
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
        uuc.a((QQAppInterface)localAppRuntime, paramContext, paramString, new zzo(paramzzq), false, 0, true);
        return;
      }
    } while (paramzzq == null);
    paramzzq.a(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, zzq paramzzq)
  {
    if (paramContext == null) {}
    bkzi localbkzi;
    do
    {
      return;
      localbkzi = bkzi.a(paramContext);
      if (paramBoolean) {
        localbkzi.a(String.format(paramContext.getResources().getString(2131695031), new Object[] { paramString2 }));
      }
      localbkzi.a(paramInt, 3);
      localbkzi.c(2131690697);
      localbkzi.setOnDismissListener(new zzl());
      localbkzi.a(new zzm(paramzzq, paramString1, localbkzi));
      localbkzi.a(new zzn(paramContext, paramString1, paramzzq, localbkzi));
    } while (localbkzi.isShowing());
    a = false;
    localbkzi.show();
  }
  
  public static void b(Context paramContext, String paramString, zzq paramzzq)
  {
    a(paramContext, paramString, false, "", 2131695029, paramzzq);
  }
  
  public static void c(Context paramContext, String paramString, zzq paramzzq)
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
        uuc.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new zzp(paramzzq), true);
        return;
      }
    } while (paramzzq == null);
    paramzzq.a(false, paramString, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     zzk
 * JD-Core Version:    0.7.0.1
 */