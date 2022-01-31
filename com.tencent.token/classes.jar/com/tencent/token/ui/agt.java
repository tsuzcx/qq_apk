package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.global.e;

final class agt
  implements View.OnClickListener
{
  agt(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public final void onClick(View paramView)
  {
    e.a("interval: " + VryMobileForStrategyActivity.access$500(this.a) + "  count: " + VryMobileForStrategyActivity.access$600(this.a));
    VryMobileForStrategyActivity.access$400(this.a, false);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agt
 * JD-Core Version:    0.7.0.1
 */