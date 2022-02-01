package com.tencent.mobileqq.apollo.store;

import android.widget.TextView;

class ApolloGuestsStateActivity$2
  implements Runnable
{
  ApolloGuestsStateActivity$2(ApolloGuestsStateActivity paramApolloGuestsStateActivity, int paramInt) {}
  
  public void run()
  {
    if (this.this$0.PU != null)
    {
      this.this$0.PU.setText(String.valueOf(this.val$count));
      this.this$0.crz = this.val$count;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.store.ApolloGuestsStateActivity.2
 * JD-Core Version:    0.7.0.1
 */