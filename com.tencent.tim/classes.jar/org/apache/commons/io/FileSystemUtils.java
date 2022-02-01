package org.apache.commons.io;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;

@Deprecated
public class FileSystemUtils
{
  private static final String DF;
  private static final int INIT_PROBLEM = -1;
  private static final FileSystemUtils INSTANCE;
  private static final int OS;
  private static final int OTHER = 0;
  private static final int POSIX_UNIX = 3;
  private static final int UNIX = 2;
  private static final int WINDOWS = 1;
  
  static
  {
    int j = 3;
    INSTANCE = new FileSystemUtils();
    String str3 = "df";
    int i;
    String str2;
    try
    {
      String str1 = System.getProperty("os.name");
      if (str1 == null) {
        throw new IOException("os.name not found");
      }
    }
    catch (Exception localException)
    {
      i = -1;
      str2 = str3;
    }
    for (;;)
    {
      OS = i;
      DF = str2;
      return;
      String str4 = str2.toLowerCase(Locale.ENGLISH);
      if (str4.contains("windows"))
      {
        i = 1;
        str2 = str3;
      }
      else
      {
        if ((!str4.contains("linux")) && (!str4.contains("mpe/ix")) && (!str4.contains("freebsd")) && (!str4.contains("openbsd")) && (!str4.contains("irix")) && (!str4.contains("digital unix")) && (!str4.contains("unix")) && (!str4.contains("mac os x")))
        {
          if ((!str4.contains("sun os")) && (!str4.contains("sunos")) && (!str4.contains("solaris")))
          {
            str2 = str3;
            i = j;
            if (str4.contains("hp-ux")) {
              continue;
            }
            boolean bool = str4.contains("aix");
            str2 = str3;
            i = j;
            if (bool) {
              continue;
            }
            i = 0;
            str2 = str3;
          }
        }
        else
        {
          i = 2;
          str2 = str3;
          continue;
        }
        str2 = "/usr/xpg4/bin/df";
        i = j;
      }
    }
  }
  
  @Deprecated
  public static long freeSpace(String paramString)
    throws IOException
  {
    return INSTANCE.freeSpaceOS(paramString, OS, false, -1L);
  }
  
  @Deprecated
  public static long freeSpaceKb()
    throws IOException
  {
    return freeSpaceKb(-1L);
  }
  
  @Deprecated
  public static long freeSpaceKb(long paramLong)
    throws IOException
  {
    return freeSpaceKb(new File(".").getAbsolutePath(), paramLong);
  }
  
  @Deprecated
  public static long freeSpaceKb(String paramString)
    throws IOException
  {
    return freeSpaceKb(paramString, -1L);
  }
  
  @Deprecated
  public static long freeSpaceKb(String paramString, long paramLong)
    throws IOException
  {
    return INSTANCE.freeSpaceOS(paramString, OS, true, paramLong);
  }
  
  long freeSpaceOS(String paramString, int paramInt, boolean paramBoolean, long paramLong)
    throws IOException
  {
    if (paramString == null) {
      throw new IllegalArgumentException("Path must not be null");
    }
    switch (paramInt)
    {
    default: 
      throw new IllegalStateException("Exception caught when determining operating system");
    case 1: 
      if (paramBoolean) {
        return freeSpaceWindows(paramString, paramLong) / 1024L;
      }
      return freeSpaceWindows(paramString, paramLong);
    case 2: 
      return freeSpaceUnix(paramString, paramBoolean, false, paramLong);
    case 3: 
      return freeSpaceUnix(paramString, paramBoolean, true, paramLong);
    }
    throw new IllegalStateException("Unsupported operating system");
  }
  
  long freeSpaceUnix(String paramString, boolean paramBoolean1, boolean paramBoolean2, long paramLong)
    throws IOException
  {
    if (paramString.isEmpty()) {
      throw new IllegalArgumentException("Path must not be empty");
    }
    Object localObject1 = "-";
    if (paramBoolean1) {
      localObject1 = "-" + "k";
    }
    Object localObject2 = localObject1;
    if (paramBoolean2) {
      localObject2 = (String)localObject1 + "P";
    }
    if (((String)localObject2).length() > 1) {
      localObject1 = new String[] { DF, localObject2, paramString };
    }
    for (;;)
    {
      localObject2 = performCommand((String[])localObject1, 3, paramLong);
      if (((List)localObject2).size() >= 2) {
        break;
      }
      throw new IOException("Command line '" + DF + "' did not return info as expected for path '" + paramString + "'- response was " + localObject2);
      localObject1 = new String[2];
      localObject1[0] = DF;
      localObject1[1] = paramString;
    }
    localObject1 = new StringTokenizer((String)((List)localObject2).get(1), " ");
    if (((StringTokenizer)localObject1).countTokens() < 4) {
      if ((((StringTokenizer)localObject1).countTokens() == 1) && (((List)localObject2).size() >= 3)) {
        localObject1 = new StringTokenizer((String)((List)localObject2).get(2), " ");
      }
    }
    for (;;)
    {
      ((StringTokenizer)localObject1).nextToken();
      ((StringTokenizer)localObject1).nextToken();
      return parseBytes(((StringTokenizer)localObject1).nextToken(), paramString);
      throw new IOException("Command line '" + DF + "' did not return data as expected for path '" + paramString + "'- check path is valid");
      ((StringTokenizer)localObject1).nextToken();
    }
  }
  
  long freeSpaceWindows(String paramString, long paramLong)
    throws IOException
  {
    Object localObject = FilenameUtils.normalize(paramString, false);
    if (localObject == null) {
      throw new IllegalArgumentException(paramString);
    }
    if ((((String)localObject).length() > 0) && (((String)localObject).charAt(0) != '"')) {}
    for (paramString = "\"" + (String)localObject + "\"";; paramString = (String)localObject)
    {
      localObject = performCommand(new String[] { "cmd.exe", "/C", "dir /a /-c " + paramString }, 2147483647, paramLong);
      int i = ((List)localObject).size() - 1;
      while (i >= 0)
      {
        String str = (String)((List)localObject).get(i);
        if (str.length() > 0) {
          return parseDir(str, paramString);
        }
        i -= 1;
      }
      throw new IOException("Command line 'dir /-c' did not return any info for path '" + paramString + "'");
    }
  }
  
  Process openProcess(String[] paramArrayOfString)
    throws IOException
  {
    return Runtime.getRuntime().exec(paramArrayOfString);
  }
  
  long parseBytes(String paramString1, String paramString2)
    throws IOException
  {
    long l;
    try
    {
      l = Long.parseLong(paramString1);
      if (l < 0L) {
        throw new IOException("Command line '" + DF + "' did not find free space in response for path '" + paramString2 + "'- check path is valid");
      }
    }
    catch (NumberFormatException paramString1)
    {
      throw new IOException("Command line '" + DF + "' did not return numeric data as expected for path '" + paramString2 + "'- check path is valid", paramString1);
    }
    return l;
  }
  
  long parseDir(String paramString1, String paramString2)
    throws IOException
  {
    int m = 0;
    int i = paramString1.length() - 1;
    int j;
    if (i >= 0) {
      if (Character.isDigit(paramString1.charAt(i))) {
        j = i + 1;
      }
    }
    for (;;)
    {
      label34:
      if (i >= 0)
      {
        char c = paramString1.charAt(i);
        if ((Character.isDigit(c)) || (c == ',') || (c == '.')) {}
      }
      for (int k = i + 1;; k = 0)
      {
        if (i < 0)
        {
          throw new IOException("Command line 'dir /-c' did not return valid info for path '" + paramString2 + "'");
          i -= 1;
          break;
          i -= 1;
          break label34;
        }
        paramString1 = new StringBuilder(paramString1.substring(k, j));
        for (i = m; i < paramString1.length(); i = j + 1) {
          if (paramString1.charAt(i) != ',')
          {
            j = i;
            if (paramString1.charAt(i) != '.') {}
          }
          else
          {
            paramString1.deleteCharAt(i);
            j = i - 1;
          }
        }
        return parseBytes(paramString1.toString(), paramString2);
      }
      j = 0;
    }
  }
  
  /* Error */
  List<String> performCommand(String[] paramArrayOfString, int paramInt, long paramLong)
    throws IOException
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 6
    //   3: aconst_null
    //   4: astore 12
    //   6: new 290	java/util/ArrayList
    //   9: dup
    //   10: bipush 20
    //   12: invokespecial 293	java/util/ArrayList:<init>	(I)V
    //   15: astore 13
    //   17: lload_3
    //   18: invokestatic 299	org/apache/commons/io/ThreadMonitor:start	(J)Ljava/lang/Thread;
    //   21: astore 11
    //   23: aload_0
    //   24: aload_1
    //   25: invokevirtual 301	org/apache/commons/io/FileSystemUtils:openProcess	([Ljava/lang/String;)Ljava/lang/Process;
    //   28: astore 9
    //   30: aload 9
    //   32: invokevirtual 307	java/lang/Process:getInputStream	()Ljava/io/InputStream;
    //   35: astore 8
    //   37: aload 9
    //   39: invokevirtual 311	java/lang/Process:getOutputStream	()Ljava/io/OutputStream;
    //   42: astore 7
    //   44: aload 9
    //   46: invokevirtual 314	java/lang/Process:getErrorStream	()Ljava/io/InputStream;
    //   49: astore 5
    //   51: new 316	java/io/BufferedReader
    //   54: dup
    //   55: new 318	java/io/InputStreamReader
    //   58: dup
    //   59: aload 8
    //   61: invokestatic 324	java/nio/charset/Charset:defaultCharset	()Ljava/nio/charset/Charset;
    //   64: invokespecial 327	java/io/InputStreamReader:<init>	(Ljava/io/InputStream;Ljava/nio/charset/Charset;)V
    //   67: invokespecial 330	java/io/BufferedReader:<init>	(Ljava/io/Reader;)V
    //   70: astore 10
    //   72: aload 10
    //   74: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   77: astore 6
    //   79: aload 6
    //   81: ifnull +43 -> 124
    //   84: aload 13
    //   86: invokeinterface 182 1 0
    //   91: iload_2
    //   92: if_icmpge +32 -> 124
    //   95: aload 13
    //   97: aload 6
    //   99: getstatic 57	java/util/Locale:ENGLISH	Ljava/util/Locale;
    //   102: invokevirtual 63	java/lang/String:toLowerCase	(Ljava/util/Locale;)Ljava/lang/String;
    //   105: invokevirtual 336	java/lang/String:trim	()Ljava/lang/String;
    //   108: invokeinterface 340 2 0
    //   113: pop
    //   114: aload 10
    //   116: invokevirtual 333	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   119: astore 6
    //   121: goto -42 -> 79
    //   124: aload 9
    //   126: invokevirtual 343	java/lang/Process:waitFor	()I
    //   129: pop
    //   130: aload 11
    //   132: invokestatic 347	org/apache/commons/io/ThreadMonitor:stop	(Ljava/lang/Thread;)V
    //   135: aload 9
    //   137: invokevirtual 350	java/lang/Process:exitValue	()I
    //   140: ifeq +134 -> 274
    //   143: new 42	java/io/IOException
    //   146: dup
    //   147: new 157	java/lang/StringBuilder
    //   150: dup
    //   151: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   154: ldc_w 352
    //   157: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   160: aload 9
    //   162: invokevirtual 350	java/lang/Process:exitValue	()I
    //   165: invokevirtual 354	java/lang/StringBuilder:append	(I)Ljava/lang/StringBuilder;
    //   168: ldc_w 356
    //   171: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   174: aload_1
    //   175: invokestatic 362	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   178: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   181: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   184: invokespecial 47	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   187: athrow
    //   188: astore 6
    //   190: new 42	java/io/IOException
    //   193: dup
    //   194: new 157	java/lang/StringBuilder
    //   197: dup
    //   198: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   201: ldc_w 364
    //   204: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   207: aload_1
    //   208: invokestatic 362	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   211: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   214: ldc_w 366
    //   217: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   220: lload_3
    //   221: invokevirtual 369	java/lang/StringBuilder:append	(J)Ljava/lang/StringBuilder;
    //   224: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   227: aload 6
    //   229: invokespecial 267	java/io/IOException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   232: athrow
    //   233: astore_1
    //   234: aload 5
    //   236: astore 6
    //   238: aload 10
    //   240: astore 5
    //   242: aload 8
    //   244: invokestatic 375	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   247: aload 7
    //   249: invokestatic 378	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   252: aload 6
    //   254: invokestatic 375	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   257: aload 5
    //   259: invokestatic 380	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   262: aload 9
    //   264: ifnull +8 -> 272
    //   267: aload 9
    //   269: invokevirtual 383	java/lang/Process:destroy	()V
    //   272: aload_1
    //   273: athrow
    //   274: aload 13
    //   276: invokeinterface 384 1 0
    //   281: ifeq +34 -> 315
    //   284: new 42	java/io/IOException
    //   287: dup
    //   288: new 157	java/lang/StringBuilder
    //   291: dup
    //   292: invokespecial 158	java/lang/StringBuilder:<init>	()V
    //   295: ldc_w 386
    //   298: invokevirtual 162	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   301: aload_1
    //   302: invokestatic 362	java/util/Arrays:asList	([Ljava/lang/Object;)Ljava/util/List;
    //   305: invokevirtual 191	java/lang/StringBuilder:append	(Ljava/lang/Object;)Ljava/lang/StringBuilder;
    //   308: invokevirtual 167	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   311: invokespecial 47	java/io/IOException:<init>	(Ljava/lang/String;)V
    //   314: athrow
    //   315: aload 10
    //   317: invokevirtual 389	java/io/BufferedReader:close	()V
    //   320: aload 8
    //   322: invokevirtual 392	java/io/InputStream:close	()V
    //   325: aload 7
    //   327: astore 6
    //   329: aload 7
    //   331: ifnull +19 -> 350
    //   334: aload 7
    //   336: astore 8
    //   338: aload 7
    //   340: astore 11
    //   342: aload 7
    //   344: invokevirtual 395	java/io/OutputStream:close	()V
    //   347: aconst_null
    //   348: astore 6
    //   350: aload 5
    //   352: astore 7
    //   354: aload 5
    //   356: ifnull +19 -> 375
    //   359: aload 6
    //   361: astore 8
    //   363: aload 6
    //   365: astore 11
    //   367: aload 5
    //   369: invokevirtual 392	java/io/InputStream:close	()V
    //   372: aconst_null
    //   373: astore 7
    //   375: aconst_null
    //   376: invokestatic 375	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   379: aload 6
    //   381: invokestatic 378	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/OutputStream;)V
    //   384: aload 7
    //   386: invokestatic 375	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/InputStream;)V
    //   389: aconst_null
    //   390: invokestatic 380	org/apache/commons/io/IOUtils:closeQuietly	(Ljava/io/Reader;)V
    //   393: aload 9
    //   395: ifnull +8 -> 403
    //   398: aload 9
    //   400: invokevirtual 383	java/lang/Process:destroy	()V
    //   403: aload 13
    //   405: areturn
    //   406: astore_1
    //   407: aconst_null
    //   408: astore 5
    //   410: aconst_null
    //   411: astore 7
    //   413: aconst_null
    //   414: astore 8
    //   416: aconst_null
    //   417: astore 9
    //   419: goto -177 -> 242
    //   422: astore_1
    //   423: aconst_null
    //   424: astore 5
    //   426: aconst_null
    //   427: astore 7
    //   429: aconst_null
    //   430: astore 8
    //   432: goto -190 -> 242
    //   435: astore_1
    //   436: aconst_null
    //   437: astore 5
    //   439: aconst_null
    //   440: astore 7
    //   442: goto -200 -> 242
    //   445: astore_1
    //   446: aconst_null
    //   447: astore 5
    //   449: goto -207 -> 242
    //   452: astore_1
    //   453: aconst_null
    //   454: astore 10
    //   456: aload 5
    //   458: astore 6
    //   460: aload 10
    //   462: astore 5
    //   464: goto -222 -> 242
    //   467: astore_1
    //   468: aconst_null
    //   469: astore 10
    //   471: aconst_null
    //   472: astore 7
    //   474: aload 5
    //   476: astore 6
    //   478: aload 7
    //   480: astore 5
    //   482: aload 8
    //   484: astore 7
    //   486: aload 10
    //   488: astore 8
    //   490: goto -248 -> 242
    //   493: astore 6
    //   495: aconst_null
    //   496: astore 5
    //   498: aconst_null
    //   499: astore 7
    //   501: aconst_null
    //   502: astore 8
    //   504: aconst_null
    //   505: astore 9
    //   507: aload 12
    //   509: astore 10
    //   511: goto -321 -> 190
    //   514: astore 6
    //   516: aconst_null
    //   517: astore 5
    //   519: aconst_null
    //   520: astore 7
    //   522: aconst_null
    //   523: astore 8
    //   525: aload 12
    //   527: astore 10
    //   529: goto -339 -> 190
    //   532: astore 6
    //   534: aconst_null
    //   535: astore 5
    //   537: aconst_null
    //   538: astore 7
    //   540: aload 12
    //   542: astore 10
    //   544: goto -354 -> 190
    //   547: astore 6
    //   549: aconst_null
    //   550: astore 5
    //   552: aload 12
    //   554: astore 10
    //   556: goto -366 -> 190
    //   559: astore 6
    //   561: aload 12
    //   563: astore 10
    //   565: goto -375 -> 190
    //   568: astore 6
    //   570: aconst_null
    //   571: astore 8
    //   573: aload 12
    //   575: astore 10
    //   577: aload 11
    //   579: astore 7
    //   581: goto -391 -> 190
    //   584: astore_1
    //   585: aload 5
    //   587: astore 6
    //   589: aload 10
    //   591: astore 5
    //   593: goto -351 -> 242
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	596	0	this	FileSystemUtils
    //   0	596	1	paramArrayOfString	String[]
    //   0	596	2	paramInt	int
    //   0	596	3	paramLong	long
    //   49	543	5	localObject1	Object
    //   1	119	6	str	String
    //   188	40	6	localInterruptedException1	java.lang.InterruptedException
    //   236	241	6	localObject2	Object
    //   493	1	6	localInterruptedException2	java.lang.InterruptedException
    //   514	1	6	localInterruptedException3	java.lang.InterruptedException
    //   532	1	6	localInterruptedException4	java.lang.InterruptedException
    //   547	1	6	localInterruptedException5	java.lang.InterruptedException
    //   559	1	6	localInterruptedException6	java.lang.InterruptedException
    //   568	1	6	localInterruptedException7	java.lang.InterruptedException
    //   587	1	6	localObject3	Object
    //   42	538	7	localObject4	Object
    //   35	537	8	localObject5	Object
    //   28	478	9	localProcess	Process
    //   70	520	10	localObject6	Object
    //   21	557	11	localObject7	Object
    //   4	570	12	localObject8	Object
    //   15	389	13	localArrayList	java.util.ArrayList
    // Exception table:
    //   from	to	target	type
    //   72	79	188	java/lang/InterruptedException
    //   84	121	188	java/lang/InterruptedException
    //   124	188	188	java/lang/InterruptedException
    //   274	315	188	java/lang/InterruptedException
    //   315	320	188	java/lang/InterruptedException
    //   190	233	233	finally
    //   17	30	406	finally
    //   30	37	422	finally
    //   37	44	435	finally
    //   44	51	445	finally
    //   51	72	452	finally
    //   320	325	452	finally
    //   342	347	467	finally
    //   367	372	467	finally
    //   17	30	493	java/lang/InterruptedException
    //   30	37	514	java/lang/InterruptedException
    //   37	44	532	java/lang/InterruptedException
    //   44	51	547	java/lang/InterruptedException
    //   51	72	559	java/lang/InterruptedException
    //   320	325	559	java/lang/InterruptedException
    //   342	347	568	java/lang/InterruptedException
    //   367	372	568	java/lang/InterruptedException
    //   72	79	584	finally
    //   84	121	584	finally
    //   124	188	584	finally
    //   274	315	584	finally
    //   315	320	584	finally
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.FileSystemUtils
 * JD-Core Version:    0.7.0.1
 */