package com.tencent.qqmini.miniapp.widget;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.res.Resources.NotFoundException;
import android.graphics.drawable.ColorDrawable;
import android.os.Build.VERSION;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.view.WindowManager.LayoutParams;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.NumberPicker;
import android.widget.NumberPicker.OnValueChangeListener;
import android.widget.TextView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;
import com.tencent.qqlive.module.videoreport.inject.dialog.ReportDialog;
import com.tencent.qqmini.miniapp.R.id;
import com.tencent.qqmini.miniapp.R.layout;
import com.tencent.qqmini.miniapp.R.style;
import com.tencent.qqmini.sdk.launcher.utils.ColorUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;

public class MutiPickerView
  extends ReportDialog
  implements DialogInterface.OnCancelListener, View.OnClickListener
{
  private TextView mCancelTextView;
  private TextView mConfirmTextView;
  private LinearLayout mMutiPickerContainer;
  private ArrayList<NumberPicker> mNumberPicker = new ArrayList();
  private OnConfirmListener mOnConfirmListener;
  private int[] mResult;
  private String[][] mValues;
  
  public MutiPickerView(@NonNull Context paramContext)
  {
    super(paramContext, R.style.Theme_Light_NoTitle_Dialog);
    initView(paramContext);
  }
  
  private void initView(Context paramContext)
  {
    paramContext = LayoutInflater.from(paramContext).inflate(R.layout.mini_sdk_muti_dialog_picker, null);
    setContentView(paramContext);
    Window localWindow = getWindow();
    if (localWindow != null)
    {
      localWindow.getDecorView().setPadding(0, 0, 0, 0);
      WindowManager.LayoutParams localLayoutParams = localWindow.getAttributes();
      localLayoutParams.width = -1;
      localLayoutParams.height = -2;
      localWindow.setAttributes(localLayoutParams);
      localWindow.setGravity(80);
    }
    this.mMutiPickerContainer = ((LinearLayout)paramContext.findViewById(R.id.muti_picker_container));
    this.mCancelTextView = ((TextView)paramContext.findViewById(R.id.muti_tv_cancel));
    this.mCancelTextView.setOnClickListener(this);
    this.mConfirmTextView = ((TextView)paramContext.findViewById(R.id.muti_tv_confirm));
    this.mConfirmTextView.setOnClickListener(this);
    setOnCancelListener(this);
  }
  
  private void setNumpickerDiverColor(NumberPicker paramNumberPicker)
  {
    Field[] arrayOfField = NumberPicker.class.getDeclaredFields();
    int j = arrayOfField.length;
    int i = 0;
    for (;;)
    {
      Field localField;
      if (i < j)
      {
        localField = arrayOfField[i];
        if (localField.getName().equals("mSelectionDivider")) {
          localField.setAccessible(true);
        }
      }
      else
      {
        try
        {
          localField.set(paramNumberPicker, new ColorDrawable(ColorUtils.parseColor("#3CB371")));
          return;
        }
        catch (IllegalArgumentException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (Resources.NotFoundException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
        catch (IllegalAccessException paramNumberPicker)
        {
          paramNumberPicker.printStackTrace();
          return;
        }
      }
      i += 1;
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
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    if (this.mOnConfirmListener != null) {
      this.mOnConfirmListener.onValCancel();
    }
  }
  
  public void onClick(View paramView)
  {
    if (paramView.getId() == R.id.muti_tv_cancel)
    {
      if (this.mOnConfirmListener != null) {
        this.mOnConfirmListener.onValCancel();
      }
      dismissDlg();
    }
    for (;;)
    {
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (paramView.getId() == R.id.muti_tv_confirm)
      {
        if (this.mOnConfirmListener != null) {
          this.mOnConfirmListener.onValConfirm(this.mResult);
        }
        dismissDlg();
      }
    }
  }
  
  public void setCurrentIndex(int[] paramArrayOfInt)
  {
    if ((this.mNumberPicker == null) || (this.mNumberPicker.size() == 0)) {}
    for (;;)
    {
      return;
      if ((paramArrayOfInt != null) && (paramArrayOfInt.length == this.mNumberPicker.size()))
      {
        this.mResult = paramArrayOfInt;
        int i = 0;
        while (i < this.mNumberPicker.size())
        {
          ((NumberPicker)this.mNumberPicker.get(i)).setValue(paramArrayOfInt[i]);
          i += 1;
        }
      }
    }
  }
  
  public void setDisplayedValues(int paramInt1, int paramInt2, String[] paramArrayOfString)
  {
    if ((paramArrayOfString == null) || (paramArrayOfString.length == 0)) {}
    do
    {
      do
      {
        return;
      } while ((this.mNumberPicker == null) || (paramInt1 >= this.mNumberPicker.size()));
      NumberPicker localNumberPicker = (NumberPicker)this.mNumberPicker.get(paramInt1);
      localNumberPicker.setDisplayedValues(null);
      localNumberPicker.setMaxValue(paramArrayOfString.length - 1);
      localNumberPicker.setDisplayedValues(paramArrayOfString);
      localNumberPicker.setValue(paramInt2);
    } while ((paramInt1 >= this.mResult.length) || (paramInt1 < 0));
    this.mResult[paramInt1] = paramInt2;
  }
  
  public void setDisplayedValues(String[][] paramArrayOfString)
  {
    this.mValues = paramArrayOfString;
    this.mNumberPicker.clear();
    if (this.mMutiPickerContainer.getChildCount() > 0) {
      this.mMutiPickerContainer.removeAllViews();
    }
    this.mResult = null;
    if (paramArrayOfString != null)
    {
      this.mResult = new int[paramArrayOfString.length];
      int i = 0;
      if (i < paramArrayOfString.length)
      {
        if (Build.VERSION.SDK_INT >= 16) {}
        for (Object localObject = new MiniNumberPicker(getContext());; localObject = new NumberPicker(getContext()))
        {
          if (paramArrayOfString[i].length > 0)
          {
            ((NumberPicker)localObject).setDisplayedValues(paramArrayOfString[i]);
            ((NumberPicker)localObject).setMinValue(0);
            ((NumberPicker)localObject).setMaxValue(paramArrayOfString[i].length - 1);
          }
          ((NumberPicker)localObject).setOnValueChangedListener(new MutiOnValueChangeListener(i));
          setNumpickerDiverColor((NumberPicker)localObject);
          this.mNumberPicker.add(localObject);
          LinearLayout.LayoutParams localLayoutParams = new LinearLayout.LayoutParams(0, -2);
          localLayoutParams.weight = 1.0F;
          localLayoutParams.setMargins(10, 10, 10, 10);
          this.mMutiPickerContainer.addView((View)localObject, localLayoutParams);
          i += 1;
          break;
        }
      }
    }
  }
  
  public void setOnConfirmListener(OnConfirmListener paramOnConfirmListener)
  {
    this.mOnConfirmListener = paramOnConfirmListener;
  }
  
  class MutiOnValueChangeListener
    implements NumberPicker.OnValueChangeListener
  {
    private int index;
    
    public MutiOnValueChangeListener(int paramInt)
    {
      this.index = paramInt;
    }
    
    public int getIndex()
    {
      return this.index;
    }
    
    public void onValueChange(NumberPicker paramNumberPicker, int paramInt1, int paramInt2)
    {
      if ((MutiPickerView.this.mResult != null) && (MutiPickerView.this.mResult.length > this.index))
      {
        MutiPickerView.this.mResult[this.index] = paramInt2;
        MutiPickerView.this.mOnConfirmListener.onValChange(this.index, paramInt2);
      }
    }
  }
  
  public static abstract interface OnConfirmListener
  {
    public abstract void onValCancel();
    
    public abstract void onValChange(int paramInt1, int paramInt2);
    
    public abstract void onValConfirm(int[] paramArrayOfInt);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.widget.MutiPickerView
 * JD-Core Version:    0.7.0.1
 */