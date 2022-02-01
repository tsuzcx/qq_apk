package com.tencent.mobileqq.minigame.report;

import com.tencent.mobileqq.mini.tfs.TaskExecutionStatics;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "it", "Lcom/tencent/mobileqq/mini/tfs/TaskExecutionStatics;", "invoke"}, k=3, mv={1, 1, 16})
final class MiniGameBeaconReport$getTaskName$name$1
  extends Lambda
  implements Function1<TaskExecutionStatics, CharSequence>
{
  public static final 1 INSTANCE = new 1();
  
  MiniGameBeaconReport$getTaskName$name$1()
  {
    super(1);
  }
  
  @NotNull
  public final CharSequence invoke(@NotNull TaskExecutionStatics paramTaskExecutionStatics)
  {
    Intrinsics.checkParameterIsNotNull(paramTaskExecutionStatics, "it");
    paramTaskExecutionStatics = paramTaskExecutionStatics.getName();
    if (StringsKt.endsWith$default(paramTaskExecutionStatics, ".js", false, 2, null))
    {
      int i = StringsKt.lastIndexOf$default((CharSequence)paramTaskExecutionStatics, '/', 0, false, 6, null);
      if (paramTaskExecutionStatics == null) {
        throw new TypeCastException("null cannot be cast to non-null type java.lang.String");
      }
      paramTaskExecutionStatics = paramTaskExecutionStatics.substring(i + 1);
      Intrinsics.checkExpressionValueIsNotNull(paramTaskExecutionStatics, "(this as java.lang.String).substring(startIndex)");
      return (CharSequence)StringsKt.replace$default(paramTaskExecutionStatics, ".js", "_js", false, 4, null);
    }
    return (CharSequence)StringsKt.replace$default(paramTaskExecutionStatics, ".", "_", false, 4, null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.minigame.report.MiniGameBeaconReport.getTaskName.name.1
 * JD-Core Version:    0.7.0.1
 */