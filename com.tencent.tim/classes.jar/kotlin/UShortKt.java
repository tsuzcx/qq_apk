package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toUShort", "Lkotlin/UShort;", "", "(B)S", "", "(I)S", "", "(J)S", "", "(S)S", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UShortKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short toUShort(byte paramByte)
  {
    return UShort.constructor-impl((short)paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short toUShort(int paramInt)
  {
    return UShort.constructor-impl((short)paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short toUShort(long paramLong)
  {
    return UShort.constructor-impl((short)(int)paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final short toUShort(short paramShort)
  {
    return UShort.constructor-impl(paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.UShortKt
 * JD-Core Version:    0.7.0.1
 */