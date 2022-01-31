package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class rc
  implements DialogInterface.OnClickListener
{
  rc(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, NetActiveVryOtherListActivity.class);
    paramDialogInterface.putExtra("page_id", NetActiveVryMobileNoSmsActivity.access$500(this.a));
    paramDialogInterface.putExtra("intent.qquser", NetActiveVryMobileNoSmsActivity.access$400(this.a));
    paramDialogInterface.putExtra("intent.upgradedetermin", NetActiveVryMobileNoSmsActivity.access$200(this.a));
    this.a.startActivity(paramDialogInterface);
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.rc
 * JD-Core Version:    0.7.0.1
 */