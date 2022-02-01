package com.tencent.qqmini.sdk.manager;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Process;
import com.tencent.qqmini.sdk.launcher.log.QMLog;

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
      if ((this.this$0.getContext() != null) && ((this.this$0.getContext() instanceof Activity)))
      {
        ((Activity)this.this$0.getContext()).onBackPressed();
        return;
      }
      Process.killProcess(Process.myPid());
      return;
    }
    catch (Throwable paramDialogInterface)
    {
      QMLog.e("GameGrowthGuardianManager", "getPositiveDialogAction", paramDialogInterface);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.manager.GameGrowthGuardianManager.GuardInstructionDialogLogout.1
 * JD-Core Version:    0.7.0.1
 */