package com.tencent.token;

import android.view.View;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public final class abp
{
  public static final afk<abp> a = new a();
  public Map<String, d> b = new HashMap();
  public Map<String, b> c = new HashMap();
  public abs d;
  
  public static final class a
    extends afk<abp>
  {
    public final Object a()
    {
      return new abp((byte)0);
    }
  }
  
  public final class b
    implements abt
  {
    public int a;
    
    public b(int paramInt)
    {
      this.a = paramInt;
    }
    
    public final void a(String paramString, View paramView)
    {
      abp.a(abp.this).a(paramString, this.a, 3, null);
    }
  }
  
  public final class c
  {
    public final int a;
    public final float b;
    public final float c;
    public final float d;
    public final float e;
    
    public c(float paramFloat1, float paramFloat2, float paramFloat3, float paramFloat4)
    {
      this.a = this$1;
      this.b = paramFloat1;
      this.c = paramFloat2;
      this.d = paramFloat3;
      this.e = paramFloat4;
    }
  }
  
  public final class d
  {
    public int a;
    public long b = -1L;
    public long c;
    public List<abp.c> d = new ArrayList();
    public String e;
    public boolean f = false;
    public boolean g = false;
    
    public d(String paramString, int paramInt)
    {
      this.a = paramInt;
      this.e = paramString;
    }
    
    public final void a()
    {
      this.b = -1L;
      this.c = 0L;
      this.d.clear();
      this.f = false;
      this.g = false;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abp
 * JD-Core Version:    0.7.0.1
 */