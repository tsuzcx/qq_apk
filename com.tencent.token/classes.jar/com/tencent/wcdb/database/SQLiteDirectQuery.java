package com.tencent.wcdb.database;

import com.tencent.token.aiw;
import com.tencent.token.aje;
import java.lang.ref.WeakReference;

public class SQLiteDirectQuery
  extends aiw
{
  private static final int[] h = { 3, 1, 2, 3, 4, 0 };
  private final aje g;
  
  private static native byte[] nativeGetBlob(long paramLong, int paramInt);
  
  private static native double nativeGetDouble(long paramLong, int paramInt);
  
  private static native long nativeGetLong(long paramLong, int paramInt);
  
  private static native String nativeGetString(long paramLong, int paramInt);
  
  private static native int nativeGetType(long paramLong, int paramInt);
  
  private static native int nativeStep(long paramLong, int paramInt);
  
  public final void c()
  {
    try
    {
      if (this.f != null)
      {
        Object localObject3 = this.f;
        Object localObject1 = this.g;
        localObject3 = (SQLiteConnection)((SQLiteConnection.c)localObject3).a.get();
        if (localObject3 != null) {
          SQLiteConnection.a((SQLiteConnection)localObject3, (aje)localObject1);
        }
        localObject1 = this.f;
        if (((SQLiteConnection.c)localObject1).j != null)
        {
          localObject3 = (SQLiteConnection)((SQLiteConnection.c)localObject1).a.get();
          if (localObject3 != null)
          {
            if (SQLiteConnection.a((SQLiteConnection)localObject3).b(((SQLiteConnection.c)localObject1).j.h)) {
              SQLiteConnection.a((SQLiteConnection)localObject3).a(((SQLiteConnection.c)localObject1).j.h, null);
            }
            ((SQLiteConnection.c)localObject1).j = null;
          }
        }
      }
      super.c();
      return;
    }
    finally {}
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.wcdb.database.SQLiteDirectQuery
 * JD-Core Version:    0.7.0.1
 */