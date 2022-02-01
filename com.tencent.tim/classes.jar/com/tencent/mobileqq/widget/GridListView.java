package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.ListAdapter;
import arfu;
import arfv;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AbsListView.LayoutParams;
import com.tencent.widget.AdapterView.c;
import com.tencent.widget.XListView;

@Deprecated
public class GridListView
  extends XListView
{
  public b a;
  public c a;
  boolean dag = false;
  int egg = 4;
  int egh = 0;
  int egi;
  int egj = -2;
  int egk = -2;
  int egl;
  View.OnClickListener gf;
  public AdapterView.c i;
  View mEmptyView = new View(getContext());
  int mHorizontalSpacing;
  int mMode = 0;
  int mVerticalSpacing;
  
  public GridListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c = new c();
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c = new c();
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c = new c();
  }
  
  private void Yt(int paramInt)
  {
    if (this.egi != paramInt) {
      Yu(paramInt);
    }
  }
  
  private void Yu(int paramInt)
  {
    this.egi = paramInt;
    this.egh = this.egi;
    if (this.mMode == 1) {
      this.egh = ((this.egi + this.egg - 1) / this.egg);
    }
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    if (paramListAdapter == null) {
      return;
    }
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b = ((b)paramListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.registerDataSetObserver(new arfu(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.setMode(this.mMode);
    this.egl = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.zu();
    Yt(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.getCount());
    super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c);
  }
  
  public void setEmptyView(View paramView)
  {
    this.mEmptyView = paramView;
    if (this.egi == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetChanged();
    }
  }
  
  public void setEnableAverageLayout(boolean paramBoolean)
  {
    this.dag = paramBoolean;
  }
  
  public void setGridSize(int paramInt)
  {
    setGridSize(paramInt, paramInt);
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.egj != paramInt1) || (this.egk != paramInt2))
    {
      this.egj = paramInt1;
      this.egk = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetChanged();
    }
  }
  
  public void setGridSpacing(int paramInt1, int paramInt2)
  {
    if ((this.mHorizontalSpacing != paramInt1) || (this.mVerticalSpacing != paramInt2))
    {
      this.mHorizontalSpacing = paramInt1;
      this.mVerticalSpacing = paramInt2;
      if (this.mMode == 1) {
        setPadding(0, 0, 0, this.mVerticalSpacing);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.mMode != paramInt)
    {
      this.mMode = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.setMode(this.mMode);
        Yu(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.getCount());
      }
      if (this.mMode != 1) {
        break label71;
      }
    }
    label71:
    for (paramInt = this.mVerticalSpacing;; paramInt = 0)
    {
      setPadding(0, 0, 0, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$c.notifyDataSetChanged();
      return;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.egg)
    {
      this.egg = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b != null) {
        Yt(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$b.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.c paramc)
  {
    this.i = paramc;
    if (this.gf == null) {
      this.gf = new arfv(this);
    }
  }
  
  static class a
  {
    View[] v = new View[12];
  }
  
  public static abstract class b
    extends BaseAdapter
  {
    protected int mMode = 0;
    
    public abstract int fT(int paramInt);
    
    public abstract int fU(int paramInt);
    
    void setMode(int paramInt)
    {
      this.mMode = paramInt;
    }
    
    public abstract int zu();
  }
  
  public class c
    extends BaseAdapter
  {
    public c() {}
    
    private LinearLayout a(ViewGroup paramViewGroup)
    {
      paramViewGroup = new LinearLayout(GridListView.this.getContext());
      paramViewGroup.setOrientation(0);
      paramViewGroup.setClickable(false);
      paramViewGroup.setLongClickable(false);
      paramViewGroup.setTag(new GridListView.a(null));
      return paramViewGroup;
    }
    
    public int getCount()
    {
      if (GridListView.this.egh == 0)
      {
        if (GridListView.this.mEmptyView != null) {
          return 1;
        }
        return 0;
      }
      return GridListView.this.egh;
    }
    
    public Object getItem(int paramInt)
    {
      return null;
    }
    
    public long getItemId(int paramInt)
    {
      return 0L;
    }
    
    public int getItemViewType(int paramInt)
    {
      if (GridListView.this.egh == 0) {
        return 0;
      }
      if (GridListView.this.mMode == 0) {
        return GridListView.this.a.getItemViewType(paramInt) + 2;
      }
      return 1;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      Object localObject2;
      Object localObject1;
      if (GridListView.this.egh == 0)
      {
        GridListView.this.mEmptyView.setLayoutParams(new AbsListView.LayoutParams(GridListView.this.getWidth(), GridListView.this.getHeight()));
        localObject2 = GridListView.this.mEmptyView;
        localObject1 = paramView;
        EventCollector.getInstance().onListGetView(paramInt, (View)localObject1, paramViewGroup, getItemId(paramInt));
        return localObject2;
      }
      int i;
      int j;
      GridListView.a locala;
      int k;
      label167:
      int m;
      int n;
      if (GridListView.this.mMode == 1)
      {
        paramView = (LinearLayout)paramView;
        localObject1 = paramView;
        if (paramView == null) {
          localObject1 = a(paramViewGroup);
        }
        ((LinearLayout)localObject1).removeAllViews();
        i = GridListView.this.egi;
        j = GridListView.this.egg;
        if (GridListView.this.dag)
        {
          i = GridListView.this.egg;
          locala = (GridListView.a)((LinearLayout)localObject1).getTag();
          k = paramInt * GridListView.this.egg;
          j = 0;
          paramView = (View)localObject1;
          if (j >= i) {
            break label758;
          }
          paramView = locala.v[j];
          m = Math.min(GridListView.this.egi - 1, k + j);
          n = GridListView.this.a.fU(m);
          if ((paramView == null) || (((Integer)paramView.getTag(2131361874)).intValue() == n)) {
            break label775;
          }
          paramView = null;
        }
      }
      label775:
      for (;;)
      {
        View localView = GridListView.this.a.getView(m, paramView, (ViewGroup)localObject1);
        localView.setTag(2131361874, Integer.valueOf(n));
        locala.v[j] = localView;
        localObject2 = (LinearLayout.LayoutParams)localView.getLayoutParams();
        paramView = (View)localObject2;
        if (localObject2 == null)
        {
          paramView = new LinearLayout.LayoutParams(GridListView.this.egj, GridListView.this.egk);
          localView.setLayoutParams(paramView);
        }
        if (GridListView.this.dag)
        {
          paramView.weight = 1.0F;
          if (j % GridListView.this.egg == 0)
          {
            paramView.leftMargin = GridListView.this.mHorizontalSpacing;
            paramView.rightMargin = (GridListView.this.mHorizontalSpacing / 2);
            label379:
            paramView.width = GridListView.this.egj;
            paramView.height = GridListView.this.egk;
            paramView.topMargin = GridListView.this.mVerticalSpacing;
            ((LinearLayout)localObject1).addView(localView);
            if (k + j < GridListView.this.egi) {
              break label569;
            }
            localView.setVisibility(4);
            localView.setOnClickListener(null);
          }
        }
        for (;;)
        {
          j += 1;
          break label167;
          i = Math.min(i - j * paramInt, GridListView.this.egg);
          break;
          if (j % GridListView.this.egg == GridListView.this.egg - 1)
          {
            paramView.leftMargin = (GridListView.this.mHorizontalSpacing / 2);
            paramView.rightMargin = GridListView.this.mHorizontalSpacing;
            break label379;
          }
          paramView.leftMargin = (GridListView.this.mHorizontalSpacing / 2);
          paramView.rightMargin = (GridListView.this.mHorizontalSpacing / 2);
          break label379;
          paramView.leftMargin = GridListView.this.mHorizontalSpacing;
          break label379;
          label569:
          if ((GridListView.this.i != null) && (GridListView.this.a.isEnabled(m)))
          {
            localView.setVisibility(0);
            localView.setTag(2131361825, Integer.valueOf(m));
            localView.setOnClickListener(GridListView.this.gf);
          }
          else
          {
            localView.setVisibility(0);
            localView.setOnClickListener(null);
          }
        }
        i = GridListView.this.a.fT(paramInt) + 2;
        localObject1 = paramView;
        if (paramView != null)
        {
          localObject1 = paramView;
          if (((Integer)paramView.getTag(2131361874)).intValue() != i) {
            localObject1 = null;
          }
        }
        paramView = GridListView.this.a.getView(paramInt, (View)localObject1, paramViewGroup);
        paramView.setTag(2131361874, Integer.valueOf(i));
        if ((GridListView.this.i != null) && (GridListView.this.a.isEnabled(paramInt)))
        {
          paramView.setTag(2131361825, Integer.valueOf(paramInt));
          paramView.setOnClickListener(GridListView.this.gf);
        }
        for (;;)
        {
          label758:
          localObject1 = paramView;
          localObject2 = paramView;
          break;
          paramView.setOnClickListener(null);
        }
      }
    }
    
    public int getViewTypeCount()
    {
      return GridListView.this.egl + 2;
    }
    
    public boolean isEnabled(int paramInt)
    {
      if ((GridListView.this.egh == 0) || (GridListView.this.mMode == 1)) {
        return false;
      }
      return super.isEnabled(paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */