package com.tencent.mobileqq.nearby.widget;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import java.lang.ref.SoftReference;
import java.util.ArrayList;
import java.util.List;

public abstract class AvatarWallPagerAdapter<T>
{
  protected final List<T> DZ = new ArrayList();
  protected AvatarWallPagerAdapter<T>.InnerPagerAdapter a;
  protected AvatarWallViewPager b;
  protected boolean csA;
  protected SoftReference<View> y;
  protected SoftReference<View> z;
  
  public AvatarWallPagerAdapter(AvatarWallViewPager paramAvatarWallViewPager)
  {
    this.b = paramAvatarWallViewPager;
    this.a = new InnerPagerAdapter();
  }
  
  public int GS()
  {
    return this.DZ.size();
  }
  
  protected PagerAdapter a()
  {
    return this.a;
  }
  
  public abstract View a(int paramInt, T paramT);
  
  public abstract View a(boolean paramBoolean, int paramInt);
  
  public boolean c(T paramT1, T paramT2)
  {
    if ((paramT1 == null) || (paramT2 == null)) {
      return false;
    }
    return paramT1.equals(paramT2);
  }
  
  protected int it(int paramInt)
  {
    int i = GS();
    if (i <= 1) {}
    do
    {
      return 0;
      if (paramInt == 0) {
        return i - 3;
      }
    } while (paramInt == i - 1);
    return paramInt - 1;
  }
  
  public void lG(List<T> paramList)
  {
    if (this.csA) {
      return;
    }
    this.z = null;
    this.y = null;
    this.DZ.clear();
    if (paramList != null) {
      this.DZ.addAll(paramList);
    }
    if ((this.DZ.size() > 1) || ((this.DZ.size() == 1) && (this.b.csC)))
    {
      int i = paramList.size();
      this.DZ.add(paramList.get(0));
      this.DZ.add(0, paramList.get(i - 1));
    }
    this.b.dBD();
    this.a.notifyDataSetChanged();
    this.b.a().setCurrentItem(1);
  }
  
  public void onDetached()
  {
    this.csA = true;
    this.b = null;
    this.z = null;
    this.y = null;
  }
  
  public void w(int paramInt, View paramView) {}
  
  public class InnerPagerAdapter
    extends PagerAdapter
  {
    List<Integer> Ea = new ArrayList();
    
    protected InnerPagerAdapter() {}
    
    public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
    {
      paramViewGroup.removeView((View)paramObject);
      AvatarWallPagerAdapter.this.w(AvatarWallPagerAdapter.this.it(paramInt), (View)paramObject);
    }
    
    public int getCount()
    {
      return AvatarWallPagerAdapter.this.DZ.size();
    }
    
    public int getItemPosition(Object paramObject)
    {
      paramObject = (AvatarWallPagerAdapter.a)((View)paramObject).getTag(2131379193);
      int i = 0;
      while (i < AvatarWallPagerAdapter.this.DZ.size())
      {
        if ((AvatarWallPagerAdapter.this.c(paramObject.data, AvatarWallPagerAdapter.this.DZ.get(i))) && (!this.Ea.contains(Integer.valueOf(i))))
        {
          this.Ea.add(Integer.valueOf(i));
          return i;
        }
        i += 1;
      }
      return -2;
    }
    
    public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
    {
      int i = getCount();
      if (i > 1) {
        if (paramInt == 1) {
          if (paramViewGroup == null)
          {
            if ((AvatarWallPagerAdapter.this.y == null) || (AvatarWallPagerAdapter.this.y.get() == null) || (((View)AvatarWallPagerAdapter.this.y.get()).getParent() != null)) {
              break label327;
            }
            paramViewGroup = AvatarWallPagerAdapter.this.y.get();
          }
        }
      }
      View localView;
      label327:
      do
      {
        do
        {
          return paramViewGroup;
          if ((AvatarWallPagerAdapter.this.y == null) || (AvatarWallPagerAdapter.this.y.get() == null) || (((View)AvatarWallPagerAdapter.this.y.get()).getParent() != null))
          {
            localView = (View)instantiateItem(null, paramInt);
            AvatarWallPagerAdapter.this.y = new SoftReference(localView);
          }
          for (;;)
          {
            paramViewGroup.addView(localView);
            return localView;
            localView = (View)AvatarWallPagerAdapter.this.y.get();
          }
          if (paramInt == i - 2) {
            if (paramViewGroup == null)
            {
              if ((AvatarWallPagerAdapter.this.z != null) && (AvatarWallPagerAdapter.this.z.get() != null) && (((View)AvatarWallPagerAdapter.this.z.get()).getParent() == null)) {
                return AvatarWallPagerAdapter.this.z;
              }
            }
            else
            {
              if ((AvatarWallPagerAdapter.this.z == null) || (AvatarWallPagerAdapter.this.z.get() == null) || (((View)AvatarWallPagerAdapter.this.z.get()).getParent() != null))
              {
                localView = (View)instantiateItem(null, paramInt);
                AvatarWallPagerAdapter.this.z = new SoftReference(localView);
              }
              for (;;)
              {
                paramViewGroup.addView(localView);
                return localView;
                localView = (View)AvatarWallPagerAdapter.this.z.get();
              }
            }
          }
          localView = AvatarWallPagerAdapter.this.a(AvatarWallPagerAdapter.this.it(paramInt), AvatarWallPagerAdapter.this.DZ.get(paramInt));
          localView.setTag(2131379193, new AvatarWallPagerAdapter.a(AvatarWallPagerAdapter.this, AvatarWallPagerAdapter.this.DZ.get(paramInt)));
          if (paramViewGroup != null)
          {
            paramViewGroup.addView(localView);
            return localView;
          }
          paramViewGroup = localView;
        } while (i <= 1);
        if (paramInt == 1)
        {
          AvatarWallPagerAdapter.this.y = new SoftReference(localView);
          return localView;
        }
        paramViewGroup = localView;
      } while (paramInt != i - 2);
      AvatarWallPagerAdapter.this.z = new SoftReference(localView);
      return localView;
    }
    
    public boolean isViewFromObject(View paramView, Object paramObject)
    {
      return paramView == paramObject;
    }
    
    public void notifyDataSetChanged()
    {
      this.Ea.clear();
      super.notifyDataSetChanged();
    }
  }
  
  public class a
  {
    public T data;
    
    public a()
    {
      Object localObject;
      this.data = localObject;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.widget.AvatarWallPagerAdapter
 * JD-Core Version:    0.7.0.1
 */