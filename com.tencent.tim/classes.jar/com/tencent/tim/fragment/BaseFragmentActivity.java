package com.tencent.tim.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
import augw;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class BaseFragmentActivity
  extends FragmentActivity
{
  protected FragmentManagerEx a;
  boolean diN = false;
  protected List<augw> xt;
  
  public FullScreenFragment a(Class<? extends FullScreenFragment> paramClass, Bundle paramBundle, CharSequence paramCharSequence, boolean paramBoolean)
    throws IllegalArgumentException
  {
    return a(paramClass, paramBundle, paramCharSequence, paramBoolean, 0, true);
  }
  
  public FullScreenFragment a(Class<? extends FullScreenFragment> paramClass, Bundle paramBundle, CharSequence paramCharSequence, boolean paramBoolean1, int paramInt, boolean paramBoolean2)
    throws IllegalArgumentException
  {
    return this.a.a(paramClass, paramBundle, paramCharSequence, paramBoolean1, paramInt, paramBoolean2);
  }
  
  public List<augw> cH()
  {
    return null;
  }
  
  public void doOnBackPressed()
  {
    if (this.a.onBackPressed()) {
      return;
    }
    super.doOnBackPressed();
  }
  
  public boolean doOnCreate(Bundle paramBundle)
  {
    super.doOnCreate(paramBundle);
    this.a = new FragmentManagerEx(this);
    getSupportFragmentManager().addOnBackStackChangedListener(this.a);
    paramBundle = cH();
    if (paramBundle != null)
    {
      this.xt = new ArrayList();
      this.xt.addAll(paramBundle);
      paramBundle = this.xt.iterator();
      while (paramBundle.hasNext()) {
        ((augw)paramBundle.next()).create();
      }
    }
    return true;
  }
  
  public void doOnDestroy()
  {
    super.doOnDestroy();
    this.a = null;
    if (this.xt != null)
    {
      Iterator localIterator = this.xt.iterator();
      while (localIterator.hasNext()) {
        ((augw)localIterator.next()).destroy();
      }
    }
  }
  
  public boolean doOnKeyDown(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyDown(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.doOnKeyDown(paramInt, paramKeyEvent);
  }
  
  public void doOnResume()
  {
    super.doOnResume();
    if (this.diN) {
      this.diN = false;
    }
  }
  
  public void doOnStart()
  {
    this.diN = true;
    super.doOnStart();
  }
  
  public void doOnStop()
  {
    super.doOnStop();
    this.a.noteStateNotSaved();
  }
  
  public void onAccountChanged()
  {
    super.onAccountChanged();
    if (this.xt != null)
    {
      localObject = this.xt.iterator();
      while (((Iterator)localObject).hasNext()) {
        ((augw)((Iterator)localObject).next()).onAccountChanged(this.app);
      }
    }
    Object localObject = getSupportFragmentManager().getFragments();
    if (localObject != null)
    {
      localObject = ((List)localObject).iterator();
      while (((Iterator)localObject).hasNext()) {
        if (!((Fragment)((Iterator)localObject).next() instanceof FullScreenFragment)) {}
      }
    }
  }
  
  public boolean onKeyLongPress(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyLongPress(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyLongPress(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyMultiple(int paramInt1, int paramInt2, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent)) {
      return true;
    }
    return super.onKeyMultiple(paramInt1, paramInt2, paramKeyEvent);
  }
  
  public boolean onKeyShortcut(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyShortcut(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyShortcut(paramInt, paramKeyEvent);
  }
  
  public boolean onKeyUp(int paramInt, KeyEvent paramKeyEvent)
  {
    if (this.a.onKeyUp(paramInt, paramKeyEvent)) {
      return true;
    }
    return super.onKeyUp(paramInt, paramKeyEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tim.fragment.BaseFragmentActivity
 * JD-Core Version:    0.7.0.1
 */