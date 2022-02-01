package com.tencent.token;

import android.text.TextUtils;
import com.tencent.turingfd.sdk.qps.Grapefruit;
import com.tencent.turingfd.sdk.qps.Guava;
import java.util.ArrayList;
import java.util.Iterator;

public final class aeq
{
  public String a;
  public int b;
  public Grapefruit c;
  
  public aeq(String paramString, int paramInt, Grapefruit paramGrapefruit)
  {
    this.a = paramString;
    this.b = paramInt;
    this.c = paramGrapefruit;
  }
  
  private static String a(String paramString)
  {
    String str = paramString;
    if (paramString.indexOf(".") > 0) {
      str = paramString.replaceAll("0+?$", "").replaceAll("[.]$", "");
    }
    return str;
  }
  
  private static String a(String paramString1, String paramString2, String paramString3)
  {
    String str = paramString3;
    if (!TextUtils.isEmpty(paramString3)) {
      str = paramString3.replace(paramString1, paramString2);
    }
    return str;
  }
  
  public final String a()
  {
    StringBuilder localStringBuilder = new StringBuilder();
    Object localObject2 = this.a;
    Object localObject1 = localObject2;
    if (localObject2 == null) {
      localObject1 = "";
    }
    localStringBuilder.append(a("&", "%0A", a(",", "%54", a("_", "%5F", a(";", "%3B", a(":", "%3A", (String)localObject1))))));
    localStringBuilder.append("_");
    localStringBuilder.append(this.b);
    localStringBuilder.append("_");
    localObject1 = this.c;
    if (localObject1 == null) {
      return localStringBuilder.toString();
    }
    localStringBuilder.append(((Grapefruit)localObject1).b);
    localStringBuilder.append(":");
    localStringBuilder.append(this.c.c);
    localStringBuilder.append(":");
    localObject1 = this.c.d.iterator();
    while (((Iterator)localObject1).hasNext())
    {
      localObject2 = (Guava)((Iterator)localObject1).next();
      localStringBuilder.append(((Guava)localObject2).a);
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Guava)localObject2).b) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Guava)localObject2).c) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Guava)localObject2).d) })));
      localStringBuilder.append(",");
      localStringBuilder.append(a(String.format("%.5f", new Object[] { Float.valueOf(((Guava)localObject2).e) })));
      if (((Iterator)localObject1).hasNext()) {
        localStringBuilder.append(";");
      }
    }
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.aeq
 * JD-Core Version:    0.7.0.1
 */