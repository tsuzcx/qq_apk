package com.tencent.token.ui;

import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

class wo
  implements View.OnClickListener
{
  wo(RealNameStep0VerifyMobileUpActivity paramRealNameStep0VerifyMobileUpActivity) {}
  
  public void onClick(View paramView)
  {
    if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1001)
    {
      paramView = new Intent(this.a, CheckMobileAvailableActivity.class);
      paramView.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$600(this.a));
      paramView.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
      paramView.putExtra("realname_mobile", RealNameStep0VerifyMobileUpActivity.access$900(this.a));
      paramView.putExtra("scene_id", RealNameStep0VerifyMobileUpActivity.access$000(this.a));
      paramView.putExtra("zzb_recommend_view", RealNameStep0VerifyMobileUpActivity.access$700(this.a));
      paramView.putExtra("up_sms_scene_id", 5);
      this.a.startActivity(paramView);
      return;
    }
    paramView = new Intent(this.a, RealNameSmsContentTipActivity.class);
    paramView.putExtra("real_uin", RealNameStep0VerifyMobileUpActivity.access$100(this.a));
    paramView.putExtra("realname_mobile", RealNameStep0VerifyMobileUpActivity.access$900(this.a));
    paramView.putExtra("scene_id", RealNameStep0VerifyMobileUpActivity.access$000(this.a));
    paramView.putExtra("ish5zzb", RealNameStep0VerifyMobileUpActivity.access$500(this.a));
    if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1003)
    {
      paramView.putExtra("source_id", this.a.mSourceId);
      paramView.putExtra("mFrontPath", this.a.mFrontPath);
      paramView.putExtra("mBackPath", this.a.mBackPath);
      paramView.putExtra("mFaceData", this.a.mFaceData);
      paramView.putExtra("frontphotoinfo", this.a.frontphotoinfo);
      paramView.putExtra("backphotoinfo", this.a.backphotoinfo);
      paramView.putExtra("canchange_uin", this.a.canchange_uin);
      paramView.putExtra("result", RealNameStep0VerifyMobileUpActivity.access$800(this.a));
      paramView.putExtra("up_sms_scene_id", 2);
    }
    for (;;)
    {
      this.a.startActivity(paramView);
      return;
      if (RealNameStep0VerifyMobileUpActivity.access$000(this.a) == 1002)
      {
        paramView.putExtra("realname_result", RealNameStep0VerifyMobileUpActivity.access$600(this.a));
        paramView.putExtra("up_sms_scene_id", 1);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.wo
 * JD-Core Version:    0.7.0.1
 */