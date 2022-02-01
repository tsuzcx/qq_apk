package com.tencent.biz.pubaccount.readinjoy.view.widget;

import android.content.Context;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v4.app.Fragment;
import android.support.v4.app.Fragment.SavedState;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.PagerAdapter;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.biz.pubaccount.readinjoy.fragment.ReadInJoyBaseFragment;
import com.tencent.biz.pubaccount.readinjoy.struct.TabChannelCoverInfo;
import com.tencent.biz.pubaccount.readinjoy.view.ReadinjoyTabFrame.a;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kxj;
import ldw;

public class ReadInJoyChannelViewPager
  extends ViewPagerCompat
{
  private boolean auk = true;
  
  public ReadInJoyChannelViewPager(Context paramContext)
  {
    super(paramContext);
    initViewPager();
  }
  
  public ReadInJoyChannelViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    initViewPager();
  }
  
  private void initViewPager()
  {
    setOffscreenPageLimit(1);
  }
  
  public boolean onInterceptTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.auk) {
      return super.onInterceptTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (this.auk) {
      return super.onTouchEvent(paramMotionEvent);
    }
    return false;
  }
  
  public void setSlideLeftAndRight(boolean paramBoolean)
  {
    this.auk = paramBoolean;
  }
  
  public static class CustomFragmentPagerAdapter
    extends PagerAdapter
  {
    ReadinjoyTabFrame.a a;
    private List<TabChannelCoverInfo> kB;
    private FragmentTransaction mCurTransaction;
    private Fragment mCurrentPrimaryItem;
    private final FragmentManager mFragmentManager;
    private ArrayList<Fragment> mFragments = new ArrayList();
    private ArrayList<Fragment.SavedState> mSavedState = new ArrayList();
    
    public CustomFragmentPagerAdapter(FragmentManager paramFragmentManager)
    {
      this.mFragmentManager = paramFragmentManager;
      init();
    }
    
    private void a(Fragment paramFragment)
    {
      if ((paramFragment instanceof ReadInJoyBaseFragment))
      {
        kxj.a().clearData();
        paramFragment = (ReadInJoyBaseFragment)paramFragment;
        kxj.a().mB(String.valueOf(paramFragment.nh()));
      }
    }
    
    private Fragment getItem(int paramInt)
    {
      Object localObject;
      if ((paramInt < 0) || (paramInt >= getCount())) {
        localObject = null;
      }
      TabChannelCoverInfo localTabChannelCoverInfo;
      Fragment localFragment;
      do
      {
        return localObject;
        localTabChannelCoverInfo = (TabChannelCoverInfo)this.kB.get(paramInt);
        localFragment = ldw.a().a(localTabChannelCoverInfo);
        localObject = localFragment;
      } while (!(localFragment instanceof ReadInJoyBaseFragment));
      ((ReadInJoyBaseFragment)localFragment).setPos(paramInt);
      ((ReadInJoyBaseFragment)localFragment).a(this.a, localTabChannelCoverInfo.mChannelCoverId);
      return localFragment;
    }
    
    private void init()
    {
      this.kB = new ArrayList();
    }
    
    public Fragment a(int paramInt)
    {
      if (this.mFragments.size() > paramInt) {
        return (Fragment)this.mFragments.get(paramInt);
      }
      return null;
    }
    
    public void a(ReadinjoyTabFrame.a parama)
    {
      this.a = parama;
    }
    
    public Fragment b()
    {
      return this.mCurrentPrimaryItem;
    }
    
    public void clearData()
    {
      try
      {
        this.kB.clear();
        notifyDataSetChanged();
        return;
      }
      catch (Exception localException)
      {
        localException.printStackTrace();
        QLog.d("CustomFragmentPagerAdapter", 1, "clearData exception.");
      }
    }
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramObject = (Fragment)paramObject;
      if (this.mCurTransaction == null) {
        this.mCurTransaction = this.mFragmentManager.beginTransaction();
      }
      QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "destroyItem position = ", Integer.valueOf(paramInt), ", f = ", paramObject });
      while (this.mSavedState.size() <= paramInt) {
        this.mSavedState.add(null);
      }
      ArrayList localArrayList = this.mSavedState;
      if (paramObject.isAdded()) {}
      for (paramViewGroup = this.mFragmentManager.saveFragmentInstanceState(paramObject);; paramViewGroup = null)
      {
        localArrayList.set(paramInt, paramViewGroup);
        this.mFragments.set(paramInt, null);
        this.mCurTransaction.remove(paramObject);
        return;
      }
    }
    
    public void jdMethod_do(List<TabChannelCoverInfo> paramList)
    {
      if ((paramList != null) && (paramList.size() > 0))
      {
        this.kB.clear();
        this.kB.addAll(paramList);
      }
      notifyDataSetChanged();
    }
    
    public void finishUpdate(ViewGroup paramViewGroup)
    {
      if (this.mCurTransaction != null)
      {
        this.mCurTransaction.commitAllowingStateLoss();
        this.mCurTransaction = null;
      }
    }
    
    public int getCount()
    {
      if (this.kB != null) {
        return this.kB.size();
      }
      return 0;
    }
    
    public int getItemPosition(Object paramObject)
    {
      if ((paramObject instanceof ReadInJoyBaseFragment))
      {
        paramObject = (ReadInJoyBaseFragment)paramObject;
        int i = 0;
        while (i < this.kB.size())
        {
          if (((TabChannelCoverInfo)this.kB.get(i)).mChannelCoverId == paramObject.nh())
          {
            int j = paramObject.getPos();
            QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.nh()), ", channelName = ", ((TabChannelCoverInfo)this.kB.get(i)).mChannelCoverName, ", oldPos = ", Integer.valueOf(j), ", newPos = ", Integer.valueOf(i) });
            if (j == i) {
              return -1;
            }
          }
          i += 1;
        }
        QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "getItemPosition, channelID = ", Integer.valueOf(paramObject.nh()), ",  POSITION_NONE" });
      }
      return -2;
    }
    
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
      QLog.d("CustomFragmentPagerAdapter", 2, new Object[] { "instantiateItem position = ", Integer.valueOf(paramInt), ", f = ", localFragment });
      while (this.mFragments.size() <= paramInt) {
        this.mFragments.add(null);
      }
      localFragment.setMenuVisibility(false);
      localFragment.setUserVisibleHint(false);
      this.mFragments.set(paramInt, localFragment);
      this.mCurTransaction.add(paramViewGroup.getId(), localFragment);
      return localFragment;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return ((Fragment)paramObject).getView() == paramView;
    }
    
    public void restoreState(Parcelable paramParcelable, ClassLoader paramClassLoader)
    {
      if (paramParcelable != null)
      {
        paramParcelable = (Bundle)paramParcelable;
        paramParcelable.setClassLoader(paramClassLoader);
        paramClassLoader = paramParcelable.getParcelableArray("states");
        this.mSavedState.clear();
        this.mFragments.clear();
        int i;
        if (paramClassLoader != null)
        {
          i = 0;
          while (i < paramClassLoader.length)
          {
            this.mSavedState.add((Fragment.SavedState)paramClassLoader[i]);
            i += 1;
          }
        }
        paramClassLoader = paramParcelable.keySet().iterator();
        while (paramClassLoader.hasNext())
        {
          String str = (String)paramClassLoader.next();
          if (str.startsWith("f"))
          {
            i = Integer.parseInt(str.substring(1));
            Fragment localFragment = this.mFragmentManager.getFragment(paramParcelable, str);
            if (localFragment != null)
            {
              while (this.mFragments.size() <= i) {
                this.mFragments.add(null);
              }
              localFragment.setMenuVisibility(false);
              this.mFragments.set(i, localFragment);
            }
            else
            {
              Log.w("CustomFragmentPagerAdapter", "Bad fragment at key " + str);
            }
          }
        }
      }
    }
    
    public Parcelable saveState()
    {
      Object localObject1 = null;
      Object localObject2;
      if (this.mSavedState.size() > 0)
      {
        localObject1 = new Bundle();
        localObject2 = new Fragment.SavedState[this.mSavedState.size()];
        this.mSavedState.toArray((Object[])localObject2);
        ((Bundle)localObject1).putParcelableArray("states", (Parcelable[])localObject2);
      }
      int i = 0;
      while (i < this.mFragments.size())
      {
        Fragment localFragment = (Fragment)this.mFragments.get(i);
        localObject2 = localObject1;
        if (localFragment != null)
        {
          localObject2 = localObject1;
          if (localFragment.isAdded())
          {
            localObject2 = localObject1;
            if (localObject1 == null) {
              localObject2 = new Bundle();
            }
            localObject1 = "f" + i;
            this.mFragmentManager.putFragment((Bundle)localObject2, (String)localObject1, localFragment);
          }
        }
        i += 1;
        localObject1 = localObject2;
      }
      return localObject1;
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
        a(this.mCurrentPrimaryItem);
      }
    }
    
    public void startUpdate(ViewGroup paramViewGroup)
    {
      if (paramViewGroup.getId() == -1) {
        throw new IllegalStateException("ViewPager with adapter " + this + " requires a view id");
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.view.widget.ReadInJoyChannelViewPager
 * JD-Core Version:    0.7.0.1
 */