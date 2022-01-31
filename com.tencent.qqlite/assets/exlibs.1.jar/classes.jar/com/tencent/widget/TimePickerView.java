package com.tencent.widget;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import android.os.Build.VERSION;
import android.view.LayoutInflater;
import android.view.Window;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.IphonePickListener;
import com.tencent.mobileqq.conditionsearch.widget.IphonePickerView.PickerViewAdapter;
import com.tencent.mobileqq.widget.DispatchActionMoveScrollView;
import com.tencent.qphone.base.util.QLog;
import java.util.Calendar;

public class TimePickerView
  implements DialogInterface.OnDismissListener, IphonePickerView.IphonePickListener, IphonePickerView.PickerViewAdapter
{
  static int jdField_a_of_type_Int = 2014;
  public static final String a = "TimePickerView";
  static final int b = 1895;
  Context jdField_a_of_type_AndroidContentContext;
  IphonePickerView jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView;
  ActionSheet jdField_a_of_type_ComTencentWidgetActionSheet;
  TimePickerView.TimePickerListener jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener;
  int c;
  int d;
  int e;
  
  public TimePickerView(Activity paramActivity, int paramInt1, int paramInt2, int paramInt3, TimePickerView.TimePickerListener paramTimePickerListener)
  {
    this.jdField_a_of_type_AndroidContentContext = paramActivity;
    this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener = paramTimePickerListener;
    paramActivity = Calendar.getInstance();
    jdField_a_of_type_Int = paramActivity.get(1);
    if (paramInt1 > jdField_a_of_type_Int) {
      jdField_a_of_type_Int = paramInt1;
    }
    if (jdField_a_of_type_Int < 1895) {
      jdField_a_of_type_Int = 1895;
    }
    this.c = (paramInt1 - 1895);
    int i;
    if (paramInt2 < 1) {
      i = 1;
    }
    for (;;)
    {
      this.d = (i - 1);
      paramActivity.set(1, paramInt1);
      paramActivity.set(2, i - 1);
      paramActivity.set(5, 1);
      paramInt2 = paramActivity.getActualMaximum(5);
      paramInt1 = paramInt3;
      if (paramInt3 > paramInt2) {
        paramInt1 = paramInt2;
      }
      this.e = (paramInt1 - 1);
      return;
      i = paramInt2;
      if (paramInt2 > 12) {
        i = 12;
      }
    }
  }
  
  public int a()
  {
    return 3;
  }
  
  public int a(int paramInt)
  {
    switch (paramInt)
    {
    default: 
      return 0;
    case 0: 
      return jdField_a_of_type_Int - 1895 + 1;
    case 1: 
      return 12;
    }
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(1, this.c + 1895);
    localCalendar.set(2, this.d);
    localCalendar.set(5, 1);
    return localCalendar.getActualMaximum(5);
  }
  
  public String a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    default: 
      return "";
    case 0: 
      return paramInt2 + 1895 + "年";
    case 1: 
      return paramInt2 + 1 + "月";
    }
    return paramInt2 + 1 + "日";
  }
  
  public void a()
  {
    if ((this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener != null) && (this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null)) {
      this.jdField_a_of_type_ComTencentWidgetTimePickerView$TimePickerListener.a(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(0) + 1895, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(1) + 1, this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2) + 1);
    }
    if ((this.jdField_a_of_type_ComTencentWidgetActionSheet != null) && (this.jdField_a_of_type_ComTencentWidgetActionSheet.isShowing()))
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.dismiss();
      this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = null;
    }
  }
  
  public void a(int paramInt1, int paramInt2)
  {
    switch (paramInt1)
    {
    }
    for (;;)
    {
      if ((this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView != null) && ((paramInt1 == 0) || (paramInt1 == 1))) {
        this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(2);
      }
      return;
      this.c = paramInt2;
      continue;
      this.d = paramInt2;
      continue;
      this.e = paramInt2;
    }
  }
  
  public void b()
  {
    this.jdField_a_of_type_ComTencentWidgetActionSheet = ((ActionSheet)ActionSheetHelper.a(this.jdField_a_of_type_AndroidContentContext, null, 2131624119));
    ((DispatchActionMoveScrollView)this.jdField_a_of_type_ComTencentWidgetActionSheet.findViewById(2131296499)).a = true;
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView = ((IphonePickerView)((Activity)this.jdField_a_of_type_AndroidContentContext).getLayoutInflater().inflate(2130903504, null));
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.a(this);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(0, this.c);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(1, this.d);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setSelection(2, this.e);
    this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView.setPickListener(this);
    if (Build.VERSION.SDK_INT >= 11) {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.getWindow().setFlags(16777216, 16777216);
    }
    this.jdField_a_of_type_ComTencentWidgetActionSheet.b(this.jdField_a_of_type_ComTencentMobileqqConditionsearchWidgetIphonePickerView, null);
    this.jdField_a_of_type_ComTencentWidgetActionSheet.setOnDismissListener(this);
    try
    {
      this.jdField_a_of_type_ComTencentWidgetActionSheet.show();
      return;
    }
    catch (Throwable localThrowable)
    {
      while (!QLog.isColorLevel()) {}
      QLog.d("TimePickerView", 2, localThrowable.getMessage());
    }
  }
  
  public void onDismiss(DialogInterface paramDialogInterface) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.widget.TimePickerView
 * JD-Core Version:    0.7.0.1
 */