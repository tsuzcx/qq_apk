package com.tencent.token.ui;

import android.view.View;
import android.view.View.OnClickListener;
import com.tencent.token.core.bean.DeviceInfo;
import com.tencent.token.cp;
import com.tencent.token.cw;
import com.tencent.token.global.RqdApplication;
import com.tencent.token.utils.w;

class tg
  implements View.OnClickListener
{
  tg(tf paramtf) {}
  
  public void onClick(View paramView)
  {
    cw.a().a(0L, tf.a(this.a).dguid, tf.a(this.a).ddes, tf.a(this.a).dappid, tf.a(this.a).dsubappid, tf.a(this.a).dappname, 71, w.a(cp.a(RqdApplication.l()).b()), 523005419, 1, "com.tencent.token", PCMobileQQVerifyedDevicesActivity.access$000(this.a.a), PCMobileQQVerifyedDevicesActivity.access$200(this.a.a));
    this.a.dismiss();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.tg
 * JD-Core Version:    0.7.0.1
 */