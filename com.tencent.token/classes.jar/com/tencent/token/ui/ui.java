package com.tencent.token.ui;

import android.app.Dialog;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.ax;
import com.tencent.token.core.bean.QQUser;
import com.tencent.token.core.bean.RealNameStatusResult;

final class ui
  implements View.OnClickListener
{
  ui(RealNameActivity paramRealNameActivity, Dialog paramDialog) {}
  
  public final void onClick(View paramView)
  {
    this.a.dismiss();
    paramView = new Intent(this.b, RealNameStep0VerifyMobileActivity.class);
    paramView.putExtra("realname_result", RealNameActivity.access$100(this.b));
    paramView.putExtra("realname_mobile", RealNameActivity.access$100(this.b).mMaskMobile);
    if (ax.a().e() != null) {
      paramView.putExtra("real_uin", ax.a().e().mRealUin);
    }
    paramView.putExtra("scene_id", 1001);
    this.b.startActivity(paramView);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ui
 * JD-Core Version:    0.7.0.1
 */