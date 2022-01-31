package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class qk
  implements View.OnClickListener
{
  qk(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", NetActiveVryMobileNoSmsActivity.access$000(this.a));
    paramView.putExtra("intent.determin_factors_result", NetActiveVryMobileNoSmsActivity.access$100(this.a));
    paramView.putExtra("intent.determin_verify_type", NetActiveVryMobileNoSmsActivity.access$200(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qk
 * JD-Core Version:    0.7.0.1
 */