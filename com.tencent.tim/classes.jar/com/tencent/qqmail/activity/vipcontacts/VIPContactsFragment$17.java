package com.tencent.qqmail.activity.vipcontacts;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.Locale;

class VIPContactsFragment$17
  implements TextWatcher
{
  VIPContactsFragment$17(VIPContactsFragment paramVIPContactsFragment) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!VIPContactsFragment.access$2100(this.this$0)) {
      return;
    }
    VIPContactsFragment.access$1402(this.this$0, paramCharSequence.toString().toLowerCase(Locale.getDefault()));
    VIPContactsFragment.access$2800(this.this$0).startTextChangedTimer(new VIPContactsFragment.17.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.vipcontacts.VIPContactsFragment.17
 * JD-Core Version:    0.7.0.1
 */