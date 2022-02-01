package com.tencent.mobileqq.magicface.service;

import aiym;
import android.media.SoundPool;
import com.tencent.qphone.base.util.QLog;
import java.util.TimerTask;

public class SoundPoolUtil$2
  extends TimerTask
{
  public SoundPoolUtil$2(aiym paramaiym, int paramInt, String paramString) {}
  
  public void run()
  {
    if ((this.this$0.mSoundPool != null) && (this.this$0.mSoundPool.play(this.aCQ, 1.0F, 1.0F, 0, 0, 1.0F) == 0) && (QLog.isColorLevel())) {
      QLog.d("SoundPoolUtil", 2, "play failure filepath=" + this.val$filepath);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.magicface.service.SoundPoolUtil.2
 * JD-Core Version:    0.7.0.1
 */