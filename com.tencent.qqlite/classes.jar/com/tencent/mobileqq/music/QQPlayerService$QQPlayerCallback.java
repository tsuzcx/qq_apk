package com.tencent.mobileqq.music;

public abstract interface QQPlayerService$QQPlayerCallback
{
  public abstract String getToken();
  
  public abstract void onPlaySongChanged(SongInfo paramSongInfo);
  
  public abstract void onPlayStateChanged(int paramInt);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.mobileqq.music.QQPlayerService.QQPlayerCallback
 * JD-Core Version:    0.7.0.1
 */