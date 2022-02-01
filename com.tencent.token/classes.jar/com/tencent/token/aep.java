package com.tencent.token;

import java.io.Closeable;
import java.io.Flushable;
import java.io.IOException;
import java.io.Writer;
import java.util.Arrays;

public class aep
  implements Closeable, Flushable
{
  public static final String[] f = new String[''];
  public static final String[] g;
  public final Writer h;
  public int[] i = new int[32];
  public int j = 0;
  public String k;
  public String l;
  public boolean m;
  public boolean n;
  public String o;
  public boolean p;
  
  static
  {
    int i1 = 0;
    while (i1 <= 31)
    {
      f[i1] = String.format("\\u%04x", new Object[] { Integer.valueOf(i1) });
      i1 += 1;
    }
    String[] arrayOfString = f;
    arrayOfString[34] = "\\\"";
    arrayOfString[92] = "\\\\";
    arrayOfString[9] = "\\t";
    arrayOfString[8] = "\\b";
    arrayOfString[10] = "\\n";
    arrayOfString[13] = "\\r";
    arrayOfString[12] = "\\f";
    arrayOfString = (String[])arrayOfString.clone();
    g = arrayOfString;
    arrayOfString[60] = "\\u003c";
    arrayOfString[62] = "\\u003e";
    arrayOfString[38] = "\\u0026";
    arrayOfString[61] = "\\u003d";
    arrayOfString[39] = "\\u0027";
  }
  
  public aep(Writer paramWriter)
  {
    a(6);
    this.l = ":";
    this.p = true;
    if (paramWriter != null)
    {
      this.h = paramWriter;
      return;
    }
    throw new NullPointerException("out == null");
  }
  
  private aep a(int paramInt1, int paramInt2, char paramChar)
  {
    int i1 = f();
    if ((i1 != paramInt2) && (i1 != paramInt1)) {
      throw new IllegalStateException("Nesting problem.");
    }
    if (this.o == null)
    {
      this.j -= 1;
      if (i1 == paramInt2) {
        h();
      }
      this.h.write(paramChar);
      return this;
    }
    StringBuilder localStringBuilder = new StringBuilder("Dangling name: ");
    localStringBuilder.append(this.o);
    throw new IllegalStateException(localStringBuilder.toString());
  }
  
  private void a(int paramInt)
  {
    int i1 = this.j;
    int[] arrayOfInt = this.i;
    if (i1 == arrayOfInt.length) {
      this.i = Arrays.copyOf(arrayOfInt, i1 * 2);
    }
    arrayOfInt = this.i;
    i1 = this.j;
    this.j = (i1 + 1);
    arrayOfInt[i1] = paramInt;
  }
  
  private void b(int paramInt)
  {
    this.i[(this.j - 1)] = paramInt;
  }
  
  private void c(String paramString)
  {
    String[] arrayOfString;
    if (this.n) {
      arrayOfString = g;
    } else {
      arrayOfString = f;
    }
    this.h.write(34);
    int i4 = paramString.length();
    int i1 = 0;
    int i3;
    for (int i2 = 0; i1 < i4; i2 = i3)
    {
      int i5 = paramString.charAt(i1);
      String str1;
      if (i5 < 128)
      {
        String str2 = arrayOfString[i5];
        str1 = str2;
        if (str2 == null)
        {
          i3 = i2;
          break label143;
        }
      }
      else if (i5 == 8232)
      {
        str1 = "\\u2028";
      }
      else
      {
        i3 = i2;
        if (i5 != 8233) {
          break label143;
        }
        str1 = "\\u2029";
      }
      if (i2 < i1) {
        this.h.write(paramString, i2, i1 - i2);
      }
      this.h.write(str1);
      i3 = i1 + 1;
      label143:
      i1 += 1;
    }
    if (i2 < i4) {
      this.h.write(paramString, i2, i4 - i2);
    }
    this.h.write(34);
  }
  
  private int f()
  {
    int i1 = this.j;
    if (i1 != 0) {
      return this.i[(i1 - 1)];
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
  
  private void g()
  {
    if (this.o != null)
    {
      int i1 = f();
      if (i1 == 5) {
        this.h.write(44);
      } else {
        if (i1 != 3) {
          break label57;
        }
      }
      h();
      b(4);
      c(this.o);
      this.o = null;
      return;
      label57:
      throw new IllegalStateException("Nesting problem.");
    }
  }
  
  private void h()
  {
    if (this.k == null) {
      return;
    }
    this.h.write(10);
    int i2 = this.j;
    int i1 = 1;
    while (i1 < i2)
    {
      this.h.write(this.k);
      i1 += 1;
    }
  }
  
  private void i()
  {
    switch (f())
    {
    case 3: 
    case 5: 
    default: 
      throw new IllegalStateException("Nesting problem.");
    case 7: 
      if (!this.m) {
        throw new IllegalStateException("JSON must have only one top-level value.");
      }
    case 6: 
      b(7);
      return;
    case 4: 
      this.h.append(this.l);
      b(5);
      return;
    case 2: 
      this.h.append(',');
      h();
      return;
    }
    b(2);
    h();
  }
  
  public aep a()
  {
    g();
    i();
    a(1);
    this.h.write(91);
    return this;
  }
  
  public aep a(long paramLong)
  {
    g();
    i();
    this.h.write(Long.toString(paramLong));
    return this;
  }
  
  public aep a(Boolean paramBoolean)
  {
    if (paramBoolean == null) {
      return e();
    }
    g();
    i();
    Writer localWriter = this.h;
    if (paramBoolean.booleanValue()) {
      paramBoolean = "true";
    } else {
      paramBoolean = "false";
    }
    localWriter.write(paramBoolean);
    return this;
  }
  
  public aep a(Number paramNumber)
  {
    if (paramNumber == null) {
      return e();
    }
    g();
    String str = paramNumber.toString();
    if ((!this.m) && ((str.equals("-Infinity")) || (str.equals("Infinity")) || (str.equals("NaN")))) {
      throw new IllegalArgumentException("Numeric values must be finite, but was ".concat(String.valueOf(paramNumber)));
    }
    i();
    this.h.append(str);
    return this;
  }
  
  public aep a(String paramString)
  {
    if (paramString != null)
    {
      if (this.o == null)
      {
        if (this.j != 0)
        {
          this.o = paramString;
          return this;
        }
        throw new IllegalStateException("JsonWriter is closed.");
      }
      throw new IllegalStateException();
    }
    throw new NullPointerException("name == null");
  }
  
  public aep a(boolean paramBoolean)
  {
    g();
    i();
    Writer localWriter = this.h;
    String str;
    if (paramBoolean) {
      str = "true";
    } else {
      str = "false";
    }
    localWriter.write(str);
    return this;
  }
  
  public aep b()
  {
    return a(1, 2, ']');
  }
  
  public aep b(String paramString)
  {
    if (paramString == null) {
      return e();
    }
    g();
    i();
    c(paramString);
    return this;
  }
  
  public aep c()
  {
    g();
    i();
    a(3);
    this.h.write(123);
    return this;
  }
  
  public void close()
  {
    this.h.close();
    int i1 = this.j;
    if ((i1 <= 1) && ((i1 != 1) || (this.i[(i1 - 1)] == 7)))
    {
      this.j = 0;
      return;
    }
    throw new IOException("Incomplete document");
  }
  
  public aep d()
  {
    return a(3, 5, '}');
  }
  
  public aep e()
  {
    if (this.o != null) {
      if (this.p)
      {
        g();
      }
      else
      {
        this.o = null;
        return this;
      }
    }
    i();
    this.h.write("null");
    return this;
  }
  
  public void flush()
  {
    if (this.j != 0)
    {
      this.h.flush();
      return;
    }
    throw new IllegalStateException("JsonWriter is closed.");
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aep
 * JD-Core Version:    0.7.0.1
 */