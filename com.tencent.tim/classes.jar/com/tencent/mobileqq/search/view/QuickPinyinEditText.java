package com.tencent.mobileqq.search.view;

import alla;
import android.content.Context;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.qphone.base.util.BaseApplication;
import com.tencent.qphone.base.util.QLog;

public class QuickPinyinEditText
  extends EditText
{
  private static String lastPinyin;
  private volatile boolean cEw;
  private volatile String ccv = "";
  public int dEb = 200;
  
  public QuickPinyinEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public QuickPinyinEditText(Context paramContext, AttributeSet paramAttributeSet, int paramInt)
  {
    super(paramContext, paramAttributeSet, paramInt);
  }
  
  private void Qb(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "updateInputtingStatus : " + paramString);
    }
    if ((TextUtils.isEmpty(paramString)) || (TextUtils.isEmpty(paramString.trim())))
    {
      this.cEw = false;
      return;
    }
    this.cEw = true;
  }
  
  private void Qc(String paramString)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "updateInputtingText : " + paramString);
    }
    Qb(paramString);
    if (paramString == null) {}
    int i;
    int j;
    Editable localEditable;
    do
    {
      do
      {
        return;
        i = getSelectionStart();
        j = getSelectionEnd();
        localEditable = getText();
      } while (localEditable.length() + paramString.length() > this.dEb);
      if (j > i)
      {
        localEditable.replace(i, j, paramString);
        setSelection(i, paramString.length() + i);
        lastPinyin = paramString;
        return;
      }
    } while ((j != i) || (j == -1));
    localEditable.insert(i, paramString);
    setSelection(i, paramString.length() + i);
    lastPinyin = paramString;
  }
  
  public boolean awp()
  {
    boolean bool2 = false;
    String str = getText().toString();
    StringBuilder localStringBuilder;
    if (QLog.isColorLevel())
    {
      localStringBuilder = new StringBuilder().append("isInputtingPinYin :  currentText= ").append(str).append("  isInputting=");
      if ((!str.startsWith(this.ccv)) || (str.equals(this.ccv))) {
        break label94;
      }
    }
    label94:
    for (boolean bool1 = true;; bool1 = false)
    {
      QLog.d("QuickPinyinEditText", 2, bool1);
      bool1 = bool2;
      if (awq()) {
        bool1 = this.cEw;
      }
      return bool1;
    }
  }
  
  public boolean awq()
  {
    String str = alla.getString(getContext().getContentResolver(), "default_input_method");
    return (str != null) && (str.contains("com.sohu.inputmethod.sogou"));
  }
  
  public void dOF()
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "notifyInputMethodSuggestCommit : ");
    }
    if ((!TextUtils.isEmpty(lastPinyin)) && (awq()))
    {
      ((InputMethodManager)BaseApplicationImpl.getContext().getSystemService("input_method")).sendAppPrivateCommand(this, "com.sohu.inputmethod.sogou.search.enter", null);
      setSelection(getText().length());
    }
  }
  
  public InputConnection onCreateInputConnection(EditorInfo paramEditorInfo)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "onCreateInputConnection : ");
    }
    return super.onCreateInputConnection(paramEditorInfo);
  }
  
  public boolean onPrivateIMECommand(String paramString, Bundle paramBundle)
  {
    String str;
    if (paramBundle != null)
    {
      str = paramBundle.getString("req");
      if ((!"com.sohu.inputmethod.sogou.send.input".equals(paramString)) || (!awq())) {
        break label39;
      }
      Qc(str);
    }
    for (;;)
    {
      return super.onPrivateIMECommand(paramString, paramBundle);
      label39:
      Qb(str);
    }
  }
  
  public boolean onTouchEvent(MotionEvent paramMotionEvent)
  {
    if (QLog.isColorLevel()) {
      QLog.d("QuickPinyinEditText", 2, "onTouchEvent : ");
    }
    dOF();
    return super.onTouchEvent(paramMotionEvent);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.search.view.QuickPinyinEditText
 * JD-Core Version:    0.7.0.1
 */