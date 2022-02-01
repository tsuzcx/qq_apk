package com.tencent.biz.subscribe.widget;

import aqhq;
import sio;

public class SubscribeQRCodeShareHelper$1
  implements Runnable
{
  public SubscribeQRCodeShareHelper$1(sio paramsio) {}
  
  public void run()
  {
    aqhq.delete(sio.a(this.this$0), true);
    aqhq.UD(sio.a(this.this$0) + ".nomedia");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.1
 * JD-Core Version:    0.7.0.1
 */