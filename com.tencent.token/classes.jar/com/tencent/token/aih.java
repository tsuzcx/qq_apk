package com.tencent.token;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;

public final class aih
{
  public final String[] a;
  
  aih(a parama)
  {
    this.a = ((String[])parama.a.toArray(new String[parama.a.size()]));
  }
  
  public final a a()
  {
    a locala = new a();
    Collections.addAll(locala.a, this.a);
    return locala;
  }
  
  public final String a(int paramInt)
  {
    return this.a[(paramInt * 2)];
  }
  
  @Nullable
  public final String a(String paramString)
  {
    String[] arrayOfString = this.a;
    int i = arrayOfString.length - 2;
    while (i >= 0)
    {
      if (paramString.equalsIgnoreCase(arrayOfString[i])) {
        return arrayOfString[(i + 1)];
      }
      i -= 2;
    }
    return null;
  }
  
  public final String b(int paramInt)
  {
    return this.a[(paramInt * 2 + 1)];
  }
  
  public final boolean equals(@Nullable Object paramObject)
  {
    return ((paramObject instanceof aih)) && (Arrays.equals(((aih)paramObject).a, this.a));
  }
  
  public final int hashCode()
  {
    return Arrays.hashCode(this.a);
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    int j = this.a.length / 2;
    int i = 0;
    while (i < j)
    {
      localStringBuilder.append(a(i));
      localStringBuilder.append(": ");
      localStringBuilder.append(b(i));
      localStringBuilder.append("\n");
      i += 1;
    }
    return localStringBuilder.toString();
  }
  
  public static final class a
  {
    final List<String> a = new ArrayList(20);
    
    static void c(String paramString1, String paramString2)
    {
      if (paramString1 != null)
      {
        if (!paramString1.isEmpty())
        {
          int j = paramString1.length();
          int i = 0;
          int k;
          while (i < j)
          {
            k = paramString1.charAt(i);
            if ((k > 32) && (k < 127)) {
              i += 1;
            } else {
              throw new IllegalArgumentException(aiw.a("Unexpected char %#04x at %d in header name: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1 }));
            }
          }
          if (paramString2 != null)
          {
            j = paramString2.length();
            i = 0;
            while (i < j)
            {
              k = paramString2.charAt(i);
              if (((k > 31) || (k == 9)) && (k < 127)) {
                i += 1;
              } else {
                throw new IllegalArgumentException(aiw.a("Unexpected char %#04x at %d in %s value: %s", new Object[] { Integer.valueOf(k), Integer.valueOf(i), paramString1, paramString2 }));
              }
            }
            return;
          }
          paramString2 = new StringBuilder("value for name ");
          paramString2.append(paramString1);
          paramString2.append(" == null");
          throw new NullPointerException(paramString2.toString());
        }
        throw new IllegalArgumentException("name is empty");
      }
      throw new NullPointerException("name == null");
    }
    
    public final a a(String paramString)
    {
      int j;
      for (int i = 0; i < this.a.size(); i = j + 2)
      {
        j = i;
        if (paramString.equalsIgnoreCase((String)this.a.get(i)))
        {
          this.a.remove(i);
          this.a.remove(i);
          j = i - 2;
        }
      }
      return this;
    }
    
    final a a(String paramString1, String paramString2)
    {
      this.a.add(paramString1);
      this.a.add(paramString2.trim());
      return this;
    }
    
    public final aih a()
    {
      return new aih(this);
    }
    
    public final a b(String paramString1, String paramString2)
    {
      c(paramString1, paramString2);
      a(paramString1);
      a(paramString1, paramString2);
      return this;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aih
 * JD-Core Version:    0.7.0.1
 */