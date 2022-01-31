package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class le
  implements DialogInterface.OnClickListener
{
  le(lc paramlc) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.a.dismissDialog();
    paramDialogInterface = new Intent(this.a.a, WtLoginAccountInput.class);
    paramDialogInterface.putExtra("page_id", 4);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.le
 * JD-Core Version:    0.7.0.1
 */