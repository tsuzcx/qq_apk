package com.tencent.qapmsdk.common.logcat;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logcat/LogcatManager;", "", "()V", "Companion", "common_release"}, k=1, mv={1, 1, 15})
public final class LogcatManager
{
  public static final Companion Companion = new Companion(null);
  public static final int JAVA = 1;
  public static final int NATIVE = 2;
  private static final Lazy javaLog$delegate = LazyKt.lazy((Function0)LogcatManager.Companion.javaLog.2.INSTANCE);
  private static final Lazy nativeLog$delegate = LazyKt.lazy((Function0)LogcatManager.Companion.nativeLog.2.INSTANCE);
  
  @JvmStatic
  @Nullable
  public static final ILogcat initLogcat(int paramInt)
  {
    return Companion.initLogcat(paramInt);
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lcom/tencent/qapmsdk/common/logcat/LogcatManager$Companion;", "", "()V", "JAVA", "", "NATIVE", "javaLog", "Lcom/tencent/qapmsdk/common/logcat/LogcatFromJava;", "getJavaLog", "()Lcom/tencent/qapmsdk/common/logcat/LogcatFromJava;", "javaLog$delegate", "Lkotlin/Lazy;", "nativeLog", "Lcom/tencent/qapmsdk/common/logcat/LogcatFromNative;", "getNativeLog", "()Lcom/tencent/qapmsdk/common/logcat/LogcatFromNative;", "nativeLog$delegate", "initLogcat", "Lcom/tencent/qapmsdk/common/logcat/ILogcat;", "type", "common_release"}, k=1, mv={1, 1, 15})
  public static final class Companion
  {
    private final LogcatFromJava getJavaLog()
    {
      Lazy localLazy = LogcatManager.access$getJavaLog$cp();
      Object localObject = LogcatManager.Companion;
      localObject = $$delegatedProperties[0];
      return (LogcatFromJava)localLazy.getValue();
    }
    
    private final LogcatFromNative getNativeLog()
    {
      Lazy localLazy = LogcatManager.access$getNativeLog$cp();
      Object localObject = LogcatManager.Companion;
      localObject = $$delegatedProperties[1];
      return (LogcatFromNative)localLazy.getValue();
    }
    
    @JvmStatic
    @Nullable
    public final ILogcat initLogcat(int paramInt)
    {
      switch (paramInt)
      {
      default: 
        return (ILogcat)((Companion)this).getJavaLog();
      case 2: 
        return (ILogcat)((Companion)this).getNativeLog();
      }
      return (ILogcat)((Companion)this).getJavaLog();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.logcat.LogcatManager
 * JD-Core Version:    0.7.0.1
 */