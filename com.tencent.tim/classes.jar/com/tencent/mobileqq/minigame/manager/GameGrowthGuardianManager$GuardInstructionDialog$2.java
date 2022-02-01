package com.tencent.mobileqq.minigame.manager;

import android.app.Activity;
import android.app.Application.ActivityLifecycleCallbacks;
import android.os.Bundle;

class GameGrowthGuardianManager$GuardInstructionDialog$2
  implements Application.ActivityLifecycleCallbacks
{
  GameGrowthGuardianManager$GuardInstructionDialog$2(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog) {}
  
  public void onActivityCreated(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityDestroyed(Activity paramActivity) {}
  
  public void onActivityPaused(Activity paramActivity) {}
  
  public void onActivityResumed(Activity paramActivity) {}
  
  public void onActivitySaveInstanceState(Activity paramActivity, Bundle paramBundle) {}
  
  public void onActivityStarted(Activity paramActivity) {}
  
  public void onActivityStopped(Activity paramActivity)
  {
    this.this$0.onBackgroundForReport();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog.2
 * JD-Core Version:    0.7.0.1
 */