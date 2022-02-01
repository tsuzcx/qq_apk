package com.tencent.mobileqq.triton.audio;

import com.tencent.mobileqq.triton.sdk.audio.IAudioNativeManager;

public class f
  implements IAudioNativeManager
{
  public void bindBufferToSource(int paramInt1, int paramInt2)
  {
    AudioNativeManager.bindBufferToSource(paramInt1, paramInt2);
  }
  
  public void closeAudioContext() {}
  
  public int copyToChannel(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    return AudioNativeManager.copyToChannel(paramArrayOfByte, paramInt1, paramInt2, paramInt3, paramInt4);
  }
  
  public int createBuffer(int paramInt1, int paramInt2, int paramInt3)
  {
    return AudioNativeManager.createBuffer(paramInt1, paramInt2, paramInt3);
  }
  
  public int createBufferSource()
  {
    return AudioNativeManager.createBufferSource();
  }
  
  public void createScriptProcessorNode(int paramInt1, int paramInt2, int paramInt3)
  {
    AudioNativeManager.createScriptProcessorNode(paramInt1, paramInt2, paramInt3);
  }
  
  public byte[] getBufferChannelData(int paramInt1, int paramInt2)
  {
    return AudioNativeManager.getBufferChannelData(paramInt1, paramInt2);
  }
  
  public float getCurrentGain(int paramInt)
  {
    return AudioNativeManager.getCurrentGain(paramInt);
  }
  
  public void initAudioContext() {}
  
  public void initOpenAL() {}
  
  public boolean isSourceStopped(int paramInt)
  {
    return AudioNativeManager.isSourceStopped(paramInt);
  }
  
  public int loadRawData(byte[] paramArrayOfByte, int paramInt1, int paramInt2, int paramInt3)
  {
    return AudioNativeManager.loadRawData(paramArrayOfByte, paramInt1, paramInt2, paramInt3);
  }
  
  public int onAudioProcess(int paramInt)
  {
    return AudioNativeManager.onAudioProcess(paramInt);
  }
  
  public void pauseSource(int paramInt)
  {
    AudioNativeManager.pauseSource(paramInt);
  }
  
  public void play(int paramInt, float paramFloat)
  {
    AudioNativeManager.play(paramInt, paramFloat);
  }
  
  public void resumeAudioContext() {}
  
  public void resumeSource(int paramInt)
  {
    AudioNativeManager.resumeSource(paramInt);
  }
  
  public void setBufferSourceLoop(int paramInt, boolean paramBoolean)
  {
    AudioNativeManager.setBufferSourceLoop(paramInt, paramBoolean);
  }
  
  public void setCurrentGain(int paramInt, float paramFloat)
  {
    AudioNativeManager.setCurrentGain(paramInt, paramFloat);
  }
  
  public void setQueueBuffer(int paramInt1, int paramInt2)
  {
    AudioNativeManager.setQueueBuffer(paramInt1, paramInt2);
  }
  
  public void stopSource(int paramInt)
  {
    AudioNativeManager.stopSource(paramInt);
  }
  
  public void suspendAudioContext() {}
  
  public void testEndFunction() {}
  
  public void testInitFunction() {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.audio.f
 * JD-Core Version:    0.7.0.1
 */