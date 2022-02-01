package dov.com.qq.im.capture.adapter;

import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.support.v4.view.PagerAdapter;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListAdapter;
import aqnm;
import axpg;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.GridView;
import dov.com.qq.im.capture.data.FilterCategory;
import java.util.ArrayList;
import wja;

public class TransitionProviderPagerAdapter
  extends PagerAdapter
{
  public static final int dyn = aqnm.dpToPx(7.0F);
  public static final int dyo = aqnm.dpToPx(0.0F);
  private ArrayList<FilterCategory> FN;
  public SparseArray<GridView> jdField_do = new SparseArray();
  public int eCJ;
  private AdapterView.c h;
  private Context mContext;
  
  public TransitionProviderPagerAdapter(Context paramContext, int paramInt)
  {
    this.mContext = paramContext;
    this.eCJ = paramInt;
  }
  
  public void b(AdapterView.c paramc)
  {
    this.h = paramc;
  }
  
  public void dLo()
  {
    if (this.jdField_do != null)
    {
      int i = 0;
      while (i < this.jdField_do.size())
      {
        GridView localGridView = (GridView)this.jdField_do.valueAt(i);
        if ((localGridView != null) && ((localGridView.getAdapter() instanceof axpg))) {
          ((axpg)localGridView.getAdapter()).dLo();
        }
        i += 1;
      }
    }
  }
  
  public void destroyItem(ViewGroup paramViewGroup, int paramInt, Object paramObject)
  {
    paramViewGroup.removeView((View)this.jdField_do.get(paramInt));
  }
  
  public void fC(ArrayList<FilterCategory> paramArrayList)
  {
    this.FN = paramArrayList;
  }
  
  public int getCount()
  {
    if (this.FN == null) {
      return 0;
    }
    return this.FN.size();
  }
  
  public Object instantiateItem(ViewGroup paramViewGroup, int paramInt)
  {
    if (QLog.isColorLevel()) {
      QLog.d("TransitionProviderPagerAdapter", 2, "instantiateItem position = " + paramInt);
    }
    Object localObject2 = (GridView)this.jdField_do.get(paramInt);
    Object localObject1 = localObject2;
    if (localObject2 == null)
    {
      localObject1 = new GridView(this.mContext);
      ((GridView)localObject1).setNumColumns(3);
      ((GridView)localObject1).setSelector(new ColorDrawable(0));
      ((GridView)localObject1).setVerticalSpacing(dyo);
      ((GridView)localObject1).setHorizontalSpacing(dyo);
      ((GridView)localObject1).setClipToPadding(false);
      ((GridView)localObject1).setPadding(dyn, dyn, dyn, dyn + dyn + wja.dp2px(36.0F, this.mContext.getResources()));
      ((GridView)localObject1).setVerticalScrollBarEnabled(false);
      localObject2 = new axpg(this.mContext, this.eCJ);
      ((axpg)localObject2).setData(((FilterCategory)this.FN.get(paramInt)).Fv);
      ((GridView)localObject1).setAdapter((ListAdapter)localObject2);
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
  
  public void onDestroy()
  {
    if (this.jdField_do != null)
    {
      int i = 0;
      while (i < this.jdField_do.size())
      {
        GridView localGridView = (GridView)this.jdField_do.valueAt(i);
        if ((localGridView != null) && ((localGridView.getAdapter() instanceof axpg))) {
          ((axpg)localGridView.getAdapter()).onDestroy();
        }
        i += 1;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     dov.com.qq.im.capture.adapter.TransitionProviderPagerAdapter
 * JD-Core Version:    0.7.0.1
 */