package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.h;

class afj
  implements View.OnClickListener
{
  afj(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public void onClick(View paramView)
  {
    h.a("interval: " + VryMobileForStrategyActivity.access$200(this.a) + "  count: " + VryMobileForStrategyActivity.access$300(this.a));
    VryMobileForStrategyActivity.access$100(this.a);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afj
 * JD-Core Version:    0.7.0.1
 */