package kotlin.collections.unsigned;

import kotlin.Metadata;
import kotlin.UByteArray;
import kotlin.collections.UByteIterator;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"<anonymous>", "Lkotlin/collections/UByteIterator;", "invoke"}, k=3, mv={1, 1, 16})
final class UArraysKt___UArraysKt$withIndex$3
  extends Lambda
  implements Function0<UByteIterator>
{
  UArraysKt___UArraysKt$withIndex$3(byte[] paramArrayOfByte)
  {
    super(0);
  }
  
  @NotNull
  public final UByteIterator invoke()
  {
    return UByteArray.iterator-impl(this.$this_withIndex);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.collections.unsigned.UArraysKt___UArraysKt.withIndex.3
 * JD-Core Version:    0.7.0.1
 */