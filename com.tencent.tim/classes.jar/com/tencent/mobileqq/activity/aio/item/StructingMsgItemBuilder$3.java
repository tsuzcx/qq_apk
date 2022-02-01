package com.tencent.mobileqq.activity.aio.item;

import android.app.Activity;
import ansu;
import aoiz;
import aoop;
import aviz;
import avjg;
import com.tencent.mobileqq.app.QQAppInterface;
import com.tencent.mobileqq.data.ChatMessage;
import java.net.URL;

class StructingMsgItemBuilder$3
  implements Runnable
{
  StructingMsgItemBuilder$3(StructingMsgItemBuilder paramStructingMsgItemBuilder, ansu paramansu, int paramInt, ChatMessage paramChatMessage) {}
  
  public void run()
  {
    Object localObject = aoop.a(this.a.j, 1);
    if (localObject == null) {}
    for (localObject = null;; localObject = ((URL)localObject).toString())
    {
      localObject = aoiz.getFilePath((String)localObject);
      aviz.a(this.a.mMd5, this.alR, this.a.mUuid, this.a.anV, (String)localObject, this.a.filesize).b(this.this$0.app, this.b).b((Activity)this.this$0.mContext, this.this$0.app.getAccount());
      avjg.a(this.this$0.app, 6, 3);
      avjg.a(this.this$0.app, 2, 0, this.alR);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.item.StructingMsgItemBuilder.3
 * JD-Core Version:    0.7.0.1
 */