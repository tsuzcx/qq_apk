package io.flutter.view;

import android.graphics.SurfaceTexture;

public abstract interface TextureRegistry
{
  public abstract SurfaceTextureEntry createSurfaceTexture();
  
  public static abstract interface SurfaceTextureEntry
  {
    public abstract long id();
    
    public abstract void release();
    
    public abstract SurfaceTexture surfaceTexture();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     io.flutter.view.TextureRegistry
 * JD-Core Version:    0.7.0.1
 */