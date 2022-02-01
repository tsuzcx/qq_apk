package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/CharSpreadBuilder;", "Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "", "size", "", "(I)V", "values", "add", "", "value", "", "toArray", "getSize", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public final class CharSpreadBuilder
  extends PrimitiveSpreadBuilder<char[]>
{
  private final char[] values;
  
  public CharSpreadBuilder(int paramInt)
  {
    super(paramInt);
    this.values = new char[paramInt];
  }
  
  public final void add(char paramChar)
  {
    char[] arrayOfChar = this.values;
    int i = getPosition();
    setPosition(i + 1);
    arrayOfChar[i] = paramChar;
  }
  
  protected int getSize(@NotNull char[] paramArrayOfChar)
  {
    Intrinsics.checkParameterIsNotNull(paramArrayOfChar, "$this$getSize");
    return paramArrayOfChar.length;
  }
  
  @NotNull
  public final char[] toArray()
  {
    return (char[])toArray(this.values, new char[size()]);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.CharSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */