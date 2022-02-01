package com.tencent.token;

public final class amf
{
  int a;
  final int[] b = new int[10];
  
  final int a()
  {
    if ((this.a & 0x2) != 0) {
      return this.b[1];
    }
    return -1;
  }
  
  final amf a(int paramInt1, int paramInt2)
  {
    if (paramInt1 >= 0)
    {
      int[] arrayOfInt = this.b;
      if (paramInt1 >= arrayOfInt.length) {
        return this;
      }
      this.a = (1 << paramInt1 | this.a);
      arrayOfInt[paramInt1] = paramInt2;
      return this;
    }
    return this;
  }
  
  final boolean a(int paramInt)
  {
    return (1 << paramInt & this.a) != 0;
  }
  
  final int b()
  {
    if ((this.a & 0x80) != 0) {
      return this.b[7];
    }
    return 65535;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.amf
 * JD-Core Version:    0.7.0.1
 */