package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class adz
  implements View.OnClickListener
{
  adz(UtilsGameProtectActivity paramUtilsGameProtectActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, WtLoginAccountInput.class);
    paramView.putExtra("page_id", 4);
    this.a.startActivity(paramView);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adz
 * JD-Core Version:    0.7.0.1
 */