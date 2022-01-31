package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.token.el;

final class ag
  implements DialogInterface.OnClickListener
{
  ag(aa paramaa, el paramel) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.b.a, WtLoginAccountInput.class);
    paramDialogInterface.putExtra("page_id", 4);
    paramDialogInterface.putExtra("intent.uin", this.a.c);
    this.b.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ag
 * JD-Core Version:    0.7.0.1
 */