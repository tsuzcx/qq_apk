package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.token.af;

final class ae
  implements DialogInterface.OnCancelListener
{
  ae(aa paramaa) {}
  
  public final void onCancel(DialogInterface paramDialogInterface)
  {
    af.a().b(this.a.a.mHandler);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ae
 * JD-Core Version:    0.7.0.1
 */