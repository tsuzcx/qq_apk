package com.tencent.mobileqq.activity.contacts.base.tabs;

import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;

public abstract class CustomFragmentStatePagerAdapter
  extends PagerAdapter
{
  private FragmentTransaction mCurTransaction;
  private Fragment mCurrentPrimaryItem;
  private final FragmentManager mFragmentManager;
  private ArrayList<Fragment> mFragments = new ArrayList();
  private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
  
  public CustomFragmentStatePagerAdapter(FragmentManager paramFragmentManager)
  {
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void cleanCache()
  {
    this.mSavedState.clear();
    this.mFragments.clear();
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    Fragment localFragment = (Fragment)paramObject;
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    if (QLog.isColorLevel()) {
      QLog.d("FragmentStatePagerAdapter", 2, "Removing item #" + paramInt + ": f=" + paramObject + " v=" + ((Fragment)paramObject).getView());
    }
    while (this.mSavedState.size() <= paramInt) {
      this.mSavedState.add(null);
    }
    paramObject = this.mSavedState;
    if (localFragment.isAdded()) {}
    for (paramViewGroup = this.mFragmentManager.saveFragmentInstanceState(localFragment);; paramViewGroup = null)
    {
      paramObject.set(paramInt, paramViewGroup);
      if ((paramInt >= 0) && (paramInt < this.mFragments.size())) {
        this.mFragments.set(paramInt, null);
      }
      this.mCurTransaction.remove(localFragment);
      return;
    }
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitAllowingStateLoss();
      this.mCurTransaction = null;
    }
  }
  
  public abstract Fragment getItem(int paramInt);
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mFragments.size() > paramInt)
    {
      localFragment = (Fragment)this.mFragments.get(paramInt);
      if (localFragment != null) {
        return localFragment;
      }
    }
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    Fragment localFragment = getItem(paramInt);
    if (QLog.isColorLevel()) {
      QLog.d("FragmentStatePagerAdapter", 2, "Adding item #" + paramInt + ": f=" + localFragment);
    }
    if (localFragment != null)
    {
      if (this.mSavedState.size() > paramInt)
      {
        Fragment.SavedState localSavedState = (Fragment.SavedState)this.mSavedState.get(paramInt);
        if (localSavedState != null) {
          localFragment.setInitialSavedState(localSavedState);
        }
      }
      while (this.mFragments.size() <= paramInt) {
        this.mFragments.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.mFragments.set(paramInt, localFragment);
      if (!localFragment.isAdded()) {
        this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
      }
    }
    return localFragment;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
  {
    Bundle localBundle;
    int i;
    String str;
    if (paramParcelable != null)
    {
      QLog.d("FragmentStatePagerAdapter", 2, "restoreState");
      localBundle = (Bundle)paramParcelable;
      localBundle.setClassLoader(paramClassLoader);
      paramParcelable = localBundle.getParcelableArray("states");
      this.mSavedState.clear();
      this.mFragments.clear();
      if (paramParcelable != null)
      {
        i = 0;
        while (i < paramParcelable.length)
        {
          this.mSavedState.add((Fragment.SavedState)paramParcelable[i]);
          i += 1;
        }
      }
      paramClassLoader = localBundle.keySet().iterator();
      while (paramClassLoader.hasNext())
      {
        str = (String)paramClassLoader.next();
        if (str.startsWith("f")) {
          i = Integer.parseInt(str.substring(1));
        }
      }
    }
    for (;;)
    {
      try
      {
        if (this.mFragmentManager.getFragments() == null) {
          break label296;
        }
        paramParcelable = this.mFragmentManager.getFragment(localBundle, str);
        if (paramParcelable == null) {
          break label266;
        }
        if (this.mFragments.size() <= i)
        {
          this.mFragments.add(null);
          continue;
        }
      }
      catch (Exception paramParcelable)
      {
        QLog.e("FragmentStatePagerAdapter", 1, "restoreState error: " + paramParcelable.getMessage());
        paramParcelable = null;
        continue;
        paramParcelable.setMenuVisibility(false);
        this.mFragments.set(i, paramParcelable);
        QLog.d("FragmentStatePagerAdapter", 2, "restoreState key: " + str + "  " + paramParcelable);
      }
      break;
      label266:
      QLog.d("FragmentStatePagerAdapter", 2, "Bad fragment at key " + str);
      break;
      return;
      label296:
      paramParcelable = null;
    }
  }
  
  public Parcelable saveState()
  {
    Object localObject1 = null;
    if (this.mSavedState.size() > 0)
    {
      localObject1 = new Bundle();
      localObject2 = new Fragment.SavedState[this.mSavedState.size()];
      this.mSavedState.toArray((Object[])localObject2);
      ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
    }
    int i = 0;
    Object localObject2 = localObject1;
    for (;;)
    {
      if (i < this.mFragments.size())
      {
        Fragment localFragment = (Fragment)this.mFragments.get(i);
        localObject1 = localObject2;
        if (localFragment != null)
        {
          localObject1 = localObject2;
          if (localFragment.isAdded())
          {
            localObject1 = localObject2;
            if (localObject2 == null) {
              localObject1 = new Bundle();
            }
            localObject2 = "f" + i;
            QLog.d("FragmentStatePagerAdapter", 2, "saveState key: " + (String)localObject2 + "  " + localFragment);
          }
        }
        try
        {
          this.mFragmentManager.putFragment((Bundle)localObject1, (String)localObject2, localFragment);
          i += 1;
          localObject2 = localObject1;
        }
        catch (Exception localException)
        {
          for (;;)
          {
            QLog.e("FragmentStatePagerAdapter", 1, "saveState error: " + localException.getMessage());
          }
        }
      }
    }
    return localException;
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup = (Fragment)paramObject;
    if (paramViewGroup != this.mCurrentPrimaryItem)
    {
      if (this.mCurrentPrimaryItem != null)
      {
        this.mCurrentPrimaryItem.setMenuVisibility(false);
        this.mCurrentPrimaryItem.setUserVisibleHint(false);
      }
      if (paramViewGroup != null)
      {
        paramViewGroup.setMenuVisibility(true);
        paramViewGroup.setUserVisibleHint(true);
      }
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    if (paramViewGroup.getId() == -1) {
      throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.contacts.base.tabs.CustomFragmentStatePagerAdapter
 * JD-Core Version:    0.7.0.1
 */