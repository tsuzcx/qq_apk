package com.tencent.mobileqq.search.adapter;

import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.mobileqq.search.fragment.ActiveEntitySearchFragment;
import com.tencent.qphone.base.util.QLog;
import java.util.List;

public class GroupSearchPagerAdapter
  extends PagerAdapter
{
  List<Fragment> bU;
  private FragmentTransaction mCurTransaction;
  private Fragment mCurrentPrimaryItem;
  private final FragmentManager mFragmentManager;
  
  private static String makeFragmentName(int paramInt, long paramLong)
  {
    return "android:switcher:" + paramInt + ":" + paramLong;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    if ((paramObject instanceof ActiveEntitySearchFragment)) {
      QLog.i("Q.uniteSearch.", 2, "Detaching item hash = " + paramObject.hashCode() + "  Detaching item name:" + ((ActiveEntitySearchFragment)paramObject).name);
    }
    this.mCurTransaction.remove((Fragment)paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    if (this.mCurTransaction != null)
    {
      this.mCurTransaction.commitAllowingStateLoss();
      this.mCurTransaction = null;
      this.mFragmentManager.executePendingTransactions();
    }
  }
  
  public int getCount()
  {
    if (this.bU == null) {
      return 0;
    }
    return this.bU.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    if ((this.bU == null) || (paramInt < 0) || (this.bU.size() <= paramInt))
    {
      QLog.e("GroupSearchPagerAdapter", 2, "error! fragments==null || position<0 || fragments.size()<=position !");
      return ActiveEntitySearchFragment.a(0, new long[] { 0L }, "", "");
    }
    return (Fragment)this.bU.get(paramInt);
  }
  
  public long getItemId(int paramInt)
  {
    if ((this.bU.get(paramInt) instanceof ActiveEntitySearchFragment)) {
      return ((Fragment)this.bU.get(paramInt)).hashCode();
    }
    return paramInt;
  }
  
  public int getItemPosition(Object paramObject)
  {
    int i = 0;
    while (i < this.bU.size())
    {
      if (paramObject == this.bU.get(i)) {
        return i;
      }
      i += 1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (this.mCurTransaction == null) {
      this.mCurTransaction = this.mFragmentManager.beginTransaction();
    }
    long l = getItemId(paramInt);
    Object localObject = makeFragmentName(paramViewGroup.getId(), l);
    localObject = this.mFragmentManager.findFragmentByTag((String)localObject);
    if (localObject != null)
    {
      if ((localObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "Attaching item hash = " + ((Fragment)localObject).hashCode() + "   Attaching item  name:" + ((ActiveEntitySearchFragment)localObject).name);
      }
      this.mCurTransaction.attach((Fragment)localObject);
    }
    for (paramViewGroup = (ViewGroup)localObject;; paramViewGroup = (ViewGroup)localObject)
    {
      if (paramViewGroup != this.mCurrentPrimaryItem)
      {
        paramViewGroup.setMenuVisibility(false);
        paramViewGroup.setUserVisibleHint(false);
      }
      return paramViewGroup;
      localObject = getItem(paramInt);
      if ((localObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "Adding item hash = " + ((Fragment)localObject).hashCode() + "   Adding item  name:" + ((ActiveEntitySearchFragment)localObject).name);
      }
      this.mCurTransaction.add(paramViewGroup.getId(), (Fragment)localObject, makeFragmentName(paramViewGroup.getId(), l));
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return ((Fragment)paramObject).getView() == paramView;
  }
  
  public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader) {}
  
  public Parcelable saveState()
  {
    return null;
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
      if ((paramObject instanceof ActiveEntitySearchFragment)) {
        QLog.i("Q.uniteSearch.", 2, "setPrimaryItem hash = " + paramObject.hashCode() + "  pos=" + paramInt + "  setPrimaryItem name:" + ((ActiveEntitySearchFragment)paramObject).name);
      }
      this.mCurrentPrimaryItem = paramViewGroup;
    }
  }
  
  public void startUpdate(ViewGroup paramViewGroup) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.adapter.GroupSearchPagerAdapter
 * JD-Core Version:    0.7.0.1
 */