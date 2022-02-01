public final class lj
{
  private int[] bits = new int[1];
  private int size = 0;
  
  private void ensureCapacity(int paramInt)
  {
    if (paramInt > this.bits.length << 5)
    {
      int[] arrayOfInt = makeArray(paramInt);
      System.arraycopy(this.bits, 0, arrayOfInt, 0, this.bits.length);
      this.bits = arrayOfInt;
    }
  }
  
  private static int[] makeArray(int paramInt)
  {
    return new int[paramInt + 31 >> 5];
  }
  
  public void a(lj paramlj)
  {
    int j = paramlj.size;
    ensureCapacity(this.size + j);
    int i = 0;
    while (i < j)
    {
      appendBit(paramlj.get(i));
      i += 1;
    }
  }
  
  public void appendBit(boolean paramBoolean)
  {
    ensureCapacity(this.size + 1);
    if (paramBoolean)
    {
      int[] arrayOfInt = this.bits;
      int i = this.size >> 5;
      arrayOfInt[i] |= 1 << (this.size & 0x1F);
    }
    this.size += 1;
  }
  
  public void appendBits(int paramInt1, int paramInt2)
  {
    if ((paramInt2 < 0) || (paramInt2 > 32)) {
      throw new IllegalArgumentException("Num bits must be between 0 and 32");
    }
    ensureCapacity(this.size + paramInt2);
    if (paramInt2 > 0)
    {
      if ((paramInt1 >> paramInt2 - 1 & 0x1) == 1) {}
      for (boolean bool = true;; bool = false)
      {
        appendBit(bool);
        paramInt2 -= 1;
        break;
      }
    }
  }
  
  public void b(lj paramlj)
  {
    if (this.bits.length != paramlj.bits.length) {
      throw new IllegalArgumentException("Sizes don't match");
    }
    int i = 0;
    while (i < this.bits.length)
    {
      int[] arrayOfInt = this.bits;
      arrayOfInt[i] ^= paramlj.bits[i];
      i += 1;
    }
  }
  
  public boolean get(int paramInt)
  {
    return (this.bits[(paramInt >> 5)] & 1 << (paramInt & 0x1F)) != 0;
  }
  
  public int getSize()
  {
    return this.size;
  }
  
  public int getSizeInBytes()
  {
    return this.size + 7 >> 3;
  }
  
  public void toBytes(int paramInt1, byte[] paramArrayOfByte, int paramInt2, int paramInt3)
  {
    int i = 0;
    while (i < paramInt3)
    {
      int j = 0;
      int m;
      for (int k = 0; j < 8; k = m)
      {
        m = k;
        if (get(paramInt1)) {
          m = k | 1 << 7 - j;
        }
        paramInt1 += 1;
        j += 1;
      }
      paramArrayOfByte[(paramInt2 + i)] = ((byte)k);
      i += 1;
    }
  }
  
  public String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder(this.size);
    int i = 0;
    if (i < this.size)
    {
      if ((i & 0x7) == 0) {
        localStringBuilder.append(' ');
      }
      if (get(i)) {}
      for (char c = 'X';; c = '.')
      {
        localStringBuilder.append(c);
        i += 1;
        break;
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     lj
 * JD-Core Version:    0.7.0.1
 */