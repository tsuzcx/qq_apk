package com.tencent.tim.fragment;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentManager.BackStackEntry;
import android.support.v4.app.FragmentManager.OnBackStackChangedListener;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import java.lang.reflect.Method;

public class FragmentManagerEx
  implements FragmentManager.OnBackStackChangedListener
{
  FullScreenFragment a;
  private String cIr;
  private FragmentActivity g;
  
  public FragmentManagerEx(BaseFragmentActivity paramBaseFragmentActivity)
  {
    this.g = paramBaseFragmentActivity;
  }
  
  private String Fb()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    int i = localFragmentManager.getBackStackEntryCount();
    if (i > 0) {
      return localFragmentManager.getBackStackEntryAt(i - 1).getName();
    }
    return this.cIr;
  }
  
  public FullScreenFragment a(Class<? extends FullScreenFragment> paramClass, Bundle paramBundle, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    throws IllegalArgumentException
  {
    Bundle localBundle = paramBundle;
    if (paramBundle == null) {}
    for (;;)
    {
      Object localObject;
      try
      {
        localBundle = new Bundle();
        str = paramClass.getName();
        localObject = getSupportFragmentManager();
        if (!paramBoolean1)
        {
          localFullScreenFragment = (FullScreenFragment)((FragmentManager)localObject).findFragmentByTag(str);
          if (localFullScreenFragment != null)
          {
            localFullScreenFragment.setArguments(localBundle);
            paramBundle = localFullScreenFragment;
            if (str.equals(Fb())) {
              break label412;
            }
            if (str.equals(this.cIr))
            {
              ((FragmentManager)localObject).popBackStack(((FragmentManager)localObject).getBackStackEntryAt(0).getId(), 1);
              return localFullScreenFragment;
            }
            ((FragmentManager)localObject).popBackStack(str, 0);
            return localFullScreenFragment;
          }
        }
      }
      catch (InstantiationException paramBundle)
      {
        String str;
        FullScreenFragment localFullScreenFragment;
        throw new IllegalArgumentException("class :" + paramClass.getName() + " must have null arguments constractor");
        localObject = ((FragmentManager)localObject).beginTransaction();
        switch (paramInt)
        {
        case 1: 
          ((FragmentTransaction)localObject).setCustomAnimations(2130772092, 2130772093, 2130772088, 2130772089);
          localFullScreenFragment = (FullScreenFragment)paramClass.newInstance();
          localFullScreenFragment.setArguments(localBundle);
          if (paramBoolean1) {
            break label407;
          }
          paramBundle = str;
          ((FragmentTransaction)localObject).replace(16908290, localFullScreenFragment, paramBundle);
          if (paramBoolean2) {
            ((FragmentTransaction)localObject).addToBackStack(str);
          }
          ((FragmentTransaction)localObject).setBreadCrumbTitle(paramCharSequence);
          ((FragmentTransaction)localObject).commitAllowingStateLoss();
          paramBundle = localFullScreenFragment;
          if (this.cIr != null) {
            break label412;
          }
          this.cIr = str;
          return localFullScreenFragment;
        }
      }
      catch (IllegalAccessException paramBundle)
      {
        throw new IllegalArgumentException("class :" + paramClass.getName() + " must have null arguments constractor");
      }
      ((FragmentTransaction)localObject).setCustomAnimations(0, 0, 2130772088, 2130772089);
      continue;
      ((FragmentTransaction)localObject).setCustomAnimations(0, 2130772094, 0, 2130772095);
      continue;
      ((FragmentTransaction)localObject).setCustomAnimations(2130772099, 2130772100, 0, 2130772098);
      continue;
      ((FragmentTransaction)localObject).setCustomAnimations(2130772101, 2130772102, 2130772088, 2130772089);
      continue;
      ((FragmentTransaction)localObject).setCustomAnimations(0, 0, 0, 2130772089);
      continue;
      label407:
      paramBundle = null;
      continue;
      label412:
      return paramBundle;
    }
  }
  
  public FragmentManager getSupportFragmentManager()
  {
    return this.g.getSupportFragmentManager();
  }
  
  public void noteStateNotSaved()
  {
    FragmentManager localFragmentManager = getSupportFragmentManager();
    if (localFragmentManager != null) {}
    try
    {
      localFragmentManager.getClass().getMethod("noteStateNotSaved", new Class[0]).invoke(localFragmentManager, new Object[0]);
      return;
    }
    catch (Exception localException)
    {
      localException.printStackTrace();
    }
  }
  
  public boolean onBackPressed()
  {
    return (this.a != null) && (this.a.onBackPressed());
  }
  
  public void onBackStackChanged()
  {
    int i = getSupportFragmentManager().getBackStackEntryCount();
    this.a = ((FullScreenFragment)getSupportFragmentManager().findFragmentById(16908290));
    if ((this.a != null) && (i > 0)) {
      this.a.a = getSupportFragmentManager().getBackStackEntryAt(i - 1);
    }
  }
  
  public boolean onKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.a != null) && (this.a.onKeyDown(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.a != null) && (this.a.onKeyLongPress(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    return (this.a != null) && (this.a.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent));
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.a != null) && (this.a.onKeyShortcut(paramInt, paramKeyEvent));
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    return (this.a != null) && (this.a.onKeyUp(paramInt, paramKeyEvent));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.fragment.FragmentManagerEx
 * JD-Core Version:    0.7.0.1
 */