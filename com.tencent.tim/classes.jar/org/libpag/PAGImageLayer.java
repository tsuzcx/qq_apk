package org.libpag;

import org.extra.tools.LibraryLoadUtils;

public class PAGImageLayer
  extends PAGLayer
{
  static
  {
    LibraryLoadUtils.loadLibrary("libpag");
    nativeInit();
  }
  
  public PAGImageLayer(long paramLong)
  {
    super(paramLong);
  }
  
  private static native void nativeInit();
  
  private native void replaceImage(long paramLong);
  
  public native long contentDuration();
  
  public native PAGVideoRange[] getVideoRanges();
  
  public void replaceImage(PAGImage paramPAGImage)
  {
    if (paramPAGImage == null) {}
    for (long l = 0L;; l = paramPAGImage.nativeContext)
    {
      replaceImage(l);
      return;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.libpag.PAGImageLayer
 * JD-Core Version:    0.7.0.1
 */