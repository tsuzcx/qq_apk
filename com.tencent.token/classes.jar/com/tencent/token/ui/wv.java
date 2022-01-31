package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import android.content.Intent;

final class wv
  implements DialogInterface.OnCancelListener
{
  wv(RealNameStep0VerifyMobileDownActivity paramRealNameStep0VerifyMobileDownActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    paramDialogInterface = new Intent(this.a, RealNameFindActivity.class);
    paramDialogInterface.putExtra("result", RealNameStep0VerifyMobileDownActivity.access$1800(this.a));
    paramDialogInterface.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$400(this.a));
    paramDialogInterface.putExtra("source_id", this.a.mSourceId);
    paramDialogInterface.putExtra("mFrontPath", this.a.mFrontPath);
    paramDialogInterface.putExtra("mBackPath", this.a.mBackPath);
    paramDialogInterface.putExtra("mFaceData", this.a.mFaceData);
    paramDialogInterface.putExtra("frontphotoinfo", this.a.frontphotoinfo);
    paramDialogInterface.putExtra("backphotoinfo", this.a.backphotoinfo);
    paramDialogInterface.putExtra("ish5zzb", RealNameStep0VerifyMobileDownActivity.access$700(this.a));
    paramDialogInterface.putExtra("canchange_uin", RealNameStep0VerifyMobileDownActivity.access$800(this.a));
    paramDialogInterface.addFlags(67108864);
    paramDialogInterface.putExtra("reupload", true);
    this.a.startActivity(paramDialogInterface);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wv
 * JD-Core Version:    0.7.0.1
 */