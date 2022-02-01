package com.tencent.mobileqq.activity;

import android.graphics.Color;
import android.widget.TextView;
import uwf;

public class EditInfoActivity$8$2
  implements Runnable
{
  public EditInfoActivity$8$2(uwf paramuwf, int paramInt) {}
  
  public void run()
  {
    this.a.this$0.Da.setText(this.a.this$0.aMT);
    if (this.val$length > this.a.this$0.bGH)
    {
      this.a.this$0.Da.setTextColor(-65536);
      this.a.this$0.rightViewText.setEnabled(false);
      return;
    }
    this.a.this$0.Da.setTextColor(Color.rgb(119, 119, 119));
    this.a.this$0.rightViewText.setEnabled(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.EditInfoActivity.8.2
 * JD-Core Version:    0.7.0.1
 */