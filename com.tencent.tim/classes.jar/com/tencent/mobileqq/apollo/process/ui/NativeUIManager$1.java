package com.tencent.mobileqq.apollo.process.ui;

import abmt;
import abqe;
import com.tencent.mobileqq.apollo.ApolloSurfaceView;
import com.tencent.mobileqq.apollo.IApolloRunnableTask;
import com.tencent.mobileqq.apollo.aioChannel.ApolloCmdChannel;

public class NativeUIManager$1
  extends IApolloRunnableTask
{
  public NativeUIManager$1(abqe paramabqe, ApolloSurfaceView paramApolloSurfaceView, String paramString1, String paramString2) {}
  
  public String aV()
  {
    return "notifyUIUpdate";
  }
  
  public void run()
  {
    if (this.e != null)
    {
      ApolloCmdChannel localApolloCmdChannel = abmt.a();
      if (localApolloCmdChannel != null) {
        localApolloCmdChannel.callbackFromRequest(this.e.getRuntimeState(), 0, this.val$type, this.val$info);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.apollo.process.ui.NativeUIManager.1
 * JD-Core Version:    0.7.0.1
 */