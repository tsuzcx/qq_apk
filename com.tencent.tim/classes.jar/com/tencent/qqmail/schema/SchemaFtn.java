package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.ftn.activity.FtnListActivity;
import com.tencent.qqmail.launcher.third.LaunchSaveToMyFtn;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaFtn
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_K = "k";
  private static final String TAG = "SchemaFtn";
  private static final String VALUE_ADD = "add";
  private static final String VALUE_LIST = "list";
  private String action;
  private String k;
  
  public SchemaFtn(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if (AccountManager.shareInstance().getAccountList().getDefaultFtnAccount() != null)
    {
      QMSettingManager.sharedInstance().setFtnDisplay(true);
      localObject1 = localObject2;
      if (this.action != null)
      {
        if (!this.action.equals("list")) {
          break label83;
        }
        localObject1 = FtnListActivity.createIntent();
        ((Intent)localObject1).putExtra("from", "from_schema");
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
      label83:
      localObject1 = localObject2;
      if (this.action.equals("add"))
      {
        localObject1 = localObject2;
        if (this.k != null)
        {
          String[] arrayOfString = this.k.split(",");
          localObject1 = localObject2;
          if (arrayOfString != null)
          {
            localObject1 = localObject2;
            if (arrayOfString.length == 2)
            {
              LaunchSaveToMyFtn.launchSaveToMyFtn(arrayOfString[0], arrayOfString[1], this.context);
              return true;
              localObject1 = LoginFragmentActivity.createIntentFromSchema("FTN", "", String.valueOf(AccountType.qqmail));
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
            } else if (str.equals("k")) {
              this.k = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaFtn", localException.getMessage());
      }
      return;
      label122:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaFtn
 * JD-Core Version:    0.7.0.1
 */