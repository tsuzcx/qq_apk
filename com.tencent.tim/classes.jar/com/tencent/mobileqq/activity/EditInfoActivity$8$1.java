package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.widget.TextView;
import uwf;

public class EditInfoActivity$8$1
  implements Runnable
{
  public EditInfoActivity$8$1(uwf paramuwf) {}
  
  public void run()
  {
    this.a.this$0.Da.setText(this.a.this$0.aMT);
    this.a.this$0.Da.setTextColor(Color.rgb(119, 119, 119));
    if (this.a.this$0.aVL)
    {
      this.a.this$0.rightViewText.setEnabled(true);
      return;
    }
    this.a.this$0.rightViewText.setEnabled(false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.8.1
 * JD-Core Version:    0.7.0.1
 */