package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;
import com.tencent.token.do;
import com.tencent.token.global.h;

class tt
  implements View.OnClickListener
{
  tt(RealNameActivity paramRealNameActivity, Dialog paramDialog) {}
  
  public void onClick(View paramView)
  {
    this.a.dismiss();
    h.a("QQUserAgent.getInstance().getCurrentUser()" + do.a().e());
    if ((RealNameActivity.access$100(this.b) == null) || (do.a().e() == null)) {
      return;
    }
    if (RealNameActivity.access$100(this.b).mVerify_sms == 1)
    {
      paramView = new Intent(this.b, RealNameStep0VerifyMobileActivity.class);
      paramView.putExtra("realname_result", RealNameActivity.access$100(this.b));
      paramView.putExtra("realname_mobile", RealNameActivity.access$100(this.b).mMaskMobile);
      if (do.a().e() != null) {
        paramView.putExtra("real_uin", do.a().e().mRealUin);
      }
      paramView.putExtra("scene_id", 1001);
      paramView.putExtra("zzb_recommend_view", RealNameActivity.access$700(this.b));
      this.b.startActivity(paramView);
      return;
    }
    this.b.dismissDialog();
    paramView = new Intent(this.b, RealNameStep1InputNameIdActivity.class);
    paramView.putExtra("realname_result", RealNameActivity.access$100(this.b));
    paramView.putExtra("real_uin", do.a().e().mRealUin);
    paramView.putExtra("zzb_recommend_view", RealNameActivity.access$700(this.b));
    this.b.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tt
 * JD-Core Version:    0.7.0.1
 */