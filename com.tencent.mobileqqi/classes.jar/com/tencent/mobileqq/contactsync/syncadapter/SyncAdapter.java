package com.tencent.mobileqq.contactsync.syncadapter;

import android.accounts.Account;
import android.annotation.SuppressLint;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.MobileQQ;

public class SyncAdapter
  extends AbstractThreadedSyncAdapter
{
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.SyncAdapter";
  private Context jdField_a_of_type_AndroidContentContext;
  
  public SyncAdapter(Context paramContext, boolean paramBoolean)
  {
    super(paramContext, paramBoolean);
    this.a = paramContext;
  }
  
  public void onPerformSync(Account paramAccount, Bundle paramBundle, String paramString, ContentProviderClient paramContentProviderClient, SyncResult paramSyncResult)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync");
    }
    paramAccount = (QQAppInterface)((MobileQQ)this.a.getApplicationContext()).waitAppRuntime(null);
    if ((paramAccount == null) || (!paramAccount.isLogin())) {
      if (QLog.isColorLevel()) {
        QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | app is null or not login, " + paramAccount);
      }
    }
    do
    {
      return;
      paramAccount = (ContactSyncManager)paramAccount.getManager(39);
      try
      {
        paramAccount.a();
        return;
      }
      catch (Throwable paramAccount) {}
    } while (!QLog.isColorLevel());
    QLog.d("ContactSync.SyncAdapter", 2, "onPerformSync | syncAllContacts exception = " + Log.getStackTraceString(paramAccount));
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled()
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled()");
    }
    super.onSyncCanceled();
  }
  
  @SuppressLint({"NewApi"})
  public void onSyncCanceled(Thread paramThread)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.SyncAdapter", 2, "onSyncCanceled(thread)");
    }
    super.onSyncCanceled(paramThread);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.syncadapter.SyncAdapter
 * JD-Core Version:    0.7.0.1
 */