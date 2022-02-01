package com.tencent.qqmail.utilities.ui;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageButton;

class QMSearchBar$1
  implements TextWatcher
{
  QMSearchBar$1(QMSearchBar paramQMSearchBar) {}
  
  public void afterTextChanged(Editable paramEditable) {}
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3)
  {
    if (this.this$0.searchInput.getText().toString().length() > 0)
    {
      this.this$0.searchInputCleaner.setVisibility(0);
      return;
    }
    this.this$0.searchInputCleaner.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.utilities.ui.QMSearchBar.1
 * JD-Core Version:    0.7.0.1
 */