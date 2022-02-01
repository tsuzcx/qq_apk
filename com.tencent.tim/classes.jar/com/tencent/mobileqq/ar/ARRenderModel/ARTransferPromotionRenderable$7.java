package com.tencent.mobileqq.ar.ARRenderModel;

import adbk;
import adbn;
import adda;
import addg;
import addi;
import adgu;
import adus;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import java.util.ArrayList;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$7
  implements Runnable
{
  public ARTransferPromotionRenderable$7(addg paramaddg) {}
  
  public void run()
  {
    if (addg.a(this.this$0) == 6)
    {
      if ((addg.a(this.this$0) != null) && (addg.a(this.this$0)))
      {
        addg.a(this.this$0).hg(1, 0);
        addg.a(this.this$0, false);
      }
      if ((addg.a(this.this$0) != null) && (addg.b(this.this$0))) {
        addg.a(this.this$0).stop();
      }
      if (addg.b(this.this$0) != -1)
      {
        addg.a(this.this$0).stopPreDownload(addg.b(this.this$0));
        addg.a(this.this$0, -1);
      }
      if (addg.a(this.this$0) != null) {
        addg.a(this.this$0).Gr(addg.a(this.this$0).key);
      }
      if (addg.a(this.this$0) == 6) {
        addg.a(this.this$0, 7);
      }
      addg.a(this.this$0).cPK();
      if (addg.a(this.this$0) != null) {
        ThreadManager.getUIHandler().post(new ARTransferPromotionRenderable.7.1(this));
      }
    }
    synchronized (addg.a(this.this$0))
    {
      addg.a(this.this$0).clear();
      addg.a(this.this$0).release();
      addg.a(this.this$0);
      if (addg.a(this.this$0) != null)
      {
        addg.a(this.this$0).onPause();
        addg.a(this.this$0).onDestory();
        addg.a(this.this$0, null);
      }
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.7
 * JD-Core Version:    0.7.0.1
 */