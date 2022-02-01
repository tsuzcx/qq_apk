package com.tencent.ttpic.voicechanger.common.audio;

import com.tencent.ttpic.baseutils.log.LogUtils;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.ShortBuffer;
import java.util.LinkedList;

class AudioRecorderCompat$AsyncPcmWriter$2
  implements Runnable
{
  AudioRecorderCompat$AsyncPcmWriter$2(AudioRecorderCompat.AsyncPcmWriter paramAsyncPcmWriter, byte[] paramArrayOfByte, int paramInt) {}
  
  public void run()
  {
    try
    {
      l = System.currentTimeMillis();
      byte[] arrayOfByte = this.val$fileBuffer;
      Object localObject1 = arrayOfByte;
      if (this.this$1.this$0.mVoiceChangeEnable)
      {
        localObject1 = arrayOfByte;
        if (this.this$1.this$0.mVoiceChanger != null)
        {
          localObject1 = new short[this.val$count / 2];
          ByteBuffer.wrap(this.val$fileBuffer).order(ByteOrder.LITTLE_ENDIAN).asShortBuffer().get((short[])localObject1);
          this.this$1.this$0.mVoiceChanger.writeVoiceFrames((short[])localObject1);
          localObject1 = null;
          if (0 == 0) {
            throw new Exception("frames is null");
          }
        }
      }
    }
    catch (Exception localException)
    {
      long l;
      LogUtils.e(AudioRecorderCompat.TAG, "onRecord() - ERROR", new Object[] { localException.getMessage() });
      try
      {
        AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1).close();
        return;
      }
      catch (IOException localIOException)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "can't close?", localIOException, new Object[0]);
      }
      if ((this.this$1.this$0.mRealPackerEnable) && (this.this$1.this$0.mPcmPacker != null)) {
        this.this$1.this$0.mPcmPacker.encodeBytes(localException);
      }
      for (;;)
      {
        LogUtils.d(AudioRecorderCompat.TAG, "Process 1 recorded frame: " + (System.currentTimeMillis() - l) + " ms");
        synchronized (AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1))
        {
          if (AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1).size() < 8) {
            AudioRecorderCompat.AsyncPcmWriter.access$100(this.this$1).add(this.val$fileBuffer);
          }
          return;
        }
        AudioRecorderCompat.AsyncPcmWriter.access$000(this.this$1).write(???, 0, ???.length);
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.ttpic.voicechanger.common.audio.AudioRecorderCompat.AsyncPcmWriter.2
 * JD-Core Version:    0.7.0.1
 */