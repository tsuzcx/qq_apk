package com.tencent.ttpic.videoshelf.model.player;

public abstract interface IVideoShelfPlayerListener
{
  public abstract void onChangVideoSize(int paramInt1, int paramInt2);
  
  public abstract void onCompletion();
  
  public abstract boolean onError(int paramInt, String paramString, Object paramObject);
  
  public abstract void onPrepared(IVideoShelfPlayer paramIVideoShelfPlayer);
  
  public abstract void onUpdateRate(long paramLong);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.videoshelf.model.player.IVideoShelfPlayerListener
 * JD-Core Version:    0.7.0.1
 */