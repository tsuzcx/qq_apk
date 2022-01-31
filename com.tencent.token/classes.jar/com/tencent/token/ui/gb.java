package com.tencent.token.ui;

import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Handler;
import android.view.View;
import com.tencent.token.ui.base.FaceImageView;
import com.tencent.token.ui.base.co;

final class gb
  implements DialogInterface.OnClickListener
{
  gb(fz paramfz) {}
  
  public final void onClick(DialogInterface paramDialogInterface, int paramInt)
  {
    FaceRecognitionCameraActivityOld.access$1700(this.a.a).b();
    FaceRecognitionCameraActivityOld.access$1100(this.a.a).removeMessages(13);
    this.a.a.setContentView(2130903089);
    this.a.a.hideTitle();
    this.a.a.findViewById(2131296572).setOnClickListener(new gc(this));
    FaceRecognitionCameraActivityOld.access$1002(this.a.a, (FaceRecognitionCameraPreviewOld)this.a.a.findViewById(2131296481));
    FaceRecognitionCameraActivityOld.access$302(this.a.a, (FaceImageView)this.a.a.findViewById(2131296482));
    if (FaceRecognitionCameraActivityOld.access$1000(this.a.a) != null) {
      FaceRecognitionCameraActivityOld.access$1000(this.a.a).a(this.a.a, FaceRecognitionCameraActivityOld.access$100(this.a.a), FaceRecognitionCameraActivityOld.access$1100(this.a.a));
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.gb
 * JD-Core Version:    0.7.0.1
 */