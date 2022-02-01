package com.huawei.hms.security;

import android.content.Context;
import android.content.Intent;
import com.huawei.hms.api.HuaweiServicesNotAvailableException;
import com.huawei.hms.api.HuaweiServicesRepairableException;

public class SecComponentInstallWizard
{
  public static final String PROVIDER_NAME = "HmsCore_OpenSSL";
  
  public static void install(Context paramContext)
    throws HuaweiServicesNotAvailableException, HuaweiServicesRepairableException
  {}
  
  public static abstract interface SecComponentInstallWizardListener
  {
    public abstract void onFailed(int paramInt, Intent paramIntent);
    
    public abstract void onSuccess();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.security.SecComponentInstallWizard
 * JD-Core Version:    0.7.0.1
 */