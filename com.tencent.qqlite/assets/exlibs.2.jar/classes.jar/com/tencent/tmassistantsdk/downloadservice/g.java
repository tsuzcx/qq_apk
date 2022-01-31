package com.tencent.tmassistantsdk.downloadservice;

import android.text.TextUtils;
import com.tencent.tmassistantsdk.e.b;
import com.tencent.tmassistantsdk.f.f;
import com.tencent.tmassistantsdk.f.k;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import org.apache.http.Header;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;

public final class g
{
  private boolean a = false;
  private HttpClient b = null;
  private HttpGet c = null;
  private d d = null;
  private byte[] e = new byte[4096];
  private b f;
  private int g = f.k();
  
  public g(d paramd)
  {
    this.d = paramd;
  }
  
  private void a(HttpResponse paramHttpResponse)
  {
    if (paramHttpResponse == null) {}
    for (;;)
    {
      return;
      if (this.d.a.equals("application/vnd.android.package-archive"))
      {
        Object localObject = null;
        paramHttpResponse = paramHttpResponse.getHeaders("Content-Disposition");
        if ((paramHttpResponse != null) && (paramHttpResponse.length > 0))
        {
          paramHttpResponse = paramHttpResponse[0].getValue();
          if ((!TextUtils.isEmpty(paramHttpResponse)) && (paramHttpResponse.contains("filename=\"")))
          {
            String str = paramHttpResponse.substring(paramHttpResponse.indexOf("filename=\"") + 10);
            paramHttpResponse = localObject;
            if (!TextUtils.isEmpty(str))
            {
              paramHttpResponse = str.substring(0, str.indexOf("\""));
              k.b("_DownloadTask", "header file Name =" + paramHttpResponse);
            }
          }
        }
        while (!TextUtils.isEmpty(paramHttpResponse))
        {
          paramHttpResponse = c.d(c.c(paramHttpResponse));
          this.d.k = paramHttpResponse;
          return;
          paramHttpResponse = c.b(this.d.c);
          continue;
          paramHttpResponse = c.b(this.d.c);
        }
      }
    }
  }
  
  /* Error */
  private void a(HttpResponse paramHttpResponse, com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo paramDownloadChunkLogInfo)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokeinterface 137 1 0
    //   6: astore 10
    //   8: aload_0
    //   9: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   12: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   15: lconst_0
    //   16: lcmp
    //   17: ifne +391 -> 408
    //   20: aload_1
    //   21: invokeinterface 144 1 0
    //   26: invokeinterface 149 1 0
    //   31: sipush 200
    //   34: if_icmpne +261 -> 295
    //   37: aload_0
    //   38: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   41: aload 10
    //   43: invokeinterface 154 1 0
    //   48: invokevirtual 157	com/tencent/tmassistantsdk/downloadservice/d:a	(J)V
    //   51: ldc 96
    //   53: new 98	java/lang/StringBuilder
    //   56: dup
    //   57: ldc 159
    //   59: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   62: aload_0
    //   63: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   66: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   69: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   72: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   75: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   78: ldc 96
    //   80: new 98	java/lang/StringBuilder
    //   83: dup
    //   84: ldc 164
    //   86: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   89: aload_0
    //   90: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   93: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   96: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   99: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   102: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   105: aload_1
    //   106: ldc 168
    //   108: invokeinterface 172 2 0
    //   113: astore_1
    //   114: aload_1
    //   115: ifnull +36 -> 151
    //   118: aload_1
    //   119: invokeinterface 70 1 0
    //   124: invokestatic 177	com/tencent/tmassistantsdk/downloadservice/b:a	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/b;
    //   127: astore_1
    //   128: aload_2
    //   129: aload_1
    //   130: invokevirtual 179	com/tencent/tmassistantsdk/downloadservice/b:a	()J
    //   133: putfield 185	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   136: aload_2
    //   137: aload_1
    //   138: invokevirtual 186	com/tencent/tmassistantsdk/downloadservice/b:b	()J
    //   141: aload_1
    //   142: invokevirtual 179	com/tencent/tmassistantsdk/downloadservice/b:a	()J
    //   145: lsub
    //   146: lconst_1
    //   147: ladd
    //   148: putfield 189	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   151: aload_2
    //   152: aload_0
    //   153: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   156: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   159: putfield 192	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   162: aload_0
    //   163: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   166: ifnonnull +28 -> 194
    //   169: aload_0
    //   170: new 196	com/tencent/tmassistantsdk/e/b
    //   173: dup
    //   174: aload_0
    //   175: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   178: getfield 199	com/tencent/tmassistantsdk/downloadservice/d:l	Ljava/lang/String;
    //   181: aload_0
    //   182: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   185: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   188: invokespecial 201	com/tencent/tmassistantsdk/e/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   191: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   194: lconst_0
    //   195: lstore 7
    //   197: lload 7
    //   199: lstore 5
    //   201: aload 10
    //   203: invokeinterface 205 1 0
    //   208: astore_1
    //   209: lload 7
    //   211: lstore 5
    //   213: ldc 96
    //   215: new 98	java/lang/StringBuilder
    //   218: dup
    //   219: ldc 207
    //   221: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   224: aload_0
    //   225: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   228: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   231: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   234: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   237: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   240: lconst_0
    //   241: lstore 5
    //   243: aload_1
    //   244: aload_0
    //   245: getfield 33	com/tencent/tmassistantsdk/downloadservice/g:e	[B
    //   248: invokevirtual 213	java/io/InputStream:read	([B)I
    //   251: istore 4
    //   253: iload 4
    //   255: ifle +14 -> 269
    //   258: aload_0
    //   259: getfield 25	com/tencent/tmassistantsdk/downloadservice/g:a	Z
    //   262: ifeq +396 -> 658
    //   265: aload_1
    //   266: invokevirtual 216	java/io/InputStream:close	()V
    //   269: aload_0
    //   270: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   273: ifnull +15 -> 288
    //   276: aload_0
    //   277: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   280: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   283: aload_0
    //   284: aconst_null
    //   285: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   288: aload_2
    //   289: lload 5
    //   291: putfield 221	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   294: return
    //   295: aload_1
    //   296: invokeinterface 144 1 0
    //   301: invokeinterface 149 1 0
    //   306: sipush 206
    //   309: if_icmpne +60 -> 369
    //   312: aload_1
    //   313: ldc 168
    //   315: invokeinterface 172 2 0
    //   320: astore 11
    //   322: aload_0
    //   323: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   326: aload 11
    //   328: invokeinterface 70 1 0
    //   333: invokestatic 224	com/tencent/tmassistantsdk/downloadservice/b:b	(Ljava/lang/String;)J
    //   336: invokevirtual 157	com/tencent/tmassistantsdk/downloadservice/d:a	(J)V
    //   339: ldc 96
    //   341: new 98	java/lang/StringBuilder
    //   344: dup
    //   345: ldc 226
    //   347: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   350: aload_0
    //   351: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   354: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   357: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   360: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   363: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   366: goto -288 -> 78
    //   369: ldc 96
    //   371: new 98	java/lang/StringBuilder
    //   374: dup
    //   375: ldc 228
    //   377: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   380: aload_1
    //   381: invokeinterface 144 1 0
    //   386: invokeinterface 149 1 0
    //   391: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   394: ldc 233
    //   396: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   399: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   402: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   405: goto -327 -> 78
    //   408: aload_1
    //   409: invokeinterface 144 1 0
    //   414: invokeinterface 149 1 0
    //   419: sipush 206
    //   422: if_icmpne -260 -> 162
    //   425: aload_1
    //   426: ldc 168
    //   428: invokeinterface 172 2 0
    //   433: astore_1
    //   434: aload_1
    //   435: invokeinterface 70 1 0
    //   440: invokestatic 177	com/tencent/tmassistantsdk/downloadservice/b:a	(Ljava/lang/String;)Lcom/tencent/tmassistantsdk/downloadservice/b;
    //   443: astore 11
    //   445: aload_1
    //   446: invokeinterface 70 1 0
    //   451: invokestatic 224	com/tencent/tmassistantsdk/downloadservice/b:b	(Ljava/lang/String;)J
    //   454: lstore 5
    //   456: aload_2
    //   457: aload 11
    //   459: invokevirtual 179	com/tencent/tmassistantsdk/downloadservice/b:a	()J
    //   462: putfield 185	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangePosition	J
    //   465: aload_2
    //   466: aload 11
    //   468: invokevirtual 186	com/tencent/tmassistantsdk/downloadservice/b:b	()J
    //   471: aload 11
    //   473: invokevirtual 179	com/tencent/tmassistantsdk/downloadservice/b:a	()J
    //   476: lsub
    //   477: lconst_1
    //   478: ladd
    //   479: putfield 189	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseRangeLength	J
    //   482: aload_2
    //   483: lload 5
    //   485: putfield 192	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   488: ldc 96
    //   490: new 98	java/lang/StringBuilder
    //   493: dup
    //   494: ldc 235
    //   496: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   499: lload 5
    //   501: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   504: ldc 237
    //   506: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   509: aload_0
    //   510: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   513: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   516: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   519: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   522: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   525: aload 11
    //   527: invokevirtual 179	com/tencent/tmassistantsdk/downloadservice/b:a	()J
    //   530: aload_0
    //   531: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   534: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   537: lcmp
    //   538: ifeq +51 -> 589
    //   541: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   544: dup
    //   545: sipush 706
    //   548: ldc 244
    //   550: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   553: athrow
    //   554: astore_1
    //   555: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   558: dup
    //   559: sipush 704
    //   562: aload_1
    //   563: invokespecial 250	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/Throwable;)V
    //   566: athrow
    //   567: astore_1
    //   568: aload_0
    //   569: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   572: ifnull +15 -> 587
    //   575: aload_0
    //   576: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   579: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   582: aload_0
    //   583: aconst_null
    //   584: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   587: aload_1
    //   588: athrow
    //   589: lload 5
    //   591: aload_0
    //   592: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   595: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   598: lcmp
    //   599: ifeq +16 -> 615
    //   602: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   605: dup
    //   606: sipush 705
    //   609: ldc 252
    //   611: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   614: athrow
    //   615: ldc 96
    //   617: new 98	java/lang/StringBuilder
    //   620: dup
    //   621: ldc 254
    //   623: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   626: aload_1
    //   627: invokevirtual 257	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   630: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   633: invokestatic 259	com/tencent/tmassistantsdk/f/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   636: aload_0
    //   637: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   640: ifnull -478 -> 162
    //   643: aload_0
    //   644: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   647: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   650: aload_0
    //   651: aconst_null
    //   652: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   655: goto -493 -> 162
    //   658: aload_0
    //   659: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   662: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   665: iload 4
    //   667: i2l
    //   668: ladd
    //   669: lstore 7
    //   671: lload 7
    //   673: aload_0
    //   674: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   677: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   680: lcmp
    //   681: ifgt +432 -> 1113
    //   684: lload 7
    //   686: aload_0
    //   687: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   690: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   693: lcmp
    //   694: ifne +217 -> 911
    //   697: iconst_1
    //   698: istore 9
    //   700: aload_0
    //   701: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   704: aload_0
    //   705: getfield 33	com/tencent/tmassistantsdk/downloadservice/g:e	[B
    //   708: iconst_0
    //   709: iload 4
    //   711: aload_0
    //   712: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   715: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   718: iload 9
    //   720: invokevirtual 262	com/tencent/tmassistantsdk/e/b:a	([BIIJZ)Z
    //   723: ifne +369 -> 1092
    //   726: invokestatic 264	com/tencent/tmassistantsdk/e/b:d	()Ljava/lang/String;
    //   729: aload_0
    //   730: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   733: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   736: invokestatic 267	com/tencent/tmassistantsdk/downloadservice/c:a	(Ljava/lang/String;J)Z
    //   739: ifeq +268 -> 1007
    //   742: ldc_w 269
    //   745: invokestatic 274	android/os/Environment:getExternalStorageState	()Ljava/lang/String;
    //   748: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   751: ifeq +166 -> 917
    //   754: invokestatic 278	android/os/Environment:getExternalStorageDirectory	()Ljava/io/File;
    //   757: invokevirtual 284	java/io/File:canWrite	()Z
    //   760: ifeq +157 -> 917
    //   763: iconst_1
    //   764: istore_3
    //   765: iload_3
    //   766: ifeq +156 -> 922
    //   769: new 98	java/lang/StringBuilder
    //   772: dup
    //   773: ldc_w 286
    //   776: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   779: aload_0
    //   780: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   783: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   786: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   789: ldc_w 288
    //   792: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   795: aload_0
    //   796: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   799: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   802: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   805: ldc_w 290
    //   808: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   811: iload 4
    //   813: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   816: ldc_w 292
    //   819: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   822: aload_0
    //   823: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   826: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   829: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   832: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   835: astore_1
    //   836: ldc 96
    //   838: aload_1
    //   839: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   842: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   845: dup
    //   846: sipush 703
    //   849: aload_1
    //   850: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   853: athrow
    //   854: astore_1
    //   855: lload 5
    //   857: lstore 7
    //   859: lload 7
    //   861: lstore 5
    //   863: aload_1
    //   864: invokevirtual 295	java/net/SocketException:printStackTrace	()V
    //   867: lload 7
    //   869: lstore 5
    //   871: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   874: dup
    //   875: sipush 605
    //   878: aload_1
    //   879: invokespecial 250	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/Throwable;)V
    //   882: athrow
    //   883: astore_1
    //   884: aload_0
    //   885: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   888: ifnull +15 -> 903
    //   891: aload_0
    //   892: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   895: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   898: aload_0
    //   899: aconst_null
    //   900: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   903: aload_2
    //   904: lload 5
    //   906: putfield 221	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:receiveDataSize	J
    //   909: aload_1
    //   910: athrow
    //   911: iconst_0
    //   912: istore 9
    //   914: goto -214 -> 700
    //   917: iconst_0
    //   918: istore_3
    //   919: goto -154 -> 765
    //   922: new 98	java/lang/StringBuilder
    //   925: dup
    //   926: ldc_w 297
    //   929: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   932: aload_0
    //   933: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   936: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   939: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   942: ldc_w 288
    //   945: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   948: aload_0
    //   949: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   952: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   955: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   958: ldc_w 290
    //   961: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   964: iload 4
    //   966: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   969: ldc_w 292
    //   972: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   975: aload_0
    //   976: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   979: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   982: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   985: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   988: astore_1
    //   989: ldc 96
    //   991: aload_1
    //   992: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   995: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   998: dup
    //   999: sipush 711
    //   1002: aload_1
    //   1003: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   1006: athrow
    //   1007: new 98	java/lang/StringBuilder
    //   1010: dup
    //   1011: ldc_w 299
    //   1014: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1017: aload_0
    //   1018: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1021: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1024: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1027: ldc_w 288
    //   1030: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1033: aload_0
    //   1034: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1037: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   1040: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1043: ldc_w 290
    //   1046: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1049: iload 4
    //   1051: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1054: ldc_w 292
    //   1057: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1060: aload_0
    //   1061: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1064: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   1067: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1070: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1073: astore_1
    //   1074: ldc 96
    //   1076: aload_1
    //   1077: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1080: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   1083: dup
    //   1084: sipush 710
    //   1087: aload_1
    //   1088: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   1091: athrow
    //   1092: aload_0
    //   1093: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1096: iload 4
    //   1098: i2l
    //   1099: invokevirtual 301	com/tencent/tmassistantsdk/downloadservice/d:b	(J)V
    //   1102: lload 5
    //   1104: iload 4
    //   1106: i2l
    //   1107: ladd
    //   1108: lstore 5
    //   1110: goto -867 -> 243
    //   1113: ldc 96
    //   1115: new 98	java/lang/StringBuilder
    //   1118: dup
    //   1119: ldc_w 303
    //   1122: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1125: iload 4
    //   1127: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1130: ldc_w 305
    //   1133: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1136: aload_0
    //   1137: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1140: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   1143: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1146: ldc_w 307
    //   1149: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1152: aload_0
    //   1153: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1156: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   1159: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   1162: ldc_w 309
    //   1165: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1168: iconst_0
    //   1169: invokevirtual 312	java/lang/StringBuilder:append	(Z)Ljava/lang/StringBuilder;
    //   1172: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1175: invokestatic 166	com/tencent/tmassistantsdk/f/k:d	(Ljava/lang/String;Ljava/lang/String;)V
    //   1178: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   1181: dup
    //   1182: sipush 703
    //   1185: ldc_w 314
    //   1188: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   1191: athrow
    //   1192: astore_1
    //   1193: goto -334 -> 859
    //   1196: astore_1
    //   1197: goto -313 -> 884
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1200	0	this	g
    //   0	1200	1	paramHttpResponse	HttpResponse
    //   0	1200	2	paramDownloadChunkLogInfo	com.tencent.tmassistantsdk.protocol.jce.DownloadChunkLogInfo
    //   764	155	3	i	int
    //   251	875	4	j	int
    //   199	910	5	l1	long
    //   195	673	7	l2	long
    //   698	215	9	bool	boolean
    //   6	196	10	localHttpEntity	org.apache.http.HttpEntity
    //   320	206	11	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   425	554	554	java/lang/Throwable
    //   589	615	554	java/lang/Throwable
    //   615	636	554	java/lang/Throwable
    //   425	554	567	finally
    //   555	567	567	finally
    //   589	615	567	finally
    //   615	636	567	finally
    //   243	253	854	java/net/SocketException
    //   258	269	854	java/net/SocketException
    //   658	697	854	java/net/SocketException
    //   700	763	854	java/net/SocketException
    //   769	854	854	java/net/SocketException
    //   922	1007	854	java/net/SocketException
    //   1007	1092	854	java/net/SocketException
    //   1092	1102	854	java/net/SocketException
    //   1113	1192	854	java/net/SocketException
    //   201	209	883	finally
    //   213	240	883	finally
    //   863	867	883	finally
    //   871	883	883	finally
    //   201	209	1192	java/net/SocketException
    //   213	240	1192	java/net/SocketException
    //   243	253	1196	finally
    //   258	269	1196	finally
    //   658	697	1196	finally
    //   700	763	1196	finally
    //   769	854	1196	finally
    //   922	1007	1196	finally
    //   1007	1092	1196	finally
    //   1092	1102	1196	finally
    //   1113	1192	1196	finally
  }
  
  private static void a(HttpGet paramHttpGet, Map paramMap)
  {
    if ((paramHttpGet != null) && (paramMap != null) && (paramMap.size() > 0))
    {
      paramMap = paramMap.entrySet().iterator();
      while (paramMap.hasNext())
      {
        Map.Entry localEntry = (Map.Entry)paramMap.next();
        paramHttpGet.addHeader((String)localEntry.getKey(), (String)localEntry.getValue());
      }
    }
  }
  
  public final int a()
  {
    return this.g;
  }
  
  public final void b()
  {
    k.b("_DownloadTask", "DownloadTask::cancel url: " + this.d.b);
    this.a = true;
    if ((this.c != null) && (!this.c.isAborted())) {
      this.c.abort();
    }
  }
  
  public final String c()
  {
    return this.d.b;
  }
  
  public final int d()
  {
    return this.d.m;
  }
  
  /* Error */
  public final void e()
  {
    // Byte code:
    //   0: aload_0
    //   1: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   4: iconst_1
    //   5: putfield 380	com/tencent/tmassistantsdk/downloadservice/d:g	Z
    //   8: aload_0
    //   9: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   12: iconst_2
    //   13: invokevirtual 383	com/tencent/tmassistantsdk/downloadservice/d:a	(I)V
    //   16: aconst_null
    //   17: astore 11
    //   19: aconst_null
    //   20: astore 10
    //   22: iconst_1
    //   23: istore_1
    //   24: iload_1
    //   25: ifeq +2647 -> 2672
    //   28: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   31: pop
    //   32: iconst_0
    //   33: invokestatic 391	com/tencent/tmassistantsdk/c/a:a	(B)Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;
    //   36: astore 11
    //   38: aload 11
    //   40: aload_0
    //   41: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   44: getfield 393	com/tencent/tmassistantsdk/downloadservice/d:f	Ljava/lang/String;
    //   47: putfield 396	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:UUID	Ljava/lang/String;
    //   50: aload 11
    //   52: aload_0
    //   53: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   56: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   59: i2b
    //   60: putfield 402	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:currentRetryCnt	B
    //   63: aload 11
    //   65: aload_0
    //   66: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   69: getfield 355	com/tencent/tmassistantsdk/downloadservice/d:b	Ljava/lang/String;
    //   72: putfield 405	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestUrl	Ljava/lang/String;
    //   75: aload_0
    //   76: getfield 25	com/tencent/tmassistantsdk/downloadservice/g:a	Z
    //   79: ifne +2593 -> 2672
    //   82: aload_0
    //   83: invokestatic 410	com/tencent/tmassistantsdk/b/a:b	()Lorg/apache/http/client/HttpClient;
    //   86: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   89: aload_0
    //   90: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   93: invokestatic 413	com/tencent/tmassistantsdk/b/a:a	(Lorg/apache/http/client/HttpClient;)V
    //   96: aload_0
    //   97: new 348	org/apache/http/client/methods/HttpGet
    //   100: dup
    //   101: invokespecial 414	org/apache/http/client/methods/HttpGet:<init>	()V
    //   104: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   107: aload_0
    //   108: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   111: new 416	java/net/URI
    //   114: dup
    //   115: aload_0
    //   116: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   119: getfield 126	com/tencent/tmassistantsdk/downloadservice/d:c	Ljava/lang/String;
    //   122: invokespecial 417	java/net/URI:<init>	(Ljava/lang/String;)V
    //   125: invokevirtual 421	org/apache/http/client/methods/HttpGet:setURI	(Ljava/net/URI;)V
    //   128: aload_0
    //   129: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   132: aload_0
    //   133: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   136: invokevirtual 424	com/tencent/tmassistantsdk/downloadservice/d:a	()Ljava/util/HashMap;
    //   139: invokestatic 426	com/tencent/tmassistantsdk/downloadservice/g:a	(Lorg/apache/http/client/methods/HttpGet;Ljava/util/Map;)V
    //   142: aload_0
    //   143: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   146: astore 12
    //   148: invokestatic 428	com/tencent/tmassistantsdk/downloadservice/c:b	()Ljava/lang/String;
    //   151: astore 13
    //   153: aload_0
    //   154: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   157: aload 13
    //   159: putfield 431	com/tencent/tmassistantsdk/downloadservice/d:o	Ljava/lang/String;
    //   162: aload 13
    //   164: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   167: ifne +679 -> 846
    //   170: aload 13
    //   172: ldc_w 433
    //   175: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   178: ifne +26 -> 204
    //   181: aload 13
    //   183: ldc_w 435
    //   186: invokevirtual 81	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   189: ifeq +657 -> 846
    //   192: aload_0
    //   193: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   196: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   199: istore_2
    //   200: iload_2
    //   201: ifle +645 -> 846
    //   204: aload 13
    //   206: invokestatic 439	com/tencent/tmassistantsdk/downloadservice/f:a	(Ljava/lang/String;)I
    //   209: istore_2
    //   210: aload_0
    //   211: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   214: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   217: lstore 7
    //   219: aload_0
    //   220: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   223: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   226: lconst_0
    //   227: lcmp
    //   228: ifle +406 -> 634
    //   231: aload_0
    //   232: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   235: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   238: iload_2
    //   239: i2l
    //   240: ladd
    //   241: lconst_1
    //   242: lsub
    //   243: lstore 5
    //   245: lload 5
    //   247: lstore_3
    //   248: lload 5
    //   250: aload_0
    //   251: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   254: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   257: lcmp
    //   258: iflt +13 -> 271
    //   261: aload_0
    //   262: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   265: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   268: lconst_1
    //   269: lsub
    //   270: lstore_3
    //   271: new 98	java/lang/StringBuilder
    //   274: dup
    //   275: ldc_w 441
    //   278: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   281: lload 7
    //   283: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   286: ldc_w 443
    //   289: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   292: lload_3
    //   293: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   296: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   299: astore 13
    //   301: aload 12
    //   303: ldc_w 445
    //   306: aload 13
    //   308: invokevirtual 351	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   311: ldc 96
    //   313: new 98	java/lang/StringBuilder
    //   316: dup
    //   317: ldc_w 447
    //   320: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   323: aload 13
    //   325: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   328: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   331: invokestatic 259	com/tencent/tmassistantsdk/f/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   334: aload 11
    //   336: aload_0
    //   337: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   340: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   343: putfield 192	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   346: aload 11
    //   348: lload 7
    //   350: putfield 450	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestRanagePosition	J
    //   353: aload 11
    //   355: iload_2
    //   356: i2l
    //   357: putfield 453	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestRanageSize	J
    //   360: ldc 96
    //   362: new 98	java/lang/StringBuilder
    //   365: dup
    //   366: ldc_w 455
    //   369: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   372: invokestatic 461	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   375: invokevirtual 464	java/lang/Thread:getName	()Ljava/lang/String;
    //   378: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   381: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   384: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   387: aload_0
    //   388: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   391: aload_0
    //   392: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   395: invokeinterface 470 2 0
    //   400: astore 12
    //   402: aload 12
    //   404: ifnonnull +635 -> 1039
    //   407: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   410: dup
    //   411: sipush 701
    //   414: new 98	java/lang/StringBuilder
    //   417: dup
    //   418: ldc_w 472
    //   421: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   424: invokestatic 461	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   427: invokevirtual 464	java/lang/Thread:getName	()Ljava/lang/String;
    //   430: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   433: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   436: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   439: athrow
    //   440: astore 12
    //   442: aload 12
    //   444: invokevirtual 473	org/apache/http/conn/ConnectTimeoutException:printStackTrace	()V
    //   447: aload_0
    //   448: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   451: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   454: istore_2
    //   455: iload_2
    //   456: iconst_5
    //   457: if_icmpgt +2114 -> 2571
    //   460: iconst_1
    //   461: istore_2
    //   462: iload_2
    //   463: ifeq +2130 -> 2593
    //   466: aload_0
    //   467: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   470: astore 12
    //   472: aload 12
    //   474: aload 12
    //   476: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   479: iconst_1
    //   480: iadd
    //   481: putfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   484: ldc2_w 474
    //   487: invokestatic 478	java/lang/Thread:sleep	(J)V
    //   490: iconst_1
    //   491: istore_1
    //   492: aload_0
    //   493: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   496: ifnull +25 -> 521
    //   499: aload_0
    //   500: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   503: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   506: ifne +10 -> 516
    //   509: aload_0
    //   510: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   513: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   516: aload_0
    //   517: aconst_null
    //   518: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   521: aload_0
    //   522: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   525: ifnull +22 -> 547
    //   528: aload_0
    //   529: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   532: invokeinterface 482 1 0
    //   537: invokeinterface 487 1 0
    //   542: aload_0
    //   543: aconst_null
    //   544: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   547: aload_0
    //   548: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   551: ifnull +15 -> 566
    //   554: aload_0
    //   555: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   558: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   561: aload_0
    //   562: aconst_null
    //   563: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   566: aload 11
    //   568: astore 12
    //   570: iload_1
    //   571: iconst_1
    //   572: if_icmpne +55 -> 627
    //   575: aload 11
    //   577: astore 12
    //   579: aload 11
    //   581: ifnull +46 -> 627
    //   584: aload 11
    //   586: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   589: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   592: aload 11
    //   594: aload_0
    //   595: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   598: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   601: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   604: aload 11
    //   606: aload_0
    //   607: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   610: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   613: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   616: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   619: aload 11
    //   621: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   624: aconst_null
    //   625: astore 12
    //   627: aload 12
    //   629: astore 11
    //   631: goto -607 -> 24
    //   634: iload_2
    //   635: iconst_1
    //   636: isub
    //   637: i2l
    //   638: lstore_3
    //   639: goto -368 -> 271
    //   642: astore 12
    //   644: aload 12
    //   646: invokevirtual 511	java/lang/UnsupportedOperationException:printStackTrace	()V
    //   649: goto -289 -> 360
    //   652: astore 12
    //   654: aload 12
    //   656: invokevirtual 512	java/net/SocketTimeoutException:printStackTrace	()V
    //   659: aload_0
    //   660: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   663: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   666: istore_2
    //   667: iload_2
    //   668: iconst_5
    //   669: if_icmpgt +1943 -> 2612
    //   672: iconst_1
    //   673: istore_2
    //   674: iload_2
    //   675: ifeq +1963 -> 2638
    //   678: aload_0
    //   679: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   682: astore 13
    //   684: aload 13
    //   686: aload 13
    //   688: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   691: iconst_1
    //   692: iadd
    //   693: putfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   696: ldc2_w 474
    //   699: invokestatic 478	java/lang/Thread:sleep	(J)V
    //   702: iconst_1
    //   703: istore_1
    //   704: aload_0
    //   705: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   708: ifnull +25 -> 733
    //   711: aload_0
    //   712: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   715: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   718: ifne +10 -> 728
    //   721: aload_0
    //   722: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   725: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   728: aload_0
    //   729: aconst_null
    //   730: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   733: aload_0
    //   734: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   737: ifnull +22 -> 759
    //   740: aload_0
    //   741: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   744: invokeinterface 482 1 0
    //   749: invokeinterface 487 1 0
    //   754: aload_0
    //   755: aconst_null
    //   756: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   759: aload_0
    //   760: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   763: ifnull +15 -> 778
    //   766: aload_0
    //   767: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   770: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   773: aload_0
    //   774: aconst_null
    //   775: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   778: aload 11
    //   780: astore 12
    //   782: iload_1
    //   783: iconst_1
    //   784: if_icmpne +55 -> 839
    //   787: aload 11
    //   789: astore 12
    //   791: aload 11
    //   793: ifnull +46 -> 839
    //   796: aload 11
    //   798: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   801: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   804: aload 11
    //   806: aload_0
    //   807: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   810: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   813: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   816: aload 11
    //   818: aload_0
    //   819: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   822: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   825: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   828: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   831: aload 11
    //   833: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   836: aconst_null
    //   837: astore 12
    //   839: aload 12
    //   841: astore 11
    //   843: goto -819 -> 24
    //   846: new 98	java/lang/StringBuilder
    //   849: dup
    //   850: ldc_w 441
    //   853: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   856: aload_0
    //   857: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   860: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   863: invokevirtual 162	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   866: ldc_w 443
    //   869: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   872: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   875: astore 13
    //   877: aload 12
    //   879: ldc_w 445
    //   882: aload 13
    //   884: invokevirtual 351	org/apache/http/client/methods/HttpGet:addHeader	(Ljava/lang/String;Ljava/lang/String;)V
    //   887: ldc 96
    //   889: new 98	java/lang/StringBuilder
    //   892: dup
    //   893: ldc_w 447
    //   896: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   899: aload 13
    //   901: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   904: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   907: invokestatic 259	com/tencent/tmassistantsdk/f/k:c	(Ljava/lang/String;Ljava/lang/String;)V
    //   910: aload 11
    //   912: aload_0
    //   913: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   916: invokevirtual 140	com/tencent/tmassistantsdk/downloadservice/d:b	()J
    //   919: putfield 192	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseContentLength	J
    //   922: aload 11
    //   924: aload_0
    //   925: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   928: getfield 240	com/tencent/tmassistantsdk/downloadservice/d:j	J
    //   931: putfield 450	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestRanagePosition	J
    //   934: aload 11
    //   936: lconst_0
    //   937: putfield 453	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:requestRanageSize	J
    //   940: goto -580 -> 360
    //   943: astore 10
    //   945: aload 10
    //   947: invokevirtual 513	java/net/UnknownHostException:printStackTrace	()V
    //   950: aload_0
    //   951: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   954: sipush 603
    //   957: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   960: aload_0
    //   961: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   964: ifnull +25 -> 989
    //   967: aload_0
    //   968: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   971: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   974: ifne +10 -> 984
    //   977: aload_0
    //   978: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   981: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   984: aload_0
    //   985: aconst_null
    //   986: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   989: aload_0
    //   990: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   993: ifnull +22 -> 1015
    //   996: aload_0
    //   997: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1000: invokeinterface 482 1 0
    //   1005: invokeinterface 487 1 0
    //   1010: aload_0
    //   1011: aconst_null
    //   1012: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1015: aload_0
    //   1016: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1019: ifnull +15 -> 1034
    //   1022: aload_0
    //   1023: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1026: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   1029: aload_0
    //   1030: aconst_null
    //   1031: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1034: iconst_0
    //   1035: istore_1
    //   1036: goto -1012 -> 24
    //   1039: aload 12
    //   1041: invokeinterface 144 1 0
    //   1046: invokeinterface 149 1 0
    //   1051: istore_2
    //   1052: ldc 96
    //   1054: new 98	java/lang/StringBuilder
    //   1057: dup
    //   1058: ldc_w 515
    //   1061: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1064: iload_2
    //   1065: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1068: ldc_w 517
    //   1071: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1074: invokestatic 461	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1077: invokevirtual 464	java/lang/Thread:getName	()Ljava/lang/String;
    //   1080: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1083: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1086: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   1089: aload 11
    //   1091: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   1094: putfield 520	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:readHeaderTime	J
    //   1097: aload 11
    //   1099: iload_2
    //   1100: putfield 523	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:responseHttpCode	I
    //   1103: iload_2
    //   1104: lookupswitch	default:+1719->2823, 200:+206->1310, 206:+696->1800, 301:+1096->2200, 302:+1096->2200, 303:+1096->2200, 307:+1096->2200, 416:+1384->2488, 500:+1436->2540, 503:+1410->2514
    //   1189: nop
    //   1190: <illegal opcode>
    //   1191: dup
    //   1192: iload_2
    //   1193: new 98	java/lang/StringBuilder
    //   1196: dup
    //   1197: ldc_w 525
    //   1200: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1203: iload_2
    //   1204: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   1207: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1210: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   1213: athrow
    //   1214: astore 10
    //   1216: aload 10
    //   1218: invokevirtual 526	java/lang/InterruptedException:printStackTrace	()V
    //   1221: aload_0
    //   1222: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1225: sipush 600
    //   1228: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   1231: aload_0
    //   1232: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1235: ifnull +25 -> 1260
    //   1238: aload_0
    //   1239: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1242: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1245: ifne +10 -> 1255
    //   1248: aload_0
    //   1249: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1252: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   1255: aload_0
    //   1256: aconst_null
    //   1257: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1260: aload_0
    //   1261: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1264: ifnull +22 -> 1286
    //   1267: aload_0
    //   1268: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1271: invokeinterface 482 1 0
    //   1276: invokeinterface 487 1 0
    //   1281: aload_0
    //   1282: aconst_null
    //   1283: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1286: aload_0
    //   1287: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1290: ifnull +15 -> 1305
    //   1293: aload_0
    //   1294: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1297: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   1300: aload_0
    //   1301: aconst_null
    //   1302: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1305: iconst_0
    //   1306: istore_1
    //   1307: goto -1283 -> 24
    //   1310: aload 12
    //   1312: ldc_w 528
    //   1315: invokeinterface 64 2 0
    //   1320: astore 13
    //   1322: aload 13
    //   1324: ifnull +46 -> 1370
    //   1327: aload 13
    //   1329: arraylength
    //   1330: ifle +40 -> 1370
    //   1333: aload_0
    //   1334: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1337: getfield 48	com/tencent/tmassistantsdk/downloadservice/d:a	Ljava/lang/String;
    //   1340: ldc_w 530
    //   1343: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1346: ifeq +190 -> 1536
    //   1349: aload_0
    //   1350: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1353: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1356: invokestatic 532	com/tencent/tmassistantsdk/downloadservice/c:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1359: astore 13
    //   1361: aload_0
    //   1362: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1365: aload 13
    //   1367: putfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1370: aload_0
    //   1371: aload 12
    //   1373: aload 11
    //   1375: invokespecial 534	com/tencent/tmassistantsdk/downloadservice/g:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   1378: aload_0
    //   1379: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1382: invokevirtual 536	com/tencent/tmassistantsdk/downloadservice/d:c	()Z
    //   1385: istore 9
    //   1387: iload 9
    //   1389: ifne +1177 -> 2566
    //   1392: iconst_1
    //   1393: istore_1
    //   1394: aload_0
    //   1395: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1398: ifnull +25 -> 1423
    //   1401: aload_0
    //   1402: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1405: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1408: ifne +10 -> 1418
    //   1411: aload_0
    //   1412: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1415: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   1418: aload_0
    //   1419: aconst_null
    //   1420: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1423: aload_0
    //   1424: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1427: ifnull +22 -> 1449
    //   1430: aload_0
    //   1431: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1434: invokeinterface 482 1 0
    //   1439: invokeinterface 487 1 0
    //   1444: aload_0
    //   1445: aconst_null
    //   1446: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1449: aload_0
    //   1450: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1453: ifnull +15 -> 1468
    //   1456: aload_0
    //   1457: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1460: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   1463: aload_0
    //   1464: aconst_null
    //   1465: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1468: aload 11
    //   1470: astore 12
    //   1472: iload_1
    //   1473: iconst_1
    //   1474: if_icmpne +55 -> 1529
    //   1477: aload 11
    //   1479: astore 12
    //   1481: aload 11
    //   1483: ifnull +46 -> 1529
    //   1486: aload 11
    //   1488: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   1491: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   1494: aload 11
    //   1496: aload_0
    //   1497: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1500: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   1503: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   1506: aload 11
    //   1508: aload_0
    //   1509: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1512: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   1515: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   1518: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   1521: aload 11
    //   1523: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   1526: aconst_null
    //   1527: astore 12
    //   1529: aload 12
    //   1531: astore 11
    //   1533: goto -1509 -> 24
    //   1536: aload 13
    //   1538: iconst_0
    //   1539: aaload
    //   1540: invokeinterface 70 1 0
    //   1545: astore 13
    //   1547: aload 13
    //   1549: invokestatic 76	android/text/TextUtils:isEmpty	(Ljava/lang/CharSequence;)Z
    //   1552: ifne +143 -> 1695
    //   1555: aload 13
    //   1557: ldc_w 538
    //   1560: invokevirtual 542	java/lang/String:startsWith	(Ljava/lang/String;)Z
    //   1563: ifeq +132 -> 1695
    //   1566: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   1569: dup
    //   1570: sipush 708
    //   1573: new 98	java/lang/StringBuilder
    //   1576: dup
    //   1577: ldc_w 544
    //   1580: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   1583: invokestatic 461	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   1586: invokevirtual 464	java/lang/Thread:getName	()Ljava/lang/String;
    //   1589: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   1592: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   1595: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   1598: athrow
    //   1599: astore 10
    //   1601: aload 10
    //   1603: invokevirtual 545	javax/net/ssl/SSLException:printStackTrace	()V
    //   1606: aload_0
    //   1607: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1610: sipush 607
    //   1613: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   1616: aload_0
    //   1617: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1620: ifnull +25 -> 1645
    //   1623: aload_0
    //   1624: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1627: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1630: ifne +10 -> 1640
    //   1633: aload_0
    //   1634: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1637: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   1640: aload_0
    //   1641: aconst_null
    //   1642: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1645: aload_0
    //   1646: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1649: ifnull +22 -> 1671
    //   1652: aload_0
    //   1653: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1656: invokeinterface 482 1 0
    //   1661: invokeinterface 487 1 0
    //   1666: aload_0
    //   1667: aconst_null
    //   1668: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1671: aload_0
    //   1672: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1675: ifnull +15 -> 1690
    //   1678: aload_0
    //   1679: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1682: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   1685: aload_0
    //   1686: aconst_null
    //   1687: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1690: iconst_0
    //   1691: istore_1
    //   1692: goto -1668 -> 24
    //   1695: aload_0
    //   1696: aload 12
    //   1698: invokespecial 547	com/tencent/tmassistantsdk/downloadservice/g:a	(Lorg/apache/http/HttpResponse;)V
    //   1701: goto -331 -> 1370
    //   1704: astore 10
    //   1706: aload 10
    //   1708: invokevirtual 548	java/io/IOException:printStackTrace	()V
    //   1711: aload_0
    //   1712: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1715: sipush 606
    //   1718: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   1721: aload_0
    //   1722: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1725: ifnull +25 -> 1750
    //   1728: aload_0
    //   1729: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1732: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1735: ifne +10 -> 1745
    //   1738: aload_0
    //   1739: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1742: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   1745: aload_0
    //   1746: aconst_null
    //   1747: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1750: aload_0
    //   1751: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1754: ifnull +22 -> 1776
    //   1757: aload_0
    //   1758: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1761: invokeinterface 482 1 0
    //   1766: invokeinterface 487 1 0
    //   1771: aload_0
    //   1772: aconst_null
    //   1773: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1776: aload_0
    //   1777: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1780: ifnull +15 -> 1795
    //   1783: aload_0
    //   1784: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1787: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   1790: aload_0
    //   1791: aconst_null
    //   1792: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   1795: iconst_0
    //   1796: istore_1
    //   1797: goto -1773 -> 24
    //   1800: aload_0
    //   1801: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1804: getfield 48	com/tencent/tmassistantsdk/downloadservice/d:a	Ljava/lang/String;
    //   1807: ldc_w 530
    //   1810: invokevirtual 56	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   1813: ifeq +282 -> 2095
    //   1816: aload_0
    //   1817: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1820: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1823: invokestatic 532	com/tencent/tmassistantsdk/downloadservice/c:e	(Ljava/lang/String;)Ljava/lang/String;
    //   1826: astore 13
    //   1828: aload_0
    //   1829: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1832: aload 13
    //   1834: putfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1837: aload_0
    //   1838: aload 12
    //   1840: aload 11
    //   1842: invokespecial 534	com/tencent/tmassistantsdk/downloadservice/g:a	(Lorg/apache/http/HttpResponse;Lcom/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo;)V
    //   1845: goto -467 -> 1378
    //   1848: astore 12
    //   1850: aload 12
    //   1852: invokevirtual 549	com/tencent/tmassistantsdk/downloadservice/n:printStackTrace	()V
    //   1855: aload_0
    //   1856: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1859: aload 12
    //   1861: getfield 551	com/tencent/tmassistantsdk/downloadservice/n:a	I
    //   1864: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   1867: sipush 704
    //   1870: aload 12
    //   1872: getfield 551	com/tencent/tmassistantsdk/downloadservice/n:a	I
    //   1875: if_icmpne +792 -> 2667
    //   1878: aload_0
    //   1879: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1882: lconst_0
    //   1883: invokevirtual 157	com/tencent/tmassistantsdk/downloadservice/d:a	(J)V
    //   1886: new 196	com/tencent/tmassistantsdk/e/b
    //   1889: dup
    //   1890: aload_0
    //   1891: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1894: getfield 199	com/tencent/tmassistantsdk/downloadservice/d:l	Ljava/lang/String;
    //   1897: aload_0
    //   1898: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1901: getfield 124	com/tencent/tmassistantsdk/downloadservice/d:k	Ljava/lang/String;
    //   1904: invokespecial 201	com/tencent/tmassistantsdk/e/b:<init>	(Ljava/lang/String;Ljava/lang/String;)V
    //   1907: invokevirtual 553	com/tencent/tmassistantsdk/e/b:a	()V
    //   1910: aload_0
    //   1911: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1914: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   1917: istore_2
    //   1918: iload_2
    //   1919: iconst_5
    //   1920: if_icmpgt +737 -> 2657
    //   1923: iconst_1
    //   1924: istore_1
    //   1925: iload_1
    //   1926: ifeq +736 -> 2662
    //   1929: aload_0
    //   1930: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   1933: astore 10
    //   1935: aload 10
    //   1937: aload 10
    //   1939: getfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   1942: iconst_1
    //   1943: iadd
    //   1944: putfield 398	com/tencent/tmassistantsdk/downloadservice/d:d	I
    //   1947: iconst_1
    //   1948: istore_1
    //   1949: aload_0
    //   1950: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1953: ifnull +25 -> 1978
    //   1956: aload_0
    //   1957: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1960: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   1963: ifne +10 -> 1973
    //   1966: aload_0
    //   1967: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1970: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   1973: aload_0
    //   1974: aconst_null
    //   1975: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   1978: aload_0
    //   1979: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1982: ifnull +22 -> 2004
    //   1985: aload_0
    //   1986: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   1989: invokeinterface 482 1 0
    //   1994: invokeinterface 487 1 0
    //   1999: aload_0
    //   2000: aconst_null
    //   2001: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2004: aload_0
    //   2005: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2008: ifnull +15 -> 2023
    //   2011: aload_0
    //   2012: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2015: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   2018: aload_0
    //   2019: aconst_null
    //   2020: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2023: aload 11
    //   2025: astore 10
    //   2027: iload_1
    //   2028: iconst_1
    //   2029: if_icmpne +55 -> 2084
    //   2032: aload 11
    //   2034: astore 10
    //   2036: aload 11
    //   2038: ifnull +46 -> 2084
    //   2041: aload 11
    //   2043: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   2046: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   2049: aload 11
    //   2051: aload_0
    //   2052: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2055: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2058: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   2061: aload 11
    //   2063: aload_0
    //   2064: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2067: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   2070: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   2073: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   2076: aload 11
    //   2078: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   2081: aconst_null
    //   2082: astore 10
    //   2084: aload 10
    //   2086: astore 11
    //   2088: aload 12
    //   2090: astore 10
    //   2092: goto -2068 -> 24
    //   2095: aload_0
    //   2096: aload 12
    //   2098: invokespecial 547	com/tencent/tmassistantsdk/downloadservice/g:a	(Lorg/apache/http/HttpResponse;)V
    //   2101: goto -264 -> 1837
    //   2104: astore 10
    //   2106: aload 10
    //   2108: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   2111: aload_0
    //   2112: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2115: sipush 604
    //   2118: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2121: aload_0
    //   2122: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2125: ifnull +25 -> 2150
    //   2128: aload_0
    //   2129: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2132: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   2135: ifne +10 -> 2145
    //   2138: aload_0
    //   2139: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2142: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   2145: aload_0
    //   2146: aconst_null
    //   2147: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2150: aload_0
    //   2151: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2154: ifnull +22 -> 2176
    //   2157: aload_0
    //   2158: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2161: invokeinterface 482 1 0
    //   2166: invokeinterface 487 1 0
    //   2171: aload_0
    //   2172: aconst_null
    //   2173: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2176: aload_0
    //   2177: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2180: ifnull +15 -> 2195
    //   2183: aload_0
    //   2184: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2187: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   2190: aload_0
    //   2191: aconst_null
    //   2192: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2195: iconst_0
    //   2196: istore_1
    //   2197: goto -2173 -> 24
    //   2200: aload_0
    //   2201: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2204: getfield 556	com/tencent/tmassistantsdk/downloadservice/d:e	I
    //   2207: iconst_5
    //   2208: if_icmple +146 -> 2354
    //   2211: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2214: dup
    //   2215: sipush 709
    //   2218: ldc_w 558
    //   2221: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2224: athrow
    //   2225: astore 10
    //   2227: aload_0
    //   2228: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2231: ifnull +25 -> 2256
    //   2234: aload_0
    //   2235: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2238: invokevirtual 358	org/apache/http/client/methods/HttpGet:isAborted	()Z
    //   2241: ifne +10 -> 2251
    //   2244: aload_0
    //   2245: getfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2248: invokevirtual 361	org/apache/http/client/methods/HttpGet:abort	()V
    //   2251: aload_0
    //   2252: aconst_null
    //   2253: putfield 29	com/tencent/tmassistantsdk/downloadservice/g:c	Lorg/apache/http/client/methods/HttpGet;
    //   2256: aload_0
    //   2257: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2260: ifnull +22 -> 2282
    //   2263: aload_0
    //   2264: getfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2267: invokeinterface 482 1 0
    //   2272: invokeinterface 487 1 0
    //   2277: aload_0
    //   2278: aconst_null
    //   2279: putfield 27	com/tencent/tmassistantsdk/downloadservice/g:b	Lorg/apache/http/client/HttpClient;
    //   2282: aload_0
    //   2283: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2286: ifnull +15 -> 2301
    //   2289: aload_0
    //   2290: getfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2293: invokevirtual 218	com/tencent/tmassistantsdk/e/b:c	()V
    //   2296: aload_0
    //   2297: aconst_null
    //   2298: putfield 194	com/tencent/tmassistantsdk/downloadservice/g:f	Lcom/tencent/tmassistantsdk/e/b;
    //   2301: iload_1
    //   2302: iconst_1
    //   2303: if_icmpne +48 -> 2351
    //   2306: aload 11
    //   2308: ifnull +43 -> 2351
    //   2311: aload 11
    //   2313: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   2316: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   2319: aload 11
    //   2321: aload_0
    //   2322: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2325: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2328: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   2331: aload 11
    //   2333: aload_0
    //   2334: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2337: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   2340: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   2343: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   2346: aload 11
    //   2348: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   2351: aload 10
    //   2353: athrow
    //   2354: aload 12
    //   2356: ldc_w 560
    //   2359: invokeinterface 172 2 0
    //   2364: astore 12
    //   2366: aload 12
    //   2368: ifnull +92 -> 2460
    //   2371: aload 12
    //   2373: invokeinterface 70 1 0
    //   2378: astore 12
    //   2380: aload 12
    //   2382: invokestatic 562	com/tencent/tmassistantsdk/downloadservice/c:f	(Ljava/lang/String;)Z
    //   2385: ifeq +36 -> 2421
    //   2388: aload_0
    //   2389: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2392: aload 12
    //   2394: invokestatic 564	com/tencent/tmassistantsdk/downloadservice/c:a	(Ljava/lang/String;)Ljava/lang/String;
    //   2397: putfield 126	com/tencent/tmassistantsdk/downloadservice/d:c	Ljava/lang/String;
    //   2400: aload_0
    //   2401: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2404: astore 12
    //   2406: aload 12
    //   2408: aload 12
    //   2410: getfield 556	com/tencent/tmassistantsdk/downloadservice/d:e	I
    //   2413: iconst_1
    //   2414: iadd
    //   2415: putfield 556	com/tencent/tmassistantsdk/downloadservice/d:e	I
    //   2418: goto -1040 -> 1378
    //   2421: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2424: dup
    //   2425: sipush 700
    //   2428: new 98	java/lang/StringBuilder
    //   2431: dup
    //   2432: ldc_w 566
    //   2435: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2438: iload_2
    //   2439: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2442: ldc_w 568
    //   2445: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2448: aload 12
    //   2450: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2453: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2456: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2459: athrow
    //   2460: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2463: dup
    //   2464: sipush 702
    //   2467: new 98	java/lang/StringBuilder
    //   2470: dup
    //   2471: ldc_w 570
    //   2474: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2477: iload_2
    //   2478: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2481: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2484: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2487: athrow
    //   2488: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2491: dup
    //   2492: iload_2
    //   2493: new 98	java/lang/StringBuilder
    //   2496: dup
    //   2497: ldc_w 525
    //   2500: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2503: iload_2
    //   2504: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2507: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2510: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2513: athrow
    //   2514: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2517: dup
    //   2518: iload_2
    //   2519: new 98	java/lang/StringBuilder
    //   2522: dup
    //   2523: ldc_w 525
    //   2526: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2529: iload_2
    //   2530: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2533: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2536: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2539: athrow
    //   2540: new 242	com/tencent/tmassistantsdk/downloadservice/n
    //   2543: dup
    //   2544: iload_2
    //   2545: new 98	java/lang/StringBuilder
    //   2548: dup
    //   2549: ldc_w 525
    //   2552: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2555: iload_2
    //   2556: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2559: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2562: invokespecial 247	com/tencent/tmassistantsdk/downloadservice/n:<init>	(ILjava/lang/String;)V
    //   2565: athrow
    //   2566: iconst_0
    //   2567: istore_1
    //   2568: goto -1174 -> 1394
    //   2571: iconst_0
    //   2572: istore_2
    //   2573: goto -2111 -> 462
    //   2576: astore 10
    //   2578: aload_0
    //   2579: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2582: sipush 600
    //   2585: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2588: iconst_0
    //   2589: istore_1
    //   2590: goto -2098 -> 492
    //   2593: aload_0
    //   2594: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2597: sipush 601
    //   2600: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2603: iconst_0
    //   2604: istore_1
    //   2605: aload 12
    //   2607: astore 10
    //   2609: goto -2117 -> 492
    //   2612: iconst_0
    //   2613: istore_2
    //   2614: goto -1940 -> 674
    //   2617: astore 10
    //   2619: aload_0
    //   2620: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2623: sipush 600
    //   2626: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2629: iconst_0
    //   2630: istore_1
    //   2631: aload 12
    //   2633: astore 10
    //   2635: goto -1931 -> 704
    //   2638: aload_0
    //   2639: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2642: sipush 602
    //   2645: putfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2648: iconst_0
    //   2649: istore_1
    //   2650: aload 12
    //   2652: astore 10
    //   2654: goto -1950 -> 704
    //   2657: iconst_0
    //   2658: istore_1
    //   2659: goto -734 -> 1925
    //   2662: iconst_0
    //   2663: istore_1
    //   2664: goto -715 -> 1949
    //   2667: iconst_0
    //   2668: istore_1
    //   2669: goto -720 -> 1949
    //   2672: aload_0
    //   2673: getfield 25	com/tencent/tmassistantsdk/downloadservice/g:a	Z
    //   2676: ifne +21 -> 2697
    //   2679: aload_0
    //   2680: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2683: invokevirtual 536	com/tencent/tmassistantsdk/downloadservice/d:c	()Z
    //   2686: ifeq +109 -> 2795
    //   2689: aload_0
    //   2690: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2693: iconst_4
    //   2694: invokevirtual 383	com/tencent/tmassistantsdk/downloadservice/d:a	(I)V
    //   2697: aload 11
    //   2699: ifnull +43 -> 2742
    //   2702: aload 11
    //   2704: invokestatic 492	java/lang/System:currentTimeMillis	()J
    //   2707: putfield 495	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:endTime	J
    //   2710: aload 11
    //   2712: aload_0
    //   2713: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2716: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2719: putfield 501	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:errorCode	I
    //   2722: aload 11
    //   2724: aload_0
    //   2725: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2728: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   2731: putfield 507	com/tencent/tmassistantsdk/protocol/jce/DownloadChunkLogInfo:resultState	I
    //   2734: invokestatic 388	com/tencent/tmassistantsdk/c/a:a	()Lcom/tencent/tmassistantsdk/c/a;
    //   2737: aload 11
    //   2739: invokevirtual 510	com/tencent/tmassistantsdk/c/a:a	(Lcom/qq/taf/jce/JceStruct;)V
    //   2742: ldc 96
    //   2744: new 98	java/lang/StringBuilder
    //   2747: dup
    //   2748: ldc_w 572
    //   2751: invokespecial 103	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   2754: aload_0
    //   2755: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2758: getfield 504	com/tencent/tmassistantsdk/downloadservice/d:i	I
    //   2761: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2764: ldc_w 574
    //   2767: invokevirtual 107	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   2770: aload_0
    //   2771: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2774: getfield 498	com/tencent/tmassistantsdk/downloadservice/d:n	I
    //   2777: invokevirtual 231	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   2780: invokevirtual 110	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   2783: invokestatic 115	com/tencent/tmassistantsdk/f/k:b	(Ljava/lang/String;Ljava/lang/String;)V
    //   2786: aload_0
    //   2787: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2790: iconst_0
    //   2791: putfield 380	com/tencent/tmassistantsdk/downloadservice/d:g	Z
    //   2794: return
    //   2795: aload_0
    //   2796: getfield 31	com/tencent/tmassistantsdk/downloadservice/g:d	Lcom/tencent/tmassistantsdk/downloadservice/d;
    //   2799: iconst_5
    //   2800: invokevirtual 383	com/tencent/tmassistantsdk/downloadservice/d:a	(I)V
    //   2803: aload 10
    //   2805: ifnull -108 -> 2697
    //   2808: aload 10
    //   2810: invokevirtual 554	java/lang/Throwable:printStackTrace	()V
    //   2813: goto -116 -> 2697
    //   2816: astore 10
    //   2818: iconst_1
    //   2819: istore_1
    //   2820: goto -593 -> 2227
    //   2823: goto -1635 -> 1188
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	2826	0	this	g
    //   23	2797	1	i	int
    //   199	2415	2	j	int
    //   247	392	3	l1	long
    //   243	6	5	l2	long
    //   217	132	7	l3	long
    //   1385	3	9	bool	boolean
    //   20	1	10	localObject1	Object
    //   943	3	10	localUnknownHostException	java.net.UnknownHostException
    //   1214	3	10	localInterruptedException1	java.lang.InterruptedException
    //   1599	3	10	localSSLException	javax.net.ssl.SSLException
    //   1704	3	10	localIOException	java.io.IOException
    //   1933	158	10	localObject2	Object
    //   2104	3	10	localThrowable	java.lang.Throwable
    //   2225	127	10	localObject3	Object
    //   2576	1	10	localInterruptedException2	java.lang.InterruptedException
    //   2607	1	10	localObject4	Object
    //   2617	1	10	localInterruptedException3	java.lang.InterruptedException
    //   2633	176	10	localObject5	Object
    //   2816	1	10	localObject6	Object
    //   17	2721	11	localObject7	Object
    //   146	257	12	localObject8	Object
    //   440	3	12	localConnectTimeoutException	org.apache.http.conn.ConnectTimeoutException
    //   470	158	12	localObject9	Object
    //   642	3	12	localUnsupportedOperationException	java.lang.UnsupportedOperationException
    //   652	3	12	localSocketTimeoutException	java.net.SocketTimeoutException
    //   780	1059	12	localObject10	Object
    //   1848	507	12	localn	n
    //   2364	287	12	localObject11	Object
    //   151	1682	13	localObject12	Object
    // Exception table:
    //   from	to	target	type
    //   82	200	440	org/apache/http/conn/ConnectTimeoutException
    //   204	245	440	org/apache/http/conn/ConnectTimeoutException
    //   248	271	440	org/apache/http/conn/ConnectTimeoutException
    //   271	360	440	org/apache/http/conn/ConnectTimeoutException
    //   360	402	440	org/apache/http/conn/ConnectTimeoutException
    //   407	440	440	org/apache/http/conn/ConnectTimeoutException
    //   644	649	440	org/apache/http/conn/ConnectTimeoutException
    //   846	940	440	org/apache/http/conn/ConnectTimeoutException
    //   1039	1103	440	org/apache/http/conn/ConnectTimeoutException
    //   1188	1214	440	org/apache/http/conn/ConnectTimeoutException
    //   1310	1322	440	org/apache/http/conn/ConnectTimeoutException
    //   1327	1370	440	org/apache/http/conn/ConnectTimeoutException
    //   1370	1378	440	org/apache/http/conn/ConnectTimeoutException
    //   1378	1387	440	org/apache/http/conn/ConnectTimeoutException
    //   1536	1599	440	org/apache/http/conn/ConnectTimeoutException
    //   1695	1701	440	org/apache/http/conn/ConnectTimeoutException
    //   1800	1837	440	org/apache/http/conn/ConnectTimeoutException
    //   1837	1845	440	org/apache/http/conn/ConnectTimeoutException
    //   2095	2101	440	org/apache/http/conn/ConnectTimeoutException
    //   2200	2225	440	org/apache/http/conn/ConnectTimeoutException
    //   2354	2366	440	org/apache/http/conn/ConnectTimeoutException
    //   2371	2418	440	org/apache/http/conn/ConnectTimeoutException
    //   2421	2460	440	org/apache/http/conn/ConnectTimeoutException
    //   2460	2488	440	org/apache/http/conn/ConnectTimeoutException
    //   2488	2514	440	org/apache/http/conn/ConnectTimeoutException
    //   2514	2540	440	org/apache/http/conn/ConnectTimeoutException
    //   2540	2566	440	org/apache/http/conn/ConnectTimeoutException
    //   204	245	642	java/lang/UnsupportedOperationException
    //   248	271	642	java/lang/UnsupportedOperationException
    //   271	360	642	java/lang/UnsupportedOperationException
    //   82	200	652	java/net/SocketTimeoutException
    //   204	245	652	java/net/SocketTimeoutException
    //   248	271	652	java/net/SocketTimeoutException
    //   271	360	652	java/net/SocketTimeoutException
    //   360	402	652	java/net/SocketTimeoutException
    //   407	440	652	java/net/SocketTimeoutException
    //   644	649	652	java/net/SocketTimeoutException
    //   846	940	652	java/net/SocketTimeoutException
    //   1039	1103	652	java/net/SocketTimeoutException
    //   1188	1214	652	java/net/SocketTimeoutException
    //   1310	1322	652	java/net/SocketTimeoutException
    //   1327	1370	652	java/net/SocketTimeoutException
    //   1370	1378	652	java/net/SocketTimeoutException
    //   1378	1387	652	java/net/SocketTimeoutException
    //   1536	1599	652	java/net/SocketTimeoutException
    //   1695	1701	652	java/net/SocketTimeoutException
    //   1800	1837	652	java/net/SocketTimeoutException
    //   1837	1845	652	java/net/SocketTimeoutException
    //   2095	2101	652	java/net/SocketTimeoutException
    //   2200	2225	652	java/net/SocketTimeoutException
    //   2354	2366	652	java/net/SocketTimeoutException
    //   2371	2418	652	java/net/SocketTimeoutException
    //   2421	2460	652	java/net/SocketTimeoutException
    //   2460	2488	652	java/net/SocketTimeoutException
    //   2488	2514	652	java/net/SocketTimeoutException
    //   2514	2540	652	java/net/SocketTimeoutException
    //   2540	2566	652	java/net/SocketTimeoutException
    //   82	200	943	java/net/UnknownHostException
    //   204	245	943	java/net/UnknownHostException
    //   248	271	943	java/net/UnknownHostException
    //   271	360	943	java/net/UnknownHostException
    //   360	402	943	java/net/UnknownHostException
    //   407	440	943	java/net/UnknownHostException
    //   644	649	943	java/net/UnknownHostException
    //   846	940	943	java/net/UnknownHostException
    //   1039	1103	943	java/net/UnknownHostException
    //   1188	1214	943	java/net/UnknownHostException
    //   1310	1322	943	java/net/UnknownHostException
    //   1327	1370	943	java/net/UnknownHostException
    //   1370	1378	943	java/net/UnknownHostException
    //   1378	1387	943	java/net/UnknownHostException
    //   1536	1599	943	java/net/UnknownHostException
    //   1695	1701	943	java/net/UnknownHostException
    //   1800	1837	943	java/net/UnknownHostException
    //   1837	1845	943	java/net/UnknownHostException
    //   2095	2101	943	java/net/UnknownHostException
    //   2200	2225	943	java/net/UnknownHostException
    //   2354	2366	943	java/net/UnknownHostException
    //   2371	2418	943	java/net/UnknownHostException
    //   2421	2460	943	java/net/UnknownHostException
    //   2460	2488	943	java/net/UnknownHostException
    //   2488	2514	943	java/net/UnknownHostException
    //   2514	2540	943	java/net/UnknownHostException
    //   2540	2566	943	java/net/UnknownHostException
    //   82	200	1214	java/lang/InterruptedException
    //   204	245	1214	java/lang/InterruptedException
    //   248	271	1214	java/lang/InterruptedException
    //   271	360	1214	java/lang/InterruptedException
    //   360	402	1214	java/lang/InterruptedException
    //   407	440	1214	java/lang/InterruptedException
    //   644	649	1214	java/lang/InterruptedException
    //   846	940	1214	java/lang/InterruptedException
    //   1039	1103	1214	java/lang/InterruptedException
    //   1188	1214	1214	java/lang/InterruptedException
    //   1310	1322	1214	java/lang/InterruptedException
    //   1327	1370	1214	java/lang/InterruptedException
    //   1370	1378	1214	java/lang/InterruptedException
    //   1378	1387	1214	java/lang/InterruptedException
    //   1536	1599	1214	java/lang/InterruptedException
    //   1695	1701	1214	java/lang/InterruptedException
    //   1800	1837	1214	java/lang/InterruptedException
    //   1837	1845	1214	java/lang/InterruptedException
    //   2095	2101	1214	java/lang/InterruptedException
    //   2200	2225	1214	java/lang/InterruptedException
    //   2354	2366	1214	java/lang/InterruptedException
    //   2371	2418	1214	java/lang/InterruptedException
    //   2421	2460	1214	java/lang/InterruptedException
    //   2460	2488	1214	java/lang/InterruptedException
    //   2488	2514	1214	java/lang/InterruptedException
    //   2514	2540	1214	java/lang/InterruptedException
    //   2540	2566	1214	java/lang/InterruptedException
    //   82	200	1599	javax/net/ssl/SSLException
    //   204	245	1599	javax/net/ssl/SSLException
    //   248	271	1599	javax/net/ssl/SSLException
    //   271	360	1599	javax/net/ssl/SSLException
    //   360	402	1599	javax/net/ssl/SSLException
    //   407	440	1599	javax/net/ssl/SSLException
    //   644	649	1599	javax/net/ssl/SSLException
    //   846	940	1599	javax/net/ssl/SSLException
    //   1039	1103	1599	javax/net/ssl/SSLException
    //   1188	1214	1599	javax/net/ssl/SSLException
    //   1310	1322	1599	javax/net/ssl/SSLException
    //   1327	1370	1599	javax/net/ssl/SSLException
    //   1370	1378	1599	javax/net/ssl/SSLException
    //   1378	1387	1599	javax/net/ssl/SSLException
    //   1536	1599	1599	javax/net/ssl/SSLException
    //   1695	1701	1599	javax/net/ssl/SSLException
    //   1800	1837	1599	javax/net/ssl/SSLException
    //   1837	1845	1599	javax/net/ssl/SSLException
    //   2095	2101	1599	javax/net/ssl/SSLException
    //   2200	2225	1599	javax/net/ssl/SSLException
    //   2354	2366	1599	javax/net/ssl/SSLException
    //   2371	2418	1599	javax/net/ssl/SSLException
    //   2421	2460	1599	javax/net/ssl/SSLException
    //   2460	2488	1599	javax/net/ssl/SSLException
    //   2488	2514	1599	javax/net/ssl/SSLException
    //   2514	2540	1599	javax/net/ssl/SSLException
    //   2540	2566	1599	javax/net/ssl/SSLException
    //   82	200	1704	java/io/IOException
    //   204	245	1704	java/io/IOException
    //   248	271	1704	java/io/IOException
    //   271	360	1704	java/io/IOException
    //   360	402	1704	java/io/IOException
    //   407	440	1704	java/io/IOException
    //   644	649	1704	java/io/IOException
    //   846	940	1704	java/io/IOException
    //   1039	1103	1704	java/io/IOException
    //   1188	1214	1704	java/io/IOException
    //   1310	1322	1704	java/io/IOException
    //   1327	1370	1704	java/io/IOException
    //   1370	1378	1704	java/io/IOException
    //   1378	1387	1704	java/io/IOException
    //   1536	1599	1704	java/io/IOException
    //   1695	1701	1704	java/io/IOException
    //   1800	1837	1704	java/io/IOException
    //   1837	1845	1704	java/io/IOException
    //   2095	2101	1704	java/io/IOException
    //   2200	2225	1704	java/io/IOException
    //   2354	2366	1704	java/io/IOException
    //   2371	2418	1704	java/io/IOException
    //   2421	2460	1704	java/io/IOException
    //   2460	2488	1704	java/io/IOException
    //   2488	2514	1704	java/io/IOException
    //   2514	2540	1704	java/io/IOException
    //   2540	2566	1704	java/io/IOException
    //   82	200	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   204	245	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   248	271	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   271	360	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   360	402	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   407	440	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   644	649	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   846	940	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1039	1103	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1188	1214	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1310	1322	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1327	1370	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1370	1378	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1378	1387	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1536	1599	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1695	1701	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1800	1837	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   1837	1845	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2095	2101	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2200	2225	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2354	2366	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2371	2418	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2421	2460	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2460	2488	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2488	2514	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2514	2540	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   2540	2566	1848	com/tencent/tmassistantsdk/downloadservice/n
    //   82	200	2104	java/lang/Throwable
    //   204	245	2104	java/lang/Throwable
    //   248	271	2104	java/lang/Throwable
    //   271	360	2104	java/lang/Throwable
    //   360	402	2104	java/lang/Throwable
    //   407	440	2104	java/lang/Throwable
    //   644	649	2104	java/lang/Throwable
    //   846	940	2104	java/lang/Throwable
    //   1039	1103	2104	java/lang/Throwable
    //   1188	1214	2104	java/lang/Throwable
    //   1310	1322	2104	java/lang/Throwable
    //   1327	1370	2104	java/lang/Throwable
    //   1370	1378	2104	java/lang/Throwable
    //   1378	1387	2104	java/lang/Throwable
    //   1536	1599	2104	java/lang/Throwable
    //   1695	1701	2104	java/lang/Throwable
    //   1800	1837	2104	java/lang/Throwable
    //   1837	1845	2104	java/lang/Throwable
    //   2095	2101	2104	java/lang/Throwable
    //   2200	2225	2104	java/lang/Throwable
    //   2354	2366	2104	java/lang/Throwable
    //   2371	2418	2104	java/lang/Throwable
    //   2421	2460	2104	java/lang/Throwable
    //   2460	2488	2104	java/lang/Throwable
    //   2488	2514	2104	java/lang/Throwable
    //   2514	2540	2104	java/lang/Throwable
    //   2540	2566	2104	java/lang/Throwable
    //   82	200	2225	finally
    //   204	245	2225	finally
    //   248	271	2225	finally
    //   271	360	2225	finally
    //   360	402	2225	finally
    //   407	440	2225	finally
    //   442	455	2225	finally
    //   644	649	2225	finally
    //   654	667	2225	finally
    //   846	940	2225	finally
    //   945	960	2225	finally
    //   1039	1103	2225	finally
    //   1188	1214	2225	finally
    //   1216	1231	2225	finally
    //   1310	1322	2225	finally
    //   1327	1370	2225	finally
    //   1370	1378	2225	finally
    //   1378	1387	2225	finally
    //   1536	1599	2225	finally
    //   1601	1616	2225	finally
    //   1695	1701	2225	finally
    //   1706	1721	2225	finally
    //   1800	1837	2225	finally
    //   1837	1845	2225	finally
    //   1850	1918	2225	finally
    //   2095	2101	2225	finally
    //   2106	2121	2225	finally
    //   2200	2225	2225	finally
    //   2354	2366	2225	finally
    //   2371	2418	2225	finally
    //   2421	2460	2225	finally
    //   2460	2488	2225	finally
    //   2488	2514	2225	finally
    //   2514	2540	2225	finally
    //   2540	2566	2225	finally
    //   2593	2603	2225	finally
    //   2638	2648	2225	finally
    //   484	490	2576	java/lang/InterruptedException
    //   696	702	2617	java/lang/InterruptedException
    //   466	484	2816	finally
    //   484	490	2816	finally
    //   678	696	2816	finally
    //   696	702	2816	finally
    //   1929	1947	2816	finally
    //   2578	2588	2816	finally
    //   2619	2629	2816	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\assets\exlibs.2.jar\classes.jar
 * Qualified Name:     com.tencent.tmassistantsdk.downloadservice.g
 * JD-Core Version:    0.7.0.1
 */