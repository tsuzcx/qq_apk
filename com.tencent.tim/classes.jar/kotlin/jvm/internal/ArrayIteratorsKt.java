package kotlin.jvm.internal;

import kotlin.Metadata;
import kotlin.collections.BooleanIterator;
import kotlin.collections.ByteIterator;
import kotlin.collections.CharIterator;
import kotlin.collections.DoubleIterator;
import kotlin.collections.FloatIterator;
import kotlin.collections.IntIterator;
import kotlin.collections.LongIterator;
import kotlin.collections.ShortIterator;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"iterator", "Lkotlin/collections/BooleanIterator;", "array", "", "Lkotlin/collections/ByteIterator;", "", "Lkotlin/collections/CharIterator;", "", "Lkotlin/collections/DoubleIterator;", "", "Lkotlin/collections/FloatIterator;", "", "Lkotlin/collections/IntIterator;", "", "Lkotlin/collections/LongIterator;", "", "Lkotlin/collections/ShortIterator;", "", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ArrayIteratorsKt
{
  @NotNull
  public static final BooleanIterator iterator(@NotNull boolean[] paramArrayOfBoolean)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfBoolean, "array");
    return (BooleanIterator)new ArrayBooleanIterator(paramArrayOfBoolean);
  }
  
  @NotNull
  public static final ByteIterator iterator(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "array");
    return (ByteIterator)new ArrayByteIterator(paramArrayOfByte);
  }
  
  @NotNull
  public static final CharIterator iterator(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "array");
    return (CharIterator)new ArrayCharIterator(paramArrayOfChar);
  }
  
  @NotNull
  public static final DoubleIterator iterator(@NotNull double[] paramArrayOfDouble)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfDouble, "array");
    return (DoubleIterator)new ArrayDoubleIterator(paramArrayOfDouble);
  }
  
  @NotNull
  public static final FloatIterator iterator(@NotNull float[] paramArrayOfFloat)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfFloat, "array");
    return (FloatIterator)new ArrayFloatIterator(paramArrayOfFloat);
  }
  
  @NotNull
  public static final IntIterator iterator(@NotNull int[] paramArrayOfInt)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfInt, "array");
    return (IntIterator)new ArrayIntIterator(paramArrayOfInt);
  }
  
  @NotNull
  public static final LongIterator iterator(@NotNull long[] paramArrayOfLong)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfLong, "array");
    return (LongIterator)new ArrayLongIterator(paramArrayOfLong);
  }
  
  @NotNull
  public static final ShortIterator iterator(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "array");
    return (ShortIterator)new ArrayShortIterator(paramArrayOfShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.ArrayIteratorsKt
 * JD-Core Version:    0.7.0.1
 */