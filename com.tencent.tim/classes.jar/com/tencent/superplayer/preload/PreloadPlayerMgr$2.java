package com.tencent.superplayer.preload;

import com.tencent.superplayer.player.SuperPlayerWrapper;

class PreloadPlayerMgr$2
  implements Runnable
{
  PreloadPlayerMgr$2(PreloadPlayerMgr paramPreloadPlayerMgr, PreloadPlayerInfo paramPreloadPlayerInfo) {}
  
  public void run()
  {
    if (this.val$playerInfo.player != null) {
      this.val$playerInfo.player.release();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.superplayer.preload.PreloadPlayerMgr.2
 * JD-Core Version:    0.7.0.1
 */