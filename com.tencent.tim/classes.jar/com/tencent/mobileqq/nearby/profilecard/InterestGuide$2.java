package com.tencent.mobileqq.nearby.profilecard;

import ajrb;
import akbv;
import android.content.Context;
import android.view.View;
import anot;
import com.tencent.mobileqq.app.BaseActivity;

public class InterestGuide$2
  implements Runnable
{
  public InterestGuide$2(akbv paramakbv) {}
  
  public void run()
  {
    ajrb.c(this.this$0.mAccount, "interest_guide_key", Boolean.FALSE);
    Context localContext = this.this$0.mLayout.getContext();
    if ((localContext instanceof BaseActivity)) {
      anot.a(((BaseActivity)localContext).app, "dc00898", "", "", "0X8006991", "0X8006991", 0, 0, "", "", "", "");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.nearby.profilecard.InterestGuide.2
 * JD-Core Version:    0.7.0.1
 */