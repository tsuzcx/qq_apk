package kotlin.collections;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.SinceKotlin;
import kotlin.TypeCastException;
import kotlin.internal.InlineOnly;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref.IntRef;
import kotlin.jvm.internal.TypeIntrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"eachCount", "", "K", "", "T", "Lkotlin/collections/Grouping;", "mapValuesInPlace", "", "R", "V", "f", "Lkotlin/Function1;", "", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/GroupingKt")
class GroupingKt__GroupingJVMKt
{
  @SinceKotlin(version="1.1")
  @NotNull
  public static final <T, K> Map<K, Integer> eachCount(@NotNull Grouping<T, ? extends K> paramGrouping)
  {
    Intrinsics.checkParameterIsNotNull(paramGrouping, "$this$eachCount");
    Map localMap = (Map)new LinkedHashMap();
    Iterator localIterator = paramGrouping.sourceIterator();
    Object localObject1;
    if (localIterator.hasNext())
    {
      Object localObject2 = paramGrouping.keyOf(localIterator.next());
      localObject1 = localMap.get(localObject2);
      if ((localObject1 == null) && (!localMap.containsKey(localObject2))) {}
      for (int i = 1;; i = 0)
      {
        if (i != 0) {
          localObject1 = new Ref.IntRef();
        }
        localObject1 = (Ref.IntRef)localObject1;
        ((Ref.IntRef)localObject1).element += 1;
        localMap.put(localObject2, localObject1);
        break;
      }
    }
    paramGrouping = ((Iterable)localMap.entrySet()).iterator();
    while (paramGrouping.hasNext())
    {
      localObject1 = (Map.Entry)paramGrouping.next();
      if (localObject1 == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
      }
      TypeIntrinsics.asMutableMapEntry(localObject1).setValue(Integer.valueOf(((Ref.IntRef)((Map.Entry)localObject1).getValue()).element));
    }
    return TypeIntrinsics.asMutableMap(localMap);
  }
  
  @PublishedApi
  @InlineOnly
  private static final <K, V, R> Map<K, R> mapValuesInPlace(@NotNull Map<K, V> paramMap, Function1<? super Map.Entry<? extends K, ? extends V>, ? extends R> paramFunction1)
  {
    Iterator localIterator = ((Iterable)paramMap.entrySet()).iterator();
    while (localIterator.hasNext())
    {
      Map.Entry localEntry = (Map.Entry)localIterator.next();
      if (localEntry == null) {
        throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap.MutableEntry<K, R>");
      }
      TypeIntrinsics.asMutableMapEntry(localEntry).setValue(paramFunction1.invoke(localEntry));
    }
    if (paramMap == null) {
      throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableMap<K, R>");
    }
    return TypeIntrinsics.asMutableMap(paramMap);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.GroupingKt__GroupingJVMKt
 * JD-Core Version:    0.7.0.1
 */