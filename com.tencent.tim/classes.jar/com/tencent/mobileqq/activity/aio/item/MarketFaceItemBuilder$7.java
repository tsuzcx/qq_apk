package com.tencent.mobileqq.activity.aio.item;

import afke;
import afpu;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.mobileqq.data.ChatMessage;
import mqq.os.MqqHandler;

class MarketFaceItemBuilder$7
  implements Runnable
{
  MarketFaceItemBuilder$7(MarketFaceItemBuilder paramMarketFaceItemBuilder, MarketFaceItemBuilder.b paramb, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    boolean bool = this.this$0.b.a(this.a.c.e, 8);
    ThreadManager.getUIHandler().post(new MarketFaceItemBuilder.7.1(this, bool));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.MarketFaceItemBuilder.7
 * JD-Core Version:    0.7.0.1
 */