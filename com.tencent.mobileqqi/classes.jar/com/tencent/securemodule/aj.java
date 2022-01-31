package com.tencent.securemodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.securemodule.ui.TransparentActivity;

public final class aj
  implements DialogInterface.OnCancelListener
{
  public aj(TransparentActivity paramTransparentActivity) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.aj
 * JD-Core Version:    0.7.0.1
 */