package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

final class act
  implements View.OnClickListener
{
  act(UnbindUinActivity paramUnbindUinActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("op_type", 1);
    paramView.putExtra("title", this.a.getResources().getString(2131361846));
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.act
 * JD-Core Version:    0.7.0.1
 */