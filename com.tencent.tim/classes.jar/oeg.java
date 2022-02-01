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
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.mobileqq.wxapi.WXShareHelper;
import com.tencent.mobileqq.wxapi.WXShareHelper.a;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Calendar;
import mqq.os.MqqHandler;

public class oeg
{
  private static WXShareHelper.a b = new oeh();
  private static Bitmap bitmap;
  private static String currentPath;
  
  public static void aU(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "launchFriendPicker path = " + currentPath);
    }
    if (currentPath == null)
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
    localIntent.setData(Uri.parse(currentPath));
    paramActivity.startActivityForResult(localIntent, 3);
  }
  
  public static void aV(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "ScreenShotShareFragment shareToWXFriend");
    }
    if ((currentPath == null) || (bitmap == null))
    {
      QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
      return;
    }
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        WxShareHelperFromReadInjoy.a().a(currentPath, bitmap, 0, false);
        return;
      }
      i = -1;
    }
  }
  
  public static void aW(Activity paramActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToFriendCircle");
    }
    if ((currentPath == null) || (bitmap == null))
    {
      QLog.e("ShareImageUtils", 1, "currentPath or bitmap is null");
      return;
    }
    int i;
    if (!WXShareHelper.a().isWXinstalled()) {
      i = 2131721935;
    }
    for (;;)
    {
      if (i != -1)
      {
        QQToast.a(BaseApplicationImpl.getContext(), BaseApplicationImpl.getContext().getString(i), 0).show(BaseApplicationImpl.getContext().getResources().getDimensionPixelSize(2131299627));
        return;
        if (!WXShareHelper.a().isWXsupportApi()) {
          i = 2131721936;
        }
      }
      else
      {
        WxShareHelperFromReadInjoy.a().a(currentPath, bitmap, 1, false);
        return;
      }
      i = -1;
    }
  }
  
  public static void b(BaseActivity paramBaseActivity)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ShareImageUtils", 2, "shareToQzone");
    }
    if (currentPath == null)
    {
      QLog.e("ShareImageUtils", 1, "currentPath is null");
      return;
    }
    paramBaseActivity = (QQAppInterface)paramBaseActivity.getAppRuntime();
    Bundle localBundle = new Bundle();
    ArrayList localArrayList = new ArrayList();
    localArrayList.add(currentPath);
    localBundle.putStringArrayList("images", localArrayList);
    avqq.a(paramBaseActivity, BaseApplicationImpl.getContext(), localBundle, null, 2);
  }
  
  public static void bdN()
  {
    WXShareHelper.a().a(b);
  }
  
  private static void bdO()
  {
    String str = acbn.SDCARD_ROOT + "/Tencent/Tim_Images/" + Calendar.getInstance().getTime() + ".png";
    if (aqhq.c(bitmap, str))
    {
      QLog.d("ShareImageUtils", 1, "save to sdcard success");
      aqhu.cn(BaseApplicationImpl.getContext(), str);
      str = BaseApplicationImpl.getContext().getString(2131696988) + " " + str;
      ThreadManager.getUIHandler().post(new ShareImageUtils.3(str));
      return;
    }
    QLog.d("ShareImageUtils", 1, "save to sdcard fail");
    ThreadManager.getUIHandler().post(new ShareImageUtils.4());
  }
  
  public static void co(Context paramContext)
  {
    if (bitmap == null)
    {
      QLog.e("ShareImageUtils", 1, "bitmap is null");
      return;
    }
    ThreadManager.getFileThreadHandler().post(new ShareImageUtils.2(paramContext));
  }
  
  public static void destroy()
  {
    currentPath = null;
    bitmap = null;
    WXShareHelper.a().b(b);
  }
  
  public static void setBitmap(Bitmap paramBitmap)
  {
    bitmap = paramBitmap;
  }
  
  public static void setCurrentPath(String paramString)
  {
    currentPath = paramString;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     oeg
 * JD-Core Version:    0.7.0.1
 */