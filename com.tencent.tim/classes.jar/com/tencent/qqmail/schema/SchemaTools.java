package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.util.SparseArray;
import com.tencent.androidqqmail.R.string;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.helper.GmailLoginHelper;
import com.tencent.qqmail.activity.setting.DeveloperActivity;
import com.tencent.qqmail.activity.setting.tableactivity.onclick.OnClickAnnotationUtil;
import com.tencent.qqmail.attachment.util.QMAttachUtils;
import com.tencent.qqmail.attachment.util.QQBrowserUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.protobuf.ByteString;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.protocol.UMA.PushConfigHandle;
import com.tencent.qqmail.protocol.UMA.PushConfigHandleInfo;
import com.tencent.qqmail.pushconfig.QMPushConfigUtil;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.MLogConfiguration;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.patch.QMPatchManager;
import com.tencent.qqmail.utilities.qmnetwork.QMProxyUtil;
import com.tencent.qqmail.utilities.report.QMReportManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.syncadapter.QMSyncAdapterManager;
import com.tencent.qqmail.utilities.thread.Threads;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Calendar;
import moai.oss.KvHelper;
import moai.oss.OssHelper;

public class SchemaTools
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_ARG = "arg";
  private static final String PARAM_BASE_VERSION = "baseversion";
  private static final String PARAM_BEGIN = "begin";
  private static final String PARAM_BLACK = "black";
  private static final String PARAM_CLOSE = "close";
  private static final String PARAM_CONFIG = "config";
  private static final String PARAM_DOMAIN = "domain";
  private static final String PARAM_DURATION = "duration";
  private static final String PARAM_END = "end";
  private static final String PARAM_FTS_UPGRADE = "upgrade";
  private static final String PARAM_HASH = "hash";
  private static final String PARAM_HOSTS = "hosts";
  private static final String PARAM_ID = "id";
  private static final String PARAM_KEY_WORD = "keyword";
  private static final String PARAM_NAME = "name";
  private static final String PARAM_OBJ = "obj";
  private static final String PARAM_OPEN = "open";
  private static final String PARAM_PARAMS = "params";
  private static final String PARAM_PATCH_CAHNNEL = "patchchannel";
  private static final String PARAM_PATCH_MAX_API = "patchmaxapi";
  private static final String PARAM_PATCH_MD5 = "patchmd5";
  private static final String PARAM_PATCH_MIN_API = "patchminapi";
  private static final String PARAM_PATCH_SIZE = "patchsize";
  private static final String PARAM_PATCH_TYPE = "patchtype";
  private static final String PARAM_PATCH_URL = "patchurl";
  private static final String PARAM_PATCH_VERSION = "patchversion";
  private static final String PARAM_PKG = "pkg";
  private static final String PARAM_SIGN = "sign";
  private static final String PARAM_SUBJECT = "subject";
  private static final String PARAM_SWITCH = "switch";
  private static final String PARAM_TASK = "task";
  private static final String PARAM_TID = "tid";
  private static final String PARAM_TYPE = "type";
  private static final String PARAM_URL = "url";
  private static final String PARAM_VALUE = "value";
  private static final String PARAM_VERSION = "version";
  private static final String PARAM_WHITE = "white";
  private static final String TAG = "SchemaTools";
  private static final String VALUE_ABTEST = "abtest";
  private static final String VALUE_ACTIVESYNC = "activeSync";
  private static final String VALUE_DEBUG_LOG = "debuglog";
  private static final String VALUE_DEVELOPER = "developer";
  private static final String VALUE_DOWNLOAD = "download";
  private static final String VALUE_EXCHANGE = "exchange";
  private static final String VALUE_FTS = "fts";
  private static final String VALUE_HOTFIX = "hotfix";
  private static final String VALUE_IDLE = "idle";
  private static final String VALUE_IMAP = "imap";
  private static final String VALUE_IS_INSTALLED = "isinstalled";
  private static final String VALUE_KEEP_ALIVE = "keepalive";
  private static final String VALUE_LOGIN_AUTH = "loginauth";
  private static final String VALUE_MLOG = "mlog";
  private static final String VALUE_OSSLOG = "osslog";
  private static final String VALUE_POP = "pop";
  private static final String VALUE_PROTOCOL = "protocol";
  private static final String VALUE_PROXY = "proxy";
  private static final String VALUE_REPORT = "report";
  private static final String VALUE_RESET_QB = "resetqb";
  private static final String VALUE_SMTP = "smtp";
  private static final String VALUE_SYNC_ACCOUNT = "syncaccount";
  private static final String VALUE_UPDATE_CONFIG = "updateconfig";
  private static final String VALUE_UPLOAD = "upload";
  private String action;
  private String arg;
  private String baseVersion;
  private String begin;
  private ArrayList<String> blackProtocol = new ArrayList();
  private ArrayList<String> closeProtocol = new ArrayList();
  private String config;
  private String domain;
  private String durationString;
  private String end;
  private int ftsUpgrade;
  private int hash;
  private String hosts;
  private int id;
  private String keyword;
  private String name;
  private String obj;
  private ArrayList<String> openProtocol = new ArrayList();
  private String paramsString;
  private String patchChannel;
  private String patchMaxApi;
  private String patchMd5;
  private String patchMinApi;
  private String patchSize;
  private String patchType;
  private String patchUrl;
  private String patchVersion;
  private ArrayList<String> pkgs = new ArrayList();
  private String sign;
  private String subject;
  private String task;
  private String tid;
  private String type;
  private String url;
  private String value;
  private ArrayList<String> versions = new ArrayList();
  private ArrayList<String> whiteProtocol = new ArrayList();
  
  public SchemaTools(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private boolean shouldSendPushLog()
  {
    long l = QMPushConfigUtil.getPushLogTime();
    Calendar localCalendar;
    int i;
    if (l > 0L)
    {
      localCalendar = Calendar.getInstance();
      localCalendar.setTimeInMillis(l);
      i = localCalendar.get(6);
      localCalendar.setTimeInMillis(System.currentTimeMillis());
    }
    return i != localCalendar.get(6);
  }
  
  public boolean doAction(int paramInt)
  {
    label95:
    Object localObject1;
    Object localObject2;
    Object localObject3;
    if (this.action != null)
    {
      if ((this.action.equals("upload")) && (this.sign != null) && (this.sign.equals("updateconfig")))
      {
        if ("debuglog".equals(this.obj))
        {
          if (!shouldSendPushLog()) {
            break label95;
          }
          if (this.durationString != null)
          {
            long l = Long.parseLong(this.durationString);
            if (l > 0L) {
              Threads.runInBackground(new SchemaTools.1(this, l));
            }
          }
        }
        for (;;)
        {
          return true;
          QMLog.log(4, "SchemaTools", "send push log same day");
        }
      }
      if (this.action.equals("isinstalled")) {
        if ((this.pkgs != null) && (this.pkgs.size() > 0))
        {
          localObject1 = new ArrayList();
          int j = Math.min(this.pkgs.size(), this.versions.size());
          paramInt = 0;
          if (paramInt < j)
          {
            localObject2 = (String)this.pkgs.get(paramInt);
            localObject3 = (String)this.versions.get(paramInt);
          }
        }
      }
    }
    for (;;)
    {
      try
      {
        localObject4 = QMApplicationContext.sharedInstance().getPackageManager().getPackageInfo((String)localObject2, 0);
        if (localObject4 == null) {
          break label1687;
        }
        bool = StringExtention.isNullOrEmpty((String)localObject3);
        if (!bool) {
          continue;
        }
        bool = true;
      }
      catch (Exception localException)
      {
        bool = false;
        continue;
        int i = 0;
        continue;
        i = 0;
        continue;
      }
      if (bool)
      {
        i = 1;
        ((ArrayList)localObject1).add(Integer.valueOf(i));
        QMLog.log(4, "SchemaTools", (String)localObject2 + " isInstalled:" + bool);
        localObject3 = new StringBuilder().append((String)localObject2).append(":");
        if (!bool) {
          continue;
        }
        i = 1;
        DataCollector.logDetailEvent("DetailEvent_Is_App_Install", 0L, 0L, i);
        OssHelper.pushConfig(new Object[] { "appInstall", localObject2, Boolean.valueOf(bool) });
        paramInt += 1;
        break;
        localObject4 = ((PackageInfo)localObject4).versionName;
        if (StringExtention.isNullOrEmpty((String)localObject4)) {
          break label1687;
        }
        bool = QMPushConfigUtil.compareVersion((String)localObject3, (String)localObject4, false);
        if (bool) {
          break label1687;
        }
        bool = true;
        continue;
      }
      localObject2 = CloudProtocolHelper.getCommonInfo();
      ArrayList localArrayList = new ArrayList();
      Object localObject4 = new PushConfigHandle();
      ((PushConfigHandle)localObject4).id = this.id;
      ((PushConfigHandle)localObject4).hash = this.hash;
      ((PushConfigHandle)localObject4).state = 2;
      PushConfigHandleInfo localPushConfigHandleInfo = new PushConfigHandleInfo();
      paramInt = 0;
      while (paramInt < this.pkgs.size())
      {
        localPushConfigHandleInfo.content = ByteString.copyFromUtf8((String)this.pkgs.get(paramInt) + ":" + ((ArrayList)localObject1).get(paramInt) + " ");
        paramInt += 1;
      }
      ((PushConfigHandle)localObject4).push_config_handle_info = localPushConfigHandleInfo;
      QMLog.log(4, "SchemaTools", "send upgrade download.id=" + ((PushConfigHandle)localObject4).id + ",hash=" + ((PushConfigHandle)localObject4).hash + ",state=" + ((PushConfigHandle)localObject4).state + ",content=" + ((PushConfigHandle)localObject4).push_config_handle_info.content.toString());
      localArrayList.add(localObject4);
      ((CloudProtocolInfo)localObject2).push_config_list_req_ = ((PushConfigHandle[])localArrayList.toArray(new PushConfigHandle[localArrayList.size()]));
      CloudProtocolService.PushConfigHandle((CloudProtocolInfo)localObject2, new SchemaTools.2(this));
      return true;
      if (this.action.equals("download"))
      {
        if ((this.url != null) && (this.name != null)) {
          QMAttachUtils.goToDownload(this.context, this.url, 2, this.name, null);
        }
        return true;
      }
      if ("report".equals(this.action)) {
        QMReportManager.handleSchemaPush(this.params);
      }
      label1159:
      label1185:
      label1211:
      label1237:
      label1257:
      label1279:
      do
      {
        for (;;)
        {
          return false;
          if ("mlog".equals(this.action))
          {
            MLogConfiguration.getInstance().handleSchemaPush(this.params);
          }
          else if ("developer".equals(this.action))
          {
            try
            {
              localObject1 = R.string.class.getField(this.value);
              if (localObject1 == null) {
                continue;
              }
              paramInt = ((Field)localObject1).getInt(null);
              localObject1 = (Method)OnClickAnnotationUtil.getMethodsWithOnClickAnnotation(DeveloperActivity.class, true).get(paramInt);
              if (localObject1 == null) {
                continue;
              }
              if (this.arg != null) {
                if ((this.arg.equalsIgnoreCase("true")) || (this.arg.equalsIgnoreCase("false"))) {
                  ((Method)localObject1).invoke(null, new Object[] { Boolean.valueOf(this.arg) });
                } else {
                  ((Method)localObject1).invoke(null, new Object[] { this.arg });
                }
              }
            }
            catch (NoSuchFieldException localNoSuchFieldException)
            {
              localNoSuchFieldException.printStackTrace();
              continue;
              localNoSuchFieldException.invoke(null, new Object[0]);
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              localIllegalAccessException.printStackTrace();
              continue;
            }
            catch (InvocationTargetException localInvocationTargetException)
            {
              localInvocationTargetException.printStackTrace();
            }
          }
          else if ("hotfix".equals(this.action))
          {
            QMPatchManager.handleSchema(this.patchType, this.patchMinApi, this.patchMaxApi, this.baseVersion, this.patchVersion, this.patchChannel, this.patchUrl, this.patchSize, this.patchMd5);
          }
          else if ("keepalive".equals(this.action))
          {
            KeepAliveManager.handleSchemaPush(this.config);
          }
          else if ("syncaccount".equals(this.action))
          {
            QMSyncAdapterManager.handleSchemaPush(this.config);
          }
          else
          {
            if ("protocol".equals(this.action))
            {
              if (StringExtention.isNullOrEmpty(this.domain))
              {
                QMLog.log(4, "SchemaTools", "protocol open:" + this.openProtocol.toString() + ", close:" + this.closeProtocol.toString());
                if (this.openProtocol.indexOf("smtp") == -1) {
                  break label1279;
                }
                QMSettingManager.sharedInstance().setEnableJavaSmtpService(true);
                KvHelper.eventJavaSmtpOpen(new double[0]);
                if (this.openProtocol.indexOf("pop") == -1) {
                  break label1308;
                }
                QMSettingManager.sharedInstance().setEnableJavaPop3Service(true);
                KvHelper.eventJavaPop3Open(new double[0]);
                if (this.openProtocol.indexOf("imap") == -1) {
                  break label1337;
                }
                QMSettingManager.sharedInstance().setEnableJavaImapService(true);
                KvHelper.eventJavaImapOpen(new double[0]);
                if (this.openProtocol.indexOf("activeSync") == -1) {
                  break label1366;
                }
                QMSettingManager.sharedInstance().setEnableJavaEasService(true);
                KvHelper.eventJavaActivesyncOpen(new double[0]);
                if (this.openProtocol.indexOf("exchange") == -1) {
                  break label1395;
                }
                QMSettingManager.sharedInstance().setEnableJavaEwsService(true);
                KvHelper.eventJavaExchangeOpen(new double[0]);
                if (this.openProtocol.indexOf("osslog") == -1) {
                  break label1424;
                }
                QMSettingManager.sharedInstance().setEnableProtocolApiOsslog(true);
                if (this.openProtocol.indexOf("idle") == -1) {
                  break label1447;
                }
                QMSettingManager.sharedInstance().setEnableJavaImapIdle(true);
              }
              for (;;)
              {
                return true;
                if (this.closeProtocol.indexOf("smtp") == -1) {
                  break;
                }
                QMSettingManager.sharedInstance().setEnableJavaSmtpService(false);
                KvHelper.eventJavaSmtpClose(new double[0]);
                break;
                if (this.closeProtocol.indexOf("pop") == -1) {
                  break label1159;
                }
                QMSettingManager.sharedInstance().setEnableJavaPop3Service(false);
                KvHelper.eventJavaPop3Close(new double[0]);
                break label1159;
                if (this.closeProtocol.indexOf("imap") == -1) {
                  break label1185;
                }
                QMSettingManager.sharedInstance().setEnableJavaImapService(false);
                KvHelper.eventJavaImapClose(new double[0]);
                break label1185;
                if (this.closeProtocol.indexOf("activeSync") == -1) {
                  break label1211;
                }
                QMSettingManager.sharedInstance().setEnableJavaEasService(false);
                KvHelper.eventJavaActivesyncClose(new double[0]);
                break label1211;
                if (this.closeProtocol.indexOf("exchange") == -1) {
                  break label1237;
                }
                QMSettingManager.sharedInstance().setEnableJavaEwsService(false);
                KvHelper.eventJavaExchangeClose(new double[0]);
                break label1237;
                if (this.closeProtocol.indexOf("osslog") == -1) {
                  break label1257;
                }
                QMSettingManager.sharedInstance().setEnableProtocolApiOsslog(false);
                break label1257;
                if (this.closeProtocol.indexOf("idle") != -1) {
                  QMSettingManager.sharedInstance().setEnableJavaImapIdle(false);
                }
              }
            }
            if ("abtest".equals(this.action))
            {
              QMABTestManager.handle(this.task, this.tid, this.type);
            }
            else if ("resetqb".equals(this.action))
            {
              QQBrowserUtil.resetInitQB();
            }
            else if ("proxy".equals(this.action))
            {
              QMProxyUtil.handleSchemaPush(this.hosts);
            }
            else
            {
              if (!"loginauth".equals(this.action)) {
                break;
              }
              GmailLoginHelper.handleSchemaPush(this.type);
            }
          }
        }
      } while (!"fts".equals(this.action));
      label1308:
      label1337:
      label1366:
      label1395:
      QMLog.log(4, "SchemaTools", "enable upgrade fts:" + this.ftsUpgrade);
      label1424:
      label1447:
      if ((this.ftsUpgrade == 1) && (!SPManager.getSp("fts").getBoolean("upgrade_mail_content_done", false))) {
        OssHelper.enableUpgradeFts(new Object[] { Integer.valueOf(SPManager.getSp("fts").getInt("upgrade_mail_fts_record_count", 0)) });
      }
      QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
      if (this.ftsUpgrade == 1) {}
      for (boolean bool = true;; bool = false)
      {
        localQMSettingManager.setEnableUpgradeFts(bool);
        break;
      }
      label1687:
      bool = false;
    }
    return true;
  }
  
  public void parseParams()
  {
    int i = 0;
    for (;;)
    {
      Object localObject;
      String str;
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            localObject = arrayOfString[i].split("=");
            if (localObject.length != 2) {
              break label820;
            }
            str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("obj")) {
              this.obj = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaTools", localException.getMessage());
      }
      return;
      if (str.equals("sign")) {
        this.sign = ((String)localObject);
      } else if (str.equals("duration")) {
        this.durationString = ((String)localObject);
      } else if (str.equals("params")) {
        this.paramsString = ((String)localObject);
      } else if (str.equals("pkg")) {
        this.pkgs.add(localObject);
      } else if (str.equals("version")) {
        this.versions.add(localObject);
      } else if (str.equals("url")) {
        this.url = ((String)localObject);
      } else if (str.equals("name")) {
        this.name = ((String)localObject);
      } else if (str.equals("type")) {
        this.type = ((String)localObject);
      } else if (str.equals("begin")) {
        this.begin = ((String)localObject);
      } else if (str.equals("end")) {
        this.end = ((String)localObject);
      } else if (str.equals("keyword")) {
        this.keyword = ((String)localObject);
      } else if (str.equals("subject")) {
        this.subject = ((String)localObject);
      } else if (str.equals("id")) {
        this.id = Integer.parseInt((String)localObject);
      } else if (str.equals("hash")) {
        this.hash = Integer.valueOf((String)localObject).intValue();
      } else if (str.equals("baseversion")) {
        this.baseVersion = ((String)localObject);
      } else if (str.equals("patchversion")) {
        this.patchVersion = ((String)localObject);
      } else if (str.equals("patchurl")) {
        this.patchUrl = ((String)localObject);
      } else if (str.equals("patchchannel")) {
        this.patchChannel = ((String)localObject);
      } else if (str.equals("patchtype")) {
        this.patchType = ((String)localObject);
      } else if (str.equals("patchsize")) {
        this.patchSize = ((String)localObject);
      } else if (str.equals("patchmd5")) {
        this.patchMd5 = ((String)localObject);
      } else if (str.equals("patchminapi")) {
        this.patchMinApi = ((String)localObject);
      } else if (str.equals("patchmaxapi")) {
        this.patchMaxApi = ((String)localObject);
      } else if (str.equals("value")) {
        this.value = ((String)localObject);
      } else if (str.equals("arg")) {
        this.arg = ((String)localObject);
      } else if (str.equals("config")) {
        this.config = ((String)localObject);
      } else if (str.equals("open")) {
        this.openProtocol.add(localObject);
      } else if (str.equals("close")) {
        this.closeProtocol.add(localObject);
      } else if (str.equals("domain")) {
        this.domain = ((String)localObject);
      } else if (str.equals("black")) {
        this.blackProtocol.add(localObject);
      } else if (str.equals("white")) {
        this.whiteProtocol.add(localObject);
      } else if (str.equals("task")) {
        this.task = ((String)localObject);
      } else if (str.equals("tid")) {
        this.tid = ((String)localObject);
      } else if (str.equals("hosts")) {
        this.hosts = ((String)localObject);
      } else if (str.equals("upgrade")) {
        this.ftsUpgrade = Integer.valueOf((String)localObject).intValue();
      }
      label820:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaTools
 * JD-Core Version:    0.7.0.1
 */