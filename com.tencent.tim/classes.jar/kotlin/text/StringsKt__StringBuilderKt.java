package kotlin.text;

import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.SinceKotlin;
import kotlin.Unit;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"buildString", "", "capacity", "", "builderAction", "Lkotlin/Function1;", "Ljava/lang/StringBuilder;", "Lkotlin/text/StringBuilder;", "", "Lkotlin/ExtensionFunctionType;", "append", "obj", "", "value", "", "(Ljava/lang/StringBuilder;[Ljava/lang/Object;)Ljava/lang/StringBuilder;", "(Ljava/lang/StringBuilder;[Ljava/lang/String;)Ljava/lang/StringBuilder;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/text/StringsKt")
class StringsKt__StringBuilderKt
  extends StringsKt__StringBuilderJVMKt
{
  @Deprecated(level=DeprecationLevel.WARNING, message="Use append(value: Any?) instead", replaceWith=@ReplaceWith(expression="append(value = obj)", imports={}))
  @InlineOnly
  private static final StringBuilder append(@NotNull StringBuilder paramStringBuilder, Object paramObject)
  {
    paramStringBuilder = paramStringBuilder.append(paramObject);
    Intrinsics.checkExpressionValueIsNotNull(paramStringBuilder, "this.append(obj)");
    return paramStringBuilder;
  }
  
  @NotNull
  public static final StringBuilder append(@NotNull StringBuilder paramStringBuilder, @NotNull Object... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$append");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "value");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    return paramStringBuilder;
  }
  
  @NotNull
  public static final StringBuilder append(@NotNull StringBuilder paramStringBuilder, @NotNull String... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramStringBuilder, "$this$append");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "value");
    int j = paramVarArgs.length;
    int i = 0;
    while (i < j)
    {
      paramStringBuilder.append(paramVarArgs[i]);
      i += 1;
    }
    return paramStringBuilder;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final String buildString(int paramInt, Function1<? super StringBuilder, Unit> paramFunction1)
  {
    StringBuilder localStringBuilder = new StringBuilder(paramInt);
    paramFunction1.invoke(localStringBuilder);
    paramFunction1 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "StringBuilder(capacity).…builderAction).toString()");
    return paramFunction1;
  }
  
  @InlineOnly
  private static final String buildString(Function1<? super StringBuilder, Unit> paramFunction1)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    paramFunction1.invoke(localStringBuilder);
    paramFunction1 = localStringBuilder.toString();
    Intrinsics.checkExpressionValueIsNotNull(paramFunction1, "StringBuilder().apply(builderAction).toString()");
    return paramFunction1;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.text.StringsKt__StringBuilderKt
 * JD-Core Version:    0.7.0.1
 */