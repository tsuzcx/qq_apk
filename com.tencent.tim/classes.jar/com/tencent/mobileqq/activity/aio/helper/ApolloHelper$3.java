package com.tencent.mobileqq.activity.aio.helper;

import android.content.Intent;
import com.tencent.mobileqq.apollo.ApolloRender;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import wuq;

public class ApolloHelper$3
  extends IApolloRunnableTask
{
  public ApolloHelper$3(wuq paramwuq, ApolloSurfaceView paramApolloSurfaceView, int paramInt1, int paramInt2, Intent paramIntent) {}
  
  public String aV()
  {
    return "selectPhotoFromSystem";
  }
  
  public void run()
  {
    if (this.a.getRender() != null) {
      ApolloRender.selectPhotoFromSystem(this.bGi, this.bGj, this.D);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.helper.ApolloHelper.3
 * JD-Core Version:    0.7.0.1
 */