package com.tencent.mobileqq.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.AdapterView.OnItemClickListener;
import com.tencent.widget.XListView;
import eye;
import eyf;

@Deprecated
public class GridListView
  extends XListView
{
  public static final int a = 0;
  public static final int b = 1;
  static final int l = 2131298496;
  static final int m = 2131296456;
  static final int n = 0;
  static final int o = 1;
  static final int p = 2;
  View.OnClickListener jdField_a_of_type_AndroidViewView$OnClickListener;
  View jdField_a_of_type_AndroidViewView = new View(getContext());
  public GridListView.GridListAdapter a;
  public GridListView.WraperAdapter a;
  public AdapterView.OnItemClickListener a;
  int c = 0;
  int d = 4;
  int e = 0;
  int f;
  int g;
  int h;
  int i;
  int j;
  int k;
  
  public GridListView(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter = new GridListView.WraperAdapter(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter = new GridListView.WraperAdapter(this);
  }
  
  public GridListView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter = new GridListView.WraperAdapter(this);
  }
  
  private void g(int paramInt)
  {
    if (this.f != paramInt) {
      h(paramInt);
    }
  }
  
  private void h(int paramInt)
  {
    this.f = paramInt;
    this.e = this.f;
    if (this.c == 1) {
      this.e = ((this.f + this.d - 1) / this.d);
    }
  }
  
  public int a()
  {
    int i1 = super.getChildCount();
    int i2 = i1;
    if (this.c == 1)
    {
      i2 = i1;
      if (i1 > 0)
      {
        LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i1 - 1);
        i2 = i1;
        if (i1 > 1) {
          i2 = (i1 - 1) * this.d;
        }
        i2 += localLinearLayout.getChildCount();
      }
    }
    return i2;
  }
  
  public View a(int paramInt)
  {
    if (this.c == 0) {
      return super.getChildAt(paramInt);
    }
    int i1 = paramInt / this.d;
    int i2 = this.d;
    View localView = null;
    LinearLayout localLinearLayout = (LinearLayout)super.getChildAt(i1);
    if (localLinearLayout != null) {
      localView = localLinearLayout.getChildAt(paramInt % i2);
    }
    StringBuilder localStringBuilder;
    if ((localView == null) && (QLog.isColorLevel()))
    {
      localStringBuilder = new StringBuilder().append("gridChild is null when ").append(paramInt).append(":").append(a()).append(":").append(super.getChildCount()).append(":");
      if (localLinearLayout == null) {
        break label140;
      }
    }
    label140:
    for (paramInt = localLinearLayout.getChildCount();; paramInt = -1)
    {
      QLog.e("GridListView", 2, paramInt);
      return localView;
    }
  }
  
  public int a_()
  {
    return this.c;
  }
  
  public void setAdapter(ListAdapter paramListAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter = ((GridListView.GridListAdapter)paramListAdapter);
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.registerDataSetObserver(new eye(this));
    this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.b(this.c);
    this.k = this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.a();
    g(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
    super.setAdapter(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter);
  }
  
  public void setEmptyView(View paramView)
  {
    this.jdField_a_of_type_AndroidViewView = paramView;
    if (this.f == 0) {
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setGridSize(int paramInt)
  {
    setGridSize(paramInt, paramInt);
  }
  
  public void setGridSize(int paramInt1, int paramInt2)
  {
    if ((this.i != paramInt1) || (this.j != paramInt2))
    {
      this.i = paramInt1;
      this.j = paramInt2;
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setGridSpacing(int paramInt1, int paramInt2)
  {
    if ((this.g != paramInt1) || (this.h != paramInt2))
    {
      this.g = paramInt1;
      this.h = paramInt2;
      if (this.c == 1) {
        setPadding(0, 0, 0, this.h);
      }
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
    }
  }
  
  public void setMode(int paramInt)
  {
    if (this.c != paramInt)
    {
      this.c = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null)
      {
        this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.b(this.c);
        h(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
      }
      if (this.c != 1) {
        break label71;
      }
    }
    label71:
    for (paramInt = this.h;; paramInt = 0)
    {
      setPadding(0, 0, 0, paramInt);
      this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$WraperAdapter.notifyDataSetChanged();
      return;
    }
  }
  
  public void setNumColumns(int paramInt)
  {
    if (paramInt != this.d)
    {
      this.d = paramInt;
      if (this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter != null) {
        g(this.jdField_a_of_type_ComTencentMobileqqWidgetGridListView$GridListAdapter.getCount());
      }
    }
  }
  
  public void setOnItemClickListener(AdapterView.OnItemClickListener paramOnItemClickListener)
  {
    this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemClickListener = paramOnItemClickListener;
    if (this.jdField_a_of_type_AndroidViewView$OnClickListener == null) {
      this.jdField_a_of_type_AndroidViewView$OnClickListener = new eyf(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.mobileqq.widget.GridListView
 * JD-Core Version:    0.7.0.1
 */