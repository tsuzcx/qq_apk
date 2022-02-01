package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import iiv;
import jko;

class VideoController$14
  implements Runnable
{
  VideoController$14(VideoController paramVideoController) {}
  
  public void run()
  {
    String str = this.this$0.mApp.getDisplayName(this.this$0.b().uinType, String.valueOf(this.this$0.b().ll), null);
    Bitmap localBitmap = this.this$0.mApp.a(this.this$0.b().uinType, String.valueOf(this.this$0.b().ll), null, true, true);
    jko.a(this.this$0.mApp).a(this.this$0.b().sessionId, str, localBitmap, String.valueOf(this.this$0.b().ll), 44, this.this$0.b().uinType, this.this$0.b().amI);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.14
 * JD-Core Version:    0.7.0.1
 */