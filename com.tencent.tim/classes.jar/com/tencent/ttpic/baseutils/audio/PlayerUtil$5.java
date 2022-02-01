package com.tencent.ttpic.baseutils.audio;

import android.media.MediaRecorder;
import android.media.MediaRecorder.OnErrorListener;

final class PlayerUtil$5
  implements MediaRecorder.OnErrorListener
{
  public void onError(MediaRecorder paramMediaRecorder, int paramInt1, int paramInt2)
  {
    PlayerUtil.destroyRecorder((PlayerUtil.Recorder)paramMediaRecorder);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.baseutils.audio.PlayerUtil.5
 * JD-Core Version:    0.7.0.1
 */