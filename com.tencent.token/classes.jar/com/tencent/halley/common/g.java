package com.tencent.halley.common;

import com.tencent.beacon.event.UserAction;
import com.tencent.halley.scheduler.c.h;
import com.tencent.token.al;
import com.tencent.token.am;
import com.tencent.token.bd;
import com.tencent.token.be;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

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
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static boolean a(String paramString, boolean paramBoolean1, long paramLong1, long paramLong2, Map paramMap, boolean paramBoolean2)
  {
    try
    {
      paramBoolean1 = UserAction.onUserAction(paramString, true, 0L, 0L, paramMap, true);
    }
    catch (Throwable localThrowable1)
    {
      for (;;)
      {
        try
        {
          StringBuilder localStringBuilder;
          label59:
          boolean bool;
          if (a != null)
          {
            paramBoolean2 = paramBoolean1;
            bool = a.a(paramString, true, 0L, 0L, paramMap, true);
            paramBoolean2 = bool;
            paramMap = new StringBuilder("UserActionWrapper...call App UserAction event:");
            paramBoolean2 = bool;
            paramMap.append(paramString);
            paramBoolean2 = bool;
            paramMap.append(",ret:");
            paramBoolean2 = bool;
            paramMap.append(bool);
            paramBoolean2 = bool;
            b.c("UserActionWrapper", paramMap.toString());
          }
          return bool;
        }
        catch (Throwable paramString) {}
        localThrowable1 = localThrowable1;
      }
    }
    try
    {
      localStringBuilder = new StringBuilder("UserActionWrapper onUserAction event:");
      localStringBuilder.append(paramString);
      localStringBuilder.append(",ret:");
      localStringBuilder.append(paramBoolean1);
      b.c("UserActionWrapper", localStringBuilder.toString());
    }
    catch (Throwable localThrowable2)
    {
      break label59;
    }
    paramBoolean1 = false;
    bool = paramBoolean1;
    if (!paramBoolean1)
    {
      bool = paramBoolean1;
      paramBoolean2 = paramBoolean1;
    }
    return paramBoolean2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.halley.common.g
 * JD-Core Version:    0.7.0.1
 */