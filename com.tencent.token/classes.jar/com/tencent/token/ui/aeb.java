package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class aeb
  implements DialogInterface.OnClickListener
{
  aeb(aea paramaea) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, UtilsModSetMobileStep2SmsActivity.class);
    paramDialogInterface.putExtra("title", UtilsModSetMobileStep2Activity.access$100(this.a.a));
    paramDialogInterface.putExtra("op_type", UtilsModSetMobileStep2Activity.access$200(this.a.a));
    paramDialogInterface.putExtra("mobile", UtilsModSetMobileStep2Activity.access$300(this.a.a));
    paramDialogInterface.putExtra("area_code", UtilsModSetMobileStep2Activity.access$400(this.a.a));
    paramDialogInterface.putExtra("page_id", UtilsModSetMobileStep2Activity.access$500(this.a.a));
    this.a.a.startActivity(paramDialogInterface);
    this.a.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.aeb
 * JD-Core Version:    0.7.0.1
 */