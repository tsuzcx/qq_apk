package com.tencent.mobileqq.statistics;

import acej;
import acha;
import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.content.Intent;
import android.os.Build.VERSION;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.Parcelable.Creator;
import android.os.SystemClock;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.IFragmentAttachCallback;
import android.support.v4.app.Fragment.IFragmentLifecycleCallback;
import android.support.v4.app.FragmentActivity;
import anpn;
import aqmr;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mfsdk.MagnifierSDK;
import com.tencent.mobileqq.activity.ChatFragment;
import com.tencent.mobileqq.activity.MainFragment;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.activity.SplashActivity;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.pluginsdk.PluginProxyActivity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import sws;

@TargetApi(14)
public final class UEC
  implements Application.ActivityLifecycleCallbacks, Fragment.IFragmentAttachCallback, Fragment.IFragmentLifecycleCallback
{
  public static UEC a;
  private final List<Application.ActivityLifecycleCallbacks> GH = new ArrayList();
  private LinkedHashMap<String, UECItem> ag = new LinkedHashMap(8);
  private final boolean cJi;
  private int mActiveActivityCount;
  
  private UEC()
  {
    if (BaseApplicationImpl.sProcessId == 1) {}
    for (;;)
    {
      this.cJi = bool;
      a = this;
      this.mActiveActivityCount = 0;
      return;
      bool = false;
    }
  }
  
  public static boolean C(Object paramObject)
  {
    if ((FragmentActivity.class.isInstance(paramObject)) || (MainFragment.class.isInstance(paramObject))) {}
    do
    {
      return false;
      if (!Fragment.class.isInstance(paramObject)) {
        break;
      }
      paramObject = (Fragment)paramObject;
    } while ((SplashActivity.class.isInstance(paramObject.getActivity())) && (!ChatFragment.class.isInstance(paramObject)));
    return true;
  }
  
  public static UEC a()
  {
    if (a == null) {}
    try
    {
      if (a == null) {
        a = new UEC();
      }
      return a;
    }
    finally {}
  }
  
  private String a(Fragment paramFragment)
  {
    if (paramFragment == null) {
      return "null";
    }
    String str = e(paramFragment.getActivity());
    paramFragment = paramFragment.getClass().getSimpleName();
    return str + "_fg_" + paramFragment;
  }
  
  private String a(String paramString, Activity paramActivity)
  {
    paramActivity = e(paramActivity);
    return paramActivity + "_fm_" + paramString;
  }
  
  public static String a(String paramString1, String paramString2, int paramInt, long paramLong)
  {
    if (paramString2 != null)
    {
      str1 = paramString2;
      if (!paramString2.equals("")) {}
    }
    else
    {
      str1 = "preActNull";
    }
    paramString2 = nD(str1);
    if ((paramString1 == null) || (paramString1.equals(""))) {
      return paramString2 + "+" + paramInt + ":" + paramLong;
    }
    if (!paramString1.contains(paramString2)) {
      return paramString1 + "|" + paramString2 + "+" + paramInt + ":" + paramLong;
    }
    String str2 = paramString1.substring(paramString1.indexOf(paramString2));
    int k = str2.indexOf("+");
    int m = str2.indexOf(":");
    int j = str2.indexOf("|");
    int i = j;
    if (j == -1) {
      i = str2.length();
    }
    String str1 = str2.substring(k + 1, m);
    str2 = str2.substring(m + 1, i);
    i = Integer.valueOf(str1).intValue();
    long l = Long.valueOf(str2).longValue();
    paramLong = (i * l / (i + paramInt) + 0.5D + (paramInt * paramLong / (i + paramInt) + 0.5D));
    return paramString1.replace(paramString2 + "+" + i + ":" + l, paramString2 + "+" + (i + paramInt) + ":" + paramLong);
  }
  
  private void a(Object paramObject1, String paramString1, boolean paramBoolean, String paramString2, Object paramObject2)
  {
    int i = paramObject1.hashCode();
    if (paramBoolean)
    {
      a(paramString1, i, paramString2, paramObject2);
      return;
    }
    a(paramString1, null, 0L, paramString2, paramObject2);
    b(paramString1, i, paramString2, paramObject2);
  }
  
  private String e(Activity paramActivity)
  {
    Object localObject;
    if (paramActivity == null) {
      localObject = "null";
    }
    String str;
    do
    {
      return localObject;
      str = paramActivity.getClass().getSimpleName();
      if ((paramActivity instanceof PluginProxyActivity))
      {
        paramActivity = nD(((PluginProxyActivity)paramActivity).getPluginActivity());
        return str + "_" + paramActivity;
      }
      localObject = str;
    } while (!QQBrowserActivity.class.isInstance(paramActivity));
    paramActivity = nE(g(paramActivity));
    return str + "_" + paramActivity;
  }
  
  private String f(Activity paramActivity)
  {
    Object localObject2;
    if (paramActivity == null) {
      localObject2 = "null";
    }
    Object localObject1;
    do
    {
      return localObject2;
      localObject2 = paramActivity.getClass().getSimpleName();
      localObject1 = localObject2;
      if ((paramActivity instanceof FragmentActivity)) {
        localObject1 = "fa_" + (String)localObject2;
      }
      localObject2 = localObject1;
    } while (!(paramActivity instanceof PluginProxyActivity));
    paramActivity = nD(((PluginProxyActivity)paramActivity).getPluginActivity());
    return (String)localObject1 + "_" + paramActivity;
  }
  
  public static String nD(String paramString)
  {
    String str = paramString;
    if (paramString != null)
    {
      str = paramString;
      if (paramString.contains("."))
      {
        str = paramString;
        if (!paramString.endsWith(".")) {
          str = paramString.substring(paramString.lastIndexOf('.') + 1, paramString.length());
        }
      }
    }
    return str;
  }
  
  private String nE(String paramString)
  {
    String str;
    if (aqmr.isEmpty(paramString)) {
      str = "null";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("?");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  private String nF(String paramString)
  {
    String str;
    if (aqmr.isEmpty(paramString)) {
      str = "null";
    }
    int i;
    do
    {
      return str;
      i = paramString.indexOf("//");
      str = paramString;
      if (i >= 0)
      {
        str = paramString;
        if (paramString.length() > i + 2) {
          str = paramString.substring(i + 2);
        }
      }
      i = str.indexOf(":");
      paramString = str;
      if (i > 0) {
        paramString = str.substring(0, i);
      }
      i = paramString.indexOf("/");
      str = paramString;
    } while (i <= 0);
    return paramString.substring(0, i);
  }
  
  private void onRunningBackground()
  {
    Object localObject = this.ag;
    this.ag = new LinkedHashMap(8);
    ArrayList localArrayList = new ArrayList(((LinkedHashMap)localObject).size());
    localObject = ((LinkedHashMap)localObject).values().iterator();
    while (((Iterator)localObject).hasNext()) {
      localArrayList.add((UECItem)((Iterator)localObject).next());
    }
    if (this.cJi)
    {
      ce(localArrayList);
      return;
    }
    localObject = new Intent();
    ((Intent)localObject).putParcelableArrayListExtra("UECData", localArrayList);
    ((Intent)localObject).setClass(BaseApplicationImpl.sApplication, UECReceiver.class);
    BaseApplicationImpl.sApplication.sendBroadcast((Intent)localObject);
  }
  
  public UECItem a(String paramString1, String paramString2, long paramLong, String paramString3, Object paramObject)
  {
    paramObject = (UECItem)this.ag.get(paramString1);
    if (paramObject == null)
    {
      paramObject = new UECItem();
      paramObject.mKey = paramString1;
      paramObject.dLa = 1;
      if ((paramString1.startsWith(QQBrowserActivity.class.getSimpleName())) && (paramObject.mDomain == null))
      {
        int i = paramString1.indexOf("_");
        if ((i >= 0) && (paramString1.length() > i)) {
          paramObject.mDomain = nF(paramString1.substring(paramString1.indexOf("_") + 1));
        }
      }
      paramObject.aKU = paramString3;
      paramObject.mVersion = "3.4.4";
      this.ag.put(paramString1, paramObject);
    }
    for (paramString1 = paramObject;; paramString1 = paramObject)
    {
      paramString1.cgf = a(paramString1.cgf, paramString2, 1, paramLong);
      return paramString1;
      paramObject.dLa += 1;
    }
  }
  
  public void a(Application.ActivityLifecycleCallbacks paramActivityLifecycleCallbacks)
  {
    if (paramActivityLifecycleCallbacks == null) {}
    while (this.GH.contains(paramActivityLifecycleCallbacks)) {
      return;
    }
    this.GH.add(paramActivityLifecycleCallbacks);
  }
  
  public void a(String paramString1, int paramInt, String paramString2, Object paramObject)
  {
    UECItem localUECItem2 = (UECItem)this.ag.get(paramString1);
    UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2, paramObject);
    }
    if ((paramInt == localUECItem1.dLc) && (localUECItem1.anC > 0L))
    {
      localUECItem1.anB = (SystemClock.uptimeMillis() - localUECItem1.anC + localUECItem1.anB);
      localUECItem1.anC = 0L;
      if (C(paramObject)) {
        MagnifierSDK.a().uG(paramString2);
      }
    }
  }
  
  public void a(String paramString, Activity paramActivity, boolean paramBoolean, Object paramObject)
  {
    if (paramString != null)
    {
      paramActivity = a(paramString, paramActivity);
      a(paramString, paramActivity, paramBoolean, paramActivity, paramObject);
    }
  }
  
  public void b(String paramString1, int paramInt, String paramString2, Object paramObject)
  {
    UECItem localUECItem2 = (UECItem)this.ag.get(paramString1);
    UECItem localUECItem1 = localUECItem2;
    if (localUECItem2 == null) {
      localUECItem1 = a(paramString1, null, 0L, paramString2, paramObject);
    }
    localUECItem1.dLc = paramInt;
    localUECItem1.dLb += 1;
    localUECItem1.anC = SystemClock.uptimeMillis();
    if (C(paramObject)) {
      MagnifierSDK.a().uF(paramString2);
    }
  }
  
  public void ce(ArrayList<UECItem> paramArrayList)
  {
    if (!"Success".equals(BaseApplicationImpl.sInjectResult)) {}
    Object localObject;
    do
    {
      do
      {
        do
        {
          return;
        } while (!BaseApplicationImpl.sApplication.isRuntimeReady());
        localObject = (QQAppInterface)BaseApplicationImpl.sApplication.getRuntime();
        if (localObject != null)
        {
          a locala = (a)((QQAppInterface)localObject).getManager(134);
          if (locala != null) {
            locala.bR(paramArrayList);
          }
        }
      } while (localObject == null);
      localObject = (a)((QQAppInterface)localObject).getManager(158);
    } while (localObject == null);
    ((a)localObject).bR(paramArrayList);
  }
  
  protected String g(Activity paramActivity)
  {
    Intent localIntent = paramActivity.getIntent();
    String str = localIntent.getStringExtra("url");
    paramActivity = str;
    if (str == null)
    {
      str = localIntent.getStringExtra("key_params_qq");
      paramActivity = str;
      if (str == null) {
        paramActivity = "null";
      }
    }
    return paramActivity;
  }
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle)
  {
    Object localObject = this.GH.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityCreated(paramActivity, paramBundle);
    }
    try
    {
      if (paramActivity.getIntent() == null) {
        break label148;
      }
      localObject = paramActivity.getIntent().getExtras();
      if (localObject == null) {
        break label148;
      }
      paramBundle = ((Bundle)localObject).getString("preAct");
      l1 = ((Bundle)localObject).getLong("preAct_time", 0L);
      if (l1 == 0L) {
        break label143;
      }
      long l2 = System.currentTimeMillis();
      l1 = l2 - l1;
    }
    catch (Throwable paramBundle)
    {
      for (;;)
      {
        paramBundle.printStackTrace();
        long l1 = 0L;
        paramBundle = null;
        continue;
        l1 = 0L;
        continue;
        paramBundle = null;
        l1 = 0L;
      }
    }
    if ((paramActivity instanceof FragmentActivity)) {
      ((FragmentActivity)paramActivity).setFragmentAttachListener(this);
    }
    a(e(paramActivity), paramBundle, l1, f(paramActivity), paramActivity);
  }
  
  public void onActivityDestroyed(Activity paramActivity)
  {
    Iterator localIterator = this.GH.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityDestroyed(paramActivity);
    }
  }
  
  public void onActivityPaused(Activity paramActivity)
  {
    Object localObject = this.GH.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityPaused(paramActivity);
    }
    localObject = e(paramActivity);
    String str = f(paramActivity);
    a((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      sws.cP(paramActivity);
    }
  }
  
  public void onActivityResumed(Activity paramActivity)
  {
    Object localObject = this.GH.iterator();
    while (((Iterator)localObject).hasNext()) {
      ((Application.ActivityLifecycleCallbacks)((Iterator)localObject).next()).onActivityResumed(paramActivity);
    }
    localObject = e(paramActivity);
    String str = f(paramActivity);
    b((String)localObject, paramActivity.hashCode(), str, paramActivity);
    if (Build.VERSION.SDK_INT >= 23) {
      sws.cO(paramActivity);
    }
  }
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity)
  {
    Iterator localIterator = this.GH.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStarted(paramActivity);
    }
    this.mActiveActivityCount += 1;
    acha.dN(paramActivity);
    if (Build.VERSION.SDK_INT >= 26) {
      acej.c(paramActivity, true, false);
    }
  }
  
  public void onActivityStopped(Activity paramActivity)
  {
    Iterator localIterator = this.GH.iterator();
    while (localIterator.hasNext()) {
      ((Application.ActivityLifecycleCallbacks)localIterator.next()).onActivityStopped(paramActivity);
    }
    this.mActiveActivityCount -= 1;
    if (this.mActiveActivityCount == 0) {
      onRunningBackground();
    }
  }
  
  public void onFragmentAttached(Fragment paramFragment)
  {
    if (paramFragment != null) {
      paramFragment.setFragmentLifecycleCallback(this);
    }
  }
  
  public void onFragmentHiddenChanged(Fragment paramFragment, boolean paramBoolean)
  {
    if (paramFragment != null)
    {
      String str = a(paramFragment);
      a(paramFragment, str, paramBoolean, str, paramFragment);
    }
  }
  
  public static class UECItem
    implements Parcelable
  {
    public static final Parcelable.Creator<UECItem> CREATOR = new anpn();
    public String aKU;
    public long anB;
    public long anC;
    public String cgf;
    public String cgg;
    public int dLa;
    public int dLb;
    public int dLc;
    public String mDomain;
    public String mKey;
    public String mVersion;
    
    public int describeContents()
    {
      return 0;
    }
    
    public void writeToParcel(Parcel paramParcel, int paramInt)
    {
      paramParcel.writeString(this.mKey);
      paramParcel.writeInt(this.dLa);
      paramParcel.writeLong(this.anB);
      paramParcel.writeInt(this.dLb);
      paramParcel.writeString(this.cgf);
      paramParcel.writeString(this.cgg);
      paramParcel.writeString(this.mDomain);
      paramParcel.writeString(this.mVersion);
      paramParcel.writeString(this.aKU);
    }
  }
  
  public static abstract interface a
  {
    public abstract void bR(ArrayList<UEC.UECItem> paramArrayList);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.mobileqq.statistics.UEC
 * JD-Core Version:    0.7.0.1
 */