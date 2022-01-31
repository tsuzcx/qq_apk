package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class vb
  implements View.OnClickListener
{
  vb(RealNameFindActivity paramRealNameFindActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", RealNameFindActivity.access$2000(this.a));
    paramView.putExtra("intent.determin_factors_result", RealNameFindActivity.access$3200(this.a));
    paramView.putExtra("intent.determin_verify_type", RealNameFindActivity.access$2100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vb
 * JD-Core Version:    0.7.0.1
 */