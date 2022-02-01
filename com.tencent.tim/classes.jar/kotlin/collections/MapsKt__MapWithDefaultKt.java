package kotlin.collections;

import java.util.Map;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.PublishedApi;
import kotlin.jvm.JvmName;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"getOrImplicitDefault", "V", "K", "", "key", "getOrImplicitDefaultNullable", "(Ljava/util/Map;Ljava/lang/Object;)Ljava/lang/Object;", "withDefault", "defaultValue", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "withDefaultMutable", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/MapsKt")
class MapsKt__MapWithDefaultKt
{
  @PublishedApi
  @JvmName(name="getOrImplicitDefaultNullable")
  public static final <K, V> V getOrImplicitDefaultNullable(@NotNull Map<K, ? extends V> paramMap, K paramK)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$getOrImplicitDefault");
    Object localObject1;
    if ((paramMap instanceof MapWithDefault)) {
      localObject1 = ((MapWithDefault)paramMap).getOrImplicitDefault(paramK);
    }
    do
    {
      Object localObject2;
      do
      {
        return localObject1;
        localObject2 = paramMap.get(paramK);
        localObject1 = localObject2;
      } while (localObject2 != null);
      localObject1 = localObject2;
    } while (paramMap.containsKey(paramK));
    throw ((Throwable)new NoSuchElementException("Key " + paramK + " is missing in the map."));
  }
  
  @NotNull
  public static final <K, V> Map<K, V> withDefault(@NotNull Map<K, ? extends V> paramMap, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$withDefault");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "defaultValue");
    if ((paramMap instanceof MapWithDefault)) {
      return MapsKt.withDefault(((MapWithDefault)paramMap).getMap(), paramFunction1);
    }
    return (Map)new MapWithDefaultImpl(paramMap, paramFunction1);
  }
  
  @JvmName(name="withDefaultMutable")
  @NotNull
  public static final <K, V> Map<K, V> withDefaultMutable(@NotNull Map<K, V> paramMap, @NotNull Function1<? super K, ? extends V> paramFunction1)
  {
    Intrinsics.checkParameterIsNotNull(paramMap, "$this$withDefault");
    Intrinsics.checkParameterIsNotNull(paramFunction1, "defaultValue");
    if ((paramMap instanceof MutableMapWithDefault)) {
      return MapsKt.withDefaultMutable(((MutableMapWithDefault)paramMap).getMap(), paramFunction1);
    }
    return (Map)new MutableMapWithDefaultImpl(paramMap, paramFunction1);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.MapsKt__MapWithDefaultKt
 * JD-Core Version:    0.7.0.1
 */