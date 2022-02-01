package com.tencent.qqmini.sdk.launcher.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import com.tencent.qqmini.sdk.launcher.R.id;
import com.tencent.qqmini.sdk.launcher.R.layout;
import com.tencent.qqmini.sdk.launcher.log.QMLog;
import com.tencent.qqmini.sdk.launcher.utils.AndroidOUIWrapperUtil;

public class MiniFragmentActivity
  extends FragmentActivity
{
  public static final String KEY_FRAGMENT_CLASS = "public_fragment_class";
  public static final String KEY_WINDOW_FEATURE = "public_fragment_window_feature";
  private static final String TAG = "MiniFragmentActivity";
  private MiniBaseFragment mFrag;
  
  private MiniBaseFragment createFragment()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    if (QMLog.isColorLevel()) {
      QMLog.d("MiniFragmentActivity", "creating fragment " + (String)localObject);
    }
    try
    {
      localObject = (MiniBaseFragment)Class.forName((String)localObject).newInstance();
      ((MiniBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      QMLog.e("MiniFragmentActivity", "create fragment error", localException);
    }
    return null;
  }
  
  public static void start(Context paramContext, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass)
  {
    Launcher.start(paramContext, paramIntent, MiniFragmentActivity.class, paramClass);
  }
  
  public static void start(Context paramContext, Class<? extends MiniBaseFragment> paramClass)
  {
    start(paramContext, null, paramClass);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    Launcher.startForResult(paramActivity, paramIntent, MiniFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void startForResult(Activity paramActivity, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    startForResult(paramActivity, null, paramClass, paramInt);
  }
  
  public static void startForResult(Fragment paramFragment, Intent paramIntent, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    Launcher.startForResult(paramFragment, paramIntent, MiniFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void startForResult(Fragment paramFragment, Class<? extends MiniBaseFragment> paramClass, int paramInt)
  {
    startForResult(paramFragment, null, paramClass, paramInt);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.mFrag = createFragment();
    setContentView(R.layout.mini_sdk_fragment_activity);
    if (this.mFrag == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(R.id.frag_container, this.mFrag);
    paramBundle.commit();
    return true;
  }
  
  public MiniBaseFragment getFragment()
  {
    return this.mFrag;
  }
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    MiniBaseFragment localMiniBaseFragment = getFragment();
    if (localMiniBaseFragment != null) {
      localMiniBaseFragment.onActivityResult(paramInt1, paramInt2, paramIntent);
    }
  }
  
  public void onBackPressed()
  {
    if (this.mFrag != null) {
      this.mFrag.onBackPressed();
    }
    super.onBackPressed();
  }
  
  public void onCreate(@Nullable Bundle paramBundle)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      AndroidOUIWrapperUtil.fixOrientation(this);
    }
    requestWindowFeature(getIntent());
    super.onCreate(paramBundle);
    doOnCreate(paramBundle);
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.mFrag != null) && (this.mFrag.onKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.onKeyDown(paramInt, paramKeyEvent);
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    try
    {
      paramIntent.setExtrasClassLoader(getClassLoader());
      if (paramIntent.hasExtra("public_fragment_window_feature")) {
        requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
      }
      return;
    }
    catch (Exception paramIntent)
    {
      QMLog.w("MiniFragmentActivity", "Failed to request window feature", paramIntent);
    }
  }
  
  public void setRequestedOrientation(int paramInt)
  {
    if (!AndroidOUIWrapperUtil.isTranslucentOrFloating(this)) {
      super.setRequestedOrientation(paramInt);
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.mFrag != null) {
      str1 = str2 + "#" + this.mFrag.getClass().getName() + "@" + Integer.toHexString(this.mFrag.hashCode());
    }
    do
    {
      do
      {
        return str1;
        str1 = str2;
      } while (getIntent() == null);
      str1 = str2;
    } while (getIntent().getStringExtra("public_fragment_class") == null);
    return str2 + "#" + getIntent().getStringExtra("public_fragment_class");
  }
  
  public static class Launcher
  {
    public static void start(Context paramContext, Intent paramIntent, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramContext, paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramContext.startActivity(localIntent);
    }
    
    public static void start(Context paramContext, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1)
    {
      start(paramContext, null, paramClass, paramClass1);
    }
    
    public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1, int paramInt)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramActivity, paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramActivity.startActivityForResult(localIntent, paramInt);
    }
    
    public static void startForResult(Activity paramActivity, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1, int paramInt)
    {
      startForResult(paramActivity, null, paramClass, paramClass1, paramInt);
    }
    
    public static void startForResult(Fragment paramFragment, Intent paramIntent, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1, int paramInt)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramFragment.getActivity(), paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramFragment.startActivityForResult(localIntent, paramInt);
    }
    
    public static void startForResult(Fragment paramFragment, Class<? extends MiniFragmentActivity> paramClass, Class<? extends MiniBaseFragment> paramClass1, int paramInt)
    {
      startForResult(paramFragment, null, paramClass, paramClass1, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.launcher.ui.MiniFragmentActivity
 * JD-Core Version:    0.7.0.1
 */