package com.tencent.mobileqq.customviews;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Canvas;
import android.support.v4.view.ViewCompat;
import aqis;
import com.tencent.mobileqq.widget.MessageProgressView;
import com.tencent.mobileqq.widget.MessageProgressView.RefreshProgressRunnable;

public class VideoProgressView
  extends MessageProgressView
{
  private boolean bWP = true;
  private float vS;
  
  public VideoProgressView(Context paramContext)
  {
    super(paramContext);
  }
  
  public boolean air()
  {
    return this.bWP;
  }
  
  public void f(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F) && (paramFloat > this.vS)) {
      setVideoCompressPercent(paramString, paramFloat);
    }
  }
  
  @TargetApi(11)
  public void onDraw(Canvas paramCanvas)
  {
    if (this.egH == 1)
    {
      updateSize();
      bq(paramCanvas);
      if (air())
      {
        f(paramCanvas, this.vS);
        if (this.cAo == null) {
          break label68;
        }
        b(paramCanvas, this.cAo);
        label49:
        bs(paramCanvas);
        bt(paramCanvas);
      }
    }
    label68:
    do
    {
      return;
      br(paramCanvas);
      break;
      aQ(paramCanvas);
      break label49;
      if (this.egH == 2)
      {
        updateSize();
        bu(paramCanvas);
        return;
      }
    } while (this.egH != 3);
    updateSize();
    bv(paramCanvas);
  }
  
  public void setVideoCompressPercent(String paramString, float paramFloat)
  {
    if ((paramFloat >= 0.0F) && (paramFloat <= 1.0F))
    {
      this.vS = paramFloat;
      if (this.vS >= 1.0F) {
        break label82;
      }
    }
    MessageProgressView.RefreshProgressRunnable localRefreshProgressRunnable;
    label82:
    for (boolean bool = true;; bool = false)
    {
      this.bWP = bool;
      if (this.egH == 1)
      {
        localRefreshProgressRunnable = aqis.a().a(paramString);
        if (localRefreshProgressRunnable != null) {
          break;
        }
        localRefreshProgressRunnable = new MessageProgressView.RefreshProgressRunnable(this, paramString);
        aqis.a().a(paramString, localRefreshProgressRunnable);
        ViewCompat.postOnAnimation(this, localRefreshProgressRunnable);
      }
      return;
    }
    localRefreshProgressRunnable.a(this);
  }
  
  public void setVideoCompressStatus(boolean paramBoolean)
  {
    this.bWP = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.customviews.VideoProgressView
 * JD-Core Version:    0.7.0.1
 */