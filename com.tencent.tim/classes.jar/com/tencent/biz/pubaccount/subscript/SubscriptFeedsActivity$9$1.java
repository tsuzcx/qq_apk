package com.tencent.biz.pubaccount.subscript;

import android.widget.TextView;

class SubscriptFeedsActivity$9$1
  implements Runnable
{
  SubscriptFeedsActivity$9$1(SubscriptFeedsActivity.9 param9, int paramInt) {}
  
  public void run()
  {
    if (this.aIU <= 0)
    {
      this.a.this$0.leftView.setText(2131720735);
      return;
    }
    if (this.aIU > 99)
    {
      this.a.this$0.leftView.setText(String.format("%s(%d+)", new Object[] { this.a.this$0.getString(2131720735), Integer.valueOf(99) }));
      return;
    }
    this.a.this$0.leftView.setText(String.format("%s(%d)", new Object[] { this.a.this$0.getString(2131720735), Integer.valueOf(this.aIU) }));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.subscript.SubscriptFeedsActivity.9.1
 * JD-Core Version:    0.7.0.1
 */