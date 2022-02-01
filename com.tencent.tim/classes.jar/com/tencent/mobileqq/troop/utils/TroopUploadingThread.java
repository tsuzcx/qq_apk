package com.tencent.mobileqq.troop.utils;

import android.text.TextUtils;
import apul;
import apun;
import arml;
import com.tencent.mobileqq.activity.photo.TroopClipPic;
import com.tencent.qphone.base.util.QLog;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import zti;

public class TroopUploadingThread
  extends Thread
{
  protected ArrayList<apul> Cs;
  protected apun b;
  protected boolean bz = true;
  protected volatile boolean mStopped;
  
  public int a(HttpURLConnection paramHttpURLConnection, a parama, apul paramapul)
  {
    int k = -1;
    Object localObject1 = Integer.valueOf(-1);
    Object localObject2 = null;
    String str = null;
    Map localMap = paramHttpURLConnection.getHeaderFields();
    int j;
    try
    {
      j = paramHttpURLConnection.getResponseCode();
      Object localObject3 = localObject1;
      if (localMap == null) {
        break label440;
      }
      Iterator localIterator = localMap.keySet().iterator();
      for (;;)
      {
        localObject2 = str;
        localObject3 = localObject1;
        if (!localIterator.hasNext()) {
          break label440;
        }
        localObject3 = (String)localIterator.next();
        if (localObject3 == null) {
          break label583;
        }
        localObject2 = localMap.get(localObject3);
        if ((localObject2 == null) || (!(localObject2 instanceof List))) {
          break label583;
        }
        if (!((String)localObject3).equals("Result")) {
          break;
        }
        localObject3 = ((List)localObject2).get(0);
        if ((localObject3 == null) || (!(localObject3 instanceof String))) {
          break label583;
        }
        localObject1 = Integer.valueOf(Integer.parseInt((String)((List)localObject2).get(0)));
      }
    }
    catch (IOException localIOException)
    {
      for (;;)
      {
        QLog.d("TroopUploadingThread", 1, "getResult IOException", localIOException);
        j = -1;
        continue;
        if (!localIOException.equals("NewSeq")) {
          break;
        }
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          parama.dWC = Integer.parseInt((String)((List)localObject2).get(0));
        }
      }
      if (!localObject4.equals("FileName")) {
        break label303;
      }
    }
    Object localObject4 = ((List)localObject2).get(0);
    if ((localObject4 != null) && ((localObject4 instanceof String))) {
      str = (String)((List)localObject2).get(0);
    }
    for (;;)
    {
      break;
      label303:
      if (localObject4.equals("X-ErrMsg"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String))) {
          parama.errorMsg = new String(arml.decode((String)((List)localObject2).get(0), 0));
        }
        break;
      }
      if (localObject4.equals("X-ErrNo"))
      {
        localObject4 = ((List)localObject2).get(0);
        if ((localObject4 != null) && ((localObject4 instanceof String)))
        {
          parama.errorCode = Integer.parseInt((String)((List)localObject2).get(0));
          localObject1 = Integer.valueOf(parama.errorCode);
          break;
          label440:
          int i = localObject4.intValue();
          if (j != 200) {
            i = 102;
          }
          QLog.d("TroopUploadingThread", 1, "result:" + i + "resCode:" + j);
          j = k;
          if (localObject2 != null)
          {
            j = k;
            if (localObject2.contains("_"))
            {
              localObject1 = localObject2.split("_");
              if (localObject1.length != 2) {
                break label570;
              }
            }
          }
          for (;;)
          {
            try
            {
              parama.result = Integer.parseInt(localObject1[1]);
              j = i;
              if (!paramapul.byl) {
                break;
              }
              return 104;
            }
            catch (NumberFormatException parama)
            {
              parama.printStackTrace();
              i = -1;
              continue;
            }
            label570:
            i = -1;
          }
          paramHttpURLConnection.disconnect();
          return j;
        }
      }
      label583:
      break;
    }
  }
  
  /* Error */
  public int a(byte[] paramArrayOfByte, HttpURLConnection paramHttpURLConnection, apul paramapul, int paramInt)
  {
    // Byte code:
    //   0: aload_2
    //   1: ifnonnull +19 -> 20
    //   4: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +11 -> 18
    //   10: ldc 88
    //   12: iconst_2
    //   13: ldc 178
    //   15: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   18: iconst_m1
    //   19: ireturn
    //   20: new 180	java/io/DataOutputStream
    //   23: dup
    //   24: aload_2
    //   25: invokevirtual 184	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   28: invokespecial 187	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   31: astore 9
    //   33: aload_1
    //   34: arraylength
    //   35: istore 8
    //   37: iconst_0
    //   38: istore 6
    //   40: iconst_0
    //   41: istore 5
    //   43: iload 6
    //   45: iload 8
    //   47: if_icmpge +253 -> 300
    //   50: aload_3
    //   51: getfield 166	apul:byl	Z
    //   54: ifeq +77 -> 131
    //   57: aload_0
    //   58: getfield 189	com/tencent/mobileqq/troop/utils/TroopUploadingThread:Cs	Ljava/util/ArrayList;
    //   61: aload_3
    //   62: invokevirtual 194	java/util/ArrayList:remove	(Ljava/lang/Object;)Z
    //   65: pop
    //   66: aload 9
    //   68: invokevirtual 197	java/io/DataOutputStream:flush	()V
    //   71: bipush 104
    //   73: ireturn
    //   74: astore_1
    //   75: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   78: ifeq +14 -> 92
    //   81: ldc 88
    //   83: iconst_1
    //   84: aload_1
    //   85: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   88: aload_1
    //   89: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   92: iconst_0
    //   93: ifeq +11 -> 104
    //   96: new 205	java/lang/NullPointerException
    //   99: dup
    //   100: invokespecial 206	java/lang/NullPointerException:<init>	()V
    //   103: athrow
    //   104: aload_2
    //   105: ifnull +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   112: iload 4
    //   114: iconst_3
    //   115: if_icmpge +14 -> 129
    //   118: bipush 252
    //   120: ireturn
    //   121: astore_3
    //   122: aload_1
    //   123: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   126: goto -22 -> 104
    //   129: iconst_m1
    //   130: ireturn
    //   131: iload 8
    //   133: iload 6
    //   135: isub
    //   136: sipush 10240
    //   139: if_icmple +107 -> 246
    //   142: sipush 10240
    //   145: istore 7
    //   147: aload 9
    //   149: aload_1
    //   150: iload 6
    //   152: iload 7
    //   154: invokevirtual 211	java/io/DataOutputStream:write	([BII)V
    //   157: iload 6
    //   159: iload 7
    //   161: iadd
    //   162: istore 6
    //   164: iload 6
    //   166: bipush 100
    //   168: imul
    //   169: iload 8
    //   171: idiv
    //   172: iload 5
    //   174: isub
    //   175: ifle +58 -> 233
    //   178: aload_3
    //   179: iload 5
    //   181: putfield 214	apul:progress	I
    //   184: new 6	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a
    //   187: dup
    //   188: invokespecial 215	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a:<init>	()V
    //   191: astore 10
    //   193: aload 10
    //   195: iconst_0
    //   196: putfield 218	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a:dWB	I
    //   199: aload 10
    //   201: iload 5
    //   203: putfield 161	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a:result	I
    //   206: aload 10
    //   208: aload_3
    //   209: getfield 222	apul:ts	J
    //   212: putfield 223	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a:ts	J
    //   215: aload 10
    //   217: aload_3
    //   218: getfield 226	apul:type	I
    //   221: putfield 227	com/tencent/mobileqq/troop/utils/TroopUploadingThread$a:type	I
    //   224: aload_0
    //   225: getfield 229	com/tencent/mobileqq/troop/utils/TroopUploadingThread:b	Lapun;
    //   228: aload 10
    //   230: invokevirtual 235	apun:notifyObservers	(Ljava/lang/Object;)V
    //   233: iload 6
    //   235: bipush 100
    //   237: imul
    //   238: iload 8
    //   240: idiv
    //   241: istore 5
    //   243: goto -200 -> 43
    //   246: iload 8
    //   248: iload 6
    //   250: isub
    //   251: istore 7
    //   253: goto -106 -> 147
    //   256: astore_1
    //   257: aload 9
    //   259: invokevirtual 197	java/io/DataOutputStream:flush	()V
    //   262: ldc 88
    //   264: iconst_1
    //   265: aload_1
    //   266: invokevirtual 200	java/io/IOException:getMessage	()Ljava/lang/String;
    //   269: aload_1
    //   270: invokestatic 96	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   273: aload_2
    //   274: ifnull +7 -> 281
    //   277: aload_2
    //   278: invokevirtual 172	java/net/HttpURLConnection:disconnect	()V
    //   281: iload 4
    //   283: iconst_3
    //   284: if_icmpge +13 -> 297
    //   287: bipush 252
    //   289: ireturn
    //   290: astore_1
    //   291: aload_1
    //   292: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   295: iconst_m1
    //   296: ireturn
    //   297: bipush 103
    //   299: ireturn
    //   300: aload 9
    //   302: invokevirtual 197	java/io/DataOutputStream:flush	()V
    //   305: aload 9
    //   307: invokevirtual 238	java/io/DataOutputStream:close	()V
    //   310: iconst_0
    //   311: ireturn
    //   312: astore_1
    //   313: aload_1
    //   314: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   317: iconst_m1
    //   318: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	319	0	this	TroopUploadingThread
    //   0	319	1	paramArrayOfByte	byte[]
    //   0	319	2	paramHttpURLConnection	HttpURLConnection
    //   0	319	3	paramapul	apul
    //   0	319	4	paramInt	int
    //   41	201	5	i	int
    //   38	213	6	j	int
    //   145	107	7	k	int
    //   35	216	8	m	int
    //   31	275	9	localDataOutputStream	java.io.DataOutputStream
    //   191	38	10	locala	a
    // Exception table:
    //   from	to	target	type
    //   20	33	74	java/io/IOException
    //   96	104	121	java/io/IOException
    //   50	71	256	java/io/IOException
    //   147	157	256	java/io/IOException
    //   164	233	256	java/io/IOException
    //   233	243	256	java/io/IOException
    //   257	262	290	java/io/IOException
    //   300	310	312	java/io/IOException
  }
  
  /* Error */
  ByteArrayOutputStream a(String paramString)
  {
    // Byte code:
    //   0: new 245	android/graphics/BitmapFactory$Options
    //   3: dup
    //   4: invokespecial 246	android/graphics/BitmapFactory$Options:<init>	()V
    //   7: astore_2
    //   8: aload_2
    //   9: getstatic 252	android/graphics/Bitmap$Config:ARGB_8888	Landroid/graphics/Bitmap$Config;
    //   12: putfield 255	android/graphics/BitmapFactory$Options:inPreferredConfig	Landroid/graphics/Bitmap$Config;
    //   15: aload_2
    //   16: iconst_1
    //   17: putfield 258	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   20: aload_1
    //   21: aload_2
    //   22: invokestatic 264	android/graphics/BitmapFactory:decodeFile	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   25: pop
    //   26: aload_2
    //   27: aload_2
    //   28: sipush 1024
    //   31: sipush 1024
    //   34: invokestatic 270	zti:calculateInSampleSize	(Landroid/graphics/BitmapFactory$Options;II)I
    //   37: putfield 273	android/graphics/BitmapFactory$Options:inSampleSize	I
    //   40: aload_2
    //   41: iconst_0
    //   42: putfield 258	android/graphics/BitmapFactory$Options:inJustDecodeBounds	Z
    //   45: aload_1
    //   46: aload_2
    //   47: invokestatic 277	aqhu:d	(Ljava/lang/String;Landroid/graphics/BitmapFactory$Options;)Landroid/graphics/Bitmap;
    //   50: astore_2
    //   51: aload_2
    //   52: ifnonnull +5 -> 57
    //   55: aconst_null
    //   56: areturn
    //   57: new 279	aooy
    //   60: dup
    //   61: aload_1
    //   62: invokespecial 282	aooy:<init>	(Ljava/lang/String;)V
    //   65: aload_2
    //   66: invokevirtual 286	aooy:Q	(Landroid/graphics/Bitmap;)Landroid/graphics/Bitmap;
    //   69: astore_2
    //   70: aload_2
    //   71: ifnull +143 -> 214
    //   74: new 288	java/io/ByteArrayOutputStream
    //   77: dup
    //   78: invokespecial 289	java/io/ByteArrayOutputStream:<init>	()V
    //   81: astore_1
    //   82: aload_2
    //   83: getstatic 295	android/graphics/Bitmap$CompressFormat:JPEG	Landroid/graphics/Bitmap$CompressFormat;
    //   86: bipush 100
    //   88: aload_1
    //   89: invokevirtual 301	android/graphics/Bitmap:compress	(Landroid/graphics/Bitmap$CompressFormat;ILjava/io/OutputStream;)Z
    //   92: pop
    //   93: aload_1
    //   94: ifnull +7 -> 101
    //   97: aload_1
    //   98: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   101: aload_2
    //   102: invokevirtual 305	android/graphics/Bitmap:isRecycled	()Z
    //   105: ifne +7 -> 112
    //   108: aload_2
    //   109: invokevirtual 308	android/graphics/Bitmap:recycle	()V
    //   112: aload_1
    //   113: areturn
    //   114: astore_3
    //   115: aload_3
    //   116: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   119: goto -18 -> 101
    //   122: astore_2
    //   123: aconst_null
    //   124: astore_1
    //   125: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   128: ifeq +32 -> 160
    //   131: ldc 88
    //   133: iconst_2
    //   134: new 129	java/lang/StringBuilder
    //   137: dup
    //   138: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   141: ldc_w 310
    //   144: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   147: aload_2
    //   148: invokevirtual 311	java/lang/Exception:toString	()Ljava/lang/String;
    //   151: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   154: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   157: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   160: aload_1
    //   161: ifnull +53 -> 214
    //   164: aload_1
    //   165: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   168: aconst_null
    //   169: areturn
    //   170: astore_1
    //   171: aload_1
    //   172: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   175: aconst_null
    //   176: areturn
    //   177: astore_2
    //   178: aconst_null
    //   179: astore_1
    //   180: aload_1
    //   181: ifnull +7 -> 188
    //   184: aload_1
    //   185: invokevirtual 302	java/io/ByteArrayOutputStream:close	()V
    //   188: aload_2
    //   189: athrow
    //   190: astore_1
    //   191: aload_1
    //   192: invokevirtual 207	java/io/IOException:printStackTrace	()V
    //   195: goto -7 -> 188
    //   198: astore_2
    //   199: goto -19 -> 180
    //   202: astore_2
    //   203: goto -23 -> 180
    //   206: astore_2
    //   207: goto -82 -> 125
    //   210: astore_1
    //   211: aconst_null
    //   212: areturn
    //   213: astore_1
    //   214: aconst_null
    //   215: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	216	0	this	TroopUploadingThread
    //   0	216	1	paramString	String
    //   7	102	2	localObject1	Object
    //   122	26	2	localException1	java.lang.Exception
    //   177	12	2	localObject2	Object
    //   198	1	2	localObject3	Object
    //   202	1	2	localObject4	Object
    //   206	1	2	localException2	java.lang.Exception
    //   114	2	3	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   97	101	114	java/io/IOException
    //   74	82	122	java/lang/Exception
    //   164	168	170	java/io/IOException
    //   74	82	177	finally
    //   184	188	190	java/io/IOException
    //   82	93	198	finally
    //   125	160	202	finally
    //   82	93	206	java/lang/Exception
    //   0	51	210	java/lang/Exception
    //   57	70	210	java/lang/Exception
    //   0	51	213	java/lang/OutOfMemoryError
    //   57	70	213	java/lang/OutOfMemoryError
  }
  
  /* Error */
  public HttpURLConnection a(URL paramURL, long paramLong)
  {
    // Byte code:
    //   0: aload_1
    //   1: ifnonnull +20 -> 21
    //   4: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   7: ifeq +12 -> 19
    //   10: ldc 88
    //   12: iconst_2
    //   13: ldc_w 318
    //   16: invokestatic 148	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   19: aconst_null
    //   20: areturn
    //   21: aload_1
    //   22: invokevirtual 324	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   25: checkcast 35	java/net/HttpURLConnection
    //   28: astore_1
    //   29: aload_1
    //   30: ifnonnull +27 -> 57
    //   33: aconst_null
    //   34: areturn
    //   35: astore_1
    //   36: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   39: ifeq +13 -> 52
    //   42: ldc 88
    //   44: iconst_2
    //   45: ldc_w 326
    //   48: aload_1
    //   49: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   52: aconst_null
    //   53: astore_1
    //   54: goto -25 -> 29
    //   57: aload_1
    //   58: iconst_1
    //   59: invokevirtual 330	java/net/HttpURLConnection:setDoInput	(Z)V
    //   62: aload_1
    //   63: iconst_1
    //   64: invokevirtual 333	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   67: lload_2
    //   68: l2i
    //   69: istore 4
    //   71: aload_1
    //   72: iload 4
    //   74: invokevirtual 337	java/net/HttpURLConnection:setFixedLengthStreamingMode	(I)V
    //   77: aload_1
    //   78: iconst_0
    //   79: invokevirtual 340	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   82: getstatic 345	android/os/Build$VERSION:SDK	Ljava/lang/String;
    //   85: ifnull +126 -> 211
    //   88: getstatic 348	android/os/Build$VERSION:SDK_INT	I
    //   91: bipush 13
    //   93: if_icmple +118 -> 211
    //   96: aload_1
    //   97: ldc_w 350
    //   100: ldc_w 351
    //   103: invokevirtual 355	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   106: aload_1
    //   107: ldc_w 357
    //   110: invokevirtual 360	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   113: aload_1
    //   114: ldc_w 362
    //   117: ldc_w 364
    //   120: invokevirtual 355	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   123: aload_1
    //   124: ldc_w 366
    //   127: new 129	java/lang/StringBuilder
    //   130: dup
    //   131: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   134: ldc_w 368
    //   137: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   140: ldc_w 370
    //   143: invokevirtual 136	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   146: invokevirtual 145	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   149: invokevirtual 355	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   152: aload_1
    //   153: areturn
    //   154: astore_1
    //   155: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   158: ifeq +13 -> 171
    //   161: ldc 88
    //   163: iconst_2
    //   164: ldc_w 372
    //   167: aload_1
    //   168: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   171: aconst_null
    //   172: areturn
    //   173: astore_1
    //   174: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   177: ifeq +13 -> 190
    //   180: ldc 88
    //   182: iconst_2
    //   183: ldc_w 374
    //   186: aload_1
    //   187: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   190: aconst_null
    //   191: areturn
    //   192: astore_1
    //   193: invokestatic 176	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   196: ifeq +13 -> 209
    //   199: ldc 88
    //   201: iconst_2
    //   202: ldc_w 376
    //   205: aload_1
    //   206: invokestatic 203	com/tencent/qphone/base/util/QLog:i	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   209: aconst_null
    //   210: areturn
    //   211: aload_1
    //   212: ldc_w 378
    //   215: ldc_w 380
    //   218: invokevirtual 355	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   221: goto -115 -> 106
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	224	0	this	TroopUploadingThread
    //   0	224	1	paramURL	URL
    //   0	224	2	paramLong	long
    //   69	4	4	i	int
    // Exception table:
    //   from	to	target	type
    //   21	29	35	java/io/IOException
    //   82	106	154	java/net/ProtocolException
    //   106	152	154	java/net/ProtocolException
    //   211	221	154	java/net/ProtocolException
    //   57	67	173	java/lang/IllegalAccessError
    //   71	82	192	java/lang/Exception
  }
  
  protected List<String> a(HashMap<String, String> paramHashMap, List<String> paramList, TroopClipPic paramTroopClipPic)
  {
    ArrayList localArrayList = new ArrayList(paramList.size());
    Iterator localIterator1 = paramList.iterator();
    if (localIterator1.hasNext())
    {
      paramList = (String)localIterator1.next();
      if (paramHashMap != null)
      {
        Iterator localIterator2 = paramHashMap.keySet().iterator();
        for (;;)
        {
          localObject = paramList;
          if (!localIterator2.hasNext()) {
            break;
          }
          localObject = (String)localIterator2.next();
          paramList = paramList + "&" + (String)localObject + "=" + (String)paramHashMap.get(localObject);
        }
      }
      Object localObject = paramList;
      paramList = (String)localObject + "&subcmd=" + zti.fE(paramTroopClipPic.type);
      paramList = paramList + "&subver=101";
      if (!TextUtils.isEmpty(paramTroopClipPic.clipInfo)) {}
      for (paramList = paramList + "&clip=" + paramTroopClipPic.clipInfo;; paramList = paramList + "&clip=" + zti.a(0, 0, 0, 0))
      {
        localArrayList.add(paramList);
        break;
      }
    }
    if (QLog.isColorLevel()) {
      QLog.i("TroopUploadingThread", 2, String.format("geturl=%s", new Object[] { Arrays.toString(localArrayList.toArray()) }));
    }
    return localArrayList;
  }
  
  public void a(apul paramapul)
  {
    Object localObject1 = a(paramapul.baE);
    int m;
    byte[] arrayOfByte;
    int n;
    a locala;
    int j;
    int i;
    label58:
    int k;
    if (localObject1 == null)
    {
      m = -1;
      arrayOfByte = null;
      n = 1;
      locala = new a();
      locala.ts = paramapul.ts;
      locala.type = paramapul.type;
      localObject1 = null;
      j = 0;
      i = -1;
      k = i;
      if (j <= 3)
      {
        j += 1;
        if (n == 0) {
          break label139;
        }
        k = 101;
      }
      label79:
      if (k != 0) {
        break label337;
      }
      locala.dWB = 1;
    }
    for (;;)
    {
      this.Cs.remove(paramapul);
      this.mStopped = true;
      if (k != 104) {
        this.b.notifyObservers(locala);
      }
      return;
      arrayOfByte = ((ByteArrayOutputStream)localObject1).toByteArray();
      m = arrayOfByte.length;
      n = 0;
      break;
      label139:
      k = i;
      Object localObject3 = localObject1;
      try
      {
        localObject4 = new URL(paramapul.fP(j - 1) + "&filesize=" + arrayOfByte);
        localObject1 = localObject4;
      }
      catch (MalformedURLException localMalformedURLException)
      {
        for (;;)
        {
          Object localObject4;
          long l;
          k = i;
          localObject3 = localObject1;
          QLog.d("TroopUploadingThread", 1, localMalformedURLException.getMessage(), localMalformedURLException);
        }
      }
      catch (Throwable localThrowable)
      {
        QLog.d("TroopUploadingThread", 1, localThrowable.getMessage(), localThrowable);
        i = k;
        localObject2 = localObject3;
      }
      l = m;
      k = i;
      localObject3 = localObject1;
      localObject4 = a((URL)localObject1, l);
      Object localObject2;
      if (localObject4 == null)
      {
        break label58;
        break label58;
      }
      k = i;
      localObject3 = localObject2;
      i = a(arrayOfByte, localMalformedURLException, paramapul, j);
      if (i == -4) {
        break label58;
      }
      k = i;
      if (i == -1) {
        break label79;
      }
      k = i;
      if (i == 104) {
        break label79;
      }
      k = i;
      localObject3 = localObject2;
      i = a(localMalformedURLException, locala, paramapul);
      k = i;
      break label79;
      label337:
      locala.dWB = 2;
      locala.result = k;
    }
  }
  
  public void a(ArrayList<TroopClipPic> paramArrayList, HashMap<String, String> paramHashMap, List<String> paramList, apun paramapun)
  {
    this.b = paramapun;
    if (this.Cs == null) {
      this.Cs = new ArrayList();
    }
    paramArrayList = paramArrayList.iterator();
    while (paramArrayList.hasNext())
    {
      paramapun = (TroopClipPic)paramArrayList.next();
      new File(paramapun.id);
      apul localapul = new apul();
      localapul.CC = a(paramHashMap, paramList, paramapun);
      localapul.baE = paramapun.id;
      localapul.type = paramapun.type;
      localapul.ts = paramapun.ts;
      localapul.clipInfo = paramapun.clipInfo;
      this.Cs.add(localapul);
    }
  }
  
  public ArrayList<apul> dW()
  {
    return this.Cs;
  }
  
  public boolean isStopped()
  {
    return this.mStopped;
  }
  
  public void run()
  {
    while ((this.Cs != null) && (this.Cs.size() > 0)) {
      a((apul)this.Cs.get(0));
    }
    this.b = null;
  }
  
  public static class a
  {
    public int dWB;
    public int dWC;
    public int errorCode;
    public String errorMsg;
    public int result;
    public long ts;
    public int type;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes9.jar
 * Qualified Name:     com.tencent.mobileqq.troop.utils.TroopUploadingThread
 * JD-Core Version:    0.7.0.1
 */