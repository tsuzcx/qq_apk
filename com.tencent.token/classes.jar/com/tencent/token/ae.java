package com.tencent.token;

import android.text.TextUtils;
import com.tencent.halley.common.h;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class ae
{
  private List a = new ArrayList();
  
  public final String a()
  {
    synchronized (this.a)
    {
      if (this.a.size() == 0) {
        return "";
      }
      StringBuilder localStringBuilder = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      if (localIterator.hasNext())
      {
        localStringBuilder.append(((a)localIterator.next()).a());
        localStringBuilder.append(";");
      }
    }
    String str = localObject.toString();
    return str;
  }
  
  public final void a(a parama)
  {
    synchronized (this.a)
    {
      if (this.a.size() < 20) {
        this.a.add(parama);
      }
      return;
    }
  }
  
  public static final class a
  {
    private long a;
    private int b;
    private String c;
    
    public a(long paramLong, int paramInt, String paramString)
    {
      this.a = paramLong;
      this.b = paramInt;
      if (TextUtils.isEmpty(paramString))
      {
        this.c = "";
        return;
      }
      this.c = h.b(paramString);
    }
    
    public final String a()
    {
      return this.a + "," + this.b + "," + this.c;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ae
 * JD-Core Version:    0.7.0.1
 */