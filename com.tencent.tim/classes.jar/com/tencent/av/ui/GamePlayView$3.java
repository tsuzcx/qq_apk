package com.tencent.av.ui;

import com.tencent.av.gameplay.ARNativeBridge;

class GamePlayView$3
  implements Runnable
{
  GamePlayView$3(GamePlayView paramGamePlayView, byte[] paramArrayOfByte, int paramInt1, int paramInt2, boolean paramBoolean) {}
  
  public void run()
  {
    GamePlayView.a(this.this$0).native_updateParticleTexture(this.val$rgba, this.val$width, this.awr, this.WR);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.ui.GamePlayView.3
 * JD-Core Version:    0.7.0.1
 */