package com.tencent.mobileqq.activity.aio.audiopanel;

import android.view.ViewGroup;
import com.tencent.mobileqq.activity.BaseChatPie;
import com.tencent.mobileqq.utils.QQRecorder.RecorderParam;

class PressToSpeakPanel$12
  implements Runnable
{
  PressToSpeakPanel$12(PressToSpeakPanel paramPressToSpeakPanel, String paramString, QQRecorder.RecorderParam paramRecorderParam) {}
  
  public void run()
  {
    PressToSpeakPanel.a(this.this$0).e(this.val$path, this.d);
    ListenPanel localListenPanel = (ListenPanel)PressToSpeakPanel.a(this.this$0).findViewById(2131370577);
    localListenPanel.setVisibility(0);
    localListenPanel.setAudioPath(this.val$path, PressToSpeakPanel.a(this.this$0), this.d);
    localListenPanel.setJumpSource(ListenPanel.bQf);
    PressToSpeakPanel.a(this.this$0).setStatus(4);
    this.this$0.setVisibility(8);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mobileqq.activity.aio.audiopanel.PressToSpeakPanel.12
 * JD-Core Version:    0.7.0.1
 */