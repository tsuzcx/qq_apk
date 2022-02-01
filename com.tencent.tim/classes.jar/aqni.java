import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Handler.Callback;
import android.text.TextUtils;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.bubble.BubbleManager;
import com.tencent.mobileqq.vas.AvatarPendantManager;
import com.tencent.mobileqq.widget.QQToast;
import java.io.File;
import mqq.app.MobileQQ;

public class aqni
{
  public static Handler.Callback a = new aqnk();
  public static final String cum = acbn.SDCARD_PATH + ".VasResourceCheck/temp.json";
  public static Handler mUIHandler;
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, String paramString)
  {
    QQToast.a(paramActivity, acfp.m(2131716320), 0).show();
    paramActivity.finish();
    if (mUIHandler == null) {
      mUIHandler = new Handler(a);
    }
    paramActivity = new aquz(paramString, new File(cum));
    ((aqva)paramQQAppInterface.getManager(47)).a(1).a(paramActivity, new aqnj(paramQQAppInterface), null);
  }
  
  public static void eB(QQAppInterface paramQQAppInterface)
  {
    Object localObject = (BubbleManager)paramQQAppInterface.getManager(44);
    if (localObject != null)
    {
      aqhq.delete(((BubbleManager)localObject).A().getAbsolutePath(), false);
      ((BubbleManager)localObject).A();
    }
    localObject = (ku)paramQQAppInterface.getManager(42);
    if (localObject != null)
    {
      aqhq.delete(((ku)localObject).c().getAbsolutePath(), false);
      ((ku)localObject).c();
    }
    localObject = (AvatarPendantManager)paramQQAppInterface.getManager(46);
    if (localObject != null)
    {
      aqhq.delete(((AvatarPendantManager)localObject).K().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).K();
      aqhq.delete(((AvatarPendantManager)localObject).L().getAbsolutePath(), false);
      ((AvatarPendantManager)localObject).L();
    }
    localObject = new File(aqul.getSDKPrivatePath(acbn.SDCARD_PATH + ".emotionsm"));
    if (!((File)localObject).exists()) {
      ((File)localObject).mkdirs();
    }
    aqhq.delete(((File)localObject).getAbsolutePath(), false);
    ((File)localObject).mkdirs();
    paramQQAppInterface = new File(paramQQAppInterface.getApplication().getApplicationContext().getFilesDir().getParentFile(), "app_mobileqq_theme");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    aqhq.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(acbn.bmQ);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    aqhq.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(acbn.bmX + "resource");
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    aqhq.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
    paramQQAppInterface = new File(aqpq.cuS);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    aqhq.delete(paramQQAppInterface.getAbsolutePath(), false);
    paramQQAppInterface.mkdirs();
  }
  
  public static boolean rB(String paramString)
  {
    return (!TextUtils.isEmpty(paramString)) && (paramString.startsWith("https://gxh.vip.qq.com")) && (paramString.endsWith("secret.json"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes4.jar
 * Qualified Name:     aqni
 * JD-Core Version:    0.7.0.1
 */