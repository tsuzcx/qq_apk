package com.tencent.av;

import android.graphics.Bitmap;
import com.tencent.av.app.VideoAppInterface;
import jko;

class VideoController$13
  implements Runnable
{
  VideoController$13(VideoController paramVideoController, String paramString1, String paramString2, String paramString3) {}
  
  public void run()
  {
    Bitmap localBitmap = this.this$0.mApp.a(3000, this.Mt, null, true, true);
    String str = this.this$0.mApp.getDisplayName(1004, this.Mu, this.Mt);
    jko.a(this.this$0.mApp).a(this.Mv, str, localBitmap, this.Mt, 57, 3000, 3);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.av.VideoController.13
 * JD-Core Version:    0.7.0.1
 */