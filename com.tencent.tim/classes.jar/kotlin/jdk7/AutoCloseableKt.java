package kotlin.jdk7;

import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.jvm.JvmName;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"closeFinally", "", "Ljava/lang/AutoCloseable;", "cause", "", "use", "R", "T", "block", "Lkotlin/Function1;", "(Ljava/lang/AutoCloseable;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "kotlin-stdlib-jdk7"}, k=2, mv={1, 1, 16}, pn="kotlin")
@JvmName(name="AutoCloseableKt")
public final class AutoCloseableKt
{
  @PublishedApi
  @SinceKotlin(version="1.2")
  public static final void closeFinally(@Nullable AutoCloseable paramAutoCloseable, @Nullable Throwable paramThrowable)
  {
    if (paramAutoCloseable == null) {
      return;
    }
    if (paramThrowable == null)
    {
      paramAutoCloseable.close();
      return;
    }
    try
    {
      paramAutoCloseable.close();
      return;
    }
    catch (Throwable paramAutoCloseable)
    {
      paramThrowable.addSuppressed(paramAutoCloseable);
    }
  }
  
  /* Error */
  @SinceKotlin(version="1.2")
  @kotlin.internal.InlineOnly
  private static final <T extends AutoCloseable, R> R use(T paramT, kotlin.jvm.functions.Function1<? super T, ? extends R> paramFunction1)
  {
    // Byte code:
    //   0: aconst_null
    //   1: checkcast 40	java/lang/Throwable
    //   4: astore_2
    //   5: aload_1
    //   6: aload_0
    //   7: invokeinterface 60 2 0
    //   12: astore_1
    //   13: iconst_1
    //   14: invokestatic 66	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   17: aload_0
    //   18: aload_2
    //   19: invokestatic 68	kotlin/jdk7/AutoCloseableKt:closeFinally	(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
    //   22: iconst_1
    //   23: invokestatic 71	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   26: aload_1
    //   27: areturn
    //   28: astore_1
    //   29: aload_1
    //   30: athrow
    //   31: astore_2
    //   32: iconst_1
    //   33: invokestatic 66	kotlin/jvm/internal/InlineMarker:finallyStart	(I)V
    //   36: aload_0
    //   37: aload_1
    //   38: invokestatic 68	kotlin/jdk7/AutoCloseableKt:closeFinally	(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
    //   41: iconst_1
    //   42: invokestatic 71	kotlin/jvm/internal/InlineMarker:finallyEnd	(I)V
    //   45: aload_2
    //   46: athrow
    //   47: astore_3
    //   48: aload_2
    //   49: astore_1
    //   50: aload_3
    //   51: astore_2
    //   52: goto -20 -> 32
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	55	0	paramT	T
    //   0	55	1	paramFunction1	kotlin.jvm.functions.Function1<? super T, ? extends R>
    //   4	15	2	localThrowable	Throwable
    //   31	18	2	localObject1	Object
    //   51	1	2	localObject2	Object
    //   47	4	3	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   5	13	28	java/lang/Throwable
    //   29	31	31	finally
    //   5	13	47	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jdk7.AutoCloseableKt
 * JD-Core Version:    0.7.0.1
 */