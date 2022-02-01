package com.tencent.token;

import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public final class nb
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
        a locala = (a)localIterator.next();
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(locala.a);
        localStringBuilder.append(",");
        localStringBuilder.append(locala.b);
        localStringBuilder.append(",");
        localStringBuilder.append(locala.c);
        ((StringBuilder)localObject1).append(localStringBuilder.toString());
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
    long a;
    int b;
    String c;
    
    public a(long paramLong, int paramInt, String paramString)
    {
      this.a = paramLong;
      this.b = paramInt;
      if (TextUtils.isEmpty(paramString)) {}
      for (paramString = "";; paramString = ml.b(paramString))
      {
        this.c = paramString;
        return;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.nb
 * JD-Core Version:    0.7.0.1
 */