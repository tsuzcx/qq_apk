package com.tencent.qphone.base.util.a.c;

import com.tencent.qphone.base.util.a.b.d;

public class a
{
  a a;
  d b = new d();
  
  public a(a parama)
  {
    this.a = parama;
  }
  
  public void a()
  {
    this.b.c = 0;
    this.a.a(this.b);
    this.b.a();
  }
  
  public void a(int paramInt)
  {
    int i = (char)paramInt;
    Object localObject;
    d locald;
    if (i < 128)
    {
      localObject = this.b.a;
      locald = this.b;
      paramInt = locald.c;
      locald.c = (paramInt + 1);
      localObject[paramInt] = ((byte)i);
      localObject = this.b;
      ((d)localObject).d += 1;
    }
    for (;;)
    {
      if (this.b.c >= this.b.b - 4) {
        a();
      }
      return;
      if (i < 2048)
      {
        localObject = this.b.a;
        locald = this.b;
        paramInt = locald.c;
        locald.c = (paramInt + 1);
        localObject[paramInt] = ((byte)(i >>> 6 | 0xC0));
        localObject = this.b.a;
        locald = this.b;
        paramInt = locald.c;
        locald.c = (paramInt + 1);
        localObject[paramInt] = ((byte)(i & 0x3F | 0x80));
        localObject = this.b;
        ((d)localObject).d += 2;
      }
      else
      {
        if ((i >= 55296) && (i <= 57343)) {
          break;
        }
        localObject = this.b.a;
        locald = this.b;
        paramInt = locald.c;
        locald.c = (paramInt + 1);
        localObject[paramInt] = ((byte)(i >>> 12 | 0xE0));
        localObject = this.b.a;
        locald = this.b;
        paramInt = locald.c;
        locald.c = (paramInt + 1);
        localObject[paramInt] = ((byte)(i >>> 6 & 0x3F | 0x80));
        localObject = this.b.a;
        locald = this.b;
        paramInt = locald.c;
        locald.c = (paramInt + 1);
        localObject[paramInt] = ((byte)(i & 0x3F | 0x80));
        localObject = this.b;
        ((d)localObject).d += 3;
      }
    }
    throw new RuntimeException("not supported char " + paramInt);
  }
  
  public void a(String paramString)
  {
    int m = paramString.length();
    int j = 0;
    int i;
    Object localObject;
    d locald;
    int k;
    if (j < m)
    {
      i = paramString.charAt(j);
      if (i < 128)
      {
        localObject = this.b.a;
        locald = this.b;
        k = locald.c;
        locald.c = (k + 1);
        localObject[k] = ((byte)i);
        localObject = this.b;
        ((d)localObject).d += 1;
      }
      for (;;)
      {
        if (this.b.c >= this.b.b - 4) {
          a();
        }
        j += 1;
        break;
        if (i < 2048)
        {
          localObject = this.b.a;
          locald = this.b;
          k = locald.c;
          locald.c = (k + 1);
          localObject[k] = ((byte)(i >>> 6 | 0xC0));
          localObject = this.b.a;
          locald = this.b;
          k = locald.c;
          locald.c = (k + 1);
          localObject[k] = ((byte)(i & 0x3F | 0x80));
          localObject = this.b;
          ((d)localObject).d += 2;
        }
        else
        {
          if ((i >= 55296) && (i <= 57343)) {
            break label402;
          }
          localObject = this.b.a;
          locald = this.b;
          k = locald.c;
          locald.c = (k + 1);
          localObject[k] = ((byte)(i >>> 12 | 0xE0));
          localObject = this.b.a;
          locald = this.b;
          k = locald.c;
          locald.c = (k + 1);
          localObject[k] = ((byte)(i >>> 6 & 0x3F | 0x80));
          localObject = this.b.a;
          locald = this.b;
          k = locald.c;
          locald.c = (k + 1);
          localObject[k] = ((byte)(i & 0x3F | 0x80));
          localObject = this.b;
          ((d)localObject).d += 3;
        }
      }
      label402:
      k = j + 1;
      if (k >= m) {
        break label707;
      }
    }
    label707:
    for (j = Character.toCodePoint(i, paramString.charAt(k));; j = 0)
    {
      if ((j >= 65536) && (j < 2097152))
      {
        localObject = this.b.a;
        locald = this.b;
        int n = locald.c;
        locald.c = (n + 1);
        localObject[n] = ((byte)(j >>> 18 | 0xF0));
        localObject = this.b.a;
        locald = this.b;
        n = locald.c;
        locald.c = (n + 1);
        localObject[n] = ((byte)(j >>> 12 & 0x3F | 0x80));
        localObject = this.b.a;
        locald = this.b;
        n = locald.c;
        locald.c = (n + 1);
        localObject[n] = ((byte)(j >>> 6 & 0x3F | 0x80));
        localObject = this.b.a;
        locald = this.b;
        n = locald.c;
        locald.c = (n + 1);
        localObject[n] = ((byte)(j & 0x3F | 0x80));
        localObject = this.b;
        ((d)localObject).d += 4;
        j = k;
        break;
      }
      localObject = this.b.a;
      locald = this.b;
      j = locald.c;
      locald.c = (j + 1);
      localObject[j] = 63;
      localObject = this.b;
      ((d)localObject).d += 1;
      j = k;
      break;
      return;
    }
  }
  
  public void a(byte[] paramArrayOfByte, int paramInt1, int paramInt2)
  {
    if (paramInt2 > this.b.b) {
      throw new IndexOutOfBoundsException();
    }
    if (this.b.b - this.b.d < paramInt2) {
      a();
    }
    this.b.b(paramArrayOfByte, paramInt1, paramInt2);
    if (this.b.c >= this.b.b - 4) {
      a();
    }
  }
  
  public void a(char[] paramArrayOfChar, int paramInt1, int paramInt2)
  {
    int k = paramInt2 + paramInt1;
    if (paramInt1 < k)
    {
      int i = paramArrayOfChar[paramInt1];
      Object localObject;
      d locald;
      if (i < 128)
      {
        localObject = this.b.a;
        locald = this.b;
        paramInt2 = locald.c;
        locald.c = (paramInt2 + 1);
        localObject[paramInt2] = ((byte)i);
        localObject = this.b;
        ((d)localObject).d += 1;
      }
      for (;;)
      {
        if (this.b.c >= this.b.b - 4) {
          a();
        }
        paramInt1 += 1;
        break;
        if (i < 2048)
        {
          localObject = this.b.a;
          locald = this.b;
          paramInt2 = locald.c;
          locald.c = (paramInt2 + 1);
          localObject[paramInt2] = ((byte)(i >>> 6 | 0xC0));
          localObject = this.b.a;
          locald = this.b;
          paramInt2 = locald.c;
          locald.c = (paramInt2 + 1);
          localObject[paramInt2] = ((byte)(i & 0x3F | 0x80));
          localObject = this.b;
          ((d)localObject).d += 2;
        }
        else if ((i < 55296) || (i > 57343))
        {
          localObject = this.b.a;
          locald = this.b;
          paramInt2 = locald.c;
          locald.c = (paramInt2 + 1);
          localObject[paramInt2] = ((byte)(i >>> 12 | 0xE0));
          localObject = this.b.a;
          locald = this.b;
          paramInt2 = locald.c;
          locald.c = (paramInt2 + 1);
          localObject[paramInt2] = ((byte)(i >>> 6 & 0x3F | 0x80));
          localObject = this.b.a;
          locald = this.b;
          paramInt2 = locald.c;
          locald.c = (paramInt2 + 1);
          localObject[paramInt2] = ((byte)(i & 0x3F | 0x80));
          localObject = this.b;
          ((d)localObject).d += 3;
        }
        else
        {
          int j = 0;
          paramInt2 = paramInt1 + 1;
          paramInt1 = j;
          if (paramInt2 < k) {
            paramInt1 = Character.toCodePoint(i, paramArrayOfChar[paramInt2]);
          }
          if ((paramInt1 >= 65536) && (paramInt1 < 2097152))
          {
            localObject = this.b.a;
            locald = this.b;
            j = locald.c;
            locald.c = (j + 1);
            localObject[j] = ((byte)(paramInt1 >>> 18 | 0xF0));
            localObject = this.b.a;
            locald = this.b;
            j = locald.c;
            locald.c = (j + 1);
            localObject[j] = ((byte)(paramInt1 >>> 12 & 0x3F | 0x80));
            localObject = this.b.a;
            locald = this.b;
            j = locald.c;
            locald.c = (j + 1);
            localObject[j] = ((byte)(paramInt1 >>> 6 & 0x3F | 0x80));
            localObject = this.b.a;
            locald = this.b;
            j = locald.c;
            locald.c = (j + 1);
            localObject[j] = ((byte)(paramInt1 & 0x3F | 0x80));
            localObject = this.b;
            ((d)localObject).d += 4;
            paramInt1 = paramInt2;
          }
          else
          {
            localObject = this.b.a;
            locald = this.b;
            paramInt1 = locald.c;
            locald.c = (paramInt1 + 1);
            localObject[paramInt1] = 63;
            localObject = this.b;
            ((d)localObject).d += 1;
            paramInt1 = paramInt2;
          }
        }
      }
    }
  }
  
  public static abstract interface a
  {
    public abstract void a(d paramd);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     com.tencent.qphone.base.util.a.c.a
 * JD-Core Version:    0.7.0.1
 */