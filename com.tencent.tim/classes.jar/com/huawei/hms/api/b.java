package com.huawei.hms.api;

import android.app.Activity;
import android.app.AlertDialog.Builder;
import android.app.Dialog;
import android.app.Fragment;
import android.app.PendingIntent;
import android.content.Context;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import android.content.IntentSender.SendIntentException;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.os.Bundle;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.activity.BridgeActivity;
import com.huawei.hms.activity.EnableServiceActivity;
import com.huawei.hms.activity.ForegroundIntentBuilder;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.common.ErrorDialogFragment;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.api.AvailabilityException;
import com.huawei.hms.common.api.HuaweiApiCallable;
import com.huawei.hms.common.internal.ConnectionErrorMessages;
import com.huawei.hms.common.internal.DialogRedirect;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.update.manager.UpdateManager;
import com.huawei.hms.update.ui.UpdateBean;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.PackageManagerHelper.PackageStates;
import com.huawei.hms.utils.ResourceLoaderUtil;

final class b
  extends HuaweiApiAvailability
{
  private static final b a = new b();
  
  protected static int a(Activity paramActivity)
  {
    if ((a(paramActivity) != 0) && (Build.VERSION.SDK_INT >= 16)) {
      return 0;
    }
    return 3;
  }
  
  private static int a(Context paramContext)
  {
    if (paramContext == null) {
      return 0;
    }
    return paramContext.getResources().getIdentifier("androidhwext:style/Theme.Emui", null, null);
  }
  
  private static Dialog a(Activity paramActivity, int paramInt, DialogRedirect paramDialogRedirect, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    if (paramInt == 0) {
      return null;
    }
    AlertDialog.Builder localBuilder = new AlertDialog.Builder(paramActivity, a(paramActivity));
    localBuilder.setMessage(ConnectionErrorMessages.getErrorMessage(paramActivity, paramInt));
    if (paramOnCancelListener != null) {
      localBuilder.setOnCancelListener(paramOnCancelListener);
    }
    localBuilder.setPositiveButton(ConnectionErrorMessages.getErrorDialogButtonMessage(paramActivity, paramInt), paramDialogRedirect);
    paramActivity = ConnectionErrorMessages.getErrorTitle(paramActivity, paramInt);
    if (paramActivity != null) {
      localBuilder.setTitle(paramActivity);
    }
    return localBuilder.create();
  }
  
  private Intent a(Activity paramActivity, int paramInt)
  {
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
    case 2: 
      return UpdateManager.startUpdateIntent(paramActivity);
    }
    return BridgeActivity.getIntentStartBridgeActivity(paramActivity, BindingFailedResolution.class.getName());
  }
  
  private static Intent a(Activity paramActivity, String paramString)
  {
    return BridgeActivity.getIntentStartBridgeActivity(paramActivity, paramString);
  }
  
  private static Intent a(Context paramContext, String paramString)
  {
    return BridgeActivity.getIntentStartBridgeActivity(paramContext, paramString);
  }
  
  public static b a()
  {
    return a;
  }
  
  private static void a(Activity paramActivity, Dialog paramDialog, String paramString, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    ErrorDialogFragment.newInstance(paramDialog, paramOnCancelListener).show(paramActivity.getFragmentManager(), paramString);
  }
  
  private void a(Object paramObject)
    throws AvailabilityException
  {
    AvailabilityException localAvailabilityException = new AvailabilityException();
    if ((paramObject instanceof HuaweiApi)) {}
    for (paramObject = localAvailabilityException.getConnectionResult((HuaweiApi)paramObject); paramObject.getErrorCode() != 0; paramObject = localAvailabilityException.getConnectionResult((HuaweiApiCallable)paramObject))
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "The service is unavailable: " + localAvailabilityException.getMessage());
      throw localAvailabilityException;
    }
  }
  
  public PendingIntent a(Context paramContext, int paramInt)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + paramInt);
    PendingIntent localPendingIntent = null;
    Intent localIntent = b(paramContext, paramInt);
    if (localIntent != null) {
      localPendingIntent = PendingIntent.getActivity(paramContext, 0, localIntent, 134217728);
    }
    return localPendingIntent;
  }
  
  public Intent b(Context paramContext, int paramInt)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + paramInt);
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
    case 2: 
      UpdateBean localUpdateBean = new UpdateBean();
      localUpdateBean.setHmsOrApkUpgrade(true);
      localUpdateBean.setClientPackageName("com.huawei.hwid");
      localUpdateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
      localUpdateBean.setClientAppId("C10132067");
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramContext.getApplicationContext());
      }
      localUpdateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
      return UpdateManager.getStartUpdateIntent(paramContext, localUpdateBean);
    }
    return a(paramContext, BindingFailedResolution.class.getName());
  }
  
  public Task<Void> checkApiAccessible(HuaweiApi<?> paramHuaweiApi, HuaweiApi<?>... paramVarArgs)
  {
    localTask = new TaskCompletionSource().getTask();
    if (paramHuaweiApi != null) {}
    try
    {
      a(paramHuaweiApi);
      if (paramVarArgs != null)
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          a(paramVarArgs[i]);
          i += 1;
        }
      }
      return localTask;
    }
    catch (AvailabilityException paramHuaweiApi)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "checkApi has AvailabilityException " + paramHuaweiApi.getMessage());
    }
  }
  
  public Task<Void> checkApiAccessible(HuaweiApiCallable paramHuaweiApiCallable, HuaweiApiCallable... paramVarArgs)
  {
    localTask = new TaskCompletionSource().getTask();
    if (paramHuaweiApiCallable != null) {}
    try
    {
      a(paramHuaweiApiCallable);
      if (paramVarArgs != null)
      {
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          a(paramVarArgs[i]);
          i += 1;
        }
      }
      return localTask;
    }
    catch (AvailabilityException paramHuaweiApiCallable)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "HuaweiApiCallable checkApi has AvailabilityException " + paramHuaweiApiCallable.getMessage());
    }
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, int paramInt1, int paramInt2)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + paramInt1 + " requestCode: " + paramInt2);
    PendingIntent localPendingIntent = null;
    Intent localIntent = b(paramContext, paramInt1);
    if (localIntent != null) {
      localPendingIntent = PendingIntent.getActivity(paramContext, paramInt2, localIntent, 134217728);
    }
    return localPendingIntent;
  }
  
  public PendingIntent getErrPendingIntent(Context paramContext, ConnectionResult paramConnectionResult)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    return a(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + paramInt1);
    return getErrorDialog(paramActivity, paramInt1, paramInt2, null);
  }
  
  public Dialog getErrorDialog(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorDialog, errorCode: " + paramInt1);
    return a(paramActivity, paramInt1, DialogRedirect.getInstance(paramActivity, a(paramActivity, paramInt1), paramInt2), paramOnCancelListener);
  }
  
  public String getErrorString(int paramInt)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getErrorString, errorCode: " + paramInt);
    return ConnectionResult.a(paramInt);
  }
  
  public Task<Void> getHuaweiServicesReady(Activity paramActivity)
  {
    Preconditions.checkNotNull(paramActivity);
    Object localObject = new TaskCompletionSource[1];
    localObject[0] = new TaskCompletionSource();
    Task localTask = localObject[0].getTask();
    int i = new AvailableAdapter(30000000).isHuaweiMobileServicesAvailable(paramActivity);
    Intent localIntent1 = getResolveErrorIntent(paramActivity, i);
    Intent localIntent2 = BridgeActivity.getIntentStartBridgeActivity(paramActivity, ResolutionDelegate.class.getName());
    if (localIntent1 != null)
    {
      ForegroundIntentBuilder.registerResponseCallback("CALLBACK_METHOD", new b.1(this, (TaskCompletionSource[])localObject));
      localObject = new Bundle();
      ((Bundle)localObject).putParcelable("resolution", localIntent1);
      localIntent2.putExtras((Bundle)localObject);
      paramActivity.startActivity(localIntent2);
      return localTask;
    }
    if (i == 3)
    {
      localIntent1 = new Intent();
      localIntent1.setClass(paramActivity, EnableServiceActivity.class);
      paramActivity.startActivity(localIntent1);
      return localTask;
    }
    if (i == 0)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "The HMS service is available.");
      return localTask;
    }
    HMSLog.e("HuaweiApiAvailabilityImpl", "Framework can not solve the availability problem.");
    localObject[0].setException(new AvailabilityException());
    return localTask;
  }
  
  public Intent getResolveErrorIntent(Activity paramActivity, int paramInt)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorIntent, errorCode: " + paramInt);
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return null;
    case 1: 
    case 2: 
      UpdateBean localUpdateBean = new UpdateBean();
      localUpdateBean.setHmsOrApkUpgrade(true);
      localUpdateBean.setClientPackageName("com.huawei.hwid");
      localUpdateBean.setClientVersionCode(HuaweiApiAvailability.getServicesVersionCode());
      localUpdateBean.setClientAppId("C10132067");
      if (ResourceLoaderUtil.getmContext() == null) {
        ResourceLoaderUtil.setmContext(paramActivity.getApplicationContext());
      }
      localUpdateBean.setClientAppName(ResourceLoaderUtil.getString("hms_update_title"));
      return UpdateManager.getStartUpdateIntent(paramActivity, localUpdateBean);
    }
    return a(paramActivity, BindingFailedResolution.class.getName());
  }
  
  public PendingIntent getResolveErrorPendingIntent(Activity paramActivity, int paramInt)
  {
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter getResolveErrorPendingIntent, errorCode: " + paramInt);
    PendingIntent localPendingIntent = null;
    Intent localIntent = getResolveErrorIntent(paramActivity, paramInt);
    if (localIntent != null) {
      localPendingIntent = PendingIntent.getActivity(paramActivity, 0, localIntent, 134217728);
    }
    return localPendingIntent;
  }
  
  public int isHuaweiMobileNoticeAvailable(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    paramContext = new PackageManagerHelper(paramContext);
    PackageManagerHelper.PackageStates localPackageStates = paramContext.getPackageStates("com.huawei.hwid");
    if (PackageManagerHelper.PackageStates.NOT_INSTALLED.equals(localPackageStates)) {
      return 1;
    }
    if (paramContext.getPackageVersionCode("com.huawei.hwid") < 20600000) {
      return 2;
    }
    return 0;
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, HuaweiApiAvailability.getServicesVersionCode());
  }
  
  public int isHuaweiMobileServicesAvailable(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    return HuaweiMobileServicesUtil.isHuaweiMobileServicesAvailable(paramContext, paramInt);
  }
  
  public boolean isUserResolvableError(int paramInt)
  {
    return isUserResolvableError(paramInt, null);
  }
  
  public boolean isUserResolvableError(int paramInt, PendingIntent paramPendingIntent)
  {
    if (paramInt == 0) {
      return false;
    }
    if (paramPendingIntent != null) {
      return true;
    }
    switch (paramInt)
    {
    case 3: 
    case 4: 
    case 5: 
    default: 
      return false;
    }
    return true;
  }
  
  public void popupErrNotification(Context paramContext, ConnectionResult paramConnectionResult)
  {
    Preconditions.checkNotNull(paramContext);
    Preconditions.checkNotNull(paramConnectionResult);
    showErrorNotification(paramContext, paramConnectionResult.getErrorCode());
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2)
  {
    resolveError(paramActivity, paramInt1, paramInt2, null);
  }
  
  public void resolveError(Activity paramActivity, int paramInt1, int paramInt2, PendingIntent paramPendingIntent)
  {
    Checker.checkNonNull(paramActivity, "activity must not be null.");
    if (paramPendingIntent != null) {
      HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, parm pindingIntent is not null. and.errorCode: " + paramInt1);
    }
    for (;;)
    {
      if (paramPendingIntent != null) {
        HMSLog.i("HuaweiApiAvailabilityImpl", "In resolveError, start pingding intent.errorCode: " + paramInt1);
      }
      try
      {
        paramActivity.startIntentSenderForResult(paramPendingIntent.getIntentSender(), paramInt2, null, 0, 0, 0);
        return;
      }
      catch (IntentSender.SendIntentException paramActivity)
      {
        HMSLog.e("HuaweiApiAvailabilityImpl", "Enter resolveError, start pingding intent failed.errorCode: " + paramInt1);
      }
      HMSLog.i("HuaweiApiAvailabilityImpl", "Enter resolveError, parm pindingIntent is  null. get pendingintent from error code.and.errorCode: " + paramInt1);
      paramPendingIntent = getResolveErrorPendingIntent(paramActivity, paramInt1);
    }
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, null);
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    Dialog localDialog = getErrorDialog(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
    if (localDialog == null) {
      return false;
    }
    a(paramActivity, localDialog, "HuaweiMobileServicesErrorDialog", paramOnCancelListener);
    return true;
  }
  
  public boolean showErrorDialogFragment(Activity paramActivity, int paramInt1, Fragment paramFragment, int paramInt2, DialogInterface.OnCancelListener paramOnCancelListener)
  {
    return showErrorDialogFragment(paramActivity, paramInt1, paramInt2, paramOnCancelListener);
  }
  
  public void showErrorNotification(Context paramContext, int paramInt)
  {
    Checker.checkNonNull(paramContext, "context must not be null.");
    HMSLog.i("HuaweiApiAvailabilityImpl", "Enter showErrorNotification, errorCode: " + paramInt);
    paramContext = getErrorDialog((Activity)paramContext, paramInt, 0);
    if (paramContext == null)
    {
      HMSLog.i("HuaweiApiAvailabilityImpl", "showErrorNotification errorDialog can not be null");
      return;
    }
    paramContext.show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.api.b
 * JD-Core Version:    0.7.0.1
 */