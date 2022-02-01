package com.tencent.mobileqq.activity.aio.audiopanel;

import android.widget.TextView;

class CommonRecordSoundPanel$3
  implements Runnable
{
  CommonRecordSoundPanel$3(CommonRecordSoundPanel paramCommonRecordSoundPanel, int paramInt, double paramDouble) {}
  
  public void run()
  {
    int i = AudioPanel.fc(this.bQk);
    this.this$0.jd(i);
    CommonRecordSoundPanel.a(this.this$0).setText(AudioPanel.a(this.bz));
    this.this$0.recordTime = this.bz;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.CommonRecordSoundPanel.3
 * JD-Core Version:    0.7.0.1
 */