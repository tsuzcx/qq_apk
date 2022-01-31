package com.tencent.mobileqq.contactsync.authenticator;

import android.accounts.AbstractAccountAuthenticator;
import android.accounts.Account;
import android.accounts.AccountAuthenticatorResponse;
import android.content.Context;
import android.os.Bundle;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.contactsync.ContactSyncManager;
import com.tencent.qphone.base.util.QLog;
import mqq.app.AppRuntime;

public class Authenticator
  extends AbstractAccountAuthenticator
{
  private static final String jdField_a_of_type_JavaLangString = "ContactSync.Authenticator";
  private Context jdField_a_of_type_AndroidContentContext;
  private QQAppInterface jdField_a_of_type_ComTencentMobileqqAppQQAppInterface;
  
  public Authenticator(Context paramContext, AppRuntime paramAppRuntime)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    if ((paramAppRuntime instanceof QQAppInterface)) {
      this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface = ((QQAppInterface)paramAppRuntime);
    }
  }
  
  public Bundle addAccount(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString1, String paramString2, String[] paramArrayOfString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "addAccount");
    }
    paramAccountAuthenticatorResponse = new Bundle();
    paramAccountAuthenticatorResponse.putInt("errorCode", 6);
    paramAccountAuthenticatorResponse.putString("errorMessage", "Manually add account is unsupported");
    return paramAccountAuthenticatorResponse;
  }
  
  public Bundle confirmCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "onfirmCredentials");
    }
    return null;
  }
  
  public Bundle editProperties(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, String paramString)
  {
    return null;
  }
  
  public Bundle getAccountRemovalAllowed(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "getAccountRemovalAllowed");
    }
    if (this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface != null) {
      ContactSyncManager.a(this.jdField_a_of_type_ComTencentMobileqqAppQQAppInterface, paramAccount);
    }
    return super.getAccountRemovalAllowed(paramAccountAuthenticatorResponse, paramAccount);
  }
  
  public Bundle getAuthToken(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "getAuthToken");
    }
    return null;
  }
  
  public String getAuthTokenLabel(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "getAuthTokenLabel");
    }
    return "QQ通讯录同步@Authenticator";
  }
  
  public Bundle hasFeatures(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String[] paramArrayOfString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "hasFeatures");
    }
    return null;
  }
  
  public Bundle updateCredentials(AccountAuthenticatorResponse paramAccountAuthenticatorResponse, Account paramAccount, String paramString, Bundle paramBundle)
  {
    if (QLog.isColorLevel()) {
      QLog.d("ContactSync.Authenticator", 2, "getAuthToken");
    }
    return null;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.contactsync.authenticator.Authenticator
 * JD-Core Version:    0.7.0.1
 */