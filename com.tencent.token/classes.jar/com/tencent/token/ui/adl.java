package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class adl
  implements View.OnClickListener
{
  adl(UtilsActivity paramUtilsActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, VerifyStartScanActivity.class);
    this.a.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adl
 * JD-Core Version:    0.7.0.1
 */