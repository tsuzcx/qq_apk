package com.tencent.mobileqq.triton.sdk.bridge;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public abstract interface InspectorAgent
{
  public abstract void sendMessageToDebugger(@NonNull String paramString);
  
  public abstract void setOnDebuggerMessageListener(@Nullable DebuggerMessageListener paramDebuggerMessageListener);
  
  public static abstract interface DebuggerMessageListener
  {
    public abstract void sendMessageToEngine(@NonNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.sdk.bridge.InspectorAgent
 * JD-Core Version:    0.7.0.1
 */