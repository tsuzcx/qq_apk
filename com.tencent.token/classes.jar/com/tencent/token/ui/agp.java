package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class agp
  implements DialogInterface.OnClickListener
{
  agp(VryMobileForStrategyActivity paramVryMobileForStrategyActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a, BindUinActivity.class);
    paramDialogInterface.putExtra("intent.qquser", VryMobileForStrategyActivity.access$1600(this.a));
    paramDialogInterface.putExtra("intent.upgradedetermin", VryMobileForStrategyActivity.access$1100(this.a));
    paramDialogInterface.putExtra("page_id", 13);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.agp
 * JD-Core Version:    0.7.0.1
 */