package com.tencent.qapmsdk.common.logger;

import kotlin.Metadata;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/LogState;", "", "value", "", "(Ljava/lang/String;II)V", "getValue", "()I", "OFF", "ERROR", "WARN", "INFO", "DEBUG", "VERBOS", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public enum LogState
{
  public static final Companion Companion = new Companion(null);
  private static final LogState[] values = values();
  private final int value;
  
  static
  {
    LogState localLogState1 = new LogState("OFF", 0, 0);
    OFF = localLogState1;
    LogState localLogState2 = new LogState("ERROR", 1, 1);
    ERROR = localLogState2;
    LogState localLogState3 = new LogState("WARN", 2, 2);
    WARN = localLogState3;
    LogState localLogState4 = new LogState("INFO", 3, 3);
    INFO = localLogState4;
    LogState localLogState5 = new LogState("DEBUG", 4, 4);
    DEBUG = localLogState5;
    LogState localLogState6 = new LogState("VERBOS", 5, 5);
    VERBOS = localLogState6;
    $VALUES = new LogState[] { localLogState1, localLogState2, localLogState3, localLogState4, localLogState5, localLogState6 };
  }
  
  private LogState(int paramInt)
  {
    this.value = paramInt;
  }
  
  public final int getValue()
  {
    return this.value;
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logger/LogState$Companion;", "", "()V", "values", "", "Lcom/tencent/qapmsdk/common/logger/LogState;", "[Lcom/tencent/qapmsdk/common/logger/LogState;", "getByValue", "value", "", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    @Nullable
    public final LogState getByValue(int paramInt)
    {
      LogState[] arrayOfLogState = LogState.access$getValues$cp();
      int k = arrayOfLogState.length;
      int i = 0;
      while (i < k)
      {
        LogState localLogState = arrayOfLogState[i];
        if (localLogState.getValue() == paramInt) {}
        for (int j = 1; j != 0; j = 0) {
          return localLogState;
        }
        i += 1;
      }
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logger.LogState
 * JD-Core Version:    0.7.0.1
 */