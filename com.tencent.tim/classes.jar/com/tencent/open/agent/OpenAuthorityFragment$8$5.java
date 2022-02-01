package com.tencent.open.agent;

import ahlw;
import android.graphics.Bitmap;
import android.os.Message;
import arrq;
import cooperation.qqfav.util.HandlerPlus;

public class OpenAuthorityFragment$8$5
  implements Runnable
{
  public OpenAuthorityFragment$8$5(arrq paramarrq, String paramString) {}
  
  public void run()
  {
    ahlw.Kj("KEY_GET_APP_ADS_PIC");
    Bitmap localBitmap = OpenAuthorityFragment.P(this.val$url);
    ahlw.a("KEY_GET_APP_ADS_PIC", OpenAuthorityFragment.a(this.a.this$0));
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
 * Qualified Name:     com.tencent.open.agent.OpenAuthorityFragment.8.5
 * JD-Core Version:    0.7.0.1
 */