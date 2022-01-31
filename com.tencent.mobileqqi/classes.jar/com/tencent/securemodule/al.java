package com.tencent.securemodule;

import android.content.Context;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.content.Intent;
import com.tencent.securemodule.impl.SecureService;
import com.tencent.securemodule.ui.TransparentActivity;

public final class al
  implements DialogInterface.OnClickListener
{
  public al(TransparentActivity paramTransparentActivity, boolean paramBoolean) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    if (this.b) {}
    for (;;)
    {
      try
      {
        paramDialogInterface = new Intent();
        paramDialogInterface.addFlags(268435456);
        paramDialogInterface.setAction("com.tencent.action.virus_scan");
        this.a.startActivity(paramDialogInterface);
        this.a.finish();
        return;
      }
      catch (Throwable paramDialogInterface)
      {
        paramDialogInterface.printStackTrace();
        continue;
      }
      SecureService.a(TransparentActivity.b(this.a).getApplicationContext(), "1000011");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.al
 * JD-Core Version:    0.7.0.1
 */