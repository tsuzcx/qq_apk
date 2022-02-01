package com.tencent.qqmail.activity.compose;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.Locale;

class ComposeMobileContactsActivity$14
  implements TextWatcher
{
  ComposeMobileContactsActivity$14(ComposeMobileContactsActivity paramComposeMobileContactsActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ComposeMobileContactsActivity.access$1200(this.this$0)) {
      return;
    }
    ComposeMobileContactsActivity.access$602(this.this$0, paramCharSequence.toString().toLowerCase(Locale.getDefault()));
    ComposeMobileContactsActivity.access$1900(this.this$0).startTextChangedTimer(new ComposeMobileContactsActivity.14.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeMobileContactsActivity.14
 * JD-Core Version:    0.7.0.1
 */