package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class afn
  implements DialogInterface.OnClickListener
{
  afn(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, BindUinActivity.class);
    paramDialogInterface.putExtra("intent.qquser", VryMobileForStrategyActivity.access$1200(this.a));
    paramDialogInterface.putExtra("intent.upgradedetermin", VryMobileForStrategyActivity.access$700(this.a));
    paramDialogInterface.putExtra("page_id", 13);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.afn
 * JD-Core Version:    0.7.0.1
 */