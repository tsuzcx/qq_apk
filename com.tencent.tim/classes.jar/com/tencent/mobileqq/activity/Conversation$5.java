package com.tencent.mobileqq.activity;

import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class Conversation$5
  extends IApolloRunnableTask
{
  Conversation$5(Conversation paramConversation, ApolloSurfaceView paramApolloSurfaceView, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String aV()
  {
    return "Conversation_selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (this.a.getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.bGi, this.bGj, this.D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.Conversation.5
 * JD-Core Version:    0.7.0.1
 */