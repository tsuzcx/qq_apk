package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class zu
  implements View.OnClickListener
{
  zu(SettingPageActivity paramSettingPageActivity) {}
  
  public final void onClick(View paramView)
  {
    paramView = new Intent(this.a, VerifyStartScanActivity.class);
    paramView.putExtra("source_from", 1);
    this.a.startActivity(paramView);
    SettingPageActivity.mShowQRNew = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.zu
 * JD-Core Version:    0.7.0.1
 */