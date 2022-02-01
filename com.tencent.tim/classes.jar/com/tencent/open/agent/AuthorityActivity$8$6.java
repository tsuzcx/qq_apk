package com.tencent.open.agent;

import ahlw;
import android.graphics.Bitmap;
import android.os.Message;
import arpb;
import cooperation.qqfav.util.HandlerPlus;

public class AuthorityActivity$8$6
  implements Runnable
{
  public AuthorityActivity$8$6(arpb paramarpb, String paramString) {}
  
  public void run()
  {
    ahlw.Kj("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = AuthorityActivity.P(this.val$url);
    ahlw.a("KEY_GET_APP_ADS_PIC", this.a.this$0.a);
    if (localBitmap != null)
    {
      Message localMessage = new Message();
      localMessage.obj = localBitmap;
      localMessage.what = 9;
      this.a.this$0.b.sendMessage(localMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.open.agent.AuthorityActivity.8.6
 * JD-Core Version:    0.7.0.1
 */