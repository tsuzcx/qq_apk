package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

class rb
  implements View.OnClickListener
{
  rb(NetActiveVryQQTokenActivity paramNetActiveVryQQTokenActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = (EditText)this.a.findViewById(2131559085);
    if (paramView != null) {
      paramView.clearFocus();
    }
    paramView = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramView.putExtra("intent.qquser", NetActiveVryQQTokenActivity.access$500(this.a));
    paramView.putExtra("intent.determin_factors_result", NetActiveVryQQTokenActivity.access$200(this.a));
    paramView.putExtra("intent.determin_verify_type", NetActiveVryQQTokenActivity.access$100(this.a));
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rb
 * JD-Core Version:    0.7.0.1
 */