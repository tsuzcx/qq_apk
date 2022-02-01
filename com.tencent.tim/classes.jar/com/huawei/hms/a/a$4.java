package com.huawei.hms.a;

import android.content.DialogInterface;
import android.content.DialogInterface.OnKeyListener;
import android.view.KeyEvent;

class a$4
  implements DialogInterface.OnKeyListener
{
  a$4(a parama) {}
  
  public boolean onKey(DialogInterface paramDialogInterface, int paramInt, KeyEvent paramKeyEvent)
  {
    if ((4 == paramInt) && (paramKeyEvent.getAction() == 1))
    {
      this.a.a();
      return true;
    }
    return false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hms.a.a.4
 * JD-Core Version:    0.7.0.1
 */