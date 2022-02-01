package com.tencent.TMG.ptt;

class FileTransfer$1
  implements Runnable
{
  FileTransfer$1(FileTransfer paramFileTransfer, String paramString1, int paramInt, String paramString2, String paramString3, PttListener.UploadFileListener paramUploadFileListener) {}
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_1
    //   2: sipush 8195
    //   5: istore_2
    //   6: aconst_null
    //   7: astore 9
    //   9: aconst_null
    //   10: astore 6
    //   12: aconst_null
    //   13: astore 11
    //   15: ldc 43
    //   17: astore 8
    //   19: aload_0
    //   20: getfield 20	com/tencent/TMG/ptt/FileTransfer$1:this$0	Lcom/tencent/TMG/ptt/FileTransfer;
    //   23: aload_0
    //   24: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   27: invokestatic 49	com/tencent/TMG/ptt/FileTransfer:access$000	(Lcom/tencent/TMG/ptt/FileTransfer;Ljava/lang/String;)Ljava/io/File;
    //   30: astore 4
    //   32: aload 4
    //   34: ifnonnull +87 -> 121
    //   37: sipush 8193
    //   40: istore_1
    //   41: aconst_null
    //   42: astore 6
    //   44: aconst_null
    //   45: astore 7
    //   47: aconst_null
    //   48: astore 4
    //   50: aconst_null
    //   51: astore 5
    //   53: aload 11
    //   55: astore 8
    //   57: aload 5
    //   59: ifnull +8 -> 67
    //   62: aload 5
    //   64: invokevirtual 54	java/io/FileInputStream:close	()V
    //   67: aload 7
    //   69: ifnull +8 -> 77
    //   72: aload 7
    //   74: invokevirtual 57	java/io/OutputStream:close	()V
    //   77: aload 6
    //   79: ifnull +8 -> 87
    //   82: aload 6
    //   84: invokevirtual 60	java/io/BufferedReader:close	()V
    //   87: aload 4
    //   89: ifnull +8 -> 97
    //   92: aload 4
    //   94: invokevirtual 65	java/net/HttpURLConnection:disconnect	()V
    //   97: aload_0
    //   98: getfield 30	com/tencent/TMG/ptt/FileTransfer$1:val$monitor	Lcom/tencent/TMG/ptt/PttListener$UploadFileListener;
    //   101: ifnull +19 -> 120
    //   104: aload_0
    //   105: getfield 30	com/tencent/TMG/ptt/FileTransfer$1:val$monitor	Lcom/tencent/TMG/ptt/PttListener$UploadFileListener;
    //   108: iload_1
    //   109: aload_0
    //   110: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   113: aload 8
    //   115: invokeinterface 71 4 0
    //   120: return
    //   121: aload_0
    //   122: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   125: invokestatic 77	com/tencent/TMG/ptt/SHA1Utils:getFileSHA1	(Ljava/lang/String;)Ljava/lang/String;
    //   128: astore 10
    //   130: new 51	java/io/FileInputStream
    //   133: dup
    //   134: aload 4
    //   136: invokespecial 80	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   139: astore 5
    //   141: aload 5
    //   143: invokevirtual 84	java/io/FileInputStream:available	()I
    //   146: istore_3
    //   147: iload_3
    //   148: ifle +11 -> 159
    //   151: iload_3
    //   152: aload_0
    //   153: getfield 24	com/tencent/TMG/ptt/FileTransfer$1:val$maxSize	I
    //   156: if_icmple +60 -> 216
    //   159: ldc 86
    //   161: new 88	java/lang/StringBuilder
    //   164: dup
    //   165: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   168: ldc 91
    //   170: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   173: aload_0
    //   174: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   177: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   180: ldc 97
    //   182: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   185: iload_3
    //   186: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   189: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   192: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   195: pop
    //   196: sipush 8193
    //   199: istore_1
    //   200: aconst_null
    //   201: astore 6
    //   203: aconst_null
    //   204: astore 7
    //   206: aconst_null
    //   207: astore 4
    //   209: aload 11
    //   211: astore 8
    //   213: goto -156 -> 57
    //   216: new 112	java/net/URL
    //   219: dup
    //   220: aload_0
    //   221: getfield 26	com/tencent/TMG/ptt/FileTransfer$1:val$strUrl	Ljava/lang/String;
    //   224: invokespecial 115	java/net/URL:<init>	(Ljava/lang/String;)V
    //   227: invokevirtual 119	java/net/URL:openConnection	()Ljava/net/URLConnection;
    //   230: checkcast 62	java/net/HttpURLConnection
    //   233: astore 4
    //   235: aload 4
    //   237: sipush 5000
    //   240: invokevirtual 123	java/net/HttpURLConnection:setConnectTimeout	(I)V
    //   243: aload 4
    //   245: sipush 30000
    //   248: invokevirtual 126	java/net/HttpURLConnection:setReadTimeout	(I)V
    //   251: aload 4
    //   253: iconst_1
    //   254: invokevirtual 130	java/net/HttpURLConnection:setDoOutput	(Z)V
    //   257: aload 4
    //   259: iconst_1
    //   260: invokevirtual 133	java/net/HttpURLConnection:setDoInput	(Z)V
    //   263: aload 4
    //   265: iconst_0
    //   266: invokevirtual 136	java/net/HttpURLConnection:setUseCaches	(Z)V
    //   269: aload 4
    //   271: ldc 138
    //   273: invokevirtual 141	java/net/HttpURLConnection:setRequestMethod	(Ljava/lang/String;)V
    //   276: aload 4
    //   278: ldc 143
    //   280: ldc 145
    //   282: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   285: aload 4
    //   287: ldc 151
    //   289: aload_0
    //   290: getfield 28	com/tencent/TMG/ptt/FileTransfer$1:val$sign	Ljava/lang/String;
    //   293: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   296: aload 4
    //   298: ldc 153
    //   300: new 88	java/lang/StringBuilder
    //   303: dup
    //   304: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   307: ldc 155
    //   309: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   312: ldc 157
    //   314: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   317: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   320: invokevirtual 149	java/net/HttpURLConnection:setRequestProperty	(Ljava/lang/String;Ljava/lang/String;)V
    //   323: new 159	java/io/DataOutputStream
    //   326: dup
    //   327: aload 4
    //   329: invokevirtual 163	java/net/HttpURLConnection:getOutputStream	()Ljava/io/OutputStream;
    //   332: invokespecial 166	java/io/DataOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   335: astore 7
    //   337: new 168	java/util/HashMap
    //   340: dup
    //   341: iconst_3
    //   342: invokespecial 170	java/util/HashMap:<init>	(I)V
    //   345: astore 12
    //   347: aload 12
    //   349: ldc 172
    //   351: ldc 174
    //   353: invokeinterface 180 3 0
    //   358: pop
    //   359: aload 12
    //   361: ldc 182
    //   363: aload 10
    //   365: invokeinterface 180 3 0
    //   370: pop
    //   371: aload 12
    //   373: ldc 184
    //   375: ldc 43
    //   377: invokeinterface 180 3 0
    //   382: pop
    //   383: aload_0
    //   384: getfield 20	com/tencent/TMG/ptt/FileTransfer$1:this$0	Lcom/tencent/TMG/ptt/FileTransfer;
    //   387: aload 12
    //   389: ldc 157
    //   391: invokestatic 188	com/tencent/TMG/ptt/FileTransfer:access$100	(Lcom/tencent/TMG/ptt/FileTransfer;Ljava/util/Map;Ljava/lang/String;)Ljava/lang/String;
    //   394: astore 10
    //   396: new 88	java/lang/StringBuilder
    //   399: dup
    //   400: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   403: aload 10
    //   405: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   408: ldc 190
    //   410: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   413: ldc 157
    //   415: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   418: ldc 192
    //   420: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   423: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   426: astore 10
    //   428: new 88	java/lang/StringBuilder
    //   431: dup
    //   432: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   435: aload 10
    //   437: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   440: ldc 194
    //   442: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   445: aload_0
    //   446: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   449: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   452: ldc 196
    //   454: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   457: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   460: astore 10
    //   462: aload 7
    //   464: new 88	java/lang/StringBuilder
    //   467: dup
    //   468: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   471: aload 10
    //   473: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   476: ldc 198
    //   478: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   481: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   484: invokevirtual 204	java/lang/String:getBytes	()[B
    //   487: invokevirtual 208	java/io/OutputStream:write	([B)V
    //   490: sipush 1024
    //   493: newarray byte
    //   495: astore 10
    //   497: aload 5
    //   499: aload 10
    //   501: invokevirtual 212	java/io/FileInputStream:read	([B)I
    //   504: istore_3
    //   505: iload_3
    //   506: iconst_m1
    //   507: if_icmpeq +70 -> 577
    //   510: aload 7
    //   512: aload 10
    //   514: iconst_0
    //   515: iload_3
    //   516: invokevirtual 215	java/io/OutputStream:write	([BII)V
    //   519: goto -22 -> 497
    //   522: astore 9
    //   524: aconst_null
    //   525: astore 6
    //   527: aload 7
    //   529: astore 8
    //   531: aload 4
    //   533: astore 7
    //   535: aload 8
    //   537: astore 4
    //   539: aload 9
    //   541: astore 8
    //   543: ldc 86
    //   545: ldc 217
    //   547: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   550: pop
    //   551: aload 8
    //   553: invokevirtual 220	java/net/UnknownHostException:printStackTrace	()V
    //   556: aload 7
    //   558: astore 8
    //   560: aload 4
    //   562: astore 7
    //   564: aload 8
    //   566: astore 4
    //   568: aload 11
    //   570: astore 8
    //   572: iload_2
    //   573: istore_1
    //   574: goto -517 -> 57
    //   577: aload 7
    //   579: new 88	java/lang/StringBuilder
    //   582: dup
    //   583: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   586: ldc 222
    //   588: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   591: ldc 157
    //   593: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   596: ldc 224
    //   598: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   601: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   604: invokevirtual 204	java/lang/String:getBytes	()[B
    //   607: invokevirtual 208	java/io/OutputStream:write	([B)V
    //   610: aload 7
    //   612: invokevirtual 227	java/io/OutputStream:flush	()V
    //   615: aload 4
    //   617: invokevirtual 230	java/net/HttpURLConnection:getResponseCode	()I
    //   620: istore_3
    //   621: ldc 86
    //   623: new 88	java/lang/StringBuilder
    //   626: dup
    //   627: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   630: ldc 232
    //   632: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   635: iload_3
    //   636: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   639: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   642: invokestatic 235	android/util/Log:i	(Ljava/lang/String;Ljava/lang/String;)I
    //   645: pop
    //   646: iload_3
    //   647: sipush 200
    //   650: if_icmpne +196 -> 846
    //   653: new 59	java/io/BufferedReader
    //   656: dup
    //   657: new 237	java/io/InputStreamReader
    //   660: dup
    //   661: aload 4
    //   663: invokevirtual 241	java/net/HttpURLConnection:getInputStream	()Ljava/io/InputStream;
    //   666: invokespecial 244	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;)V
    //   669: invokespecial 247	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   672: astore 6
    //   674: aload 6
    //   676: invokevirtual 250	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   679: astore 10
    //   681: aload 10
    //   683: ifnull +32 -> 715
    //   686: new 88	java/lang/StringBuilder
    //   689: dup
    //   690: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   693: aload 8
    //   695: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   698: aload 10
    //   700: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   703: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   706: astore 10
    //   708: aload 10
    //   710: astore 8
    //   712: goto -38 -> 674
    //   715: ldc 86
    //   717: new 88	java/lang/StringBuilder
    //   720: dup
    //   721: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   724: ldc 252
    //   726: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   729: aload 8
    //   731: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   734: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   737: invokestatic 255	android/util/Log:d	(Ljava/lang/String;Ljava/lang/String;)I
    //   740: pop
    //   741: new 257	org/json/JSONObject
    //   744: dup
    //   745: aload 8
    //   747: invokespecial 258	org/json/JSONObject:<init>	(Ljava/lang/String;)V
    //   750: astore 10
    //   752: aload 10
    //   754: ldc_w 260
    //   757: invokevirtual 264	org/json/JSONObject:getInt	(Ljava/lang/String;)I
    //   760: istore_3
    //   761: iload_3
    //   762: ifne +26 -> 788
    //   765: aload 10
    //   767: ldc_w 266
    //   770: invokevirtual 270	org/json/JSONObject:getJSONObject	(Ljava/lang/String;)Lorg/json/JSONObject;
    //   773: ldc_w 272
    //   776: invokevirtual 275	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   779: astore 9
    //   781: aload 9
    //   783: astore 8
    //   785: goto +452 -> 1237
    //   788: aload 10
    //   790: ldc_w 277
    //   793: invokevirtual 275	org/json/JSONObject:getString	(Ljava/lang/String;)Ljava/lang/String;
    //   796: astore 10
    //   798: ldc 86
    //   800: new 88	java/lang/StringBuilder
    //   803: dup
    //   804: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   807: ldc_w 279
    //   810: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   813: iload_3
    //   814: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   817: ldc_w 281
    //   820: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   823: aload 10
    //   825: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   828: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   831: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   834: pop
    //   835: sipush 8195
    //   838: istore_1
    //   839: aload 9
    //   841: astore 8
    //   843: goto +394 -> 1237
    //   846: ldc 86
    //   848: new 88	java/lang/StringBuilder
    //   851: dup
    //   852: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   855: ldc_w 283
    //   858: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   861: iload_3
    //   862: invokevirtual 100	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   865: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   868: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   871: pop
    //   872: sipush 8195
    //   875: istore_1
    //   876: aconst_null
    //   877: astore 9
    //   879: goto +366 -> 1245
    //   882: astore 8
    //   884: aconst_null
    //   885: astore 6
    //   887: aconst_null
    //   888: astore 7
    //   890: aconst_null
    //   891: astore 4
    //   893: aconst_null
    //   894: astore 5
    //   896: ldc 86
    //   898: new 88	java/lang/StringBuilder
    //   901: dup
    //   902: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   905: ldc_w 285
    //   908: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   911: aload_0
    //   912: getfield 22	com/tencent/TMG/ptt/FileTransfer$1:val$srcPath	Ljava/lang/String;
    //   915: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   918: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   921: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   924: pop
    //   925: aload 8
    //   927: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   930: sipush 8193
    //   933: istore_1
    //   934: aload 11
    //   936: astore 8
    //   938: goto -881 -> 57
    //   941: astore 8
    //   943: ldc 43
    //   945: astore 9
    //   947: aconst_null
    //   948: astore 5
    //   950: aconst_null
    //   951: astore 7
    //   953: aconst_null
    //   954: astore 4
    //   956: aconst_null
    //   957: astore 6
    //   959: ldc 86
    //   961: new 88	java/lang/StringBuilder
    //   964: dup
    //   965: invokespecial 89	java/lang/StringBuilder:<init>	()V
    //   968: ldc_w 288
    //   971: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   974: aload 9
    //   976: invokevirtual 95	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   979: invokevirtual 104	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   982: invokestatic 110	android/util/Log:e	(Ljava/lang/String;Ljava/lang/String;)I
    //   985: pop
    //   986: aload 8
    //   988: invokevirtual 289	org/json/JSONException:printStackTrace	()V
    //   991: aload 6
    //   993: astore 9
    //   995: aload 11
    //   997: astore 8
    //   999: iload_2
    //   1000: istore_1
    //   1001: aload 5
    //   1003: astore 6
    //   1005: aload 9
    //   1007: astore 5
    //   1009: goto -952 -> 57
    //   1012: astore 5
    //   1014: aload 5
    //   1016: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1019: goto -952 -> 67
    //   1022: astore 5
    //   1024: aload 5
    //   1026: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1029: goto -952 -> 77
    //   1032: astore 5
    //   1034: aload 5
    //   1036: invokevirtual 286	java/io/IOException:printStackTrace	()V
    //   1039: goto -952 -> 87
    //   1042: astore 8
    //   1044: ldc 43
    //   1046: astore 9
    //   1048: aconst_null
    //   1049: astore 10
    //   1051: aconst_null
    //   1052: astore 7
    //   1054: aload 5
    //   1056: astore 6
    //   1058: aconst_null
    //   1059: astore 4
    //   1061: aload 10
    //   1063: astore 5
    //   1065: goto -106 -> 959
    //   1068: astore 8
    //   1070: aconst_null
    //   1071: astore 10
    //   1073: aconst_null
    //   1074: astore 7
    //   1076: ldc 43
    //   1078: astore 9
    //   1080: aload 5
    //   1082: astore 6
    //   1084: aload 10
    //   1086: astore 5
    //   1088: goto -129 -> 959
    //   1091: astore 8
    //   1093: aconst_null
    //   1094: astore 10
    //   1096: aload 5
    //   1098: astore 6
    //   1100: ldc 43
    //   1102: astore 9
    //   1104: aload 10
    //   1106: astore 5
    //   1108: goto -149 -> 959
    //   1111: astore 12
    //   1113: aload 8
    //   1115: astore 9
    //   1117: aload 5
    //   1119: astore 10
    //   1121: aload 12
    //   1123: astore 8
    //   1125: aload 6
    //   1127: astore 5
    //   1129: aload 10
    //   1131: astore 6
    //   1133: goto -174 -> 959
    //   1136: astore 8
    //   1138: aconst_null
    //   1139: astore 6
    //   1141: aconst_null
    //   1142: astore 7
    //   1144: aconst_null
    //   1145: astore 4
    //   1147: goto -251 -> 896
    //   1150: astore 8
    //   1152: aconst_null
    //   1153: astore 6
    //   1155: aconst_null
    //   1156: astore 7
    //   1158: goto -262 -> 896
    //   1161: astore 8
    //   1163: aconst_null
    //   1164: astore 6
    //   1166: goto -270 -> 896
    //   1169: astore 8
    //   1171: goto -275 -> 896
    //   1174: astore 8
    //   1176: aconst_null
    //   1177: astore 6
    //   1179: aconst_null
    //   1180: astore 4
    //   1182: aconst_null
    //   1183: astore 7
    //   1185: aconst_null
    //   1186: astore 5
    //   1188: goto -645 -> 543
    //   1191: astore 8
    //   1193: aconst_null
    //   1194: astore 6
    //   1196: aconst_null
    //   1197: astore 4
    //   1199: aconst_null
    //   1200: astore 7
    //   1202: goto -659 -> 543
    //   1205: astore 8
    //   1207: aconst_null
    //   1208: astore 6
    //   1210: aload 4
    //   1212: astore 7
    //   1214: aconst_null
    //   1215: astore 4
    //   1217: goto -674 -> 543
    //   1220: astore 8
    //   1222: aload 7
    //   1224: astore 9
    //   1226: aload 4
    //   1228: astore 7
    //   1230: aload 9
    //   1232: astore 4
    //   1234: goto -691 -> 543
    //   1237: aload 6
    //   1239: astore 9
    //   1241: aload 8
    //   1243: astore 6
    //   1245: aload 6
    //   1247: astore 8
    //   1249: aload 9
    //   1251: astore 6
    //   1253: goto -1196 -> 57
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1256	0	this	1
    //   1	1000	1	i	int
    //   5	995	2	j	int
    //   146	716	3	k	int
    //   30	1203	4	localObject1	Object
    //   51	957	5	localObject2	Object
    //   1012	3	5	localIOException1	java.io.IOException
    //   1022	3	5	localIOException2	java.io.IOException
    //   1032	23	5	localIOException3	java.io.IOException
    //   1063	124	5	localObject3	Object
    //   10	1242	6	localObject4	Object
    //   45	1184	7	localObject5	Object
    //   17	825	8	localObject6	Object
    //   882	44	8	localIOException4	java.io.IOException
    //   936	1	8	localObject7	Object
    //   941	46	8	localJSONException1	org.json.JSONException
    //   997	1	8	localObject8	Object
    //   1042	1	8	localJSONException2	org.json.JSONException
    //   1068	1	8	localJSONException3	org.json.JSONException
    //   1091	23	8	localJSONException4	org.json.JSONException
    //   1123	1	8	localObject9	Object
    //   1136	1	8	localIOException5	java.io.IOException
    //   1150	1	8	localIOException6	java.io.IOException
    //   1161	1	8	localIOException7	java.io.IOException
    //   1169	1	8	localIOException8	java.io.IOException
    //   1174	1	8	localUnknownHostException1	java.net.UnknownHostException
    //   1191	1	8	localUnknownHostException2	java.net.UnknownHostException
    //   1205	1	8	localUnknownHostException3	java.net.UnknownHostException
    //   1220	22	8	localUnknownHostException4	java.net.UnknownHostException
    //   1247	1	8	localObject10	Object
    //   7	1	9	localObject11	Object
    //   522	18	9	localUnknownHostException5	java.net.UnknownHostException
    //   779	471	9	localObject12	Object
    //   128	1002	10	localObject13	Object
    //   13	983	11	localObject14	Object
    //   345	43	12	localHashMap	java.util.HashMap
    //   1111	11	12	localJSONException5	org.json.JSONException
    // Exception table:
    //   from	to	target	type
    //   337	497	522	java/net/UnknownHostException
    //   497	505	522	java/net/UnknownHostException
    //   510	519	522	java/net/UnknownHostException
    //   577	646	522	java/net/UnknownHostException
    //   653	674	522	java/net/UnknownHostException
    //   846	872	522	java/net/UnknownHostException
    //   130	141	882	java/io/IOException
    //   130	141	941	org/json/JSONException
    //   62	67	1012	java/io/IOException
    //   72	77	1022	java/io/IOException
    //   82	87	1032	java/io/IOException
    //   141	147	1042	org/json/JSONException
    //   151	159	1042	org/json/JSONException
    //   159	196	1042	org/json/JSONException
    //   216	235	1042	org/json/JSONException
    //   235	337	1068	org/json/JSONException
    //   337	497	1091	org/json/JSONException
    //   497	505	1091	org/json/JSONException
    //   510	519	1091	org/json/JSONException
    //   577	646	1091	org/json/JSONException
    //   653	674	1091	org/json/JSONException
    //   846	872	1091	org/json/JSONException
    //   674	681	1111	org/json/JSONException
    //   686	708	1111	org/json/JSONException
    //   715	761	1111	org/json/JSONException
    //   765	781	1111	org/json/JSONException
    //   788	835	1111	org/json/JSONException
    //   141	147	1136	java/io/IOException
    //   151	159	1136	java/io/IOException
    //   159	196	1136	java/io/IOException
    //   216	235	1136	java/io/IOException
    //   235	337	1150	java/io/IOException
    //   337	497	1161	java/io/IOException
    //   497	505	1161	java/io/IOException
    //   510	519	1161	java/io/IOException
    //   577	646	1161	java/io/IOException
    //   653	674	1161	java/io/IOException
    //   846	872	1161	java/io/IOException
    //   674	681	1169	java/io/IOException
    //   686	708	1169	java/io/IOException
    //   715	761	1169	java/io/IOException
    //   765	781	1169	java/io/IOException
    //   788	835	1169	java/io/IOException
    //   130	141	1174	java/net/UnknownHostException
    //   141	147	1191	java/net/UnknownHostException
    //   151	159	1191	java/net/UnknownHostException
    //   159	196	1191	java/net/UnknownHostException
    //   216	235	1191	java/net/UnknownHostException
    //   235	337	1205	java/net/UnknownHostException
    //   674	681	1220	java/net/UnknownHostException
    //   686	708	1220	java/net/UnknownHostException
    //   715	761	1220	java/net/UnknownHostException
    //   765	781	1220	java/net/UnknownHostException
    //   788	835	1220	java/net/UnknownHostException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.tencent.TMG.ptt.FileTransfer.1
 * JD-Core Version:    0.7.0.1
 */