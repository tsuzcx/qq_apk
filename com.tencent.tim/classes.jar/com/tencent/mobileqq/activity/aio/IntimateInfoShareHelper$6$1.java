package com.tencent.mobileqq.activity.aio;

import android.content.Intent;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import com.tencent.mobileqq.widget.QQToast;
import wlh;

class IntimateInfoShareHelper$6$1
  implements Runnable
{
  IntimateInfoShareHelper$6$1(IntimateInfoShareHelper.6 param6, boolean paramBoolean, String paramString) {}
  
  public void run()
  {
    if (this.UM)
    {
      Intent localIntent = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
      localIntent.setData(Uri.parse("file://" + this.Qu));
      wlh.a(this.a.this$0).sendBroadcast(localIntent);
      QQToast.a(wlh.a(this.a.this$0), 2, wlh.a(this.a.this$0).getString(2131696988), 1).show(wlh.a(this.a.this$0).getTitleBarHeight());
      return;
    }
    QQToast.a(wlh.a(this.a.this$0), 1, wlh.a(this.a.this$0).getString(2131696987), 1).show(wlh.a(this.a.this$0).getTitleBarHeight());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.IntimateInfoShareHelper.6.1
 * JD-Core Version:    0.7.0.1
 */