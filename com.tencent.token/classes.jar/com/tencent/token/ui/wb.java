package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;

class wb
  implements DialogInterface.OnClickListener
{
  wb(vy paramvy) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface = new Intent(this.a.a, RealNameStep0VerifyMobileUpActivity.class);
    paramDialogInterface.putExtra("realname_mobile", RealNameStep0VerifyMobileDownActivity.access$600(this.a.a));
    paramDialogInterface.putExtra("real_uin", RealNameStep0VerifyMobileDownActivity.access$100(this.a.a));
    paramDialogInterface.putExtra("scene_id", RealNameStep0VerifyMobileDownActivity.access$700(this.a.a));
    if (RealNameStep0VerifyMobileDownActivity.access$700(this.a.a) == 1003)
    {
      paramDialogInterface.putExtra("source_id", this.a.a.mSourceId);
      paramDialogInterface.putExtra("mFrontPath", this.a.a.mFrontPath);
      paramDialogInterface.putExtra("mBackPath", this.a.a.mBackPath);
      paramDialogInterface.putExtra("mFaceData", this.a.a.mFaceData);
      paramDialogInterface.putExtra("frontphotoinfo", this.a.a.frontphotoinfo);
      paramDialogInterface.putExtra("backphotoinfo", this.a.a.backphotoinfo);
      paramDialogInterface.putExtra("canchange_uin", RealNameStep0VerifyMobileDownActivity.access$300(this.a.a));
    }
    for (;;)
    {
      this.a.a.startActivity(paramDialogInterface);
      return;
      paramDialogInterface.putExtra("realname_result", RealNameStep0VerifyMobileDownActivity.access$800(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wb
 * JD-Core Version:    0.7.0.1
 */