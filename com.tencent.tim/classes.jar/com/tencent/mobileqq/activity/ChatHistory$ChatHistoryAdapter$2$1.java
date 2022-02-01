package com.tencent.mobileqq.activity;

import android.view.View;
import android.widget.Toast;
import unl;

public class ChatHistory$ChatHistoryAdapter$2$1
  implements Runnable
{
  public ChatHistory$ChatHistoryAdapter$2$1(unl paramunl, Object paramObject, View paramView) {}
  
  public void run()
  {
    if ((this.a.bFr == 0) && ((this.a.b.this$0.a == null) || (!this.a.b.this$0.a.a(0, this.val$tag))))
    {
      Toast.makeText(this.a.b.mContext, this.a.b.this$0.getString(2131719258), 0).show();
      return;
    }
    if (this.a.b.this$0.a == null) {
      this.a.b.this$0.a = new ChatHistory.d(this.a.b.this$0);
    }
    this.a.b.this$0.a.a(0, this.rQ, this.val$tag, this.a.val$url);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.ChatHistory.ChatHistoryAdapter.2.1
 * JD-Core Version:    0.7.0.1
 */