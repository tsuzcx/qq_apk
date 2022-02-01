package com.tencent.qqmail.namelist.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import com.tencent.qqmail.view.QMTopBar;

class NameListAddFragment$4
  implements TextWatcher
{
  NameListAddFragment$4(NameListAddFragment paramNameListAddFragment) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.length() > 0)
    {
      NameListAddFragment.access$100(this.this$0).getButtonRight().setEnabled(true);
      return;
    }
    NameListAddFragment.access$100(this.this$0).getButtonRight().setEnabled(false);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    NameListAddFragment.access$200(this.this$0).setTextColor(-16777216);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.namelist.fragment.NameListAddFragment.4
 * JD-Core Version:    0.7.0.1
 */