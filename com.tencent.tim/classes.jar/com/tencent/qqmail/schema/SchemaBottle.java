package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.bottle.fragment.BottleFragmentActivity;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaBottle
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String TAG = "SchemaBottle";
  private static final String VALUE_LIST = "list";
  public String action = "";
  
  public SchemaBottle(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (AccountManager.shareInstance().getAccountList().getDefaultBottleAccount() != null)
    {
      QMSettingManager.sharedInstance().setBottleDisplay(true);
      localObject1 = localObject2;
      if (this.action != null)
      {
        localObject1 = localObject2;
        if (QMSettingManager.sharedInstance().isBottleEnabled())
        {
          localObject1 = localObject2;
          if (this.action.equals("list")) {
            localObject1 = BottleFragmentActivity.createIntent();
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
      localObject1 = AccountManager.shareInstance().getAccountList().getFirstQQMailAccount();
      if (localObject1 != null)
      {
        QMSettingManager.sharedInstance().setDefaultBottleAccountID(((QQMailAccount)localObject1).getId());
        QMSettingManager.sharedInstance().setBottleDisplay(true);
        localObject1 = localObject2;
        if (this.action != null)
        {
          localObject1 = localObject2;
          if (QMSettingManager.sharedInstance().isBottleEnabled())
          {
            localObject1 = localObject2;
            if (this.action.equals("list")) {
              localObject1 = BottleFragmentActivity.createIntent();
            }
          }
        }
      }
      else
      {
        localObject1 = LoginFragmentActivity.createIntentFromSchema("BOTTLE", "", String.valueOf(AccountType.qqmail));
      }
    }
    return false;
  }
  
  public void parseParams()
  {
    int i = 0;
    try
    {
      if (this.params != null)
      {
        String[] arrayOfString = this.params.split("&");
        int j = arrayOfString.length;
        while (i < j)
        {
          Object localObject = arrayOfString[i].split("=");
          if (localObject.length == 2)
          {
            String str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            }
          }
          i += 1;
        }
      }
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
      QMLog.log(6, "SchemaBottle", localException.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaBottle
 * JD-Core Version:    0.7.0.1
 */