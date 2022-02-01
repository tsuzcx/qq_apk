import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.qphone.base.util.QLog;
import java.lang.ref.WeakReference;
import mqq.app.AppRuntime;

public class shk
{
  private static boolean aLm;
  
  public static void a(Context paramContext, String paramString1, String paramString2, shk.c paramc)
  {
    a(paramContext, paramString1, true, paramString2, 2131698678, paramc);
  }
  
  public static void a(Context paramContext, String paramString, shk.c paramc)
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
        ocp.a((QQAppInterface)localAppRuntime, paramContext, paramString, new shk.a(paramc), false, 0, true);
        return;
      }
    } while (paramc == null);
    paramc.g(false, paramString, false);
  }
  
  public static void a(Context paramContext, String paramString1, boolean paramBoolean, String paramString2, int paramInt, shk.c paramc)
  {
    if (paramContext == null) {}
    ausj localausj;
    do
    {
      return;
      localausj = ausj.b(paramContext);
      if (paramBoolean) {
        localausj.setMainTitle(String.format(paramContext.getResources().getString(2131697482), new Object[] { paramString2 }));
      }
      localausj.addButton(paramInt, 3);
      localausj.addCancelButton(2131721058);
      localausj.setOnDismissListener(new shl());
      localausj.setOnBottomCancelListener(new shm(paramc, paramString1, localausj));
      localausj.a(new shn(paramContext, paramString1, paramc, localausj));
    } while (localausj.isShowing());
    aLm = false;
    localausj.show();
  }
  
  public static void b(Context paramContext, String paramString, shk.c paramc)
  {
    a(paramContext, paramString, false, "", 2131697480, paramc);
  }
  
  public static void c(Context paramContext, String paramString, shk.c paramc)
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
        ocp.a((QQAppInterface)localAppRuntime, paramContext, paramString, false, new shk.b(paramc), true);
        return;
      }
    } while (paramc == null);
    paramc.g(false, paramString, false);
  }
  
  static class a
    extends acje
  {
    WeakReference<shk.c> dp;
    
    public a(shk.c paramc)
    {
      this.dp = new WeakReference(paramc);
    }
    
    public void m(boolean paramBoolean, String paramString)
    {
      super.m(paramBoolean, paramString);
      shk.c localc = (shk.c)this.dp.get();
      if (localc != null) {
        localc.g(paramBoolean, paramString, false);
      }
    }
  }
  
  static class b
    extends acje
  {
    WeakReference<shk.c> dp;
    
    public b(shk.c paramc)
    {
      this.dp = new WeakReference(paramc);
    }
    
    public void v(boolean paramBoolean, String paramString)
    {
      super.m(paramBoolean, paramString);
      shk.c localc = (shk.c)this.dp.get();
      if (localc != null) {
        localc.g(paramBoolean, paramString, false);
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void g(boolean paramBoolean1, String paramString, boolean paramBoolean2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes15.jar
 * Qualified Name:     shk
 * JD-Core Version:    0.7.0.1
 */