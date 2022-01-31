package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class vw
  implements View.OnClickListener
{
  vw(RealNameStep0VerifyMobileActivity paramRealNameStep0VerifyMobileActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, RealNameFindActivity.class);
    paramView.putExtra("source_id", RealNameStep0VerifyMobileActivity.access$300(this.a));
    paramView.putExtra("real_uin", RealNameStep0VerifyMobileActivity.access$100(this.a));
    paramView.putExtra("ish5zzb", this.a.ish5zzb);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vw
 * JD-Core Version:    0.7.0.1
 */