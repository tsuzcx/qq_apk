package com.tencent.tmassistantsdk.b;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Environment;
import android.os.SystemClock;
import android.text.TextUtils;
import com.qq.taf.jce.JceInputStream;
import com.qq.taf.jce.JceStruct;
import com.tencent.tmassistantsdk.f.d;
import com.tencent.tmassistantsdk.f.e;
import com.tencent.tmassistantsdk.protocol.jce.Response;
import com.tencent.tmassistantsdk.protocol.jce.RspHead;
import java.io.File;
import java.util.ArrayList;
import org.apache.http.HttpHost;
import org.apache.http.client.HttpClient;
import org.apache.http.client.params.HttpClientParams;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpConnectionParams;
import org.apache.http.params.HttpParams;

public class a
{
  private String a = "";
  
  public a()
  {
    int i;
    Object localObject;
    if (("mounted".equals(Environment.getExternalStorageState())) && (Environment.getExternalStorageDirectory().canWrite()))
    {
      i = 1;
      if (i == 0) {
        break label122;
      }
      localObject = Environment.getExternalStorageDirectory();
    }
    for (this.a = (((File)localObject).getPath() + "/tencent/assistant/");; this.a = (((Context)localObject).getFilesDir().getAbsolutePath() + "/assistant/"))
    {
      localObject = new File(this.a);
      if (!((File)localObject).exists()) {
        ((File)localObject).mkdirs();
      }
      this.a += ".SystemConfig.db";
      label122:
      do
      {
        return;
        i = 0;
        break;
        localObject = e.a().b();
      } while (localObject == null);
    }
  }
  
  private static JceStruct a(JceStruct paramJceStruct)
  {
    if (paramJceStruct == null) {
      return null;
    }
    paramJceStruct = paramJceStruct.getClass().getName();
    paramJceStruct = paramJceStruct.substring(0, paramJceStruct.length() - 7) + "Response";
    try
    {
      paramJceStruct = (JceStruct)Class.forName(paramJceStruct).newInstance();
      return paramJceStruct;
    }
    catch (ClassNotFoundException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (IllegalAccessException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
    catch (InstantiationException paramJceStruct)
    {
      for (;;)
      {
        paramJceStruct.printStackTrace();
        paramJceStruct = null;
      }
    }
  }
  
  public static JceStruct a(JceStruct paramJceStruct, byte[] paramArrayOfByte)
  {
    if ((paramJceStruct != null) && (paramArrayOfByte != null))
    {
      paramJceStruct = a(paramJceStruct);
      if (paramJceStruct != null) {
        try
        {
          paramArrayOfByte = new JceInputStream(paramArrayOfByte);
          paramArrayOfByte.setServerEncoding("utf-8");
          paramJceStruct.readFrom(paramArrayOfByte);
          return paramJceStruct;
        }
        catch (Exception paramJceStruct)
        {
          paramJceStruct.printStackTrace();
          return null;
        }
      }
    }
    return null;
  }
  
  public static JceStruct a(byte[] paramArrayOfByte, Class paramClass)
  {
    if (paramArrayOfByte == null) {
      return null;
    }
    try
    {
      paramArrayOfByte = new JceInputStream(paramArrayOfByte);
      paramArrayOfByte.setServerEncoding("utf-8");
      paramClass = (JceStruct)paramClass.newInstance();
      paramClass.readFrom(paramArrayOfByte);
      return paramClass;
    }
    catch (Exception paramArrayOfByte) {}
    return null;
  }
  
  public static Response a(byte[] paramArrayOfByte)
  {
    if ((paramArrayOfByte == null) || (paramArrayOfByte.length < 4)) {
      paramArrayOfByte = null;
    }
    for (;;)
    {
      return paramArrayOfByte;
      Response localResponse = new Response();
      try
      {
        paramArrayOfByte = new JceInputStream(paramArrayOfByte);
        paramArrayOfByte.setServerEncoding("utf-8");
        localResponse.readFrom(paramArrayOfByte);
        paramArrayOfByte = localResponse;
        if (localResponse.head.ret == 0)
        {
          if ((localResponse.head.encryptWithPack & 0x2) == 2)
          {
            paramArrayOfByte = localResponse.body;
            byte[] arrayOfByte = "ji*9^&43U0X-~./(".getBytes();
            localResponse.body = new d().a(paramArrayOfByte, arrayOfByte);
          }
          if ((localResponse.head.encryptWithPack & 0x1) == 1) {
            localResponse.body = c(localResponse.body);
          }
          e.a().b(localResponse.head.phoneGuid);
          return localResponse;
        }
      }
      catch (Exception paramArrayOfByte)
      {
        paramArrayOfByte.printStackTrace();
      }
    }
    return null;
  }
  
  public static void a(HttpClient paramHttpClient)
  {
    Object localObject = com.tencent.tmassistantsdk.downloadservice.c.b();
    if (!TextUtils.isEmpty((CharSequence)localObject))
    {
      if ((!((String)localObject).equalsIgnoreCase("cmwap")) && (!((String)localObject).equalsIgnoreCase("3gwap")) && (!((String)localObject).equalsIgnoreCase("uniwap"))) {
        break label66;
      }
      localObject = new HttpHost("10.0.0.172", 80);
      paramHttpClient.getParams().setParameter("http.route.default-proxy", localObject);
    }
    label66:
    while (!((String)localObject).equalsIgnoreCase("ctwap")) {
      return;
    }
    localObject = new HttpHost("10.0.0.200", 80);
    paramHttpClient.getParams().setParameter("http.route.default-proxy", localObject);
  }
  
  /* Error */
  public static byte[] a(java.util.List paramList)
  {
    // Byte code:
    //   0: new 242	java/io/ByteArrayOutputStream
    //   3: dup
    //   4: invokespecial 243	java/io/ByteArrayOutputStream:<init>	()V
    //   7: astore_1
    //   8: new 245	java/io/DataOutputStream
    //   11: dup
    //   12: aload_1
    //   13: invokespecial 248	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   16: astore 4
    //   18: aload 4
    //   20: astore_3
    //   21: aload_1
    //   22: astore_2
    //   23: aload_0
    //   24: invokeinterface 254 1 0
    //   29: astore_0
    //   30: aload 4
    //   32: astore_3
    //   33: aload_1
    //   34: astore_2
    //   35: aload_0
    //   36: invokeinterface 259 1 0
    //   41: ifeq +83 -> 124
    //   44: aload 4
    //   46: astore_3
    //   47: aload_1
    //   48: astore_2
    //   49: aload_0
    //   50: invokeinterface 262 1 0
    //   55: checkcast 263	[B
    //   58: astore 5
    //   60: aload 4
    //   62: astore_3
    //   63: aload_1
    //   64: astore_2
    //   65: aload 4
    //   67: aload 5
    //   69: arraylength
    //   70: invokevirtual 267	java/io/DataOutputStream:writeInt	(I)V
    //   73: aload 4
    //   75: astore_3
    //   76: aload_1
    //   77: astore_2
    //   78: aload 4
    //   80: aload 5
    //   82: invokevirtual 270	java/io/DataOutputStream:write	([B)V
    //   85: goto -55 -> 30
    //   88: astore_2
    //   89: aload 4
    //   91: astore_0
    //   92: aload_2
    //   93: astore 4
    //   95: aload_0
    //   96: astore_3
    //   97: aload_1
    //   98: astore_2
    //   99: aload 4
    //   101: invokevirtual 146	java/lang/Exception:printStackTrace	()V
    //   104: aload_1
    //   105: ifnull +7 -> 112
    //   108: aload_1
    //   109: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   112: aload_0
    //   113: ifnull +7 -> 120
    //   116: aload_0
    //   117: invokevirtual 274	java/io/DataOutputStream:close	()V
    //   120: aconst_null
    //   121: astore_1
    //   122: aload_1
    //   123: areturn
    //   124: aload 4
    //   126: astore_3
    //   127: aload_1
    //   128: astore_2
    //   129: aload_1
    //   130: invokevirtual 277	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   133: astore_0
    //   134: aload_1
    //   135: ifnull +7 -> 142
    //   138: aload_1
    //   139: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   142: aload_0
    //   143: astore_1
    //   144: aload 4
    //   146: ifnull -24 -> 122
    //   149: aload 4
    //   151: invokevirtual 274	java/io/DataOutputStream:close	()V
    //   154: aload_0
    //   155: areturn
    //   156: astore_1
    //   157: aload_1
    //   158: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   161: aload_0
    //   162: areturn
    //   163: astore_0
    //   164: aconst_null
    //   165: astore_3
    //   166: aconst_null
    //   167: astore_1
    //   168: aload_1
    //   169: ifnull +7 -> 176
    //   172: aload_1
    //   173: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   176: aload_3
    //   177: ifnull +7 -> 184
    //   180: aload_3
    //   181: invokevirtual 274	java/io/DataOutputStream:close	()V
    //   184: aload_0
    //   185: athrow
    //   186: astore_1
    //   187: aload_1
    //   188: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   191: goto -15 -> 176
    //   194: astore_1
    //   195: aload_1
    //   196: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   199: goto -15 -> 184
    //   202: astore_1
    //   203: aload_1
    //   204: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   207: goto -95 -> 112
    //   210: astore_0
    //   211: aload_0
    //   212: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   215: goto -95 -> 120
    //   218: astore_1
    //   219: aload_1
    //   220: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   223: goto -81 -> 142
    //   226: astore_0
    //   227: aconst_null
    //   228: astore_3
    //   229: goto -61 -> 168
    //   232: astore_0
    //   233: aload_2
    //   234: astore_1
    //   235: goto -67 -> 168
    //   238: astore 4
    //   240: aconst_null
    //   241: astore_0
    //   242: aconst_null
    //   243: astore_1
    //   244: goto -149 -> 95
    //   247: astore 4
    //   249: aconst_null
    //   250: astore_0
    //   251: goto -156 -> 95
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	254	0	paramList	java.util.List
    //   7	137	1	localObject1	Object
    //   156	2	1	localIOException1	java.io.IOException
    //   167	6	1	localObject2	Object
    //   186	2	1	localIOException2	java.io.IOException
    //   194	2	1	localIOException3	java.io.IOException
    //   202	2	1	localIOException4	java.io.IOException
    //   218	2	1	localIOException5	java.io.IOException
    //   234	10	1	localObject3	Object
    //   22	56	2	localObject4	Object
    //   88	5	2	localException1	Exception
    //   98	136	2	localObject5	Object
    //   20	209	3	localObject6	Object
    //   16	134	4	localObject7	Object
    //   238	1	4	localException2	Exception
    //   247	1	4	localException3	Exception
    //   58	23	5	arrayOfByte	byte[]
    // Exception table:
    //   from	to	target	type
    //   23	30	88	java/lang/Exception
    //   35	44	88	java/lang/Exception
    //   49	60	88	java/lang/Exception
    //   65	73	88	java/lang/Exception
    //   78	85	88	java/lang/Exception
    //   129	134	88	java/lang/Exception
    //   149	154	156	java/io/IOException
    //   0	8	163	finally
    //   172	176	186	java/io/IOException
    //   180	184	194	java/io/IOException
    //   108	112	202	java/io/IOException
    //   116	120	210	java/io/IOException
    //   138	142	218	java/io/IOException
    //   8	18	226	finally
    //   23	30	232	finally
    //   35	44	232	finally
    //   49	60	232	finally
    //   65	73	232	finally
    //   78	85	232	finally
    //   99	104	232	finally
    //   129	134	232	finally
    //   0	8	238	java/lang/Exception
    //   8	18	247	java/lang/Exception
  }
  
  public static HttpClient b()
  {
    BasicHttpParams localBasicHttpParams = new BasicHttpParams();
    HttpConnectionParams.setConnectionTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSoTimeout(localBasicHttpParams, 30000);
    HttpConnectionParams.setSocketBufferSize(localBasicHttpParams, 4096);
    HttpClientParams.setRedirecting(localBasicHttpParams, false);
    return new DefaultHttpClient(localBasicHttpParams);
  }
  
  /* Error */
  public static byte[] b(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 307	java/util/zip/Deflater
    //   3: dup
    //   4: invokespecial 308	java/util/zip/Deflater:<init>	()V
    //   7: astore_2
    //   8: new 242	java/io/ByteArrayOutputStream
    //   11: dup
    //   12: aload_0
    //   13: arraylength
    //   14: invokespecial 310	java/io/ByteArrayOutputStream:<init>	(I)V
    //   17: astore_1
    //   18: aload_2
    //   19: bipush 9
    //   21: invokevirtual 313	java/util/zip/Deflater:setLevel	(I)V
    //   24: aload_2
    //   25: aload_0
    //   26: invokevirtual 316	java/util/zip/Deflater:setInput	([B)V
    //   29: aload_2
    //   30: invokevirtual 319	java/util/zip/Deflater:finish	()V
    //   33: sipush 1024
    //   36: newarray byte
    //   38: astore_0
    //   39: aload_2
    //   40: invokevirtual 322	java/util/zip/Deflater:finished	()Z
    //   43: ifne +32 -> 75
    //   46: aload_1
    //   47: aload_0
    //   48: iconst_0
    //   49: aload_2
    //   50: aload_0
    //   51: invokevirtual 326	java/util/zip/Deflater:deflate	([B)I
    //   54: invokevirtual 329	java/io/ByteArrayOutputStream:write	([BII)V
    //   57: goto -18 -> 39
    //   60: astore_0
    //   61: aload_2
    //   62: invokevirtual 332	java/util/zip/Deflater:end	()V
    //   65: aload_1
    //   66: ifnull +7 -> 73
    //   69: aload_1
    //   70: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   73: aload_0
    //   74: athrow
    //   75: aload_2
    //   76: invokevirtual 332	java/util/zip/Deflater:end	()V
    //   79: aload_1
    //   80: ifnull +7 -> 87
    //   83: aload_1
    //   84: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   87: aload_1
    //   88: invokevirtual 277	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   91: areturn
    //   92: astore_1
    //   93: aload_1
    //   94: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   97: goto -24 -> 73
    //   100: astore_0
    //   101: aload_0
    //   102: invokevirtual 278	java/io/IOException:printStackTrace	()V
    //   105: goto -18 -> 87
    //   108: astore_0
    //   109: aconst_null
    //   110: astore_1
    //   111: goto -50 -> 61
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	114	0	paramArrayOfByte	byte[]
    //   17	71	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   92	2	1	localIOException	java.io.IOException
    //   110	1	1	localObject	Object
    //   7	69	2	localDeflater	java.util.zip.Deflater
    // Exception table:
    //   from	to	target	type
    //   18	39	60	finally
    //   39	57	60	finally
    //   69	73	92	java/io/IOException
    //   83	87	100	java/io/IOException
    //   8	18	108	finally
  }
  
  private SQLiteDatabase c()
  {
    Object localObject1 = null;
    int i = 0;
    for (;;)
    {
      localObject2 = localObject1;
      if (i >= 20) {
        break label82;
      }
      try
      {
        localObject2 = SQLiteDatabase.openOrCreateDatabase(this.a, null);
        localObject1 = localObject2;
      }
      catch (SQLiteException localSQLiteException)
      {
        label23:
        break label23;
      }
      if (localObject1 != null) {
        break;
      }
      SystemClock.sleep(50L);
      i += 1;
    }
    i = localObject1.getVersion();
    Object localObject2 = localObject1;
    if (i != 1)
    {
      localObject1.beginTransaction();
      if (i != 0) {}
    }
    try
    {
      localObject1.execSQL("CREATE TABLE if not exists channeldata( itemId INTEGER PRIMARY KEY AUTOINCREMENT, itemData BLOB);");
      localObject1.setVersion(1);
      localObject1.setTransactionSuccessful();
      localObject1.endTransaction();
      localObject2 = localObject1;
      label82:
      return localObject2;
    }
    finally
    {
      localObject1.endTransaction();
    }
  }
  
  /* Error */
  public static byte[] c(byte[] paramArrayOfByte)
  {
    // Byte code:
    //   0: new 373	java/util/zip/Inflater
    //   3: dup
    //   4: invokespecial 374	java/util/zip/Inflater:<init>	()V
    //   7: astore 4
    //   9: aconst_null
    //   10: astore_2
    //   11: new 242	java/io/ByteArrayOutputStream
    //   14: dup
    //   15: aload_0
    //   16: arraylength
    //   17: invokespecial 310	java/io/ByteArrayOutputStream:<init>	(I)V
    //   20: astore_1
    //   21: aload_1
    //   22: astore_2
    //   23: sipush 1024
    //   26: newarray byte
    //   28: astore_3
    //   29: aload_1
    //   30: astore_2
    //   31: aload 4
    //   33: aload_0
    //   34: invokevirtual 375	java/util/zip/Inflater:setInput	([B)V
    //   37: aload_1
    //   38: astore_2
    //   39: aload 4
    //   41: invokevirtual 376	java/util/zip/Inflater:finished	()Z
    //   44: ifne +77 -> 121
    //   47: aload_1
    //   48: astore_2
    //   49: aload_1
    //   50: aload_3
    //   51: iconst_0
    //   52: aload 4
    //   54: aload_3
    //   55: invokevirtual 379	java/util/zip/Inflater:inflate	([B)I
    //   58: invokevirtual 329	java/io/ByteArrayOutputStream:write	([BII)V
    //   61: goto -24 -> 37
    //   64: astore_3
    //   65: aload_1
    //   66: astore_0
    //   67: aload_0
    //   68: astore_2
    //   69: aload_3
    //   70: invokevirtual 380	java/util/zip/DataFormatException:printStackTrace	()V
    //   73: aload 4
    //   75: invokevirtual 381	java/util/zip/Inflater:end	()V
    //   78: aload_0
    //   79: astore_2
    //   80: aload_0
    //   81: ifnull +11 -> 92
    //   84: aload_0
    //   85: astore_2
    //   86: aload_0
    //   87: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   90: aload_0
    //   91: astore_2
    //   92: aload_2
    //   93: invokevirtual 277	java/io/ByteArrayOutputStream:toByteArray	()[B
    //   96: areturn
    //   97: astore_0
    //   98: aload 4
    //   100: invokevirtual 381	java/util/zip/Inflater:end	()V
    //   103: aload_2
    //   104: ifnull +7 -> 111
    //   107: aload_2
    //   108: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   111: aload_0
    //   112: athrow
    //   113: astore_1
    //   114: goto -3 -> 111
    //   117: astore_0
    //   118: goto -26 -> 92
    //   121: aload 4
    //   123: invokevirtual 381	java/util/zip/Inflater:end	()V
    //   126: aload_1
    //   127: astore_2
    //   128: aload_1
    //   129: ifnull -37 -> 92
    //   132: aload_1
    //   133: astore_2
    //   134: aload_1
    //   135: invokevirtual 273	java/io/ByteArrayOutputStream:close	()V
    //   138: aload_1
    //   139: astore_2
    //   140: goto -48 -> 92
    //   143: astore_0
    //   144: goto -46 -> 98
    //   147: astore_3
    //   148: aconst_null
    //   149: astore_0
    //   150: goto -83 -> 67
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	153	0	paramArrayOfByte	byte[]
    //   20	46	1	localByteArrayOutputStream	java.io.ByteArrayOutputStream
    //   113	26	1	localIOException	java.io.IOException
    //   10	130	2	localObject	Object
    //   28	27	3	arrayOfByte	byte[]
    //   64	6	3	localDataFormatException1	java.util.zip.DataFormatException
    //   147	1	3	localDataFormatException2	java.util.zip.DataFormatException
    //   7	115	4	localInflater	java.util.zip.Inflater
    // Exception table:
    //   from	to	target	type
    //   23	29	64	java/util/zip/DataFormatException
    //   31	37	64	java/util/zip/DataFormatException
    //   39	47	64	java/util/zip/DataFormatException
    //   49	61	64	java/util/zip/DataFormatException
    //   11	21	97	finally
    //   107	111	113	java/io/IOException
    //   86	90	117	java/io/IOException
    //   134	138	117	java/io/IOException
    //   23	29	143	finally
    //   31	37	143	finally
    //   39	47	143	finally
    //   49	61	143	finally
    //   69	73	143	finally
    //   11	21	147	java/util/zip/DataFormatException
  }
  
  private SQLiteDatabase d()
  {
    Object localObject1 = null;
    Object localObject3 = null;
    for (;;)
    {
      int i;
      try
      {
        boolean bool = new File(this.a).exists();
        if (!bool) {
          return localObject3;
        }
        i = 0;
        localObject3 = localObject1;
        if (i >= 20) {
          continue;
        }
      }
      finally {}
      try
      {
        localObject3 = SQLiteDatabase.openDatabase(this.a, null, 1);
        localObject1 = localObject3;
      }
      catch (SQLiteException localSQLiteException)
      {
        continue;
      }
      localObject3 = localObject1;
      if (localObject1 == null)
      {
        SystemClock.sleep(50L);
        i += 1;
      }
    }
  }
  
  public final long a(c paramc)
  {
    long l2 = -1L;
    long l1;
    if (paramc == null) {
      l1 = l2;
    }
    SQLiteDatabase localSQLiteDatabase;
    do
    {
      do
      {
        do
        {
          do
          {
            return l1;
            paramc = paramc.a();
            l1 = l2;
          } while (paramc == null);
          localSQLiteDatabase = c();
          l1 = l2;
        } while (localSQLiteDatabase == null);
        ContentValues localContentValues = new ContentValues();
        localContentValues.put("itemData", paramc);
        l2 = localSQLiteDatabase.insert("channeldata", "", localContentValues);
        l1 = l2;
      } while (localSQLiteDatabase == null);
      l1 = l2;
    } while (!localSQLiteDatabase.isOpen());
    try
    {
      localSQLiteDatabase.close();
      return l2;
    }
    catch (Exception paramc) {}
    return l2;
  }
  
  public final ArrayList a()
  {
    localObject3 = null;
    Object localObject4 = null;
    localSQLiteDatabase = d();
    Cursor localCursor;
    if (localSQLiteDatabase != null)
    {
      localCursor = localSQLiteDatabase.rawQuery("select * from channeldata", null);
      localObject1 = localObject4;
      if (localCursor != null)
      {
        localObject1 = localObject4;
        if (localCursor.moveToFirst() == true)
        {
          int i = localCursor.getColumnIndex("itemId");
          int j = localCursor.getColumnIndex("itemData");
          localObject3 = new ArrayList();
          do
          {
            int k = localCursor.getInt(i);
            localObject1 = c.a(localCursor.getBlob(j));
            if (localObject1 != null)
            {
              ((c)localObject1).a = k;
              ((ArrayList)localObject3).add(localObject1);
            }
          } while (localCursor.moveToNext());
          localObject1 = localObject3;
          if (localSQLiteDatabase != null)
          {
            localObject1 = localObject3;
            if (!localSQLiteDatabase.isOpen()) {}
          }
        }
      }
    }
    try
    {
      localSQLiteDatabase.close();
      localObject1 = localObject3;
    }
    catch (Exception localException1)
    {
      Object localObject2;
      for (;;)
      {
        try
        {
          localSQLiteDatabase.close();
          localObject3 = localObject1;
          return localObject3;
        }
        catch (Exception localException2) {}
        localException1 = localException1;
        localObject2 = localObject3;
      }
      return localObject2;
    }
    localCursor.close();
    localObject3 = localObject1;
    if (localSQLiteDatabase != null)
    {
      localObject3 = localObject1;
      if (!localSQLiteDatabase.isOpen()) {}
    }
  }
  
  public final boolean a(long paramLong)
  {
    SQLiteDatabase localSQLiteDatabase = c();
    if (localSQLiteDatabase != null)
    {
      localSQLiteDatabase.delete("channeldata", "itemId=?", new String[] { paramLong });
      if ((localSQLiteDatabase == null) || (!localSQLiteDatabase.isOpen())) {}
    }
    try
    {
      localSQLiteDatabase.close();
      return true;
    }
    catch (Exception localException) {}
    return false;
    return true;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.mobileqqi\classes2.jar
 * Qualified Name:     com.tencent.tmassistantsdk.b.a
 * JD-Core Version:    0.7.0.1
 */