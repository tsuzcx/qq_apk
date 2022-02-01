package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.TextView;

class ReadInJoyChannelActivity$8
  implements Runnable
{
  ReadInJoyChannelActivity$8(ReadInJoyChannelActivity paramReadInJoyChannelActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.leftView != null)
    {
      if (this.aIU <= 0) {
        this.this$0.leftView.setText(2131720735);
      }
    }
    else {
      return;
    }
    if (this.aIU > 99)
    {
      this.this$0.leftView.setText(String.format("%s(%d+)", new Object[] { this.this$0.getString(2131720735), Integer.valueOf(99) }));
      return;
    }
    this.this$0.leftView.setText(String.format("%s(%d)", new Object[] { this.this$0.getString(2131720735), Integer.valueOf(this.aIU) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyChannelActivity.8
 * JD-Core Version:    0.7.0.1
 */