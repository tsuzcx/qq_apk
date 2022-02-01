package com.tencent.mobileqq.apollo.lightGame;

import abmd;
import acfp;
import android.widget.Button;
import android.widget.TextView;
import com.tencent.mobileqq.apollo.cmgame.CmGameStartChecker;

public class CmGameLoadingView$1
  implements Runnable
{
  CmGameLoadingView$1(CmGameLoadingView paramCmGameLoadingView, int paramInt, CmGameStartChecker paramCmGameStartChecker) {}
  
  public void run()
  {
    String str;
    if (this.cpt == 1) {
      str = acfp.m(2131704096);
    }
    for (;;)
    {
      this.this$0.PL.setText(str);
      this.this$0.PL.setVisibility(0);
      return;
      str = acfp.m(2131704094);
      this.this$0.fB.setText(acfp.m(2131704103));
      this.this$0.fB.setVisibility(0);
      this.this$0.setProgressViewVisibility(false);
      this.this$0.fB.setOnClickListener(new abmd(this));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.lightGame.CmGameLoadingView.1
 * JD-Core Version:    0.7.0.1
 */