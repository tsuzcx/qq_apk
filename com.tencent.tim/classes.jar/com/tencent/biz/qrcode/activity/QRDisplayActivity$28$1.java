package com.tencent.biz.qrcode.activity;

import acbn;
import ahgq;
import android.content.Intent;
import android.os.Bundle;
import com.tencent.mobileqq.activity.ForwardRecentActivity;
import com.tencent.mobileqq.activity.ForwardRecentTranslucentActivity;

class QRDisplayActivity$28$1
  implements Runnable
{
  QRDisplayActivity$28$1(QRDisplayActivity.28 param28, String paramString) {}
  
  public void run()
  {
    if (this.a.this$0.isFinishing()) {
      return;
    }
    Bundle localBundle = new Bundle();
    localBundle.putInt("forward_type", 1);
    localBundle.putString("forward_filepath", this.aCx);
    localBundle.putString("forward_thumb", this.aCx);
    localBundle.putString("forward_urldrawable_big_url", this.aCx);
    localBundle.putString("forward_extra", this.aCx);
    localBundle.putInt("key_req", ForwardRecentActivity.bGS);
    localBundle.putInt("key_direct_show_uin_type", this.a.alR);
    localBundle.putString("key_direct_show_uin", this.a.val$uin);
    if ((6000 == this.a.alR) && (acbn.bkw == this.a.val$uin)) {
      localBundle.putBoolean("filepath_copy", true);
    }
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    ahgq.a(this.a.this$0, localIntent, ForwardRecentTranslucentActivity.class, 21, 100500, "biz_src_jc_gxl_ctcshare");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.28.1
 * JD-Core Version:    0.7.0.1
 */