package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.core.protocolcenter.protocol.b;

class aj
  implements DialogInterface.OnClickListener
{
  aj(ad paramad, b paramb) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.b.a, WtLoginAccountInput.class);
    paramDialogInterface.putExtra("page_id", 4);
    paramDialogInterface.putExtra("intent.uin", this.a.c);
    this.b.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aj
 * JD-Core Version:    0.7.0.1
 */