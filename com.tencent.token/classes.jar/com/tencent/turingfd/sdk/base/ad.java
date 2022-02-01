package com.tencent.turingfd.sdk.base;

import android.content.Context;
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
    localFlat.tc = b(paramContext);
    localArrayList.add(localFlat);
    return localArrayList;
  }
  
  /* Error */
  public final int b(Context paramContext)
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 22	com/tencent/turingfd/sdk/base/ad:b	Ljava/lang/Object;
    //   4: astore 4
    //   6: aload 4
    //   8: monitorenter
    //   9: aload_0
    //   10: aload_1
    //   11: invokevirtual 78	com/tencent/turingfd/sdk/base/ad:c	(Landroid/content/Context;)Ljava/lang/String;
    //   14: astore 5
    //   16: aload 5
    //   18: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   21: istore_3
    //   22: iload_3
    //   23: ifeq +23 -> 46
    //   26: iconst_0
    //   27: istore_2
    //   28: aload_0
    //   29: aload_1
    //   30: invokevirtual 78	com/tencent/turingfd/sdk/base/ad:c	(Landroid/content/Context;)Ljava/lang/String;
    //   33: astore_1
    //   34: aload_1
    //   35: invokestatic 84	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   38: ifeq +27 -> 65
    //   41: aload 4
    //   43: monitorexit
    //   44: iload_2
    //   45: ireturn
    //   46: new 86	java/lang/String
    //   49: dup
    //   50: aload 5
    //   52: invokestatic 91	com/tencent/turingfd/sdk/base/cm:b	(Ljava/lang/String;)[B
    //   55: invokespecial 94	java/lang/String:<init>	([B)V
    //   58: invokestatic 100	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   61: istore_2
    //   62: goto -34 -> 28
    //   65: aload_1
    //   66: ldc 102
    //   68: invokevirtual 106	java/lang/String:getBytes	()[B
    //   71: invokestatic 109	com/tencent/turingfd/sdk/base/cm:a	(Ljava/lang/String;[B)Z
    //   74: pop
    //   75: goto -34 -> 41
    //   78: astore_1
    //   79: aload 4
    //   81: monitorexit
    //   82: aload_1
    //   83: athrow
    //   84: astore 5
    //   86: goto -60 -> 26
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	89	0	this	ad
    //   0	89	1	paramContext	Context
    //   27	35	2	i	int
    //   21	2	3	bool	boolean
    //   14	37	5	str	String
    //   84	1	5	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   9	22	78	finally
    //   28	41	78	finally
    //   41	44	78	finally
    //   46	62	78	finally
    //   65	75	78	finally
    //   79	82	78	finally
    //   9	22	84	java/lang/Throwable
    //   46	62	84	java/lang/Throwable
  }
  
  public final String c(Context paramContext)
  {
    paramContext = paramContext.getDir("turingfd", 0);
    if (paramContext == null) {
      return "";
    }
    paramContext = new File(ci.a(new StringBuilder().append(paramContext.getAbsolutePath()), File.separator, "8"));
    if ((!paramContext.exists()) && (!paramContext.mkdirs())) {
      return "";
    }
    return ci.a(new StringBuilder().append(paramContext.getAbsolutePath()), File.separator, "2");
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