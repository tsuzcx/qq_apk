package com.tencent.qqmail.utilities.ui;

import android.text.Editable;
import android.text.TextWatcher;
import java.util.Map;

class QMEditDialog$EditBuilder$1
  implements TextWatcher
{
  QMEditDialog$EditBuilder$1(QMEditDialog.EditBuilder paramEditBuilder, String paramString) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    if (!paramEditable.toString().equals(QMEditDialog.EditBuilder.access$200(this.this$0).get(this.val$name))) {
      QMEditDialog.EditBuilder.access$200(this.this$0).put(this.val$name, paramEditable.toString());
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMEditDialog.EditBuilder.1
 * JD-Core Version:    0.7.0.1
 */