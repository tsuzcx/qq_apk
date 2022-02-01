package org.libpag;

import android.graphics.Matrix;
import org.extra.tools.LibraryLoadUtils;

public class PAGPlayer
{
  private long nativeContext = 0L;
  private PAGSurface pagSurface = null;
  
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
    PAGFont.loadSystemFonts();
  }
  
  public PAGPlayer()
  {
    nativeSetup();
  }
  
  private native void nativeGetMatrix(float[] paramArrayOfFloat);
  
  private static final native void nativeInit();
  
  private final native void nativeRelease();
  
  private native void nativeSetMatrix(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4, float paramFloat5, float paramFloat6);
  
  private native void nativeSetSurface(long paramLong);
  
  private final native void nativeSetup();
  
  public native boolean cacheEnabled();
  
  public native float cacheScale();
  
  public native long duration();
  
  protected void finalize()
  {
    nativeRelease();
  }
  
  public native boolean flush();
  
  public native PAGComposition getComposition();
  
  public native PAGLayer[] getLayersUnderPoint(float paramFloat1, float paramFloat2);
  
  public native double getProgress();
  
  public PAGSurface getSurface()
  {
    return this.pagSurface;
  }
  
  public Matrix matrix()
  {
    float[] arrayOfFloat = new float[9];
    nativeGetMatrix(arrayOfFloat);
    Matrix localMatrix = new Matrix();
    localMatrix.setValues(arrayOfFloat);
    return localMatrix;
  }
  
  public native float maxFrameRate();
  
  public native int scaleMode();
  
  public native void setCacheEnabled(boolean paramBoolean);
  
  public native void setCacheScale(float paramFloat);
  
  public native void setComposition(PAGComposition paramPAGComposition);
  
  public void setMatrix(Matrix paramMatrix)
  {
    float[] arrayOfFloat = new float[9];
    paramMatrix.getValues(arrayOfFloat);
    nativeSetMatrix(arrayOfFloat[0], arrayOfFloat[3], arrayOfFloat[1], arrayOfFloat[4], arrayOfFloat[2], arrayOfFloat[5]);
  }
  
  public native void setMaxFrameRate(float paramFloat);
  
  public native void setProgress(double paramDouble);
  
  public native void setScaleMode(int paramInt);
  
  public void setSurface(PAGSurface paramPAGSurface)
  {
    this.pagSurface = paramPAGSurface;
    if (paramPAGSurface == null)
    {
      nativeSetSurface(0L);
      return;
    }
    nativeSetSurface(paramPAGSurface.nativeSurface);
  }
  
  public native void setVideoEnabled(boolean paramBoolean);
  
  public native boolean videoEnabled();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGPlayer
 * JD-Core Version:    0.7.0.1
 */