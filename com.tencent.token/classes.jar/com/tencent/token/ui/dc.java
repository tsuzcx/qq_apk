package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;

final class dc
  implements DialogInterface.OnClickListener
{
  dc(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    DetectIDPhotoActivity.access$100(this.a).a(false);
    if (!DetectIDPhotoActivity.access$600(this.a))
    {
      DetectIDPhotoActivity.access$602(this.a, true);
      DetectIDPhotoActivity.access$100(this.a).postDelayed(DetectIDPhotoActivity.access$1700(this.a), 30000L);
    }
    this.a.dismissDialog();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dc
 * JD-Core Version:    0.7.0.1
 */