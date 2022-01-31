package com.tencent.token.ui;

import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.view.View;
import android.view.View.OnClickListener;

class abo
  implements View.OnClickListener
{
  abo(UtilsActivity paramUtilsActivity) {}
  
  public void onClick(View paramView)
  {
    LocalBroadcastManager.getInstance(this.a).sendBroadcast(new Intent("com.tencent.token.open_menu"));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.abo
 * JD-Core Version:    0.7.0.1
 */