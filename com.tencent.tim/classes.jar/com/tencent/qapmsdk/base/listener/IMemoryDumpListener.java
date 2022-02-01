package com.tencent.qapmsdk.base.listener;

import java.util.List;
import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IMemoryDumpListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "onFinishDump", "", "isSuccess", "", "objInfo", "", "zipPath", "onPrepareDump", "", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IMemoryDumpListener
  extends IBaseListener
{
  public abstract void onFinishDump(boolean paramBoolean, @NotNull String paramString1, @NotNull String paramString2);
  
  @NotNull
  public abstract List<String> onPrepareDump(@NotNull String paramString);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IMemoryDumpListener
 * JD-Core Version:    0.7.0.1
 */