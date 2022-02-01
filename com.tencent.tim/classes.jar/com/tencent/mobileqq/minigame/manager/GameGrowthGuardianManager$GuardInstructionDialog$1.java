package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.StJudgeTimingRsp;
import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnDismissListener;
import com.tencent.mobileqq.mini.apkg.MiniAppConfig;

final class GameGrowthGuardianManager$GuardInstructionDialog$1
  implements DialogInterface.OnDismissListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$1(Context paramContext, MiniAppConfig paramMiniAppConfig, INTERFACE.StJudgeTimingRsp paramStJudgeTimingRsp, int paramInt) {}
  
  public void onDismiss(DialogInterface paramDialogInterface)
  {
    GameGrowthGuardianManager.GuardInstructionDialog.tryBuildAndShow(this.val$context, this.val$miniAppConfig, this.val$judgeTimingRsp, this.val$currentIndexOfInstruction + 1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialog.1
 * JD-Core Version:    0.7.0.1
 */