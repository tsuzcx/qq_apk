package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;

class dl
  implements Runnable
{
  dl(DetectIDPhotoActivity paramDetectIDPhotoActivity) {}
  
  public void run()
  {
    Message localMessage = DetectIDPhotoActivity.access$000(this.a).obtainMessage(5);
    DetectIDPhotoActivity.access$000(this.a).sendMessage(localMessage);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.dl
 * JD-Core Version:    0.7.0.1
 */