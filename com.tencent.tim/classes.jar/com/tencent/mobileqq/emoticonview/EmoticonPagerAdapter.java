package com.tencent.mobileqq.emoticonview;

import afnq;
import afnw;
import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;
import com.tencent.qphone.base.util.QLog;
import java.util.Iterator;
import java.util.List;

public class EmoticonPagerAdapter
  extends PagerAdapter
{
  private boolean bZf = true;
  private List<afnw> zX;
  
  public void ap(List<afnw> paramList, boolean paramBoolean)
  {
    this.bZf = false;
    this.zX = paramList;
    if (paramBoolean) {
      super.notifyDataSetChanged();
    }
  }
  
  public void destroy()
  {
    if (this.zX != null)
    {
      Iterator localIterator = this.zX.iterator();
      while (localIterator.hasNext()) {
        ((afnw)localIterator.next()).destroy();
      }
      this.zX = null;
    }
    afnq.daU();
  }
  
  public void destroyItem(View paramView, int paramInt, Object paramObject)
  {
    if (QLog.isColorLevel()) {
      QLog.d("EmoticonPagerAdapter", 2, "[RecycleView] destroyItem, position=" + paramInt + ", viewRecycleable=" + this.bZf);
    }
    ((ViewGroup)paramView).removeView((View)paramObject);
    if (!this.bZf) {}
    for (;;)
    {
      return;
      paramView = this.zX.iterator();
      int i;
      for (int j = 0; paramView.hasNext(); j = i)
      {
        paramObject = (afnw)paramView.next();
        i = j;
        if (paramObject != null)
        {
          i = j;
          if ((paramObject instanceof afnq))
          {
            paramObject = (afnq)paramObject;
            int k = paramObject.Ad();
            j += k;
            i = j;
            if (paramInt + 1 <= j)
            {
              i = k - (j - paramInt);
              if (QLog.isColorLevel()) {
                QLog.d("EmoticonPagerAdapter", 2, "[RecycleView] destroyItem, position=" + paramInt + ", viewBinder=" + paramObject + ", innerIndex=" + i);
              }
              paramObject.MO(i);
              return;
            }
          }
        }
      }
    }
  }
  
  public int getCount()
  {
    int j;
    if ((this.zX == null) || (this.zX.size() == 0)) {
      j = 0;
    }
    Iterator localIterator;
    int i;
    do
    {
      return j;
      localIterator = this.zX.iterator();
      i = 0;
      j = i;
    } while (!localIterator.hasNext());
    afnw localafnw = (afnw)localIterator.next();
    if ((localafnw != null) && ((localafnw instanceof afnq))) {
      i += ((afnq)localafnw).Ad();
    }
    for (;;)
    {
      break;
    }
  }
  
  public int getItemPosition(Object paramObject)
  {
    return -2;
  }
  
  public Object instantiateItem(View paramView, int paramInt)
  {
    long l = System.currentTimeMillis();
    Object localObject1 = this.zX.iterator();
    int j = 0;
    Object localObject2;
    int i;
    int k;
    if (((Iterator)localObject1).hasNext())
    {
      localObject2 = (afnw)((Iterator)localObject1).next();
      i = j;
      if (localObject2 != null)
      {
        i = j;
        if ((localObject2 instanceof afnq))
        {
          localObject2 = (afnq)localObject2;
          k = ((afnq)localObject2).Ad();
          j += k;
          i = j;
          if (paramInt + 1 > j) {}
        }
      }
    }
    for (localObject1 = ((afnq)localObject2).J(k - (j - paramInt));; localObject1 = null)
    {
      if ((localObject1 != null) && (((View)localObject1).getParent() != paramView) && (paramInt < getCount())) {
        ((ViewGroup)paramView).addView((View)localObject1);
      }
      if (QLog.isColorLevel()) {
        QLog.d("EmoticonPagerAdapter", 2, "[Performance] instantiateItem, position=" + paramInt + ", duration=" + (System.currentTimeMillis() - l));
      }
      return localObject1;
      j = i;
      break;
    }
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void kv(List<afnw> paramList)
  {
    ap(paramList, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.emoticonview.EmoticonPagerAdapter
 * JD-Core Version:    0.7.0.1
 */