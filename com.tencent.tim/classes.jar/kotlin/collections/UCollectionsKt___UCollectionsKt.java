package kotlin.collections;

import java.util.Collection;
import java.util.Iterator;
import kotlin.ExperimentalUnsignedTypes;
import kotlin.Metadata;
import kotlin.SinceKotlin;
import kotlin.UByte;
import kotlin.UByteArray;
import kotlin.UInt;
import kotlin.UIntArray;
import kotlin.ULong;
import kotlin.ULongArray;
import kotlin.UShort;
import kotlin.UShortArray;
import kotlin.jvm.JvmName;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"sum", "Lkotlin/UInt;", "", "Lkotlin/UByte;", "sumOfUByte", "(Ljava/lang/Iterable;)I", "sumOfUInt", "Lkotlin/ULong;", "sumOfULong", "(Ljava/lang/Iterable;)J", "Lkotlin/UShort;", "sumOfUShort", "toUByteArray", "Lkotlin/UByteArray;", "", "(Ljava/util/Collection;)[B", "toUIntArray", "Lkotlin/UIntArray;", "(Ljava/util/Collection;)[I", "toULongArray", "Lkotlin/ULongArray;", "(Ljava/util/Collection;)[J", "toUShortArray", "Lkotlin/UShortArray;", "(Ljava/util/Collection;)[S", "kotlin-stdlib"}, k=5, mv={1, 1, 16}, xi=1, xs="kotlin/collections/UCollectionsKt")
class UCollectionsKt___UCollectionsKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUByte")
  public static final int sumOfUByte(@NotNull Iterable<UByte> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = UInt.constructor-impl(UInt.constructor-impl(((UByte)paramIterable.next()).unbox-impl() & 0xFF) + i)) {}
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUInt")
  public static final int sumOfUInt(@NotNull Iterable<UInt> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = UInt.constructor-impl(((UInt)paramIterable.next()).unbox-impl() + i)) {}
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfULong")
  public static final long sumOfULong(@NotNull Iterable<ULong> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (long l = 0L; paramIterable.hasNext(); l = ULong.constructor-impl(((ULong)paramIterable.next()).unbox-impl() + l)) {}
    return l;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @JvmName(name="sumOfUShort")
  public static final int sumOfUShort(@NotNull Iterable<UShort> paramIterable)
  {
    Intrinsics.checkParameterIsNotNull(paramIterable, "$this$sum");
    paramIterable = paramIterable.iterator();
    for (int i = 0; paramIterable.hasNext(); i = UInt.constructor-impl(UInt.constructor-impl(((UShort)paramIterable.next()).unbox-impl() & 0xFFFF) + i)) {}
    return i;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final byte[] toUByteArray(@NotNull Collection<UByte> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toUByteArray");
    byte[] arrayOfByte = UByteArray.constructor-impl(paramCollection.size());
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      UByteArray.set-VurrAj0(arrayOfByte, i, ((UByte)paramCollection.next()).unbox-impl());
      i += 1;
    }
    return arrayOfByte;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final int[] toUIntArray(@NotNull Collection<UInt> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toUIntArray");
    int[] arrayOfInt = UIntArray.constructor-impl(paramCollection.size());
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      UIntArray.set-VXSXFK8(arrayOfInt, i, ((UInt)paramCollection.next()).unbox-impl());
      i += 1;
    }
    return arrayOfInt;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final long[] toULongArray(@NotNull Collection<ULong> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toULongArray");
    long[] arrayOfLong = ULongArray.constructor-impl(paramCollection.size());
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      ULongArray.set-k8EXiF4(arrayOfLong, i, ((ULong)paramCollection.next()).unbox-impl());
      i += 1;
    }
    return arrayOfLong;
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @NotNull
  public static final short[] toUShortArray(@NotNull Collection<UShort> paramCollection)
  {
    Intrinsics.checkParameterIsNotNull(paramCollection, "$this$toUShortArray");
    short[] arrayOfShort = UShortArray.constructor-impl(paramCollection.size());
    paramCollection = paramCollection.iterator();
    int i = 0;
    while (paramCollection.hasNext())
    {
      UShortArray.set-01HTLdE(arrayOfShort, i, ((UShort)paramCollection.next()).unbox-impl());
      i += 1;
    }
    return arrayOfShort;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.UCollectionsKt___UCollectionsKt
 * JD-Core Version:    0.7.0.1
 */