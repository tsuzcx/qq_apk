package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.cd;

class gf
  implements DialogInterface.OnClickListener
{
  gf(fj paramfj) {}
  
  public void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRecognitionCameraActivity.access$1700(this.a.a).b();
    FaceRecognitionCameraActivity.access$1400(this.a.a).removeMessages(13);
    this.a.a.setContentView(2130968654);
    this.a.a.hideTitle();
    this.a.a.findViewById(2131558858).setOnClickListener(new gg(this));
    FaceRecognitionCameraActivity.access$402(this.a.a, (FaceRecognitionCameraPreview)this.a.a.findViewById(2131558767));
    FaceRecognitionCameraActivity.access$702(this.a.a, (FaceView)this.a.a.findViewById(2131558768));
    if (FaceRecognitionCameraActivity.access$400(this.a.a) != null) {
      FaceRecognitionCameraActivity.access$400(this.a.a).a(this.a.a, FaceRecognitionCameraActivity.access$300(this.a.a), FaceRecognitionCameraActivity.access$1400(this.a.a), FaceRecognitionCameraActivity.access$700(this.a.a), FaceRecognitionCameraActivity.access$1800(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gf
 * JD-Core Version:    0.7.0.1
 */