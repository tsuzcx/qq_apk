package com.tencent.qqmail.utilities.syncadapter;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.accounts.NetworkErrorException;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.qqmail.QMApplicationContext;
import com.tencent.qqmail.account.activity.AccountTypeListActivity;
import com.tencent.qqmail.utilities.log.QMLog;
import com.tencent.qqmail.utilities.report.QMPushReportManager;

public class QMAuthenticator
  extends AbstractAccountAuthenticator
{
  private static final String TAG = "QMAuthenticator";
  
  public QMAuthenticator(Context paramContext)
  {
    super(paramContext);
  }
  
  public Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
    throws NetworkErrorException
  {
    QMLog.log(4, "QMAuthenticator", "addAccount");
    try
    {
      paramAccountAuthenticatorResponse = AccountTypeListActivity.createIntent("extra_from_system_add_account");
      paramAccountAuthenticatorResponse.addFlags(268435456);
      QMApplicationContext.sharedInstance().startActivity(paramAccountAuthenticatorResponse);
      QMSyncAdapterManager.setUserRemoved(false);
      QMSyncAdapterManager.checkAccount(true);
      return paramBundle;
    }
    catch (Throwable paramAccountAuthenticatorResponse) {}
    return paramBundle;
  }
  
  public Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
    throws NetworkErrorException
  {
    QMLog.log(4, "QMAuthenticator", "confirmCredentials");
    return null;
  }
  
  public Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    QMLog.log(4, "QMAuthenticator", "editProperties");
    return null;
  }
  
  public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount)
    throws NetworkErrorException
  {
    boolean bool = QMSyncAdapterManager.isSelfDeleting();
    if (bool) {}
    for (int i = 4;; i = 5)
    {
      QMLog.log(i, "QMAuthenticator", "getAccountRemovalAllowed: " + paramAccount + ", self: " + bool);
      if (!bool)
      {
        QMLog.log(5, "QMAuthenticator", "user removed account! " + paramAccount);
        QMSyncAdapterManager.setUserRemoved(true);
        QMPushReportManager.removeSyncAccount();
      }
      return super.getAccountRemovalAllowed(paramAccountAuthenticatorResponse, paramAccount);
    }
  }
  
  public Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    throws NetworkErrorException
  {
    QMLog.log(4, "QMAuthenticator", "getAuthToken");
    return null;
  }
  
  public String getAuthTokenLabel(String paramString)
  {
    QMLog.log(4, "QMAuthenticator", "getAuthTokenLabel");
    return null;
  }
  
  public Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
    throws NetworkErrorException
  {
    QMLog.log(4, "QMAuthenticator", "hasFeatures");
    return null;
  }
  
  public Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
    throws NetworkErrorException
  {
    QMLog.log(4, "QMAuthenticator", "updateCredentials");
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.syncadapter.QMAuthenticator
 * JD-Core Version:    0.7.0.1
 */