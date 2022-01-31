package com.tencent.feedback.anr;

import java.io.BufferedReader;
import java.io.IOException;
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
    if ((paramString1 == null) || (paramString2 == null)) {
      paramString1 = null;
    }
    f localf;
    do
    {
      return paramString1;
      localf = new f();
      a(paramString2, new d(localf, true));
      if ((localf.a <= 0L) || (localf.c <= 0L)) {
        break;
      }
      paramString1 = localf;
    } while (localf.b != null);
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
    com.tencent.feedback.common.e.d("first dump error %s", new Object[] { localf.a + " " + localf.c + " " + localf.b });
    return null;
  }
  
  protected static String a(BufferedReader paramBufferedReader)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    int i = 0;
    while (i < 3)
    {
      String str = paramBufferedReader.readLine();
      if (str == null) {
        return null;
      }
      localStringBuffer.append(str + "\n");
      i += 1;
    }
    return localStringBuffer.toString();
  }
  
  /* Error */
  public static void a(String paramString, g paramg)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 101	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 104	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 108	java/io/File:exists	()Z
    //   24: ifeq -16 -> 8
    //   27: aload 7
    //   29: invokevirtual 112	java/io/File:lastModified	()J
    //   32: pop2
    //   33: aload 7
    //   35: invokevirtual 115	java/io/File:length	()J
    //   38: pop2
    //   39: aconst_null
    //   40: astore_0
    //   41: new 87	java/io/BufferedReader
    //   44: dup
    //   45: new 117	java/io/FileReader
    //   48: dup
    //   49: aload 7
    //   51: invokespecial 120	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   54: invokespecial 123	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore 7
    //   59: ldc 125
    //   61: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   64: astore_0
    //   65: ldc 133
    //   67: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   70: astore 8
    //   72: ldc 135
    //   74: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   77: astore 9
    //   79: ldc 137
    //   81: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   84: astore 10
    //   86: new 139	java/text/SimpleDateFormat
    //   89: dup
    //   90: ldc 141
    //   92: getstatic 147	java/util/Locale:US	Ljava/util/Locale;
    //   95: invokespecial 150	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   98: astore 11
    //   100: aload 7
    //   102: iconst_1
    //   103: anewarray 127	java/util/regex/Pattern
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: invokestatic 153	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +414 -> 531
    //   120: aload 12
    //   122: iconst_1
    //   123: aaload
    //   124: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   127: ldc 156
    //   129: invokevirtual 162	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   132: astore 12
    //   134: aload 12
    //   136: iconst_2
    //   137: aaload
    //   138: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   141: lstore_2
    //   142: aload 11
    //   144: new 65	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 66	java/lang/StringBuilder:<init>	()V
    //   151: aload 12
    //   153: iconst_4
    //   154: aaload
    //   155: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 72
    //   160: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 12
    //   165: iconst_5
    //   166: aaload
    //   167: invokevirtual 75	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 79	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 172	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   176: invokevirtual 177	java/util/Date:getTime	()J
    //   179: lstore 4
    //   181: aload 7
    //   183: iconst_1
    //   184: anewarray 127	java/util/regex/Pattern
    //   187: dup
    //   188: iconst_0
    //   189: aload 9
    //   191: aastore
    //   192: invokestatic 153	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   195: astore 12
    //   197: aload 12
    //   199: ifnonnull +22 -> 221
    //   202: aload 7
    //   204: invokevirtual 180	java/io/BufferedReader:close	()V
    //   207: return
    //   208: astore_0
    //   209: aload_0
    //   210: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   213: ifne -205 -> 8
    //   216: aload_0
    //   217: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   220: return
    //   221: aload 9
    //   223: aload 12
    //   225: iconst_1
    //   226: aaload
    //   227: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   230: invokevirtual 190	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   233: astore 12
    //   235: aload 12
    //   237: invokevirtual 195	java/util/regex/Matcher:find	()Z
    //   240: pop
    //   241: aload 12
    //   243: iconst_1
    //   244: invokevirtual 199	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   247: pop
    //   248: aload_1
    //   249: lload_2
    //   250: lload 4
    //   252: aload 12
    //   254: iconst_1
    //   255: invokevirtual 199	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   258: invokeinterface 204 6 0
    //   263: istore 6
    //   265: iload 6
    //   267: ifne +22 -> 289
    //   270: aload 7
    //   272: invokevirtual 180	java/io/BufferedReader:close	()V
    //   275: return
    //   276: astore_0
    //   277: aload_0
    //   278: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   281: ifne -273 -> 8
    //   284: aload_0
    //   285: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   288: return
    //   289: aload 7
    //   291: iconst_2
    //   292: anewarray 127	java/util/regex/Pattern
    //   295: dup
    //   296: iconst_0
    //   297: aload 10
    //   299: aastore
    //   300: dup
    //   301: iconst_1
    //   302: aload 8
    //   304: aastore
    //   305: invokestatic 153	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   308: astore 12
    //   310: aload 12
    //   312: ifnull -212 -> 100
    //   315: aload 12
    //   317: iconst_0
    //   318: aaload
    //   319: aload 10
    //   321: if_acmpne +161 -> 482
    //   324: aload 12
    //   326: iconst_1
    //   327: aaload
    //   328: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   331: astore 12
    //   333: ldc 206
    //   335: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   338: aload 12
    //   340: invokevirtual 190	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   343: astore 13
    //   345: aload 13
    //   347: invokevirtual 195	java/util/regex/Matcher:find	()Z
    //   350: pop
    //   351: aload 13
    //   353: invokevirtual 208	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   356: astore 13
    //   358: aload 13
    //   360: iconst_1
    //   361: aload 13
    //   363: invokevirtual 211	java/lang/String:length	()I
    //   366: iconst_1
    //   367: isub
    //   368: invokevirtual 215	java/lang/String:substring	(II)Ljava/lang/String;
    //   371: astore 13
    //   373: aload 12
    //   375: ldc 217
    //   377: invokevirtual 221	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   380: pop
    //   381: ldc 223
    //   383: invokestatic 131	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   386: aload 12
    //   388: invokevirtual 190	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   391: astore 12
    //   393: aload 12
    //   395: invokevirtual 195	java/util/regex/Matcher:find	()Z
    //   398: pop
    //   399: aload 12
    //   401: invokevirtual 208	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   404: astore 12
    //   406: aload_1
    //   407: aload 13
    //   409: aload 12
    //   411: aload 12
    //   413: ldc 225
    //   415: invokevirtual 229	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   418: iconst_1
    //   419: iadd
    //   420: invokevirtual 231	java/lang/String:substring	(I)Ljava/lang/String;
    //   423: invokestatic 236	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   426: aload 7
    //   428: invokestatic 238	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   431: aload 7
    //   433: invokestatic 240	com/tencent/feedback/anr/a:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   436: invokeinterface 243 5 0
    //   441: pop
    //   442: goto -153 -> 289
    //   445: astore_1
    //   446: aload 7
    //   448: astore_0
    //   449: aload_1
    //   450: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   453: ifne +7 -> 460
    //   456: aload_1
    //   457: invokevirtual 244	java/lang/Exception:printStackTrace	()V
    //   460: aload_0
    //   461: ifnull -453 -> 8
    //   464: aload_0
    //   465: invokevirtual 180	java/io/BufferedReader:close	()V
    //   468: return
    //   469: astore_0
    //   470: aload_0
    //   471: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   474: ifne -466 -> 8
    //   477: aload_0
    //   478: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   481: return
    //   482: aload_1
    //   483: aload 12
    //   485: iconst_1
    //   486: aaload
    //   487: invokevirtual 154	java/lang/Object:toString	()Ljava/lang/String;
    //   490: ldc 156
    //   492: invokevirtual 162	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   495: iconst_2
    //   496: aaload
    //   497: invokestatic 168	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   500: invokeinterface 247 3 0
    //   505: istore 6
    //   507: iload 6
    //   509: ifne -409 -> 100
    //   512: aload 7
    //   514: invokevirtual 180	java/io/BufferedReader:close	()V
    //   517: return
    //   518: astore_0
    //   519: aload_0
    //   520: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   523: ifne -515 -> 8
    //   526: aload_0
    //   527: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   530: return
    //   531: aload 7
    //   533: invokevirtual 180	java/io/BufferedReader:close	()V
    //   536: return
    //   537: astore_0
    //   538: aload_0
    //   539: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   542: ifne -534 -> 8
    //   545: aload_0
    //   546: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   549: return
    //   550: astore_0
    //   551: aconst_null
    //   552: astore_1
    //   553: aload_1
    //   554: ifnull +7 -> 561
    //   557: aload_1
    //   558: invokevirtual 180	java/io/BufferedReader:close	()V
    //   561: aload_0
    //   562: athrow
    //   563: astore_1
    //   564: aload_1
    //   565: invokestatic 183	com/tencent/feedback/common/e:a	(Ljava/lang/Throwable;)Z
    //   568: ifne -7 -> 561
    //   571: aload_1
    //   572: invokevirtual 186	java/io/IOException:printStackTrace	()V
    //   575: goto -14 -> 561
    //   578: astore_0
    //   579: aload 7
    //   581: astore_1
    //   582: goto -29 -> 553
    //   585: astore 7
    //   587: aload_0
    //   588: astore_1
    //   589: aload 7
    //   591: astore_0
    //   592: goto -39 -> 553
    //   595: astore_1
    //   596: goto -147 -> 449
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	599	0	paramString	String
    //   0	599	1	paramg	g
    //   141	109	2	l1	long
    //   179	72	4	l2	long
    //   263	245	6	bool	boolean
    //   17	563	7	localObject1	Object
    //   585	5	7	localObject2	Object
    //   70	233	8	localPattern1	Pattern
    //   77	145	9	localPattern2	Pattern
    //   84	236	10	localPattern3	Pattern
    //   98	45	11	localSimpleDateFormat	java.text.SimpleDateFormat
    //   113	371	12	localObject3	Object
    //   343	65	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   202	207	208	java/io/IOException
    //   270	275	276	java/io/IOException
    //   59	100	445	java/lang/Exception
    //   100	115	445	java/lang/Exception
    //   120	197	445	java/lang/Exception
    //   221	265	445	java/lang/Exception
    //   289	310	445	java/lang/Exception
    //   324	442	445	java/lang/Exception
    //   482	507	445	java/lang/Exception
    //   464	468	469	java/io/IOException
    //   512	517	518	java/io/IOException
    //   531	536	537	java/io/IOException
    //   41	59	550	finally
    //   557	561	563	java/io/IOException
    //   59	100	578	finally
    //   100	115	578	finally
    //   120	197	578	finally
    //   221	265	578	finally
    //   289	310	578	finally
    //   324	442	578	finally
    //   482	507	578	finally
    //   449	460	585	finally
    //   41	59	595	java/lang/Exception
  }
  
  protected static Object[] a(BufferedReader paramBufferedReader, Pattern... paramVarArgs)
    throws IOException
  {
    if ((paramBufferedReader == null) || (paramVarArgs == null)) {
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
  }
  
  protected static String b(BufferedReader paramBufferedReader)
    throws IOException
  {
    StringBuffer localStringBuffer = new StringBuffer();
    for (;;)
    {
      String str = paramBufferedReader.readLine();
      if ((str == null) || (str.trim().length() <= 0)) {
        break;
      }
      localStringBuffer.append(str + "\n");
    }
    return localStringBuffer.toString();
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.token\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.a
 * JD-Core Version:    0.7.0.1
 */