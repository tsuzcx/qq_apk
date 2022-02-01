package com.tencent.mobileqq.activity.photo;

import com.tencent.mobileqq.troop.utils.TroopUploadingThread.a;
import zri;
import zta;

public class TroopAvatarController$4
  implements Runnable
{
  public TroopAvatarController$4(zta paramzta, TroopUploadingThread.a parama, zri paramzri, int paramInt) {}
  
  public void run()
  {
    int i = this.b.dWC;
    this.e.isUploading = false;
    this.e.fromType = 1;
    this.e.aYK = false;
    this.this$0.c(this.e);
    i &= 0x7FFFFFFF;
    if ((i < 0) || (i > 1))
    {
      this.e.baF = String.valueOf(this.ceT);
      this.e.fromType = 1;
      this.e.isUploading = false;
      if (this.this$0.a(this.ceT, this.e)) {
        zta.a(this.this$0, this.e);
      }
    }
    zta.a(this.this$0, null);
    zta.b(this.this$0, null);
    this.this$0.a(this.e, this.b);
    this.this$0.notifyDataSetChanged();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.photo.TroopAvatarController.4
 * JD-Core Version:    0.7.0.1
 */