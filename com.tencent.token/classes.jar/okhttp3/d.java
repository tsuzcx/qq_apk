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
    boolean bool6 = false;
    int i6 = -1;
    int i5 = -1;
    boolean bool8 = false;
    boolean bool7 = false;
    boolean bool5 = false;
    int i4 = -1;
    int i3 = -1;
    boolean bool4 = false;
    boolean bool3 = false;
    boolean bool2 = false;
    int i1 = 1;
    int i13 = paramr.a();
    int i7 = 0;
    Object localObject1 = null;
    boolean bool1 = false;
    while (i7 < i13)
    {
      Object localObject2 = paramr.a(i7);
      String str1 = paramr.b(i7);
      int i8;
      if (((String)localObject2).equalsIgnoreCase("Cache-Control")) {
        if (localObject1 != null)
        {
          i1 = 0;
          i8 = 0;
        }
      }
      for (;;)
      {
        label92:
        localObject2 = localObject1;
        bool16 = bool6;
        i12 = i6;
        i11 = i5;
        bool15 = bool8;
        bool14 = bool7;
        bool13 = bool5;
        i10 = i4;
        i9 = i3;
        bool12 = bool4;
        bool11 = bool3;
        bool10 = bool2;
        i2 = i1;
        bool9 = bool1;
        if (i8 >= str1.length()) {
          break label633;
        }
        i2 = fn.a(str1, i8, "=,;");
        String str2 = str1.substring(i8, i2).trim();
        if ((i2 == str1.length()) || (str1.charAt(i2) == ',') || (str1.charAt(i2) == ';'))
        {
          i2 += 1;
          localObject2 = null;
        }
        for (;;)
        {
          if (!"no-cache".equalsIgnoreCase(str2)) {
            break label348;
          }
          bool1 = true;
          i8 = i2;
          break label92;
          localObject1 = str1;
          break;
          if (!((String)localObject2).equalsIgnoreCase("Pragma")) {
            break label580;
          }
          i1 = 0;
          break;
          i8 = fn.a(str1, i2 + 1);
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
        label348:
        if ("no-store".equalsIgnoreCase(str2))
        {
          bool6 = true;
          i8 = i2;
        }
        else if ("max-age".equalsIgnoreCase(str2))
        {
          i6 = fn.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("s-maxage".equalsIgnoreCase(str2))
        {
          i5 = fn.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("private".equalsIgnoreCase(str2))
        {
          bool8 = true;
          i8 = i2;
        }
        else if ("public".equalsIgnoreCase(str2))
        {
          bool7 = true;
          i8 = i2;
        }
        else if ("must-revalidate".equalsIgnoreCase(str2))
        {
          bool5 = true;
          i8 = i2;
        }
        else if ("max-stale".equalsIgnoreCase(str2))
        {
          i4 = fn.b((String)localObject2, 2147483647);
          i8 = i2;
        }
        else if ("min-fresh".equalsIgnoreCase(str2))
        {
          i3 = fn.b((String)localObject2, -1);
          i8 = i2;
        }
        else if ("only-if-cached".equalsIgnoreCase(str2))
        {
          bool4 = true;
          i8 = i2;
        }
        else if ("no-transform".equalsIgnoreCase(str2))
        {
          bool3 = true;
          i8 = i2;
        }
        else
        {
          i8 = i2;
          if ("immutable".equalsIgnoreCase(str2))
          {
            bool2 = true;
            i8 = i2;
          }
        }
      }
      label580:
      boolean bool9 = bool1;
      int i2 = i1;
      boolean bool10 = bool2;
      boolean bool11 = bool3;
      boolean bool12 = bool4;
      int i9 = i3;
      int i10 = i4;
      boolean bool13 = bool5;
      boolean bool14 = bool7;
      boolean bool15 = bool8;
      int i11 = i5;
      int i12 = i6;
      boolean bool16 = bool6;
      localObject2 = localObject1;
      label633:
      i7 += 1;
      bool1 = bool9;
      localObject1 = localObject2;
      bool6 = bool16;
      i6 = i12;
      i5 = i11;
      bool8 = bool15;
      bool7 = bool14;
      bool5 = bool13;
      i4 = i10;
      i3 = i9;
      bool4 = bool12;
      bool3 = bool11;
      bool2 = bool10;
      i1 = i2;
    }
    if (i1 == 0) {}
    for (paramr = null;; paramr = localObject1) {
      return new d(bool1, bool6, i6, i5, bool8, bool7, bool5, i4, i3, bool4, bool3, bool2, paramr);
    }
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
    if (this.f != -1) {
      localStringBuilder.append("max-age=").append(this.f).append(", ");
    }
    if (this.g != -1) {
      localStringBuilder.append("s-maxage=").append(this.g).append(", ");
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
    if (this.k != -1) {
      localStringBuilder.append("max-stale=").append(this.k).append(", ");
    }
    if (this.l != -1) {
      localStringBuilder.append("min-fresh=").append(this.l).append(", ");
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
      if (paramInt < 0) {
        throw new IllegalArgumentException("maxStale < 0: " + paramInt);
      }
      long l = paramTimeUnit.toSeconds(paramInt);
      if (l > 2147483647L) {}
      for (paramInt = 2147483647;; paramInt = (int)l)
      {
        this.d = paramInt;
        return this;
      }
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