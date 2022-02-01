package com.tencent.mobileqq.richmedia.capture.adapter;

import alvw;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import com.tencent.mobileqq.richmedia.capture.data.FilterCategory;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import wja;

public class FilterProviderPagerAdapter
  extends PagerAdapter
{
  public static final int dyn = wja.dp2px(7.0F, BaseApplication.getContext().getResources());
  public static final int dyo = wja.dp2px(0.0F, BaseApplication.getContext().getResources());
  private List<FilterCategory> Ay = new CopyOnWriteArrayList();
  boolean czH = true;
  public SparseArray<GridView> jdField_do = new SparseArray();
  private AdapterView.c h;
  private Context mContext;
  
  public FilterProviderPagerAdapter(Context paramContext, boolean paramBoolean)
  {
    this.mContext = paramContext;
    this.czH = paramBoolean;
  }
  
  public void b(AdapterView.c paramc)
  {
    this.h = paramc;
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_do.get(paramInt));
  }
  
  public int getCount()
  {
    return this.Ay.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("FilterProviderPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    Object localObject2 = (GridView)this.jdField_do.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.mContext);
      ((GridView)localObject1).setNumColumns(4);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(dyo);
      ((GridView)localObject1).setHorizontalSpacing(dyo);
      ((GridView)localObject1).setClipToPadding(false);
      ((GridView)localObject1).setPadding(dyn, dyn, dyn, dyn * 4);
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new alvw(this.mContext, this.czH);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
      if (paramInt < this.Ay.size()) {
        ((alvw)localObject2).setData(((FilterCategory)this.Ay.get(paramInt)).Fv);
      }
      ((GridView)localObject1).setOnItemClickListener(this.h);
      this.jdField_do.put(paramInt, localObject1);
    }
    paramViewGroup.addView((View)localObject1, -1, -1);
    return localObject1;
  }
  
  public boolean isViewFromObject(View paramView, Object paramObject)
  {
    return paramView == paramObject;
  }
  
  public void lV(List<FilterCategory> paramList)
  {
    this.Ay.clear();
    this.Ay.addAll(paramList);
    notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richmedia.capture.adapter.FilterProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */