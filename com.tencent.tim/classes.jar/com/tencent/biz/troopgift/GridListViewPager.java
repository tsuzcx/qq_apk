package com.tencent.biz.troopgift;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.GridView;
import android.widget.ListAdapter;
import java.util.ArrayList;
import snb;
import wja;

public class GridListViewPager
  extends absMultiViewPager
{
  protected String aES;
  public TroopGiftPanel b;
  protected int bxS = 4;
  protected int bxT = 2;
  protected int mDisplayWidth;
  
  public GridListViewPager(Context paramContext)
  {
    super(paramContext);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.mDisplayWidth = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public GridListViewPager(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    paramContext = paramContext.getResources().getDisplayMetrics();
    this.mDisplayWidth = Math.min(paramContext.heightPixels, paramContext.widthPixels);
  }
  
  public View a(int paramInt, ArrayList<Object> paramArrayList)
  {
    GridListViewPager.1 local1 = new GridListViewPager.1(this, getContext());
    local1.setLayoutParams(new ViewGroup.LayoutParams(-1, -2));
    local1.setVerticalSpacing(0);
    local1.setHorizontalSpacing(10);
    local1.setColumnWidth(this.mDisplayWidth / this.bxS - 40);
    local1.setNumColumns(this.bxS);
    Object localObject = getContext().getResources();
    local1.setPadding(wja.dp2px(5.0F, (Resources)localObject), wja.dp2px(1.0F, (Resources)localObject), wja.dp2px(5.0F, (Resources)localObject), wja.dp2px(1.0F, (Resources)localObject));
    local1.setGravity(1);
    local1.setSelector(new ColorDrawable(0));
    localObject = new snb(getContext(), this.b);
    ((snb)localObject).setData(paramArrayList);
    ((snb)localObject).tq(this.aES);
    local1.setAdapter((ListAdapter)localObject);
    local1.setOnItemClickListener(this);
    ((snb)localObject).notifyDataSetChanged();
    return local1;
  }
  
  public ArrayList<Object> m(int paramInt)
  {
    if (paramInt == this.byt - 1) {
      return a(this.mData, this.bxS * this.bxT * paramInt, this.mData.size());
    }
    return a(this.mData, this.bxS * this.bxT * paramInt, (paramInt + 1) * (this.bxS * this.bxT));
  }
  
  public void refreshUI()
  {
    ArrayList localArrayList = ((absMultiViewPager.ViewPagerAdapter)getAdapter()).getData();
    int i = 0;
    while (i < localArrayList.size())
    {
      ((snb)((GridView)localArrayList.get(i)).getAdapter()).notifyDataSetChanged();
      i += 1;
    }
  }
  
  public void setGridGiftIcon(String paramString)
  {
    this.aES = paramString;
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    int j = 1;
    int i = 0;
    if (this.bxS != paramInt1)
    {
      this.bxS = paramInt1;
      i = 1;
    }
    if (this.bxT != paramInt2) {
      this.bxT = paramInt2;
    }
    for (paramInt1 = j;; paramInt1 = i)
    {
      if (paramInt1 != 0) {
        bzI();
      }
      return;
    }
  }
  
  public int ul()
  {
    int j = this.mData.size() / (this.bxS * this.bxT);
    int i = j;
    if (this.mData.size() % (this.bxS * this.bxT) > 0) {
      i = j + 1;
    }
    return i;
  }
  
  public View z(int paramInt)
  {
    return a(paramInt, m(paramInt));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.troopgift.GridListViewPager
 * JD-Core Version:    0.7.0.1
 */