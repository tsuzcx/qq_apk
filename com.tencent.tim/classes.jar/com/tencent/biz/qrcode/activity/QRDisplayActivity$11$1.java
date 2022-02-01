package com.tencent.biz.qrcode.activity;

import android.content.Intent;
import android.net.Uri;
import com.tencent.common.app.BaseApplicationImpl;
import com.tencent.mobileqq.widget.QQToast;
import rwt;

class QRDisplayActivity$11$1
  implements Runnable
{
  QRDisplayActivity$11$1(QRDisplayActivity.11 param11, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.UM)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.Qu));
      this.a.this$0.sendBroadcast(localIntent);
      QQToast.a(BaseApplicationImpl.getContext(), 2, this.a.this$0.getString(2131696988), 1).show(this.a.this$0.getTitleBarHeight());
      return;
    }
    rwt.ez(1, 2131717217);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.qrcode.activity.QRDisplayActivity.11.1
 * JD-Core Version:    0.7.0.1
 */