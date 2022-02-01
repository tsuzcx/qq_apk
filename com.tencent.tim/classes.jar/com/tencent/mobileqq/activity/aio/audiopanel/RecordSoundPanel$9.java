package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

class RecordSoundPanel$9
  implements Runnable
{
  RecordSoundPanel$9(RecordSoundPanel paramRecordSoundPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    this.this$0.a.e(this.val$path, this.d);
    this.this$0.dc.setVisibility(8);
    ListenPanel localListenPanel = (ListenPanel)this.this$0.ba.findViewById(2131370577);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.val$path, this.this$0.recordTime, this.d);
    localListenPanel.setJumpSource(ListenPanel.bQg);
    this.this$0.b.setStatus(4);
    this.this$0.setVisibility(8);
    this.this$0.setClickable(true);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.RecordSoundPanel.9
 * JD-Core Version:    0.7.0.1
 */