package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.tencent.token.ui.base.FaceView;
import com.tencent.token.ui.base.co;

final class fn
  implements DialogInterface.OnClickListener
{
  fn(es parames) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRecognitionCameraActivity.access$1500(this.a.a).b();
    FaceRecognitionCameraActivity.access$1200(this.a.a).removeMessages(13);
    this.a.a.setContentView(2130903089);
    this.a.a.hideTitle();
    this.a.a.findViewById(2131296572).setOnClickListener(new fo(this));
    FaceRecognitionCameraActivity.access$702(this.a.a, (FaceRecognitionCameraPreview)this.a.a.findViewById(2131296481));
    FaceRecognitionCameraActivity.access$502(this.a.a, (FaceView)this.a.a.findViewById(2131296482));
    if (FaceRecognitionCameraActivity.access$700(this.a.a) != null) {
      FaceRecognitionCameraActivity.access$700(this.a.a).a(this.a.a, FaceRecognitionCameraActivity.access$300(this.a.a), FaceRecognitionCameraActivity.access$1200(this.a.a), FaceRecognitionCameraActivity.access$500(this.a.a), FaceRecognitionCameraActivity.access$1600(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.fn
 * JD-Core Version:    0.7.0.1
 */