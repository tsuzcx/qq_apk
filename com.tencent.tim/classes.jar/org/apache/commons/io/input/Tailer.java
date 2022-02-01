package org.apache.commons.io.input;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.charset.Charset;

public class Tailer
  implements Runnable
{
  private static final int DEFAULT_BUFSIZE = 4096;
  private static final Charset DEFAULT_CHARSET = ;
  private static final int DEFAULT_DELAY_MILLIS = 1000;
  private static final String RAF_MODE = "r";
  private final Charset cset;
  private final long delayMillis;
  private final boolean end;
  private final File file;
  private final byte[] inbuf;
  private final TailerListener listener;
  private final boolean reOpen;
  private volatile boolean run = true;
  
  public Tailer(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this.file = paramFile;
    this.delayMillis = paramLong;
    this.end = paramBoolean1;
    this.inbuf = new byte[paramInt];
    this.listener = paramTailerListener;
    paramTailerListener.init(this);
    this.reOpen = paramBoolean2;
    this.cset = paramCharset;
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener)
  {
    this(paramFile, paramTailerListener, 1000L);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    this(paramFile, paramTailerListener, paramLong, false);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    this(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public Tailer(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    this(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
  }
  
  public static Tailer create(File paramFile, Charset paramCharset, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    paramFile = new Tailer(paramFile, paramCharset, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
    paramCharset = new Thread(paramFile);
    paramCharset.setDaemon(true);
    paramCharset.start();
    return paramFile;
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener)
  {
    return create(paramFile, paramTailerListener, 1000L, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong)
  {
    return create(paramFile, paramTailerListener, paramLong, false);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean, int paramInt)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean, false, paramInt);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2)
  {
    return create(paramFile, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, 4096);
  }
  
  public static Tailer create(File paramFile, TailerListener paramTailerListener, long paramLong, boolean paramBoolean1, boolean paramBoolean2, int paramInt)
  {
    return create(paramFile, DEFAULT_CHARSET, paramTailerListener, paramLong, paramBoolean1, paramBoolean2, paramInt);
  }
  
  private long readLines(RandomAccessFile paramRandomAccessFile)
    throws IOException
  {
    ByteArrayOutputStream localByteArrayOutputStream = new ByteArrayOutputStream(64);
    Object localObject = null;
    int i;
    int k;
    for (;;)
    {
      try
      {
        l1 = paramRandomAccessFile.getFilePointer();
        i = 0;
        l2 = l1;
        if (!getRun()) {
          continue;
        }
        int m = paramRandomAccessFile.read(this.inbuf);
        if (m == -1) {
          continue;
        }
        k = 0;
        if (k >= m) {
          continue;
        }
        n = this.inbuf[k];
        switch (n)
        {
        }
      }
      catch (Throwable localThrowable1)
      {
        try
        {
          long l1;
          long l2;
          int n;
          int j;
          throw localThrowable1;
        }
        finally
        {
          if ((localByteArrayOutputStream != null) && (localThrowable1 == null)) {
            continue;
          }
          try
          {
            localByteArrayOutputStream.close();
            throw paramRandomAccessFile;
          }
          catch (Throwable localThrowable2)
          {
            localThrowable1.addSuppressed(localThrowable2);
            continue;
          }
          localThrowable2.close();
        }
      }
      finally
      {
        continue;
        continue;
      }
      j = i;
      if (i != 0)
      {
        j = 0;
        this.listener.handle(new String(localByteArrayOutputStream.toByteArray(), this.cset));
        localByteArrayOutputStream.reset();
        l1 = k + l2 + 1L;
      }
      localByteArrayOutputStream.write(n);
      i = j;
      break label338;
      i = 0;
      this.listener.handle(new String(localByteArrayOutputStream.toByteArray(), this.cset));
      localByteArrayOutputStream.reset();
      l1 = k + l2 + 1L;
      break label338;
      if (i == 0) {
        break label347;
      }
      localByteArrayOutputStream.write(13);
      break label347;
      l2 = paramRandomAccessFile.getFilePointer();
      continue;
      paramRandomAccessFile.seek(l1);
      if ((this.listener instanceof TailerListenerAdapter)) {
        ((TailerListenerAdapter)this.listener).endOfFileReached();
      }
      if ((localByteArrayOutputStream == null) || (0 != 0)) {
        try
        {
          localByteArrayOutputStream.close();
          return l1;
        }
        catch (Throwable paramRandomAccessFile)
        {
          throw new NullPointerException();
        }
      }
      localByteArrayOutputStream.close();
      return l1;
    }
    for (;;)
    {
      label338:
      k += 1;
      break;
      label347:
      i = 1;
    }
  }
  
  public long getDelay()
  {
    return this.delayMillis;
  }
  
  public File getFile()
  {
    return this.file;
  }
  
  protected boolean getRun()
  {
    return this.run;
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: lconst_0
    //   1: lstore 5
    //   3: lconst_0
    //   4: lstore 7
    //   6: aconst_null
    //   7: astore 12
    //   9: aload 12
    //   11: astore 13
    //   13: aload 12
    //   15: astore 14
    //   17: aload 12
    //   19: astore 11
    //   21: aload_0
    //   22: invokevirtual 134	org/apache/commons/io/input/Tailer:getRun	()Z
    //   25: istore 9
    //   27: aload 12
    //   29: astore 10
    //   31: lload 5
    //   33: lstore_1
    //   34: lload 7
    //   36: lstore_3
    //   37: iload 9
    //   39: ifeq +268 -> 307
    //   42: aload 12
    //   44: astore 10
    //   46: lload 5
    //   48: lstore_1
    //   49: lload 7
    //   51: lstore_3
    //   52: aload 12
    //   54: ifnonnull +253 -> 307
    //   57: aload 12
    //   59: astore 13
    //   61: aload 12
    //   63: astore 14
    //   65: aload 12
    //   67: astore 11
    //   69: new 126	java/io/RandomAccessFile
    //   72: dup
    //   73: aload_0
    //   74: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   77: ldc 17
    //   79: invokespecial 189	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   82: astore 10
    //   84: aload 10
    //   86: astore 12
    //   88: aload 12
    //   90: ifnonnull +133 -> 223
    //   93: aload 12
    //   95: astore 13
    //   97: aload 12
    //   99: astore 14
    //   101: aload 12
    //   103: astore 11
    //   105: aload_0
    //   106: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   109: invokestatic 192	java/lang/Thread:sleep	(J)V
    //   112: goto -103 -> 9
    //   115: astore 12
    //   117: aload 13
    //   119: astore 10
    //   121: aload 10
    //   123: astore 11
    //   125: invokestatic 196	java/lang/Thread:currentThread	()Ljava/lang/Thread;
    //   128: invokevirtual 199	java/lang/Thread:interrupt	()V
    //   131: aload 10
    //   133: astore 11
    //   135: aload_0
    //   136: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   139: aload 12
    //   141: invokeinterface 202 2 0
    //   146: aload 10
    //   148: ifnull +8 -> 156
    //   151: aload 10
    //   153: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   156: aload_0
    //   157: invokevirtual 206	org/apache/commons/io/input/Tailer:stop	()V
    //   160: return
    //   161: astore 10
    //   163: aload 12
    //   165: astore 13
    //   167: aload 12
    //   169: astore 14
    //   171: aload 12
    //   173: astore 11
    //   175: aload_0
    //   176: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   179: invokeinterface 209 1 0
    //   184: goto -96 -> 88
    //   187: astore 12
    //   189: aload 14
    //   191: astore 10
    //   193: aload 10
    //   195: astore 11
    //   197: aload_0
    //   198: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   201: aload 12
    //   203: invokeinterface 202 2 0
    //   208: aload 10
    //   210: ifnull +8 -> 218
    //   213: aload 10
    //   215: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   218: aload_0
    //   219: invokevirtual 206	org/apache/commons/io/input/Tailer:stop	()V
    //   222: return
    //   223: aload 12
    //   225: astore 13
    //   227: aload 12
    //   229: astore 14
    //   231: aload 12
    //   233: astore 11
    //   235: aload_0
    //   236: getfield 53	org/apache/commons/io/input/Tailer:end	Z
    //   239: ifeq +845 -> 1084
    //   242: aload 12
    //   244: astore 13
    //   246: aload 12
    //   248: astore 14
    //   250: aload 12
    //   252: astore 11
    //   254: aload_0
    //   255: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   258: invokevirtual 214	java/io/File:length	()J
    //   261: lstore_1
    //   262: aload 12
    //   264: astore 13
    //   266: aload 12
    //   268: astore 14
    //   270: aload 12
    //   272: astore 11
    //   274: aload_0
    //   275: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   278: invokevirtual 217	java/io/File:lastModified	()J
    //   281: lstore 7
    //   283: aload 12
    //   285: astore 13
    //   287: aload 12
    //   289: astore 14
    //   291: aload 12
    //   293: astore 11
    //   295: aload 12
    //   297: lload_1
    //   298: invokevirtual 161	java/io/RandomAccessFile:seek	(J)V
    //   301: lload_1
    //   302: lstore 5
    //   304: goto -295 -> 9
    //   307: aload 10
    //   309: astore 13
    //   311: aload 10
    //   313: astore 14
    //   315: aload 10
    //   317: astore 11
    //   319: aload_0
    //   320: invokevirtual 134	org/apache/commons/io/input/Tailer:getRun	()Z
    //   323: ifeq +582 -> 905
    //   326: aload 10
    //   328: astore 13
    //   330: aload 10
    //   332: astore 14
    //   334: aload 10
    //   336: astore 11
    //   338: aload_0
    //   339: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   342: lload_3
    //   343: invokestatic 223	org/apache/commons/io/FileUtils:isFileNewer	(Ljava/io/File;J)Z
    //   346: istore 9
    //   348: aload 10
    //   350: astore 13
    //   352: aload 10
    //   354: astore 14
    //   356: aload 10
    //   358: astore 11
    //   360: aload_0
    //   361: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   364: invokevirtual 214	java/io/File:length	()J
    //   367: lstore 5
    //   369: lload 5
    //   371: lload_1
    //   372: lcmp
    //   373: ifge +287 -> 660
    //   376: aload 10
    //   378: astore 13
    //   380: aload 10
    //   382: astore 14
    //   384: aload 10
    //   386: astore 11
    //   388: aload_0
    //   389: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   392: invokeinterface 226 1 0
    //   397: new 126	java/io/RandomAccessFile
    //   400: dup
    //   401: aload_0
    //   402: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   405: ldc 17
    //   407: invokespecial 189	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   410: astore 11
    //   412: aload_0
    //   413: aload 10
    //   415: invokespecial 228	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   418: pop2
    //   419: aload 10
    //   421: ifnull +12 -> 433
    //   424: iconst_0
    //   425: ifeq +165 -> 590
    //   428: aload 10
    //   430: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   433: lconst_0
    //   434: lstore_1
    //   435: aload 11
    //   437: astore 10
    //   439: goto -132 -> 307
    //   442: astore 12
    //   444: aload_0
    //   445: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   448: aload 12
    //   450: invokeinterface 202 2 0
    //   455: goto -36 -> 419
    //   458: astore 13
    //   460: aload 11
    //   462: astore 12
    //   464: aload 13
    //   466: astore 11
    //   468: aload 11
    //   470: athrow
    //   471: astore 15
    //   473: aload 12
    //   475: astore 14
    //   477: aload 11
    //   479: astore 13
    //   481: aload 15
    //   483: astore 12
    //   485: aload 14
    //   487: astore 11
    //   489: aload 10
    //   491: ifnull +25 -> 516
    //   494: aload 13
    //   496: ifnull +135 -> 631
    //   499: aload 11
    //   501: astore 14
    //   503: aload 11
    //   505: astore 15
    //   507: aload 11
    //   509: astore 16
    //   511: aload 10
    //   513: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   516: aload 11
    //   518: astore 14
    //   520: aload 11
    //   522: astore 15
    //   524: aload 11
    //   526: astore 16
    //   528: aload 12
    //   530: athrow
    //   531: astore 10
    //   533: aload 11
    //   535: astore 14
    //   537: aload 11
    //   539: astore 15
    //   541: aload 11
    //   543: astore 16
    //   545: aload_0
    //   546: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   549: invokeinterface 209 1 0
    //   554: aload 11
    //   556: astore 14
    //   558: aload 11
    //   560: astore 15
    //   562: aload 11
    //   564: astore 16
    //   566: aload_0
    //   567: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   570: invokestatic 192	java/lang/Thread:sleep	(J)V
    //   573: aload 11
    //   575: astore 10
    //   577: goto -270 -> 307
    //   580: astore 10
    //   582: new 171	java/lang/NullPointerException
    //   585: dup
    //   586: invokespecial 172	java/lang/NullPointerException:<init>	()V
    //   589: athrow
    //   590: aload 10
    //   592: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   595: goto -162 -> 433
    //   598: astore 12
    //   600: aload 11
    //   602: astore 10
    //   604: goto -483 -> 121
    //   607: astore 10
    //   609: aload 11
    //   611: astore 14
    //   613: aload 11
    //   615: astore 15
    //   617: aload 11
    //   619: astore 16
    //   621: aload 13
    //   623: aload 10
    //   625: invokevirtual 176	java/lang/Throwable:addSuppressed	(Ljava/lang/Throwable;)V
    //   628: goto -112 -> 516
    //   631: aload 11
    //   633: astore 14
    //   635: aload 11
    //   637: astore 15
    //   639: aload 11
    //   641: astore 16
    //   643: aload 10
    //   645: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   648: goto -132 -> 516
    //   651: astore 12
    //   653: aload 14
    //   655: astore 10
    //   657: goto -464 -> 193
    //   660: lload 5
    //   662: lload_1
    //   663: lcmp
    //   664: ifle +176 -> 840
    //   667: aload 10
    //   669: astore 13
    //   671: aload 10
    //   673: astore 14
    //   675: aload 10
    //   677: astore 11
    //   679: aload_0
    //   680: aload 10
    //   682: invokespecial 228	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   685: lstore_1
    //   686: aload 10
    //   688: astore 13
    //   690: aload 10
    //   692: astore 14
    //   694: aload 10
    //   696: astore 11
    //   698: aload_0
    //   699: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   702: invokevirtual 217	java/io/File:lastModified	()J
    //   705: lstore_3
    //   706: aload 10
    //   708: astore 13
    //   710: aload 10
    //   712: astore 14
    //   714: aload 10
    //   716: astore 11
    //   718: aload_0
    //   719: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   722: ifeq +25 -> 747
    //   725: aload 10
    //   727: ifnull +20 -> 747
    //   730: aload 10
    //   732: astore 13
    //   734: aload 10
    //   736: astore 14
    //   738: aload 10
    //   740: astore 11
    //   742: aload 10
    //   744: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   747: aload 10
    //   749: astore 13
    //   751: aload 10
    //   753: astore 14
    //   755: aload 10
    //   757: astore 11
    //   759: aload_0
    //   760: getfield 51	org/apache/commons/io/input/Tailer:delayMillis	J
    //   763: invokestatic 192	java/lang/Thread:sleep	(J)V
    //   766: aload 10
    //   768: astore 13
    //   770: aload 10
    //   772: astore 14
    //   774: aload 10
    //   776: astore 11
    //   778: aload_0
    //   779: invokevirtual 134	org/apache/commons/io/input/Tailer:getRun	()Z
    //   782: ifeq +296 -> 1078
    //   785: aload 10
    //   787: astore 13
    //   789: aload 10
    //   791: astore 14
    //   793: aload 10
    //   795: astore 11
    //   797: aload_0
    //   798: getfield 65	org/apache/commons/io/input/Tailer:reOpen	Z
    //   801: ifeq +277 -> 1078
    //   804: aload 10
    //   806: astore 13
    //   808: aload 10
    //   810: astore 14
    //   812: aload 10
    //   814: astore 11
    //   816: new 126	java/io/RandomAccessFile
    //   819: dup
    //   820: aload_0
    //   821: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   824: ldc 17
    //   826: invokespecial 189	java/io/RandomAccessFile:<init>	(Ljava/io/File;Ljava/lang/String;)V
    //   829: astore 10
    //   831: aload 10
    //   833: lload_1
    //   834: invokevirtual 161	java/io/RandomAccessFile:seek	(J)V
    //   837: goto -530 -> 307
    //   840: iload 9
    //   842: ifeq +239 -> 1081
    //   845: aload 10
    //   847: astore 13
    //   849: aload 10
    //   851: astore 14
    //   853: aload 10
    //   855: astore 11
    //   857: aload 10
    //   859: lconst_0
    //   860: invokevirtual 161	java/io/RandomAccessFile:seek	(J)V
    //   863: aload 10
    //   865: astore 13
    //   867: aload 10
    //   869: astore 14
    //   871: aload 10
    //   873: astore 11
    //   875: aload_0
    //   876: aload 10
    //   878: invokespecial 228	org/apache/commons/io/input/Tailer:readLines	(Ljava/io/RandomAccessFile;)J
    //   881: lstore_1
    //   882: aload 10
    //   884: astore 13
    //   886: aload 10
    //   888: astore 14
    //   890: aload 10
    //   892: astore 11
    //   894: aload_0
    //   895: getfield 49	org/apache/commons/io/input/Tailer:file	Ljava/io/File;
    //   898: invokevirtual 217	java/io/File:lastModified	()J
    //   901: lstore_3
    //   902: goto -196 -> 706
    //   905: aload 10
    //   907: ifnull +8 -> 915
    //   910: aload 10
    //   912: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   915: aload_0
    //   916: invokevirtual 206	org/apache/commons/io/input/Tailer:stop	()V
    //   919: return
    //   920: astore 10
    //   922: aload_0
    //   923: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   926: aload 10
    //   928: invokeinterface 202 2 0
    //   933: goto -18 -> 915
    //   936: astore 10
    //   938: aload_0
    //   939: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   942: aload 10
    //   944: invokeinterface 202 2 0
    //   949: goto -793 -> 156
    //   952: astore 10
    //   954: aload_0
    //   955: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   958: aload 10
    //   960: invokeinterface 202 2 0
    //   965: goto -747 -> 218
    //   968: astore 10
    //   970: aload 11
    //   972: ifnull +8 -> 980
    //   975: aload 11
    //   977: invokevirtual 203	java/io/RandomAccessFile:close	()V
    //   980: aload_0
    //   981: invokevirtual 206	org/apache/commons/io/input/Tailer:stop	()V
    //   984: aload 10
    //   986: athrow
    //   987: astore 11
    //   989: aload_0
    //   990: getfield 57	org/apache/commons/io/input/Tailer:listener	Lorg/apache/commons/io/input/TailerListener;
    //   993: aload 11
    //   995: invokeinterface 202 2 0
    //   1000: goto -20 -> 980
    //   1003: astore 10
    //   1005: goto -35 -> 970
    //   1008: astore 10
    //   1010: aload 15
    //   1012: astore 11
    //   1014: goto -44 -> 970
    //   1017: astore 12
    //   1019: aload 10
    //   1021: astore 11
    //   1023: aload 12
    //   1025: astore 10
    //   1027: goto -57 -> 970
    //   1030: astore 12
    //   1032: aload 11
    //   1034: astore 10
    //   1036: goto -843 -> 193
    //   1039: astore 12
    //   1041: goto -848 -> 193
    //   1044: astore 12
    //   1046: goto -925 -> 121
    //   1049: astore 12
    //   1051: aconst_null
    //   1052: astore 13
    //   1054: aload 10
    //   1056: astore 11
    //   1058: goto -569 -> 489
    //   1061: astore 12
    //   1063: aconst_null
    //   1064: astore 13
    //   1066: goto -577 -> 489
    //   1069: astore 11
    //   1071: aload 10
    //   1073: astore 12
    //   1075: goto -607 -> 468
    //   1078: goto -241 -> 837
    //   1081: goto -375 -> 706
    //   1084: lconst_0
    //   1085: lstore_1
    //   1086: goto -824 -> 262
    //   1089: astore 10
    //   1091: lconst_0
    //   1092: lstore_1
    //   1093: goto -560 -> 533
    //   1096: astore 12
    //   1098: aload 16
    //   1100: astore 10
    //   1102: goto -981 -> 121
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	1105	0	this	Tailer
    //   33	1060	1	l1	long
    //   36	866	3	l2	long
    //   1	660	5	l3	long
    //   4	278	7	l4	long
    //   25	816	9	bool	boolean
    //   29	123	10	localObject1	Object
    //   161	1	10	localFileNotFoundException1	java.io.FileNotFoundException
    //   191	321	10	localObject2	Object
    //   531	1	10	localFileNotFoundException2	java.io.FileNotFoundException
    //   575	1	10	localObject3	Object
    //   580	11	10	localThrowable1	Throwable
    //   602	1	10	localObject4	Object
    //   607	37	10	localThrowable2	Throwable
    //   655	256	10	localObject5	Object
    //   920	7	10	localIOException1	IOException
    //   936	7	10	localIOException2	IOException
    //   952	7	10	localIOException3	IOException
    //   968	17	10	localObject6	Object
    //   1003	1	10	localObject7	Object
    //   1008	12	10	localObject8	Object
    //   1025	47	10	localObject9	Object
    //   1089	1	10	localFileNotFoundException3	java.io.FileNotFoundException
    //   1100	1	10	localObject10	Object
    //   19	957	11	localObject11	Object
    //   987	7	11	localIOException4	IOException
    //   1012	45	11	localObject12	Object
    //   1069	1	11	localThrowable3	Throwable
    //   7	95	12	localObject13	Object
    //   115	57	12	localInterruptedException1	java.lang.InterruptedException
    //   187	109	12	localException1	java.lang.Exception
    //   442	7	12	localIOException5	IOException
    //   462	67	12	localObject14	Object
    //   598	1	12	localInterruptedException2	java.lang.InterruptedException
    //   651	1	12	localException2	java.lang.Exception
    //   1017	7	12	localObject15	Object
    //   1030	1	12	localException3	java.lang.Exception
    //   1039	1	12	localException4	java.lang.Exception
    //   1044	1	12	localInterruptedException3	java.lang.InterruptedException
    //   1049	1	12	localObject16	Object
    //   1061	1	12	localObject17	Object
    //   1073	1	12	localObject18	Object
    //   1096	1	12	localInterruptedException4	java.lang.InterruptedException
    //   11	368	13	localObject19	Object
    //   458	7	13	localThrowable4	Throwable
    //   479	586	13	localObject20	Object
    //   15	874	14	localObject21	Object
    //   471	11	15	localObject22	Object
    //   505	506	15	localObject23	Object
    //   509	590	16	localObject24	Object
    // Exception table:
    //   from	to	target	type
    //   21	27	115	java/lang/InterruptedException
    //   69	84	115	java/lang/InterruptedException
    //   105	112	115	java/lang/InterruptedException
    //   175	184	115	java/lang/InterruptedException
    //   235	242	115	java/lang/InterruptedException
    //   254	262	115	java/lang/InterruptedException
    //   274	283	115	java/lang/InterruptedException
    //   295	301	115	java/lang/InterruptedException
    //   319	326	115	java/lang/InterruptedException
    //   338	348	115	java/lang/InterruptedException
    //   360	369	115	java/lang/InterruptedException
    //   388	397	115	java/lang/InterruptedException
    //   679	686	115	java/lang/InterruptedException
    //   698	706	115	java/lang/InterruptedException
    //   718	725	115	java/lang/InterruptedException
    //   742	747	115	java/lang/InterruptedException
    //   759	766	115	java/lang/InterruptedException
    //   778	785	115	java/lang/InterruptedException
    //   797	804	115	java/lang/InterruptedException
    //   816	831	115	java/lang/InterruptedException
    //   857	863	115	java/lang/InterruptedException
    //   875	882	115	java/lang/InterruptedException
    //   894	902	115	java/lang/InterruptedException
    //   69	84	161	java/io/FileNotFoundException
    //   21	27	187	java/lang/Exception
    //   69	84	187	java/lang/Exception
    //   105	112	187	java/lang/Exception
    //   175	184	187	java/lang/Exception
    //   235	242	187	java/lang/Exception
    //   254	262	187	java/lang/Exception
    //   274	283	187	java/lang/Exception
    //   295	301	187	java/lang/Exception
    //   319	326	187	java/lang/Exception
    //   338	348	187	java/lang/Exception
    //   360	369	187	java/lang/Exception
    //   388	397	187	java/lang/Exception
    //   679	686	187	java/lang/Exception
    //   698	706	187	java/lang/Exception
    //   718	725	187	java/lang/Exception
    //   742	747	187	java/lang/Exception
    //   759	766	187	java/lang/Exception
    //   778	785	187	java/lang/Exception
    //   797	804	187	java/lang/Exception
    //   816	831	187	java/lang/Exception
    //   857	863	187	java/lang/Exception
    //   875	882	187	java/lang/Exception
    //   894	902	187	java/lang/Exception
    //   412	419	442	java/io/IOException
    //   412	419	458	java/lang/Throwable
    //   444	455	458	java/lang/Throwable
    //   468	471	471	finally
    //   511	516	531	java/io/FileNotFoundException
    //   528	531	531	java/io/FileNotFoundException
    //   621	628	531	java/io/FileNotFoundException
    //   643	648	531	java/io/FileNotFoundException
    //   428	433	580	java/lang/Throwable
    //   428	433	598	java/lang/InterruptedException
    //   582	590	598	java/lang/InterruptedException
    //   590	595	598	java/lang/InterruptedException
    //   511	516	607	java/lang/Throwable
    //   511	516	651	java/lang/Exception
    //   528	531	651	java/lang/Exception
    //   545	554	651	java/lang/Exception
    //   566	573	651	java/lang/Exception
    //   621	628	651	java/lang/Exception
    //   643	648	651	java/lang/Exception
    //   910	915	920	java/io/IOException
    //   151	156	936	java/io/IOException
    //   213	218	952	java/io/IOException
    //   21	27	968	finally
    //   69	84	968	finally
    //   105	112	968	finally
    //   125	131	968	finally
    //   135	146	968	finally
    //   175	184	968	finally
    //   197	208	968	finally
    //   235	242	968	finally
    //   254	262	968	finally
    //   274	283	968	finally
    //   295	301	968	finally
    //   319	326	968	finally
    //   338	348	968	finally
    //   360	369	968	finally
    //   388	397	968	finally
    //   679	686	968	finally
    //   698	706	968	finally
    //   718	725	968	finally
    //   742	747	968	finally
    //   759	766	968	finally
    //   778	785	968	finally
    //   797	804	968	finally
    //   816	831	968	finally
    //   857	863	968	finally
    //   875	882	968	finally
    //   894	902	968	finally
    //   975	980	987	java/io/IOException
    //   428	433	1003	finally
    //   582	590	1003	finally
    //   590	595	1003	finally
    //   511	516	1008	finally
    //   528	531	1008	finally
    //   545	554	1008	finally
    //   566	573	1008	finally
    //   621	628	1008	finally
    //   643	648	1008	finally
    //   831	837	1017	finally
    //   428	433	1030	java/lang/Exception
    //   582	590	1030	java/lang/Exception
    //   590	595	1030	java/lang/Exception
    //   831	837	1039	java/lang/Exception
    //   831	837	1044	java/lang/InterruptedException
    //   397	412	1049	finally
    //   412	419	1061	finally
    //   444	455	1061	finally
    //   397	412	1069	java/lang/Throwable
    //   428	433	1089	java/io/FileNotFoundException
    //   582	590	1089	java/io/FileNotFoundException
    //   590	595	1089	java/io/FileNotFoundException
    //   511	516	1096	java/lang/InterruptedException
    //   528	531	1096	java/lang/InterruptedException
    //   545	554	1096	java/lang/InterruptedException
    //   566	573	1096	java/lang/InterruptedException
    //   621	628	1096	java/lang/InterruptedException
    //   643	648	1096	java/lang/InterruptedException
  }
  
  public void stop()
  {
    this.run = false;
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     org.apache.commons.io.input.Tailer
 * JD-Core Version:    0.7.0.1
 */