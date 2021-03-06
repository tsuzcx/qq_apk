import MAAccessClient.AccessRsp;
import MAAccessClient.GetSinglePkgSigRsp;
import android.app.ActivityManager;
import android.app.ActivityManager.RunningTaskInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.os.Message;
import android.support.v4.util.MQLruCache;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.activity.Conversation;
import com.tencent.mobileqq.activity.LoginActivity;
import com.tencent.mobileqq.app.BaseActivity;
import com.tencent.mobileqq.app.ConfigHandler.1;
import com.tencent.mobileqq.app.ConfigHandler.11;
import com.tencent.mobileqq.app.ConfigHandler.2;
import com.tencent.mobileqq.app.ConfigHandler.3;
import com.tencent.mobileqq.app.ConfigHandler.4;
import com.tencent.mobileqq.app.ConfigHandler.5;
import com.tencent.mobileqq.app.ConfigHandler.6;
import com.tencent.mobileqq.app.ConfigHandler.7;
import com.tencent.mobileqq.app.ConfigHandler.8;
import com.tencent.mobileqq.app.ConfigHandler.9;
import com.tencent.mobileqq.app.DeviceProfileManager;
import com.tencent.mobileqq.app.DeviceProfileManager.DpcNames;
import com.tencent.mobileqq.app.MessageHandler;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.config.operation.QQOperationViopTipTask;
import com.tencent.mobileqq.config.operation.QQOperationVoipTipsTaskExcuteRecord;
import com.tencent.mobileqq.data.AppShareID;
import com.tencent.mobileqq.data.OperateVoipTipsInfo;
import com.tencent.mobileqq.data.QQEntityManagerFactory;
import com.tencent.mobileqq.model.ChatBackgroundManager;
import com.tencent.mobileqq.msf.sdk.AppNetConnInfo;
import com.tencent.mobileqq.msf.sdk.SettingCloneUtil;
import com.tencent.mobileqq.pb.ByteStringMicro;
import com.tencent.mobileqq.pb.InvalidProtocolBufferMicroException;
import com.tencent.mobileqq.pb.PBBoolField;
import com.tencent.mobileqq.pb.PBBytesField;
import com.tencent.mobileqq.pb.PBEnumField;
import com.tencent.mobileqq.pb.PBRepeatField;
import com.tencent.mobileqq.pb.PBRepeatMessageField;
import com.tencent.mobileqq.pb.PBStringField;
import com.tencent.mobileqq.pb.PBUInt32Field;
import com.tencent.mobileqq.pb.PBUInt64Field;
import com.tencent.mobileqq.persistence.EntityManager;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig;
import com.tencent.mobileqq.upgrade.NewUpgradeConfig.a;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper;
import com.tencent.mobileqq.upgrade.UpgradeDetailWrapper.a;
import com.tencent.mobileqq.vaswebviewplugin.ThemeUiPlugin;
import com.tencent.qphone.base.remote.FromServiceMsg;
import com.tencent.qphone.base.remote.ToServiceMsg;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.util.Pair;
import java.io.File;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import mqq.app.MobileQQ;
import mqq.os.MqqHandler;
import protocol.KQQConfig.GetResourceReqInfo;
import protocol.KQQConfig.GetResourceResp;
import protocol.KQQConfig.GetResourceRespInfo;
import protocol.KQQConfig.UpgradeInfo;
import tencent.im.mobiletips.MobileTips.MobileTipsPkg;
import tencent.im.mobiletips.MobileTips.ReqBody;
import tencent.im.mobiletips.MobileTips.RspBody;
import tencent.im.mobiletips.MobileTips.TaskInfo;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.AuthTips;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.ReqBody;
import tencent.im.oidb.cmd0x9ae.cmd0x9ae.RspBody;
import tencent.im.oidb.oidb_sso.OIDBSSOPkg;
import tencent.im.s2c.msgtype0x210.SubMsgType0x43.UpdateTips;

public class accy
  extends accg
  implements aqap.b
{
  public accy.a a = new accy.a();
  private HashSet<String> aR = new HashSet();
  private volatile boolean bHd;
  private boolean bHe;
  
  public accy(QQAppInterface paramQQAppInterface)
  {
    super(paramQQAppInterface);
  }
  
  private void Dy(String paramString)
  {
    try
    {
      this.aR.remove(paramString);
      return;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public static UpgradeDetailWrapper.a a(UpgradeInfo paramUpgradeInfo)
  {
    if ((paramUpgradeInfo != null) && (paramUpgradeInfo.strProgressName != null))
    {
      paramUpgradeInfo = paramUpgradeInfo.strProgressName;
      if (paramUpgradeInfo != null)
      {
        String[] arrayOfString = paramUpgradeInfo.split("\\|");
        try
        {
          paramUpgradeInfo = new UpgradeDetailWrapper.a();
          return null;
        }
        catch (Exception paramUpgradeInfo)
        {
          try
          {
            paramUpgradeInfo.csi = arrayOfString[2];
            paramUpgradeInfo.csj = arrayOfString[1];
            paramUpgradeInfo.asx = Long.parseLong(arrayOfString[0]);
            paramUpgradeInfo.dYn = Integer.parseInt(arrayOfString[3]);
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
  
  private void a(EntityManager paramEntityManager, GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "get share appid resp info");
    }
    if (paramGetResourceRespInfo.iResult != 0) {
      notifyUI(5, false, null);
    }
    AppShareID localAppShareID;
    do
    {
      return;
      localAppShareID = aqgb.a(paramGetResourceRespInfo);
    } while (localAppShareID == null);
    if (QLog.isColorLevel()) {
      QLog.d("share_appid", 2, "parser share appid from resp info, result:  " + localAppShareID);
    }
    paramGetResourceRespInfo = (AppShareID)paramEntityManager.find(AppShareID.class, "strPkgName=?", new String[] { paramGetResourceRespInfo.strPkgName });
    if (paramGetResourceRespInfo == null)
    {
      paramEntityManager.persist(localAppShareID);
      if (QLog.isColorLevel()) {
        QLog.d("share_appid", 2, "Persist DB appid = " + localAppShareID.strPkgName);
      }
    }
    for (;;)
    {
      this.app.a().a.a(localAppShareID.strPkgName, localAppShareID);
      b(localAppShareID.strResURL_big, this.app.getApplication().getFileStreamPath(localAppShareID.strPkgName));
      notifyUI(5, true, localAppShareID);
      return;
      if (localAppShareID.uiNewVer != paramGetResourceRespInfo.uiNewVer)
      {
        paramEntityManager.remove(paramGetResourceRespInfo);
        paramEntityManager.persist(localAppShareID);
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
  
  public static boolean ac(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences();
    boolean bool2 = false;
    paramQQAppInterface = paramQQAppInterface.getString("UPGRADE_TIPS_DAILY_STR", null);
    boolean bool1 = bool2;
    if (paramQQAppInterface != null)
    {
      bool1 = bool2;
      if (rx().equals(paramQQAppInterface)) {
        bool1 = true;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.isDailyShowTips:" + bool1 + "--> " + paramQQAppInterface);
    }
    return bool1;
  }
  
  public static boolean ad(QQAppInterface paramQQAppInterface)
  {
    return paramQQAppInterface.getPreferences().getBoolean("AUTO_DOWNLOADED_IN_WIFI", false);
  }
  
  public static String ay(Context paramContext)
  {
    paramContext = ((ActivityManager)paramContext.getSystemService("activity")).getRunningTasks(1);
    if ((paramContext != null) && (paramContext.size() > 0) && (((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity != null)) {
      return ((ActivityManager.RunningTaskInfo)paramContext.get(0)).topActivity.getClassName();
    }
    return null;
  }
  
  public static void b(QQAppInterface paramQQAppInterface, byte[] paramArrayOfByte)
  {
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage");
    }
    paramQQAppInterface = new SubMsgType0x43.UpdateTips();
    try
    {
      String str = paramQQAppInterface.bytes_desc.get().toString();
      if (QLog.isColorLevel()) {
        QLog.d("UpgradeController", 2, "ConfigHandler.onReceiverPCUpgradeMessage: " + str);
      }
      paramQQAppInterface.mergeFrom(paramArrayOfByte);
      return;
    }
    catch (InvalidProtocolBufferMicroException paramQQAppInterface) {}
  }
  
  private void b(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if ((paramUpgradeDetailWrapper == null) || (paramUpgradeDetailWrapper.a == null)) {}
    UpgradeInfo localUpgradeInfo;
    label37:
    label344:
    label352:
    do
    {
      Object localObject1;
      do
      {
        return;
        localUpgradeInfo = paramUpgradeDetailWrapper.a;
        int i;
        Object localObject2;
        if ((localUpgradeInfo.iUpgradeType > 0) && (localUpgradeInfo.bNewSwitch == 1))
        {
          i = 1;
          localObject2 = this.app;
          if (i == 0) {
            break label344;
          }
        }
        for (localObject1 = "1";; localObject1 = "0")
        {
          anot.a((QQAppInterface)localObject2, "CliOper", "", "", "0X8004DA5", "0X8004DA5", 0, 0, (String)localObject1, "", aqap.BI(), "");
          localObject1 = this.app.getPreferences();
          localObject2 = ((SharedPreferences)localObject1).edit();
          if (((SharedPreferences)localObject1).getInt("upgrade_timeStamp", 0) < localUpgradeInfo.iNewTimeStamp) {
            ((SharedPreferences.Editor)localObject2).putInt("upgrade_timeStamp", localUpgradeInfo.iNewTimeStamp);
          }
          ((SharedPreferences.Editor)localObject2).commit();
          b(true, paramUpgradeDetailWrapper);
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary iActionType=%s iUpgradeType=%s", new Object[] { Integer.valueOf(localUpgradeInfo.iActionType), Integer.valueOf(localUpgradeInfo.iUpgradeType) }));
          }
          if (localUpgradeInfo.iActionType != 0) {
            break;
          }
          if (localUpgradeInfo.iUpgradeType != 1) {
            cIb();
          }
          if (localUpgradeInfo.iUpgradeType != 2) {
            break label352;
          }
          localObject1 = ay(this.app.getApp());
          if ((localObject1 == null) || (((String)localObject1).equals("com.tencent.mobileqq.activity.UserguideActivity"))) {
            break;
          }
          localObject1 = new Intent();
          ((Intent)localObject1).putExtra("reason_for_upgrade", true);
          ((Intent)localObject1).putExtra("StrTitle", acfp.m(2131704324));
          ((Intent)localObject1).putExtra("StrUpgradeDesc", acfp.m(2131704327));
          ((Intent)localObject1).putExtra("StrUrl", localUpgradeInfo.strNewSoftwareURL);
          ((Intent)localObject1).putExtra(paramUpgradeDetailWrapper.getClass().getSimpleName(), paramUpgradeDetailWrapper);
          dg((Intent)localObject1);
          return;
          i = 0;
          break label37;
        }
        if (localUpgradeInfo.iUpgradeType != 1) {
          break;
        }
        if (aqap.a().getDownloadState() == 4)
        {
          if (QLog.isColorLevel()) {
            QLog.d("UpgradeConfigManager", 2, "showUpgradeIfNecessary apk has been download");
          }
          aqap.a().Sv(true);
          return;
        }
        boolean bool1 = b(this.app, false);
        boolean bool2 = AppNetConnInfo.isWifiConn();
        if (QLog.isColorLevel()) {
          QLog.d("UpgradeConfigManager", 2, String.format("showUpgradeIfNecessary apk has not been download. autoDownloadInWifi=%s isWifiConn=%s", new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2) }));
        }
        localObject1 = aqap.a();
        if (bool1)
        {
          if (bool2)
          {
            ((aqap)localObject1).ecY();
            return;
          }
          ((aqap)localObject1).Sv(true);
          return;
        }
        if ((localUpgradeInfo.iTipsType == 0) || (localUpgradeInfo.iTipsType == 2))
        {
          ((aqap)localObject1).Sv(true);
          return;
        }
        localObject1 = this.app.getHandler(Conversation.class);
      } while (localObject1 == null);
      ((MqqHandler)localObject1).obtainMessage(1134020, paramUpgradeDetailWrapper).sendToTarget();
      return;
    } while (localUpgradeInfo.iUpgradeType != 3);
    c(paramUpgradeDetailWrapper);
  }
  
  private void b(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    do
    {
      return;
      long l1 = aqii.a().eO();
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("JumpWhiteList", 2, "handleJumpWhiteList currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.app.execute(new ConfigHandler.1(this, paramGetResourceRespInfo, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.2(this));
  }
  
  private void b(boolean paramBoolean, UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    notifyUI(4, paramBoolean, paramUpgradeDetailWrapper);
    this.bHd = false;
  }
  
  public static boolean b(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    return paramQQAppInterface.getPreferences().getBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
  }
  
  private void c(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper.b.dialog.cTi)
    {
      arzk.a().S(BaseActivity.sTopActivity, "biz_src_yyb");
      ThreadManager.getUIHandler().postDelayed(new ConfigHandler.11(this), 5000L);
    }
  }
  
  private void c(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    abcy localabcy;
    long l1;
    do
    {
      long l2;
      do
      {
        return;
        localabcy = (abcy)this.app.getManager(114);
        l1 = paramGetResourceRespInfo.uiNewVer;
        l2 = localabcy.eO();
        if (QLog.isColorLevel()) {
          QLog.d("weatherManager", 2, "handleWeatherResources currentVersion: " + l2 + ", serverVersion: " + l1 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
        }
      } while (l1 == l2);
      paramGetResourceRespInfo = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(paramGetResourceRespInfo));
    this.app.execute(new ConfigHandler.3(this, paramGetResourceRespInfo, localabcy, l1));
  }
  
  private void cS(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool9 = false;
    boolean bool10 = false;
    boolean bool11 = false;
    boolean bool8 = false;
    boolean bool1;
    boolean bool2;
    boolean bool7;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      bool1 = true;
      if (QLog.isColorLevel()) {
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig success=" + bool1);
      }
      bool2 = bool1;
      bool7 = bool9;
      if (bool1)
      {
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
      }
    }
    for (;;)
    {
      try
      {
        paramFromServiceMsg = (oidb_sso.OIDBSSOPkg)new oidb_sso.OIDBSSOPkg().mergeFrom((byte[])paramObject);
        if (paramFromServiceMsg == null) {
          continue;
        }
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (paramFromServiceMsg.uint32_result.get() != 0) {
          continue;
        }
        bool1 = true;
        bool3 = bool1;
        bool4 = bool10;
        bool5 = bool1;
        bool6 = bool11;
        if (QLog.isColorLevel())
        {
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool1);
        }
        bool2 = bool1;
        bool7 = bool9;
        if (bool1)
        {
          bool2 = bool1;
          bool7 = bool9;
          bool3 = bool1;
          bool4 = bool10;
          bool5 = bool1;
          bool6 = bool11;
          if (paramFromServiceMsg.bytes_bodybuffer.has())
          {
            bool2 = bool1;
            bool7 = bool9;
            bool3 = bool1;
            bool4 = bool10;
            bool5 = bool1;
            bool6 = bool11;
            if (paramFromServiceMsg.bytes_bodybuffer.get() != null)
            {
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              paramFromServiceMsg = ByteBuffer.wrap(paramFromServiceMsg.bytes_bodybuffer.get().toByteArray());
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int i = paramFromServiceMsg.getShort();
              bool3 = bool1;
              bool4 = bool10;
              bool5 = bool1;
              bool6 = bool11;
              int j = paramFromServiceMsg.getShort();
              bool2 = bool1;
              bool7 = bool9;
              if (i == 16)
              {
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramObject = new byte[j];
                bool3 = bool1;
                bool4 = bool10;
                bool5 = bool1;
                bool6 = bool11;
                paramFromServiceMsg.get(paramObject);
                bool2 = bool8;
                if ((paramObject[16] & 0x1) > 0) {
                  bool2 = true;
                }
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                SettingCloneUtil.writeValue(this.app.getApplication(), paramToServiceMsg.getUin(), null, "pcactive_config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.app.openMsfPCActive(paramToServiceMsg.getUin(), "config", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                QLog.d("ConfigHandler", 1, "PCActive opened: " + bool2 + " by config");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg = new Intent("com.tencent.mobileqq.activity.NotifyPushSettingActivity.ConfigPCActive");
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("configPCActive", bool2);
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                paramFromServiceMsg.putExtra("uin", paramToServiceMsg.getUin());
                bool3 = bool1;
                bool4 = bool2;
                bool5 = bool1;
                bool6 = bool2;
                this.app.getApp().sendBroadcast(paramFromServiceMsg);
                bool7 = bool2;
                bool2 = bool1;
              }
            }
          }
        }
        return;
      }
      catch (Exception paramToServiceMsg)
      {
        bool5 = bool3;
        bool6 = bool4;
        if (!QLog.isColorLevel()) {
          continue;
        }
        bool5 = bool3;
        bool6 = bool4;
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig ex", paramToServiceMsg);
        return;
      }
      finally
      {
        if (!QLog.isColorLevel()) {
          continue;
        }
        QLog.d("ConfigHandler", 2, "handleGetPCActiveConfig result=" + bool5 + ";allow=" + bool6);
      }
      bool1 = false;
      break;
      bool1 = false;
    }
  }
  
  /* Error */
  private void cT(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aconst_null
    //   4: astore 11
    //   6: aconst_null
    //   7: astore 10
    //   9: aconst_null
    //   10: astore 9
    //   12: aload_2
    //   13: invokevirtual 612	com/tencent/qphone/base/remote/FromServiceMsg:isSuccess	()Z
    //   16: ifeq +187 -> 203
    //   19: aload_3
    //   20: ifnull +183 -> 203
    //   23: iconst_1
    //   24: istore 8
    //   26: iload 8
    //   28: ifne +181 -> 209
    //   31: aconst_null
    //   32: astore_1
    //   33: aconst_null
    //   34: astore_2
    //   35: aconst_null
    //   36: astore_3
    //   37: iload 8
    //   39: ifne +670 -> 709
    //   42: iconst_1
    //   43: istore 6
    //   45: ldc 226
    //   47: iconst_1
    //   48: new 119	java/lang/StringBuilder
    //   51: dup
    //   52: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   55: ldc_w 702
    //   58: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: iload 8
    //   63: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   66: ldc_w 704
    //   69: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: iload 6
    //   74: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   77: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   83: aload_0
    //   84: iload 6
    //   86: putfield 706	accy:bHe	Z
    //   89: iload 6
    //   91: ifne +98 -> 189
    //   94: getstatic 712	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   97: invokevirtual 716	com/tencent/common/app/BaseApplicationImpl:getResources	()Landroid/content/res/Resources;
    //   100: pop
    //   101: new 387	android/content/Intent
    //   104: dup
    //   105: invokespecial 388	android/content/Intent:<init>	()V
    //   108: astore 12
    //   110: aload 12
    //   112: ldc_w 718
    //   115: iconst_1
    //   116: invokevirtual 394	android/content/Intent:putExtra	(Ljava/lang/String;Z)Landroid/content/Intent;
    //   119: pop
    //   120: aload 12
    //   122: ldc_w 396
    //   125: aload 11
    //   127: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   130: pop
    //   131: aload 12
    //   133: ldc_w 408
    //   136: aload 10
    //   138: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   141: pop
    //   142: aload 12
    //   144: ldc_w 720
    //   147: aload 9
    //   149: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   152: pop
    //   153: aload 12
    //   155: ldc_w 722
    //   158: aload_2
    //   159: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   162: pop
    //   163: aload 12
    //   165: ldc_w 724
    //   168: aload_1
    //   169: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   172: pop
    //   173: aload 12
    //   175: ldc_w 726
    //   178: aload_3
    //   179: invokevirtual 406	android/content/Intent:putExtra	(Ljava/lang/String;Ljava/lang/String;)Landroid/content/Intent;
    //   182: pop
    //   183: aload_0
    //   184: aload 12
    //   186: invokespecial 430	accy:dg	(Landroid/content/Intent;)V
    //   189: aload_0
    //   190: bipush 11
    //   192: iload 8
    //   194: iload 6
    //   196: invokestatic 459	java/lang/Boolean:valueOf	(Z)Ljava/lang/Boolean;
    //   199: invokevirtual 112	accy:notifyUI	(IZLjava/lang/Object;)V
    //   202: return
    //   203: iconst_0
    //   204: istore 8
    //   206: goto -180 -> 26
    //   209: aload_3
    //   210: checkcast 728	MAAccessClient/AccessRsp
    //   213: astore 14
    //   215: aload 14
    //   217: getfield 731	MAAccessClient/AccessRsp:ret	I
    //   220: istore 4
    //   222: iload 4
    //   224: iconst_1
    //   225: if_icmpne +15 -> 240
    //   228: iconst_1
    //   229: istore 5
    //   231: aconst_null
    //   232: astore_1
    //   233: aconst_null
    //   234: astore_2
    //   235: aconst_null
    //   236: astore_3
    //   237: goto -200 -> 37
    //   240: iload 4
    //   242: ifeq +15 -> 257
    //   245: iconst_1
    //   246: istore 5
    //   248: aconst_null
    //   249: astore_1
    //   250: aconst_null
    //   251: astore_2
    //   252: aconst_null
    //   253: astore_3
    //   254: goto -217 -> 37
    //   257: aload 14
    //   259: getfield 734	MAAccessClient/AccessRsp:body	[B
    //   262: ifnull +489 -> 751
    //   265: aload 14
    //   267: getfield 734	MAAccessClient/AccessRsp:body	[B
    //   270: arraylength
    //   271: ifle +480 -> 751
    //   274: new 736	com/qq/taf/jce/JceInputStream
    //   277: dup
    //   278: aload 14
    //   280: getfield 734	MAAccessClient/AccessRsp:body	[B
    //   283: invokespecial 739	com/qq/taf/jce/JceInputStream:<init>	([B)V
    //   286: astore_2
    //   287: new 741	MAAccessClient/CheckSinglePkgSigRsp
    //   290: dup
    //   291: invokespecial 742	MAAccessClient/CheckSinglePkgSigRsp:<init>	()V
    //   294: astore_1
    //   295: aload_1
    //   296: aload_2
    //   297: invokevirtual 746	MAAccessClient/CheckSinglePkgSigRsp:readFrom	(Lcom/qq/taf/jce/JceInputStream;)V
    //   300: aload_1
    //   301: ifnull +28 -> 329
    //   304: aload_1
    //   305: getfield 747	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   308: iconst_1
    //   309: if_icmpeq +20 -> 329
    //   312: aload_1
    //   313: getfield 747	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   316: iconst_m1
    //   317: if_icmpeq +12 -> 329
    //   320: aload_1
    //   321: getfield 747	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   324: bipush 100
    //   326: if_icmpne +21 -> 347
    //   329: iconst_1
    //   330: istore 5
    //   332: aconst_null
    //   333: astore_1
    //   334: aconst_null
    //   335: astore_2
    //   336: aconst_null
    //   337: astore_3
    //   338: goto -301 -> 37
    //   341: astore_1
    //   342: aconst_null
    //   343: astore_1
    //   344: goto -44 -> 300
    //   347: aload_1
    //   348: getfield 747	MAAccessClient/CheckSinglePkgSigRsp:ret	I
    //   351: ifne +346 -> 697
    //   354: aload_1
    //   355: getfield 751	MAAccessClient/CheckSinglePkgSigRsp:vtMarket	Ljava/util/ArrayList;
    //   358: ifnull +387 -> 745
    //   361: aload_1
    //   362: getfield 751	MAAccessClient/CheckSinglePkgSigRsp:vtMarket	Ljava/util/ArrayList;
    //   365: invokevirtual 757	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   368: astore_2
    //   369: iconst_0
    //   370: istore 5
    //   372: iload 5
    //   374: istore 7
    //   376: aload_2
    //   377: invokeinterface 762 1 0
    //   382: ifeq +154 -> 536
    //   385: aload_2
    //   386: invokeinterface 766 1 0
    //   391: checkcast 768	MAAccessClient/NoCheckMarket
    //   394: astore_3
    //   395: iload 5
    //   397: istore 7
    //   399: aload_3
    //   400: getfield 771	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   403: invokestatic 520	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   406: ifne +284 -> 690
    //   409: iload 5
    //   411: istore 6
    //   413: iload 5
    //   415: ifne +23 -> 438
    //   418: getstatic 712	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   421: aload_3
    //   422: getfield 771	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   425: aload_3
    //   426: getfield 774	MAAccessClient/NoCheckMarket:versionCode	I
    //   429: aload_3
    //   430: getfield 777	MAAccessClient/NoCheckMarket:signatureMd5	Ljava/lang/String;
    //   433: invokestatic 782	atae:c	(Landroid/content/Context;Ljava/lang/String;ILjava/lang/String;)Z
    //   436: istore 6
    //   438: invokestatic 785	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   441: ifeq +45 -> 486
    //   444: ldc 226
    //   446: iconst_4
    //   447: new 119	java/lang/StringBuilder
    //   450: dup
    //   451: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   454: ldc_w 787
    //   457: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   460: aload_3
    //   461: getfield 771	MAAccessClient/NoCheckMarket:pkgName	Ljava/lang/String;
    //   464: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   467: ldc_w 789
    //   470: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: aload_3
    //   474: getfield 774	MAAccessClient/NoCheckMarket:versionCode	I
    //   477: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   480: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   483: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   486: iload 6
    //   488: istore 7
    //   490: iload 6
    //   492: ifeq +198 -> 690
    //   495: iload 6
    //   497: istore 7
    //   499: invokestatic 785	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   502: ifeq +34 -> 536
    //   505: ldc 226
    //   507: iconst_4
    //   508: new 119	java/lang/StringBuilder
    //   511: dup
    //   512: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   515: ldc_w 787
    //   518: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   521: iload 6
    //   523: invokevirtual 231	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   526: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   529: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   532: iload 6
    //   534: istore 7
    //   536: aload_1
    //   537: getfield 792	MAAccessClient/CheckSinglePkgSigRsp:pkgSig	Ljava/lang/String;
    //   540: astore 13
    //   542: aload_1
    //   543: getfield 795	MAAccessClient/CheckSinglePkgSigRsp:tmastUrl	Ljava/lang/String;
    //   546: astore 12
    //   548: aload_1
    //   549: getfield 798	MAAccessClient/CheckSinglePkgSigRsp:pageUrl	Ljava/lang/String;
    //   552: astore_2
    //   553: aload_1
    //   554: getfield 801	MAAccessClient/CheckSinglePkgSigRsp:sigVersionCode	I
    //   557: istore 4
    //   559: new 119	java/lang/StringBuilder
    //   562: dup
    //   563: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   566: aload_2
    //   567: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   570: ldc_w 803
    //   573: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   576: iload 4
    //   578: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   581: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   584: astore 10
    //   586: invokestatic 785	com/tencent/qphone/base/util/QLog:isDevelopLevel	()Z
    //   589: ifeq +41 -> 630
    //   592: ldc 226
    //   594: iconst_4
    //   595: new 119	java/lang/StringBuilder
    //   598: dup
    //   599: invokespecial 120	java/lang/StringBuilder:<init>	()V
    //   602: ldc_w 805
    //   605: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   608: aload 13
    //   610: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   613: ldc_w 789
    //   616: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   619: iload 4
    //   621: invokevirtual 511	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   624: invokevirtual 133	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   627: invokestatic 103	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   630: aload 14
    //   632: getfield 809	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   635: ifnull +101 -> 736
    //   638: aload 14
    //   640: getfield 809	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   643: getfield 814	MAAccessClient/Tips:title	Ljava/lang/String;
    //   646: astore_3
    //   647: aload 14
    //   649: getfield 809	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   652: getfield 817	MAAccessClient/Tips:content	Ljava/lang/String;
    //   655: astore_2
    //   656: aload 14
    //   658: getfield 809	MAAccessClient/AccessRsp:tips	LMAAccessClient/Tips;
    //   661: getfield 820	MAAccessClient/Tips:button	Ljava/lang/String;
    //   664: astore_1
    //   665: aload_1
    //   666: astore 9
    //   668: iload 7
    //   670: istore 5
    //   672: aload 10
    //   674: astore_1
    //   675: aload_2
    //   676: astore 10
    //   678: aload_3
    //   679: astore 11
    //   681: aload 12
    //   683: astore_2
    //   684: aload 13
    //   686: astore_3
    //   687: goto -650 -> 37
    //   690: iload 7
    //   692: istore 5
    //   694: goto -322 -> 372
    //   697: iconst_1
    //   698: istore 5
    //   700: aconst_null
    //   701: astore_1
    //   702: aconst_null
    //   703: astore_2
    //   704: aconst_null
    //   705: astore_3
    //   706: goto -669 -> 37
    //   709: iload 5
    //   711: istore 6
    //   713: iload 5
    //   715: ifeq -670 -> 45
    //   718: getstatic 712	com/tencent/common/app/BaseApplicationImpl:sApplication	Lcom/tencent/common/app/BaseApplicationImpl;
    //   721: invokestatic 824	atae:cw	(Landroid/content/Context;)Z
    //   724: pop
    //   725: iload 5
    //   727: istore 6
    //   729: goto -684 -> 45
    //   732: astore_2
    //   733: goto -389 -> 344
    //   736: aconst_null
    //   737: astore_1
    //   738: aconst_null
    //   739: astore_2
    //   740: aconst_null
    //   741: astore_3
    //   742: goto -77 -> 665
    //   745: iconst_0
    //   746: istore 7
    //   748: goto -212 -> 536
    //   751: aconst_null
    //   752: astore_1
    //   753: goto -453 -> 300
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	756	0	this	accy
    //   0	756	1	paramToServiceMsg	ToServiceMsg
    //   0	756	2	paramFromServiceMsg	FromServiceMsg
    //   0	756	3	paramObject	Object
    //   220	400	4	i	int
    //   1	725	5	bool1	boolean
    //   43	685	6	bool2	boolean
    //   374	373	7	bool3	boolean
    //   24	181	8	bool4	boolean
    //   10	657	9	localObject1	Object
    //   7	670	10	localObject2	Object
    //   4	676	11	localObject3	Object
    //   108	574	12	localObject4	Object
    //   540	145	13	str	String
    //   213	444	14	localAccessRsp	AccessRsp
    // Exception table:
    //   from	to	target	type
    //   274	295	341	java/lang/Exception
    //   295	300	732	java/lang/Exception
  }
  
  private void cU(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = false;
    String str2 = paramToServiceMsg.extraData.getString("rid");
    String str1 = "";
    int i;
    boolean bool1;
    if ((paramFromServiceMsg.isSuccess()) && (paramObject != null))
    {
      i = 1;
      if (i != 0) {
        break label136;
      }
      bool1 = bool2;
      paramToServiceMsg = str1;
    }
    label136:
    label178:
    do
    {
      for (;;)
      {
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode:" + bool1 + ", " + str2 + ", code:" + paramToServiceMsg);
        }
        notifyUI(10, bool1, new Pair(paramToServiceMsg, str2));
        aqap.a().B(bool1, str2, paramToServiceMsg);
        return;
        i = 0;
        break;
        paramFromServiceMsg = (AccessRsp)paramObject;
        i = paramFromServiceMsg.ret;
        if (i != 1) {
          break label178;
        }
        if (QLog.isDevelopLevel()) {
          QLog.d("UpgradeController", 4, "handleGetAuthCode not supported");
        }
        paramToServiceMsg = "";
        bool1 = true;
      }
      paramToServiceMsg = str1;
      bool1 = bool2;
    } while (i != 0);
    if ((paramFromServiceMsg.body != null) && (paramFromServiceMsg.body.length > 0)) {}
    for (;;)
    {
      try
      {
        paramToServiceMsg = new JceInputStream(paramFromServiceMsg.body);
        paramFromServiceMsg = new GetSinglePkgSigRsp();
      }
      catch (Exception paramToServiceMsg)
      {
        try
        {
          paramFromServiceMsg.readFrom(paramToServiceMsg);
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg == null) {
            break;
          }
          paramToServiceMsg = str1;
          bool1 = bool2;
          if (paramFromServiceMsg.ret != 0) {
            break;
          }
          paramToServiceMsg = paramFromServiceMsg.pkgSig;
          bool1 = true;
          break;
          paramToServiceMsg = paramToServiceMsg;
          paramFromServiceMsg = null;
          continue;
        }
        catch (Exception paramToServiceMsg)
        {
          continue;
        }
      }
      paramFromServiceMsg = null;
    }
  }
  
  private void cV(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    if ((paramFromServiceMsg == null) || (paramObject == null)) {}
    for (;;)
    {
      return;
      int i = ((Integer)paramToServiceMsg.getAttribute("serviceType", Integer.valueOf(2))).intValue();
      paramToServiceMsg = new cmd0x9ae.RspBody();
      int j = parseOIDBPkg(paramFromServiceMsg, paramObject, paramToServiceMsg);
      boolean bool1;
      label68:
      boolean bool2;
      if (j == 0)
      {
        if (paramToServiceMsg.bool_has_been_authenticated.has())
        {
          bool1 = paramToServiceMsg.bool_has_been_authenticated.get();
          if (!paramToServiceMsg.bool_need_auth_tips.has()) {
            break label321;
          }
          bool2 = paramToServiceMsg.bool_need_auth_tips.get();
          label87:
          if (!paramToServiceMsg.msg_auth_tips.has()) {
            break label327;
          }
          paramObject = (cmd0x9ae.AuthTips)paramToServiceMsg.msg_auth_tips.get();
          label108:
          this.app.getPreferences().edit().putBoolean("has_auth_real_name", bool1).commit();
          if (i != 2) {
            break label438;
          }
          if (paramObject == null) {
            break label353;
          }
          if (!paramObject.string_tips_title.has()) {
            break label332;
          }
          paramToServiceMsg = paramObject.string_tips_title.get();
          label164:
          if (!paramObject.string_tips_context.has()) {
            break label339;
          }
          paramFromServiceMsg = paramObject.string_tips_context.get();
          label182:
          if (!paramObject.string_tips_action_url.has()) {
            break label346;
          }
        }
        label321:
        label327:
        label332:
        label339:
        label346:
        for (paramObject = paramObject.string_tips_action_url.get();; paramObject = "")
        {
          notifyUI(13, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), paramToServiceMsg, paramFromServiceMsg, paramObject });
          if (!QLog.isColorLevel()) {
            break;
          }
          QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + bool1 + "|" + bool2 + "|" + paramToServiceMsg + "|" + paramFromServiceMsg + "|" + paramObject);
          return;
          bool1 = true;
          break label68;
          bool2 = false;
          break label87;
          paramObject = null;
          break label108;
          paramToServiceMsg = "";
          break label164;
          paramFromServiceMsg = "";
          break label182;
        }
        label353:
        QLog.i("RealName", 2, "handleGetRealNameStatus, authTips is null " + bool1 + " " + bool2);
      }
      while (QLog.isColorLevel())
      {
        QLog.i("RealName", 2, "handleGetRealNameStatus, result is: " + j + " serviceType:" + i);
        return;
        label438:
        if (i == 10)
        {
          Object localObject = "";
          paramFromServiceMsg = "";
          paramToServiceMsg = "";
          if (paramObject != null)
          {
            if (!paramObject.string_tips_title.has()) {
              break label672;
            }
            paramFromServiceMsg = paramObject.string_tips_title.get();
            label480:
            if (!paramObject.string_tips_context.has()) {
              break label679;
            }
            paramToServiceMsg = paramObject.string_tips_context.get();
            label498:
            if (!paramObject.string_tips_action_url.has()) {
              break label686;
            }
          }
          for (paramObject = paramObject.string_tips_action_url.get();; paramObject = "")
          {
            localObject = paramFromServiceMsg;
            paramFromServiceMsg = paramToServiceMsg;
            paramToServiceMsg = paramObject;
            paramObject = (afwh)this.app.getManager(292);
            paramObject.IE(bool1);
            paramObject.h(bool2, (String)localObject, paramFromServiceMsg, paramToServiceMsg);
            notifyUI(14, true, new Object[] { Boolean.valueOf(bool1), Boolean.valueOf(bool2), localObject, paramFromServiceMsg, paramToServiceMsg });
            if (!QLog.isColorLevel()) {
              break;
            }
            QLog.i("RealName", 2, "handleGetRealNameStatus value is: " + bool1 + "|" + bool2 + "|" + (String)localObject + "|" + paramFromServiceMsg + "|" + paramToServiceMsg);
            break;
            paramFromServiceMsg = "";
            break label480;
            paramToServiceMsg = "";
            break label498;
          }
        }
        label672:
        label679:
        label686:
        if (i == 12)
        {
          if (QLog.isColorLevel()) {
            QLog.i("RealName", 2, "handleGetRealNameStatus type=12, value is: " + bool1);
          }
          this.app.getPreferences().edit().putBoolean("has_auth_real_name_av", bool1).putBoolean("has_request_auth_real_name_av", true).commit();
          notifyUI(15, true, new Object[] { Boolean.valueOf(bool1) });
          continue;
          if (i == 10) {
            notifyUI(14, false, new Object[] { Boolean.valueOf(false), Boolean.valueOf(false), "", "", "" });
          } else if (i == 12) {
            notifyUI(15, false, new Object[] { Boolean.valueOf(false) });
          }
        }
      }
    }
  }
  
  public static void cn(QQAppInterface paramQQAppInterface)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putString("UPGRADE_TIPS_DAILY_STR", rx());
    paramQQAppInterface.commit();
  }
  
  private void d(GetResourceRespInfo paramGetResourceRespInfo)
  {
    agmy.ces = true;
    if (paramGetResourceRespInfo.iResult == -2) {}
    while (paramGetResourceRespInfo.iResult == 0)
    {
      String str = paramGetResourceRespInfo.strResURL_big;
      if ((str != null) && (str.length() > 0)) {
        this.app.execute(new ConfigHandler.4(this, str, paramGetResourceRespInfo));
      }
      return;
    }
  }
  
  private void dg(Intent paramIntent)
  {
    paramIntent.putExtra("logout_intent", true);
    ThemeUiPlugin.destroy(this.app);
    ChatBackgroundManager.destroy();
    this.app.logout(true);
    if (BaseApplicationImpl.sImageCache != null) {
      BaseApplicationImpl.sImageCache.evictAll();
    }
    BaseActivity localBaseActivity = BaseActivity.sTopActivity;
    Object localObject = localBaseActivity;
    if (localBaseActivity == null)
    {
      localObject = BaseApplication.getContext();
      paramIntent.addFlags(268435456);
    }
    paramIntent.setClass((Context)localObject, LoginActivity.class);
    ((Context)localObject).startActivity(paramIntent);
  }
  
  private void e(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo.iResult != 0) {
      notifyUI(1, false, paramGetResourceRespInfo);
    }
    String str;
    do
    {
      return;
      str = paramGetResourceRespInfo.strResURL_big;
    } while ((str == null) || (str.length() <= 0));
    this.app.execute(new ConfigHandler.5(this, str, paramGetResourceRespInfo));
  }
  
  private void f(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("Q.richstatus.xml", 2, "ConfigHandler.handleUpdateStatusActions, result is " + paramGetResourceRespInfo.iResult + ", server version:" + paramGetResourceRespInfo.uiNewVer);
    }
    if (paramGetResourceRespInfo.iResult == -2) {
      notifyUI(7, true, Integer.valueOf(100));
    }
    amhj localamhj;
    do
    {
      return;
      if (paramGetResourceRespInfo.iResult != 0)
      {
        notifyUI(7, false, Integer.valueOf(-1));
        return;
      }
      localamhj = (amhj)this.app.getManager(15);
    } while (localamhj == null);
    if (!localamhj.cE(paramGetResourceRespInfo.uiNewVer))
    {
      notifyUI(7, true, Integer.valueOf(100));
      return;
    }
    String str = paramGetResourceRespInfo.strResURL_big;
    if (TextUtils.isEmpty(str))
    {
      if (QLog.isColorLevel()) {
        QLog.w("Q.richstatus.xml", 2, "url is empty");
      }
      notifyUI(7, false, Integer.valueOf(-1));
      return;
    }
    this.app.execute(new ConfigHandler.6(this, str, localamhj, paramGetResourceRespInfo));
  }
  
  public static String g(QQAppInterface paramQQAppInterface, int paramInt)
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
  
  private void g(GetResourceRespInfo paramGetResourceRespInfo)
  {
    if (paramGetResourceRespInfo == null) {}
    long l2;
    String str;
    do
    {
      return;
      long l1 = this.app.getPreferences().getLong("k_eggs_file_version", 0L);
      l2 = paramGetResourceRespInfo.uiNewVer;
      if (QLog.isColorLevel()) {
        QLog.d("eggs", 2, "handleUpdateEggsActions currentVersion: " + l1 + ", serverVersion: " + l2 + ",iResult: " + paramGetResourceRespInfo.iResult + ", bigUrl: " + paramGetResourceRespInfo.strResURL_big);
      }
      if (l2 == l1) {
        break;
      }
      str = paramGetResourceRespInfo.strResURL_big;
    } while (TextUtils.isEmpty(str));
    this.app.execute(new ConfigHandler.7(this, paramGetResourceRespInfo, str, l2));
    return;
    ThreadManager.getFileThreadHandler().post(new ConfigHandler.8(this, paramGetResourceRespInfo));
  }
  
  public static boolean j(QQAppInterface paramQQAppInterface, int paramInt)
  {
    return paramInt == paramQQAppInterface.getPreferences().getInt("NEW_ICON_TIMESTAMP", -1);
  }
  
  private boolean l(String paramString, long paramLong)
  {
    boolean bool2 = true;
    boolean bool1 = true;
    if (paramString == null) {
      bool2 = bool1;
    }
    do
    {
      return bool2;
      DeviceProfileManager localDeviceProfileManager = DeviceProfileManager.a();
      bool1 = bool2;
      if ("eggs_android_CI_4.7.1".equals(paramString))
      {
        bool1 = bool2;
        if (!localDeviceProfileManager.m(DeviceProfileManager.DpcNames.aio_eggs.name(), paramLong))
        {
          aqhq.deleteFile(new File(this.app.getApplication().getFilesDir(), "eggs_config.zip").getAbsolutePath());
          aqhq.deleteFile(wne.aTu);
          bool1 = false;
          wne.a().dj(this.app.getApplication());
          this.app.getPreferences().edit().putLong("k_eggs_file_version", 0L).commit();
        }
      }
      bool2 = bool1;
    } while (!QLog.isColorLevel());
    QLog.d("ConfigHandler", 2, "str=" + paramString + ", isFeatureSupport=" + bool1);
    return bool1;
  }
  
  public static void m(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("NEW_ICON_TIMESTAMP", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void m(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
  {
    Object localObject = paramQQAppInterface.getPreferences();
    String str = ((SharedPreferences)localObject).getString("UPGRADE_TIPS_URL", null);
    if ((str != null) && (paramInt >= 0))
    {
      if (str.equals(paramString)) {
        return;
      }
      n(paramQQAppInterface, 0);
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
  
  public static void n(QQAppInterface paramQQAppInterface, int paramInt)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putInt("UPGRADE_TIPS_SHOW_COUNT", paramInt);
    paramQQAppInterface.commit();
  }
  
  public static void n(QQAppInterface paramQQAppInterface, String paramString, int paramInt)
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
  
  private static String rx()
  {
    Date localDate = new Date();
    int i = localDate.getYear();
    int j = localDate.getMonth();
    int k = localDate.getDay();
    return i + ":" + j + ":" + k;
  }
  
  public static void t(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    QLog.d("UpgradeController", 1, String.format("setUpgradeAutoDownloadInWifi isAuto=%s", new Object[] { Boolean.valueOf(paramBoolean) }));
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("UPGRADE_AUTO_DOWNLOAD_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
  }
  
  public static void u(QQAppInterface paramQQAppInterface, boolean paramBoolean)
  {
    paramQQAppInterface = paramQQAppInterface.getPreferences().edit();
    paramQQAppInterface.putBoolean("AUTO_DOWNLOADED_IN_WIFI", paramBoolean);
    paramQQAppInterface.commit();
    if (QLog.isColorLevel()) {
      QLog.d("preLoad_configServlet", 2, "is auto download : " + paramBoolean);
    }
  }
  
  public static int z(QQAppInterface paramQQAppInterface)
  {
    int i = paramQQAppInterface.getPreferences().getInt("UPGRADE_TIPS_SHOW_COUNT", 0);
    if (QLog.isColorLevel()) {
      QLog.d("UpgradeController", 2, "ConfigHandler.getUpgradeTipsShowCount:" + i);
    }
    return i;
  }
  
  public boolean ZM()
  {
    boolean bool = atae.cx(BaseApplicationImpl.sApplication);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary preCheck:" + bool);
    }
    this.bHe = bool;
    if (bool) {
      return false;
    }
    Object localObject1 = null;
    try
    {
      localObject2 = ataa.z(new File(BaseApplicationImpl.sApplication.getPackageResourcePath()));
      localObject1 = localObject2;
    }
    catch (Exception localException)
    {
      Object localObject2;
      label71:
      break label71;
    }
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "checkAuthIfNeccessary forCode:" + localObject1);
    }
    localObject2 = createToServiceMsg("MAAControl.CheckSinglePkgSig");
    ((ToServiceMsg)localObject2).extraData.putString("ac", localObject1);
    ((ToServiceMsg)localObject2).extraData.putInt("mv", aewh.getVersionCode(this.app.getApp()));
    ((ToServiceMsg)localObject2).extraData.putInt("sv", aqgz.getOsVersion());
    send((ToServiceMsg)localObject2);
    return true;
  }
  
  public boolean ZN()
  {
    boolean bool = this.app.getPreferences().getBoolean("has_auth_real_name", false);
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "hasAuthRealName " + bool);
    }
    if (bool) {
      return true;
    }
    ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 10, new cmd0x9ae.ReqBody().toByteArray());
    localToServiceMsg.addAttribute("serviceType", Integer.valueOf(10));
    sendPbReq(localToServiceMsg);
    return false;
  }
  
  public boolean ZO()
  {
    Object localObject = this.app.getPreferences();
    boolean bool1 = ((SharedPreferences)localObject).getBoolean("has_auth_real_name_av", false);
    boolean bool2 = ((SharedPreferences)localObject).getBoolean("has_request_auth_real_name_av", false);
    if (QLog.isColorLevel()) {
      QLog.i("RealName", 2, "hasAuthRealNameForAv " + bool1 + " " + bool2);
    }
    if (bool1) {}
    do
    {
      return true;
      localObject = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 12, new cmd0x9ae.ReqBody().toByteArray());
      ((ToServiceMsg)localObject).addAttribute("serviceType", Integer.valueOf(12));
      sendPbReq((ToServiceMsg)localObject);
    } while (!bool2);
    return false;
  }
  
  public int a(ArrayList<GetResourceReqInfo> paramArrayList, GetResourceReqInfo... paramVarArgs)
  {
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
    int j = paramVarArgs.length;
    boolean bool1 = bool2;
    int i = 0;
    while (i < j)
    {
      paramArrayList = paramVarArgs[i];
      bool2 = bool1;
      if (paramArrayList != null)
      {
        if (paramArrayList.strPkgName.equals("QQAddFriend.AdministrateRegion")) {
          bool1 = true;
        }
        localArrayList.add(paramArrayList);
        bool2 = bool1;
      }
      i += 1;
      bool1 = bool2;
    }
    if (localArrayList.size() <= 0) {
      return -1;
    }
    paramArrayList = createToServiceMsg("ResourceConfig.GetResourceReq");
    paramArrayList.extraData.putSerializable("getResourceReqInfos", localArrayList);
    paramArrayList.extraData.putBoolean("reqRegionConfig", bool1);
    i = amzq.seq;
    amzq.seq = i + 1;
    paramArrayList.setAppSeq(i);
    if (QLog.isColorLevel()) {
      QLog.d("updateConfigs", 2, String.format("updateConfigs reqRegionConfig!, AppSeq[%s]", new Object[] { Integer.valueOf(paramArrayList.getAppSeq()) }));
    }
    send(paramArrayList);
    return paramArrayList.getAppSeq();
  }
  
  public GetResourceReqInfo a()
  {
    long l = this.app.getPreferences().getLong("k_eggs_file_version", 0L);
    if (QLog.isColorLevel()) {
      QLog.d("eggs", 2, "getEggsInfo curVersion: " + l);
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "eggs_android_CI_4.7.1";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void a(int paramInt, UpgradeDetailWrapper paramUpgradeDetailWrapper, aqap paramaqap)
  {
    paramaqap = paramUpgradeDetailWrapper.a;
    if ((paramInt == 0) && (paramaqap != null))
    {
      BaseApplicationImpl.sApplication.getPackageName();
      a(paramaqap);
      m(this.app, paramaqap.strNewTipsDescURL, paramaqap.iTipsWaitDay);
      n(this.app, paramaqap.strBannerPicUrl, paramaqap.iDisplayDay);
      b(paramUpgradeDetailWrapper);
      return;
    }
    b(true, paramUpgradeDetailWrapper);
  }
  
  public void a(UpgradeDetailWrapper paramUpgradeDetailWrapper)
  {
    if (paramUpgradeDetailWrapper != null)
    {
      paramUpgradeDetailWrapper.a = new UpgradeInfo();
      b(false, paramUpgradeDetailWrapper);
    }
  }
  
  public void a(String paramString, int paramInt, ArrayList<aevh> paramArrayList, boolean paramBoolean)
  {
    if (TextUtils.isEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      try
      {
        Long.parseLong(paramString);
        MobileTips.MobileTipsPkg localMobileTipsPkg = new MobileTips.MobileTipsPkg();
        if (paramInt == 3000)
        {
          i = 2;
          localMobileTipsPkg.req.peer_type.set(i);
          localMobileTipsPkg.req.peer_uin.set(Long.parseLong(paramString));
          if (paramArrayList != null)
          {
            ArrayList localArrayList = new ArrayList();
            paramArrayList = paramArrayList.iterator();
            if (paramArrayList.hasNext())
            {
              aevh localaevh = (aevh)paramArrayList.next();
              MobileTips.TaskInfo localTaskInfo = new MobileTips.TaskInfo();
              localTaskInfo.task_id.set(localaevh.taskId);
              localTaskInfo.msgcnt.set(localaevh.cPr);
              localTaskInfo.keywords.set(localaevh.vQ);
              localTaskInfo.setHasFlag(true);
              localArrayList.add(localTaskInfo);
              continue;
            }
            localMobileTipsPkg.req.task_list.set(localArrayList);
          }
          localMobileTipsPkg.req.setHasFlag(true);
          localMobileTipsPkg.rsp.setHasFlag(true);
          localMobileTipsPkg.setHasFlag(true);
          paramArrayList = new ToServiceMsg("mobileqq.service", this.app.getCurrentAccountUin(), "MobileTipsSvc.TipsReport");
          paramArrayList.extraData.putBoolean("isRetry", paramBoolean);
          paramArrayList.extraData.putString("chatuin", paramString);
          paramArrayList.extraData.putInt("chattype", paramInt);
          paramArrayList.putWupBuffer(localMobileTipsPkg.toByteArray());
          sendPbReq(paramArrayList);
          return;
        }
      }
      catch (NumberFormatException paramString)
      {
        return;
      }
      int i = 1;
    }
  }
  
  public GetResourceReqInfo b()
  {
    long l = this.app.getPreferences().getLong("k_voice_notify2_file_version", 0L);
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
  
  public void b(String paramString, int paramInt, ArrayList<QQOperationViopTipTask> paramArrayList)
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
    Object localObject2 = aeve.a(this.app);
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      QQOperationViopTipTask localQQOperationViopTipTask = ((aeve)localObject2).a(((QQOperationViopTipTask)paramArrayList.next()).taskid);
      if (localQQOperationViopTipTask == null)
      {
        aevk.cL(this.app);
        return;
      }
      QQOperationVoipTipsTaskExcuteRecord localQQOperationVoipTipsTaskExcuteRecord = new QQOperationVoipTipsTaskExcuteRecord();
      localQQOperationVoipTipsTaskExcuteRecord.taskid = localQQOperationViopTipTask.taskid;
      localQQOperationVoipTipsTaskExcuteRecord.tipType = localQQOperationViopTipTask.tipType;
      localQQOperationVoipTipsTaskExcuteRecord.uin = paramString;
      localQQOperationVoipTipsTaskExcuteRecord.uinType = paramInt;
      localQQOperationVoipTipsTaskExcuteRecord.count = 1;
      localQQOperationVoipTipsTaskExcuteRecord.time = System.currentTimeMillis();
      ((aeve)localObject2).a(this.app, localQQOperationVoipTipsTaskExcuteRecord);
    }
    notifyUI(8, true, localObject1);
  }
  
  public void b(String paramString, File paramFile)
  {
    this.app.execute(new ConfigHandler.9(this, paramString, paramFile));
  }
  
  public GetResourceReqInfo c()
  {
    long l = BaseApplicationImpl.getApplication().getSharedPreferences("qq_safe_jump_whitelist", 0).getLong("key_jump_whitelist_version", 0L);
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "com.tencent.jumpCI";
    localGetResourceReqInfo.uiCurVer = l;
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public void cIa()
  {
    aqap.a().reset(false);
    b(false, null);
  }
  
  public void cIb()
  {
    this.app.getPreferences().edit().putInt("upgrade_tip_count", 0).putLong("YELLOW_BAR_LAST_SHOW", 0L).putBoolean("AUTO_DOWNLOADED_IN_WIFI", false).remove("APPID_SHOULD_DOWNLOAD").commit();
    n(this.app, 0);
  }
  
  public void cIc()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ConfigHandler", 2, "getPCActiveConfig");
    }
    try
    {
      oidb_sso.OIDBSSOPkg localOIDBSSOPkg = new oidb_sso.OIDBSSOPkg();
      localOIDBSSOPkg.uint32_command.set(2095);
      localOIDBSSOPkg.uint32_service_type.set(0);
      Object localObject = ByteBuffer.allocate(6);
      ((ByteBuffer)localObject).putInt(aqft.ag(Long.parseLong(this.app.getAccount()))).putShort((short)16);
      localOIDBSSOPkg.bytes_bodybuffer.set(ByteStringMicro.copyFrom(((ByteBuffer)localObject).array()));
      localObject = createToServiceMsg("OidbSvc.0x82f_0");
      ((ToServiceMsg)localObject).putWupBuffer(localOIDBSSOPkg.toByteArray());
      ((ToServiceMsg)localObject).setTimeout(30000L);
      sendPbReq((ToServiceMsg)localObject);
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("ConfigHandler", 2, "getPCActiveConfig ex", localException);
    }
  }
  
  public void cId()
  {
    if (this.app.getPreferences().getBoolean("has_auth_real_name", false)) {
      if (QLog.isColorLevel()) {
        QLog.i("RealName", 2, "has auth real name.");
      }
    }
    do
    {
      do
      {
        return;
        if (afsf.a().a(this.app, BaseApplicationImpl.getApplication()) != 0) {
          break;
        }
      } while (!QLog.isColorLevel());
      QLog.i("RealName", 2, "devlock status is 0.");
      return;
      ToServiceMsg localToServiceMsg = makeOIDBPkg("OidbSvc.0x9ae_2", 2478, 2, new cmd0x9ae.ReqBody().toByteArray());
      localToServiceMsg.addAttribute("serviceType", Integer.valueOf(2));
      sendPbReq(localToServiceMsg);
    } while (!QLog.isColorLevel());
    QLog.i("RealName", 2, "queryRealNameStatus");
  }
  
  public void close()
  {
    MqqHandler localMqqHandler = this.app.getHandler(Conversation.class);
    if (localMqqHandler != null)
    {
      localMqqHandler.sendEmptyMessage(11340004);
      localMqqHandler.sendEmptyMessage(1134019);
    }
    b(true, null);
  }
  
  public GetResourceReqInfo d()
  {
    Object localObject = (amhj)this.app.getManager(15);
    if (localObject == null) {
      return null;
    }
    long l = ((amhj)localObject).gK();
    localObject = new GetResourceReqInfo();
    ((GetResourceReqInfo)localObject).uiResID = 0L;
    ((GetResourceReqInfo)localObject).strPkgName = "rich_status_android";
    ((GetResourceReqInfo)localObject).uiCurVer = l;
    ((GetResourceReqInfo)localObject).sResType = 2;
    ((GetResourceReqInfo)localObject).sLanType = 0;
    ((GetResourceReqInfo)localObject).sReqType = 1;
    return localObject;
  }
  
  public GetResourceReqInfo e()
  {
    accv localaccv = (accv)this.app.getManager(59);
    if (localaccv == null) {
      return null;
    }
    GetResourceReqInfo localGetResourceReqInfo = new GetResourceReqInfo();
    localGetResourceReqInfo.uiResID = 0L;
    localGetResourceReqInfo.strPkgName = "QQAddFriend.AdministrateRegion";
    localGetResourceReqInfo.uiCurVer = localaccv.f(true);
    localGetResourceReqInfo.sResType = 2;
    localGetResourceReqInfo.sLanType = 0;
    localGetResourceReqInfo.sReqType = 1;
    return localGetResourceReqInfo;
  }
  
  public GetResourceReqInfo f()
  {
    Object localObject = this.app.getApplication().getSharedPreferences("QlinkResistTerrorist", 0);
    long l1 = ((SharedPreferences)localObject).getLong("SettingQlinkResistTerroristLastTime", 0L);
    l1 = anaz.gQ() - l1;
    if (QLog.isColorLevel()) {
      QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,qlinkdur[" + l1 + "]");
    }
    String str = this.app.getCurrentAccountUin();
    if (!((SharedPreferences)localObject).getString("SettingQlinkResistTerroristLastAccount", "0").equalsIgnoreCase(str))
    {
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,change account!");
      }
      this.app.a().dgq();
    }
    for (;;)
    {
      localObject = this.app.getApplication().getSharedPreferences("OfflineFileConfigV2", 0);
      l1 = ((SharedPreferences)localObject).getLong("FMConfigUpdateLastTime", 0L);
      long l2 = anaz.gQ();
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      l1 = l2 - l1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime[" + l1 + "]");
      }
      if (l1 <= 86400L) {
        break;
      }
      l1 = ((SharedPreferences)localObject).getLong("FileOnlinePreviewVersionKey", 0L);
      if (QLog.isDevelopLevel()) {
        l1 = 0L;
      }
      localObject = new GetResourceReqInfo();
      ((GetResourceReqInfo)localObject).uiResID = 0L;
      ((GetResourceReqInfo)localObject).strPkgName = "FileOnlinePreviewConfigV2";
      ((GetResourceReqInfo)localObject).uiCurVer = l1;
      ((GetResourceReqInfo)localObject).sResType = 3;
      ((GetResourceReqInfo)localObject).sLanType = 0;
      ((GetResourceReqInfo)localObject).sReqType = 1;
      if (QLog.isColorLevel()) {
        QLog.i("FMConfig<FileAssistant>", 2, "updateConfig,durtime over one day!currentVersion[" + l1 + "]");
      }
      return localObject;
      if (l1 > 86400L)
      {
        if (QLog.isColorLevel()) {
          QLog.i("FMConfig<FileAssistant>", 2, "verifyResistTerrorist,durtime over one day!");
        }
        this.app.a().dgq();
      }
    }
    return null;
  }
  
  public boolean g(String paramString1, int paramInt, String paramString2)
  {
    ToServiceMsg localToServiceMsg = createToServiceMsg("MAAControl.GetSinglePkgSig");
    localToServiceMsg.extraData.putString("pn", paramString1);
    localToServiceMsg.extraData.putInt("vc", paramInt);
    localToServiceMsg.extraData.putString("rid", paramString2);
    localToServiceMsg.extraData.putInt("mv", aewh.getVersionCode(this.app.getApp()));
    localToServiceMsg.extraData.putInt("sv", aqgz.getOsVersion());
    send(localToServiceMsg);
    if (QLog.isDevelopLevel()) {
      QLog.d("UpgradeController", 4, "getAuthCode:" + paramString2 + ", forPkg:" + paramString1);
    }
    return true;
  }
  
  protected Class<? extends acci> observerClass()
  {
    return accz.class;
  }
  
  public void onReceive(ToServiceMsg paramToServiceMsg, FromServiceMsg paramFromServiceMsg, Object paramObject)
  {
    boolean bool2 = true;
    boolean bool1;
    if (QLog.isColorLevel())
    {
      String str = paramFromServiceMsg.getServiceCmd();
      i = paramToServiceMsg.getAppSeq();
      if (paramObject != null)
      {
        bool1 = true;
        QLog.d("ConfigHandler", 2, String.format("ConfigHandler serviceCmd[%s], appseq[%s], data[%s]", new Object[] { str, Integer.valueOf(i), Boolean.valueOf(bool1) }));
      }
    }
    else
    {
      if (!"ResourceConfig.GetResourceReq".equals(paramFromServiceMsg.getServiceCmd())) {
        break label434;
      }
      if (paramObject != null) {
        break label119;
      }
      if (paramToServiceMsg.extraData.getBoolean("reqRegionConfig")) {
        ((accv)this.app.getManager(59)).a(null);
      }
    }
    label119:
    do
    {
      return;
      bool1 = false;
      break;
      paramToServiceMsg = ((GetResourceResp)paramObject).vecResRespInfo;
    } while ((paramToServiceMsg == null) || (paramToServiceMsg.size() <= 0));
    int i = 0;
    label141:
    if (i < paramToServiceMsg.size())
    {
      paramFromServiceMsg = (GetResourceRespInfo)paramToServiceMsg.get(i);
      if (QLog.isColorLevel()) {
        QLog.d("ThemeDownloadTrace", 2, String.format("onReceive_GetResourceRespInfo. \r\n%s", new Object[] { paramFromServiceMsg }));
      }
      if (paramFromServiceMsg.sResType != 3) {
        break label230;
      }
      if (!"FileOnlinePreviewConfigV2".equals(paramFromServiceMsg.strPkgName)) {
        break label222;
      }
      d(paramFromServiceMsg);
    }
    for (;;)
    {
      i += 1;
      break label141;
      break;
      label222:
      e(paramFromServiceMsg);
      continue;
      label230:
      if (paramFromServiceMsg.sResType == 0)
      {
        if ("com.tencent.weather_bg".equals(paramFromServiceMsg.strPkgName)) {
          c(paramFromServiceMsg);
        }
      }
      else if (paramFromServiceMsg.sResType == 2)
      {
        if ("rich_status_android".equals(paramFromServiceMsg.strPkgName))
        {
          f(paramFromServiceMsg);
        }
        else if ("eggs_android_CI_4.7.1".equals(paramFromServiceMsg.strPkgName))
        {
          g(paramFromServiceMsg);
        }
        else if ("QQAddFriend.AdministrateRegion".equals(paramFromServiceMsg.strPkgName))
        {
          paramObject = (accv)this.app.getManager(59);
          if (paramObject != null) {
            paramObject.a(paramFromServiceMsg);
          }
        }
        else if ("com.tencent.jumpCI".equals(paramFromServiceMsg.strPkgName))
        {
          b(paramFromServiceMsg);
        }
      }
      else if (paramFromServiceMsg.sResType == 4)
      {
        paramObject = this.app.a().createEntityManager();
        a(paramObject, paramFromServiceMsg);
        paramObject.close();
      }
      else if (paramFromServiceMsg.sResType == 512)
      {
        paramObject = (afem)this.app.getManager(77);
        if (paramObject != null) {
          paramObject.h(paramFromServiceMsg);
        }
      }
    }
    label434:
    if ("MobileTipsSvc.TipsReport".equals(paramFromServiceMsg.getServiceCmd()))
    {
      bool1 = paramFromServiceMsg.isSuccess();
      if (!bool1) {
        break label670;
      }
      paramToServiceMsg = new MobileTips.MobileTipsPkg();
    }
    label670:
    for (;;)
    {
      try
      {
        paramToServiceMsg.mergeFrom((byte[])paramObject);
        if (paramToServiceMsg.rsp.result.get() == 0)
        {
          bool1 = bool2;
          if (QLog.isDevelopLevel()) {
            QLog.d("QQOperateVoIP", 4, "get voip_tips req ack rsp confighandler isSuccess " + bool1);
          }
          if (bool1) {
            break;
          }
          return;
        }
      }
      catch (InvalidProtocolBufferMicroException paramFromServiceMsg)
      {
        paramFromServiceMsg.printStackTrace();
        continue;
        bool1 = false;
        continue;
      }
      if ("OidbSvc.0x82f_0".equals(paramFromServiceMsg.getServiceCmd()))
      {
        cS(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.CheckSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        cT(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("MAAControl.GetSinglePkgSig".equals(paramFromServiceMsg.getServiceCmd()))
      {
        cU(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if ("OidbSvc.0x9ae_2".equals(paramFromServiceMsg.getServiceCmd()))
      {
        cV(paramToServiceMsg, paramFromServiceMsg, paramObject);
        return;
      }
      if (!QLog.isColorLevel()) {
        break;
      }
      QLog.d("Q.richstatus.xml", 2, "cmdfilter error=" + paramFromServiceMsg.getServiceCmd());
      return;
    }
  }
  
  public class a
  {
    public a() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes2.jar
 * Qualified Name:     accy
 * JD-Core Version:    0.7.0.1
 */