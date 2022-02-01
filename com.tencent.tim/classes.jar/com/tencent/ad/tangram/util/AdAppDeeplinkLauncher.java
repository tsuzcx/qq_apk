package com.tencent.ad.tangram.util;

import android.app.Activity;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Keep;
import android.text.TextUtils;
import com.tencent.ad.tangram.AdError;
import com.tencent.ad.tangram.log.AdLog;

@Keep
public final class AdAppDeeplinkLauncher
{
  private static final String TAG = "AdAppDeeplinkLauncher";
  
  public static Result canLaunch(Activity paramActivity, Params paramParams)
  {
    Result localResult = new Result();
    if ((paramActivity == null) || (!paramParams.isValid()))
    {
      localResult.error = new AdError(4);
      return localResult;
    }
    paramParams = paramParams.getIntent();
    if (paramParams == null)
    {
      localResult.error = new AdError(201);
      return localResult;
    }
    localResult.resolveInfo = AdAppUtil.resolveActivity(paramActivity, paramParams);
    if (localResult.resolveInfo == null)
    {
      localResult.error = new AdError(204);
      return localResult;
    }
    localResult.error = new AdError(0);
    return localResult;
  }
  
  public static Result launch(Activity paramActivity, Params paramParams)
  {
    Object localObject3 = null;
    Object localObject1 = new Result();
    label77:
    Object localObject2;
    if ((paramActivity == null) || (!paramParams.isValid()))
    {
      ((Result)localObject1).error = new AdError(4);
      paramActivity = (Activity)localObject1;
      localObject1 = paramActivity;
      if (paramActivity == null)
      {
        localObject1 = new Result();
        ((Result)localObject1).error = new AdError(1);
      }
      if (paramParams == null) {
        break label297;
      }
      paramActivity = paramParams.deeplink;
      if (paramParams == null) {
        break label302;
      }
      localObject2 = paramParams.packageName;
      label87:
      if (paramParams == null) {
        break label308;
      }
    }
    label297:
    label302:
    label308:
    for (int i = paramParams.addflags;; i = -2147483648)
    {
      for (;;)
      {
        int j = ((Result)localObject1).getErrorCode();
        paramParams = localObject3;
        if (((Result)localObject1).resolveInfo != null)
        {
          paramParams = localObject3;
          if (((Result)localObject1).resolveInfo.activityInfo != null) {
            paramParams = ((Result)localObject1).resolveInfo.activityInfo.toString();
          }
        }
        AdLog.i("AdAppDeeplinkLauncher", String.format("launch \nparams deeplink:%s packageName:%s flags:%d \nresult errorCode:%d resolveInfo.activityInfo:%s", new Object[] { paramActivity, localObject2, Integer.valueOf(i), Integer.valueOf(j), paramParams }));
        return localObject1;
        localObject2 = paramParams.getIntent();
        if (localObject2 == null)
        {
          ((Result)localObject1).error = new AdError(201);
          paramActivity = (Activity)localObject1;
          break;
        }
        localObject1 = canLaunch(paramActivity, paramParams);
        if (localObject1 != null)
        {
          if (!((Result)localObject1).isSuccess())
          {
            paramActivity = (Activity)localObject1;
            break;
          }
          try
          {
            paramActivity.startActivity((Intent)localObject2);
            ((Result)localObject1).error = new AdError(0);
            paramActivity = (Activity)localObject1;
          }
          catch (Throwable paramActivity)
          {
            AdLog.e("AdAppDeeplinkLauncher", "launch", paramActivity);
            ((Result)localObject1).error = new AdError(202, paramActivity);
          }
        }
      }
      paramActivity = (Activity)localObject1;
      break;
      paramActivity = null;
      break label77;
      localObject2 = null;
      break label87;
    }
  }
  
  @Keep
  public static final class Params
  {
    public int addflags = -2147483648;
    public String deeplink;
    public Bundle extrasForIntent;
    public String packageName;
    
    Intent getIntent()
    {
      Object localObject1 = null;
      if (!isValid()) {}
      Object localObject2;
      do
      {
        do
        {
          return localObject1;
          localObject2 = AdUriUtil.parse(this.deeplink);
        } while (localObject2 == null);
        localObject2 = new Intent("android.intent.action.VIEW", (Uri)localObject2);
        if (!TextUtils.isEmpty(this.packageName)) {
          ((Intent)localObject2).setPackage(this.packageName);
        }
        if ((this.extrasForIntent != null) && (!this.extrasForIntent.isEmpty())) {
          ((Intent)localObject2).putExtras(this.extrasForIntent);
        }
        localObject1 = localObject2;
      } while (this.addflags == -2147483648);
      ((Intent)localObject2).addFlags(this.addflags);
      return localObject2;
    }
    
    boolean isValid()
    {
      return !TextUtils.isEmpty(this.deeplink);
    }
  }
  
  @Keep
  public static final class Result
  {
    AdError error;
    ResolveInfo resolveInfo;
    
    String getActivityName()
    {
      if ((this.resolveInfo != null) && (this.resolveInfo.activityInfo != null)) {
        return this.resolveInfo.activityInfo.name;
      }
      return null;
    }
    
    AdError getError()
    {
      if (this.error != null) {
        return this.error;
      }
      return new AdError(1);
    }
    
    int getErrorCode()
    {
      return getError().getErrorCode();
    }
    
    public boolean isSuccess()
    {
      return (this.error != null) && (this.error.isSuccess());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.ad.tangram.util.AdAppDeeplinkLauncher
 * JD-Core Version:    0.7.0.1
 */