package com.tencent.qqmail.namelist;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.model.mail.QMMailManager;
import com.tencent.qqmail.model.mail.QMMailSQLiteHelper;
import com.tencent.qqmail.model.mail.QMSettingManager;
import com.tencent.qqmail.model.mail.watcher.QMWatcherCenter;
import com.tencent.qqmail.namelist.cursor.NameListCursor;
import com.tencent.qqmail.namelist.cursor.NameListSearchCursor;
import com.tencent.qqmail.namelist.model.NameListContact;

public class NameListManager
{
  private static final long LOAD_NAME_LIST_INTERVAL = 180000L;
  private static final String TAG = "NameListManager";
  private static volatile NameListManager _instance;
  private NameListCGIManager cgiManager;
  private NameListProtocolManager protocolManager;
  private QMMailSQLiteHelper sqliteHelper;
  
  private NameListManager(QMMailSQLiteHelper paramQMMailSQLiteHelper)
  {
    this.sqliteHelper = paramQMMailSQLiteHelper;
    this.cgiManager = new NameListCGIManager(paramQMMailSQLiteHelper);
    this.protocolManager = new NameListProtocolManager(paramQMMailSQLiteHelper);
  }
  
  public static NameListManager sharedInstance()
  {
    if (_instance == null) {}
    try
    {
      if (_instance == null) {
        _instance = new NameListManager(QMMailManager.sharedInstance().getSqliteHelper());
      }
      return _instance;
    }
    finally {}
  }
  
  public void addNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if ((localAccount != null) && (localAccount.isQQMail()))
    {
      this.cgiManager.addNameList(paramInt1, paramInt2, paramArrayOfString);
      return;
    }
    this.protocolManager.addProtocolNameList(paramInt1, paramInt2, paramArrayOfString);
  }
  
  public void deleteNameList(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    if ((localAccount != null) && (localAccount.isQQMail()))
    {
      this.cgiManager.deleteNameList(paramInt1, paramInt2, paramArrayOfString);
      return;
    }
    this.protocolManager.deleteProtocolNameList(paramInt1, paramInt2, paramArrayOfString);
  }
  
  public NameListContact getNameListContactById(long paramLong)
  {
    return this.sqliteHelper.nameList.getNameListContactById(this.sqliteHelper.getReadableDatabase(), paramLong);
  }
  
  public NameListCursor getNameListCursor(int paramInt1, int paramInt2)
  {
    return new NameListCursor(this.sqliteHelper, this, paramInt1, paramInt2);
  }
  
  public NameListSearchCursor getNameListSearchCursor(int paramInt1, int paramInt2, String paramString)
  {
    return new NameListSearchCursor(this.sqliteHelper, this, paramInt1, paramInt2, paramString);
  }
  
  public boolean isBlackNameExist(int paramInt, String paramString)
  {
    return this.sqliteHelper.nameList.isBlackNameExist(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
  }
  
  public boolean isWhiteNameExist(int paramInt, String paramString)
  {
    return this.sqliteHelper.nameList.isWhiteNameExist(this.sqliteHelper.getReadableDatabase(), paramInt, paramString);
  }
  
  public void loadNameList(int paramInt)
  {
    long l = QMSettingManager.sharedInstance().getLastLoadBlackWhiteNameListTime(paramInt);
    if (System.currentTimeMillis() - l > 180000L)
    {
      QMSettingManager.sharedInstance().setLastLoadBlackWhiteNameListTime(paramInt, System.currentTimeMillis());
      Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt);
      if ((localAccount != null) && (localAccount.isQQMail()))
      {
        this.cgiManager.loadNameList(paramInt);
        return;
      }
      this.protocolManager.loadProtocolNameList(paramInt);
      return;
    }
    QMWatcherCenter.triggerLoadNameListSuccess(paramInt, false);
  }
  
  public void sqlUpdateNameListContactTypeByContactId(int paramInt, long paramLong)
  {
    this.sqliteHelper.nameList.sqlUpdateNameListContactTypeByContactId(this.sqliteHelper.getWritableDatabase(), paramInt, paramLong);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.NameListManager
 * JD-Core Version:    0.7.0.1
 */