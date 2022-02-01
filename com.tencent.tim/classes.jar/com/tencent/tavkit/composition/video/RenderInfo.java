package com.tencent.tavkit.composition.video;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import com.tencent.tav.coremedia.CGSize;
import com.tencent.tav.coremedia.CMTime;
import com.tencent.tav.decoder.RenderContext;
import com.tencent.tav.decoder.RenderContextParams;
import com.tencent.tavkit.ciimage.CIContext;

public class RenderInfo
{
  @NonNull
  private final CIContext ciContext;
  @NonNull
  private final CGSize renderSize;
  @NonNull
  private final CMTime time;
  
  public RenderInfo(@NonNull CMTime paramCMTime, @NonNull CGSize paramCGSize, @NonNull CIContext paramCIContext)
  {
    this.time = paramCMTime;
    this.renderSize = paramCGSize;
    this.ciContext = paramCIContext;
  }
  
  @NonNull
  public CIContext getCiContext()
  {
    return this.ciContext;
  }
  
  @Nullable
  public Object getParam(String paramString)
  {
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null) {
      return localRenderContextParams.getParam(paramString);
    }
    return null;
  }
  
  public int getRenderHeight()
  {
    return (int)this.renderSize.height;
  }
  
  @NonNull
  public CGSize getRenderSize()
  {
    return this.renderSize;
  }
  
  public int getRenderWidth()
  {
    return (int)this.renderSize.width;
  }
  
  @NonNull
  public CMTime getTime()
  {
    return this.time;
  }
  
  public void putParam(String paramString, Object paramObject)
  {
    RenderContextParams localRenderContextParams = this.ciContext.getRenderContext().getParams();
    if (localRenderContextParams != null) {
      localRenderContextParams.putParam(paramString, paramObject);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tavkit.composition.video.RenderInfo
 * JD-Core Version:    0.7.0.1
 */