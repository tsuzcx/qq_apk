package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import java.util.ArrayList;
import java.util.Iterator;
import zri;
import ztd;

public class TroopPhotoController$2
  implements Runnable
{
  public TroopPhotoController$2(ztd paramztd, TroopUploadingThread.a parama, zri paramzri, int paramInt) {}
  
  public void run()
  {
    int i = this.b.dWC;
    this.e.isUploading = false;
    this.e.fromType = 1;
    this.e.aYK = false;
    this.this$0.c(this.e);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1)) {
      this.this$0.a(this.ceT, this.e);
    }
    Iterator localIterator = this.this$0.rN.iterator();
    while (localIterator.hasNext())
    {
      TroopClipPic localTroopClipPic = (TroopClipPic)localIterator.next();
      if (localTroopClipPic.ts == this.e.ts) {
        this.this$0.rN.remove(localTroopClipPic);
      }
    }
    this.this$0.a(this.e, this.b);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopPhotoController.2
 * JD-Core Version:    0.7.0.1
 */