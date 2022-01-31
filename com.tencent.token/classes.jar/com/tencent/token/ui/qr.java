package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;
import com.tencent.token.core.bean.DeterminVerifyFactorsResult;

class qr
  implements DialogInterface.OnCancelListener
{
  qr(NetActiveVryMobileNoSmsActivity paramNetActiveVryMobileNoSmsActivity) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    NetActiveVryMobileNoSmsActivity.access$602(this.a, 0);
    if (NetActiveVryMobileNoSmsActivity.access$100(this.a).j())
    {
      paramDialogInterface = new Intent(this.a, GeneralVerifyMobileUpActivity.class);
      paramDialogInterface.putExtra("intent.qquser", NetActiveVryMobileNoSmsActivity.access$000(this.a));
      paramDialogInterface.putExtra("intent.determin_factors_result", NetActiveVryMobileNoSmsActivity.access$100(this.a));
      paramDialogInterface.putExtra("intent.determin_verify_type", NetActiveVryMobileNoSmsActivity.access$200(this.a));
      paramDialogInterface.putExtra("intent.determin_verify_factor_id", 3);
      this.a.startActivity(paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.qr
 * JD-Core Version:    0.7.0.1
 */