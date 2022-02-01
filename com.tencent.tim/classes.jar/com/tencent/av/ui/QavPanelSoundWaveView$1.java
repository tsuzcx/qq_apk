package com.tencent.av.ui;

import android.os.Handler;
import com.tencent.av.VideoController;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import java.util.Iterator;
import java.util.List;
import jde;
import mqq.app.BaseActivity;

class QavPanelSoundWaveView$1
  implements Runnable
{
  QavPanelSoundWaveView$1(QavPanelSoundWaveView paramQavPanelSoundWaveView) {}
  
  public void run()
  {
    if (this.this$0.getVisibility() != 0)
    {
      this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 200L);
      return;
    }
    Object localObject;
    float f;
    int j;
    if (!this.this$0.XK)
    {
      localObject = this.this$0;
      ((QavPanelSoundWaveView)localObject).hP += -this.this$0.hN * 0.00048F;
      localObject = this.this$0.getContext();
      if (!(localObject instanceof BaseActivity)) {
        break label330;
      }
      localObject = ((BaseActivity)localObject).getAppRuntime();
      if (!(localObject instanceof VideoAppInterface)) {
        break label330;
      }
      localObject = ((VideoAppInterface)localObject).b();
      f = ((VideoController)localObject).kE() * 0.05F;
      if ((((VideoController)localObject).b().amI != 3) && (!((VideoController)localObject).b().isConnected())) {
        break label325;
      }
      j = 1;
    }
    for (;;)
    {
      if ((j != 0) && (!this.this$0.XK))
      {
        this.this$0.hP = 0.0F;
        f = 0.0F;
      }
      for (;;)
      {
        localObject = this.this$0.fA.iterator();
        int i = 1;
        label190:
        if (((Iterator)localObject).hasNext())
        {
          jde localjde = (jde)((Iterator)localObject).next();
          localjde.v(this.this$0.hP, f);
          if (i == 0) {
            break label319;
          }
          if (Float.compare(localjde.bM, 0.0F) == 0) {
            i = 1;
          }
        }
        label319:
        for (;;)
        {
          break label190;
          localObject = this.this$0;
          ((QavPanelSoundWaveView)localObject).hP += -this.this$0.hN * 0.00067F;
          break;
          i = 0;
          continue;
          if ((j == 0) || (i == 0)) {
            this.this$0.mHandler.postDelayed(this.this$0.mRunnable, 66L);
          }
          this.this$0.invalidate();
          return;
        }
      }
      label325:
      j = 0;
      continue;
      label330:
      j = 0;
      f = 1.0F;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.QavPanelSoundWaveView.1
 * JD-Core Version:    0.7.0.1
 */