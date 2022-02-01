package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

class AddRequestActivity$1
  implements Runnable
{
  AddRequestActivity$1(AddRequestActivity paramAddRequestActivity) {}
  
  public void run()
  {
    Card localCard = ((acff)this.this$0.app.getManager(51)).b(this.this$0.aKN);
    this.this$0.runOnUiThread(new AddRequestActivity.1.1(this, localCard));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.1
 * JD-Core Version:    0.7.0.1
 */