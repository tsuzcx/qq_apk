package com.tencent.mobileqq.apollo.game;

import abos;
import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;

class ApolloWebGameActivity$3
  extends IApolloRunnableTask
{
  ApolloWebGameActivity$3(ApolloWebGameActivity paramApolloWebGameActivity, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String aV()
  {
    return "doOnActivityResult_selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (ApolloWebGameActivity.a(this.this$0).b().getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.bGi, this.bGj, this.D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.game.ApolloWebGameActivity.3
 * JD-Core Version:    0.7.0.1
 */