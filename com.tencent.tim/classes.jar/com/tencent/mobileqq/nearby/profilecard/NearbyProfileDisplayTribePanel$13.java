package com.tencent.mobileqq.nearby.profilecard;

import acff;
import akef;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.Card;

public class NearbyProfileDisplayTribePanel$13
  implements Runnable
{
  public NearbyProfileDisplayTribePanel$13(akef paramakef) {}
  
  public void run()
  {
    Object localObject = (acff)this.this$0.a.app.getManager(51);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((acff)localObject).b(this.this$0.a.getCurrentAccountUin()))
    {
      this.this$0.a.runOnUiThread(new NearbyProfileDisplayTribePanel.13.1(this, (Card)localObject));
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.NearbyProfileDisplayTribePanel.13
 * JD-Core Version:    0.7.0.1
 */