package com.tencent.biz.subscribe.widget;

import acbn;
import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.widget.Toast;
import aqhq;
import java.io.File;
import mqq.app.MobileQQ;
import sio;

public class SubscribeQRCodeShareHelper$5
  implements Runnable
{
  public SubscribeQRCodeShareHelper$5(sio paramsio) {}
  
  public void run()
  {
    String str;
    if ((sio.a(this.this$0)) && (!sio.a(this.this$0).isFinishing()))
    {
      localObject = sio.a(this.this$0, sio.a(this.this$0));
      str = sio.a(this.this$0, acbn.oM);
      if (!aqhq.copyFile((String)localObject, str)) {
        Toast.makeText(sio.a(this.this$0), "save failed", 0).show();
      }
    }
    else
    {
      return;
    }
    Object localObject = new Intent("android.intent.action.MEDIA_SCANNER_SCAN_FILE");
    ((Intent)localObject).setData(Uri.fromFile(new File(str)));
    sio.a(this.this$0).sendBroadcast((Intent)localObject);
    MobileQQ.sMobileQQ.onSendBroadcast(sio.a(this.this$0), (Intent)localObject);
    Toast.makeText(sio.a(this.this$0), "save:" + str, 0).show();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.5
 * JD-Core Version:    0.7.0.1
 */