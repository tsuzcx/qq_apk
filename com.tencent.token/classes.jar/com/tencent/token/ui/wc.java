package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

final class wc
  implements DialogInterface.OnCancelListener
{
  wc(vu paramvu) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent(this.a.a, RealNameFindActivity.class);
    paramDialogInterface.putExtra("result", RealNameSmsContentTipActivity.access$1100(this.a.a));
    paramDialogInterface.putExtra("real_uin", RealNameSmsContentTipActivity.access$100(this.a.a));
    paramDialogInterface.putExtra("source_id", RealNameSmsContentTipActivity.access$400(this.a.a));
    paramDialogInterface.putExtra("mFrontPath", this.a.a.mFrontPath);
    paramDialogInterface.putExtra("mBackPath", this.a.a.mBackPath);
    paramDialogInterface.putExtra("mFaceData", this.a.a.mFaceData);
    paramDialogInterface.putExtra("frontphotoinfo", this.a.a.frontphotoinfo);
    paramDialogInterface.putExtra("backphotoinfo", this.a.a.backphotoinfo);
    paramDialogInterface.putExtra("ish5zzb", RealNameSmsContentTipActivity.access$900(this.a.a));
    paramDialogInterface.putExtra("canchange_uin", this.a.a.canchange_uin);
    paramDialogInterface.addFlags(67108864);
    paramDialogInterface.putExtra("reupload", true);
    this.a.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wc
 * JD-Core Version:    0.7.0.1
 */