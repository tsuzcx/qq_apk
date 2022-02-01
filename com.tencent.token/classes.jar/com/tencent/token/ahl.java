package com.tencent.token;

import com.tencent.wcdb.support.Log;
import java.io.File;

public final class ahl
  implements ahj
{
  private static final String[] b = { "", "-journal", "-wal", ".sm", ".bak", "-vfslog", "-vfslo1" };
  private final boolean a;
  
  public ahl()
  {
    this.a = false;
  }
  
  public ahl(byte paramByte)
  {
    this.a = true;
  }
  
  private void a(String paramString)
  {
    if (!paramString.equalsIgnoreCase(":memory:"))
    {
      if (paramString.trim().length() == 0) {
        return;
      }
      Log.a("WCDB.DefaultDatabaseErrorHandler", "Remove database file: ".concat(String.valueOf(paramString)));
      boolean bool = this.a;
      int j = 0;
      int i = 0;
      Object localObject2;
      Object localObject3;
      if (!bool)
      {
        localObject1 = new File(paramString);
        localObject2 = new File(((File)localObject1).getParentFile(), "corrupted");
        if (!((File)localObject2).mkdirs()) {
          Log.a("WCDB.DefaultDatabaseErrorHandler", "Could not create directory for corrupted database. Corruption backup may be unavailable.");
        }
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(((File)localObject2).getPath());
        ((StringBuilder)localObject3).append("/");
        ((StringBuilder)localObject3).append(((File)localObject1).getName());
        localObject1 = ((StringBuilder)localObject3).toString();
        localObject2 = b;
        j = localObject2.length;
        while (i < j)
        {
          localObject3 = localObject2[i];
          Object localObject4 = new StringBuilder();
          ((StringBuilder)localObject4).append(paramString);
          ((StringBuilder)localObject4).append((String)localObject3);
          localObject4 = ((StringBuilder)localObject4).toString();
          StringBuilder localStringBuilder = new StringBuilder();
          localStringBuilder.append((String)localObject1);
          localStringBuilder.append((String)localObject3);
          localObject3 = localStringBuilder.toString();
          localObject4 = new File((String)localObject4);
          if (!((File)localObject4).renameTo(new File((String)localObject3))) {
            ((File)localObject4).delete();
          }
          i += 1;
        }
        return;
      }
      Object localObject1 = b;
      int k = localObject1.length;
      i = j;
      while (i < k)
      {
        localObject2 = localObject1[i];
        localObject3 = new StringBuilder();
        ((StringBuilder)localObject3).append(paramString);
        ((StringBuilder)localObject3).append((String)localObject2);
        new File(((StringBuilder)localObject3).toString()).delete();
        i += 1;
      }
      return;
    }
  }
  
  /* Error */
  public final void a(com.tencent.wcdb.database.SQLiteDatabase paramSQLiteDatabase)
  {
    // Byte code:
    //   0: new 90	java/lang/StringBuilder
    //   3: dup
    //   4: ldc 118
    //   6: invokespecial 119	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   9: astore_2
    //   10: aload_2
    //   11: aload_1
    //   12: invokevirtual 124	com/tencent/wcdb/database/SQLiteDatabase:o	()Ljava/lang/String;
    //   15: invokevirtual 98	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   18: pop
    //   19: ldc 54
    //   21: aload_2
    //   22: invokevirtual 106	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 69	com/tencent/wcdb/support/Log:a	(Ljava/lang/String;Ljava/lang/String;)V
    //   28: aload_1
    //   29: invokevirtual 127	com/tencent/wcdb/database/SQLiteDatabase:n	()Z
    //   32: ifne +12 -> 44
    //   35: aload_0
    //   36: aload_1
    //   37: invokevirtual 124	com/tencent/wcdb/database/SQLiteDatabase:o	()Ljava/lang/String;
    //   40: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   43: return
    //   44: aconst_null
    //   45: astore_2
    //   46: aload_1
    //   47: invokevirtual 133	com/tencent/wcdb/database/SQLiteDatabase:q	()Ljava/util/List;
    //   50: astore_3
    //   51: aload_3
    //   52: astore_2
    //   53: aload_1
    //   54: invokevirtual 137	com/tencent/wcdb/database/SQLiteDatabase:p	()Lcom/tencent/token/aic;
    //   57: pop
    //   58: aload_1
    //   59: invokevirtual 140	com/tencent/wcdb/database/SQLiteDatabase:close	()V
    //   62: aload_2
    //   63: ifnull +42 -> 105
    //   66: aload_2
    //   67: invokeinterface 146 1 0
    //   72: astore_1
    //   73: aload_1
    //   74: invokeinterface 151 1 0
    //   79: ifeq +25 -> 104
    //   82: aload_0
    //   83: aload_1
    //   84: invokeinterface 155 1 0
    //   89: checkcast 157	android/util/Pair
    //   92: getfield 161	android/util/Pair:second	Ljava/lang/Object;
    //   95: checkcast 14	java/lang/String
    //   98: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   101: goto -28 -> 73
    //   104: return
    //   105: aload_0
    //   106: aload_1
    //   107: invokevirtual 124	com/tencent/wcdb/database/SQLiteDatabase:o	()Ljava/lang/String;
    //   110: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   113: return
    //   114: astore_3
    //   115: aload_2
    //   116: ifnull +41 -> 157
    //   119: aload_2
    //   120: invokeinterface 146 1 0
    //   125: astore_1
    //   126: aload_1
    //   127: invokeinterface 151 1 0
    //   132: ifeq +33 -> 165
    //   135: aload_0
    //   136: aload_1
    //   137: invokeinterface 155 1 0
    //   142: checkcast 157	android/util/Pair
    //   145: getfield 161	android/util/Pair:second	Ljava/lang/Object;
    //   148: checkcast 14	java/lang/String
    //   151: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   154: goto -28 -> 126
    //   157: aload_0
    //   158: aload_1
    //   159: invokevirtual 124	com/tencent/wcdb/database/SQLiteDatabase:o	()Ljava/lang/String;
    //   162: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   165: aload_3
    //   166: athrow
    //   167: aload_2
    //   168: ifnull -63 -> 105
    //   171: aload_2
    //   172: invokeinterface 146 1 0
    //   177: astore_1
    //   178: aload_1
    //   179: invokeinterface 151 1 0
    //   184: ifeq +25 -> 209
    //   187: aload_0
    //   188: aload_1
    //   189: invokeinterface 155 1 0
    //   194: checkcast 157	android/util/Pair
    //   197: getfield 161	android/util/Pair:second	Ljava/lang/Object;
    //   200: checkcast 14	java/lang/String
    //   203: invokespecial 129	com/tencent/token/ahl:a	(Ljava/lang/String;)V
    //   206: goto -28 -> 178
    //   209: return
    //   210: astore_3
    //   211: goto -158 -> 53
    //   214: astore_3
    //   215: goto -48 -> 167
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	218	0	this	ahl
    //   0	218	1	paramSQLiteDatabase	com.tencent.wcdb.database.SQLiteDatabase
    //   9	163	2	localObject1	Object
    //   50	2	3	localList	java.util.List
    //   114	52	3	localObject2	Object
    //   210	1	3	localSQLiteException1	com.tencent.wcdb.database.SQLiteException
    //   214	1	3	localSQLiteException2	com.tencent.wcdb.database.SQLiteException
    // Exception table:
    //   from	to	target	type
    //   58	62	114	finally
    //   46	51	210	com/tencent/wcdb/database/SQLiteException
    //   58	62	214	com/tencent/wcdb/database/SQLiteException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ahl
 * JD-Core Version:    0.7.0.1
 */