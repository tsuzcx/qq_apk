package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class rj
  implements View.OnClickListener
{
  rj(NetActiveVryQuesActivity paramNetActiveVryQuesActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", NetActiveVryQuesActivity.access$500(this.a));
    paramView.putExtra("intent.determin_factors_result", NetActiveVryQuesActivity.access$200(this.a));
    paramView.putExtra("intent.determin_verify_type", NetActiveVryQuesActivity.access$100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rj
 * JD-Core Version:    0.7.0.1
 */