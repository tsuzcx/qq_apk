package com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture;

import com.tencent.qphone.base.util.QLog;
import com.tencent.superplayer.api.ISuperPlayer;
import java.util.Iterator;
import java.util.Set;
import mlt;
import mlx;

public class PlayerCaptureProxy$2
  implements Runnable
{
  public PlayerCaptureProxy$2(mlx parammlx) {}
  
  public void run()
  {
    if (mlx.a(this.this$0) == null) {
      QLog.e("PlayerCaptureProxy", 1, "onPreviewVideoPrepared error for player is null");
    }
    for (;;)
    {
      return;
      mlx.a(this.this$0, true);
      int i = mlx.a(this.this$0).getVideoWidth();
      int j = mlx.a(this.this$0).getVideoHeight();
      long l = mlx.a(this.this$0).getDurationMs();
      Iterator localIterator = mlx.a(this.this$0).iterator();
      while (localIterator.hasNext())
      {
        mlt localmlt = (mlt)localIterator.next();
        if (localmlt != null) {
          localmlt.a(i, j, l);
        }
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.readinjoy.ugc.coverselect.capture.PlayerCaptureProxy.2
 * JD-Core Version:    0.7.0.1
 */