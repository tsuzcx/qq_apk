package com.tencent.token;

import android.content.ContentValues;
import android.content.Context;
import com.tencent.kingkong.Cursor;
import com.tencent.kingkong.database.SQLiteDatabase;
import com.tencent.token.global.e;
import java.util.ArrayList;
import java.util.List;

public final class gl
{
  private static gh a;
  private static Context b;
  private static String c = "token";
  
  static
  {
    try
    {
      SQLiteDatabase.LoadLib("kkdb");
      return;
    }
    catch (Exception localException)
    {
      e.c("status_kk" + localException.toString() + localException.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c("status_kk" + localThrowable.toString() + localThrowable.getMessage());
    }
  }
  
  public static int a(go paramgo, String paramString)
  {
    try
    {
      c(paramgo);
      paramgo = a().query(paramString, new String[] { "count(*)" }, null, null, null, null, null, null);
      if (paramgo.getCount() > 0)
      {
        paramgo.moveToFirst();
        i = paramgo.getInt(0);
        paramgo.close();
        e.c("test database, tablecount=" + i);
        return i;
      }
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
        continue;
        int i = 0;
      }
    }
  }
  
  public static int a(go paramgo, String paramString1, ContentValues paramContentValues, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramgo);
      int i = a().update(paramString1, paramContentValues, paramString2, paramArrayOfString);
      return i;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      }
    }
  }
  
  public static int a(go paramgo, String paramString1, String paramString2, String[] paramArrayOfString)
  {
    try
    {
      c(paramgo);
      int i = a().delete(paramString1, paramString2, paramArrayOfString);
      e.c("test database, del=" + i);
      return i;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      }
    }
  }
  
  public static long a(go paramgo)
  {
    try
    {
      c(paramgo);
      long l = paramgo.b(a());
      return l;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0L;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      }
    }
  }
  
  /* Error */
  public static SQLiteDatabase a()
  {
    // Byte code:
    //   0: getstatic 113	com/tencent/token/gl:a	Lcom/tencent/token/gh;
    //   3: ifnonnull +339 -> 342
    //   6: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   9: ifnonnull +9 -> 18
    //   12: invokestatic 121	com/tencent/token/global/RqdApplication:i	()Landroid/content/Context;
    //   15: putstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   18: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   21: ldc 123
    //   23: invokevirtual 129	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   26: astore_2
    //   27: aload_2
    //   28: ifnull +15 -> 43
    //   31: aload_2
    //   32: invokevirtual 134	java/io/File:exists	()Z
    //   35: ifeq +8 -> 43
    //   38: aload_2
    //   39: invokevirtual 136	java/io/File:delete	()Z
    //   42: pop
    //   43: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   46: ldc 138
    //   48: invokevirtual 129	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   51: astore_3
    //   52: aload_3
    //   53: invokevirtual 134	java/io/File:exists	()Z
    //   56: ifne +778 -> 834
    //   59: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   62: ldc 140
    //   64: invokevirtual 129	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   67: astore_2
    //   68: aload_2
    //   69: invokevirtual 134	java/io/File:exists	()Z
    //   72: ifeq +251 -> 323
    //   75: aload_2
    //   76: invokevirtual 143	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   79: aconst_null
    //   80: iconst_1
    //   81: new 145	com/tencent/token/gf
    //   84: dup
    //   85: invokespecial 146	com/tencent/token/gf:<init>	()V
    //   88: invokestatic 150	com/tencent/kingkong/database/SQLiteDatabase:openDatabase	(Ljava/lang/String;Lcom/tencent/kingkong/database/SQLiteDatabase$CursorFactory;ILcom/tencent/kingkong/DatabaseErrorHandler;)Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   91: astore_2
    //   92: aload_3
    //   93: getstatic 156	com/tencent/kingkong/database/SQLiteDatabase$LockedDevice:STABLE	Lcom/tencent/kingkong/database/SQLiteDatabase$LockedDevice;
    //   96: getstatic 20	com/tencent/token/gl:c	Ljava/lang/String;
    //   99: getstatic 162	com/tencent/kingkong/database/SQLiteDatabase$Arithmetic:DEFAULT	Lcom/tencent/kingkong/database/SQLiteDatabase$Arithmetic;
    //   102: aconst_null
    //   103: new 145	com/tencent/token/gf
    //   106: dup
    //   107: invokespecial 146	com/tencent/token/gf:<init>	()V
    //   110: invokestatic 166	com/tencent/kingkong/database/SQLiteDatabase:openOrCreateDatabase	(Ljava/io/File;Lcom/tencent/kingkong/database/SQLiteDatabase$LockedDevice;Ljava/lang/String;Lcom/tencent/kingkong/database/SQLiteDatabase$Arithmetic;Lcom/tencent/kingkong/database/SQLiteDatabase$CursorFactory;Lcom/tencent/kingkong/DatabaseErrorHandler;)Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   113: astore 4
    //   115: invokestatic 169	com/tencent/kingkong/database/SQLiteDatabase:enableForceOptimization	()V
    //   118: new 171	java/util/HashSet
    //   121: dup
    //   122: invokespecial 172	java/util/HashSet:<init>	()V
    //   125: astore_3
    //   126: aload_3
    //   127: ldc 174
    //   129: invokevirtual 178	java/util/HashSet:add	(Ljava/lang/Object;)Z
    //   132: pop
    //   133: new 30	java/lang/StringBuilder
    //   136: dup
    //   137: ldc 180
    //   139: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   142: astore 5
    //   144: aload_2
    //   145: aload 5
    //   147: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   150: aconst_null
    //   151: invokevirtual 186	com/tencent/kingkong/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/kingkong/Cursor;
    //   154: astore 6
    //   156: aload 6
    //   158: ifnull +652 -> 810
    //   161: aload 6
    //   163: invokeinterface 77 1 0
    //   168: pop
    //   169: aload 6
    //   171: invokeinterface 189 1 0
    //   176: ifeq +627 -> 803
    //   179: aload 6
    //   181: iconst_0
    //   182: invokeinterface 193 2 0
    //   187: astore 9
    //   189: aload 5
    //   191: iconst_0
    //   192: invokevirtual 197	java/lang/StringBuilder:setLength	(I)V
    //   195: aload 5
    //   197: ldc 199
    //   199: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   202: aload 9
    //   204: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: ldc 201
    //   209: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   212: pop
    //   213: aload_2
    //   214: aload 5
    //   216: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   219: aconst_null
    //   220: invokevirtual 186	com/tencent/kingkong/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/kingkong/Cursor;
    //   223: astore 7
    //   225: aload 7
    //   227: ifnull -58 -> 169
    //   230: aload 7
    //   232: invokeinterface 204 1 0
    //   237: ifeq +556 -> 793
    //   240: aload_3
    //   241: aload 9
    //   243: invokevirtual 207	java/util/HashSet:contains	(Ljava/lang/Object;)Z
    //   246: ifeq +105 -> 351
    //   249: aload 7
    //   251: invokeinterface 208 1 0
    //   256: goto -87 -> 169
    //   259: astore 5
    //   261: aload_2
    //   262: astore_3
    //   263: aload 4
    //   265: astore_2
    //   266: aload 5
    //   268: astore 4
    //   270: new 30	java/lang/StringBuilder
    //   273: dup
    //   274: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   277: ldc 35
    //   279: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   282: aload 4
    //   284: invokevirtual 43	java/lang/Exception:toString	()Ljava/lang/String;
    //   287: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   290: aload 4
    //   292: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   295: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   298: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   301: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   304: aload_3
    //   305: ifnull +7 -> 312
    //   308: aload_3
    //   309: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   312: aload_2
    //   313: ifnull +7 -> 320
    //   316: aload_2
    //   317: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   320: invokestatic 212	com/tencent/kingkong/database/SQLiteDatabase:disableForceOptimization	()V
    //   323: new 214	com/tencent/token/gh
    //   326: dup
    //   327: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   330: getstatic 20	com/tencent/token/gl:c	Ljava/lang/String;
    //   333: invokestatic 218	com/tencent/token/global/b:a	()I
    //   336: invokespecial 221	com/tencent/token/gh:<init>	(Landroid/content/Context;Ljava/lang/String;I)V
    //   339: putstatic 113	com/tencent/token/gl:a	Lcom/tencent/token/gh;
    //   342: getstatic 113	com/tencent/token/gl:a	Lcom/tencent/token/gh;
    //   345: invokevirtual 224	com/tencent/token/gh:getWritableDatabase	()Lcom/tencent/kingkong/database/SQLiteDatabase;
    //   348: astore_2
    //   349: aload_2
    //   350: areturn
    //   351: aload 4
    //   353: aload 7
    //   355: iconst_0
    //   356: invokeinterface 225 2 0
    //   361: invokevirtual 228	com/tencent/kingkong/database/SQLiteDatabase:execSQL	(Ljava/lang/String;)V
    //   364: aload_2
    //   365: new 30	java/lang/StringBuilder
    //   368: dup
    //   369: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   372: ldc 230
    //   374: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   377: aload 9
    //   379: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   382: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   385: aconst_null
    //   386: invokevirtual 186	com/tencent/kingkong/database/SQLiteDatabase:rawQuery	(Ljava/lang/String;[Ljava/lang/String;)Lcom/tencent/kingkong/Cursor;
    //   389: astore 8
    //   391: aload 8
    //   393: ifnull +400 -> 793
    //   396: aload 8
    //   398: invokeinterface 77 1 0
    //   403: ifle +390 -> 793
    //   406: aload 5
    //   408: iconst_0
    //   409: invokevirtual 197	java/lang/StringBuilder:setLength	(I)V
    //   412: aload 5
    //   414: ldc 232
    //   416: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   419: aload 9
    //   421: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   424: ldc 234
    //   426: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   429: pop
    //   430: aload 8
    //   432: invokeinterface 237 1 0
    //   437: ifle +108 -> 545
    //   440: new 30	java/lang/StringBuilder
    //   443: dup
    //   444: ldc 239
    //   446: invokespecial 182	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   449: astore 9
    //   451: aload 8
    //   453: invokeinterface 243 1 0
    //   458: astore 10
    //   460: aload 10
    //   462: arraylength
    //   463: istore_1
    //   464: iconst_0
    //   465: istore_0
    //   466: iload_0
    //   467: iload_1
    //   468: if_icmpge +33 -> 501
    //   471: aload 5
    //   473: aload 10
    //   475: iload_0
    //   476: aaload
    //   477: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   480: ldc 245
    //   482: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   485: pop
    //   486: aload 9
    //   488: ldc 247
    //   490: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   493: pop
    //   494: iload_0
    //   495: iconst_1
    //   496: iadd
    //   497: istore_0
    //   498: goto -32 -> 466
    //   501: aload 9
    //   503: aload 9
    //   505: invokevirtual 250	java/lang/StringBuilder:length	()I
    //   508: iconst_1
    //   509: isub
    //   510: invokevirtual 253	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   513: pop
    //   514: aload 5
    //   516: aload 5
    //   518: invokevirtual 250	java/lang/StringBuilder:length	()I
    //   521: iconst_1
    //   522: isub
    //   523: invokevirtual 253	java/lang/StringBuilder:deleteCharAt	(I)Ljava/lang/StringBuilder;
    //   526: pop
    //   527: aload 5
    //   529: ldc 255
    //   531: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   534: aload 9
    //   536: invokevirtual 258	java/lang/StringBuilder:append	(Ljava/lang/CharSequence;)Ljava/lang/StringBuilder;
    //   539: ldc 255
    //   541: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   544: pop
    //   545: aload 4
    //   547: aload 5
    //   549: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   552: invokevirtual 262	com/tencent/kingkong/database/SQLiteDatabase:compileStatement	(Ljava/lang/String;)Lcom/tencent/kingkong/database/SQLiteStatement;
    //   555: astore 9
    //   557: aload 4
    //   559: invokevirtual 265	com/tencent/kingkong/database/SQLiteDatabase:beginTransaction	()V
    //   562: aload 8
    //   564: invokeinterface 237 1 0
    //   569: istore_1
    //   570: iload_1
    //   571: newarray int
    //   573: astore 10
    //   575: aload 8
    //   577: invokeinterface 81 1 0
    //   582: pop
    //   583: iconst_0
    //   584: istore_0
    //   585: iload_0
    //   586: iload_1
    //   587: if_icmpge +435 -> 1022
    //   590: aload 10
    //   592: iload_0
    //   593: aload 8
    //   595: iload_0
    //   596: invokeinterface 268 2 0
    //   601: iastore
    //   602: iload_0
    //   603: iconst_1
    //   604: iadd
    //   605: istore_0
    //   606: goto -21 -> 585
    //   609: aload 8
    //   611: iload_0
    //   612: invokeinterface 193 2 0
    //   617: astore 11
    //   619: aload 11
    //   621: ifnull +40 -> 661
    //   624: aload 9
    //   626: iload_0
    //   627: iconst_1
    //   628: iadd
    //   629: aload 11
    //   631: invokevirtual 274	com/tencent/kingkong/database/SQLiteStatement:bindString	(ILjava/lang/String;)V
    //   634: goto +434 -> 1068
    //   637: astore_3
    //   638: aload_2
    //   639: ifnull +7 -> 646
    //   642: aload_2
    //   643: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   646: aload 4
    //   648: ifnull +8 -> 656
    //   651: aload 4
    //   653: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   656: invokestatic 212	com/tencent/kingkong/database/SQLiteDatabase:disableForceOptimization	()V
    //   659: aload_3
    //   660: athrow
    //   661: aload 9
    //   663: iload_0
    //   664: iconst_1
    //   665: iadd
    //   666: invokevirtual 277	com/tencent/kingkong/database/SQLiteStatement:bindNull	(I)V
    //   669: goto +399 -> 1068
    //   672: aload 9
    //   674: iload_0
    //   675: iconst_1
    //   676: iadd
    //   677: aload 8
    //   679: iload_0
    //   680: invokeinterface 281 2 0
    //   685: invokevirtual 285	com/tencent/kingkong/database/SQLiteStatement:bindLong	(IJ)V
    //   688: goto +380 -> 1068
    //   691: aload 8
    //   693: iload_0
    //   694: invokeinterface 289 2 0
    //   699: astore 11
    //   701: aload 11
    //   703: ifnull +16 -> 719
    //   706: aload 9
    //   708: iload_0
    //   709: iconst_1
    //   710: iadd
    //   711: aload 11
    //   713: invokevirtual 293	com/tencent/kingkong/database/SQLiteStatement:bindBlob	(I[B)V
    //   716: goto +352 -> 1068
    //   719: aload 9
    //   721: iload_0
    //   722: iconst_1
    //   723: iadd
    //   724: invokevirtual 277	com/tencent/kingkong/database/SQLiteStatement:bindNull	(I)V
    //   727: goto +341 -> 1068
    //   730: aload 9
    //   732: iload_0
    //   733: iconst_1
    //   734: iadd
    //   735: aload 8
    //   737: iload_0
    //   738: invokeinterface 297 2 0
    //   743: invokevirtual 301	com/tencent/kingkong/database/SQLiteStatement:bindDouble	(ID)V
    //   746: goto +322 -> 1068
    //   749: aload 9
    //   751: iload_0
    //   752: iconst_1
    //   753: iadd
    //   754: invokevirtual 277	com/tencent/kingkong/database/SQLiteStatement:bindNull	(I)V
    //   757: goto +311 -> 1068
    //   760: aload 9
    //   762: invokevirtual 305	com/tencent/kingkong/database/SQLiteStatement:executeInsert	()J
    //   765: pop2
    //   766: aload 8
    //   768: invokeinterface 189 1 0
    //   773: ifne +249 -> 1022
    //   776: aload 4
    //   778: invokevirtual 308	com/tencent/kingkong/database/SQLiteDatabase:setTransactionSuccessful	()V
    //   781: aload 4
    //   783: invokevirtual 311	com/tencent/kingkong/database/SQLiteDatabase:endTransaction	()V
    //   786: aload 8
    //   788: invokeinterface 88 1 0
    //   793: aload 7
    //   795: invokeinterface 208 1 0
    //   800: goto -631 -> 169
    //   803: aload 6
    //   805: invokeinterface 88 1 0
    //   810: aload_2
    //   811: ifnull +7 -> 818
    //   814: aload_2
    //   815: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   818: aload 4
    //   820: ifnull +8 -> 828
    //   823: aload 4
    //   825: invokevirtual 209	com/tencent/kingkong/database/SQLiteDatabase:close	()V
    //   828: invokestatic 212	com/tencent/kingkong/database/SQLiteDatabase:disableForceOptimization	()V
    //   831: goto -508 -> 323
    //   834: getstatic 115	com/tencent/token/gl:b	Landroid/content/Context;
    //   837: ldc 140
    //   839: invokevirtual 129	android/content/Context:getDatabasePath	(Ljava/lang/String;)Ljava/io/File;
    //   842: pop
    //   843: goto -520 -> 323
    //   846: astore_2
    //   847: aload_2
    //   848: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   851: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   854: new 30	java/lang/StringBuilder
    //   857: dup
    //   858: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   861: ldc 35
    //   863: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   866: aload_2
    //   867: invokevirtual 43	java/lang/Exception:toString	()Ljava/lang/String;
    //   870: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   873: aload_2
    //   874: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   877: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   880: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   883: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   886: goto -544 -> 342
    //   889: astore_2
    //   890: aload_2
    //   891: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   894: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   897: new 30	java/lang/StringBuilder
    //   900: dup
    //   901: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   904: ldc 35
    //   906: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   909: aload_2
    //   910: invokevirtual 43	java/lang/Exception:toString	()Ljava/lang/String;
    //   913: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   916: aload_2
    //   917: invokevirtual 46	java/lang/Exception:getMessage	()Ljava/lang/String;
    //   920: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   923: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   926: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   929: aconst_null
    //   930: areturn
    //   931: astore_2
    //   932: new 30	java/lang/StringBuilder
    //   935: dup
    //   936: invokespecial 33	java/lang/StringBuilder:<init>	()V
    //   939: ldc 35
    //   941: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   944: aload_2
    //   945: invokevirtual 53	java/lang/Throwable:toString	()Ljava/lang/String;
    //   948: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   951: aload_2
    //   952: invokevirtual 54	java/lang/Throwable:getMessage	()Ljava/lang/String;
    //   955: invokevirtual 39	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   958: invokevirtual 47	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   961: invokestatic 52	com/tencent/token/global/e:c	(Ljava/lang/String;)V
    //   964: goto -35 -> 929
    //   967: astore_3
    //   968: aconst_null
    //   969: astore 4
    //   971: aconst_null
    //   972: astore_2
    //   973: goto -335 -> 638
    //   976: astore_3
    //   977: aconst_null
    //   978: astore 4
    //   980: goto -342 -> 638
    //   983: astore 4
    //   985: aload_3
    //   986: astore 5
    //   988: aload 4
    //   990: astore_3
    //   991: aload_2
    //   992: astore 4
    //   994: aload 5
    //   996: astore_2
    //   997: goto -359 -> 638
    //   1000: astore 4
    //   1002: aconst_null
    //   1003: astore_2
    //   1004: aconst_null
    //   1005: astore_3
    //   1006: goto -736 -> 270
    //   1009: astore 4
    //   1011: aconst_null
    //   1012: astore 5
    //   1014: aload_2
    //   1015: astore_3
    //   1016: aload 5
    //   1018: astore_2
    //   1019: goto -749 -> 270
    //   1022: iconst_0
    //   1023: istore_0
    //   1024: iload_0
    //   1025: iload_1
    //   1026: if_icmpge -266 -> 760
    //   1029: aload 10
    //   1031: iload_0
    //   1032: iaload
    //   1033: tableswitch	default:+35 -> 1068, 0:+-284->749, 1:+-361->672, 2:+-303->730, 3:+-424->609, 4:+-342->691
    //   1069: iconst_1
    //   1070: iadd
    //   1071: istore_0
    //   1072: goto -48 -> 1024
    // Local variable table:
    //   start	length	slot	name	signature
    //   465	607	0	i	int
    //   463	564	1	j	int
    //   26	789	2	localObject1	Object
    //   846	28	2	localException1	Exception
    //   889	28	2	localException2	Exception
    //   931	21	2	localThrowable	Throwable
    //   972	47	2	localObject2	Object
    //   51	258	3	localObject3	Object
    //   637	23	3	localObject4	Object
    //   967	1	3	localObject5	Object
    //   976	10	3	localObject6	Object
    //   990	26	3	localObject7	Object
    //   113	866	4	localObject8	Object
    //   983	6	4	localObject9	Object
    //   992	1	4	localObject10	Object
    //   1000	1	4	localException3	Exception
    //   1009	1	4	localException4	Exception
    //   142	73	5	localStringBuilder	java.lang.StringBuilder
    //   259	289	5	localException5	Exception
    //   986	31	5	localObject11	Object
    //   154	650	6	localCursor1	Cursor
    //   223	571	7	localCursor2	Cursor
    //   389	398	8	localCursor3	Cursor
    //   187	574	9	localObject12	Object
    //   458	572	10	localObject13	Object
    //   617	95	11	localObject14	Object
    // Exception table:
    //   from	to	target	type
    //   115	156	259	java/lang/Exception
    //   161	169	259	java/lang/Exception
    //   169	225	259	java/lang/Exception
    //   230	256	259	java/lang/Exception
    //   351	391	259	java/lang/Exception
    //   396	464	259	java/lang/Exception
    //   471	494	259	java/lang/Exception
    //   501	545	259	java/lang/Exception
    //   545	583	259	java/lang/Exception
    //   590	602	259	java/lang/Exception
    //   609	619	259	java/lang/Exception
    //   624	634	259	java/lang/Exception
    //   661	669	259	java/lang/Exception
    //   672	688	259	java/lang/Exception
    //   691	701	259	java/lang/Exception
    //   706	716	259	java/lang/Exception
    //   719	727	259	java/lang/Exception
    //   730	746	259	java/lang/Exception
    //   749	757	259	java/lang/Exception
    //   760	793	259	java/lang/Exception
    //   793	800	259	java/lang/Exception
    //   803	810	259	java/lang/Exception
    //   115	156	637	finally
    //   161	169	637	finally
    //   169	225	637	finally
    //   230	256	637	finally
    //   351	391	637	finally
    //   396	464	637	finally
    //   471	494	637	finally
    //   501	545	637	finally
    //   545	583	637	finally
    //   590	602	637	finally
    //   609	619	637	finally
    //   624	634	637	finally
    //   661	669	637	finally
    //   672	688	637	finally
    //   691	701	637	finally
    //   706	716	637	finally
    //   719	727	637	finally
    //   730	746	637	finally
    //   749	757	637	finally
    //   760	793	637	finally
    //   793	800	637	finally
    //   803	810	637	finally
    //   323	342	846	java/lang/Exception
    //   342	349	889	java/lang/Exception
    //   342	349	931	java/lang/Throwable
    //   75	92	967	finally
    //   92	115	976	finally
    //   270	304	983	finally
    //   75	92	1000	java/lang/Exception
    //   92	115	1009	java/lang/Exception
  }
  
  public static go a(go paramgo, String paramString, String[] paramArrayOfString)
  {
    paramgo = a(paramgo, paramString, paramArrayOfString, null, null, null, null);
    if ((paramgo != null) && (paramgo.size() > 0)) {
      return (go)paramgo.get(0);
    }
    return null;
  }
  
  public static List a(go paramgo, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    ArrayList localArrayList = new ArrayList();
    try
    {
      c(paramgo);
      paramString1 = a().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
      if (paramString1.getCount() > 0)
      {
        paramString1.moveToFirst();
        do
        {
          localArrayList.add(paramgo.a(paramString1));
        } while (paramString1.moveToNext());
      }
      paramString1.close();
      return localArrayList;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return localArrayList;
    }
    catch (Throwable paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
    }
    return localArrayList;
  }
  
  public static void a(Context paramContext)
  {
    b = paramContext;
  }
  
  public static void a(String paramString)
  {
    try
    {
      SQLiteDatabase localSQLiteDatabase = a();
      localSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + paramString);
      localSQLiteDatabase.close();
      return;
    }
    catch (Exception paramString)
    {
      e.c("status_kk" + paramString.toString() + paramString.getMessage());
      return;
    }
    catch (Throwable paramString)
    {
      e.c("status_kk" + paramString.toString() + paramString.getMessage());
    }
  }
  
  public static long b(go paramgo)
  {
    try
    {
      c(paramgo);
      long l = a().replace(paramgo.a(), null, paramgo.b());
      return l;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0L;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      }
    }
  }
  
  public static long b(go paramgo, String paramString1, String[] paramArrayOfString1, String paramString2, String[] paramArrayOfString2, String paramString3, String paramString4)
  {
    try
    {
      c(paramgo);
      paramgo = a().query(paramString1, paramArrayOfString1, paramString2, paramArrayOfString2, null, null, paramString3, paramString4);
      long l = 0L;
      if (paramgo.getCount() > 0)
      {
        paramgo.moveToLast();
        l = paramgo.getLong(0);
      }
      paramgo.close();
      e.c("test database, time=" + l);
      return l;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return 0L;
    }
    catch (Throwable paramgo)
    {
      for (;;)
      {
        e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      }
    }
  }
  
  public static void b()
  {
    if (a != null) {}
    try
    {
      a.close();
      a = null;
      return;
    }
    catch (Exception localException)
    {
      e.c("status_kk" + localException.toString() + localException.getMessage());
      return;
    }
    catch (Throwable localThrowable)
    {
      e.c("status_kk" + localThrowable.toString() + localThrowable.getMessage());
    }
  }
  
  private static void c(go paramgo)
  {
    try
    {
      paramgo.a(a());
      return;
    }
    catch (Exception paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
      return;
    }
    catch (Throwable paramgo)
    {
      e.c("status_kk" + paramgo.toString() + paramgo.getMessage());
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.token.gl
 * JD-Core Version:    0.7.0.1
 */