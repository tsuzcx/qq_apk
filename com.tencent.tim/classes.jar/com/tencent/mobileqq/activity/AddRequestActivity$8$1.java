package com.tencent.mobileqq.activity;

import acff;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;
import ufj;

public class AddRequestActivity$8$1
  implements Runnable
{
  public AddRequestActivity$8$1(ufj paramufj) {}
  
  public void run()
  {
    Card localCard = ((acff)this.a.this$0.app.getManager(51)).b(this.a.this$0.aKN);
    if (localCard != null) {
      this.a.this$0.runOnUiThread(new AddRequestActivity.8.1.1(this, localCard));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.AddRequestActivity.8.1
 * JD-Core Version:    0.7.0.1
 */