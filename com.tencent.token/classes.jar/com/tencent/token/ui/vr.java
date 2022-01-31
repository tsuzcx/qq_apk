package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

class vr
  implements DialogInterface.OnCancelListener
{
  vr(vj paramvj) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent(this.a.a, RealNameFindActivity.class);
    paramDialogInterface.putExtra("result", RealNameSmsContentTipActivity.access$1100(this.a.a));
    paramDialogInterface.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a.a));
    paramDialogInterface.putExtra("source_id", RealNameSmsContentTipActivity.access$600(this.a.a));
    paramDialogInterface.putExtra("mFrontPath", this.a.a.mFrontPath);
    paramDialogInterface.putExtra("mBackPath", this.a.a.mBackPath);
    paramDialogInterface.putExtra("mFaceData", this.a.a.mFaceData);
    paramDialogInterface.putExtra("frontphotoinfo", this.a.a.frontphotoinfo);
    paramDialogInterface.putExtra("backphotoinfo", this.a.a.backphotoinfo);
    paramDialogInterface.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$700(this.a.a));
    paramDialogInterface.putExtra("canchange_uin", this.a.a.canchange_uin);
    paramDialogInterface.addFlags(67108864);
    paramDialogInterface.putExtra("reupload", true);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.vr
 * JD-Core Version:    0.7.0.1
 */