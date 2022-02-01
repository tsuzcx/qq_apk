package com.tencent.qqmail.utilities.richeditor;

import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;

class QMEditor$3
  implements TextWatcher
{
  QMEditor$3(QMEditor paramQMEditor) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    Log.v("baggio", "afterTextChanged");
    if (paramEditable.length() == 0) {}
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.v("baggio", "beforeTextChanged");
  }
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    Log.v("baggio", "onTextChanged");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.richeditor.QMEditor.3
 * JD-Core Version:    0.7.0.1
 */