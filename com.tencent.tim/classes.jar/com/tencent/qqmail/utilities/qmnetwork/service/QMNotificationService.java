package com.tencent.qqmail.utilities.qmnetwork.service;

import android.app.IntentService;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.AppStatusUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import moai.oss.KvHelper;

public class QMNotificationService
  extends IntentService
{
  public static final String HOST_CANCEL = "cancel";
  public static final String HOST_CLEAR = "clear";
  public static final String HOST_DELETE = "delete";
  public static final String HOST_READ = "read";
  public static final String HOST_SCAN_FILE = "scan_file";
  public static final String QUERY_ACCOUNTID = "accountid";
  public static final String QUERY_FOLDERID = "folderid";
  public static final String QUERY_MAILID = "mailid";
  public static final String QUERY_NOTIFICATION_ID = "notificationid";
  public static final String QUERY_REMOTEID = "remoteid";
  public static final String SCHEME = "qqmail";
  private static final String TAG = "QMNotificationService";
  
  public QMNotificationService()
  {
    super("QMNotificationService");
  }
  
  private static int string2int(String paramString)
  {
    try
    {
      int i = Integer.parseInt(paramString);
      return i;
    }
    catch (Exception paramString) {}
    return 0;
  }
  
  private static long string2long(String paramString)
  {
    try
    {
      long l = Long.parseLong(paramString);
      return l;
    }
    catch (Exception paramString) {}
    return 0L;
  }
  
  public void onCreate()
  {
    super.onCreate();
    QMLog.log(4, "QMNotificationService", "onCreate, " + Integer.toHexString(hashCode()));
  }
  
  public void onDestroy()
  {
    QMLog.log(4, "QMNotificationService", "onDestroy, " + Integer.toHexString(hashCode()));
    super.onDestroy();
  }
  
  protected void onHandleIntent(Intent paramIntent)
  {
    Uri localUri;
    if (paramIntent != null)
    {
      localUri = paramIntent.getData();
      if ((localUri != null) && ("qqmail".equals(localUri.getScheme())))
      {
        QMLog.log(4, "QMNotificationService", "notification service host:" + localUri.getHost() + ", query:" + localUri.getQuery());
        if (!"clear".equals(localUri.getHost())) {
          break label96;
        }
        QMPushMailNotify.getInstance().cancelAllNotifyNewMail();
        KvHelper.eventClearAllNotification(new double[0]);
      }
    }
    label96:
    int i;
    String str;
    int j;
    do
    {
      return;
      i = string2int(localUri.getQueryParameter("accountid"));
      str = localUri.getQueryParameter("remoteid");
      j = string2int(localUri.getQueryParameter("notificationid"));
    } while (i <= 0);
    int k;
    long l;
    if ("read".equals(localUri.getHost()))
    {
      k = string2int(localUri.getQueryParameter("folderid"));
      paramIntent = localUri.getQueryParameter("remoteid");
      l = string2long(localUri.getQueryParameter("mailid"));
      QMMailManager.sharedInstance().unreadMailMaybeNotDownload(i, k, l, paramIntent, false);
      DataCollector.logEvent("Event_Notifycenter_Read");
      QMMailManager.sharedInstance().checkUpdateConfig(false);
      AppStatusUtil.logWakeup();
      KvHelper.eventNotificationMarkReadNewMail(new double[0]);
    }
    for (;;)
    {
      QMPushMailNotify.getInstance().cancelNotifyNewMail(i, paramIntent, j);
      return;
      if ("delete".equals(localUri.getHost()))
      {
        k = string2int(localUri.getQueryParameter("folderid"));
        paramIntent = localUri.getQueryParameter("remoteid");
        l = string2long(localUri.getQueryParameter("mailid"));
        QMMailManager.sharedInstance().deleteMailMaybeNotDownload(i, k, l, paramIntent);
        DataCollector.logEvent("Event_Notifycenter_Del");
        QMMailManager.sharedInstance().checkUpdateConfig(false);
        AppStatusUtil.logWakeup();
        KvHelper.eventNotificationMarkDeleteNewMail(new double[0]);
      }
      else
      {
        paramIntent = str;
        if ("cancel".equals(localUri.getHost()))
        {
          KvHelper.eventClearSingleNewMailNotification(new double[0]);
          paramIntent = str;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.qmnetwork.service.QMNotificationService
 * JD-Core Version:    0.7.0.1
 */