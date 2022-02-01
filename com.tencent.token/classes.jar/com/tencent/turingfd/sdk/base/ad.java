package com.tencent.turingfd.sdk.base;

import android.content.Context;
import android.text.TextUtils;
import java.io.File;
import java.util.ArrayList;

public class ad
{
  public static final cx<ad> a = new a();
  public Object b = new Object();
  
  public ArrayList<Flat> a(Context paramContext)
  {
    ArrayList localArrayList = new ArrayList();
    Flat localFlat = new Flat();
    localFlat.sc = ci.a(new StringBuilder(), da.c, "sign");
    StringBuilder localStringBuilder = ci.a("");
    localStringBuilder.append(b(paramContext));
    localFlat.tc = localStringBuilder.toString();
    localArrayList.add(localFlat);
    return localArrayList;
  }
  
  public final int b(Context paramContext)
  {
    try
    {
      synchronized (this.b)
      {
        String str = c(paramContext);
        if (!TextUtils.isEmpty(str)) {
          i = Integer.parseInt(new String(cm.b(str)));
        }
      }
    }
    catch (Throwable localThrowable)
    {
      int i;
      label48:
      break label48;
    }
    i = 0;
    paramContext = c(paramContext);
    if (!TextUtils.isEmpty(paramContext)) {
      cm.a(paramContext, "0".getBytes());
    }
    return i;
    throw paramContext;
  }
  
  public final String c(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    paramContext = new File(ci.a(localStringBuilder, File.separator, "8"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    localStringBuilder = new StringBuilder();
    localStringBuilder.append(paramContext.getAbsolutePath());
    return ci.a(localStringBuilder, File.separator, "2");
  }
  
  public static final class a
    extends cx<ad>
  {
    public Object a()
    {
      return new ad();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.turingfd.sdk.base.ad
 * JD-Core Version:    0.7.0.1
 */