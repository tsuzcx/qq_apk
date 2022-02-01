package com.tencent.qqmail.activity.compose;

import android.text.Editable;
import android.text.TextWatcher;
import com.tencent.qqmail.utilities.timer.TextChangeTimer;
import java.util.Locale;

class ComposeContactsActivity$17
  implements TextWatcher
{
  ComposeContactsActivity$17(ComposeContactsActivity paramComposeContactsActivity) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (!ComposeContactsActivity.access$1500(this.this$0)) {
      return;
    }
    ComposeContactsActivity.access$902(this.this$0, paramCharSequence.toString().toLowerCase(Locale.getDefault()));
    ComposeContactsActivity.access$2200(this.this$0).startTextChangedTimer(new ComposeContactsActivity.17.1(this));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeContactsActivity.17
 * JD-Core Version:    0.7.0.1
 */