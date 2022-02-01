package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ByteSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ByteSpreadBuilder
  extends PrimitiveSpreadBuilder<byte[]>
{
  private final byte[] values;
  
  public ByteSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new byte[paramInt];
  }
  
  public final void add(byte paramByte)
  {
    byte[] arrayOfByte = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfByte[i] = paramByte;
  }
  
  protected int getSize(@NotNull byte[] paramArrayOfByte)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfByte, "$this$getSize");
    return paramArrayOfByte.length;
  }
  
  @NotNull
  public final byte[] toArray()
  {
    return (byte[])toArray(this.values, new byte[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.ByteSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */