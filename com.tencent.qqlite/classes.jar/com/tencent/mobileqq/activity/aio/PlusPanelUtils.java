package com.tencent.mobileqq.activity.aio;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.widget.Toast;
import btc;
import com.tencent.biz.PoiMapActivity;
import com.tencent.biz.anonymous.AnonymousChatHelper;
import com.tencent.biz.pubaccount.PublicAccountBrowser;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.activity.ChatActivity;
import com.tencent.mobileqq.activity.DoodleActivity;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.photo.MediaFileFilter;
import com.tencent.mobileqq.activity.photo.PhotoListActivity;
import com.tencent.mobileqq.activity.photo.SendPhotoActivity;
import com.tencent.mobileqq.app.AppConstants;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Friends;
import com.tencent.mobileqq.filemanager.activity.FMActivity;
import com.tencent.mobileqq.model.FriendManager;
import com.tencent.mobileqq.statistics.ReportController;
import com.tencent.mobileqq.util.Utils;
import com.tencent.mobileqq.utils.AlbumUtil;
import com.tencent.mobileqq.utils.ImageUtil;
import com.tencent.mobileqq.widget.QQToast;
import com.tencent.qphone.base.util.QLog;
import cooperation.peak.PeakUtils;
import cooperation.qqfav.QfavHelper;
import cooperation.qqfav.QfavReport;
import java.io.File;
import java.util.Calendar;

public class PlusPanelUtils
{
  public static String a;
  public static String b;
  
  private static String a()
  {
    Calendar localCalendar = Calendar.getInstance();
    StringBuilder localStringBuilder = new StringBuilder(AppConstants.aw);
    localStringBuilder.append("IMG");
    localStringBuilder.append(localCalendar.get(1));
    int i = localCalendar.get(2) + 1;
    if (i < 10)
    {
      localObject = "0" + i;
      localStringBuilder.append(localObject);
      i = localCalendar.get(5);
      if (i >= 10) {
        break label300;
      }
      localObject = "0" + i;
      label108:
      localStringBuilder.append(localObject);
      i = localCalendar.get(11);
      if (i >= 10) {
        break label308;
      }
      localObject = "0" + i;
      label148:
      localStringBuilder.append(localObject);
      i = localCalendar.get(12);
      if (i >= 10) {
        break label316;
      }
      localObject = "0" + i;
      label188:
      localStringBuilder.append(localObject);
      i = localCalendar.get(13);
      if (i >= 10) {
        break label324;
      }
    }
    label300:
    label308:
    label316:
    label324:
    for (Object localObject = "0" + i;; localObject = Integer.valueOf(i))
    {
      localStringBuilder.append(localObject);
      if (new File(localStringBuilder.toString() + ".jpg").exists()) {
        break label332;
      }
      return localStringBuilder.toString() + ".jpg";
      localObject = Integer.valueOf(i);
      break;
      localObject = Integer.valueOf(i);
      break label108;
      localObject = Integer.valueOf(i);
      break label148;
      localObject = Integer.valueOf(i);
      break label188;
    }
    label332:
    localObject = new StringBuilder(localStringBuilder);
    int j = localStringBuilder.length();
    i = 1;
    for (;;)
    {
      if (i < 2147483647)
      {
        ((StringBuilder)localObject).append('(');
        ((StringBuilder)localObject).append(i);
        ((StringBuilder)localObject).append(')');
        ((StringBuilder)localObject).append(".jpg");
        if (new File(((StringBuilder)localObject).toString()).exists()) {}
      }
      else
      {
        return ((StringBuilder)localObject).toString();
      }
      ((StringBuilder)localObject).delete(j, ((StringBuilder)localObject).length());
      i += 1;
    }
  }
  
  public static void a(Activity paramActivity, SessionInfo paramSessionInfo, QQAppInterface paramQQAppInterface)
  {
    String str = paramQQAppInterface.getAccount();
    Friends localFriends = ((FriendManager)paramQQAppInterface.getManager(8)).c(str);
    Intent localIntent = new Intent(paramActivity, SendPhotoActivity.class);
    localIntent.setClass(paramActivity, PhotoListActivity.class);
    localIntent.putExtra("PhotoConst.SEND_BUSINESS_TYPE", 1007);
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_CLASS_NAME", ChatActivity.class.getName());
    localIntent.putExtra("PhotoConst.INIT_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_CLASS_NAME", SendPhotoActivity.class.getName());
    localIntent.putExtra("PhotoConst.DEST_ACTIVITY_PACKAGE_NAME", "com.tencent.qqlite");
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
    localIntent.putExtra("troop_uin", paramSessionInfo.b);
    localIntent.putExtra("uinname", paramSessionInfo.d);
    localIntent.putExtra("PhotoConst.MY_UIN", str);
    if ((paramActivity instanceof ChatActivity)) {
      localIntent.putExtra("isBack2Root", ((ChatActivity)paramActivity).a().c);
    }
    if (localFriends != null) {
      localIntent.putExtra("PhotoConst.MY_NICK", localFriends.name);
    }
    localIntent.putExtra("is_anonymous", AnonymousChatHelper.a().a(paramSessionInfo.jdField_a_of_type_JavaLangString));
    if (AlbumUtil.a(paramSessionInfo.jdField_a_of_type_Int)) {}
    for (int i = MediaFileFilter.MEDIA_FILTER_DEFAULT.ordinal();; i = MediaFileFilter.MEDIA_FILTER_SHOW_IMAGE.ordinal())
    {
      localIntent.putExtra("PhotoConst.PHOTOLIST_KEY_SHOW_MEDIA", i);
      if ((TextUtils.isEmpty(str)) && (QLog.isColorLevel())) {
        QLog.i("PEAK", 2, "enterAlbum: my uin is " + str);
      }
      localIntent.getExtras().remove("forward_type");
      if (paramSessionInfo.jdField_a_of_type_Int != 1) {
        break;
      }
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
    localIntent.putExtra("groupUin", paramSessionInfo.b);
    localIntent.setFlags(67108864);
    paramActivity.startActivityForResult(localIntent, 3);
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
      ((ChatActivity)paramActivity).a().Z();
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
      Toast.makeText(paramActivity, paramActivity.getResources().getString(2131363511), 0).show();
      return;
    }
    paramQQAppInterface = new File(AppConstants.aw);
    if (!paramQQAppInterface.exists()) {
      paramQQAppInterface.mkdirs();
    }
    Object localObject = a();
    paramQQAppInterface = Uri.fromFile(new File((String)localObject));
    PreferenceManager.getDefaultSharedPreferences(paramActivity).edit().putString("camera_photo_path", (String)localObject).commit();
    localObject = new Intent("android.media.action.IMAGE_CAPTURE");
    ((Intent)localObject).putExtra("output", paramQQAppInterface);
    ((Intent)localObject).putExtra("android.intent.extra.videoQuality", 100);
    try
    {
      paramActivity.startActivityForResult((Intent)localObject, paramInt);
      return;
    }
    catch (Exception paramQQAppInterface)
    {
      paramQQAppInterface.printStackTrace();
      QQToast.a(paramActivity, 2131363515, 0).a();
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
      paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.b);
    }
    for (;;)
    {
      paramActivity.startActivityForResult(paramQQAppInterface, 5);
      paramActivity.overridePendingTransition(2130968585, 2130968586);
      return;
      if (paramSessionInfo.jdField_a_of_type_Int == 1006) {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.e);
      } else {
        paramQQAppInterface.putExtra("srcDiscGroup", paramSessionInfo.c);
      }
    }
  }
  
  public static void a(QQAppInterface paramQQAppInterface, Context paramContext, Uri paramUri, SessionInfo paramSessionInfo)
  {
    new btc(paramSessionInfo, paramQQAppInterface, paramContext, ImageUtil.c(paramContext, paramUri)).execute(new Void[0]);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    ReportController.b(paramQQAppInterface, "CliOper", "", "", "Grp", "Up_sent_files\t", 0, 0, "", paramSessionInfo.jdField_a_of_type_JavaLangString, "", "");
    paramQQAppInterface = new Intent(paramActivity, FMActivity.class);
    paramQQAppInterface.putExtra("from_aio", true);
    paramQQAppInterface.addFlags(536870912);
    paramQQAppInterface.putExtra("selectMode", true);
    paramQQAppInterface.putExtra("peerType", paramSessionInfo.jdField_a_of_type_Int);
    paramQQAppInterface.putExtra("targetUin", paramSessionInfo.jdField_a_of_type_JavaLangString);
    paramQQAppInterface.putExtra("tab_tab_type", 5);
    paramQQAppInterface.putExtra("key_check_troop_privilege", true);
    paramActivity.startActivityForResult(paramQQAppInterface, 5);
    paramActivity.overridePendingTransition(2130968585, 2130968586);
  }
  
  public static void c(QQAppInterface paramQQAppInterface, Activity paramActivity, SessionInfo paramSessionInfo)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("bEnterToSelect", true);
    localIntent.putExtra("paSessionInfo", paramSessionInfo);
    QfavHelper.b(paramActivity, paramQQAppInterface.getAccount(), localIntent, -1);
    QfavReport.c(paramQQAppInterface, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.PlusPanelUtils
 * JD-Core Version:    0.7.0.1
 */