package com.tencent.mobileqq.triton.font;

import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;
import java.util.Set;

public class a
{
  private int a;
  private int b;
  private byte[] c;
  
  public a(String paramString)
    throws IOException
  {
    paramString = new FileInputStream(new File(paramString));
    try
    {
      a(paramString);
      return;
    }
    finally
    {
      paramString.close();
    }
  }
  
  public static String a(String paramString)
  {
    if ((paramString == null) || (paramString.length() <= 0)) {
      return "";
    }
    String str1 = new File(paramString).getName().replaceAll(" ", "_");
    try
    {
      paramString = b(paramString);
      if (paramString != null)
      {
        if ((paramString.a() != null) && (!paramString.a().isEmpty()))
        {
          paramString = paramString.a().iterator();
          String str2;
          do
          {
            if (!paramString.hasNext()) {
              break;
            }
            str2 = (String)paramString.next();
          } while ((str2 == null) || (str2.matches(".*[一-鿿]+.*")));
          return str2;
        }
        if ((paramString.b() != null) && (paramString.b().length() > 0))
        {
          paramString = paramString.b();
          return paramString;
        }
        return str1;
      }
      return str1;
    }
    catch (IOException paramString)
    {
      paramString.printStackTrace();
      return str1;
    }
    return str1;
  }
  
  private void a(InputStream paramInputStream)
    throws IOException
  {
    this.c = b.a(paramInputStream);
    this.a = this.c.length;
    this.b = 0;
  }
  
  public static d b(String paramString)
    throws IOException
  {
    d locald = new d();
    locald.a(new a(paramString));
    return locald;
  }
  
  private byte g()
    throws IOException
  {
    int i = this.b;
    if (i < this.a)
    {
      byte[] arrayOfByte = this.c;
      this.b = (i + 1);
      return arrayOfByte[i];
    }
    throw new EOFException("Reached EOF, file size=" + this.a);
  }
  
  public int a()
  {
    return this.b;
  }
  
  public String a(int paramInt)
    throws IOException
  {
    int i = this.b;
    if (paramInt + i <= this.a)
    {
      byte[] arrayOfByte = new byte[paramInt];
      System.arraycopy(this.c, i, arrayOfByte, 0, paramInt);
      this.b += paramInt;
      if ((arrayOfByte.length > 0) && (arrayOfByte[0] == 0)) {}
      for (String str = "UTF-16BE";; str = "ISO-8859-1") {
        return new String(arrayOfByte, str);
      }
    }
    throw new EOFException("Reached EOF, file size=" + this.a);
  }
  
  public String a(int paramInt1, int paramInt2)
    throws IOException
  {
    paramInt2 = this.b;
    if (paramInt1 + paramInt2 <= this.a)
    {
      byte[] arrayOfByte = new byte[paramInt1];
      System.arraycopy(this.c, paramInt2, arrayOfByte, 0, paramInt1);
      this.b += paramInt1;
      return new String(arrayOfByte, "UTF-16BE");
    }
    throw new EOFException("Reached EOF, file size=" + this.a);
  }
  
  public void a(long paramLong)
    throws IOException
  {
    if ((paramLong <= this.a) && (paramLong >= 0L))
    {
      this.b = ((int)paramLong);
      return;
    }
    throw new EOFException("Reached EOF, file size=" + this.a + " offset=" + paramLong);
  }
  
  public byte b()
    throws IOException
  {
    return g();
  }
  
  public void b(long paramLong)
    throws IOException
  {
    a(this.b + paramLong);
  }
  
  public int c()
    throws IOException
  {
    return (int)((((d() << 8) + d() << 8) + d() << 8) + d());
  }
  
  public int d()
    throws IOException
  {
    int j = g();
    int i = j;
    if (j < 0) {
      i = j + 256;
    }
    return i;
  }
  
  public long e()
    throws IOException
  {
    return (((d() << 8) + d() << 8) + d() << 8) + d();
  }
  
  public int f()
    throws IOException
  {
    return (d() << 8) + d();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.triton.font.a
 * JD-Core Version:    0.7.0.1
 */