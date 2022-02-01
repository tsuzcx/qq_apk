package com.tencent.qqmail.pushconfig;

import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.launcher.third.LaunchWebPush;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.AppUpdateWatcher;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.UMA.CheckUpgradeReq;
import com.tencent.qqmail.protocol.UMA.PushConfigHandle;
import com.tencent.qqmail.protocol.UMA.PushConfigHandleInfo;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMNotificationConstructor;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;
import moai.core.watcher.Watchers;
import moai.oss.OssHelper;

public class QMPushConfigUtil
{
  private static final String BETA_CHECK_UPGRADE_TIME = "betaCheckUpgradeTime";
  private static final String BETA_CLICK_TYPE = "betaClickType";
  private static final String BETA_FEATURE_DIALOG = "betaFeatureDialog";
  private static final String BETA_ITEM_SHOW_NEW = "betaItemShowNew";
  private static final String BETA_OPEN = "betaOpen";
  private static final String BETA_POPWINDOW_ITEM = "betaPopwindowItem";
  private static final String BETA_PUSHCONFIG_HASH = "beta_pushconfig_hash";
  private static final String BETA_PUSHCONFIG_ID = "beta_pushconfig_id";
  private static final String BETA_VERSION = "betaVersion";
  private static final String BETA_VERSION_URL = "betaVersionUrl";
  private static final String BETA_WEBVIEW_URL = "betaWebViewUrl";
  private static final String FORCE_SHOW_TYPE = "forceShowType";
  private static final String FORCE_TYPE = "forceType";
  private static final String MIN_VERSION = "minVersion";
  private static final String NEW_VERSION = "newversion";
  private static final String NEW_VERSION_URL = "newversionurl";
  private static final String PUSH_CONFIG_KEY = "push_config";
  private static final String PUSH_CONFIG_SP_NAME = "push_config_info";
  private static final String PUSH_LOG_TIME = "push_log_time";
  private static final String TAG = "PushConfigUtil";
  private static final String TOPBAR_POP_WINDOW_REDDOT = "topbarPopWindowRedDot";
  private static final String TOPBAR_RIGHT_BUTTON_REDDOT = "topbarRightButtonRedDot";
  private static final String UPGRADE_CLICK_TYPE = "upgrade_click_type";
  private static final String UPGRADE_FEATURE_DIALOG = "upgrade_feature_dialog";
  private static final String UPGRADE_FORCE_DIALOG = "upgrade_force_dialog";
  private static final String UPGRADE_ITEM_SHOW_NEW = "upgrade_item_show_new";
  private static final String UPGRADE_PUSHCONFIG_HASH = "upgrade_pushconfig_hash";
  private static final String UPGRADE_PUSHCONFIG_ID = "upgrade_pushconfig_id";
  private static final String UPGRADE_WEBVIEW_URL = "upgrade_webview_url";
  private static final String VERSION_INFO = "version_info";
  
  public static void bindAppUpdateWatcher(AppUpdateWatcher paramAppUpdateWatcher, boolean paramBoolean)
  {
    if (paramBoolean)
    {
      Watchers.bind(paramAppUpdateWatcher);
      return;
    }
    Watchers.unbind(paramAppUpdateWatcher);
  }
  
  public static void clearPushConfig()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("push_config_info", 0).edit().clear().commit();
    QMLog.log(4, "PushConfigUtil", "clear save push config");
  }
  
  public static void clearPushConfigVersion()
  {
    SPManager.getEditor("push_config_info").putString("push_config", "").apply();
  }
  
  public static boolean compareVersion(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (StringExtention.isNullOrEmpty(paramString1)) {
      return false;
    }
    if (StringExtention.isNullOrEmpty(paramString2)) {
      return true;
    }
    paramString1 = paramString1.split("\\.");
    paramString2 = paramString2.split("\\.");
    if (paramString1.length > paramString2.length) {
      return true;
    }
    if (paramString1.length < paramString2.length) {
      return false;
    }
    int j = paramString1.length;
    int i = j;
    if (paramBoolean)
    {
      i = j;
      if (paramString1.length == 4) {
        i = 3;
      }
    }
    j = 0;
    while (j < i)
    {
      int k = Integer.parseInt(paramString1[j]);
      int m = Integer.parseInt(paramString2[j]);
      if (k > m) {
        return true;
      }
      if (k < m) {
        return false;
      }
      j += 1;
    }
    return false;
  }
  
  public static Long getBetaCheckUpgradeTime()
  {
    return Long.valueOf(SPManager.getSp("version_info").getLong("betaCheckUpgradeTime", 0L));
  }
  
  public static int getBetaClickType()
  {
    return SPManager.getSp("version_info").getInt("betaClickType", 0);
  }
  
  public static QMPushConfigDialog getBetaFeatureDialog()
  {
    return QMPushConfigDialog.parseFrom(SPManager.getSp("version_info").getString("betaFeatureDialog", ""));
  }
  
  public static boolean getBetaItemShowNew()
  {
    return SPManager.getSp("version_info").getBoolean("betaItemShowNew", false);
  }
  
  public static boolean getBetaPopWindowItem()
  {
    return SPManager.getSp("version_info").getBoolean("betaPopwindowItem", false);
  }
  
  public static int getBetaPushConfigHash()
  {
    return SPManager.getSp("version_info").getInt("beta_pushconfig_hash", -1);
  }
  
  public static int getBetaPushConfigId()
  {
    return SPManager.getSp("version_info").getInt("beta_pushconfig_id", -1);
  }
  
  public static boolean getBetaPushConfigOpen()
  {
    return SPManager.getSp("version_info").getBoolean("betaOpen", false);
  }
  
  public static String getBetaVersion()
  {
    return SPManager.getSp("version_info").getString("betaVersion", "");
  }
  
  public static String getBetaVersionUrl()
  {
    return SPManager.getSp("version_info").getString("betaVersionUrl", "");
  }
  
  public static String getBetaWebViewUrl()
  {
    return SPManager.getSp("version_info").getString("betaWebViewUrl", "");
  }
  
  public static int getForceShowType()
  {
    return SPManager.getSp("version_info").getInt("forceShowType", 0);
  }
  
  public static int getForceType()
  {
    return SPManager.getSp("version_info").getInt("forceType", 0);
  }
  
  public static String getMinVersion()
  {
    return SPManager.getSp("version_info").getString("minVersion", "");
  }
  
  public static String getNewVersion()
  {
    return SPManager.getSp("version_info").getString("newversion", "");
  }
  
  public static String getNewVersionUrl()
  {
    return SPManager.getSp("version_info").getString("newversionurl", "");
  }
  
  public static String getPushConfigListVersion()
  {
    return SPManager.getSp("push_config_info").getString("push_config", "");
  }
  
  public static long getPushLogTime()
  {
    return QMApplicationContext.sharedInstance().getSharedPreferences("push_config_info", 0).getLong("push_log_time", 0L);
  }
  
  public static boolean getTopbarPopWindowHasNewUnClick()
  {
    return SPManager.getSp("version_info").getBoolean("topbarPopWindowRedDot", true);
  }
  
  public static boolean getTopbarRightButtonHasNewUnClick()
  {
    return SPManager.getSp("version_info").getBoolean("topbarRightButtonRedDot", true);
  }
  
  public static int getUpgradeClickType()
  {
    return SPManager.getSp("version_info").getInt("upgrade_click_type", 0);
  }
  
  public static QMPushConfigDialog getUpgradeFeatureDialog()
  {
    return QMPushConfigDialog.parseFrom(SPManager.getSp("version_info").getString("upgrade_feature_dialog", ""));
  }
  
  public static QMPushConfigDialog getUpgradeForceDialog()
  {
    return QMPushConfigDialog.parseFrom(SPManager.getSp("version_info").getString("upgrade_force_dialog", ""));
  }
  
  public static boolean getUpgradeItemShowNew()
  {
    return SPManager.getSp("version_info").getBoolean("upgrade_item_show_new", false);
  }
  
  public static int getUpgradePushConfigId()
  {
    return SPManager.getSp("version_info").getInt("upgrade_pushconfig_id", -1);
  }
  
  public static int getUpgradePushconfigHash()
  {
    return SPManager.getSp("version_info").getInt("upgrade_pushconfig_hash", -1);
  }
  
  public static String getUpgradeWebViewUrl()
  {
    return SPManager.getSp("version_info").getString("upgrade_webview_url", "");
  }
  
  private static void handleBeta(QMBetaPushConfig paramQMBetaPushConfig)
  {
    if ((paramQMBetaPushConfig == null) || (ChannelDefine.isGooglePlay())) {}
    do
    {
      return;
      setBetaPushConfigId(paramQMBetaPushConfig.getId());
      setBetaPushConfigHash(paramQMBetaPushConfig.getHash());
      setBetaPushConfigOpen(paramQMBetaPushConfig.isOpen());
      setBetaVersion(paramQMBetaPushConfig.getBetaVersion());
      setBetaVersionUrl(paramQMBetaPushConfig.getDownloadUrl());
      setBetaClickType(paramQMBetaPushConfig.getClickType());
      setBetaFeatureDialog(paramQMBetaPushConfig.getDialog());
      setBetaWebviewUrl(paramQMBetaPushConfig.getNotificationUrl());
      QMLog.log(4, "PushConfigUtil", "curVer:" + AppConfig.getCodeVersion() + ", betaVer:" + getBetaVersion() + ", upgradeVer:" + getNewVersion() + ", open:" + getBetaPushConfigOpen());
      if (!showBetaVersion()) {
        break;
      }
      QMLog.log(4, "PushConfigUtil", "show beta");
      setTopbarRightButtonHasNewUnClick(true);
      setBetaPopWindowItem(true);
      QMSettingManager.sharedInstance().setNewVersionRead(true);
      setTopbarPopWindowHasNewUnClick(false);
      setBetaItemShowNew(true);
    } while ((AppStatusUtil.isAppOnForeground()) || (StringExtention.isNullOrEmpty(paramQMBetaPushConfig.getNotificationUrl())) || (StringExtention.isNullOrEmpty(paramQMBetaPushConfig.getNotificationDesp())) || (StringExtention.isNullOrEmpty(paramQMBetaPushConfig.getNotificationTitle())));
    QMLog.log(4, "PushConfigUtil", "show beta push:" + paramQMBetaPushConfig.getBetaVersion());
    Object localObject = LaunchWebPush.createBetaIntent(paramQMBetaPushConfig.getNotificationUrl(), paramQMBetaPushConfig.getNotificationDesp());
    localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), paramQMBetaPushConfig.getId(), (Intent)localObject, 134217728);
    QMNotificationConstructor.getInstance().notifyBeta(paramQMBetaPushConfig, (PendingIntent)localObject);
    DataCollector.logEvent("Event_Beta_Notification_Show");
    return;
    QMLog.log(4, "PushConfigUtil", "not show beta");
  }
  
  public static void handleBetaCheckUpgrade()
  {
    long l;
    CloudProtocolInfo localCloudProtocolInfo;
    if ((getBetaPopWindowItem()) && (showBetaVersion()))
    {
      l = System.currentTimeMillis();
      if (l - getBetaCheckUpgradeTime().longValue() >= 86400000L)
      {
        QMLog.log(4, "PushConfigUtil", "beta check upgrade");
        localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
        if (localCloudProtocolInfo != null) {
          break label49;
        }
      }
    }
    return;
    label49:
    CheckUpgradeReq localCheckUpgradeReq = new CheckUpgradeReq();
    localCheckUpgradeReq.version = new ByteString(AppConfig.getCodeVersion().getBytes());
    localCloudProtocolInfo.check_upgrade_req_ = localCheckUpgradeReq;
    CloudProtocolService.CheckUpgrade(localCloudProtocolInfo, new QMPushConfigUtil.7());
    setBetaCheckUpgradeTime(l);
  }
  
  private static void handleCommon(QMCommonPushConfig paramQMCommonPushConfig)
  {
    if (paramQMCommonPushConfig == null) {}
    Object localObject;
    QMUIDialog.MessageDialogBuilder localMessageDialogBuilder;
    do
    {
      do
      {
        do
        {
          return;
          if ((paramQMCommonPushConfig.getType() == 1) && (!AppStatusUtil.isAppOnForeground()))
          {
            localObject = LaunchWebPush.createPushSchemaIntent(paramQMCommonPushConfig.getAction());
            localObject = PendingIntent.getActivity(QMApplicationContext.sharedInstance(), paramQMCommonPushConfig.getId(), (Intent)localObject, 134217728);
            QMNotificationConstructor.getInstance().notifyCommonPushConfig(paramQMCommonPushConfig.getTitle(), paramQMCommonPushConfig.getSubject(), (PendingIntent)localObject);
            return;
          }
        } while ((paramQMCommonPushConfig.getType() != 2) || (!AppStatusUtil.isAppOnForeground()));
        localObject = paramQMCommonPushConfig.getItems();
        localMessageDialogBuilder = new QMUIDialog.MessageDialogBuilder(QMApplicationContext.sharedInstance());
      } while (localObject == null);
      if (((ArrayList)localObject).size() == 1)
      {
        ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setTitle(paramQMCommonPushConfig.getTitle())).setMessage(paramQMCommonPushConfig.getSubject()).addAction(((QMPushConfigItem)((ArrayList)localObject).get(0)).getText(), new QMPushConfigUtil.2((ArrayList)localObject))).create().show();
        return;
      }
    } while (((ArrayList)localObject).size() != 2);
    ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)localMessageDialogBuilder.setTitle(paramQMCommonPushConfig.getTitle())).setMessage(paramQMCommonPushConfig.getSubject()).addAction(((QMPushConfigItem)((ArrayList)localObject).get(0)).getText(), new QMPushConfigUtil.4((ArrayList)localObject))).addAction(0, ((QMPushConfigItem)((ArrayList)localObject).get(1)).getText(), 2, new QMPushConfigUtil.3((ArrayList)localObject))).create().show();
  }
  
  public static boolean handlePushConfig(QMPushConfig paramQMPushConfig)
  {
    if (paramQMPushConfig == null) {
      return false;
    }
    QMLog.log(4, "PushConfigUtil", "pushConfig:" + paramQMPushConfig.toString());
    return true;
  }
  
  private static void handleUpgrade(QMUpgradePushConfig paramQMUpgradePushConfig)
  {
    if (paramQMUpgradePushConfig == null) {}
    QMPushConfigDialog localQMPushConfigDialog;
    do
    {
      return;
      setUpgradePushconfigId(paramQMUpgradePushConfig.getId());
      setUpgradePushconfigHash(paramQMUpgradePushConfig.getHash());
      setNewVersion(paramQMUpgradePushConfig.getUpgradeVersion());
      setMinVersion(paramQMUpgradePushConfig.getMinVersion());
      setNewVersionUrl(paramQMUpgradePushConfig.getUrl());
      setForceShowType(paramQMUpgradePushConfig.getForceShowType());
      setForceType(paramQMUpgradePushConfig.getForceType());
      setUpgradeFeatureDialog(paramQMUpgradePushConfig.getFeatureDialog());
      setUpgradeForceDialog(paramQMUpgradePushConfig.getForceDialog());
      setUpgradeWebviewUrl(paramQMUpgradePushConfig.getWebViewUrl());
      setUpgradeClickType(paramQMUpgradePushConfig.getClickType());
      QMLog.log(4, "PushConfigUtil", "curVer:" + AppConfig.getCodeVersion() + ", betaVer:" + getBetaVersion() + ", upgradeVer:" + getNewVersion());
      if (!showUpgradeVersion()) {
        break;
      }
      QMLog.log(4, "PushConfigUtil", "show upgrade");
      QMSettingManager.sharedInstance().setNewVersionRead(false);
      setTopbarRightButtonHasNewUnClick(true);
      setTopbarPopWindowHasNewUnClick(true);
      setUpgradeItemShowNew(true);
      setBetaPushConfigOpen(false);
      localQMPushConfigDialog = paramQMUpgradePushConfig.getForceDialog();
    } while ((localQMPushConfigDialog == null) || (paramQMUpgradePushConfig.getForceType() == 0));
    Threads.runOnMainThread(new QMPushConfigUtil.1(localQMPushConfigDialog, paramQMUpgradePushConfig));
    return;
    QMLog.log(4, "PushConfigUtil", "not show upgrade");
  }
  
  private static HashMap<Integer, Integer> parseVersionFromString(String paramString)
  {
    HashMap localHashMap = new HashMap();
    if (!StringExtention.isNullOrEmpty(paramString))
    {
      paramString = paramString.split(";");
      int i = 0;
      while (i < paramString.length)
      {
        String[] arrayOfString = paramString[i].split(":");
        if (arrayOfString.length == 2) {
          localHashMap.put(Integer.valueOf(Integer.parseInt(arrayOfString[0])), Integer.valueOf(Integer.parseInt(arrayOfString[1])));
        }
        i += 1;
      }
    }
    return localHashMap;
  }
  
  private static String parseVersionToString(HashMap<Integer, Integer> paramHashMap)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if ((paramHashMap != null) && (paramHashMap.size() > 0))
    {
      Iterator localIterator = paramHashMap.keySet().iterator();
      while (localIterator.hasNext())
      {
        int i = ((Integer)localIterator.next()).intValue();
        localStringBuilder.append(i).append(":").append(paramHashMap.get(Integer.valueOf(i))).append(";");
      }
    }
    return localStringBuilder.toString();
  }
  
  public static void sendDownloadBeta()
  {
    OssHelper.pushConfig(new Object[] { "betaDownload", Integer.valueOf(getBetaPushConfigId()), getBetaVersion() });
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    PushConfigHandle localPushConfigHandle = new PushConfigHandle();
    localPushConfigHandle.id = getBetaPushConfigId();
    localPushConfigHandle.hash = getBetaPushConfigHash();
    localPushConfigHandle.state = 2;
    PushConfigHandleInfo localPushConfigHandleInfo = new PushConfigHandleInfo();
    localPushConfigHandleInfo.content = ByteString.copyFromUtf8("1");
    localPushConfigHandle.push_config_handle_info = localPushConfigHandleInfo;
    QMLog.log(4, "PushConfigUtil", "send beta download.id=" + localPushConfigHandle.id + ",hash=" + localPushConfigHandle.hash + ",state=" + localPushConfigHandle.state + ",content=" + localPushConfigHandle.push_config_handle_info.content.toString());
    localArrayList.add(localPushConfigHandle);
    localCloudProtocolInfo.push_config_list_req_ = ((PushConfigHandle[])localArrayList.toArray(new PushConfigHandle[localArrayList.size()]));
    CloudProtocolService.PushConfigHandle(localCloudProtocolInfo, new QMPushConfigUtil.6());
  }
  
  public static void sendDownloadUpgrade()
  {
    OssHelper.pushConfig(new Object[] { "downloadUpgrade", Integer.valueOf(getUpgradePushConfigId()), getNewVersion() });
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null) {
      return;
    }
    ArrayList localArrayList = new ArrayList();
    PushConfigHandle localPushConfigHandle = new PushConfigHandle();
    localPushConfigHandle.id = getUpgradePushConfigId();
    localPushConfigHandle.hash = getUpgradePushconfigHash();
    localPushConfigHandle.state = 2;
    PushConfigHandleInfo localPushConfigHandleInfo = new PushConfigHandleInfo();
    localPushConfigHandleInfo.content = ByteString.copyFromUtf8("1");
    localPushConfigHandle.push_config_handle_info = localPushConfigHandleInfo;
    QMLog.log(4, "PushConfigUtil", "send upgrade download.id=" + localPushConfigHandle.id + ",hash=" + localPushConfigHandle.hash + ",state=" + localPushConfigHandle.state + ",content=" + localPushConfigHandle.push_config_handle_info.content.toString());
    localArrayList.add(localPushConfigHandle);
    localCloudProtocolInfo.push_config_list_req_ = ((PushConfigHandle[])localArrayList.toArray(new PushConfigHandle[localArrayList.size()]));
    CloudProtocolService.PushConfigHandle(localCloudProtocolInfo, new QMPushConfigUtil.5());
  }
  
  public static void setBetaCheckUpgradeTime(long paramLong)
  {
    SPManager.getEditor("version_info").putLong("betaCheckUpgradeTime", paramLong).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaCheckUpgradeTime:" + paramLong);
  }
  
  public static void setBetaClickType(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("betaClickType", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaClickType:" + paramInt);
  }
  
  public static void setBetaFeatureDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    if (paramQMPushConfigDialog != null)
    {
      SPManager.getEditor("version_info").putString("betaFeatureDialog", paramQMPushConfigDialog.toString()).apply();
      QMLog.log(4, "PushConfigUtil", "setBetaFeatureDialog:" + paramQMPushConfigDialog.toString());
    }
  }
  
  public static void setBetaItemShowNew(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("betaItemShowNew", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaItemShowNew:" + paramBoolean);
  }
  
  public static void setBetaPopWindowItem(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("betaPopwindowItem", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaPopWindowItem:" + paramBoolean);
  }
  
  public static void setBetaPushConfigHash(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("beta_pushconfig_hash", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaPushConfigHash:" + paramInt);
  }
  
  public static void setBetaPushConfigId(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("beta_pushconfig_id", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaPushConfigId:" + paramInt);
  }
  
  public static void setBetaPushConfigOpen(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("betaOpen", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaPushConfigOpen:" + paramBoolean);
  }
  
  public static void setBetaVersion(String paramString)
  {
    SPManager.getEditor("version_info").putString("betaVersion", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaVersion:" + paramString);
  }
  
  public static void setBetaVersionUrl(String paramString)
  {
    SPManager.getEditor("version_info").putString("betaVersionUrl", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaVersionUrl:" + paramString);
  }
  
  public static void setBetaWebviewUrl(String paramString)
  {
    SPManager.getEditor("version_info").putString("betaWebViewUrl", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setBetaWebViewUrl:" + paramString);
  }
  
  public static void setForceShowType(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("forceShowType", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setForceShowType:" + paramInt);
  }
  
  public static void setForceType(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("forceType", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setForceType:" + paramInt);
  }
  
  public static void setMinVersion(String paramString)
  {
    SPManager.getEditor("version_info").putString("minVersion", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setMinVersion:" + paramString);
  }
  
  public static void setNewVersion(String paramString)
  {
    SPManager.getEditor("version_info").putString("newversion", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setnewversionok:" + paramString);
  }
  
  public static void setNewVersionUrl(String paramString)
  {
    SPManager.getEditor("version_info").putString("newversionurl", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setNewVersionUrl:" + paramString);
  }
  
  public static void setPushConfigListVersion(ArrayList<QMPushConfig> paramArrayList)
  {
    if ((paramArrayList != null) && (paramArrayList.size() > 0))
    {
      HashMap localHashMap = parseVersionFromString(getPushConfigListVersion());
      paramArrayList = paramArrayList.iterator();
      while (paramArrayList.hasNext())
      {
        QMPushConfig localQMPushConfig = (QMPushConfig)paramArrayList.next();
        localHashMap.put(Integer.valueOf(localQMPushConfig.getId()), Integer.valueOf(localQMPushConfig.getVersion()));
      }
      paramArrayList = parseVersionToString(localHashMap);
      QMLog.log(4, "PushConfigUtil", "setPushConfigVersion:" + paramArrayList);
      SPManager.getEditor("push_config_info").putString("push_config", paramArrayList).apply();
    }
  }
  
  public static void setPushLogTime()
  {
    QMApplicationContext.sharedInstance().getSharedPreferences("push_config_info", 0).edit().putLong("push_log_time", System.currentTimeMillis()).commit();
    QMLog.log(4, "PushConfigUtil", "push config set push log time:" + System.currentTimeMillis());
  }
  
  public static void setTopbarPopWindowHasNewUnClick(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("topbarPopWindowRedDot", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setTopBarPopWindowNew:" + paramBoolean);
  }
  
  public static void setTopbarRightButtonHasNewUnClick(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("topbarRightButtonRedDot", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setTopBarRightButtonNew:" + paramBoolean);
  }
  
  public static void setUpgradeClickType(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("upgrade_click_type", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setUpgradeClickType:" + paramInt);
  }
  
  public static void setUpgradeFeatureDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    if (paramQMPushConfigDialog != null)
    {
      SPManager.getEditor("version_info").putString("upgrade_feature_dialog", paramQMPushConfigDialog.toString()).apply();
      QMLog.log(4, "PushConfigUtil", "setUpgradeFeatureDialog:" + paramQMPushConfigDialog.toString());
    }
  }
  
  public static void setUpgradeForceDialog(QMPushConfigDialog paramQMPushConfigDialog)
  {
    if (paramQMPushConfigDialog != null)
    {
      SPManager.getEditor("version_info").putString("upgrade_force_dialog", paramQMPushConfigDialog.toString()).apply();
      QMLog.log(4, "PushConfigUtil", "setUpgradeForceDialog:" + paramQMPushConfigDialog.toString());
    }
  }
  
  public static void setUpgradeItemShowNew(boolean paramBoolean)
  {
    SPManager.getEditor("version_info").putBoolean("upgrade_item_show_new", paramBoolean).apply();
    QMLog.log(4, "PushConfigUtil", "setUpgradeItemShowNew:" + paramBoolean);
  }
  
  public static void setUpgradePushconfigHash(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("upgrade_pushconfig_hash", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setUpgradePushConfighash:" + paramInt);
  }
  
  public static void setUpgradePushconfigId(int paramInt)
  {
    SPManager.getEditor("version_info").putInt("upgrade_pushconfig_id", paramInt).apply();
    QMLog.log(4, "PushConfigUtil", "setUpgradePushConfigId:" + paramInt);
  }
  
  public static void setUpgradeWebviewUrl(String paramString)
  {
    SPManager.getEditor("version_info").putString("upgrade_webview_url", paramString).apply();
    QMLog.log(4, "PushConfigUtil", "setUpgradeWebViewUrl:" + paramString);
  }
  
  public static boolean showBetaVersion()
  {
    String str1 = AppConfig.getCodeVersion();
    String str2 = getBetaVersion();
    String str3 = getNewVersion();
    return (getBetaPushConfigOpen()) && (compareVersion(str2, str1, true)) && (compareVersion(str2, str3, false));
  }
  
  public static boolean showUpgradeVersion()
  {
    boolean bool2 = false;
    String str1 = AppConfig.getCodeVersion();
    String str2 = getBetaVersion();
    String str3 = getNewVersion();
    boolean bool1 = bool2;
    if (compareVersion(str3, str1, false))
    {
      bool1 = bool2;
      if (!compareVersion(str2, str3, false)) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  public static void triggerAppUpdateWatcher(String paramString1, String paramString2, String paramString3, String paramString4, int paramInt)
  {
    ((AppUpdateWatcher)Watchers.of(AppUpdateWatcher.class)).onUpdate(paramString1, paramString2, paramString3, paramString4, paramInt);
    QMLog.log(4, "PushConfigUtil", "triggerAppUpdateWatcher:newVersion : " + paramString1 + ", desp : " + paramString2 + ", title : " + paramString3 + ", updateUrl : " + paramString4 + ", forceType :" + paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.pushconfig.QMPushConfigUtil
 * JD-Core Version:    0.7.0.1
 */