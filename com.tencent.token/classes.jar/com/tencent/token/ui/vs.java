package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;

class vs
  implements View.OnClickListener
{
  vs(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity) {}
  
  public void onClick(View paramView)
  {
    RealNameSmsContentTipActivity.access$1200(this.a).setVisibility(0);
    RealNameSmsContentTipActivity.access$1400(this.a).setText(this.a.getResources().getString(2131231129));
    RealNameSmsContentTipActivity.access$1000(this.a).setVisibility(4);
    RealNameSmsContentTipActivity.access$202(this.a, 0);
    RealNameSmsContentTipActivity.access$1300(this.a).setClickable(false);
    this.a.mHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vs
 * JD-Core Version:    0.7.0.1
 */