package com.tencent.mobileqq.multicard;

import ajjj;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.ViewGroup;
import com.tencent.mobileqq.multiaio.widget.MultiAIOPagerAdapter;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class MultiCardPagerAdapter
  extends MultiAIOPagerAdapter
{
  private ajjj a;
  private FragmentManager mFragmentManager;
  
  public MultiCardPagerAdapter(FragmentManager paramFragmentManager)
  {
    super(paramFragmentManager);
    this.mFragmentManager = paramFragmentManager;
  }
  
  public void a(ajjj paramajjj)
  {
    this.a = paramajjj;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardPagerAdapter", 2, "destroyItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "], object = [" + paramObject + "]");
    }
    super.destroyItem(paramViewGroup, paramInt, paramObject);
  }
  
  public int getCount()
  {
    if (this.a == null) {
      return 0;
    }
    return this.a.Go();
  }
  
  public Fragment getItem(int paramInt)
  {
    MultiCardItemFragment localMultiCardItemFragment = new MultiCardItemFragment();
    if (this.a != null) {
      localMultiCardItemFragment.a(this.a.mApp, paramInt, this.a.a(paramInt), this.a.xq());
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("KEY_POSITION", paramInt);
    localMultiCardItemFragment.setArguments(localBundle);
    return localMultiCardItemFragment;
  }
  
  public int getItemPosition(Object paramObject)
  {
    if (((paramObject instanceof MultiCardItemFragment)) && (((MultiCardItemFragment)paramObject).getPosition() < getCount())) {
      return -1;
    }
    return -2;
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("MultiCardPagerAdapter", 2, "instantiateItem() called with: container = [" + paramViewGroup + "], position = [" + paramInt + "]");
    }
    return super.instantiateItem(paramViewGroup, paramInt);
  }
  
  public void updateData()
  {
    if ((this.mFragmentManager == null) || (this.a == null)) {}
    for (;;)
    {
      return;
      Object localObject1 = this.mFragmentManager.getFragments();
      if (localObject1 != null)
      {
        localObject1 = ((List)localObject1).iterator();
        while (((Iterator)localObject1).hasNext())
        {
          Object localObject2 = (Fragment)((Iterator)localObject1).next();
          if ((localObject2 instanceof MultiCardItemFragment))
          {
            localObject2 = (MultiCardItemFragment)localObject2;
            int i = ((MultiCardItemFragment)localObject2).getPosition();
            if (i < getCount()) {
              ((MultiCardItemFragment)localObject2).b(this.a.a(i));
            }
          }
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.multicard.MultiCardPagerAdapter
 * JD-Core Version:    0.7.0.1
 */