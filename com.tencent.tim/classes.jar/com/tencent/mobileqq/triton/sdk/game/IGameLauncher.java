package com.tencent.mobileqq.triton.sdk.game;

import androidx.annotation.NonNull;
import com.tencent.mobileqq.triton.sdk.statics.ScriptLoadResult;

public abstract interface IGameLauncher
{
  public abstract MiniGameInfo getCurrentGame();
  
  public abstract void launchGame(@NonNull GameLaunchParam paramGameLaunchParam);
  
  public abstract ScriptLoadResult launchSubpackage(@NonNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.game.IGameLauncher
 * JD-Core Version:    0.7.0.1
 */