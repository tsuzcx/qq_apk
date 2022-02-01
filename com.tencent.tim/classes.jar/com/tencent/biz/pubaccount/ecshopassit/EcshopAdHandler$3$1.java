package com.tencent.biz.pubaccount.ecshopassit;

import com.tencent.common.app.AppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import kds;
import kds.a;
import kdu;

public class EcshopAdHandler$3$1
  implements Runnable
{
  public EcshopAdHandler$3$1(kdu paramkdu, Object paramObject) {}
  
  public void run()
  {
    ChatMessage localChatMessage = (ChatMessage)this.aH;
    kds localkds = (kds)this.this$0.b.getBusinessHandler(139);
    kds.a locala = new kds.a();
    locala.aId = 10;
    localkds.a(kds.a(locala, localChatMessage), null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.ecshopassit.EcshopAdHandler.3.1
 * JD-Core Version:    0.7.0.1
 */