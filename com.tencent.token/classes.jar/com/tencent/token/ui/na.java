package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class na
  implements View.OnClickListener
{
  na(JLAppealListDetailActivity paramJLAppealListDetailActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, FindItemsActivity.class);
    paramView.addFlags(67108864);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.na
 * JD-Core Version:    0.7.0.1
 */