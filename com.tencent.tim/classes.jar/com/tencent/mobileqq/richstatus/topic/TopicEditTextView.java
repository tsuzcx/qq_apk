package com.tencent.mobileqq.richstatus.topic;

import amii;
import amik;
import amil;
import amin;
import android.content.Context;
import android.text.Editable;
import android.text.Editable.Factory;
import android.text.Spannable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode.Callback;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.widget.EditText;
import com.tencent.qphone.base.util.QLog;

public class TopicEditTextView
  extends EditText
  implements TextWatcher
{
  public static Editable.Factory b;
  ActionMode.Callback a = new amil(this);
  amii b;
  int beY;
  boolean cCM;
  public boolean chQ;
  int dCd;
  private TextWatcher mTextWatcher;
  
  static
  {
    jdField_b_of_type_AndroidTextEditable$Factory = new amik();
  }
  
  public TopicEditTextView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public TopicEditTextView(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private boolean anR()
  {
    int i = getSelectionStart();
    int j = getSelectionEnd();
    if (getEditableText() == null) {
      return false;
    }
    amii[] arrayOfamii = (amii[])getEditableText().getSpans(i, j, amii.class);
    if ((arrayOfamii != null) && (arrayOfamii.length > 0) && ((arrayOfamii[0] instanceof amii)))
    {
      i = getEditableText().getSpanEnd(arrayOfamii[0]);
      j = getEditableText().getSpanStart(arrayOfamii[0]);
      if ((j >= 0) && (i > j)) {
        return false;
      }
    }
    return true;
  }
  
  private void init()
  {
    setEditableFactory(jdField_b_of_type_AndroidTextEditable$Factory);
    setCustomSelectionActionModeCallback(this.a);
    super.addTextChangedListener(this);
  }
  
  public void addTextChangedListener(TextWatcher paramTextWatcher)
  {
    this.mTextWatcher = paramTextWatcher;
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (this.chQ) {}
    for (;;)
    {
      return;
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, String.format("afterTextChanged [delTopic=%s] src=%s", new Object[] { this.jdField_b_of_type_Amii, paramEditable }));
      }
      if (this.jdField_b_of_type_Amii != null)
      {
        int i = paramEditable.getSpanStart(this.jdField_b_of_type_Amii);
        int j = paramEditable.getSpanEnd(this.jdField_b_of_type_Amii);
        if ((i >= 0) && (j > i))
        {
          this.chQ = true;
          paramEditable.delete(i, j);
          if (QLog.isColorLevel()) {
            QLog.i("TopicEditTextView", 2, String.format("afterTextChanged after delete=%s", new Object[] { paramEditable }));
          }
          this.chQ = false;
          setSelection(i);
        }
      }
      while (this.mTextWatcher != null)
      {
        this.mTextWatcher.afterTextChanged(paramEditable);
        return;
        if (!this.cCM) {}
      }
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.chQ) {
      return;
    }
    this.jdField_b_of_type_Amii = null;
    if ((paramCharSequence instanceof Spannable))
    {
      Spannable localSpannable = (Spannable)paramCharSequence;
      amii localamii = amin.a(localSpannable, paramInt1);
      if (localamii != null)
      {
        int i = localSpannable.getSpanStart(localamii);
        int j = localSpannable.getSpanEnd(localamii);
        if ((j >= 0) && (j >= i) && (paramInt2 > paramInt3)) {
          this.jdField_b_of_type_Amii = localamii;
        }
      }
    }
    if (paramInt3 >= paramInt2) {}
    for (boolean bool = true;; bool = false)
    {
      this.cCM = bool;
      this.beY = paramInt1;
      this.dCd = paramInt3;
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, String.format("beforeTextChanged [bAdd=%b][delTopic=%s][edit=%s]", new Object[] { Boolean.valueOf(this.cCM), this.jdField_b_of_type_Amii, paramCharSequence }));
      }
      if (this.mTextWatcher == null) {
        break;
      }
      this.mTextWatcher.beforeTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
      return;
    }
  }
  
  protected void onCreateContextMenu(ContextMenu paramContextMenu)
  {
    if (anR()) {
      super.onCreateContextMenu(paramContextMenu);
    }
  }
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if (getEditableText() == null) {}
    int i;
    int j;
    do
    {
      do
      {
        amii[] arrayOfamii;
        do
        {
          return;
          arrayOfamii = (amii[])getEditableText().getSpans(paramInt1, paramInt2, amii.class);
        } while ((arrayOfamii == null) || (arrayOfamii.length <= 0));
        i = getEditableText().getSpanEnd(arrayOfamii[0]);
        j = getEditableText().getSpanStart(arrayOfamii[0]);
      } while ((i <= j) || (j < 0));
      if ((paramInt1 == j) && (paramInt2 == i))
      {
        setSelection(i);
        return;
      }
    } while (((paramInt1 >= i) && (paramInt2 >= i)) || ((paramInt1 <= j) && (paramInt2 <= j)));
    setSelection(i, i);
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.mTextWatcher != null) {
      this.mTextWatcher.onTextChanged(paramCharSequence, paramInt1, paramInt2, paramInt3);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    try
    {
      boolean bool = super.onTouchEvent(paramMotionEvent);
      return bool;
    }
    catch (Throwable paramMotionEvent)
    {
      if (QLog.isColorLevel()) {
        QLog.i("TopicEditTextView", 2, paramMotionEvent.getMessage(), paramMotionEvent);
      }
      try
      {
        setSelection(getEditableText().length());
        return true;
      }
      catch (Throwable paramMotionEvent) {}
    }
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.richstatus.topic.TopicEditTextView
 * JD-Core Version:    0.7.0.1
 */