public final class lk
{
  private final int[] bits;
  private final int height;
  private final int rowSize;
  private final int width;
  
  public lk(int paramInt1, int paramInt2)
  {
    if ((paramInt1 < 1) || (paramInt2 < 1)) {
      throw new IllegalArgumentException("Both dimensions must be greater than 0");
    }
    this.width = paramInt1;
    this.height = paramInt2;
    this.rowSize = (paramInt1 + 31 >> 5);
    this.bits = new int[this.rowSize * paramInt2];
  }
  
  public boolean equals(Object paramObject)
  {
    if (!(paramObject instanceof lk)) {}
    do
    {
      return false;
      paramObject = (lk)paramObject;
    } while ((this.width != paramObject.width) || (this.height != paramObject.height) || (this.rowSize != paramObject.rowSize) || (this.bits.length != paramObject.bits.length));
    int i = 0;
    for (;;)
    {
      if (i >= this.bits.length) {
        break label93;
      }
      if (this.bits[i] != paramObject.bits[i]) {
        break;
      }
      i += 1;
    }
    label93:
    return true;
  }
  
  public boolean get(int paramInt1, int paramInt2)
  {
    int i = this.rowSize;
    return (this.bits[(i * paramInt2 + (paramInt1 >> 5))] >>> (paramInt1 & 0x1F) & 0x1) != 0;
  }
  
  public int getHeight()
  {
    return this.height;
  }
  
  public int getWidth()
  {
    return this.width;
  }
  
  public int hashCode()
  {
    int i = this.width;
    int j = this.width;
    int k = this.height;
    j = this.rowSize + ((i * 31 + j) * 31 + k) * 31;
    int[] arrayOfInt = this.bits;
    k = arrayOfInt.length;
    i = 0;
    while (i < k)
    {
      j = j * 31 + arrayOfInt[i];
      i += 1;
    }
    return j;
  }
  
  public void setRegion(int paramInt1, int paramInt2, int paramInt3, int paramInt4)
  {
    if ((paramInt2 < 0) || (paramInt1 < 0)) {
      throw new IllegalArgumentException("Left and top must be nonnegative");
    }
    if ((paramInt4 < 1) || (paramInt3 < 1)) {
      throw new IllegalArgumentException("Height and width must be at least 1");
    }
    int i = paramInt1 + paramInt3;
    paramInt4 = paramInt2 + paramInt4;
    if ((paramInt4 > this.height) || (i > this.width)) {
      throw new IllegalArgumentException("The region must fit inside the matrix");
    }
    for (;;)
    {
      paramInt2 += 1;
      if (paramInt2 >= paramInt4) {
        break;
      }
      int j = this.rowSize;
      paramInt3 = paramInt1;
      while (paramInt3 < i)
      {
        int[] arrayOfInt = this.bits;
        int k = (paramInt3 >> 5) + paramInt2 * j;
        arrayOfInt[k] |= 1 << (paramInt3 & 0x1F);
        paramInt3 += 1;
      }
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.height * (this.width + 1));
    int i = 0;
    while (i < this.height)
    {
      int j = 0;
      if (j < this.width)
      {
        if (get(j, i)) {}
        for (String str = "X ";; str = "  ")
        {
          localStringBuilder.append(str);
          j += 1;
          break;
        }
      }
      localStringBuilder.append('\n');
      i += 1;
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lk
 * JD-Core Version:    0.7.0.1
 */