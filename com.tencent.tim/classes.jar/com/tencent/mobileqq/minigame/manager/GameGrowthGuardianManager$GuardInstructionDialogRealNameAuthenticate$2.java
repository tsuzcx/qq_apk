package com.tencent.mobileqq.minigame.manager;

import NS_MINI_INTERFACE.INTERFACE.GuardInstruction;
import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.mobileqq.activity.QQBrowserActivity;
import com.tencent.mobileqq.pb.PBStringField;

class GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$2
  implements DialogInterface.OnClickListener
{
  GameGrowthGuardianManager$GuardInstructionDialogRealNameAuthenticate$2(GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate paramGuardInstructionDialogRealNameAuthenticate) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (((this.this$0.getContext() instanceof Activity)) && (this.this$0.getGuardInstruction() != null))
    {
      paramDialogInterface = (Activity)this.this$0.getContext();
      paramDialogInterface.startActivity(new Intent(paramDialogInterface, QQBrowserActivity.class).putExtra("url", this.this$0.getGuardInstruction().url.get()));
    }
    this.this$0.performReport("identi_click");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameGrowthGuardianManager.GuardInstructionDialogRealNameAuthenticate.2
 * JD-Core Version:    0.7.0.1
 */