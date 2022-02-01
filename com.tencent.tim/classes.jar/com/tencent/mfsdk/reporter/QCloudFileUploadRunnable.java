package com.tencent.mfsdk.reporter;

import android.text.TextUtils;
import aqhq;
import com.tencent.qphone.base.util.QLog;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.net.URL;
import mqq.os.MqqHandler;
import org.json.JSONObject;
import tyv.a;

public class QCloudFileUploadRunnable
  extends BaseUploadRunnable
{
  private File P;
  private FileInputStream jdField_a_of_type_JavaIoFileInputStream;
  private tyv.a jdField_a_of_type_Tyv$a;
  private String aJX;
  private String aJY;
  private String aJZ;
  private boolean aOH;
  private MqqHandler b;
  private int bDe;
  private int dbId = -1;
  private String disposition;
  private JSONObject json;
  private int maxCount = -1;
  private String originalPath;
  private URL url;
  
  public QCloudFileUploadRunnable(URL paramURL, String paramString, JSONObject paramJSONObject, tyv.a parama, int paramInt, MqqHandler paramMqqHandler)
  {
    this.url = paramURL;
    this.originalPath = paramString;
    this.json = paramJSONObject;
    this.jdField_a_of_type_Tyv$a = parama;
    this.dbId = paramInt;
    this.b = paramMqqHandler;
    if (QLog.isColorLevel()) {
      this.bDe = 1;
    }
  }
  
  private boolean init()
  {
    Object localObject = new File(this.originalPath);
    if ((localObject != null) && (((File)localObject).isFile())) {
      localObject = this.originalPath;
    }
    for (;;)
    {
      this.P = new File((String)localObject);
      localObject = new StringBuilder(512);
      ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"uploadedfile\"; filename=\"").append(this.P.getName()).append("\"");
      this.disposition = ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      ((StringBuilder)localObject).append("--").append("27182818284590452353602874713526").append("\r\n").append(this.disposition).append("\r\n\r\n");
      this.aJX = ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      ((StringBuilder)localObject).append("\r\n--").append("27182818284590452353602874713526").append("\r\n");
      this.aJY = ((StringBuilder)localObject).toString();
      ((StringBuilder)localObject).delete(0, ((StringBuilder)localObject).length());
      ((StringBuilder)localObject).append("Content-Disposition: form-data; name=\"_json\"\r\n").append("Content-Type: application/json\r\n\r\n");
      ((StringBuilder)localObject).append(this.json.toString()).append("\r\n--").append("27182818284590452353602874713526").append("--\r\n");
      this.aJZ = ((StringBuilder)localObject).toString();
      try
      {
        this.jdField_a_of_type_JavaIoFileInputStream = new FileInputStream(this.P);
        return true;
      }
      catch (FileNotFoundException localFileNotFoundException)
      {
        long l;
        String str;
        vD(true);
      }
      if (!((File)localObject).isDirectory()) {
        break;
      }
      localObject = ((File)localObject).getParent();
      l = System.currentTimeMillis();
      str = "out_" + String.valueOf(l) + ".zip";
      localObject = (String)localObject + "/" + str;
      aqhq.zipFiles(this.originalPath, (String)localObject);
    }
    return false;
    return false;
  }
  
  private void vD(boolean paramBoolean)
  {
    try
    {
      if (this.jdField_a_of_type_JavaIoFileInputStream != null)
      {
        this.jdField_a_of_type_JavaIoFileInputStream.close();
        this.jdField_a_of_type_JavaIoFileInputStream = null;
      }
      if ((paramBoolean == true) && (this.P != null) && (this.P.isFile())) {
        this.P.delete();
      }
      return;
    }
    catch (Exception localException)
    {
      while (!QLog.isColorLevel()) {}
      QLog.e("Magnifier_QCloudFileUploadRunnable", 2, "[qcloud_report] exception:", localException);
    }
  }
  
  public boolean isSucceeded(String paramString)
  {
    boolean bool2 = true;
    boolean bool1;
    try
    {
      if (TextUtils.isEmpty(paramString)) {
        return true;
      }
      int i = new JSONObject(paramString).getInt("status");
      bool1 = bool2;
      if (i != 1000)
      {
        bool1 = bool2;
        if (i != 1495) {
          return false;
        }
      }
    }
    catch (Exception paramString)
    {
      bool1 = false;
    }
    return bool1;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 204	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:aOH	Z
    //   4: ifne +16 -> 20
    //   7: aload_0
    //   8: iconst_1
    //   9: putfield 204	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:aOH	Z
    //   12: aload_0
    //   13: invokespecial 206	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:init	()Z
    //   16: ifne +4 -> 20
    //   19: return
    //   20: aload_0
    //   21: getfield 130	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   24: ifnonnull +23 -> 47
    //   27: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   30: ifeq +11 -> 41
    //   33: ldc 174
    //   35: iconst_2
    //   36: ldc 208
    //   38: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   41: aload_0
    //   42: iconst_0
    //   43: invokespecial 165	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:vD	(Z)V
    //   46: return
    //   47: aload_0
    //   48: getfield 38	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:url	Ljava/net/URL;
    //   51: invokevirtual 217	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   54: checkcast 219	java/net/HttpURLConnection
    //   57: astore 7
    //   59: aload 7
    //   61: sipush 30000
    //   64: invokevirtual 222	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   67: aload 7
    //   69: sipush 30000
    //   72: invokevirtual 225	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   75: aload 7
    //   77: iconst_1
    //   78: invokevirtual 228	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   81: aload 7
    //   83: iconst_1
    //   84: invokevirtual 231	java/net/HttpURLConnection:setDoInput	(Z)V
    //   87: aload 7
    //   89: iconst_0
    //   90: invokevirtual 234	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   93: aload 7
    //   95: ldc 235
    //   97: invokevirtual 238	java/net/HttpURLConnection:setChunkedStreamingMode	(I)V
    //   100: aload 7
    //   102: ldc 240
    //   104: invokevirtual 243	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   107: aload 7
    //   109: ldc 245
    //   111: ldc 247
    //   113: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   116: aload 7
    //   118: ldc 253
    //   120: ldc 255
    //   122: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   125: aload 7
    //   127: ldc_w 257
    //   130: ldc_w 259
    //   133: invokevirtual 251	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   136: new 261	java/io/DataOutputStream
    //   139: dup
    //   140: aload 7
    //   142: invokevirtual 265	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   145: invokespecial 268	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   148: astore 6
    //   150: aload 6
    //   152: astore 5
    //   154: aload 6
    //   156: aload_0
    //   157: getfield 108	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:aJX	Ljava/lang/String;
    //   160: invokevirtual 271	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   163: aload 6
    //   165: astore 5
    //   167: aload_0
    //   168: getfield 130	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   171: invokevirtual 274	java/io/FileInputStream:available	()I
    //   174: ldc 235
    //   176: invokestatic 280	java/lang/Math:min	(II)I
    //   179: istore_2
    //   180: aload 6
    //   182: astore 5
    //   184: iload_2
    //   185: newarray byte
    //   187: astore 8
    //   189: aload 6
    //   191: astore 5
    //   193: aload_0
    //   194: getfield 130	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   197: aload 8
    //   199: iconst_0
    //   200: iload_2
    //   201: invokevirtual 284	java/io/FileInputStream:read	([BII)I
    //   204: istore_1
    //   205: iload_1
    //   206: ifle +207 -> 413
    //   209: aload 6
    //   211: astore 5
    //   213: aload 6
    //   215: aload 8
    //   217: iconst_0
    //   218: iload_2
    //   219: invokevirtual 288	java/io/DataOutputStream:write	([BII)V
    //   222: aload 6
    //   224: astore 5
    //   226: aload_0
    //   227: getfield 130	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   230: invokevirtual 274	java/io/FileInputStream:available	()I
    //   233: ldc 235
    //   235: invokestatic 280	java/lang/Math:min	(II)I
    //   238: istore_2
    //   239: aload 6
    //   241: astore 5
    //   243: aload_0
    //   244: getfield 130	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_JavaIoFileInputStream	Ljava/io/FileInputStream;
    //   247: aload 8
    //   249: iconst_0
    //   250: iload_2
    //   251: invokevirtual 284	java/io/FileInputStream:read	([BII)I
    //   254: istore_1
    //   255: goto -50 -> 205
    //   258: astore 9
    //   260: aload 6
    //   262: astore 5
    //   264: aload 9
    //   266: invokevirtual 291	java/lang/OutOfMemoryError:printStackTrace	()V
    //   269: goto -47 -> 222
    //   272: astore 7
    //   274: iconst_0
    //   275: istore_3
    //   276: aload 6
    //   278: astore 5
    //   280: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   283: ifeq +18 -> 301
    //   286: aload 6
    //   288: astore 5
    //   290: ldc 174
    //   292: iconst_2
    //   293: ldc_w 293
    //   296: aload 7
    //   298: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   301: iload_3
    //   302: istore 4
    //   304: aload 6
    //   306: ifnull +11 -> 317
    //   309: aload 6
    //   311: invokevirtual 294	java/io/DataOutputStream:close	()V
    //   314: iload_3
    //   315: istore 4
    //   317: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   320: ifeq +43 -> 363
    //   323: ldc 174
    //   325: iconst_2
    //   326: new 70	java/lang/StringBuilder
    //   329: dup
    //   330: invokespecial 143	java/lang/StringBuilder:<init>	()V
    //   333: ldc_w 296
    //   336: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   339: iload 4
    //   341: invokevirtual 299	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   344: ldc_w 301
    //   347: invokevirtual 79	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   350: aload_0
    //   351: getfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   354: invokevirtual 304	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   357: invokevirtual 88	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   360: invokestatic 211	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   363: iload 4
    //   365: ifne +289 -> 654
    //   368: aload_0
    //   369: getfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   372: ifle +282 -> 654
    //   375: aload_0
    //   376: iconst_0
    //   377: invokespecial 165	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:vD	(Z)V
    //   380: aload_0
    //   381: aload_0
    //   382: getfield 34	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:maxCount	I
    //   385: iconst_1
    //   386: iadd
    //   387: putfield 34	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:maxCount	I
    //   390: aload_0
    //   391: aload_0
    //   392: getfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   395: iconst_1
    //   396: isub
    //   397: putfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   400: aload_0
    //   401: getfield 46	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:b	Lmqq/os/MqqHandler;
    //   404: aload_0
    //   405: ldc2_w 305
    //   408: invokevirtual 312	mqq/os/MqqHandler:postDelayed	(Ljava/lang/Runnable;J)Z
    //   411: pop
    //   412: return
    //   413: aload 6
    //   415: astore 5
    //   417: aload 6
    //   419: aload_0
    //   420: getfield 112	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:aJY	Ljava/lang/String;
    //   423: invokevirtual 271	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   426: aload 6
    //   428: astore 5
    //   430: aload 6
    //   432: aload_0
    //   433: getfield 123	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:aJZ	Ljava/lang/String;
    //   436: invokevirtual 271	java/io/DataOutputStream:writeBytes	(Ljava/lang/String;)V
    //   439: aload 6
    //   441: astore 5
    //   443: aload_0
    //   444: new 314	java/io/BufferedInputStream
    //   447: dup
    //   448: aload 7
    //   450: invokevirtual 318	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   453: invokespecial 321	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   456: sipush 8192
    //   459: invokestatic 327	com/tencent/qapmsdk/common/util/FileUtil:readStream	(Ljava/io/InputStream;I)Ljava/lang/String;
    //   462: invokevirtual 329	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:isSucceeded	(Ljava/lang/String;)Z
    //   465: istore_3
    //   466: aload 6
    //   468: astore 5
    //   470: aload_0
    //   471: getfield 44	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_Tyv$a	Ltyv$a;
    //   474: ifnull +24 -> 498
    //   477: iload_3
    //   478: ifeq +20 -> 498
    //   481: aload 6
    //   483: astore 5
    //   485: aload_0
    //   486: getfield 44	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:jdField_a_of_type_Tyv$a	Ltyv$a;
    //   489: aload_0
    //   490: getfield 36	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:dbId	I
    //   493: invokeinterface 334 2 0
    //   498: iload_3
    //   499: istore 4
    //   501: aload 6
    //   503: ifnull -186 -> 317
    //   506: aload 6
    //   508: invokevirtual 294	java/io/DataOutputStream:close	()V
    //   511: iload_3
    //   512: istore 4
    //   514: goto -197 -> 317
    //   517: astore 5
    //   519: iload_3
    //   520: istore 4
    //   522: goto -205 -> 317
    //   525: astore 5
    //   527: aconst_null
    //   528: astore 6
    //   530: iconst_0
    //   531: istore_3
    //   532: aload 6
    //   534: astore 5
    //   536: aload_0
    //   537: iconst_0
    //   538: putfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   541: iload_3
    //   542: istore 4
    //   544: aload 6
    //   546: ifnull -229 -> 317
    //   549: aload 6
    //   551: invokevirtual 294	java/io/DataOutputStream:close	()V
    //   554: iload_3
    //   555: istore 4
    //   557: goto -240 -> 317
    //   560: astore 5
    //   562: iload_3
    //   563: istore 4
    //   565: goto -248 -> 317
    //   568: astore 7
    //   570: aconst_null
    //   571: astore 6
    //   573: iconst_0
    //   574: istore_3
    //   575: aload 6
    //   577: astore 5
    //   579: aload_0
    //   580: iconst_0
    //   581: putfield 54	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:bDe	I
    //   584: aload 6
    //   586: astore 5
    //   588: invokestatic 52	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   591: ifeq +18 -> 609
    //   594: aload 6
    //   596: astore 5
    //   598: ldc 174
    //   600: iconst_2
    //   601: ldc_w 293
    //   604: aload 7
    //   606: invokestatic 180	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;Ljava/lang/Throwable;)V
    //   609: iload_3
    //   610: istore 4
    //   612: aload 6
    //   614: ifnull -297 -> 317
    //   617: aload 6
    //   619: invokevirtual 294	java/io/DataOutputStream:close	()V
    //   622: iload_3
    //   623: istore 4
    //   625: goto -308 -> 317
    //   628: astore 5
    //   630: iload_3
    //   631: istore 4
    //   633: goto -316 -> 317
    //   636: astore 6
    //   638: aconst_null
    //   639: astore 5
    //   641: aload 5
    //   643: ifnull +8 -> 651
    //   646: aload 5
    //   648: invokevirtual 294	java/io/DataOutputStream:close	()V
    //   651: aload 6
    //   653: athrow
    //   654: aload_0
    //   655: iconst_0
    //   656: invokespecial 165	com/tencent/mfsdk/reporter/QCloudFileUploadRunnable:vD	(Z)V
    //   659: return
    //   660: astore 5
    //   662: iload_3
    //   663: istore 4
    //   665: goto -348 -> 317
    //   668: astore 5
    //   670: goto -19 -> 651
    //   673: astore 6
    //   675: goto -34 -> 641
    //   678: astore 7
    //   680: iconst_0
    //   681: istore_3
    //   682: goto -107 -> 575
    //   685: astore 7
    //   687: goto -112 -> 575
    //   690: astore 5
    //   692: iconst_0
    //   693: istore_3
    //   694: goto -162 -> 532
    //   697: astore 5
    //   699: goto -167 -> 532
    //   702: astore 7
    //   704: aconst_null
    //   705: astore 6
    //   707: iconst_0
    //   708: istore_3
    //   709: goto -433 -> 276
    //   712: astore 7
    //   714: goto -438 -> 276
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	717	0	this	QCloudFileUploadRunnable
    //   204	51	1	i	int
    //   179	72	2	j	int
    //   275	434	3	bool1	boolean
    //   302	362	4	bool2	boolean
    //   152	332	5	localDataOutputStream1	java.io.DataOutputStream
    //   517	1	5	localIOException1	java.io.IOException
    //   525	1	5	localOutOfMemoryError1	java.lang.OutOfMemoryError
    //   534	1	5	localDataOutputStream2	java.io.DataOutputStream
    //   560	1	5	localIOException2	java.io.IOException
    //   577	20	5	localDataOutputStream3	java.io.DataOutputStream
    //   628	1	5	localIOException3	java.io.IOException
    //   639	8	5	localObject1	Object
    //   660	1	5	localIOException4	java.io.IOException
    //   668	1	5	localIOException5	java.io.IOException
    //   690	1	5	localOutOfMemoryError2	java.lang.OutOfMemoryError
    //   697	1	5	localOutOfMemoryError3	java.lang.OutOfMemoryError
    //   148	470	6	localDataOutputStream4	java.io.DataOutputStream
    //   636	16	6	localObject2	Object
    //   673	1	6	localObject3	Object
    //   705	1	6	localObject4	Object
    //   57	84	7	localHttpURLConnection	java.net.HttpURLConnection
    //   272	177	7	localException1	Exception
    //   568	37	7	localThrowable1	java.lang.Throwable
    //   678	1	7	localThrowable2	java.lang.Throwable
    //   685	1	7	localThrowable3	java.lang.Throwable
    //   702	1	7	localException2	Exception
    //   712	1	7	localException3	Exception
    //   187	61	8	arrayOfByte	byte[]
    //   258	7	9	localOutOfMemoryError4	java.lang.OutOfMemoryError
    // Exception table:
    //   from	to	target	type
    //   213	222	258	java/lang/OutOfMemoryError
    //   154	163	272	java/lang/Exception
    //   167	180	272	java/lang/Exception
    //   184	189	272	java/lang/Exception
    //   193	205	272	java/lang/Exception
    //   213	222	272	java/lang/Exception
    //   226	239	272	java/lang/Exception
    //   243	255	272	java/lang/Exception
    //   264	269	272	java/lang/Exception
    //   417	426	272	java/lang/Exception
    //   430	439	272	java/lang/Exception
    //   443	466	272	java/lang/Exception
    //   506	511	517	java/io/IOException
    //   47	150	525	java/lang/OutOfMemoryError
    //   549	554	560	java/io/IOException
    //   47	150	568	java/lang/Throwable
    //   617	622	628	java/io/IOException
    //   47	150	636	finally
    //   309	314	660	java/io/IOException
    //   646	651	668	java/io/IOException
    //   154	163	673	finally
    //   167	180	673	finally
    //   184	189	673	finally
    //   193	205	673	finally
    //   213	222	673	finally
    //   226	239	673	finally
    //   243	255	673	finally
    //   264	269	673	finally
    //   280	286	673	finally
    //   290	301	673	finally
    //   417	426	673	finally
    //   430	439	673	finally
    //   443	466	673	finally
    //   470	477	673	finally
    //   485	498	673	finally
    //   536	541	673	finally
    //   579	584	673	finally
    //   588	594	673	finally
    //   598	609	673	finally
    //   154	163	678	java/lang/Throwable
    //   167	180	678	java/lang/Throwable
    //   184	189	678	java/lang/Throwable
    //   193	205	678	java/lang/Throwable
    //   213	222	678	java/lang/Throwable
    //   226	239	678	java/lang/Throwable
    //   243	255	678	java/lang/Throwable
    //   264	269	678	java/lang/Throwable
    //   417	426	678	java/lang/Throwable
    //   430	439	678	java/lang/Throwable
    //   443	466	678	java/lang/Throwable
    //   470	477	685	java/lang/Throwable
    //   485	498	685	java/lang/Throwable
    //   154	163	690	java/lang/OutOfMemoryError
    //   167	180	690	java/lang/OutOfMemoryError
    //   184	189	690	java/lang/OutOfMemoryError
    //   193	205	690	java/lang/OutOfMemoryError
    //   226	239	690	java/lang/OutOfMemoryError
    //   243	255	690	java/lang/OutOfMemoryError
    //   264	269	690	java/lang/OutOfMemoryError
    //   417	426	690	java/lang/OutOfMemoryError
    //   430	439	690	java/lang/OutOfMemoryError
    //   443	466	690	java/lang/OutOfMemoryError
    //   470	477	697	java/lang/OutOfMemoryError
    //   485	498	697	java/lang/OutOfMemoryError
    //   47	150	702	java/lang/Exception
    //   470	477	712	java/lang/Exception
    //   485	498	712	java/lang/Exception
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes7.jar
 * Qualified Name:     com.tencent.mfsdk.reporter.QCloudFileUploadRunnable
 * JD-Core Version:    0.7.0.1
 */