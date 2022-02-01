package com.tencent.mobileqq.activity;

import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

class H5MagicPlayerActivity$4
  extends TimerTask
{
  H5MagicPlayerActivity$4(H5MagicPlayerActivity paramH5MagicPlayerActivity, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.mSoundPool != null) && (this.this$0.mSoundPool.play(this.this$0.bHJ, 1.0F, 1.0F, 0, this.this$0.loop - 1, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.val$filePath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.H5MagicPlayerActivity.4
 * JD-Core Version:    0.7.0.1
 */