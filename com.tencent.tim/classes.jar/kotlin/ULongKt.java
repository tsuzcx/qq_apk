package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toULong", "Lkotlin/ULong;", "", "(B)J", "", "(D)J", "", "(F)J", "", "(I)J", "", "(J)J", "", "(S)J", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class ULongKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(byte paramByte)
  {
    return ULong.constructor-impl(paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(double paramDouble)
  {
    return UnsignedKt.doubleToULong(paramDouble);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(float paramFloat)
  {
    return UnsignedKt.doubleToULong(paramFloat);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(int paramInt)
  {
    return ULong.constructor-impl(paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(long paramLong)
  {
    return ULong.constructor-impl(paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final long toULong(short paramShort)
  {
    return ULong.constructor-impl(paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.ULongKt
 * JD-Core Version:    0.7.0.1
 */