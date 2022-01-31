package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnCancelListener;
import com.tencent.token.ui.base.FaceView;

class hx
  implements DialogInterface.OnCancelListener
{
  hx(hs paramhs) {}
  
  public void onCancel(DialogInterface paramDialogInterface)
  {
    FaceRegCameraActivity.access$400(this.a.a).a(true, false, 0, FaceRegCameraActivity.access$300(this.a.a));
    FaceRegCameraActivity.access$500(this.a.a).setStatus(0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.hx
 * JD-Core Version:    0.7.0.1
 */