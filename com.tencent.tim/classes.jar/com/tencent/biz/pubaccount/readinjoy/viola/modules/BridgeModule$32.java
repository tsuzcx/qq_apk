package com.tencent.biz.pubaccount.readinjoy.viola.modules;

import com.tencent.mobileqq.app.QQAppInterface;
import kxm;

class BridgeModule$32
  implements Runnable
{
  BridgeModule$32(BridgeModule paramBridgeModule, int paramInt, String paramString) {}
  
  public void run()
  {
    QQAppInterface localQQAppInterface = kxm.a();
    if (localQQAppInterface != null) {
      BridgeModule.access$1200(this.this$0, localQQAppInterface, this.aTI, this.val$callback);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.viola.modules.BridgeModule.32
 * JD-Core Version:    0.7.0.1
 */