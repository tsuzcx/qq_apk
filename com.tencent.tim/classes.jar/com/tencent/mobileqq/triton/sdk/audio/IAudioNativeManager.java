package com.tencent.mobileqq.triton.sdk.audio;

public abstract interface IAudioNativeManager
{
  public abstract void bindBufferToSource(int paramInt1, int paramInt2);
  
  public abstract void closeAudioContext();
  
  public abstract int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4);
  
  public abstract int createBuffer(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int createBufferSource();
  
  public abstract void createScriptProcessorNode(int paramInt1, int paramInt2, int paramInt3);
  
  public abstract byte[] getBufferChannelData(int paramInt1, int paramInt2);
  
  public abstract float getCurrentGain(int paramInt);
  
  public abstract void initAudioContext();
  
  public abstract void initOpenAL();
  
  public abstract boolean isSourceStopped(int paramInt);
  
  public abstract int loadRawData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3);
  
  public abstract int onAudioProcess(int paramInt);
  
  public abstract void pauseSource(int paramInt);
  
  public abstract void play(int paramInt, float paramFloat);
  
  public abstract void resumeAudioContext();
  
  public abstract void resumeSource(int paramInt);
  
  public abstract void setBufferSourceLoop(int paramInt, boolean paramBoolean);
  
  public abstract void setCurrentGain(int paramInt, float paramFloat);
  
  public abstract void setQueueBuffer(int paramInt1, int paramInt2);
  
  public abstract void stopSource(int paramInt);
  
  public abstract void suspendAudioContext();
  
  public abstract void testEndFunction();
  
  public abstract void testInitFunction();
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager
 * JD-Core Version:    0.7.0.1
 */