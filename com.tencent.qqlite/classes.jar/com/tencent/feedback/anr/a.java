package com.tencent.feedback.anr;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class a
{
  private String a;
  private long b;
  private String c;
  private String d;
  private int e;
  
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
  public static void a(String paramString, f paramf)
  {
    // Byte code:
    //   0: aload_0
    //   1: ifnull +7 -> 8
    //   4: aload_1
    //   5: ifnonnull +4 -> 9
    //   8: return
    //   9: new 51	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: invokespecial 54	java/io/File:<init>	(Ljava/lang/String;)V
    //   17: astore 7
    //   19: aload 7
    //   21: invokevirtual 58	java/io/File:exists	()Z
    //   24: ifeq -16 -> 8
    //   27: aload 7
    //   29: invokevirtual 62	java/io/File:lastModified	()J
    //   32: pop2
    //   33: aload 7
    //   35: invokevirtual 65	java/io/File:length	()J
    //   38: pop2
    //   39: aconst_null
    //   40: astore_0
    //   41: new 25	java/io/BufferedReader
    //   44: dup
    //   45: new 67	java/io/FileReader
    //   48: dup
    //   49: aload 7
    //   51: invokespecial 70	java/io/FileReader:<init>	(Ljava/io/File;)V
    //   54: invokespecial 73	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   57: astore 7
    //   59: ldc 75
    //   61: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   64: astore_0
    //   65: ldc 83
    //   67: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   70: astore 8
    //   72: ldc 85
    //   74: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   77: astore 9
    //   79: ldc 87
    //   81: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   84: astore 10
    //   86: new 89	java/text/SimpleDateFormat
    //   89: dup
    //   90: ldc 91
    //   92: getstatic 97	java/util/Locale:US	Ljava/util/Locale;
    //   95: invokespecial 100	java/text/SimpleDateFormat:<init>	(Ljava/lang/String;Ljava/util/Locale;)V
    //   98: astore 11
    //   100: aload 7
    //   102: iconst_1
    //   103: anewarray 77	java/util/regex/Pattern
    //   106: dup
    //   107: iconst_0
    //   108: aload_0
    //   109: aastore
    //   110: invokestatic 103	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   113: astore 12
    //   115: aload 12
    //   117: ifnull +379 -> 496
    //   120: aload 12
    //   122: iconst_1
    //   123: aaload
    //   124: invokevirtual 104	java/lang/Object:toString	()Ljava/lang/String;
    //   127: ldc 106
    //   129: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   132: astore 12
    //   134: aload 12
    //   136: iconst_2
    //   137: aaload
    //   138: invokestatic 118	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   141: lstore_2
    //   142: aload 11
    //   144: new 31	java/lang/StringBuilder
    //   147: dup
    //   148: invokespecial 32	java/lang/StringBuilder:<init>	()V
    //   151: aload 12
    //   153: iconst_4
    //   154: aaload
    //   155: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   158: ldc 120
    //   160: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   163: aload 12
    //   165: iconst_5
    //   166: aaload
    //   167: invokevirtual 36	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   170: invokevirtual 41	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   173: invokevirtual 124	java/text/SimpleDateFormat:parse	(Ljava/lang/String;)Ljava/util/Date;
    //   176: invokevirtual 129	java/util/Date:getTime	()J
    //   179: lstore 4
    //   181: aload 7
    //   183: iconst_1
    //   184: anewarray 77	java/util/regex/Pattern
    //   187: dup
    //   188: iconst_0
    //   189: aload 9
    //   191: aastore
    //   192: invokestatic 103	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   195: astore 12
    //   197: aload 12
    //   199: ifnonnull +15 -> 214
    //   202: aload 7
    //   204: invokevirtual 132	java/io/BufferedReader:close	()V
    //   207: return
    //   208: astore_0
    //   209: aload_0
    //   210: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   213: return
    //   214: aload 9
    //   216: aload 12
    //   218: iconst_1
    //   219: aaload
    //   220: invokevirtual 104	java/lang/Object:toString	()Ljava/lang/String;
    //   223: invokevirtual 139	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   226: astore 12
    //   228: aload 12
    //   230: invokevirtual 144	java/util/regex/Matcher:find	()Z
    //   233: pop
    //   234: aload 12
    //   236: iconst_1
    //   237: invokevirtual 148	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   240: pop
    //   241: aload_1
    //   242: lload_2
    //   243: lload 4
    //   245: aload 12
    //   247: iconst_1
    //   248: invokevirtual 148	java/util/regex/Matcher:group	(I)Ljava/lang/String;
    //   251: invokeinterface 153 6 0
    //   256: istore 6
    //   258: iload 6
    //   260: ifne +15 -> 275
    //   263: aload 7
    //   265: invokevirtual 132	java/io/BufferedReader:close	()V
    //   268: return
    //   269: astore_0
    //   270: aload_0
    //   271: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   274: return
    //   275: aload 7
    //   277: iconst_2
    //   278: anewarray 77	java/util/regex/Pattern
    //   281: dup
    //   282: iconst_0
    //   283: aload 10
    //   285: aastore
    //   286: dup
    //   287: iconst_1
    //   288: aload 8
    //   290: aastore
    //   291: invokestatic 103	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;[Ljava/util/regex/Pattern;)[Ljava/lang/Object;
    //   294: astore 12
    //   296: aload 12
    //   298: ifnull -198 -> 100
    //   301: aload 12
    //   303: iconst_0
    //   304: aaload
    //   305: aload 10
    //   307: if_acmpne +147 -> 454
    //   310: aload 12
    //   312: iconst_1
    //   313: aaload
    //   314: invokevirtual 104	java/lang/Object:toString	()Ljava/lang/String;
    //   317: astore 12
    //   319: ldc 155
    //   321: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   324: aload 12
    //   326: invokevirtual 139	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   329: astore 13
    //   331: aload 13
    //   333: invokevirtual 144	java/util/regex/Matcher:find	()Z
    //   336: pop
    //   337: aload 13
    //   339: invokevirtual 157	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   342: astore 13
    //   344: aload 13
    //   346: iconst_1
    //   347: aload 13
    //   349: invokevirtual 160	java/lang/String:length	()I
    //   352: iconst_1
    //   353: isub
    //   354: invokevirtual 164	java/lang/String:substring	(II)Ljava/lang/String;
    //   357: astore 13
    //   359: aload 12
    //   361: ldc 166
    //   363: invokevirtual 170	java/lang/String:contains	(Ljava/lang/CharSequence;)Z
    //   366: pop
    //   367: ldc 172
    //   369: invokestatic 81	java/util/regex/Pattern:compile	(Ljava/lang/String;)Ljava/util/regex/Pattern;
    //   372: aload 12
    //   374: invokevirtual 139	java/util/regex/Pattern:matcher	(Ljava/lang/CharSequence;)Ljava/util/regex/Matcher;
    //   377: astore 12
    //   379: aload 12
    //   381: invokevirtual 144	java/util/regex/Matcher:find	()Z
    //   384: pop
    //   385: aload 12
    //   387: invokevirtual 157	java/util/regex/Matcher:group	()Ljava/lang/String;
    //   390: astore 12
    //   392: aload_1
    //   393: aload 13
    //   395: aload 12
    //   397: aload 12
    //   399: ldc 174
    //   401: invokevirtual 178	java/lang/String:indexOf	(Ljava/lang/String;)I
    //   404: iconst_1
    //   405: iadd
    //   406: invokevirtual 180	java/lang/String:substring	(I)Ljava/lang/String;
    //   409: invokestatic 185	java/lang/Integer:parseInt	(Ljava/lang/String;)I
    //   412: aload 7
    //   414: invokestatic 187	com/tencent/feedback/anr/a:a	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   417: aload 7
    //   419: invokestatic 189	com/tencent/feedback/anr/a:b	(Ljava/io/BufferedReader;)Ljava/lang/String;
    //   422: invokeinterface 192 5 0
    //   427: pop
    //   428: goto -153 -> 275
    //   431: astore_1
    //   432: aload 7
    //   434: astore_0
    //   435: aload_1
    //   436: invokevirtual 193	java/lang/Exception:printStackTrace	()V
    //   439: aload_0
    //   440: ifnull -432 -> 8
    //   443: aload_0
    //   444: invokevirtual 132	java/io/BufferedReader:close	()V
    //   447: return
    //   448: astore_0
    //   449: aload_0
    //   450: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   453: return
    //   454: aload_1
    //   455: aload 12
    //   457: iconst_1
    //   458: aaload
    //   459: invokevirtual 104	java/lang/Object:toString	()Ljava/lang/String;
    //   462: ldc 106
    //   464: invokevirtual 112	java/lang/String:split	(Ljava/lang/String;)[Ljava/lang/String;
    //   467: iconst_2
    //   468: aaload
    //   469: invokestatic 118	java/lang/Long:parseLong	(Ljava/lang/String;)J
    //   472: invokeinterface 196 3 0
    //   477: istore 6
    //   479: iload 6
    //   481: ifne -381 -> 100
    //   484: aload 7
    //   486: invokevirtual 132	java/io/BufferedReader:close	()V
    //   489: return
    //   490: astore_0
    //   491: aload_0
    //   492: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   495: return
    //   496: aload 7
    //   498: invokevirtual 132	java/io/BufferedReader:close	()V
    //   501: return
    //   502: astore_0
    //   503: aload_0
    //   504: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   507: return
    //   508: astore_0
    //   509: aconst_null
    //   510: astore_1
    //   511: aload_1
    //   512: ifnull +7 -> 519
    //   515: aload_1
    //   516: invokevirtual 132	java/io/BufferedReader:close	()V
    //   519: aload_0
    //   520: athrow
    //   521: astore_1
    //   522: aload_1
    //   523: invokevirtual 135	java/io/IOException:printStackTrace	()V
    //   526: goto -7 -> 519
    //   529: astore_0
    //   530: aload 7
    //   532: astore_1
    //   533: goto -22 -> 511
    //   536: astore 7
    //   538: aload_0
    //   539: astore_1
    //   540: aload 7
    //   542: astore_0
    //   543: goto -32 -> 511
    //   546: astore_1
    //   547: goto -112 -> 435
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	550	0	paramString	String
    //   0	550	1	paramf	f
    //   141	102	2	l1	long
    //   179	65	4	l2	long
    //   256	224	6	bool	boolean
    //   17	514	7	localObject1	Object
    //   536	5	7	localObject2	Object
    //   70	219	8	localPattern1	Pattern
    //   77	138	9	localPattern2	Pattern
    //   84	222	10	localPattern3	Pattern
    //   98	45	11	localSimpleDateFormat	java.text.SimpleDateFormat
    //   113	343	12	localObject3	Object
    //   329	65	13	localObject4	Object
    // Exception table:
    //   from	to	target	type
    //   202	207	208	java/io/IOException
    //   263	268	269	java/io/IOException
    //   59	100	431	java/lang/Exception
    //   100	115	431	java/lang/Exception
    //   120	197	431	java/lang/Exception
    //   214	258	431	java/lang/Exception
    //   275	296	431	java/lang/Exception
    //   310	428	431	java/lang/Exception
    //   454	479	431	java/lang/Exception
    //   443	447	448	java/io/IOException
    //   484	489	490	java/io/IOException
    //   496	501	502	java/io/IOException
    //   41	59	508	finally
    //   515	519	521	java/io/IOException
    //   59	100	529	finally
    //   100	115	529	finally
    //   120	197	529	finally
    //   214	258	529	finally
    //   275	296	529	finally
    //   310	428	529	finally
    //   454	479	529	finally
    //   435	439	536	finally
    //   41	59	546	java/lang/Exception
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
  
  public final String a()
  {
    return this.a;
  }
  
  public final void a(int paramInt)
  {
    this.e = paramInt;
  }
  
  public final void a(long paramLong)
  {
    this.b = paramLong;
  }
  
  public final void a(String paramString)
  {
    this.a = paramString;
  }
  
  public final long b()
  {
    return this.b;
  }
  
  public final void b(String paramString)
  {
    this.c = paramString;
  }
  
  public final int c()
  {
    return this.e;
  }
  
  public final void c(String paramString)
  {
    this.d = paramString;
  }
  
  public final String d()
  {
    return this.c;
  }
  
  public final String e()
  {
    return this.d;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.qqlite\classes.jar
 * Qualified Name:     com.tencent.feedback.anr.a
 * JD-Core Version:    0.7.0.1
 */