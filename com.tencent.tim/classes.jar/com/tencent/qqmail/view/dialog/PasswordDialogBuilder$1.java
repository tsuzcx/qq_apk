package com.tencent.qqmail.view.dialog;

import android.view.View;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

class PasswordDialogBuilder$1
  implements View.OnFocusChangeListener
{
  PasswordDialogBuilder$1(PasswordDialogBuilder paramPasswordDialogBuilder) {}
  
  public void onFocusChange(View paramView, boolean paramBoolean)
  {
    if (!paramBoolean)
    {
      PasswordDialogBuilder.access$000(this.this$0).setVisibility(8);
      return;
    }
    PasswordDialogBuilder.access$100(this.this$0).setVisibility(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.dialog.PasswordDialogBuilder.1
 * JD-Core Version:    0.7.0.1
 */