package com.tencent.mobileqq.activity.photo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.graphics.BitmapFactory.Options;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.statistics.StatisticCollector;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.qqfav.QfavHelper;
import cooperation.qzone.QZoneHelper;
import cooperation.troop.TroopProxyActivity;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Iterator;

public class PhotoUtils
{
  public static final int a = 1048576;
  private static final String a = "PhotoUtils";
  private static final String b = "PHOTO_KEY_FRIEND_UIN";
  
  public static String a(Context paramContext, float paramFloat)
  {
    paramFloat /= 1048576.0F;
    paramContext = new DecimalFormat("0.0");
    if (paramFloat > 1.0F) {
      return paramContext.format(paramFloat) + "M";
    }
    return paramContext.format(paramFloat * 1024.0F) + "K";
  }
  
  public static String a(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    if (paramArrayList.hasNext())
    {
      File localFile = new File((String)paramArrayList.next());
      if (localFile.length() > 204800) {}
      for (l += 204800;; l = (l + localFile.length() * 0.8D)) {
        break;
      }
    }
    float f = (float)l * 1.0F / 1048576.0F;
    paramArrayList = new DecimalFormat("#.0");
    if (f > 1.0F) {
      return "约" + paramArrayList.format(f) + "M";
    }
    return "约" + paramArrayList.format(f * 1024.0F) + "K";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, ((BaseActivity)paramActivity).app.a());
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      if (paramInt1 != 7001) {
        break label127;
      }
      Intent localIntent = paramActivity.getIntent();
      String str1 = localIntent.getStringExtra("key_album_id");
      String str2 = localIntent.getStringExtra("key_album_name");
      QZoneHelper.a(paramString, localIntent.getStringExtra("uin"), str1, str2);
      localIntent.putExtras(paramIntent);
      paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      localIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramIntent);
      if (!paramBoolean)
      {
        localIntent.addFlags(603979776);
        paramActivity.startActivity(localIntent);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      AlbumUtil.a(paramActivity, false, false);
      return;
      label127:
      paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
      if (!paramBoolean)
      {
        paramIntent.addFlags(603979776);
        paramActivity.startActivity(paramIntent);
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList paramArrayList, int paramInt, boolean paramBoolean)
  {
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    String str1 = str3;
    if (str3 == null)
    {
      str3 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = str3;
      if (str3 == null) {
        QQToast.a(paramActivity, "请设置INIT_ACTIVITY_CLASS_NAME ", 0).a();
      }
    }
    for (;;)
    {
      return;
      paramIntent.setClassName(str2, str1);
      str2 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
      if (str2 != null) {
        paramIntent.putExtra("uin", str2);
      }
      paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
      if (paramArrayList.size() == 1) {
        paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
      }
      paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "currActivity is:" + paramActivity.getClass().getName());
      }
      if (QLog.isColorLevel()) {
        QLog.d("SelectPhotoTrace", 2, "destination activity is:" + str1 + ",intent extra is:" + paramIntent.getExtras());
      }
      paramIntent.addFlags(603979776);
      if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false)) {
        if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
        {
          paramIntent.putExtra("cleartop", true);
          TroopProxyActivity.a(paramActivity, paramIntent, 2);
        }
      }
      while (!paramBoolean)
      {
        paramActivity.finish();
        AlbumUtil.a(paramActivity, false, false);
        return;
        paramActivity.startActivityForResult(paramIntent, 2);
        continue;
        paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
        paramArrayList = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
        str1 = paramIntent.getStringExtra("PhotoConst.UIN");
        if ("qqfav.apk".equals(paramArrayList)) {
          QfavHelper.a(paramActivity, str1, paramIntent, 2);
        }
      }
    }
  }
  
  static void a(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    paramIntent.setClass(paramActivity, PhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    if (100 == paramIntent.getIntExtra("Business_Origin", 0))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", 0);
    }
    for (;;)
    {
      paramIntent.removeExtra("Business_Origin");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
      paramActivity.startActivity(paramIntent);
      AlbumUtil.a(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString, int paramInt, boolean paramBoolean)
  {
    paramIntent.setClass(paramActivity, PhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", paramInt);
    if (paramInt == 1) {
      paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    }
    paramIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", paramBoolean);
    paramIntent.putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
    paramIntent.putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    paramIntent.setClass(paramActivity, PhotoPreviewActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", paramString2);
    paramIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", "com.tencent.qqlite");
    paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString3);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_DERECTBACK_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramActivity.startActivity(paramIntent);
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt, ArrayList paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      String str;
      Iterator localIterator;
      switch (paramInt)
      {
      case 1: 
      default: 
        str = "Send_compress";
        localIterator = paramArrayList.iterator();
        paramInt = 0;
      }
      for (;;)
      {
        if (!localIterator.hasNext()) {
          break label135;
        }
        Object localObject = (String)localIterator.next();
        if (localObject == null)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:path == null");
          continue;
          str = "Send_compress";
          break;
          str = "Send_raw";
          break;
        }
        localObject = new File((String)localObject);
        paramInt = (int)(paramInt + ((File)localObject).length());
      }
      label135:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:" + str + ",count:" + paramArrayList.size() + ",totalSize:" + paramInt);
      }
      a(paramQQAppInterface, str, paramArrayList.size(), paramInt);
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    StatisticCollector.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.a(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  static boolean a(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    BitmapFactory.decodeFile(paramString, localOptions);
    int i = localOptions.outHeight;
    int j = localOptions.outWidth;
    if (QLog.isColorLevel()) {
      QLog.d("_photo", 2, "isLargeFile w:" + j + ",h:" + i);
    }
    boolean bool1 = bool2;
    if (i != -1)
    {
      bool1 = bool2;
      if (j != -1) {
        if (i <= j * 3)
        {
          bool1 = bool2;
          if (j <= i * 3) {}
        }
        else
        {
          bool1 = true;
        }
      }
    }
    return bool1;
  }
  
  public static String b(ArrayList paramArrayList)
  {
    paramArrayList = paramArrayList.iterator();
    long l = 0L;
    if (paramArrayList.hasNext())
    {
      File localFile = new File((String)paramArrayList.next());
      if (localFile.length() > 102400) {
        if (localFile.length() > 204800L) {
          l += 102400;
        }
      }
      for (;;)
      {
        break;
        l = (l + localFile.length() * 0.5D);
        continue;
        l = (l + localFile.length() * 0.5D);
      }
    }
    float f = (float)l * 1.0F / 1048576.0F;
    paramArrayList = new DecimalFormat("#.0");
    if (f > 1.0F) {
      return "约" + paramArrayList.format(f) + "M";
    }
    return "约" + paramArrayList.format(f * 1024.0F) + "K";
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */