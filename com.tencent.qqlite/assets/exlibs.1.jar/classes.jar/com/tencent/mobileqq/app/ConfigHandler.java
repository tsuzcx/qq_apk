package com.tencent.mobileqq.app;

import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.content.res.Resources;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.common.config.AppSetting;
import com.tencent.mobileqq.activity.ChatBackgroundSettingActivity;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.activity.UpgradeActivity;
import com.tencent.mobileqq.app.upgrade.UpgradeController;
import com.tencent.mobileqq.app.upgrade.UpgradeController.OnHandleUpgradeFinishListener;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.app.upgrade.UpgradeDetailWrapper.NewApkInfo;
import com.tencent.mobileqq.config.operation.QQOperateManager;
import com.tencent.mobileqq.config.operation.QQOperationRequestTaskInfo;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.config.splashlogo.ConfigServlet;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.earlydownload.EarlyDownloadManager;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.persistence.EntityManagerFactory;
import com.tencent.mobileqq.richstatus.StatusManager;
import com.tencent.mobileqq.service.message.MessageCache;
import com.tencent.mobileqq.utils.AppShareIDUtil;
import com.tencent.mobileqq.utils.JumpFilterHelper;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import cqs;
import cqt;
import cqu;
import cqv;
import cqw;
import cqx;
import cqy;
import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.SDKUpgradeRes;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.mobiletips.MobileTips.MobileTipsPkg;
import tencent.im.mobiletips.MobileTips.ReqBody;
import tencent.im.mobiletips.MobileTips.RspBody;
import tencent.im.mobiletips.MobileTips.TaskInfo;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43.UpdateTips;

public class ConfigHandler
  extends BusinessHandler
  implements UpgradeController.OnHandleUpgradeFinishListener
{
  public static final int a = 1;
  private static final String jdField_a_of_type_JavaLangString = "VoiceNotify";
  public static final int b = 2;
  private static final String b = "k_voice_notify2_file_version";
  public static final int c = 3;
  public static final int d = 4;
  public static final int e = 5;
  public static final int f = 6;
  public static final int g = 7;
  public static final int h = 8;
  public static int i = 0;
  private HashSet jdField_a_of_type_JavaUtilHashSet = new HashSet();
  private volatile boolean jdField_a_of_type_Boolean;
  
  public ConfigHandler(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  public static int a(QQAppInterface paramQQAppInterface)
  {
    int j = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + j);
    }
    return j;
  }
  
  public static UpgradeDetailWrapper.NewApkInfo a(UpgradeInfo paramUpgradeInfo)
  {
    if ((paramUpgradeInfo != null) && (paramUpgradeInfo.strProgressName != null))
    {
      paramUpgradeInfo = paramUpgradeInfo.strProgressName;
      if (paramUpgradeInfo != null)
      {
        String[] arrayOfString = paramUpgradeInfo.split("\\|");
        try
        {
          paramUpgradeInfo = new UpgradeDetailWrapper.NewApkInfo();
          return null;
        }
        catch (Exception paramUpgradeInfo)
        {
          try
          {
            paramUpgradeInfo.jdField_a_of_type_JavaLangString = arrayOfString[2];
            paramUpgradeInfo.b = arrayOfString[1];
            paramUpgradeInfo.jdField_a_of_type_Long = Long.parseLong(arrayOfString[0]);
            paramUpgradeInfo.jdField_a_of_type_Int = Integer.parseInt(arrayOfString[3]);
            return paramUpgradeInfo;
          }
          catch (Exception localException)
          {
            return paramUpgradeInfo;
          }
          paramUpgradeInfo = paramUpgradeInfo;
          return null;
        }
      }
    }
  }
  
  private static String a()
  {
    Date localDate = new Date();
    int j = localDate.getYear();
    int k = localDate.getMonth();
    int m = localDate.getDay();
    return j + ":" + k + ":" + m;
  }
  
  public static String a(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if (paramContext.size() > 0) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static String a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    String str1 = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if (str1 == null) {
      return null;
    }
    String str2 = paramQQAppInterface.getString("UPGRADE_BANNER_URL_MARK", null);
    paramQQAppInterface = str1;
    if (str2 != null)
    {
      paramQQAppInterface = str2.split(":");
      long l1 = Long.parseLong(paramQQAppInterface[0]);
      long l2 = Long.parseLong(paramQQAppInterface[1]);
      long l3 = System.currentTimeMillis();
      if ((l2 >= l1) && (l3 > l1))
      {
        paramQQAppInterface = str1;
        if (l3 <= l2) {}
      }
      else
      {
        paramQQAppInterface = null;
      }
    }
    return paramQQAppInterface;
  }
  
  public static String a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + paramInt);
    }
    Object localObject = paramQQAppInterface.getPreferences();
    paramQQAppInterface = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if (paramQQAppInterface == null) {}
    do
    {
      long l1;
      long l2;
      long l3;
      do
      {
        return null;
        localObject = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL_MARK", null);
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + (String)localObject);
        }
        if (TextUtils.isEmpty((CharSequence)localObject)) {
          break;
        }
        localObject = ((String)localObject).split(":");
        l1 = Long.parseLong(localObject[0]);
        l2 = Long.parseLong(localObject[1]);
        l3 = System.currentTimeMillis();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsUrl:" + l3);
        }
      } while ((l2 < l1) || (l3 <= l1));
      if (l3 > l2) {
        return paramQQAppInterface;
      }
    } while (paramInt > 0);
    return paramQQAppInterface;
  }
  
  public static void a(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("UPGRADE_TIPS_DAILY_STR", a());
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("NEW_ICON_TIMESTAMP", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    String str = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if ((str != null) && (paramInt >= 0))
    {
      if (str.equals(paramString)) {
        return;
      }
      b(paramQQAppInterface, 0);
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = ((SharedPreferences)localObject).edit();
      paramQQAppInterface.putString("UPGRADE_TIPS_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_TIPS_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    paramQQAppInterface = l1 + ":" + (l2 + l1);
    localObject = ((SharedPreferences)localObject).edit();
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL_MARK", paramQQAppInterface);
    ((SharedPreferences.Editor)localObject).putString("UPGRADE_TIPS_URL", paramString);
    ((SharedPreferences.Editor)localObject).commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void a(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
    }
    SubMsgType0x43.UpdateTips localUpdateTips = new SubMsgType0x43.UpdateTips();
    try
    {
      paramQQAppInterface.a(0);
      paramQQAppInterface = localUpdateTips.bytes_desc.get().toString();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + paramQQAppInterface);
      }
      localUpdateTips.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface) {}
  }
  
  private void a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    Object localObject2 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences();
    if (paramUpgradeDetailWrapper == null) {}
    Object localObject1;
    label265:
    do
    {
      do
      {
        do
        {
          do
          {
            do
            {
              do
              {
                return;
                localObject1 = paramUpgradeDetailWrapper.a;
              } while (localObject1 == null);
              SharedPreferences.Editor localEditor = ((SharedPreferences)localObject2).edit();
              if (((SharedPreferences)localObject2).getInt("upgrade_timeStamp", 0) < ((UpgradeInfo)localObject1).iNewTimeStamp) {
                localEditor.putInt("upgrade_timeStamp", ((UpgradeInfo)localObject1).iNewTimeStamp);
              }
              localEditor.commit();
              a(true, paramUpgradeDetailWrapper);
            } while (((UpgradeInfo)localObject1).iActionType != 0);
            if (((UpgradeInfo)localObject1).iUpgradeType == 1) {}
            for (;;)
            {
              if (((UpgradeInfo)localObject1).iUpgradeType != 2) {
                break label265;
              }
              if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).equals("com.tencent.mobileqq.activity.UserguideActivity")) {
                break;
              }
              localObject2 = new Intent();
              ((Intent)localObject2).putExtra("logout_intent", true);
              ((Intent)localObject2).putExtra("reason_for_upgrade", true);
              ((Intent)localObject2).putExtra("StrTitle", "版本升级");
              ((Intent)localObject2).putExtra("StrUpgradeDesc", "你当前使用的QQ版本过低，需要立即升级");
              ((Intent)localObject2).putExtra("StrUrl", ((UpgradeInfo)localObject1).strNewSoftwareURL);
              ((Intent)localObject2).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
              ThemeUiPlugin.destroy(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
              ChatBackgroundSettingActivity.f();
              this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.logout(true);
              if (BaseApplicationImpl.a != null) {
                BaseApplicationImpl.a.evictAll();
              }
              localObject1 = BaseActivity.sTopActivity;
              paramUpgradeDetailWrapper = (UpgradeDetailWrapper)localObject1;
              if (localObject1 == null)
              {
                paramUpgradeDetailWrapper = BaseApplication.getContext();
                ((Intent)localObject2).addFlags(268435456);
              }
              ((Intent)localObject2).setClass(paramUpgradeDetailWrapper, LoginActivity.class);
              paramUpgradeDetailWrapper.startActivity((Intent)localObject2);
              return;
              c();
            }
          } while (((UpgradeInfo)localObject1).iUpgradeType != 1);
          if (UpgradeController.a().a() != 4) {
            break;
          }
          paramUpgradeDetailWrapper = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
        } while (paramUpgradeDetailWrapper == null);
        paramUpgradeDetailWrapper.obtainMessage(1134018).sendToTarget();
        return;
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, false))
        {
          UpgradeController.a().a();
          return;
        }
        if ((((UpgradeInfo)localObject1).iTipsType != 0) && (((UpgradeInfo)localObject1).iTipsType != 2)) {
          break;
        }
        paramUpgradeDetailWrapper = new Intent(BaseApplication.getContext(), UpgradeActivity.class);
        paramUpgradeDetailWrapper.putExtra("StrTitle", ((UpgradeInfo)localObject1).strTitle);
        paramUpgradeDetailWrapper.putExtra("StrUpgradeDesc", ((UpgradeInfo)localObject1).strUpgradeDesc);
        paramUpgradeDetailWrapper.putExtra("StrUrl", ((UpgradeInfo)localObject1).strUrl);
        paramUpgradeDetailWrapper.putExtra("iUpgradeType", ((UpgradeInfo)localObject1).iUpgradeType);
        paramUpgradeDetailWrapper.putExtra("iTipsType", ((UpgradeInfo)localObject1).iTipsType);
        paramUpgradeDetailWrapper.putExtra("strConfirmBtnText", ((UpgradeInfo)localObject1).strButtonDesc);
        paramUpgradeDetailWrapper.putExtra("activity_type", 4096);
        paramUpgradeDetailWrapper.putExtra("mode", 0);
        if (a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a()).equals("com.tencent.mobileqq.activity.UserguideActivity"))
        {
          this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = paramUpgradeDetailWrapper;
          return;
        }
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a = null;
      } while (BaseActivity.sTopActivity == null);
      BaseActivity.sTopActivity.startActivity(paramUpgradeDetailWrapper);
      return;
      localObject1 = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    } while (localObject1 == null);
    ((Handler)localObject1).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
  }
  
  private void a(EntityManager paramEntityManager, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "get share appid resp info");
    }
    if (paramGetResourceRespInfo.iResult != 0) {
      a(5, false, null);
    }
    AppShareID localAppShareID;
    do
    {
      return;
      localAppShareID = AppShareIDUtil.a(paramGetResourceRespInfo);
    } while (localAppShareID == null);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + localAppShareID);
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.a(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.a(localAppShareID);
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Persist DB appid = " + localAppShareID.strPkgName);
      }
    }
    for (;;)
    {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().a.a(localAppShareID.strPkgName, localAppShareID);
      a(localAppShareID.strResURL_big, this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getFileStreamPath(localAppShareID.strPkgName));
      a(5, true, localAppShareID);
      return;
      if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
      {
        paramEntityManager.b(paramGetResourceRespInfo);
        paramEntityManager.a(localAppShareID);
        if (QLog.isColorLevel()) {
          QLog.d("share_appid", 2, "Update DB appid = " + localAppShareID.strPkgName);
        }
      }
      else if (QLog.isColorLevel())
      {
        QLog.d("share_appid", 2, "Not need update DB appid = " + localAppShareID.strPkgName);
      }
    }
  }
  
  private void a(Object paramObject)
  {
    if (paramObject == null) {
      a(false, null);
    }
    Object localObject;
    do
    {
      return;
      localObject = ((SDKUpgradeRes)paramObject).vUpgradeInfo;
      paramObject = UpgradeController.a().a();
      if ((localObject == null) || (((ArrayList)localObject).size() <= 0)) {
        break;
      }
      localObject = (UpgradeInfo)((ArrayList)localObject).get(0);
      UpgradeController.a().a((UpgradeInfo)localObject, this);
      a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a.strNewTipsDescURL, paramObject.a.iTipsWaitDay);
      b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramObject.a.strBannerPicUrl, paramObject.a.iDisplayDay);
    } while (((UpgradeInfo)localObject).iUpgradeType != 0);
    a(true, paramObject);
    return;
    a(false, paramObject);
  }
  
  private void a(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.add(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void a(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    do
    {
      return;
      long l1 = JumpFilterHelper.a().a();
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqs(this, paramGetResourceRespInfo, l2));
    return;
    ThreadManager.a().post(new cqt(this));
  }
  
  private void a(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    a(4, paramBoolean, paramUpgradeDetailWrapper);
    this.jdField_a_of_type_Boolean = false;
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("AUTO_DOWNLOADED_IN_WIFI", false);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramInt == paramQQAppInterface.getPreferences().getInt("NEW_ICON_TIMESTAMP", -1);
  }
  
  public static boolean a(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
  }
  
  public static void b(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("UPGRADE_TIPS_SHOW_COUNT", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    String str = paramQQAppInterface.getString("UPGRADE_BANNER_URL", null);
    if ((str != null) && (paramInt > 0) && (str.equals(paramString))) {
      return;
    }
    if (TextUtils.isEmpty(paramString))
    {
      paramQQAppInterface = paramQQAppInterface.edit();
      paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", null);
      paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
      paramQQAppInterface.commit();
      return;
    }
    long l1 = System.currentTimeMillis();
    long l2 = paramInt * 24 * 60 * 60 * 1000;
    str = l1 + ":" + (l2 + l1);
    paramQQAppInterface = paramQQAppInterface.edit();
    paramQQAppInterface.putString("UPGRADE_BANNER_URL_MARK", str);
    paramQQAppInterface.putString("UPGRADE_BANNER_URL", paramString);
    paramQQAppInterface.commit();
  }
  
  public static void b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  private void b(String paramString)
  {
    try
    {
      this.jdField_a_of_type_JavaUtilHashSet.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    com.tencent.mobileqq.filemanager.data.FMConstants.jdField_a_of_type_Boolean = true;
    if (paramGetResourceRespInfo.iResult == -2) {}
    while (paramGetResourceRespInfo.iResult == 0)
    {
      String str = paramGetResourceRespInfo.strResURL_big;
      if ((str != null) && (str.length() > 0)) {
        this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqu(this, str, paramGetResourceRespInfo));
      }
      return;
    }
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (a().equals(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + bool1 + "--> " + paramQQAppInterface);
    }
    return bool1;
  }
  
  private void c()
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().getSharedPreferences("QQLite", 0).edit().putInt("upgrade_tip_count", 0).putLong("upgrade_tip_time", 0L).commit();
    b(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, 0);
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0) {
      a(1, false, paramGetResourceRespInfo);
    }
    String str;
    do
    {
      return;
      str = paramGetResourceRespInfo.strResURL_big;
    } while ((str == null) || (str.length() <= 0));
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqv(this, str, paramGetResourceRespInfo));
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + paramGetResourceRespInfo.iResult + ", server version:" + paramGetResourceRespInfo.uiNewVer);
    }
    if (paramGetResourceRespInfo.iResult == -2) {
      a(7, true, Integer.valueOf(100));
    }
    StatusManager localStatusManager;
    do
    {
      return;
      if (paramGetResourceRespInfo.iResult != 0)
      {
        a(7, false, Integer.valueOf(-1));
        return;
      }
      localStatusManager = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    } while (localStatusManager == null);
    if (!localStatusManager.a(paramGetResourceRespInfo.uiNewVer))
    {
      a(7, true, Integer.valueOf(100));
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.richstatus.xml", 2, "url is empty");
      }
      a(7, false, Integer.valueOf(-1));
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqw(this, str, localStatusManager, paramGetResourceRespInfo));
  }
  
  protected Class a()
  {
    return ConfigObserver.class;
  }
  
  public GetResourceReqInfo a()
  {
    long l = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getPreferences().getLong("k_voice_notify2_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("VoiceNotify", 2, "updateVoiceNotifyConfig => curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQVoiceNotifyConfig2_android_CI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo a(String paramString, long paramLong)
  {
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = paramString;
    localGetResourceReqInfo.uiCurVer = paramLong;
    localGetResourceReqInfo.sResType = 3;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void a()
  {
    Handler localHandler = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(Conversation.class);
    if (localHandler != null)
    {
      localHandler.sendEmptyMessage(11340004);
      localHandler.sendEmptyMessage(1134019);
    }
    a(true, null);
  }
  
  public void a(int paramInt)
  {
    if (this.jdField_a_of_type_Boolean) {
      return;
    }
    UpgradeController.a().a(false);
    a(false, null);
    this.jdField_a_of_type_Boolean = true;
    ToServiceMsg localToServiceMsg = a("ConfigService.ClientReq");
    localToServiceMsg.extraData.putInt("iActionType", paramInt);
    localToServiceMsg.setAppId(AppSetting.jdField_a_of_type_Int);
    DisplayMetrics localDisplayMetrics = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getResources().getDisplayMetrics();
    paramInt = localDisplayMetrics.widthPixels;
    int j = localDisplayMetrics.heightPixels;
    localToServiceMsg.extraData.putInt("iWidth", paramInt);
    localToServiceMsg.extraData.putInt("iHeight", j);
    a(localToServiceMsg);
  }
  
  public void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, UpgradeController paramUpgradeController)
  {
    a(paramUpgradeDetailWrapper);
  }
  
  public void a(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool1 = false;
    if ("ConfigService.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      if (paramObject == null) {
        if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
          ((ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49)).a(null);
        }
      }
      do
      {
        return;
        paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
      } while ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0));
      int j = 0;
      label72:
      if (j < paramToServiceMsg.size())
      {
        paramFromServiceMsg = (GetResourceRespInfo)paramToServiceMsg.get(j);
        if (QLog.isColorLevel()) {
          QLog.d("ThemeDownloadTrace", 2, "resType is:" + paramFromServiceMsg.sResType + ",result is:" + paramFromServiceMsg.iResult + ",pkgName is:" + paramFromServiceMsg.strPkgName);
        }
        if (paramFromServiceMsg.sResType != 3) {
          break label260;
        }
        if (!"FileOnlinePreviewConfig".equals(paramFromServiceMsg.strPkgName)) {
          break label217;
        }
        b(paramFromServiceMsg);
      }
      label260:
      for (;;)
      {
        if (paramFromServiceMsg.sResType == 4)
        {
          paramObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a().createEntityManager();
          a(paramObject, paramFromServiceMsg);
          paramObject.a();
        }
        j += 1;
        break label72;
        break;
        label217:
        if (EarlyDownloadManager.a(paramFromServiceMsg.strPkgName))
        {
          paramObject = (EarlyDownloadManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(58);
          if (paramObject != null) {
            paramObject.a(paramFromServiceMsg);
          }
        }
        else
        {
          c(paramFromServiceMsg);
          continue;
          if (paramFromServiceMsg.sResType == 2) {
            if ("rich_status_android".equals(paramFromServiceMsg.strPkgName))
            {
              d(paramFromServiceMsg);
            }
            else if ("QQAddFriend.AdministrateRegion".equals(paramFromServiceMsg.strPkgName))
            {
              paramObject = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
              if (paramObject != null) {
                paramObject.a(paramFromServiceMsg);
              }
            }
            else if ("com.tencent.jumpCI".equals(paramFromServiceMsg.strPkgName))
            {
              a(paramFromServiceMsg);
            }
          }
        }
      }
    }
    if ("ConfigService.ClientReq".equals(paramFromServiceMsg.getServiceCmd()))
    {
      a(paramObject);
      return;
    }
    boolean bool2;
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool2 = paramFromServiceMsg.isSuccess();
      if (!bool2) {
        break label512;
      }
      paramToServiceMsg = new MobileTips.MobileTipsPkg();
    }
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.rsp.result.get() == 0) {
          bool1 = true;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + bool1);
        }
        if (bool1) {
          break;
        }
        return;
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
      label512:
      bool1 = bool2;
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList)
  {
    if (QLog.isDevelopLevel())
    {
      QLog.d("QQOperateVoIP", 4, "receive task, uin =" + paramString + " uinType=" + paramInt);
      localObject1 = paramArrayList.iterator();
      while (((Iterator)localObject1).hasNext())
      {
        localObject2 = (QQOperationViopTipTask)((Iterator)localObject1).next();
        QLog.d("QQOperateVoIP", 4, "receive task, taskid=" + ((QQOperationViopTipTask)localObject2).taskid);
      }
    }
    Object localObject1 = new OperateVoipTipsInfo();
    ((OperateVoipTipsInfo)localObject1).uin = paramString;
    ((OperateVoipTipsInfo)localObject1).uinType = paramInt;
    ((OperateVoipTipsInfo)localObject1).taskList = paramArrayList;
    Object localObject2 = QQOperateManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = ((QQOperateManager)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localQQOperationViopTipTask == null)
      {
        ConfigServlet.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = localQQOperationViopTipTask.taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = localQQOperationViopTipTask.tipType;
      localQQOperationVoipTipsTaskExcuteRecord.uin = paramString;
      localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt;
      localQQOperationVoipTipsTaskExcuteRecord.count = 1;
      localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
      ((QQOperateManager)localObject2).a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, localQQOperationVoipTipsTaskExcuteRecord);
    }
    a(8, true, localObject1);
  }
  
  public void a(String paramString, int paramInt, ArrayList paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
    if (paramInt == 3000) {}
    for (int j = 2;; j = 1)
    {
      localMobileTipsPkg.req.peer_type.set(j);
      localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
      if (paramArrayList != null)
      {
        ArrayList localArrayList = new ArrayList();
        paramArrayList = paramArrayList.iterator();
        while (paramArrayList.hasNext())
        {
          QQOperationRequestTaskInfo localQQOperationRequestTaskInfo = (QQOperationRequestTaskInfo)paramArrayList.next();
          MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
          localTaskInfo.task_id.set(localQQOperationRequestTaskInfo.jdField_a_of_type_Int);
          localTaskInfo.msgcnt.set(localQQOperationRequestTaskInfo.b);
          localTaskInfo.keywords.set(localQQOperationRequestTaskInfo.jdField_a_of_type_JavaUtilArrayList);
          localTaskInfo.setHasFlag(true);
          localArrayList.add(localTaskInfo);
        }
        localMobileTipsPkg.req.task_list.set(localArrayList);
      }
      localMobileTipsPkg.req.setHasFlag(true);
      localMobileTipsPkg.rsp.setHasFlag(true);
      localMobileTipsPkg.setHasFlag(true);
      paramArrayList = new ToServiceMsg("mobileqq.service", this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(), "MobileTipsSvc.TipsReport");
      paramArrayList.extraData.putBoolean("isRetry", paramBoolean);
      paramArrayList.extraData.putString("chatuin", paramString);
      paramArrayList.extraData.putInt("chattype", paramInt);
      paramArrayList.putWupBuffer(localMobileTipsPkg.toByteArray());
      b(paramArrayList);
      return;
    }
  }
  
  public void a(String paramString, File paramFile)
  {
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqx(this, paramString, paramFile));
  }
  
  public void a(String paramString1, String paramString2)
  {
    try
    {
      boolean bool = this.jdField_a_of_type_JavaUtilHashSet.contains(paramString1);
      if ((paramString1 == null) || (paramString1.length() == 0) || (bool)) {
        return;
      }
    }
    finally {}
    a(paramString1);
    this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.a(new cqy(this, paramString2, paramString1));
  }
  
  public void a(ArrayList paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
    int j = 0;
    ArrayList localArrayList = new ArrayList(4);
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      paramArrayList = paramArrayList.iterator();
      for (bool1 = false;; bool1 = bool2)
      {
        bool2 = bool1;
        if (!paramArrayList.hasNext()) {
          break;
        }
        GetResourceReqInfo localGetResourceReqInfo = (GetResourceReqInfo)paramArrayList.next();
        bool2 = bool1;
        if (localGetResourceReqInfo != null)
        {
          if (localGetResourceReqInfo.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
            bool1 = true;
          }
          localArrayList.add(localGetResourceReqInfo);
          bool2 = bool1;
        }
      }
    }
    boolean bool2 = false;
    int k = paramVarArgs.length;
    for (boolean bool1 = bool2; j < k; bool1 = bool2)
    {
      paramArrayList = paramVarArgs[j];
      bool2 = bool1;
      if (paramArrayList != null)
      {
        if (paramArrayList.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
          bool1 = true;
        }
        localArrayList.add(paramArrayList);
        bool2 = bool1;
      }
      j += 1;
    }
    if (localArrayList.size() <= 0) {
      return;
    }
    paramArrayList = a("ConfigService.GetResourceReq");
    paramArrayList.extraData.putSerializable("getResourceReqInfos", localArrayList);
    paramArrayList.extraData.putBoolean("reqRegionConfig", bool1);
    a(paramArrayList);
  }
  
  public GetResourceReqInfo b()
  {
    long l = BaseApplicationImpl.a().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "com.tencent.jumpCI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void b() {}
  
  public GetResourceReqInfo c()
  {
    Object localObject = (StatusManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(14);
    if (localObject == null) {
      return null;
    }
    long l = ((StatusManager)localObject).a();
    localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "rich_status_android";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public GetResourceReqInfo d()
  {
    ConditionSearchManager localConditionSearchManager = (ConditionSearchManager)this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getManager(49);
    if (localConditionSearchManager == null) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
    localGetResourceReqInfo.uiCurVer = localConditionSearchManager.a(true);
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo e()
  {
    Object localObject = this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface.getApplication().getSharedPreferences("OfflineFileConfig", 0);
    long l = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
    l = MessageCache.a() - l;
    if (QLog.isColorLevel()) {
      QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime[" + l + "]");
    }
    if (l > 86400L)
    {
      l = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfig";
      ((GetResourceReqInfo)localObject).uiCurVer = l;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime over one day!currentVersion[" + l + "]");
      }
      return localObject;
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.app.ConfigHandler
 * JD-Core Version:    0.7.0.1
 */