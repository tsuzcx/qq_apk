package com.tencent.tissue.v8rt.engine;

import com.tencent.tissue.v8rt.anno.NotNull;
import com.tencent.tissue.v8rt.anno.Nullable;

public abstract interface IInspectorAgent
{
  public abstract boolean isWaitForDebugger();
  
  public abstract void sendMessageToDebugger(@NotNull String paramString);
  
  public abstract void setOnDebuggerMessageListener(@Nullable IDebuggerMessageListener paramIDebuggerMessageListener);
  
  public abstract void stop();
  
  public static abstract interface IDebuggerMessageListener
  {
    public abstract void sendMessageToEngine(@NotNull String paramString);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tissue.v8rt.engine.IInspectorAgent
 * JD-Core Version:    0.7.0.1
 */