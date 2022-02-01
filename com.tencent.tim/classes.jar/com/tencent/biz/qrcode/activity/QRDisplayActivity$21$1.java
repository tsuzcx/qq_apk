package com.tencent.biz.qrcode.activity;

import ahgq;
import android.content.Intent;
import android.os.Bundle;

class QRDisplayActivity$21$1
  implements Runnable
{
  QRDisplayActivity$21$1(QRDisplayActivity.21 param21, String paramString) {}
  
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
    Intent localIntent = new Intent();
    localIntent.putExtras(localBundle);
    if (this.a.this$0.type == 1)
    {
      ahgq.a(this.a.this$0, localIntent, 21, 100500, "biz_src_jc_gxl_ctcshare");
      return;
    }
    ahgq.f(this.a.this$0, localIntent, 21);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.21.1
 * JD-Core Version:    0.7.0.1
 */