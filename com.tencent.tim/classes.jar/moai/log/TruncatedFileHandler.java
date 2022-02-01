package moai.log;

import java.io.File;
import java.util.concurrent.LinkedBlockingQueue;

public class TruncatedFileHandler
  extends FileHandlerDelegate
  implements Runnable
{
  private volatile long fileSize = -1L;
  private Object lock = new Object();
  private long maxSize = -1L;
  private double truncateRatio = 0.5D;
  private LinkedBlockingQueue<FileHandler.LogData> truncatedCache = new LinkedBlockingQueue();
  private volatile boolean truncating = false;
  
  public TruncatedFileHandler(FileHandler paramFileHandler, long paramLong)
  {
    super(paramFileHandler);
    if (getFilename().indexOf('%') >= 0) {
      throw new IllegalArgumentException("not support");
    }
    this.maxSize = paramLong;
  }
  
  public TruncatedFileHandler(FileHandler paramFileHandler, long paramLong, double paramDouble)
  {
    this(paramFileHandler, paramLong);
    this.truncateRatio = paramDouble;
  }
  
  private void deleteAllOldTempFile()
  {
    File[] arrayOfFile = new File(getDirname()).listFiles();
    if (arrayOfFile != null)
    {
      int i = 0;
      while (i < arrayOfFile.length)
      {
        File localFile = arrayOfFile[i];
        if ((localFile != null) && (localFile.exists()) && (localFile.getName().endsWith(".tmp"))) {
          localFile.delete();
        }
        i += 1;
      }
    }
  }
  
  protected int onPrepareToWrite(FileHandler.LogData paramLogData)
  {
    synchronized (this.lock)
    {
      if (this.truncating)
      {
        this.truncatedCache.add(FileHandler.LogData.obtain(paramLogData));
        int i = paramLogData.sizeEstimated();
        return i;
      }
      if (this.truncatedCache.isEmpty()) {
        break label93;
      }
      while (this.truncatedCache.size() > 0)
      {
        ??? = (FileHandler.LogData)this.truncatedCache.poll();
        if (??? != null) {
          super.writeToFile((FileHandler.LogData)???);
        }
      }
    }
    this.truncatedCache.clear();
    label93:
    if (this.maxSize >= 0L) {
      if (this.fileSize < 0L) {
        this.fileSize = new File(getDirname() + File.separator + getFilename()).length();
      }
    }
    synchronized (this.lock)
    {
      this.fileSize += paramLogData.sizeEstimated();
      if ((this.fileSize > this.maxSize) && (!this.truncating))
      {
        this.truncating = true;
        this.fileSize = -1L;
        new Thread(this).start();
      }
      return super.onPrepareToWrite(paramLogData);
    }
  }
  
  /* Error */
  public void run()
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore 13
    //   3: aconst_null
    //   4: astore 12
    //   6: iconst_0
    //   7: istore_3
    //   8: iconst_0
    //   9: istore_2
    //   10: iconst_0
    //   11: istore_1
    //   12: new 71	java/io/File
    //   15: dup
    //   16: new 129	java/lang/StringBuilder
    //   19: dup
    //   20: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   23: aload_0
    //   24: invokevirtual 74	moai/log/TruncatedFileHandler:getDirname	()Ljava/lang/String;
    //   27: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   30: getstatic 138	java/io/File:separator	Ljava/lang/String;
    //   33: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   36: aload_0
    //   37: invokevirtual 51	moai/log/TruncatedFileHandler:getFilename	()Ljava/lang/String;
    //   40: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   43: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   46: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   49: astore 9
    //   51: aload 9
    //   53: invokevirtual 145	java/io/File:length	()J
    //   56: lstore 7
    //   58: aload_0
    //   59: getfield 31	moai/log/TruncatedFileHandler:maxSize	J
    //   62: lstore 5
    //   64: lload 7
    //   66: lload 5
    //   68: lcmp
    //   69: ifge +79 -> 148
    //   72: aload_0
    //   73: getfield 47	moai/log/TruncatedFileHandler:lock	Ljava/lang/Object;
    //   76: astore 10
    //   78: aload 10
    //   80: monitorenter
    //   81: iconst_0
    //   82: i2l
    //   83: lstore 5
    //   85: aload_0
    //   86: lload 5
    //   88: putfield 42	moai/log/TruncatedFileHandler:fileSize	J
    //   91: aload_0
    //   92: iconst_0
    //   93: putfield 33	moai/log/TruncatedFileHandler:truncating	Z
    //   96: aload 10
    //   98: monitorexit
    //   99: iconst_0
    //   100: ifeq +11 -> 111
    //   103: new 160	java/lang/NullPointerException
    //   106: dup
    //   107: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   110: athrow
    //   111: iconst_0
    //   112: ifeq +11 -> 123
    //   115: new 160	java/lang/NullPointerException
    //   118: dup
    //   119: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   122: athrow
    //   123: iconst_0
    //   124: ifeq +11 -> 135
    //   127: new 160	java/lang/NullPointerException
    //   130: dup
    //   131: invokespecial 161	java/lang/NullPointerException:<init>	()V
    //   134: athrow
    //   135: aload_0
    //   136: invokespecial 163	moai/log/TruncatedFileHandler:deleteAllOldTempFile	()V
    //   139: return
    //   140: astore 9
    //   142: aload 10
    //   144: monitorexit
    //   145: aload 9
    //   147: athrow
    //   148: new 165	java/io/BufferedInputStream
    //   151: dup
    //   152: new 167	java/io/FileInputStream
    //   155: dup
    //   156: aload 9
    //   158: invokespecial 170	java/io/FileInputStream:<init>	(Ljava/io/File;)V
    //   161: invokespecial 173	java/io/BufferedInputStream:<init>	(Ljava/io/InputStream;)V
    //   164: astore 10
    //   166: aload 9
    //   168: invokevirtual 145	java/io/File:length	()J
    //   171: lstore 5
    //   173: lload 5
    //   175: aload_0
    //   176: getfield 31	moai/log/TruncatedFileHandler:maxSize	J
    //   179: lcmp
    //   180: ifle +19 -> 199
    //   183: lload 5
    //   185: l2d
    //   186: dconst_1
    //   187: aload_0
    //   188: getfield 27	moai/log/TruncatedFileHandler:truncateRatio	D
    //   191: dsub
    //   192: dmul
    //   193: d2l
    //   194: lstore 5
    //   196: goto -23 -> 173
    //   199: aload 10
    //   201: aload 9
    //   203: invokevirtual 145	java/io/File:length	()J
    //   206: lload 5
    //   208: lsub
    //   209: invokevirtual 179	java/io/InputStream:skip	(J)J
    //   212: pop2
    //   213: aload_0
    //   214: invokevirtual 51	moai/log/TruncatedFileHandler:getFilename	()Ljava/lang/String;
    //   217: aconst_null
    //   218: new 71	java/io/File
    //   221: dup
    //   222: aload_0
    //   223: invokevirtual 74	moai/log/TruncatedFileHandler:getDirname	()Ljava/lang/String;
    //   226: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   229: invokestatic 183	java/io/File:createTempFile	(Ljava/lang/String;Ljava/lang/String;Ljava/io/File;)Ljava/io/File;
    //   232: astore 11
    //   234: new 185	java/io/BufferedOutputStream
    //   237: dup
    //   238: new 187	java/io/FileOutputStream
    //   241: dup
    //   242: aload 11
    //   244: invokespecial 188	java/io/FileOutputStream:<init>	(Ljava/io/File;)V
    //   247: invokespecial 191	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   250: astore 9
    //   252: iload_1
    //   253: istore_3
    //   254: iload_1
    //   255: istore_2
    //   256: aload 10
    //   258: invokevirtual 194	java/io/InputStream:read	()I
    //   261: istore 4
    //   263: iload 4
    //   265: iconst_m1
    //   266: if_icmpeq +107 -> 373
    //   269: iload_1
    //   270: iconst_1
    //   271: iadd
    //   272: istore_1
    //   273: iload_1
    //   274: istore_3
    //   275: iload_1
    //   276: istore_2
    //   277: aload 9
    //   279: iload 4
    //   281: invokevirtual 200	java/io/OutputStream:write	(I)V
    //   284: goto -32 -> 252
    //   287: astore 13
    //   289: aload 9
    //   291: astore 12
    //   293: aload 10
    //   295: astore 9
    //   297: aload 11
    //   299: astore 10
    //   301: aload 13
    //   303: astore 11
    //   305: aload 11
    //   307: invokevirtual 203	java/io/IOException:printStackTrace	()V
    //   310: aload_0
    //   311: getfield 47	moai/log/TruncatedFileHandler:lock	Ljava/lang/Object;
    //   314: astore 11
    //   316: aload 11
    //   318: monitorenter
    //   319: iload_3
    //   320: i2l
    //   321: lstore 5
    //   323: aload_0
    //   324: lload 5
    //   326: putfield 42	moai/log/TruncatedFileHandler:fileSize	J
    //   329: aload_0
    //   330: iconst_0
    //   331: putfield 33	moai/log/TruncatedFileHandler:truncating	Z
    //   334: aload 11
    //   336: monitorexit
    //   337: aload 10
    //   339: ifnull +9 -> 348
    //   342: aload 10
    //   344: invokevirtual 95	java/io/File:delete	()Z
    //   347: pop
    //   348: aload 9
    //   350: ifnull +8 -> 358
    //   353: aload 9
    //   355: invokevirtual 206	java/io/InputStream:close	()V
    //   358: aload 12
    //   360: ifnull +8 -> 368
    //   363: aload 12
    //   365: invokevirtual 207	java/io/OutputStream:close	()V
    //   368: aload_0
    //   369: invokespecial 163	moai/log/TruncatedFileHandler:deleteAllOldTempFile	()V
    //   372: return
    //   373: iload_1
    //   374: istore_3
    //   375: iload_1
    //   376: istore_2
    //   377: aload 11
    //   379: new 71	java/io/File
    //   382: dup
    //   383: new 129	java/lang/StringBuilder
    //   386: dup
    //   387: invokespecial 130	java/lang/StringBuilder:<init>	()V
    //   390: aload_0
    //   391: invokevirtual 74	moai/log/TruncatedFileHandler:getDirname	()Ljava/lang/String;
    //   394: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   397: getstatic 138	java/io/File:separator	Ljava/lang/String;
    //   400: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   403: aload_0
    //   404: invokevirtual 51	moai/log/TruncatedFileHandler:getFilename	()Ljava/lang/String;
    //   407: invokevirtual 134	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   410: invokevirtual 141	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   413: invokespecial 75	java/io/File:<init>	(Ljava/lang/String;)V
    //   416: invokevirtual 211	java/io/File:renameTo	(Ljava/io/File;)Z
    //   419: pop
    //   420: iload_1
    //   421: istore_3
    //   422: iload_1
    //   423: istore_2
    //   424: aload 11
    //   426: invokevirtual 95	java/io/File:delete	()Z
    //   429: pop
    //   430: iload_1
    //   431: istore_3
    //   432: iload_1
    //   433: istore_2
    //   434: aload 9
    //   436: invokevirtual 207	java/io/OutputStream:close	()V
    //   439: iload_1
    //   440: istore_3
    //   441: iload_1
    //   442: istore_2
    //   443: aload 10
    //   445: invokevirtual 206	java/io/InputStream:close	()V
    //   448: iload_1
    //   449: istore_3
    //   450: iload_1
    //   451: istore_2
    //   452: aload_0
    //   453: invokespecial 212	moai/log/FileHandlerDelegate:close	()V
    //   456: aload_0
    //   457: getfield 47	moai/log/TruncatedFileHandler:lock	Ljava/lang/Object;
    //   460: astore 12
    //   462: aload 12
    //   464: monitorenter
    //   465: iload_1
    //   466: i2l
    //   467: lstore 5
    //   469: aload_0
    //   470: lload 5
    //   472: putfield 42	moai/log/TruncatedFileHandler:fileSize	J
    //   475: aload_0
    //   476: iconst_0
    //   477: putfield 33	moai/log/TruncatedFileHandler:truncating	Z
    //   480: aload 12
    //   482: monitorexit
    //   483: aload 11
    //   485: ifnull +9 -> 494
    //   488: aload 11
    //   490: invokevirtual 95	java/io/File:delete	()Z
    //   493: pop
    //   494: aload 10
    //   496: ifnull +8 -> 504
    //   499: aload 10
    //   501: invokevirtual 206	java/io/InputStream:close	()V
    //   504: aload 9
    //   506: ifnull +8 -> 514
    //   509: aload 9
    //   511: invokevirtual 207	java/io/OutputStream:close	()V
    //   514: aload_0
    //   515: invokespecial 163	moai/log/TruncatedFileHandler:deleteAllOldTempFile	()V
    //   518: return
    //   519: astore 9
    //   521: aload 12
    //   523: monitorexit
    //   524: aload 9
    //   526: athrow
    //   527: astore 9
    //   529: aload 11
    //   531: monitorexit
    //   532: aload 9
    //   534: athrow
    //   535: astore 9
    //   537: aconst_null
    //   538: astore 10
    //   540: aconst_null
    //   541: astore 11
    //   543: aload 13
    //   545: astore 12
    //   547: aload_0
    //   548: getfield 47	moai/log/TruncatedFileHandler:lock	Ljava/lang/Object;
    //   551: astore 13
    //   553: aload 13
    //   555: monitorenter
    //   556: iload_2
    //   557: i2l
    //   558: lstore 5
    //   560: aload_0
    //   561: lload 5
    //   563: putfield 42	moai/log/TruncatedFileHandler:fileSize	J
    //   566: aload_0
    //   567: iconst_0
    //   568: putfield 33	moai/log/TruncatedFileHandler:truncating	Z
    //   571: aload 13
    //   573: monitorexit
    //   574: aload 11
    //   576: ifnull +9 -> 585
    //   579: aload 11
    //   581: invokevirtual 95	java/io/File:delete	()Z
    //   584: pop
    //   585: aload 10
    //   587: ifnull +8 -> 595
    //   590: aload 10
    //   592: invokevirtual 206	java/io/InputStream:close	()V
    //   595: aload 12
    //   597: ifnull +8 -> 605
    //   600: aload 12
    //   602: invokevirtual 207	java/io/OutputStream:close	()V
    //   605: aload_0
    //   606: invokespecial 163	moai/log/TruncatedFileHandler:deleteAllOldTempFile	()V
    //   609: aload 9
    //   611: athrow
    //   612: astore 9
    //   614: aload 13
    //   616: monitorexit
    //   617: aload 9
    //   619: athrow
    //   620: astore 9
    //   622: goto -499 -> 123
    //   625: astore 9
    //   627: goto -492 -> 135
    //   630: astore 10
    //   632: goto -128 -> 504
    //   635: astore 9
    //   637: goto -123 -> 514
    //   640: astore 9
    //   642: goto -284 -> 358
    //   645: astore 9
    //   647: goto -279 -> 368
    //   650: astore 10
    //   652: goto -57 -> 595
    //   655: astore 10
    //   657: goto -52 -> 605
    //   660: astore 9
    //   662: aconst_null
    //   663: astore 11
    //   665: aload 13
    //   667: astore 12
    //   669: goto -122 -> 547
    //   672: astore 9
    //   674: aload 13
    //   676: astore 12
    //   678: goto -131 -> 547
    //   681: astore 13
    //   683: aload 9
    //   685: astore 12
    //   687: aload 13
    //   689: astore 9
    //   691: goto -144 -> 547
    //   694: astore 13
    //   696: aload 10
    //   698: astore 11
    //   700: aload 9
    //   702: astore 10
    //   704: aload 13
    //   706: astore 9
    //   708: iload_3
    //   709: istore_2
    //   710: goto -163 -> 547
    //   713: astore 11
    //   715: aconst_null
    //   716: astore 9
    //   718: aconst_null
    //   719: astore 10
    //   721: goto -416 -> 305
    //   724: astore 11
    //   726: aload 10
    //   728: astore 9
    //   730: aconst_null
    //   731: astore 10
    //   733: goto -428 -> 305
    //   736: astore 13
    //   738: aload 10
    //   740: astore 9
    //   742: aload 11
    //   744: astore 10
    //   746: aload 13
    //   748: astore 11
    //   750: goto -445 -> 305
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	753	0	this	TruncatedFileHandler
    //   11	455	1	i	int
    //   9	701	2	j	int
    //   7	702	3	k	int
    //   261	19	4	m	int
    //   62	500	5	l1	long
    //   56	9	7	l2	long
    //   49	3	9	localFile1	File
    //   140	62	9	localFile2	File
    //   250	260	9	localObject1	Object
    //   519	6	9	localObject2	Object
    //   527	6	9	localObject3	Object
    //   535	75	9	localObject4	Object
    //   612	6	9	localObject5	Object
    //   620	1	9	localIOException1	java.io.IOException
    //   625	1	9	localIOException2	java.io.IOException
    //   635	1	9	localIOException3	java.io.IOException
    //   640	1	9	localIOException4	java.io.IOException
    //   645	1	9	localIOException5	java.io.IOException
    //   660	1	9	localObject6	Object
    //   672	12	9	localObject7	Object
    //   689	52	9	localObject8	Object
    //   76	515	10	localObject9	Object
    //   630	1	10	localIOException6	java.io.IOException
    //   650	1	10	localIOException7	java.io.IOException
    //   655	42	10	localIOException8	java.io.IOException
    //   702	43	10	localObject10	Object
    //   232	467	11	localObject11	Object
    //   713	1	11	localIOException9	java.io.IOException
    //   724	19	11	localIOException10	java.io.IOException
    //   748	1	11	localIOException11	java.io.IOException
    //   4	682	12	localObject12	Object
    //   1	1	13	localObject13	Object
    //   287	257	13	localIOException12	java.io.IOException
    //   551	124	13	localObject14	Object
    //   681	7	13	localObject15	Object
    //   694	11	13	localObject16	Object
    //   736	11	13	localIOException13	java.io.IOException
    // Exception table:
    //   from	to	target	type
    //   85	99	140	finally
    //   142	145	140	finally
    //   256	263	287	java/io/IOException
    //   277	284	287	java/io/IOException
    //   377	420	287	java/io/IOException
    //   424	430	287	java/io/IOException
    //   434	439	287	java/io/IOException
    //   443	448	287	java/io/IOException
    //   452	456	287	java/io/IOException
    //   469	483	519	finally
    //   521	524	519	finally
    //   323	337	527	finally
    //   529	532	527	finally
    //   12	64	535	finally
    //   148	166	535	finally
    //   560	574	612	finally
    //   614	617	612	finally
    //   115	123	620	java/io/IOException
    //   127	135	625	java/io/IOException
    //   499	504	630	java/io/IOException
    //   509	514	635	java/io/IOException
    //   353	358	640	java/io/IOException
    //   363	368	645	java/io/IOException
    //   590	595	650	java/io/IOException
    //   600	605	655	java/io/IOException
    //   166	173	660	finally
    //   173	196	660	finally
    //   199	234	660	finally
    //   234	252	672	finally
    //   256	263	681	finally
    //   277	284	681	finally
    //   377	420	681	finally
    //   424	430	681	finally
    //   434	439	681	finally
    //   443	448	681	finally
    //   452	456	681	finally
    //   305	310	694	finally
    //   12	64	713	java/io/IOException
    //   148	166	713	java/io/IOException
    //   166	173	724	java/io/IOException
    //   173	196	724	java/io/IOException
    //   199	234	724	java/io/IOException
    //   234	252	736	java/io/IOException
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.TruncatedFileHandler
 * JD-Core Version:    0.7.0.1
 */