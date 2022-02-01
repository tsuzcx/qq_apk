package com.tencent.qqmail.fragment.base;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.accountlist.fragment.AccountListFragment;
import com.tencent.qqmail.activity.readmail.ReadIcsFragment;
import com.tencent.qqmail.activity.readmail.ReadMailFragment;
import com.tencent.qqmail.folderlist.AppFolderListFragment;
import com.tencent.qqmail.folderlist.FolderListFragment;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.maillist.fragment.AggregateMailListFragment;
import com.tencent.qqmail.maillist.fragment.ConvMailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment;
import com.tencent.qqmail.maillist.fragment.MailListFragment.NullFolderException;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.model.qmdomain.ReuseMail;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.sendmaillist.SendMailListFragment;
import com.tencent.qqmail.subscribe.SubscribeListFragment;
import com.tencent.qqmail.utilities.StatusBarUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.osslog.QMOssClient;
import java.util.ArrayList;
import moai.fragment.app.FragmentManager;
import moai.fragment.app.FragmentTransaction;
import moai.fragment.base.BaseFragmentActivity;
import moai.fragment.base.NullMailException;
import org.apache.commons.lang3.StringUtils;

public class MailFragmentActivity
  extends BaseFragmentActivity
{
  private static final String ARG_ACCOUNT_ID = "arg_basefragment_account_id";
  private static final String ARG_FOLDER_ID = "arg_baseFragment_folder_id";
  private static final String ARG_FROM = "arg_from";
  private static final String ARG_FROM_NOTIFICATION = "arg_basefragment_from_notification";
  private static final String ARG_GO_TO_PLACE = "arg_basefragment_goto";
  private static final String ARG_ICS_PATH = "arg_ics_path";
  private static final String ARG_LAST_PAGE_INDEX = "arg_last_page_index";
  private static final String ARG_LAST_PAGE_TOP = "arg_last_page_top";
  private static final String ARG_MAIL_FROM_ATTACHFOLDER = "arg_basefragment_from_attachfolder";
  private static final String ARG_MAIL_FROM_INQUIRY_MAIL = "arg_basefragment_from_inquiry_mail";
  private static final String ARG_MAIL_FROM_PUSH = "arg_basefragment_from_push";
  private static final String ARG_MAIL_FROM_SCHEME = "arg_basefragment_from_scheme";
  private static final String ARG_MAIL_ID = "arg_basefragment_mail_id";
  private static final String ARG_MAIL_REMOTE_ID = "arg_basefragment_mail_remote_id";
  private static final String ARG_MAIL_SENDER_EMAIL = "arg_basefragment_sender_email";
  private static final String ARG_MAIL_SENDER_NICKNAME = "arg_basefragment_sender_nickname";
  private static final String ARG_MAIL_SUBJECT = "arg_basefragment_subject";
  private static final String ARG_READMAIL_BY_ID = "arg_readmail_by_id";
  private static final String ARG_TOPBAR_TITLE = "arg_basefragment_topbar_title";
  private static final int PLACE_ACCOUNT_LIST = 1;
  private static final int PLACE_APP_FOLDER_LIST = 8;
  private static final int PLACE_FOLDER_LIST = 2;
  private static final int PLACE_MAIL_LIST = 3;
  private static final int PLACE_READMAIL = 5;
  private static final int PLACE_READ_ICS = 6;
  private static final int PLACE_SEND_MAIL_LIST = 4;
  private static final int PLACE_TELRECORD_LIST = 7;
  private static final int PLACE_WIDGET_TO_AD = 11;
  private static final int PLACE_WIDGET_TO_CONV = 9;
  private static final int PLACE_WIDGET_TO_SUB = 10;
  private int animationType;
  private int lastPageIndex = -1;
  private int lastPageTop = -1;
  private boolean showMailDeletedDialogOnce = true;
  
  public static Intent createIntentAdvertise(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("ACCOUNTID", paramInt);
    localIntent.putExtra("AGGRTYPE", paramLong);
    localIntent.putExtra("arg_basefragment_goto", 11);
    return localIntent;
  }
  
  public static Intent createIntentFromShortcut()
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 8);
    return localIntent;
  }
  
  public static Intent createIntentSubscribe(int paramInt, long paramLong)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("ACCOUNTID", paramInt);
    localIntent.putExtra("AGGRTYPE", paramLong);
    localIntent.putExtra("arg_basefragment_goto", 10);
    return localIntent;
  }
  
  public static Intent createIntentToAccountList()
  {
    return createIntentToAccountList(null);
  }
  
  public static Intent createIntentToAccountList(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 1);
    if (paramString != null) {
      localIntent.putExtra("arg_from", paramString);
    }
    return localIntent;
  }
  
  public static Intent createIntentToConv(Bundle paramBundle)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 9);
    localIntent.putExtras(paramBundle);
    return localIntent;
  }
  
  public static Intent createIntentToFolderList(int paramInt)
  {
    return createIntentToFolderList(paramInt, null);
  }
  
  public static Intent createIntentToFolderList(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 2);
    localIntent.putExtra("arg_basefragment_account_id", paramInt);
    if (paramString != null) {
      localIntent.putExtra("arg_from", paramString);
    }
    return localIntent;
  }
  
  public static Intent createIntentToMailList(int paramInt1, int paramInt2, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 3);
    localIntent.putExtra("arg_basefragment_account_id", paramInt1);
    localIntent.putExtra("arg_baseFragment_folder_id", paramInt2);
    localIntent.putExtra("arg_basefragment_topbar_title", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToReadIcsEvent(String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 6);
    localIntent.putExtra("arg_ics_path", paramString);
    return localIntent;
  }
  
  public static Intent createIntentToReadmail(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 5);
    localIntent.putExtra("arg_basefragment_account_id", paramInt1);
    localIntent.putExtra("arg_baseFragment_folder_id", paramInt2);
    localIntent.putExtra("arg_basefragment_mail_id", paramLong);
    localIntent.putExtra("arg_basefragment_from_push", false);
    localIntent.putExtra("arg_basefragment_from_attachfolder", paramBoolean);
    localIntent.putExtra("arg_basefragment_subject", paramString1);
    localIntent.putExtra("arg_basefragment_sender_nickname", paramString2);
    localIntent.putExtra("arg_basefragment_sender_email", paramString3);
    return localIntent;
  }
  
  public static Intent createIntentToReadmailById(int paramInt, String paramString)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 5);
    localIntent.putExtra("arg_readmail_by_id", true);
    localIntent.putExtra("arg_basefragment_mail_remote_id", paramString);
    localIntent.putExtra("arg_basefragment_account_id", paramInt);
    return localIntent;
  }
  
  public static Intent createIntentToReadmailFromPush(int paramInt1, int paramInt2, long paramLong, String paramString1, String paramString2, String paramString3, String paramString4, boolean paramBoolean1, boolean paramBoolean2, boolean paramBoolean3)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 5);
    localIntent.putExtra("arg_basefragment_account_id", paramInt1);
    localIntent.putExtra("arg_baseFragment_folder_id", paramInt2);
    localIntent.putExtra("arg_basefragment_mail_id", paramLong);
    localIntent.putExtra("arg_basefragment_mail_remote_id", paramString1);
    localIntent.putExtra("arg_basefragment_from_push", paramBoolean1);
    localIntent.putExtra("arg_basefragment_from_scheme", paramBoolean2);
    localIntent.putExtra("arg_basefragment_from_attachfolder", paramBoolean3);
    localIntent.putExtra("arg_basefragment_subject", paramString2);
    localIntent.putExtra("arg_basefragment_sender_nickname", paramString3);
    localIntent.putExtra("arg_basefragment_sender_email", paramString4);
    return localIntent;
  }
  
  public static Intent createIntentToSendMailList(boolean paramBoolean)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 4);
    localIntent.putExtra("arg_basefragment_from_notification", paramBoolean);
    return localIntent;
  }
  
  public static Intent createIntentToTelRecordList(int paramInt)
  {
    Intent localIntent = new Intent(QMApplicationContext.sharedInstance(), MailFragmentActivity.class);
    localIntent.putExtra("arg_basefragment_goto", 7);
    localIntent.putExtra("arg_basefragment_account_id", paramInt);
    return localIntent;
  }
  
  private void initializeFragment()
  {
    Object localObject1 = getIntent();
    this.lastPageTop = ((Intent)localObject1).getIntExtra("arg_last_page_top", -1);
    this.lastPageIndex = ((Intent)localObject1).getIntExtra("arg_last_page_index", -1);
    int j = ((Intent)localObject1).getIntExtra("arg_basefragment_goto", 0);
    int m = ((Intent)localObject1).getIntExtra("arg_basefragment_account_id", 0);
    int k = ((Intent)localObject1).getIntExtra("arg_baseFragment_folder_id", 0);
    long l = ((Intent)localObject1).getLongExtra("arg_basefragment_mail_id", 0L);
    Object localObject4;
    String str1;
    label106:
    Object localObject5;
    label125:
    int i;
    Object localObject6;
    boolean bool;
    if (((Intent)localObject1).hasExtra("arg_basefragment_sender_nickname"))
    {
      localObject4 = ((Intent)localObject1).getStringExtra("arg_basefragment_sender_nickname");
      if (!((Intent)localObject1).hasExtra("arg_basefragment_sender_email")) {
        break label325;
      }
      str1 = ((Intent)localObject1).getStringExtra("arg_basefragment_sender_email");
      if (!((Intent)localObject1).hasExtra("arg_basefragment_subject")) {
        break label332;
      }
      localObject5 = ((Intent)localObject1).getStringExtra("arg_basefragment_subject");
      i = 0;
      localObject6 = getIntent().getData();
      if (localObject6 == null) {
        break label1069;
      }
      bool = AccountManager.shareInstance().getAccountList().hasMultiAccounts();
      localObject1 = ((Uri)localObject6).getScheme();
      localObject6 = ((Uri)localObject6).getPath();
      QMLog.log(4, TAG, "scheme = " + (String)localObject1 + "path = " + (String)localObject6);
      if (!"qqmail_3dtouch".equals(localObject1)) {
        break label1064;
      }
      if (!"/open_search".equals(localObject6)) {
        break label344;
      }
      if (!bool) {
        break label339;
      }
      i = 1;
      label230:
      k = 1;
      j = i;
      i = k;
      label236:
      if (!bool) {
        break label361;
      }
      k = -1;
    }
    label1036:
    label1064:
    label1069:
    for (;;)
    {
      label243:
      localObject6 = null;
      localObject1 = localObject6;
      switch (j)
      {
      default: 
        localObject1 = localObject6;
      }
      label325:
      label332:
      label339:
      label344:
      label361:
      label636:
      Object localObject3;
      for (;;)
      {
        if (localObject1 != null) {
          break label1036;
        }
        return;
        localObject4 = "";
        break;
        str1 = "";
        break label106;
        localObject5 = "";
        break label125;
        i = 2;
        break label230;
        if (!"/open_inbox".equals(localObject6)) {
          break label1064;
        }
        j = 3;
        i = 0;
        break label236;
        localObject1 = AccountManager.shareInstance().getAccountList().get(0);
        k = ((QMFolder)QMFolderManager.sharedInstance().getFoldersByAccountAndType(((Account)localObject1).getId(), 1).get(0)).getId();
        break label243;
        if (i != 0)
        {
          localObject1 = new AccountListFragment(true);
        }
        else
        {
          localObject1 = new AccountListFragment();
          continue;
          if (i != 0)
          {
            localObject1 = new FolderListFragment(AccountManager.shareInstance().getAccountList().get(0).getId(), true);
          }
          else
          {
            localObject1 = new FolderListFragment(m);
            continue;
            try
            {
              localObject1 = new MailListFragment(m, k, getIntent().getStringExtra("arg_basefragment_topbar_title"), getIntent().getStringExtra("from"));
            }
            catch (MailListFragment.NullFolderException localNullFolderException)
            {
              return;
            }
            Object localObject2 = new SendMailListFragment();
            continue;
            if (getIntent().getBooleanExtra("arg_readmail_by_id", false))
            {
              str1 = getIntent().getStringExtra("arg_basefragment_mail_remote_id");
              localObject2 = getIntent().getSerializableExtra("arg_cancel_fail_mail");
              if (localObject2 != null)
              {
                localObject4 = (ReuseMail)localObject2;
                localObject2 = ((ReuseMail)localObject4).getInfo();
                i = ((MailInformation)localObject2).getAccountId();
                j = ((MailInformation)localObject2).getFolderId();
                l = ((MailInformation)localObject2).getId();
                localObject5 = ((MailInformation)localObject2).getSubject();
                localObject6 = ((MailInformation)localObject2).getSendContact().getName();
                String str2 = ((MailInformation)localObject2).getSendContact().getAddress();
                if (!StringUtils.isEmpty(((MailInformation)localObject2).getGroupId()))
                {
                  bool = true;
                  localObject2 = new ReadMailFragment(i, j, l, (String)localObject5, (String)localObject6, str2, bool, null, true);
                }
              }
              for (;;)
              {
                localObject5 = new MailUI();
                if (localObject4 != null)
                {
                  ((MailUI)localObject5).setInformation(((ReuseMail)localObject4).getInfo());
                  ((MailUI)localObject5).setContent(((ReuseMail)localObject4).getContent());
                  ((MailUI)localObject5).setVote(((ReuseMail)localObject4).getVote());
                  ((MailUI)localObject5).setStatus(((ReuseMail)localObject4).getStatus());
                  ((MailUI)localObject5).setRead(((ReuseMail)localObject4).isRead());
                }
                ((ReadMailFragment)localObject2).reuseMailData((Mail)localObject5);
                ((ReadMailFragment)localObject2).readMailFromRemoteId(m, str1);
                break;
                bool = false;
                break label636;
                localObject2 = new ReadMailFragment();
                localObject4 = null;
              }
            }
            if ((getIntent().getBooleanExtra("arg_basefragment_from_push", false)) || (getIntent().getBooleanExtra("arg_basefragment_from_scheme", false)) || (getIntent().getBooleanExtra("arg_basefragment_from_attachfolder", false)))
            {
              localObject2 = new ReadMailFragment(m, k, l, getIntent().getStringExtra("arg_basefragment_mail_remote_id"), (String)localObject5, (String)localObject4, str1, getIntent().getBooleanExtra("arg_basefragment_from_push", false), getIntent().getBooleanExtra("arg_basefragment_from_scheme", false), getIntent().getBooleanExtra("arg_basefragment_from_attachfolder", false), getIntent().getBooleanExtra("arg_basefragment_from_inquiry_mail", false));
            }
            else
            {
              localObject2 = new ReadMailFragment(m, k, l, (String)localObject5, (String)localObject4, str1);
              continue;
              localObject2 = new ReadIcsFragment(getIntent().getStringExtra("arg_ics_path"));
              continue;
              localObject2 = new AppFolderListFragment();
              continue;
              localObject2 = new ConvMailListFragment(m, k, l, getIntent().getExtras().getLongArray("ITEMSID"));
              continue;
              localObject2 = new AggregateMailListFragment(m, getIntent().getExtras().getLong("AGGRTYPE"));
              continue;
              localObject2 = getIntent().getExtras();
              try
              {
                localObject2 = new SubscribeListFragment(m, ((Bundle)localObject2).getLong("AGGRTYPE"));
              }
              catch (NullMailException localNullMailException)
              {
                localNullMailException.printStackTrace();
                localObject3 = localObject6;
              }
            }
          }
        }
      }
      getSupportFragmentManager().beginTransaction().add(2131367566, localObject3, localObject3.getClass().getSimpleName()).commit();
      return;
      i = 0;
      break label236;
    }
  }
  
  public static void resetScrollPositonForIntent(Intent paramIntent, int paramInt1, int paramInt2)
  {
    paramIntent.putExtra("arg_last_page_top", paramInt1);
    paramIntent.putExtra("arg_last_page_index", paramInt2);
  }
  
  protected boolean canEnter()
  {
    return true;
  }
  
  public void clearLastPageInfo()
  {
    this.lastPageTop = -1;
    this.lastPageIndex = -1;
  }
  
  public int getContextViewId()
  {
    return 2131367566;
  }
  
  public int getHistorySize()
  {
    return QMActivityManager.shareInstance().getActivitySize();
  }
  
  public int getLastPageIndex()
  {
    return this.lastPageIndex;
  }
  
  public int getLastPageTop()
  {
    return this.lastPageTop;
  }
  
  public void onCreate(Bundle paramBundle)
  {
    super.onCreate(null);
    this.animationType = getIntent().getIntExtra("animationType", 0);
    overridePendingTransition(2130772422, 2130772420);
    initializeFragment();
    StatusBarUtil.immerseWhite(this);
  }
  
  public void onDestroy()
  {
    super.onDestroy();
    QMOssClient.getInstance().submit();
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if ((paramBoolean) && (this.showMailDeletedDialogOnce)) {
      this.showMailDeletedDialogOnce = false;
    }
  }
  
  public void overridePendingTransition(int paramInt1, int paramInt2)
  {
    super.overridePendingTransition(2130772422, 2130772420);
  }
  
  public void popBackStack()
  {
    super.popBackStack();
  }
  
  public void setLastPageIndex(int paramInt)
  {
    this.lastPageIndex = paramInt;
  }
  
  public void setLastPageTop(int paramInt)
  {
    this.lastPageTop = paramInt;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.fragment.base.MailFragmentActivity
 * JD-Core Version:    0.7.0.1
 */