package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.qphone.base.util.QLog;

class GameGrowthGuardianManager$GuardInstructionDialogLogout$1
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogLogout$1(GameGrowthGuardianManager.GuardInstructionDialogLogout paramGuardInstructionDialogLogout) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.this$0.performReport("click");
    paramDialogInterface.dismiss();
    try
    {
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QLog.e("GameGrowthGuardianManag", 1, paramDialogInterface, new Object[0]);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.1
 * JD-Core Version:    0.7.0.1
 */