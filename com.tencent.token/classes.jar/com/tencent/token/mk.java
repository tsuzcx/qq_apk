package com.tencent.token;

import com.tencent.beacon.event.UserAction;
import com.tencent.halley.scheduler.c.a;
import com.tencent.halley.scheduler.c.b;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public final class mk
{
  public static lq a;
  
  public static void a(byte[] paramArrayOfByte)
  {
    try
    {
      b localb = new b();
      localb.a(new md(paramArrayOfByte));
      Object localObject1 = localb.a;
      paramArrayOfByte = new ArrayList();
      localObject1 = ((List)localObject1).iterator();
      while (((Iterator)localObject1).hasNext())
      {
        Object localObject2 = (a)((Iterator)localObject1).next();
        nq localnq = new nq();
        localObject2 = ((a)localObject2).c.iterator();
        while (((Iterator)localObject2).hasNext())
        {
          ((Iterator)localObject2).next();
          nr localnr = new nr();
          localnq.a.add(localnr);
        }
        paramArrayOfByte.add(localnq);
      }
      paramArrayOfByte = localb.b;
      oi.a();
      if ((paramArrayOfByte == null) || (!"".equals(paramArrayOfByte))) {
        oj.a("detectTaskCode", paramArrayOfByte);
      }
      return;
    }
    catch (Exception paramArrayOfByte) {}
  }
  
  public static boolean a(String paramString, Map paramMap)
  {
    label53:
    boolean bool2;
    try
    {
      bool1 = UserAction.onUserAction(paramString, true, 0L, 0L, paramMap, true);
    }
    catch (Throwable paramMap)
    {
      for (;;)
      {
        try
        {
          boolean bool1;
          boolean bool3;
          if (a != null)
          {
            bool2 = bool1;
            bool3 = a.a();
            bool2 = bool3;
            paramMap = new StringBuilder("UserActionWrapper...call App UserAction event:");
            bool2 = bool3;
            paramMap.append(paramString);
            bool2 = bool3;
            paramMap.append(",ret:");
            bool2 = bool3;
            paramMap.append(bool3);
            bool2 = bool3;
            mc.c("UserActionWrapper", paramMap.toString());
          }
          return bool3;
        }
        catch (Throwable paramString) {}
        paramMap = paramMap;
      }
    }
    try
    {
      paramMap = new StringBuilder("UserActionWrapper onUserAction event:");
      paramMap.append(paramString);
      paramMap.append(",ret:");
      paramMap.append(bool1);
      mc.c("UserActionWrapper", paramMap.toString());
    }
    catch (Throwable paramMap)
    {
      break label53;
    }
    bool1 = false;
    bool3 = bool1;
    if (!bool1)
    {
      bool3 = bool1;
      bool2 = bool1;
    }
    return bool2;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.mk
 * JD-Core Version:    0.7.0.1
 */