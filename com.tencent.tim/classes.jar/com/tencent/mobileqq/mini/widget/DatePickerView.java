package com.tencent.mobileqq.mini.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.support.annotation.NonNull;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.DatePicker;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.NumberPicker;
import android.widget.TextView;
import com.tencent.mobileqq.mini.util.ColorUtils;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import java.lang.reflect.Field;

public class DatePickerView
  extends ReportDialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private int dayOfMonth;
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private DatePicker mDatePicker;
  private OnConfirmListener mOnConfirmListener;
  private int monthOfYear;
  private int year;
  
  public DatePickerView(@NonNull Context paramContext)
  {
    super(paramContext, 2131755710);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(2131559229, null);
    setContentView(paramContext);
    Object localObject = getWindow();
    if (localObject != null)
    {
      ((Window)localObject).getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = ((Window)localObject).getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      ((Window)localObject).setAttributes(localLayoutParams);
      ((Window)localObject).setGravity(80);
    }
    localObject = (FrameLayout)paramContext.findViewById(2131373280);
    this.mDatePicker = new DatePicker(new ContextThemeWrapper(getContext(), 16973934));
    this.mDatePicker.setCalendarViewShown(false);
    ((FrameLayout)localObject).addView(this.mDatePicker);
    this.mCancelTextView = ((TextView)paramContext.findViewById(2131380588));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(2131380629));
    this.mConfirmTextView.setOnClickListener(this);
    setDatePickerDividerColor(this.mDatePicker);
    setOnCancelListener(this);
  }
  
  private void setDatePickerDividerColor(DatePicker paramDatePicker)
  {
    paramDatePicker = (LinearLayout)((LinearLayout)paramDatePicker.getChildAt(0)).getChildAt(0);
    int i = 0;
    if (i < paramDatePicker.getChildCount())
    {
      NumberPicker localNumberPicker = (NumberPicker)paramDatePicker.getChildAt(i);
      Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
      int k = arrayOfField.length;
      int j = 0;
      for (;;)
      {
        for (;;)
        {
          Field localField;
          if (j < k)
          {
            localField = arrayOfField[j];
            if (localField.getName().equals("mSelectionDivider")) {
              localField.setAccessible(true);
            }
          }
          else
          {
            try
            {
              localField.set(localNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
              i += 1;
            }
            catch (IllegalArgumentException localIllegalArgumentException)
            {
              for (;;)
              {
                localIllegalArgumentException.printStackTrace();
              }
            }
            catch (Resources.NotFoundException localNotFoundException)
            {
              for (;;)
              {
                localNotFoundException.printStackTrace();
              }
            }
            catch (IllegalAccessException localIllegalAccessException)
            {
              for (;;)
              {
                localIllegalAccessException.printStackTrace();
              }
            }
          }
        }
        j += 1;
      }
    }
  }
  
  public void dismissDlg()
  {
    try
    {
      if (isShowing()) {
        dismiss();
      }
      return;
    }
    catch (Exception localException) {}
  }
  
  public void init(int paramInt1, int paramInt2, int paramInt3, OnConfirmListener paramOnConfirmListener)
  {
    this.mDatePicker.init(paramInt1, paramInt2, paramInt3, new DatePickerView.1(this));
    this.mOnConfirmListener = paramOnConfirmListener;
  }
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.mOnConfirmListener != null) {
      this.mOnConfirmListener.onDateCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == 2131380588)
    {
      if (this.mOnConfirmListener != null) {
        this.mOnConfirmListener.onDateCancel();
      }
      dismissDlg();
    }
    while (paramView.getId() != 2131380629)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
    }
    int i;
    String str1;
    if (this.mOnConfirmListener != null)
    {
      i = this.monthOfYear + 1;
      if (i >= 10) {
        break label144;
      }
      str1 = "0" + i;
      label86:
      i = this.dayOfMonth;
      if (i >= 10) {
        break label152;
      }
    }
    label144:
    label152:
    for (String str2 = "0" + i;; str2 = String.valueOf(i))
    {
      this.mOnConfirmListener.onDateConfirm(String.valueOf(this.year), str1, str2);
      dismissDlg();
      break;
      str1 = String.valueOf(i);
      break label86;
    }
  }
  
  public void setDayOfMonthVisible(int paramInt)
  {
    if (this.mDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.mDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(2).setVisibility(paramInt);
    }
  }
  
  public void setMaxDate(long paramLong)
  {
    this.mDatePicker.setMaxDate(paramLong);
  }
  
  public void setMinDate(long paramLong)
  {
    this.mDatePicker.setMinDate(paramLong);
  }
  
  public void setMonthOfYearVisible(int paramInt)
  {
    if (this.mDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.mDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(1).setVisibility(paramInt);
    }
  }
  
  public void setYearVisible(int paramInt)
  {
    if (this.mDatePicker != null) {
      ((ViewGroup)((ViewGroup)this.mDatePicker.getChildAt(0)).getChildAt(0)).getChildAt(0).setVisibility(paramInt);
    }
  }
  
  public void updateDate(int paramInt1, int paramInt2, int paramInt3)
  {
    this.year = paramInt1;
    this.monthOfYear = paramInt2;
    this.dayOfMonth = paramInt3;
    this.mDatePicker.updateDate(paramInt1, paramInt2, paramInt3);
  }
  
  public static abstract interface OnConfirmListener
  {
    public abstract void onDateCancel();
    
    public abstract void onDateConfirm(String paramString1, String paramString2, String paramString3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.mini.widget.DatePickerView
 * JD-Core Version:    0.7.0.1
 */