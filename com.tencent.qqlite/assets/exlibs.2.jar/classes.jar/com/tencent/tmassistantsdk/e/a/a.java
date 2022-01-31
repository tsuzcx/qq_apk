package com.tencent.tmassistantsdk.e.a;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import com.tencent.tmassistantsdk.e.c.d;
import com.tencent.tmassistantsdk.e.c.e;
import com.tencent.tmassistantsdk.e.c.h;

public final class a
  extends c
{
  private static c a = null;
  private static final Class[] b = { d.class, com.tencent.tmassistantsdk.e.c.f.class, com.tencent.tmassistantsdk.e.c.c.class, h.class, e.class };
  
  private a(Context paramContext, SQLiteDatabase.CursorFactory paramCursorFactory, int paramInt)
  {
    super(paramContext, "tmassistant_sdk.db", null, 1);
  }
  
  public static c a()
  {
    try
    {
      if (a == null)
      {
        localObject1 = com.tencent.tmassistantsdk.f.f.a().b();
        if (localObject1 != null) {
          a = new a((Context)localObject1, null, 1);
        }
      }
      Object localObject1 = a;
      return localObject1;
    }
    finally {}
  }
  
  public final int b()
  {
    return 1;
  }
  
  public final Class[] c()
  {
    return b;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.e.a.a
 * JD-Core Version:    0.7.0.1
 */