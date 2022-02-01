package com.tencent.qapmsdk.common.logcat;

import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lcom/tencent/qapmsdk/common/logcat/LogcatFromNative;", "invoke"}, k=3, mv={1, 1, 15})
final class LogcatManager$Companion$nativeLog$2
  extends Lambda
  implements Function0<LogcatFromNative>
{
  public static final 2 INSTANCE = new 2();
  
  LogcatManager$Companion$nativeLog$2()
  {
    super(0);
  }
  
  @NotNull
  public final LogcatFromNative invoke()
  {
    return new LogcatFromNative();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logcat.LogcatManager.Companion.nativeLog.2
 * JD-Core Version:    0.7.0.1
 */