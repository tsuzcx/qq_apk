package com.tencent.qqmail.schema;

import android.content.Context;
import android.content.Intent;
import android.util.Base64;
import com.tencent.qqmail.QMActivityManager;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.account.activity.LoginFragmentActivity;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.AccountType;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.activity.compose.ComposeMailActivity;
import com.tencent.qqmail.model.MailManagerDelegate;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.qmdomain.AttachInfo;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.MailContact;
import com.tencent.qqmail.model.qmdomain.MailContent;
import com.tencent.qqmail.model.qmdomain.MailInformation;
import com.tencent.qqmail.model.qmdomain.MailStatus;
import com.tencent.qqmail.model.uidomain.ComposeMailUI.QMComposeMailType;
import com.tencent.qqmail.model.uidomain.MailUI;
import com.tencent.qqmail.protocol.DataCollector;
import com.tencent.qqmail.utilities.fileextention.FileUtil;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.stringextention.StringExtention;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SchemaCompose
  extends SchemaBase
{
  public static final String OTHERAPP_FOCUS_CONTENT = "content";
  public static final String OTHERAPP_FOCUS_MAILTO = "mailto";
  public static final String OTHERAPP_FOCUS_SUBJECT = "subject";
  private static final String PARAM_ACTION = "action";
  private static final String PARAM_APP_NAME = "appname";
  private static final String PARAM_ATTACH_NAME = "attachname";
  private static final String PARAM_ATTACH_PATH = "attachpath";
  private static final String PARAM_CALLBACK = "callback";
  private static final String PARAM_FOCUS = "focus";
  private static final String PARAM_MAIL_BCC = "mailbcc";
  private static final String PARAM_MAIL_CC = "mailcc";
  private static final String PARAM_MAIL_CONTENT = "mailcontent";
  private static final String PARAM_MAIL_ID = "mailid";
  private static final String PARAM_MAIL_TO = "mailto";
  private static final String PARAM_PKG = "pkg";
  private static final String PARAM_SENDER = "sender";
  private static final String PARAM_SUBJECT = "subject";
  private static final String PARAM_UIN = "uin";
  public static final String RTX_PACKAGE = "com.tencent.wework";
  private static final String TAG = "SchemaCompose";
  private static final String VALUE_FORWARD = "forward";
  private static final String VALUE_REPLY = "reply";
  private static final String VALUE_REPLY_ALL = "replyall";
  private static final String VALUE_SEND = "send";
  private String action = "";
  private String appName = "";
  private List<String> attachname = new ArrayList();
  private List<String> attachpath = new ArrayList();
  private String callback = "";
  private String focus = "";
  private String mailcontent = "";
  private String mailid = "";
  private List<String> maillbcc = new ArrayList();
  private List<String> maillcc = new ArrayList();
  private List<String> mailto = new ArrayList();
  private String pkg = "";
  private String sender = "";
  private String subject = "";
  private String uin = "";
  
  public SchemaCompose(Context paramContext, String paramString)
  {
    super(paramContext, paramString);
  }
  
  private ArrayList convertToAttachList(List<String> paramList1, List<String> paramList2)
  {
    if ((paramList1 == null) || (paramList2 == null)) {
      return null;
    }
    ArrayList localArrayList = new ArrayList();
    if ((paramList1.size() > 0) && (paramList2.size() > 0))
    {
      int i = 0;
      while (i < Math.min(paramList1.size(), paramList2.size()))
      {
        AttachInfo localAttachInfo = new AttachInfo();
        localAttachInfo.setAttachName((String)paramList1.get(i));
        localAttachInfo.setAttachPath((String)paramList2.get(i));
        localAttachInfo.setAbsAttachPath((String)paramList2.get(i));
        localAttachInfo.estimateAndSetSizeByRealSize(FileUtil.getFileSize(localAttachInfo.getAttachPath()));
        localArrayList.add(localAttachInfo);
        i += 1;
      }
    }
    return localArrayList;
  }
  
  private ArrayList convertToContactList(List<String> paramList)
  {
    ArrayList localArrayList = new ArrayList();
    if ((paramList != null) && (!paramList.isEmpty()))
    {
      Iterator localIterator = paramList.iterator();
      if (localIterator.hasNext())
      {
        paramList = (String)localIterator.next();
        String[] arrayOfString = paramList.split("&");
        if ((arrayOfString != null) && (arrayOfString.length >= 2)) {}
        for (paramList = new MailContact(paramList.split("&")[0], paramList.split("&")[1]);; paramList = new MailContact(paramList, paramList))
        {
          localArrayList.add(paramList);
          break;
        }
      }
    }
    return localArrayList;
  }
  
  private Intent createLoginIntent()
  {
    return LoginFragmentActivity.createIntentFromSchema("COMPOSE", this.uin, String.valueOf(AccountType.qqmail));
  }
  
  private String decodeBase64FromUrl(String paramString)
  {
    if (paramString == null) {
      return null;
    }
    QMLog.log(4, "SchemaCompose", "original content:" + paramString);
    paramString = new String(Base64.decode(paramString.replace("-xx", "-x").replace("-x-", "*").replace("*", "+").replace("-", "/"), 1));
    QMLog.log(4, "SchemaCompose", "decode content:" + paramString);
    return paramString;
  }
  
  private void loadRemoteMail(Mail paramMail, int paramInt1, String paramString, MailManagerDelegate paramMailManagerDelegate, int paramInt2)
  {
    paramMail.setInformation(new MailInformation());
    paramMail.setContent(new MailContent());
    paramMail.setStatus(new MailStatus());
    paramMail.getInformation().setRemoteId(paramString);
    paramMail.getInformation().setAccountId(paramInt1);
    paramMail.getInformation().setId(Mail.generateId(paramInt1, paramString));
    QMMailManager.sharedInstance().loadRemoteMail(paramMail, 0, paramMailManagerDelegate);
  }
  
  public boolean doAction(int paramInt)
  {
    QQMailAccount localQQMailAccount = null;
    Mail localMail = null;
    Object localObject = localMail;
    if (this.action != null)
    {
      if (AccountManager.shareInstance().getAccountList().size() != 0) {
        break label63;
      }
      localObject = AccountTypeListActivity.createIntent("extra_from_schema");
    }
    while (localObject != null)
    {
      QMActivityManager.shareInstance().finishAllActivity();
      ((Intent)localObject).putExtra("animationType", paramInt);
      this.context.startActivity((Intent)localObject);
      return true;
      label63:
      if (this.action.equals("send"))
      {
        if ((this.pkg != null) && (this.pkg.equals("com.tencent.wework"))) {
          DataCollector.logEvent("Event_RTX_Scheme_Compose");
        }
        localMail = new Mail();
        localObject = new MailInformation();
        ((MailInformation)localObject).setToList(convertToContactList(this.mailto));
        ((MailInformation)localObject).setCcList(convertToContactList(this.maillcc));
        ((MailInformation)localObject).setBccList(convertToContactList(this.maillbcc));
        ((MailInformation)localObject).setSubject(this.subject);
        localMail.setInformation((MailInformation)localObject);
        localObject = new MailContent();
        ((MailContent)localObject).setBody(this.mailcontent);
        localMail.setContent((MailContent)localObject);
        localMail.setStatus(new MailStatus());
        ArrayList localArrayList = convertToAttachList(this.attachname, this.attachpath);
        if (StringExtention.isNullOrEmpty(this.uin))
        {
          localObject = localQQMailAccount;
          if (!StringExtention.isNullOrEmpty(this.sender)) {
            localObject = AccountManager.shareInstance().getAccountList().getAccountByEmail(this.sender);
          }
          if (localObject != null) {
            localObject = ComposeMailActivity.createIntent(((Account)localObject).getId(), localMail, localArrayList, this.appName, this.callback, this.focus);
          } else {
            localObject = ComposeMailActivity.createIntent(0, localMail, localArrayList, this.appName, this.callback, this.focus);
          }
        }
        else
        {
          localObject = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
          if (localObject == null) {
            localObject = createLoginIntent();
          } else {
            localObject = ComposeMailActivity.createIntent(((QQMailAccount)localObject).getId(), localMail, localArrayList, this.appName, this.callback, this.focus);
          }
        }
      }
      else if (this.action.equals("forward"))
      {
        localObject = localMail;
        if (this.uin != null)
        {
          localQQMailAccount = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
          if (localQQMailAccount != null)
          {
            localObject = localMail;
            if (this.mailid != null)
            {
              localObject = QMMailManager.sharedInstance().getMailInfoByRemoteId(localQQMailAccount.getId(), this.mailid);
              if (localObject != null)
              {
                localObject = new MailUI((Mail)localObject);
                localObject = ComposeMailActivity.createIntentForSchema(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_FORWARD, 1, (Mail)localObject);
              }
              else
              {
                localObject = new MailManagerDelegate();
                localMail = new Mail();
                ((MailManagerDelegate)localObject).setOnComplete(new SchemaCompose.1(this, localMail, paramInt));
                loadRemoteMail(localMail, localQQMailAccount.getId(), this.mailid, (MailManagerDelegate)localObject, paramInt);
                return true;
              }
            }
          }
          else
          {
            localObject = createLoginIntent();
          }
        }
      }
      else if (this.action.equals("reply"))
      {
        localObject = localMail;
        if (this.uin != null)
        {
          localQQMailAccount = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
          if (localQQMailAccount != null)
          {
            localObject = localMail;
            if (this.mailid != null)
            {
              localObject = QMMailManager.sharedInstance().getMailInfoByRemoteId(localQQMailAccount.getId(), this.mailid);
              if (localObject != null)
              {
                localObject = new MailUI((Mail)localObject);
                localObject = ComposeMailActivity.createIntentForSchema(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLY, 0, (Mail)localObject);
              }
              else
              {
                localObject = new MailManagerDelegate();
                localMail = new Mail();
                ((MailManagerDelegate)localObject).setOnComplete(new SchemaCompose.2(this, localMail, paramInt));
                loadRemoteMail(localMail, localQQMailAccount.getId(), this.mailid, (MailManagerDelegate)localObject, paramInt);
                return true;
              }
            }
          }
          else
          {
            localObject = createLoginIntent();
          }
        }
      }
      else
      {
        localObject = localMail;
        if (this.action.equals("replyall"))
        {
          localObject = localMail;
          if (this.uin != null)
          {
            localQQMailAccount = AccountManager.shareInstance().getAccountList().getQQMailAccountByUin(this.uin);
            if (localQQMailAccount != null)
            {
              localObject = localMail;
              if (this.mailid != null)
              {
                localObject = QMMailManager.sharedInstance().getMailInfoByRemoteId(localQQMailAccount.getId(), this.mailid);
                if (localObject != null)
                {
                  localObject = new MailUI((Mail)localObject);
                  localObject = ComposeMailActivity.createIntentForSchema(ComposeMailUI.QMComposeMailType.COMPOSE_TYPE_REPLYALL, 0, (Mail)localObject);
                }
                else
                {
                  localObject = new MailManagerDelegate();
                  localMail = new Mail();
                  ((MailManagerDelegate)localObject).setOnComplete(new SchemaCompose.3(this, localMail, paramInt));
                  loadRemoteMail(localMail, localQQMailAccount.getId(), this.mailid, (MailManagerDelegate)localObject, paramInt);
                  return true;
                }
              }
            }
            else
            {
              localObject = createLoginIntent();
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
              break label402;
            }
            str = URLDecoder.decode(localObject[0], "UTF-8");
            localObject = URLDecoder.decode(localObject[1], "UTF-8");
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
        QMLog.log(6, "SchemaCompose", localException.getMessage());
      }
      return;
      if (str.equals("mailid")) {
        this.mailid = ((String)localObject);
      } else if (str.equals("mailto")) {
        this.mailto.add(localObject);
      } else if (str.equals("mailcc")) {
        this.maillcc.add(localObject);
      } else if (str.equals("mailbcc")) {
        this.maillbcc.add(localObject);
      } else if (str.equals("subject")) {
        this.subject = ((String)localObject);
      } else if (str.equals("mailcontent")) {
        this.mailcontent = decodeBase64FromUrl((String)localObject);
      } else if (str.equals("sender")) {
        this.sender = ((String)localObject);
      } else if (str.equals("attachname")) {
        this.attachname.add(localObject);
      } else if (str.equals("attachpath")) {
        this.attachpath.add(localObject);
      } else if (str.equals("appname")) {
        this.appName = ((String)localObject);
      } else if (str.equals("callback")) {
        this.callback = ((String)localObject);
      } else if (str.equals("focus")) {
        this.focus = ((String)localObject);
      } else if (str.equals("pkg")) {
        this.pkg = ((String)localObject);
      }
      label402:
      i += 1;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.schema.SchemaCompose
 * JD-Core Version:    0.7.0.1
 */