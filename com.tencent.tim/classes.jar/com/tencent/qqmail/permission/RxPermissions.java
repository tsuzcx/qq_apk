package com.tencent.qqmail.permission;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build.VERSION;
import android.text.TextUtils;
import android.util.Log;
import com.tencent.qqmail.utilities.log.QMLog;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import rx.Observable;
import rx.Observable.Transformer;
import rx.subjects.PublishSubject;

public class RxPermissions
{
  public static final String TAG = "RxPermissions";
  static RxPermissions sSingleton;
  private Context mCtx;
  private boolean mLogging;
  private Map<String, PublishSubject<Permission>> mSubjects = new HashMap();
  
  RxPermissions(Context paramContext)
  {
    this.mCtx = paramContext;
  }
  
  public static RxPermissions getInstance(Context paramContext)
  {
    if (sSingleton == null) {
      sSingleton = new RxPermissions(paramContext.getApplicationContext());
    }
    return sSingleton;
  }
  
  @TargetApi(23)
  private boolean isGranted_(String paramString)
  {
    return this.mCtx.checkSelfPermission(paramString) == 0;
  }
  
  @TargetApi(23)
  private boolean isRevoked_(String paramString)
  {
    return this.mCtx.getPackageManager().isPermissionRevokedByPolicy(paramString, this.mCtx.getPackageName());
  }
  
  private void log(String paramString)
  {
    if (this.mLogging) {
      Log.d("RxPermissions", paramString);
    }
  }
  
  private Observable<?> oneOf(Observable<?> paramObservable1, Observable<?> paramObservable2)
  {
    if (paramObservable1 == null) {
      return Observable.just(null);
    }
    return Observable.merge(paramObservable1, paramObservable2);
  }
  
  private Observable<?> pending(String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if (!this.mSubjects.containsKey(str)) {
        return Observable.empty();
      }
      i += 1;
    }
    return Observable.just(null);
  }
  
  private Observable<Permission> request(Observable<?> paramObservable, String... paramVarArgs)
  {
    if ((paramVarArgs == null) || (paramVarArgs.length == 0)) {
      throw new IllegalArgumentException("RxPermissions.request/requestEach requires at least one input permission");
    }
    return oneOf(paramObservable, pending(paramVarArgs)).flatMap(new RxPermissions.3(this, paramVarArgs));
  }
  
  @TargetApi(23)
  private Observable<Permission> request_(String... paramVarArgs)
  {
    ArrayList localArrayList1 = new ArrayList(paramVarArgs.length);
    ArrayList localArrayList2 = new ArrayList();
    int j = paramVarArgs.length;
    int i = 0;
    if (i < j)
    {
      String str = paramVarArgs[i];
      log("Requesting permission " + str);
      if (isGranted(str)) {
        localArrayList1.add(Observable.just(new Permission(str, true)));
      }
      for (;;)
      {
        i += 1;
        break;
        if (isRevoked(str))
        {
          localArrayList1.add(Observable.just(new Permission(str, false)));
        }
        else
        {
          PublishSubject localPublishSubject2 = (PublishSubject)this.mSubjects.get(str);
          PublishSubject localPublishSubject1 = localPublishSubject2;
          if (localPublishSubject2 == null)
          {
            localArrayList2.add(str);
            localPublishSubject1 = PublishSubject.create();
            this.mSubjects.put(str, localPublishSubject1);
          }
          localArrayList1.add(localPublishSubject1);
        }
      }
    }
    if (!localArrayList2.isEmpty()) {
      startShadowActivity((String[])localArrayList2.toArray(new String[localArrayList2.size()]));
    }
    return Observable.concat(Observable.from(localArrayList1));
  }
  
  @TargetApi(23)
  private boolean shouldShowRequestPermissionRationale_(Activity paramActivity, String... paramVarArgs)
  {
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      String str = paramVarArgs[i];
      if ((!isGranted(str)) && (!paramActivity.shouldShowRequestPermissionRationale(str))) {
        return false;
      }
      i += 1;
    }
    return true;
  }
  
  public Observable.Transformer<Object, Boolean> ensure(String... paramVarArgs)
  {
    return new RxPermissions.1(this, paramVarArgs);
  }
  
  public Observable.Transformer<Object, Permission> ensureEach(String... paramVarArgs)
  {
    return new RxPermissions.2(this, paramVarArgs);
  }
  
  public boolean isGranted(String paramString)
  {
    return (!isMarshmallow()) || (isGranted_(paramString));
  }
  
  boolean isMarshmallow()
  {
    return Build.VERSION.SDK_INT >= 23;
  }
  
  public boolean isRevoked(String paramString)
  {
    return (isMarshmallow()) && (isRevoked_(paramString));
  }
  
  void onRequestPermissionsResult(int paramInt, String[] paramArrayOfString, int[] paramArrayOfInt)
  {
    int i = paramArrayOfString.length;
    paramInt = 0;
    if (paramInt < i)
    {
      log("onRequestPermissionsResult  " + paramArrayOfString[paramInt]);
      PublishSubject localPublishSubject = (PublishSubject)this.mSubjects.get(paramArrayOfString[paramInt]);
      boolean bool;
      if (localPublishSubject != null)
      {
        this.mSubjects.remove(paramArrayOfString[paramInt]);
        if (paramArrayOfInt[paramInt] == 0)
        {
          bool = true;
          label81:
          localPublishSubject.onNext(new Permission(paramArrayOfString[paramInt], bool));
          localPublishSubject.onCompleted();
        }
      }
      for (;;)
      {
        paramInt += 1;
        break;
        bool = false;
        break label81;
        QMLog.log(4, "RxPermissions", "Maybe the request is restore by system");
      }
    }
  }
  
  void removeResult(String[] paramArrayOfString)
  {
    if (paramArrayOfString != null)
    {
      int j = paramArrayOfString.length;
      int i = 0;
      while (i < j)
      {
        if ((PublishSubject)this.mSubjects.get(paramArrayOfString[i]) != null) {
          this.mSubjects.remove(paramArrayOfString[i]);
        }
        i += 1;
      }
    }
  }
  
  public Observable<Boolean> request(String... paramVarArgs)
  {
    return Observable.just(null).compose(ensure(paramVarArgs));
  }
  
  public Observable<Permission> requestEach(String... paramVarArgs)
  {
    return Observable.just(null).compose(ensureEach(paramVarArgs));
  }
  
  public void setLogging(boolean paramBoolean)
  {
    this.mLogging = paramBoolean;
  }
  
  public Observable<Boolean> shouldShowRequestPermissionRationale(Activity paramActivity, String... paramVarArgs)
  {
    if (!isMarshmallow()) {
      return Observable.just(Boolean.valueOf(false));
    }
    return Observable.just(Boolean.valueOf(shouldShowRequestPermissionRationale_(paramActivity, paramVarArgs)));
  }
  
  void startShadowActivity(String[] paramArrayOfString)
  {
    log("startShadowActivity " + TextUtils.join(", ", paramArrayOfString));
    Intent localIntent = new Intent(this.mCtx, ShadowActivity.class);
    localIntent.putExtra("permissions", paramArrayOfString);
    localIntent.addFlags(268435456);
    this.mCtx.startActivity(localIntent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.permission.RxPermissions
 * JD-Core Version:    0.7.0.1
 */