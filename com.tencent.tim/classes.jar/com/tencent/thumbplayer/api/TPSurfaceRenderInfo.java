package com.tencent.thumbplayer.api;

public class TPSurfaceRenderInfo
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
    
    public String toString()
    {
      return "width:" + this.width + ", height:" + this.height + ", cropLeft:" + this.cropLeft + ", cropRight:" + this.cropRight + ", cropTop:" + this.cropTop + ", cropBottom:" + this.cropBottom;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.thumbplayer.api.TPSurfaceRenderInfo
 * JD-Core Version:    0.7.0.1
 */