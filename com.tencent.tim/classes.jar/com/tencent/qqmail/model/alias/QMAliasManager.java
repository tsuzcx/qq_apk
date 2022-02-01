package com.tencent.qqmail.model.alias;

import androidx.annotation.NonNull;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.account.model.QQMailAccount;
import com.tencent.qqmail.model.mail.QMComposeDataManager;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.CGIManager;
import com.tencent.qqmail.utilities.qmnetwork.QMCallback;

public class QMAliasManager
{
  public static String ACTION_SETDEFAULT;
  public static String ACTION_SETDEFAULTNICK;
  public static String ALIAS;
  public static String FMT = "&t=";
  public static String FUN_EDIT;
  public static String INDEP;
  public static String MOBILE_JSON = "mobile_mgr.json";
  public static String NICK_NAME;
  public static String SHOW_SENDER_NICK;
  public static String SID;
  private static final String TAG = "QMAliasManager";
  private static volatile QMAliasManager _instance = new QMAliasManager();
  
  static
  {
    FUN_EDIT = "fun=edit";
    ACTION_SETDEFAULT = "action=setdefaultemail";
    ACTION_SETDEFAULTNICK = "action=setnickname";
    SID = "&sid=";
    ALIAS = "&alias=";
    INDEP = "&signvalid=";
    NICK_NAME = "&nickname=";
    SHOW_SENDER_NICK = "&showdefaultemailfrom=";
  }
  
  private QQMailAccount getQQMailAccount(int paramInt)
  {
    AccountList localAccountList = AccountManager.shareInstance().getAccountList();
    Account localAccount = localAccountList.getAccountById(paramInt);
    if (localAccount != null) {
      return localAccountList.getQQMailAccountByUin(localAccount.getUin());
    }
    return null;
  }
  
  @NonNull
  public static QMAliasManager shareInstance()
  {
    return _instance;
  }
  
  public void syncQMAccountDefaultAlias(int paramInt, String paramString, QMCallback paramQMCallback)
  {
    QQMailAccount localQQMailAccount = getQQMailAccount(paramInt);
    QMComposeDataManager.sharedInstance().setQMDefaultAlias(paramInt, paramString);
    CGIManager.httpPost(paramInt, "setting4", ACTION_SETDEFAULT + SHOW_SENDER_NICK + paramString + SID + localQQMailAccount.getSid() + FMT + MOBILE_JSON, paramQMCallback);
  }
  
  public void syncQMAccountDefaultNick(int paramInt, String paramString, QMCallback paramQMCallback)
  {
    try
    {
      QQMailAccount localQQMailAccount = (QQMailAccount)AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      if (localQQMailAccount != null) {
        CGIManager.httpPost(paramInt, "setting4", ACTION_SETDEFAULTNICK + NICK_NAME + paramString + SID + localQQMailAccount.getSid() + FMT + MOBILE_JSON, paramQMCallback);
      }
      return;
    }
    catch (Exception localException)
    {
      for (;;)
      {
        QMLog.log(3, "QMAliasManager", localException.toString());
        Object localObject = null;
      }
    }
  }
  
  public void syncQMAliasIndep(String paramString, int paramInt, boolean paramBoolean, QMCallback paramQMCallback)
  {
    Object localObject = getQQMailAccount(paramInt);
    localObject = new StringBuilder().append(FUN_EDIT).append(SID).append(((QQMailAccount)localObject).getSid()).append(FMT).append(MOBILE_JSON).append(ALIAS).append(paramString).append(INDEP);
    if (paramBoolean) {}
    for (paramString = "1";; paramString = "0")
    {
      CGIManager.httpPost(paramInt, "setting4_editaccount", paramString, paramQMCallback);
      return;
    }
  }
  
  public void syncQMAliasNick(String paramString1, int paramInt, String paramString2, QMCallback paramQMCallback)
  {
    Object localObject = getQQMailAccount(paramInt);
    if (localObject != null)
    {
      localObject = new StringBuilder().append(FUN_EDIT).append(SID).append(((QQMailAccount)localObject).getSid()).append(FMT).append(MOBILE_JSON).append(ALIAS).append(paramString1).append(INDEP);
      if (!QMComposeDataManager.sharedInstance().getQMAliasIndep(paramString1, paramInt)) {
        break label112;
      }
    }
    label112:
    for (paramString1 = "1";; paramString1 = "0")
    {
      CGIManager.httpPost(paramInt, "setting4_editaccount", paramString1 + NICK_NAME + paramString2, paramQMCallback);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.alias.QMAliasManager
 * JD-Core Version:    0.7.0.1
 */