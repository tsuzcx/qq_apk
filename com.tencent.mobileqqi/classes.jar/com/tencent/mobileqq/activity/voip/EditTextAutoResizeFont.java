package com.tencent.mobileqq.activity.voip;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

public class EditTextAutoResizeFont
  extends EditText
{
  private static float jdField_a_of_type_Float = 10.0F;
  private static float jdField_b_of_type_Float = 20.0F;
  private Paint jdField_a_of_type_AndroidGraphicsPaint;
  private EditTextAutoResizeFont jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont;
  private Paint jdField_b_of_type_AndroidGraphicsPaint;
  private float c;
  private float d;
  
  public EditTextAutoResizeFont(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    a();
  }
  
  private void a()
  {
    this.jdField_a_of_type_AndroidGraphicsPaint = new Paint();
    this.jdField_a_of_type_AndroidGraphicsPaint.set(getPaint());
    this.jdField_b_of_type_AndroidGraphicsPaint = new Paint();
    if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont != null) {
      this.jdField_b_of_type_AndroidGraphicsPaint.set(this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.getPaint());
    }
    this.d = getTextSize();
    if (this.d <= jdField_a_of_type_Float) {
      this.d = jdField_b_of_type_Float;
    }
    this.c = jdField_a_of_type_Float;
  }
  
  private void a(String paramString, int paramInt)
  {
    QLog.d("EditTextAutoResizeFont", 2, "VOIP_ 自写控件：textWidth = " + paramInt);
    float f1;
    if (paramInt > 0)
    {
      f1 = getContext().getResources().getDisplayMetrics().density;
      paramInt = (int)((paramInt - getPaddingLeft() - getPaddingRight() - 3) / f1);
      f1 = this.d;
      QLog.d("EditTextAutoResizeFont", 2, "VOIP_ 自写控件：availableWidth =" + paramInt + " getPaddingLeft() = " + getPaddingLeft() + " getPaddingRight() = " + getPaddingRight() + " maxTextSize=" + this.d);
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f1);
      QLog.d("EditTextAutoResizeFont", 2, "VOIP_ 自写控件：measureText() = " + this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString) + " trySize = " + f1 + " minTextSize = " + this.c);
    }
    for (;;)
    {
      float f2 = f1;
      if (f1 > this.c)
      {
        f2 = f1;
        if (this.jdField_a_of_type_AndroidGraphicsPaint.measureText(paramString) > paramInt)
        {
          f2 = f1 - 1.0F;
          if (f2 > this.c) {
            break label261;
          }
          f2 = this.c;
        }
      }
      setTextSize(f2);
      if (this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont != null) {
        this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont.setTextSize(f2);
      }
      return;
      label261:
      this.jdField_a_of_type_AndroidGraphicsPaint.setTextSize(f2);
      f1 = f2;
      if (this.jdField_b_of_type_AndroidGraphicsPaint != null)
      {
        this.jdField_b_of_type_AndroidGraphicsPaint.setTextSize(f2);
        f1 = f2;
      }
    }
  }
  
  public void a(String paramString)
  {
    a(paramString, getWidth());
  }
  
  protected void onSizeChanged(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if (paramInt1 != paramInt3) {
      a(getText().toString(), paramInt1);
    }
  }
  
  protected void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    super.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    a(paramCharSequence.toString(), getWidth());
  }
  
  public void setOtherCtrl(EditTextAutoResizeFont paramEditTextAutoResizeFont)
  {
    this.jdField_a_of_type_ComTencentMobileqqActivityVoipEditTextAutoResizeFont = paramEditTextAutoResizeFont;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.mobileqq.activity.voip.EditTextAutoResizeFont
 * JD-Core Version:    0.7.0.1
 */