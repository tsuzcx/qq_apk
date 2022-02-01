package c.t.m.g;

import android.text.TextUtils;
import android.util.Pair;
import java.util.Observable;

public final class al
{
  private long A = 30000L;
  private String B = "6.0.5.8.4";
  private String C = "210908";
  private String D = this.B;
  public int a;
  public String b;
  public String c;
  public String d;
  public String e;
  public String f;
  public String g;
  public String h;
  public int i;
  public String j;
  public long k;
  public boolean l = true;
  public boolean m = true;
  public boolean n = true;
  public int o = -2;
  public Pair<String, String> p;
  private final ap q;
  private String r;
  private int s = 0;
  private int t = 0;
  private int u = 0;
  private boolean v = false;
  private boolean w = false;
  private boolean x = false;
  private boolean y = false;
  private long z = 20000L;
  
  public al(ap paramap)
  {
    this.q = paramap;
  }
  
  public final String a()
  {
    if (TextUtils.isEmpty(this.b)) {
      return "0123456789ABCDEF";
    }
    return this.b;
  }
  
  public final String b()
  {
    if (TextUtils.isEmpty(this.c)) {
      return "0123456789ABCDEF";
    }
    return this.c;
  }
  
  public final String c()
  {
    if ((TextUtils.isEmpty(this.e)) || (this.e.contains("0000"))) {
      return "0123456789ABCDEF";
    }
    return this.e;
  }
  
  public final String d()
  {
    if (this.B == null) {
      return "None";
    }
    return this.B;
  }
  
  public final String e()
  {
    if (this.C == null) {
      return "None";
    }
    return this.C;
  }
  
  public final String f()
  {
    if (this.r == null)
    {
      StringBuilder localStringBuilder = new StringBuilder(100);
      localStringBuilder.append(a()).append("_").append(b()).append("_").append(c()).append("_QQGeoLocation");
      this.r = ai.d(localStringBuilder.toString());
    }
    return this.r;
  }
  
  public static class a
    extends Observable
  {
    public void clearChanged()
    {
      try
      {
        super.clearChanged();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
    
    public void setChanged()
    {
      try
      {
        super.setChanged();
        return;
      }
      finally
      {
        localObject = finally;
        throw localObject;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     c.t.m.g.al
 * JD-Core Version:    0.7.0.1
 */