package com.tencent.thumbplayer.core.player;

import androidx.annotation.NonNull;

public class TPNativePlayerSurfaceRenderInfo
{
  public int displayHeight = -1;
  public int displayWidth = -1;
  public TPVideoCropInfo videoCropInfo = null;
  
  public static class TPVideoCropInfo
  {
    public int cropBottom = -1;
    public int cropLeft = -1;
    public int cropRight = -1;
    public int cropTop = -1;
    public int height = -1;
    public int width = -1;
    
    @NonNull
    public String toString()
    {
      return "width:" + this.width + ", height:" + this.height + ", cropLeft:" + this.cropLeft + ", cropRight:" + this.cropRight + ", cropTop:" + this.cropTop + ", cropBottom:" + this.cropBottom;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.core.player.TPNativePlayerSurfaceRenderInfo
 * JD-Core Version:    0.7.0.1
 */