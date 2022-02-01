package com.tencent.tmassistant;

import android.content.Context;
import com.tencent.tmassistantbase.util.GlobalUtil;
import com.tencent.tmassistantbase.util.ab;
import com.tencent.tmassistantbase.util.s;
import com.tencent.tmassistantsdk.internal.b.b;
import com.tencent.tmdownloader.TMAssistantDownloadClient;
import com.tencent.tmdownloader.f;
import java.util.ArrayList;
import java.util.Iterator;

public class a
{
  protected static a a = null;
  protected static ArrayList<TMAssistantDownloadClient> c = new ArrayList();
  protected static ArrayList<b> d = new ArrayList();
  protected Context b = null;
  
  protected a(Context paramContext)
  {
    this.b = paramContext;
  }
  
  public static a a(Context paramContext)
  {
    try
    {
      if (a == null)
      {
        a = new a(paramContext);
        if (!s.a())
        {
          if (GlobalUtil.getInstance().getContext() == null) {
            GlobalUtil.getInstance().setContext(paramContext);
          }
          f.a();
        }
      }
      paramContext = a;
      return paramContext;
    }
    finally {}
  }
  
  public b a(String paramString)
  {
    for (;;)
    {
      try
      {
        ab.c("TMAssistantDownloadSDKManager", "<getDownloadOpenSDKClient> clientKey = " + paramString + ",process Name:" + s.e());
        Iterator localIterator = d.iterator();
        if (localIterator.hasNext())
        {
          b localb = (b)localIterator.next();
          boolean bool = localb.mClientKey.equals(paramString);
          if (bool == true)
          {
            paramString = localb;
            return paramString;
          }
        }
        else
        {
          paramString = new b(this.b, paramString, "com.tencent.android.qqdownloader.SDKService");
          if (paramString.initTMAssistantDownloadSDK()) {
            d.add(paramString);
          } else {
            paramString = null;
          }
        }
      }
      finally {}
    }
  }
  
  /* Error */
  public boolean b(String paramString)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: getstatic 24	com/tencent/tmassistant/a:c	Ljava/util/ArrayList;
    //   5: invokevirtual 87	java/util/ArrayList:iterator	()Ljava/util/Iterator;
    //   8: astore_3
    //   9: aload_3
    //   10: invokeinterface 92 1 0
    //   15: ifeq +49 -> 64
    //   18: aload_3
    //   19: invokeinterface 96 1 0
    //   24: checkcast 122	com/tencent/tmdownloader/TMAssistantDownloadClient
    //   27: astore 4
    //   29: aload 4
    //   31: ifnull -22 -> 9
    //   34: aload 4
    //   36: getfield 123	com/tencent/tmdownloader/TMAssistantDownloadClient:mClientKey	Ljava/lang/String;
    //   39: aload_1
    //   40: invokevirtual 108	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   43: iconst_1
    //   44: if_icmpne -35 -> 9
    //   47: aload 4
    //   49: invokevirtual 126	com/tencent/tmdownloader/TMAssistantDownloadClient:unInitTMAssistantDownloadSDK	()V
    //   52: aload_3
    //   53: invokeinterface 129 1 0
    //   58: iconst_1
    //   59: istore_2
    //   60: aload_0
    //   61: monitorexit
    //   62: iload_2
    //   63: ireturn
    //   64: iconst_0
    //   65: istore_2
    //   66: goto -6 -> 60
    //   69: astore_1
    //   70: aload_0
    //   71: monitorexit
    //   72: aload_1
    //   73: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	74	0	this	a
    //   0	74	1	paramString	String
    //   59	7	2	bool	boolean
    //   8	45	3	localIterator	Iterator
    //   27	21	4	localTMAssistantDownloadClient	TMAssistantDownloadClient
    // Exception table:
    //   from	to	target	type
    //   2	9	69	finally
    //   9	29	69	finally
    //   34	58	69	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes12.jar
 * Qualified Name:     com.tencent.tmassistant.a
 * JD-Core Version:    0.7.0.1
 */