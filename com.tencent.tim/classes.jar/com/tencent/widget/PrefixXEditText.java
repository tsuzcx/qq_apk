package com.tencent.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.util.AttributeSet;

public class PrefixXEditText
  extends XEditText
  implements TextWatcher
{
  protected String mPrefix;
  
  public PrefixXEditText(Context paramContext)
  {
    super(paramContext);
  }
  
  public PrefixXEditText(Context paramContext, AttributeSet paramAttributeSet)
  {
    super(paramContext, paramAttributeSet);
  }
  
  public void afterTextChanged(Editable paramEditable)
  {
    if ((!TextUtils.isEmpty(this.mPrefix)) && (!paramEditable.toString().startsWith(this.mPrefix))) {
      paramEditable.replace(0, paramEditable.length(), this.mPrefix);
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  protected void onSelectionChanged(int paramInt1, int paramInt2)
  {
    super.onSelectionChanged(paramInt1, paramInt2);
    if ((!TextUtils.isEmpty(this.mPrefix)) && (getText().length() >= this.mPrefix.length())) {
      if (paramInt1 >= this.mPrefix.length()) {
        break label87;
      }
    }
    label87:
    for (int i = this.mPrefix.length();; i = paramInt1)
    {
      if (paramInt2 < i) {}
      for (int j = i;; j = paramInt2)
      {
        if ((i != paramInt1) || (j != paramInt2)) {
          setSelection(i, j);
        }
        return;
      }
    }
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void setPrefix(String paramString, int paramInt)
  {
    this.mPrefix = paramString;
    if (!TextUtils.isEmpty(this.mPrefix))
    {
      setText(this.mPrefix);
      setSelection(this.mPrefix.length());
      getEditableText().setSpan(new ForegroundColorSpan(paramInt), 0, this.mPrefix.length(), 17);
      addTextChangedListener(this);
      return;
    }
    removeTextChangedListener(this);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.widget.PrefixXEditText
 * JD-Core Version:    0.7.0.1
 */