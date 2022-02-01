package com.tencent.tav.player;

public class UpdateCompositionMessage
{
  public final PlayerItem playerItem;
  public final OnCompositionUpdateListener updateListener;
  
  public UpdateCompositionMessage(PlayerItem paramPlayerItem, OnCompositionUpdateListener paramOnCompositionUpdateListener)
  {
    this.playerItem = paramPlayerItem;
    this.updateListener = paramOnCompositionUpdateListener;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tav.player.UpdateCompositionMessage
 * JD-Core Version:    0.7.0.1
 */