package com.tencent.biz.pubaccount.readinjoy.activity;

import android.widget.TextView;

class ReadInJoyFeedsActivity$4
  implements Runnable
{
  ReadInJoyFeedsActivity$4(ReadInJoyFeedsActivity paramReadInJoyFeedsActivity, int paramInt) {}
  
  public void run()
  {
    if (this.aIU <= 0)
    {
      this.this$0.leftView.setText(2131720735);
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
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.activity.ReadInJoyFeedsActivity.4
 * JD-Core Version:    0.7.0.1
 */