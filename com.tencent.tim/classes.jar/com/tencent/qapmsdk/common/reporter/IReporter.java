package com.tencent.qapmsdk.common.reporter;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IReporter;", "", "report", "", "baseJson", "Lcom/tencent/qapmsdk/common/reporter/BaseJsonObject;", "callback", "Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "ReportResultCallback", "common_release"}, k=1, mv={1, 1, 15})
public abstract interface IReporter
{
  public abstract boolean report(@NotNull BaseJsonObject paramBaseJsonObject, @Nullable ReportResultCallback paramReportResultCallback);
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/reporter/IReporter$ReportResultCallback;", "", "onFailure", "", "errorCode", "", "errorMsg", "", "dbId", "onSuccess", "successCode", "common_release"}, k=1, mv={1, 1, 15})
  public static abstract interface ReportResultCallback
  {
    public abstract void onFailure(int paramInt1, @NotNull String paramString, int paramInt2);
    
    public abstract void onSuccess(int paramInt1, int paramInt2);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.reporter.IReporter
 * JD-Core Version:    0.7.0.1
 */