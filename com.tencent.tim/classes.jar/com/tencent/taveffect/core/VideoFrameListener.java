package com.tencent.taveffect.core;

public abstract interface VideoFrameListener
{
  public abstract void onStickerTextureProcess(TAVTextureInfo paramTAVTextureInfo, RenderParams paramRenderParams);
  
  public abstract void onVideoTextureProcess(TAVTextureInfo paramTAVTextureInfo, RenderParams paramRenderParams);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.taveffect.core.VideoFrameListener
 * JD-Core Version:    0.7.0.1
 */