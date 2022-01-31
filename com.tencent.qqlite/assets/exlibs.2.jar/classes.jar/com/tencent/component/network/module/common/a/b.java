package com.tencent.component.network.module.common.a;

import java.util.concurrent.atomic.AtomicInteger;

public final class b
{
  private static b a = null;
  private static AtomicInteger b = new AtomicInteger(100);
  
  public static b a()
  {
    try
    {
      if (a == null) {
        a = new b();
      }
      b localb = a;
      return localb;
    }
    finally {}
  }
  
  public final int b()
  {
    try
    {
      int j = b.getAndIncrement();
      int i = j;
      if (j >= 65535)
      {
        AtomicInteger localAtomicInteger = new AtomicInteger(100);
        b = localAtomicInteger;
        i = localAtomicInteger.getAndIncrement();
      }
      return i;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.component.network.module.common.a.b
 * JD-Core Version:    0.7.0.1
 */