package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.widget.EditText;

class adw
  implements DialogInterface.OnClickListener
{
  adw(adv paramadv) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, UtilsModSetMobileStep2SmsActivity.class);
    paramDialogInterface.putExtra("title", UtilsModSetMobileStep1Activity.access$200(this.a.a));
    paramDialogInterface.putExtra("op_type", UtilsModSetMobileStep1Activity.access$300(this.a.a));
    paramDialogInterface.putExtra("mobile", UtilsModSetMobileStep1Activity.access$000(this.a.a).getText().toString());
    paramDialogInterface.putExtra("area_code", UtilsModSetMobileStep1Activity.access$400(this.a.a));
    paramDialogInterface.putExtra("page_id", UtilsModSetMobileStep1Activity.access$500(this.a.a));
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.adw
 * JD-Core Version:    0.7.0.1
 */