package com.tencent.mobileqq.minigame.manager;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class GameCloseManager$2
  implements DialogInterface.OnClickListener
{
  GameCloseManager$2(DialogInterface.OnClickListener paramOnClickListener) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.val$onLeaveGameClickListener != null) {
      this.val$onLeaveGameClickListener.onClick(paramDialogInterface, paramInt);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.manager.GameCloseManager.2
 * JD-Core Version:    0.7.0.1
 */