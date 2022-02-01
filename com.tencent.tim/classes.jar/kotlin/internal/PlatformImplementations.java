package kotlin.internal;

import java.lang.reflect.Method;
import java.util.regex.MatchResult;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.JvmField;
import kotlin.jvm.internal.Intrinsics;
import kotlin.random.FallbackThreadLocalRandom;
import kotlin.random.Random;
import kotlin.text.MatchGroup;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/internal/PlatformImplementations;", "", "()V", "addSuppressed", "", "cause", "", "exception", "defaultPlatformRandom", "Lkotlin/random/Random;", "getMatchResultNamedGroup", "Lkotlin/text/MatchGroup;", "matchResult", "Ljava/util/regex/MatchResult;", "name", "", "ReflectAddSuppressedMethod", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public class PlatformImplementations
{
  public void addSuppressed(@NotNull Throwable paramThrowable1, @NotNull Throwable paramThrowable2)
  {
    Intrinsics.checkParameterIsNotNull(paramThrowable1, "cause");
    Intrinsics.checkParameterIsNotNull(paramThrowable2, "exception");
    Method localMethod = ReflectAddSuppressedMethod.method;
    if (localMethod != null) {
      localMethod.invoke(paramThrowable1, new Object[] { paramThrowable2 });
    }
  }
  
  @NotNull
  public Random defaultPlatformRandom()
  {
    return (Random)new FallbackThreadLocalRandom();
  }
  
  @Nullable
  public MatchGroup getMatchResultNamedGroup(@NotNull MatchResult paramMatchResult, @NotNull String paramString)
  {
    Intrinsics.checkParameterIsNotNull(paramMatchResult, "matchResult");
    Intrinsics.checkParameterIsNotNull(paramString, "name");
    throw ((Throwable)new UnsupportedOperationException("Retrieving groups by name is not supported on this platform."));
  }
  
  @Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/internal/PlatformImplementations$ReflectAddSuppressedMethod;", "", "()V", "method", "Ljava/lang/reflect/Method;", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
  static final class ReflectAddSuppressedMethod
  {
    public static final ReflectAddSuppressedMethod INSTANCE = new ReflectAddSuppressedMethod();
    @JvmField
    @Nullable
    public static final Method method;
    
    static
    {
      Method[] arrayOfMethod = Throwable.class.getMethods();
      Intrinsics.checkExpressionValueIsNotNull(arrayOfMethod, "throwableClass.methods");
      int k = arrayOfMethod.length;
      int i = 0;
      Method localMethod;
      int j;
      if (i < k)
      {
        localMethod = arrayOfMethod[i];
        Intrinsics.checkExpressionValueIsNotNull(localMethod, "it");
        if (Intrinsics.areEqual(localMethod.getName(), "addSuppressed"))
        {
          Class[] arrayOfClass = localMethod.getParameterTypes();
          Intrinsics.checkExpressionValueIsNotNull(arrayOfClass, "it.parameterTypes");
          if (Intrinsics.areEqual((Class)ArraysKt.singleOrNull(arrayOfClass), Throwable.class))
          {
            j = 1;
            label89:
            if (j == 0) {
              break label103;
            }
          }
        }
      }
      for (;;)
      {
        method = localMethod;
        return;
        j = 0;
        break label89;
        label103:
        i += 1;
        break;
        localMethod = null;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.internal.PlatformImplementations
 * JD-Core Version:    0.7.0.1
 */