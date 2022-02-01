package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/ShortSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class ShortSpreadBuilder
  extends PrimitiveSpreadBuilder<short[]>
{
  private final short[] values;
  
  public ShortSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new short[paramInt];
  }
  
  public final void add(short paramShort)
  {
    short[] arrayOfShort = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfShort[i] = paramShort;
  }
  
  protected int getSize(@NotNull short[] paramArrayOfShort)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfShort, "$this$getSize");
    return paramArrayOfShort.length;
  }
  
  @NotNull
  public final short[] toArray()
  {
    return (short[])toArray(this.values, new short[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.ShortSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */