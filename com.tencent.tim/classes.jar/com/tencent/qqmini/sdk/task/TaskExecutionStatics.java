package com.tencent.qqmini.sdk.task;

import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics;", "", "name", "", "runDurationMs", "", "totalRunDurationMs", "status", "Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "message", "subSteps", "", "(Ljava/lang/String;JJLcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;Ljava/lang/String;Ljava/util/List;)V", "getMessage", "()Ljava/lang/String;", "getName", "getRunDurationMs", "()J", "getStatus", "()Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "getSubSteps", "()Ljava/util/List;", "getTotalRunDurationMs", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "Status", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
public final class TaskExecutionStatics
{
  @NotNull
  private final String message;
  @NotNull
  private final String name;
  private final long runDurationMs;
  @NotNull
  private final Status status;
  @NotNull
  private final List<TaskExecutionStatics> subSteps;
  private final long totalRunDurationMs;
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong)
  {
    this(paramString, paramLong, 0L, null, null, null, 60, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong1, long paramLong2)
  {
    this(paramString, paramLong1, paramLong2, null, null, null, 56, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString, long paramLong1, long paramLong2, @NotNull Status paramStatus)
  {
    this(paramString, paramLong1, paramLong2, paramStatus, null, null, 48, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull Status paramStatus, @NotNull String paramString2)
  {
    this(paramString1, paramLong1, paramLong2, paramStatus, paramString2, null, 32, null);
  }
  
  @JvmOverloads
  public TaskExecutionStatics(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull Status paramStatus, @NotNull String paramString2, @NotNull List<TaskExecutionStatics> paramList)
  {
    this.name = paramString1;
    this.runDurationMs = paramLong1;
    this.totalRunDurationMs = paramLong2;
    this.status = paramStatus;
    this.message = paramString2;
    this.subSteps = paramList;
  }
  
  @NotNull
  public final String component1()
  {
    return this.name;
  }
  
  public final long component2()
  {
    return this.runDurationMs;
  }
  
  public final long component3()
  {
    return this.totalRunDurationMs;
  }
  
  @NotNull
  public final Status component4()
  {
    return this.status;
  }
  
  @NotNull
  public final String component5()
  {
    return this.message;
  }
  
  @NotNull
  public final List<TaskExecutionStatics> component6()
  {
    return this.subSteps;
  }
  
  @NotNull
  public final TaskExecutionStatics copy(@NotNull String paramString1, long paramLong1, long paramLong2, @NotNull Status paramStatus, @NotNull String paramString2, @NotNull List<TaskExecutionStatics> paramList)
  {
    Intrinsics.checkParameterIsNotNull(paramString1, "name");
    Intrinsics.checkParameterIsNotNull(paramStatus, "status");
    Intrinsics.checkParameterIsNotNull(paramString2, "message");
    Intrinsics.checkParameterIsNotNull(paramList, "subSteps");
    return new TaskExecutionStatics(paramString1, paramLong1, paramLong2, paramStatus, paramString2, paramList);
  }
  
  public boolean equals(@Nullable Object paramObject)
  {
    if (this != paramObject)
    {
      if ((paramObject instanceof TaskExecutionStatics))
      {
        paramObject = (TaskExecutionStatics)paramObject;
        if ((!Intrinsics.areEqual(this.name, paramObject.name)) || (this.runDurationMs != paramObject.runDurationMs) || (this.totalRunDurationMs != paramObject.totalRunDurationMs) || (!Intrinsics.areEqual(this.status, paramObject.status)) || (!Intrinsics.areEqual(this.message, paramObject.message)) || (!Intrinsics.areEqual(this.subSteps, paramObject.subSteps))) {}
      }
    }
    else {
      return true;
    }
    return false;
  }
  
  @NotNull
  public final String getMessage()
  {
    return this.message;
  }
  
  @NotNull
  public final String getName()
  {
    return this.name;
  }
  
  public final long getRunDurationMs()
  {
    return this.runDurationMs;
  }
  
  @NotNull
  public final Status getStatus()
  {
    return this.status;
  }
  
  @NotNull
  public final List<TaskExecutionStatics> getSubSteps()
  {
    return this.subSteps;
  }
  
  public final long getTotalRunDurationMs()
  {
    return this.totalRunDurationMs;
  }
  
  public int hashCode()
  {
    int m = 0;
    Object localObject = this.name;
    int i;
    int n;
    int i1;
    int j;
    if (localObject != null)
    {
      i = localObject.hashCode();
      long l = this.runDurationMs;
      n = (int)(l ^ l >>> 32);
      l = this.totalRunDurationMs;
      i1 = (int)(l ^ l >>> 32);
      localObject = this.status;
      if (localObject == null) {
        break label141;
      }
      j = localObject.hashCode();
      label71:
      localObject = this.message;
      if (localObject == null) {
        break label146;
      }
    }
    label141:
    label146:
    for (int k = localObject.hashCode();; k = 0)
    {
      localObject = this.subSteps;
      if (localObject != null) {
        m = localObject.hashCode();
      }
      return (k + (j + ((i * 31 + n) * 31 + i1) * 31) * 31) * 31 + m;
      i = 0;
      break;
      j = 0;
      break label71;
    }
  }
  
  @NotNull
  public String toString()
  {
    return "TaskExecutionStatics(name=" + this.name + ", runDurationMs=" + this.runDurationMs + ", totalRunDurationMs=" + this.totalRunDurationMs + ", status=" + this.status + ", message=" + this.message + ", subSteps=" + this.subSteps + ")";
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qqmini/sdk/task/TaskExecutionStatics$Status;", "", "(Ljava/lang/String;I)V", "WAIT", "RUNNING", "SUCCESS", "FAIL", "CACHED", "lib_minisdk_internalRelease"}, k=1, mv={1, 1, 16})
  public static enum Status
  {
    static
    {
      Status localStatus1 = new Status("WAIT", 0);
      WAIT = localStatus1;
      Status localStatus2 = new Status("RUNNING", 1);
      RUNNING = localStatus2;
      Status localStatus3 = new Status("SUCCESS", 2);
      SUCCESS = localStatus3;
      Status localStatus4 = new Status("FAIL", 3);
      FAIL = localStatus4;
      Status localStatus5 = new Status("CACHED", 4);
      CACHED = localStatus5;
      $VALUES = new Status[] { localStatus1, localStatus2, localStatus3, localStatus4, localStatus5 };
    }
    
    private Status() {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes11.jar
 * Qualified Name:     com.tencent.qqmini.sdk.task.TaskExecutionStatics
 * JD-Core Version:    0.7.0.1
 */