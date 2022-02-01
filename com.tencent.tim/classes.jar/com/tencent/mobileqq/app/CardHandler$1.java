package com.tencent.mobileqq.app;

import acff;
import com.tencent.mobileqq.data.Card;
import java.util.ArrayList;

class CardHandler$1
  implements Runnable
{
  CardHandler$1(CardHandler paramCardHandler, int paramInt, ArrayList paramArrayList) {}
  
  public void run()
  {
    String str = this.this$0.app.getCurrentAccountUin();
    acff localacff = (acff)this.this$0.app.getManager(51);
    Card localCard = localacff.b(str);
    if (localCard != null)
    {
      localCard.iVoteIncrement = this.cuB;
      localacff.a(localCard);
    }
    if ((this.sU != null) && (this.sU.size() > 0)) {
      CardHandler.B(str, this.sU);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.app.CardHandler.1
 * JD-Core Version:    0.7.0.1
 */