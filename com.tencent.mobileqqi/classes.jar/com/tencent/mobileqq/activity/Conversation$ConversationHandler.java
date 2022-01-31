package com.tencent.mobileqq.activity;

import android.os.Handler;
import android.os.Message;
import java.lang.ref.WeakReference;

public class Conversation$ConversationHandler
  extends Handler
{
  private final WeakReference a;
  
  public Conversation$ConversationHandler(Conversation paramConversation)
  {
    this.a = new WeakReference(paramConversation);
  }
  
  public void handleMessage(Message paramMessage)
  {
    Conversation localConversation = (Conversation)this.a.get();
    if (localConversation != null) {
      localConversation.a(paramMessage);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.ConversationHandler
 * JD-Core Version:    0.7.0.1
 */