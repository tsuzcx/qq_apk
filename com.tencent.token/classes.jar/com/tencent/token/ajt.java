package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.wcdb.database.SQLiteDatabase;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class ajt
{
  private String b = "tbl_safe_msg";
  private boolean c = false;
  
  public ajt(String paramString)
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
        localSafeMsgItem.mTitle = "msg title".concat(String.valueOf(paramLong));
        a(localSafeMsgItem);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public final java.util.List<SafeMsgItem> a(long paramLong, int paramInt)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: iload_3
    //   3: ifgt +7 -> 10
    //   6: aload_0
    //   7: monitorexit
    //   8: aconst_null
    //   9: areturn
    //   10: new 6	com/tencent/token/ajt$a
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 90	com/tencent/token/ajt$a:<init>	(Lcom/tencent/token/ajt;)V
    //   18: astore 5
    //   20: aload 5
    //   22: aload_0
    //   23: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   26: bipush 13
    //   28: anewarray 70	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 92
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 94
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 96
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 98
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 100
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 102
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 104
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 106
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 108
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 110
    //   84: aastore
    //   85: dup
    //   86: bipush 10
    //   88: ldc 112
    //   90: aastore
    //   91: dup
    //   92: bipush 11
    //   94: ldc 114
    //   96: aastore
    //   97: dup
    //   98: bipush 12
    //   100: ldc 116
    //   102: aastore
    //   103: ldc 118
    //   105: iconst_1
    //   106: anewarray 70	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: lload_1
    //   112: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   115: aastore
    //   116: ldc 120
    //   118: iload_3
    //   119: invokestatic 123	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   122: invokestatic 128	com/tencent/token/ajs:a	(Lcom/tencent/token/aju;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   125: astore 5
    //   127: aload 5
    //   129: invokeinterface 134 1 0
    //   134: astore 7
    //   136: new 136	java/util/ArrayList
    //   139: dup
    //   140: invokespecial 137	java/util/ArrayList:<init>	()V
    //   143: astore 6
    //   145: aload 7
    //   147: invokeinterface 142 1 0
    //   152: ifeq +79 -> 231
    //   155: aload 7
    //   157: invokeinterface 146 1 0
    //   162: checkcast 6	com/tencent/token/ajt$a
    //   165: astore 8
    //   167: getstatic 21	com/tencent/token/ajt:a	Z
    //   170: ifne +19 -> 189
    //   173: aload 8
    //   175: ifnull +6 -> 181
    //   178: goto +11 -> 189
    //   181: new 148	java/lang/AssertionError
    //   184: dup
    //   185: invokespecial 149	java/lang/AssertionError:<init>	()V
    //   188: athrow
    //   189: aload 8
    //   191: invokevirtual 152	com/tencent/token/ajt$a:c	()Lcom/tencent/token/core/bean/SafeMsgItem;
    //   194: astore 8
    //   196: getstatic 21	com/tencent/token/ajt:a	Z
    //   199: ifne +19 -> 218
    //   202: aload 8
    //   204: ifnull +6 -> 210
    //   207: goto +11 -> 218
    //   210: new 148	java/lang/AssertionError
    //   213: dup
    //   214: invokespecial 149	java/lang/AssertionError:<init>	()V
    //   217: athrow
    //   218: aload 6
    //   220: aload 8
    //   222: invokeinterface 156 2 0
    //   227: pop
    //   228: goto -83 -> 145
    //   231: new 158	java/lang/StringBuilder
    //   234: dup
    //   235: ldc 160
    //   237: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   240: astore 7
    //   242: aload 7
    //   244: aload_0
    //   245: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   248: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   251: pop
    //   252: aload 7
    //   254: ldc 168
    //   256: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 7
    //   262: lload_1
    //   263: invokevirtual 171	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   266: pop
    //   267: aload 7
    //   269: ldc 173
    //   271: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 7
    //   277: aload 6
    //   279: invokeinterface 177 1 0
    //   284: invokevirtual 180	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   287: pop
    //   288: aload 7
    //   290: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   293: invokestatic 188	com/tencent/token/xv:b	(Ljava/lang/String;)V
    //   296: aload 5
    //   298: invokeinterface 191 1 0
    //   303: ifeq +15 -> 318
    //   306: aload_0
    //   307: getfield 32	com/tencent/token/ajt:c	Z
    //   310: ifeq +8 -> 318
    //   313: aload_0
    //   314: lload_1
    //   315: invokespecial 193	com/tencent/token/ajt:e	(J)V
    //   318: aload 6
    //   320: invokeinterface 191 1 0
    //   325: istore 4
    //   327: iload 4
    //   329: ifeq +7 -> 336
    //   332: aload_0
    //   333: monitorexit
    //   334: aconst_null
    //   335: areturn
    //   336: aload_0
    //   337: monitorexit
    //   338: aload 6
    //   340: areturn
    //   341: astore 5
    //   343: new 158	java/lang/StringBuilder
    //   346: dup
    //   347: ldc 195
    //   349: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   352: astore 6
    //   354: aload 6
    //   356: aload 5
    //   358: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   361: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: pop
    //   365: aload 6
    //   367: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 198	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   373: aload_0
    //   374: monitorexit
    //   375: aconst_null
    //   376: areturn
    //   377: astore 5
    //   379: aload_0
    //   380: monitorexit
    //   381: aload 5
    //   383: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	384	0	this	ajt
    //   0	384	1	paramLong	long
    //   0	384	3	paramInt	int
    //   325	3	4	bool	boolean
    //   18	279	5	localObject1	Object
    //   341	16	5	localException	java.lang.Exception
    //   377	5	5	localObject2	Object
    //   143	223	6	localObject3	Object
    //   134	155	7	localObject4	Object
    //   165	56	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	127	341	java/lang/Exception
    //   10	20	377	finally
    //   20	127	377	finally
    //   127	145	377	finally
    //   145	173	377	finally
    //   181	189	377	finally
    //   189	202	377	finally
    //   210	218	377	finally
    //   218	228	377	finally
    //   231	318	377	finally
    //   318	327	377	finally
    //   343	373	377	finally
  }
  
  /* Error */
  public final boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 6	com/tencent/token/ajt$a
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/ajt$a:<init>	(Lcom/tencent/token/ajt;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   16: ldc 118
    //   18: iconst_1
    //   19: anewarray 70	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokestatic 204	com/tencent/token/ajs:a	(Lcom/tencent/token/aju;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_1
    //   36: ireturn
    //   37: astore_3
    //   38: new 158	java/lang/StringBuilder
    //   41: dup
    //   42: ldc 206
    //   44: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   47: astore 4
    //   49: aload 4
    //   51: aload_3
    //   52: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   55: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   58: pop
    //   59: aload 4
    //   61: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokestatic 198	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   67: aload_0
    //   68: monitorexit
    //   69: iconst_0
    //   70: ireturn
    //   71: astore_3
    //   72: aload_0
    //   73: monitorexit
    //   74: aload_3
    //   75: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	76	0	this	ajt
    //   0	76	1	paramLong	long
    //   10	2	3	locala	a
    //   37	15	3	localException	java.lang.Exception
    //   71	4	3	localObject	Object
    //   47	13	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	33	37	java/lang/Exception
    //   2	11	71	finally
    //   11	33	71	finally
    //   38	67	71	finally
  }
  
  public final boolean a(long paramLong, int paramInt, String paramString)
  {
    try
    {
      a locala = new a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("flag", Integer.valueOf(paramInt));
      localContentValues.put("fcontent", paramString);
      if (ajs.a(locala, this.b, localContentValues, "fid=?", new String[] { String.valueOf(paramLong) }) <= 0)
      {
        xv.c("update msg flag failed, id=".concat(String.valueOf(paramLong)));
        return false;
      }
      return true;
    }
    finally
    {
      paramString = finally;
      throw paramString;
    }
  }
  
  public final boolean a(SafeMsgItem paramSafeMsgItem)
  {
    for (;;)
    {
      try
      {
        Object localObject = new a();
        ((a)localObject).a = paramSafeMsgItem.mUin;
        ((a)localObject).b = paramSafeMsgItem.mFlag;
        if (paramSafeMsgItem.mIsRead)
        {
          i = 1;
          ((a)localObject).c = i;
          ((a)localObject).d = paramSafeMsgItem.mTitle;
          ((a)localObject).e = paramSafeMsgItem.mContent;
          ((a)localObject).f = paramSafeMsgItem.mTime;
          ((a)localObject).g = paramSafeMsgItem.mTypea;
          ((a)localObject).h = paramSafeMsgItem.mTypeb;
          ((a)localObject).i = paramSafeMsgItem.mTypec;
          ((a)localObject).j = paramSafeMsgItem.mUri;
          ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream();
          try
          {
            ObjectOutputStream localObjectOutputStream = new ObjectOutputStream(localByteArrayOutputStream);
            localObjectOutputStream.writeObject(paramSafeMsgItem);
            localObjectOutputStream.flush();
          }
          catch (IOException localIOException)
          {
            localIOException.printStackTrace();
          }
          ((a)localObject).k = localByteArrayOutputStream.toByteArray();
          if (ajs.a((aju)localObject) < 0L)
          {
            localObject = new StringBuilder("SQLiteManager.add user data failed: ");
            ((StringBuilder)localObject).append(paramSafeMsgItem.mUin);
            xv.c(((StringBuilder)localObject).toString());
            return false;
          }
          return true;
        }
      }
      finally {}
      int i = 0;
    }
  }
  
  /* Error */
  public final boolean b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 6	com/tencent/token/ajt$a
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/ajt$a:<init>	(Lcom/tencent/token/ajt;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   16: ldc_w 306
    //   19: iconst_1
    //   20: anewarray 70	java/lang/String
    //   23: dup
    //   24: iconst_0
    //   25: lload_1
    //   26: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   29: aastore
    //   30: invokestatic 204	com/tencent/token/ajs:a	(Lcom/tencent/token/aju;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   33: pop
    //   34: aload_0
    //   35: monitorexit
    //   36: iconst_1
    //   37: ireturn
    //   38: astore_3
    //   39: new 158	java/lang/StringBuilder
    //   42: dup
    //   43: ldc 206
    //   45: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   48: astore 4
    //   50: aload 4
    //   52: aload_3
    //   53: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   56: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   59: pop
    //   60: aload 4
    //   62: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   65: invokestatic 198	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   68: aload_0
    //   69: monitorexit
    //   70: iconst_0
    //   71: ireturn
    //   72: astore_3
    //   73: aload_0
    //   74: monitorexit
    //   75: aload_3
    //   76: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	77	0	this	ajt
    //   0	77	1	paramLong	long
    //   10	2	3	locala	a
    //   38	15	3	localException	java.lang.Exception
    //   72	4	3	localObject	Object
    //   48	13	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	34	38	java/lang/Exception
    //   2	11	72	finally
    //   11	34	72	finally
    //   39	68	72	finally
  }
  
  /* Error */
  public final void c(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 6	com/tencent/token/ajt$a
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/ajt$a:<init>	(Lcom/tencent/token/ajt;)V
    //   10: astore 5
    //   12: aload 5
    //   14: aload_0
    //   15: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   18: invokestatic 309	com/tencent/token/ajs:a	(Lcom/tencent/token/aju;Ljava/lang/String;)I
    //   21: sipush 500
    //   24: if_icmplt +78 -> 102
    //   27: aload 5
    //   29: aload_0
    //   30: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   33: iconst_1
    //   34: anewarray 70	java/lang/String
    //   37: dup
    //   38: iconst_0
    //   39: ldc 104
    //   41: aastore
    //   42: ldc 118
    //   44: iconst_1
    //   45: anewarray 70	java/lang/String
    //   48: dup
    //   49: iconst_0
    //   50: lload_1
    //   51: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   54: aastore
    //   55: ldc_w 311
    //   58: ldc_w 313
    //   61: invokestatic 316	com/tencent/token/ajs:b	(Lcom/tencent/token/aju;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)J
    //   64: lstore_3
    //   65: lload_3
    //   66: lconst_0
    //   67: lcmp
    //   68: ifle +34 -> 102
    //   71: aload 5
    //   73: aload_0
    //   74: getfield 30	com/tencent/token/ajt:b	Ljava/lang/String;
    //   77: ldc_w 318
    //   80: iconst_2
    //   81: anewarray 70	java/lang/String
    //   84: dup
    //   85: iconst_0
    //   86: lload_1
    //   87: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   90: aastore
    //   91: dup
    //   92: iconst_1
    //   93: lload_3
    //   94: invokestatic 74	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   97: aastore
    //   98: invokestatic 204	com/tencent/token/ajs:a	(Lcom/tencent/token/aju;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   101: pop
    //   102: aload_0
    //   103: monitorexit
    //   104: return
    //   105: astore 5
    //   107: new 158	java/lang/StringBuilder
    //   110: dup
    //   111: ldc 195
    //   113: invokespecial 162	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   116: astore 6
    //   118: aload 6
    //   120: aload 5
    //   122: invokevirtual 196	java/lang/Exception:toString	()Ljava/lang/String;
    //   125: invokevirtual 166	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 6
    //   131: invokevirtual 184	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 198	com/tencent/token/xv:c	(Ljava/lang/String;)V
    //   137: aload_0
    //   138: monitorexit
    //   139: return
    //   140: astore 5
    //   142: aload_0
    //   143: monitorexit
    //   144: aload 5
    //   146: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	147	0	this	ajt
    //   0	147	1	paramLong	long
    //   64	30	3	l	long
    //   10	62	5	locala	a
    //   105	16	5	localException	java.lang.Exception
    //   140	5	5	localObject	Object
    //   116	14	6	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   12	65	105	java/lang/Exception
    //   71	102	105	java/lang/Exception
    //   2	12	140	finally
    //   12	65	140	finally
    //   71	102	140	finally
    //   107	137	140	finally
  }
  
  public final boolean d(long paramLong)
  {
    try
    {
      a locala = new a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fis_read", Integer.valueOf(1));
      if (ajs.a(locala, this.b, localContentValues, "fid=?", new String[] { String.valueOf(paramLong) }) <= 0)
      {
        xv.c("update msg isRead failed, id=".concat(String.valueOf(paramLong)));
        return false;
      }
      return true;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public final class a
    implements aju
  {
    long a;
    int b;
    int c;
    String d;
    String e;
    long f;
    int g;
    int h;
    int i;
    String j;
    byte[] k;
    private long m;
    private String n;
    
    public a() {}
    
    public final aju a(aii paramaii)
    {
      a locala = new a(ajt.this);
      locala.m = paramaii.getLong(paramaii.getColumnIndex("fid"));
      locala.a = paramaii.getLong(paramaii.getColumnIndex("fuin"));
      locala.b = paramaii.getInt(paramaii.getColumnIndex("flag"));
      locala.c = paramaii.getInt(paramaii.getColumnIndex("fis_read"));
      locala.d = paramaii.getString(paramaii.getColumnIndex("ftitle"));
      locala.e = paramaii.getString(paramaii.getColumnIndex("fcontent"));
      locala.f = paramaii.getLong(paramaii.getColumnIndex("ftime"));
      locala.g = paramaii.getInt(paramaii.getColumnIndex("ftype"));
      locala.h = paramaii.getInt(paramaii.getColumnIndex("fsub_type"));
      locala.i = paramaii.getInt(paramaii.getColumnIndex("fdetail_type"));
      locala.j = paramaii.getString(paramaii.getColumnIndex("furi"));
      locala.n = paramaii.getString(paramaii.getColumnIndex("faction"));
      locala.k = paramaii.getBlob(paramaii.getColumnIndex("freserved1"));
      return locala;
    }
    
    public final String a()
    {
      return ajt.a(ajt.this);
    }
    
    public final void a(SQLiteDatabase paramSQLiteDatabase)
    {
      StringBuilder localStringBuilder = new StringBuilder("CREATE TABLE IF NOT EXISTS ");
      localStringBuilder.append(ajt.a(ajt.this));
      localStringBuilder.append(" (fid INTEGER PRIMARY KEY autoincrement,fuin INTEGER,flag INTEGER,fis_read INTEGER,ftitle TEXT,fcontent TEXT,ftime INTEGER,ftype INTEGER,fsub_type INTEGER,fdetail_type INTEGER,furi TEXT,faction TEXT,freserved1 BLOB);");
      paramSQLiteDatabase.b(localStringBuilder.toString());
    }
    
    public final long b(SQLiteDatabase paramSQLiteDatabase)
    {
      a(paramSQLiteDatabase);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fuin", Long.valueOf(this.a));
      localContentValues.put("flag", Integer.valueOf(this.b));
      localContentValues.put("fis_read", Integer.valueOf(this.c));
      localContentValues.put("ftitle", this.d);
      localContentValues.put("ftime", Long.valueOf(this.f));
      localContentValues.put("fcontent", this.e);
      localContentValues.put("ftype", Integer.valueOf(this.g));
      localContentValues.put("fsub_type", Integer.valueOf(this.h));
      localContentValues.put("fdetail_type", Integer.valueOf(this.i));
      localContentValues.put("furi", this.j);
      localContentValues.put("faction", this.n);
      localContentValues.put("freserved1", this.k);
      return paramSQLiteDatabase.a(ajt.a(ajt.this), localContentValues);
    }
    
    public final ContentValues b()
    {
      return null;
    }
    
    /* Error */
    public final SafeMsgItem c()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 112	com/tencent/token/ajt$a:k	[B
      //   4: astore_2
      //   5: aload_2
      //   6: ifnull +106 -> 112
      //   9: new 180	java/io/ByteArrayInputStream
      //   12: dup
      //   13: aload_2
      //   14: invokespecial 183	java/io/ByteArrayInputStream:<init>	([B)V
      //   17: astore_2
      //   18: new 185	java/io/ObjectInputStream
      //   21: dup
      //   22: aload_2
      //   23: invokespecial 188	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   26: invokevirtual 192	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   29: checkcast 194	com/tencent/token/core/bean/SafeMsgItem
      //   32: astore_3
      //   33: aload_3
      //   34: astore_2
      //   35: aload_3
      //   36: ifnonnull +84 -> 120
      //   39: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   42: dup
      //   43: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   46: astore_2
      //   47: goto +73 -> 120
      //   50: astore_2
      //   51: goto +51 -> 102
      //   54: astore_2
      //   55: aload_2
      //   56: invokevirtual 198	java/lang/ClassNotFoundException:printStackTrace	()V
      //   59: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   62: dup
      //   63: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   66: astore_2
      //   67: goto +53 -> 120
      //   70: astore_2
      //   71: aload_2
      //   72: invokevirtual 199	java/io/IOException:printStackTrace	()V
      //   75: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   78: dup
      //   79: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   82: astore_2
      //   83: goto +37 -> 120
      //   86: astore_2
      //   87: aload_2
      //   88: invokevirtual 200	java/io/StreamCorruptedException:printStackTrace	()V
      //   91: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   94: dup
      //   95: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   98: astore_2
      //   99: goto +21 -> 120
      //   102: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   105: dup
      //   106: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   109: pop
      //   110: aload_2
      //   111: athrow
      //   112: new 194	com/tencent/token/core/bean/SafeMsgItem
      //   115: dup
      //   116: invokespecial 195	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   119: astore_2
      //   120: aload_0
      //   121: getfield 68	com/tencent/token/ajt$a:c	I
      //   124: ifne +8 -> 132
      //   127: iconst_0
      //   128: istore_1
      //   129: goto +5 -> 134
      //   132: iconst_1
      //   133: istore_1
      //   134: aload_2
      //   135: iload_1
      //   136: putfield 204	com/tencent/token/core/bean/SafeMsgItem:mIsRead	Z
      //   139: aload_2
      //   140: aload_0
      //   141: getfield 56	com/tencent/token/ajt$a:a	J
      //   144: putfield 207	com/tencent/token/core/bean/SafeMsgItem:mUin	J
      //   147: aload_2
      //   148: aload_0
      //   149: getfield 52	com/tencent/token/ajt$a:m	J
      //   152: putfield 210	com/tencent/token/core/bean/SafeMsgItem:mId	J
      //   155: aload_2
      //   156: aload_0
      //   157: getfield 64	com/tencent/token/ajt$a:b	I
      //   160: putfield 213	com/tencent/token/core/bean/SafeMsgItem:mFlag	I
      //   163: aload_2
      //   164: aload_0
      //   165: getfield 76	com/tencent/token/ajt$a:d	Ljava/lang/String;
      //   168: putfield 216	com/tencent/token/core/bean/SafeMsgItem:mTitle	Ljava/lang/String;
      //   171: aload_2
      //   172: aload_0
      //   173: getfield 84	com/tencent/token/ajt$a:f	J
      //   176: putfield 219	com/tencent/token/core/bean/SafeMsgItem:mTime	J
      //   179: aload_2
      //   180: aload_0
      //   181: getfield 80	com/tencent/token/ajt$a:e	Ljava/lang/String;
      //   184: putfield 222	com/tencent/token/core/bean/SafeMsgItem:mContent	Ljava/lang/String;
      //   187: aload_2
      //   188: aload_0
      //   189: getfield 100	com/tencent/token/ajt$a:j	Ljava/lang/String;
      //   192: putfield 225	com/tencent/token/core/bean/SafeMsgItem:mUri	Ljava/lang/String;
      //   195: aload_2
      //   196: aload_0
      //   197: getfield 88	com/tencent/token/ajt$a:g	I
      //   200: putfield 228	com/tencent/token/core/bean/SafeMsgItem:mTypea	I
      //   203: aload_2
      //   204: aload_0
      //   205: getfield 92	com/tencent/token/ajt$a:h	I
      //   208: putfield 231	com/tencent/token/core/bean/SafeMsgItem:mTypeb	I
      //   211: aload_2
      //   212: aload_0
      //   213: getfield 96	com/tencent/token/ajt$a:i	I
      //   216: putfield 234	com/tencent/token/core/bean/SafeMsgItem:mTypec	I
      //   219: aload_2
      //   220: areturn
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	221	0	this	a
      //   128	8	1	bool	boolean
      //   4	43	2	localObject1	Object
      //   50	1	2	localObject2	Object
      //   54	2	2	localClassNotFoundException	java.lang.ClassNotFoundException
      //   66	1	2	localSafeMsgItem1	SafeMsgItem
      //   70	2	2	localIOException	IOException
      //   82	1	2	localSafeMsgItem2	SafeMsgItem
      //   86	2	2	localStreamCorruptedException	java.io.StreamCorruptedException
      //   98	122	2	localSafeMsgItem3	SafeMsgItem
      //   32	4	3	localSafeMsgItem4	SafeMsgItem
      // Exception table:
      //   from	to	target	type
      //   18	33	50	finally
      //   55	59	50	finally
      //   71	75	50	finally
      //   87	91	50	finally
      //   18	33	54	java/lang/ClassNotFoundException
      //   18	33	70	java/io/IOException
      //   18	33	86	java/io/StreamCorruptedException
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.ajt
 * JD-Core Version:    0.7.0.1
 */