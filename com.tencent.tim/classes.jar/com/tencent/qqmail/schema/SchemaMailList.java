package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;

public class SchemaMailList
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_FOLDER = "folder";
  private static final String PARAM_UIN = "uin";
  private static final String TAG = "SchemaMailList";
  private static final String VALUE_INBOX = "inbox";
  private static final String VALUE_LIST = "list";
  private static final String VALUE_UNREAD = "unread";
  private String action;
  private String folder;
  private String uin;
  
  public SchemaMailList(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject3 = null;
    Object localObject2 = null;
    Object localObject1 = localObject2;
    ArrayList localArrayList;
    if (this.action != null)
    {
      localObject1 = localObject2;
      if (this.action.equals("list"))
      {
        if (this.uin == null) {
          break label230;
        }
        localObject3 = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
        if (localObject3 == null) {
          break label211;
        }
        localObject1 = localObject2;
        if (this.folder != null)
        {
          if (!this.folder.equals("inbox")) {
            break label174;
          }
          localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountAndType(((QQMailAccount)localObject3).getId(), 1);
          localObject1 = localObject2;
          if (localArrayList != null)
          {
            localObject1 = localObject2;
            if (localArrayList.size() > 0) {
              localObject1 = MailFragmentActivity.createIntentToMailList(((QQMailAccount)localObject3).getId(), ((QMFolder)localArrayList.get(0)).getId(), ((QMFolder)localArrayList.get(0)).getName());
            }
          }
        }
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
      label174:
      localObject1 = localObject2;
      if (this.folder.equals("unread"))
      {
        localObject1 = MailFragmentActivity.createIntentToMailList(((QQMailAccount)localObject3).getId(), -9, QMApplicationContext.sharedInstance().getString(2131693929));
        continue;
        label211:
        localObject1 = LoginFragmentActivity.createIntentFromSchema("FOLDERLIST", this.uin, String.valueOf(AccountType.qqmail));
        continue;
        label230:
        int i = AccountManager.shareInstance().getAccountList().size();
        localObject2 = localObject3;
        if (i == 0) {
          localObject2 = AccountTypeListActivity.createIntent("extra_from_schema");
        }
        if (i == 1)
        {
          localObject3 = AccountManager.shareInstance().getAccountList().get(0);
          localObject1 = localObject2;
          if (this.folder != null) {
            if (this.folder.equals("inbox"))
            {
              localArrayList = QMFolderManager.sharedInstance().getFoldersByAccountAndType(((Account)localObject3).getId(), 1);
              localObject1 = localObject2;
              if (localArrayList != null)
              {
                localObject1 = localObject2;
                if (localArrayList.size() > 0) {
                  localObject1 = MailFragmentActivity.createIntentToMailList(((Account)localObject3).getId(), ((QMFolder)localArrayList.get(0)).getId(), ((QMFolder)localArrayList.get(0)).getName());
                }
              }
            }
            else
            {
              localObject1 = localObject2;
              if (this.folder.equals("unread")) {
                localObject1 = MailFragmentActivity.createIntentToMailList(((Account)localObject3).getId(), -9, QMApplicationContext.sharedInstance().getString(2131693929));
              }
            }
          }
        }
        else
        {
          localObject1 = localObject2;
          if (this.folder != null) {
            if (this.folder.equals("inbox"))
            {
              localObject1 = MailFragmentActivity.createIntentToMailList(0, -1, QMApplicationContext.sharedInstance().getString(2131693934));
            }
            else
            {
              localObject1 = localObject2;
              if (this.folder.equals("unread"))
              {
                localObject1 = MailFragmentActivity.createIntentToMailList(0, -9, QMApplicationContext.sharedInstance().getString(2131693939));
                ((Intent)localObject1).putExtra("from", "from_schema");
              }
            }
          }
        }
      }
    }
    return false;
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
              break label133;
            }
            str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("folder")) {
              this.folder = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaMailList", localException.getMessage());
      }
      return;
      if (str.equals("uin")) {
        this.uin = ((String)localObject);
      }
      label133:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaMailList
 * JD-Core Version:    0.7.0.1
 */