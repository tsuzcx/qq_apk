package okhttp3;

import com.tencent.token.fn;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;

public final class d
{
  public static final d a = new a().a().c();
  public static final d b = new a().b().a(2147483647, TimeUnit.SECONDS).c();
  @Nullable
  String c;
  private final boolean d;
  private final boolean e;
  private final int f;
  private final int g;
  private final boolean h;
  private final boolean i;
  private final boolean j;
  private final int k;
  private final int l;
  private final boolean m;
  private final boolean n;
  private final boolean o;
  
  d(a parama)
  {
    this.d = parama.a;
    this.e = parama.b;
    this.f = parama.c;
    this.g = -1;
    this.h = false;
    this.i = false;
    this.j = false;
    this.k = parama.d;
    this.l = parama.e;
    this.m = parama.f;
    this.n = parama.g;
    this.o = parama.h;
  }
  
  private d(boolean paramBoolean1, boolean paramBoolean2, int paramInt1, int paramInt2, boolean paramBoolean3, boolean paramBoolean4, boolean paramBoolean5, int paramInt3, int paramInt4, boolean paramBoolean6, boolean paramBoolean7, boolean paramBoolean8, @Nullable String paramString)
  {
    this.d = paramBoolean1;
    this.e = paramBoolean2;
    this.f = paramInt1;
    this.g = paramInt2;
    this.h = paramBoolean3;
    this.i = paramBoolean4;
    this.j = paramBoolean5;
    this.k = paramInt3;
    this.l = paramInt4;
    this.m = paramBoolean6;
    this.n = paramBoolean7;
    this.o = paramBoolean8;
    this.c = paramString;
  }
  
  public static d a(r paramr)
  {
    int i12 = paramr.a();
    int i7 = 0;
    int i1 = 1;
    Object localObject1 = null;
    boolean bool8 = false;
    boolean bool7 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool6 = false;
    boolean bool5 = false;
    boolean bool4 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool3 = false;
    boolean bool2 = false;
    boolean bool1 = false;
    for (;;)
    {
      Object localObject2 = paramr;
      if (i7 >= i12) {
        break;
      }
      String str2 = ((r)localObject2).a(i7);
      String str1 = ((r)localObject2).b(i7);
      if (str2.equalsIgnoreCase("Cache-Control"))
      {
        if (localObject1 != null) {
          i1 = 0;
        } else {
          localObject1 = str1;
        }
      }
      else
      {
        if (!str2.equalsIgnoreCase("Pragma")) {
          break label1062;
        }
        i1 = 0;
      }
      int i2 = 0;
      while (i2 < str1.length())
      {
        int i8 = fn.a(str1, i2, "=,;");
        str2 = str1.substring(i2, i8).trim();
        if ((i8 != str1.length()) && (str1.charAt(i8) != ',') && (str1.charAt(i8) != ';'))
        {
          i8 = fn.a(str1, i8 + 1);
          if ((i8 < str1.length()) && (str1.charAt(i8) == '"'))
          {
            i2 = i8 + 1;
            i8 = fn.a(str1, i2, "\"");
            localObject2 = str1.substring(i2, i8);
            i2 = i8 + 1;
          }
          else
          {
            i2 = fn.a(str1, i8, ",;");
            localObject2 = str1.substring(i8, i2).trim();
          }
        }
        else
        {
          i2 = i8 + 1;
          localObject2 = null;
        }
        boolean bool9;
        boolean bool10;
        int i9;
        boolean bool11;
        boolean bool12;
        boolean bool13;
        int i10;
        int i11;
        boolean bool14;
        boolean bool15;
        if ("no-cache".equalsIgnoreCase(str2))
        {
          bool9 = true;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("no-store".equalsIgnoreCase(str2))
        {
          bool10 = true;
          bool9 = bool8;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i8 = fn.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i9 = fn.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool11 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool12 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool13 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i10 = fn.b((String)localObject2, 2147483647);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i11 = fn.b((String)localObject2, -1);
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          bool14 = bool3;
          bool15 = bool2;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool14 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool15 = bool2;
        }
        else if ("no-transform".equalsIgnoreCase(str2))
        {
          bool15 = true;
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
        }
        else
        {
          bool9 = bool8;
          bool10 = bool7;
          i8 = i6;
          i9 = i5;
          bool11 = bool6;
          bool12 = bool5;
          bool13 = bool4;
          i10 = i4;
          i11 = i3;
          bool14 = bool3;
          bool15 = bool2;
          if ("immutable".equalsIgnoreCase(str2))
          {
            bool1 = true;
            bool15 = bool2;
            bool14 = bool3;
            i11 = i3;
            i10 = i4;
            bool13 = bool4;
            bool12 = bool5;
            bool11 = bool6;
            i9 = i5;
            i8 = i6;
            bool10 = bool7;
            bool9 = bool8;
          }
        }
        bool8 = bool9;
        bool7 = bool10;
        i6 = i8;
        i5 = i9;
        bool6 = bool11;
        bool5 = bool12;
        bool4 = bool13;
        i4 = i10;
        i3 = i11;
        bool3 = bool14;
        bool2 = bool15;
      }
      label1062:
      i7 += 1;
    }
    if (i1 == 0) {
      localObject1 = null;
    }
    return new d(bool8, bool7, i6, i5, bool6, bool5, bool4, i4, i3, bool3, bool2, bool1, localObject1);
  }
  
  private String k()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    if (this.d) {
      localStringBuilder.append("no-cache, ");
    }
    if (this.e) {
      localStringBuilder.append("no-store, ");
    }
    if (this.f != -1)
    {
      localStringBuilder.append("max-age=");
      localStringBuilder.append(this.f);
      localStringBuilder.append(", ");
    }
    if (this.g != -1)
    {
      localStringBuilder.append("s-maxage=");
      localStringBuilder.append(this.g);
      localStringBuilder.append(", ");
    }
    if (this.h) {
      localStringBuilder.append("private, ");
    }
    if (this.i) {
      localStringBuilder.append("public, ");
    }
    if (this.j) {
      localStringBuilder.append("must-revalidate, ");
    }
    if (this.k != -1)
    {
      localStringBuilder.append("max-stale=");
      localStringBuilder.append(this.k);
      localStringBuilder.append(", ");
    }
    if (this.l != -1)
    {
      localStringBuilder.append("min-fresh=");
      localStringBuilder.append(this.l);
      localStringBuilder.append(", ");
    }
    if (this.m) {
      localStringBuilder.append("only-if-cached, ");
    }
    if (this.n) {
      localStringBuilder.append("no-transform, ");
    }
    if (this.o) {
      localStringBuilder.append("immutable, ");
    }
    if (localStringBuilder.length() == 0) {
      return "";
    }
    localStringBuilder.delete(localStringBuilder.length() - 2, localStringBuilder.length());
    return localStringBuilder.toString();
  }
  
  public boolean a()
  {
    return this.d;
  }
  
  public boolean b()
  {
    return this.e;
  }
  
  public int c()
  {
    return this.f;
  }
  
  public boolean d()
  {
    return this.h;
  }
  
  public boolean e()
  {
    return this.i;
  }
  
  public boolean f()
  {
    return this.j;
  }
  
  public int g()
  {
    return this.k;
  }
  
  public int h()
  {
    return this.l;
  }
  
  public boolean i()
  {
    return this.m;
  }
  
  public boolean j()
  {
    return this.o;
  }
  
  public String toString()
  {
    String str = this.c;
    if (str != null) {
      return str;
    }
    str = k();
    this.c = str;
    return str;
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
    
    public a a()
    {
      this.a = true;
      return this;
    }
    
    public a a(int paramInt, TimeUnit paramTimeUnit)
    {
      if (paramInt >= 0)
      {
        long l = paramTimeUnit.toSeconds(paramInt);
        if (l > 2147483647L) {
          paramInt = 2147483647;
        } else {
          paramInt = (int)l;
        }
        this.d = paramInt;
        return this;
      }
      paramTimeUnit = new StringBuilder();
      paramTimeUnit.append("maxStale < 0: ");
      paramTimeUnit.append(paramInt);
      throw new IllegalArgumentException(paramTimeUnit.toString());
    }
    
    public a b()
    {
      this.f = true;
      return this;
    }
    
    public d c()
    {
      return new d(this);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     okhttp3.d
 * JD-Core Version:    0.7.0.1
 */