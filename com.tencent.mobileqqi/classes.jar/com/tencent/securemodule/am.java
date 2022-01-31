package com.tencent.securemodule;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.securemodule.ui.TransparentActivity;

public final class am
  implements DialogInterface.OnClickListener
{
  public am(TransparentActivity paramTransparentActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    this.a.finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.securemodule.am
 * JD-Core Version:    0.7.0.1
 */