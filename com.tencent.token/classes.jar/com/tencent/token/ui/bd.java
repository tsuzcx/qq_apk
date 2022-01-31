package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import android.net.Uri;
import com.tencent.token.global.h;

class bd
  implements DialogInterface.OnClickListener
{
  bd(AssistantRecommendFriendQrcode paramAssistantRecommendFriendQrcode) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    try
    {
      paramDialogInterface = new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.tencent.mm"));
      this.a.startActivity(paramDialogInterface);
      return;
    }
    catch (Exception paramDialogInterface)
    {
      paramDialogInterface.printStackTrace();
      h.b(paramDialogInterface.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.bd
 * JD-Core Version:    0.7.0.1
 */