package com.tencent.token;

import com.tencent.wcdb.database.SQLiteDatabase;

public final class ahx
  extends ahw
{
  private final aie g;
  
  ahx(SQLiteDatabase paramSQLiteDatabase, String paramString, Object[] paramArrayOfObject, aie paramaie)
  {
    super(paramSQLiteDatabase, paramString, paramArrayOfObject, paramaie);
    this.g = paramaie;
  }
  
  /* Error */
  final int a(com.tencent.wcdb.CursorWindow paramCursorWindow, int paramInt1, int paramInt2, boolean paramBoolean)
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 23	com/tencent/token/ahx:d	()V
    //   4: aload_1
    //   5: invokevirtual 26	com/tencent/wcdb/CursorWindow:d	()V
    //   8: aload_0
    //   9: getfield 29	com/tencent/token/ahw:a	Lcom/tencent/wcdb/database/SQLiteDatabase;
    //   12: invokevirtual 35	com/tencent/wcdb/database/SQLiteDatabase:b	()Lcom/tencent/token/ahz;
    //   15: aload_0
    //   16: getfield 38	com/tencent/token/ahw:b	Ljava/lang/String;
    //   19: aload_0
    //   20: getfield 42	com/tencent/token/ahw:e	[Ljava/lang/Object;
    //   23: aload_1
    //   24: iload_2
    //   25: iload_3
    //   26: iload 4
    //   28: aload_0
    //   29: getfield 46	com/tencent/token/ahw:c	Z
    //   32: invokestatic 49	com/tencent/wcdb/database/SQLiteDatabase:a	(Z)I
    //   35: aload_0
    //   36: getfield 12	com/tencent/token/ahx:g	Lcom/tencent/token/aie;
    //   39: invokevirtual 54	com/tencent/token/ahz:a	(Ljava/lang/String;[Ljava/lang/Object;Lcom/tencent/wcdb/CursorWindow;IIZILcom/tencent/token/aie;)I
    //   42: istore_2
    //   43: aload_1
    //   44: invokevirtual 56	com/tencent/wcdb/CursorWindow:e	()V
    //   47: aload_0
    //   48: invokevirtual 57	com/tencent/token/ahx:e	()V
    //   51: iload_2
    //   52: ireturn
    //   53: astore 5
    //   55: goto +67 -> 122
    //   58: astore 5
    //   60: new 59	java/lang/StringBuilder
    //   63: dup
    //   64: ldc 61
    //   66: invokespecial 64	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   69: astore 6
    //   71: aload 6
    //   73: aload 5
    //   75: invokevirtual 68	com/tencent/wcdb/database/SQLiteException:getMessage	()Ljava/lang/String;
    //   78: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   81: pop
    //   82: aload 6
    //   84: ldc 74
    //   86: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: pop
    //   90: aload 6
    //   92: aload_0
    //   93: getfield 38	com/tencent/token/ahw:b	Ljava/lang/String;
    //   96: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: pop
    //   100: ldc 76
    //   102: aload 6
    //   104: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   107: invokestatic 84	com/tencent/wcdb/support/Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   110: aload 5
    //   112: athrow
    //   113: astore 5
    //   115: aload_0
    //   116: invokevirtual 86	com/tencent/token/ahx:a	()V
    //   119: aload 5
    //   121: athrow
    //   122: aload_1
    //   123: invokevirtual 56	com/tencent/wcdb/CursorWindow:e	()V
    //   126: aload 5
    //   128: athrow
    //   129: astore_1
    //   130: aload_0
    //   131: invokevirtual 57	com/tencent/token/ahx:e	()V
    //   134: aload_1
    //   135: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	136	0	this	ahx
    //   0	136	1	paramCursorWindow	com.tencent.wcdb.CursorWindow
    //   0	136	2	paramInt1	int
    //   0	136	3	paramInt2	int
    //   0	136	4	paramBoolean	boolean
    //   53	1	5	localObject	Object
    //   58	53	5	localSQLiteException	com.tencent.wcdb.database.SQLiteException
    //   113	14	5	localSQLiteDatabaseCorruptException	com.tencent.wcdb.database.SQLiteDatabaseCorruptException
    //   69	34	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   8	43	53	finally
    //   60	113	53	finally
    //   115	122	53	finally
    //   8	43	58	com/tencent/wcdb/database/SQLiteException
    //   8	43	113	com/tencent/wcdb/database/SQLiteDatabaseCorruptException
    //   4	8	129	finally
    //   43	47	129	finally
    //   122	129	129	finally
  }
  
  public final String toString()
  {
    StringBuilder localStringBuilder = new StringBuilder("SQLiteQuery: ");
    localStringBuilder.append(this.b);
    return localStringBuilder.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahx
 * JD-Core Version:    0.7.0.1
 */