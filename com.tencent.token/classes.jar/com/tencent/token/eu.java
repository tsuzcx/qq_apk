package com.tencent.token;

import android.content.ContentValues;
import com.tencent.token.core.bean.SafeMsgItem;
import com.tencent.token.global.g;
import com.tencent.wcdb.Cursor;
import com.tencent.wcdb.database.SQLiteDatabase;

public class eu
{
  private String b = "tbl_safe_msg";
  private boolean c = false;
  
  public eu(String paramString)
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
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("msg title");
        localStringBuilder.append(paramLong);
        localSafeMsgItem.a(localStringBuilder.toString());
        a(localSafeMsgItem);
      }
      return;
    }
    finally {}
  }
  
  /* Error */
  public java.util.List<SafeMsgItem> a(long paramLong, int paramInt)
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
    //   10: new 6	com/tencent/token/eu$a
    //   13: dup
    //   14: aload_0
    //   15: invokespecial 90	com/tencent/token/eu$a:<init>	(Lcom/tencent/token/eu;)V
    //   18: astore 5
    //   20: aload 5
    //   22: aload_0
    //   23: getfield 30	com/tencent/token/eu:b	Ljava/lang/String;
    //   26: bipush 13
    //   28: anewarray 92	java/lang/String
    //   31: dup
    //   32: iconst_0
    //   33: ldc 94
    //   35: aastore
    //   36: dup
    //   37: iconst_1
    //   38: ldc 96
    //   40: aastore
    //   41: dup
    //   42: iconst_2
    //   43: ldc 98
    //   45: aastore
    //   46: dup
    //   47: iconst_3
    //   48: ldc 100
    //   50: aastore
    //   51: dup
    //   52: iconst_4
    //   53: ldc 102
    //   55: aastore
    //   56: dup
    //   57: iconst_5
    //   58: ldc 104
    //   60: aastore
    //   61: dup
    //   62: bipush 6
    //   64: ldc 106
    //   66: aastore
    //   67: dup
    //   68: bipush 7
    //   70: ldc 108
    //   72: aastore
    //   73: dup
    //   74: bipush 8
    //   76: ldc 110
    //   78: aastore
    //   79: dup
    //   80: bipush 9
    //   82: ldc 112
    //   84: aastore
    //   85: dup
    //   86: bipush 10
    //   88: ldc 114
    //   90: aastore
    //   91: dup
    //   92: bipush 11
    //   94: ldc 116
    //   96: aastore
    //   97: dup
    //   98: bipush 12
    //   100: ldc 118
    //   102: aastore
    //   103: ldc 120
    //   105: iconst_1
    //   106: anewarray 92	java/lang/String
    //   109: dup
    //   110: iconst_0
    //   111: lload_1
    //   112: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   115: aastore
    //   116: aconst_null
    //   117: aconst_null
    //   118: ldc 126
    //   120: iload_3
    //   121: invokestatic 129	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   124: invokestatic 134	com/tencent/token/et:a	(Lcom/tencent/token/ev;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Ljava/util/List;
    //   127: astore 5
    //   129: aload 5
    //   131: invokeinterface 140 1 0
    //   136: astore 7
    //   138: new 142	java/util/ArrayList
    //   141: dup
    //   142: invokespecial 143	java/util/ArrayList:<init>	()V
    //   145: astore 6
    //   147: aload 7
    //   149: invokeinterface 148 1 0
    //   154: ifeq +79 -> 233
    //   157: aload 7
    //   159: invokeinterface 152 1 0
    //   164: checkcast 6	com/tencent/token/eu$a
    //   167: astore 8
    //   169: getstatic 21	com/tencent/token/eu:a	Z
    //   172: ifne +19 -> 191
    //   175: aload 8
    //   177: ifnull +6 -> 183
    //   180: goto +11 -> 191
    //   183: new 154	java/lang/AssertionError
    //   186: dup
    //   187: invokespecial 155	java/lang/AssertionError:<init>	()V
    //   190: athrow
    //   191: aload 8
    //   193: invokevirtual 158	com/tencent/token/eu$a:a	()Lcom/tencent/token/core/bean/SafeMsgItem;
    //   196: astore 8
    //   198: getstatic 21	com/tencent/token/eu:a	Z
    //   201: ifne +19 -> 220
    //   204: aload 8
    //   206: ifnull +6 -> 212
    //   209: goto +11 -> 220
    //   212: new 154	java/lang/AssertionError
    //   215: dup
    //   216: invokespecial 155	java/lang/AssertionError:<init>	()V
    //   219: athrow
    //   220: aload 6
    //   222: aload 8
    //   224: invokeinterface 162 2 0
    //   229: pop
    //   230: goto -83 -> 147
    //   233: new 65	java/lang/StringBuilder
    //   236: dup
    //   237: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   240: astore 7
    //   242: aload 7
    //   244: ldc 164
    //   246: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload 7
    //   252: aload_0
    //   253: getfield 30	com/tencent/token/eu:b	Ljava/lang/String;
    //   256: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: pop
    //   260: aload 7
    //   262: ldc 166
    //   264: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   267: pop
    //   268: aload 7
    //   270: lload_1
    //   271: invokevirtual 75	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload 7
    //   277: ldc 168
    //   279: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: pop
    //   283: aload 7
    //   285: aload 6
    //   287: invokeinterface 172 1 0
    //   292: invokevirtual 175	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   295: pop
    //   296: aload 7
    //   298: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 178	com/tencent/token/global/g:b	(Ljava/lang/String;)V
    //   304: aload 5
    //   306: ifnull +13 -> 319
    //   309: aload 5
    //   311: invokeinterface 181 1 0
    //   316: ifeq +15 -> 331
    //   319: aload_0
    //   320: getfield 32	com/tencent/token/eu:c	Z
    //   323: ifeq +8 -> 331
    //   326: aload_0
    //   327: lload_1
    //   328: invokespecial 183	com/tencent/token/eu:e	(J)V
    //   331: aload 6
    //   333: invokeinterface 181 1 0
    //   338: istore 4
    //   340: iload 4
    //   342: ifeq +7 -> 349
    //   345: aload_0
    //   346: monitorexit
    //   347: aconst_null
    //   348: areturn
    //   349: aload_0
    //   350: monitorexit
    //   351: aload 6
    //   353: areturn
    //   354: astore 5
    //   356: new 65	java/lang/StringBuilder
    //   359: dup
    //   360: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   363: astore 6
    //   365: aload 6
    //   367: ldc 185
    //   369: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   372: pop
    //   373: aload 6
    //   375: aload 5
    //   377: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   380: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   383: pop
    //   384: aload 6
    //   386: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   389: invokestatic 188	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   392: aload_0
    //   393: monitorexit
    //   394: aconst_null
    //   395: areturn
    //   396: astore 5
    //   398: aload_0
    //   399: monitorexit
    //   400: aload 5
    //   402: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	403	0	this	eu
    //   0	403	1	paramLong	long
    //   0	403	3	paramInt	int
    //   338	3	4	bool	boolean
    //   18	292	5	localObject1	Object
    //   354	22	5	localException	Exception
    //   396	5	5	localObject2	Object
    //   145	240	6	localObject3	Object
    //   136	161	7	localObject4	Object
    //   167	56	8	localObject5	Object
    // Exception table:
    //   from	to	target	type
    //   20	129	354	java/lang/Exception
    //   10	20	396	finally
    //   20	129	396	finally
    //   129	147	396	finally
    //   147	175	396	finally
    //   183	191	396	finally
    //   191	204	396	finally
    //   212	220	396	finally
    //   220	230	396	finally
    //   233	304	396	finally
    //   309	319	396	finally
    //   319	331	396	finally
    //   331	340	396	finally
    //   356	392	396	finally
  }
  
  /* Error */
  public boolean a(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 6	com/tencent/token/eu$a
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/eu$a:<init>	(Lcom/tencent/token/eu;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: getfield 30	com/tencent/token/eu:b	Ljava/lang/String;
    //   16: ldc 120
    //   18: iconst_1
    //   19: anewarray 92	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokestatic 194	com/tencent/token/et:a	(Lcom/tencent/token/ev;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_1
    //   36: ireturn
    //   37: astore_3
    //   38: new 65	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 196
    //   51: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: aload_3
    //   58: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   61: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 188	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	eu
    //   0	82	1	paramLong	long
    //   10	2	3	locala	a
    //   37	21	3	localException	Exception
    //   77	4	3	localObject	Object
    //   45	21	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	33	37	java/lang/Exception
    //   2	11	77	finally
    //   11	33	77	finally
    //   38	73	77	finally
  }
  
  public boolean a(long paramLong, int paramInt, String paramString)
  {
    try
    {
      a locala = new a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("flag", Integer.valueOf(paramInt));
      localContentValues.put("fcontent", paramString);
      if (et.a(locala, this.b, localContentValues, "fid=?", new String[] { String.valueOf(paramLong) }) <= 0)
      {
        paramString = new StringBuilder();
        paramString.append("update msg flag failed, id=");
        paramString.append(paramLong);
        g.c(paramString.toString());
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
  
  public boolean a(SafeMsgItem paramSafeMsgItem)
  {
    try
    {
      Object localObject = new a();
      ((a)localObject).a(paramSafeMsgItem);
      if (et.b((ev)localObject) < 0L)
      {
        localObject = new StringBuilder();
        ((StringBuilder)localObject).append("SQLiteManager.add user data failed: ");
        ((StringBuilder)localObject).append(paramSafeMsgItem.mUin);
        g.c(((StringBuilder)localObject).toString());
        return false;
      }
      return true;
    }
    finally
    {
      paramSafeMsgItem = finally;
      throw paramSafeMsgItem;
    }
  }
  
  /* Error */
  public boolean b(long paramLong)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: new 6	com/tencent/token/eu$a
    //   5: dup
    //   6: aload_0
    //   7: invokespecial 90	com/tencent/token/eu$a:<init>	(Lcom/tencent/token/eu;)V
    //   10: astore_3
    //   11: aload_3
    //   12: aload_0
    //   13: getfield 30	com/tencent/token/eu:b	Ljava/lang/String;
    //   16: ldc 229
    //   18: iconst_1
    //   19: anewarray 92	java/lang/String
    //   22: dup
    //   23: iconst_0
    //   24: lload_1
    //   25: invokestatic 124	java/lang/String:valueOf	(J)Ljava/lang/String;
    //   28: aastore
    //   29: invokestatic 194	com/tencent/token/et:a	(Lcom/tencent/token/ev;Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   32: pop
    //   33: aload_0
    //   34: monitorexit
    //   35: iconst_1
    //   36: ireturn
    //   37: astore_3
    //   38: new 65	java/lang/StringBuilder
    //   41: dup
    //   42: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   45: astore 4
    //   47: aload 4
    //   49: ldc 196
    //   51: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: aload 4
    //   57: aload_3
    //   58: invokevirtual 186	java/lang/Exception:toString	()Ljava/lang/String;
    //   61: invokevirtual 72	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload 4
    //   67: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   70: invokestatic 188	com/tencent/token/global/g:c	(Ljava/lang/String;)V
    //   73: aload_0
    //   74: monitorexit
    //   75: iconst_0
    //   76: ireturn
    //   77: astore_3
    //   78: aload_0
    //   79: monitorexit
    //   80: aload_3
    //   81: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	82	0	this	eu
    //   0	82	1	paramLong	long
    //   10	2	3	locala	a
    //   37	21	3	localException	Exception
    //   77	4	3	localObject	Object
    //   45	21	4	localStringBuilder	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   11	33	37	java/lang/Exception
    //   2	11	77	finally
    //   11	33	77	finally
    //   38	73	77	finally
  }
  
  public void c(long paramLong)
  {
    try
    {
      a locala = new a();
      try
      {
        if (et.a(locala, this.b) >= 500)
        {
          long l = et.a(locala, this.b, new String[] { "ftime" }, "fuin = ?", new String[] { String.valueOf(paramLong) }, null, null, "ftime asc", String.valueOf(200), false);
          if (l > 0L) {
            et.a(locala, this.b, "fuin = ? and ftime <= ?", new String[] { String.valueOf(paramLong), String.valueOf(l) });
          }
        }
      }
      catch (Exception localException)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("SQLiteManager query Exception:");
        localStringBuilder.append(localException.toString());
        g.c(localStringBuilder.toString());
      }
      return;
    }
    finally {}
  }
  
  public boolean d(long paramLong)
  {
    try
    {
      Object localObject1 = new a();
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fis_read", Integer.valueOf(1));
      if (et.a((ev)localObject1, this.b, localContentValues, "fid=?", new String[] { String.valueOf(paramLong) }) <= 0)
      {
        localObject1 = new StringBuilder();
        ((StringBuilder)localObject1).append("update msg isRead failed, id=");
        ((StringBuilder)localObject1).append(paramLong);
        g.c(((StringBuilder)localObject1).toString());
        return false;
      }
      return true;
    }
    finally
    {
      localObject2 = finally;
      throw localObject2;
    }
  }
  
  public class a
    implements ev
  {
    private long b;
    private long c;
    private int d;
    private int e;
    private String f;
    private String g;
    private long h;
    private int i;
    private int j;
    private int k;
    private String l;
    private String m;
    private byte[] n;
    
    public a() {}
    
    /* Error */
    public SafeMsgItem a()
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 44	com/tencent/token/eu$a:n	[B
      //   4: astore_2
      //   5: aload_2
      //   6: ifnull +106 -> 112
      //   9: new 46	java/io/ByteArrayInputStream
      //   12: dup
      //   13: aload_2
      //   14: invokespecial 49	java/io/ByteArrayInputStream:<init>	([B)V
      //   17: astore_2
      //   18: new 51	java/io/ObjectInputStream
      //   21: dup
      //   22: aload_2
      //   23: invokespecial 54	java/io/ObjectInputStream:<init>	(Ljava/io/InputStream;)V
      //   26: invokevirtual 58	java/io/ObjectInputStream:readObject	()Ljava/lang/Object;
      //   29: checkcast 60	com/tencent/token/core/bean/SafeMsgItem
      //   32: astore_3
      //   33: aload_3
      //   34: astore_2
      //   35: aload_3
      //   36: ifnonnull +84 -> 120
      //   39: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   42: dup
      //   43: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   46: astore_2
      //   47: goto +73 -> 120
      //   50: astore_2
      //   51: goto +51 -> 102
      //   54: astore_2
      //   55: aload_2
      //   56: invokevirtual 64	java/lang/ClassNotFoundException:printStackTrace	()V
      //   59: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   62: dup
      //   63: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   66: astore_2
      //   67: goto +53 -> 120
      //   70: astore_2
      //   71: aload_2
      //   72: invokevirtual 65	java/io/IOException:printStackTrace	()V
      //   75: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   78: dup
      //   79: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   82: astore_2
      //   83: goto +37 -> 120
      //   86: astore_2
      //   87: aload_2
      //   88: invokevirtual 66	java/io/StreamCorruptedException:printStackTrace	()V
      //   91: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   94: dup
      //   95: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   98: astore_2
      //   99: goto +21 -> 120
      //   102: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   105: dup
      //   106: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   109: pop
      //   110: aload_2
      //   111: athrow
      //   112: new 60	com/tencent/token/core/bean/SafeMsgItem
      //   115: dup
      //   116: invokespecial 61	com/tencent/token/core/bean/SafeMsgItem:<init>	()V
      //   119: astore_2
      //   120: aload_0
      //   121: getfield 68	com/tencent/token/eu$a:e	I
      //   124: ifne +8 -> 132
      //   127: iconst_0
      //   128: istore_1
      //   129: goto +5 -> 134
      //   132: iconst_1
      //   133: istore_1
      //   134: aload_2
      //   135: iload_1
      //   136: putfield 72	com/tencent/token/core/bean/SafeMsgItem:mIsRead	Z
      //   139: aload_2
      //   140: aload_0
      //   141: getfield 74	com/tencent/token/eu$a:c	J
      //   144: putfield 77	com/tencent/token/core/bean/SafeMsgItem:mUin	J
      //   147: aload_2
      //   148: aload_0
      //   149: getfield 79	com/tencent/token/eu$a:b	J
      //   152: invokevirtual 82	com/tencent/token/core/bean/SafeMsgItem:a	(J)V
      //   155: aload_2
      //   156: aload_0
      //   157: getfield 84	com/tencent/token/eu$a:d	I
      //   160: invokevirtual 87	com/tencent/token/core/bean/SafeMsgItem:a	(I)V
      //   163: aload_2
      //   164: aload_0
      //   165: getfield 89	com/tencent/token/eu$a:f	Ljava/lang/String;
      //   168: invokevirtual 92	com/tencent/token/core/bean/SafeMsgItem:a	(Ljava/lang/String;)V
      //   171: aload_2
      //   172: aload_0
      //   173: getfield 94	com/tencent/token/eu$a:h	J
      //   176: invokevirtual 96	com/tencent/token/core/bean/SafeMsgItem:b	(J)V
      //   179: aload_2
      //   180: aload_0
      //   181: getfield 98	com/tencent/token/eu$a:g	Ljava/lang/String;
      //   184: invokevirtual 100	com/tencent/token/core/bean/SafeMsgItem:b	(Ljava/lang/String;)V
      //   187: aload_2
      //   188: aload_0
      //   189: getfield 102	com/tencent/token/eu$a:l	Ljava/lang/String;
      //   192: invokevirtual 104	com/tencent/token/core/bean/SafeMsgItem:c	(Ljava/lang/String;)V
      //   195: aload_2
      //   196: aload_0
      //   197: getfield 106	com/tencent/token/eu$a:i	I
      //   200: invokevirtual 108	com/tencent/token/core/bean/SafeMsgItem:b	(I)V
      //   203: aload_2
      //   204: aload_0
      //   205: getfield 110	com/tencent/token/eu$a:j	I
      //   208: invokevirtual 112	com/tencent/token/core/bean/SafeMsgItem:c	(I)V
      //   211: aload_2
      //   212: aload_0
      //   213: getfield 114	com/tencent/token/eu$a:k	I
      //   216: invokevirtual 116	com/tencent/token/core/bean/SafeMsgItem:d	(I)V
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
      //   70	2	2	localIOException	java.io.IOException
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
    
    public ev a(Cursor paramCursor)
    {
      a locala = new a(eu.this);
      locala.b = paramCursor.getLong(paramCursor.getColumnIndex("fid"));
      locala.c = paramCursor.getLong(paramCursor.getColumnIndex("fuin"));
      locala.d = paramCursor.getInt(paramCursor.getColumnIndex("flag"));
      locala.e = paramCursor.getInt(paramCursor.getColumnIndex("fis_read"));
      locala.f = paramCursor.getString(paramCursor.getColumnIndex("ftitle"));
      locala.g = paramCursor.getString(paramCursor.getColumnIndex("fcontent"));
      locala.h = paramCursor.getLong(paramCursor.getColumnIndex("ftime"));
      locala.i = paramCursor.getInt(paramCursor.getColumnIndex("ftype"));
      locala.j = paramCursor.getInt(paramCursor.getColumnIndex("fsub_type"));
      locala.k = paramCursor.getInt(paramCursor.getColumnIndex("fdetail_type"));
      locala.l = paramCursor.getString(paramCursor.getColumnIndex("furi"));
      locala.m = paramCursor.getString(paramCursor.getColumnIndex("faction"));
      locala.n = paramCursor.getBlob(paramCursor.getColumnIndex("freserved1"));
      return locala;
    }
    
    public void a(SafeMsgItem paramSafeMsgItem)
    {
      throw new Runtime("d2j fail translate: java.lang.RuntimeException: can not merge I and Z\r\n\tat com.googlecode.dex2jar.ir.TypeClass.merge(TypeClass.java:100)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeRef.updateTypeClass(TypeTransformer.java:174)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.copyTypes(TypeTransformer.java:311)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.fixTypes(TypeTransformer.java:226)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer$TypeAnalyze.analyze(TypeTransformer.java:207)\r\n\tat com.googlecode.dex2jar.ir.ts.TypeTransformer.transform(TypeTransformer.java:44)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.optimize(Dex2jar.java:162)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertCode(Dex2Asm.java:414)\r\n\tat com.googlecode.d2j.dex.ExDex2Asm.convertCode(ExDex2Asm.java:42)\r\n\tat com.googlecode.d2j.dex.Dex2jar$2.convertCode(Dex2jar.java:128)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertMethod(Dex2Asm.java:509)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertClass(Dex2Asm.java:406)\r\n\tat com.googlecode.d2j.dex.Dex2Asm.convertDex(Dex2Asm.java:422)\r\n\tat com.googlecode.d2j.dex.Dex2jar.doTranslate(Dex2jar.java:172)\r\n\tat com.googlecode.d2j.dex.Dex2jar.to(Dex2jar.java:272)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.doCommandLine(Dex2jarCmd.java:108)\r\n\tat com.googlecode.dex2jar.tools.BaseCmd.doMain(BaseCmd.java:288)\r\n\tat com.googlecode.dex2jar.tools.Dex2jarCmd.main(Dex2jarCmd.java:32)\r\n");
    }
    
    public void a(SQLiteDatabase paramSQLiteDatabase)
    {
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("CREATE TABLE IF NOT EXISTS ");
      localStringBuilder.append(eu.a(eu.this));
      localStringBuilder.append(" (");
      localStringBuilder.append("fid");
      localStringBuilder.append(" INTEGER PRIMARY KEY autoincrement,");
      localStringBuilder.append("fuin");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("flag");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("fis_read");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("ftitle");
      localStringBuilder.append(" TEXT,");
      localStringBuilder.append("fcontent");
      localStringBuilder.append(" TEXT,");
      localStringBuilder.append("ftime");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("ftype");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("fsub_type");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("fdetail_type");
      localStringBuilder.append(" INTEGER,");
      localStringBuilder.append("furi");
      localStringBuilder.append(" TEXT,");
      localStringBuilder.append("faction");
      localStringBuilder.append(" TEXT,");
      localStringBuilder.append("freserved1");
      localStringBuilder.append(" BLOB);");
      paramSQLiteDatabase.execSQL(localStringBuilder.toString());
    }
    
    public long b(SQLiteDatabase paramSQLiteDatabase)
    {
      a(paramSQLiteDatabase);
      ContentValues localContentValues = new ContentValues();
      localContentValues.put("fuin", Long.valueOf(this.c));
      localContentValues.put("flag", Integer.valueOf(this.d));
      localContentValues.put("fis_read", Integer.valueOf(this.e));
      localContentValues.put("ftitle", this.f);
      localContentValues.put("ftime", Long.valueOf(this.h));
      localContentValues.put("fcontent", this.g);
      localContentValues.put("ftype", Integer.valueOf(this.i));
      localContentValues.put("fsub_type", Integer.valueOf(this.j));
      localContentValues.put("fdetail_type", Integer.valueOf(this.k));
      localContentValues.put("furi", this.l);
      localContentValues.put("faction", this.m);
      localContentValues.put("freserved1", this.n);
      return paramSQLiteDatabase.insert(eu.a(eu.this), null, localContentValues);
    }
    
    public String b()
    {
      return eu.a(eu.this);
    }
    
    public ContentValues c()
    {
      return null;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.eu
 * JD-Core Version:    0.7.0.1
 */