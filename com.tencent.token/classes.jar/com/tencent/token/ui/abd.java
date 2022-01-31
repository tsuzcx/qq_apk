package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;
import android.view.View;
import android.view.View.OnClickListener;

class abd
  implements View.OnClickListener
{
  abd(UnbindUinActivity paramUnbindUinActivity) {}
  
  public void onClick(View paramView)
  {
    paramView = new Intent(this.a, UtilsModSetMobileStep1Activity.class);
    paramView.putExtra("op_type", 1);
    paramView.putExtra("title", this.a.getResources().getString(2131230788));
    paramView.putExtra("page_id", 14);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abd
 * JD-Core Version:    0.7.0.1
 */