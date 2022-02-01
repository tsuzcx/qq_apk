package com.tencent.feedback.proguard;

import android.content.Context;
import com.tencent.feedback.common.c;
import com.tencent.feedback.common.e;
import com.tencent.feedback.upload.AbstractUploadDatas;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public final class A
  extends AbstractUploadDatas
{
  private y d = null;
  private byte e = -1;
  
  public A(Context paramContext, y paramy, byte paramByte)
  {
    super(paramContext, 1111, 520);
    this.d = paramy;
    this.e = paramByte;
  }
  
  public static S a(Context paramContext, y paramy, byte paramByte)
  {
    if ((paramy != null) && (paramContext != null))
    {
      paramContext = c.a(paramContext);
      Object localObject1 = paramContext.E();
      Object localObject2 = paramy.a((String)localObject1);
      if ((localObject2 != null) && (localObject2.length > 0))
      {
        paramy.a((q[])localObject2);
        ArrayList localArrayList = new ArrayList(localObject2.length);
        int j = localObject2.length;
        int i = 0;
        while (i < j)
        {
          paramy = localObject2[i];
          R localR = new R();
          localR.a = paramy.a();
          localR.d = paramy.c();
          localR.c = paramy.e();
          switch (paramy.b())
          {
          default: 
            e.c("rqdp{  unknown app state :%d ,drop it}", new Object[] { Integer.valueOf(paramy.b()) });
            break;
          case 4: 
            localR.b = 4;
            break;
          case 3: 
            localR.b = 3;
            break;
          case 2: 
            localR.b = 2;
            break;
          case 1: 
            localR.b = 1;
          }
          localR.e = new HashMap();
          Object localObject3;
          Object localObject4;
          if (paramContext.F() >= 0)
          {
            localObject3 = localR.e;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramContext.F());
            ((Map)localObject3).put("C01", ((StringBuilder)localObject4).toString());
          }
          if (paramContext.G() >= 0)
          {
            localObject3 = localR.e;
            localObject4 = new StringBuilder();
            ((StringBuilder)localObject4).append(paramContext.G());
            ((Map)localObject3).put("C02", ((StringBuilder)localObject4).toString());
          }
          Map localMap;
          StringBuilder localStringBuilder;
          if (paramContext.I() > 0)
          {
            localObject3 = paramContext.J().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              localMap = localR.e;
              localStringBuilder = new StringBuilder("C03_");
              localStringBuilder.append((String)localObject4);
              localMap.put(localStringBuilder.toString(), paramContext.k((String)localObject4));
            }
          }
          if (paramContext.L() > 0)
          {
            localObject3 = paramContext.M().iterator();
            while (((Iterator)localObject3).hasNext())
            {
              localObject4 = (String)((Iterator)localObject3).next();
              localMap = localR.e;
              localStringBuilder = new StringBuilder("C04_");
              localStringBuilder.append((String)localObject4);
              localMap.put(localStringBuilder.toString(), paramContext.l((String)localObject4));
            }
          }
          localArrayList.add(localR);
          e.b("rqdp{  loc st :%s , uid:%s ,  tm:%d , st:%d }", new Object[] { paramy.c(), paramy.e(), Long.valueOf(paramy.a()), Integer.valueOf(paramy.b()) });
          i += 1;
        }
        if (localArrayList.size() > 0)
        {
          paramy = new S();
          paramy.b = ((String)localObject1);
          paramy.d = localArrayList;
          paramy.a = paramByte;
          paramy.c = paramContext.h();
          paramy.e = new HashMap();
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.d());
          ((Map)localObject1).put("A7", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.w());
          ((Map)localObject1).put("A6", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.v());
          ((Map)localObject1).put("A5", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.t());
          ((Map)localObject1).put("A2", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.t());
          ((Map)localObject1).put("A1", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.f());
          ((Map)localObject1).put("A24", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.u());
          ((Map)localObject1).put("A17", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.z());
          ((Map)localObject1).put("A15", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.C());
          ((Map)localObject1).put("A13", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.o());
          ((Map)localObject1).put("A3", ((StringBuilder)localObject2).toString());
          localObject1 = paramy.e;
          localObject2 = new StringBuilder();
          ((StringBuilder)localObject2).append(paramContext.h());
          ((Map)localObject1).put("A22", ((StringBuilder)localObject2).toString());
          return paramy;
        }
        return null;
      }
      return null;
    }
    return null;
  }
  
  /* Error */
  private N e()
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 256	com/tencent/feedback/proguard/A:c	Landroid/content/Context;
    //   6: aload_0
    //   7: getfield 15	com/tencent/feedback/proguard/A:d	Lcom/tencent/feedback/proguard/y;
    //   10: aload_0
    //   11: getfield 17	com/tencent/feedback/proguard/A:e	B
    //   14: invokestatic 258	com/tencent/feedback/proguard/A:a	(Landroid/content/Context;Lcom/tencent/feedback/proguard/y;B)Lcom/tencent/feedback/proguard/S;
    //   17: astore_1
    //   18: aload_1
    //   19: ifnonnull +7 -> 26
    //   22: aload_0
    //   23: monitorexit
    //   24: aconst_null
    //   25: areturn
    //   26: aload_0
    //   27: getfield 256	com/tencent/feedback/proguard/A:c	Landroid/content/Context;
    //   30: aload_0
    //   31: getfield 260	com/tencent/feedback/proguard/A:a	I
    //   34: aload_1
    //   35: invokevirtual 263	com/tencent/feedback/proguard/S:a	()[B
    //   38: invokestatic 266	com/tencent/feedback/proguard/A:a	(Landroid/content/Context;I[B)Lcom/tencent/feedback/proguard/N;
    //   41: astore_1
    //   42: aload_0
    //   43: monitorexit
    //   44: aload_1
    //   45: areturn
    //   46: astore_1
    //   47: goto +19 -> 66
    //   50: astore_1
    //   51: aload_1
    //   52: invokestatic 269	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   55: ifne +7 -> 62
    //   58: aload_1
    //   59: invokevirtual 272	java/lang/Throwable:printStackTrace	()V
    //   62: aload_0
    //   63: monitorexit
    //   64: aconst_null
    //   65: areturn
    //   66: aload_0
    //   67: monitorexit
    //   68: aload_1
    //   69: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	70	0	this	A
    //   17	28	1	localObject1	Object
    //   46	1	1	localObject2	Object
    //   50	19	1	localThrowable	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   2	18	46	finally
    //   26	42	46	finally
    //   51	62	46	finally
    //   2	18	50	java/lang/Throwable
    //   26	42	50	java/lang/Throwable
  }
  
  public final N a()
  {
    try
    {
      N localN = e();
      return localN;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final void done(boolean paramBoolean) {}
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.proguard.A
 * JD-Core Version:    0.7.0.1
 */