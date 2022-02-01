package com.tencent.mobileqq.ar.ARRecord;

import java.lang.ref.WeakReference;

public abstract class AudioRecordController
  extends Thread
{
  public WeakReference<VideoRecordController> mRef;
  
  public AudioRecordController(VideoRecordController paramVideoRecordController)
  {
    super("AudioRecordThread");
    this.mRef = new WeakReference(paramVideoRecordController);
  }
  
  public abstract void Ml();
  
  public abstract void cQk();
  
  public void run()
  {
    Ml();
  }
  
  public abstract void stopAudioRecord();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes8.jar
 * Qualified Name:     com.tencent.mobileqq.ar.ARRecord.AudioRecordController
 * JD-Core Version:    0.7.0.1
 */