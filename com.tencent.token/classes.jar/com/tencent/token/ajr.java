package com.tencent.token;

import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class ajr
{
  public static final ajr a;
  public static final ajr b;
  public final boolean c;
  public final boolean d;
  public final int e;
  public final boolean f;
  public final boolean g;
  public final boolean h;
  public final int i;
  public final int j;
  public final boolean k;
  public final boolean l;
  @Nullable
  String m;
  private final int n;
  private final boolean o;
  
  static
  {
    a locala = new a();
    locala.a = true;
    a = locala.a();
    locala = new a();
    locala.f = true;
    long l1 = TimeUnit.SECONDS.toSeconds(2147483647L);
    int i1;
    if (l1 > 2147483647L) {
      i1 = 2147483647;
    } else {
      i1 = (int)l1;
    }
    locala.d = i1;
    b = locala.a();
  }
  
  ajr(a parama)
  {
    this.c = parama.a;
    this.d = parama.b;
    this.e = parama.c;
    this.n = -1;
    this.f = false;
    this.g = false;
    this.h = false;
    this.i = parama.d;
    this.j = parama.e;
    this.k = parama.f;
    this.o = parama.g;
    this.l = parama.h;
  }
  
  private ajr(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, @Nullable String paramString)
  {
    this.c = paramBoolean1;
    this.d = paramBoolean2;
    this.e = paramInt1;
    this.n = paramInt2;
    this.f = paramBoolean3;
    this.g = paramBoolean4;
    this.h = paramBoolean5;
    this.i = paramInt3;
    this.j = paramInt4;
    this.k = paramBoolean6;
    this.o = paramBoolean7;
    this.l = paramBoolean8;
    this.m = paramString;
  }
  
  public static ajr a(ake paramake)
  {
    int i8 = paramake.a.length / 2;
    int i7 = 0;
    int i2 = 1;
    Object localObject1 = null;
    boolean bool5 = false;
    boolean bool7 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool8 = false;
    boolean bool6 = false;
    boolean bool4 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      Object localObject2 = paramake;
      if (i7 >= i8) {
        break;
      }
      String str2 = ((ake)localObject2).a(i7);
      String str1 = ((ake)localObject2).b(i7);
      if (str2.equalsIgnoreCase("Cache-Control"))
      {
        if (localObject1 != null) {
          i2 = 0;
        } else {
          localObject1 = str1;
        }
      }
      else
      {
        if (!str2.equalsIgnoreCase("Pragma")) {
          break label505;
        }
        i2 = 0;
      }
      int i1 = 0;
      while (i1 < str1.length())
      {
        int i9 = alk.a(str1, i1, "=,;");
        str2 = str1.substring(i1, i9).trim();
        if ((i9 != str1.length()) && (str1.charAt(i9) != ',') && (str1.charAt(i9) != ';'))
        {
          i9 = alk.a(str1, i9 + 1);
          if ((i9 < str1.length()) && (str1.charAt(i9) == '"'))
          {
            i1 = i9 + 1;
            i9 = alk.a(str1, i1, "\"");
            localObject2 = str1.substring(i1, i9);
            i1 = i9 + 1;
          }
          else
          {
            i1 = alk.a(str1, i9, ",;");
            localObject2 = str1.substring(i9, i1).trim();
          }
        }
        else
        {
          i1 = i9 + 1;
          localObject2 = null;
        }
        if ("no-cache".equalsIgnoreCase(str2)) {
          bool5 = true;
        } else if ("no-store".equalsIgnoreCase(str2)) {
          bool7 = true;
        } else if ("max-age".equalsIgnoreCase(str2)) {
          i6 = alk.b((String)localObject2, -1);
        } else if ("s-maxage".equalsIgnoreCase(str2)) {
          i5 = alk.b((String)localObject2, -1);
        } else if ("private".equalsIgnoreCase(str2)) {
          bool8 = true;
        } else if ("public".equalsIgnoreCase(str2)) {
          bool6 = true;
        } else if ("must-revalidate".equalsIgnoreCase(str2)) {
          bool4 = true;
        } else if ("max-stale".equalsIgnoreCase(str2)) {
          i4 = alk.b((String)localObject2, 2147483647);
        } else if ("min-fresh".equalsIgnoreCase(str2)) {
          i3 = alk.b((String)localObject2, -1);
        } else if ("only-if-cached".equalsIgnoreCase(str2)) {
          bool3 = true;
        } else if ("no-transform".equalsIgnoreCase(str2)) {
          bool2 = true;
        } else if ("immutable".equalsIgnoreCase(str2)) {
          bool1 = true;
        }
      }
      label505:
      i7 += 1;
    }
    if (i2 == 0) {
      localObject1 = null;
    }
    return new ajr(bool5, bool7, i6, i5, bool8, bool6, bool4, i4, i3, bool3, bool2, bool1, localObject1);
  }
  
  public final String toString()
  {
    Object localObject = this.m;
    if (localObject != null) {
      return localObject;
    }
    localObject = new StringBuilder();
    if (this.c) {
      ((StringBuilder)localObject).append("no-cache, ");
    }
    if (this.d) {
      ((StringBuilder)localObject).append("no-store, ");
    }
    if (this.e != -1)
    {
      ((StringBuilder)localObject).append("max-age=");
      ((StringBuilder)localObject).append(this.e);
      ((StringBuilder)localObject).append(", ");
    }
    if (this.n != -1)
    {
      ((StringBuilder)localObject).append("s-maxage=");
      ((StringBuilder)localObject).append(this.n);
      ((StringBuilder)localObject).append(", ");
    }
    if (this.f) {
      ((StringBuilder)localObject).append("private, ");
    }
    if (this.g) {
      ((StringBuilder)localObject).append("public, ");
    }
    if (this.h) {
      ((StringBuilder)localObject).append("must-revalidate, ");
    }
    if (this.i != -1)
    {
      ((StringBuilder)localObject).append("max-stale=");
      ((StringBuilder)localObject).append(this.i);
      ((StringBuilder)localObject).append(", ");
    }
    if (this.j != -1)
    {
      ((StringBuilder)localObject).append("min-fresh=");
      ((StringBuilder)localObject).append(this.j);
      ((StringBuilder)localObject).append(", ");
    }
    if (this.k) {
      ((StringBuilder)localObject).append("only-if-cached, ");
    }
    if (this.o) {
      ((StringBuilder)localObject).append("no-transform, ");
    }
    if (this.l) {
      ((StringBuilder)localObject).append("immutable, ");
    }
    if (((StringBuilder)localObject).length() == 0)
    {
      localObject = "";
    }
    else
    {
      ((StringBuilder)localObject).delete(((StringBuilder)localObject).length() - 2, ((StringBuilder)localObject).length());
      localObject = ((StringBuilder)localObject).toString();
    }
    this.m = ((String)localObject);
    return localObject;
  }
  
  public static final class a
  {
    boolean a;
    boolean b;
    int c = -1;
    int d = -1;
    int e = -1;
    boolean f;
    boolean g;
    boolean h;
    
    public final ajr a()
    {
      return new ajr(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajr
 * JD-Core Version:    0.7.0.1
 */