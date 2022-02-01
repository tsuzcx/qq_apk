package com.tencent.qqmail.launcher.third;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import com.tencent.androidqqmail.tim.TimReportManager;
import com.tencent.qqmail.BaseActivity;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.activity.compose.ComposeNoteActivity;
import com.tencent.qqmail.activity.setting.SettingNoteActivity;
import com.tencent.qqmail.activity.webviewexplorer.SimpleWebViewExplorer;
import com.tencent.qqmail.attachment.util.IntentUtil;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.fragment.CalendarMainFragment;
import com.tencent.qqmail.calendar.fragment.ModifyScheduleFragment;
import com.tencent.qqmail.calendar.model.QMCalendarManager;
import com.tencent.qqmail.folderlist.FolderDataManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.launcher.base.LauncherUtils;
import com.tencent.qqmail.launcher.desktop.LauncherActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.note.NoteListActivity;
import com.tencent.qqmail.note.ReadNoteActivity;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.qmui.dialog.QMUIDialog;
import com.tencent.qqmail.qmui.dialog.QMUIDialog.MessageDialogBuilder;
import com.tencent.qqmail.schema.SchemaUtil;
import com.tencent.qqmail.sendmaillist.SendMailListFragment;
import com.tencent.qqmail.trd.safecomponent.SafeIntent;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.service.QMPushMailNotify;
import com.tencent.qqmail.utilities.qmnetwork.ssl.SSLStrategyFactory;
import com.tencent.qqmail.utilities.qmnetwork.ssl.SafeSSLStrategy;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import moai.fragment.base.BaseFragmentActivity;
import moai.oss.KvHelper;

public class LaunchWebPush
  extends ThirdLauncherActivity
{
  private static final String ARG_ACCOUNT_ID = "arg_launch_webpush_accountid";
  private static final String ARG_CLEAR_TASKS = "arg_clear_tasks";
  private static final String ARG_TYPE = "arg_launch_webpush_type";
  private static final String BOTTLE_ACCOUNT_ID = "accountId";
  private static final String BOTTLE_BOTTLE_ID = "bottleId";
  private static final String BOTTLE_PICK_KEY = "pickkey";
  private static final String BOTTLE_SUBTYPE = "subtype";
  private static final int BOTTLE_SUBTYPE_FAIL_TO_THROW = 1;
  private static final int BOTTLE_SUBTYPE_NEW_PUSH = 2;
  private static final int BOTTLE_SUBTYPE_RESPONSE = 3;
  private static final String CALENDAR_REMINDER_REMINDER_ID = "reminderId";
  private static final String CALENDAR_WIDGET_SCHEDULE_ID = "id";
  private static final int CHANGE_ACCOUNT = 2;
  private static final String FTN_ACCOUNT_ID = "account";
  private static final String FTN_FROM = "from";
  private static final String FTN_NEW_FILE_COUNT = "newFileCount";
  private static final String NOTE_ACCOUNT_ID = "account";
  private static final String NOTE_CATALOGNAME = "catalogName";
  private static final String NOTE_FROM = "from";
  private static final String NOTE_NOTE_ID = "noteId";
  private static final String ONE_MAIL_FOLDER_ID = "folderId";
  private static final String ONE_MAIL_IS_FROM_NOTIFICATION_PUSH = "isfromNOtificationPush";
  private static final String ONE_MAIL_IS_FROM_SCHEME_PUSH = "isFromSchemePush";
  private static final String ONE_MAIL_MAIL_ID = "mailId";
  private static final String ONE_MAIL_REMOTE_ID = "remoteId";
  private static final String ONE_MAIL_SENDER_EMAIL = "senderEmail";
  private static final String ONE_MAIL_SENDER_NICK = "senderNick";
  private static final String ONE_MAIL_SUBJECT = "subject";
  private static final int OPEN_PLUG = 1;
  private static final String PUSH_BETA_TITLE = "push_beta_title";
  private static final String PUSH_BETA_URL = "push_beta_url";
  private static final String PUSH_SCHEMA = "push_schema";
  private static final int PUSH_TYPE_BOTTLE = 3;
  private static final int PUSH_TYPE_FTN = 2;
  private static final int PUSH_TYPE_NOTE = 1;
  public static final String TAG = "LaunchWebPush";
  private static final int TYPE_BETA_PUSH_CONFIG = 12;
  private static final int TYPE_BOTTLE = 8;
  private static final int TYPE_CALENDAR_MAIN_PAGE = 9;
  private static final int TYPE_CALENDAR_REMIND = 10;
  private static final int TYPE_CALENDAR_WIDGET = 14;
  private static final int TYPE_FOLDER_LIST = 4;
  private static final int TYPE_FTN = 6;
  private static final int TYPE_LOGIN_INVALID = 16;
  private static final int TYPE_MORE_MAIL = 3;
  private static final int TYPE_NOTE = 5;
  private static final int TYPE_NOTE_MAIN_PAGE = 13;
  private static final int TYPE_ONE_MAIL_FROM_PUSH = 1;
  private static final int TYPE_ONE_MAIL_NOT_FROM_PUSH = 2;
  private static final int TYPE_PASSWORD_ERROR = 15;
  private static final int TYPE_PUSH_SCHEMA = 11;
  private static final int TYPE_SENDMAIL_LIST = 7;
  private static final int TYPE_SSL_ERROR = 17;
  private static int tag = -1;
  
  private ArrayList converToContactList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      paramList = paramList.iterator();
      while (paramList.hasNext())
      {
        String str = (String)paramList.next();
        localArrayList.add(new MailContact(str.split("&")[0], str));
      }
    }
    return localArrayList;
  }
  
  public static Intent createBetaIntent(String paramString1, String paramString2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 12);
    localIntent.putExtra("push_beta_url", paramString1);
    localIntent.putExtra("push_beta_title", paramString2);
    return localIntent;
  }
  
  public static Intent createBottleFailToThrowIntent(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 8);
    localIntent.putExtra("subtype", 1);
    localIntent.putExtra("accountId", paramInt);
    localIntent.putExtra("bottleId", paramString);
    return localIntent;
  }
  
  public static Intent createBottleNewPush(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 8);
    localIntent.putExtra("subtype", 2);
    localIntent.putExtra("accountId", paramInt);
    localIntent.putExtra("pickkey", paramString);
    localIntent.setAction(String.valueOf(System.currentTimeMillis()));
    return localIntent;
  }
  
  public static Intent createBottleResponse(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 8);
    localIntent.putExtra("subtype", 3);
    localIntent.putExtra("accountId", paramInt);
    localIntent.putExtra("bottleId", paramString);
    localIntent.setAction(String.valueOf(System.currentTimeMillis()));
    return localIntent;
  }
  
  public static Intent createCalendarMainIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 9);
    return localIntent;
  }
  
  public static Intent createCalendarReminderIntent(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 10);
    localIntent.putExtra("reminderId", paramInt);
    return localIntent;
  }
  
  public static Intent createCalendarScheduleIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 14);
    return localIntent;
  }
  
  public static Intent createEmptyScheduleIntent(int paramInt)
  {
    Intent localIntent = new Intent();
    localIntent.putExtra("id", paramInt);
    return localIntent;
  }
  
  public static Intent createFolderList(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 4);
    localIntent.putExtra("arg_launch_webpush_accountid", paramInt);
    initIntentFlag(localIntent);
    return localIntent;
  }
  
  public static Intent createFtnIntent(int paramInt1, String paramString, int paramInt2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 6);
    localIntent.putExtra("account", paramInt1);
    localIntent.putExtra("from", paramString);
    localIntent.putExtra("newFileCount", paramInt2);
    localIntent.setAction(String.valueOf(System.currentTimeMillis()));
    return localIntent;
  }
  
  public static Intent createIntentToCertainCalendarSchedule(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 14);
    localIntent.putExtra("id", paramInt);
    return localIntent;
  }
  
  public static Intent createLoginInvalidIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 16);
    return localIntent;
  }
  
  public static Intent createMoreMailIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 3);
    initIntentFlag(localIntent);
    return localIntent;
  }
  
  public static Intent createNoteIntent(int paramInt, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 5);
    localIntent.putExtra("account", paramInt);
    localIntent.putExtra("noteId", paramString1);
    localIntent.putExtra("from", paramString2);
    localIntent.putExtra("catalogName", paramString3);
    localIntent.setAction(String.valueOf(System.currentTimeMillis()));
    return localIntent;
  }
  
  public static Intent createNoteMainIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 13);
    return localIntent;
  }
  
  public static Intent createOneMailIntentFromPush(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 1);
    localIntent.putExtra("arg_launch_webpush_accountid", paramInt1);
    localIntent.putExtra("folderId", paramInt2);
    localIntent.putExtra("mailId", paramLong);
    localIntent.putExtra("remoteId", paramString1);
    localIntent.putExtra("subject", paramString2);
    localIntent.putExtra("senderNick", paramString3);
    localIntent.putExtra("senderEmail", paramString4);
    localIntent.putExtra("isfromNOtificationPush", paramBoolean1);
    localIntent.putExtra("isFromSchemePush", paramBoolean2);
    initIntentFlag(localIntent);
    return localIntent;
  }
  
  public static Intent createOneMailIntentNotFromPush(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 2);
    localIntent.putExtra("arg_launch_webpush_accountid", paramInt1);
    localIntent.putExtra("folderId", paramInt2);
    localIntent.putExtra("mailId", paramLong);
    localIntent.putExtra("subject", paramString1);
    localIntent.putExtra("senderNick", paramString2);
    localIntent.putExtra("senderEmail", paramString3);
    initIntentFlag(localIntent);
    return localIntent;
  }
  
  public static Intent createPasswordErrorIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 15);
    return localIntent;
  }
  
  public static Intent createPushSchemaIntent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 11);
    localIntent.putExtra("push_schema", paramString);
    initIntentFlag(localIntent);
    return localIntent;
  }
  
  public static Intent createSSLErrorIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 17);
    return localIntent;
  }
  
  private Intent createSchemeIntent(HashMap<String, List<String>> paramHashMap, String paramString)
  {
    Object localObject2 = new StringBuilder().append("enter create");
    Object localObject1;
    Object localObject3;
    int i;
    if (paramHashMap == null)
    {
      localObject1 = "map null";
      QMLog.log(4, "LaunchWebPush", (String)localObject1);
      localObject2 = null;
      localObject1 = localObject2;
      if (paramHashMap != null)
      {
        localObject1 = localObject2;
        if (paramHashMap.get("uin") != null)
        {
          localObject1 = localObject2;
          if (paramHashMap.get(paramString) != null)
          {
            paramString = (String)((List)paramHashMap.get(paramString)).get(0);
            localObject1 = "";
            localObject3 = (String)((List)paramHashMap.get("uin")).get(0);
            localObject3 = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin((String)localObject3);
            if (localObject3 == null) {
              break label1018;
            }
            i = ((Account)localObject3).getId();
            localObject3 = (List)paramHashMap.get("mailid");
            if (localObject3 == null) {
              break label716;
            }
            localObject2 = QMMailManager.sharedInstance().getMailInfoByRemoteId(i, (String)((List)localObject3).get(0));
            if (localObject2 == null) {
              break label542;
            }
            localObject1 = ((Mail)localObject2).getInformation();
            ((MailInformation)localObject1).setToList(converToContactList((List)paramHashMap.get("mailto")));
            ((MailInformation)localObject1).setCcList(converToContactList((List)paramHashMap.get("mailcc")));
            ((MailInformation)localObject1).setBccList(converToContactList((List)paramHashMap.get("mailbcc")));
            if (paramHashMap.get("subject") != null) {
              ((MailInformation)localObject1).setSubject((String)((List)paramHashMap.get("subject")).get(0));
            }
            if (paramHashMap.get("content") != null)
            {
              localObject4 = new MailContent();
              ((MailContent)localObject4).setBody((String)((List)paramHashMap.get("content")).get(0));
              ((Mail)localObject2).setContent((MailContent)localObject4);
            }
            long l = ((MailInformation)localObject1).getId();
            int j = ((MailInformation)localObject1).getFolderId();
            paramHashMap = ((MailInformation)localObject1).getSubject();
            Object localObject4 = ((MailInformation)localObject1).getFrom().getAddress();
            localObject1 = ((MailInformation)localObject1).getFrom().getNick();
            localObject2 = new MailUI((Mail)localObject2);
            if (!paramString.equals("read")) {
              break label446;
            }
            QMLog.log(4, "LaunchWebPush", "read create by db");
            paramHashMap = MailFragmentActivity.createIntentToReadmailFromPush(i, j, l, (String)((List)localObject3).get(0), paramHashMap, (String)localObject1, (String)localObject4, false, true, false);
          }
        }
      }
    }
    label542:
    for (;;)
    {
      localObject1 = paramHashMap;
      label434:
      return localObject1;
      localObject1 = paramHashMap.toString();
      break;
      label446:
      if (paramString.equals("forward"))
      {
        QMLog.log(4, "LaunchWebPush", "forward create by db");
        paramHashMap = ComposeMailActivity.createIntentForWeiXin(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD, 1, (Mail)localObject2);
      }
      else if (paramString.equals("reply"))
      {
        QMLog.log(4, "LaunchWebPush", "reply create by db");
        paramHashMap = ComposeMailActivity.createIntentForWeiXin(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY, 0, (Mail)localObject2);
      }
      else
      {
        if (paramString.equals("replyall"))
        {
          QMLog.log(4, "LaunchWebPush", "replyall create by db");
          paramHashMap = ComposeMailActivity.createIntentForWeiXin(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL, 0, (Mail)localObject2);
          continue;
          if (paramString.equals("read"))
          {
            if (paramHashMap.get("subject") != null) {}
            for (paramString = (String)((List)paramHashMap.get("subject")).get(0);; paramString = "")
            {
              if (paramHashMap.get("address") != null) {
                localObject1 = (String)((List)paramHashMap.get("address")).get(0);
              }
              if (paramHashMap.get("sendernick") != null) {}
              for (paramHashMap = (String)((List)paramHashMap.get("sendernick")).get(0);; paramHashMap = "")
              {
                QMLog.log(4, "LaunchWebPush", "read create by dbsubject" + paramString + "senderEmail" + (String)localObject1 + "senderNick" + paramHashMap);
                paramHashMap = MailFragmentActivity.createIntentToReadmailFromPush(i, -1, -1L, (String)((List)localObject3).get(0), paramString, paramHashMap, (String)localObject1, false, true, false);
                break;
                label716:
                if (paramString.equals("compose"))
                {
                  paramString = new Mail();
                  localObject1 = new MailInformation();
                  ((MailInformation)localObject1).setToList(converToContactList((List)paramHashMap.get("mailto")));
                  ((MailInformation)localObject1).setCcList(converToContactList((List)paramHashMap.get("mailcc")));
                  ((MailInformation)localObject1).setBccList(converToContactList((List)paramHashMap.get("mailbcc")));
                  if (paramHashMap.get("subject") != null) {
                    ((MailInformation)localObject1).setSubject((String)((List)paramHashMap.get("subject")).get(0));
                  }
                  if (paramHashMap.get("content") != null)
                  {
                    localObject2 = new MailContent();
                    ((MailContent)localObject2).setBody((String)((List)paramHashMap.get("content")).get(0));
                    paramString.setContent((MailContent)localObject2);
                  }
                  paramString.setInformation((MailInformation)localObject1);
                  paramString.setStatus(new MailStatus());
                  QMLog.log(4, "LaunchWebPush", "compose create");
                  return ComposeMailActivity.createIntent(i, paramString);
                }
                localObject1 = localObject2;
                if (!paramString.equals("ftn")) {
                  break label434;
                }
                QMLog.log(4, "LaunchWebPush", "ftn create");
                localObject1 = localObject2;
                if (paramHashMap.get("k") == null) {
                  break label434;
                }
                paramHashMap = (String)((List)paramHashMap.get("k")).get(0);
                localObject1 = localObject2;
                if (paramHashMap.equals("")) {
                  break label434;
                }
                localObject1 = localObject2;
                if (!paramHashMap.contains(",")) {
                  break label434;
                }
                paramHashMap = paramHashMap.split(",");
                LaunchSaveToMyFtn.launchSaveToMyFtn(paramHashMap[0], paramHashMap[1], this);
                return null;
                label1018:
                enterAccountListOrFolderList();
                return null;
              }
            }
          }
        }
        paramHashMap = null;
      }
    }
  }
  
  public static Intent createSendMailListIntent()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), LaunchWebPush.class);
    localIntent.putExtra("arg_launch_webpush_type", 7);
    return localIntent;
  }
  
  private void enterAccountListOrFolderList()
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    if (localAccountList.size() == 0) {
      startActivity(AccountTypeListActivity.createIntent());
    }
    do
    {
      return;
      if (localAccountList.size() == 1)
      {
        startActivity(MailFragmentActivity.createIntentToFolderList(localAccountList.get(0).getId()));
        return;
      }
    } while (localAccountList.size() <= 1);
    startActivity(MailFragmentActivity.createIntentToAccountList());
  }
  
  private HashMap<String, List<String>> getUrlParama(String paramString1, String paramString2)
  {
    if ((paramString1 != null) && (paramString2 != null))
    {
      HashMap localHashMap = new HashMap();
      Object localObject = paramString1.split("\\?");
      if (localObject.length > 1)
      {
        localHashMap.put(paramString2, Arrays.asList(new String[] { localObject[0].replace("//", "") }));
        paramString1 = paramString1.replace(localObject[0] + "?", "").split("\\&");
        int i = 0;
        if (i < paramString1.length)
        {
          paramString2 = paramString1[i].split("\\=");
          if (paramString2.length >= 2)
          {
            if (!localHashMap.containsKey(paramString2[0])) {
              break label165;
            }
            ((List)localHashMap.get(paramString2[0])).add(Uri.decode(paramString2[1]));
          }
          for (;;)
          {
            i += 1;
            break;
            label165:
            localObject = new ArrayList(1);
            ((ArrayList)localObject).add(Uri.decode(paramString2[1]));
            localHashMap.put(paramString2[0], localObject);
          }
        }
      }
      return localHashMap;
    }
    return null;
  }
  
  private boolean handleNotificationPushIntent(Intent paramIntent, int paramInt)
  {
    int i;
    int j;
    Object localObject1;
    Object localObject2;
    Object localObject3;
    Object localObject4;
    String str;
    switch (paramInt)
    {
    default: 
      return false;
    case 1: 
    case 2: 
      KvHelper.eventClickNewMailNotification(new double[0]);
      i = paramIntent.getIntExtra("arg_launch_webpush_accountid", 0);
      if (i != 0) {
        QMPushMailNotify.getInstance().cancelNotifyNewMail(i);
      }
      j = paramIntent.getIntExtra("folderId", 0);
      localObject1 = Long.valueOf(paramIntent.getLongExtra("mailId", 0L));
      localObject2 = paramIntent.getStringExtra("remoteId");
      localObject3 = paramIntent.getStringExtra("subject");
      localObject4 = paramIntent.getStringExtra("senderNick");
      str = paramIntent.getStringExtra("senderEmail");
      boolean bool1 = paramIntent.getBooleanExtra("isfromNOtificationPush", false);
      boolean bool2 = paramIntent.getBooleanExtra("isFromSchemePush", false);
      if (paramInt == 1)
      {
        paramIntent = MailFragmentActivity.createIntentToReadmailFromPush(i, j, ((Long)localObject1).longValue(), (String)localObject2, (String)localObject3, (String)localObject4, str, bool1, bool2, false);
        TimReportManager.reportClickEvent(QMApplicationContext.sharedInstance(), "0X8008904", 0, 0, 0, 0, 0, "", "", "", "");
        startActivity(paramIntent);
      }
      break;
    }
    label1154:
    for (;;)
    {
      return true;
      paramIntent = MailFragmentActivity.createIntentToReadmail(i, j, ((Long)localObject1).longValue(), (String)localObject3, (String)localObject4, str, false);
      break;
      paramIntent = AccountManager.shareInstance().getAccountList();
      paramInt = paramIntent.size();
      if (paramInt == 1)
      {
        startActivity(MailFragmentActivity.createIntentToFolderList(paramIntent.get(0).getId()));
        return false;
      }
      label800:
      if (paramInt > 1)
      {
        startActivity(MailFragmentActivity.createIntentToAccountList());
        return false;
        startActivity(MailFragmentActivity.createIntentToFolderList(paramIntent.getIntExtra("arg_launch_webpush_accountid", 0)));
        continue;
        paramInt = paramIntent.getIntExtra("account", 0);
        localObject2 = paramIntent.getStringExtra("noteId");
        localObject3 = paramIntent.getStringExtra("from");
        paramIntent = paramIntent.getStringExtra("catalogName");
        localObject1 = new Intent(QMApplicationContext.sharedInstance(), ReadNoteActivity.class);
        ((Intent)localObject1).putExtra("account", paramInt);
        ((Intent)localObject1).putExtra("noteId", (String)localObject2);
        ((Intent)localObject1).putExtra("from", (String)localObject3);
        ((Intent)localObject1).putExtra("catalogName", paramIntent);
        localObject2 = AccountManager.shareInstance().getAccountList().getDefaultNoteAccount();
        localObject3 = new StringBuilder().append("launchwebpush note: ");
        if (localObject2 == null) {}
        for (paramIntent = null;; paramIntent = Integer.valueOf(((QQMailAccount)localObject2).getId()))
        {
          QMLog.log(4, "webpush", paramIntent + ", " + ((Intent)localObject1).getIntExtra("account", 0));
          if ((localObject2 == null) || (((QQMailAccount)localObject2).getId() != ((Intent)localObject1).getIntExtra("account", 0))) {
            break label554;
          }
          if (!QMSettingManager.sharedInstance().getNoteDisplay()) {
            QMSettingManager.sharedInstance().setNoteDisplay(true);
          }
          initIntentFlag((Intent)localObject1);
          ((Intent)localObject1).addFlags(268435456);
          startActivity((Intent)localObject1);
          break;
        }
        label554:
        if (QMActivityManager.shareInstance().getActivitySize() <= 1)
        {
          enterAccountListOrFolderList();
          Threads.runOnMainThread(new LaunchWebPush.1(this, paramInt), 2000L);
        }
        else
        {
          showMessage(1, paramInt, false);
          continue;
          localObject1 = new Intent(QMApplicationContext.sharedInstance(), FtnListActivity.class);
          paramInt = paramIntent.getIntExtra("account", 0);
          localObject2 = paramIntent.getStringExtra("from");
          i = paramIntent.getIntExtra("newFileCount", 0);
          ((Intent)localObject1).putExtra("account", paramInt);
          ((Intent)localObject1).putExtra("from", (String)localObject2);
          ((Intent)localObject1).putExtra("newFileCount", i);
          localObject2 = AccountManager.shareInstance().getAccountList().getDefaultFtnAccount();
          localObject3 = new StringBuilder().append("launchwebpush ftn: ");
          if (localObject2 == null) {}
          for (paramIntent = null;; paramIntent = Integer.valueOf(((QQMailAccount)localObject2).getId()))
          {
            QMLog.log(4, "webpush", paramIntent + ", " + ((Intent)localObject1).getIntExtra("account", 0));
            if ((localObject2 == null) || (((QQMailAccount)localObject2).getId() != ((Intent)localObject1).getIntExtra("account", 0))) {
              break label800;
            }
            if (!QMSettingManager.sharedInstance().getFtnDisplay()) {
              QMSettingManager.sharedInstance().setFtnDisplay(true);
            }
            initIntentFlag((Intent)localObject1);
            ((Intent)localObject1).addFlags(268435456);
            startActivity((Intent)localObject1);
            break;
          }
          if (QMActivityManager.shareInstance().getActivitySize() <= 1)
          {
            enterAccountListOrFolderList();
            Threads.runOnMainThread(new LaunchWebPush.2(this, paramInt), 2000L);
          }
          else
          {
            showMessage(2, paramInt, false);
            continue;
            if (canEnterOtherActivity())
            {
              paramIntent = QMActivityManager.shareInstance().getFirstInvisibleActivity();
              if ((paramIntent == null) || ((paramIntent instanceof BaseActivity)))
              {
                startActivity(MailFragmentActivity.createIntentToSendMailList(true));
              }
              else if ((paramIntent instanceof BaseFragmentActivity))
              {
                paramIntent = (BaseFragmentActivity)paramIntent;
                if (!paramIntent.isCurrentPage(SendMailListFragment.class))
                {
                  paramIntent.startFragment(new SendMailListFragment());
                  continue;
                  paramInt = paramIntent.getIntExtra("accountId", 0);
                  localObject1 = AccountManager.shareInstance().getAccountList();
                  if (((AccountList)localObject1).getAccountById(paramInt) == null)
                  {
                    QMLog.log(4, "webpush", "launchwebpush bottle no account: " + paramInt);
                    if (((AccountList)localObject1).size() == 0)
                    {
                      paramIntent = AccountTypeListActivity.createIntent(true);
                      initIntentFlag(paramIntent);
                      startActivity(paramIntent);
                      return true;
                    }
                  }
                  localObject2 = paramIntent.getStringExtra("bottleId");
                  i = paramIntent.getIntExtra("subtype", 0);
                  localObject3 = AccountManager.shareInstance().getAccountList().getDefaultBottleAccount();
                  localObject4 = new StringBuilder().append("launchwebpush bottle: ");
                  if (localObject3 == null) {}
                  for (localObject1 = null;; localObject1 = Integer.valueOf(((QQMailAccount)localObject3).getId()))
                  {
                    QMLog.log(4, "webpush", localObject1 + ", " + paramInt + ", " + i);
                    if ((localObject3 == null) || (paramInt != ((QQMailAccount)localObject3).getId()) || (!QMSettingManager.sharedInstance().isBottleEnabled())) {
                      break label1195;
                    }
                    if ((i != 1) && (i != 3)) {
                      break label1154;
                    }
                    paramIntent = BottleFragmentActivity.createConversationIntent((String)localObject2);
                    initIntentFlag(paramIntent);
                    paramIntent.addFlags(268435456);
                    startActivity(paramIntent);
                    overridePendingTransition(0, 0);
                    break;
                  }
                  if (i == 2)
                  {
                    paramIntent = BottleFragmentActivity.createBeachIntent(paramIntent.getStringExtra("pickkey"));
                    initIntentFlag(paramIntent);
                    paramIntent.addFlags(268435456);
                    startActivity(paramIntent);
                    overridePendingTransition(0, 0);
                    continue;
                    label1195:
                    QMActivityManager.shareInstance().finishAllActivity(this);
                    enterAccountListOrFolderList();
                    Threads.runOnMainThread(new LaunchWebPush.3(this, paramInt), 2000L);
                    continue;
                    DataCollector.logEvent("Event_Click_Calendar_Shortcut");
                    LauncherUtils.IS_CLICK_SHORTCUT = true;
                    if (((LauncherUtils.APP_LAUCHER_TYPE != LauncherUtils.LAUCHER_FROM_CALENDAR) && (!isCalendarActivityExist())) || (QMActivityManager.shareInstance().getActivitySize() == 1))
                    {
                      LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_CALENDAR;
                      QMActivityManager.shareInstance().finishAllActivity();
                      if (AccountManager.shareInstance().getAccountList().size() == 0) {
                        paramIntent = AccountTypeListActivity.createIntent();
                      }
                      for (;;)
                      {
                        startActivity(paramIntent);
                        break;
                        localObject1 = CalendarFragmentActivity.createIntent();
                        localObject2 = FolderDataManager.getInnerAppIdList();
                        paramIntent = (Intent)localObject1;
                        if (localObject2 != null)
                        {
                          paramIntent = (Intent)localObject1;
                          if (((ArrayList)localObject2).contains(Integer.valueOf(-18)))
                          {
                            ((Intent)localObject1).putExtra("fromCalendarShortcutAppFolderAndCalendarInAppFolder", true);
                            paramIntent = (Intent)localObject1;
                          }
                        }
                      }
                      if (canEnterOtherActivity())
                      {
                        paramInt = paramIntent.getIntExtra("reminderId", 0);
                        QMActivityManager.shareInstance().finishAllActivity();
                        QMCalendarManager.logEvent("Event_Calendar_Push_Preview_Event");
                        startActivity(CalendarFragmentActivity.createIntentToReadSchedule(paramInt));
                        continue;
                        if (canEnterOtherActivity())
                        {
                          paramInt = paramIntent.getIntExtra("id", 0);
                          QMActivityManager.shareInstance().finishAllActivity();
                          startActivity(CalendarFragmentActivity.createIntentToReadScheduleByScheduleId(paramInt));
                          continue;
                          SchemaUtil.handleSchemaAction(this, paramIntent.getStringExtra("push_schema"), 1, 3);
                          continue;
                          DataCollector.logEvent("Event_Beta_Notification_Click");
                          localObject1 = paramIntent.getStringExtra("push_beta_url");
                          if (!SchemaUtil.handleSchemaAction(this, (String)localObject1, 1, 5))
                          {
                            startActivity(SimpleWebViewExplorer.createIntent((String)localObject1, paramIntent.getStringExtra("push_beta_title"), SimpleWebViewExplorer.TOPBAR_LEFT_BUTTON));
                            continue;
                            DataCollector.logEvent("Event_Click_Note_Shortcut");
                            LauncherUtils.IS_CLICK_SHORTCUT = true;
                            if (((LauncherUtils.APP_LAUCHER_TYPE != LauncherUtils.LAUCHER_FROM_NOTE) && (!isNoteActivityExist())) || (QMActivityManager.shareInstance().getActivitySize() == 1))
                            {
                              LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_NOTE;
                              QMActivityManager.shareInstance().finishAllActivity();
                              paramIntent = AccountManager.shareInstance().getAccountList();
                              if (paramIntent.size() == 0) {
                                paramIntent = AccountTypeListActivity.createIntent("extra_from_note_shortcut");
                              }
                              for (;;)
                              {
                                startActivity(paramIntent);
                                break;
                                if (paramIntent.getDefaultNoteAccount() == null)
                                {
                                  paramIntent = SettingNoteActivity.createIntentFromShortcut();
                                }
                                else if (!QMSettingManager.sharedInstance().getNoteDisplay())
                                {
                                  paramIntent = SettingNoteActivity.createIntent();
                                }
                                else
                                {
                                  localObject1 = new Intent(QMApplicationContext.sharedInstance(), NoteListActivity.class);
                                  localObject2 = FolderDataManager.getInnerAppIdList();
                                  paramIntent = (Intent)localObject1;
                                  if (localObject2 != null)
                                  {
                                    paramIntent = (Intent)localObject1;
                                    if (((ArrayList)localObject2).contains(Integer.valueOf(-4)))
                                    {
                                      ((Intent)localObject1).putExtra("fromNoteShortcutAppFolderAndNoteInAppFolder", true);
                                      paramIntent = (Intent)localObject1;
                                    }
                                  }
                                }
                              }
                              paramIntent = new Intent(QMApplicationContext.sharedInstance(), LauncherActivity.class);
                              LauncherUtils.APP_LAUCHER_TYPE = LauncherUtils.LAUCHER_FROM_PASSWARD_ERROR_PUSH;
                              startActivity(paramIntent);
                              continue;
                              paramIntent = AccountManager.shareInstance().getAccountList();
                              if (paramIntent.size() <= 0) {
                                paramIntent = AccountTypeListActivity.createIntent();
                              }
                              for (;;)
                              {
                                KvHelper.clickNotifyLoginInvalid(new double[0]);
                                startActivity(paramIntent);
                                break;
                                if (paramIntent.size() == 1) {
                                  paramIntent = MailFragmentActivity.createIntentToFolderList(paramIntent.get(0).getId());
                                } else {
                                  paramIntent = MailFragmentActivity.createIntentToAccountList();
                                }
                              }
                              KvHelper.clickSslNotification(new double[0]);
                              if ((SSLStrategyFactory.getSSLStrategy() instanceof SafeSSLStrategy)) {
                                SafeSSLStrategy.showUnconfirmedSSLDialog();
                              }
                              startActivity(new Intent(QMApplicationContext.sharedInstance(), LauncherActivity.class));
                            }
                          }
                        }
                      }
                    }
                  }
                }
              }
            }
          }
        }
      }
    }
  }
  
  private static void initIntentFlag(Intent paramIntent)
  {
    paramIntent.setFlags(268435456);
    paramIntent.addFlags(2);
    paramIntent.setAction(String.valueOf(System.currentTimeMillis()));
    paramIntent.putExtra("arg_clear_tasks", true);
  }
  
  private boolean isCalendarActivityExist()
  {
    return (QMActivityManager.shareInstance().existPage(CalendarFragmentActivity.class)) || (QMActivityManager.shareInstance().existPage(CalendarMainFragment.class)) || (QMActivityManager.shareInstance().existPage(ModifyScheduleFragment.class));
  }
  
  private boolean isNoteActivityExist()
  {
    return (QMActivityManager.shareInstance().existPage(ReadNoteActivity.class)) || (QMActivityManager.shareInstance().existPage(ComposeNoteActivity.class)) || (QMActivityManager.shareInstance().existPage(NoteListActivity.class));
  }
  
  private static void showMessage(int paramInt1, int paramInt2, boolean paramBoolean)
  {
    Activity localActivity;
    if (paramBoolean)
    {
      localActivity = QMActivityManager.shareInstance().getVisibleActivity();
      if (localActivity != null) {
        break label55;
      }
      QMLog.log(5, "LaunchWebPush", "activity null:" + paramInt1);
    }
    label55:
    AccountList localAccountList;
    do
    {
      return;
      localActivity = QMActivityManager.shareInstance().getFirstInvisibleActivity();
      break;
      localAccountList = AccountManager.shareInstance().getAccountList();
    } while (localAccountList.getAccountById(paramInt2) == null);
    Object localObject = "";
    if (paramInt1 == 1) {
      if (QMSettingManager.sharedInstance().getNoteDisplay())
      {
        localObject = localActivity.getString(2131697511, new Object[] { localAccountList.getAccountById(paramInt2).getEmail() });
        tag = 2;
      }
    }
    for (;;)
    {
      localObject = ((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)((QMUIDialog.MessageDialogBuilder)new QMUIDialog.MessageDialogBuilder(localActivity).setTitle(2131696311)).setMessage((CharSequence)localObject).addAction(2131691246, new LaunchWebPush.5())).addAction(2131719634, new LaunchWebPush.4(paramInt1, localActivity))).create();
      ((QMUIDialog)localObject).setCanceledOnTouchOutside(false);
      ((QMUIDialog)localObject).show();
      return;
      localObject = localActivity.getString(2131697512, new Object[] { localAccountList.getAccountById(paramInt2).getEmail() });
      tag = 1;
      continue;
      if (paramInt1 == 2)
      {
        if (QMSettingManager.sharedInstance().getFtnDisplay())
        {
          localObject = localActivity.getString(2131697509, new Object[] { localAccountList.getAccountById(paramInt2).getEmail() });
          tag = 2;
        }
        else
        {
          localObject = localActivity.getString(2131697510, new Object[] { localAccountList.getAccountById(paramInt2).getEmail() });
          tag = 1;
        }
      }
      else if (paramInt1 == 3)
      {
        localObject = localActivity.getString(2131697506, new Object[] { localAccountList.getAccountById(paramInt2).getEmail() });
        tag = 1;
      }
    }
  }
  
  public void initDataSource() {}
  
  public void initDom() {}
  
  public void onBindEvent(boolean paramBoolean) {}
  
  public void onNewIntent(Intent paramIntent)
  {
    super.onNewIntent(paramIntent);
    setIntent(SafeIntent.createSafeIntet(paramIntent));
    initUI();
  }
  
  public void onRelease() {}
  
  public void refreshData() {}
  
  public void render() {}
  
  protected void route()
  {
    Object localObject3 = null;
    try
    {
      if (!canEnterOtherActivity()) {
        finish();
      }
      localObject1 = IntentUtil.restoreComposeIntent();
      if (localObject1 != null)
      {
        startActivity((Intent)localObject1);
        finish();
      }
      localIntent = getIntent();
      if (localIntent.getBooleanExtra("arg_clear_tasks", false)) {
        QMActivityManager.shareInstance().finishAllActivity();
      }
      i = localIntent.getIntExtra("arg_launch_webpush_type", 0);
      localUri = localIntent.getData();
      QMLog.log(4, "LaunchWebPush", "incoming uri: " + localUri);
      if (localUri == null) {
        break label220;
      }
      localObject1 = localUri.getScheme();
      localObject3 = localUri.getEncodedSchemeSpecificPart();
    }
    catch (Exception localException)
    {
      for (;;)
      {
        Object localObject1;
        Intent localIntent;
        int i;
        Uri localUri;
        QMLog.log(6, "LaunchWebPush", localException.getMessage());
        finish();
        continue;
        Object localObject2 = null;
      }
    }
    if ((localObject1 != null) && (localObject3 != null) && (SchemaUtil.handleSchemaAction(this, localUri.toString(), 1, 0))) {
      finish();
    }
    localObject3 = getUrlParama((String)localObject3, (String)localObject1);
    if (localObject3 != null) {
      if (AccountManager.shareInstance().getAccountList().isLoginQQAccount())
      {
        QMActivityManager.shareInstance().finishAllActivity(this);
        localObject1 = createSchemeIntent((HashMap)localObject3, (String)localObject1);
        if (localObject1 != null) {
          startActivity((Intent)localObject1);
        }
      }
    }
    for (;;)
    {
      finish();
      return;
      handleNotificationPushIntent(localIntent, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.launcher.third.LaunchWebPush
 * JD-Core Version:    0.7.0.1
 */