package oicq.wlogin_sdk.report;

import android.content.Context;
import android.text.TextUtils;
import java.util.ArrayList;
import java.util.Iterator;
import oicq.wlogin_sdk.tools.util;

public class a
{
  public ArrayList<a> a = new ArrayList(10);
  public ArrayList<a> b = new ArrayList(10);
  
  public static a a()
  {
    return b.a;
  }
  
  public String a(Context paramContext, ArrayList<a> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramContext = util.get_cost_time(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      localStringBuilder.append(paramContext);
    }
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext())
    {
      paramArrayList = (a)paramContext.next();
      localStringBuilder.append(paramArrayList.b).append("|");
      localStringBuilder.append(paramArrayList.a).append("|");
      localStringBuilder.append(paramArrayList.c).append("|");
      localStringBuilder.append(paramArrayList.d).append("|");
      localStringBuilder.append(paramArrayList.e).append(";");
    }
    return localStringBuilder.toString();
  }
  
  public void a(int paramInt, long paramLong1, long paramLong2, long paramLong3)
  {
    a locala = new a();
    locala.b = System.currentTimeMillis();
    locala.a = paramInt;
    locala.c = paramLong1;
    locala.d = paramLong2;
    locala.e = paramLong3;
    this.a.add(locala);
  }
  
  public void a(String paramString)
  {
    a locala = new a();
    locala.b = System.currentTimeMillis();
    locala.f = paramString;
    this.b.add(locala);
  }
  
  public boolean a(Context paramContext)
  {
    util.LOGI("saveCost " + this.a.size(), "");
    if (this.a.size() > 0)
    {
      ArrayList localArrayList = new ArrayList(this.a.size());
      localArrayList.addAll(this.a);
      this.a.clear();
      util.save_cost_time(paramContext, a(paramContext, localArrayList));
      if (this.b.size() > 0)
      {
        localArrayList = new ArrayList(this.b.size());
        localArrayList.addAll(this.b);
        this.b.clear();
        util.save_cost_trace(paramContext, b(paramContext, localArrayList));
      }
      return true;
    }
    return false;
  }
  
  public String b(Context paramContext, ArrayList<a> paramArrayList)
  {
    StringBuilder localStringBuilder = new StringBuilder(100);
    paramContext = util.get_cost_trace(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      localStringBuilder.append(paramContext);
    }
    paramContext = paramArrayList.iterator();
    while (paramContext.hasNext())
    {
      paramArrayList = (a)paramContext.next();
      localStringBuilder.append(paramArrayList.b).append(",").append(paramArrayList.f).append("|");
    }
    return localStringBuilder.toString();
  }
  
  public static class a
  {
    public int a;
    public long b;
    public long c;
    public long d;
    public long e;
    public String f;
  }
  
  static final class b
  {
    public static final a a = new a(null);
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes.jar
 * Qualified Name:     oicq.wlogin_sdk.report.a
 * JD-Core Version:    0.7.0.1
 */