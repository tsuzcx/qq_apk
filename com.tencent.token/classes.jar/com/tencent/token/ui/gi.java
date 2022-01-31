package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import com.tencent.token.cw;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.cd;

class gi
  implements DialogInterface.OnClickListener
{
  gi(fj paramfj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    cw.a().a(0L, 0L, FaceRecognitionCameraActivity.access$1600(this.a.a), FaceRecognitionCameraActivity.access$1900(this.a.a), 0, FaceRecognitionCameraActivity.access$2000(this.a.a), FaceRecognitionCameraActivity.access$700(this.a.a).getBrightModeIntValue(), FaceRecognitionCameraActivity.access$1400(this.a.a));
    FaceRecognitionCameraActivity.access$1700(this.a.a).b();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gi
 * JD-Core Version:    0.7.0.1
 */