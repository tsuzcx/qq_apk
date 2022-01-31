package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

final class xf
  implements View.OnClickListener
{
  xf(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public final void onClick(View paramView)
  {
    if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1001)
    {
      paramView = new Intent(this.a, CheckMobileAvailableActivity.class);
      paramView.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$700(this.a));
      paramView.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      paramView.putExtra("realname_mobile", RealNameStep0VerifyMobileUpActivity.access$900(this.a));
      paramView.putExtra("scene_id", RealNameStep0VerifyMobileUpActivity.access$000(this.a));
      paramView.putExtra("up_sms_scene_id", 5);
    }
    for (;;)
    {
      this.a.startActivity(paramView);
      return;
      Intent localIntent = new Intent(this.a, RealNameSmsContentTipActivity.class);
      localIntent.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      localIntent.putExtra("realname_mobile", RealNameStep0VerifyMobileUpActivity.access$900(this.a));
      localIntent.putExtra("scene_id", RealNameStep0VerifyMobileUpActivity.access$000(this.a));
      localIntent.putExtra("ish5zzb", RealNameStep0VerifyMobileUpActivity.access$600(this.a));
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1003)
      {
        localIntent.putExtra("source_id", this.a.mSourceId);
        localIntent.putExtra("mFrontPath", this.a.mFrontPath);
        localIntent.putExtra("mBackPath", this.a.mBackPath);
        localIntent.putExtra("mFaceData", this.a.mFaceData);
        localIntent.putExtra("frontphotoinfo", this.a.frontphotoinfo);
        localIntent.putExtra("backphotoinfo", this.a.backphotoinfo);
        localIntent.putExtra("canchange_uin", this.a.canchange_uin);
        localIntent.putExtra("result", RealNameStep0VerifyMobileUpActivity.access$800(this.a));
        localIntent.putExtra("up_sms_scene_id", 2);
        paramView = localIntent;
      }
      else
      {
        paramView = localIntent;
        if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1002)
        {
          localIntent.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$700(this.a));
          localIntent.putExtra("up_sms_scene_id", 1);
          paramView = localIntent;
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.xf
 * JD-Core Version:    0.7.0.1
 */