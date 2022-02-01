package com.tencent.mobileqq.ar.ARRenderModel;

import adbk;
import adbm.a;
import adbn;
import adda;
import addg;
import addi;
import adgu;
import adus;
import aurf;
import com.tencent.mobileqq.app.ThreadManager;
import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISPlayerPreDownloader;
import mqq.os.MqqHandler;

public class ARTransferPromotionRenderable$16
  implements Runnable
{
  public ARTransferPromotionRenderable$16(addg paramaddg, int paramInt) {}
  
  public void run()
  {
    switch (this.cCP)
    {
    default: 
    case 2: 
      do
      {
        return;
        addg.e(this.this$0);
      } while ((this.this$0.cCI != 0) || (this.this$0.cCJ != 2));
      addg.a(this.this$0, 3, addg.a(this.this$0).bsf + "360Video.mp4", false, addg.a(this.this$0).cCU, false);
      addg.a(this.this$0).setMute(true);
      addg.b(this.this$0);
      addg.c(this.this$0);
      return;
    case 3: 
      if (this.this$0.h != null) {
        this.this$0.h.removeCallbacks(addg.a(this.this$0));
      }
      if (addg.a(this.this$0) != null)
      {
        if (addg.a(this.this$0).ap.booleanValue())
        {
          addg.a(this.this$0).restart();
          QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: config jumpTo firstFrame");
        }
        addg.d(this.this$0);
        this.this$0.gN(4);
      }
      if (addg.a(this.this$0).cBI == 0) {}
      for (;;)
      {
        QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: m360VideoConnectType " + addg.a(this.this$0).cBI);
        return;
        if (addg.a(this.this$0).cBI == 1) {
          addg.a(this.this$0).FT(true);
        }
      }
    case 4: 
      if (this.this$0.h != null) {
        this.this$0.h.removeCallbacks(addg.a(this.this$0));
      }
      if ((addg.a(this.this$0) != null) && (!addg.d(this.this$0)))
      {
        addg.a(this.this$0).setMute(false);
        addg.a(this.this$0).FS(true);
        if (addg.a(this.this$0) != null)
        {
          if (addg.a(this.this$0).ap.booleanValue())
          {
            addg.a(this.this$0).restart();
            QLog.d("ARTransferPromotionRenderable", 2, "nativeCallBack status GameStatus_TRAVERSING_DOOR: config jumpTo firstFrame");
          }
          addg.d(this.this$0);
        }
        if (addg.a(this.this$0).cBI != 0) {
          break label482;
        }
      }
      for (;;)
      {
        addg.c(this.this$0, false);
        return;
        if (addg.a(this.this$0).cBI == 1) {
          addg.a(this.this$0).FT(true);
        }
      }
    case 5: 
      addg.a(this.this$0).setMute(true);
      addg.a(this.this$0).FS(false);
      addg.a(this.this$0);
      QLog.d("ARTransferPromotionRenderable", 2, "GameStatus_OUTSIDE_WORLD_360 ready");
      return;
    case 6: 
      addg.a(this.this$0).akG();
      if (addg.b(this.this$0)) {
        addg.a(this.this$0).stop();
      }
      if (addg.a(this.this$0) != null) {
        addg.a(this.this$0).onPause();
      }
      if (addg.b(this.this$0) != -1)
      {
        addg.a(this.this$0).stopPreDownload(addg.b(this.this$0));
        addg.a(this.this$0, -1);
      }
      addg.a(this.this$0, 7, addg.a(this.this$0).mVideoUrl, false, addg.a(this.this$0).cBJ, true);
      QLog.d("ARTransferPromotionRenderable", 2, "start play 360 over video " + addg.a(this.this$0));
      return;
    case 8: 
      label482:
      addg.a(this.this$0).akG();
      if (addg.a(this.this$0) != null) {
        addg.a(this.this$0).hg(2, 0);
      }
      QLog.d("ARTransferPromotionRenderable", 2, "ad play end here");
      return;
    }
    addg.a(this.this$0).setMute(false);
    ThreadManager.getSubThreadHandler().post(new ARTransferPromotionRenderable.16.1(this));
    addg.c(this.this$0, true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRenderModel.ARTransferPromotionRenderable.16
 * JD-Core Version:    0.7.0.1
 */