package com.tencent.device;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import rwe;

final class DeviceScanner$1
  implements DialogInterface.OnClickListener
{
  DeviceScanner$1(rwe paramrwe) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    paramDialogInterface.dismiss();
    if (this.val$callBack != null) {
      this.val$callBack.bwZ();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.device.DeviceScanner.1
 * JD-Core Version:    0.7.0.1
 */