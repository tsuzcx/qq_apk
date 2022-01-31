package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

final class cv
  implements Runnable
{
  cv(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public final void run()
  {
    Message localMessage = DetectIDPhotoActivity.access$000(this.a).obtainMessage(5);
    DetectIDPhotoActivity.access$000(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.cv
 * JD-Core Version:    0.7.0.1
 */