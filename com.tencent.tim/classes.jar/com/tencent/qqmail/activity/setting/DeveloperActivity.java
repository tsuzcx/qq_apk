package com.tencent.qqmail.activity.setting;

import android.app.Activity;
import android.app.Notification;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Environment;
import android.util.Log;
import android.util.SparseBooleanArray;
import android.view.MotionEvent;
import android.webkit.WebView;
import android.widget.Toast;
import androidx.core.app.NotificationCompat.Builder;
import com.lolita.annotations.BlockManager;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.WelcomePagesActivity;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.helper.QMWtLoginManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.networkanalyse.NetworkAnalyseActivity;
import com.tencent.qqmail.activity.setting.tableactivity.BaseTableActivity;
import com.tencent.qqmail.activity.setting.tableactivity.model.CheckBoxTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.DetailTableItem;
import com.tencent.qqmail.activity.setting.tableactivity.model.Table;
import com.tencent.qqmail.activity.setting.tableactivity.model.TableItem;
import com.tencent.qqmail.calendar.provider.CalendarProviderConversionManager;
import com.tencent.qqmail.marcos.AppConfig;
import com.tencent.qqmail.marcos.ChannelDefine;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.monitor.QMMemoryMonitor;
import com.tencent.qqmail.popularize.PopularizeManager;
import com.tencent.qqmail.protocol.CloudProtocolHelper;
import com.tencent.qqmail.protocol.CloudProtocolInfo;
import com.tencent.qqmail.protocol.CloudProtocolService;
import com.tencent.qqmail.schema.SchemaUtil;
import com.tencent.qqmail.utilities.BrandUtil;
import com.tencent.qqmail.utilities.VersionUtils;
import com.tencent.qqmail.utilities.abtest.QMABTestManager;
import com.tencent.qqmail.utilities.deviceid.DeviceInfo;
import com.tencent.qqmail.utilities.deviceid.DeviceUtil;
import com.tencent.qqmail.utilities.exception.DevRuntimeException;
import com.tencent.qqmail.utilities.fps.FrameMonitoer;
import com.tencent.qqmail.utilities.fps.MainLooperMonitor;
import com.tencent.qqmail.utilities.keepalive.KeepAliveManager;
import com.tencent.qqmail.utilities.log.MLogConfiguration;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.patch.QMPatchManager;
import com.tencent.qqmail.utilities.qmbroadcastreceiver.QMBonusBroadCast;
import com.tencent.qqmail.utilities.qmnetwork.HttpURLConnectionFactory;
import com.tencent.qqmail.utilities.qmnetwork.QMHttpUtil;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushManager;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushService;
import com.tencent.qqmail.utilities.qmnetwork.service.QMServiceManager;
import com.tencent.qqmail.utilities.sharedpreference.SPManager;
import com.tencent.qqmail.utilities.sharedpreference.SharedPreferenceUtil;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import com.tencent.qqmail.utilities.thread.Threads;
import com.tencent.qqmail.utilities.ui.QMUIHelper;
import com.tencent.qqmail.view.BrightnessDialog;
import com.tencent.qqmail.view.QMTopBar;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import org.apache.commons.io.FileUtils;

public class DeveloperActivity
  extends BaseTableActivity
{
  public static final String TAG = "DeveloperActivity";
  
  private static void appendFile()
  {
    QMMailManager.sharedInstance().appendFile();
  }
  
  public static void cgiPing()
  {
    Threads.runInBackground(new DeveloperActivity.2());
  }
  
  private static boolean changeQMLogLevel(boolean paramBoolean)
  {
    MLogConfiguration localMLogConfiguration = MLogConfiguration.getInstance();
    if (localMLogConfiguration.getLevel() == 2)
    {
      localMLogConfiguration.setLevel(4);
      return false;
    }
    localMLogConfiguration.setLevel(2);
    return true;
  }
  
  private static void connectPush()
  {
    QMServiceManager.setEnableUMAPush(true);
    Toast.makeText(QMApplicationContext.sharedInstance(), "已恢复Push长连接", 0).show();
  }
  
  public static void copyData()
  {
    File localFile1 = new File(Environment.getExternalStorageDirectory() + "/MailDebug");
    localFile1.delete();
    localFile1.mkdirs();
    StringBuilder localStringBuilder = new StringBuilder("Copy to: ").append("\n").append(localFile1).append("\n").append("\n");
    File[] arrayOfFile = QMApplicationContext.sharedInstance().getFilesDir().getParentFile().listFiles();
    int j = arrayOfFile.length;
    int i = 0;
    for (;;)
    {
      if (i < j)
      {
        File localFile2 = arrayOfFile[i];
        Object localObject = "cp ";
        if (localFile2.isDirectory()) {
          localObject = "cp " + "-R ";
        }
        localObject = (String)localObject + localFile2 + " " + localFile1;
        try
        {
          localObject = Runtime.getRuntime().exec((String)localObject);
          ((Process)localObject).waitFor();
          ((Process)localObject).destroy();
          localStringBuilder.append(localFile2.getName()).append(" --- success\n");
          i += 1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QMLog.log(5, "DeveloperActivity", "copy data failed", localException);
            localStringBuilder.append(localFile2.getName()).append(" --- failed!!\n");
          }
        }
      }
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), localStringBuilder.toString(), 1).show();
  }
  
  private void createContentTableData()
  {
    Table localTable = createTable(2131719739).add(new DetailTableItem(2131719818, 1, String.valueOf(QMApplicationContext.sharedInstance().getVid()))).add(new DetailTableItem(2131719817, 1, AppConfig.getCodeVersion() + "_" + ChannelDefine.getChannelId())).add(new DetailTableItem(2131719810, 1, AppConfig.getSystemVersion())).add(new DetailTableItem(2131719743, 1, "" + CloudProtocolHelper.getDeviceId()));
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    while (i < localAccountList.size())
    {
      localTable.add(new DetailTableItem(localAccountList.get(i).getEmail(), 1, localAccountList.get(i).getId() + ""));
      i += 1;
    }
    localTable.add(new TableItem(2131719731, 1)).add(new TableItem(2131719733, 1)).add(new TableItem(2131719780, 0)).add(new TableItem(2131719821, 0));
  }
  
  private void createDebugTableData()
  {
    createTable(2131719741).add(new TableItem(2131719809, 0)).add(new TableItem(2131719819, 0)).add(new CheckBoxTableItem(2131719820, 0, SharedPreferenceUtil.isWtlogin())).add(new TableItem(2131719791, 0)).add(new CheckBoxTableItem(2131719796, 0, QMSettingManager.sharedInstance().isQuickCalendarSync())).add(new TableItem(2131719783, 0)).add(new CheckBoxTableItem(2131719784, 0, SharedPreferenceUtil.isMainThreadMonitorTurnedOn())).add(new CheckBoxTableItem(2131719785, 0, QMMemoryMonitor.sharedInstance().isStart())).add(new TableItem(2131719800, 0)).add(new TableItem(2131719801, 0)).add(new TableItem(2131719789, 0)).add(new TableItem(2131719812, 0)).add(new CheckBoxTableItem(2131719752, 0, QMSettingManager.sharedInstance().isEnableJavaSmtpService())).add(new CheckBoxTableItem(2131719750, 0, QMSettingManager.sharedInstance().isEnableJavaImapService())).add(new CheckBoxTableItem(2131719751, 0, QMSettingManager.sharedInstance().isEnableJavaPop3Service())).add(new CheckBoxTableItem(2131719748, 0, QMSettingManager.sharedInstance().isEnableJavaEasService())).add(new CheckBoxTableItem(2131719749, 0, QMSettingManager.sharedInstance().isEnableJavaEwsService())).add(new CheckBoxTableItem(2131719824, 0, QMSettingManager.sharedInstance().isEnableSettingDomainConfig())).add(new CheckBoxTableItem(2131719747, 0, QMSettingManager.sharedInstance().isEnableGmailAuth())).add(new CheckBoxTableItem(2131719754, 0, QMABTestManager.isSendMailByFtn())).add(new CheckBoxTableItem(2131719745, 0, QMSettingManager.sharedInstance().isEnableDomainAppend()));
  }
  
  private void createHotfixTableData()
  {
    createTable(2131719776).add(new TableItem(2131719778, 0)).add(new TableItem(2131719777, 0));
  }
  
  public static Intent createIntent()
  {
    return new Intent(QMApplicationContext.sharedInstance(), DeveloperActivity.class);
  }
  
  private void createLogTalbeData()
  {
    Table localTable = createTable(2131719781).add(new CheckBoxTableItem(2131719782, 0, MLogConfiguration.getInstance().isLogcatEnabled()));
    if (MLogConfiguration.getInstance().getLevel() == 2) {}
    for (boolean bool = true;; bool = false)
    {
      localTable.add(new CheckBoxTableItem(2131719795, 1, bool)).add(new TableItem(2131719814, 0));
      return;
    }
  }
  
  private void createNetworkTableData()
  {
    createTable(2131719787).add(new TableItem(2131719799, 0)).add(new TableItem(2131719788, 1)).add(new TableItem(2131719815, 0)).add(new CheckBoxTableItem(2131719755, 1, QMHttpUtil.forceHttp())).add(new CheckBoxTableItem(2131719792, 0, QMHttpUtil.enableProblemProxy()));
  }
  
  private void createPushTableData()
  {
    Table localTable = createTable(2131719793).add(new TableItem(2131719798, 0)).add(new TableItem(2131719744, 0)).add(new TableItem(2131719738, 0));
    if (BrandUtil.isMiui()) {
      localTable.add(new CheckBoxTableItem(2131719786, 0, QMABTestManager.isEnableMiPush()));
    }
    while (!BrandUtil.isEmui()) {
      return;
    }
    localTable.add(new CheckBoxTableItem(2131719779, 0, QMABTestManager.isEnableHwPush()));
  }
  
  private void createSimulationTableData()
  {
    Table localTable = createTable(2131719802).add(new TableItem(2131719805, 0)).add(new TableItem(2131719804, 0)).add(new TableItem(2131719807, 0)).add(new TableItem(2131719808, 0)).add(new DetailTableItem(2131719806, 0, getModifySidTitle())).add(new TableItem(2131719803, 0));
    if (AccountManager.shareInstance().getAccountList().getAllGMailAccountIds().length > 0) {
      localTable.add(new TableItem(2131719756, 0));
    }
  }
  
  private void createToolTableData()
  {
    createTable(2131719811).add(new TableItem(2131719734, 1)).add(new TableItem(2131719813, 0)).add(new TableItem(2131719790, 0)).add(new TableItem(2131719794, 0)).add(new TableItem(2131719735, 0)).add(new CheckBoxTableItem(2131719753, 0, SharedPreferenceUtil.isEnableRichEditMode())).add(new CheckBoxTableItem(2131719742, 0, SharedPreferenceUtil.getWebviewDebug())).add(new TableItem(2131719740, 0)).add(new CheckBoxTableItem(2131719816, 0, HttpURLConnectionFactory.useOkHttp)).add(new TableItem(2131719732, 0));
  }
  
  private static void disconnectPush()
  {
    QMServiceManager.setEnableUMAPush(false);
    Toast.makeText(QMApplicationContext.sharedInstance(), "已停止Push长连接", 0).show();
  }
  
  /* Error */
  private static void downloadAndInstallPatch()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 81	java/io/File
    //   5: dup
    //   6: new 83	java/lang/StringBuilder
    //   9: dup
    //   10: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   13: invokestatic 90	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   16: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   19: ldc_w 446
    //   22: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   28: invokespecial 105	java/io/File:<init>	(Ljava/lang/String;)V
    //   31: astore 4
    //   33: aload 4
    //   35: invokevirtual 449	java/io/File:exists	()Z
    //   38: ifne +35 -> 73
    //   41: invokestatic 65	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   44: new 83	java/lang/StringBuilder
    //   47: dup
    //   48: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   51: ldc_w 451
    //   54: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   57: aload 4
    //   59: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   62: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: iconst_1
    //   66: invokestatic 73	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   69: invokevirtual 76	android/widget/Toast:show	()V
    //   72: return
    //   73: new 453	java/io/BufferedReader
    //   76: dup
    //   77: new 455	java/io/FileReader
    //   80: dup
    //   81: aload 4
    //   83: invokespecial 458	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   86: invokespecial 461	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   89: astore_1
    //   90: aload_1
    //   91: astore_0
    //   92: aload_1
    //   93: invokevirtual 464	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   96: astore_2
    //   97: aload_2
    //   98: astore_0
    //   99: aload_1
    //   100: invokevirtual 467	java/io/BufferedReader:close	()V
    //   103: aload_0
    //   104: invokestatic 473	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   107: ifeq +74 -> 181
    //   110: invokestatic 65	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   113: new 83	java/lang/StringBuilder
    //   116: dup
    //   117: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   120: ldc_w 475
    //   123: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   126: aload 4
    //   128: invokevirtual 94	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: iconst_1
    //   135: invokestatic 73	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   138: invokevirtual 76	android/widget/Toast:show	()V
    //   141: return
    //   142: astore_2
    //   143: aconst_null
    //   144: astore_1
    //   145: aload_1
    //   146: astore_0
    //   147: iconst_5
    //   148: ldc 8
    //   150: ldc_w 477
    //   153: aload_2
    //   154: invokestatic 167	com/tencent/qqmail/utilities/log/QMLog:log	(ILjava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   157: aload_1
    //   158: invokevirtual 467	java/io/BufferedReader:close	()V
    //   161: aload_3
    //   162: astore_0
    //   163: goto -60 -> 103
    //   166: astore_0
    //   167: aload_3
    //   168: astore_0
    //   169: goto -66 -> 103
    //   172: astore_1
    //   173: aconst_null
    //   174: astore_0
    //   175: aload_0
    //   176: invokevirtual 467	java/io/BufferedReader:close	()V
    //   179: aload_1
    //   180: athrow
    //   181: invokestatic 65	com/tencent/qqmail/QMApplicationContext:sharedInstance	()Lcom/tencent/qqmail/QMApplicationContext;
    //   184: new 83	java/lang/StringBuilder
    //   187: dup
    //   188: invokespecial 84	java/lang/StringBuilder:<init>	()V
    //   191: ldc_w 479
    //   194: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   197: aload_0
    //   198: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   201: ldc_w 481
    //   204: invokevirtual 99	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 103	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: iconst_1
    //   211: invokestatic 73	android/widget/Toast:makeText	(Landroid/content/Context;Ljava/lang/CharSequence;I)Landroid/widget/Toast;
    //   214: invokevirtual 76	android/widget/Toast:show	()V
    //   217: aload_0
    //   218: iconst_1
    //   219: iconst_0
    //   220: invokestatic 487	com/tencent/qqmail/utilities/patch/QMPatchManager:downloadPatch	(Ljava/lang/String;ZZ)V
    //   223: return
    //   224: astore_1
    //   225: goto -122 -> 103
    //   228: astore_0
    //   229: goto -50 -> 179
    //   232: astore_1
    //   233: goto -58 -> 175
    //   236: astore_2
    //   237: goto -92 -> 145
    // Local variable table:
    //   start	length	slot	name	signature
    //   91	72	0	localObject1	Object
    //   166	1	0	localException1	Exception
    //   168	50	0	localObject2	Object
    //   228	1	0	localException2	Exception
    //   89	69	1	localBufferedReader	java.io.BufferedReader
    //   172	8	1	localObject3	Object
    //   224	1	1	localException3	Exception
    //   232	1	1	localObject4	Object
    //   96	2	2	str	String
    //   142	12	2	localException4	Exception
    //   236	1	2	localException5	Exception
    //   1	167	3	localObject5	Object
    //   31	96	4	localFile	File
    // Exception table:
    //   from	to	target	type
    //   73	90	142	java/lang/Exception
    //   157	161	166	java/lang/Exception
    //   73	90	172	finally
    //   99	103	224	java/lang/Exception
    //   175	179	228	java/lang/Exception
    //   92	97	232	finally
    //   147	157	232	finally
    //   92	97	236	java/lang/Exception
  }
  
  private static void dumpBlockMethodDetail()
  {
    BlockManager.dump(30);
    BlockManager.dumpBlockStackTrace();
  }
  
  private static boolean enableGmailAuth()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableGmailAuth()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableGmailAuth(bool);
      return QMSettingManager.sharedInstance().isEnableGmailAuth();
    }
  }
  
  private static boolean enableJavaEas()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableJavaEasService()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableJavaEasService(bool);
      return QMSettingManager.sharedInstance().isEnableJavaEasService();
    }
  }
  
  private static boolean enableJavaEws()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableJavaEwsService()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableJavaEwsService(bool);
      return QMSettingManager.sharedInstance().isEnableJavaEwsService();
    }
  }
  
  private static boolean enableJavaImap()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableJavaImapService()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableJavaImapService(bool);
      return QMSettingManager.sharedInstance().isEnableJavaImapService();
    }
  }
  
  private static boolean enableJavaPop3()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableJavaPop3Service()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableJavaPop3Service(bool);
      return QMSettingManager.sharedInstance().isEnableJavaPop3Service();
    }
  }
  
  private static boolean enableJavaSmtp()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableJavaSmtpService()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableJavaSmtpService(bool);
      return QMSettingManager.sharedInstance().isEnableJavaSmtpService();
    }
  }
  
  private static boolean enableLogcat(boolean paramBoolean)
  {
    MLogConfiguration localMLogConfiguration = MLogConfiguration.getInstance();
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      localMLogConfiguration.setLogcatEnable(bool);
      if (paramBoolean) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean enableProxy(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      QMHttpUtil.setProblemProxyEnable(bool);
      if (paramBoolean) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean enableSendmailByFtn()
  {
    if (!QMABTestManager.isSendMailByFtn()) {}
    for (boolean bool = true;; bool = false)
    {
      QMABTestManager.enableSendMailByFtn(bool);
      return QMABTestManager.isSendMailByFtn();
    }
  }
  
  private static boolean enableSettingDomainAppend()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableDomainAppend()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableDomainAppend(bool);
      return QMSettingManager.sharedInstance().isEnableDomainAppend();
    }
  }
  
  private static boolean enableSettingDomainConfig()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isEnableSettingDomainConfig()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setEnableSettingDomainConfig(bool);
      return QMSettingManager.sharedInstance().isEnableSettingDomainConfig();
    }
  }
  
  private static void expireGmailToken()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if (localAccount.isGMail())
      {
        localAccount.setLastTokenTime(0L);
        AccountManager.shareInstance().updateAccessTokenInfo(localAccount);
      }
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), QMApplicationContext.sharedInstance().getString(2131719757), 0).show();
  }
  
  private static boolean forceHttp(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      QMHttpUtil.setForceHttp(bool);
      if (paramBoolean) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static String getModifySidTitle()
  {
    Object localObject = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if ((localObject instanceof QQMailAccount))
    {
      localObject = ((QQMailAccount)localObject).getSid();
      if ((localObject == null) || (((String)localObject).length() <= 5)) {
        return "invalid sid";
      }
      return "valid sid";
    }
    return "not qqmail account";
  }
  
  private static void goToCacheActivity()
  {
    goActivity(new Intent(QMApplicationContext.sharedInstance(), CacheActivity.class));
  }
  
  private static void goToNetworkAnalyseActivity()
  {
    goActivity(new Intent(QMApplicationContext.sharedInstance(), NetworkAnalyseActivity.class));
  }
  
  private static void goToSettingPackageSizeActivity()
  {
    try
    {
      Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
      if (localActivity != null) {
        localActivity.startActivity(SettingPackageSizeActivity.createInitIntent());
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  private static void goToSettingSyncAdapterActivity()
  {
    goActivity(new Intent(QMApplicationContext.sharedInstance(), SettingSyncAdapterActivity.class));
  }
  
  private static void goToSettingTestHostIpActivity()
  {
    goActivity(new Intent(QMApplicationContext.sharedInstance(), SettingTestHostIpActivity.class));
  }
  
  private static void goToSettingTrafficControlActivity()
  {
    goActivity(new Intent(QMApplicationContext.sharedInstance(), SettingTrafficControlActivity.class));
  }
  
  private static void goToStartPage()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null) {
      localActivity.startActivity(WelcomePagesActivity.createIntent(""));
    }
  }
  
  private static void goToWelcomePage() {}
  
  private static boolean hwPush()
  {
    if (!QMABTestManager.isEnableHwPush()) {}
    for (boolean bool = true;; bool = false)
    {
      QMABTestManager.enableHwPush(bool);
      if (!bool) {
        break;
      }
      QMPushManager.register();
      return bool;
    }
    QMPushManager.unregister(true);
    return bool;
  }
  
  private void initTopBar()
  {
    QMTopBar localQMTopBar = getTopBar();
    localQMTopBar.setTitle(2131719822);
    localQMTopBar.setButtonLeftBack();
  }
  
  private static void installPatch()
  {
    File localFile = new File(Environment.getExternalStorageDirectory() + "/patch.zip");
    if (!localFile.exists())
    {
      Toast.makeText(QMApplicationContext.sharedInstance(), "找不到patch文件: " + localFile, 1).show();
      return;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), "正在安装patch文件: " + localFile, 1).show();
    QMPatchManager.installPatch(StringExtention.calculateDigest(localFile, "MD5"), localFile.getAbsolutePath(), false);
  }
  
  private static boolean memoryMonitor()
  {
    if (!QMMemoryMonitor.sharedInstance().isStart()) {}
    for (boolean bool = true; bool; bool = false)
    {
      QMMemoryMonitor.sharedInstance().start();
      return bool;
    }
    QMMemoryMonitor.sharedInstance().stop();
    return bool;
  }
  
  private static boolean miPush()
  {
    if (!QMABTestManager.isEnableMiPush()) {}
    for (boolean bool = true;; bool = false)
    {
      QMABTestManager.enableMiPush(bool);
      if (!bool) {
        break;
      }
      QMPushManager.register();
      return bool;
    }
    QMPushManager.unregister(true);
    return bool;
  }
  
  private static boolean monitorMainLoop(boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      paramBoolean = true;
      if (!paramBoolean) {
        break label33;
      }
      MainLooperMonitor.getInstance().startMonitor();
      FrameMonitoer.getInstance().startMonitor();
    }
    for (;;)
    {
      SharedPreferenceUtil.turnOnMainThreadMonitor(paramBoolean);
      return paramBoolean;
      paramBoolean = false;
      break;
      label33:
      MainLooperMonitor.getInstance().stopMonitor();
      FrameMonitoer.getInstance().stopMonitor();
    }
  }
  
  private static void printSystemCalendar()
  {
    CalendarProviderConversionManager.sharedInstance().dumpLog(true);
  }
  
  private static void reIndexDBAndAnalyzeAll()
  {
    QMMailManager.sharedInstance().reIndexDB();
    QMMailSQLiteHelper.analyzeAll();
    Toast.makeText(QMApplicationContext.sharedInstance(), "重建索引 + 执行分析", 0).show();
  }
  
  private static void sendLowMemoryNotification()
  {
    Object localObject1 = new NotificationCompat.Builder(QMApplicationContext.sharedInstance());
    Object localObject2 = ((NotificationCompat.Builder)localObject1).setContentTitle("QQ邮箱低内存模拟").setContentText("触摸可模拟读信低内存");
    if (BrandUtil.isColorfulNotificationIcon()) {}
    for (int i = 2130840992;; i = 2130841012)
    {
      ((NotificationCompat.Builder)localObject2).setSmallIcon(i);
      ((NotificationCompat.Builder)localObject1).setProgress(0, 0, false);
      localObject1 = ((NotificationCompat.Builder)localObject1).build();
      localObject2 = new Intent(QMApplicationContext.sharedInstance(), QMBonusBroadCast.class);
      ((Intent)localObject2).setAction("com.tencent.qqmail.LOW_MEN");
      ((Notification)localObject1).contentIntent = PendingIntent.getBroadcast(QMApplicationContext.sharedInstance(), 0, (Intent)localObject2, 268435456);
      QMUIHelper.notifyNotification(29054322, (Notification)localObject1);
      return;
    }
  }
  
  private static void sendPushHeart()
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), "发送心跳包成功，等待回复", 0).show();
    Intent localIntent = QMPushService.createHeartbeatTestIntent();
    QMApplicationContext.sharedInstance().startService(localIntent);
  }
  
  private static boolean setCalendarSync()
  {
    QMSettingManager localQMSettingManager = QMSettingManager.sharedInstance();
    if (!QMSettingManager.sharedInstance().isQuickCalendarSync()) {}
    for (boolean bool = true;; bool = false)
    {
      localQMSettingManager.setQuickCalendarSync(bool);
      return QMSettingManager.sharedInstance().isQuickCalendarSync();
    }
  }
  
  private static boolean setEnableOkHttp(boolean paramBoolean)
  {
    if (!HttpURLConnectionFactory.useOkHttp) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      HttpURLConnectionFactory.useOkHttp = paramBoolean;
      return HttpURLConnectionFactory.useOkHttp;
    }
  }
  
  private static boolean setEnableWebViewDebugMode(boolean paramBoolean)
  {
    if (!SharedPreferenceUtil.getWebviewDebug()) {}
    for (boolean bool = true;; bool = false)
    {
      SharedPreferenceUtil.setWebviewDebug(bool);
      if (VersionUtils.hasKitKat()) {
        WebView.setWebContentsDebuggingEnabled(SharedPreferenceUtil.getWebviewDebug());
      }
      if (paramBoolean) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static boolean setRichEditEnabled(boolean paramBoolean)
  {
    if (!paramBoolean) {}
    for (boolean bool = true;; bool = false)
    {
      SharedPreferenceUtil.enableRichEditMode(bool);
      if (paramBoolean) {
        break;
      }
      return true;
    }
    return false;
  }
  
  private static void showGuideDialog()
  {
    KeepAliveManager.showGuide(-2);
  }
  
  private static void showNotificationGuideDialog() {}
  
  private static void showSvrAccounts()
  {
    CloudProtocolInfo localCloudProtocolInfo = CloudProtocolHelper.getCommonInfo();
    if (localCloudProtocolInfo == null) {
      return;
    }
    CloudProtocolService.LstAccount(localCloudProtocolInfo, new DeveloperActivity.1());
  }
  
  private static void showToast(String paramString)
  {
    Toast.makeText(QMApplicationContext.sharedInstance(), paramString, 0).show();
  }
  
  private static void showWtloginTicket()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    StringBuilder localStringBuilder = new StringBuilder();
    int i = 0;
    while (i < localAccountList.size())
    {
      localStringBuilder.append(localAccountList.get(i).getEmail()).append(":\n").append(QMWtLoginManager.getInstance().getA2(localAccountList.get(i).getUin())).append("\n");
      i += 1;
    }
    Toast.makeText(QMApplicationContext.sharedInstance(), localStringBuilder.toString(), 1).show();
  }
  
  private static void showbrightnessDialog()
  {
    Activity localActivity = QMActivityManager.shareInstance().getVisibleActivity();
    if (localActivity != null)
    {
      BrightnessDialog localBrightnessDialog = new BrightnessDialog();
      localBrightnessDialog.show(localActivity.getFragmentManager(), "BrightnessDialog");
      localBrightnessDialog.setCancelable(true);
    }
  }
  
  private static void simulateAutologin()
  {
    Iterator localIterator = AccountManager.shareInstance().getAccountList().iterator();
    while (localIterator.hasNext())
    {
      Account localAccount = (Account)localIterator.next();
      if ((localAccount instanceof QQMailAccount)) {
        ((QQMailAccount)localAccount).autoLogin();
      }
    }
  }
  
  private static void simulateJavaCore()
  {
    throw new DevRuntimeException("simulate java core!");
  }
  
  private static void simulateNativeCore() {}
  
  private static void simulatePushSchema()
  {
    try
    {
      String str1 = Environment.getExternalStorageDirectory().getAbsolutePath() + File.separator + "pushschema.txt";
      String str2 = FileUtils.readFileToString(new File(str1));
      Log.i("DeveloperActivity", "develop push schema path: " + str1 + ", content: " + str2);
      SchemaUtil.handleSchemaAction(QMApplicationContext.sharedInstance(), str2, 1, 0);
      return;
    }
    catch (IOException localIOException)
    {
      localIOException.printStackTrace();
    }
  }
  
  private static String simulationModifySid(String paramString)
  {
    paramString = AccountManager.shareInstance().getAccountList().getDefaultMailAccount();
    if ((paramString instanceof QQMailAccount))
    {
      String str = ((QQMailAccount)paramString).getSid();
      if ((str != null) && (str.length() > 5)) {
        ((QQMailAccount)paramString).setSid(str.substring(0, 5));
      }
    }
    return getModifySidTitle();
  }
  
  private static boolean switchWtlogin(boolean paramBoolean)
  {
    if (!SharedPreferenceUtil.isWtlogin()) {}
    for (paramBoolean = true;; paramBoolean = false)
    {
      SharedPreferenceUtil.setWtlogin(paramBoolean);
      return SharedPreferenceUtil.isWtlogin();
    }
  }
  
  private static void trigerPopularUpdateConfig()
  {
    PopularizeManager.sharedInstance().deleteAllPopularize();
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    localSparseBooleanArray.put(11, true);
    QMPrivateProtocolManager.sharedInstance().updateConfig(true, 4, localSparseBooleanArray);
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131719758, 0).show();
  }
  
  private static void trigerUpdateconfig()
  {
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    int i = 1;
    while (i <= 17)
    {
      localSparseBooleanArray.append(i, true);
      i += 1;
    }
    QMPrivateProtocolManager.sharedInstance().updateConfig(true, 128, localSparseBooleanArray);
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131719758, 0).show();
  }
  
  private static void triggerPushConfigForce()
  {
    SPManager.getEditor("user_info").putString("configtype_14", "").apply();
    SparseBooleanArray localSparseBooleanArray = new SparseBooleanArray();
    localSparseBooleanArray.put(14, true);
    QMPrivateProtocolManager.sharedInstance().updateConfig(true, 4, localSparseBooleanArray);
    Toast.makeText(QMApplicationContext.sharedInstance(), 2131719758, 0).show();
  }
  
  private static void uploadDBFile()
  {
    SchemaUtil.handleSchemaAction(QMApplicationContext.sharedInstance(), "qqmail://tools?action=upload&obj=debuglog&duration=1&params=1|upload_QMMailDB|QMMailDB,QMSettingDB&sign=updateconfig", 1, 0);
  }
  
  private static void useDefaultUA()
  {
    String str = "(\"name\" \"QQMail\" \"os\" \"Android\" \"os-version\" \"" + DeviceUtil.getDeviceInfos().releaseVersion + "\" \"version\" \"" + AppConfig.getCodeVersionName() + "\" \"vendor\" \"Tencent Limited\" \"contact\" \"helpapp@qq.com\")";
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    int i = 0;
    while (i < localAccountList.size())
    {
      if (!localAccountList.get(i).isQQMail()) {
        localAccountList.get(i).getProfile().imapUserAgentId = str;
      }
      i += 1;
    }
  }
  
  public void initDom()
  {
    super.initDom();
    initTopBar();
  }
  
  public void initViewData()
  {
    createContentTableData();
    createLogTalbeData();
    createHotfixTableData();
    createDebugTableData();
    createToolTableData();
    createSimulationTableData();
    createNetworkTableData();
    createPushTableData();
  }
  
  public boolean onDragBack(MotionEvent paramMotionEvent)
  {
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.setting.DeveloperActivity
 * JD-Core Version:    0.7.0.1
 */