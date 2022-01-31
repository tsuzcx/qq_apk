package com.tencent.token.ui;

import android.os.Handler;
import android.os.Message;
import java.util.TimerTask;

class ya
  extends TimerTask
{
  ya(RealNameTakeIDPhotoPreview paramRealNameTakeIDPhotoPreview) {}
  
  public void run()
  {
    Message localMessage = RealNameTakeIDPhotoPreview.a(this.a).obtainMessage(0);
    localMessage.what = 3;
    localMessage.sendToTarget();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ui.ya
 * JD-Core Version:    0.7.0.1
 */