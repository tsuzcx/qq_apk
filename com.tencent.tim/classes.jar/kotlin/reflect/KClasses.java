package kotlin.reflect;

import kotlin.ExperimentalStdlibApi;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.LowPriorityInOverloadResolution;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"cast", "T", "", "Lkotlin/reflect/KClass;", "value", "(Lkotlin/reflect/KClass;Ljava/lang/Object;)Ljava/lang/Object;", "safeCast", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
@JvmName(name="KClasses")
public final class KClasses
{
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @NotNull
  public static final <T> T cast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$cast");
    if (!paramKClass.isInstance(paramObject)) {
      throw ((Throwable)new ClassCastException("Value cannot be cast to " + paramKClass.getQualifiedName()));
    }
    if (paramObject == null) {
      throw new TypeCastException("null cannot be cast to non-null type T");
    }
    return paramObject;
  }
  
  @ExperimentalStdlibApi
  @SinceKotlin(version="1.3")
  @LowPriorityInOverloadResolution
  @Nullable
  public static final <T> T safeCast(@NotNull KClass<T> paramKClass, @Nullable Object paramObject)
  {
    Intrinsics.checkParameterIsNotNull(paramKClass, "$this$safeCast");
    if (paramKClass.isInstance(paramObject))
    {
      paramKClass = paramObject;
      if (paramObject == null) {
        throw new TypeCastException("null cannot be cast to non-null type T");
      }
    }
    else
    {
      paramKClass = null;
    }
    return paramKClass;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.reflect.KClasses
 * JD-Core Version:    0.7.0.1
 */