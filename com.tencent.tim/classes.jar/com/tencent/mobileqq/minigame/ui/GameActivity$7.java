package com.tencent.mobileqq.minigame.ui;

class GameActivity$7
  implements Runnable
{
  GameActivity$7(GameActivity paramGameActivity) {}
  
  public void run()
  {
    if (GameActivity.access$1100(this.this$0) != null)
    {
      GameActivity.access$1200(this.this$0);
      return;
    }
    this.this$0.tryStartGameWhenReady();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.ui.GameActivity.7
 * JD-Core Version:    0.7.0.1
 */