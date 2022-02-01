package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.fragment.base.MailFragmentActivity;

public class SchemaHome
  extends SchemaBase
{
  public SchemaHome(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject = AccountManager.shareInstance().getAccountList();
    if (((AccountList)localObject).size() == 0) {
      localObject = AccountTypeListActivity.createIntent("extra_from_schema");
    }
    while (localObject != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject);
      return true;
      if (((AccountList)localObject).size() == 1) {
        localObject = MailFragmentActivity.createIntentToFolderList(((AccountList)localObject).get(0).getId());
      } else {
        localObject = MailFragmentActivity.createIntentToAccountList();
      }
    }
    return false;
  }
  
  public void parseParams() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaHome
 * JD-Core Version:    0.7.0.1
 */