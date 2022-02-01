package com.tencent.mobileqq.activity.aio.photo;

import android.widget.SeekBar;
import android.widget.TextView;
import xsk;
import xto;
import xuf;

public class AIOGalleryScene$4
  implements Runnable
{
  public AIOGalleryScene$4(xsk paramxsk, long paramLong, float paramFloat, String paramString) {}
  
  public void run()
  {
    Object localObject = this.this$0.b.c();
    if ((localObject == null) || (((xuf)localObject).e.id != this.val$id)) {
      return;
    }
    if (AIOFileVideoData.class.isInstance(((xuf)localObject).e))
    {
      localObject = (AIOFileVideoData)((xuf)localObject).e;
      ((AIOFileVideoData)localObject).progress = (((float)((AIOFileVideoData)localObject).size * this.val$progress));
    }
    this.this$0.gm(false);
    this.this$0.zA(true);
    this.this$0.Kl.setText(this.aWh);
    int i = (int)(10000.0F * this.val$progress);
    this.this$0.l.setProgress(i);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.4
 * JD-Core Version:    0.7.0.1
 */