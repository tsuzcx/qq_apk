package com.tencent.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputFilter.LengthFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnKeyListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import java.util.ArrayList;
import java.util.List;

public class VerificationCodeInputView
  extends LinearLayout
  implements TextWatcher, View.OnKeyListener, ListenCutCopyPasteEditText.a
{
  public static final int[] tz = { 2131364852, 2131364853, 2131364854, 2131364855, 2131364856, 2131364857 };
  private final List<EditText> Lm = new ArrayList();
  private a a;
  private final InputFilter[] c = new InputFilter[0];
  private final InputFilter[] d = { new InputFilter.LengthFilter(1) };
  private Drawable gO;
  private Drawable gP;
  private int mCurPos;
  private int mMode = 4;
  
  public VerificationCodeInputView(Context paramContext)
  {
    super(paramContext);
    init();
  }
  
  public VerificationCodeInputView(Context paramContext, @Nullable AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
    init();
  }
  
  public VerificationCodeInputView(Context paramContext, @Nullable AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
    init();
  }
  
  private void exC()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = getChildCount();
    int i = 0;
    EditText localEditText;
    String str;
    if ((i < this.mMode) && (i < j))
    {
      localEditText = (EditText)getChildAt(i);
      str = localEditText.getText().toString();
      if (str.length() == 0)
      {
        localEditText.setBackgroundDrawable(this.gO);
        localEditText.requestFocus();
      }
    }
    for (i = 0;; i = 1)
    {
      if (i != 0)
      {
        if (this.a != null) {
          this.a.onComplete(localStringBuilder.toString());
        }
        setEnabled(false);
      }
      return;
      localEditText.setBackgroundDrawable(this.gP);
      localStringBuilder.append(str);
      i += 1;
      break;
    }
  }
  
  private void init()
  {
    this.gO = getResources().getDrawable(2130845908);
    this.gP = getResources().getDrawable(2130845909);
    LayoutInflater.from(getContext()).inflate(2131559741, this);
    initEditText();
  }
  
  private void initEditText()
  {
    this.Lm.clear();
    int i = 0;
    if (i < tz.length)
    {
      EditText localEditText = (EditText)findViewById(tz[i]);
      if (localEditText == null) {}
      for (;;)
      {
        i += 1;
        break;
        localEditText.setOnKeyListener(null);
        localEditText.removeTextChangedListener(this);
        localEditText.setFilters(this.c);
        localEditText.setEnabled(true);
        if (this.Lm.size() < this.mMode)
        {
          localEditText.setVisibility(0);
          localEditText.setOnKeyListener(this);
          localEditText.addTextChangedListener(this);
          localEditText.setFilters(this.d);
          localEditText.setEms(1);
          localEditText.setBackgroundDrawable(this.gO);
          this.Lm.add(localEditText);
          if ((localEditText instanceof ListenCutCopyPasteEditText)) {
            ((ListenCutCopyPasteEditText)localEditText).setCutCopyPasteCallback(this);
          }
        }
        else
        {
          localEditText.setVisibility(8);
          localEditText.setBackgroundDrawable(null);
          if ((localEditText instanceof ListenCutCopyPasteEditText)) {
            ((ListenCutCopyPasteEditText)localEditText).setCutCopyPasteCallback(null);
          }
        }
      }
    }
  }
  
  public void a(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onCut content: " + paramCharSequence);
    }
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    exC();
  }
  
  public void b(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onCopy content: " + paramCharSequence);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void c(EditText paramEditText, CharSequence paramCharSequence)
  {
    if (QLog.isColorLevel()) {
      QLog.i("VerificationCodeInputView", 2, "onPaste content: " + paramCharSequence);
    }
    if ((paramCharSequence != null) && (paramCharSequence.length() == this.mMode) && (TextUtils.isDigitsOnly(paramCharSequence))) {
      setContent(paramCharSequence.toString());
    }
  }
  
  protected void onAttachedToWindow()
  {
    super.onAttachedToWindow();
  }
  
  protected void onDetachedFromWindow()
  {
    super.onDetachedFromWindow();
  }
  
  public boolean onKey(View paramView, int paramInt, KeyEvent paramKeyEvent)
  {
    paramView = (EditText)paramView;
    if ((paramInt == 67) && (paramView.getText().length() == 0))
    {
      paramInt = paramKeyEvent.getAction();
      if ((this.mCurPos != 0) && (paramInt == 0))
      {
        this.mCurPos -= 1;
        ((EditText)this.Lm.get(this.mCurPos)).requestFocus();
        ((EditText)this.Lm.get(this.mCurPos)).setText("");
      }
    }
    return false;
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if ((paramInt1 == 0) && (paramInt3 >= 1) && (this.mCurPos != this.Lm.size() - 1))
    {
      this.mCurPos += 1;
      ((EditText)this.Lm.get(this.mCurPos)).requestFocus();
    }
  }
  
  public void setContent(String paramString)
  {
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isDigitsOnly(paramString)))
    {
      this.mCurPos = 0;
      int i;
      int j;
      label33:
      EditText localEditText;
      if (paramString == null)
      {
        i = 0;
        int k = getChildCount();
        j = 0;
        if ((j >= this.mMode) || (j >= k)) {
          return;
        }
        localEditText = (EditText)getChildAt(j);
        localEditText.setEnabled(true);
        if (j >= i) {
          break label105;
        }
        localEditText.setText(paramString.substring(j, j + 1));
        localEditText.setBackgroundDrawable(this.gP);
      }
      for (;;)
      {
        j += 1;
        break label33;
        i = paramString.length();
        break;
        label105:
        localEditText.setText("");
        localEditText.setBackgroundDrawable(this.gO);
      }
    }
  }
  
  public void setEnabled(boolean paramBoolean)
  {
    int j = getChildCount();
    int i = 0;
    while ((i < this.mMode) && (i < j))
    {
      getChildAt(i).setEnabled(paramBoolean);
      i += 1;
    }
  }
  
  public void setMode(int paramInt)
  {
    if ((paramInt != this.mMode) && ((paramInt == 4) || (paramInt == 6)))
    {
      this.mMode = paramInt;
      initEditText();
    }
  }
  
  public void setOnCompleteListener(a parama)
  {
    this.a = parama;
  }
  
  public static abstract interface a
  {
    public abstract void onComplete(String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.VerificationCodeInputView
 * JD-Core Version:    0.7.0.1
 */