import android.content.Context;
import android.content.res.Resources;
import com.tencent.biz.qqcircle.utils.QCircleBindPhoneNumberHelper.2;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManagerV2;
import common.config.service.QzoneConfig;
import mqq.app.AppRuntime;

public class vvw
{
  private static boolean a;
  
  public static void a()
  {
    if (QzoneConfig.isQQCircleShowLebaEntrance()) {
      ThreadManagerV2.executeOnSubThread(new QCircleBindPhoneNumberHelper.2());
    }
  }
  
  public static void a(boolean paramBoolean)
  {
    AppRuntime localAppRuntime = BaseApplicationImpl.getApplication().getRuntime();
    if ((localAppRuntime instanceof QQAppInterface)) {
      bcvd.b((QQAppInterface)localAppRuntime, new vvx(paramBoolean));
    }
  }
  
  public static boolean a()
  {
    int i;
    if (QzoneConfig.getQQCircleUsePhoneSecurityAuth())
    {
      uyk localuyk = uyk.a();
      if (localuyk != null)
      {
        i = localuyk.b();
        if (i != 0) {
          break label29;
        }
        a(false);
      }
    }
    label29:
    while (i == 1) {
      return true;
    }
    return false;
  }
  
  public static boolean a(Context paramContext, int paramInt)
  {
    if ((paramContext == null) || (a)) {
      return false;
    }
    if (paramContext.getResources() != null)
    {
      String str1 = paramContext.getResources().getString(2131697178);
      String str2 = paramContext.getResources().getString(2131697176);
      vvy localvvy = new vvy(paramContext);
      paramContext = bhlq.a(paramContext, 230, str1, str2, 2131697175, 2131697177, localvvy, localvvy);
      paramContext.setCancelable(false);
      a = true;
      vtq.a("", 53, 1, paramInt);
      paramContext.show();
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     vvw
 * JD-Core Version:    0.7.0.1
 */