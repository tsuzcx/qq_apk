package com.tencent.token;

import android.content.Context;
import com.tencent.turingfd.sdk.qps.Almond;
import java.io.File;
import java.util.ArrayList;
import java.util.LinkedList;

public final class abz
{
  public static final agi<abz> a = new a();
  
  public static abz a()
  {
    return (abz)a.b();
  }
  
  public static aeq a(Context paramContext, int paramInt1, int paramInt2, int paramInt3)
  {
    try
    {
      Almond localAlmond = new Almond();
      localAlmond.a(new agd(adg.a(a(paramContext, paramInt1))));
      paramContext = new aeq(paramContext, localAlmond, paramInt2, paramInt3);
      return paramContext;
    }
    finally
    {
      label44:
      break label44;
    }
    return null;
  }
  
  private static String a(Context paramContext, int paramInt)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append(paramContext.getAbsolutePath());
    paramContext = File.separator;
    ((StringBuilder)localObject).append(paramContext);
    ((StringBuilder)localObject).append("11");
    localObject = new File(((StringBuilder)localObject).toString());
    if ((!((File)localObject).exists()) && (!((File)localObject).mkdirs())) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(((File)localObject).getAbsolutePath());
    localStringBuilder.append(paramContext);
    localStringBuilder.append(61);
    localStringBuilder.append("_");
    localStringBuilder.append(paramInt);
    return localStringBuilder.toString();
  }
  
  public static void a(Context paramContext, int paramInt, aeq paramaeq)
  {
    long l1 = paramaeq.j;
    long l2 = paramaeq.i;
    int j = paramaeq.h;
    int k = paramaeq.e;
    int m = paramaeq.f;
    Object localObject = paramaeq.c;
    paramaeq = new ArrayList();
    int i = 0;
    while (i < ((adh)localObject).b.size())
    {
      paramaeq.add((Long)((adh)localObject).b.get(i));
      i += 1;
    }
    localObject = new age();
    ((age)localObject).a(paramInt, 0);
    ((age)localObject).a(l1, 1);
    ((age)localObject).a(l2, 2);
    ((age)localObject).a(j, 3);
    ((age)localObject).a(k, 4);
    ((age)localObject).a(m, 5);
    ((age)localObject).a(paramaeq, 6);
    paramaeq = ((age)localObject).a();
    adg.a(a(paramContext, paramInt), paramaeq);
  }
  
  public final class a
    extends agi<abz>
  {
    public final Object a()
    {
      return new abz();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.abz
 * JD-Core Version:    0.7.0.1
 */