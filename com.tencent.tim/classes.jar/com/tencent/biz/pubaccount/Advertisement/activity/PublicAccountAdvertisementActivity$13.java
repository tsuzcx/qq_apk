package com.tencent.biz.pubaccount.Advertisement.activity;

import android.media.AudioManager;
import com.tencent.biz.pubaccount.Advertisement.fragment.VideoCoverFragment;
import com.tencent.qphone.base.util.QLog;

class PublicAccountAdvertisementActivity$13
  implements Runnable
{
  PublicAccountAdvertisementActivity$13(PublicAccountAdvertisementActivity paramPublicAccountAdvertisementActivity) {}
  
  public void run()
  {
    if (QLog.isColorLevel()) {
      QLog.d("volumeTrace", 2, ",music system is thread " + PublicAccountAdvertisementActivity.a(this.this$0).aEh);
    }
    PublicAccountAdvertisementActivity.a(this.this$0).setStreamVolume(3, PublicAccountAdvertisementActivity.a(this.this$0).aEh, 0);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.biz.pubaccount.Advertisement.activity.PublicAccountAdvertisementActivity.13
 * JD-Core Version:    0.7.0.1
 */