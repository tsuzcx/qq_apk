package kotlin;

import kotlin.internal.InlineOnly;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"toUInt", "Lkotlin/UInt;", "", "(B)I", "", "(D)I", "", "(F)I", "", "(I)I", "", "(J)I", "", "(S)I", "kotlin-stdlib"}, k=2, mv={1, 1, 16})
public final class UIntKt
{
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(byte paramByte)
  {
    return UInt.constructor-impl(paramByte);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(double paramDouble)
  {
    return UnsignedKt.doubleToUInt(paramDouble);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(float paramFloat)
  {
    return UnsignedKt.doubleToUInt(paramFloat);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(int paramInt)
  {
    return UInt.constructor-impl(paramInt);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(long paramLong)
  {
    return UInt.constructor-impl((int)paramLong);
  }
  
  @ExperimentalUnsignedTypes
  @SinceKotlin(version="1.3")
  @InlineOnly
  private static final int toUInt(short paramShort)
  {
    return UInt.constructor-impl(paramShort);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.UIntKt
 * JD-Core Version:    0.7.0.1
 */