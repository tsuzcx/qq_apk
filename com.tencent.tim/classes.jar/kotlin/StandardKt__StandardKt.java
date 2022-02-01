package kotlin;

import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"TODO", "", "reason", "", "repeat", "", "times", "", "action", "Lkotlin/Function1;", "run", "R", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "with", "T", "receiver", "Lkotlin/ExtensionFunctionType;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "also", "apply", "let", "takeIf", "predicate", "", "takeUnless", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/StandardKt")
class StandardKt__StandardKt
{
  @InlineOnly
  private static final Void TODO()
  {
    throw ((Throwable)new NotImplementedError(null, 1, null));
  }
  
  @InlineOnly
  private static final Void TODO(String paramString)
  {
    throw ((Throwable)new NotImplementedError("An operation is not implemented: " + paramString));
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> T also(T paramT, Function1<? super T, Unit> paramFunction1)
  {
    paramFunction1.invoke(paramT);
    return paramT;
  }
  
  @InlineOnly
  private static final <T> T apply(T paramT, Function1<? super T, Unit> paramFunction1)
  {
    paramFunction1.invoke(paramT);
    return paramT;
  }
  
  @InlineOnly
  private static final <T, R> R let(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    return paramFunction1.invoke(paramT);
  }
  
  @InlineOnly
  private static final void repeat(int paramInt, Function1<? super Integer, Unit> paramFunction1)
  {
    int i = 0;
    while (i < paramInt)
    {
      paramFunction1.invoke(Integer.valueOf(i));
      i += 1;
    }
  }
  
  @InlineOnly
  private static final <T, R> R run(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    return paramFunction1.invoke(paramT);
  }
  
  @InlineOnly
  private static final <R> R run(Function0<? extends R> paramFunction0)
  {
    return paramFunction0.invoke();
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> T takeIf(T paramT, Function1<? super T, Boolean> paramFunction1)
  {
    if (((Boolean)paramFunction1.invoke(paramT)).booleanValue()) {
      return paramT;
    }
    return null;
  }
  
  @SinceKotlin(version="1.1")
  @InlineOnly
  private static final <T> T takeUnless(T paramT, Function1<? super T, Boolean> paramFunction1)
  {
    if (!((Boolean)paramFunction1.invoke(paramT)).booleanValue()) {
      return paramT;
    }
    return null;
  }
  
  @InlineOnly
  private static final <T, R> R with(T paramT, Function1<? super T, ? extends R> paramFunction1)
  {
    return paramFunction1.invoke(paramT);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.StandardKt__StandardKt
 * JD-Core Version:    0.7.0.1
 */