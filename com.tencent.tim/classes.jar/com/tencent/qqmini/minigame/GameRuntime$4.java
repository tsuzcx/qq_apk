package com.tencent.qqmini.minigame;

import android.os.Process;

class GameRuntime$4
  implements Runnable
{
  GameRuntime$4(GameRuntime paramGameRuntime) {}
  
  public void run()
  {
    Process.killProcess(Process.myPid());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.minigame.GameRuntime.4
 * JD-Core Version:    0.7.0.1
 */