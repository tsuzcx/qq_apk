package com.tencent.mobileqq.conditionsearch.widget;

import aegf;
import aegg;
import aegh;
import android.content.Context;
import android.content.res.Resources;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.widget.AdapterView.e;
import com.tencent.widget.VerticalGallery;
import com.tencent.widget.VerticalGallery.LayoutParams;
import com.tencent.widget.VerticalGallery.b;
import com.tencent.widget.VerticalGallery.c;

public class IphonePickerView
  extends LinearLayout
{
  public static int cAW = -7829368;
  private static int cAZ = -12303292;
  private d jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d;
  private AdapterView.e jdField_a_of_type_ComTencentWidgetAdapterView$e = new aegg(this);
  private VerticalGallery.c jdField_a_of_type_ComTencentWidgetVerticalGallery$c = new aegh(this);
  private b[] jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$b;
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private c b;
  private int columnCount;
  private Button fR;
  private TextView fb;
  
  public IphonePickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet)
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
    b localb = new b(paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$b[paramInt] = localb;
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
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(cAW);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(cAZ);
  }
  
  public void LV(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$b.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$b[paramInt].notifyDataSetChanged();
  }
  
  public void a(d paramd)
  {
    Object localObject1 = getContext().getResources();
    cAW = ((Resources)localObject1).getColor(2131167389);
    cAZ = ((Resources)localObject1).getColor(2131167349);
    setBackgroundColor(((Resources)localObject1).getColor(2131167354));
    Object localObject2 = findViewById(2131379694);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167402));
    }
    localObject2 = findViewById(2131379695);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167402));
    }
    localObject2 = findViewById(2131370492);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167401));
    }
    localObject2 = findViewById(2131370470);
    if (localObject2 != null) {
      ((View)localObject2).setBackgroundColor(((Resources)localObject1).getColor(2131167401));
    }
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d = paramd;
    this.columnCount = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$d.getColumnCount();
    if ((this.columnCount <= 0) || (this.columnCount > 3)) {
      throw new RuntimeException("Unsupportted column count " + this.columnCount);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.columnCount];
    this.jdField_a_of_type_ArrayOfComTencentMobileqqConditionsearchWidgetIphonePickerView$b = new b[this.columnCount];
    paramd = (WheelView)findViewById(2131365628);
    localObject1 = (WheelView)findViewById(2131368677);
    localObject2 = (WheelView)findViewById(2131371855);
    this.fR = ((Button)findViewById(2131379693));
    this.fb = ((TextView)findViewById(2131379722));
    if (this.fR != null) {
      this.fR.setOnClickListener(new aegf(this));
    }
    a(paramd, 0);
    if (this.columnCount < 2) {
      ((WheelView)localObject1).setVisibility(8);
    }
    while (this.columnCount < 3)
    {
      ((WheelView)localObject2).setVisibility(8);
      return;
      ((WheelView)localObject1).setVisibility(0);
      a((WheelView)localObject1, 1);
    }
    ((WheelView)localObject2).setVisibility(0);
    a((WheelView)localObject2, 2);
  }
  
  public int ha(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].getSelectedItemPosition();
  }
  
  public void setPickListener(c paramc)
  {
    this.b = paramc;
  }
  
  public void setSelection(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 0) || (paramInt1 >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt1);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt1].setSelection(paramInt2, true);
  }
  
  public void setTips(int paramInt)
  {
    this.fb.setText(paramInt);
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
      int i = IphonePickerView.a(IphonePickerView.this)[this.column].getSelectedItemPosition();
      if (IphonePickerView.a(IphonePickerView.this) != null) {
        IphonePickerView.a(IphonePickerView.this).w(this.column, i);
      }
    }
  }
  
  class b
    extends BaseAdapter
  {
    private int mColumn;
    private int mHeight = 25;
    
    public b(int paramInt1, int paramInt2)
    {
      this.mColumn = paramInt1;
      this.mHeight = ((int)TypedValue.applyDimension(1, paramInt2, IphonePickerView.this.getResources().getDisplayMetrics()));
    }
    
    public int getCount()
    {
      return IphonePickerView.a(IphonePickerView.this).t(this.mColumn);
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
        paramView = new WheelTextView(IphonePickerView.this.getContext());
        paramView.setLayoutParams(new VerticalGallery.LayoutParams(-1, this.mHeight));
        paramView.setFocusable(true);
        paramView.setFocusableInTouchMode(true);
      }
      for (;;)
      {
        String str = IphonePickerView.a(IphonePickerView.this).d(this.mColumn, paramInt);
        WheelTextView localWheelTextView = (WheelTextView)paramView;
        localWheelTextView.setTextSize(20.0F);
        localWheelTextView.setTextColor(IphonePickerView.cAW);
        localWheelTextView.setGravity(17);
        localWheelTextView.setText(str);
        EventCollector.getInstance().onListGetView(paramInt, paramView, paramViewGroup, getItemId(paramInt));
        return paramView;
      }
    }
  }
  
  public static abstract interface c
  {
    public abstract void dn();
    
    public abstract void w(int paramInt1, int paramInt2);
  }
  
  public static abstract interface d
  {
    public abstract String d(int paramInt1, int paramInt2);
    
    public abstract int getColumnCount();
    
    public abstract int t(int paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */