package com.tencent.qqmail.movemail;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import com.tencent.qqmail.view.QMTopBar;

class ManageFolderActivity$6
  implements TextWatcher
{
  ManageFolderActivity$6(ManageFolderActivity paramManageFolderActivity) {}
  
  public void afterTextChanged(Editable paramEditable)
  {
    View localView = ManageFolderActivity.access$1500(this.this$0).getButtonRight();
    if (paramEditable.toString().length() != 0) {}
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
 * Qualified Name:     com.tencent.qqmail.movemail.ManageFolderActivity.6
 * JD-Core Version:    0.7.0.1
 */