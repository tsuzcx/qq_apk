import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.biz.pubaccount.readinjoy.common.WxShareHelperFromReadInjoy;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.2;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.3;
import com.tencent.biz.pubaccount.util.ShareUtils.ShareImageUtils.4;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.utils.FileUtils;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qzone.QZoneShareManager;
import java.util.ArrayList;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class uwi
{
  private static Bitmap jdField_a_of_type_AndroidGraphicsBitmap;
  private static biyn jdField_a_of_type_Biyn = new uwj();
  private static String jdField_a_of_type_JavaLangString;
  
  public static void a()
  {
    WXShareHelper.a().a(jdField_a_of_type_Biyn);
  }
  
  public static void a(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "launchFriendPicker path = " + jdField_a_of_type_JavaLangString);
    }
    if (jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    Intent localIntent = new Intent(paramActivity, ForwardRecentActivity.class);
    Bundle localBundle = new Bundle();
    localBundle.putBoolean("key_help_forward_pic", true);
    localIntent.putExtras(localBundle);
    localIntent.putExtra("forward_type", 1);
    localIntent.putExtra("key_allow_multiple_forward_from_limit", false);
    localIntent.putExtra("key_share_from_screen_shot", true);
    localIntent.putExtra("key_share_from_screen_need_finish", true);
    localIntent.setData(Uri.parse(jdField_a_of_type_JavaLangString));
    paramActivity.startActivityForResult(localIntent, 3);
  }
  
  public static void a(Context paramContext)
  {
    if (jdField_a_of_type_AndroidGraphicsBitmap == null)
    {
      QLog.e("ShareImageUtils", 1, "bitmap is null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ShareImageUtils.2(paramContext));
  }
  
  public static void a(Bitmap paramBitmap)
  {
    jdField_a_of_type_AndroidGraphicsBitmap = paramBitmap;
  }
  
  public static void a(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToQzone");
    }
    if (jdField_a_of_type_JavaLangString == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(jdField_a_of_type_JavaLangString);
    localBundle.putStringArrayList("images", localArrayList);
    QZoneShareManager.publishToQzone(paramBaseActivity, BaseApplicationImpl.getContext(), localBundle, null, 2);
  }
  
  public static void a(String paramString)
  {
    jdField_a_of_type_JavaLangString = paramString;
  }
  
  public static void b()
  {
    jdField_a_of_type_JavaLangString = null;
    jdField_a_of_type_AndroidGraphicsBitmap = null;
    WXShareHelper.a().b(jdField_a_of_type_Biyn);
  }
  
  public static void b(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720175;
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080));
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720176;
        }
      }
      else
      {
        WxShareHelperFromReadInjoy.a().a(jdField_a_of_type_JavaLangString, jdField_a_of_type_AndroidGraphicsBitmap, 0, false);
        return;
      }
      i = -1;
    }
  }
  
  public static void c(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToFriendCircle");
    }
    if ((jdField_a_of_type_JavaLangString == null) || (jdField_a_of_type_AndroidGraphicsBitmap == null))
    {
      QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
      return;
    }
    int i;
    if (!WXShareHelper.a().a()) {
      i = 2131720175;
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).b(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299080));
        return;
        if (!WXShareHelper.a().b()) {
          i = 2131720176;
        }
      }
      else
      {
        WxShareHelperFromReadInjoy.a().a(jdField_a_of_type_JavaLangString, jdField_a_of_type_AndroidGraphicsBitmap, 1, false);
        return;
      }
      i = -1;
    }
  }
  
  private static void d()
  {
    String str = AppConstants.SDCARD_ROOT + "/Tencent/QQ_Images/" + Calendar.getInstance().getTime() + ".png";
    if (FileUtils.saveBitmapToFile(jdField_a_of_type_AndroidGraphicsBitmap, str))
    {
      QLog.d("ShareImageUtils", 1, "save to sdcard success");
      bheg.a(BaseApplicationImpl.getContext(), str);
      str = BaseApplicationImpl.getContext().getString(2131694686) + " " + str;
      ThreadManager.getUIHandler().post(new ShareImageUtils.3(str));
      return;
    }
    QLog.d("ShareImageUtils", 1, "save to sdcard fail");
    ThreadManager.getUIHandler().post(new ShareImageUtils.4());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqq\classes14.jar
 * Qualified Name:     uwi
 * JD-Core Version:    0.7.0.1
 */