package com.tencent.qqmail.view.dialog;

import android.text.Editable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;
import android.widget.ImageView;
import com.tencent.qqlive.module.videoreport.collect.EventCollector;

class PasswordDialogBuilder$2
  implements View.OnClickListener
{
  PasswordDialogBuilder$2(PasswordDialogBuilder paramPasswordDialogBuilder) {}
  
  public void onClick(View paramView)
  {
    if (PasswordDialogBuilder.access$200(this.this$0).getInputType() == 129)
    {
      PasswordDialogBuilder.access$300(this.this$0).setInputType(144);
      PasswordDialogBuilder.access$400(this.this$0).setImageResource(2130841043);
    }
    for (;;)
    {
      PasswordDialogBuilder.access$900(this.this$0).setSelection(PasswordDialogBuilder.access$800(this.this$0).getText().length());
      EventCollector.getInstance().onViewClicked(paramView);
      return;
      if (PasswordDialogBuilder.access$500(this.this$0).getInputType() == 144)
      {
        PasswordDialogBuilder.access$600(this.this$0).setInputType(129);
        PasswordDialogBuilder.access$700(this.this$0).setImageResource(2130841042);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmail.view.dialog.PasswordDialogBuilder.2
 * JD-Core Version:    0.7.0.1
 */