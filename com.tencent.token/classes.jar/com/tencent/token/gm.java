package com.tencent.token;

import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.e;

public class gm
{
  private String b = "tbl_safe_msg";
  private boolean c = false;
  
  static
  {
    if (!gm.class.desiredAssertionStatus()) {}
    for (boolean bool = true;; bool = false)
    {
      a = bool;
      return;
    }
  }
  
  public gm(String paramString)
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
      localSafeMsgItem.mContent = "test write msg";
      localSafeMsgItem.mTime = (System.currentTimeMillis() / 1000L);
      for (paramLong = 0L; paramLong < 10L; paramLong += 1L)
      {
        localSafeMsgItem.mId = paramLong;
        localSafeMsgItem.mTitle = ("msg title" + paramLong);
        a(localSafeMsgItem);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final java.util.List a(long paramLong, int paramInt)
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
    //   14: new 91	com/tencent/token/gn
    //   17: dup
    //   18: aload_0
    //   19: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   22: astore 5
    //   24: aload 5
    //   26: aload_0
    //   27: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   30: bipush 13
    //   32: anewarray 96	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: ldc 98
    //   39: aastore
    //   40: dup
    //   41: iconst_1
    //   42: ldc 100
    //   44: aastore
    //   45: dup
    //   46: iconst_2
    //   47: ldc 102
    //   49: aastore
    //   50: dup
    //   51: iconst_3
    //   52: ldc 104
    //   54: aastore
    //   55: dup
    //   56: iconst_4
    //   57: ldc 106
    //   59: aastore
    //   60: dup
    //   61: iconst_5
    //   62: ldc 108
    //   64: aastore
    //   65: dup
    //   66: bipush 6
    //   68: ldc 110
    //   70: aastore
    //   71: dup
    //   72: bipush 7
    //   74: ldc 112
    //   76: aastore
    //   77: dup
    //   78: bipush 8
    //   80: ldc 114
    //   82: aastore
    //   83: dup
    //   84: bipush 9
    //   86: ldc 116
    //   88: aastore
    //   89: dup
    //   90: bipush 10
    //   92: ldc 118
    //   94: aastore
    //   95: dup
    //   96: bipush 11
    //   98: ldc 120
    //   100: aastore
    //   101: dup
    //   102: bipush 12
    //   104: ldc 122
    //   106: aastore
    //   107: ldc 124
    //   109: iconst_1
    //   110: anewarray 96	java/lang/String
    //   113: dup
    //   114: iconst_0
    //   115: lload_1
    //   116: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   119: aastore
    //   120: ldc 130
    //   122: iload_3
    //   123: invokestatic 133	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   126: invokestatic 138	com/tencent/token/gl:a	(Lcom/tencent/token/go;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   129: astore 6
    //   131: aload 6
    //   133: invokeinterface 144 1 0
    //   138: astore 7
    //   140: new 146	java/util/ArrayList
    //   143: dup
    //   144: invokespecial 147	java/util/ArrayList:<init>	()V
    //   147: astore 5
    //   149: aload 7
    //   151: invokeinterface 152 1 0
    //   156: ifeq +114 -> 270
    //   159: aload 7
    //   161: invokeinterface 156 1 0
    //   166: checkcast 91	com/tencent/token/gn
    //   169: astore 8
    //   171: getstatic 19	com/tencent/token/gm:a	Z
    //   174: ifne +57 -> 231
    //   177: aload 8
    //   179: ifnonnull +52 -> 231
    //   182: new 158	java/lang/AssertionError
    //   185: dup
    //   186: invokespecial 159	java/lang/AssertionError:<init>	()V
    //   189: athrow
    //   190: astore 5
    //   192: aload_0
    //   193: monitorexit
    //   194: aload 5
    //   196: athrow
    //   197: astore 5
    //   199: new 66	java/lang/StringBuilder
    //   202: dup
    //   203: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   206: ldc 161
    //   208: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: aload 5
    //   213: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   216: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   219: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   222: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   225: aconst_null
    //   226: astore 5
    //   228: goto -219 -> 9
    //   231: aload 8
    //   233: invokevirtual 169	com/tencent/token/gn:c	()Lcom/tencent/token/core/bean/SafeMsgItem;
    //   236: astore 8
    //   238: getstatic 19	com/tencent/token/gm:a	Z
    //   241: ifne +16 -> 257
    //   244: aload 8
    //   246: ifnonnull +11 -> 257
    //   249: new 158	java/lang/AssertionError
    //   252: dup
    //   253: invokespecial 159	java/lang/AssertionError:<init>	()V
    //   256: athrow
    //   257: aload 5
    //   259: aload 8
    //   261: invokeinterface 173 2 0
    //   266: pop
    //   267: goto -118 -> 149
    //   270: new 66	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   277: ldc 175
    //   279: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload_0
    //   283: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   286: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: ldc 177
    //   291: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: lload_1
    //   295: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   298: ldc 179
    //   300: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: aload 5
    //   305: invokeinterface 183 1 0
    //   310: invokevirtual 186	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   313: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   316: invokestatic 188	com/tencent/token/global/e:b	(Ljava/lang/String;)V
    //   319: aload 6
    //   321: ifnull +13 -> 334
    //   324: aload 6
    //   326: invokeinterface 191 1 0
    //   331: ifeq +15 -> 346
    //   334: aload_0
    //   335: getfield 30	com/tencent/token/gm:c	Z
    //   338: ifeq +8 -> 346
    //   341: aload_0
    //   342: lload_1
    //   343: invokespecial 193	com/tencent/token/gm:e	(J)V
    //   346: aload 5
    //   348: invokeinterface 191 1 0
    //   353: istore 4
    //   355: iload 4
    //   357: ifeq +9 -> 366
    //   360: aconst_null
    //   361: astore 5
    //   363: goto -354 -> 9
    //   366: goto -357 -> 9
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	369	0	this	gm
    //   0	369	1	paramLong	long
    //   0	369	3	paramInt	int
    //   353	3	4	bool	boolean
    //   7	141	5	localObject1	Object
    //   190	5	5	localObject2	Object
    //   197	15	5	localException	Exception
    //   226	136	5	localObject3	Object
    //   129	196	6	localList	java.util.List
    //   138	22	7	localIterator	java.util.Iterator
    //   169	91	8	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   14	24	190	finally
    //   24	131	190	finally
    //   131	149	190	finally
    //   149	177	190	finally
    //   182	190	190	finally
    //   199	225	190	finally
    //   231	244	190	finally
    //   249	257	190	finally
    //   257	267	190	finally
    //   270	319	190	finally
    //   324	334	190	finally
    //   334	346	190	finally
    //   346	355	190	finally
    //   24	131	197	java/lang/Exception
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 91	com/tencent/token/gn
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_0
    //   17: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   20: ldc 124
    //   22: iconst_1
    //   23: anewarray 96	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: lload_1
    //   29: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 197	com/tencent/token/gl:a	(Lcom/tencent/token/go;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: astore 4
    //   43: new 66	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   50: ldc 199
    //   52: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 4
    //   57: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   60: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
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
    //   0	81	0	this	gm
    //   0	81	1	paramLong	long
    //   1	70	3	bool	boolean
    //   12	3	4	localgn	gn
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
  public final boolean a(long paramLong, int paramInt, String paramString)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 5
    //   3: aload_0
    //   4: monitorenter
    //   5: new 91	com/tencent/token/gn
    //   8: dup
    //   9: aload_0
    //   10: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   13: astore 6
    //   15: new 202	android/content/ContentValues
    //   18: dup
    //   19: invokespecial 203	android/content/ContentValues:<init>	()V
    //   22: astore 7
    //   24: aload 7
    //   26: ldc 102
    //   28: iload_3
    //   29: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   32: invokevirtual 212	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   35: aload 7
    //   37: ldc 108
    //   39: aload 4
    //   41: invokevirtual 215	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   44: aload 6
    //   46: aload_0
    //   47: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   50: aload 7
    //   52: ldc 217
    //   54: iconst_1
    //   55: anewarray 96	java/lang/String
    //   58: dup
    //   59: iconst_0
    //   60: lload_1
    //   61: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   64: aastore
    //   65: invokestatic 220	com/tencent/token/gl:a	(Lcom/tencent/token/go;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   68: ifgt +30 -> 98
    //   71: new 66	java/lang/StringBuilder
    //   74: dup
    //   75: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   78: ldc 222
    //   80: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: lload_1
    //   84: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   87: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
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
    //   0	111	0	this	gm
    //   0	111	1	paramLong	long
    //   0	111	3	paramInt	int
    //   0	111	4	paramString	String
    //   1	99	5	bool	boolean
    //   13	32	6	localgn	gn
    //   22	29	7	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   5	93	104	finally
  }
  
  /* Error */
  public final boolean a(SafeMsgItem paramSafeMsgItem)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 91	com/tencent/token/gn
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_1
    //   13: invokevirtual 225	com/tencent/token/gn:a	(Lcom/tencent/token/core/bean/SafeMsgItem;)V
    //   16: aload_3
    //   17: invokestatic 228	com/tencent/token/gl:a	(Lcom/tencent/token/go;)J
    //   20: lconst_0
    //   21: lcmp
    //   22: ifge +34 -> 56
    //   25: new 66	java/lang/StringBuilder
    //   28: dup
    //   29: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   32: ldc 230
    //   34: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: aload_1
    //   38: getfield 40	com/tencent/token/core/bean/SafeMsgItem:mUin	J
    //   41: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   44: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   47: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
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
    //   0	66	0	this	gm
    //   0	66	1	paramSafeMsgItem	SafeMsgItem
    //   51	7	2	bool	boolean
    //   10	7	3	localgn	gn
    // Exception table:
    //   from	to	target	type
    //   2	50	61	finally
  }
  
  /* Error */
  public final boolean b(long paramLong)
  {
    // Byte code:
    //   0: iconst_1
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 91	com/tencent/token/gn
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   12: astore 4
    //   14: aload 4
    //   16: aload_0
    //   17: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   20: ldc 232
    //   22: iconst_1
    //   23: anewarray 96	java/lang/String
    //   26: dup
    //   27: iconst_0
    //   28: lload_1
    //   29: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   32: aastore
    //   33: invokestatic 197	com/tencent/token/gl:a	(Lcom/tencent/token/go;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   36: pop
    //   37: aload_0
    //   38: monitorexit
    //   39: iload_3
    //   40: ireturn
    //   41: astore 4
    //   43: new 66	java/lang/StringBuilder
    //   46: dup
    //   47: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   50: ldc 199
    //   52: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   55: aload 4
    //   57: invokevirtual 162	java/lang/Exception:toString	()Ljava/lang/String;
    //   60: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   63: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   66: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
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
    //   0	81	0	this	gm
    //   0	81	1	paramLong	long
    //   1	70	3	bool	boolean
    //   12	3	4	localgn	gn
    //   41	15	4	localException	Exception
    //   74	5	4	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   14	37	41	java/lang/Exception
    //   4	14	74	finally
    //   14	37	74	finally
    //   43	69	74	finally
  }
  
  public final void c(long paramLong)
  {
    try
    {
      gn localgn = new gn(this);
      try
      {
        if (gl.a(localgn, this.b) >= 500)
        {
          long l = gl.b(localgn, this.b, new String[] { "ftime" }, "fuin = ?", new String[] { String.valueOf(paramLong) }, "ftime asc", String.valueOf(200));
          if (l > 0L) {
            gl.a(localgn, this.b, "fuin = ? and ftime <= ?", new String[] { String.valueOf(paramLong), String.valueOf(l) });
          }
        }
      }
      catch (Exception localException)
      {
        for (;;)
        {
          e.c("SQLiteManager query Exception:" + localException.toString());
        }
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final boolean d(long paramLong)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: aload_0
    //   3: monitorenter
    //   4: new 91	com/tencent/token/gn
    //   7: dup
    //   8: aload_0
    //   9: invokespecial 94	com/tencent/token/gn:<init>	(Lcom/tencent/token/gm;)V
    //   12: astore 4
    //   14: new 202	android/content/ContentValues
    //   17: dup
    //   18: invokespecial 203	android/content/ContentValues:<init>	()V
    //   21: astore 5
    //   23: aload 5
    //   25: ldc 104
    //   27: iconst_1
    //   28: invokestatic 208	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   31: invokevirtual 212	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Integer;)V
    //   34: aload 4
    //   36: aload_0
    //   37: getfield 28	com/tencent/token/gm:b	Ljava/lang/String;
    //   40: aload 5
    //   42: ldc 217
    //   44: iconst_1
    //   45: anewarray 96	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 128	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: invokestatic 220	com/tencent/token/gl:a	(Lcom/tencent/token/go;Ljava/lang/String;Landroid/content/ContentValues;Ljava/lang/String;[Ljava/lang/String;)I
    //   58: ifgt +29 -> 87
    //   61: new 66	java/lang/StringBuilder
    //   64: dup
    //   65: invokespecial 67	java/lang/StringBuilder:<init>	()V
    //   68: ldc 245
    //   70: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: lload_1
    //   74: invokevirtual 76	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   77: invokevirtual 80	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   80: invokestatic 166	com/tencent/token/global/e:c	(Ljava/lang/String;)V
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
    //   0	99	0	this	gm
    //   0	99	1	paramLong	long
    //   1	88	3	bool	boolean
    //   12	23	4	localgn	gn
    //   92	5	4	localObject	Object
    //   21	20	5	localContentValues	android.content.ContentValues
    // Exception table:
    //   from	to	target	type
    //   4	83	92	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gm
 * JD-Core Version:    0.7.0.1
 */