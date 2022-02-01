package kotlin.collections;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Set;
import java.util.TreeSet;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"setOf", "", "T", "element", "(Ljava/lang/Object;)Ljava/util/Set;", "sortedSetOf", "Ljava/util/TreeSet;", "elements", "", "([Ljava/lang/Object;)Ljava/util/TreeSet;", "comparator", "Ljava/util/Comparator;", "Lkotlin/Comparator;", "(Ljava/util/Comparator;[Ljava/lang/Object;)Ljava/util/TreeSet;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/SetsKt")
public class SetsKt__SetsJVMKt
{
  @NotNull
  public static final <T> Set<T> setOf(T paramT)
  {
    paramT = Collections.singleton(paramT);
    Intrinsics.checkExpressionValueIsNotNull(paramT, "java.util.Collections.singleton(element)");
    return paramT;
  }
  
  @NotNull
  public static final <T> TreeSet<T> sortedSetOf(@NotNull Comparator<? super T> paramComparator, @NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramComparator, "comparator");
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (TreeSet)ArraysKt.toCollection(paramVarArgs, (Collection)new TreeSet(paramComparator));
  }
  
  @NotNull
  public static final <T> TreeSet<T> sortedSetOf(@NotNull T... paramVarArgs)
  {
    Intrinsics.checkParameterIsNotNull(paramVarArgs, "elements");
    return (TreeSet)ArraysKt.toCollection(paramVarArgs, (Collection)new TreeSet());
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.SetsKt__SetsJVMKt
 * JD-Core Version:    0.7.0.1
 */