package com.tencent.qqmail.account.helper;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageButton;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class Helper$5
  implements View.OnClickListener
{
  Helper$5(EditText paramEditText, ImageButton paramImageButton) {}
  
  public void onClick(View paramView)
  {
    int i = this.val$editText.getSelectionEnd();
    if (this.val$editText.getInputType() == 129)
    {
      this.val$editText.setInputType(144);
      this.val$passwordStateButton.setImageResource(2130841043);
    }
    for (;;)
    {
      this.val$editText.setSelection(i);
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      this.val$editText.setInputType(129);
      this.val$passwordStateButton.setImageResource(2130841042);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.5
 * JD-Core Version:    0.7.0.1
 */