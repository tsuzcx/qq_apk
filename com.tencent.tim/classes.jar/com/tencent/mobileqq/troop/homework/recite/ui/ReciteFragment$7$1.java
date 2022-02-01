package com.tencent.mobileqq.troop.homework.recite.ui;

import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import apit;
import apjd;
import apkp;

public class ReciteFragment$7$1
  implements Runnable
{
  public ReciteFragment$7$1(apjd paramapjd, int paramInt) {}
  
  public void run()
  {
    if (ReciteFragment.b(this.a.b).isFinishing()) {
      return;
    }
    this.a.b.a.dUH = this.a.dUB;
    this.a.b.a.clt = this.a.dUC;
    this.a.b.a.dUR = this.dUD;
    this.a.b.jdField_b_of_type_Apit.a(true, this.a.b.a.cpO, this.a.b.a.dUR, this.a.b.a.arE, this.a.dUC, this.a.dUB);
    this.a.b.mHandler.postDelayed(new ReciteFragment.7.1.1(this), 100L);
    this.a.b.Iz.setVisibility(8);
    this.a.b.jdField_b_of_type_ComTencentMobileqqTroopHomeworkReciteUiReciteDisplayView.requestLayout();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.homework.recite.ui.ReciteFragment.7.1
 * JD-Core Version:    0.7.0.1
 */