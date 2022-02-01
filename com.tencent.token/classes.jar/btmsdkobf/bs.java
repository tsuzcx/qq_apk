package btmsdkobf;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;
import com.qq.taf.jce.HexUtil;
import java.util.ArrayList;
import java.util.List;
import tmsdk.common.tcc.b;

public class bs
{
  static bs gC;
  private static Object gD = new Object();
  private SQLiteOpenHelper gE;
  private final String gF = "CREATE TABLE IF NOT EXISTS r_tb (a INTEGER PRIMARY KEY,f INTEGER,b INTEGER,c INTEGER,d INTEGER,e LONG,i TEXT,j TEXT,k INTEGER,l INTEGER)";
  
  private bs()
  {
    bo.k("DataManager-DataManager");
    this.gE = new SQLiteOpenHelper(bc.n(), "r.db", null, 10)
    {
      public void onCreate(SQLiteDatabase paramAnonymousSQLiteDatabase)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onCreate-db:[");
        localStringBuilder.append(paramAnonymousSQLiteDatabase);
        localStringBuilder.append("]");
        bo.k(localStringBuilder.toString());
        bs.a(bs.this, paramAnonymousSQLiteDatabase);
      }
      
      public void onDowngrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onDowngrade-db:[");
        localStringBuilder.append(paramAnonymousSQLiteDatabase);
        localStringBuilder.append("]oldVersion:[");
        localStringBuilder.append(paramAnonymousInt1);
        localStringBuilder.append("]newVersion:[");
        localStringBuilder.append(paramAnonymousInt2);
        localStringBuilder.append("]");
        bo.k(localStringBuilder.toString());
      }
      
      public void onUpgrade(SQLiteDatabase paramAnonymousSQLiteDatabase, int paramAnonymousInt1, int paramAnonymousInt2)
      {
        StringBuilder localStringBuilder = new StringBuilder();
        localStringBuilder.append("onUpgrade-db:[");
        localStringBuilder.append(paramAnonymousSQLiteDatabase);
        localStringBuilder.append("]oldVersion:[");
        localStringBuilder.append(paramAnonymousInt1);
        localStringBuilder.append("]newVersion:[");
        localStringBuilder.append(paramAnonymousInt2);
        localStringBuilder.append("]");
        bo.k(localStringBuilder.toString());
        bs.a(bs.this, paramAnonymousSQLiteDatabase, paramAnonymousInt1, paramAnonymousInt2);
      }
    };
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
  
  public static bs ac()
  {
    try
    {
      if (gC == null) {
        try
        {
          if (gC == null) {
            gC = new bs();
          }
        }
        finally {}
      }
      return gC;
    }
    finally {}
  }
  
  private List<br> b(Cursor paramCursor)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      paramCursor.moveToFirst();
      Object localObject;
      while (!paramCursor.isAfterLast())
      {
        localObject = new br();
        ((br)localObject).gz = new bt();
        ((br)localObject).gz.gH = paramCursor.getInt(paramCursor.getColumnIndex("a"));
        ((br)localObject).gz.gI = paramCursor.getInt(paramCursor.getColumnIndex("b"));
        ((br)localObject).gz.gJ = paramCursor.getInt(paramCursor.getColumnIndex("c"));
        ((br)localObject).gz.gK = paramCursor.getInt(paramCursor.getColumnIndex("d"));
        ((br)localObject).gz.gL = paramCursor.getLong(paramCursor.getColumnIndex("e"));
        ((br)localObject).gz.gM = paramCursor.getInt(paramCursor.getColumnIndex("f"));
        ((br)localObject).gz.gN = paramCursor.getString(paramCursor.getColumnIndex("i"));
        String str = new String(b.decrypt(HexUtil.hexStr2Bytes(paramCursor.getString(paramCursor.getColumnIndex("j"))), null));
        ((br)localObject).gz.gO = str;
        ((br)localObject).gA = paramCursor.getInt(paramCursor.getColumnIndex("k"));
        ((br)localObject).gB = paramCursor.getInt(paramCursor.getColumnIndex("l"));
        localArrayList.add(localObject);
        paramCursor.moveToNext();
      }
      return paramCursor;
    }
    catch (Throwable paramCursor)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("e:[");
      ((StringBuilder)localObject).append(paramCursor);
      ((StringBuilder)localObject).append("]");
      bo.l(((StringBuilder)localObject).toString());
      paramCursor = localArrayList;
      if (localArrayList.size() == 0) {
        paramCursor = null;
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
  
  private void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2) {}
  
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
  public List<br> ae()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 6
    //   6: aconst_null
    //   7: astore 8
    //   9: aconst_null
    //   10: astore 7
    //   12: aload 6
    //   14: astore 4
    //   16: invokestatic 296	java/lang/System:currentTimeMillis	()J
    //   19: lstore_2
    //   20: aload 6
    //   22: astore 4
    //   24: new 199	java/lang/StringBuilder
    //   27: dup
    //   28: bipush 120
    //   30: invokespecial 299	java/lang/StringBuilder:<init>	(I)V
    //   33: astore 9
    //   35: aload 6
    //   37: astore 4
    //   39: aload 9
    //   41: ldc_w 301
    //   44: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   47: pop
    //   48: aload 6
    //   50: astore 4
    //   52: aload 9
    //   54: ldc_w 303
    //   57: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 6
    //   63: astore 4
    //   65: aload 9
    //   67: ldc_w 305
    //   70: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   73: pop
    //   74: aload 6
    //   76: astore 4
    //   78: aload 9
    //   80: ldc 180
    //   82: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: pop
    //   86: aload 6
    //   88: astore 4
    //   90: aload 9
    //   92: ldc_w 307
    //   95: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   98: pop
    //   99: aload 6
    //   101: astore 4
    //   103: aload 9
    //   105: iconst_2
    //   106: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   109: pop
    //   110: aload 6
    //   112: astore 4
    //   114: aload 9
    //   116: ldc_w 312
    //   119: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   122: pop
    //   123: aload 6
    //   125: astore 4
    //   127: aload 9
    //   129: ldc 135
    //   131: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   134: pop
    //   135: aload 6
    //   137: astore 4
    //   139: aload 9
    //   141: ldc_w 314
    //   144: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: pop
    //   148: aload 6
    //   150: astore 4
    //   152: aload 9
    //   154: lload_2
    //   155: invokevirtual 317	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   158: pop
    //   159: aload 6
    //   161: astore 4
    //   163: new 199	java/lang/StringBuilder
    //   166: dup
    //   167: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   170: astore 10
    //   172: aload 6
    //   174: astore 4
    //   176: aload 10
    //   178: ldc_w 319
    //   181: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   184: pop
    //   185: aload 6
    //   187: astore 4
    //   189: aload 10
    //   191: aload 9
    //   193: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 6
    //   202: astore 4
    //   204: aload 10
    //   206: ldc 211
    //   208: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   211: pop
    //   212: aload 6
    //   214: astore 4
    //   216: aload 10
    //   218: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   221: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   224: aload 6
    //   226: astore 4
    //   228: aload_0
    //   229: aload 9
    //   231: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   234: invokespecial 321	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   237: astore 6
    //   239: aload 7
    //   241: astore 4
    //   243: aload 6
    //   245: ifnull +11 -> 256
    //   248: aload_0
    //   249: aload 6
    //   251: invokespecial 323	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   254: astore 4
    //   256: aload 4
    //   258: astore 5
    //   260: new 199	java/lang/StringBuilder
    //   263: dup
    //   264: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   267: astore 7
    //   269: aload 4
    //   271: astore 5
    //   273: aload 7
    //   275: ldc_w 325
    //   278: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   281: pop
    //   282: aload 4
    //   284: ifnull +337 -> 621
    //   287: aload 4
    //   289: astore 5
    //   291: aload 4
    //   293: invokeinterface 221 1 0
    //   298: istore_1
    //   299: goto +3 -> 302
    //   302: aload 4
    //   304: astore 5
    //   306: aload 7
    //   308: iload_1
    //   309: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   312: pop
    //   313: aload 4
    //   315: astore 5
    //   317: aload 7
    //   319: ldc 211
    //   321: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   324: pop
    //   325: aload 4
    //   327: astore 5
    //   329: aload 7
    //   331: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   334: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   337: aload 4
    //   339: astore 5
    //   341: aload 6
    //   343: ifnull +214 -> 557
    //   346: aload 6
    //   348: invokeinterface 326 1 0
    //   353: aload 4
    //   355: areturn
    //   356: astore 5
    //   358: new 199	java/lang/StringBuilder
    //   361: dup
    //   362: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   365: astore 6
    //   367: aload 6
    //   369: ldc 202
    //   371: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   374: pop
    //   375: aload 6
    //   377: aload 5
    //   379: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   382: pop
    //   383: aload 6
    //   385: ldc 211
    //   387: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   390: pop
    //   391: aload 6
    //   393: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   396: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   399: aload 4
    //   401: areturn
    //   402: astore 4
    //   404: aload 6
    //   406: astore 5
    //   408: goto +152 -> 560
    //   411: astore 7
    //   413: goto +25 -> 438
    //   416: astore 6
    //   418: aload 4
    //   420: astore 5
    //   422: aload 6
    //   424: astore 4
    //   426: goto +134 -> 560
    //   429: astore 7
    //   431: aconst_null
    //   432: astore 5
    //   434: aload 8
    //   436: astore 6
    //   438: aload 6
    //   440: astore 4
    //   442: new 199	java/lang/StringBuilder
    //   445: dup
    //   446: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   449: astore 8
    //   451: aload 6
    //   453: astore 4
    //   455: aload 8
    //   457: ldc 202
    //   459: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 6
    //   465: astore 4
    //   467: aload 8
    //   469: aload 7
    //   471: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   474: pop
    //   475: aload 6
    //   477: astore 4
    //   479: aload 8
    //   481: ldc 211
    //   483: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 6
    //   489: astore 4
    //   491: aload 8
    //   493: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   496: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   499: aload 6
    //   501: ifnull +56 -> 557
    //   504: aload 6
    //   506: invokeinterface 326 1 0
    //   511: goto +46 -> 557
    //   514: astore 4
    //   516: new 199	java/lang/StringBuilder
    //   519: dup
    //   520: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   523: astore 6
    //   525: aload 6
    //   527: ldc 202
    //   529: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 6
    //   535: aload 4
    //   537: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   540: pop
    //   541: aload 6
    //   543: ldc 211
    //   545: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   548: pop
    //   549: aload 6
    //   551: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   554: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   557: aload 5
    //   559: areturn
    //   560: aload 5
    //   562: ifnull +56 -> 618
    //   565: aload 5
    //   567: invokeinterface 326 1 0
    //   572: goto +46 -> 618
    //   575: astore 5
    //   577: new 199	java/lang/StringBuilder
    //   580: dup
    //   581: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   584: astore 6
    //   586: aload 6
    //   588: ldc 202
    //   590: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   593: pop
    //   594: aload 6
    //   596: aload 5
    //   598: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   601: pop
    //   602: aload 6
    //   604: ldc 211
    //   606: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   609: pop
    //   610: aload 6
    //   612: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   615: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   618: aload 4
    //   620: athrow
    //   621: iconst_0
    //   622: istore_1
    //   623: goto -321 -> 302
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	this	bs
    //   298	325	1	i	int
    //   19	136	2	l	long
    //   14	386	4	localObject1	Object
    //   402	17	4	localObject2	Object
    //   424	66	4	localObject3	Object
    //   514	105	4	localThrowable1	Throwable
    //   1	339	5	localObject4	Object
    //   356	22	5	localThrowable2	Throwable
    //   406	160	5	localObject5	Object
    //   575	22	5	localThrowable3	Throwable
    //   4	401	6	localObject6	Object
    //   416	7	6	localObject7	Object
    //   436	175	6	localObject8	Object
    //   10	320	7	localStringBuilder1	StringBuilder
    //   411	1	7	localThrowable4	Throwable
    //   429	41	7	localThrowable5	Throwable
    //   7	485	8	localStringBuilder2	StringBuilder
    //   33	197	9	localStringBuilder3	StringBuilder
    //   170	47	10	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   346	353	356	java/lang/Throwable
    //   248	256	402	finally
    //   260	269	402	finally
    //   273	282	402	finally
    //   291	299	402	finally
    //   306	313	402	finally
    //   317	325	402	finally
    //   329	337	402	finally
    //   248	256	411	java/lang/Throwable
    //   260	269	411	java/lang/Throwable
    //   273	282	411	java/lang/Throwable
    //   291	299	411	java/lang/Throwable
    //   306	313	411	java/lang/Throwable
    //   317	325	411	java/lang/Throwable
    //   329	337	411	java/lang/Throwable
    //   16	20	416	finally
    //   24	35	416	finally
    //   39	48	416	finally
    //   52	61	416	finally
    //   65	74	416	finally
    //   78	86	416	finally
    //   90	99	416	finally
    //   103	110	416	finally
    //   114	123	416	finally
    //   127	135	416	finally
    //   139	148	416	finally
    //   152	159	416	finally
    //   163	172	416	finally
    //   176	185	416	finally
    //   189	200	416	finally
    //   204	212	416	finally
    //   216	224	416	finally
    //   228	239	416	finally
    //   442	451	416	finally
    //   455	463	416	finally
    //   467	475	416	finally
    //   479	487	416	finally
    //   491	499	416	finally
    //   16	20	429	java/lang/Throwable
    //   24	35	429	java/lang/Throwable
    //   39	48	429	java/lang/Throwable
    //   52	61	429	java/lang/Throwable
    //   65	74	429	java/lang/Throwable
    //   78	86	429	java/lang/Throwable
    //   90	99	429	java/lang/Throwable
    //   103	110	429	java/lang/Throwable
    //   114	123	429	java/lang/Throwable
    //   127	135	429	java/lang/Throwable
    //   139	148	429	java/lang/Throwable
    //   152	159	429	java/lang/Throwable
    //   163	172	429	java/lang/Throwable
    //   176	185	429	java/lang/Throwable
    //   189	200	429	java/lang/Throwable
    //   204	212	429	java/lang/Throwable
    //   216	224	429	java/lang/Throwable
    //   228	239	429	java/lang/Throwable
    //   504	511	514	java/lang/Throwable
    //   565	572	575	java/lang/Throwable
  }
  
  /* Error */
  public List<br> af()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: new 199	java/lang/StringBuilder
    //   17: dup
    //   18: bipush 120
    //   20: invokespecial 299	java/lang/StringBuilder:<init>	(I)V
    //   23: astore 7
    //   25: aload 4
    //   27: astore_2
    //   28: aload 7
    //   30: ldc_w 301
    //   33: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: astore_2
    //   40: aload 7
    //   42: ldc_w 303
    //   45: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: astore_2
    //   52: aload 7
    //   54: ldc_w 305
    //   57: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 4
    //   63: astore_2
    //   64: aload 7
    //   66: ldc 185
    //   68: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: astore_2
    //   75: aload 7
    //   77: ldc_w 307
    //   80: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 4
    //   86: astore_2
    //   87: aload 7
    //   89: iconst_1
    //   90: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: astore_2
    //   97: aload 7
    //   99: ldc_w 312
    //   102: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: astore_2
    //   109: aload 7
    //   111: ldc 185
    //   113: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: astore_2
    //   120: aload 7
    //   122: ldc_w 307
    //   125: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: astore_2
    //   132: aload 7
    //   134: iconst_2
    //   135: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_2
    //   142: aload 7
    //   144: ldc_w 330
    //   147: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   150: pop
    //   151: aload 4
    //   153: astore_2
    //   154: aload 7
    //   156: ldc 180
    //   158: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   161: pop
    //   162: aload 4
    //   164: astore_2
    //   165: aload 7
    //   167: ldc_w 307
    //   170: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: pop
    //   174: aload 4
    //   176: astore_2
    //   177: aload 7
    //   179: iconst_1
    //   180: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   183: pop
    //   184: aload 4
    //   186: astore_2
    //   187: new 199	java/lang/StringBuilder
    //   190: dup
    //   191: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   194: astore 8
    //   196: aload 4
    //   198: astore_2
    //   199: aload 8
    //   201: ldc_w 332
    //   204: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: pop
    //   208: aload 4
    //   210: astore_2
    //   211: aload 8
    //   213: aload 7
    //   215: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   218: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   221: pop
    //   222: aload 4
    //   224: astore_2
    //   225: aload 8
    //   227: ldc 211
    //   229: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload 4
    //   235: astore_2
    //   236: aload 8
    //   238: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   241: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   244: aload 4
    //   246: astore_2
    //   247: aload_0
    //   248: aload 7
    //   250: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   253: invokespecial 321	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   256: astore 4
    //   258: aload 5
    //   260: astore_2
    //   261: aload 4
    //   263: ifnull +10 -> 273
    //   266: aload_0
    //   267: aload 4
    //   269: invokespecial 323	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   272: astore_2
    //   273: aload_2
    //   274: astore_3
    //   275: new 199	java/lang/StringBuilder
    //   278: dup
    //   279: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   282: astore 5
    //   284: aload_2
    //   285: astore_3
    //   286: aload 5
    //   288: ldc_w 334
    //   291: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   294: pop
    //   295: aload_2
    //   296: ifnull +303 -> 599
    //   299: aload_2
    //   300: astore_3
    //   301: aload_2
    //   302: invokeinterface 221 1 0
    //   307: istore_1
    //   308: goto +3 -> 311
    //   311: aload_2
    //   312: astore_3
    //   313: aload 5
    //   315: iload_1
    //   316: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   319: pop
    //   320: aload_2
    //   321: astore_3
    //   322: aload 5
    //   324: ldc 211
    //   326: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   329: pop
    //   330: aload_2
    //   331: astore_3
    //   332: aload 5
    //   334: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   337: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   340: aload_2
    //   341: astore_3
    //   342: aload 4
    //   344: ifnull +197 -> 541
    //   347: aload 4
    //   349: invokeinterface 326 1 0
    //   354: aload_2
    //   355: areturn
    //   356: astore_3
    //   357: new 199	java/lang/StringBuilder
    //   360: dup
    //   361: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   364: astore 4
    //   366: aload 4
    //   368: ldc 202
    //   370: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   373: pop
    //   374: aload 4
    //   376: aload_3
    //   377: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   380: pop
    //   381: aload 4
    //   383: ldc 211
    //   385: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   388: pop
    //   389: aload 4
    //   391: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   394: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   397: aload_2
    //   398: areturn
    //   399: astore_2
    //   400: aload 4
    //   402: astore_3
    //   403: goto +140 -> 543
    //   406: astore 5
    //   408: goto +21 -> 429
    //   411: astore 4
    //   413: aload_2
    //   414: astore_3
    //   415: aload 4
    //   417: astore_2
    //   418: goto +125 -> 543
    //   421: astore 5
    //   423: aconst_null
    //   424: astore_3
    //   425: aload 6
    //   427: astore 4
    //   429: aload 4
    //   431: astore_2
    //   432: new 199	java/lang/StringBuilder
    //   435: dup
    //   436: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   439: astore 6
    //   441: aload 4
    //   443: astore_2
    //   444: aload 6
    //   446: ldc 202
    //   448: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   451: pop
    //   452: aload 4
    //   454: astore_2
    //   455: aload 6
    //   457: aload 5
    //   459: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   462: pop
    //   463: aload 4
    //   465: astore_2
    //   466: aload 6
    //   468: ldc 211
    //   470: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   473: pop
    //   474: aload 4
    //   476: astore_2
    //   477: aload 6
    //   479: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   482: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   485: aload 4
    //   487: ifnull +54 -> 541
    //   490: aload 4
    //   492: invokeinterface 326 1 0
    //   497: goto +44 -> 541
    //   500: astore_2
    //   501: new 199	java/lang/StringBuilder
    //   504: dup
    //   505: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   508: astore 4
    //   510: aload 4
    //   512: ldc 202
    //   514: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   517: pop
    //   518: aload 4
    //   520: aload_2
    //   521: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   524: pop
    //   525: aload 4
    //   527: ldc 211
    //   529: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   532: pop
    //   533: aload 4
    //   535: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   538: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   541: aload_3
    //   542: areturn
    //   543: aload_3
    //   544: ifnull +53 -> 597
    //   547: aload_3
    //   548: invokeinterface 326 1 0
    //   553: goto +44 -> 597
    //   556: astore_3
    //   557: new 199	java/lang/StringBuilder
    //   560: dup
    //   561: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   564: astore 4
    //   566: aload 4
    //   568: ldc 202
    //   570: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   573: pop
    //   574: aload 4
    //   576: aload_3
    //   577: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   580: pop
    //   581: aload 4
    //   583: ldc 211
    //   585: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   588: pop
    //   589: aload 4
    //   591: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   594: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   597: aload_2
    //   598: athrow
    //   599: iconst_0
    //   600: istore_1
    //   601: goto -290 -> 311
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	604	0	this	bs
    //   307	294	1	i	int
    //   13	385	2	localObject1	Object
    //   399	15	2	localObject2	Object
    //   417	60	2	localObject3	Object
    //   500	98	2	localThrowable1	Throwable
    //   1	341	3	localObject4	Object
    //   356	21	3	localThrowable2	Throwable
    //   402	146	3	localObject5	Object
    //   556	21	3	localThrowable3	Throwable
    //   3	398	4	localObject6	Object
    //   411	5	4	localObject7	Object
    //   427	163	4	localObject8	Object
    //   9	324	5	localStringBuilder1	StringBuilder
    //   406	1	5	localThrowable4	Throwable
    //   421	37	5	localThrowable5	Throwable
    //   6	472	6	localStringBuilder2	StringBuilder
    //   23	226	7	localStringBuilder3	StringBuilder
    //   194	43	8	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   347	354	356	java/lang/Throwable
    //   266	273	399	finally
    //   275	284	399	finally
    //   286	295	399	finally
    //   301	308	399	finally
    //   313	320	399	finally
    //   322	330	399	finally
    //   332	340	399	finally
    //   266	273	406	java/lang/Throwable
    //   275	284	406	java/lang/Throwable
    //   286	295	406	java/lang/Throwable
    //   301	308	406	java/lang/Throwable
    //   313	320	406	java/lang/Throwable
    //   322	330	406	java/lang/Throwable
    //   332	340	406	java/lang/Throwable
    //   14	25	411	finally
    //   28	37	411	finally
    //   40	49	411	finally
    //   52	61	411	finally
    //   64	72	411	finally
    //   75	84	411	finally
    //   87	94	411	finally
    //   97	106	411	finally
    //   109	117	411	finally
    //   120	129	411	finally
    //   132	139	411	finally
    //   142	151	411	finally
    //   154	162	411	finally
    //   165	174	411	finally
    //   177	184	411	finally
    //   187	196	411	finally
    //   199	208	411	finally
    //   211	222	411	finally
    //   225	233	411	finally
    //   236	244	411	finally
    //   247	258	411	finally
    //   432	441	411	finally
    //   444	452	411	finally
    //   455	463	411	finally
    //   466	474	411	finally
    //   477	485	411	finally
    //   14	25	421	java/lang/Throwable
    //   28	37	421	java/lang/Throwable
    //   40	49	421	java/lang/Throwable
    //   52	61	421	java/lang/Throwable
    //   64	72	421	java/lang/Throwable
    //   75	84	421	java/lang/Throwable
    //   87	94	421	java/lang/Throwable
    //   97	106	421	java/lang/Throwable
    //   109	117	421	java/lang/Throwable
    //   120	129	421	java/lang/Throwable
    //   132	139	421	java/lang/Throwable
    //   142	151	421	java/lang/Throwable
    //   154	162	421	java/lang/Throwable
    //   165	174	421	java/lang/Throwable
    //   177	184	421	java/lang/Throwable
    //   187	196	421	java/lang/Throwable
    //   199	208	421	java/lang/Throwable
    //   211	222	421	java/lang/Throwable
    //   225	233	421	java/lang/Throwable
    //   236	244	421	java/lang/Throwable
    //   247	258	421	java/lang/Throwable
    //   490	497	500	java/lang/Throwable
    //   547	553	556	java/lang/Throwable
  }
  
  /* Error */
  public List<br> ag()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore 4
    //   5: aconst_null
    //   6: astore 6
    //   8: aconst_null
    //   9: astore 5
    //   11: aload 4
    //   13: astore_2
    //   14: new 199	java/lang/StringBuilder
    //   17: dup
    //   18: bipush 120
    //   20: invokespecial 299	java/lang/StringBuilder:<init>	(I)V
    //   23: astore 7
    //   25: aload 4
    //   27: astore_2
    //   28: aload 7
    //   30: ldc_w 301
    //   33: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: pop
    //   37: aload 4
    //   39: astore_2
    //   40: aload 7
    //   42: ldc_w 303
    //   45: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   48: pop
    //   49: aload 4
    //   51: astore_2
    //   52: aload 7
    //   54: ldc_w 305
    //   57: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   60: pop
    //   61: aload 4
    //   63: astore_2
    //   64: aload 7
    //   66: ldc 185
    //   68: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   71: pop
    //   72: aload 4
    //   74: astore_2
    //   75: aload 7
    //   77: ldc_w 307
    //   80: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   83: pop
    //   84: aload 4
    //   86: astore_2
    //   87: aload 7
    //   89: iconst_3
    //   90: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   93: pop
    //   94: aload 4
    //   96: astore_2
    //   97: aload 7
    //   99: ldc_w 330
    //   102: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   105: pop
    //   106: aload 4
    //   108: astore_2
    //   109: aload 7
    //   111: ldc 130
    //   113: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   116: pop
    //   117: aload 4
    //   119: astore_2
    //   120: aload 7
    //   122: ldc_w 307
    //   125: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   128: pop
    //   129: aload 4
    //   131: astore_2
    //   132: aload 7
    //   134: iconst_1
    //   135: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   138: pop
    //   139: aload 4
    //   141: astore_2
    //   142: new 199	java/lang/StringBuilder
    //   145: dup
    //   146: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   149: astore 8
    //   151: aload 4
    //   153: astore_2
    //   154: aload 8
    //   156: ldc_w 337
    //   159: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   162: pop
    //   163: aload 4
    //   165: astore_2
    //   166: aload 8
    //   168: aload 7
    //   170: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   176: pop
    //   177: aload 4
    //   179: astore_2
    //   180: aload 8
    //   182: ldc 211
    //   184: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   187: pop
    //   188: aload 4
    //   190: astore_2
    //   191: aload 8
    //   193: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   196: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   199: aload 4
    //   201: astore_2
    //   202: aload_0
    //   203: aload 7
    //   205: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   208: invokespecial 321	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   211: astore 4
    //   213: aload 5
    //   215: astore_2
    //   216: aload 4
    //   218: ifnull +10 -> 228
    //   221: aload_0
    //   222: aload 4
    //   224: invokespecial 323	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   227: astore_2
    //   228: aload_2
    //   229: astore_3
    //   230: new 199	java/lang/StringBuilder
    //   233: dup
    //   234: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   237: astore 5
    //   239: aload_2
    //   240: astore_3
    //   241: aload 5
    //   243: ldc_w 339
    //   246: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   249: pop
    //   250: aload_2
    //   251: ifnull +303 -> 554
    //   254: aload_2
    //   255: astore_3
    //   256: aload_2
    //   257: invokeinterface 221 1 0
    //   262: istore_1
    //   263: goto +3 -> 266
    //   266: aload_2
    //   267: astore_3
    //   268: aload 5
    //   270: iload_1
    //   271: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   274: pop
    //   275: aload_2
    //   276: astore_3
    //   277: aload 5
    //   279: ldc 211
    //   281: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   284: pop
    //   285: aload_2
    //   286: astore_3
    //   287: aload 5
    //   289: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   295: aload_2
    //   296: astore_3
    //   297: aload 4
    //   299: ifnull +197 -> 496
    //   302: aload 4
    //   304: invokeinterface 326 1 0
    //   309: aload_2
    //   310: areturn
    //   311: astore_3
    //   312: new 199	java/lang/StringBuilder
    //   315: dup
    //   316: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   319: astore 4
    //   321: aload 4
    //   323: ldc 202
    //   325: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 4
    //   331: aload_3
    //   332: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   335: pop
    //   336: aload 4
    //   338: ldc 211
    //   340: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   343: pop
    //   344: aload 4
    //   346: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   349: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   352: aload_2
    //   353: areturn
    //   354: astore_2
    //   355: aload 4
    //   357: astore_3
    //   358: goto +140 -> 498
    //   361: astore 5
    //   363: goto +21 -> 384
    //   366: astore 4
    //   368: aload_2
    //   369: astore_3
    //   370: aload 4
    //   372: astore_2
    //   373: goto +125 -> 498
    //   376: astore 5
    //   378: aconst_null
    //   379: astore_3
    //   380: aload 6
    //   382: astore 4
    //   384: aload 4
    //   386: astore_2
    //   387: new 199	java/lang/StringBuilder
    //   390: dup
    //   391: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   394: astore 6
    //   396: aload 4
    //   398: astore_2
    //   399: aload 6
    //   401: ldc 202
    //   403: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   406: pop
    //   407: aload 4
    //   409: astore_2
    //   410: aload 6
    //   412: aload 5
    //   414: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload 4
    //   420: astore_2
    //   421: aload 6
    //   423: ldc 211
    //   425: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   428: pop
    //   429: aload 4
    //   431: astore_2
    //   432: aload 6
    //   434: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   437: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   440: aload 4
    //   442: ifnull +54 -> 496
    //   445: aload 4
    //   447: invokeinterface 326 1 0
    //   452: goto +44 -> 496
    //   455: astore_2
    //   456: new 199	java/lang/StringBuilder
    //   459: dup
    //   460: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   463: astore 4
    //   465: aload 4
    //   467: ldc 202
    //   469: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   472: pop
    //   473: aload 4
    //   475: aload_2
    //   476: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   479: pop
    //   480: aload 4
    //   482: ldc 211
    //   484: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   487: pop
    //   488: aload 4
    //   490: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   493: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   496: aload_3
    //   497: areturn
    //   498: aload_3
    //   499: ifnull +53 -> 552
    //   502: aload_3
    //   503: invokeinterface 326 1 0
    //   508: goto +44 -> 552
    //   511: astore_3
    //   512: new 199	java/lang/StringBuilder
    //   515: dup
    //   516: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   519: astore 4
    //   521: aload 4
    //   523: ldc 202
    //   525: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   528: pop
    //   529: aload 4
    //   531: aload_3
    //   532: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   535: pop
    //   536: aload 4
    //   538: ldc 211
    //   540: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   543: pop
    //   544: aload 4
    //   546: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   549: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   552: aload_2
    //   553: athrow
    //   554: iconst_0
    //   555: istore_1
    //   556: goto -290 -> 266
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	559	0	this	bs
    //   262	294	1	i	int
    //   13	340	2	localObject1	Object
    //   354	15	2	localObject2	Object
    //   372	60	2	localObject3	Object
    //   455	98	2	localThrowable1	Throwable
    //   1	296	3	localObject4	Object
    //   311	21	3	localThrowable2	Throwable
    //   357	146	3	localObject5	Object
    //   511	21	3	localThrowable3	Throwable
    //   3	353	4	localObject6	Object
    //   366	5	4	localObject7	Object
    //   382	163	4	localObject8	Object
    //   9	279	5	localStringBuilder1	StringBuilder
    //   361	1	5	localThrowable4	Throwable
    //   376	37	5	localThrowable5	Throwable
    //   6	427	6	localStringBuilder2	StringBuilder
    //   23	181	7	localStringBuilder3	StringBuilder
    //   149	43	8	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   302	309	311	java/lang/Throwable
    //   221	228	354	finally
    //   230	239	354	finally
    //   241	250	354	finally
    //   256	263	354	finally
    //   268	275	354	finally
    //   277	285	354	finally
    //   287	295	354	finally
    //   221	228	361	java/lang/Throwable
    //   230	239	361	java/lang/Throwable
    //   241	250	361	java/lang/Throwable
    //   256	263	361	java/lang/Throwable
    //   268	275	361	java/lang/Throwable
    //   277	285	361	java/lang/Throwable
    //   287	295	361	java/lang/Throwable
    //   14	25	366	finally
    //   28	37	366	finally
    //   40	49	366	finally
    //   52	61	366	finally
    //   64	72	366	finally
    //   75	84	366	finally
    //   87	94	366	finally
    //   97	106	366	finally
    //   109	117	366	finally
    //   120	129	366	finally
    //   132	139	366	finally
    //   142	151	366	finally
    //   154	163	366	finally
    //   166	177	366	finally
    //   180	188	366	finally
    //   191	199	366	finally
    //   202	213	366	finally
    //   387	396	366	finally
    //   399	407	366	finally
    //   410	418	366	finally
    //   421	429	366	finally
    //   432	440	366	finally
    //   14	25	376	java/lang/Throwable
    //   28	37	376	java/lang/Throwable
    //   40	49	376	java/lang/Throwable
    //   52	61	376	java/lang/Throwable
    //   64	72	376	java/lang/Throwable
    //   75	84	376	java/lang/Throwable
    //   87	94	376	java/lang/Throwable
    //   97	106	376	java/lang/Throwable
    //   109	117	376	java/lang/Throwable
    //   120	129	376	java/lang/Throwable
    //   132	139	376	java/lang/Throwable
    //   142	151	376	java/lang/Throwable
    //   154	163	376	java/lang/Throwable
    //   166	177	376	java/lang/Throwable
    //   180	188	376	java/lang/Throwable
    //   191	199	376	java/lang/Throwable
    //   202	213	376	java/lang/Throwable
    //   445	452	455	java/lang/Throwable
    //   502	508	511	java/lang/Throwable
  }
  
  public void d(br parambr)
  {
    Object localObject = new StringBuilder();
    ((StringBuilder)localObject).append("updateDataItem:[");
    ((StringBuilder)localObject).append(parambr);
    ((StringBuilder)localObject).append("]");
    bo.k(((StringBuilder)localObject).toString());
    try
    {
      localObject = f(parambr);
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append("a=");
      localStringBuilder.append(parambr.gz.gH);
      update("r_tb", (ContentValues)localObject, localStringBuilder.toString(), null);
      return;
    }
    catch (Throwable parambr)
    {
      localObject = new StringBuilder();
      ((StringBuilder)localObject).append("e:[");
      ((StringBuilder)localObject).append(parambr);
      ((StringBuilder)localObject).append("]");
      bo.k(((StringBuilder)localObject).toString());
    }
  }
  
  public void e(br parambr)
  {
    StringBuilder localStringBuilder = new StringBuilder();
    localStringBuilder.append("insertDataItem:[");
    localStringBuilder.append(parambr);
    localStringBuilder.append("]");
    bo.k(localStringBuilder.toString());
    try
    {
      a("r_tb", f(parambr));
      return;
    }
    catch (Throwable parambr)
    {
      localStringBuilder = new StringBuilder();
      localStringBuilder.append("e:[");
      localStringBuilder.append(parambr);
      localStringBuilder.append("]");
      bo.k(localStringBuilder.toString());
    }
  }
  
  /* Error */
  public int getCount()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore 4
    //   3: iconst_0
    //   4: istore_3
    //   5: aconst_null
    //   6: astore 8
    //   8: aconst_null
    //   9: astore 7
    //   11: aload 7
    //   13: astore 5
    //   15: iload 4
    //   17: istore_2
    //   18: aload 8
    //   20: astore 6
    //   22: new 199	java/lang/StringBuilder
    //   25: dup
    //   26: bipush 120
    //   28: invokespecial 299	java/lang/StringBuilder:<init>	(I)V
    //   31: astore 9
    //   33: aload 7
    //   35: astore 5
    //   37: iload 4
    //   39: istore_2
    //   40: aload 8
    //   42: astore 6
    //   44: aload 9
    //   46: ldc_w 354
    //   49: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   52: pop
    //   53: aload 7
    //   55: astore 5
    //   57: iload 4
    //   59: istore_2
    //   60: aload 8
    //   62: astore 6
    //   64: aload 9
    //   66: ldc_w 303
    //   69: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 7
    //   75: astore 5
    //   77: iload 4
    //   79: istore_2
    //   80: aload 8
    //   82: astore 6
    //   84: aload_0
    //   85: aload 9
    //   87: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   90: invokespecial 321	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   93: astore 7
    //   95: iload_3
    //   96: istore_1
    //   97: aload 7
    //   99: ifnull +46 -> 145
    //   102: iload_3
    //   103: istore_1
    //   104: aload 7
    //   106: astore 5
    //   108: iload 4
    //   110: istore_2
    //   111: aload 7
    //   113: astore 6
    //   115: aload 7
    //   117: invokeinterface 197 1 0
    //   122: ifeq +23 -> 145
    //   125: aload 7
    //   127: astore 5
    //   129: iload 4
    //   131: istore_2
    //   132: aload 7
    //   134: astore 6
    //   136: aload 7
    //   138: iconst_0
    //   139: invokeinterface 115 2 0
    //   144: istore_1
    //   145: aload 7
    //   147: astore 5
    //   149: iload_1
    //   150: istore_2
    //   151: aload 7
    //   153: astore 6
    //   155: new 199	java/lang/StringBuilder
    //   158: dup
    //   159: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   162: astore 8
    //   164: aload 7
    //   166: astore 5
    //   168: iload_1
    //   169: istore_2
    //   170: aload 7
    //   172: astore 6
    //   174: aload 8
    //   176: ldc_w 356
    //   179: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 7
    //   185: astore 5
    //   187: iload_1
    //   188: istore_2
    //   189: aload 7
    //   191: astore 6
    //   193: aload 8
    //   195: iload_1
    //   196: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   199: pop
    //   200: aload 7
    //   202: astore 5
    //   204: iload_1
    //   205: istore_2
    //   206: aload 7
    //   208: astore 6
    //   210: aload 8
    //   212: ldc 211
    //   214: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   217: pop
    //   218: aload 7
    //   220: astore 5
    //   222: iload_1
    //   223: istore_2
    //   224: aload 7
    //   226: astore 6
    //   228: aload 8
    //   230: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   233: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   236: iload_1
    //   237: istore_3
    //   238: aload 7
    //   240: ifnull +157 -> 397
    //   243: aload 7
    //   245: invokeinterface 326 1 0
    //   250: iload_1
    //   251: ireturn
    //   252: astore 5
    //   254: new 199	java/lang/StringBuilder
    //   257: dup
    //   258: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   261: astore 6
    //   263: aload 6
    //   265: ldc 202
    //   267: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   270: pop
    //   271: aload 6
    //   273: aload 5
    //   275: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   278: pop
    //   279: aload 6
    //   281: ldc 211
    //   283: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   286: pop
    //   287: aload 6
    //   289: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   292: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   295: iload_1
    //   296: ireturn
    //   297: astore 6
    //   299: goto +100 -> 399
    //   302: astore 7
    //   304: aload 6
    //   306: astore 5
    //   308: new 199	java/lang/StringBuilder
    //   311: dup
    //   312: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   315: astore 8
    //   317: aload 6
    //   319: astore 5
    //   321: aload 8
    //   323: ldc 202
    //   325: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: pop
    //   329: aload 6
    //   331: astore 5
    //   333: aload 8
    //   335: aload 7
    //   337: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   340: pop
    //   341: aload 6
    //   343: astore 5
    //   345: aload 8
    //   347: ldc 211
    //   349: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   352: pop
    //   353: aload 6
    //   355: astore 5
    //   357: aload 8
    //   359: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   362: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   365: iload_2
    //   366: istore_3
    //   367: aload 6
    //   369: ifnull +28 -> 397
    //   372: aload 6
    //   374: invokeinterface 326 1 0
    //   379: iload_2
    //   380: ireturn
    //   381: astore 5
    //   383: new 199	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   390: astore 6
    //   392: iload_2
    //   393: istore_1
    //   394: goto -131 -> 263
    //   397: iload_3
    //   398: ireturn
    //   399: aload 5
    //   401: ifnull +56 -> 457
    //   404: aload 5
    //   406: invokeinterface 326 1 0
    //   411: goto +46 -> 457
    //   414: astore 5
    //   416: new 199	java/lang/StringBuilder
    //   419: dup
    //   420: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   423: astore 7
    //   425: aload 7
    //   427: ldc 202
    //   429: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   432: pop
    //   433: aload 7
    //   435: aload 5
    //   437: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   440: pop
    //   441: aload 7
    //   443: ldc 211
    //   445: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   448: pop
    //   449: aload 7
    //   451: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   454: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   457: aload 6
    //   459: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	460	0	this	bs
    //   96	298	1	i	int
    //   17	376	2	j	int
    //   4	394	3	k	int
    //   1	129	4	m	int
    //   13	208	5	localCursor1	Cursor
    //   252	22	5	localThrowable1	Throwable
    //   306	50	5	localObject1	Object
    //   381	24	5	localThrowable2	Throwable
    //   414	22	5	localThrowable3	Throwable
    //   20	268	6	localObject2	Object
    //   297	76	6	localObject3	Object
    //   390	68	6	localStringBuilder1	StringBuilder
    //   9	235	7	localCursor2	Cursor
    //   302	34	7	localThrowable4	Throwable
    //   423	27	7	localStringBuilder2	StringBuilder
    //   6	352	8	localStringBuilder3	StringBuilder
    //   31	55	9	localStringBuilder4	StringBuilder
    // Exception table:
    //   from	to	target	type
    //   243	250	252	java/lang/Throwable
    //   22	33	297	finally
    //   44	53	297	finally
    //   64	73	297	finally
    //   84	95	297	finally
    //   115	125	297	finally
    //   136	145	297	finally
    //   155	164	297	finally
    //   174	183	297	finally
    //   193	200	297	finally
    //   210	218	297	finally
    //   228	236	297	finally
    //   308	317	297	finally
    //   321	329	297	finally
    //   333	341	297	finally
    //   345	353	297	finally
    //   357	365	297	finally
    //   22	33	302	java/lang/Throwable
    //   44	53	302	java/lang/Throwable
    //   64	73	302	java/lang/Throwable
    //   84	95	302	java/lang/Throwable
    //   115	125	302	java/lang/Throwable
    //   136	145	302	java/lang/Throwable
    //   155	164	302	java/lang/Throwable
    //   174	183	302	java/lang/Throwable
    //   193	200	302	java/lang/Throwable
    //   210	218	302	java/lang/Throwable
    //   228	236	302	java/lang/Throwable
    //   372	379	381	java/lang/Throwable
    //   404	411	414	java/lang/Throwable
  }
  
  /* Error */
  public br i(int paramInt)
  {
    // Byte code:
    //   0: new 199	java/lang/StringBuilder
    //   3: dup
    //   4: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: ldc_w 359
    //   12: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   15: pop
    //   16: aload_2
    //   17: iload_1
    //   18: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: ldc 211
    //   25: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   28: pop
    //   29: aload_2
    //   30: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   33: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   36: aconst_null
    //   37: astore 6
    //   39: aconst_null
    //   40: astore 4
    //   42: aconst_null
    //   43: astore_3
    //   44: aconst_null
    //   45: astore 5
    //   47: aload 4
    //   49: astore_2
    //   50: new 199	java/lang/StringBuilder
    //   53: dup
    //   54: bipush 120
    //   56: invokespecial 299	java/lang/StringBuilder:<init>	(I)V
    //   59: astore 7
    //   61: aload 4
    //   63: astore_2
    //   64: aload 7
    //   66: ldc_w 301
    //   69: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   72: pop
    //   73: aload 4
    //   75: astore_2
    //   76: aload 7
    //   78: ldc_w 303
    //   81: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   84: pop
    //   85: aload 4
    //   87: astore_2
    //   88: aload 7
    //   90: ldc_w 305
    //   93: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   96: pop
    //   97: aload 4
    //   99: astore_2
    //   100: aload 7
    //   102: ldc 107
    //   104: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   107: pop
    //   108: aload 4
    //   110: astore_2
    //   111: aload 7
    //   113: ldc_w 307
    //   116: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   119: pop
    //   120: aload 4
    //   122: astore_2
    //   123: aload 7
    //   125: iload_1
    //   126: invokevirtual 310	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   129: pop
    //   130: aload 4
    //   132: astore_2
    //   133: aload_0
    //   134: aload 7
    //   136: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   139: invokespecial 321	btmsdkobf/bs:m	(Ljava/lang/String;)Landroid/database/Cursor;
    //   142: astore 4
    //   144: aload 5
    //   146: astore_3
    //   147: aload 4
    //   149: ifnull +53 -> 202
    //   152: aload 6
    //   154: astore_2
    //   155: aload_0
    //   156: aload 4
    //   158: invokespecial 323	btmsdkobf/bs:b	(Landroid/database/Cursor;)Ljava/util/List;
    //   161: astore 7
    //   163: aload 5
    //   165: astore_3
    //   166: aload 7
    //   168: ifnull +34 -> 202
    //   171: aload 5
    //   173: astore_3
    //   174: aload 6
    //   176: astore_2
    //   177: aload 7
    //   179: invokeinterface 221 1 0
    //   184: ifle +18 -> 202
    //   187: aload 6
    //   189: astore_2
    //   190: aload 7
    //   192: iconst_0
    //   193: invokeinterface 363 2 0
    //   198: checkcast 98	btmsdkobf/br
    //   201: astore_3
    //   202: aload_3
    //   203: astore_2
    //   204: new 199	java/lang/StringBuilder
    //   207: dup
    //   208: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   211: astore 5
    //   213: aload_3
    //   214: astore_2
    //   215: aload 5
    //   217: ldc_w 365
    //   220: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   223: pop
    //   224: aload_3
    //   225: astore_2
    //   226: aload 5
    //   228: aload_3
    //   229: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   232: pop
    //   233: aload_3
    //   234: astore_2
    //   235: aload 5
    //   237: ldc 211
    //   239: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   242: pop
    //   243: aload_3
    //   244: astore_2
    //   245: aload 5
    //   247: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   250: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   253: aload 4
    //   255: ifnull +54 -> 309
    //   258: aload 4
    //   260: invokeinterface 326 1 0
    //   265: goto +44 -> 309
    //   268: astore_2
    //   269: new 199	java/lang/StringBuilder
    //   272: dup
    //   273: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   276: astore 4
    //   278: aload 4
    //   280: ldc 202
    //   282: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   285: pop
    //   286: aload 4
    //   288: aload_2
    //   289: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   292: pop
    //   293: aload 4
    //   295: ldc 211
    //   297: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   300: pop
    //   301: aload 4
    //   303: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   306: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   309: aload_3
    //   310: areturn
    //   311: astore_3
    //   312: aload 4
    //   314: astore_2
    //   315: goto +126 -> 441
    //   318: astore 5
    //   320: aload 4
    //   322: astore_3
    //   323: aload_2
    //   324: astore 4
    //   326: goto +12 -> 338
    //   329: astore_3
    //   330: goto +111 -> 441
    //   333: astore 5
    //   335: aconst_null
    //   336: astore 4
    //   338: aload_3
    //   339: astore_2
    //   340: new 199	java/lang/StringBuilder
    //   343: dup
    //   344: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   347: astore 6
    //   349: aload_3
    //   350: astore_2
    //   351: aload 6
    //   353: ldc 202
    //   355: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: pop
    //   359: aload_3
    //   360: astore_2
    //   361: aload 6
    //   363: aload 5
    //   365: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   368: pop
    //   369: aload_3
    //   370: astore_2
    //   371: aload 6
    //   373: ldc 211
    //   375: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   378: pop
    //   379: aload_3
    //   380: astore_2
    //   381: aload 6
    //   383: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   386: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   389: aload_3
    //   390: ifnull +48 -> 438
    //   393: aload_3
    //   394: invokeinterface 326 1 0
    //   399: aload 4
    //   401: areturn
    //   402: astore_2
    //   403: new 199	java/lang/StringBuilder
    //   406: dup
    //   407: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   410: astore_3
    //   411: aload_3
    //   412: ldc 202
    //   414: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   417: pop
    //   418: aload_3
    //   419: aload_2
    //   420: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   423: pop
    //   424: aload_3
    //   425: ldc 211
    //   427: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: pop
    //   431: aload_3
    //   432: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   435: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   438: aload 4
    //   440: areturn
    //   441: aload_2
    //   442: ifnull +53 -> 495
    //   445: aload_2
    //   446: invokeinterface 326 1 0
    //   451: goto +44 -> 495
    //   454: astore_2
    //   455: new 199	java/lang/StringBuilder
    //   458: dup
    //   459: invokespecial 200	java/lang/StringBuilder:<init>	()V
    //   462: astore 4
    //   464: aload 4
    //   466: ldc 202
    //   468: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   471: pop
    //   472: aload 4
    //   474: aload_2
    //   475: invokevirtual 209	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   478: pop
    //   479: aload 4
    //   481: ldc 211
    //   483: invokevirtual 206	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: pop
    //   487: aload 4
    //   489: invokevirtual 215	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   492: invokestatic 34	btmsdkobf/bo:k	(Ljava/lang/String;)V
    //   495: aload_3
    //   496: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	497	0	this	bs
    //   0	497	1	paramInt	int
    //   7	238	2	localObject1	Object
    //   268	21	2	localThrowable1	Throwable
    //   314	67	2	localObject2	Object
    //   402	44	2	localThrowable2	Throwable
    //   454	21	2	localThrowable3	Throwable
    //   43	267	3	localObject3	Object
    //   311	1	3	localObject4	Object
    //   322	1	3	localObject5	Object
    //   329	65	3	localObject6	Object
    //   410	86	3	localStringBuilder1	StringBuilder
    //   40	448	4	localObject7	Object
    //   45	201	5	localStringBuilder2	StringBuilder
    //   318	1	5	localThrowable4	Throwable
    //   333	31	5	localThrowable5	Throwable
    //   37	345	6	localStringBuilder3	StringBuilder
    //   59	132	7	localObject8	Object
    // Exception table:
    //   from	to	target	type
    //   258	265	268	java/lang/Throwable
    //   155	163	311	finally
    //   177	187	311	finally
    //   190	202	311	finally
    //   204	213	311	finally
    //   215	224	311	finally
    //   226	233	311	finally
    //   235	243	311	finally
    //   245	253	311	finally
    //   155	163	318	java/lang/Throwable
    //   177	187	318	java/lang/Throwable
    //   190	202	318	java/lang/Throwable
    //   204	213	318	java/lang/Throwable
    //   215	224	318	java/lang/Throwable
    //   226	233	318	java/lang/Throwable
    //   235	243	318	java/lang/Throwable
    //   245	253	318	java/lang/Throwable
    //   50	61	329	finally
    //   64	73	329	finally
    //   76	85	329	finally
    //   88	97	329	finally
    //   100	108	329	finally
    //   111	120	329	finally
    //   123	130	329	finally
    //   133	144	329	finally
    //   340	349	329	finally
    //   351	359	329	finally
    //   361	369	329	finally
    //   371	379	329	finally
    //   381	389	329	finally
    //   50	61	333	java/lang/Throwable
    //   64	73	333	java/lang/Throwable
    //   76	85	333	java/lang/Throwable
    //   88	97	333	java/lang/Throwable
    //   100	108	333	java/lang/Throwable
    //   111	120	333	java/lang/Throwable
    //   123	130	333	java/lang/Throwable
    //   133	144	333	java/lang/Throwable
    //   393	399	402	java/lang/Throwable
    //   445	451	454	java/lang/Throwable
  }
  
  public void j(int paramInt)
  {
    StringBuilder localStringBuilder1 = new StringBuilder();
    localStringBuilder1.append("deleteDataItem-id:[");
    localStringBuilder1.append(paramInt);
    localStringBuilder1.append("]");
    bo.k(localStringBuilder1.toString());
    try
    {
      localStringBuilder1 = new StringBuilder();
      localStringBuilder1.append("a=");
      localStringBuilder1.append(paramInt);
      delete("r_tb", localStringBuilder1.toString(), null);
      return;
    }
    catch (Throwable localThrowable)
    {
      StringBuilder localStringBuilder2 = new StringBuilder();
      localStringBuilder2.append("e:[");
      localStringBuilder2.append(localThrowable);
      localStringBuilder2.append("]");
      bo.k(localStringBuilder2.toString());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     btmsdkobf.bs
 * JD-Core Version:    0.7.0.1
 */