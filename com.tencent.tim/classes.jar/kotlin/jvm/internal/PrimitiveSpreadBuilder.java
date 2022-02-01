package kotlin.jvm.internal;

import kotlin.Metadata;
import org.jetbrains.annotations.NotNull;

@Metadata(bv={1, 0, 3}, d1={""}, d2={"Lkotlin/jvm/internal/PrimitiveSpreadBuilder;", "T", "", "size", "", "(I)V", "position", "getPosition", "()I", "setPosition", "spreads", "", "spreads$annotations", "()V", "[Ljava/lang/Object;", "addSpread", "", "spreadArgument", "(Ljava/lang/Object;)V", "toArray", "values", "result", "(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;", "getSize", "(Ljava/lang/Object;)I", "kotlin-stdlib"}, k=1, mv={1, 1, 16})
public abstract class PrimitiveSpreadBuilder<T>
{
  private int position;
  private final int size;
  private final T[] spreads;
  
  public PrimitiveSpreadBuilder(int paramInt)
  {
    this.size = paramInt;
    this.spreads = new Object[this.size];
  }
  
  public final void addSpread(@NotNull T paramT)
  {
    Intrinsics.checkParameterIsNotNull(paramT, "spreadArgument");
    Object[] arrayOfObject = this.spreads;
    int i = this.position;
    this.position = (i + 1);
    arrayOfObject[i] = paramT;
  }
  
  protected final int getPosition()
  {
    return this.position;
  }
  
  protected abstract int getSize(@NotNull T paramT);
  
  protected final void setPosition(int paramInt)
  {
    this.position = paramInt;
  }
  
  protected final int size()
  {
    int i = 0;
    int m = this.size - 1;
    if (m <= 0)
    {
      int j = 0;
      Object localObject = this.spreads[i];
      if (localObject != null) {}
      for (k = getSize(localObject);; k = 1)
      {
        j += k;
        k = j;
        if (i == m) {
          return k;
        }
        i += 1;
        break;
      }
    }
    int k = 0;
    return k;
  }
  
  @NotNull
  protected final T toArray(@NotNull T paramT1, @NotNull T paramT2)
  {
    Intrinsics.checkParameterIsNotNull(paramT1, "values");
    Intrinsics.checkParameterIsNotNull(paramT2, "result");
    int i1 = this.size - 1;
    if (i1 <= 0)
    {
      int m = 0;
      n = 0;
      int i;
      for (j = 0;; j = i)
      {
        Object localObject = this.spreads[m];
        int k = n;
        i = j;
        if (localObject != null)
        {
          i = j;
          if (n < m)
          {
            System.arraycopy(paramT1, n, paramT2, j, m - n);
            i = j + (m - n);
          }
          j = getSize(localObject);
          System.arraycopy(localObject, 0, paramT2, i, j);
          i += j;
          k = m + 1;
        }
        n = k;
        j = i;
        if (m == i1) {
          break;
        }
        m += 1;
        n = k;
      }
    }
    int n = 0;
    int j = 0;
    if (n < this.size) {
      System.arraycopy(paramT1, n, paramT2, j, this.size - n);
    }
    return paramT2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes13.jar
 * Qualified Name:     kotlin.jvm.internal.PrimitiveSpreadBuilder
 * JD-Core Version:    0.7.0.1
 */