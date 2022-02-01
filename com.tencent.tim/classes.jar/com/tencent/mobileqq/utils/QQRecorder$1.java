package com.tencent.mobileqq.utils;

import android.media.AudioRecord;

class QQRecorder$1
  implements Runnable
{
  QQRecorder$1(QQRecorder paramQQRecorder) {}
  
  public void run()
  {
    int i = AudioRecord.getMinBufferSize(this.this$0.a.mSampleRate, 2, 2);
    if (QQRecorder.a(this.this$0) < i) {
      QQRecorder.a(this.this$0, i);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.mobileqq.utils.QQRecorder.1
 * JD-Core Version:    0.7.0.1
 */