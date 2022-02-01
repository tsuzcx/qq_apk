package com.tencent.qqmail.account.helper;

import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

final class Helper$3
  implements View.OnClickListener
{
  Helper$3(View paramView, EditText paramEditText) {}
  
  public void onClick(View paramView)
  {
    if (this.val$clearButton.getVisibility() == 0) {
      this.val$editText.setText("");
    }
    EventCollector.getInstance().onViewClicked(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.account.helper.Helper.3
 * JD-Core Version:    0.7.0.1
 */