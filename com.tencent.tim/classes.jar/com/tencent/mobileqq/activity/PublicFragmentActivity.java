package com.tencent.mobileqq.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.util.ArrayMap;
import android.util.AttributeSet;
import android.util.Log;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.fragment.PublicBaseFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Array;
import java.lang.reflect.Field;

public class PublicFragmentActivity
  extends FragmentActivity
{
  private static ArrayMap<String, a> jdField_b_of_type_AndroidSupportV4UtilArrayMap = new ArrayMap();
  private PublicBaseFragment jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  
  private PublicBaseFragment a()
  {
    Object localObject = getIntent().getStringExtra("public_fragment_class");
    bj(this, (String)localObject);
    if (QLog.isColorLevel()) {
      QLog.d("PublicFragmentActivity", 2, new Object[] { "creating fragment ", localObject });
    }
    try
    {
      localObject = (PublicBaseFragment)Class.forName((String)localObject).newInstance();
      ((PublicBaseFragment)localObject).setArguments(getIntent().getExtras());
      return localObject;
    }
    catch (Exception localException)
    {
      BaseApplicationImpl.sPublicFragmentEscapedMsg = Log.getStackTraceString(localException);
      QLog.e("PublicFragmentActivity", 1, "create fragment error", localException);
    }
    return null;
  }
  
  public static void a(String paramString, a parama)
  {
    jdField_b_of_type_AndroidSupportV4UtilArrayMap.put(paramString, parama);
  }
  
  private static void bj(Context paramContext, String paramString) {}
  
  private void bu(Bundle paramBundle)
  {
    Object localObject1 = paramBundle.getParcelable("android:support:fragments");
    if (localObject1 != null) {
      try
      {
        Object localObject2 = Class.forName("android.support.v4.app.FragmentManagerState");
        paramBundle = Class.forName("android.support.v4.app.FragmentState");
        if (((Class)localObject2).isInstance(localObject1))
        {
          localObject2 = ((Class)localObject2).getDeclaredField("mActive");
          if (!((Field)localObject2).isAccessible()) {
            ((Field)localObject2).setAccessible(true);
          }
          if (((Field)localObject2).getType().isArray())
          {
            localObject1 = ((Field)localObject2).get(localObject1);
            int j = Array.getLength(localObject1);
            int i = 0;
            while (i < j)
            {
              localObject2 = Array.get(localObject1, i);
              if ((localObject2 != null) && (paramBundle.isInstance(localObject2)))
              {
                Field localField = paramBundle.getDeclaredField("mArguments");
                if (!localField.isAccessible()) {
                  localField.setAccessible(true);
                }
                localObject2 = localField.get(localObject2);
                if ((localObject2 != null) && ((localObject2 instanceof Bundle))) {
                  ((Bundle)localObject2).setClassLoader(getClass().getClassLoader());
                }
              }
              i += 1;
            }
          }
        }
        return;
      }
      catch (Exception paramBundle)
      {
        QLog.d("PublicFragmentActivity", 2, "Patch error");
      }
    }
  }
  
  public static void start(Context paramContext, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass)
  {
    b.start(paramContext, paramIntent, PublicFragmentActivity.class, paramClass);
  }
  
  public static void start(Context paramContext, Class<? extends PublicBaseFragment> paramClass)
  {
    start(paramContext, null, paramClass);
  }
  
  public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    b.startForResult(paramActivity, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public static void startForResult(Activity paramActivity, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    startForResult(paramActivity, null, paramClass, paramInt);
  }
  
  public static void startForResult(Fragment paramFragment, Intent paramIntent, Class<? extends PublicBaseFragment> paramClass, int paramInt)
  {
    b.startForResult(paramFragment, paramIntent, PublicFragmentActivity.class, paramClass, paramInt);
  }
  
  public PublicBaseFragment b()
  {
    return this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment;
  }
  
  public boolean dispatchTouchEvent(MotionEvent paramMotionEvent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needDispatchTouchEvent()) && (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.dispatchTouchEvent(paramMotionEvent))) {
      return true;
    }
    return super.dispatchTouchEvent(paramMotionEvent);
  }
  
  public void doOnActivityResult(int paramInt1, int paramInt2, Intent paramIntent)
  {
    this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onActivityResult(0xFFFF & paramInt1, paramInt2, paramIntent);
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment = a();
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null)
    {
      this.mNeedStatusTrans = this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needStatusTrans();
      this.mActNeedImmersive = this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.needImmersive();
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.initWindowStyleAndAnimation(this);
    }
    if (paramBundle != null)
    {
      if (QLog.isColorLevel()) {
        QLog.d("PublicFragmentActivity", 1, "Activity restored, set classloader.");
      }
      bu(paramBundle);
    }
    super.doOnCreate(paramBundle);
    setContentView(2131558505);
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null)
    {
      finish();
      return false;
    }
    paramBundle = getSupportFragmentManager().beginTransaction();
    paramBundle.replace(2131367554, this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment);
    paramBundle.commit();
    return true;
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) && (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.doOnKeyDown(paramInt, paramKeyEvent))) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnNewIntent(Intent paramIntent)
  {
    super.doOnNewIntent(paramIntent);
    this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onNewIntent(paramIntent);
  }
  
  public void finish()
  {
    if ((this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) || (!this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.overrideFinish())) {
      superFinish();
    }
  }
  
  public String getCIOPageName()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      return this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.getCIOPageName();
    }
    return super.getCIOPageName();
  }
  
  public boolean isSupportScreenShot()
  {
    return (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) || (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.isSupportScreenShot());
  }
  
  public boolean isWrapContent()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      return this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.isWrapContent();
    }
    return super.isWrapContent();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onAccountChanged();
    }
  }
  
  public boolean onBackEvent()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment == null) {
      return super.onBackEvent();
    }
    return this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onBackEvent();
  }
  
  public View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet)
  {
    if (jdField_b_of_type_AndroidSupportV4UtilArrayMap.containsKey(paramString))
    {
      View localView = ((a)jdField_b_of_type_AndroidSupportV4UtilArrayMap.get(paramString)).onCreateView(paramString, paramContext, paramAttributeSet);
      if (localView != null) {
        return localView;
      }
    }
    return super.onCreateView(paramString, paramContext, paramAttributeSet);
  }
  
  public void onMultiWindowModeChanged(boolean paramBoolean)
  {
    super.onMultiWindowModeChanged(paramBoolean);
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onMultiWindowModeChanged(paramBoolean);
    }
  }
  
  public void onPostThemeChanged()
  {
    super.onPostThemeChanged();
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onPostThemeChanged();
    }
  }
  
  public void onPreThemeChanged()
  {
    super.onPreThemeChanged();
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onPreThemeChanged();
    }
  }
  
  public void onWindowFocusChanged(boolean paramBoolean)
  {
    super.onWindowFocusChanged(paramBoolean);
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onWindowFocusChanged(paramBoolean);
    }
  }
  
  public void requestWindowFeature(Intent paramIntent)
  {
    super.requestWindowFeature(paramIntent);
    if (paramIntent.hasExtra("public_fragment_window_feature")) {
      requestWindowFeature(paramIntent.getIntExtra("public_fragment_window_feature", 0));
    }
  }
  
  public void superFinish()
  {
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.beforeFinish();
    }
    super.finish();
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.onFinish();
    }
  }
  
  public String toString()
  {
    String str2 = super.toString();
    String str1;
    if (this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment != null) {
      str1 = str2 + "#" + this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.getClass().getName() + "@" + Integer.toHexString(this.jdField_b_of_type_ComTencentMobileqqFragmentPublicBaseFragment.hashCode());
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
  
  public static abstract interface a
  {
    public abstract View onCreateView(String paramString, Context paramContext, AttributeSet paramAttributeSet);
  }
  
  public static class b
  {
    public static void a(Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(BaseApplicationImpl.getApplication(), paramClass);
      localIntent.addFlags(268435456);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      BaseApplicationImpl.getApplication().startActivity(localIntent);
    }
    
    public static void start(Context paramContext, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramContext, paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramContext.startActivity(localIntent);
    }
    
    public static void start(Context paramContext, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1)
    {
      start(paramContext, null, paramClass, paramClass1);
    }
    
    public static void startForResult(Activity paramActivity, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramActivity, paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramActivity.startActivityForResult(localIntent, paramInt);
    }
    
    public static void startForResult(Fragment paramFragment, Intent paramIntent, Class<? extends PublicFragmentActivity> paramClass, Class<? extends PublicBaseFragment> paramClass1, int paramInt)
    {
      Intent localIntent = paramIntent;
      if (paramIntent == null) {
        localIntent = new Intent();
      }
      localIntent.setClass(paramFragment.getActivity(), paramClass);
      localIntent.putExtra("public_fragment_class", paramClass1.getName());
      paramFragment.startActivityForResult(localIntent, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.PublicFragmentActivity
 * JD-Core Version:    0.7.0.1
 */