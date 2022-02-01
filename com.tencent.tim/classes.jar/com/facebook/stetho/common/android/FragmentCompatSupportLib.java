package com.facebook.stetho.common.android;

import android.app.Dialog;
import android.content.res.Resources;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.View;
import javax.annotation.Nullable;

final class FragmentCompatSupportLib
  extends FragmentCompat<Fragment, DialogFragment, FragmentManager, FragmentActivity>
{
  private static final DialogFragmentAccessorSupportLib sDialogFragmentAccessor;
  private static final FragmentAccessorSupportLib sFragmentAccessor = new FragmentAccessorSupportLib(null);
  private static final FragmentActivityAccessorSupportLib sFragmentActivityAccessor = new FragmentActivityAccessorSupportLib(null);
  private static final FragmentCompat.FragmentManagerAccessorViaReflection<FragmentManager, Fragment> sFragmentManagerAccessor;
  
  static
  {
    sDialogFragmentAccessor = new DialogFragmentAccessorSupportLib(null);
    sFragmentManagerAccessor = new FragmentCompat.FragmentManagerAccessorViaReflection();
  }
  
  public DialogFragmentAccessorSupportLib forDialogFragment()
  {
    return sDialogFragmentAccessor;
  }
  
  public FragmentAccessorSupportLib forFragment()
  {
    return sFragmentAccessor;
  }
  
  public FragmentActivityAccessorSupportLib forFragmentActivity()
  {
    return sFragmentActivityAccessor;
  }
  
  public FragmentManagerAccessor<FragmentManager, Fragment> forFragmentManager()
  {
    return sFragmentManagerAccessor;
  }
  
  public Class<DialogFragment> getDialogFragmentClass()
  {
    return DialogFragment.class;
  }
  
  public Class<FragmentActivity> getFragmentActivityClass()
  {
    return FragmentActivity.class;
  }
  
  public Class<Fragment> getFragmentClass()
  {
    return Fragment.class;
  }
  
  static class DialogFragmentAccessorSupportLib
    extends FragmentCompatSupportLib.FragmentAccessorSupportLib
    implements DialogFragmentAccessor<DialogFragment, Fragment, FragmentManager>
  {
    private DialogFragmentAccessorSupportLib()
    {
      super();
    }
    
    public Dialog getDialog(DialogFragment paramDialogFragment)
    {
      return paramDialogFragment.getDialog();
    }
  }
  
  static class FragmentAccessorSupportLib
    implements FragmentAccessor<Fragment, FragmentManager>
  {
    @Nullable
    public FragmentManager getChildFragmentManager(Fragment paramFragment)
    {
      return paramFragment.getChildFragmentManager();
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
  
  static class FragmentActivityAccessorSupportLib
    implements FragmentActivityAccessor<FragmentActivity, FragmentManager>
  {
    @Nullable
    public FragmentManager getFragmentManager(FragmentActivity paramFragmentActivity)
    {
      return paramFragmentActivity.getSupportFragmentManager();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.facebook.stetho.common.android.FragmentCompatSupportLib
 * JD-Core Version:    0.7.0.1
 */