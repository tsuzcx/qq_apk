package com.huawei.updatesdk.a.a.c.a;

import android.content.Context;
import com.huawei.updatesdk.a.a.c.e;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class a
  extends com.huawei.updatesdk.a.b.d.a.b
{
  private String abis_;
  private String deviceFeatures_;
  private int dpi_;
  private String preferLan_;
  
  public static class a
  {
    private final Context a;
    private boolean b;
    private Set<String> c;
    private String[] d;
    private boolean e;
    
    public a(Context paramContext)
    {
      this.a = paramContext;
    }
    
    private String b()
    {
      ArrayList localArrayList = new ArrayList(b.c(this.a));
      if (this.c != null)
      {
        Iterator localIterator = this.c.iterator();
        while (localIterator.hasNext())
        {
          String str = (String)localIterator.next();
          if (!localArrayList.contains(str)) {
            localArrayList.add(str);
          }
        }
      }
      if (this.e) {
        return e.a(b.a(localArrayList, this.d), ",");
      }
      return e.a(localArrayList, ",");
    }
    
    public a a(boolean paramBoolean)
    {
      this.b = paramBoolean;
      return this;
    }
    
    public a a()
    {
      a locala = new a(null);
      a.a(locala, e.a(b.c(), ","));
      a.a(locala, Integer.parseInt(b.a(this.a)));
      a.b(locala, b());
      if (this.b) {
        a.c(locala, b.b(this.a));
      }
      return locala;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.huawei.updatesdk.a.a.c.a.a
 * JD-Core Version:    0.7.0.1
 */