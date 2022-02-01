package com.tencent.biz.subscribe.widget;

import ahgq;
import android.content.Intent;
import java.io.File;
import java.net.URI;
import sio;

public class SubscribeQRCodeShareHelper$6
  implements Runnable
{
  public SubscribeQRCodeShareHelper$6(sio paramsio) {}
  
  public void run()
  {
    if (sio.a(this.this$0))
    {
      String str = sio.a(this.this$0, sio.a(this.this$0));
      File localFile = new File(str);
      Intent localIntent = new Intent();
      localIntent.putExtra("forward_type", 1);
      localIntent.putExtra("forward_filepath", str);
      localIntent.putExtra("forward_thumb", str);
      localIntent.putExtra("forward_urldrawable", true);
      localIntent.putExtra("forward_urldrawable_big_url", localFile.toURI().toString());
      localIntent.putExtra("forward_urldrawable_thumb_url", localFile.toURI().toString());
      localIntent.putExtra("key_help_forward_pic", true);
      localIntent.putExtra("selection_mode", 1);
      localIntent.putExtra("forward_ability_entrence_show_in_share", false);
      localIntent.putExtra("filePath", str);
      localIntent.putExtra("shareQQType", 13);
      localIntent.putExtra("reqType", 1);
      ahgq.f(sio.a(this.this$0), localIntent, 21);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.6
 * JD-Core Version:    0.7.0.1
 */