package com.tencent.qqmini.miniapp.core.model;

public class EmbeddedState
{
  private boolean enableEmbeddedCanvas = false;
  private boolean enableEmbeddedLive = false;
  private boolean enableEmbeddedVideo = false;
  
  public boolean isEnableEmbeddedCanvas()
  {
    return this.enableEmbeddedCanvas;
  }
  
  public boolean isEnableEmbeddedLive()
  {
    return this.enableEmbeddedLive;
  }
  
  public boolean isEnableEmbeddedVideo()
  {
    return this.enableEmbeddedVideo;
  }
  
  public void setEnableEmbeddedCanvas(boolean paramBoolean)
  {
    this.enableEmbeddedCanvas = paramBoolean;
  }
  
  public void setEnableEmbeddedLive(boolean paramBoolean)
  {
    this.enableEmbeddedLive = paramBoolean;
  }
  
  public void setEnableEmbeddedVideo(boolean paramBoolean)
  {
    this.enableEmbeddedVideo = paramBoolean;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.miniapp.core.model.EmbeddedState
 * JD-Core Version:    0.7.0.1
 */