package com.tencent.qqmail.activity.compose;

import com.tencent.qqmail.utilities.audio.QMAudioRecorder.RecorderCallBack;

class ComposeNoteActivity$32
  implements QMAudioRecorder.RecorderCallBack
{
  ComposeNoteActivity$32(ComposeNoteActivity paramComposeNoteActivity) {}
  
  public void onCancel()
  {
    ComposeNoteActivity.access$3902(this.this$0, null);
  }
  
  public void onError(int paramInt)
  {
    ComposeNoteActivity.access$3902(this.this$0, null);
  }
  
  public void onSuccess(String paramString1, String paramString2, long paramLong)
  {
    ComposeNoteActivity.access$3902(this.this$0, null);
    ComposeNoteActivity.access$1400(this.this$0).addAudioSpan(paramString1, paramLong, paramString2);
    ComposeNoteActivity.access$4000(this.this$0, paramString2);
    ComposeNoteActivity.access$1400(this.this$0).postDelayed(new ComposeNoteActivity.32.1(this), 300L);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qqmail.activity.compose.ComposeNoteActivity.32
 * JD-Core Version:    0.7.0.1
 */