package com.huawei.hiar;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

class InformActivityImpl$1
  implements DialogInterface.OnClickListener
{
  InformActivityImpl$1(InformActivityImpl paramInformActivityImpl) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    j.b().b = this.a.userFatal;
    InformActivityImpl.access$000(this.a).finish();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.hiar.InformActivityImpl.1
 * JD-Core Version:    0.7.0.1
 */