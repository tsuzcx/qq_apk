package com.tencent.mobileqq.activity;

import android.widget.TextView;
import aqgv;
import aqiu;

class ChatHistory$ChatHistoryAdapter$1
  implements Runnable
{
  ChatHistory$ChatHistoryAdapter$1(ChatHistory.a parama, int paramInt, String paramString, ChatHistory.c paramc, TextView paramTextView) {}
  
  public void run()
  {
    String str = aqgv.a(this.b.this$0.app, this.b.this$0.c, aqiu.ms(this.bFp), this.aem);
    if (this.a.senderUin.equals(this.aem)) {
      this.a.name = str;
    }
    this.b.this$0.runOnUiThread(new ChatHistory.ChatHistoryAdapter.1.1(this, str));
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.1
 * JD-Core Version:    0.7.0.1
 */