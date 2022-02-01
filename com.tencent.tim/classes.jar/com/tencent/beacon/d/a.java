package com.tencent.beacon.d;

import com.tencent.beacon.module.ModuleName;
import com.tencent.beacon.module.StatModule;
import java.util.HashMap;
import java.util.Map;

public class a
{
  private static Map<String, Long> a = new HashMap();
  
  public static void a(String paramString)
  {
    long l = System.currentTimeMillis();
    a.put(paramString, Long.valueOf(l));
    com.tencent.beacon.base.util.c.a("[page] onPageIn cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
  
  public static void b(String paramString)
  {
    long l = System.currentTimeMillis();
    Object localObject = a;
    if (localObject == null)
    {
      com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    localObject = (Long)((Map)localObject).get(paramString);
    if (localObject == null)
    {
      com.tencent.beacon.base.util.c.e("[page] please call 'onPageIn' first!", new Object[0]);
      return;
    }
    ((StatModule)com.tencent.beacon.a.c.c.d().a(ModuleName.STAT)).a(paramString, l - ((Long)localObject).longValue(), l);
    a.remove(paramString);
    com.tencent.beacon.base.util.c.a("[page] onPageOut cost time: %d", new Object[] { Long.valueOf(System.currentTimeMillis() - l) });
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes6.jar
 * Qualified Name:     com.tencent.beacon.d.a
 * JD-Core Version:    0.7.0.1
 */