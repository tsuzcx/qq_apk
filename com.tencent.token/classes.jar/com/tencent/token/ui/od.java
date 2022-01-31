package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class od
  implements DialogInterface.OnClickListener
{
  od(LogoActivity paramLogoActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, WtLoginAccountInput.class);
    paramDialogInterface.putExtra("page_id", 3);
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.od
 * JD-Core Version:    0.7.0.1
 */