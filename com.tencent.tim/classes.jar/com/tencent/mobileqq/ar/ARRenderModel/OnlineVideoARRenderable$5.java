package com.tencent.mobileqq.ar.ARRenderModel;

import addw;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;

public class OnlineVideoARRenderable$5
  implements Runnable
{
  public OnlineVideoARRenderable$5(addw paramaddw) {}
  
  public void run()
  {
    try
    {
      addw.a(this.this$0).stop();
    }
    catch (Exception localException1)
    {
      for (;;)
      {
        try
        {
          addw.b(this.this$0, true);
          addw.a(this.this$0, addw.a(this.this$0));
          addw.h(this.this$0);
          return;
        }
        catch (Exception localException2)
        {
          if (!QLog.isColorLevel()) {
            continue;
          }
          localException2.printStackTrace();
          QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, exception=" + localException2.getMessage());
        }
        localException1 = localException1;
        if (QLog.isColorLevel()) {
          localException1.printStackTrace();
        }
        QLog.d("AREngine_OnlineVideoARRenderable", 1, "onCompletion, stop, exception=" + localException1.getMessage());
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.OnlineVideoARRenderable.5
 * JD-Core Version:    0.7.0.1
 */