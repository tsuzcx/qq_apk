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
      Object localObject1 = new StringBuilder();
      Iterator localIterator = this.a.iterator();
      while (localIterator.hasNext())
      {
        ((StringBuilder)localObject1).append(((a)localIterator.next()).a());
        ((StringBuilder)localObject1).append(";");
      }
      localObject1 = ((StringBuilder)localObject1).toString();
      return localObject1;
    }
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
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "";; paramString = h.b(paramString))
      {
        this.c = paramString;
        return;
      }
    }
    
    public final String a()
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(this.a);
      localStringBuilder.append(",");
      localStringBuilder.append(this.b);
      localStringBuilder.append(",");
      localStringBuilder.append(this.c);
      return localStringBuilder.toString();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ae
 * JD-Core Version:    0.7.0.1
 */