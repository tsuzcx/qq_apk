package com.tencent.qapmsdk.base.listener;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/base/listener/IBatteryReportListener;", "Lcom/tencent/qapmsdk/base/listener/IBaseListener;", "getSosoClassName", "", "onPrintLog", "", "msg", "onUsageAlarm", "monitorType", "", "exceptType", "level", "message", "description", "qapmbase_release"}, k=1, mv={1, 1, 15})
public abstract interface IBatteryReportListener
  extends IBaseListener
{
  @NotNull
  public abstract String getSosoClassName();
  
  public abstract void onPrintLog(@NotNull String paramString);
  
  public abstract void onUsageAlarm(int paramInt1, int paramInt2, int paramInt3, @NotNull String paramString1, @NotNull String paramString2);
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.base.listener.IBatteryReportListener
 * JD-Core Version:    0.7.0.1
 */