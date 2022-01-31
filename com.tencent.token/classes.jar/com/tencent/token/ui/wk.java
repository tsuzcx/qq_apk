package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class wk
  implements View.OnClickListener
{
  wk(RealNameStep0VerifyMobileActivity paramRealNameStep0VerifyMobileActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameFindActivity.class);
    paramView.putExtra("source_id", RealNameStep0VerifyMobileActivity.access$300(this.a));
    paramView.putExtra("real_uin", RealNameStep0VerifyMobileActivity.access$100(this.a));
    paramView.putExtra("ish5zzb", this.a.ish5zzb);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wk
 * JD-Core Version:    0.7.0.1
 */