package com.tencent.token.ui;

import android.content.res.Resources;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.tencent.token.core.bean.QQUser;

final class aaw
  implements View.OnClickListener
{
  aaw(SmsContentTipActivity paramSmsContentTipActivity) {}
  
  public final void onClick(View paramView)
  {
    SmsContentTipActivity.access$2200(this.a).setVisibility(0);
    SmsContentTipActivity.access$2300(this.a).setText(this.a.getResources().getString(2131361882));
    SmsContentTipActivity.access$2400(this.a).setClickable(false);
    SmsContentTipActivity.access$1300(this.a).setVisibility(4);
    if ((SmsContentTipActivity.access$1000(this.a) == 0) || (SmsContentTipActivity.access$1000(this.a) == 7))
    {
      SmsContentTipActivity.access$2502(this.a, false);
      SmsContentTipActivity.access$202(this.a, SmsContentTipActivity.access$2600(this.a).mRealUin + "");
    }
    this.a.startTimeTask(2);
    this.a.mHandler.sendEmptyMessage(3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aaw
 * JD-Core Version:    0.7.0.1
 */