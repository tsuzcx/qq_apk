package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;

class zn
  implements View.OnClickListener
{
  zn(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public void onClick(View paramView)
  {
    SmsContentTipActivity.access$2900(this.a).setVisibility(0);
    SmsContentTipActivity.access$3000(this.a).setText(this.a.getResources().getString(2131231129));
    SmsContentTipActivity.access$3100(this.a).setClickable(false);
    SmsContentTipActivity.access$1500(this.a).setVisibility(4);
    if ((SmsContentTipActivity.access$1200(this.a) == 0) || (SmsContentTipActivity.access$1200(this.a) == 7))
    {
      SmsContentTipActivity.access$3202(this.a, false);
      SmsContentTipActivity.access$302(this.a, SmsContentTipActivity.access$2000(this.a).mRealUin + "");
    }
    this.a.startTimeTask();
    this.a.mHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zn
 * JD-Core Version:    0.7.0.1
 */