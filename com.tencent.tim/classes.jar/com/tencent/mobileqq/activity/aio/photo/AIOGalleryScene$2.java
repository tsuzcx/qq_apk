package com.tencent.mobileqq.activity.aio.photo;

import android.widget.ImageView;
import android.widget.LinearLayout;
import com.tencent.qphone.base.util.QLog;
import xsk;
import xto;
import xuf;
import ztk;

public class AIOGalleryScene$2
  implements Runnable
{
  public AIOGalleryScene$2(xsk paramxsk) {}
  
  public void run()
  {
    xuf localxuf = this.this$0.b.c();
    if ((localxuf == null) || (localxuf.e == null)) {}
    ImageView localImageView;
    do
    {
      return;
      localImageView = (ImageView)this.this$0.hi.findViewById(2131372728);
    } while ((((localxuf.e instanceof AIOShortVideoData)) && (((AIOShortVideoData)localxuf.e).mBusiType == 1)) || (localImageView == null) || (this.this$0.c == null));
    int i = this.this$0.c.getVideoState();
    if (QLog.isColorLevel()) {
      QLog.d("AIOGalleryScene", 2, "mVideoStateChecker, long video，videoState =  " + i);
    }
    if ((i == 1) || (i == 2) || (i == 3) || (i == 7))
    {
      localImageView.setImageResource(2130847021);
      return;
    }
    localImageView.setImageResource(2130847020);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.photo.AIOGalleryScene.2
 * JD-Core Version:    0.7.0.1
 */