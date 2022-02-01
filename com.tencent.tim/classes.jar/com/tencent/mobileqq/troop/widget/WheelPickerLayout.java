package com.tencent.mobileqq.troop.widget;

import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import apwl;
import apwm;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.LayoutParams;
import com.tencent.widget.VerticalGallery.b;
import com.tencent.widget.VerticalGallery.c;

public class WheelPickerLayout
  extends LinearLayout
{
  private c jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$c;
  private d jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d;
  private e jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$e;
  private AdapterView.e jdField_a_of_type_ComTencentWidgetAdapterView$e = new apwl(this);
  private VerticalGallery.c jdField_a_of_type_ComTencentWidgetVerticalGallery$c = new apwm(this);
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private b[] jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$b;
  private int columnCount;
  
  public WheelPickerLayout(Context paramContext)
  {
    super(paramContext);
  }
  
  public WheelPickerLayout(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  private void G(View paramView, boolean paramBoolean)
  {
    if ((paramView instanceof WheelTextView))
    {
      StringBuilder localStringBuilder = new StringBuilder(((WheelTextView)paramView).getText());
      ((WheelTextView)paramView).setContentDescription(localStringBuilder);
    }
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    b localb = new b(paramInt, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d.mItemHeight);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$b[paramInt] = localb;
    paramWheelView.setAdapter(localb);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$e);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$c);
    paramWheelView.setOnEndMovementListener(new a(paramInt));
  }
  
  private void ae(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d.mTextSize);
        ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d.mTextColor);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(1, this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d.dXJ);
    ((WheelTextView)paramView).setTextColor(this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d.dXK);
  }
  
  public void LV(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$b.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$b[paramInt].notifyDataSetChanged();
  }
  
  public void a(c paramc, d paramd)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$d = paramd;
    if (paramd == null) {
      throw new RuntimeException("ViewStyle can not be null!");
    }
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$c = paramc;
    this.columnCount = getChildCount();
    if (this.columnCount <= 0) {
      throw new RuntimeException("Unsupportted column count " + this.columnCount);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.columnCount];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqTroopWidgetWheelPickerLayout$b = new b[this.columnCount];
    int i = 0;
    while (i < this.columnCount)
    {
      a((WheelView)getChildAt(i), i);
      i += 1;
    }
  }
  
  public int ha(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void setPickListener(e parame)
  {
    this.jdField_a_of_type_ComTencentMobileqqTroopWidgetWheelPickerLayout$e = parame;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
  
  class a
    implements VerticalGallery.b
  {
    private int column;
    
    public a(int paramInt)
    {
      this.column = paramInt;
    }
    
    public void a(VerticalGallery paramVerticalGallery)
    {
      int i = WheelPickerLayout.a(WheelPickerLayout.this)[this.column].getSelectedItemPosition();
      if (WheelPickerLayout.a(WheelPickerLayout.this) != null) {
        WheelPickerLayout.a(WheelPickerLayout.this).w(this.column, i);
      }
    }
  }
  
  class b
    extends BaseAdapter
  {
    private final int mColumn;
    private final int mHeight;
    
    public b(int paramInt1, int paramInt2)
    {
      this.mColumn = paramInt1;
      this.mHeight = ((int)TypedValue.applyDimension(1, paramInt2, WheelPickerLayout.this.getResources().getDisplayMetrics()));
    }
    
    public int getCount()
    {
      return WheelPickerLayout.a(WheelPickerLayout.this).t(this.mColumn);
    }
    
    public Object getItem(int paramInt)
    {
      return Integer.valueOf(paramInt);
    }
    
    public long getItemId(int paramInt)
    {
      return paramInt;
    }
    
    public View getView(int paramInt, View paramView, ViewGroup paramViewGroup)
    {
      if (paramView == null)
      {
        paramView = new WheelTextView(WheelPickerLayout.this.getContext());
        paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.mHeight));
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
      }
      for (;;)
      {
        String str = WheelPickerLayout.a(WheelPickerLayout.this).d(this.mColumn, paramInt);
        WheelTextView localWheelTextView = (WheelTextView)paramView;
        localWheelTextView.setTextSize(1, WheelPickerLayout.a(WheelPickerLayout.this).mTextSize);
        localWheelTextView.setTextColor(WheelPickerLayout.a(WheelPickerLayout.this).mTextColor);
        localWheelTextView.setGravity(WheelPickerLayout.a(WheelPickerLayout.this).mGravity);
        localWheelTextView.setText(str);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract String d(int paramInt1, int paramInt2);
    
    public abstract int t(int paramInt);
  }
  
  public static class d
  {
    public int dXJ;
    public int dXK;
    public int mGravity;
    public int mItemHeight;
    public int mTextColor;
    public int mTextSize;
  }
  
  public static abstract interface e
  {
    public abstract void w(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.widget.WheelPickerLayout
 * JD-Core Version:    0.7.0.1
 */