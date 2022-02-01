package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaAccount
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_UIN = "uin";
  private static final String TAG = "SchemaAccount";
  private static final String VALUE_ADD = "add";
  private static final String VALUE_LOGIN = "login";
  private String action;
  private String uin;
  
  public SchemaAccount(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject1 = null;
    Object localObject2 = null;
    if (this.action != null)
    {
      localObject1 = localObject2;
      if (this.action.equals("login")) {
        localObject1 = LoginFragmentActivity.createIntentFromSchema("ACCOUNT", this.uin, String.valueOf(AccountType.qqmail));
      }
      if (this.action.equals("add")) {
        localObject1 = AccountTypeListActivity.createIntent("extra_from_schema");
      }
    }
    if (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject1);
      return true;
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
          if ((arrayOfString != null) && (i < arrayOfString.length))
          {
            Object localObject = arrayOfString[i].split("=");
            if ((localObject == null) || (localObject.length != 2)) {
              break label121;
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
        QMLog.log(6, "SchemaAccount", localException.getMessage());
      }
      return;
      label121:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaAccount
 * JD-Core Version:    0.7.0.1
 */