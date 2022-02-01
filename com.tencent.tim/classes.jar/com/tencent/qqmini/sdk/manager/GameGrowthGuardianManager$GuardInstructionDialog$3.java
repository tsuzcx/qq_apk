package com.tencent.qqmini.sdk.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnShowListener;

class GameGrowthGuardianManager$GuardInstructionDialog$3
  implements DialogInterface.OnShowListener
{
  GameGrowthGuardianManager$GuardInstructionDialog$3(GameGrowthGuardianManager.GuardInstructionDialog paramGuardInstructionDialog, GameGrowthGuardianManager.OnStopCallback paramOnStopCallback) {}
  
  public void onShow(DialogInterface paramDialogInterface)
  {
    this.this$0.onShowForReport(paramDialogInterface);
    GameGrowthGuardianManager.access$600(this.this$0.getMiniAppInfo(), GameGrowthGuardianManager.GuardInstructionDialog.access$500(this.this$0), this.this$0.getGuardInstruction());
    GameGrowthGuardianManager.registerActivityOnStopCallback(this.val$onStopCallback);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialog.3
 * JD-Core Version:    0.7.0.1
 */