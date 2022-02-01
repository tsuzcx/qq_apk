package com.tencent.biz.subscribe.widget;

import aqhq;
import sio;

public class SubscribeQRCodeShareHelper$10
  implements Runnable
{
  public SubscribeQRCodeShareHelper$10(sio paramsio) {}
  
  public void run()
  {
    aqhq.delete(sio.aEk, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.biz.subscribe.widget.SubscribeQRCodeShareHelper.10
 * JD-Core Version:    0.7.0.1
 */