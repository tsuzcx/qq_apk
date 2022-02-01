package com.tencent.qqmail.namelist.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.Locale;

class NameListMainFragment$12
  implements TextWatcher
{
  NameListMainFragment$12(NameListMainFragment paramNameListMainFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!NameListMainFragment.access$400(this.this$0)) {
      return;
    }
    NameListMainFragment.access$802(this.this$0, paramCharSequence.toString().toLowerCase(Locale.getDefault()));
    NameListMainFragment.access$1200(this.this$0).startTextChangedTimer(new NameListMainFragment.12.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListMainFragment.12
 * JD-Core Version:    0.7.0.1
 */