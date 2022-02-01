package com.tencent.mobileqq.activity.photo;

import acfp;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory.Options;
import android.graphics.Canvas;
import android.os.Build.VERSION;
import android.text.TextUtils;
import anot;
import anpc;
import aqft;
import aqfy;
import aqhu;
import avfw;
import avfw.d;
import avja;
import avpw;
import com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyUploadAvatarFragment;
import com.tencent.component.media.image.ImageManager;
import com.tencent.mobileqq.activity.PublicFragmentActivity.b;
import com.tencent.mobileqq.activity.PublicTransFragmentActivity;
import com.tencent.mobileqq.activity.aio.SessionInfo;
import com.tencent.mobileqq.activity.photo.album.NewPhotoListActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cooperation.comic.VipComicProxyActivity;
import cooperation.qzone.QzonePluginProxyActivity;
import cooperation.smartdevice.SmartDevicePluginProxyActivity;
import cooperation.troop.TroopFileProxyActivity;
import java.io.File;
import java.io.Serializable;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.ArrayList<Ljava.lang.String;>;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import mqq.os.MqqHandler;
import rop;
import zsz;
import zti;

public class PhotoUtils
{
  public static SimpleDateFormat sDateFormatForHour = new SimpleDateFormat("yyyy年MM月dd HH点");
  public static SimpleDateFormat sDateFormatForMinute = new SimpleDateFormat("yyyy年MM月dd HH点mm分");
  
  public static Bitmap a(Bitmap paramBitmap1, Bitmap paramBitmap2, int paramInt)
  {
    new Canvas(paramBitmap1).drawBitmap(paramBitmap2, 0.0F, paramInt, null);
    return paramBitmap1;
  }
  
  public static String a(Context paramContext, float paramFloat)
  {
    paramFloat /= 1024000;
    if (paramFloat >= 10.0F)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 1.0F)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat) + "M";
    }
    if (paramFloat >= 0.001D)
    {
      paramContext = new DecimalFormat("0");
      return paramContext.format(paramFloat * 1024.0F) + "K";
    }
    if (paramFloat >= 0.0001D)
    {
      paramContext = new DecimalFormat("0.0");
      return paramContext.format(paramFloat * 1024.0F) + "K";
    }
    return "0.1K";
  }
  
  public static void a(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean, String paramString)
  {
    if (paramIntent != null) {
      paramIntent.removeExtra("PhotoConst.VIDEO_INFOS");
    }
    Intent localIntent;
    if (((paramInt1 == 2) || (paramInt1 == 7001)) && (paramInt2 == -1))
    {
      localIntent = paramIntent;
      if (paramIntent == null)
      {
        if (QLog.isColorLevel()) {
          QLog.e("PhotoUtils", 2, "[onSendResult] data = null");
        }
        localIntent = new Intent();
      }
      localIntent.putExtra("PhotoConst.send_photo_activity_result", -1);
      if (paramInt1 != 7001) {
        break label171;
      }
      paramIntent = paramActivity.getIntent();
      String str1 = paramIntent.getStringExtra("UploadPhoto.key_album_id");
      String str2 = paramIntent.getStringExtra("UploadPhoto.key_album_name");
      avpw.Z(paramString, paramIntent.getStringExtra("uin"), str1, str2);
      paramIntent.putExtras(localIntent);
      paramString = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramIntent.setClassName(paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramString);
      if (!paramBoolean)
      {
        paramIntent.addFlags(603979776);
        paramActivity.startActivity(paramIntent);
      }
    }
    for (;;)
    {
      paramActivity.finish();
      aqfy.anim(paramActivity, false, false);
      return;
      label171:
      paramIntent = paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      paramActivity.getIntent().getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      localIntent.setClassName(paramActivity, paramIntent);
      if (!paramBoolean)
      {
        localIntent.addFlags(603979776);
        zsz.cJ(localIntent);
        paramActivity.startActivity(localIntent);
      }
      else
      {
        QLog.e("PhotoUtils", 1, "Watermark has been deleted!");
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt, boolean paramBoolean)
  {
    String str1 = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
    if (str1 != null) {
      paramIntent.putExtra("uin", str1);
    }
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    String str3 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    str1 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    String str2;
    if (!TextUtils.isEmpty(str1))
    {
      str2 = str3;
      if (!TextUtils.isEmpty(str3)) {}
    }
    else
    {
      str2 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { str2, str1 }));
    }
    if ((TextUtils.isEmpty(str2)) || (TextUtils.isEmpty(str1)))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
      }
      if (TextUtils.isEmpty(paramArrayList)) {
        QQToast.a(paramActivity, acfp.m(2131709626), 0).show();
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setComponent(null);
      paramIntent.setAction(paramArrayList);
      paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
      try
      {
        paramActivity.sendBroadcast(paramIntent);
        paramActivity.finish();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.d("PhotoUtils", 1, "sendPhoto fail!", paramActivity);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName(paramActivity, str1);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + bool1 + "className=" + str1);
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + bool2);
      }
      boolean bool3 = paramIntent.getBooleanExtra("ReceiptMsgManager.EXTRA_KEY_IS_RECEIPT", false);
      if (bool2)
      {
        a(paramActivity, paramIntent, paramArrayList, paramInt);
        paramActivity.finish();
        bool1 = paramBoolean;
      }
      while (!bool1)
      {
        paramActivity.finish();
        aqfy.anim(paramActivity, false, false);
        return;
        if (bool3)
        {
          a(paramActivity, paramIntent, paramArrayList, paramInt);
          paramActivity.finish();
          bool1 = paramBoolean;
        }
        else if (!bool1)
        {
          if (str1.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity"))
          {
            paramIntent.putExtra("cleartop", true);
            TroopFileProxyActivity.b(paramActivity, paramIntent, 2, null);
            bool1 = paramBoolean;
          }
          else if (str1.equals(ReadInJoyUploadAvatarFragment.class.getName()))
          {
            bool1 = paramIntent.getBooleanExtra("PhotoConst.HANDLE_DEST_RESULT", false);
            paramIntent.putExtra("keyAction", "actionSelectPicture");
            paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
            PublicFragmentActivity.b.startForResult(paramActivity, paramIntent, PublicTransFragmentActivity.class, ReadInJoyUploadAvatarFragment.class, 2);
          }
          else
          {
            paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
            if (paramIntent.getBooleanExtra("sIsCloudPrinter", false))
            {
              paramActivity.startActivityForResult(paramIntent, 102);
              bool1 = paramBoolean;
            }
            else
            {
              paramActivity.startActivityForResult(paramIntent, 2);
              bool1 = paramBoolean;
            }
          }
        }
        else
        {
          str2 = paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
          str3 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
          String str4 = paramIntent.getStringExtra("PhotoConst.UIN");
          if ("qzone_plugin.apk".equals(str3))
          {
            if (str1.equals("com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity"))
            {
              m(paramActivity, (String)paramArrayList.get(0), paramIntent.getIntExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", 0));
              bool1 = paramBoolean;
            }
            else
            {
              QzonePluginProxyActivity.x(paramIntent, str1);
              paramIntent.putExtra("cleartop", true);
              paramIntent.putExtra("PhotoConst.IS_FROM_PHOTO_LIST", true);
              avpw.a(paramActivity, str4, paramIntent, -1);
              bool1 = false;
            }
          }
          else if ("qqfav.apk".equals(str3))
          {
            avja.a(paramActivity, str4, paramIntent, 2);
            bool1 = paramBoolean;
          }
          else if ("qqsmartdevice.apk".equals(str3))
          {
            paramIntent.putExtra("cleartop", true);
            paramArrayList = new avfw.d(0);
            paramArrayList.mPluginID = str3;
            paramArrayList.mPluginName = str2;
            paramArrayList.mUin = str4;
            paramArrayList.cKu = str1;
            paramArrayList.K = SmartDevicePluginProxyActivity.class;
            paramArrayList.mIntent = paramIntent;
            paramArrayList.mRequestCode = 2;
            avfw.a(paramActivity, paramArrayList);
            bool1 = paramBoolean;
          }
          else
          {
            bool1 = paramBoolean;
            if ("comic_plugin.apk".equals(str3))
            {
              paramIntent.putExtra("cleartop", true);
              paramArrayList = new avfw.d(0);
              paramArrayList.mPluginID = str3;
              paramArrayList.mPluginName = str2;
              paramArrayList.mUin = str4;
              paramArrayList.cKu = str1;
              paramArrayList.K = VipComicProxyActivity.e(str1);
              paramArrayList.mIntent = paramIntent;
              paramArrayList.mRequestCode = 2;
              avfw.a(paramActivity, paramArrayList);
              bool1 = paramBoolean;
            }
          }
        }
      }
    }
  }
  
  public static void a(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList, HashMap<String, PhotoSendParams> paramHashMap, int paramInt, boolean paramBoolean)
  {
    paramIntent.setExtrasClassLoader(PhotoSendParams.class.getClassLoader());
    Object localObject = paramIntent.getStringExtra("PHOTO_KEY_FRIEND_UIN");
    if (localObject != null) {
      paramIntent.putExtra("uin", (String)localObject);
    }
    localObject = new HashMap();
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    if (i < paramArrayList.size())
    {
      PhotoSendParams localPhotoSendParams = (PhotoSendParams)paramHashMap.get(paramArrayList.get(i));
      if (localPhotoSendParams != null)
      {
        ((HashMap)localObject).put(localPhotoSendParams.thumbPath, localPhotoSendParams);
        if (QLog.isColorLevel()) {
          QLog.d("aioSendPhotos", 2, new Object[] { "[Qzone] thumbPath:", localPhotoSendParams.thumbPath, " photoSendParams:", localPhotoSendParams.toString() });
        }
      }
      for (;;)
      {
        i += 1;
        break;
        if (!ImageManager.isNetworkUrl((String)paramArrayList.get(i)))
        {
          localArrayList.add(paramArrayList.get(i));
          if (QLog.isColorLevel()) {
            QLog.d("aioSendPhotos", 2, new Object[] { "[QQ] local path:", paramArrayList.get(i) });
          }
        }
        else
        {
          QLog.w("aioSendPhotos", 2, "[Error] path:" + (String)paramArrayList.get(i));
        }
      }
    }
    paramIntent.putExtra("PhotoConst.photo_send_pic_type", (Serializable)localObject);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", localArrayList);
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localObject = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME");
    paramHashMap = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
    if (!TextUtils.isEmpty(paramHashMap))
    {
      paramArrayList = (ArrayList<String>)localObject;
      if (!TextUtils.isEmpty((CharSequence)localObject)) {}
    }
    else
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
      paramHashMap = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    }
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, String.format("sendPhoto packageName=%s className=%s", new Object[] { paramArrayList, paramHashMap }));
    }
    if ((TextUtils.isEmpty(paramArrayList)) || (TextUtils.isEmpty(paramHashMap)))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.DEST_BROADCAST_ACTION_NAME");
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto action=%s", new Object[] { paramArrayList }));
      }
      if (TextUtils.isEmpty(paramArrayList)) {
        QQToast.a(paramActivity, acfp.m(2131709627), 0).show();
      }
    }
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setComponent(null);
      paramIntent.setAction(paramArrayList);
      paramIntent.setFlags(paramIntent.getFlags() & 0xDFFFFFFF & 0xFBFFFFFF);
      try
      {
        paramActivity.sendBroadcast(paramIntent);
        paramActivity.finish();
        return;
      }
      catch (Exception paramActivity)
      {
        QLog.d("PhotoUtils", 1, "sendPhoto fail!", paramActivity);
        return;
      }
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, String.format("sendPhoto extras=%s", new Object[] { paramIntent.getExtras() }));
      }
      paramIntent.setClassName(paramArrayList, paramHashMap);
      paramIntent.addFlags(603979776);
      boolean bool1 = paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false);
      if (QLog.isColorLevel()) {
        QLog.d("forward", 2, "sendPhoto isCallFromPlugin=" + bool1 + "className=" + paramHashMap);
      }
      boolean bool2 = paramIntent.getBooleanExtra("PhotoConst.is_troop_send_mixed_msg", false);
      if (QLog.isColorLevel()) {
        QLog.d("zivonchen", 2, "sendPhoto isTroopSendMixedMsg = " + bool2);
      }
      if (!bool1)
      {
        if (!paramHashMap.equals("com.tencent.mobileqq.troop.activity.TroopFileBroswerActivity")) {
          break label686;
        }
        paramIntent.putExtra("cleartop", true);
        TroopFileProxyActivity.b(paramActivity, paramIntent, 2, null);
      }
      while (!paramBoolean)
      {
        paramActivity.finish();
        aqfy.anim(paramActivity, false, false);
        return;
        label686:
        paramIntent.putExtra("PhotoConst.QZONE_ALBUM_FROM_AIO", true);
        paramIntent.putExtra("param_compressInitTime", System.currentTimeMillis());
        if (paramIntent.getBooleanExtra("sIsCloudPrinter", false)) {
          paramActivity.startActivityForResult(paramIntent, 102);
        } else {
          paramActivity.startActivityForResult(paramIntent, 2);
        }
      }
    }
  }
  
  public static final void a(Context paramContext, Intent paramIntent, ArrayList<String> paramArrayList, int paramInt)
  {
    Intent localIntent = paramIntent;
    if (paramIntent == null) {
      localIntent = new Intent();
    }
    paramIntent = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME");
    String str = localIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
    localIntent.setClassName(paramIntent, str);
    localIntent.putExtra("open_chatfragment_fromphoto", true);
    localIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    localIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", paramInt);
    localIntent.putExtra("PhotoConst.SEND_FLAG", true);
    localIntent.addFlags(603979776);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "sendPhotoFromAio activity = " + str + ", packageName = " + paramIntent + ", data = " + localIntent.getExtras());
    }
    localIntent.putExtra("open_chatfragment_fromphoto", true);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2)
  {
    a(paramIntent, paramActivity, paramString1, paramInt1, paramInt2, paramInt3, paramInt4, paramString2, -1);
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, int paramInt5)
  {
    paramIntent.setClass(paramActivity, NewPhotoListActivity.class);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
    paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
    paramIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 1);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_MODE", true);
    paramIntent.putExtra("PhotoConst.IS_SINGLE_NEED_EDIT", true);
    paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString2);
    paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
    paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
    paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
    paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
    paramIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    paramIntent.putExtra("PhotoConst.32_Bit_Config", true);
    if (paramInt5 > -1)
    {
      paramIntent.putExtra("keyAction", "actionSelectPicture");
      paramActivity.startActivityForResult(paramIntent, paramInt5);
    }
    for (;;)
    {
      aqfy.anim(paramActivity, false, true);
      return;
      paramActivity.startActivity(paramIntent);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 == i) || (102 == i) || (103 == i))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", zti.fF(i));
    }
    for (;;)
    {
      paramIntent.removeExtra("Business_Origin");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
      paramActivity.startActivity(paramIntent);
      aqfy.anim(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent, Activity paramActivity, String paramString1, int paramInt1, int paramInt2, int paramInt3, int paramInt4, String paramString2, String paramString3, int paramInt5)
  {
    int i = paramIntent.getIntExtra("Business_Origin", 0);
    if ((100 == i) || (102 == i) || (103 == i))
    {
      paramIntent.setClass(paramActivity, PhotoCropForPortraitActivity.class);
      paramIntent.putExtra("PhotoConst.EDIT_MASK_SHAPE_TYPE", zti.fF(i));
    }
    for (;;)
    {
      paramIntent.removeExtra("Business_Origin");
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", paramString1);
      paramIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqq");
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString2);
      paramIntent.putExtra("PhotoConst.TARGET_PATH", paramString3);
      paramIntent.putExtra("PhotoConst.CLIP_WIDTH", paramInt1);
      paramIntent.putExtra("PhotoConst.CLIP_HEIGHT", paramInt2);
      paramIntent.putExtra("PhotoConst.TARGET_WIDTH", paramInt3);
      paramIntent.putExtra("PhotoConst.TARGET_HEIGHT", paramInt4);
      paramActivity.startActivityForResult(paramIntent, paramInt5);
      aqfy.anim(paramActivity, false, true);
      return;
      paramIntent.setClass(paramActivity, PhotoCropActivity.class);
    }
  }
  
  public static void a(Intent paramIntent1, Intent paramIntent2)
  {
    boolean bool = paramIntent1.getBooleanExtra("custom_photopreview_sendbtn_report", false);
    String str1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_reportActionName");
    String str2 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_album_reportReverse2");
    paramIntent1 = paramIntent1.getStringExtra("custom_photopreview_sendbtn_camera_reportReverse2");
    paramIntent2.putExtra("custom_photopreview_sendbtn_report", bool);
    paramIntent2.putExtra("custom_photopreview_sendbtn_reportActionName", str1);
    paramIntent2.putExtra("custom_photopreview_sendbtn_album_reportReverse2", str2);
    paramIntent2.putExtra("custom_photopreview_sendbtn_camera_reportReverse2", paramIntent1);
  }
  
  public static int b(SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.cZ)
    {
    default: 
      i = 5;
      return i;
    case 0: 
      return 1;
    case 1: 
      return 2;
    }
    return 3;
  }
  
  public static void backToPhoto(Intent paramIntent, Activity paramActivity)
  {
    String str = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str);
    paramIntent.addFlags(603979776);
    paramActivity.startActivity(paramIntent);
    paramActivity.finish();
  }
  
  public static int c(SessionInfo paramSessionInfo)
  {
    if (paramSessionInfo == null) {
      return -1;
    }
    if (paramSessionInfo.cZ == 3000) {
      return 2;
    }
    return b(paramSessionInfo);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, int paramInt, ArrayList<String> paramArrayList)
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
          break label140;
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
        long l = paramInt;
        paramInt = (int)(((File)localObject).length() + l);
      }
      label140:
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "reportSendSize sendReportType:" + str + ",count:" + paramArrayList.size() + ",totalSize:" + paramInt);
      }
      d(paramQQAppInterface, str, paramArrayList.size(), paramInt);
    }
  }
  
  public static String createContentDescription(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(sDateFormatForMinute.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static String createContentDescriptionWithCheckBox(int paramInt1, LocalMediaInfo paramLocalMediaInfo, int paramInt2, boolean paramBoolean)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    switch (paramInt1)
    {
    default: 
      localStringBuilder.append("照片 ");
    }
    for (;;)
    {
      localStringBuilder.append("拍摄时间: ");
      paramLocalMediaInfo = new Date(paramLocalMediaInfo.modifiedDate * 1000L);
      localStringBuilder.append(sDateFormatForHour.format(paramLocalMediaInfo));
      return localStringBuilder.toString();
      localStringBuilder.append("视频 ");
    }
  }
  
  public static int d(SessionInfo paramSessionInfo)
  {
    int i = 0;
    if (paramSessionInfo != null) {}
    switch (paramSessionInfo.cZ)
    {
    default: 
      i = -1;
      return i;
    case 0: 
      return 1;
    case 1: 
      return 2;
    case 1000: 
    case 1003: 
    case 1004: 
    case 1005: 
    case 1006: 
    case 1020: 
    case 1021: 
    case 1022: 
    case 1023: 
    case 1025: 
    case 7400: 
    case 10004: 
    case 10008: 
      return 3;
    case 3000: 
      return 4;
    }
    return 5;
  }
  
  public static void d(QQAppInterface paramQQAppInterface, String paramString, int paramInt1, int paramInt2)
  {
    anpc.a(BaseApplication.getContext()).a(paramQQAppInterface, paramQQAppInterface.getCurrentAccountUin(), "Pic_edit", paramString, 0, 1, null, String.valueOf(paramInt1), null, String.valueOf(paramInt2), null);
  }
  
  /* Error */
  public static Bitmap decodeFileWithBuffer(String paramString, BitmapFactory.Options paramOptions)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 674	java/io/FileInputStream
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 675	java/io/FileInputStream:<init>	(Ljava/lang/String;)V
    //   10: astore_2
    //   11: aload_1
    //   12: ifnull +47 -> 59
    //   15: aload_2
    //   16: astore_0
    //   17: aload_1
    //   18: getfield 680	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   21: ifeq +38 -> 59
    //   24: aload_2
    //   25: astore_0
    //   26: new 682	java/io/BufferedInputStream
    //   29: dup
    //   30: aload_2
    //   31: sipush 8192
    //   34: invokespecial 685	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   37: aconst_null
    //   38: aload_1
    //   39: invokestatic 691	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   42: astore_1
    //   43: aload_1
    //   44: astore_0
    //   45: aload_0
    //   46: astore_1
    //   47: aload_2
    //   48: ifnull +9 -> 57
    //   51: aload_2
    //   52: invokevirtual 696	java/io/InputStream:close	()V
    //   55: aload_0
    //   56: astore_1
    //   57: aload_1
    //   58: areturn
    //   59: aload_2
    //   60: astore_0
    //   61: new 682	java/io/BufferedInputStream
    //   64: dup
    //   65: aload_2
    //   66: sipush 8192
    //   69: invokespecial 685	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;I)V
    //   72: aconst_null
    //   73: aload_1
    //   74: invokestatic 691	android/graphics/BitmapFactory:decodeStream	(Ljava/io/InputStream;Landroid/graphics/Rect;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   77: astore_1
    //   78: aload_1
    //   79: astore_0
    //   80: goto -35 -> 45
    //   83: astore_1
    //   84: aconst_null
    //   85: astore_2
    //   86: aload_2
    //   87: astore_0
    //   88: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   91: ifeq +15 -> 106
    //   94: aload_2
    //   95: astore_0
    //   96: ldc 91
    //   98: iconst_2
    //   99: ldc_w 698
    //   102: aload_1
    //   103: invokestatic 700	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   106: aload_3
    //   107: astore_1
    //   108: aload_2
    //   109: ifnull -52 -> 57
    //   112: aload_2
    //   113: invokevirtual 696	java/io/InputStream:close	()V
    //   116: aconst_null
    //   117: areturn
    //   118: astore_0
    //   119: aconst_null
    //   120: areturn
    //   121: astore_1
    //   122: aconst_null
    //   123: astore_2
    //   124: aload_2
    //   125: astore_0
    //   126: invokestatic 89	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   129: ifeq +15 -> 144
    //   132: aload_2
    //   133: astore_0
    //   134: ldc 91
    //   136: iconst_2
    //   137: ldc_w 698
    //   140: aload_1
    //   141: invokestatic 700	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   144: aload_3
    //   145: astore_1
    //   146: aload_2
    //   147: ifnull -90 -> 57
    //   150: aload_2
    //   151: invokevirtual 696	java/io/InputStream:close	()V
    //   154: aconst_null
    //   155: areturn
    //   156: astore_0
    //   157: aconst_null
    //   158: areturn
    //   159: astore_1
    //   160: aconst_null
    //   161: astore_0
    //   162: aload_0
    //   163: ifnull +7 -> 170
    //   166: aload_0
    //   167: invokevirtual 696	java/io/InputStream:close	()V
    //   170: aload_1
    //   171: athrow
    //   172: astore_1
    //   173: aload_0
    //   174: areturn
    //   175: astore_0
    //   176: goto -6 -> 170
    //   179: astore_1
    //   180: goto -18 -> 162
    //   183: astore_1
    //   184: goto -60 -> 124
    //   187: astore_1
    //   188: goto -102 -> 86
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	191	0	paramString	String
    //   0	191	1	paramOptions	BitmapFactory.Options
    //   10	141	2	localFileInputStream	java.io.FileInputStream
    //   1	144	3	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   2	11	83	java/lang/OutOfMemoryError
    //   112	116	118	java/io/IOException
    //   2	11	121	java/lang/Exception
    //   150	154	156	java/io/IOException
    //   2	11	159	finally
    //   51	55	172	java/io/IOException
    //   166	170	175	java/io/IOException
    //   17	24	179	finally
    //   26	43	179	finally
    //   61	78	179	finally
    //   88	94	179	finally
    //   96	106	179	finally
    //   126	132	179	finally
    //   134	144	179	finally
    //   17	24	183	java/lang/Exception
    //   26	43	183	java/lang/Exception
    //   61	78	183	java/lang/Exception
    //   17	24	187	java/lang/OutOfMemoryError
    //   26	43	187	java/lang/OutOfMemoryError
    //   61	78	187	java/lang/OutOfMemoryError
  }
  
  public static long eG()
  {
    return System.currentTimeMillis();
  }
  
  public static String hS(String paramString)
  {
    if (TextUtils.isEmpty(paramString)) {}
    while (!new File(paramString).exists()) {
      return null;
    }
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    decodeFileWithBuffer(paramString, localOptions);
    return localOptions.outMimeType;
  }
  
  public static boolean ip(String paramString)
  {
    boolean bool2 = false;
    BitmapFactory.Options localOptions = new BitmapFactory.Options();
    localOptions.inJustDecodeBounds = true;
    try
    {
      aqhu.d(paramString, localOptions);
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
    catch (Exception paramString)
    {
      for (;;)
      {
        QLog.e("_photo", 1, paramString, new Object[0]);
      }
    }
    catch (OutOfMemoryError paramString)
    {
      for (;;)
      {
        QLog.e("_photo", 1, paramString, new Object[0]);
      }
    }
  }
  
  public static boolean isJPEGImage(String paramString)
  {
    paramString = hS(paramString);
    if (TextUtils.isEmpty(paramString)) {
      return false;
    }
    return paramString.contains("image/jpeg");
  }
  
  static void m(Context paramContext, String paramString, int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.setAction("action.com.qzone.cover.ui.activity.QZoneCoverSetCustomActivity.cover_img_crop_end");
    localIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", paramString);
    localIntent.putExtra("PhotoConst.QZONE_COVER_SYNC_FLAG", paramInt);
    paramContext.sendBroadcast(localIntent);
  }
  
  public static void onSendResult(Activity paramActivity, int paramInt1, int paramInt2, Intent paramIntent, boolean paramBoolean)
  {
    if ((paramActivity != null) && (((BaseActivity)paramActivity).app != null)) {
      a(paramActivity, paramInt1, paramInt2, paramIntent, paramBoolean, ((BaseActivity)paramActivity).app.getCurrentAccountUin());
    }
  }
  
  public static void sendPhotoForPhotoPlus(Activity paramActivity, Intent paramIntent, ArrayList<String> paramArrayList)
  {
    String str1 = paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_CLASS_NAME");
    paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.PHOTO_SELECT_ACTIVITY_PACKAGE_NAME"), str1);
    paramIntent.putStringArrayListExtra("PhotoConst.PHOTO_PATHS", paramArrayList);
    if (paramArrayList.size() == 1) {
      paramIntent.putExtra("PhotoConst.SINGLE_PHOTO_PATH", (String)paramArrayList.get(0));
    }
    paramIntent.putExtra("PhotoConst.SEND_SIZE_SPEC", 0);
    paramIntent.putExtra("PhotoConst.SEND_FLAG", true);
    if (QLog.isColorLevel()) {
      QLog.d("PhotoUtils", 2, "sendPhotoForPhotoPlus , activity = " + paramActivity + ",data = " + paramIntent.getExtras());
    }
    paramIntent.addFlags(603979776);
    if ((Build.VERSION.SDK_INT >= 21) && (str1.contains("ForwardRecentActivity")))
    {
      int i = paramIntent.getFlags();
      if ((0x80000 & i) > 0) {
        paramIntent.setFlags(i & 0xFFF7FFFF);
      }
    }
    String str2;
    if (!paramIntent.getBooleanExtra("PhotoConst.IS_CALL_IN_PLUGIN", false))
    {
      paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");
      str2 = paramIntent.getStringExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME");
      if (("com.tencent.mobileqq.activity.SplashActivity".equals(paramArrayList)) && ("com.tencent.mobileqq.activity.photo.PhotoPreviewActivity".equals(str1)) && ("com.tencent.mobileqq.activity.photo.SendPhotoActivity".equals(str2)))
      {
        paramIntent.setClassName(paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME"), paramArrayList);
        paramIntent.putExtra("open_chatfragment_fromphoto", true);
        paramActivity.startActivity(paramIntent);
      }
    }
    while (!"qzone_plugin.apk".equals(paramIntent.getStringExtra("PhotoConst.PLUGIN_APK"))) {
      for (;;)
      {
        if (aqft.rj(paramIntent.getStringExtra("uin"))) {
          anot.a(null, "dc00898", "", "", "0X8007249", "0X8007249", 0, 0, "", "", "", "");
        }
        paramActivity.finish();
        return;
        if ("com.tencent.mobileqq.activity.aio.photo.AIOGalleryActivity".equals(str1)) {
          paramIntent.setClassName("com.tencent.mobileqq", "com.tencent.mobileqq.activity.SplashActivity");
        }
      }
    }
    if ((!str1.contains("QZone")) && (paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME") != null)) {}
    for (paramArrayList = paramIntent.getStringExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME");; paramArrayList = str1)
    {
      paramIntent.getStringExtra("PhotoConst.PLUGIN_NAME");
      str1 = paramIntent.getStringExtra("PhotoConst.PLUGIN_APK");
      str2 = paramIntent.getStringExtra("PhotoConst.UIN");
      if (!"qzone_plugin.apk".equals(str1)) {
        break;
      }
      QzonePluginProxyActivity.x(paramIntent, paramArrayList);
      paramIntent.putExtra("cleartop", true);
      avpw.a(paramActivity, str2, paramIntent, -1);
      break;
    }
  }
  
  public static String v(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString2;
    if (paramString2 == null) {
      str = "";
    }
    paramString2 = paramString3;
    if (paramString3 == null) {
      paramString2 = "";
    }
    Calendar localCalendar = Calendar.getInstance();
    paramString3 = new StringBuilder(paramString1);
    paramString3.append(str);
    paramString3.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      paramString1 = "0" + i;
      paramString3.append(paramString1);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label318;
      }
      paramString1 = "0" + i;
      label128:
      paramString3.append(paramString1);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label326;
      }
      paramString1 = "0" + i;
      label168:
      paramString3.append(paramString1);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label334;
      }
      paramString1 = "0" + i;
      label208:
      paramString3.append(paramString1);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label342;
      }
    }
    label318:
    label326:
    label334:
    label342:
    for (paramString1 = "0" + i;; paramString1 = Integer.valueOf(i))
    {
      paramString3.append(paramString1);
      if (new File(paramString3.toString() + paramString2).exists()) {
        break label350;
      }
      return paramString3.toString() + paramString2;
      paramString1 = Integer.valueOf(i);
      break;
      paramString1 = Integer.valueOf(i);
      break label128;
      paramString1 = Integer.valueOf(i);
      break label168;
      paramString1 = Integer.valueOf(i);
      break label208;
    }
    label350:
    paramString1 = new StringBuilder(paramString3);
    int j = paramString3.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        paramString1.append('(');
        paramString1.append(i);
        paramString1.append(')');
        paramString1.append(paramString2);
        if (new File(paramString1.toString()).exists()) {}
      }
      else
      {
        return paramString1.toString();
      }
      paramString1.delete(j, paramString1.length());
      i += 1;
    }
  }
  
  public static class WatermarkPicTask
    implements Runnable
  {
    private final MqqHandler b;
    private final String mDstPath;
    private final String mSrcPath;
    
    private void Fu(int paramInt)
    {
      if (this.b != null) {
        this.b.sendEmptyMessage(paramInt);
      }
    }
    
    public void run()
    {
      Object localObject3 = null;
      localObject2 = null;
      boolean bool = false;
      Bitmap localBitmap2;
      try
      {
        localBitmap2 = aqhu.d(this.mSrcPath, null);
        if (localBitmap2 == null)
        {
          if (QLog.isColorLevel()) {
            QLog.d("PhotoUtils", 2, "decode src is null.");
          }
          Fu(1001);
          return;
        }
      }
      catch (OutOfMemoryError localOutOfMemoryError1)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoUtils", 2, "decode src cause oom.");
        }
        Fu(1001);
        return;
      }
      int n = localBitmap2.getWidth();
      int m = localBitmap2.getHeight();
      int k = aqhu.getRotation(this.mSrcPath);
      if (QLog.isColorLevel()) {
        QLog.d("PhotoUtils", 2, "watermark pic task, w=" + n + ", h=" + m + ", r=" + k);
      }
      Object localObject4 = aqhu.g(BaseApplication.getContext().getResources(), 2130846913);
      if (n != 576)
      {
        float f = n / 576.0F;
        localObject1 = Bitmap.createScaledBitmap((Bitmap)localObject4, (int)(((Bitmap)localObject4).getWidth() * f), (int)(f * ((Bitmap)localObject4).getHeight()), true);
        ((Bitmap)localObject4).recycle();
        localObject4 = localObject1;
      }
      while (localObject4 == null)
      {
        if (QLog.isColorLevel()) {
          QLog.d("PhotoUtils", 2, "can not load watermark icon.");
        }
        localBitmap2.recycle();
        Fu(1001);
        return;
      }
      for (;;)
      {
        try
        {
          localBitmap1 = Bitmap.createBitmap(n, m, Bitmap.Config.ARGB_8888);
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          Canvas localCanvas = new Canvas(localBitmap1);
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.drawBitmap(localBitmap2, 0.0F, 0.0F, null);
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          if ((k / 90 + 1) % 2 != 0) {
            continue;
          }
          i = 1;
          if (i == 0) {
            continue;
          }
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          j = n - 20 - ((Bitmap)localObject4).getHeight();
          if (i != 0)
          {
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            localCanvas.save();
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            n /= 2;
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            m /= 2;
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            localCanvas.rotate(360 - k, n, m);
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            localCanvas.translate(n - m, m - n);
          }
          localObject2 = localBitmap1;
          localObject3 = localBitmap1;
          localCanvas.drawBitmap((Bitmap)localObject4, 20.0F, j, null);
          localObject1 = localBitmap1;
          if (i != 0)
          {
            localObject2 = localBitmap1;
            localObject3 = localBitmap1;
            localCanvas.restore();
            localObject1 = localBitmap1;
          }
        }
        catch (OutOfMemoryError localOutOfMemoryError2)
        {
          Bitmap localBitmap1;
          int j;
          localObject1 = localObject2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("PhotoUtils", 2, localOutOfMemoryError2, new Object[0]);
          localObject1 = localObject2;
          continue;
        }
        catch (Exception localException)
        {
          localObject1 = localOutOfMemoryError2;
          if (!QLog.isColorLevel()) {
            continue;
          }
          QLog.e("PhotoUtils", 2, localException, new Object[0]);
          localObject1 = localOutOfMemoryError2;
          continue;
          int i = 1001;
          continue;
        }
        if (localObject1 != null)
        {
          bool = rop.d((Bitmap)localObject1, this.mDstPath);
          ((Bitmap)localObject1).recycle();
        }
        localBitmap2.recycle();
        ((Bitmap)localObject4).recycle();
        if (QLog.isColorLevel()) {
          QLog.d("PhotoUtils", 2, "add watermark, result=" + bool);
        }
        if (!bool) {
          continue;
        }
        i = 1000;
        Fu(i);
        return;
        i = 0;
        continue;
        localObject2 = localBitmap1;
        localObject3 = localBitmap1;
        j = ((Bitmap)localObject4).getHeight();
        j = m - 20 - j;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.PhotoUtils
 * JD-Core Version:    0.7.0.1
 */