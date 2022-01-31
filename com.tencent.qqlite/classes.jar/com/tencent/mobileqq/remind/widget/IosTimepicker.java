package com.tencent.mobileqq.remind.widget;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.tencent.mobileqq.remind.DayAdapter;
import com.tencent.mobileqq.remind.NumberAdapter;
import com.tencent.mobileqq.remind.TimeHelper;
import com.tencent.qphone.base.util.QLog;
import com.tencent.widget.ActionSheet;
import com.tencent.widget.AdapterView;
import com.tencent.widget.AdapterView.OnItemSelectedListener;
import com.tencent.widget.VerticalGallery.OnEndFlingListener;
import com.tencent.widget.VerticalGallery.OnSelectViewDataUpdateListener;
import ean;
import eao;
import eap;
import eaq;

public class IosTimepicker
  extends LinearLayout
{
  public static final float a = -0.1F;
  public static final int a = 20;
  public static final String a = "day";
  public static final float b = 0.1F;
  public static final int b = 25;
  public static final String b = "hour";
  public static final float c = -25.0F;
  public static final int c = 17;
  public static final String c = "min";
  public static final float d = 0.8F;
  public static final int d = 20;
  private static String d = "remind";
  public static final int e = 80;
  public static final int f = 80;
  public static final int g = -80;
  private static final int h = 0;
  private static final int i = 1;
  private long jdField_a_of_type_Long;
  private Context jdField_a_of_type_AndroidContentContext;
  private View jdField_a_of_type_AndroidViewView = null;
  private Button jdField_a_of_type_AndroidWidgetButton = null;
  private TextView jdField_a_of_type_AndroidWidgetTextView = null;
  private DayAdapter jdField_a_of_type_ComTencentMobileqqRemindDayAdapter;
  private NumberAdapter jdField_a_of_type_ComTencentMobileqqRemindNumberAdapter;
  private IosTimepicker.OnTimePickerSelectListener jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener;
  private WheelView jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView = null;
  private ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  private AdapterView.OnItemSelectedListener jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener = new eao(this);
  private VerticalGallery.OnEndFlingListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener = new eaq(this);
  private VerticalGallery.OnSelectViewDataUpdateListener jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener = new eap(this);
  private String[] jdField_a_of_type_ArrayOfJavaLangString;
  private long jdField_b_of_type_Long;
  private NumberAdapter jdField_b_of_type_ComTencentMobileqqRemindNumberAdapter;
  private WheelView jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView = null;
  private String[] jdField_b_of_type_ArrayOfJavaLangString;
  private WheelView c = null;
  private int j;
  private int k;
  
  public IosTimepicker(Context paramContext)
  {
    super(paramContext);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  @TargetApi(11)
  public IosTimepicker(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    this.jdField_a_of_type_AndroidContentContext = paramContext;
  }
  
  private void a()
  {
    Object localObject2 = null;
    int m = this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.p();
    int n = this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.p();
    int i1 = this.c.p();
    String str2 = TimeHelper.a(m);
    if ((n >= 0) && (n < TimeHelper.jdField_a_of_type_ArrayOfJavaLangString.length)) {}
    for (String str1 = TimeHelper.jdField_a_of_type_ArrayOfJavaLangString[n];; str1 = null)
    {
      Object localObject1 = localObject2;
      if (i1 >= 0)
      {
        localObject1 = localObject2;
        if (i1 < TimeHelper.jdField_b_of_type_ArrayOfJavaLangString.length) {
          localObject1 = TimeHelper.jdField_b_of_type_ArrayOfJavaLangString[i1];
        }
      }
      if ((!TextUtils.isEmpty(str2)) && (!TextUtils.isEmpty(str1)) && (!TextUtils.isEmpty((CharSequence)localObject1)))
      {
        this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setContentDescription("当前选中时间" + str2 + str1 + "时" + (String)localObject1 + "分");
        this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setContentDescription("当前选中时间" + str2 + str1 + "时" + (String)localObject1 + "分");
        this.c.setContentDescription("当前选中时间" + str2 + str1 + "时" + (String)localObject1 + "分");
      }
      this.jdField_b_of_type_Long = TimeHelper.a(m, n, i1);
      if (this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener != null) {
        this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener.a(this.jdField_b_of_type_Long);
      }
      return;
    }
  }
  
  private void a(View paramView, int paramInt)
  {
    if ((paramView instanceof WheelTextView))
    {
      if (paramInt == 0)
      {
        ((WheelTextView)paramView).setTextSize(20.0F);
        ((WheelTextView)paramView).setTextColor(this.j);
      }
    }
    else {
      return;
    }
    ((WheelTextView)paramView).setTextSize(20.0F);
    ((WheelTextView)paramView).setTextColor(this.k);
  }
  
  private void a(AdapterView paramAdapterView, View paramView)
  {
    String str1;
    String str2;
    if (((paramAdapterView instanceof WheelView)) && ((paramView instanceof WheelTextView)))
    {
      str1 = ((WheelTextView)paramView).getText().toString();
      str2 = paramAdapterView.getTag().toString();
      if (!str2.equals("hour")) {
        break label73;
      }
      paramAdapterView = str1 + "点";
    }
    for (;;)
    {
      ((WheelTextView)paramView).setContentDescription(paramAdapterView);
      return;
      label73:
      paramAdapterView = str1;
      if (str2.equals("min")) {
        paramAdapterView = str1 + "分";
      }
    }
  }
  
  public long a()
  {
    return this.jdField_b_of_type_Long;
  }
  
  public void a(Context paramContext, ActionSheet paramActionSheet, long paramLong, IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener, View.OnClickListener paramOnClickListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramContext;
    this.jdField_a_of_type_ComTencentWidgetActionSheet = paramActionSheet;
    this.jdField_a_of_type_Long = paramLong;
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
    paramContext = this.jdField_a_of_type_AndroidContentContext.getResources();
    this.j = paramContext.getColor(2131427504);
    this.k = paramContext.getColor(2131427490);
    this.jdField_a_of_type_ArrayOfJavaLangString = TimeHelper.jdField_a_of_type_ArrayOfJavaLangString;
    this.jdField_b_of_type_ArrayOfJavaLangString = TimeHelper.jdField_b_of_type_ArrayOfJavaLangString;
    this.jdField_a_of_type_AndroidViewView = findViewById(2131298977);
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView = ((WheelView)findViewById(2131298144));
    this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView = ((WheelView)findViewById(2131298145));
    this.c = ((WheelView)findViewById(2131298146));
    this.jdField_a_of_type_AndroidWidgetTextView = ((TextView)findViewById(2131298978));
    this.jdField_a_of_type_AndroidWidgetButton = ((Button)findViewById(2131298241));
    int m = paramContext.getColor(2131427510);
    findViewById(2131298979).setBackgroundColor(m);
    findViewById(2131298980).setBackgroundColor(m);
    this.jdField_a_of_type_AndroidViewView.setBackgroundColor(paramContext.getColor(2131427491));
    m = paramContext.getColor(2131427509);
    findViewById(2131297577).setBackgroundColor(m);
    findViewById(2131297578).setBackgroundColor(m);
    if (paramOnClickListener != null) {
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(paramOnClickListener);
    }
    for (;;)
    {
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setScrollCycle(true);
      this.c.setScrollCycle(true);
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setTag("day");
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setTag("hour");
      this.c.setTag("min");
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setmMaxRotationAngle(80);
      this.c.setmMaxRotationAngle(80);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setmMaxSkew(0.1F);
      this.c.setmMaxSkew(0.1F);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setNeedTranslate(true);
      this.c.setNeedTranslate(true);
      this.jdField_a_of_type_ComTencentMobileqqRemindDayAdapter = new DayAdapter(this.jdField_a_of_type_AndroidContentContext, 25);
      this.jdField_a_of_type_ComTencentMobileqqRemindNumberAdapter = new NumberAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_a_of_type_ArrayOfJavaLangString, 25);
      this.jdField_b_of_type_ComTencentMobileqqRemindNumberAdapter = new NumberAdapter(this.jdField_a_of_type_AndroidContentContext, this.jdField_b_of_type_ArrayOfJavaLangString, 25);
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRemindDayAdapter);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setAdapter(this.jdField_a_of_type_ComTencentMobileqqRemindNumberAdapter);
      this.c.setAdapter(this.jdField_b_of_type_ComTencentMobileqqRemindNumberAdapter);
      if (QLog.isColorLevel()) {
        QLog.d(d, 2, "createTimePicker Time :" + TimeHelper.a(this.jdField_a_of_type_Long));
      }
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setSelection((int)TimeHelper.a(this.jdField_a_of_type_Long), true);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setSelection(TimeHelper.a(this.jdField_a_of_type_Long), true);
      this.c.setSelection(TimeHelper.b(this.jdField_a_of_type_Long), true);
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
      this.c.setOnItemSelectedListener(this.jdField_a_of_type_ComTencentWidgetAdapterView$OnItemSelectedListener);
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
      this.c.setOnSelectViewDataUpdateListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnSelectViewDataUpdateListener);
      this.jdField_a_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener);
      this.jdField_b_of_type_ComTencentMobileqqRemindWidgetWheelView.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener);
      this.c.setOnEndFlingListener(this.jdField_a_of_type_ComTencentWidgetVerticalGallery$OnEndFlingListener);
      a();
      return;
      this.jdField_a_of_type_AndroidWidgetButton.setOnClickListener(new ean(this));
    }
  }
  
  public void setMaxDays(int paramInt)
  {
    TimeHelper.jdField_a_of_type_Int = paramInt;
    if (QLog.isColorLevel()) {
      QLog.d(d, 2, "setMaxDays days = " + TimeHelper.jdField_a_of_type_Int);
    }
  }
  
  public void setOnTimePickerSelectListener(IosTimepicker.OnTimePickerSelectListener paramOnTimePickerSelectListener)
  {
    this.jdField_a_of_type_ComTencentMobileqqRemindWidgetIosTimepicker$OnTimePickerSelectListener = paramOnTimePickerSelectListener;
  }
  
  public void setTips(String paramString)
  {
    if (this.jdField_a_of_type_AndroidWidgetTextView != null) {
      this.jdField_a_of_type_AndroidWidgetTextView.setText(paramString);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.remind.widget.IosTimepicker
 * JD-Core Version:    0.7.0.1
 */