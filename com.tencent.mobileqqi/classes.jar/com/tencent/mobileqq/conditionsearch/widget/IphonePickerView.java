package com.tencent.mobileqq.conditionsearch.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.remind.widget.WheelTextView;
import com.tencent.mobileqq.remind.widget.WheelView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;
import fme;
import fmf;
import fmg;
import fmh;
import fmi;

public class IphonePickerView
  extends LinearLayout
{
  public static final float a = -0.1F;
  public static final int a = 25;
  private static final String jdField_a_of_type_JavaLangString = "IphonePickerView";
  public static final float b = -25.0F;
  public static final int b = 20;
  public static final float c = 0.8F;
  public static final int c = -7829368;
  public static final int d = 17;
  public static final int e = 80;
  public static final int f = -80;
  private static final int g = 20;
  private static final int h = -12303292;
  private static final int j = 0;
  private static final int k = 1;
  private Button jdField_a_of_type_AndroidWidgetButton;
  private TextView jdField_a_of_type_AndroidWidgetTextView;
  private IphonePickerView.IphonePickListener jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener;
  private IphonePickerView.PickerViewAdapter jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new fmf(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new fmg(this);
  private WheelView[] jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView;
  private fmi[] jdField_a_of_type_ArrayOfFmi;
  private int i = 0;
  
  public IphonePickerView(Context paramContext)
  {
    super(paramContext);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public IphonePickerView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(-7829368);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(-12303292);
  }
  
  private void a(WheelView paramWheelView, int paramInt)
  {
    paramWheelView.setTag(Integer.valueOf(paramInt));
    fmi localfmi = new fmi(this, paramInt, 25);
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt] = paramWheelView;
    this.jdField_a_of_type_ArrayOfFmi[paramInt] = localfmi;
    if (paramInt != 0)
    {
      paramWheelView.setmMaxRotationAngle(80);
      paramWheelView.setmMaxSkew(-0.1F);
      paramWheelView.setNeedTranslate(true);
    }
    paramWheelView.setAdapter(localfmi);
    paramWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
    paramWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
    paramWheelView.setOnEndMovementListener(new fmh(this, paramInt));
  }
  
  public int a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    return this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView[paramInt].p();
  }
  
  public void a(int paramInt)
  {
    if ((paramInt < 0) || (paramInt >= this.jdField_a_of_type_ArrayOfFmi.length)) {
      throw new IllegalArgumentException("Error column index " + paramInt);
    }
    this.jdField_a_of_type_ArrayOfFmi[paramInt].notifyDataSetChanged();
  }
  
  public void a(IphonePickerView.PickerViewAdapter paramPickerViewAdapter)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter = paramPickerViewAdapter;
    this.i = this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$PickerViewAdapter.a();
    if ((this.i <= 0) || (this.i > 3)) {
      throw new RuntimeException("Unsupportted column count " + this.i);
    }
    this.jdField_a_of_type_ArrayOfComTencentMobileqqRemindWidgetWheelView = new WheelView[this.i];
    this.jdField_a_of_type_ArrayOfFmi = new fmi[this.i];
    paramPickerViewAdapter = (WheelView)findViewById(2131232973);
    WheelView localWheelView1 = (WheelView)findViewById(2131232974);
    WheelView localWheelView2 = (WheelView)findViewById(2131232975);
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131232972));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131232971));
    this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new fme(this));
    a(paramPickerViewAdapter, 0);
    if (this.i < 2) {
      localWheelView1.setVisibility(8);
    }
    while (this.i < 3)
    {
      localWheelView2.setVisibility(8);
      return;
      a(localWheelView1, 1);
    }
    a(localWheelView2, 2);
  }
  
  public void setPickListener(IphonePickerView.IphonePickListener paramIphonePickListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView$IphonePickListener = paramIphonePickListener;
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
    this.jdField_a_of_type_AndroidWidgetTextView.setText(paramInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.conditionsearch.widget.IphonePickerView
 * JD-Core Version:    0.7.0.1
 */