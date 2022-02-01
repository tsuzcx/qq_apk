package com.tencent.halley.common;

import com.tencent.halley.scheduler.c.h;
import com.tencent.token.al;
import com.tencent.token.am;
import com.tencent.token.bd;
import com.tencent.token.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class g
{
  public static com.tencent.halley.b a;
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      Object localObject1 = new com.tencent.halley.scheduler.c.b();
      ((com.tencent.halley.scheduler.c.b)localObject1).a(new com.tencent.halley.common.b.a(paramArrayOfByte));
      Object localObject2 = ((com.tencent.halley.scheduler.c.b)localObject1).a;
      paramArrayOfByte = new ArrayList();
      localObject2 = ((List)localObject2).iterator();
      while (((Iterator)localObject2).hasNext())
      {
        Object localObject3 = (com.tencent.halley.scheduler.c.a)((Iterator)localObject2).next();
        al localal = new al();
        Object localObject4 = ((com.tencent.halley.scheduler.c.a)localObject3).a;
        localObject4 = ((com.tencent.halley.scheduler.c.a)localObject3).b;
        int i = ((com.tencent.halley.scheduler.c.a)localObject3).d;
        localObject3 = ((com.tencent.halley.scheduler.c.a)localObject3).c.iterator();
        while (((Iterator)localObject3).hasNext())
        {
          Object localObject5 = (h)((Iterator)localObject3).next();
          localObject4 = new am();
          i = ((h)localObject5).a;
          i = ((h)localObject5).b;
          localObject5 = ((h)localObject5).c;
          localal.a.add(localObject4);
        }
        paramArrayOfByte.add(localal);
      }
      paramArrayOfByte = ((com.tencent.halley.scheduler.c.b)localObject1).b;
      localObject1 = bd.a();
      if ((paramArrayOfByte == null) || (!"".equals(paramArrayOfByte)))
      {
        localObject1 = ((bd)localObject1).c;
        be.a("detectTaskCode", paramArrayOfByte);
        return;
      }
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  /* Error */
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, java.util.Map paramMap, boolean paramBoolean2)
  {
    // Byte code:
    //   0: aload_0
    //   1: iconst_1
    //   2: lconst_0
    //   3: lconst_0
    //   4: aload 6
    //   6: iconst_1
    //   7: invokestatic 113	com/tencent/beacon/event/UserAction:onUserAction	(Ljava/lang/String;ZJJLjava/util/Map;Z)Z
    //   10: istore_1
    //   11: ldc 115
    //   13: new 117	java/lang/StringBuilder
    //   16: dup
    //   17: ldc 119
    //   19: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   22: aload_0
    //   23: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: ldc 128
    //   28: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   31: iload_1
    //   32: invokevirtual 131	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   35: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   38: invokestatic 139	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   41: iload_1
    //   42: istore 8
    //   44: iload_1
    //   45: ifne +70 -> 115
    //   48: iload_1
    //   49: istore 8
    //   51: iload_1
    //   52: istore 7
    //   54: getstatic 141	com/tencent/halley/common/g:a	Lcom/tencent/halley/b;
    //   57: ifnull +58 -> 115
    //   60: iload_1
    //   61: istore 7
    //   63: getstatic 141	com/tencent/halley/common/g:a	Lcom/tencent/halley/b;
    //   66: aload_0
    //   67: iconst_1
    //   68: lconst_0
    //   69: lconst_0
    //   70: aload 6
    //   72: iconst_1
    //   73: invokeinterface 145 9 0
    //   78: istore 8
    //   80: iload 8
    //   82: istore 7
    //   84: ldc 115
    //   86: new 117	java/lang/StringBuilder
    //   89: dup
    //   90: ldc 147
    //   92: invokespecial 122	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   95: aload_0
    //   96: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: ldc 128
    //   101: invokevirtual 126	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   104: iload 8
    //   106: invokevirtual 131	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   109: invokevirtual 135	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   112: invokestatic 139	com/tencent/halley/common/b:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   115: iload 8
    //   117: ireturn
    //   118: astore_0
    //   119: iload 7
    //   121: ireturn
    //   122: astore 9
    //   124: iconst_0
    //   125: istore_1
    //   126: goto -85 -> 41
    //   129: astore 9
    //   131: goto -90 -> 41
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	134	0	paramString	String
    //   0	134	1	paramBoolean1	boolean
    //   0	134	2	paramLong1	long
    //   0	134	4	paramLong2	long
    //   0	134	6	paramMap	java.util.Map
    //   0	134	7	paramBoolean2	boolean
    //   42	74	8	bool	boolean
    //   122	1	9	localThrowable1	java.lang.Throwable
    //   129	1	9	localThrowable2	java.lang.Throwable
    // Exception table:
    //   from	to	target	type
    //   54	60	118	java/lang/Throwable
    //   63	80	118	java/lang/Throwable
    //   84	115	118	java/lang/Throwable
    //   0	11	122	java/lang/Throwable
    //   11	41	129	java/lang/Throwable
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.g
 * JD-Core Version:    0.7.0.1
 */