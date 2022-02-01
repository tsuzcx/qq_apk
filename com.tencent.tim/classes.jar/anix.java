import java.io.File;
import java.util.HashMap;

public class anix
{
  private static final String cel = "shortvideo" + File.separator + "predic";
  
  public static String a(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    int j = 1;
    int[] arrayOfInt = new int[5];
    String str = (String)paramHashMap.get("cameraType");
    if (str != null)
    {
      if (str.equals("1"))
      {
        i = 0;
        arrayOfInt[0] = i;
      }
    }
    else
    {
      str = (String)paramHashMap.get("cameraOrientation");
      if (str != null)
      {
        if (!str.equals("0")) {
          break label209;
        }
        i = 0;
        label68:
        arrayOfInt[1] = i;
      }
      str = (String)paramHashMap.get("isFaceDectected");
      if (str != null)
      {
        if (!str.equals("true")) {
          break label214;
        }
        i = 1;
        label101:
        arrayOfInt[2] = i;
      }
      str = (String)paramHashMap.get("isTemplateMode");
      if (str != null)
      {
        if (!str.equals("true")) {
          break label219;
        }
        i = 1;
        label134:
        arrayOfInt[3] = i;
      }
      paramHashMap = (String)paramHashMap.get("sessionType");
      if (paramHashMap != null)
      {
        if (!paramHashMap.equals("1")) {
          break label224;
        }
        arrayOfInt[4] = 1;
      }
    }
    for (;;)
    {
      paramHashMap = new StringBuilder();
      int k = arrayOfInt.length;
      i = 0;
      while (i < k)
      {
        paramHashMap.append(arrayOfInt[i]);
        i += 1;
      }
      i = 1;
      break;
      label209:
      i = 1;
      break label68;
      label214:
      i = 0;
      break label101;
      label219:
      i = 0;
      break label134;
      label224:
      if (paramHashMap.equals("3000")) {
        arrayOfInt[4] = 2;
      } else {
        arrayOfInt[4] = 0;
      }
    }
    paramHashMap.append(" ");
    if (paramBoolean) {}
    for (int i = j;; i = 0)
    {
      paramHashMap.append(i);
      return paramHashMap.toString();
    }
  }
  
  /* Error */
  public static String b(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: iconst_0
    //   1: istore_3
    //   2: new 79	anjb
    //   5: dup
    //   6: iload_0
    //   7: aload_1
    //   8: invokestatic 81	anix:a	(ZLjava/util/HashMap;)Ljava/lang/String;
    //   11: iconst_0
    //   12: invokespecial 84	anjb:<init>	(Ljava/lang/String;I)V
    //   15: astore 7
    //   17: new 10	java/lang/StringBuilder
    //   20: dup
    //   21: getstatic 89	acbn:SDCARD_PATH	Ljava/lang/String;
    //   24: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   27: astore 4
    //   29: aload 4
    //   31: getstatic 32	anix:cel	Ljava/lang/String;
    //   34: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   37: pop
    //   38: aload 4
    //   40: getstatic 24	java/io/File:separator	Ljava/lang/String;
    //   43: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   46: pop
    //   47: aload 4
    //   49: ldc 94
    //   51: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   54: pop
    //   55: new 21	java/io/File
    //   58: dup
    //   59: aload 4
    //   61: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: astore 6
    //   69: aload 6
    //   71: invokevirtual 99	java/io/File:exists	()Z
    //   74: ifne +44 -> 118
    //   77: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   80: ifeq +11 -> 91
    //   83: ldc 106
    //   85: iconst_2
    //   86: ldc 108
    //   88: invokestatic 112	com/tencent/qphone/base/util/QLog:d	(Ljava/lang/String;ILjava/lang/String;)V
    //   91: aconst_null
    //   92: areturn
    //   93: astore_1
    //   94: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   97: ifeq -6 -> 91
    //   100: ldc 106
    //   102: iconst_2
    //   103: aload_1
    //   104: iconst_1
    //   105: anewarray 4	java/lang/Object
    //   108: dup
    //   109: iconst_0
    //   110: ldc 114
    //   112: aastore
    //   113: invokestatic 118	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/Throwable;[Ljava/lang/Object;)V
    //   116: aconst_null
    //   117: areturn
    //   118: new 120	java/util/ArrayList
    //   121: dup
    //   122: invokespecial 121	java/util/ArrayList:<init>	()V
    //   125: astore 8
    //   127: new 123	java/io/BufferedReader
    //   130: dup
    //   131: new 125	java/io/FileReader
    //   134: dup
    //   135: aload 6
    //   137: invokespecial 128	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   140: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   143: astore 5
    //   145: iconst_0
    //   146: istore_2
    //   147: aload 5
    //   149: astore 4
    //   151: aload 5
    //   153: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   156: astore 9
    //   158: aload 9
    //   160: ifnull +91 -> 251
    //   163: aload 5
    //   165: astore 4
    //   167: aload 9
    //   169: invokevirtual 138	java/lang/String:length	()I
    //   172: bipush 7
    //   174: if_icmpne +30 -> 204
    //   177: aload 5
    //   179: astore 4
    //   181: aload 8
    //   183: new 79	anjb
    //   186: dup
    //   187: aload 9
    //   189: iload_2
    //   190: invokespecial 84	anjb:<init>	(Ljava/lang/String;I)V
    //   193: invokevirtual 141	java/util/ArrayList:add	(Ljava/lang/Object;)Z
    //   196: pop
    //   197: iload_2
    //   198: iconst_1
    //   199: iadd
    //   200: istore_2
    //   201: goto -54 -> 147
    //   204: aload 5
    //   206: astore 4
    //   208: new 75	java/lang/Exception
    //   211: dup
    //   212: ldc 143
    //   214: invokespecial 144	java/lang/Exception:<init>	(Ljava/lang/String;)V
    //   217: athrow
    //   218: astore 4
    //   220: aload 5
    //   222: astore_1
    //   223: aload 4
    //   225: astore 5
    //   227: aload_1
    //   228: astore 4
    //   230: aload 5
    //   232: invokevirtual 147	java/lang/Exception:printStackTrace	()V
    //   235: aload_1
    //   236: ifnull +7 -> 243
    //   239: aload_1
    //   240: invokevirtual 150	java/io/BufferedReader:close	()V
    //   243: aload 6
    //   245: invokevirtual 153	java/io/File:delete	()Z
    //   248: pop
    //   249: aconst_null
    //   250: areturn
    //   251: aload 5
    //   253: ifnull +8 -> 261
    //   256: aload 5
    //   258: invokevirtual 150	java/io/BufferedReader:close	()V
    //   261: iconst_1
    //   262: istore_2
    //   263: iload_2
    //   264: ifne +73 -> 337
    //   267: aload 6
    //   269: invokevirtual 153	java/io/File:delete	()Z
    //   272: pop
    //   273: aconst_null
    //   274: areturn
    //   275: astore 4
    //   277: aload 4
    //   279: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   282: iload_3
    //   283: istore_2
    //   284: goto -21 -> 263
    //   287: astore_1
    //   288: aload_1
    //   289: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   292: goto -49 -> 243
    //   295: astore_1
    //   296: aconst_null
    //   297: astore 4
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 150	java/io/BufferedReader:close	()V
    //   309: iconst_1
    //   310: istore_2
    //   311: iload_2
    //   312: ifne +23 -> 335
    //   315: aload 6
    //   317: invokevirtual 153	java/io/File:delete	()Z
    //   320: pop
    //   321: aconst_null
    //   322: areturn
    //   323: astore 4
    //   325: aload 4
    //   327: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   330: iconst_0
    //   331: istore_2
    //   332: goto -21 -> 311
    //   335: aload_1
    //   336: athrow
    //   337: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   340: ifeq +32 -> 372
    //   343: ldc 106
    //   345: iconst_2
    //   346: new 10	java/lang/StringBuilder
    //   349: dup
    //   350: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   353: ldc 156
    //   355: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   358: aload 8
    //   360: invokevirtual 159	java/util/ArrayList:size	()I
    //   363: invokevirtual 66	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   366: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   369: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   372: aload_1
    //   373: ldc 163
    //   375: aload 8
    //   377: invokevirtual 159	java/util/ArrayList:size	()I
    //   380: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   383: invokevirtual 171	java/util/HashMap:put	(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
    //   386: pop
    //   387: aload 8
    //   389: invokevirtual 159	java/util/ArrayList:size	()I
    //   392: bipush 10
    //   394: if_icmple -303 -> 91
    //   397: new 173	aniy
    //   400: dup
    //   401: invokespecial 174	aniy:<init>	()V
    //   404: astore_1
    //   405: aload_1
    //   406: aload 8
    //   408: invokevirtual 178	aniy:mu	(Ljava/util/List;)V
    //   411: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   414: ifeq +47 -> 461
    //   417: new 10	java/lang/StringBuilder
    //   420: dup
    //   421: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   424: getstatic 89	acbn:SDCARD_PATH	Ljava/lang/String;
    //   427: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   430: getstatic 32	anix:cel	Ljava/lang/String;
    //   433: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   436: getstatic 24	java/io/File:separator	Ljava/lang/String;
    //   439: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   442: ldc 180
    //   444: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   450: astore 4
    //   452: aload_1
    //   453: getfield 183	aniy:a	Lanjc;
    //   456: aload 4
    //   458: invokevirtual 188	anjc:Qz	(Ljava/lang/String;)V
    //   461: aload_1
    //   462: getfield 183	aniy:a	Lanjc;
    //   465: aload 7
    //   467: invokevirtual 191	anjc:a	(Lanjb;)I
    //   470: invokestatic 167	java/lang/String:valueOf	(I)Ljava/lang/String;
    //   473: areturn
    //   474: astore_1
    //   475: goto -176 -> 299
    //   478: astore 5
    //   480: aconst_null
    //   481: astore_1
    //   482: goto -255 -> 227
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	485	0	paramBoolean	boolean
    //   0	485	1	paramHashMap	HashMap<String, String>
    //   146	186	2	i	int
    //   1	282	3	j	int
    //   27	180	4	localObject1	Object
    //   218	6	4	localException1	java.lang.Exception
    //   228	1	4	localHashMap	HashMap<String, String>
    //   275	3	4	localIOException1	java.io.IOException
    //   297	8	4	localObject2	Object
    //   323	3	4	localIOException2	java.io.IOException
    //   450	7	4	str1	String
    //   143	114	5	localObject3	Object
    //   478	1	5	localException2	java.lang.Exception
    //   67	249	6	localFile	File
    //   15	451	7	localanjb	anjb
    //   125	282	8	localArrayList	java.util.ArrayList
    //   156	32	9	str2	String
    // Exception table:
    //   from	to	target	type
    //   2	17	93	java/lang/Exception
    //   151	158	218	java/lang/Exception
    //   167	177	218	java/lang/Exception
    //   181	197	218	java/lang/Exception
    //   208	218	218	java/lang/Exception
    //   256	261	275	java/io/IOException
    //   239	243	287	java/io/IOException
    //   127	145	295	finally
    //   304	309	323	java/io/IOException
    //   151	158	474	finally
    //   167	177	474	finally
    //   181	197	474	finally
    //   208	218	474	finally
    //   230	235	474	finally
    //   127	145	478	java/lang/Exception
  }
  
  /* Error */
  public static void dQx()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 4
    //   3: aconst_null
    //   4: astore 5
    //   6: new 10	java/lang/StringBuilder
    //   9: dup
    //   10: getstatic 89	acbn:SDCARD_PATH	Ljava/lang/String;
    //   13: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   16: astore_2
    //   17: aload_2
    //   18: getstatic 32	anix:cel	Ljava/lang/String;
    //   21: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   24: pop
    //   25: aload_2
    //   26: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   29: astore_2
    //   30: new 21	java/io/File
    //   33: dup
    //   34: new 10	java/lang/StringBuilder
    //   37: dup
    //   38: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   41: aload_2
    //   42: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   45: getstatic 24	java/io/File:separator	Ljava/lang/String;
    //   48: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   51: ldc 94
    //   53: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   59: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   62: astore 6
    //   64: aload 6
    //   66: invokevirtual 99	java/io/File:exists	()Z
    //   69: ifeq +191 -> 260
    //   72: aload 6
    //   74: invokevirtual 195	java/io/File:length	()J
    //   77: ldc2_w 196
    //   80: lcmp
    //   81: ifle +179 -> 260
    //   84: new 21	java/io/File
    //   87: dup
    //   88: new 10	java/lang/StringBuilder
    //   91: dup
    //   92: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   95: aload 6
    //   97: invokevirtual 200	java/io/File:getAbsolutePath	()Ljava/lang/String;
    //   100: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   103: ldc 202
    //   105: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   108: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   111: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   114: astore 7
    //   116: new 123	java/io/BufferedReader
    //   119: dup
    //   120: new 125	java/io/FileReader
    //   123: dup
    //   124: aload 6
    //   126: invokespecial 128	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   129: invokespecial 131	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   132: astore_3
    //   133: new 204	java/io/PrintWriter
    //   136: dup
    //   137: new 206	java/io/FileWriter
    //   140: dup
    //   141: aload 7
    //   143: invokespecial 207	java/io/FileWriter:<init>	(Ljava/io/File;)V
    //   146: invokespecial 210	java/io/PrintWriter:<init>	(Ljava/io/Writer;)V
    //   149: astore_2
    //   150: iconst_0
    //   151: istore_0
    //   152: aload_3
    //   153: invokevirtual 134	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   156: astore 4
    //   158: aload 4
    //   160: ifnull +101 -> 261
    //   163: iload_0
    //   164: iconst_1
    //   165: iadd
    //   166: istore_1
    //   167: iload_1
    //   168: istore_0
    //   169: iload_1
    //   170: sipush 1000
    //   173: if_icmple -21 -> 152
    //   176: aload_2
    //   177: aload 4
    //   179: invokevirtual 213	java/io/PrintWriter:println	(Ljava/lang/String;)V
    //   182: aload_2
    //   183: invokevirtual 216	java/io/PrintWriter:flush	()V
    //   186: iload_1
    //   187: istore_0
    //   188: goto -36 -> 152
    //   191: astore 4
    //   193: aload 4
    //   195: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   198: aload_2
    //   199: ifnull +7 -> 206
    //   202: aload_2
    //   203: invokevirtual 217	java/io/PrintWriter:close	()V
    //   206: aload_3
    //   207: ifnull +7 -> 214
    //   210: aload_3
    //   211: invokevirtual 150	java/io/BufferedReader:close	()V
    //   214: aload 6
    //   216: invokevirtual 153	java/io/File:delete	()Z
    //   219: ifne +17 -> 236
    //   222: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   225: ifeq +11 -> 236
    //   228: ldc 106
    //   230: iconst_2
    //   231: ldc 219
    //   233: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   236: aload 7
    //   238: aload 6
    //   240: invokevirtual 223	java/io/File:renameTo	(Ljava/io/File;)Z
    //   243: ifne +17 -> 260
    //   246: invokestatic 104	com/tencent/qphone/base/util/QLog:isColorLevel	()Z
    //   249: ifeq +11 -> 260
    //   252: ldc 106
    //   254: iconst_2
    //   255: ldc 225
    //   257: invokestatic 161	com/tencent/qphone/base/util/QLog:e	(Ljava/lang/String;ILjava/lang/String;)V
    //   260: return
    //   261: aload_2
    //   262: ifnull +7 -> 269
    //   265: aload_2
    //   266: invokevirtual 217	java/io/PrintWriter:close	()V
    //   269: aload_3
    //   270: ifnull -56 -> 214
    //   273: aload_3
    //   274: invokevirtual 150	java/io/BufferedReader:close	()V
    //   277: goto -63 -> 214
    //   280: astore_2
    //   281: aload_2
    //   282: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   285: goto -71 -> 214
    //   288: astore_2
    //   289: aload_2
    //   290: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   293: goto -79 -> 214
    //   296: astore_2
    //   297: aconst_null
    //   298: astore_3
    //   299: aload 4
    //   301: ifnull +8 -> 309
    //   304: aload 4
    //   306: invokevirtual 217	java/io/PrintWriter:close	()V
    //   309: aload_3
    //   310: ifnull +7 -> 317
    //   313: aload_3
    //   314: invokevirtual 150	java/io/BufferedReader:close	()V
    //   317: aload_2
    //   318: athrow
    //   319: astore_3
    //   320: aload_3
    //   321: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   324: goto -7 -> 317
    //   327: astore_2
    //   328: goto -29 -> 299
    //   331: astore 5
    //   333: aload_2
    //   334: astore 4
    //   336: aload 5
    //   338: astore_2
    //   339: goto -40 -> 299
    //   342: astore 5
    //   344: aload_2
    //   345: astore 4
    //   347: aload 5
    //   349: astore_2
    //   350: goto -51 -> 299
    //   353: astore 4
    //   355: aconst_null
    //   356: astore_2
    //   357: aload 5
    //   359: astore_3
    //   360: goto -167 -> 193
    //   363: astore 4
    //   365: aconst_null
    //   366: astore_2
    //   367: goto -174 -> 193
    // Local variable table:
    //   start	length	slot	name	signature
    //   151	37	0	i	int
    //   166	21	1	j	int
    //   16	250	2	localObject1	Object
    //   280	2	2	localIOException1	java.io.IOException
    //   288	2	2	localIOException2	java.io.IOException
    //   296	22	2	localObject2	Object
    //   327	7	2	localObject3	Object
    //   338	29	2	localObject4	Object
    //   132	182	3	localBufferedReader	java.io.BufferedReader
    //   319	2	3	localIOException3	java.io.IOException
    //   359	1	3	localObject5	Object
    //   1	177	4	str	String
    //   191	114	4	localIOException4	java.io.IOException
    //   334	12	4	localObject6	Object
    //   353	1	4	localIOException5	java.io.IOException
    //   363	1	4	localIOException6	java.io.IOException
    //   4	1	5	localObject7	Object
    //   331	6	5	localObject8	Object
    //   342	16	5	localObject9	Object
    //   62	177	6	localFile1	File
    //   114	123	7	localFile2	File
    // Exception table:
    //   from	to	target	type
    //   152	158	191	java/io/IOException
    //   176	186	191	java/io/IOException
    //   273	277	280	java/io/IOException
    //   210	214	288	java/io/IOException
    //   116	133	296	finally
    //   313	317	319	java/io/IOException
    //   133	150	327	finally
    //   152	158	331	finally
    //   176	186	331	finally
    //   193	198	342	finally
    //   116	133	353	java/io/IOException
    //   133	150	363	java/io/IOException
  }
  
  /* Error */
  public static void j(boolean paramBoolean, HashMap<String, String> paramHashMap)
  {
    // Byte code:
    //   0: invokestatic 229	anix:dQx	()V
    //   3: new 10	java/lang/StringBuilder
    //   6: dup
    //   7: getstatic 89	acbn:SDCARD_PATH	Ljava/lang/String;
    //   10: invokespecial 92	java/lang/StringBuilder:<init>	(Ljava/lang/String;)V
    //   13: astore_2
    //   14: aload_2
    //   15: getstatic 32	anix:cel	Ljava/lang/String;
    //   18: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   21: pop
    //   22: aload_2
    //   23: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   26: astore 4
    //   28: new 21	java/io/File
    //   31: dup
    //   32: aload 4
    //   34: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   37: astore_2
    //   38: aload_2
    //   39: invokevirtual 99	java/io/File:exists	()Z
    //   42: ifne +8 -> 50
    //   45: aload_2
    //   46: invokevirtual 232	java/io/File:mkdir	()Z
    //   49: pop
    //   50: iload_0
    //   51: aload_1
    //   52: invokestatic 81	anix:a	(ZLjava/util/HashMap;)Ljava/lang/String;
    //   55: astore 5
    //   57: aconst_null
    //   58: astore_2
    //   59: aconst_null
    //   60: astore_3
    //   61: aload_2
    //   62: astore_1
    //   63: new 21	java/io/File
    //   66: dup
    //   67: new 10	java/lang/StringBuilder
    //   70: dup
    //   71: invokespecial 13	java/lang/StringBuilder:<init>	()V
    //   74: aload 4
    //   76: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   79: getstatic 24	java/io/File:separator	Ljava/lang/String;
    //   82: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   85: ldc 94
    //   87: invokevirtual 19	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   90: invokevirtual 30	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   93: invokespecial 95	java/io/File:<init>	(Ljava/lang/String;)V
    //   96: astore 4
    //   98: aload_2
    //   99: astore_1
    //   100: aload 4
    //   102: invokevirtual 99	java/io/File:exists	()Z
    //   105: ifne +11 -> 116
    //   108: aload_2
    //   109: astore_1
    //   110: aload 4
    //   112: invokevirtual 235	java/io/File:createNewFile	()Z
    //   115: pop
    //   116: aload_2
    //   117: astore_1
    //   118: new 237	java/io/BufferedWriter
    //   121: dup
    //   122: new 206	java/io/FileWriter
    //   125: dup
    //   126: aload 4
    //   128: iconst_1
    //   129: invokespecial 240	java/io/FileWriter:<init>	(Ljava/io/File;Z)V
    //   132: invokespecial 241	java/io/BufferedWriter:<init>	(Ljava/io/Writer;)V
    //   135: astore_2
    //   136: aload 4
    //   138: invokevirtual 195	java/io/File:length	()J
    //   141: lconst_0
    //   142: lcmp
    //   143: ifle +7 -> 150
    //   146: aload_2
    //   147: invokevirtual 244	java/io/BufferedWriter:newLine	()V
    //   150: aload_2
    //   151: aload 5
    //   153: invokevirtual 247	java/io/BufferedWriter:write	(Ljava/lang/String;)V
    //   156: aload_2
    //   157: invokevirtual 248	java/io/BufferedWriter:flush	()V
    //   160: aload_2
    //   161: ifnull +7 -> 168
    //   164: aload_2
    //   165: invokevirtual 249	java/io/BufferedWriter:close	()V
    //   168: return
    //   169: astore_1
    //   170: aload_1
    //   171: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   174: return
    //   175: astore_1
    //   176: aload_3
    //   177: astore_2
    //   178: aload_1
    //   179: astore_3
    //   180: aload_2
    //   181: astore_1
    //   182: aload_3
    //   183: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   186: aload_2
    //   187: ifnull -19 -> 168
    //   190: aload_2
    //   191: invokevirtual 249	java/io/BufferedWriter:close	()V
    //   194: return
    //   195: astore_1
    //   196: aload_1
    //   197: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   200: return
    //   201: astore_3
    //   202: aload_1
    //   203: astore_2
    //   204: aload_3
    //   205: astore_1
    //   206: aload_2
    //   207: ifnull +7 -> 214
    //   210: aload_2
    //   211: invokevirtual 249	java/io/BufferedWriter:close	()V
    //   214: aload_1
    //   215: athrow
    //   216: astore_2
    //   217: aload_2
    //   218: invokevirtual 154	java/io/IOException:printStackTrace	()V
    //   221: goto -7 -> 214
    //   224: astore_1
    //   225: goto -19 -> 206
    //   228: astore_3
    //   229: goto -49 -> 180
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	232	0	paramBoolean	boolean
    //   0	232	1	paramHashMap	HashMap<String, String>
    //   13	198	2	localObject1	Object
    //   216	2	2	localIOException1	java.io.IOException
    //   60	123	3	localHashMap	HashMap<String, String>
    //   201	4	3	localObject2	Object
    //   228	1	3	localIOException2	java.io.IOException
    //   26	111	4	localObject3	Object
    //   55	97	5	str	String
    // Exception table:
    //   from	to	target	type
    //   164	168	169	java/io/IOException
    //   63	98	175	java/io/IOException
    //   100	108	175	java/io/IOException
    //   110	116	175	java/io/IOException
    //   118	136	175	java/io/IOException
    //   190	194	195	java/io/IOException
    //   63	98	201	finally
    //   100	108	201	finally
    //   110	116	201	finally
    //   118	136	201	finally
    //   182	186	201	finally
    //   210	214	216	java/io/IOException
    //   136	150	224	finally
    //   150	160	224	finally
    //   136	150	228	java/io/IOException
    //   150	160	228	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes3.jar
 * Qualified Name:     anix
 * JD-Core Version:    0.7.0.1
 */