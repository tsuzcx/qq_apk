package com.facebook.stetho.common.android;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Dialog;
import android.app.DialogFragment;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Resources;
import android.os.Build.VERSION;
import android.view.View;
import javax.annotation.Nullable;

@TargetApi(11)
final class FragmentCompatFramework
  extends FragmentCompat<Fragment, DialogFragment, FragmentManager, Activity>
{
  private static final DialogFragmentAccessorFramework sDialogFragmentAccessor;
  private static final FragmentAccessorFrameworkHoneycomb sFragmentAccessor;
  private static final FragmentActivityAccessorFramework sFragmentActivityAccessor;
  private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection();
  
  static
  {
    sFragmentActivityAccessor = new FragmentActivityAccessorFramework(null);
    if (Build.VERSION.SDK_INT >= 17) {}
    for (sFragmentAccessor = new FragmentAccessorFrameworkJellyBean(null);; sFragmentAccessor = new FragmentAccessorFrameworkHoneycomb(null))
    {
      sDialogFragmentAccessor = new DialogFragmentAccessorFramework(sFragmentAccessor);
      return;
    }
  }
  
  public DialogFragmentAccessorFramework forDialogFragment()
  {
    return sDialogFragmentAccessor;
  }
  
  public FragmentAccessorFrameworkHoneycomb forFragment()
  {
    return sFragmentAccessor;
  }
  
  public FragmentActivityAccessorFramework forFragmentActivity()
  {
    return sFragmentActivityAccessor;
  }
  
  public FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> forFragmentManager()
  {
    return sFragmentManagerAccessor;
  }
  
  public Class<DialogFragment> getDialogFragmentClass()
  {
    return DialogFragment.class;
  }
  
  public Class<Activity> getFragmentActivityClass()
  {
    return Activity.class;
  }
  
  public Class<Fragment> getFragmentClass()
  {
    return Fragment.class;
  }
  
  static class DialogFragmentAccessorFramework
    implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager>
  {
    private final FragmentAccessor<Fragment, FragmentManager> mFragmentAccessor;
    
    public DialogFragmentAccessorFramework(FragmentAccessor<Fragment, FragmentManager> paramFragmentAccessor)
    {
      this.mFragmentAccessor = paramFragmentAccessor;
    }
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment paramFragment)
    {
      return (FragmentManager)this.mFragmentAccessor.getChildFragmentManager(paramFragment);
    }
    
    public Dialog getDialog(DialogFragment paramDialogFragment)
    {
      return paramDialogFragment.getDialog();
    }
    
    @Nullable
    public FragmentManager getFragmentManager(Fragment paramFragment)
    {
      return (FragmentManager)this.mFragmentAccessor.getFragmentManager(paramFragment);
    }
    
    public int getId(Fragment paramFragment)
    {
      return this.mFragmentAccessor.getId(paramFragment);
    }
    
    public Resources getResources(Fragment paramFragment)
    {
      return this.mFragmentAccessor.getResources(paramFragment);
    }
    
    @Nullable
    public String getTag(Fragment paramFragment)
    {
      return this.mFragmentAccessor.getTag(paramFragment);
    }
    
    @Nullable
    public View getView(Fragment paramFragment)
    {
      return this.mFragmentAccessor.getView(paramFragment);
    }
  }
  
  static class FragmentAccessorFrameworkHoneycomb
    implements FragmentAccessor<Fragment, FragmentManager>
  {
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment paramFragment)
    {
      return null;
    }
    
    @Nullable
    public FragmentManager getFragmentManager(Fragment paramFragment)
    {
      return paramFragment.getFragmentManager();
    }
    
    public int getId(Fragment paramFragment)
    {
      return paramFragment.getId();
    }
    
    public Resources getResources(Fragment paramFragment)
    {
      return paramFragment.getResources();
    }
    
    @Nullable
    public String getTag(Fragment paramFragment)
    {
      return paramFragment.getTag();
    }
    
    @Nullable
    public View getView(Fragment paramFragment)
    {
      return paramFragment.getView();
    }
  }
  
  @TargetApi(17)
  static class FragmentAccessorFrameworkJellyBean
    extends FragmentCompatFramework.FragmentAccessorFrameworkHoneycomb
  {
    private FragmentAccessorFrameworkJellyBean()
    {
      super();
    }
    
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment paramFragment)
    {
      return paramFragment.getChildFragmentManager();
    }
  }
  
  static class FragmentActivityAccessorFramework
    implements FragmentActivityAccessor<Activity, FragmentManager>
  {
    @Nullable
    public FragmentManager getFragmentManager(Activity paramActivity)
    {
      return paramActivity.getFragmentManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentCompatFramework
 * JD-Core Version:    0.7.0.1
 */