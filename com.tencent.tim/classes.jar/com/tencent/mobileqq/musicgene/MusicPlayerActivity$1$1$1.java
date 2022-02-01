package com.tencent.mobileqq.musicgene;

import ajmu;
import ajna;
import ajnb;
import android.graphics.Bitmap;
import android.os.Message;

public class MusicPlayerActivity$1$1$1
  implements Runnable
{
  public MusicPlayerActivity$1$1$1(ajnb paramajnb, int paramInt) {}
  
  public void run()
  {
    Object localObject = ajmu.I(this.a.jdField_a_of_type_ComTencentMobileqqMusicgeneMusicPlayerActivity$c.imgUrl);
    if (localObject != null)
    {
      int i = ((Bitmap)localObject).getWidth();
      int j = ((Bitmap)localObject).getHeight();
      if (i * j > 8000)
      {
        double d = Math.sqrt(8000.0D / (i * j));
        Bitmap localBitmap = Bitmap.createScaledBitmap((Bitmap)localObject, (int)(i * d), (int)(j * d), true);
        ((Bitmap)localObject).recycle();
        localObject = Message.obtain(MusicPlayerActivity.a(this.a.jdField_a_of_type_Ajna.a), 55);
        ((Message)localObject).arg1 = this.val$position;
        ((Message)localObject).obj = localBitmap;
        ((Message)localObject).sendToTarget();
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.musicgene.MusicPlayerActivity.1.1.1
 * JD-Core Version:    0.7.0.1
 */