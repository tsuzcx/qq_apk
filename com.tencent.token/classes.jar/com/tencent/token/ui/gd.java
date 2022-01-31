package com.tencent.token.ui;

import android.content.Intent;
import android.content.res.Resources;

class gd
  implements Runnable
{
  gd(fj paramfj) {}
  
  public void run()
  {
    Intent localIntent = new Intent(this.a.a, UtilsModSetMobileStep1Activity.class);
    localIntent.putExtra("title", this.a.a.getResources().getString(2131230997));
    localIntent.putExtra("op_type", 3);
    localIntent.putExtra("page_id", 15);
    this.a.a.startActivity(localIntent);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gd
 * JD-Core Version:    0.7.0.1
 */