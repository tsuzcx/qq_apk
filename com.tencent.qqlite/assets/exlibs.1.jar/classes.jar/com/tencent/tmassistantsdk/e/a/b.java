package com.tencent.tmassistantsdk.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.tmassistantsdk.e.c.d;
import com.tencent.tmassistantsdk.e.c.e;
import com.tencent.tmassistantsdk.e.c.h;
import com.tencent.tmassistantsdk.e.c.i;

public final class b
  extends c
{
  private static c a = null;
  private static final Class[] b = { d.class, com.tencent.tmassistantsdk.e.c.f.class, com.tencent.tmassistantsdk.e.c.c.class, h.class, e.class, i.class };
  
  private b(Context paramContext, String paramString, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, paramString, null, 2);
  }
  
  public static c a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = com.tencent.tmassistantsdk.f.f.a().b();
        if (localObject1 != null) {
          a = new b((Context)localObject1, "tmassistant_sdk_v2.db", null, 2);
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public final int b()
  {
    return 2;
  }
  
  public final Class[] c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.1.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.a.b
 * JD-Core Version:    0.7.0.1
 */