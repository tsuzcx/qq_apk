package com.tencent.mobileqq.multiaio.widget;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.view.ViewGroup;
import com.tencent.mobileqq.activity.recent.RecentBaseData;
import com.tencent.mobileqq.multiaio.MultiAIOItemFragment;
import com.tencent.qphone.base.util.QLog;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MultiAIOPagerAdapter
  extends FragmentStatePagerAdapter
{
  private boolean coS;
  private Fragment mCurrentPrimaryItem;
  private List<RecentBaseData> mDataList;
  
  public MultiAIOPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
  }
  
  private ArrayList<Fragment> i()
  {
    try
    {
      Object localObject = FragmentStatePagerAdapter.class.getDeclaredField("mFragments");
      ((Field)localObject).setAccessible(true);
      localObject = (ArrayList)((Field)localObject).get(this);
      return localObject;
    }
    catch (Exception localException)
    {
      QLog.e("MultiAIOPagerAdapter", 1, "getFragments: ", localException);
    }
    return null;
  }
  
  public void LZ(boolean paramBoolean)
  {
    this.coS = paramBoolean;
  }
  
  public void QS(int paramInt)
  {
    ArrayList localArrayList = i();
    if (localArrayList == null) {
      QLog.e("MultiAIOPagerAdapter", 1, "updateMsgRead: mFragments == null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localArrayList.size())
      {
        Fragment localFragment = (Fragment)localArrayList.get(i);
        if ((localFragment != null) && ((localFragment instanceof MultiAIOItemFragment))) {
          ((MultiAIOItemFragment)localFragment).QS(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public void QT(int paramInt)
  {
    ArrayList localArrayList = i();
    if (localArrayList == null) {
      QLog.e("MultiAIOPagerAdapter", 1, "scrollToNewMsg: mFragments == null");
    }
    for (;;)
    {
      return;
      int i = 0;
      while (i < localArrayList.size())
      {
        Fragment localFragment = (Fragment)localArrayList.get(i);
        if ((localFragment != null) && ((localFragment instanceof MultiAIOItemFragment))) {
          ((MultiAIOItemFragment)localFragment).QT(paramInt);
        }
        i += 1;
      }
    }
  }
  
  public boolean aqQ()
  {
    return this.coS;
  }
  
  public List<RecentBaseData> be()
  {
    return this.mDataList;
  }
  
  public void cS(List<RecentBaseData> paramList)
  {
    if (this.mDataList == null) {
      this.mDataList = new ArrayList();
    }
    this.mDataList.clear();
    this.mDataList.addAll(paramList);
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOPagerAdapter", 2, "destroyItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "], object = [" + paramObject + "]");
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public void finishUpdate(ViewGroup paramViewGroup)
  {
    super.finishUpdate(paramViewGroup);
    this.coS = true;
  }
  
  public int getCount()
  {
    return this.mDataList.size();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiAIOItemFragment localMultiAIOItemFragment = new MultiAIOItemFragment();
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_POSITION", paramInt);
    localMultiAIOItemFragment.setArguments(localBundle);
    return localMultiAIOItemFragment;
  }
  
  public float getPageWidth(int paramInt)
  {
    return super.getPageWidth(paramInt);
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiAIOPagerAdapter", 2, "instantiateItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "]");
    }
    return super.instantiateItem(paramViewGroup, paramInt);
  }
  
  public void setPrimaryItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    super.setPrimaryItem(paramViewGroup, paramInt, paramObject);
    this.mCurrentPrimaryItem = ((Fragment)paramObject);
  }
  
  public void startUpdate(ViewGroup paramViewGroup)
  {
    super.startUpdate(paramViewGroup);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter
 * JD-Core Version:    0.7.0.1
 */