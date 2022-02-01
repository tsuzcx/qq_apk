package com.tencent.token;

import android.content.Context;
import android.os.Build.VERSION;
import java.util.List;

public final class pt
{
  private static final int a = 17;
  
  public static String a(List<b> paramList)
  {
    Object localObject1 = "";
    if (paramList.size() <= 0) {
      return "";
    }
    int i = 0;
    while (i < paramList.size())
    {
      Object localObject2 = localObject1;
      if (paramList.get(i) != null)
      {
        localObject2 = localObject1;
        if (((b)paramList.get(i)).a.length() == a)
        {
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("<mac ");
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("macDbm=\"");
          ((StringBuilder)localObject2).append(((b)paramList.get(i)).b);
          ((StringBuilder)localObject2).append("\"");
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(">");
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append(((b)paramList.get(i)).a);
          localObject1 = ((StringBuilder)localObject2).toString();
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append((String)localObject1);
          ((StringBuilder)localObject2).append("</mac>");
          localObject2 = ((StringBuilder)localObject2).toString();
        }
      }
      i += 1;
      localObject1 = localObject2;
    }
    return localObject1;
  }
  
  public static List<a> a(Context paramContext)
  {
    if (Build.VERSION.SDK_INT >= 5)
    {
      new pw();
      return pw.a(paramContext);
    }
    new pu();
    return pu.a(paramContext);
  }
  
  public static String b(List<a> paramList)
  {
    String str = "";
    if ((paramList != null) && (paramList.size() > 0))
    {
      int i = 0;
      while (i < paramList.size())
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("<cell ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("mcc=\"");
        localStringBuilder.append(((a)paramList.get(i)).a);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("mnc=\"");
        localStringBuilder.append(((a)paramList.get(i)).b);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("lac=\"");
        localStringBuilder.append(((a)paramList.get(i)).c);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("type=\"");
        localStringBuilder.append(((a)paramList.get(i)).e);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("stationId=\"");
        localStringBuilder.append(((a)paramList.get(i)).f);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("networkId=\"");
        localStringBuilder.append(((a)paramList.get(i)).g);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("systemId=\"");
        localStringBuilder.append(((a)paramList.get(i)).h);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("dbm=\"");
        localStringBuilder.append(((a)paramList.get(i)).i);
        localStringBuilder.append("\" ");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(" >");
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append(((a)paramList.get(i)).d);
        str = localStringBuilder.toString();
        localStringBuilder = new StringBuilder();
        localStringBuilder.append(str);
        localStringBuilder.append("</cell>");
        str = localStringBuilder.toString();
        i += 1;
      }
      return str;
    }
    return "";
  }
  
  public static final class a
  {
    public String a;
    public String b;
    public String c;
    public String d;
    public String e;
    public String f;
    public String g;
    public String h;
    public String i;
    
    public a(String paramString1, String paramString2, String paramString3, String paramString4, String paramString5, String paramString6, String paramString7, String paramString8, String paramString9)
    {
      this.a = paramString1;
      this.b = paramString2;
      this.c = paramString3;
      this.e = paramString6;
      this.d = paramString4;
      this.f = paramString7;
      this.g = paramString8;
      this.h = paramString9;
      this.i = paramString5;
    }
  }
  
  public static final class b
  {
    public String a;
    public String b;
    
    public b(String paramString1, String paramString2)
    {
      this.a = paramString1;
      this.b = paramString2;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.pt
 * JD-Core Version:    0.7.0.1
 */