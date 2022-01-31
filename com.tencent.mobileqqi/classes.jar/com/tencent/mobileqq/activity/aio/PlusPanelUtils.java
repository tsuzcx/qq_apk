package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcelable;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.ChatActivityUtils;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.QQMapActivityProxy;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.filemanager.activity.FMLocalFileActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.model.PhoneContactManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import cooperation.plugin.IPluginManager;
import cooperation.plugin.IPluginManager.PluginParams;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import cooperation.zebra.ZebraPluginProxyActivity;
import cooperation.zebra.ZebraPluginSplashDialog;
import ebq;
import java.io.File;

public class PlusPanelUtils
{
  public static final int a = 0;
  public static final int b = 3;
  
  private static int a(int paramInt)
  {
    switch (paramInt)
    {
    case 0: 
    default: 
      return 0;
    case 1: 
      return 1;
    }
    return 2;
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getAccount();
    Friends localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(str);
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    localIntent.setClass(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.mobileqqi");
    localIntent.putExtra("PhotoConst.HANDLE_DEST_RESULT", true);
    localIntent.putExtra("PhotoConst.MAXUM_SELECTED_NUM", 20);
    localIntent.putExtra("extra_image_sender_tag", "sessionInfo.enterAlbum");
    localIntent.putExtra("PhotoConst.IS_RECODE_LAST_ALBUMPATH", true);
    localIntent.putExtra("album_enter_directly", true);
    localIntent.putExtra("ALBUM_ID", AlbumUtil.a(paramActivity));
    localIntent.putExtra("ALBUM_NAME", AlbumUtil.b(paramActivity));
    localIntent.putExtra("PhotoConst.PHOTO_LIST_SHOW_PREVIEW", true);
    localIntent.putExtra("PhotoConst.MY_HEAD_DIR", paramQQAppInterface.a(false, str));
    localIntent.putExtra("PhotoConst.SHOULD_SEND_RAW_PHOTO", true);
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uintype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("troop_uin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.putExtra("uinname", paramSessionInfo.d);
    localIntent.putExtra("PhotoConst.MY_UIN", str);
    if (localFriends != null) {
      localIntent.putExtra("PhotoConst.MY_NICK", localFriends.name);
    }
    if (TextUtils.isEmpty(str)) {
      QLog.i("PEAK", 1, "enterAlbum: my uin is " + str);
    }
    localIntent.getExtras().remove("forward_type");
    if (paramSessionInfo.jdField_a_of_type_Int == 1)
    {
      PeakUtils.a(paramActivity, localIntent.getExtras(), 7001);
      return;
    }
    paramActivity.startActivity(localIntent);
    if (QLog.isColorLevel()) {
      QLog.d("PEAK", 2, "enterPhotoPicker");
    }
    AlbumUtil.a(paramActivity, false, true);
  }
  
  public static void a(Activity paramActivity, boolean paramBoolean, String paramString, int paramInt, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramActivity, DoodleActivity.class);
    localIntent.putExtra("doodletype", paramBoolean);
    localIntent.putExtra("friendtype", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("frienduin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("photofilepath", paramString);
    localIntent.putExtra("rotation", paramInt);
    localIntent.putExtra("groupUin", paramSessionInfo.jdField_b_of_type_JavaLangString);
    localIntent.setFlags(67108864);
    paramActivity.startActivityForResult(localIntent, 4);
  }
  
  public static void a(Context paramContext, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent(paramContext, PublicAccountBrowser.class);
    localIntent.putExtra("url", "http://app.p.qq.com/games/zhuagui/game.html");
    localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    localIntent.putExtra("uin_type", paramSessionInfo.jdField_a_of_type_Int);
    localIntent.putExtra("uin_name", paramSessionInfo.d);
    paramContext.startActivity(localIntent);
  }
  
  public static void a(Context paramContext, QQAppInterface paramQQAppInterface, SessionInfo paramSessionInfo)
  {
    String str1 = "http://ti.qq.com/remind/add.html?_wv=1027";
    String str2 = "0";
    switch (paramSessionInfo.jdField_a_of_type_Int)
    {
    }
    for (;;)
    {
      Intent localIntent = new Intent(paramContext, QQBrowserActivity.class);
      localIntent.putExtra("url", str1);
      localIntent.putExtra("uin", paramSessionInfo.jdField_a_of_type_JavaLangString);
      localIntent.putExtra("uin_type", paramSessionInfo.jdField_a_of_type_Int);
      localIntent.putExtra("uin_name", paramSessionInfo.d);
      paramContext.startActivity(localIntent);
      if (QLog.isColorLevel()) {
        QLog.d("remind", 2, "aioClickRemindReport arg1: " + str2);
      }
      ReportController.b(paramQQAppInterface, "CliOper", "", "", "Time_reminder", "Time_aio_clk", 0, 0, str2, "", "", "");
      return;
      str1 = "http://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=c2c&uin=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "0";
      continue;
      str1 = "http://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=group&gid=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "1";
      continue;
      str1 = "http://ti.qq.com/remind/add.html?_wv=1027" + "&rtype=discuss&did=" + paramSessionInfo.jdField_a_of_type_JavaLangString;
      str2 = "2";
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity)
  {
    try
    {
      if (((ChatActivity)paramActivity).a == null) {
        ((ChatActivity)paramActivity).a = new QQMapActivityProxy(paramQQAppInterface.getAccount());
      }
      paramActivity.startActivityForResult(new Intent(paramActivity, PoiMapActivity.class).putExtra("uin", paramQQAppInterface.getAccount()), 18);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, int paramInt)
  {
    if (!Utils.e())
    {
      Toast.makeText(paramActivity, paramActivity.getResources().getString(2131562496), 0).show();
      return;
    }
    Object localObject1 = new File(AppConstants.an + "photo/");
    if (!((File)localObject1).exists()) {
      ((File)localObject1).mkdirs();
    }
    Object localObject2 = AppConstants.an + "photo/" + System.currentTimeMillis() + ".jpg";
    localObject1 = Uri.fromFile(new File((String)localObject2));
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", (String)localObject2).commit();
    if (paramInt == 23)
    {
      localObject1 = new Intent(new Intent());
      localObject2 = (FriendManager)paramQQAppInterface.getManager(8);
      if (localObject2 != null)
      {
        localObject2 = ((FriendManager)localObject2).c(paramQQAppInterface.a());
        if (localObject2 != null) {
          ((Intent)localObject1).putExtra("self_nick", ((Friends)localObject2).name);
        }
      }
      paramQQAppInterface = paramQQAppInterface.a();
      ((Intent)localObject1).putExtra("market", "photocamera");
      ((Intent)localObject1).putExtra("qq", Long.parseLong(paramQQAppInterface));
      ((Intent)localObject1).putExtra("param_plugin_gesturelock", true);
      if (QLog.isDevelopLevel()) {
        QLog.d("STARTUPTIMELOG", 4, "[STARTUPTIMELOG] DemoActivity mButton onClick, time=" + System.currentTimeMillis());
      }
      localObject2 = new IPluginManager.PluginParams(0);
      ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_JavaLangString = "WaterMarkCamera.apk";
      ((IPluginManager.PluginParams)localObject2).d = paramActivity.getResources().getString(2131558932);
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangString = paramQQAppInterface;
      ((IPluginManager.PluginParams)localObject2).e = "com.tencent.cameraui.MqqCameraActivity";
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_JavaLangClass = ZebraPluginProxyActivity.class;
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidContentIntent = ((Intent)localObject1);
      ((IPluginManager.PluginParams)localObject2).jdField_b_of_type_Int = paramInt;
      ((IPluginManager.PluginParams)localObject2).jdField_a_of_type_AndroidAppDialog = new ZebraPluginSplashDialog(paramActivity, 0);
      ((IPluginManager.PluginParams)localObject2).c = 10000;
      ((IPluginManager.PluginParams)localObject2).f = paramActivity.getResources().getString(2131558933);
      IPluginManager.a(paramActivity, (IPluginManager.PluginParams)localObject2);
      return;
    }
    paramQQAppInterface = new Intent("android.media.action.IMAGE_CAPTURE");
    paramQQAppInterface.putExtra("output", (Parcelable)localObject1);
    paramQQAppInterface.putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      paramActivity.startActivityForResult(paramQQAppInterface, paramInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QQToast.a(paramActivity, 2131561740, 0).a();
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    if (paramSessionInfo.jdField_a_of_type_Int == 1000) {
      paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.jdField_b_of_type_JavaLangString);
    }
    for (;;)
    {
      paramActivity.startActivityForResult(paramQQAppInterface, 5);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.e);
      } else {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.c);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo, boolean paramBoolean)
  {
    String str2;
    String str1;
    if (paramBoolean)
    {
      localObject = "Two_call";
      str2 = "Two_call_launch";
      switch (paramSessionInfo.jdField_a_of_type_Int)
      {
      default: 
        str1 = "0";
        label72:
        ReportController.b(paramQQAppInterface, "CliOper", "", "", (String)localObject, str2, 0, 0, str1, "", "", "");
        localObject = (PhoneContactManager)paramQQAppInterface.getManager(10);
        if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
          str1 = ((PhoneContactManager)localObject).b(paramSessionInfo.jdField_a_of_type_JavaLangString);
        }
        break;
      }
    }
    for (Object localObject = paramSessionInfo.jdField_a_of_type_JavaLangString;; localObject = ((PhoneContactManager)localObject).c(str1))
    {
      ChatActivityUtils.a(paramQQAppInterface, paramActivity, paramSessionInfo.jdField_a_of_type_Int, str1, paramSessionInfo.d, (String)localObject, paramBoolean, paramSessionInfo.jdField_b_of_type_JavaLangString, true, true, null, "from_internal");
      return;
      localObject = "Two_video_call";
      str2 = "Two_video_call_launch";
      break;
      str1 = "0";
      break label72;
      str1 = "1";
      break label72;
      str1 = "2";
      break label72;
      str1 = "3";
      break label72;
      str1 = "4";
      break label72;
      str1 = paramSessionInfo.jdField_a_of_type_JavaLangString;
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new ebq(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.c(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files\t", 0, 0, "", paramSessionInfo.jdField_a_of_type_JavaLangString, "", "");
    paramQQAppInterface = new Intent(paramActivity, FMLocalFileActivity.class);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", paramSessionInfo.jdField_a_of_type_JavaLangString, "Music_gene", "Music_gene_AIO", 0, 0, String.valueOf(a(paramSessionInfo.jdField_a_of_type_Int)), "", "", "");
    paramQQAppInterface = new Intent(paramActivity, QQBrowserActivity.class);
    paramQQAppInterface.putExtra("url", "http://y.qq.com/m/qq/aio.html" + "?touin=" + paramSessionInfo.jdField_a_of_type_JavaLangString + "&uintype=" + paramSessionInfo.jdField_a_of_type_Int + "&_wv=1");
    paramQQAppInterface.putExtra("hide_left_button", true);
    paramQQAppInterface.putExtra("show_right_close_button", true);
    paramQQAppInterface.putExtra("finish_animation_up_down", true);
    paramActivity.startActivity(paramQQAppInterface);
    paramActivity.overridePendingTransition(2130968591, 0);
  }
  
  public static void d(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.b(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1);
    QfavReport.c(paramQQAppInterface, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */