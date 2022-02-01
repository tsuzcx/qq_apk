package com.tencent.qqmail.utilities;

import com.tencent.qqmail.account.AccountList;
import com.tencent.qqmail.account.AccountManager;
import com.tencent.qqmail.account.model.Account;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkError;
import com.tencent.qqmail.utilities.qmnetwork.QMNetworkUtils;
import com.tencent.qqmail.utilities.qmnetwork.login.QMLoginError;
import com.tencent.qqmail.utilities.thread.Threads;
import java.util.HashMap;

public class QMSyncErrorManager
{
  public static final int MOBILE_SYNC_NORMAL = 0;
  public static final int MOBILE_SYNC_SERVER_ERROR = 4;
  public static final int MOBILE_SYNC_UNAUTH = 3;
  public static final int MOBILE_SYNC_WITHOUT_NETWORK = 1;
  public static final int MOBILE_SYNC_WITH_UNAVAILABLE_NETWORK = 2;
  private static final String TAG = "QMSyncErrorManager";
  private static QMSyncErrorManager instance;
  private boolean isNetworkUnavailable = false;
  private HashMap<Integer, Integer> syncErrorMap = new HashMap();
  
  private boolean isNetworkError(int paramInt, boolean paramBoolean)
  {
    boolean bool = false;
    if (paramBoolean) {
      if ((paramInt != 15) && (paramInt != 3) && (paramInt != 5) && (paramInt != 7))
      {
        paramBoolean = bool;
        if (paramInt != 5000) {}
      }
      else
      {
        paramBoolean = true;
      }
    }
    do
    {
      return paramBoolean;
      if (paramInt == 51) {
        break;
      }
      paramBoolean = bool;
    } while (paramInt != 32);
    return true;
  }
  
  private boolean isPasswordError(QMNetworkError paramQMNetworkError, boolean paramBoolean)
  {
    if (paramQMNetworkError != null) {
      if (((paramQMNetworkError instanceof QMLoginError)) && (!paramBoolean))
      {
        i = ((QMLoginError)paramQMNetworkError).loginErrorType;
        if ((i != 1) && (i != 7) && (i != 6) && (i != 4)) {}
      }
      else
      {
        while ((paramBoolean) && ((paramQMNetworkError.getCode() == 4) || (paramQMNetworkError.getCode() == 3000) || (paramQMNetworkError.getCode() == 3002) || (paramQMNetworkError.getCode() == 3003)))
        {
          int i;
          return true;
        }
      }
    }
    return false;
  }
  
  public static QMSyncErrorManager sharedInstance()
  {
    if (instance == null) {}
    try
    {
      if (instance == null) {
        instance = new QMSyncErrorManager();
      }
      return instance;
    }
    finally {}
  }
  
  public void addSyncError(int paramInt1, int paramInt2)
  {
    this.syncErrorMap.put(Integer.valueOf(paramInt1), Integer.valueOf(paramInt2));
  }
  
  public int getSyncErrorCode(int paramInt)
  {
    if (this.syncErrorMap.get(Integer.valueOf(paramInt)) != null) {
      return ((Integer)this.syncErrorMap.get(Integer.valueOf(paramInt))).intValue();
    }
    return 0;
  }
  
  public void handleSyncError(int paramInt, QMNetworkError paramQMNetworkError, boolean paramBoolean)
  {
    QMNetworkUtils.clearNetworkType();
    StringBuilder localStringBuilder = new StringBuilder().append("accountId:").append(paramInt).append(", error:");
    Object localObject;
    if (paramQMNetworkError != null)
    {
      localObject = paramQMNetworkError.toString();
      QMLog.log(6, "QMSyncErrorManager", localObject + ", isProtocol:" + paramBoolean);
      if (QMNetworkUtils.isNetworkConnected()) {
        break label87;
      }
      QMLog.log(6, "QMSyncErrorManager", "sync without network");
    }
    label87:
    do
    {
      return;
      localObject = Integer.valueOf(0);
      break;
      if (isPasswordError(paramQMNetworkError, paramBoolean))
      {
        QMLog.log(6, "QMSyncErrorManager", "sync password error:" + paramInt);
        addSyncError(paramInt, 3);
        return;
      }
    } while ((paramQMNetworkError instanceof QMLoginError));
    if ((paramQMNetworkError != null) && (isNetworkError(paramQMNetworkError.getCode(), paramBoolean)))
    {
      QMLog.log(6, "QMSyncErrorManager", "network unAvailable:" + paramQMNetworkError.getCode());
      setNetworkUnavailable(true);
      return;
    }
    Threads.runInBackground(new QMSyncErrorManager.1(this, paramQMNetworkError, paramInt));
  }
  
  public boolean isNetworkUnavailable()
  {
    return this.isNetworkUnavailable;
  }
  
  public void removeSyncError(int paramInt)
  {
    if (getSyncErrorCode(paramInt) != 0)
    {
      QMLog.log(4, "QMSyncErrorManager", "remove account:" + paramInt + ", error:" + getSyncErrorCode(paramInt));
      this.syncErrorMap.remove(Integer.valueOf(paramInt));
      setNetworkUnavailable(false);
    }
  }
  
  public void removeUnAuthError(int paramInt)
  {
    if (getSyncErrorCode(paramInt) == 3)
    {
      this.syncErrorMap.remove(Integer.valueOf(paramInt));
      setNetworkUnavailable(false);
    }
  }
  
  public void setNetworkUnavailable(boolean paramBoolean)
  {
    this.isNetworkUnavailable = paramBoolean;
  }
  
  public boolean skipErrorCode(int paramInt1, int paramInt2)
  {
    Account localAccount = AccountManager.shareInstance().getAccountList().getAccountById(paramInt1);
    return ((paramInt2 < 500) && (paramInt2 >= 300)) || (paramInt2 == 0) || ((localAccount != null) && (localAccount.isExchangeMail()) && ((paramInt2 == 5) || (paramInt2 == 3))) || ((localAccount != null) && (localAccount.isActiveSyncMail()) && ((paramInt2 == 11) || (paramInt2 == 3))) || ((localAccount != null) && (localAccount.isImapMail()) && ((paramInt2 == 5) || (paramInt2 == 8) || (paramInt2 == 3)));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.QMSyncErrorManager
 * JD-Core Version:    0.7.0.1
 */