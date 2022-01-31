package com.tencent.open.base.img;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class ImageDbHelper
  extends SQLiteOpenHelper
{
  protected static final int a = 4;
  public static final String a;
  protected static final byte[] a;
  protected static final String[] a;
  protected static final int b = 0;
  protected static final String b = "appcenterImagedb.db";
  protected static final int c = 1;
  protected static String c;
  protected static final int d = 2;
  protected static final String d = "key";
  protected static final int e = 3;
  protected static final String e = "maxage";
  protected static final int f = 4;
  protected static final String f = "updatetime";
  protected static final String g = "modified";
  protected static final String h = "local";
  
  static
  {
    jdField_a_of_type_JavaLangString = ImageDbHelper.class.getSimpleName();
    jdField_c_of_type_JavaLangString = "sys_image";
    jdField_a_of_type_ArrayOfJavaLangString = new String[] { "key", "maxage", "updatetime", "modified", "local" };
    jdField_a_of_type_ArrayOfByte = new byte[1];
  }
  
  public ImageDbHelper(Context paramContext)
  {
    super(paramContext, "appcenterImagedb.db", null, 4);
  }
  
  protected ImageInfo a(Cursor paramCursor)
  {
    ImageInfo localImageInfo = new ImageInfo();
    localImageInfo.jdField_a_of_type_JavaLangString = paramCursor.getString(0);
    localImageInfo.jdField_a_of_type_Long = paramCursor.getLong(1);
    localImageInfo.b = paramCursor.getLong(2);
    localImageInfo.jdField_c_of_type_Long = paramCursor.getLong(3);
    localImageInfo.jdField_c_of_type_JavaLangString = paramCursor.getString(4);
    return localImageInfo;
  }
  
  /* Error */
  public ImageInfo a(String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 5
    //   3: aconst_null
    //   4: astore 4
    //   6: aconst_null
    //   7: astore 6
    //   9: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   12: astore 7
    //   14: aload 7
    //   16: monitorenter
    //   17: aload_0
    //   18: invokevirtual 90	com/tencent/open/base/img/ImageDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   21: astore_2
    //   22: aload_2
    //   23: getstatic 47	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   26: getstatic 51	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   29: ldc 92
    //   31: iconst_1
    //   32: anewarray 49	java/lang/String
    //   35: dup
    //   36: iconst_0
    //   37: aload_1
    //   38: aastore
    //   39: aconst_null
    //   40: aconst_null
    //   41: aconst_null
    //   42: invokevirtual 98	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   45: astore_3
    //   46: aload 6
    //   48: astore_1
    //   49: aload_3
    //   50: invokeinterface 102 1 0
    //   55: ifle +16 -> 71
    //   58: aload_3
    //   59: invokeinterface 106 1 0
    //   64: pop
    //   65: aload_0
    //   66: aload_3
    //   67: invokevirtual 108	com/tencent/open/base/img/ImageDbHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/base/img/ImageInfo;
    //   70: astore_1
    //   71: aload_3
    //   72: ifnull +9 -> 81
    //   75: aload_3
    //   76: invokeinterface 111 1 0
    //   81: aload_1
    //   82: astore_3
    //   83: aload_2
    //   84: ifnull +9 -> 93
    //   87: aload_2
    //   88: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   91: aload_1
    //   92: astore_3
    //   93: aload 7
    //   95: monitorexit
    //   96: aload_3
    //   97: areturn
    //   98: astore_3
    //   99: aconst_null
    //   100: astore_2
    //   101: aconst_null
    //   102: astore_1
    //   103: aload_3
    //   104: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   107: aload_2
    //   108: ifnull +9 -> 117
    //   111: aload_2
    //   112: invokeinterface 111 1 0
    //   117: aload 5
    //   119: astore_3
    //   120: aload_1
    //   121: ifnull -28 -> 93
    //   124: aload_1
    //   125: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   128: aload 5
    //   130: astore_3
    //   131: goto -38 -> 93
    //   134: astore_1
    //   135: aload 7
    //   137: monitorexit
    //   138: aload_1
    //   139: athrow
    //   140: astore_2
    //   141: aconst_null
    //   142: astore_1
    //   143: aload 4
    //   145: astore_3
    //   146: aload_3
    //   147: ifnull +9 -> 156
    //   150: aload_3
    //   151: invokeinterface 111 1 0
    //   156: aload_1
    //   157: ifnull +7 -> 164
    //   160: aload_1
    //   161: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   164: aload_2
    //   165: athrow
    //   166: astore_3
    //   167: aload_2
    //   168: astore_1
    //   169: aload_3
    //   170: astore_2
    //   171: aload 4
    //   173: astore_3
    //   174: goto -28 -> 146
    //   177: astore 4
    //   179: aload_2
    //   180: astore_1
    //   181: aload 4
    //   183: astore_2
    //   184: goto -38 -> 146
    //   187: astore 4
    //   189: aload_2
    //   190: astore_3
    //   191: aload 4
    //   193: astore_2
    //   194: goto -48 -> 146
    //   197: astore_3
    //   198: aload_2
    //   199: astore_1
    //   200: aconst_null
    //   201: astore_2
    //   202: goto -99 -> 103
    //   205: astore 6
    //   207: aload_3
    //   208: astore_1
    //   209: aload_2
    //   210: astore 4
    //   212: aload 6
    //   214: astore_3
    //   215: aload_1
    //   216: astore_2
    //   217: aload 4
    //   219: astore_1
    //   220: goto -117 -> 103
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	223	0	this	ImageDbHelper
    //   0	223	1	paramString	String
    //   21	91	2	localSQLiteDatabase	SQLiteDatabase
    //   140	28	2	localObject1	java.lang.Object
    //   170	47	2	localObject2	java.lang.Object
    //   45	52	3	localObject3	java.lang.Object
    //   98	6	3	localException1	Exception
    //   119	32	3	localObject4	java.lang.Object
    //   166	4	3	localObject5	java.lang.Object
    //   173	18	3	localObject6	java.lang.Object
    //   197	11	3	localException2	Exception
    //   214	1	3	localException3	Exception
    //   4	168	4	localObject7	java.lang.Object
    //   177	5	4	localObject8	java.lang.Object
    //   187	5	4	localObject9	java.lang.Object
    //   210	8	4	localObject10	java.lang.Object
    //   1	128	5	localObject11	java.lang.Object
    //   7	40	6	localObject12	java.lang.Object
    //   205	8	6	localException4	Exception
    //   12	124	7	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   17	22	98	java/lang/Exception
    //   75	81	134	finally
    //   87	91	134	finally
    //   93	96	134	finally
    //   111	117	134	finally
    //   124	128	134	finally
    //   135	138	134	finally
    //   150	156	134	finally
    //   160	164	134	finally
    //   164	166	134	finally
    //   17	22	140	finally
    //   22	46	166	finally
    //   49	71	177	finally
    //   103	107	187	finally
    //   22	46	197	java/lang/Exception
    //   49	71	205	java/lang/Exception
  }
  
  /* Error */
  public java.util.List a()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore_3
    //   5: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   8: astore 6
    //   10: aload 6
    //   12: monitorenter
    //   13: new 118	java/util/ArrayList
    //   16: dup
    //   17: invokespecial 119	java/util/ArrayList:<init>	()V
    //   20: astore 7
    //   22: aload_0
    //   23: invokevirtual 90	com/tencent/open/base/img/ImageDbHelper:getReadableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   26: astore_2
    //   27: aload_2
    //   28: getstatic 47	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   31: getstatic 51	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfJavaLangString	[Ljava/lang/String;
    //   34: aconst_null
    //   35: aconst_null
    //   36: aconst_null
    //   37: aconst_null
    //   38: aconst_null
    //   39: invokevirtual 98	android/database/sqlite/SQLiteDatabase:query	(Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)Landroid/database/Cursor;
    //   42: astore 4
    //   44: aload 4
    //   46: invokeinterface 102 1 0
    //   51: ifle +37 -> 88
    //   54: aload 4
    //   56: invokeinterface 106 1 0
    //   61: pop
    //   62: aload 7
    //   64: aload_0
    //   65: aload 4
    //   67: invokevirtual 108	com/tencent/open/base/img/ImageDbHelper:a	(Landroid/database/Cursor;)Lcom/tencent/open/base/img/ImageInfo;
    //   70: invokeinterface 125 2 0
    //   75: pop
    //   76: aload 4
    //   78: invokeinterface 128 1 0
    //   83: istore_1
    //   84: iload_1
    //   85: ifne -23 -> 62
    //   88: aload 4
    //   90: ifnull +10 -> 100
    //   93: aload 4
    //   95: invokeinterface 111 1 0
    //   100: aload_2
    //   101: ifnull +7 -> 108
    //   104: aload_2
    //   105: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   108: aload 6
    //   110: monitorexit
    //   111: aload 7
    //   113: areturn
    //   114: astore 4
    //   116: aconst_null
    //   117: astore 5
    //   119: aload_3
    //   120: astore_2
    //   121: aload 5
    //   123: astore_3
    //   124: aload 4
    //   126: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   129: aload_3
    //   130: ifnull +9 -> 139
    //   133: aload_3
    //   134: invokeinterface 111 1 0
    //   139: aload_2
    //   140: ifnull -32 -> 108
    //   143: aload_2
    //   144: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   147: goto -39 -> 108
    //   150: astore_2
    //   151: aload 6
    //   153: monitorexit
    //   154: aload_2
    //   155: athrow
    //   156: astore_3
    //   157: aconst_null
    //   158: astore 5
    //   160: aload 4
    //   162: astore_2
    //   163: aload 5
    //   165: astore 4
    //   167: aload 4
    //   169: ifnull +10 -> 179
    //   172: aload 4
    //   174: invokeinterface 111 1 0
    //   179: aload_2
    //   180: ifnull +7 -> 187
    //   183: aload_2
    //   184: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   187: aload_3
    //   188: athrow
    //   189: astore_3
    //   190: aconst_null
    //   191: astore 4
    //   193: goto -26 -> 167
    //   196: astore_3
    //   197: goto -30 -> 167
    //   200: astore 5
    //   202: aload_3
    //   203: astore 4
    //   205: aload 5
    //   207: astore_3
    //   208: goto -41 -> 167
    //   211: astore 4
    //   213: aconst_null
    //   214: astore_3
    //   215: goto -91 -> 124
    //   218: astore_3
    //   219: aload 4
    //   221: astore 5
    //   223: aload_3
    //   224: astore 4
    //   226: aload 5
    //   228: astore_3
    //   229: goto -105 -> 124
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	this	ImageDbHelper
    //   83	2	1	bool	boolean
    //   26	118	2	localObject1	java.lang.Object
    //   150	5	2	localObject2	java.lang.Object
    //   162	22	2	localException1	Exception
    //   4	130	3	localObject3	java.lang.Object
    //   156	32	3	localObject4	java.lang.Object
    //   189	1	3	localObject5	java.lang.Object
    //   196	7	3	localObject6	java.lang.Object
    //   207	8	3	localObject7	java.lang.Object
    //   218	6	3	localException2	Exception
    //   228	1	3	localObject8	java.lang.Object
    //   1	93	4	localCursor	Cursor
    //   114	47	4	localException3	Exception
    //   165	39	4	localObject9	java.lang.Object
    //   211	9	4	localException4	Exception
    //   224	1	4	localObject10	java.lang.Object
    //   117	47	5	localObject11	java.lang.Object
    //   200	6	5	localObject12	java.lang.Object
    //   221	6	5	localException5	Exception
    //   8	144	6	arrayOfByte	byte[]
    //   20	92	7	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   22	27	114	java/lang/Exception
    //   13	22	150	finally
    //   93	100	150	finally
    //   104	108	150	finally
    //   108	111	150	finally
    //   133	139	150	finally
    //   143	147	150	finally
    //   151	154	150	finally
    //   172	179	150	finally
    //   183	187	150	finally
    //   187	189	150	finally
    //   22	27	156	finally
    //   27	44	189	finally
    //   44	62	196	finally
    //   62	84	196	finally
    //   124	129	200	finally
    //   27	44	211	java/lang/Exception
    //   44	62	218	java/lang/Exception
    //   62	84	218	java/lang/Exception
  }
  
  /* Error */
  public void a(ImageInfo paramImageInfo)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aconst_null
    //   3: astore_2
    //   4: getstatic 53	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_ArrayOfByte	[B
    //   7: astore 6
    //   9: aload 6
    //   11: monitorenter
    //   12: aload_1
    //   13: ifnonnull +7 -> 20
    //   16: aload 6
    //   18: monitorexit
    //   19: return
    //   20: aload_0
    //   21: invokevirtual 132	com/tencent/open/base/img/ImageDbHelper:getWritableDatabase	()Landroid/database/sqlite/SQLiteDatabase;
    //   24: astore 4
    //   26: aload 4
    //   28: astore_2
    //   29: aload 4
    //   31: astore_3
    //   32: new 134	android/content/ContentValues
    //   35: dup
    //   36: invokespecial 135	android/content/ContentValues:<init>	()V
    //   39: astore 7
    //   41: aload 4
    //   43: astore_2
    //   44: aload 4
    //   46: astore_3
    //   47: aload 7
    //   49: ldc 20
    //   51: aload_1
    //   52: getfield 71	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   55: invokevirtual 139	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   58: aload 4
    //   60: astore_2
    //   61: aload 4
    //   63: astore_3
    //   64: aload 7
    //   66: ldc 24
    //   68: aload_1
    //   69: getfield 78	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_Long	J
    //   72: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   75: invokevirtual 148	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   78: aload 4
    //   80: astore_2
    //   81: aload 4
    //   83: astore_3
    //   84: aload 7
    //   86: ldc 27
    //   88: aload_1
    //   89: getfield 80	com/tencent/open/base/img/ImageInfo:b	J
    //   92: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   95: invokevirtual 148	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   98: aload 4
    //   100: astore_2
    //   101: aload 4
    //   103: astore_3
    //   104: aload 7
    //   106: ldc 30
    //   108: aload_1
    //   109: getfield 82	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_Long	J
    //   112: invokestatic 145	java/lang/Long:valueOf	(J)Ljava/lang/Long;
    //   115: invokevirtual 148	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/Long;)V
    //   118: aload 4
    //   120: astore_2
    //   121: aload 4
    //   123: astore_3
    //   124: aload 7
    //   126: ldc 33
    //   128: aload_1
    //   129: getfield 83	com/tencent/open/base/img/ImageInfo:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   132: invokevirtual 139	android/content/ContentValues:put	(Ljava/lang/String;Ljava/lang/String;)V
    //   135: aload 4
    //   137: astore_2
    //   138: aload 4
    //   140: astore_3
    //   141: getstatic 43	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   144: astore 8
    //   146: aload 4
    //   148: astore_2
    //   149: aload 4
    //   151: astore_3
    //   152: new 150	java/lang/StringBuilder
    //   155: dup
    //   156: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   159: ldc 153
    //   161: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: astore 9
    //   166: aload_1
    //   167: ifnonnull +106 -> 273
    //   170: ldc 159
    //   172: astore 5
    //   174: aload 4
    //   176: astore_2
    //   177: aload 4
    //   179: astore_3
    //   180: aload 8
    //   182: aload 9
    //   184: aload 5
    //   186: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   189: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 166	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   195: aload 4
    //   197: astore_3
    //   198: aload 4
    //   200: getstatic 47	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   203: new 150	java/lang/StringBuilder
    //   206: dup
    //   207: invokespecial 151	java/lang/StringBuilder:<init>	()V
    //   210: ldc 168
    //   212: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   215: aload_1
    //   216: getfield 71	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   219: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   222: ldc 170
    //   224: invokevirtual 157	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   227: invokevirtual 162	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   230: aconst_null
    //   231: invokevirtual 174	android/database/sqlite/SQLiteDatabase:delete	(Ljava/lang/String;Ljava/lang/String;[Ljava/lang/String;)I
    //   234: pop
    //   235: aload 4
    //   237: astore_2
    //   238: aload 4
    //   240: astore_3
    //   241: aload 4
    //   243: getstatic 47	com/tencent/open/base/img/ImageDbHelper:jdField_c_of_type_JavaLangString	Ljava/lang/String;
    //   246: aconst_null
    //   247: aload 7
    //   249: invokevirtual 178	android/database/sqlite/SQLiteDatabase:insert	(Ljava/lang/String;Ljava/lang/String;Landroid/content/ContentValues;)J
    //   252: pop2
    //   253: aload 4
    //   255: ifnull +8 -> 263
    //   258: aload 4
    //   260: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   263: aload 6
    //   265: monitorexit
    //   266: return
    //   267: astore_1
    //   268: aload 6
    //   270: monitorexit
    //   271: aload_1
    //   272: athrow
    //   273: aload 4
    //   275: astore_2
    //   276: aload 4
    //   278: astore_3
    //   279: aload_1
    //   280: getfield 71	com/tencent/open/base/img/ImageInfo:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   283: astore 5
    //   285: goto -111 -> 174
    //   288: astore_1
    //   289: aload 4
    //   291: astore_2
    //   292: aload 4
    //   294: astore_3
    //   295: aload_1
    //   296: invokevirtual 115	java/lang/Exception:printStackTrace	()V
    //   299: goto -64 -> 235
    //   302: astore_1
    //   303: aload_2
    //   304: astore_3
    //   305: getstatic 43	com/tencent/open/base/img/ImageDbHelper:jdField_a_of_type_JavaLangString	Ljava/lang/String;
    //   308: ldc 180
    //   310: aload_1
    //   311: invokestatic 183	com/tencent/open/base/LogUtility:b	(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Throwable;)V
    //   314: aload_2
    //   315: ifnull -52 -> 263
    //   318: aload_2
    //   319: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   322: goto -59 -> 263
    //   325: astore_1
    //   326: aload_3
    //   327: ifnull +7 -> 334
    //   330: aload_3
    //   331: invokevirtual 112	android/database/sqlite/SQLiteDatabase:close	()V
    //   334: aload_1
    //   335: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	336	0	this	ImageDbHelper
    //   0	336	1	paramImageInfo	ImageInfo
    //   3	316	2	localObject1	java.lang.Object
    //   1	330	3	localObject2	java.lang.Object
    //   24	269	4	localSQLiteDatabase	SQLiteDatabase
    //   172	112	5	str1	String
    //   7	262	6	arrayOfByte	byte[]
    //   39	209	7	localContentValues	android.content.ContentValues
    //   144	37	8	str2	String
    //   164	19	9	localStringBuilder	java.lang.StringBuilder
    // Exception table:
    //   from	to	target	type
    //   16	19	267	finally
    //   258	263	267	finally
    //   263	266	267	finally
    //   268	271	267	finally
    //   318	322	267	finally
    //   330	334	267	finally
    //   334	336	267	finally
    //   198	235	288	java/lang/Exception
    //   20	26	302	java/lang/Exception
    //   32	41	302	java/lang/Exception
    //   47	58	302	java/lang/Exception
    //   64	78	302	java/lang/Exception
    //   84	98	302	java/lang/Exception
    //   104	118	302	java/lang/Exception
    //   124	135	302	java/lang/Exception
    //   141	146	302	java/lang/Exception
    //   152	166	302	java/lang/Exception
    //   180	195	302	java/lang/Exception
    //   241	253	302	java/lang/Exception
    //   279	285	302	java/lang/Exception
    //   295	299	302	java/lang/Exception
    //   20	26	325	finally
    //   32	41	325	finally
    //   47	58	325	finally
    //   64	78	325	finally
    //   84	98	325	finally
    //   104	118	325	finally
    //   124	135	325	finally
    //   141	146	325	finally
    //   152	166	325	finally
    //   180	195	325	finally
    //   198	235	325	finally
    //   241	253	325	finally
    //   279	285	325	finally
    //   295	299	325	finally
    //   305	314	325	finally
  }
  
  public void onCreate(SQLiteDatabase paramSQLiteDatabase)
  {
    try
    {
      paramSQLiteDatabase.execSQL("CREATE TABLE " + jdField_c_of_type_JavaLangString + " (" + "key" + " VARCHAR(50)," + "local" + " VARCHAR(50)," + "maxage" + " BIGINT," + "updatetime" + " BIGINT," + "modified" + " BIGINT,PRIMARY KEY(" + "key" + "))");
      return;
    }
    catch (Exception paramSQLiteDatabase)
    {
      paramSQLiteDatabase.printStackTrace();
    }
  }
  
  public void onUpgrade(SQLiteDatabase paramSQLiteDatabase, int paramInt1, int paramInt2)
  {
    if (paramInt1 != paramInt2)
    {
      paramSQLiteDatabase.execSQL("DROP TABLE IF EXISTS " + jdField_c_of_type_JavaLangString + ";");
      onCreate(paramSQLiteDatabase);
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.open.base.img.ImageDbHelper
 * JD-Core Version:    0.7.0.1
 */