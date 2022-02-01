package com.tencent.qapmsdk.common.util;

import java.util.Comparator;
import kotlin.Metadata;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "", "lhs", "", "kotlin.jvm.PlatformType", "rhs", "compare"}, k=3, mv={1, 1, 15})
final class ByteArrayPool$Companion$BUF_COMPARATOR$1<T>
  implements Comparator<byte[]>
{
  public static final 1 INSTANCE = new 1();
  
  public final int compare(byte[] paramArrayOfByte1, byte[] paramArrayOfByte2)
  {
    return paramArrayOfByte1.length - paramArrayOfByte2.length;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes10.jar
 * Qualified Name:     com.tencent.qapmsdk.common.util.ByteArrayPool.Companion.BUF_COMPARATOR.1
 * JD-Core Version:    0.7.0.1
 */