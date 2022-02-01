package com.tencent.qqmail.movenote;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.qqmail.view.QMTopBar;

class AddNoteCatalogActivity$2
  implements TextWatcher
{
  AddNoteCatalogActivity$2(AddNoteCatalogActivity paramAddNoteCatalogActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    View localView = AddNoteCatalogActivity.access$100(this.this$0).getButtonRight();
    if (paramEditable.toString().trim().length() != 0) {}
    for (boolean bool = true;; bool = false)
    {
      localView.setEnabled(bool);
      return;
    }
  }
  
  public void beforeTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
  
  public void onTextChanged(CharSequence paramCharSequence, int paramInt1, int paramInt2, int paramInt3) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.movenote.AddNoteCatalogActivity.2
 * JD-Core Version:    0.7.0.1
 */