package com.tencent.qqmail.model.protocol;

import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;
import android.graphics.Bitmap;
import android.text.TextUtils;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.util.SparseIntArray;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import com.alibaba.fastjson.JSONObject;
import com.tencent.androidqqmail.tim.QMAppInterface;
import com.tencent.androidqqmail.tim.TimMailLoginManager;
import com.tencent.moai.nativepages.AdLandingPagesPreDownloadHelper;
import com.tencent.moai.nativepages.NativePageManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.MailServiceManager.QueryProviderListener;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.log.AddAccountLocalLogUtil;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.readmail.model.VirtualAdManager;
import com.tencent.qqmail.advertise.AdvertiseManager;
import com.tencent.qqmail.download.ImageDownloadManager;
import com.tencent.qqmail.download.model.DownloadInfo;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.PasswordErrHandler;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMOfflineOperationManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.QMSpamTypeManager;
import com.tencent.qqmail.model.mail.callback.SyncUpdateCallback;
import com.tencent.qqmail.model.mail.watcher.SetPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncNickWatcher;
import com.tencent.qqmail.model.mail.watcher.SyncPhotoWatcher;
import com.tencent.qqmail.model.mail.watcher.WipeAppWatcher;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.nativepages.NativePageAppOperationDelegate;
import com.tencent.qqmail.permission.PermissionUtils;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.popularize.PopularizeThumbManager;
import com.tencent.qqmail.popularize.model.Popularize;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolInfo.AccountInfo;
import com.tencent.qqmail.protocol.CloudProtocolInfo.QueryConfigUpdateRequest;
import com.tencent.qqmail.protocol.CloudProtocolInfo.UserSettingA;
import com.tencent.qqmail.protocol.CloudProtocolResult.QueryConfigUpdateRspForOC;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.Profile;
import com.tencent.qqmail.protocol.UMA.AppMiscConfig;
import com.tencent.qqmail.protocol.UMA.CmdClrContactTypeReq;
import com.tencent.qqmail.protocol.UMA.CmdLstADBWContactRsp;
import com.tencent.qqmail.protocol.UMA.CmdQueryConfigUpdateReq.RequestField;
import com.tencent.qqmail.protocol.UMA.CmdSetContactTypeReq;
import com.tencent.qqmail.protocol.UMA.DelEMailPhotoReqInfo;
import com.tencent.qqmail.protocol.UMA.EmailAccountState;
import com.tencent.qqmail.protocol.UMA.EmailProtocolInfo;
import com.tencent.qqmail.protocol.UMA.HolidayPicConfig;
import com.tencent.qqmail.protocol.UMA.PopularizeConfig;
import com.tencent.qqmail.protocol.UMA.PopularizeReqExtraParam;
import com.tencent.qqmail.protocol.UMA.PushConfig;
import com.tencent.qqmail.protocol.UMA.SetEMailNicknameReqInfo;
import com.tencent.qqmail.protocol.UMA.SetEMailPhotoReqInfo;
import com.tencent.qqmail.protocol.UMA.SpreadResult;
import com.tencent.qqmail.protocol.UMA.SpreadTypeList;
import com.tencent.qqmail.protocol.UMA.SyncEMailNicknameReqInfo;
import com.tencent.qqmail.protocol.UMA.UpdateInfo;
import com.tencent.qqmail.protocol.UMA.UserSetting;
import com.tencent.qqmail.protocol.UMA.UserSetting.Account;
import com.tencent.qqmail.protocol.UMA.UserSetting.Global;
import com.tencent.qqmail.pushconfig.QMPushConfig;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.encryptionalgorithm.Aes;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.imageextention.ImageUtil;
import com.tencent.qqmail.utilities.json.JSONReader;
import com.tencent.qqmail.utilities.log.FeedbackManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.otherapprule.OtherAppConfigUtil;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMAlarmBroadCast;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMGeneralCallback;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.report.QMReportManager;
import com.tencent.qqmail.utilities.sharedpreference.QMSharedPreferenceManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIKit;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.Timer;
import moai.core.watcher.Watchers;
import moai.oss.OssHelper;
import mqq.app.AppRuntime;
import org.apache.commons.lang3.StringUtils;

public class QMPrivateProtocolManager
{
  private static final String AVATAR_MODIFY_FILENAME = "lastModify";
  private static final String AVATAR_SHA_FILENAME = "sha";
  private static final String CONFIG_EMAIL_ACCOUNT_STATE = "config_email_account_state";
  private static final String CONFIG_EMAIL_ACCOUNT_STATE_TIME = "config_email_account_state_time";
  private static final String CONFIG_TYPE_LAST_TIME_PREFIX = "configtype_last_time_";
  public static final String CONFIG_TYPE_PREFIX = "configtype_";
  private static final long SYNC_PHOTO_INTERVAL = 86400000L;
  private static final String TAG = "QMPrivateProtocolManager";
  public static final int UPDATE_CONFIG_SCENE_FLAG_DEVELOPER = 128;
  public static final int UPDATE_CONFIG_SCENE_FLAG_EMAIL_ACCOUNT_STATE = 64;
  public static final int UPDATE_CONFIG_SCENE_FLAG_FOREGROUND = 1;
  public static final int UPDATE_CONFIG_SCENE_FLAG_PUSH = 2;
  public static final int UPDATE_CONFIG_SCENE_FLAG_REGISTER_VID = 8;
  public static final int UPDATE_CONFIG_SCENE_FLAG_SYNC_ADAPTER = 32;
  public static final int UPDATE_CONFIG_SCENE_FLAG_SYNC_ADBW_LIST = 16;
  public static final int UPDATE_CONFIG_SCENE_FLAG_USER_TRIGGER = 4;
  private static QMPrivateProtocolManager instance = new QMPrivateProtocolManager();
  private static Object lock_resetVid = new Object();
  private ArrayList<String> emailList = new ArrayList();
  private volatile EmailAccountState[] mEmailAcctStateList;
  private final Object mInitEmailAccLock = new Object();
  private UpdateConfigTask mUpdateConfigTask = new UpdateConfigTask(null);
  
  private boolean addAccountUMA(Account paramAccount)
  {
    String str;
    if ((paramAccount instanceof QQMailAccount))
    {
      boolean bool;
      if ((SharedPreferenceUtil.isWtlogin()) && (!paramAccount.isBizMail())) {
        bool = true;
      }
      while (bool)
      {
        str = QMWtLoginManager.getInstance().getA2(paramAccount.getUin());
        if ((str == null) || (str.equals("")))
        {
          QMLog.log(5, "QMPrivateProtocolManager", "alignaccount a2 empty");
          return false;
          bool = false;
        }
        else
        {
          str = Aes.encode(str + "\t" + paramAccount.getSecondPassword(), Aes.getServerKey());
          QMLog.log(4, "QMPrivateProtocolManager", "align accounts add account to server : " + paramAccount.getId() + ", " + paramAccount.getEmail() + ", " + paramAccount.getProfile() + ", " + bool);
          addAccount(paramAccount.getProfile(), paramAccount.getEmail().split("@")[1], paramAccount.getEmail(), str, paramAccount.getId(), null, null, true, paramAccount.isBizMail());
        }
      }
    }
    for (;;)
    {
      return true;
      if ((paramAccount.getPwd() == null) || (paramAccount.getPwd().equals("")))
      {
        QMLog.log(5, "QMPrivateProtocolManager", "alignaccount acc psw is : " + paramAccount.getPwd());
        return false;
      }
      str = StringExtention.encodeURI(Aes.encode(paramAccount.getPwd(), Aes.getServerKey()));
      break;
      if (paramAccount != null)
      {
        QMLog.log(4, "QMPrivateProtocolManager", "align accounts. add account to server : " + paramAccount.getId() + ", " + paramAccount.getEmail() + ", " + paramAccount.getProfile() + ",");
        sharedInstance().addAccount(paramAccount.getProfile(), paramAccount.getEmail().split("@")[1], paramAccount.getEmail(), "", paramAccount.getId(), null, null, false, false);
      }
    }
  }
  
  private boolean canAlignAccount(Account paramAccount)
  {
    int i = paramAccount.getAccountState();
    QMLog.log(5, "QMPrivateProtocolManager", "canAlignAccount " + paramAccount.getEmail() + " state :" + i);
    return (i != -1) && (i != -4) && (i != -5);
  }
  
  private String getConfigTypeVersion(int paramInt)
  {
    SharedPreferences localSharedPreferences = SPManager.getSp("user_info");
    if (paramInt == 14)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "pushConfig type14 version:" + QMPushConfigUtil.getPushConfigListVersion());
      return QMPushConfigUtil.getPushConfigListVersion();
    }
    return localSharedPreferences.getString("configtype_" + paramInt, "");
  }
  
  public static Bitmap getPhotoBitmapByEmail(String paramString, int paramInt)
  {
    paramString = FileUtil.getEmailIconDirPath() + paramString + File.separator + paramInt;
    return ImageDownloadManager.shareInstance().getAvatarBitmapFromDisk(paramString);
  }
  
  public static Bitmap getPhotoBitmapByEmailFromCache(String paramString, int paramInt)
  {
    paramString = FileUtil.getEmailIconDirPath() + paramString + File.separator + paramInt;
    return ImageDownloadManager.shareInstance().getBitmapFromMemCache(paramString);
  }
  
  private CloudProtocolInfo getUserSettingAccountBasicInfo(int paramInt)
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo != null)
    {
      UserSetting.Account localAccount = new UserSetting.Account();
      localAccount.set_account_id(paramInt);
      localCloudProtocolInfo.user_setting_a_ = new CloudProtocolInfo.UserSettingA();
      localCloudProtocolInfo.user_setting_a_.account_list_ = new UserSetting.Account[1];
      localCloudProtocolInfo.user_setting_a_.account_list_[0] = localAccount;
    }
    return localCloudProtocolInfo;
  }
  
  private CloudProtocolInfo getUserSettingGlobalBasicInfo()
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_ = new CloudProtocolInfo.UserSettingA();
      localCloudProtocolInfo.user_setting_a_.global_ = new UserSetting.Global();
    }
    return localCloudProtocolInfo;
  }
  
  private void handleADBWList(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    Object localObject2 = null;
    if (paramQueryConfigUpdateRspForOC.adbw_contact_resp_ == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "handleADBWList invalid config");
      return;
    }
    paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.adbw_contact_resp_;
    String[] arrayOfString;
    label81:
    StringBuilder localStringBuilder;
    if (paramQueryConfigUpdateRspForOC.black_email != null)
    {
      arrayOfString = (String[])paramQueryConfigUpdateRspForOC.black_email.toArray(new String[paramQueryConfigUpdateRspForOC.black_email.size()]);
      if (paramQueryConfigUpdateRspForOC.white_email == null) {
        break label173;
      }
      paramQueryConfigUpdateRspForOC = (String[])paramQueryConfigUpdateRspForOC.white_email.toArray(new String[paramQueryConfigUpdateRspForOC.white_email.size()]);
      localStringBuilder = new StringBuilder().append("black_emails:");
      if (arrayOfString != null) {
        break label178;
      }
      localObject1 = null;
      label102:
      localStringBuilder = localStringBuilder.append(localObject1).append(", white_emails:");
      if (paramQueryConfigUpdateRspForOC != null) {
        break label187;
      }
    }
    label173:
    label178:
    label187:
    for (Object localObject1 = localObject2;; localObject1 = paramQueryConfigUpdateRspForOC)
    {
      QMLog.log(4, "QMPrivateProtocolManager", localObject1);
      QMMailManager.sharedInstance().getSqliteHelper().mail.syncAdAddressList(QMMailManager.sharedInstance().getSqliteHelper().getWritableDatabase(), arrayOfString, paramQueryConfigUpdateRspForOC);
      QMMailManager.sharedInstance().updateAllAdvertiseEntrance();
      return;
      arrayOfString = null;
      break;
      paramQueryConfigUpdateRspForOC = null;
      break label81;
      localObject1 = Integer.valueOf(arrayOfString.length);
      break label102;
    }
  }
  
  private void handleAccState(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    if (paramQueryConfigUpdateRspForOC.email_account_state_list_ == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "handleAccState, invalid account state list");
      return;
    }
    QMLog.log(4, "QMPrivateProtocolManager", "handleAccState, size: " + paramQueryConfigUpdateRspForOC.email_account_state_list_.length);
    Object localObject1 = paramQueryConfigUpdateRspForOC.email_account_state_list_;
    Object localObject2 = new StringBuilder();
    Object localObject3 = new SparseIntArray();
    paramQueryConfigUpdateRspForOC = new SparseIntArray();
    int j = localObject1.length;
    int i = 0;
    while (i < j)
    {
      ??? = localObject1[i];
      if (??? != null)
      {
        ((StringBuilder)localObject2).append(((EmailAccountState)???).account_id).append(":").append(((EmailAccountState)???).polling_interval).append(":").append(((EmailAccountState)???).state_code).append(":").append(((EmailAccountState)???).account_flag).append(";");
        ((SparseIntArray)localObject3).put(((EmailAccountState)???).account_id, 1);
        if (((EmailAccountState)???).account_flag != 1)
        {
          ??? = AccountManager.shareInstance().getAccountList().getAccountById(((EmailAccountState)???).account_id);
          if ((??? != null) && (((Account)???).isQQMail())) {
            paramQueryConfigUpdateRspForOC.put(((Account)???).getId(), 1);
          }
        }
      }
      i += 1;
    }
    ??? = AccountManager.shareInstance().getAccountList();
    if (((AccountList)???).size() > 0)
    {
      ??? = ((AccountList)???).iterator();
      while (((Iterator)???).hasNext())
      {
        Account localAccount = (Account)((Iterator)???).next();
        if (((SparseIntArray)localObject3).indexOfKey(localAccount.getId()) >= 0) {
          ((SparseIntArray)localObject3).put(localAccount.getId(), 3);
        } else {
          ((SparseIntArray)localObject3).put(localAccount.getId(), 2);
        }
      }
    }
    j = ((SparseIntArray)localObject3).size();
    i = 0;
    int k;
    if (i < j)
    {
      k = ((SparseIntArray)localObject3).keyAt(i);
      switch (((SparseIntArray)localObject3).valueAt(i))
      {
      }
      for (;;)
      {
        i += 1;
        break;
        delAccount(k, "");
        paramQueryConfigUpdateRspForOC.delete(k);
        continue;
        paramQueryConfigUpdateRspForOC.put(k, 2);
      }
    }
    for (;;)
    {
      synchronized (this.mInitEmailAccLock)
      {
        this.mEmailAcctStateList = ((EmailAccountState[])localObject1);
        SPManager.getEditor("user_info").putString("config_email_account_state", ((StringBuilder)localObject2).toString()).apply();
        QMLog.log(4, "QMPrivateProtocolManager", "handleAccState, addOrDelAccountArray: " + printIntArray((SparseIntArray)localObject3) + ", addOrModAccountArray: " + printIntArray(paramQueryConfigUpdateRspForOC) + ", config: " + ((StringBuilder)localObject2).toString());
        j = paramQueryConfigUpdateRspForOC.size();
        if (j <= 0) {
          break;
        }
        i = 0;
        if (i >= j) {
          break;
        }
        k = paramQueryConfigUpdateRspForOC.keyAt(i);
        localObject3 = AccountManager.shareInstance().getAccountList().getAccountById(k);
        if (localObject3 == null) {
          i += 1;
        }
      }
      int m = paramQueryConfigUpdateRspForOC.get(k);
      localObject1 = QMFolderManager.sharedInstance().getFolder(QMFolderManager.sharedInstance().getInboxFolderId(k));
      if (localObject1 != null)
      {
        localObject2 = QMMailManager.sharedInstance();
        localObject3 = new QMPrivateProtocolManager.7(this, (Account)localObject3, m);
        ((QMMailManager)localObject2).syncUpdateWithNotification(k, new QMFolder[] { localObject1 }, false, "accstate", (SyncUpdateCallback)localObject3);
      }
    }
  }
  
  private void handleAppNotNotify(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    com.tencent.qqmail.protocol.UMA.AppNotNotify[] arrayOfAppNotNotify = paramQueryConfigUpdateRspForOC.app_not_notify_list_;
    ArrayList localArrayList = new ArrayList();
    if (arrayOfAppNotNotify != null)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "handleAppNotNotify size : " + arrayOfAppNotNotify.length);
      int j = arrayOfAppNotNotify.length;
      int i = 0;
      if (i < j)
      {
        com.tencent.qqmail.protocol.UMA.AppNotNotify localAppNotNotify1 = arrayOfAppNotNotify[i];
        com.tencent.qqmail.utilities.otherapprule.AppNotNotify localAppNotNotify = new com.tencent.qqmail.utilities.otherapprule.AppNotNotify();
        if (localAppNotNotify1.package_name == null)
        {
          paramQueryConfigUpdateRspForOC = "";
          label85:
          localAppNotNotify.setPackageName(paramQueryConfigUpdateRspForOC);
          if (localAppNotNotify1.package_version != null) {
            break label142;
          }
        }
        label142:
        for (paramQueryConfigUpdateRspForOC = "";; paramQueryConfigUpdateRspForOC = new String(localAppNotNotify1.package_version.getBytes()))
        {
          localAppNotNotify.setPackageVersion(paramQueryConfigUpdateRspForOC);
          localArrayList.add(localAppNotNotify);
          i += 1;
          break;
          paramQueryConfigUpdateRspForOC = new String(localAppNotNotify1.package_name.getBytes());
          break label85;
        }
      }
      OtherAppConfigUtil.saveAppNotNotify(localArrayList);
    }
  }
  
  private void handleAppNotToOpenFile(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    com.tencent.qqmail.protocol.UMA.AppNotToOpenFile[] arrayOfAppNotToOpenFile = paramQueryConfigUpdateRspForOC.app_not_to_open_file_list_;
    ArrayList localArrayList1 = new ArrayList();
    if (arrayOfAppNotToOpenFile != null)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "handleAppNotToOpenFile size : " + arrayOfAppNotToOpenFile.length);
      int k = arrayOfAppNotToOpenFile.length;
      int i = 0;
      while (i < k)
      {
        com.tencent.qqmail.protocol.UMA.AppNotToOpenFile localAppNotToOpenFile = arrayOfAppNotToOpenFile[i];
        com.tencent.qqmail.utilities.otherapprule.AppNotToOpenFile localAppNotToOpenFile1 = new com.tencent.qqmail.utilities.otherapprule.AppNotToOpenFile();
        ArrayList localArrayList2;
        int j;
        if (localAppNotToOpenFile.package_name == null)
        {
          paramQueryConfigUpdateRspForOC = "";
          localAppNotToOpenFile1.setPackageName(paramQueryConfigUpdateRspForOC);
          localArrayList2 = new ArrayList();
          if (localAppNotToOpenFile.mimetype_list == null) {
            break label198;
          }
          j = 0;
          label112:
          if (j >= localAppNotToOpenFile.mimetype_list.size()) {
            break label198;
          }
          if (localAppNotToOpenFile.mimetype_list.get(j) != null) {
            break label172;
          }
        }
        label172:
        for (paramQueryConfigUpdateRspForOC = "";; paramQueryConfigUpdateRspForOC = new String(((ByteString)localAppNotToOpenFile.mimetype_list.get(j)).getBytes()))
        {
          localArrayList2.add(paramQueryConfigUpdateRspForOC);
          j += 1;
          break label112;
          paramQueryConfigUpdateRspForOC = new String(localAppNotToOpenFile.package_name.getBytes());
          break;
        }
        label198:
        localAppNotToOpenFile1.setAllowMimeList(localArrayList2);
        localArrayList1.add(localAppNotToOpenFile1);
        i += 1;
      }
      OtherAppConfigUtil.saveAppNotToOpenFile(localArrayList1);
    }
  }
  
  private void handleAppUpgrade(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    Object localObject = paramQueryConfigUpdateRspForOC.updateinfo_list_[0];
    try
    {
      paramQueryConfigUpdateRspForOC = new String(((UpdateInfo)localObject).version.getBytes(), "UTF8");
      String str1 = new String(((UpdateInfo)localObject).description.getBytes(), "UTF8");
      String str2 = new String(((UpdateInfo)localObject).title.getBytes(), "UTF8");
      boolean bool = ((UpdateInfo)localObject).pop_tips;
      int i = ((UpdateInfo)localObject).type;
      localObject = ((UpdateInfo)localObject).url;
      QMLog.log(4, "QMPrivateProtocolManager", "newVersion : " + paramQueryConfigUpdateRspForOC + ", description : " + str1 + ", title : " + str2 + ", popTips : " + bool + ", updateType : " + i + ", updateUrl : " + (String)localObject);
      return;
    }
    catch (UnsupportedEncodingException paramQueryConfigUpdateRspForOC)
    {
      QMLog.log(6, "QMPrivateProtocolManager", Log.getStackTraceString(paramQueryConfigUpdateRspForOC));
    }
  }
  
  private void handleHoliday(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    Object localObject1 = FileUtil.getWelcomeSplashPath();
    if ((localObject1 != null) && (!((String)localObject1).equals(""))) {
      FileUtil.delAllFile((String)localObject1);
    }
    localObject1 = new StringBuilder();
    paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.holidaypic_list_;
    int i = 0;
    if (i < paramQueryConfigUpdateRspForOC.length)
    {
      Object localObject2 = paramQueryConfigUpdateRspForOC[i];
      ((StringBuilder)localObject1).append(localObject2.begin_time).append("####").append(localObject2.end_time).append("####").append(localObject2.pic_url).append("####").append(localObject2.duration).append("####").append(localObject2.action).append("####").append(localObject2.pic_md5).append("####").append(localObject2.ret_data);
      if (i != paramQueryConfigUpdateRspForOC.length - 1) {
        ((StringBuilder)localObject1).append("@@@@");
      }
      if (!QMNetworkUtils.isNetworkConnected()) {
        QMLog.log(4, "QMPrivateProtocolManager", "handleHoliday download img network not connect");
      }
      for (;;)
      {
        i += 1;
        break;
        DownloadInfo localDownloadInfo = new DownloadInfo();
        localDownloadInfo.setAccountId(-1);
        localDownloadInfo.setUrl(localObject2.pic_url);
        localDownloadInfo.setSessionType(0);
        localDownloadInfo.setImageDownloadListener(new QMPrivateProtocolManager.6(this));
        ImageDownloadManager.shareInstance().fetchCompressImage(localDownloadInfo, 1);
      }
    }
    SharedPreferenceUtil.setWelcomeSplash(((StringBuilder)localObject1).toString());
  }
  
  private void handleIncrementalAD(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    if (TextUtils.isEmpty(paramQueryConfigUpdateRspForOC.email_type_rule_))
    {
      QMLog.log(5, "QMPrivateProtocolManager", "handleIncrementalAD rule empty");
      return;
    }
    QMSpamTypeManager.sharedInstance().addIncrementalRules(paramQueryConfigUpdateRspForOC.email_type_rule_);
  }
  
  private void handleMiscConfig(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    boolean bool2 = true;
    paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.app_misc_config_;
    if (paramQueryConfigUpdateRspForOC == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "handleMiscConfig AppMiscConfig null");
      return;
    }
    QMSettingManager.sharedInstance().setBottleEntry(paramQueryConfigUpdateRspForOC.bottle_entry);
    QMSettingManager.sharedInstance().setMiscCheckLink(paramQueryConfigUpdateRspForOC.check_link_url);
    Object localObject = QMSettingManager.sharedInstance();
    label81:
    int i;
    if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x4) != 0)
    {
      bool1 = true;
      ((QMSettingManager)localObject).setShowGmailBackground(bool1);
      localObject = QMSettingManager.sharedInstance();
      if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x10) == 0) {
        break label343;
      }
      bool1 = true;
      ((QMSettingManager)localObject).setOutDomainPwdReport(bool1);
      QMSharedPreferenceManager.getInstance().setGmailErrorMsg(paramQueryConfigUpdateRspForOC.gmail_error_message.toString());
      if (!StringUtils.isBlank(paramQueryConfigUpdateRspForOC.check_app_install))
      {
        localObject = new StringBuilder().append(paramQueryConfigUpdateRspForOC.check_app_install).append(":");
        if (!DeviceUtil.isAppInstalled(paramQueryConfigUpdateRspForOC.check_app_install)) {
          break label348;
        }
        i = 1;
        label144:
        DataCollector.logDetailEvent("DetailEvent_Is_App_Install", 0L, 0L, i);
      }
      QMSettingManager.sharedInstance().setShowSplashList(paramQueryConfigUpdateRspForOC.show_splash_history_list);
      localObject = QMSettingManager.sharedInstance();
      if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x100) == 256) {
        break label353;
      }
      bool1 = true;
      label192:
      ((QMSettingManager)localObject).setEnableTranslate(bool1);
      if (paramQueryConfigUpdateRspForOC.translation_hint != null) {
        QMSharedPreferenceManager.getInstance().setTranslateProviderTips(paramQueryConfigUpdateRspForOC.translation_hint.toString());
      }
      if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x800) == 0) {
        break label358;
      }
      bool1 = true;
      label231:
      SharedPreferenceUtil.enableTranslucentBar(bool1);
      QMReportManager.handleReportProportion(paramQueryConfigUpdateRspForOC.network_static_report);
      QMAlarmBroadCast.handleUpdateConfig(paramQueryConfigUpdateRspForOC.android_alarm_control);
      QMSettingManager.sharedInstance().setInquiryMailTipsTimes(paramQueryConfigUpdateRspForOC.receive_mail_tips_times);
      QMSettingManager.sharedInstance().setInquiryMailTipsInterval(paramQueryConfigUpdateRspForOC.receive_mail_tips_interval);
      localObject = QMSettingManager.sharedInstance();
      if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x10000) != 65536) {
        break label363;
      }
      bool1 = true;
      label290:
      ((QMSettingManager)localObject).setAvatarPhotoRedirect(bool1);
      QMSharedPreferenceManager.getInstance().setClearCacheConfig(paramQueryConfigUpdateRspForOC.clear_cache_config.toString());
      localObject = QMSettingManager.sharedInstance();
      if ((paramQueryConfigUpdateRspForOC.misc_flag & 0x40000) != 262144) {
        break label368;
      }
    }
    label343:
    label348:
    label353:
    label358:
    label363:
    label368:
    for (boolean bool1 = bool2;; bool1 = false)
    {
      ((QMSettingManager)localObject).setEnableQQBrowserX5(bool1);
      return;
      bool1 = false;
      break;
      bool1 = false;
      break label81;
      i = 0;
      break label144;
      bool1 = false;
      break label192;
      bool1 = false;
      break label231;
      bool1 = false;
      break label290;
    }
  }
  
  private void handlePopularize(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    PopularizeConfig[] arrayOfPopularizeConfig = paramQueryConfigUpdateRspForOC.popularize_list_;
    ArrayList localArrayList = new ArrayList();
    if (arrayOfPopularizeConfig != null)
    {
      int j = arrayOfPopularizeConfig.length;
      int i = 0;
      if (i < j)
      {
        PopularizeConfig localPopularizeConfig = arrayOfPopularizeConfig[i];
        Popularize localPopularize = new Popularize();
        localPopularize.setServerId(localPopularizeConfig.svr_id);
        localPopularize.setReportId(localPopularizeConfig.report_id);
        localPopularize.setType(localPopularizeConfig.type);
        localPopularize.setPage(localPopularizeConfig.page);
        localPopularize.setBannerPosition(localPopularizeConfig.banner_position);
        localPopularize.setBannerHeight(localPopularizeConfig.banner_height);
        localPopularize.setShowType(localPopularizeConfig.show_type);
        localPopularize.setAction(localPopularizeConfig.action);
        if (localPopularizeConfig.image_url == null)
        {
          paramQueryConfigUpdateRspForOC = "";
          label137:
          localPopularize.setImageUrl(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.image_md5 != null) {
            break label945;
          }
          paramQueryConfigUpdateRspForOC = "";
          label154:
          localPopularize.setImageMd5(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.open_url != null) {
            break label964;
          }
          paramQueryConfigUpdateRspForOC = "";
          label171:
          localPopularize.setOpenUrl(paramQueryConfigUpdateRspForOC);
          localPopularize.setStartTime(localPopularizeConfig.start_time);
          localPopularize.setEndTime(localPopularizeConfig.end_time);
          localPopularize.setDuration(localPopularizeConfig.duration);
          if (localPopularizeConfig.subject != null) {
            break label983;
          }
          paramQueryConfigUpdateRspForOC = "";
          label218:
          localPopularize.setSubject(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.abstracts != null) {
            break label1002;
          }
          paramQueryConfigUpdateRspForOC = "";
          label235:
          localPopularize.setAbstracts(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.content != null) {
            break label1021;
          }
          paramQueryConfigUpdateRspForOC = "";
          label252:
          localPopularize.setContent(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_information != null) {
            break label1040;
          }
          paramQueryConfigUpdateRspForOC = "";
          label269:
          localPopularize.setSubInformation(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_image_url != null) {
            break label1059;
          }
          paramQueryConfigUpdateRspForOC = "";
          label286:
          localPopularize.setSubImageUrl(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_image_md5 != null) {
            break label1078;
          }
          paramQueryConfigUpdateRspForOC = "";
          label303:
          localPopularize.setSubImageMd5(paramQueryConfigUpdateRspForOC);
          localPopularize.setNeedQQAccount(localPopularizeConfig.need_qq_account);
          localPopularize.setId(Popularize.generateId(localPopularize.getServerId(), localPopularize.getPage(), localPopularize.getType()));
          if (localPopularizeConfig.popularize_app_name != null) {
            break label1097;
          }
          paramQueryConfigUpdateRspForOC = "";
          label353:
          localPopularize.setPopularizeAppName(paramQueryConfigUpdateRspForOC);
          localPopularize.setAppInstallAction(localPopularizeConfig.app_install_action);
          localPopularize.setWeight(localPopularizeConfig.weight);
          localPopularize.setCondition(localPopularizeConfig.condition);
          localPopularize.setResourceType(localPopularizeConfig.resource_type);
          if (localPopularizeConfig.from_email != null) {
            break label1116;
          }
          paramQueryConfigUpdateRspForOC = "";
          label410:
          localPopularize.setCommercialFromEmail(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.from_nick != null) {
            break label1135;
          }
          paramQueryConfigUpdateRspForOC = "";
          label427:
          localPopularize.setCommercialFromNick(paramQueryConfigUpdateRspForOC);
          localPopularize.setCommercialConfigHead(localPopularizeConfig.config_head);
          localPopularize.setCommercialConfigTool(localPopularizeConfig.config_tool);
          localPopularize.setCommercialConfigList(localPopularizeConfig.config_list);
          localPopularize.setCommercialConfigMark(localPopularizeConfig.config_mark);
          localPopularize.setSessionType(localPopularizeConfig.session_type);
          localPopularize.setRelatedId(localPopularizeConfig.related_id);
          if (localPopularizeConfig.popularize_app_version != null) {
            break label1154;
          }
          paramQueryConfigUpdateRspForOC = "";
          label504:
          localPopularize.setPopularizeAppVersion(paramQueryConfigUpdateRspForOC);
          localPopularize.setNeedWifi(localPopularizeConfig.need_wifi);
          if (localPopularizeConfig.adxml != null) {
            break label1173;
          }
          paramQueryConfigUpdateRspForOC = "";
          label531:
          localPopularize.setAdXml(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_from_nick != null) {
            break label1192;
          }
          paramQueryConfigUpdateRspForOC = "";
          label548:
          localPopularize.setSub_fromnick(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_subject != null) {
            break label1211;
          }
          paramQueryConfigUpdateRspForOC = "";
          label565:
          localPopularize.setSub_subject(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.sub_abstracts != null) {
            break label1230;
          }
          paramQueryConfigUpdateRspForOC = "";
          label582:
          localPopularize.setSub_abstracts(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.avatar_url != null) {
            break label1249;
          }
          paramQueryConfigUpdateRspForOC = "";
          label599:
          localPopularize.setAvatar_url(paramQueryConfigUpdateRspForOC);
          if (localPopularizeConfig.avatar_md5 != null) {
            break label1268;
          }
          paramQueryConfigUpdateRspForOC = "";
          label616:
          localPopularize.setAvatar_url_md5(paramQueryConfigUpdateRspForOC);
          localPopularize.setStop(localPopularizeConfig.is_stop);
          localPopularize.setTurnId(Math.max(0, localPopularizeConfig.turn_id));
          localPopularize.setProductId(Math.max(0, localPopularizeConfig.product_id));
          paramQueryConfigUpdateRspForOC = PopularizeManager.sharedInstance().getPopularizeBySvrId(localPopularize.getServerId());
          if (paramQueryConfigUpdateRspForOC == null) {
            break label1287;
          }
          localPopularize.setMove(paramQueryConfigUpdateRspForOC.getMove());
          localPopularize.setIsOpen(paramQueryConfigUpdateRspForOC.isOpen());
          label694:
          paramQueryConfigUpdateRspForOC = PopularizeManager.sharedInstance().getPopularizeById(localPopularize.getId());
          if (paramQueryConfigUpdateRspForOC == null) {
            break label1302;
          }
          localPopularize.setLastRenderTime(paramQueryConfigUpdateRspForOC.getLastRenderTime());
          localPopularize.setRender(paramQueryConfigUpdateRspForOC.isRender());
          localPopularize.setClick(paramQueryConfigUpdateRspForOC.isClick());
          localPopularize.setCancel(paramQueryConfigUpdateRspForOC.isCancel());
          localPopularize.setIsRead(paramQueryConfigUpdateRspForOC.isRead());
          localPopularize.setPopByNewMail(paramQueryConfigUpdateRspForOC.isPopByNewMail());
          label764:
          localPopularize.setSubItems(transformPopularizeSubItem(localPopularizeConfig.sub_items, localPopularize, false));
          paramQueryConfigUpdateRspForOC = new com.tencent.qqmail.popularize.model.PopularizeAppConfig();
          if (localPopularizeConfig.app_config != null)
          {
            paramQueryConfigUpdateRspForOC.setPriority(localPopularizeConfig.app_config.priority);
            paramQueryConfigUpdateRspForOC.setSubitems(transformPopularizeSubItem(localPopularizeConfig.app_config.sub_items, localPopularize, true));
          }
          localPopularize.setAppConfig(paramQueryConfigUpdateRspForOC);
          localArrayList.add(localPopularize);
          QMLog.log(4, "QMPrivateProtocolManager", "handlePopularize popularize data is:" + localPopularize.toString());
          if (System.currentTimeMillis() / 1000L <= localPopularize.getEndTime()) {
            break label1335;
          }
          QMLog.log(5, "QMPrivateProtocolManager", "Popularize has expire:" + localPopularize.getSubject());
        }
        for (;;)
        {
          i += 1;
          break;
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.image_url.getBytes());
          break label137;
          label945:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.image_md5.getBytes());
          break label154;
          label964:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.open_url.getBytes());
          break label171;
          label983:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.subject.getBytes());
          break label218;
          label1002:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.abstracts.getBytes());
          break label235;
          label1021:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.content.getBytes());
          break label252;
          label1040:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_information.getBytes());
          break label269;
          label1059:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_image_url.getBytes());
          break label286;
          label1078:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_image_md5.getBytes());
          break label303;
          label1097:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.popularize_app_name.toByteArray());
          break label353;
          label1116:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.from_email.getBytes());
          break label410;
          label1135:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.from_nick.getBytes());
          break label427;
          label1154:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.popularize_app_version.getBytes());
          break label504;
          label1173:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.adxml.getBytes());
          break label531;
          label1192:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_from_nick.getBytes());
          break label548;
          label1211:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_subject.getBytes());
          break label565;
          label1230:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.sub_abstracts.getBytes());
          break label582;
          label1249:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.avatar_url.getBytes());
          break label599;
          label1268:
          paramQueryConfigUpdateRspForOC = new String(localPopularizeConfig.avatar_md5.getBytes());
          break label616;
          label1287:
          localPopularize.setMove(0);
          localPopularize.setIsOpen(true);
          break label694;
          label1302:
          localPopularize.setLastRenderTime(0L);
          localPopularize.setRender(false);
          localPopularize.setClick(false);
          localPopularize.setCancel(false);
          localPopularize.setPopByNewMail(false);
          break label764;
          label1335:
          if ((!StringExtention.isNullOrEmpty(localPopularize.getImageUrl())) && (QMNetworkUtils.isNetworkConnected()) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularize.getImageUrl()) == null)) {
            PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularize.getImageUrl(), localPopularize.getImageMd5(), null);
          }
          if ((!StringExtention.isNullOrEmpty(localPopularize.getSubImageUrl())) && (QMNetworkUtils.isNetworkConnected()) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularize.getSubImageUrl()) == null)) {
            PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularize.getSubImageUrl(), localPopularize.getSubImageMd5(), null);
          }
          if ((!StringExtention.isNullOrEmpty(localPopularize.getAvatar_url())) && (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularize.getAvatar_url()) == null)) {
            PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularize.getAvatar_url(), localPopularize.getAvatar_url_md5(), null);
          }
          if (localPopularize.getType() == 8)
          {
            if ((localPopularize.getResourceType() == 0) || (localPopularize.getResourceType() == 1)) {
              AdvertiseManager.getInstance().downloadPullDownImage(localPopularize.getResourceType(), localPopularize.getImageUrl(), localPopularize.getImageMd5());
            }
            if (!TextUtils.isEmpty(localPopularize.getOpenUrl())) {
              QMSharedPreferenceManager.getInstance().setPullDownADHtml("");
            }
          }
          if (localPopularize.getType() == 9)
          {
            paramQueryConfigUpdateRspForOC = localPopularize.getOpenUrl();
            if (!TextUtils.isEmpty(paramQueryConfigUpdateRspForOC))
            {
              QMSharedPreferenceManager.getInstance().setPopularizeAD(paramQueryConfigUpdateRspForOC, "");
              VirtualAdManager.getInstance().preLoadVirtualAdsMailHtml(localPopularize);
            }
            paramQueryConfigUpdateRspForOC = localPopularize.getAdXml();
            if (!TextUtils.isEmpty(paramQueryConfigUpdateRspForOC))
            {
              NativePageManager.getInstance().setContext(QMApplicationContext.sharedInstance());
              NativePageManager.getInstance().setBaseCachePath(FileUtil.getNativePagesDir());
              NativePageManager.getInstance().setAppOperationDelegate(new NativePageAppOperationDelegate());
              AdLandingPagesPreDownloadHelper.preDownload(paramQueryConfigUpdateRspForOC, "adxml");
            }
            QMSharedPreferenceManager.getInstance().setAdvertiseMailReadTime(0L);
          }
        }
      }
    }
    PopularizeManager.sharedInstance().deleteAllPopularize();
    PopularizeManager.sharedInstance().insertPopularize(localArrayList);
    AdvertiseManager.getInstance().updatePullDownHtml();
  }
  
  private void handlePushConfig(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    PushConfig[] arrayOfPushConfig = paramQueryConfigUpdateRspForOC.push_config_list_;
    ArrayList localArrayList = new ArrayList();
    if ((arrayOfPushConfig != null) && (arrayOfPushConfig.length > 0))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "handlePushConfig size : " + arrayOfPushConfig.length);
      StringBuilder localStringBuilder = new StringBuilder();
      int j = arrayOfPushConfig.length;
      int i = 0;
      if (i < j)
      {
        paramQueryConfigUpdateRspForOC = arrayOfPushConfig[i];
        QMPushConfig localQMPushConfig = new QMPushConfig();
        localQMPushConfig.setId(paramQueryConfigUpdateRspForOC.id);
        localQMPushConfig.setType(paramQueryConfigUpdateRspForOC.type);
        localQMPushConfig.setVersion(paramQueryConfigUpdateRspForOC.version);
        if (paramQueryConfigUpdateRspForOC.content == null) {}
        for (paramQueryConfigUpdateRspForOC = "";; paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.content.toStringUtf8())
        {
          localQMPushConfig.setContent(paramQueryConfigUpdateRspForOC);
          localArrayList.add(localQMPushConfig);
          QMPushConfigUtil.handlePushConfig(localQMPushConfig);
          localStringBuilder.append(localQMPushConfig.getId()).append(":").append(localQMPushConfig.getVersion()).append(";");
          i += 1;
          break;
        }
      }
      QMLog.log(4, "QMPrivateProtocolManager", "svrId:version: " + localStringBuilder.toString());
      OssHelper.pushConfig(new Object[] { localStringBuilder.toString() });
    }
  }
  
  private void handleUpdateDomainConfig(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC) {}
  
  private void handleUpdateUserSetting(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.user_setting_list_;
    int j = paramQueryConfigUpdateRspForOC.length;
    int i = 0;
    while (i < j)
    {
      UserSetting localUserSetting = paramQueryConfigUpdateRspForOC[i];
      if (localUserSetting != null) {
        readyToSetConfigFromUMA(localUserSetting);
      }
      i += 1;
    }
  }
  
  private void handleVidSpread(CloudProtocolResult.QueryConfigUpdateRspForOC paramQueryConfigUpdateRspForOC)
  {
    paramQueryConfigUpdateRspForOC = paramQueryConfigUpdateRspForOC.spreadresult_list_;
    if (paramQueryConfigUpdateRspForOC == null) {
      QMLog.log(5, "QMPrivateProtocolManager", "handleVidSpread spread list null");
    }
    for (;;)
    {
      return;
      if (SharedPreferenceUtil.isWtlogin())
      {
        QMLog.log(5, "QMPrivateProtocolManager", "handleVidSpread already wt return");
        return;
      }
      int j = paramQueryConfigUpdateRspForOC.length;
      int i = 0;
      while (i < j)
      {
        Iterator localIterator = paramQueryConfigUpdateRspForOC[i];
        if (localIterator.spread_type == 1)
        {
          if (localIterator.spread_flag)
          {
            QMLog.log(4, "QMPrivateProtocolManager", "handleVidSpread set to wtlogin login");
            localIterator = AccountManager.shareInstance().getAccountList().iterator();
            while (localIterator.hasNext())
            {
              Account localAccount = (Account)localIterator.next();
              if ((localAccount.isQQMail()) && (!localAccount.isBizMail()))
              {
                QMPrivateProtocolManager.5 local5 = new QMPrivateProtocolManager.5(this);
                changePwd4Wtlogin(localAccount.getId(), local5);
              }
            }
          }
          QMLog.log(4, "QMPrivateProtocolManager", "handleVidSpread set to normal login.");
          SharedPreferenceUtil.setWtlogin(false);
        }
        i += 1;
      }
    }
  }
  
  private CmdQueryConfigUpdateReq.RequestField prepareRequestField(int paramInt, String paramString)
  {
    CmdQueryConfigUpdateReq.RequestField localRequestField = new CmdQueryConfigUpdateReq.RequestField();
    localRequestField.cur_config_version = paramString;
    localRequestField.config_type = paramInt;
    localRequestField.new_config_part_pos = 0;
    localRequestField.new_config_part_len = 0;
    return localRequestField;
  }
  
  private String printBooleanArray(SparseBooleanArray paramSparseBooleanArray)
  {
    if (paramSparseBooleanArray == null) {
      return null;
    }
    int j = paramSparseBooleanArray.size();
    StringBuilder localStringBuilder = new StringBuilder("{");
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(paramSparseBooleanArray.keyAt(i)).append("=").append(paramSparseBooleanArray.valueAt(i));
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private String printIntArray(SparseIntArray paramSparseIntArray)
  {
    if (paramSparseIntArray == null) {
      return null;
    }
    int j = paramSparseIntArray.size();
    StringBuilder localStringBuilder = new StringBuilder("{");
    int i = 0;
    while (i < j)
    {
      if (i > 0) {
        localStringBuilder.append(", ");
      }
      localStringBuilder.append(paramSparseIntArray.keyAt(i)).append("=").append(paramSparseIntArray.valueAt(i));
      i += 1;
    }
    localStringBuilder.append("}");
    return localStringBuilder.toString();
  }
  
  private void readyToSetConfigFromUMA(UserSetting paramUserSetting)
  {
    int j = 0;
    if (QMOfflineOperationManager.shareInstance() == null) {
      return;
    }
    Set localSet = QMOfflineOperationManager.shareInstance().getOffLineOperTypeOfUMA();
    localObject1 = paramUserSetting.global();
    if ((((UserSetting.Global)localObject1).has_maillist_icon()) && (!localSet.contains("18")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "maillist_icon:" + ((UserSetting.Global)localObject1).maillist_icon());
      QMSettingManager.sharedInstance().setShowMailListAvatar(((UserSetting.Global)localObject1).maillist_icon());
    }
    if ((((UserSetting.Global)localObject1).has_aggregate_ad_mail()) && (!localSet.contains("11")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "aggregate_ad_mail:" + ((UserSetting.Global)localObject1).aggregate_ad_mail());
      QMSettingManager.sharedInstance().setAggregateAdMail(((UserSetting.Global)localObject1).aggregate_ad_mail());
    }
    if ((((UserSetting.Global)localObject1).has_aggregate_subscribed_mail()) && (!localSet.contains("12")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "aggregate_subscribed_mail:" + ((UserSetting.Global)localObject1).aggregate_subscribed_mail());
      QMSettingManager.sharedInstance().setAggregateSubscribeMail(((UserSetting.Global)localObject1).aggregate_subscribed_mail());
    }
    if ((((UserSetting.Global)localObject1).has_load_pic_function()) && (!localSet.contains("19")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "load_pic_function:" + ((UserSetting.Global)localObject1).load_pic_function());
      QMSettingManager.sharedInstance().setMailLoadImgType(((UserSetting.Global)localObject1).load_pic_function());
    }
    if ((((UserSetting.Global)localObject1).has_enable_send_sound()) && (!localSet.contains("20")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "enable_send_sound:" + ((UserSetting.Global)localObject1).enable_send_sound());
      QMSettingManager.sharedInstance().setEnableSendMailSound(((UserSetting.Global)localObject1).enable_send_sound());
    }
    if ((((UserSetting.Global)localObject1).has_gesture_password()) && (!localSet.contains("21")) && (((UserSetting.Global)localObject1).gesture_password() != null) && (!((UserSetting.Global)localObject1).gesture_password().equals("")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "gesture_password:" + ((UserSetting.Global)localObject1).gesture_password());
      SharedPreferenceUtil.setGesturePwd(((UserSetting.Global)localObject1).gesture_password());
    }
    if ((((UserSetting.Global)localObject1).has_notify_newmail()) && (!localSet.contains("10")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "notify_newmail:" + ((UserSetting.Global)localObject1).notify_newmail());
      QMSettingManager.sharedInstance().setNewMailPush(((UserSetting.Global)localObject1).notify_newmail());
    }
    if ((((UserSetting.Global)localObject1).has_enable_sound()) && (!localSet.contains("23")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "enable_sound:" + ((UserSetting.Global)localObject1).enable_sound());
      QMSettingManager.sharedInstance().setNewMailPushSound(((UserSetting.Global)localObject1).enable_sound());
    }
    if ((((UserSetting.Global)localObject1).has_enable_incremental_unread_count()) && (!localSet.contains("31")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "incremental_unread_count:" + ((UserSetting.Global)localObject1).enable_incremental_unread_count());
      QMSettingManager.sharedInstance().setIncrementBadge(((UserSetting.Global)localObject1).enable_incremental_unread_count());
    }
    if ((((UserSetting.Global)localObject1).has_newmail_shake_onusing()) && (!localSet.contains("22")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "newmail_shake_onusing:" + ((UserSetting.Global)localObject1).newmail_shake_onusing());
      QMSettingManager.sharedInstance().setNewMailPushVibrate(((UserSetting.Global)localObject1).newmail_shake_onusing());
    }
    if ((((UserSetting.Global)localObject1).has_notify_admail()) && (!localSet.contains("13")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "notify_admail:" + ((UserSetting.Global)localObject1).notify_admail());
      QMSettingManager.sharedInstance().setAdMailNotify(((UserSetting.Global)localObject1).notify_admail());
    }
    if ((((UserSetting.Global)localObject1).has_only_notify_vip()) && (!localSet.contains("7")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "only_notify_vip:" + ((UserSetting.Global)localObject1).only_notify_vip());
      QMSettingManager.sharedInstance().setOnlyNotifyVIP(((UserSetting.Global)localObject1).only_notify_vip());
    }
    if ((((UserSetting.Global)localObject1).has_use_night_mode()) && (!localSet.contains("6")))
    {
      QMLog.log(4, "QMPrivateProtocolManager", "use_night_mode:" + ((UserSetting.Global)localObject1).use_night_mode());
      QMSettingManager.sharedInstance().setUseNightMode(((UserSetting.Global)localObject1).use_night_mode());
    }
    Object localObject2;
    if (((UserSetting.Global)localObject1).has_ua_config())
    {
      QMSettingManager.sharedInstance().setImapUserAgentId(((UserSetting.Global)localObject1).ua_config());
      QMLog.log(4, "QMPrivateProtocolManager", "ua_config:" + ((UserSetting.Global)localObject1).ua_config());
      localObject2 = AccountManager.shareInstance().getAccountList();
      i = 0;
      while (i < ((AccountList)localObject2).size())
      {
        if (((AccountList)localObject2).get(i).isImapMail()) {
          ((AccountList)localObject2).get(i).getProfile().imapUserAgentId = ((UserSetting.Global)localObject1).ua_config();
        }
        i += 1;
      }
    }
    if (((UserSetting.Global)localObject1).has_sys_config()) {}
    try
    {
      localObject2 = (JSONObject)JSONReader.parse(((UserSetting.Global)localObject1).sys_config());
      JSONObject localJSONObject = (JSONObject)((JSONObject)localObject2).get("webproxy");
      if ((localJSONObject.containsKey("isopen")) && (localJSONObject.getIntValue("isopen") == 0))
      {
        i = ((JSONObject)localObject2).getIntValue("closetype");
        switch (i)
        {
        }
      }
    }
    catch (Exception localException)
    {
      for (;;)
      {
        label1036:
        QMLog.log(5, "QMPrivateProtocolManager", "set_sys_config_error", localException);
        continue;
        QMLog.log(4, "QMPrivateProtocolManager", "sys_config: no");
        continue;
        QMLog.log(4, "QMPrivateProtocolManager", "sync_mail_count:" + ((UserSetting.Account)localObject1).sync_mail_count() + " accountId:" + ((UserSetting.Account)localObject1).account_id());
        QMSyncManager.sharedInstance().setSyncMailCountOrDay(((UserSetting.Account)localObject1).account_id(), QMSyncManager.sharedInstance().transformMailCountFromServer(((UserSetting.Account)localObject1).sync_mail_count()));
      }
    }
    for (int i = 1;; i = 0)
    {
      if (i == 0) {
        break label1906;
      }
      QMSettingManager.sharedInstance().setSysConfig(((UserSetting.Global)localObject1).sys_config());
      QMLog.log(4, "QMPrivateProtocolManager", "sys_config:" + ((UserSetting.Global)localObject1).sys_config());
      if (((UserSetting.Global)localObject1).has_application_in_home())
      {
        QMLog.log(4, "QMPrivateProtocolManager", "application_in_home:" + ((UserSetting.Global)localObject1).application_in_home());
        FolderDataManager.sharedInstance().saveApplicationShowInHome(((UserSetting.Global)localObject1).application_in_home());
      }
      if (((UserSetting.Global)localObject1).has_enable_notify_detail())
      {
        QMLog.log(4, "QMPrivateProtocolManager", "enable_notify_detail:" + ((UserSetting.Global)localObject1).enable_notify_detail());
        QMSettingManager.sharedInstance().setShowMailDetail(((UserSetting.Global)localObject1).enable_notify_detail());
      }
      paramUserSetting = paramUserSetting.account();
      if (paramUserSetting == null) {
        break;
      }
      i = j;
      while (i < paramUserSetting.size())
      {
        localObject1 = (UserSetting.Account)paramUserSetting.get(i);
        if (localObject1 != null)
        {
          localObject2 = AccountManager.shareInstance().getAccountList().getAccountById(((UserSetting.Account)localObject1).account_id());
          if (localObject2 != null)
          {
            if ((((UserSetting.Account)localObject1).has_personal_signature()) && (!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 24)) && (((UserSetting.Account)localObject1).personal_signature() != null))
            {
              QMLog.log(4, "QMPrivateProtocolManager", "personal_signature:" + ((UserSetting.Account)localObject1).personal_signature() + " accountId:" + ((UserSetting.Account)localObject1).account_id());
              QMSettingManager.sharedInstance().setAccountSignature(((UserSetting.Account)localObject1).account_id(), ((UserSetting.Account)localObject1).personal_signature());
            }
            if ((((UserSetting.Account)localObject1).has_sync_mail_count()) && (!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 25)))
            {
              if (!((Account)localObject2).isTencentDotCom()) {
                break label1918;
              }
              QMLog.log(4, "QMPrivateProtocolManager", "sync_mail_day:" + ((UserSetting.Account)localObject1).sync_mail_count() + " accountId:" + ((UserSetting.Account)localObject1).account_id());
              QMSyncManager.sharedInstance().setSyncMailCountOrDay(((UserSetting.Account)localObject1).account_id(), QMSyncManager.sharedInstance().transformMailDayFromServer(((UserSetting.Account)localObject1).sync_mail_count()));
            }
            if ((((UserSetting.Account)localObject1).has_newmail_push_way()) && (!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 16)))
            {
              QMLog.log(4, "QMPrivateProtocolManager", "newmail_push_way:" + ((UserSetting.Account)localObject1).newmail_push_way() + " accountId:" + ((UserSetting.Account)localObject1).account_id());
              QMSyncManager.sharedInstance().setSyncMethod(((UserSetting.Account)localObject1).account_id(), QMSyncManager.sharedInstance().transformSyncMethodFromServer(((UserSetting.Account)localObject1).newmail_push_way()));
            }
            if ((((UserSetting.Account)localObject1).has_get_newmail_freq()) && (!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 17)))
            {
              j = QMSyncManager.sharedInstance().getSyncMethod(((UserSetting.Account)localObject1).account_id());
              if ((!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 16)) && (j == 2))
              {
                QMLog.log(4, "QMPrivateProtocolManager", "get_newmail_freq:" + ((UserSetting.Account)localObject1).get_newmail_freq() + " accountId:" + ((UserSetting.Account)localObject1).account_id());
                QMSyncManager.sharedInstance().setSyncMethod(((UserSetting.Account)localObject1).account_id(), QMSyncManager.sharedInstance().transformNewMailRateFromServer(((UserSetting.Account)localObject1).get_newmail_freq()), j);
              }
            }
            if ((((UserSetting.Account)localObject1).has_aggregate_bysubject()) && (!localSet.contains(((UserSetting.Account)localObject1).account_id() + "_" + 28)))
            {
              QMLog.log(4, "QMPrivateProtocolManager", "aggregate by subject:" + ((UserSetting.Account)localObject1).aggregate_bysubject() + ",accountId:" + ((UserSetting.Account)localObject1).account_id());
              QMSettingManager.sharedInstance().setAggregateSubject(((UserSetting.Account)localObject1).account_id(), ((UserSetting.Account)localObject1).aggregate_bysubject());
            }
          }
        }
        i += 1;
      }
      break;
      boolean bool = StringExtention.isNullOrEmpty(QMSettingManager.sharedInstance().getSysConfig());
      if (bool) {
        break label1036;
      }
    }
  }
  
  private void resetVid()
  {
    synchronized (lock_resetVid)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "resetVid called");
      QMSharedPreferenceManager.getInstance().setVid(0L);
      QMSharedPreferenceManager.getInstance().setVidPwd("");
      QMApplicationContext.sharedInstance().initVid();
      return;
    }
  }
  
  private void retryUmaLoginAddAccount(Account paramAccount, Profile paramProfile, String paramString1, String paramString2, Bitmap paramBitmap)
  {
    umaLogin(new QMPrivateProtocolManager.19(this, paramAccount, paramProfile, paramString1, paramString2, paramBitmap));
  }
  
  /* Error */
  private void saveAvatarSha(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +13 -> 14
    //   4: iconst_5
    //   5: ldc 33
    //   7: ldc_w 1952
    //   10: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   13: return
    //   14: invokestatic 319	com/tencent/qqmail/utilities/fileextention/FileUtil:getEmailIconDirPath	()Ljava/lang/String;
    //   17: astore_3
    //   18: new 209	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   25: aload_3
    //   26: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_1
    //   43: new 321	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 1953	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 1956	java/io/File:exists	()Z
    //   56: ifeq +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 1959	java/io/File:isDirectory	()Z
    //   63: ifne +8 -> 71
    //   66: aload_3
    //   67: invokevirtual 1962	java/io/File:mkdir	()Z
    //   70: pop
    //   71: new 209	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   85: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 14
    //   90: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_1
    //   97: new 1964	java/io/FileOutputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 1965	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: aload_3
    //   109: aload_2
    //   110: invokevirtual 663	java/lang/String:getBytes	()[B
    //   113: iconst_0
    //   114: aload_2
    //   115: invokevirtual 663	java/lang/String:getBytes	()[B
    //   118: arraylength
    //   119: invokevirtual 1969	java/io/FileOutputStream:write	([BII)V
    //   122: aload_3
    //   123: ifnull -110 -> 13
    //   126: aload_3
    //   127: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   130: return
    //   131: astore_1
    //   132: bipush 6
    //   134: ldc 33
    //   136: aload_1
    //   137: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   143: return
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: astore_1
    //   150: bipush 6
    //   152: ldc 33
    //   154: aload 4
    //   156: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: ifnull -150 -> 13
    //   166: aload_2
    //   167: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   170: return
    //   171: astore_1
    //   172: bipush 6
    //   174: ldc 33
    //   176: aload_1
    //   177: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   180: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   183: return
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +7 -> 195
    //   191: aload_1
    //   192: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: bipush 6
    //   200: ldc 33
    //   202: aload_1
    //   203: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   206: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: goto -14 -> 195
    //   212: astore_2
    //   213: goto -26 -> 187
    //   216: astore 4
    //   218: aload_3
    //   219: astore_2
    //   220: goto -72 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	QMPrivateProtocolManager
    //   0	223	1	paramString1	String
    //   0	223	2	paramString2	String
    //   17	202	3	localObject	Object
    //   144	11	4	localException1	Exception
    //   216	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   126	130	131	java/lang/Exception
    //   97	106	144	java/lang/Exception
    //   166	170	171	java/lang/Exception
    //   97	106	184	finally
    //   191	195	197	java/lang/Exception
    //   108	122	212	finally
    //   150	162	212	finally
    //   108	122	216	java/lang/Exception
  }
  
  private void setNick(String paramString1, String paramString2)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "setNick network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "setNick info null");
      return;
    }
    SetEMailNicknameReqInfo localSetEMailNicknameReqInfo = new SetEMailNicknameReqInfo();
    localSetEMailNicknameReqInfo.email = paramString1;
    localSetEMailNicknameReqInfo.nickname = paramString2;
    localCloudProtocolInfo.cmd_unique_id_ = "";
    localCloudProtocolInfo.set_nick_list_ = new SetEMailNicknameReqInfo[1];
    localCloudProtocolInfo.set_nick_list_[0] = localSetEMailNicknameReqInfo;
    CloudProtocolService.SetNick(localCloudProtocolInfo, new QMPrivateProtocolManager.15(this, paramString1));
  }
  
  public static QMPrivateProtocolManager sharedInstance()
  {
    return instance;
  }
  
  private void startLoadEmailIcon()
  {
    if (!QMNetworkUtils.isNetworkConnected()) {
      QMLog.log(5, "QMPrivateProtocolManager", "startLoadEmailIcon. network not valid.");
    }
    do
    {
      return;
      synchronized (this.emailList)
      {
        ArrayList localArrayList1 = new ArrayList(this.emailList.size());
        Iterator localIterator = this.emailList.iterator();
        if (localIterator.hasNext()) {
          localArrayList1.add(((String)localIterator.next()).toLowerCase());
        }
      }
      this.emailList.clear();
    } while (localArrayList2.size() <= 0);
    ??? = new QMCallback();
    ((QMCallback)???).setOnSuccess(new QMPrivateProtocolManager.2(this, localArrayList2));
    ((QMCallback)???).setOnError(new QMPrivateProtocolManager.3(this, localArrayList2));
    if (QMSettingManager.sharedInstance().isAvatarPhotoRedirect())
    {
      syncEmailIconByRedirect(localArrayList2, (QMCallback)???);
      return;
    }
    syncPhoto(localArrayList2, (QMCallback)???);
  }
  
  private void syncContactType(int paramInt1, int paramInt2, String[] paramArrayOfString, boolean paramBoolean)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncContactType network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncContactType info null");
      return;
    }
    localCloudProtocolInfo.cmd_unique_id_ = "";
    LinkedList localLinkedList = new LinkedList();
    Collections.addAll(localLinkedList, paramArrayOfString);
    if (paramBoolean)
    {
      localCloudProtocolInfo.set_contact_type_req_ = new CmdSetContactTypeReq();
      localCloudProtocolInfo.set_contact_type_req_.type = paramInt1;
      localCloudProtocolInfo.set_contact_type_req_.email = localLinkedList;
      CloudProtocolService.SetContactType(localCloudProtocolInfo, new QMPrivateProtocolManager.8(this, paramArrayOfString));
      return;
    }
    localCloudProtocolInfo.clr_contact_type_req_ = new CmdClrContactTypeReq();
    localCloudProtocolInfo.clr_contact_type_req_.type = 4;
    localCloudProtocolInfo.clr_contact_type_req_.email = localLinkedList;
    CloudProtocolService.ClearContactType(localCloudProtocolInfo, new QMPrivateProtocolManager.9(this, paramArrayOfString));
  }
  
  private ArrayList<com.tencent.qqmail.popularize.model.PopularizeSubItem> transformPopularizeSubItem(LinkedList<com.tencent.qqmail.protocol.UMA.PopularizeSubItem> paramLinkedList, Popularize paramPopularize, boolean paramBoolean)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramLinkedList != null) && (paramLinkedList.size() > 0))
    {
      Iterator localIterator = paramLinkedList.iterator();
      if (localIterator.hasNext())
      {
        com.tencent.qqmail.protocol.UMA.PopularizeSubItem localPopularizeSubItem1 = (com.tencent.qqmail.protocol.UMA.PopularizeSubItem)localIterator.next();
        com.tencent.qqmail.popularize.model.PopularizeSubItem localPopularizeSubItem = new com.tencent.qqmail.popularize.model.PopularizeSubItem();
        localPopularizeSubItem.setPopularizeId(paramPopularize.getId());
        if (localPopularizeSubItem1.text == null)
        {
          paramLinkedList = "";
          label77:
          localPopularizeSubItem.setText(paramLinkedList);
          if (localPopularizeSubItem1.image_url != null) {
            break label372;
          }
          paramLinkedList = "";
          label94:
          localPopularizeSubItem.setImageUrl(paramLinkedList);
          if (localPopularizeSubItem1.image_md5 != null) {
            break label391;
          }
          paramLinkedList = "";
          label111:
          localPopularizeSubItem.setImageMd5(paramLinkedList);
          localPopularizeSubItem.setPosition(localPopularizeSubItem1.position);
          localPopularizeSubItem.setSequence(localPopularizeSubItem1.sequence);
          localPopularizeSubItem.setShowType(localPopularizeSubItem1.show_type);
          localPopularizeSubItem.setCondition(localPopularizeSubItem1.condition);
          localPopularizeSubItem.setAction(localPopularizeSubItem1.action);
          if (localPopularizeSubItem1.open_url != null) {
            break label410;
          }
          paramLinkedList = "";
          label178:
          localPopularizeSubItem.setOpenUrl(paramLinkedList);
          localPopularizeSubItem.setServerId(localPopularizeSubItem1.svr_id);
          localPopularizeSubItem.setBottomRatio(localPopularizeSubItem1.bottom_ratio);
          localPopularizeSubItem.setId(com.tencent.qqmail.popularize.model.PopularizeSubItem.generateId(localPopularizeSubItem.getServerId(), localPopularizeSubItem.getPopularizeId()));
          localPopularizeSubItem.setIsRelated(paramBoolean);
          paramLinkedList = PopularizeManager.sharedInstance().getPopularizeSubItemById(localPopularizeSubItem.getPopularizeId(), localPopularizeSubItem.getId());
          if (paramLinkedList == null) {
            break label429;
          }
          localPopularizeSubItem.setLastRenderTime(paramLinkedList.getLastRenderTime());
          localPopularizeSubItem.setIsRender(paramLinkedList.isRender());
          localPopularizeSubItem.setIsClick(paramLinkedList.isClick());
          localPopularizeSubItem.setIsClickMyApp(paramLinkedList.isClickMyApp());
          localPopularizeSubItem.setIsCancel(paramLinkedList.isCancel());
        }
        for (;;)
        {
          localArrayList.add(localPopularizeSubItem);
          if ((StringExtention.isNullOrEmpty(localPopularizeSubItem.getImageUrl())) || (!QMNetworkUtils.isNetworkConnected()) || (PopularizeThumbManager.sharedInstance().getPopularizeThumb(localPopularizeSubItem.getImageUrl()) != null)) {
            break;
          }
          PopularizeThumbManager.sharedInstance().loadPopularizeThumbCheckMd5(localPopularizeSubItem.getImageUrl(), localPopularizeSubItem.getImageMd5(), null);
          break;
          paramLinkedList = new String(localPopularizeSubItem1.text.getBytes());
          break label77;
          label372:
          paramLinkedList = new String(localPopularizeSubItem1.image_url.getBytes());
          break label94;
          label391:
          paramLinkedList = new String(localPopularizeSubItem1.image_md5.getBytes());
          break label111;
          label410:
          paramLinkedList = new String(localPopularizeSubItem1.open_url.getBytes());
          break label178;
          label429:
          localPopularizeSubItem.setLastRenderTime(0L);
          localPopularizeSubItem.setIsRender(false);
          localPopularizeSubItem.setIsClick(false);
          localPopularizeSubItem.setIsClickMyApp(false);
          localPopularizeSubItem.setIsCancel(false);
        }
      }
    }
    return localArrayList;
  }
  
  private void updateConfigInternal(int paramInt, @NonNull SparseBooleanArray paramSparseBooleanArray)
  {
    if (!PermissionUtils.hasRequiredPermission(QMApplicationContext.sharedInstance()))
    {
      QMLog.log(5, "QMPrivateProtocolManager", "updateConfig miss permission");
      return;
    }
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "updateConfig network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "updateConfig info null");
      return;
    }
    SPManager.getSp("user_info");
    int j = paramSparseBooleanArray.size();
    CmdQueryConfigUpdateReq.RequestField[] arrayOfRequestField = new CmdQueryConfigUpdateReq.RequestField[j];
    int i = 0;
    if (i < j)
    {
      int k = paramSparseBooleanArray.keyAt(i);
      if (paramSparseBooleanArray.valueAt(i))
      {
        localObject = "";
        label121:
        localObject = prepareRequestField(k, (String)localObject);
        switch (k)
        {
        }
      }
      for (;;)
      {
        arrayOfRequestField[i] = localObject;
        i += 1;
        break;
        localObject = getConfigTypeVersion(k);
        break label121;
        SpreadTypeList localSpreadTypeList = new SpreadTypeList();
        localSpreadTypeList.spread_type.add(Integer.valueOf(1));
        try
        {
          ((CmdQueryConfigUpdateReq.RequestField)localObject).extra_param = ByteString.copyFrom(localSpreadTypeList.toByteArray());
        }
        catch (IOException localIOException1)
        {
          QMLog.log(6, "QMPrivateProtocolManager", "spread_type error", localIOException1);
        }
        continue;
        PopularizeReqExtraParam localPopularizeReqExtraParam = new PopularizeReqExtraParam();
        localPopularizeReqExtraParam.image_times = QMUIKit.getPopularizeReqImageTimes();
        try
        {
          ((CmdQueryConfigUpdateReq.RequestField)localObject).extra_param = ByteString.copyFrom(localPopularizeReqExtraParam.toByteArray());
        }
        catch (IOException localIOException2)
        {
          QMLog.log(6, "QMPrivateProtocolManager", "image_times error", localIOException2);
        }
      }
    }
    Object localObject = new CloudProtocolInfo.QueryConfigUpdateRequest();
    ((CloudProtocolInfo.QueryConfigUpdateRequest)localObject).request_list_ = arrayOfRequestField;
    localCloudProtocolInfo.query_config_update_req_ = ((CloudProtocolInfo.QueryConfigUpdateRequest)localObject);
    i = paramInt;
    if (AppStatusUtil.isAppOnForeground()) {
      i = paramInt | 0x1;
    }
    localCloudProtocolInfo.query_config_update_req_.call_scene = i;
    QMLog.log(4, "QMPrivateProtocolManager", "updateConfig, callScene: " + i + ", types: " + printBooleanArray(paramSparseBooleanArray));
    CloudProtocolService.QueryConfigUpdate(localCloudProtocolInfo, new QMPrivateProtocolManager.4(this));
  }
  
  public void addAccount(Profile paramProfile, String paramString1, String paramString2, String paramString3, int paramInt, String paramString4, Bitmap paramBitmap, boolean paramBoolean1, boolean paramBoolean2)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
    if (localAccount == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addAccount local account not exist:" + paramProfile.mailAddress);
      return;
    }
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addAccount info null");
      return;
    }
    if (paramProfile == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addAccount profile null");
      return;
    }
    AccountManager.shareInstance().updateAccountAttr(paramInt, 32, true);
    SharedPreferenceUtil.setAccountListChanged(true);
    QMLog.log(4, "QMPrivateProtocolManager", "addAccount info :" + paramString2 + " " + localCloudProtocolInfo.uma_id_ + ", " + localCloudProtocolInfo.uma_psw_md5_sum_);
    localCloudProtocolInfo.account_name_ = paramProfile.mailAddress;
    localCloudProtocolInfo.add_account_info_ = new CloudProtocolInfo.AccountInfo();
    localCloudProtocolInfo.add_account_info_.email_ = paramString2;
    localCloudProtocolInfo.add_account_info_.id_ = paramInt;
    EmailProtocolInfo localEmailProtocolInfo1 = new EmailProtocolInfo();
    EmailProtocolInfo localEmailProtocolInfo2 = new EmailProtocolInfo();
    localEmailProtocolInfo1.domain = paramString1;
    if (paramProfile.protocolType == 0)
    {
      localEmailProtocolInfo1.type = 2;
      localEmailProtocolInfo1.host = paramProfile.pop3Server;
      localEmailProtocolInfo1.port = paramProfile.pop3Port;
      localEmailProtocolInfo1.psw = paramProfile.pop3Password;
      localEmailProtocolInfo1.psw_type = 0;
      if (paramProfile.pop3UsingSSL)
      {
        localEmailProtocolInfo1.port = paramProfile.pop3SSLPort;
        localEmailProtocolInfo1.security = 2;
        localEmailProtocolInfo2.type = 5;
        localEmailProtocolInfo2.host = paramProfile.smtpServer;
        localEmailProtocolInfo2.port = paramProfile.smtpPort;
        localEmailProtocolInfo2.psw = paramProfile.smtpPassword;
        localEmailProtocolInfo2.psw_type = 0;
        if (!paramProfile.smtpUsingSSL) {
          break label506;
        }
        localEmailProtocolInfo2.security = 2;
        localEmailProtocolInfo2.port = paramProfile.smtpSSLPort;
      }
    }
    label506:
    do
    {
      for (;;)
      {
        localCloudProtocolInfo.add_account_info_.recv_ = localEmailProtocolInfo1;
        localCloudProtocolInfo.add_account_info_.send_ = localEmailProtocolInfo2;
        if (paramString2.toLowerCase().endsWith("@tencent.com"))
        {
          localEmailProtocolInfo1.psw = "";
          localEmailProtocolInfo2.psw = "";
        }
        if ((paramProfile.protocolType != 100) && (!QMSettingManager.sharedInstance().isOutDomainPwdReport()))
        {
          localEmailProtocolInfo1.psw = "";
          localEmailProtocolInfo2.psw = "";
        }
        CloudProtocolService.AddAccount(localCloudProtocolInfo, new QMPrivateProtocolManager.18(this, paramInt, paramString4, paramString2, paramBitmap, paramString3, paramProfile, paramBoolean1, localAccount, paramString1, paramBoolean2));
        return;
        localEmailProtocolInfo1.port = paramProfile.pop3Port;
        localEmailProtocolInfo1.security = 1;
        break;
        localEmailProtocolInfo2.security = 1;
        localEmailProtocolInfo2.port = paramProfile.smtpPort;
        continue;
        if (paramProfile.protocolType == 1)
        {
          localEmailProtocolInfo1.type = 1;
          localEmailProtocolInfo1.host = paramProfile.imapServer;
          localEmailProtocolInfo1.port = paramProfile.imapPort;
          if (paramProfile.imapUsingSSL)
          {
            localEmailProtocolInfo1.security = 2;
            localEmailProtocolInfo1.port = paramProfile.imapSSLPort;
            localEmailProtocolInfo2.type = 5;
            localEmailProtocolInfo2.host = paramProfile.smtpServer;
            localEmailProtocolInfo2.port = paramProfile.smtpPort;
            if (!paramProfile.smtpUsingSSL) {
              break label682;
            }
            localEmailProtocolInfo2.security = 2;
          }
          for (localEmailProtocolInfo2.port = paramProfile.smtpSSLPort;; localEmailProtocolInfo2.port = paramProfile.smtpPort)
          {
            if (paramProfile.isOauth) {
              break label700;
            }
            localEmailProtocolInfo1.psw = paramProfile.imapPassword;
            localEmailProtocolInfo1.psw_type = 0;
            localEmailProtocolInfo2.psw = paramProfile.smtpPassword;
            localEmailProtocolInfo2.psw_type = 0;
            break;
            localEmailProtocolInfo1.security = 1;
            localEmailProtocolInfo1.port = paramProfile.imapPort;
            break label578;
            localEmailProtocolInfo2.security = 1;
          }
          String str = "1" + localAccount.getRefreshToken();
          localEmailProtocolInfo1.psw = str;
          localEmailProtocolInfo1.psw_type = 3;
          localEmailProtocolInfo2.psw = str;
          localEmailProtocolInfo2.psw_type = 3;
        }
        else if (paramProfile.protocolType == 3)
        {
          localEmailProtocolInfo1.type = 4;
          localEmailProtocolInfo1.host = paramProfile.exchangeServer;
          localEmailProtocolInfo1.psw = paramProfile.exchangePassword;
          localEmailProtocolInfo1.psw_type = 0;
          if (paramProfile.exchangeUsingSSL)
          {
            localEmailProtocolInfo1.security = 2;
            localEmailProtocolInfo1.port = 443;
          }
          for (;;)
          {
            localEmailProtocolInfo2.type = 4;
            localEmailProtocolInfo2.host = paramProfile.exchangeServer;
            localEmailProtocolInfo2.psw = paramProfile.exchangePassword;
            localEmailProtocolInfo2.psw_type = 0;
            if (!paramProfile.exchangeUsingSSL) {
              break label877;
            }
            localEmailProtocolInfo2.security = 2;
            localEmailProtocolInfo2.port = 443;
            break;
            localEmailProtocolInfo1.security = 1;
          }
          localEmailProtocolInfo2.security = 1;
        }
        else
        {
          if (paramProfile.protocolType != 4) {
            break label1031;
          }
          localEmailProtocolInfo1.type = 3;
          localEmailProtocolInfo1.host = paramProfile.activeSyncServer;
          localEmailProtocolInfo1.psw = paramProfile.activeSyncPassword;
          localEmailProtocolInfo1.psw_type = 0;
          if (paramProfile.activeSyncUsingSSL) {
            localEmailProtocolInfo1.security = 2;
          }
          for (localEmailProtocolInfo1.port = 443;; localEmailProtocolInfo1.port = 80)
          {
            localEmailProtocolInfo2.type = 3;
            localEmailProtocolInfo2.host = paramProfile.activeSyncServer;
            localEmailProtocolInfo2.psw = paramProfile.activeSyncPassword;
            localEmailProtocolInfo2.psw_type = 0;
            if (!paramProfile.activeSyncUsingSSL) {
              break label1015;
            }
            localEmailProtocolInfo2.security = 2;
            localEmailProtocolInfo2.port = 443;
            break;
            localEmailProtocolInfo1.security = 1;
          }
          localEmailProtocolInfo2.security = 1;
          localEmailProtocolInfo2.port = 80;
        }
      }
    } while (paramProfile.protocolType != 100);
    label578:
    label877:
    label1015:
    localEmailProtocolInfo1.type = 6;
    label682:
    label700:
    localEmailProtocolInfo2.type = 6;
    label1031:
    if ((SharedPreferenceUtil.isWtlogin()) && (!paramBoolean2)) {}
    for (localEmailProtocolInfo1.psw_type = 2;; localEmailProtocolInfo1.psw_type = 1)
    {
      localEmailProtocolInfo2.psw = paramString3;
      localEmailProtocolInfo1.psw = paramString3;
      break;
    }
  }
  
  public void addRelatedAccount(String paramString1, String paramString2, String paramString3, int paramInt, String paramString4)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addRelatedAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "addRelatedAccount info null");
      return;
    }
    localCloudProtocolInfo.add_account_info_ = new CloudProtocolInfo.AccountInfo();
    localCloudProtocolInfo.account_name_ = paramString3;
    localCloudProtocolInfo.add_account_info_.email_ = paramString3;
    localCloudProtocolInfo.add_account_info_.id_ = paramInt;
    localCloudProtocolInfo.add_account_info_.recv_ = new EmailProtocolInfo();
    localCloudProtocolInfo.add_account_info_.send_ = new EmailProtocolInfo();
    localCloudProtocolInfo.add_account_info_.recv_.domain = paramString4;
    paramString4 = localCloudProtocolInfo.add_account_info_;
    paramString4.recv_.type = 6;
    paramString4.send_.type = 6;
    paramString4.recv_.psw = paramString2;
    paramString4.send_.psw = paramString2;
    paramString4.recv_.psw_type = 1;
    localCloudProtocolInfo.add_account_info_.recv_.associate_uin = Long.parseLong(paramString1);
    CloudProtocolService.AddAccount(localCloudProtocolInfo, new QMPrivateProtocolManager.22(this, paramString3));
  }
  
  public void alignAccount()
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "alignAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "alignAccount info null");
      return;
    }
    AddAccountLocalLogUtil.timeLineAccountChange("APP", "doAlignAccount");
    CloudProtocolService.LstAccount(localCloudProtocolInfo, new QMPrivateProtocolManager.25(this));
  }
  
  public final void bindSetPhotoWatcher(SetPhotoWatcher paramSetPhotoWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramSetPhotoWatcher, paramBoolean);
  }
  
  public final void bindSyncNickWatcher(SyncNickWatcher paramSyncNickWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramSyncNickWatcher, paramBoolean);
  }
  
  public final void bindSyncPhotoWatcher(SyncPhotoWatcher paramSyncPhotoWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramSyncPhotoWatcher, paramBoolean);
  }
  
  public void bindWipeAppWatcher(WipeAppWatcher paramWipeAppWatcher, boolean paramBoolean)
  {
    Watchers.bind(paramWipeAppWatcher, paramBoolean);
  }
  
  public void changePwd4Wtlogin(int paramInt, QMGeneralCallback paramQMGeneralCallback)
  {
    if ((!QMNetworkUtils.isNetworkConnected()) || (!PermissionUtils.hasRequiredPermission(QMApplicationContext.sharedInstance()))) {
      QMLog.log(5, "QMPrivateProtocolManager", "changePwd4Wtlogin network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
    }
    do
    {
      return;
      if (CloudProtocolHelper.getCommonInfo() == null)
      {
        QMLog.log(5, "QMPrivateProtocolManager", "changePwd4Wtlogin info null");
        return;
      }
      Object localObject = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      if (localObject == null)
      {
        QMLog.log(6, "QMPrivateProtocolManager", "changePwd4Wtlogin account is null");
        return;
      }
      if ((!((Account)localObject).isQQMail()) || (((Account)localObject).isBizMail()))
      {
        QMLog.log(5, "QMPrivateProtocolManager", "changePwd4Wtlogin account is not qqmail:" + ((Account)localObject).getEmail() + ", acc is biz:" + ((Account)localObject).isBizMail());
        return;
      }
      QMLog.log(4, "QMPrivateProtocolManager", "changePwd4Wtlogin:" + ((Account)localObject).getEmail());
      localObject = (QQMailAccount)localObject;
      String str = QMAppInterface.getRuntime().getAccount();
      if (((QQMailAccount)localObject).getUin().equals(str))
      {
        TimMailLoginManager.requestA2AndSkey(str, null, new QMPrivateProtocolManager.28(this, paramQMGeneralCallback, paramInt));
        return;
      }
      QMLog.log(5, "QMPrivateProtocolManager", String.format("changePwd4Wtlogin uin[%s], ssoAccount[%s]", new Object[] { ((QQMailAccount)localObject).getUin(), str }));
      PasswordErrHandler.saveStateAndShowErr(paramInt, -1);
    } while (paramQMGeneralCallback == null);
    paramQMGeneralCallback.onError();
  }
  
  public void clearPopularizeAndMiscConfigVersion()
  {
    QMLog.log(4, "QMPrivateProtocolManager", "clearPopularizeAndMiscConfigVersion when app upgrade");
    SPManager.getEditor("user_info").remove("configtype_6").remove("configtype_11").apply();
  }
  
  public void delAccount(int paramInt, String paramString)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "delAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "delAccount info null");
      return;
    }
    SharedPreferenceUtil.setAccountListChanged(true);
    localCloudProtocolInfo.account_name_ = paramString;
    localCloudProtocolInfo.account_id_ = paramInt;
    CloudProtocolService.DeleteAccount(localCloudProtocolInfo, new QMPrivateProtocolManager.23(this, paramInt, paramString));
  }
  
  public void delAccountPhoto(Profile paramProfile, String paramString, int paramInt)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "delAccountPhoto network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "delAccountPhoto info null");
      return;
    }
    Object localObject = new DelEMailPhotoReqInfo();
    ((DelEMailPhotoReqInfo)localObject).email = paramString;
    localCloudProtocolInfo.del_photo_list_ = new DelEMailPhotoReqInfo[1];
    localCloudProtocolInfo.del_photo_list_[0] = localObject;
    if ((paramString == null) || (paramString.split("@").length < 2))
    {
      QMLog.log(6, "QMPrivateProtocolManager", "delAccountPhoto email err : " + paramString);
      return;
    }
    localObject = new EmailProtocolInfo();
    if (paramInt == 2)
    {
      ((EmailProtocolInfo)localObject).type = 2;
      ((EmailProtocolInfo)localObject).host = paramProfile.pop3Server;
      ((EmailProtocolInfo)localObject).psw = paramProfile.pop3Password;
      if (paramProfile.pop3UsingSSL)
      {
        ((EmailProtocolInfo)localObject).security = 2;
        ((EmailProtocolInfo)localObject).port = paramProfile.pop3SSLPort;
      }
    }
    for (;;)
    {
      CloudProtocolService.DelPhoto(localCloudProtocolInfo, new QMPrivateProtocolManager.17(this, paramString));
      return;
      ((EmailProtocolInfo)localObject).security = 1;
      ((EmailProtocolInfo)localObject).port = paramProfile.pop3Port;
      continue;
      if (paramInt == 1)
      {
        ((EmailProtocolInfo)localObject).type = 1;
        ((EmailProtocolInfo)localObject).host = paramProfile.imapServer;
        ((EmailProtocolInfo)localObject).psw = paramProfile.imapPassword;
        if (paramProfile.imapUsingSSL)
        {
          ((EmailProtocolInfo)localObject).security = 2;
          ((EmailProtocolInfo)localObject).port = paramProfile.imapSSLPort;
        }
        else
        {
          ((EmailProtocolInfo)localObject).security = 1;
          ((EmailProtocolInfo)localObject).port = paramProfile.imapPort;
        }
      }
      else if (paramInt == 4)
      {
        ((EmailProtocolInfo)localObject).type = 4;
        ((EmailProtocolInfo)localObject).host = paramProfile.exchangeServer;
        ((EmailProtocolInfo)localObject).psw = paramProfile.exchangePassword;
      }
      else if (paramInt == 3)
      {
        ((EmailProtocolInfo)localObject).type = 3;
        ((EmailProtocolInfo)localObject).host = paramProfile.activeSyncServer;
        ((EmailProtocolInfo)localObject).psw = paramProfile.activeSyncPassword;
      }
      else
      {
        if (paramInt != 6) {
          break;
        }
        ((EmailProtocolInfo)localObject).type = 6;
        ((EmailProtocolInfo)localObject).psw = paramProfile.QQPassword;
        ((EmailProtocolInfo)localObject).psw_type = 1;
      }
    }
    QMLog.log(6, "QMPrivateProtocolManager", "delAccountPhoto. NO PROTOCOL FIND.");
  }
  
  public void delPhoto(Profile paramProfile, String paramString, int paramInt)
  {
    delAccountPhoto(paramProfile, paramString, paramInt);
  }
  
  /* Error */
  public String getAvatarLastModify(String paramString)
  {
    // Byte code:
    //   0: invokestatic 319	com/tencent/qqmail/utilities/fileextention/FileUtil:getEmailIconDirPath	()Ljava/lang/String;
    //   3: astore_3
    //   4: aload_3
    //   5: ifnonnull +8 -> 13
    //   8: ldc 193
    //   10: astore_1
    //   11: aload_1
    //   12: areturn
    //   13: new 321	java/io/File
    //   16: dup
    //   17: new 209	java/lang/StringBuilder
    //   20: dup
    //   21: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   24: aload_3
    //   25: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: aload_1
    //   29: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   32: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   35: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   38: ldc 11
    //   40: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 1953	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore_3
    //   50: sipush 128
    //   53: newarray char
    //   55: astore 6
    //   57: ldc 193
    //   59: astore 4
    //   61: aload 4
    //   63: astore_1
    //   64: aload_3
    //   65: invokevirtual 1956	java/io/File:exists	()Z
    //   68: ifeq -57 -> 11
    //   71: new 2588	java/io/FileReader
    //   74: dup
    //   75: aload_3
    //   76: invokespecial 2591	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   79: astore 5
    //   81: aload 5
    //   83: astore_1
    //   84: aload 5
    //   86: aload 6
    //   88: invokevirtual 2595	java/io/FileReader:read	([C)I
    //   91: istore_2
    //   92: aload 4
    //   94: astore_3
    //   95: iload_2
    //   96: ifle +18 -> 114
    //   99: aload 5
    //   101: astore_1
    //   102: new 195	java/lang/String
    //   105: dup
    //   106: aload 6
    //   108: iconst_0
    //   109: iload_2
    //   110: invokespecial 2598	java/lang/String:<init>	([CII)V
    //   113: astore_3
    //   114: aload_3
    //   115: astore_1
    //   116: aload 5
    //   118: ifnull -107 -> 11
    //   121: aload 5
    //   123: invokevirtual 2599	java/io/FileReader:close	()V
    //   126: aload_3
    //   127: areturn
    //   128: astore_1
    //   129: bipush 6
    //   131: ldc 33
    //   133: aload_1
    //   134: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   137: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   140: aload_3
    //   141: areturn
    //   142: astore 6
    //   144: aconst_null
    //   145: astore_3
    //   146: aload_3
    //   147: astore_1
    //   148: bipush 6
    //   150: ldc 33
    //   152: aload 6
    //   154: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   157: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   160: aload 4
    //   162: astore_1
    //   163: aload_3
    //   164: ifnull -153 -> 11
    //   167: aload_3
    //   168: invokevirtual 2599	java/io/FileReader:close	()V
    //   171: ldc 193
    //   173: areturn
    //   174: astore_1
    //   175: bipush 6
    //   177: ldc 33
    //   179: aload_1
    //   180: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   183: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   186: ldc 193
    //   188: areturn
    //   189: astore_3
    //   190: aconst_null
    //   191: astore_1
    //   192: aload_1
    //   193: ifnull +7 -> 200
    //   196: aload_1
    //   197: invokevirtual 2599	java/io/FileReader:close	()V
    //   200: aload_3
    //   201: athrow
    //   202: astore_1
    //   203: bipush 6
    //   205: ldc 33
    //   207: aload_1
    //   208: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   211: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   214: goto -14 -> 200
    //   217: astore_3
    //   218: goto -26 -> 192
    //   221: astore 6
    //   223: aload 5
    //   225: astore_3
    //   226: goto -80 -> 146
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	229	0	this	QMPrivateProtocolManager
    //   0	229	1	paramString	String
    //   91	19	2	i	int
    //   3	165	3	localObject1	Object
    //   189	12	3	localObject2	Object
    //   217	1	3	localObject3	Object
    //   225	1	3	localObject4	Object
    //   59	102	4	str	String
    //   79	145	5	localFileReader	java.io.FileReader
    //   55	52	6	arrayOfChar	char[]
    //   142	11	6	localException1	Exception
    //   221	1	6	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   121	126	128	java/lang/Exception
    //   71	81	142	java/lang/Exception
    //   167	171	174	java/lang/Exception
    //   71	81	189	finally
    //   196	200	202	java/lang/Exception
    //   84	92	217	finally
    //   102	114	217	finally
    //   148	160	217	finally
    //   84	92	221	java/lang/Exception
    //   102	114	221	java/lang/Exception
  }
  
  @NonNull
  public EmailAccountState[] getEmailAccountStateList()
  {
    if (this.mEmailAcctStateList == null) {}
    synchronized (this.mInitEmailAccLock)
    {
      if (this.mEmailAcctStateList == null)
      {
        localObject2 = SPManager.getSp("user_info").getString("config_email_account_state", "");
        QMLog.log(4, "QMPrivateProtocolManager", "getEmailAcctStateList, config: " + (String)localObject2);
        if (TextUtils.isEmpty((CharSequence)localObject2))
        {
          this.mEmailAcctStateList = new EmailAccountState[0];
          updateEmailAcctStateList();
        }
      }
      else
      {
        return this.mEmailAcctStateList;
      }
      Object localObject2 = ((String)localObject2).split(";");
      this.mEmailAcctStateList = new EmailAccountState[localObject2.length];
      int i = 0;
      while (i < localObject2.length)
      {
        EmailAccountState localEmailAccountState = new EmailAccountState();
        String[] arrayOfString = localObject2[i].split(":");
        try
        {
          localEmailAccountState.account_id = Integer.parseInt(arrayOfString[0]);
          localEmailAccountState.polling_interval = Integer.parseInt(arrayOfString[1]);
          localEmailAccountState.state_code = Integer.parseInt(arrayOfString[2]);
          this.mEmailAcctStateList[i] = localEmailAccountState;
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.log(5, "QMPrivateProtocolManager", "parse EmailAccountState error", localException);
          }
        }
      }
    }
  }
  
  public void handleUploadDebugLog(long paramLong, String paramString)
  {
    if (paramLong > 0L)
    {
      QMLog.log(4, "QMPrivateProtocolManager", "upload debug log");
      FeedbackManager.uploadDebugLog(paramLong, paramString);
    }
  }
  
  public void loadEmailIcon(String paramString)
  {
    if (StringExtention.isNullOrEmpty(paramString)) {
      return;
    }
    for (;;)
    {
      synchronized (this.emailList)
      {
        if (this.emailList.size() > 0)
        {
          this.emailList.add(paramString);
          return;
        }
      }
      this.emailList.add(paramString);
      paramString = new QMPrivateProtocolManager.1(this);
      new Timer(true).schedule(paramString, 1000L);
    }
  }
  
  public void loadEmailIconDirectly(String paramString)
  {
    synchronized (this.emailList)
    {
      if (!StringExtention.isNullOrEmpty(paramString)) {
        this.emailList.add(paramString);
      }
      startLoadEmailIcon();
      return;
    }
  }
  
  public void modAccount(Account paramAccount)
  {
    if (paramAccount == null) {
      return;
    }
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "modAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "modAccount info null");
      return;
    }
    QMLog.log(4, "QMPrivateProtocolManager", "modAccount, account: " + paramAccount.getEmail());
    Profile localProfile = paramAccount.getProfile();
    Object localObject2;
    Object localObject1;
    label180:
    int i;
    boolean bool;
    EmailProtocolInfo localEmailProtocolInfo;
    if ((paramAccount instanceof QQMailAccount))
    {
      if ((!SharedPreferenceUtil.isWtlogin()) || (AccountType.domainOf(paramAccount.getEmail()) == AccountType.exmail)) {
        break label496;
      }
      localObject2 = new StringBuilder().append(QMWtLoginManager.getInstance().getA2(paramAccount.getUin())).append("\t");
      if (paramAccount.getSecondPassword() == null)
      {
        localObject1 = "";
        localProfile.QQPassword = Aes.encode((String)localObject1, Aes.getServerKey());
      }
    }
    else
    {
      i = paramAccount.getId();
      localObject2 = paramAccount.getEmail();
      localObject1 = "";
      if (!TextUtils.isEmpty((CharSequence)localObject2))
      {
        localObject1 = ((String)localObject2).split("@");
        localObject1 = localObject1[(localObject1.length - 1)];
      }
      bool = paramAccount.isBizMail();
      localCloudProtocolInfo.account_name_ = localProfile.mailAddress;
      localCloudProtocolInfo.add_account_info_ = new CloudProtocolInfo.AccountInfo();
      localCloudProtocolInfo.add_account_info_.email_ = localProfile.mailAddress;
      localCloudProtocolInfo.add_account_info_.id_ = i;
      localCloudProtocolInfo.add_account_info_.recv_ = new EmailProtocolInfo();
      localCloudProtocolInfo.add_account_info_.send_ = new EmailProtocolInfo();
      localObject2 = localCloudProtocolInfo.add_account_info_.recv_;
      localEmailProtocolInfo = localCloudProtocolInfo.add_account_info_.send_;
      ((EmailProtocolInfo)localObject2).domain = ((String)localObject1);
      if (localProfile.protocolType != 0) {
        break label555;
      }
      ((EmailProtocolInfo)localObject2).type = 2;
      ((EmailProtocolInfo)localObject2).host = localProfile.pop3Server;
      ((EmailProtocolInfo)localObject2).port = localProfile.pop3Port;
      ((EmailProtocolInfo)localObject2).psw = localProfile.pop3Password;
      ((EmailProtocolInfo)localObject2).psw_type = 0;
      if (!localProfile.pop3UsingSSL) {
        break label517;
      }
      ((EmailProtocolInfo)localObject2).port = localProfile.pop3SSLPort;
      ((EmailProtocolInfo)localObject2).security = 2;
      label403:
      localEmailProtocolInfo.type = 5;
      localEmailProtocolInfo.host = localProfile.smtpServer;
      localEmailProtocolInfo.port = localProfile.smtpPort;
      localEmailProtocolInfo.psw = localProfile.smtpPassword;
      localEmailProtocolInfo.psw_type = 0;
      if (!localProfile.smtpUsingSSL) {
        break label536;
      }
      localEmailProtocolInfo.port = localProfile.smtpSSLPort;
      localEmailProtocolInfo.security = 2;
    }
    label496:
    do
    {
      for (;;)
      {
        CloudProtocolService.ModAccount(localCloudProtocolInfo, new QMPrivateProtocolManager.21(this, i, localProfile, paramAccount));
        return;
        localObject1 = paramAccount.getSecondPassword();
        break;
        localProfile.QQPassword = StringExtention.encodeURI(Aes.encode(paramAccount.getPwd(), Aes.getServerKey()));
        break label180;
        ((EmailProtocolInfo)localObject2).port = localProfile.pop3Port;
        ((EmailProtocolInfo)localObject2).security = 1;
        break label403;
        localEmailProtocolInfo.port = localProfile.smtpPort;
        localEmailProtocolInfo.security = 1;
        continue;
        if (localProfile.protocolType == 1)
        {
          ((EmailProtocolInfo)localObject2).type = 1;
          ((EmailProtocolInfo)localObject2).host = localProfile.imapServer;
          ((EmailProtocolInfo)localObject2).port = localProfile.imapPort;
          if (localProfile.imapUsingSSL)
          {
            ((EmailProtocolInfo)localObject2).port = localProfile.imapSSLPort;
            ((EmailProtocolInfo)localObject2).security = 2;
            localEmailProtocolInfo.type = 5;
            localEmailProtocolInfo.host = localProfile.smtpServer;
            localEmailProtocolInfo.port = localProfile.smtpPort;
            if (localProfile.isOauth) {
              break label726;
            }
            ((EmailProtocolInfo)localObject2).psw = localProfile.imapPassword;
            ((EmailProtocolInfo)localObject2).psw_type = 0;
            localEmailProtocolInfo.psw = localProfile.smtpPassword;
            localEmailProtocolInfo.psw_type = 0;
          }
          for (;;)
          {
            if (!localProfile.smtpUsingSSL) {
              break label824;
            }
            localEmailProtocolInfo.port = localProfile.smtpSSLPort;
            localEmailProtocolInfo.security = 2;
            break;
            ((EmailProtocolInfo)localObject2).port = localProfile.imapSSLPort;
            ((EmailProtocolInfo)localObject2).security = 1;
            break label614;
            localObject1 = "1" + paramAccount.getRefreshToken();
            ((EmailProtocolInfo)localObject2).psw = ((String)localObject1);
            ((EmailProtocolInfo)localObject2).psw_type = 3;
            localEmailProtocolInfo.psw = ((String)localObject1);
            localEmailProtocolInfo.psw_type = 3;
            QMLog.log(4, "QMPrivateProtocolManager", "modAccount oauth2 rpwd: " + ((EmailProtocolInfo)localObject2).psw + "  spwd: " + localEmailProtocolInfo.psw);
          }
          localEmailProtocolInfo.port = localProfile.smtpPort;
          localEmailProtocolInfo.security = 1;
        }
        else if (localProfile.protocolType == 3)
        {
          ((EmailProtocolInfo)localObject2).type = 4;
          ((EmailProtocolInfo)localObject2).host = localProfile.exchangeServer;
          ((EmailProtocolInfo)localObject2).psw = localProfile.exchangePassword;
          ((EmailProtocolInfo)localObject2).psw_type = 0;
          if (localProfile.exchangeUsingSSL)
          {
            ((EmailProtocolInfo)localObject2).security = 2;
            ((EmailProtocolInfo)localObject2).port = 443;
          }
          for (;;)
          {
            localEmailProtocolInfo.type = 4;
            localEmailProtocolInfo.host = localProfile.exchangeServer;
            localEmailProtocolInfo.psw = localProfile.exchangePassword;
            localEmailProtocolInfo.psw_type = 0;
            if (!localProfile.exchangeUsingSSL) {
              break label972;
            }
            localEmailProtocolInfo.security = 2;
            localEmailProtocolInfo.port = 443;
            break;
            ((EmailProtocolInfo)localObject2).security = 1;
          }
          localEmailProtocolInfo.security = 1;
        }
        else
        {
          if (localProfile.protocolType != 4) {
            break label1133;
          }
          ((EmailProtocolInfo)localObject2).type = 3;
          ((EmailProtocolInfo)localObject2).host = localProfile.activeSyncServer;
          ((EmailProtocolInfo)localObject2).psw = localProfile.activeSyncPassword;
          ((EmailProtocolInfo)localObject2).psw_type = 0;
          if (localProfile.activeSyncUsingSSL) {
            ((EmailProtocolInfo)localObject2).security = 2;
          }
          for (((EmailProtocolInfo)localObject2).port = 443;; ((EmailProtocolInfo)localObject2).port = 80)
          {
            localEmailProtocolInfo.type = 3;
            localEmailProtocolInfo.host = localProfile.activeSyncServer;
            localEmailProtocolInfo.psw = localProfile.activeSyncPassword;
            localEmailProtocolInfo.psw_type = 0;
            if (!localProfile.activeSyncUsingSSL) {
              break label1117;
            }
            localEmailProtocolInfo.security = 2;
            localEmailProtocolInfo.port = 443;
            break;
            ((EmailProtocolInfo)localObject2).security = 1;
          }
          localEmailProtocolInfo.security = 1;
          localEmailProtocolInfo.port = 80;
        }
      }
    } while (localProfile.protocolType != 100);
    label517:
    label536:
    label555:
    label614:
    label1133:
    ((EmailProtocolInfo)localObject2).type = 6;
    label726:
    label1117:
    localEmailProtocolInfo.type = 6;
    label824:
    label972:
    if ((SharedPreferenceUtil.isWtlogin()) && (!bool)) {
      ((EmailProtocolInfo)localObject2).psw_type = 2;
    }
    for (localEmailProtocolInfo.psw_type = 2;; localEmailProtocolInfo.psw_type = 1)
    {
      localEmailProtocolInfo.psw = localProfile.QQPassword;
      ((EmailProtocolInfo)localObject2).psw = localProfile.QQPassword;
      break;
      ((EmailProtocolInfo)localObject2).psw_type = 1;
    }
  }
  
  public void openPhoneAccount(ArrayList<String> paramArrayList, MailManagerDelegate paramMailManagerDelegate)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "openPhoneAccount network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "openPhoneAccount info null");
      return;
    }
    String[] arrayOfString = new String[paramArrayList.size()];
    int i = 0;
    while (i < paramArrayList.size())
    {
      arrayOfString[i] = ((String)paramArrayList.get(i));
      i += 1;
    }
    localCloudProtocolInfo.mobilenum_list_ = arrayOfString;
    CloudProtocolService.OpenMobileAcct(localCloudProtocolInfo, new QMPrivateProtocolManager.24(this, paramMailManagerDelegate));
  }
  
  public void queryDomainConfigFromWeb(String paramString, MailServiceManager.QueryProviderListener paramQueryProviderListener)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "queryDomainConfigFromWeb network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      if (paramQueryProviderListener != null) {
        paramQueryProviderListener.onError("unknown_error");
      }
      OssHelper.mailQueryProvider(new Object[] { paramString, "NETWORK_DISCONNECT" });
    }
    CloudProtocolInfo localCloudProtocolInfo;
    do
    {
      return;
      localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
      if (localCloudProtocolInfo != null) {
        break;
      }
      OssHelper.mailQueryProvider(new Object[] { paramString, "VID_EMPTY" });
      QMLog.log(5, "QMPrivateProtocolManager", "queryDomainConfigFromWeb info null");
    } while (paramQueryProviderListener == null);
    paramQueryProviderListener.onError("unknown_error");
    return;
    localCloudProtocolInfo.cmd_unique_id_ = "";
    localCloudProtocolInfo.domain_ = paramString;
    CloudProtocolService.QueryDomainConfig(localCloudProtocolInfo, new QMPrivateProtocolManager.13(this, paramQueryProviderListener));
  }
  
  public void registerGeneralCallback()
  {
    CloudProtocolService.SetCloudProtocolLoginCallback(new QMPrivateProtocolManager.29(this));
  }
  
  /* Error */
  public void saveAvatarLastModify(String paramString1, String paramString2)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +13 -> 14
    //   4: iconst_5
    //   5: ldc 33
    //   7: ldc_w 2726
    //   10: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   13: return
    //   14: invokestatic 319	com/tencent/qqmail/utilities/fileextention/FileUtil:getEmailIconDirPath	()Ljava/lang/String;
    //   17: astore_3
    //   18: new 209	java/lang/StringBuilder
    //   21: dup
    //   22: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   25: aload_3
    //   26: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   29: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   32: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: aload_1
    //   36: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   39: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   42: astore_1
    //   43: new 321	java/io/File
    //   46: dup
    //   47: aload_1
    //   48: invokespecial 1953	java/io/File:<init>	(Ljava/lang/String;)V
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 1956	java/io/File:exists	()Z
    //   56: ifeq +10 -> 66
    //   59: aload_3
    //   60: invokevirtual 1959	java/io/File:isDirectory	()Z
    //   63: ifne +8 -> 71
    //   66: aload_3
    //   67: invokevirtual 2729	java/io/File:mkdirs	()Z
    //   70: pop
    //   71: new 209	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   78: aload_1
    //   79: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   82: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   85: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   88: ldc 11
    //   90: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   96: astore_1
    //   97: new 1964	java/io/FileOutputStream
    //   100: dup
    //   101: aload_1
    //   102: invokespecial 1965	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   105: astore_3
    //   106: aload_3
    //   107: astore_1
    //   108: aload_3
    //   109: aload_2
    //   110: invokevirtual 663	java/lang/String:getBytes	()[B
    //   113: iconst_0
    //   114: aload_2
    //   115: invokevirtual 663	java/lang/String:getBytes	()[B
    //   118: arraylength
    //   119: invokevirtual 1969	java/io/FileOutputStream:write	([BII)V
    //   122: aload_3
    //   123: ifnull -110 -> 13
    //   126: aload_3
    //   127: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   130: return
    //   131: astore_1
    //   132: bipush 6
    //   134: ldc 33
    //   136: aload_1
    //   137: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   140: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   143: return
    //   144: astore 4
    //   146: aconst_null
    //   147: astore_2
    //   148: aload_2
    //   149: astore_1
    //   150: bipush 6
    //   152: ldc 33
    //   154: aload 4
    //   156: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   159: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   162: aload_2
    //   163: ifnull -150 -> 13
    //   166: aload_2
    //   167: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   170: return
    //   171: astore_1
    //   172: bipush 6
    //   174: ldc 33
    //   176: aload_1
    //   177: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   180: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   183: return
    //   184: astore_2
    //   185: aconst_null
    //   186: astore_1
    //   187: aload_1
    //   188: ifnull +7 -> 195
    //   191: aload_1
    //   192: invokevirtual 1972	java/io/FileOutputStream:close	()V
    //   195: aload_2
    //   196: athrow
    //   197: astore_1
    //   198: bipush 6
    //   200: ldc 33
    //   202: aload_1
    //   203: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   206: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   209: goto -14 -> 195
    //   212: astore_2
    //   213: goto -26 -> 187
    //   216: astore 4
    //   218: aload_3
    //   219: astore_2
    //   220: goto -72 -> 148
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	QMPrivateProtocolManager
    //   0	223	1	paramString1	String
    //   0	223	2	paramString2	String
    //   17	202	3	localObject	Object
    //   144	11	4	localException1	Exception
    //   216	1	4	localException2	Exception
    // Exception table:
    //   from	to	target	type
    //   126	130	131	java/lang/Exception
    //   97	106	144	java/lang/Exception
    //   166	170	171	java/lang/Exception
    //   97	106	184	finally
    //   191	195	197	java/lang/Exception
    //   108	122	212	finally
    //   150	162	212	finally
    //   108	122	216	java/lang/Exception
  }
  
  public void setAccountNick(int paramInt, String paramString)
  {
    setNick(AccountManager.shareInstance().getAccountList().getAccountById(paramInt).getEmail(), paramString);
  }
  
  public void setAccountNick(String paramString1, String paramString2)
  {
    setNick(paramString1, paramString2);
  }
  
  public void setAccountPhoto(int paramInt1, Profile paramProfile, String paramString, Bitmap paramBitmap, int paramInt2)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "setAccountPhoto network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "setAccountPhoto info null");
      return;
    }
    if ((paramString == null) || (paramString.split("@").length < 2))
    {
      QMLog.log(5, "QMPrivateProtocolManager", " setAccountPhoto email err : " + paramString);
      return;
    }
    EmailProtocolInfo localEmailProtocolInfo = new EmailProtocolInfo();
    localEmailProtocolInfo.user = paramProfile.mailAddress;
    if (paramInt2 == 2)
    {
      localEmailProtocolInfo.type = 2;
      localEmailProtocolInfo.host = paramProfile.pop3Server;
      localEmailProtocolInfo.psw = paramProfile.pop3Password;
      localEmailProtocolInfo.psw_type = 0;
      if (paramProfile.pop3UsingSSL)
      {
        localEmailProtocolInfo.security = 2;
        localEmailProtocolInfo.port = paramProfile.pop3SSLPort;
      }
    }
    for (;;)
    {
      paramProfile = ByteString.copyFrom(ImageUtil.Bitmap2Bytes(paramBitmap, "png"));
      paramBitmap = new SetEMailPhotoReqInfo();
      paramBitmap.data = paramProfile;
      paramBitmap.type = 1;
      paramBitmap.email = paramString;
      paramBitmap.info = localEmailProtocolInfo;
      localCloudProtocolInfo.set_photo_list_ = new SetEMailPhotoReqInfo[1];
      localCloudProtocolInfo.set_photo_list_[0] = paramBitmap;
      QMLog.log(4, "QMPrivateProtocolManager", "setAccountPhoto SetPhoto");
      CloudProtocolService.SetPhoto(localCloudProtocolInfo, new QMPrivateProtocolManager.16(this, paramInt1, paramString));
      return;
      localEmailProtocolInfo.security = 1;
      localEmailProtocolInfo.port = paramProfile.pop3Port;
      continue;
      if (paramInt2 == 1)
      {
        localEmailProtocolInfo.type = 1;
        localEmailProtocolInfo.host = paramProfile.imapServer;
        localEmailProtocolInfo.psw = paramProfile.imapPassword;
        localEmailProtocolInfo.psw_type = 0;
        if (paramProfile.imapUsingSSL)
        {
          localEmailProtocolInfo.security = 2;
          localEmailProtocolInfo.port = paramProfile.imapSSLPort;
        }
        else
        {
          localEmailProtocolInfo.security = 1;
          localEmailProtocolInfo.port = paramProfile.imapPort;
        }
      }
      else if (paramInt2 == 4)
      {
        localEmailProtocolInfo.type = 4;
        localEmailProtocolInfo.host = paramProfile.exchangeServer;
        localEmailProtocolInfo.psw = paramProfile.exchangePassword;
        localEmailProtocolInfo.psw_type = 0;
        if (paramProfile.exchangeUsingSSL)
        {
          localEmailProtocolInfo.security = 2;
          localEmailProtocolInfo.port = 443;
        }
        else
        {
          localEmailProtocolInfo.security = 1;
        }
      }
      else
      {
        if (paramInt2 != 3) {
          break;
        }
        localEmailProtocolInfo.type = 3;
        localEmailProtocolInfo.host = paramProfile.activeSyncServer;
        localEmailProtocolInfo.psw = paramProfile.activeSyncPassword;
        localEmailProtocolInfo.psw_type = 0;
        if (paramProfile.activeSyncUsingSSL)
        {
          localEmailProtocolInfo.security = 2;
          localEmailProtocolInfo.port = 443;
        }
        else
        {
          localEmailProtocolInfo.security = 1;
          localEmailProtocolInfo.port = 80;
        }
      }
    }
    if (paramInt2 == 6)
    {
      boolean bool = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1).isBizMail();
      if ((SharedPreferenceUtil.isWtlogin()) && (!bool)) {}
      for (localEmailProtocolInfo.psw_type = 2;; localEmailProtocolInfo.psw_type = 1)
      {
        localEmailProtocolInfo.type = 6;
        localEmailProtocolInfo.psw = paramProfile.QQPassword;
        break;
      }
    }
    QMLog.log(6, "QMPrivateProtocolManager", "NO PROTOCOL FIND.");
  }
  
  public void setAdMailNotify(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_notify_admail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setAggregateAdMail(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_aggregate_ad_mail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setAggregateBySubject(int paramInt, boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_aggregate_bysubject(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setAggregateSubsMail(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_aggregate_subscribed_mail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setApplicationShowInHome(LinkedList<Integer> paramLinkedList)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_application_in_home(paramLinkedList);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setEnableNotifyDetail(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_enable_notify_detail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setEnabledRealTimeCall(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_enable_realTimeCall(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setGesturePwd(String paramString)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_gesture_password(paramString);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setGetNewMailFreq(int paramInt1, int paramInt2)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt1);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_get_newmail_freq(paramInt2);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setGlobalUserSetting()
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "setGlobalUserSetting info null");
      return;
    }
    QMSettingManager localQMSettingManager1 = QMSettingManager.sharedInstance();
    ArrayList localArrayList = new ArrayList();
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    QMSettingManager localQMSettingManager2 = QMSettingManager.sharedInstance();
    int i = 0;
    while (i < localAccountList.size())
    {
      UserSetting.Account localAccount = new UserSetting.Account();
      localAccount.set_account_id(localAccountList.get(i).getId());
      String str = localQMSettingManager2.getAccountSignature(localAccountList.get(i).getId());
      localObject = str;
      if (str == null) {
        localObject = "";
      }
      localAccount.set_personal_signature((String)localObject);
      localArrayList.add(localAccount);
      i += 1;
    }
    Object localObject = new UserSetting.Account[localArrayList.size()];
    localCloudProtocolInfo.user_setting_a_.account_list_ = ((UserSetting.Account[])localArrayList.toArray((Object[])localObject));
    localCloudProtocolInfo.user_setting_a_.global_.set_notify_admail(localQMSettingManager1.getNotifyAdMail());
    localCloudProtocolInfo.user_setting_a_.global_.set_aggregate_ad_mail(localQMSettingManager1.getAggregateAdMail());
    localCloudProtocolInfo.user_setting_a_.global_.set_aggregate_subscribed_mail(localQMSettingManager1.getAggregateSubscribeMail());
    localCloudProtocolInfo.user_setting_a_.global_.set_load_pic_function(localQMSettingManager1.getMailLoadImgType());
    localCloudProtocolInfo.user_setting_a_.global_.set_only_notify_vip(localQMSettingManager1.getOnlyNotifyVIP());
    localCloudProtocolInfo.user_setting_a_.global_.set_enable_send_sound(localQMSettingManager1.getEnableSendMailSound());
    localCloudProtocolInfo.user_setting_a_.global_.set_use_night_mode(localQMSettingManager1.getUseNightMode());
    localCloudProtocolInfo.user_setting_a_.global_.set_notify_newmail(localQMSettingManager1.getNotifyNewMail());
    localCloudProtocolInfo.user_setting_a_.global_.set_enable_sound(localQMSettingManager1.getEnableSoundPushNewMail());
    localCloudProtocolInfo.user_setting_a_.global_.set_newmail_shake_onusing(localQMSettingManager1.getEnablePushNewMailVibrate());
    localCloudProtocolInfo.user_setting_a_.global_.set_gesture_password(SharedPreferenceUtil.getGesturePwd());
    setUserSetting(localCloudProtocolInfo, null);
  }
  
  public void setIncrementBadge(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_enable_incremental_unread_count(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setLoadImgType(int paramInt)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_load_pic_function(paramInt);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setMailListAvatar(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_maillist_icon(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNewMailPush(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_notify_newmail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNewMailPushSound(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_enable_sound(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNewMailPushViberate(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_newmail_shake_onusing(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNewMailPushWay(int paramInt1, int paramInt2)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt1);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_newmail_push_way(paramInt2);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNotifyCalendarReminderMail(int paramInt, boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_notify_calstorage(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNotifyNewMailSound(String paramString)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_incoming_sound(paramString);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setNotifyProtocolAccountMail(int paramInt, boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_notify_newmail(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setOnlyNotifyInbox(int paramInt, boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_only_notify_inbox(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setOnlyNotifyVIP(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_only_notify_vip(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setPersonalizedSignature(int paramInt, String paramString)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_personal_signature(paramString);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setPlpBindAccount(long paramLong)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_plp_bind_uin(paramLong);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setPushNightMode(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_use_night_mode(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setPushVipSound(String paramString)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_vip_incoming_sound(paramString);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setSendMailSound(boolean paramBoolean)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingGlobalBasicInfo();
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.global_.set_enable_send_sound(paramBoolean);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setSyncMailCountORMailTime(int paramInt1, int paramInt2)
  {
    CloudProtocolInfo localCloudProtocolInfo = getUserSettingAccountBasicInfo(paramInt1);
    if (localCloudProtocolInfo != null)
    {
      localCloudProtocolInfo.user_setting_a_.account_list_[0].set_sync_mail_count(paramInt2);
      setUserSetting(localCloudProtocolInfo, null);
    }
  }
  
  public void setUserSetting(CloudProtocolInfo paramCloudProtocolInfo, QMGeneralCallback paramQMGeneralCallback)
  {
    paramCloudProtocolInfo.user_setting_version_ = SPManager.getSp("user_info").getString("configtype_3", "");
    CloudProtocolService.SetUserSetting(paramCloudProtocolInfo, new QMPrivateProtocolManager.30(this, paramQMGeneralCallback, paramCloudProtocolInfo));
  }
  
  public void syncADBWList(boolean paramBoolean)
  {
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    localSparseBooleanArray.append(7, paramBoolean);
    updateConfig(paramBoolean, 16, localSparseBooleanArray);
  }
  
  public void syncAccountNick(String paramString)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncAccountNick network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncAccountNick info null");
      return;
    }
    SyncEMailNicknameReqInfo localSyncEMailNicknameReqInfo = new SyncEMailNicknameReqInfo();
    localSyncEMailNicknameReqInfo.email = paramString;
    localCloudProtocolInfo.sync_nick_list_ = new SyncEMailNicknameReqInfo[1];
    localCloudProtocolInfo.sync_nick_list_[0] = localSyncEMailNicknameReqInfo;
    CloudProtocolService.SyncNick(localCloudProtocolInfo, new QMPrivateProtocolManager.14(this, paramString));
  }
  
  public void syncAdStat(int paramInt, String paramString, boolean paramBoolean1, boolean paramBoolean2)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncAdStat network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      return;
    }
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null)
    {
      QMLog.log(5, "QMPrivateProtocolManager", "syncAdStat info null");
      return;
    }
    LinkedList localLinkedList;
    CmdSetContactTypeReq localCmdSetContactTypeReq;
    if (paramBoolean2 == paramBoolean1)
    {
      paramInt = 1;
      localLinkedList = new LinkedList();
      localLinkedList.add(paramString);
      localCloudProtocolInfo.cmd_unique_id_ = "";
      localCloudProtocolInfo.set_contact_type_req_ = new CmdSetContactTypeReq();
      localCmdSetContactTypeReq = localCloudProtocolInfo.set_contact_type_req_;
      if (paramInt == 0) {
        break label147;
      }
    }
    label147:
    for (paramInt = 2;; paramInt = 3)
    {
      localCmdSetContactTypeReq.type = paramInt;
      localCloudProtocolInfo.set_contact_type_req_.email = localLinkedList;
      CloudProtocolService.SetContactType(localCloudProtocolInfo, new QMPrivateProtocolManager.10(this, paramString));
      return;
      paramInt = 0;
      break;
    }
  }
  
  public void syncAutoMoveAddress(int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    syncContactType(6, paramInt, paramArrayOfString, paramBoolean);
  }
  
  /* Error */
  public void syncEmailIconByRedirect(List<String> paramList, QMCallback paramQMCallback)
  {
    // Byte code:
    //   0: invokestatic 736	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isNetworkConnected	()Z
    //   3: ifne +32 -> 35
    //   6: iconst_5
    //   7: ldc 33
    //   9: new 209	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 2984
    //   19: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 1978	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   25: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: invokestatic 346	com/tencent/qqmail/protocol/CloudProtocolHelper:getCommonInfo	()Lcom/tencent/qqmail/protocol/CloudProtocolInfo;
    //   38: astore 11
    //   40: aload 11
    //   42: ifnonnull +13 -> 55
    //   45: iconst_5
    //   46: ldc 33
    //   48: ldc_w 2986
    //   51: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: invokestatic 319	com/tencent/qqmail/utilities/fileextention/FileUtil:getEmailIconDirPath	()Ljava/lang/String;
    //   58: astore 12
    //   60: aload 12
    //   62: ifnonnull +13 -> 75
    //   65: iconst_5
    //   66: ldc 33
    //   68: ldc_w 2988
    //   71: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   74: return
    //   75: new 75	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 76	java/util/ArrayList:<init>	()V
    //   82: astore 13
    //   84: sipush 128
    //   87: newarray char
    //   89: astore 14
    //   91: new 2990	java/util/Date
    //   94: dup
    //   95: invokespecial 2991	java/util/Date:<init>	()V
    //   98: invokevirtual 2994	java/util/Date:getTime	()J
    //   101: lstore 5
    //   103: new 2996	java/util/HashSet
    //   106: dup
    //   107: invokespecial 2997	java/util/HashSet:<init>	()V
    //   110: astore 15
    //   112: iconst_0
    //   113: istore_3
    //   114: iload_3
    //   115: aload_1
    //   116: invokeinterface 2831 1 0
    //   121: if_icmpge +356 -> 477
    //   124: aload_1
    //   125: iload_3
    //   126: invokeinterface 2998 2 0
    //   131: checkcast 195	java/lang/String
    //   134: astore 16
    //   136: aload 15
    //   138: aload 16
    //   140: invokeinterface 1579 2 0
    //   145: ifeq +10 -> 155
    //   148: iload_3
    //   149: iconst_1
    //   150: iadd
    //   151: istore_3
    //   152: goto -38 -> 114
    //   155: aload 15
    //   157: aload 16
    //   159: invokeinterface 2999 2 0
    //   164: pop
    //   165: new 321	java/io/File
    //   168: dup
    //   169: new 209	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   176: aload 12
    //   178: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 16
    //   183: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   189: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 14
    //   194: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 1953	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore 7
    //   205: ldc 193
    //   207: astore 9
    //   209: aload 9
    //   211: astore 10
    //   213: aload 7
    //   215: invokevirtual 1956	java/io/File:exists	()Z
    //   218: ifeq +91 -> 309
    //   221: lload 5
    //   223: aload 7
    //   225: invokevirtual 3002	java/io/File:lastModified	()J
    //   228: lsub
    //   229: ldc2_w 29
    //   232: lcmp
    //   233: iflt -85 -> 148
    //   236: new 2588	java/io/FileReader
    //   239: dup
    //   240: aload 7
    //   242: invokespecial 2591	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   245: astore 8
    //   247: aload 8
    //   249: astore 7
    //   251: aload 8
    //   253: aload 14
    //   255: invokevirtual 2595	java/io/FileReader:read	([C)I
    //   258: istore 4
    //   260: aload 9
    //   262: astore 7
    //   264: iload 4
    //   266: ifle +25 -> 291
    //   269: aload 8
    //   271: astore 7
    //   273: new 195	java/lang/String
    //   276: dup
    //   277: aload 14
    //   279: iconst_0
    //   280: iload 4
    //   282: invokespecial 2598	java/lang/String:<init>	([CII)V
    //   285: astore 10
    //   287: aload 10
    //   289: astore 7
    //   291: aload 7
    //   293: astore 10
    //   295: aload 8
    //   297: ifnull +12 -> 309
    //   300: aload 8
    //   302: invokevirtual 2599	java/io/FileReader:close	()V
    //   305: aload 7
    //   307: astore 10
    //   309: new 3004	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo
    //   312: dup
    //   313: invokespecial 3005	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:<init>	()V
    //   316: astore 7
    //   318: aload 7
    //   320: aload 16
    //   322: putfield 3006	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:email	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 10
    //   329: putfield 3008	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:sha	Ljava/lang/String;
    //   332: aload 7
    //   334: iconst_2
    //   335: putfield 3010	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:size	I
    //   338: aload 7
    //   340: aload_0
    //   341: aload 16
    //   343: invokevirtual 3012	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager:getAvatarLastModify	(Ljava/lang/String;)Ljava/lang/String;
    //   346: putfield 3015	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:lastmodifytime	Ljava/lang/String;
    //   349: aload 13
    //   351: aload 7
    //   353: invokeinterface 2830 2 0
    //   358: pop
    //   359: goto -211 -> 148
    //   362: astore 8
    //   364: bipush 6
    //   366: ldc 33
    //   368: aload 8
    //   370: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   373: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   376: aload 7
    //   378: astore 10
    //   380: goto -71 -> 309
    //   383: astore 10
    //   385: aconst_null
    //   386: astore 8
    //   388: aload 8
    //   390: astore 7
    //   392: bipush 6
    //   394: ldc 33
    //   396: aload 10
    //   398: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   401: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   404: aload 9
    //   406: astore 10
    //   408: aload 8
    //   410: ifnull -101 -> 309
    //   413: aload 8
    //   415: invokevirtual 2599	java/io/FileReader:close	()V
    //   418: aload 9
    //   420: astore 10
    //   422: goto -113 -> 309
    //   425: astore 7
    //   427: bipush 6
    //   429: ldc 33
    //   431: aload 7
    //   433: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   436: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   439: aload 9
    //   441: astore 10
    //   443: goto -134 -> 309
    //   446: astore_1
    //   447: aconst_null
    //   448: astore 7
    //   450: aload 7
    //   452: ifnull +8 -> 460
    //   455: aload 7
    //   457: invokevirtual 2599	java/io/FileReader:close	()V
    //   460: aload_1
    //   461: athrow
    //   462: astore_2
    //   463: bipush 6
    //   465: ldc 33
    //   467: aload_2
    //   468: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   471: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   474: goto -14 -> 460
    //   477: aload 13
    //   479: invokeinterface 2831 1 0
    //   484: ifeq -450 -> 34
    //   487: iconst_0
    //   488: istore_3
    //   489: iload_3
    //   490: aload 13
    //   492: invokeinterface 2831 1 0
    //   497: if_icmpge -463 -> 34
    //   500: aload 11
    //   502: new 3017	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq
    //   505: dup
    //   506: invokespecial 3018	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq:<init>	()V
    //   509: putfield 3022	com/tencent/qqmail/protocol/CloudProtocolInfo:get_email_photo_req_	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq;
    //   512: aload 11
    //   514: getfield 3022	com/tencent/qqmail/protocol/CloudProtocolInfo:get_email_photo_req_	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq;
    //   517: new 3004	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo
    //   520: dup
    //   521: invokespecial 3005	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:<init>	()V
    //   524: putfield 3025	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq:info	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo;
    //   527: aload 11
    //   529: getfield 3022	com/tencent/qqmail/protocol/CloudProtocolInfo:get_email_photo_req_	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq;
    //   532: aload 13
    //   534: iload_3
    //   535: invokeinterface 2998 2 0
    //   540: checkcast 3004	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo
    //   543: putfield 3025	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq:info	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo;
    //   546: aload 11
    //   548: new 3027	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$12
    //   551: dup
    //   552: aload_0
    //   553: aload 12
    //   555: aload_2
    //   556: aload 11
    //   558: getfield 3022	com/tencent/qqmail/protocol/CloudProtocolInfo:get_email_photo_req_	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq;
    //   561: getfield 3025	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq:info	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo;
    //   564: getfield 3006	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:email	Ljava/lang/String;
    //   567: aload 11
    //   569: getfield 3022	com/tencent/qqmail/protocol/CloudProtocolInfo:get_email_photo_req_	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq;
    //   572: getfield 3025	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReq:info	Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo;
    //   575: getfield 3008	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoContentReqInfo:sha	Ljava/lang/String;
    //   578: invokespecial 3030	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$12:<init>	(Lcom/tencent/qqmail/model/protocol/QMPrivateProtocolManager;Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMCallback;Ljava/lang/String;Ljava/lang/String;)V
    //   581: invokestatic 3033	com/tencent/qqmail/protocol/CloudProtocolService:SyncPhotoBy302	(Lcom/tencent/qqmail/protocol/CloudProtocolInfo;Lcom/tencent/qqmail/protocol/OnProtocolListener;)V
    //   584: iload_3
    //   585: iconst_1
    //   586: iadd
    //   587: istore_3
    //   588: goto -99 -> 489
    //   591: astore_1
    //   592: goto -142 -> 450
    //   595: astore 10
    //   597: goto -209 -> 388
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	600	0	this	QMPrivateProtocolManager
    //   0	600	1	paramList	List<String>
    //   0	600	2	paramQMCallback	QMCallback
    //   113	475	3	i	int
    //   258	23	4	j	int
    //   101	121	5	l	long
    //   203	188	7	localObject1	Object
    //   425	7	7	localException1	Exception
    //   448	8	7	localObject2	Object
    //   245	56	8	localFileReader	java.io.FileReader
    //   362	7	8	localException2	Exception
    //   386	28	8	localObject3	Object
    //   207	233	9	str1	String
    //   211	168	10	localObject4	Object
    //   383	14	10	localException3	Exception
    //   406	36	10	str2	String
    //   595	1	10	localException4	Exception
    //   38	530	11	localCloudProtocolInfo	CloudProtocolInfo
    //   58	496	12	str3	String
    //   82	451	13	localArrayList	ArrayList
    //   89	189	14	arrayOfChar	char[]
    //   110	46	15	localHashSet	java.util.HashSet
    //   134	208	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   300	305	362	java/lang/Exception
    //   236	247	383	java/lang/Exception
    //   413	418	425	java/lang/Exception
    //   236	247	446	finally
    //   455	460	462	java/lang/Exception
    //   251	260	591	finally
    //   273	287	591	finally
    //   392	404	591	finally
    //   251	260	595	java/lang/Exception
    //   273	287	595	java/lang/Exception
  }
  
  /* Error */
  public void syncPhoto(List<String> paramList, QMCallback paramQMCallback)
  {
    // Byte code:
    //   0: invokestatic 736	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:isNetworkConnected	()Z
    //   3: ifne +32 -> 35
    //   6: iconst_5
    //   7: ldc 33
    //   9: new 209	java/lang/StringBuilder
    //   12: dup
    //   13: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   16: ldc_w 3036
    //   19: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokestatic 1978	com/tencent/qqmail/utilities/qmnetwork/QMNetworkUtils:getActiveNetworkName	()Ljava/lang/String;
    //   25: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   34: return
    //   35: invokestatic 346	com/tencent/qqmail/protocol/CloudProtocolHelper:getCommonInfo	()Lcom/tencent/qqmail/protocol/CloudProtocolInfo;
    //   38: astore 11
    //   40: aload 11
    //   42: ifnonnull +13 -> 55
    //   45: iconst_5
    //   46: ldc 33
    //   48: ldc_w 3038
    //   51: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   54: return
    //   55: invokestatic 319	com/tencent/qqmail/utilities/fileextention/FileUtil:getEmailIconDirPath	()Ljava/lang/String;
    //   58: astore 12
    //   60: aload 12
    //   62: ifnonnull +13 -> 75
    //   65: iconst_5
    //   66: ldc 33
    //   68: ldc_w 3040
    //   71: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   74: return
    //   75: new 75	java/util/ArrayList
    //   78: dup
    //   79: invokespecial 76	java/util/ArrayList:<init>	()V
    //   82: astore 13
    //   84: sipush 128
    //   87: newarray char
    //   89: astore 14
    //   91: new 2990	java/util/Date
    //   94: dup
    //   95: invokespecial 2991	java/util/Date:<init>	()V
    //   98: invokevirtual 2994	java/util/Date:getTime	()J
    //   101: lstore 5
    //   103: new 2996	java/util/HashSet
    //   106: dup
    //   107: invokespecial 2997	java/util/HashSet:<init>	()V
    //   110: astore 15
    //   112: iconst_0
    //   113: istore_3
    //   114: iload_3
    //   115: aload_1
    //   116: invokeinterface 2831 1 0
    //   121: if_icmpge +345 -> 466
    //   124: aload_1
    //   125: iload_3
    //   126: invokeinterface 2998 2 0
    //   131: checkcast 195	java/lang/String
    //   134: astore 16
    //   136: aload 15
    //   138: aload 16
    //   140: invokeinterface 1579 2 0
    //   145: ifeq +10 -> 155
    //   148: iload_3
    //   149: iconst_1
    //   150: iadd
    //   151: istore_3
    //   152: goto -38 -> 114
    //   155: aload 15
    //   157: aload 16
    //   159: invokeinterface 2999 2 0
    //   164: pop
    //   165: new 321	java/io/File
    //   168: dup
    //   169: new 209	java/lang/StringBuilder
    //   172: dup
    //   173: invokespecial 210	java/lang/StringBuilder:<init>	()V
    //   176: aload 12
    //   178: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   181: aload 16
    //   183: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: getstatic 324	java/io/File:separator	Ljava/lang/String;
    //   189: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   192: ldc 14
    //   194: invokevirtual 214	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: invokevirtual 222	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   200: invokespecial 1953	java/io/File:<init>	(Ljava/lang/String;)V
    //   203: astore 7
    //   205: ldc 193
    //   207: astore 9
    //   209: aload 9
    //   211: astore 10
    //   213: aload 7
    //   215: invokevirtual 1956	java/io/File:exists	()Z
    //   218: ifeq +91 -> 309
    //   221: lload 5
    //   223: aload 7
    //   225: invokevirtual 3002	java/io/File:lastModified	()J
    //   228: lsub
    //   229: ldc2_w 29
    //   232: lcmp
    //   233: iflt -85 -> 148
    //   236: new 2588	java/io/FileReader
    //   239: dup
    //   240: aload 7
    //   242: invokespecial 2591	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   245: astore 8
    //   247: aload 8
    //   249: astore 7
    //   251: aload 8
    //   253: aload 14
    //   255: invokevirtual 2595	java/io/FileReader:read	([C)I
    //   258: istore 4
    //   260: aload 9
    //   262: astore 7
    //   264: iload 4
    //   266: ifle +25 -> 291
    //   269: aload 8
    //   271: astore 7
    //   273: new 195	java/lang/String
    //   276: dup
    //   277: aload 14
    //   279: iconst_0
    //   280: iload 4
    //   282: invokespecial 2598	java/lang/String:<init>	([CII)V
    //   285: astore 10
    //   287: aload 10
    //   289: astore 7
    //   291: aload 7
    //   293: astore 10
    //   295: aload 8
    //   297: ifnull +12 -> 309
    //   300: aload 8
    //   302: invokevirtual 2599	java/io/FileReader:close	()V
    //   305: aload 7
    //   307: astore 10
    //   309: new 3042	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo
    //   312: dup
    //   313: invokespecial 3043	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo:<init>	()V
    //   316: astore 7
    //   318: aload 7
    //   320: aload 16
    //   322: putfield 3044	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo:email	Ljava/lang/String;
    //   325: aload 7
    //   327: aload 10
    //   329: putfield 3045	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo:sha	Ljava/lang/String;
    //   332: aload 7
    //   334: iconst_2
    //   335: putfield 3046	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo:size	I
    //   338: aload 13
    //   340: aload 7
    //   342: invokeinterface 2830 2 0
    //   347: pop
    //   348: goto -200 -> 148
    //   351: astore 8
    //   353: bipush 6
    //   355: ldc 33
    //   357: aload 8
    //   359: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   362: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   365: aload 7
    //   367: astore 10
    //   369: goto -60 -> 309
    //   372: astore 10
    //   374: aconst_null
    //   375: astore 8
    //   377: aload 8
    //   379: astore 7
    //   381: bipush 6
    //   383: ldc 33
    //   385: aload 10
    //   387: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   390: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   393: aload 9
    //   395: astore 10
    //   397: aload 8
    //   399: ifnull -90 -> 309
    //   402: aload 8
    //   404: invokevirtual 2599	java/io/FileReader:close	()V
    //   407: aload 9
    //   409: astore 10
    //   411: goto -102 -> 309
    //   414: astore 7
    //   416: bipush 6
    //   418: ldc 33
    //   420: aload 7
    //   422: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   425: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   428: aload 9
    //   430: astore 10
    //   432: goto -123 -> 309
    //   435: astore_1
    //   436: aconst_null
    //   437: astore 7
    //   439: aload 7
    //   441: ifnull +8 -> 449
    //   444: aload 7
    //   446: invokevirtual 2599	java/io/FileReader:close	()V
    //   449: aload_1
    //   450: athrow
    //   451: astore_2
    //   452: bipush 6
    //   454: ldc 33
    //   456: aload_2
    //   457: invokestatic 694	android/util/Log:getStackTraceString	(Ljava/lang/Throwable;)Ljava/lang/String;
    //   460: invokestatic 207	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
    //   463: goto -14 -> 449
    //   466: aload 13
    //   468: invokeinterface 2831 1 0
    //   473: ifeq -439 -> 34
    //   476: aload 11
    //   478: aload 13
    //   480: invokeinterface 2831 1 0
    //   485: anewarray 3042	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo
    //   488: putfield 3050	com/tencent/qqmail/protocol/CloudProtocolInfo:sync_photo_list_	[Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo;
    //   491: iconst_0
    //   492: istore_3
    //   493: iload_3
    //   494: aload 13
    //   496: invokeinterface 2831 1 0
    //   501: if_icmpge +28 -> 529
    //   504: aload 11
    //   506: getfield 3050	com/tencent/qqmail/protocol/CloudProtocolInfo:sync_photo_list_	[Lcom/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo;
    //   509: iload_3
    //   510: aload 13
    //   512: iload_3
    //   513: invokeinterface 2998 2 0
    //   518: checkcast 3042	com/tencent/qqmail/protocol/UMA/SyncEMailPhotoReqInfo
    //   521: aastore
    //   522: iload_3
    //   523: iconst_1
    //   524: iadd
    //   525: istore_3
    //   526: goto -33 -> 493
    //   529: aload 11
    //   531: new 3052	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$11
    //   534: dup
    //   535: aload_0
    //   536: aload 12
    //   538: aload_2
    //   539: invokespecial 3055	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$11:<init>	(Lcom/tencent/qqmail/model/protocol/QMPrivateProtocolManager;Ljava/lang/String;Lcom/tencent/qqmail/utilities/qmnetwork/QMCallback;)V
    //   542: invokestatic 3058	com/tencent/qqmail/protocol/CloudProtocolService:SyncPhoto	(Lcom/tencent/qqmail/protocol/CloudProtocolInfo;Lcom/tencent/qqmail/protocol/OnProtocolListener;)V
    //   545: return
    //   546: astore_1
    //   547: goto -108 -> 439
    //   550: astore 10
    //   552: goto -175 -> 377
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	555	0	this	QMPrivateProtocolManager
    //   0	555	1	paramList	List<String>
    //   0	555	2	paramQMCallback	QMCallback
    //   113	413	3	i	int
    //   258	23	4	j	int
    //   101	121	5	l	long
    //   203	177	7	localObject1	Object
    //   414	7	7	localException1	Exception
    //   437	8	7	localObject2	Object
    //   245	56	8	localFileReader	java.io.FileReader
    //   351	7	8	localException2	Exception
    //   375	28	8	localObject3	Object
    //   207	222	9	str1	String
    //   211	157	10	localObject4	Object
    //   372	14	10	localException3	Exception
    //   395	36	10	str2	String
    //   550	1	10	localException4	Exception
    //   38	492	11	localCloudProtocolInfo	CloudProtocolInfo
    //   58	479	12	str3	String
    //   82	429	13	localArrayList	ArrayList
    //   89	189	14	arrayOfChar	char[]
    //   110	46	15	localHashSet	java.util.HashSet
    //   134	187	16	str4	String
    // Exception table:
    //   from	to	target	type
    //   300	305	351	java/lang/Exception
    //   236	247	372	java/lang/Exception
    //   402	407	414	java/lang/Exception
    //   236	247	435	finally
    //   444	449	451	java/lang/Exception
    //   251	260	546	finally
    //   273	287	546	finally
    //   381	393	546	finally
    //   251	260	550	java/lang/Exception
    //   273	287	550	java/lang/Exception
  }
  
  public void syncRejectAddress(int paramInt, String[] paramArrayOfString, boolean paramBoolean)
  {
    syncContactType(4, paramInt, paramArrayOfString, paramBoolean);
  }
  
  protected final void triggerSetPhotoError(int paramInt)
  {
    ((SetPhotoWatcher)Watchers.of(SetPhotoWatcher.class)).onError(paramInt);
  }
  
  protected final void triggerSetPhotoSuccess(int paramInt)
  {
    ((SetPhotoWatcher)Watchers.of(SetPhotoWatcher.class)).onSuccess(paramInt);
  }
  
  protected final void triggerSyncNickError(String paramString)
  {
    ((SyncNickWatcher)Watchers.of(SyncNickWatcher.class)).onError(paramString);
  }
  
  protected final void triggerSyncNickSuccess(String paramString)
  {
    ((SyncNickWatcher)Watchers.of(SyncNickWatcher.class)).onSuccess(paramString);
  }
  
  protected final void triggerSyncPhotoError(List<String> paramList, QMNetworkError paramQMNetworkError)
  {
    ((SyncPhotoWatcher)Watchers.of(SyncPhotoWatcher.class)).onError(paramQMNetworkError);
  }
  
  protected final void triggerSyncPhotoSuccess(List<String> paramList)
  {
    ((SyncPhotoWatcher)Watchers.of(SyncPhotoWatcher.class)).onSuccess(paramList);
  }
  
  public void triggerWipeAppWatcher(int paramInt)
  {
    if (paramInt == 0)
    {
      ((WipeAppWatcher)Watchers.of(WipeAppWatcher.class)).onWipe();
      return;
    }
    ((WipeAppWatcher)Watchers.of(WipeAppWatcher.class)).onWipeActiveSync(paramInt);
  }
  
  public void umaLogin(QMGeneralCallback paramQMGeneralCallback)
  {
    if (!QMNetworkUtils.isNetworkConnected())
    {
      QMLog.log(5, "QMPrivateProtocolManager", "umaLogin network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
      if (paramQMGeneralCallback != null) {
        paramQMGeneralCallback.onError();
      }
    }
    CloudProtocolInfo localCloudProtocolInfo;
    do
    {
      return;
      localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
      if (localCloudProtocolInfo != null) {
        break;
      }
      QMLog.log(5, "QMPrivateProtocolManager", "umaLogin info null");
    } while (paramQMGeneralCallback == null);
    paramQMGeneralCallback.onError();
    return;
    localCloudProtocolInfo.device_id_ = CloudProtocolHelper.getDeviceId();
    localCloudProtocolInfo.uma_id_ = QMApplicationContext.sharedInstance().getVid();
    localCloudProtocolInfo.uma_psw_md5_sum_ = QMApplicationContext.sharedInstance().getVidPwd();
    CloudProtocolService.Login(localCloudProtocolInfo, new QMPrivateProtocolManager.20(this, paramQMGeneralCallback));
  }
  
  public void updateConfig(boolean paramBoolean, int paramInt, @Nullable SparseBooleanArray paramSparseBooleanArray)
  {
    this.mUpdateConfigTask.offer(paramBoolean, paramInt, paramSparseBooleanArray);
    Threads.runInBackgroundIfNotExist(this.mUpdateConfigTask, 3000L);
  }
  
  public void updateEmailAcctStateList()
  {
    if (!QMNetworkUtils.isNetworkConnected()) {
      QMLog.log(5, "QMPrivateProtocolManager", "updateEmailAcctStateList network is disconnected: " + QMNetworkUtils.getActiveNetworkName());
    }
    for (;;)
    {
      return;
      if (CloudProtocolHelper.getCommonInfo() == null)
      {
        QMLog.log(5, "QMPrivateProtocolManager", "updateEmailAcctStateList info is null");
        return;
      }
      long l1 = System.currentTimeMillis();
      long l2 = l1 - SPManager.getSp("user_info").getLong("config_email_account_state_time", 0L);
      if ((l2 > 86400000L) || (l2 < 0L)) {}
      for (int i = 1; i != 0; i = 0)
      {
        SPManager.getEditor("user_info").putLong("config_email_account_state_time", l1).apply();
        QMLog.log(4, "QMPrivateProtocolManager", "updateEmailAcctStateList, interval: " + l2 + "ms");
        SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
        localSparseBooleanArray.put(2, true);
        updateConfig(false, 64, localSparseBooleanArray);
        return;
      }
    }
  }
  
  public void wipeActiveSyncAccount(int paramInt)
  {
    QMLog.log(4, "QMPrivateProtocolManager", "wipe account : " + paramInt);
    AccountManager.shareInstance().deleteAccount(paramInt, true);
  }
  
  public void wipeEntireApp()
  {
    try
    {
      QMLog.log(4, "QMPrivateProtocolManager", "wipeEntireApp.");
      Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
      while (localIterator.hasNext()) {
        wipeActiveSyncAccount(((Account)localIterator.next()).getId());
      }
      resetVid();
    }
    finally {}
  }
  
  class UpdateConfigTask
    implements Runnable
  {
    final Map<Integer, Long> allTypesMap = new QMPrivateProtocolManager.UpdateConfigTask.1(this);
    SparseBooleanArray allUpdateConfigTypes = new SparseBooleanArray();
    int callScene = 0;
    final long high = 7200000L;
    final long low = 86400000L;
    final long normal = 21600000L;
    
    private UpdateConfigTask() {}
    
    void offer(boolean paramBoolean, int paramInt, @Nullable SparseBooleanArray paramSparseBooleanArray)
    {
      long l;
      int i;
      try
      {
        this.callScene |= paramInt;
        l = System.currentTimeMillis();
        if (paramSparseBooleanArray != null)
        {
          i = paramSparseBooleanArray.size();
          if (i != 0) {}
        }
        else
        {
          paramSparseBooleanArray = this.allTypesMap.keySet().iterator();
          while (paramSparseBooleanArray.hasNext())
          {
            paramInt = ((Integer)paramSparseBooleanArray.next()).intValue();
            if ((paramBoolean) || (l - SPManager.getSp("user_info").getLong("configtype_last_time_" + paramInt, 0L) > ((Long)this.allTypesMap.get(Integer.valueOf(paramInt))).longValue()))
            {
              SPManager.getEditor("user_info").putLong("configtype_last_time_" + paramInt, l).apply();
              this.allUpdateConfigTypes.put(paramInt, this.allUpdateConfigTypes.get(paramInt, false));
            }
          }
        }
        paramInt = 0;
      }
      finally {}
      while (paramInt < i)
      {
        int j = paramSparseBooleanArray.keyAt(paramInt);
        if ((paramBoolean) || (l - SPManager.getSp("user_info").getLong("configtype_last_time_" + j, 0L) > ((Long)this.allTypesMap.get(Integer.valueOf(j))).longValue()))
        {
          SPManager.getEditor("user_info").putLong("configtype_last_time_" + j, l).apply();
          this.allUpdateConfigTypes.put(j, paramSparseBooleanArray.valueAt(paramInt) | this.allUpdateConfigTypes.get(j, false));
        }
        paramInt += 1;
      }
    }
    
    /* Error */
    public void run()
    {
      // Byte code:
      //   0: aload_0
      //   1: monitorenter
      //   2: aload_0
      //   3: getfield 55	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:allUpdateConfigTypes	Landroid/util/SparseBooleanArray;
      //   6: invokevirtual 72	android/util/SparseBooleanArray:size	()I
      //   9: ifne +26 -> 35
      //   12: iconst_5
      //   13: ldc 174
      //   15: ldc 176
      //   17: invokestatic 182	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;)V
      //   20: aload_0
      //   21: iconst_0
      //   22: putfield 50	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:callScene	I
      //   25: aload_0
      //   26: getfield 55	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:allUpdateConfigTypes	Landroid/util/SparseBooleanArray;
      //   29: invokevirtual 185	android/util/SparseBooleanArray:clear	()V
      //   32: aload_0
      //   33: monitorexit
      //   34: return
      //   35: aload_0
      //   36: getfield 26	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:this$0	Lcom/tencent/qqmail/model/protocol/QMPrivateProtocolManager;
      //   39: aload_0
      //   40: getfield 50	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:callScene	I
      //   43: aload_0
      //   44: getfield 55	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager$UpdateConfigTask:allUpdateConfigTypes	Landroid/util/SparseBooleanArray;
      //   47: invokevirtual 189	android/util/SparseBooleanArray:clone	()Landroid/util/SparseBooleanArray;
      //   50: invokestatic 193	com/tencent/qqmail/model/protocol/QMPrivateProtocolManager:access$100	(Lcom/tencent/qqmail/model/protocol/QMPrivateProtocolManager;ILandroid/util/SparseBooleanArray;)V
      //   53: goto -33 -> 20
      //   56: astore_1
      //   57: aload_0
      //   58: monitorexit
      //   59: aload_1
      //   60: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	61	0	this	UpdateConfigTask
      //   56	4	1	localObject	Object
      // Exception table:
      //   from	to	target	type
      //   2	20	56	finally
      //   20	32	56	finally
      //   35	53	56	finally
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.protocol.QMPrivateProtocolManager
 * JD-Core Version:    0.7.0.1
 */