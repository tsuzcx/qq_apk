package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaFolderList
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_UIN = "uin";
  private static final String TAG = "SchemaFolderList";
  private static final String VALUE_LIST = "list";
  private String action;
  private String uin;
  
  public SchemaFolderList(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    if (this.action != null)
    {
      localObject1 = localObject2;
      if (this.action.equals("list"))
      {
        if (this.uin == null) {
          break label105;
        }
        localObject1 = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
        if (localObject1 == null) {
          break label86;
        }
        localObject1 = MailFragmentActivity.createIntentToFolderList(((QQMailAccount)localObject1).getId());
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
      label86:
      localObject1 = LoginFragmentActivity.createIntentFromSchema("FOLDERLIST", this.uin, String.valueOf(AccountType.qqmail));
      continue;
      label105:
      localObject1 = AccountManager.shareInstance().getAccountList();
      if (((AccountList)localObject1).getQQMailAccountNumber() > 0) {
        localObject1 = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject1).getFirstQQMailAccount().getId());
      } else {
        localObject1 = AccountTypeListActivity.createIntent("extra_from_schema");
      }
    }
    return false;
  }
  
  public void parseParams()
  {
    int i = 0;
    for (;;)
    {
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            Object localObject = arrayOfString[i].split("=");
            if ((localObject == null) || (localObject.length != 2)) {
              break label122;
            }
            String str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("uin")) {
              this.uin = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaFolderList", localException.getMessage());
      }
      return;
      label122:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaFolderList
 * JD-Core Version:    0.7.0.1
 */