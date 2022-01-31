package android.support.v4.app;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.net.Uri;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.support.annotation.IdRes;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RestrictTo;
import android.support.v13.view.DragAndDropPermissionsCompat;
import android.support.v4.content.ContextCompat;
import android.view.DragEvent;
import android.view.View;

public class ActivityCompat
  extends ContextCompat
{
  private static ActivityCompat.PermissionCompatDelegate sDelegate;
  
  public static void finishAffinity(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.finishAffinity();
      return;
    }
    paramActivity.finish();
  }
  
  public static void finishAfterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21)
    {
      paramActivity.finishAfterTransition();
      return;
    }
    paramActivity.finish();
  }
  
  @RestrictTo({android.support.annotation.RestrictTo.Scope.LIBRARY_GROUP})
  public static ActivityCompat.PermissionCompatDelegate getPermissionCompatDelegate()
  {
    return sDelegate;
  }
  
  @Nullable
  public static Uri getReferrer(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 22) {
      paramActivity = paramActivity.getReferrer();
    }
    Intent localIntent;
    Uri localUri;
    do
    {
      return paramActivity;
      localIntent = paramActivity.getIntent();
      localUri = (Uri)localIntent.getParcelableExtra("android.intent.extra.REFERRER");
      paramActivity = localUri;
    } while (localUri != null);
    paramActivity = localIntent.getStringExtra("android.intent.extra.REFERRER_NAME");
    if (paramActivity != null) {
      return Uri.parse(paramActivity);
    }
    return null;
  }
  
  @Deprecated
  public static boolean invalidateOptionsMenu(Activity paramActivity)
  {
    paramActivity.invalidateOptionsMenu();
    return true;
  }
  
  public static void postponeEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.postponeEnterTransition();
    }
  }
  
  @Nullable
  public static DragAndDropPermissionsCompat requestDragAndDropPermissions(Activity paramActivity, DragEvent paramDragEvent)
  {
    return DragAndDropPermissionsCompat.request(paramActivity, paramDragEvent);
  }
  
  public static void requestPermissions(@NonNull Activity paramActivity, @NonNull String[] paramArrayOfString, @IntRange(from=0L) int paramInt)
  {
    if ((sDelegate != null) && (sDelegate.requestPermissions(paramActivity, paramArrayOfString, paramInt))) {}
    do
    {
      return;
      if (Build.VERSION.SDK_INT >= 23)
      {
        if ((paramActivity instanceof ActivityCompat.RequestPermissionsRequestCodeValidator)) {
          ((ActivityCompat.RequestPermissionsRequestCodeValidator)paramActivity).validateRequestPermissionsRequestCode(paramInt);
        }
        paramActivity.requestPermissions(paramArrayOfString, paramInt);
        return;
      }
    } while (!(paramActivity instanceof ActivityCompat.OnRequestPermissionsResultCallback));
    new Handler(Looper.getMainLooper()).post(new ActivityCompat.1(paramArrayOfString, paramActivity, paramInt));
  }
  
  @NonNull
  public static View requireViewById(@NonNull Activity paramActivity, @IdRes int paramInt)
  {
    paramActivity = paramActivity.findViewById(paramInt);
    if (paramActivity == null) {
      throw new IllegalArgumentException("ID does not reference a View inside this Activity");
    }
    return paramActivity;
  }
  
  public static void setEnterSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramSharedElementCallback != null) {
        localObject1 = new ActivityCompat.SharedElementCallback23Impl(paramSharedElementCallback);
      }
      paramActivity.setEnterSharedElementCallback((android.app.SharedElementCallback)localObject1);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    localObject1 = localObject2;
    if (paramSharedElementCallback != null) {
      localObject1 = new ActivityCompat.SharedElementCallback21Impl(paramSharedElementCallback);
    }
    paramActivity.setEnterSharedElementCallback((android.app.SharedElementCallback)localObject1);
  }
  
  public static void setExitSharedElementCallback(@NonNull Activity paramActivity, @Nullable SharedElementCallback paramSharedElementCallback)
  {
    Object localObject2 = null;
    Object localObject1 = null;
    if (Build.VERSION.SDK_INT >= 23)
    {
      if (paramSharedElementCallback != null) {
        localObject1 = new ActivityCompat.SharedElementCallback23Impl(paramSharedElementCallback);
      }
      paramActivity.setExitSharedElementCallback((android.app.SharedElementCallback)localObject1);
    }
    while (Build.VERSION.SDK_INT < 21) {
      return;
    }
    localObject1 = localObject2;
    if (paramSharedElementCallback != null) {
      localObject1 = new ActivityCompat.SharedElementCallback21Impl(paramSharedElementCallback);
    }
    paramActivity.setExitSharedElementCallback((android.app.SharedElementCallback)localObject1);
  }
  
  public static void setPermissionCompatDelegate(@Nullable ActivityCompat.PermissionCompatDelegate paramPermissionCompatDelegate)
  {
    sDelegate = paramPermissionCompatDelegate;
  }
  
  public static boolean shouldShowRequestPermissionRationale(@NonNull Activity paramActivity, @NonNull String paramString)
  {
    if (Build.VERSION.SDK_INT >= 23) {
      return paramActivity.shouldShowRequestPermissionRationale(paramString);
    }
    return false;
  }
  
  public static void startActivityForResult(@NonNull Activity paramActivity, @NonNull Intent paramIntent, int paramInt, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startActivityForResult(paramIntent, paramInt, paramBundle);
      return;
    }
    paramActivity.startActivityForResult(paramIntent, paramInt);
  }
  
  public static void startIntentSenderForResult(@NonNull Activity paramActivity, @NonNull IntentSender paramIntentSender, int paramInt1, @Nullable Intent paramIntent, int paramInt2, int paramInt3, int paramInt4, @Nullable Bundle paramBundle)
  {
    if (Build.VERSION.SDK_INT >= 16)
    {
      paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4, paramBundle);
      return;
    }
    paramActivity.startIntentSenderForResult(paramIntentSender, paramInt1, paramIntent, paramInt2, paramInt3, paramInt4);
  }
  
  public static void startPostponedEnterTransition(@NonNull Activity paramActivity)
  {
    if (Build.VERSION.SDK_INT >= 21) {
      paramActivity.startPostponedEnterTransition();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     android.support.v4.app.ActivityCompat
 * JD-Core Version:    0.7.0.1
 */