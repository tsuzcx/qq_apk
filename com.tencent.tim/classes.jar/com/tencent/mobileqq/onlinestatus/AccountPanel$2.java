package com.tencent.mobileqq.onlinestatus;

import akrv;
import android.view.View;
import android.view.animation.TranslateAnimation;

public class AccountPanel$2
  implements Runnable
{
  public AccountPanel$2(akrv paramakrv) {}
  
  public void run()
  {
    TranslateAnimation localTranslateAnimation = new TranslateAnimation(0.0F, 0.0F, akrv.a(this.this$0).getHeight(), 0.0F);
    localTranslateAnimation.setFillEnabled(true);
    localTranslateAnimation.setStartTime(300L);
    localTranslateAnimation.setDuration(300L);
    akrv.a(this.this$0).startAnimation(localTranslateAnimation);
    akrv.a(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.onlinestatus.AccountPanel.2
 * JD-Core Version:    0.7.0.1
 */