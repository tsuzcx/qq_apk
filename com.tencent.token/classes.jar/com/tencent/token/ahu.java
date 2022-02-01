package com.tencent.token;

import com.tencent.wcdb.database.SQLiteDatabase;
import com.tencent.wcdb.database.SQLiteDatabase.a;

public final class ahu
  implements ahs
{
  private static SQLiteDatabase.a f = ahr.j;
  private final SQLiteDatabase a;
  private final String b;
  private final String c;
  private final aie d;
  private ahw e;
  
  public ahu(SQLiteDatabase paramSQLiteDatabase, String paramString1, String paramString2)
  {
    this.a = paramSQLiteDatabase;
    this.b = paramString2;
    this.c = paramString1;
    this.d = null;
  }
  
  public final ahi a(SQLiteDatabase.a parama, String[] paramArrayOfString)
  {
    Object localObject = parama;
    if (parama == null) {
      localObject = f;
    }
    parama = null;
    try
    {
      paramArrayOfString = ((SQLiteDatabase.a)localObject).a(this.a, this.c, paramArrayOfString, this.d);
      parama = paramArrayOfString;
      localObject = ((SQLiteDatabase.a)localObject).a(this, this.b, paramArrayOfString);
      this.e = paramArrayOfString;
      return localObject;
    }
    catch (RuntimeException paramArrayOfString)
    {
      if (parama != null) {
        parama.close();
      }
      throw paramArrayOfString;
    }
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SQLiteDirectCursorDriver: ");
    localStringBuilder.append(this.c);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahu
 * JD-Core Version:    0.7.0.1
 */