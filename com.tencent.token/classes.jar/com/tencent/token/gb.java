package com.tencent.token;

import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.h;

public class gb
{
  private String b = "tbl_safe_msg";
  private boolean c = false;
  
  static
  {
    if (!gb.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public gb(String paramString)
  {
    if (paramString == null) {
      return;
    }
    this.b = paramString;
  }
  
  private void e(long paramLong)
  {
    try
    {
      SafeMsgItem localSafeMsgItem = new SafeMsgItem();
      localSafeMsgItem.mUin = paramLong;
      localSafeMsgItem.mIsRead = false;
      localSafeMsgItem.b("test write msg");
      localSafeMsgItem.b(System.currentTimeMillis() / 1000L);
      for (paramLong = 0L; paramLong < 10L; paramLong += 1L)
      {
        localSafeMsgItem.a(paramLong);
        localSafeMsgItem.a("msg title" + paramLong);
        a(localSafeMsgItem);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public java.util.List a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifgt +11 -> 14
    //   6: aconst_null
    //   7: astore 5
    //   9: aload_0
    //   10: monitorexit
    //   11: aload 5
    //   13: areturn
    //   14: new 87	com/tencent/token/gc
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   22: astore 5
    //   24: aload 5
    //   26: aload_0
    //   27: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   30: bipush 13
    //   32: anewarray 92	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 94
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc 96
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc 98
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: ldc 100
    //   54: aastore
    //   55: dup
    //   56: iconst_4
    //   57: ldc 102
    //   59: aastore
    //   60: dup
    //   61: iconst_5
    //   62: ldc 104
    //   64: aastore
    //   65: dup
    //   66: bipush 6
    //   68: ldc 106
    //   70: aastore
    //   71: dup
    //   72: bipush 7
    //   74: ldc 108
    //   76: aastore
    //   77: dup
    //   78: bipush 8
    //   80: ldc 110
    //   82: aastore
    //   83: dup
    //   84: bipush 9
    //   86: ldc 112
    //   88: aastore
    //   89: dup
    //   90: bipush 10
    //   92: ldc 114
    //   94: aastore
    //   95: dup
    //   96: bipush 11
    //   98: ldc 116
    //   100: aastore
    //   101: dup
    //   102: bipush 12
    //   104: ldc 118
    //   106: aastore
    //   107: ldc 120
    //   109: iconst_1
    //   110: anewarray 92	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: lload_1
    //   116: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   119: aastore
    //   120: aconst_null
    //   121: aconst_null
    //   122: ldc 126
    //   124: iload_3
    //   125: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   128: invokestatic 134	com/tencent/token/ga:a	(Lcom/tencent/token/gd;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   131: astore 6
    //   133: aload 6
    //   135: invokeinterface 140 1 0
    //   140: astore 7
    //   142: new 142	java/util/ArrayList
    //   145: dup
    //   146: invokespecial 143	java/util/ArrayList:<init>	()V
    //   149: astore 5
    //   151: aload 7
    //   153: invokeinterface 148 1 0
    //   158: ifeq +114 -> 272
    //   161: aload 7
    //   163: invokeinterface 152 1 0
    //   168: checkcast 87	com/tencent/token/gc
    //   171: astore 8
    //   173: getstatic 19	com/tencent/token/gb:a	Z
    //   176: ifne +57 -> 233
    //   179: aload 8
    //   181: ifnonnull +52 -> 233
    //   184: new 154	java/lang/AssertionError
    //   187: dup
    //   188: invokespecial 155	java/lang/AssertionError:<init>	()V
    //   191: athrow
    //   192: astore 5
    //   194: aload_0
    //   195: monitorexit
    //   196: aload 5
    //   198: athrow
    //   199: astore 5
    //   201: new 63	java/lang/StringBuilder
    //   204: dup
    //   205: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   208: ldc 157
    //   210: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   213: aload 5
    //   215: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   218: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   224: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   227: aconst_null
    //   228: astore 5
    //   230: goto -221 -> 9
    //   233: aload 8
    //   235: invokevirtual 165	com/tencent/token/gc:a	()Lcom/tencent/token/core/bean/SafeMsgItem;
    //   238: astore 8
    //   240: getstatic 19	com/tencent/token/gb:a	Z
    //   243: ifne +16 -> 259
    //   246: aload 8
    //   248: ifnonnull +11 -> 259
    //   251: new 154	java/lang/AssertionError
    //   254: dup
    //   255: invokespecial 155	java/lang/AssertionError:<init>	()V
    //   258: athrow
    //   259: aload 5
    //   261: aload 8
    //   263: invokeinterface 169 2 0
    //   268: pop
    //   269: goto -118 -> 151
    //   272: new 63	java/lang/StringBuilder
    //   275: dup
    //   276: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   279: ldc 171
    //   281: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: aload_0
    //   285: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   288: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   291: ldc 173
    //   293: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   296: lload_1
    //   297: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   300: ldc 175
    //   302: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   305: aload 5
    //   307: invokeinterface 179 1 0
    //   312: invokevirtual 182	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   315: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   318: invokestatic 183	com/tencent/token/global/h:b	(Ljava/lang/String;)V
    //   321: aload 6
    //   323: ifnull +13 -> 336
    //   326: aload 6
    //   328: invokeinterface 186 1 0
    //   333: ifeq +15 -> 348
    //   336: aload_0
    //   337: getfield 30	com/tencent/token/gb:c	Z
    //   340: ifeq +8 -> 348
    //   343: aload_0
    //   344: lload_1
    //   345: invokespecial 188	com/tencent/token/gb:e	(J)V
    //   348: aload 5
    //   350: invokeinterface 186 1 0
    //   355: istore 4
    //   357: iload 4
    //   359: ifeq +9 -> 368
    //   362: aconst_null
    //   363: astore 5
    //   365: goto -356 -> 9
    //   368: goto -359 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	371	0	this	gb
    //   0	371	1	paramLong	long
    //   0	371	3	paramInt	int
    //   355	3	4	bool	boolean
    //   7	143	5	localObject1	Object
    //   192	5	5	localObject2	Object
    //   199	15	5	localException	Exception
    //   228	136	5	localObject3	Object
    //   131	196	6	localList	java.util.List
    //   140	22	7	localIterator	java.util.Iterator
    //   171	91	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	192	finally
    //   24	133	192	finally
    //   133	151	192	finally
    //   151	179	192	finally
    //   184	192	192	finally
    //   201	227	192	finally
    //   233	246	192	finally
    //   251	259	192	finally
    //   259	269	192	finally
    //   272	321	192	finally
    //   326	336	192	finally
    //   336	348	192	finally
    //   348	357	192	finally
    //   24	133	199	java/lang/Exception
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 87	com/tencent/token/gc
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_0
    //   17: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   20: ldc 120
    //   22: iconst_1
    //   23: anewarray 92	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: lload_1
    //   29: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 192	com/tencent/token/ga:a	(Lcom/tencent/token/gd;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: astore 4
    //   43: new 63	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   50: ldc 194
    //   52: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 4
    //   57: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   60: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   69: iconst_0
    //   70: istore_3
    //   71: goto -34 -> 37
    //   74: astore 4
    //   76: aload_0
    //   77: monitorexit
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	gb
    //   0	81	1	paramLong	long
    //   1	70	3	bool	boolean
    //   12	3	4	localgc	gc
    //   41	15	4	localException	Exception
    //   74	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	41	java/lang/Exception
    //   4	14	74	finally
    //   14	37	74	finally
    //   43	69	74	finally
  }
  
  /* Error */
  public boolean a(long paramLong, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: new 87	com/tencent/token/gc
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   13: astore 6
    //   15: new 197	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 198	android/content/ContentValues:<init>	()V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 98
    //   28: iload_3
    //   29: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokevirtual 207	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   35: aload 7
    //   37: ldc 104
    //   39: aload 4
    //   41: invokevirtual 210	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 6
    //   46: aload_0
    //   47: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   50: aload 7
    //   52: ldc 212
    //   54: iconst_1
    //   55: anewarray 92	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: lload_1
    //   61: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 215	com/tencent/token/ga:a	(Lcom/tencent/token/gd;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   68: ifgt +30 -> 98
    //   71: new 63	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   78: ldc 217
    //   80: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload_1
    //   84: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   93: aload_0
    //   94: monitorexit
    //   95: iload 5
    //   97: ireturn
    //   98: iconst_1
    //   99: istore 5
    //   101: goto -8 -> 93
    //   104: astore 4
    //   106: aload_0
    //   107: monitorexit
    //   108: aload 4
    //   110: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	111	0	this	gb
    //   0	111	1	paramLong	long
    //   0	111	3	paramInt	int
    //   0	111	4	paramString	String
    //   1	99	5	bool	boolean
    //   13	32	6	localgc	gc
    //   22	29	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	93	104	finally
  }
  
  /* Error */
  public boolean a(SafeMsgItem paramSafeMsgItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 87	com/tencent/token/gc
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokevirtual 220	com/tencent/token/gc:a	(Lcom/tencent/token/core/bean/SafeMsgItem;)V
    //   16: aload_3
    //   17: invokestatic 223	com/tencent/token/ga:b	(Lcom/tencent/token/gd;)J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifge +34 -> 56
    //   25: new 63	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   32: ldc 225
    //   34: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: getfield 40	com/tencent/token/core/bean/SafeMsgItem:mUin	J
    //   41: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   50: iconst_0
    //   51: istore_2
    //   52: aload_0
    //   53: monitorexit
    //   54: iload_2
    //   55: ireturn
    //   56: iconst_1
    //   57: istore_2
    //   58: goto -6 -> 52
    //   61: astore_1
    //   62: aload_0
    //   63: monitorexit
    //   64: aload_1
    //   65: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	66	0	this	gb
    //   0	66	1	paramSafeMsgItem	SafeMsgItem
    //   51	7	2	bool	boolean
    //   10	7	3	localgc	gc
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
  }
  
  /* Error */
  public boolean b(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 87	com/tencent/token/gc
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_0
    //   17: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   20: ldc 227
    //   22: iconst_1
    //   23: anewarray 92	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: lload_1
    //   29: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 192	com/tencent/token/ga:a	(Lcom/tencent/token/gd;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: astore 4
    //   43: new 63	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   50: ldc 194
    //   52: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 4
    //   57: invokevirtual 158	java/lang/Exception:toString	()Ljava/lang/String;
    //   60: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   69: iconst_0
    //   70: istore_3
    //   71: goto -34 -> 37
    //   74: astore 4
    //   76: aload_0
    //   77: monitorexit
    //   78: aload 4
    //   80: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	81	0	this	gb
    //   0	81	1	paramLong	long
    //   1	70	3	bool	boolean
    //   12	3	4	localgc	gc
    //   41	15	4	localException	Exception
    //   74	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	41	java/lang/Exception
    //   4	14	74	finally
    //   14	37	74	finally
    //   43	69	74	finally
  }
  
  public void c(long paramLong)
  {
    try
    {
      gc localgc = new gc(this);
      try
      {
        if (ga.a(localgc, this.b) >= 500)
        {
          long l = ga.a(localgc, this.b, new String[] { "ftime" }, "fuin = ?", new String[] { String.valueOf(paramLong) }, null, null, "ftime asc", String.valueOf(200), false);
          if (l > 0L) {
            ga.a(localgc, this.b, "fuin = ? and ftime <= ?", new String[] { String.valueOf(paramLong), String.valueOf(l) });
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          h.c("SQLiteManager query Exception:" + localException.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public boolean d(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 87	com/tencent/token/gc
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 90	com/tencent/token/gc:<init>	(Lcom/tencent/token/gb;)V
    //   12: astore 4
    //   14: new 197	android/content/ContentValues
    //   17: dup
    //   18: invokespecial 198	android/content/ContentValues:<init>	()V
    //   21: astore 5
    //   23: aload 5
    //   25: ldc 100
    //   27: iconst_1
    //   28: invokestatic 203	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: invokevirtual 207	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   34: aload 4
    //   36: aload_0
    //   37: getfield 28	com/tencent/token/gb:b	Ljava/lang/String;
    //   40: aload 5
    //   42: ldc 212
    //   44: iconst_1
    //   45: anewarray 92	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 215	com/tencent/token/ga:a	(Lcom/tencent/token/gd;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifgt +29 -> 87
    //   61: new 63	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   68: ldc 240
    //   70: invokevirtual 70	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokevirtual 73	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: invokevirtual 77	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 162	com/tencent/token/global/h:c	(Ljava/lang/String;)V
    //   83: aload_0
    //   84: monitorexit
    //   85: iload_3
    //   86: ireturn
    //   87: iconst_1
    //   88: istore_3
    //   89: goto -6 -> 83
    //   92: astore 4
    //   94: aload_0
    //   95: monitorexit
    //   96: aload 4
    //   98: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	99	0	this	gb
    //   0	99	1	paramLong	long
    //   1	88	3	bool	boolean
    //   12	23	4	localgc	gc
    //   92	5	4	localObject	Object
    //   21	20	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   4	83	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gb
 * JD-Core Version:    0.7.0.1
 */