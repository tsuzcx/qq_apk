package com.tencent.qqmail.model.mail.rule;

import android.annotation.SuppressLint;
import android.util.SparseArray;
import androidx.annotation.NonNull;
import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.folderlist.QMFolderManager;
import com.tencent.qqmail.model.mail.QMMailCGIManager;
import com.tencent.qqmail.model.mail.QMMailProtocolManager;
import com.tencent.qqmail.model.mail.QMMailSQLite;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.protocol.QMPrivateProtocolManager;
import com.tencent.qqmail.model.qmdomain.Mail;
import com.tencent.qqmail.model.qmdomain.QMFolder;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule.Actions;
import com.tencent.qqmail.protocol.Exchange.ExchangeRule.Conditions;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class QMRuleManager
{
  public static final String TAG = "QMRuleManager";
  private static volatile QMRuleManager instance;
  private QMMailCGIManager cgiManager;
  public RuleDelegate delegate;
  private boolean isRuleDirty;
  private QMMailProtocolManager protocolManager;
  private HashMap<Integer, MailRuleInfo> ruleMap = null;
  private SparseArray<MailRuleInfo> rules = null;
  private QMMailSQLiteHelper sqliteHelper;
  
  private QMRuleManager(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiManager = paramQMMailCGIManager;
    this.protocolManager = paramQMMailProtocolManager;
    this.delegate = new RuleDelegate(paramQMMailSQLiteHelper);
    this.isRuleDirty = true;
  }
  
  private void addRule(MailRuleInfo paramMailRuleInfo, ApplyRuleCallback paramApplyRuleCallback)
  {
    this.delegate.create(paramMailRuleInfo);
    setDirty();
    if (paramApplyRuleCallback != null) {
      apply(paramMailRuleInfo, paramApplyRuleCallback);
    }
  }
  
  private void apply(MailRuleInfo paramMailRuleInfo, ApplyRuleCallback paramApplyRuleCallback)
  {
    this.delegate.run(paramMailRuleInfo, paramApplyRuleCallback);
  }
  
  private String[] combineAddrs(String[] paramArrayOfString)
  {
    ArrayList localArrayList = new ArrayList();
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      if (!localArrayList.contains(paramArrayOfString[i])) {
        localArrayList.add(paramArrayOfString[i]);
      }
      i += 1;
    }
    return (String[])localArrayList.toArray(new String[0]);
  }
  
  public static QMRuleManager createInstance(QMMailSQLiteHelper paramQMMailSQLiteHelper, QMMailCGIManager paramQMMailCGIManager, QMMailProtocolManager paramQMMailProtocolManager)
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QMRuleManager(paramQMMailSQLiteHelper, paramQMMailCGIManager, paramQMMailProtocolManager);
      }
      return instance;
    }
    finally {}
  }
  
  private void delRules(int[] paramArrayOfInt)
  {
    this.sqliteHelper.mail.removeMailRule(this.sqliteHelper.getWritableDatabase(), paramArrayOfInt);
    setDirty();
  }
  
  private void delRules(MailRuleInfo[] paramArrayOfMailRuleInfo)
  {
    int[] arrayOfInt = new int[paramArrayOfMailRuleInfo.length];
    int i = 0;
    while (i < paramArrayOfMailRuleInfo.length)
    {
      arrayOfInt[i] = paramArrayOfMailRuleInfo[i].getId();
      i += 1;
    }
    delRules(arrayOfInt);
  }
  
  private boolean isDirty()
  {
    return this.isRuleDirty;
  }
  
  private boolean isExistRule(MailRuleInfo paramMailRuleInfo)
  {
    boolean bool2 = false;
    HashMap localHashMap = getRules();
    boolean bool1 = bool2;
    if (localHashMap != null)
    {
      bool1 = bool2;
      if (localHashMap.get(Integer.valueOf(paramMailRuleInfo.getId())) != null) {
        bool1 = true;
      }
    }
    return bool1;
  }
  
  private void setDirty()
  {
    this.isRuleDirty = true;
    QMLog.log(4, "QMRuleManager", "dirty");
  }
  
  @NonNull
  public static QMRuleManager sharedInstance()
  {
    return instance;
  }
  
  public void apply(Mail paramMail, ApplyRuleCallback paramApplyRuleCallback)
  {
    Object localObject = getRules();
    if ((paramMail != null) && (localObject != null))
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MailRuleInfo localMailRuleInfo = (MailRuleInfo)((Iterator)localObject).next();
        if (this.delegate.hit(paramMail, localMailRuleInfo)) {
          this.delegate.run(localMailRuleInfo, paramMail, paramApplyRuleCallback);
        }
      }
    }
  }
  
  public void createAutoMove(int paramInt1, String[] paramArrayOfString, int paramInt2, ApplyRuleCallback paramApplyRuleCallback)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localAccount == null) {
      return;
    }
    paramArrayOfString = combineAddrs(paramArrayOfString);
    label43:
    int i;
    label46:
    Object localObject;
    if (localAccount.isQQMail())
    {
      this.cgiManager.addFilter(paramInt1, paramArrayOfString, paramInt2);
      i = 0;
      if (i < paramArrayOfString.length)
      {
        localObject = this.delegate.createRuleInfo("moveto", new Object[] { Integer.valueOf(paramInt1), paramArrayOfString[i], Integer.valueOf(paramInt2) });
        if ((!localAccount.isQQMail()) && (!localAccount.isExchangeMail())) {
          break label283;
        }
        apply((MailRuleInfo)localObject, paramApplyRuleCallback);
      }
    }
    for (;;)
    {
      i += 1;
      break label46;
      break;
      if (localAccount.isExchangeMail())
      {
        localObject = QMFolderManager.sharedInstance().getFolder(paramInt2);
        Exchange.ExchangeRule[] arrayOfExchangeRule = new Exchange.ExchangeRule[paramArrayOfString.length];
        i = 0;
        while (i < arrayOfExchangeRule.length)
        {
          arrayOfExchangeRule[i] = new Exchange.ExchangeRule();
          arrayOfExchangeRule[i].conditions_ = new Exchange.ExchangeRule.Conditions();
          arrayOfExchangeRule[i].actions_ = new Exchange.ExchangeRule.Actions();
          arrayOfExchangeRule[i].conditions_.sender_ = paramArrayOfString[i];
          arrayOfExchangeRule[i].actions_.des_folder_id_ = ((QMFolder)localObject).getRemoteId();
          arrayOfExchangeRule[i].is_enabled_ = true;
          arrayOfExchangeRule[i].priority_ = 1;
          i += 1;
        }
        this.protocolManager.addRule(localAccount, arrayOfExchangeRule);
        break label43;
      }
      QMPrivateProtocolManager.sharedInstance().syncAutoMoveAddress(paramInt1, paramArrayOfString, true);
      break label43;
      label283:
      addRule((MailRuleInfo)localObject, paramApplyRuleCallback);
    }
  }
  
  public void createReject(int paramInt, String[] paramArrayOfString)
  {
    paramArrayOfString = combineAddrs(paramArrayOfString);
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      addRule(this.delegate.createRuleInfo("reject", new Object[] { Integer.valueOf(paramInt), paramArrayOfString[i] }), null);
      i += 1;
    }
  }
  
  @SuppressLint({"UseSparseArrays"})
  protected HashMap<Integer, MailRuleInfo> getRules()
  {
    if (isDirty())
    {
      if (this.rules == null)
      {
        this.rules = new SparseArray();
        this.ruleMap = new HashMap();
      }
      for (;;)
      {
        this.rules = this.sqliteHelper.mail.getAllMailRules(this.sqliteHelper.getReadableDatabase());
        int j = this.rules.size();
        int i = 0;
        while (i < j)
        {
          MailRuleInfo localMailRuleInfo = (MailRuleInfo)this.rules.get(i);
          this.ruleMap.put(Integer.valueOf(localMailRuleInfo.getId()), localMailRuleInfo);
          i += 1;
        }
        this.rules.clear();
        this.ruleMap.clear();
      }
      this.isRuleDirty = false;
      QMLog.log(4, "QMRuleManager", "len:" + this.rules.size());
    }
    return this.ruleMap;
  }
  
  public boolean isAutoMove(int paramInt1, int paramInt2)
  {
    Object localObject = getRules();
    if (localObject != null)
    {
      localObject = ((HashMap)localObject).values().iterator();
      while (((Iterator)localObject).hasNext())
      {
        MailRuleInfo localMailRuleInfo = (MailRuleInfo)((Iterator)localObject).next();
        if ((localMailRuleInfo.getAlias().equals("moveto")) && (localMailRuleInfo.getAccountId() == paramInt1) && (localMailRuleInfo.getParam().equals(paramInt2 + ""))) {
          return true;
        }
      }
    }
    return false;
  }
  
  public boolean isRejected(int paramInt, String paramString)
  {
    return isExistRule(this.delegate.createRuleInfo("reject", new Object[] { Integer.valueOf(paramInt), paramString }));
  }
  
  public void removeAutoMove(int paramInt1, int paramInt2, String paramString)
  {
    Object localObject1 = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if (localObject1 == null) {}
    do
    {
      return;
      if (((Account)localObject1).isQQMail())
      {
        this.cgiManager.delFilter(paramInt1, paramString);
        return;
      }
    } while (((Account)localObject1).isExchangeMail());
    Object localObject2 = getRules();
    paramString = new ArrayList();
    if (localObject2 != null)
    {
      localObject1 = new ArrayList();
      localObject2 = ((HashMap)localObject2).values().iterator();
      while (((Iterator)localObject2).hasNext())
      {
        MailRuleInfo localMailRuleInfo = (MailRuleInfo)((Iterator)localObject2).next();
        if ((localMailRuleInfo.getAlias().equals("moveto")) && (localMailRuleInfo.getAccountId() == paramInt1) && (localMailRuleInfo.getParam().equals(paramInt2 + "")))
        {
          paramString.add(localMailRuleInfo.getVal());
          ((ArrayList)localObject1).add(localMailRuleInfo);
        }
      }
      delRules((MailRuleInfo[])((ArrayList)localObject1).toArray(new MailRuleInfo[0]));
    }
    QMPrivateProtocolManager.sharedInstance().syncAutoMoveAddress(paramInt1, (String[])paramString.toArray(new String[0]), false);
    paramString.clear();
  }
  
  public void removeReject(int paramInt, String[] paramArrayOfString)
  {
    paramArrayOfString = combineAddrs(paramArrayOfString);
    int[] arrayOfInt = new int[paramArrayOfString.length];
    int i = 0;
    while (i < paramArrayOfString.length)
    {
      arrayOfInt[i] = this.delegate.createRuleInfo("reject", new Object[] { Integer.valueOf(paramInt), paramArrayOfString[i] }).getId();
      i += 1;
    }
    delRules(arrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.model.mail.rule.QMRuleManager
 * JD-Core Version:    0.7.0.1
 */