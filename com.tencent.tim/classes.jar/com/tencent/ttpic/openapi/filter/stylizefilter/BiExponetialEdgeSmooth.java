package com.tencent.ttpic.openapi.filter.stylizefilter;

import android.graphics.Bitmap;
import com.microrapid.opencv.ImageAutoProcessor;
import com.tencent.aekit.openrender.internal.Frame;
import com.tencent.aekit.openrender.util.GlUtil;
import com.tencent.view.RendererUtils;

public class BiExponetialEdgeSmooth
{
  private static final String TAG = "BiExponetialEdgeSmooth";
  private Bitmap mDstBitmap;
  private boolean mIsAsyncProcessing = false;
  private boolean mIsClear = false;
  private boolean mIsSync = false;
  
  public BiExponetialEdgeSmooth() {}
  
  public BiExponetialEdgeSmooth(boolean paramBoolean)
  {
    this.mIsSync = paramBoolean;
  }
  
  private boolean denoiseAsyn(Frame paramFrame)
  {
    if (isNeedStyleFilter())
    {
      localBitmap = RendererUtils.saveTexture(paramFrame);
      if (localBitmap != null) {}
    }
    while (this.mDstBitmap == null)
    {
      Bitmap localBitmap;
      return false;
      this.mIsAsyncProcessing = true;
      new Thread(new BiExponetialEdgeSmooth.1(this, localBitmap)).start();
    }
    GlUtil.loadTexture(paramFrame.getTextureId(), this.mDstBitmap);
    return true;
  }
  
  private boolean denoiseSync(Frame paramFrame)
  {
    if (paramFrame == null) {}
    Bitmap localBitmap1;
    Bitmap localBitmap2;
    do
    {
      do
      {
        return false;
        localBitmap1 = RendererUtils.saveTexture(paramFrame);
      } while (localBitmap1 == null);
      localBitmap2 = localBitmap1.copy(localBitmap1.getConfig(), localBitmap1.isMutable());
    } while (localBitmap2 == null);
    ImageAutoProcessor.nativeDenoiseBEEPS(localBitmap1, localBitmap2);
    GlUtil.loadTexture(paramFrame.getTextureId(), localBitmap2);
    localBitmap1.recycle();
    localBitmap2.recycle();
    return true;
  }
  
  public void clear()
  {
    this.mIsClear = true;
    if (this.mDstBitmap != null) {
      this.mDstBitmap.recycle();
    }
  }
  
  public boolean denoise(Frame paramFrame)
  {
    if (this.mIsSync) {
      return denoiseSync(paramFrame);
    }
    return denoiseAsyn(paramFrame);
  }
  
  public boolean isNeedStyleFilter()
  {
    return (!this.mIsAsyncProcessing) && (this.mDstBitmap == null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.openapi.filter.stylizefilter.BiExponetialEdgeSmooth
 * JD-Core Version:    0.7.0.1
 */