package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

final class wi
  implements DialogInterface.OnClickListener
{
  wi(wh paramwh) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, RealNameStep0VerifyMobileUpActivity.class);
    paramDialogInterface.putExtra("realname_mobile", RealNameStep0VerifyMobileActivity.access$000(this.a.a));
    paramDialogInterface.putExtra("scene_id", RealNameStep0VerifyMobileActivity.access$200(this.a.a));
    paramDialogInterface.putExtra("real_uin", RealNameStep0VerifyMobileActivity.access$100(this.a.a));
    if (RealNameStep0VerifyMobileActivity.access$200(this.a.a) == 1003)
    {
      paramDialogInterface.putExtra("source_id", RealNameStep0VerifyMobileActivity.access$300(this.a.a));
      paramDialogInterface.putExtra("mFrontPath", this.a.a.mFrontPath);
      paramDialogInterface.putExtra("mBackPath", this.a.a.mBackPath);
      paramDialogInterface.putExtra("mFaceData", this.a.a.mFaceData);
      paramDialogInterface.putExtra("frontphotoinfo", this.a.a.frontphotoinfo);
      paramDialogInterface.putExtra("backphotoinfo", this.a.a.backphotoinfo);
      paramDialogInterface.putExtra("canchange_uin", RealNameStep0VerifyMobileActivity.access$400(this.a.a));
      paramDialogInterface.putExtra("result", RealNameStep0VerifyMobileActivity.access$500(this.a.a));
    }
    for (;;)
    {
      paramDialogInterface.putExtra("ish5zzb", this.a.a.ish5zzb);
      if (RealNameStep0VerifyMobileActivity.access$700(this.a.a)) {
        paramDialogInterface.putExtra("not_showLockVerify", true);
      }
      this.a.a.startActivity(paramDialogInterface);
      return;
      paramDialogInterface.putExtra("realname_result", RealNameStep0VerifyMobileActivity.access$600(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wi
 * JD-Core Version:    0.7.0.1
 */