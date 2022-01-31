package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class wf
  implements View.OnClickListener
{
  wf(RealNameSmsContentTipActivity paramRealNameSmsContentTipActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, IndexActivity.class);
    paramView.putExtra("index_from", 16);
    paramView.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$900(this.a));
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wf
 * JD-Core Version:    0.7.0.1
 */