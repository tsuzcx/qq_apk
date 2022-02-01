package com.tencent.feedback.anr;

import java.io.BufferedReader;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  public String a = null;
  public Map<String, String> b = null;
  public long c = -1L;
  public String d = null;
  public String e = null;
  public String f = null;
  
  public static f a(String paramString1, String paramString2, boolean paramBoolean)
  {
    if (paramString1 != null)
    {
      if (paramString2 == null) {
        return null;
      }
      paramString1 = new f();
      a(paramString2, new d(paramString1, true));
      if ((paramString1.a > 0L) && (paramString1.c > 0L) && (paramString1.b != null)) {
        return paramString1;
      }
      return null;
    }
    return null;
  }
  
  public static f a(String paramString, boolean paramBoolean)
  {
    if (paramString == null)
    {
      com.tencent.feedback.common.e.d("path:%s", new Object[] { paramString });
      return null;
    }
    f localf = new f();
    a(paramString, new e(localf, false));
    if ((localf.a > 0L) && (localf.c > 0L) && (localf.b != null)) {
      return localf;
    }
    paramString = new StringBuilder();
    paramString.append(localf.a);
    paramString.append(" ");
    paramString.append(localf.c);
    paramString.append(" ");
    paramString.append(localf.b);
    com.tencent.feedback.common.e.d("first dump error %s", new Object[] { paramString.toString() });
    return null;
  }
  
  protected static String a(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 3)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        return null;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void a(String paramString, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +624 -> 625
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 100	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 103	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 107	java/io/File:exists	()Z
    //   24: ifne +4 -> 28
    //   27: return
    //   28: aload 7
    //   30: invokevirtual 111	java/io/File:lastModified	()J
    //   33: pop2
    //   34: aload 7
    //   36: invokevirtual 114	java/io/File:length	()J
    //   39: pop2
    //   40: aconst_null
    //   41: astore 8
    //   43: aconst_null
    //   44: astore_0
    //   45: new 85	java/io/BufferedReader
    //   48: dup
    //   49: new 116	java/io/FileReader
    //   52: dup
    //   53: aload 7
    //   55: invokespecial 119	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   58: invokespecial 122	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   61: astore 7
    //   63: ldc 124
    //   65: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   68: astore_0
    //   69: ldc 132
    //   71: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   74: astore 8
    //   76: ldc 134
    //   78: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   81: astore 9
    //   83: ldc 136
    //   85: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   88: astore 10
    //   90: new 138	java/text/SimpleDateFormat
    //   93: dup
    //   94: ldc 140
    //   96: getstatic 146	java/util/Locale:US	Ljava/util/Locale;
    //   99: invokespecial 149	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   102: astore 11
    //   104: aload 7
    //   106: iconst_1
    //   107: anewarray 126	java/util/regex/Pattern
    //   110: dup
    //   111: iconst_0
    //   112: aload_0
    //   113: aastore
    //   114: invokestatic 152	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   117: astore 12
    //   119: aload 12
    //   121: ifnull +390 -> 511
    //   124: aload 12
    //   126: iconst_1
    //   127: aaload
    //   128: invokevirtual 153	java/lang/Object:toString	()Ljava/lang/String;
    //   131: ldc 155
    //   133: invokevirtual 161	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   136: astore 12
    //   138: aload 12
    //   140: iconst_2
    //   141: aaload
    //   142: invokestatic 167	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   145: lstore_2
    //   146: new 63	java/lang/StringBuilder
    //   149: dup
    //   150: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   153: astore 13
    //   155: aload 13
    //   157: aload 12
    //   159: iconst_4
    //   160: aaload
    //   161: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   164: pop
    //   165: aload 13
    //   167: ldc 70
    //   169: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   172: pop
    //   173: aload 13
    //   175: aload 12
    //   177: iconst_5
    //   178: aaload
    //   179: invokevirtual 73	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   182: pop
    //   183: aload 11
    //   185: aload 13
    //   187: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   190: invokevirtual 171	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   193: invokevirtual 176	java/util/Date:getTime	()J
    //   196: lstore 4
    //   198: aload 7
    //   200: iconst_1
    //   201: anewarray 126	java/util/regex/Pattern
    //   204: dup
    //   205: iconst_0
    //   206: aload 9
    //   208: aastore
    //   209: invokestatic 152	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   212: astore 12
    //   214: aload 12
    //   216: ifnonnull +22 -> 238
    //   219: aload 7
    //   221: invokevirtual 179	java/io/BufferedReader:close	()V
    //   224: return
    //   225: astore_0
    //   226: aload_0
    //   227: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   230: ifne +7 -> 237
    //   233: aload_0
    //   234: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   237: return
    //   238: aload 9
    //   240: aload 12
    //   242: iconst_1
    //   243: aaload
    //   244: invokevirtual 153	java/lang/Object:toString	()Ljava/lang/String;
    //   247: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   250: astore 12
    //   252: aload 12
    //   254: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   257: pop
    //   258: aload 12
    //   260: iconst_1
    //   261: invokevirtual 198	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   264: pop
    //   265: aload_1
    //   266: lload_2
    //   267: lload 4
    //   269: aload 12
    //   271: iconst_1
    //   272: invokevirtual 198	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   275: invokeinterface 203 6 0
    //   280: istore 6
    //   282: iload 6
    //   284: ifne +22 -> 306
    //   287: aload 7
    //   289: invokevirtual 179	java/io/BufferedReader:close	()V
    //   292: return
    //   293: astore_0
    //   294: aload_0
    //   295: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   298: ifne +7 -> 305
    //   301: aload_0
    //   302: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   305: return
    //   306: aload 7
    //   308: iconst_2
    //   309: anewarray 126	java/util/regex/Pattern
    //   312: dup
    //   313: iconst_0
    //   314: aload 10
    //   316: aastore
    //   317: dup
    //   318: iconst_1
    //   319: aload 8
    //   321: aastore
    //   322: invokestatic 152	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   325: astore 12
    //   327: aload 12
    //   329: ifnull -225 -> 104
    //   332: aload 12
    //   334: iconst_0
    //   335: aaload
    //   336: aload 10
    //   338: if_acmpne +124 -> 462
    //   341: aload 12
    //   343: iconst_1
    //   344: aaload
    //   345: invokevirtual 153	java/lang/Object:toString	()Ljava/lang/String;
    //   348: astore 12
    //   350: ldc 205
    //   352: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   355: aload 12
    //   357: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   360: astore 13
    //   362: aload 13
    //   364: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   367: pop
    //   368: aload 13
    //   370: invokevirtual 207	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   373: astore 13
    //   375: aload 13
    //   377: iconst_1
    //   378: aload 13
    //   380: invokevirtual 210	java/lang/String:length	()I
    //   383: iconst_1
    //   384: isub
    //   385: invokevirtual 214	java/lang/String:substring	(II)Ljava/lang/String;
    //   388: astore 13
    //   390: aload 12
    //   392: ldc 216
    //   394: invokevirtual 220	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   397: pop
    //   398: ldc 222
    //   400: invokestatic 130	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   403: aload 12
    //   405: invokevirtual 189	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   408: astore 12
    //   410: aload 12
    //   412: invokevirtual 194	java/util/regex/Matcher:find	()Z
    //   415: pop
    //   416: aload 12
    //   418: invokevirtual 207	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   421: astore 12
    //   423: aload_1
    //   424: aload 13
    //   426: aload 12
    //   428: aload 12
    //   430: ldc 224
    //   432: invokevirtual 228	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   435: iconst_1
    //   436: iadd
    //   437: invokevirtual 230	java/lang/String:substring	(I)Ljava/lang/String;
    //   440: invokestatic 235	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   443: aload 7
    //   445: invokestatic 237	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   448: aload 7
    //   450: invokestatic 239	com/tencent/feedback/anr/a:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   453: invokeinterface 242 5 0
    //   458: pop
    //   459: goto -153 -> 306
    //   462: aload_1
    //   463: aload 12
    //   465: iconst_1
    //   466: aaload
    //   467: invokevirtual 153	java/lang/Object:toString	()Ljava/lang/String;
    //   470: ldc 155
    //   472: invokevirtual 161	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   475: iconst_2
    //   476: aaload
    //   477: invokestatic 167	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   480: invokeinterface 245 3 0
    //   485: istore 6
    //   487: iload 6
    //   489: ifne -385 -> 104
    //   492: aload 7
    //   494: invokevirtual 179	java/io/BufferedReader:close	()V
    //   497: return
    //   498: astore_0
    //   499: aload_0
    //   500: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   503: ifne +7 -> 510
    //   506: aload_0
    //   507: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   510: return
    //   511: aload 7
    //   513: invokevirtual 179	java/io/BufferedReader:close	()V
    //   516: return
    //   517: astore_0
    //   518: aload_0
    //   519: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   522: ifne +7 -> 529
    //   525: aload_0
    //   526: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   529: return
    //   530: astore_0
    //   531: goto +67 -> 598
    //   534: astore_0
    //   535: aload 7
    //   537: astore_1
    //   538: aload_0
    //   539: astore 7
    //   541: goto +17 -> 558
    //   544: astore_1
    //   545: aload_0
    //   546: astore 7
    //   548: aload_1
    //   549: astore_0
    //   550: goto +48 -> 598
    //   553: astore 7
    //   555: aload 8
    //   557: astore_1
    //   558: aload_1
    //   559: astore_0
    //   560: aload 7
    //   562: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   565: ifne +10 -> 575
    //   568: aload_1
    //   569: astore_0
    //   570: aload 7
    //   572: invokevirtual 246	java/lang/Exception:printStackTrace	()V
    //   575: aload_1
    //   576: ifnull +21 -> 597
    //   579: aload_1
    //   580: invokevirtual 179	java/io/BufferedReader:close	()V
    //   583: return
    //   584: astore_0
    //   585: aload_0
    //   586: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   589: ifne +7 -> 596
    //   592: aload_0
    //   593: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   596: return
    //   597: return
    //   598: aload 7
    //   600: ifnull +23 -> 623
    //   603: aload 7
    //   605: invokevirtual 179	java/io/BufferedReader:close	()V
    //   608: goto +15 -> 623
    //   611: astore_1
    //   612: aload_1
    //   613: invokestatic 182	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   616: ifne +7 -> 623
    //   619: aload_1
    //   620: invokevirtual 185	java/io/IOException:printStackTrace	()V
    //   623: aload_0
    //   624: athrow
    //   625: return
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	626	0	paramString	String
    //   0	626	1	paramg	g
    //   145	122	2	l1	long
    //   196	72	4	l2	long
    //   280	208	6	bool	boolean
    //   17	530	7	localObject1	Object
    //   553	51	7	localException	java.lang.Exception
    //   41	515	8	localPattern1	Pattern
    //   81	158	9	localPattern2	Pattern
    //   88	249	10	localPattern3	Pattern
    //   102	82	11	localSimpleDateFormat	java.text.SimpleDateFormat
    //   117	347	12	localObject2	Object
    //   153	272	13	localObject3	Object
    // Exception table:
    //   from	to	target	type
    //   219	224	225	java/io/IOException
    //   287	292	293	java/io/IOException
    //   492	497	498	java/io/IOException
    //   511	516	517	java/io/IOException
    //   63	104	530	finally
    //   104	119	530	finally
    //   124	214	530	finally
    //   238	282	530	finally
    //   306	327	530	finally
    //   341	459	530	finally
    //   462	487	530	finally
    //   63	104	534	java/lang/Exception
    //   104	119	534	java/lang/Exception
    //   124	214	534	java/lang/Exception
    //   238	282	534	java/lang/Exception
    //   306	327	534	java/lang/Exception
    //   341	459	534	java/lang/Exception
    //   462	487	534	java/lang/Exception
    //   45	63	544	finally
    //   560	568	544	finally
    //   570	575	544	finally
    //   45	63	553	java/lang/Exception
    //   579	583	584	java/io/IOException
    //   603	608	611	java/io/IOException
  }
  
  protected static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
  {
    if (paramBufferedReader != null)
    {
      if (paramVarArgs == null) {
        return null;
      }
      for (;;)
      {
        String str = paramBufferedReader.readLine();
        if (str == null) {
          break;
        }
        int j = paramVarArgs.length;
        int i = 0;
        while (i < j)
        {
          Pattern localPattern = paramVarArgs[i];
          if (localPattern.matcher(str).matches()) {
            return new Object[] { localPattern, str };
          }
          i += 1;
        }
      }
      return null;
    }
    return null;
  }
  
  protected static String b(BufferedReader paramBufferedReader)
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      StringBuilder localStringBuilder = new StringBuilder();
      localStringBuilder.append(str);
      localStringBuilder.append("\n");
      localStringBuffer.append(localStringBuilder.toString());
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.a
 * JD-Core Version:    0.7.0.1
 */