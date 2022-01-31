package btmsdkobf;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.taf.jce.HexUtil;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.tcc.b;

public class bs
{
  static bs gC = null;
  private static Object gD = new Object();
  private SQLiteOpenHelper gE;
  private final String gF = "CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)";
  
  private bs()
  {
    bo.k("DataManager-DataManager");
    this.gE = new fj(this, bc.n(), "r.db", null, 10);
    this.gE.getWritableDatabase().setLockingEnabled(false);
  }
  
  private long a(String paramString, ContentValues paramContentValues)
  {
    synchronized (gD)
    {
      long l = this.gE.getWritableDatabase().insert(paramString, null, paramContentValues);
      return l;
    }
  }
  
  /* Error */
  public static bs ac()
  {
    // Byte code:
    //   0: ldc 2
    //   2: monitorenter
    //   3: getstatic 16	btmsdkobf/bs:gC	Lbtmsdkobf/bs;
    //   6: ifnonnull +25 -> 31
    //   9: ldc 2
    //   11: monitorenter
    //   12: getstatic 16	btmsdkobf/bs:gC	Lbtmsdkobf/bs;
    //   15: ifnonnull +13 -> 28
    //   18: new 2	btmsdkobf/bs
    //   21: dup
    //   22: invokespecial 80	btmsdkobf/bs:<init>	()V
    //   25: putstatic 16	btmsdkobf/bs:gC	Lbtmsdkobf/bs;
    //   28: ldc 2
    //   30: monitorexit
    //   31: ldc 2
    //   33: monitorexit
    //   34: getstatic 16	btmsdkobf/bs:gC	Lbtmsdkobf/bs;
    //   37: areturn
    //   38: astore_0
    //   39: ldc 2
    //   41: monitorexit
    //   42: aload_0
    //   43: athrow
    //   44: astore_0
    //   45: ldc 2
    //   47: monitorexit
    //   48: aload_0
    //   49: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   38	5	0	localObject1	Object
    //   44	5	0	localObject2	Object
    // Exception table:
    //   from	to	target	type
    //   12	28	38	finally
    //   28	31	38	finally
    //   39	42	38	finally
    //   3	12	44	finally
    //   31	34	44	finally
    //   42	44	44	finally
    //   45	48	44	finally
  }
  
  private List b(Cursor paramCursor)
  {
    localArrayList = new ArrayList();
    try
    {
      paramCursor.moveToFirst();
      while (!paramCursor.isAfterLast())
      {
        br localbr = new br();
        localbr.gz = new bt();
        localbr.gz.gH = paramCursor.getInt(paramCursor.getColumnIndex("a"));
        localbr.gz.gI = paramCursor.getInt(paramCursor.getColumnIndex("b"));
        localbr.gz.gJ = paramCursor.getInt(paramCursor.getColumnIndex("c"));
        localbr.gz.gK = paramCursor.getInt(paramCursor.getColumnIndex("d"));
        localbr.gz.gL = paramCursor.getLong(paramCursor.getColumnIndex("e"));
        localbr.gz.gM = paramCursor.getInt(paramCursor.getColumnIndex("f"));
        localbr.gz.gN = paramCursor.getString(paramCursor.getColumnIndex("i"));
        String str = new String(b.decrypt(HexUtil.hexStr2Bytes(paramCursor.getString(paramCursor.getColumnIndex("j"))), null));
        localbr.gz.gO = str;
        localbr.gA = paramCursor.getInt(paramCursor.getColumnIndex("k"));
        localbr.gB = paramCursor.getInt(paramCursor.getColumnIndex("l"));
        localArrayList.add(localbr);
        paramCursor.moveToNext();
      }
      return localArrayList;
    }
    catch (Throwable paramCursor)
    {
      bo.l("e:[" + paramCursor + "]");
      if (localArrayList.size() == 0) {
        return null;
      }
    }
  }
  
  private void close()
  {
    synchronized (gD)
    {
      this.gE.close();
      return;
    }
  }
  
  private int delete(String paramString1, String paramString2, String[] paramArrayOfString)
  {
    synchronized (gD)
    {
      int i = this.gE.getWritableDatabase().delete(paramString1, paramString2, paramArrayOfString);
      return i;
    }
  }
  
  private ContentValues f(br parambr)
  {
    ContentValues localContentValues = new ContentValues();
    localContentValues.put("a", Integer.valueOf(parambr.gz.gH));
    localContentValues.put("b", Integer.valueOf(parambr.gz.gI));
    localContentValues.put("c", Integer.valueOf(parambr.gz.gJ));
    localContentValues.put("d", Integer.valueOf(parambr.gz.gK));
    localContentValues.put("e", Long.valueOf(parambr.gz.gL));
    localContentValues.put("f", Integer.valueOf(parambr.gz.gM));
    localContentValues.put("i", parambr.gz.gN);
    localContentValues.put("j", HexUtil.bytes2HexStr(b.encrypt(parambr.gz.gO.getBytes(), null)));
    localContentValues.put("k", Integer.valueOf(parambr.gA));
    localContentValues.put("l", Integer.valueOf(parambr.gB));
    return localContentValues;
  }
  
  private Cursor m(String paramString)
  {
    synchronized (gD)
    {
      paramString = this.gE.getReadableDatabase().rawQuery(paramString, null);
      return paramString;
    }
  }
  
  private void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    bo.k("execSQL:[CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)]");
    paramSQLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)");
  }
  
  private void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt2 > paramInt1) {}
  }
  
  private int update(String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    synchronized (gD)
    {
      int i = this.gE.getWritableDatabase().update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
  }
  
  public void ad()
  {
    bo.k("DataManager-freeInstance");
    close();
  }
  
  /* Error */
  public List ae()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: invokestatic 294	java/lang/System:currentTimeMillis	()J
    //   6: lstore_2
    //   7: new 199	java/lang/StringBuilder
    //   10: dup
    //   11: bipush 120
    //   13: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   16: astore 4
    //   18: aload 4
    //   20: ldc_w 299
    //   23: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   26: pop
    //   27: aload 4
    //   29: ldc_w 301
    //   32: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload 4
    //   38: ldc_w 303
    //   41: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   44: pop
    //   45: aload 4
    //   47: ldc 180
    //   49: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 4
    //   55: ldc_w 305
    //   58: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload 4
    //   64: iconst_2
    //   65: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload 4
    //   71: ldc_w 310
    //   74: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   77: pop
    //   78: aload 4
    //   80: ldc 135
    //   82: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 4
    //   88: ldc_w 312
    //   91: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   94: pop
    //   95: aload 4
    //   97: lload_2
    //   98: invokevirtual 315	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   101: pop
    //   102: new 199	java/lang/StringBuilder
    //   105: dup
    //   106: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   109: ldc_w 317
    //   112: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   115: aload 4
    //   117: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   120: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   123: ldc 211
    //   125: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   131: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   134: aload_0
    //   135: aload 4
    //   137: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   140: invokespecial 319	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   143: astore 4
    //   145: aload 4
    //   147: astore 5
    //   149: aload 5
    //   151: ifnull +297 -> 448
    //   154: aload 5
    //   156: astore 6
    //   158: aload_0
    //   159: aload 5
    //   161: invokespecial 321	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   164: astore 4
    //   166: aload 5
    //   168: astore 6
    //   170: new 199	java/lang/StringBuilder
    //   173: dup
    //   174: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   177: ldc_w 323
    //   180: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   183: astore 7
    //   185: aload 4
    //   187: ifnull +59 -> 246
    //   190: aload 5
    //   192: astore 6
    //   194: aload 4
    //   196: invokeinterface 221 1 0
    //   201: istore_1
    //   202: aload 5
    //   204: astore 6
    //   206: aload 7
    //   208: iload_1
    //   209: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   212: ldc 211
    //   214: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   220: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   223: aload 4
    //   225: astore 6
    //   227: aload 5
    //   229: ifnull +14 -> 243
    //   232: aload 5
    //   234: invokeinterface 324 1 0
    //   239: aload 4
    //   241: astore 6
    //   243: aload 6
    //   245: areturn
    //   246: iconst_0
    //   247: istore_1
    //   248: goto -46 -> 202
    //   251: astore 5
    //   253: new 199	java/lang/StringBuilder
    //   256: dup
    //   257: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   260: ldc 202
    //   262: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   265: aload 5
    //   267: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   270: ldc 211
    //   272: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   275: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   278: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   281: aload 4
    //   283: areturn
    //   284: astore 7
    //   286: aconst_null
    //   287: astore 5
    //   289: aconst_null
    //   290: astore 4
    //   292: aload 5
    //   294: astore 6
    //   296: new 199	java/lang/StringBuilder
    //   299: dup
    //   300: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   303: ldc 202
    //   305: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   308: aload 7
    //   310: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   313: ldc 211
    //   315: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   318: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   321: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   324: aload 4
    //   326: astore 6
    //   328: aload 5
    //   330: ifnull -87 -> 243
    //   333: aload 5
    //   335: invokeinterface 324 1 0
    //   340: aload 4
    //   342: areturn
    //   343: astore 5
    //   345: new 199	java/lang/StringBuilder
    //   348: dup
    //   349: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   352: ldc 202
    //   354: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   357: aload 5
    //   359: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   362: ldc 211
    //   364: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   367: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   370: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   373: aload 4
    //   375: areturn
    //   376: astore 4
    //   378: aload 5
    //   380: ifnull +10 -> 390
    //   383: aload 5
    //   385: invokeinterface 324 1 0
    //   390: aload 4
    //   392: athrow
    //   393: astore 5
    //   395: new 199	java/lang/StringBuilder
    //   398: dup
    //   399: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   402: ldc 202
    //   404: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   407: aload 5
    //   409: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   412: ldc 211
    //   414: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   420: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   423: goto -33 -> 390
    //   426: astore 4
    //   428: aload 6
    //   430: astore 5
    //   432: goto -54 -> 378
    //   435: astore 7
    //   437: aconst_null
    //   438: astore 4
    //   440: goto -148 -> 292
    //   443: astore 7
    //   445: goto -153 -> 292
    //   448: aconst_null
    //   449: astore 4
    //   451: goto -285 -> 166
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	454	0	this	bs
    //   201	47	1	i	int
    //   6	92	2	l	long
    //   16	358	4	localObject1	Object
    //   376	15	4	localObject2	Object
    //   426	1	4	localObject3	Object
    //   438	12	4	localObject4	Object
    //   1	232	5	localObject5	Object
    //   251	15	5	localThrowable1	Throwable
    //   287	47	5	localObject6	Object
    //   343	41	5	localThrowable2	Throwable
    //   393	15	5	localThrowable3	Throwable
    //   430	1	5	localObject7	Object
    //   156	273	6	localObject8	Object
    //   183	24	7	localStringBuilder	java.lang.StringBuilder
    //   284	25	7	localThrowable4	Throwable
    //   435	1	7	localThrowable5	Throwable
    //   443	1	7	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   232	239	251	java/lang/Throwable
    //   3	145	284	java/lang/Throwable
    //   333	340	343	java/lang/Throwable
    //   3	145	376	finally
    //   383	390	393	java/lang/Throwable
    //   158	166	426	finally
    //   170	185	426	finally
    //   194	202	426	finally
    //   206	223	426	finally
    //   296	324	426	finally
    //   158	166	435	java/lang/Throwable
    //   170	185	443	java/lang/Throwable
    //   194	202	443	java/lang/Throwable
    //   206	223	443	java/lang/Throwable
  }
  
  /* Error */
  public List af()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 199	java/lang/StringBuilder
    //   5: dup
    //   6: bipush 120
    //   8: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 299
    //   16: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: ldc_w 301
    //   24: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 303
    //   32: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 185
    //   39: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 305
    //   47: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iconst_1
    //   53: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc_w 310
    //   61: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc 185
    //   68: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: ldc_w 305
    //   76: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: iconst_2
    //   82: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload_2
    //   87: ldc_w 327
    //   90: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload_2
    //   95: ldc 180
    //   97: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: pop
    //   101: aload_2
    //   102: ldc_w 305
    //   105: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: pop
    //   109: aload_2
    //   110: iconst_1
    //   111: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   114: pop
    //   115: new 199	java/lang/StringBuilder
    //   118: dup
    //   119: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   122: ldc_w 329
    //   125: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: aload_2
    //   129: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   132: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   135: ldc 211
    //   137: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   143: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   146: aload_0
    //   147: aload_2
    //   148: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   151: invokespecial 319	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   154: astore_2
    //   155: aload_2
    //   156: astore_3
    //   157: aload_3
    //   158: ifnull +263 -> 421
    //   161: aload_3
    //   162: astore 4
    //   164: aload_0
    //   165: aload_3
    //   166: invokespecial 321	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   169: astore_2
    //   170: aload_3
    //   171: astore 4
    //   173: new 199	java/lang/StringBuilder
    //   176: dup
    //   177: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   180: ldc_w 331
    //   183: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   186: astore 5
    //   188: aload_2
    //   189: ifnull +52 -> 241
    //   192: aload_3
    //   193: astore 4
    //   195: aload_2
    //   196: invokeinterface 221 1 0
    //   201: istore_1
    //   202: aload_3
    //   203: astore 4
    //   205: aload 5
    //   207: iload_1
    //   208: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   211: ldc 211
    //   213: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   216: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   222: aload_2
    //   223: astore 4
    //   225: aload_3
    //   226: ifnull +12 -> 238
    //   229: aload_3
    //   230: invokeinterface 324 1 0
    //   235: aload_2
    //   236: astore 4
    //   238: aload 4
    //   240: areturn
    //   241: iconst_0
    //   242: istore_1
    //   243: goto -41 -> 202
    //   246: astore_3
    //   247: new 199	java/lang/StringBuilder
    //   250: dup
    //   251: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   254: ldc 202
    //   256: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   259: aload_3
    //   260: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   263: ldc 211
    //   265: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   271: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   274: aload_2
    //   275: areturn
    //   276: astore 5
    //   278: aconst_null
    //   279: astore_3
    //   280: aconst_null
    //   281: astore_2
    //   282: aload_3
    //   283: astore 4
    //   285: new 199	java/lang/StringBuilder
    //   288: dup
    //   289: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   292: ldc 202
    //   294: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   297: aload 5
    //   299: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   302: ldc 211
    //   304: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   307: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   310: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   313: aload_2
    //   314: astore 4
    //   316: aload_3
    //   317: ifnull -79 -> 238
    //   320: aload_3
    //   321: invokeinterface 324 1 0
    //   326: aload_2
    //   327: areturn
    //   328: astore_3
    //   329: new 199	java/lang/StringBuilder
    //   332: dup
    //   333: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   336: ldc 202
    //   338: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   341: aload_3
    //   342: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   345: ldc 211
    //   347: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   353: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   356: aload_2
    //   357: areturn
    //   358: astore_2
    //   359: aload_3
    //   360: ifnull +9 -> 369
    //   363: aload_3
    //   364: invokeinterface 324 1 0
    //   369: aload_2
    //   370: athrow
    //   371: astore_3
    //   372: new 199	java/lang/StringBuilder
    //   375: dup
    //   376: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   379: ldc 202
    //   381: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   384: aload_3
    //   385: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   388: ldc 211
    //   390: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   393: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   399: goto -30 -> 369
    //   402: astore_2
    //   403: aload 4
    //   405: astore_3
    //   406: goto -47 -> 359
    //   409: astore 5
    //   411: aconst_null
    //   412: astore_2
    //   413: goto -131 -> 282
    //   416: astore 5
    //   418: goto -136 -> 282
    //   421: aconst_null
    //   422: astore_2
    //   423: goto -253 -> 170
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	426	0	this	bs
    //   201	42	1	i	int
    //   11	346	2	localObject1	Object
    //   358	12	2	localObject2	Object
    //   402	1	2	localObject3	Object
    //   412	11	2	localObject4	Object
    //   1	229	3	localObject5	Object
    //   246	14	3	localThrowable1	Throwable
    //   279	42	3	localObject6	Object
    //   328	36	3	localThrowable2	Throwable
    //   371	14	3	localThrowable3	Throwable
    //   405	1	3	localObject7	Object
    //   162	242	4	localObject8	Object
    //   186	20	5	localStringBuilder	java.lang.StringBuilder
    //   276	22	5	localThrowable4	Throwable
    //   409	1	5	localThrowable5	Throwable
    //   416	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   229	235	246	java/lang/Throwable
    //   2	155	276	java/lang/Throwable
    //   320	326	328	java/lang/Throwable
    //   2	155	358	finally
    //   363	369	371	java/lang/Throwable
    //   164	170	402	finally
    //   173	188	402	finally
    //   195	202	402	finally
    //   205	222	402	finally
    //   285	313	402	finally
    //   164	170	409	java/lang/Throwable
    //   173	188	416	java/lang/Throwable
    //   195	202	416	java/lang/Throwable
    //   205	222	416	java/lang/Throwable
  }
  
  /* Error */
  public List ag()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: new 199	java/lang/StringBuilder
    //   5: dup
    //   6: bipush 120
    //   8: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   11: astore_2
    //   12: aload_2
    //   13: ldc_w 299
    //   16: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   19: pop
    //   20: aload_2
    //   21: ldc_w 301
    //   24: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   27: pop
    //   28: aload_2
    //   29: ldc_w 303
    //   32: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   35: pop
    //   36: aload_2
    //   37: ldc 185
    //   39: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   42: pop
    //   43: aload_2
    //   44: ldc_w 305
    //   47: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: pop
    //   51: aload_2
    //   52: iconst_3
    //   53: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   56: pop
    //   57: aload_2
    //   58: ldc_w 327
    //   61: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   64: pop
    //   65: aload_2
    //   66: ldc 130
    //   68: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload_2
    //   73: ldc_w 305
    //   76: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: pop
    //   80: aload_2
    //   81: iconst_1
    //   82: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: new 199	java/lang/StringBuilder
    //   89: dup
    //   90: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   93: ldc_w 334
    //   96: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   99: aload_2
    //   100: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   106: ldc 211
    //   108: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   111: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   114: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   117: aload_0
    //   118: aload_2
    //   119: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   122: invokespecial 319	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   125: astore_2
    //   126: aload_2
    //   127: astore_3
    //   128: aload_3
    //   129: ifnull +263 -> 392
    //   132: aload_3
    //   133: astore 4
    //   135: aload_0
    //   136: aload_3
    //   137: invokespecial 321	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   140: astore_2
    //   141: aload_3
    //   142: astore 4
    //   144: new 199	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   151: ldc_w 336
    //   154: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   157: astore 5
    //   159: aload_2
    //   160: ifnull +52 -> 212
    //   163: aload_3
    //   164: astore 4
    //   166: aload_2
    //   167: invokeinterface 221 1 0
    //   172: istore_1
    //   173: aload_3
    //   174: astore 4
    //   176: aload 5
    //   178: iload_1
    //   179: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   182: ldc 211
    //   184: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   193: aload_2
    //   194: astore 4
    //   196: aload_3
    //   197: ifnull +12 -> 209
    //   200: aload_3
    //   201: invokeinterface 324 1 0
    //   206: aload_2
    //   207: astore 4
    //   209: aload 4
    //   211: areturn
    //   212: iconst_0
    //   213: istore_1
    //   214: goto -41 -> 173
    //   217: astore_3
    //   218: new 199	java/lang/StringBuilder
    //   221: dup
    //   222: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   225: ldc 202
    //   227: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   230: aload_3
    //   231: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   234: ldc 211
    //   236: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   239: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   242: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   245: aload_2
    //   246: areturn
    //   247: astore 5
    //   249: aconst_null
    //   250: astore_3
    //   251: aconst_null
    //   252: astore_2
    //   253: aload_3
    //   254: astore 4
    //   256: new 199	java/lang/StringBuilder
    //   259: dup
    //   260: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   263: ldc 202
    //   265: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   268: aload 5
    //   270: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   273: ldc 211
    //   275: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   278: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   281: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   284: aload_2
    //   285: astore 4
    //   287: aload_3
    //   288: ifnull -79 -> 209
    //   291: aload_3
    //   292: invokeinterface 324 1 0
    //   297: aload_2
    //   298: areturn
    //   299: astore_3
    //   300: new 199	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   307: ldc 202
    //   309: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: aload_3
    //   313: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   316: ldc 211
    //   318: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   321: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   324: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   327: aload_2
    //   328: areturn
    //   329: astore_2
    //   330: aload_3
    //   331: ifnull +9 -> 340
    //   334: aload_3
    //   335: invokeinterface 324 1 0
    //   340: aload_2
    //   341: athrow
    //   342: astore_3
    //   343: new 199	java/lang/StringBuilder
    //   346: dup
    //   347: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   350: ldc 202
    //   352: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   355: aload_3
    //   356: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   359: ldc 211
    //   361: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   364: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   367: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   370: goto -30 -> 340
    //   373: astore_2
    //   374: aload 4
    //   376: astore_3
    //   377: goto -47 -> 330
    //   380: astore 5
    //   382: aconst_null
    //   383: astore_2
    //   384: goto -131 -> 253
    //   387: astore 5
    //   389: goto -136 -> 253
    //   392: aconst_null
    //   393: astore_2
    //   394: goto -253 -> 141
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	397	0	this	bs
    //   172	42	1	i	int
    //   11	317	2	localObject1	Object
    //   329	12	2	localObject2	Object
    //   373	1	2	localObject3	Object
    //   383	11	2	localObject4	Object
    //   1	200	3	localObject5	Object
    //   217	14	3	localThrowable1	Throwable
    //   250	42	3	localObject6	Object
    //   299	36	3	localThrowable2	Throwable
    //   342	14	3	localThrowable3	Throwable
    //   376	1	3	localObject7	Object
    //   133	242	4	localObject8	Object
    //   157	20	5	localStringBuilder	java.lang.StringBuilder
    //   247	22	5	localThrowable4	Throwable
    //   380	1	5	localThrowable5	Throwable
    //   387	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   200	206	217	java/lang/Throwable
    //   2	126	247	java/lang/Throwable
    //   291	297	299	java/lang/Throwable
    //   2	126	329	finally
    //   334	340	342	java/lang/Throwable
    //   135	141	373	finally
    //   144	159	373	finally
    //   166	173	373	finally
    //   176	193	373	finally
    //   256	284	373	finally
    //   135	141	380	java/lang/Throwable
    //   144	159	387	java/lang/Throwable
    //   166	173	387	java/lang/Throwable
    //   176	193	387	java/lang/Throwable
  }
  
  public void d(br parambr)
  {
    bo.k("updateDataItem:[" + parambr + "]");
    try
    {
      update("r_tb", f(parambr), "a=" + parambr.gz.gH, null);
      return;
    }
    catch (Throwable parambr)
    {
      bo.k("e:[" + parambr + "]");
    }
  }
  
  public void e(br parambr)
  {
    bo.k("insertDataItem:[" + parambr + "]");
    try
    {
      a("r_tb", f(parambr));
      return;
    }
    catch (Throwable parambr)
    {
      bo.k("e:[" + parambr + "]");
    }
  }
  
  /* Error */
  public int getCount()
  {
    // Byte code:
    //   0: new 199	java/lang/StringBuilder
    //   3: dup
    //   4: bipush 120
    //   6: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   9: astore_3
    //   10: aload_3
    //   11: ldc_w 351
    //   14: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   17: pop
    //   18: aload_3
    //   19: ldc_w 301
    //   22: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   25: pop
    //   26: aload_0
    //   27: aload_3
    //   28: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   31: invokespecial 319	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   34: astore_3
    //   35: aload_3
    //   36: ifnull +251 -> 287
    //   39: aload_3
    //   40: astore 4
    //   42: aload_3
    //   43: invokeinterface 197 1 0
    //   48: ifeq +239 -> 287
    //   51: aload_3
    //   52: astore 4
    //   54: aload_3
    //   55: iconst_0
    //   56: invokeinterface 115 2 0
    //   61: istore_1
    //   62: aload_3
    //   63: astore 4
    //   65: new 199	java/lang/StringBuilder
    //   68: dup
    //   69: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   72: ldc_w 353
    //   75: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   78: iload_1
    //   79: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: ldc 211
    //   84: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   87: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   93: iload_1
    //   94: istore_2
    //   95: aload_3
    //   96: ifnull +11 -> 107
    //   99: aload_3
    //   100: invokeinterface 324 1 0
    //   105: iload_1
    //   106: istore_2
    //   107: iload_2
    //   108: ireturn
    //   109: astore_3
    //   110: new 199	java/lang/StringBuilder
    //   113: dup
    //   114: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   117: ldc 202
    //   119: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: aload_3
    //   123: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   126: ldc 211
    //   128: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   131: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   134: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   137: iload_1
    //   138: ireturn
    //   139: astore 5
    //   141: aconst_null
    //   142: astore_3
    //   143: iconst_0
    //   144: istore_1
    //   145: aload_3
    //   146: astore 4
    //   148: new 199	java/lang/StringBuilder
    //   151: dup
    //   152: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   155: ldc 202
    //   157: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 5
    //   162: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   165: ldc 211
    //   167: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   176: iload_1
    //   177: istore_2
    //   178: aload_3
    //   179: ifnull -72 -> 107
    //   182: aload_3
    //   183: invokeinterface 324 1 0
    //   188: iload_1
    //   189: ireturn
    //   190: astore_3
    //   191: new 199	java/lang/StringBuilder
    //   194: dup
    //   195: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   198: ldc 202
    //   200: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   203: aload_3
    //   204: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   207: ldc 211
    //   209: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   215: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   218: iload_1
    //   219: ireturn
    //   220: astore_3
    //   221: aconst_null
    //   222: astore 4
    //   224: aload 4
    //   226: ifnull +10 -> 236
    //   229: aload 4
    //   231: invokeinterface 324 1 0
    //   236: aload_3
    //   237: athrow
    //   238: astore 4
    //   240: new 199	java/lang/StringBuilder
    //   243: dup
    //   244: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   247: ldc 202
    //   249: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   252: aload 4
    //   254: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   257: ldc 211
    //   259: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   262: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   265: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   268: goto -32 -> 236
    //   271: astore_3
    //   272: goto -48 -> 224
    //   275: astore 5
    //   277: iconst_0
    //   278: istore_1
    //   279: goto -134 -> 145
    //   282: astore 5
    //   284: goto -139 -> 145
    //   287: iconst_0
    //   288: istore_1
    //   289: goto -227 -> 62
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	292	0	this	bs
    //   61	228	1	i	int
    //   94	84	2	j	int
    //   9	91	3	localObject1	Object
    //   109	14	3	localThrowable1	Throwable
    //   142	41	3	localObject2	Object
    //   190	14	3	localThrowable2	Throwable
    //   220	17	3	localObject3	Object
    //   271	1	3	localObject4	Object
    //   40	190	4	localObject5	Object
    //   238	15	4	localThrowable3	Throwable
    //   139	22	5	localThrowable4	Throwable
    //   275	1	5	localThrowable5	Throwable
    //   282	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   99	105	109	java/lang/Throwable
    //   0	35	139	java/lang/Throwable
    //   182	188	190	java/lang/Throwable
    //   0	35	220	finally
    //   229	236	238	java/lang/Throwable
    //   42	51	271	finally
    //   54	62	271	finally
    //   65	93	271	finally
    //   148	176	271	finally
    //   42	51	275	java/lang/Throwable
    //   54	62	275	java/lang/Throwable
    //   65	93	282	java/lang/Throwable
  }
  
  /* Error */
  public br i(int paramInt)
  {
    // Byte code:
    //   0: new 199	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   7: ldc_w 356
    //   10: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   13: iload_1
    //   14: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   17: ldc 211
    //   19: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   22: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   25: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   28: new 199	java/lang/StringBuilder
    //   31: dup
    //   32: bipush 120
    //   34: invokespecial 297	java/lang/StringBuilder:<init>	(I)V
    //   37: astore_2
    //   38: aload_2
    //   39: ldc_w 299
    //   42: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: pop
    //   46: aload_2
    //   47: ldc_w 301
    //   50: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   53: pop
    //   54: aload_2
    //   55: ldc_w 303
    //   58: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: pop
    //   62: aload_2
    //   63: ldc 107
    //   65: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   68: pop
    //   69: aload_2
    //   70: ldc_w 305
    //   73: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   76: pop
    //   77: aload_2
    //   78: iload_1
    //   79: invokevirtual 308	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   82: pop
    //   83: aload_0
    //   84: aload_2
    //   85: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   88: invokespecial 319	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   91: astore_3
    //   92: aload_3
    //   93: ifnull +269 -> 362
    //   96: aload_3
    //   97: astore 4
    //   99: aload_0
    //   100: aload_3
    //   101: invokespecial 321	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   104: astore_2
    //   105: aload_2
    //   106: ifnull +256 -> 362
    //   109: aload_3
    //   110: astore 4
    //   112: aload_2
    //   113: invokeinterface 221 1 0
    //   118: ifle +244 -> 362
    //   121: aload_3
    //   122: astore 4
    //   124: aload_2
    //   125: iconst_0
    //   126: invokeinterface 360 2 0
    //   131: checkcast 98	btmsdkobf/br
    //   134: astore_2
    //   135: aload_3
    //   136: astore 4
    //   138: new 199	java/lang/StringBuilder
    //   141: dup
    //   142: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   145: ldc_w 362
    //   148: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   151: aload_2
    //   152: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   155: ldc 211
    //   157: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   163: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   166: aload_2
    //   167: astore 4
    //   169: aload_3
    //   170: ifnull +12 -> 182
    //   173: aload_3
    //   174: invokeinterface 324 1 0
    //   179: aload_2
    //   180: astore 4
    //   182: aload 4
    //   184: areturn
    //   185: astore_3
    //   186: new 199	java/lang/StringBuilder
    //   189: dup
    //   190: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   193: ldc 202
    //   195: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   198: aload_3
    //   199: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   202: ldc 211
    //   204: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   210: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   213: aload_2
    //   214: areturn
    //   215: astore 5
    //   217: aconst_null
    //   218: astore_3
    //   219: aconst_null
    //   220: astore_2
    //   221: aload_3
    //   222: astore 4
    //   224: new 199	java/lang/StringBuilder
    //   227: dup
    //   228: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   231: ldc 202
    //   233: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   236: aload 5
    //   238: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   241: ldc 211
    //   243: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   246: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   249: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   252: aload_2
    //   253: astore 4
    //   255: aload_3
    //   256: ifnull -74 -> 182
    //   259: aload_3
    //   260: invokeinterface 324 1 0
    //   265: aload_2
    //   266: areturn
    //   267: astore_3
    //   268: new 199	java/lang/StringBuilder
    //   271: dup
    //   272: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   275: ldc 202
    //   277: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   280: aload_3
    //   281: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   284: ldc 211
    //   286: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   289: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   295: aload_2
    //   296: areturn
    //   297: astore_2
    //   298: aconst_null
    //   299: astore 4
    //   301: aload 4
    //   303: ifnull +10 -> 313
    //   306: aload 4
    //   308: invokeinterface 324 1 0
    //   313: aload_2
    //   314: athrow
    //   315: astore_3
    //   316: new 199	java/lang/StringBuilder
    //   319: dup
    //   320: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   323: ldc 202
    //   325: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: aload_3
    //   329: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   332: ldc 211
    //   334: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   337: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   340: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   343: goto -30 -> 313
    //   346: astore_2
    //   347: goto -46 -> 301
    //   350: astore 5
    //   352: aconst_null
    //   353: astore_2
    //   354: goto -133 -> 221
    //   357: astore 5
    //   359: goto -138 -> 221
    //   362: aconst_null
    //   363: astore_2
    //   364: goto -229 -> 135
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	367	0	this	bs
    //   0	367	1	paramInt	int
    //   37	259	2	localObject1	Object
    //   297	17	2	localObject2	Object
    //   346	1	2	localObject3	Object
    //   353	11	2	localObject4	Object
    //   91	83	3	localCursor	Cursor
    //   185	14	3	localThrowable1	Throwable
    //   218	42	3	localObject5	Object
    //   267	14	3	localThrowable2	Throwable
    //   315	14	3	localThrowable3	Throwable
    //   97	210	4	localObject6	Object
    //   215	22	5	localThrowable4	Throwable
    //   350	1	5	localThrowable5	Throwable
    //   357	1	5	localThrowable6	Throwable
    // Exception table:
    //   from	to	target	type
    //   173	179	185	java/lang/Throwable
    //   28	92	215	java/lang/Throwable
    //   259	265	267	java/lang/Throwable
    //   28	92	297	finally
    //   306	313	315	java/lang/Throwable
    //   99	105	346	finally
    //   112	121	346	finally
    //   124	135	346	finally
    //   138	166	346	finally
    //   224	252	346	finally
    //   99	105	350	java/lang/Throwable
    //   112	121	350	java/lang/Throwable
    //   124	135	350	java/lang/Throwable
    //   138	166	357	java/lang/Throwable
  }
  
  public void j(int paramInt)
  {
    bo.k("deleteDataItem-id:[" + paramInt + "]");
    try
    {
      delete("r_tb", "a=" + paramInt, null);
      return;
    }
    catch (Throwable localThrowable)
    {
      bo.k("e:[" + localThrowable + "]");
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bs
 * JD-Core Version:    0.7.0.1
 */