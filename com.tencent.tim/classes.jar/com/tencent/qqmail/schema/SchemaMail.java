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
import com.tencent.qqmail.fragment.base.MailFragmentActivity;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.utilities.log.QMLog;

public class SchemaMail
  extends SchemaBase
{
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_ADDRESS = "address";
  private static final String PARAM_MAIL_ID = "mailid";
  private static final String PARAM_SENDER_NICK = "sendernick";
  private static final String PARAM_SUBJECT = "subject";
  private static final String PARAM_UIN = "uin";
  private static final String TAG = "SchemaMail";
  private static final String VALUE_READ = "read";
  private String action;
  private String address;
  private String mailid;
  private String sendernick;
  private String subject;
  private String uin;
  
  public SchemaMail(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  public boolean doAction(int paramInt)
  {
    Object localObject2 = null;
    Object localObject1 = localObject2;
    QQMailAccount localQQMailAccount;
    if (this.uin != null)
    {
      localQQMailAccount = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
      if (localQQMailAccount == null) {
        break label242;
      }
      localObject1 = localObject2;
      if (this.action != null)
      {
        localObject1 = localObject2;
        if (this.action.equals("read"))
        {
          localObject1 = localObject2;
          if (this.mailid != null)
          {
            localObject1 = QMMailManager.sharedInstance().getMailInfoByRemoteId(localQQMailAccount.getId(), this.mailid);
            if (localObject1 == null) {
              break label208;
            }
            localObject1 = ((Mail)localObject1).getInformation();
            long l = ((MailInformation)localObject1).getId();
            int i = ((MailInformation)localObject1).getFolderId();
            this.subject = ((MailInformation)localObject1).getSubject();
            this.address = ((MailInformation)localObject1).getFrom().getAddress();
            this.sendernick = ((MailInformation)localObject1).getFrom().getNick();
            localObject1 = MailFragmentActivity.createIntentToReadmailFromPush(localQQMailAccount.getId(), i, l, this.mailid, this.subject, this.sendernick, this.address, false, true, false);
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
      label208:
      localObject1 = MailFragmentActivity.createIntentToReadmailFromPush(localQQMailAccount.getId(), 0, 0L, this.mailid, this.subject, this.sendernick, this.address, false, true, false);
      continue;
      label242:
      localObject1 = LoginFragmentActivity.createIntentFromSchema("READMAIL", this.uin, String.valueOf(AccountType.qqmail));
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
              break label190;
            }
            str = Uri.decode(localObject[0]);
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
        QMLog.log(6, "SchemaMail", localException.getMessage());
      }
      return;
      if (str.equals("mailid")) {
        this.mailid = ((String)localObject);
      } else if (str.equals("subject")) {
        this.subject = ((String)localObject);
      } else if (str.equals("address")) {
        this.address = ((String)localObject);
      } else if (str.equals("sendernick")) {
        this.sendernick = ((String)localObject);
      }
      label190:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaMail
 * JD-Core Version:    0.7.0.1
 */