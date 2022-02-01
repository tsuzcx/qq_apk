package com.tencent.qapmsdk.memory;

import com.tencent.qapmsdk.base.listener.IMemoryCellingListener;
import java.util.ArrayList;
import java.util.List;
import org.jetbrains.annotations.NotNull;

final class MemoryCeilingMonitor$1
  implements IMemoryCellingListener
{
  public void onBeforeUploadJson() {}
  
  public boolean onCanDump(long paramLong)
  {
    return true;
  }
  
  public void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2) {}
  
  public void onLowMemory(long paramLong) {}
  
  @NotNull
  public List<String> onPrepareDump(@NotNull String paramString)
  {
    return new ArrayList();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.memory.MemoryCeilingMonitor.1
 * JD-Core Version:    0.7.0.1
 */