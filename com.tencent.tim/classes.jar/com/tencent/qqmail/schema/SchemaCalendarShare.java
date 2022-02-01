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
import com.tencent.qqmail.activity.setting.SettingCalendarActivity;
import com.tencent.qqmail.calendar.fragment.CalendarFragmentActivity;
import com.tencent.qqmail.calendar.util.QMCalendarUtil;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaCalendarShare
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_CODE = "code";
  private static final String TAG = "SchemaCalendarShare";
  private static final String VALUE_ACCEPT = "accept";
  private String action;
  private String code;
  
  public SchemaCalendarShare(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1;
    if ((!QMSettingManager.sharedInstance().getCalendarDisplay()) || (!QMCalendarUtil.hasCalendarFolder())) {
      if (AccountManager.shareInstance().getAccountList().size() == 0) {
        localObject1 = AccountTypeListActivity.createIntent("extra_from_schema");
      }
    }
    while (localObject1 != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject1).putExtra("animationType", paramInt);
      ((Intent)localObject1).putExtra("from", "from_schema");
      this.context.startActivity((Intent)localObject1);
      return true;
      localObject1 = localObject2;
      if (this.action != null)
      {
        localObject1 = localObject2;
        if (this.action.equals("accept"))
        {
          localObject1 = SettingCalendarActivity.createIntentWithiTips(QMApplicationContext.sharedInstance().getString(2131691099));
          continue;
          localObject1 = localObject2;
          if (this.action != null)
          {
            localObject1 = localObject2;
            if (this.action.equals("accept"))
            {
              localObject1 = AccountManager.shareInstance().getAccountList();
              int i = ((AccountList)localObject1).getPureQQMailAccountNumber();
              if (i == 0) {
                localObject1 = LoginFragmentActivity.createIntentFromSchema("CALENDAR", "", String.valueOf(AccountType.qqmail));
              } else if (i == 1) {
                localObject1 = CalendarFragmentActivity.createIntentToCalendarListToShare(((AccountList)localObject1).getFirstQQMailAccount().getId(), this.code);
              } else {
                localObject1 = CalendarFragmentActivity.createIntentToCalendarChooseAccount(this.code);
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
      try
      {
        if (this.params != null)
        {
          String[] arrayOfString = this.params.split("&");
          int j = arrayOfString.length;
          if (i < j)
          {
            Object localObject = arrayOfString[i].split("=");
            if (localObject.length != 2) {
              break label117;
            }
            String str = Uri.decode(localObject[0]);
            localObject = Uri.decode(localObject[1]);
            if (str.equals("action")) {
              this.action = ((String)localObject);
            } else if (str.equals("code")) {
              this.code = ((String)localObject);
            }
          }
        }
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QMLog.log(6, "SchemaCalendarShare", localException.getMessage());
      }
      return;
      label117:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaCalendarShare
 * JD-Core Version:    0.7.0.1
 */