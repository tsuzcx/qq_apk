package com.tencent.qqmail.activity.compose;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;

class ComposeFeedbackActivity$4
  implements TextWatcher
{
  ComposeFeedbackActivity$4(ComposeFeedbackActivity paramComposeFeedbackActivity, Button paramButton) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (paramEditable.toString().equals(""))
    {
      this.val$btnClearText.setVisibility(8);
      return;
    }
    this.val$btnClearText.setVisibility(0);
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeFeedbackActivity.4
 * JD-Core Version:    0.7.0.1
 */