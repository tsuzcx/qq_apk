package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"aggregate", "", "K", "R", "T", "Lkotlin/collections/Grouping;", "operation", "Lkotlin/Function4;", "Lkotlin/ParameterName;", "name", "key", "accumulator", "element", "", "first", "aggregateTo", "M", "", "destination", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function4;)Ljava/util/Map;", "eachCountTo", "", "(Lkotlin/collections/Grouping;Ljava/util/Map;)Ljava/util/Map;", "fold", "initialValueSelector", "Lkotlin/Function2;", "Lkotlin/Function3;", "initialValue", "(Lkotlin/collections/Grouping;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "foldTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "(Lkotlin/collections/Grouping;Ljava/util/Map;Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/Map;", "reduce", "S", "reduceTo", "(Lkotlin/collections/Grouping;Ljava/util/Map;Lkotlin/jvm/functions/Function3;)Ljava/util/Map;", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/GroupingKt")
class GroupingKt__GroupingKt
  extends GroupingKt__GroupingJVMKt
{
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R> Map<K, R> aggregate(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$aggregate");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = localMap.get(localObject2);
      if ((localObject3 == null) && (!localMap.containsKey(localObject2))) {}
      for (boolean bool = true;; bool = false)
      {
        localMap.put(localObject2, paramFunction4.invoke(localObject2, localObject3, localObject1, Boolean.valueOf(bool)));
        break;
      }
    }
    return localMap;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R, M extends Map<? super K, R>> M aggregateTo(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull M paramM, @NotNull Function4<? super K, ? super R, ? super T, ? super Boolean, ? extends R> paramFunction4)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$aggregateTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction4, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = paramM.get(localObject2);
      if ((localObject3 == null) && (!paramM.containsKey(localObject2))) {}
      for (boolean bool = true;; bool = false)
      {
        paramM.put(localObject2, paramFunction4.invoke(localObject2, localObject3, localObject1, Boolean.valueOf(bool)));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, M extends Map<? super K, Integer>> M eachCountTo(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull M paramM)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$eachCountTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = paramGrouping.keyOf(localIterator.next());
      Object localObject1 = paramM.get(localObject2);
      if ((localObject1 == null) && (!paramM.containsKey(localObject2))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = Integer.valueOf(0);
        }
        paramM.put(localObject2, Integer.valueOf(((Number)localObject1).intValue() + 1));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R> Map<K, R> fold(@NotNull Grouping<T, ? extends K> paramGrouping, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = localMap.get(localObject3);
      if ((localObject1 == null) && (!localMap.containsKey(localObject3))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = paramR;
        }
        localMap.put(localObject3, paramFunction2.invoke(localObject1, localObject2));
        break;
      }
    }
    return localMap;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R> Map<K, R> fold(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull Function2<? super K, ? super T, ? extends R> paramFunction2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$fold");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "initialValueSelector");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = localMap.get(localObject3);
      if ((localObject1 == null) && (!localMap.containsKey(localObject3))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = paramFunction2.invoke(localObject3, localObject2);
        }
        localMap.put(localObject3, paramFunction3.invoke(localObject3, localObject1, localObject2));
        break;
      }
    }
    return localMap;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull M paramM, R paramR, @NotNull Function2<? super R, ? super T, ? extends R> paramFunction2)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$foldTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = paramM.get(localObject3);
      if ((localObject1 == null) && (!paramM.containsKey(localObject3))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = paramR;
        }
        paramM.put(localObject3, paramFunction2.invoke(localObject1, localObject2));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K, R, M extends Map<? super K, R>> M foldTo(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull M paramM, @NotNull Function2<? super K, ? super T, ? extends R> paramFunction2, @NotNull Function3<? super K, ? super R, ? super T, ? extends R> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$foldTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction2, "initialValueSelector");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject2 = localIterator.next();
      Object localObject3 = paramGrouping.keyOf(localObject2);
      Object localObject1 = paramM.get(localObject3);
      if ((localObject1 == null) && (!paramM.containsKey(localObject3))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = paramFunction2.invoke(localObject3, localObject2);
        }
        paramM.put(localObject3, paramFunction3.invoke(localObject3, localObject1, localObject2));
        break;
      }
    }
    return paramM;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <S, T extends S, K> Map<K, S> reduce(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$reduce");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = localMap.get(localObject2);
      int i;
      if ((localObject3 == null) && (!localMap.containsKey(localObject2)))
      {
        i = 1;
        label89:
        if (i == 0) {
          break label112;
        }
      }
      for (;;)
      {
        localMap.put(localObject2, localObject1);
        break;
        i = 0;
        break label89;
        label112:
        localObject1 = paramFunction3.invoke(localObject2, localObject3, localObject1);
      }
    }
    return localMap;
  }
  
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <S, T extends S, K, M extends Map<? super K, S>> M reduceTo(@NotNull Grouping<T, ? extends K> paramGrouping, @NotNull M paramM, @NotNull Function3<? super K, ? super S, ? super T, ? extends S> paramFunction3)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$reduceTo");
    Intrinsics.checkParameterIsNotNull(paramM, "destination");
    Intrinsics.checkParameterIsNotNull(paramFunction3, "operation");
    Iterator localIterator = paramGrouping.sourceIterator();
    if (localIterator.hasNext())
    {
      Object localObject1 = localIterator.next();
      Object localObject2 = paramGrouping.keyOf(localObject1);
      Object localObject3 = paramM.get(localObject2);
      int i;
      if ((localObject3 == null) && (!paramM.containsKey(localObject2)))
      {
        i = 1;
        label83:
        if (i == 0) {
          break label106;
        }
      }
      for (;;)
      {
        paramM.put(localObject2, localObject1);
        break;
        i = 0;
        break label83;
        label106:
        localObject1 = paramFunction3.invoke(localObject2, localObject3, localObject1);
      }
    }
    return paramM;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.GroupingKt__GroupingKt
 * JD-Core Version:    0.7.0.1
 */