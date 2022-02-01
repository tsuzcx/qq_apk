package moai.log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.StringWriter;
import java.nio.channels.FileChannel;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FileHandler
  extends Handler
  implements FileOperation
{
  static final String BLOCK_SEPARATOR = "\r\n";
  private static final int BUF_SIZE_TO_FLUSH = 4096;
  protected static final int MAX_BUF_SIZE = 65536;
  private static final String TAG = "FileHandler";
  private StringBuilder debugInfo = new StringBuilder();
  protected final String dirname;
  private int failedForceOrCloseFileCount = 0;
  private int failedOpenFileCount = 0;
  private int failedWriteFileCount = 0;
  private volatile FileChannel fileChannel = null;
  protected final String filename;
  private final Formatter filenameFormater;
  protected volatile File mFile = null;
  private final ByteBufferWrapper mOutputByteBuffer;
  private long previousTime = 0L;
  protected FileHandler writeToFileDelegrate;
  
  FileHandler()
  {
    super(2, null);
    this.dirname = null;
    this.filename = null;
    this.filenameFormater = null;
    this.mOutputByteBuffer = null;
  }
  
  public FileHandler(String paramString1, String paramString2, int paramInt, String paramString3)
  {
    super(paramInt, paramString3);
    this.dirname = paramString1;
    this.filename = paramString2;
    this.filenameFormater = parseFilenameFormat(paramString2);
    this.mOutputByteBuffer = new ByteBufferWrapper(65536);
  }
  
  private void fileChannelWrite(int paramInt)
  {
    if (this.mOutputByteBuffer.length() > paramInt) {}
    try
    {
      this.fileChannel.write(this.mOutputByteBuffer.flip().toBuffer());
      return;
    }
    catch (IOException localIOException)
    {
      this.failedWriteFileCount += 1;
      localIOException.printStackTrace();
      return;
    }
    finally
    {
      this.mOutputByteBuffer.clear();
    }
  }
  
  private static long getTimesmorning()
  {
    Calendar localCalendar = Calendar.getInstance();
    localCalendar.set(11, 0);
    localCalendar.set(13, 0);
    localCalendar.set(12, 0);
    localCalendar.set(14, 0);
    return localCalendar.getTimeInMillis();
  }
  
  private String parseFileName(boolean paramBoolean)
  {
    Object localObject = null;
    if (this.filenameFormater == null) {
      localObject = this.filename;
    }
    long l;
    do
    {
      return localObject;
      l = System.currentTimeMillis();
    } while ((!paramBoolean) && (l - this.previousTime <= 86400000L));
    this.previousTime = getTimesmorning();
    localObject = new ByteBufferWrapper(32);
    Thread localThread = Thread.currentThread();
    this.filenameFormater.append((ByteBufferWrapper)localObject, null, 0, l, localThread.getId(), localThread.getName());
    return ((ByteBufferWrapper)localObject).toString();
  }
  
  protected static Formatter parseFilenameFormat(String paramString)
  {
    int i = 0;
    String[] arrayOfString = new String[4];
    arrayOfString[0] = ("%" + Formatter.FORMAT.YYYY.getContent());
    arrayOfString[1] = ("%" + Formatter.FORMAT.YY.getContent());
    arrayOfString[2] = ("%" + Formatter.FORMAT.MONTH.getContent());
    arrayOfString[3] = ("%" + Formatter.FORMAT.DD.getContent());
    int j = arrayOfString.length;
    while (i < j)
    {
      if (paramString.contains(arrayOfString[i])) {
        return new Formatter(paramString);
      }
      i += 1;
    }
    return null;
  }
  
  protected void appendDebugLog(String paramString)
  {
    if ((BuildConfig.BETA) && (this.debugInfo.length() < 128)) {
      this.debugInfo.append(paramString).append("|");
    }
  }
  
  /* Error */
  protected void close()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 207	moai/log/FileHandler:flush	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   10: astore_1
    //   11: aload_1
    //   12: ifnull +15 -> 27
    //   15: aload_0
    //   16: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   19: invokevirtual 209	java/nio/channels/FileChannel:close	()V
    //   22: aload_0
    //   23: aconst_null
    //   24: putfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   27: aload_0
    //   28: monitorexit
    //   29: return
    //   30: astore_1
    //   31: aload_0
    //   32: aload_0
    //   33: getfield 60	moai/log/FileHandler:failedForceOrCloseFileCount	I
    //   36: iconst_1
    //   37: iadd
    //   38: putfield 60	moai/log/FileHandler:failedForceOrCloseFileCount	I
    //   41: goto -19 -> 22
    //   44: astore_1
    //   45: aload_0
    //   46: monitorexit
    //   47: aload_1
    //   48: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	49	0	this	FileHandler
    //   10	2	1	localFileChannel	FileChannel
    //   30	1	1	localIOException	IOException
    //   44	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   15	22	30	java/io/IOException
    //   6	11	44	finally
    //   15	22	44	finally
    //   22	27	44	finally
    //   27	29	44	finally
    //   31	41	44	finally
    //   45	47	44	finally
  }
  
  protected boolean filterContent(FileOperation.Config paramConfig, String paramString)
  {
    String str = paramConfig.getPatternString();
    if ((str != null) && (paramString.contains(str))) {
      return true;
    }
    paramConfig = paramConfig.getPattern();
    if (paramConfig != null) {
      return paramConfig.matcher(paramString).matches();
    }
    return false;
  }
  
  /* Error */
  public void flush()
  {
    // Byte code:
    //   0: aload_0
    //   1: invokevirtual 235	moai/log/FileHandler:onFlush	()V
    //   4: aload_0
    //   5: monitorenter
    //   6: aload_0
    //   7: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   10: ifnull +16 -> 26
    //   13: aload_0
    //   14: iconst_0
    //   15: invokespecial 237	moai/log/FileHandler:fileChannelWrite	(I)V
    //   18: aload_0
    //   19: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   22: iconst_0
    //   23: invokevirtual 241	java/nio/channels/FileChannel:force	(Z)V
    //   26: aload_0
    //   27: monitorexit
    //   28: return
    //   29: astore_1
    //   30: aload_0
    //   31: aload_0
    //   32: getfield 60	moai/log/FileHandler:failedForceOrCloseFileCount	I
    //   35: iconst_1
    //   36: iadd
    //   37: putfield 60	moai/log/FileHandler:failedForceOrCloseFileCount	I
    //   40: aload_1
    //   41: invokevirtual 112	java/io/IOException:printStackTrace	()V
    //   44: aload_0
    //   45: aconst_null
    //   46: putfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   49: goto -23 -> 26
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	FileHandler
    //   29	12	1	localIOException	IOException
    //   52	4	1	localObject	Object
    // Exception table:
    //   from	to	target	type
    //   18	26	29	java/io/IOException
    //   6	18	52	finally
    //   18	26	52	finally
    //   26	28	52	finally
    //   30	49	52	finally
    //   53	55	52	finally
  }
  
  public String getAndClearDebugLog()
  {
    if (BuildConfig.BETA)
    {
      String str = this.debugInfo.toString();
      this.debugInfo = new StringBuilder();
      return str;
    }
    return null;
  }
  
  public int getAndClearFailedForceOrCloseFileCount()
  {
    int i = this.failedForceOrCloseFileCount;
    this.failedForceOrCloseFileCount = 0;
    return i;
  }
  
  public int getAndClearFailedOpenFileCount()
  {
    int i = this.failedOpenFileCount;
    this.failedOpenFileCount = 0;
    return i;
  }
  
  public int getAndClearFailedWriteFileCount()
  {
    int i = this.failedWriteFileCount;
    this.failedWriteFileCount = 0;
    return i;
  }
  
  public String getDirname()
  {
    return this.dirname;
  }
  
  public String getFilename()
  {
    return this.filename;
  }
  
  public List<String> list(GregorianCalendar paramGregorianCalendar1, GregorianCalendar paramGregorianCalendar2)
  {
    Object localObject = null;
    if (this.filenameFormater == null) {
      return Arrays.asList(new String[] { this.dirname + File.separator + this.filename });
    }
    Pattern localPattern = this.filenameFormater.formatDate();
    if (paramGregorianCalendar1 == null)
    {
      paramGregorianCalendar1 = null;
      if (paramGregorianCalendar2 != null) {
        break label120;
      }
    }
    label120:
    for (paramGregorianCalendar2 = localObject;; paramGregorianCalendar2 = this.filenameFormater.formatDate(paramGregorianCalendar2))
    {
      paramGregorianCalendar1 = new File(this.dirname).list(new FileHandler.1(this, localPattern, paramGregorianCalendar1, paramGregorianCalendar2));
      if (paramGregorianCalendar1 != null) {
        break label132;
      }
      return Collections.emptyList();
      paramGregorianCalendar1 = this.filenameFormater.formatDate(paramGregorianCalendar1);
      break;
    }
    label132:
    int i = 0;
    while (i < paramGregorianCalendar1.length)
    {
      paramGregorianCalendar1[i] = (this.dirname + File.separator + paramGregorianCalendar1[i]);
      i += 1;
    }
    return Arrays.asList(paramGregorianCalendar1);
  }
  
  protected void onFlush()
  {
    if (this.writeToFileDelegrate != null) {
      this.writeToFileDelegrate.onFlush();
    }
  }
  
  protected int onPrepareToWrite(LogData paramLogData)
  {
    if (this.writeToFileDelegrate != null)
    {
      int i = this.writeToFileDelegrate.onPrepareToWrite(paramLogData);
      if (i > 0)
      {
        paramLogData.recycle();
        return i;
      }
    }
    return writeToFile(paramLogData);
  }
  
  protected boolean onWriteToBuf(LogData paramLogData, ByteBufferWrapper paramByteBufferWrapper)
  {
    this.formater.append(paramByteBufferWrapper, paramLogData.tag, paramLogData.level, paramLogData.logTime, paramLogData.threadId, paramLogData.threadName);
    paramByteBufferWrapper.append(paramLogData.msg);
    if (paramLogData.throwable != null)
    {
      StringWriter localStringWriter = new StringWriter(1024);
      PrintWriter localPrintWriter = new PrintWriter(localStringWriter);
      paramLogData.throwable.printStackTrace(localPrintWriter);
      paramByteBufferWrapper.append(localStringWriter.toString());
    }
    if ((this.writeToFileDelegrate != null) && (this.writeToFileDelegrate.onWriteToBuf(paramLogData, paramByteBufferWrapper))) {}
    return true;
  }
  
  public int publish(int paramInt, String paramString1, String paramString2)
  {
    return publish(paramInt, paramString1, paramString2, null);
  }
  
  public int publish(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
  {
    if (paramInt < getLevel()) {
      return 0;
    }
    return onPrepareToWrite(LogData.obtain(paramInt, paramString1, paramString2, paramThrowable));
  }
  
  protected final void setWriteToFileDelegrate(FileHandler paramFileHandler)
  {
    this.writeToFileDelegrate = paramFileHandler;
  }
  
  /* Error */
  protected int writeToFile(LogData paramLogData)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   6: ifnonnull +230 -> 236
    //   9: new 251	java/io/File
    //   12: dup
    //   13: aload_0
    //   14: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   17: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   20: invokevirtual 362	java/io/File:mkdirs	()Z
    //   23: pop
    //   24: aload_0
    //   25: iconst_1
    //   26: invokespecial 364	moai/log/FileHandler:parseFileName	(Z)Ljava/lang/String;
    //   29: astore 4
    //   31: aload_0
    //   32: new 251	java/io/File
    //   35: dup
    //   36: new 62	java/lang/StringBuilder
    //   39: dup
    //   40: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   43: aload_0
    //   44: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   47: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   50: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   53: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   56: aload 4
    //   58: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   61: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   64: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   67: putfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   70: aload_0
    //   71: new 366	java/io/FileOutputStream
    //   74: dup
    //   75: new 62	java/lang/StringBuilder
    //   78: dup
    //   79: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   82: aload_0
    //   83: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   86: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   89: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   92: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   95: aload 4
    //   97: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   100: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   103: iconst_1
    //   104: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   107: invokevirtual 373	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   110: putfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   113: aload_0
    //   114: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   117: ifnull +447 -> 564
    //   120: aload_0
    //   121: getfield 74	moai/log/FileHandler:mOutputByteBuffer	Lmoai/log/ByteBufferWrapper;
    //   124: astore 4
    //   126: aload 4
    //   128: invokevirtual 92	moai/log/ByteBufferWrapper:length	()I
    //   131: istore_2
    //   132: aload 4
    //   134: iload_2
    //   135: invokevirtual 376	moai/log/ByteBufferWrapper:setPosition	(I)V
    //   138: aload_0
    //   139: aload_1
    //   140: aload 4
    //   142: invokevirtual 341	moai/log/FileHandler:onWriteToBuf	(Lmoai/log/FileHandler$LogData;Lmoai/log/ByteBufferWrapper;)Z
    //   145: pop
    //   146: aload 4
    //   148: ldc 16
    //   150: invokevirtual 321	moai/log/ByteBufferWrapper:append	(Ljava/lang/String;)Lmoai/log/ByteBufferWrapper;
    //   153: pop
    //   154: aload_1
    //   155: invokevirtual 292	moai/log/FileHandler$LogData:recycle	()V
    //   158: aload 4
    //   160: invokevirtual 92	moai/log/ByteBufferWrapper:length	()I
    //   163: istore_3
    //   164: aload_0
    //   165: sipush 4096
    //   168: invokespecial 237	moai/log/FileHandler:fileChannelWrite	(I)V
    //   171: getstatic 200	moai/log/BuildConfig:BETA	Z
    //   174: ifeq +31 -> 205
    //   177: iload_2
    //   178: sipush 4096
    //   181: if_icmple +24 -> 205
    //   184: aload_0
    //   185: ldc_w 378
    //   188: iconst_1
    //   189: anewarray 380	java/lang/Object
    //   192: dup
    //   193: iconst_0
    //   194: iload_2
    //   195: invokestatic 386	java/lang/Integer:valueOf	(I)Ljava/lang/Integer;
    //   198: aastore
    //   199: invokestatic 390	java/lang/String:format	(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/String;
    //   202: invokevirtual 392	moai/log/FileHandler:appendDebugLog	(Ljava/lang/String;)V
    //   205: aload_0
    //   206: monitorexit
    //   207: iload_3
    //   208: iload_2
    //   209: isub
    //   210: ireturn
    //   211: astore 4
    //   213: aload 4
    //   215: invokevirtual 393	java/io/FileNotFoundException:printStackTrace	()V
    //   218: aload_0
    //   219: aload_0
    //   220: getfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   223: iconst_1
    //   224: iadd
    //   225: putfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   228: goto -115 -> 113
    //   231: astore_1
    //   232: aload_0
    //   233: monitorexit
    //   234: aload_1
    //   235: athrow
    //   236: aload_0
    //   237: getfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   240: ifnull +159 -> 399
    //   243: aload_0
    //   244: getfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   247: invokevirtual 396	java/io/File:exists	()Z
    //   250: ifne +149 -> 399
    //   253: aload_0
    //   254: iconst_0
    //   255: invokespecial 364	moai/log/FileHandler:parseFileName	(Z)Ljava/lang/String;
    //   258: astore 5
    //   260: aload 5
    //   262: astore 4
    //   264: aload 5
    //   266: ifnonnull +12 -> 278
    //   269: aload_0
    //   270: getfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   273: invokevirtual 397	java/io/File:getName	()Ljava/lang/String;
    //   276: astore 4
    //   278: aload_0
    //   279: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   282: astore 5
    //   284: aload_0
    //   285: new 251	java/io/File
    //   288: dup
    //   289: new 62	java/lang/StringBuilder
    //   292: dup
    //   293: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   296: aload_0
    //   297: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   300: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   303: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   306: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   309: aload 4
    //   311: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   314: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   317: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   320: putfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   323: aload_0
    //   324: new 366	java/io/FileOutputStream
    //   327: dup
    //   328: new 62	java/lang/StringBuilder
    //   331: dup
    //   332: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   335: aload_0
    //   336: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   339: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   342: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   345: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   348: aload 4
    //   350: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   353: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   356: iconst_1
    //   357: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   360: invokevirtual 373	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   363: putfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   366: aload 5
    //   368: ifnull -255 -> 113
    //   371: aload 5
    //   373: invokevirtual 209	java/nio/channels/FileChannel:close	()V
    //   376: goto -263 -> 113
    //   379: astore 4
    //   381: goto -268 -> 113
    //   384: astore 4
    //   386: aload_0
    //   387: aload_0
    //   388: getfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   391: iconst_1
    //   392: iadd
    //   393: putfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   396: goto -30 -> 366
    //   399: aload_0
    //   400: getfield 72	moai/log/FileHandler:filenameFormater	Lmoai/log/Formatter;
    //   403: ifnull -290 -> 113
    //   406: aload_0
    //   407: iconst_0
    //   408: invokespecial 364	moai/log/FileHandler:parseFileName	(Z)Ljava/lang/String;
    //   411: astore 5
    //   413: aload 5
    //   415: ifnull -302 -> 113
    //   418: aload_0
    //   419: invokevirtual 207	moai/log/FileHandler:flush	()V
    //   422: aload_0
    //   423: getfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   426: astore 4
    //   428: aload_0
    //   429: new 251	java/io/File
    //   432: dup
    //   433: new 62	java/lang/StringBuilder
    //   436: dup
    //   437: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   440: aload_0
    //   441: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   444: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   447: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   450: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   453: aload 5
    //   455: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   458: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   461: invokespecial 264	java/io/File:<init>	(Ljava/lang/String;)V
    //   464: putfield 50	moai/log/FileHandler:mFile	Ljava/io/File;
    //   467: aload_0
    //   468: new 366	java/io/FileOutputStream
    //   471: dup
    //   472: new 62	java/lang/StringBuilder
    //   475: dup
    //   476: invokespecial 64	java/lang/StringBuilder:<init>	()V
    //   479: aload_0
    //   480: getfield 68	moai/log/FileHandler:dirname	Ljava/lang/String;
    //   483: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   486: getstatic 254	java/io/File:separator	Ljava/lang/String;
    //   489: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   492: aload 5
    //   494: invokevirtual 167	java/lang/StringBuilder:append	(Ljava/lang/String;)Ljava/lang/StringBuilder;
    //   497: invokevirtual 177	java/lang/StringBuilder:toString	()Ljava/lang/String;
    //   500: iconst_1
    //   501: invokespecial 369	java/io/FileOutputStream:<init>	(Ljava/lang/String;Z)V
    //   504: invokevirtual 373	java/io/FileOutputStream:getChannel	()Ljava/nio/channels/FileChannel;
    //   507: putfield 52	moai/log/FileHandler:fileChannel	Ljava/nio/channels/FileChannel;
    //   510: aload 4
    //   512: ifnull -399 -> 113
    //   515: aload 4
    //   517: invokevirtual 209	java/nio/channels/FileChannel:close	()V
    //   520: goto -407 -> 113
    //   523: astore 4
    //   525: goto -412 -> 113
    //   528: astore 5
    //   530: aload_0
    //   531: aload_0
    //   532: getfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   535: iconst_1
    //   536: iadd
    //   537: putfield 56	moai/log/FileHandler:failedOpenFileCount	I
    //   540: goto -30 -> 510
    //   543: astore 5
    //   545: getstatic 400	moai/log/BuildConfig:DEBUG	Z
    //   548: ifeq -394 -> 154
    //   551: new 402	java/lang/RuntimeException
    //   554: dup
    //   555: ldc_w 404
    //   558: aload 5
    //   560: invokespecial 407	java/lang/RuntimeException:<init>	(Ljava/lang/String;Ljava/lang/Throwable;)V
    //   563: athrow
    //   564: aload_0
    //   565: monitorexit
    //   566: iconst_0
    //   567: ireturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	568	0	this	FileHandler
    //   0	568	1	paramLogData	LogData
    //   131	79	2	i	int
    //   163	47	3	j	int
    //   29	130	4	localObject1	Object
    //   211	3	4	localFileNotFoundException1	java.io.FileNotFoundException
    //   262	87	4	localObject2	Object
    //   379	1	4	localIOException1	IOException
    //   384	1	4	localFileNotFoundException2	java.io.FileNotFoundException
    //   426	90	4	localFileChannel	FileChannel
    //   523	1	4	localIOException2	IOException
    //   258	235	5	localObject3	Object
    //   528	1	5	localFileNotFoundException3	java.io.FileNotFoundException
    //   543	16	5	localException	java.lang.Exception
    // Exception table:
    //   from	to	target	type
    //   70	113	211	java/io/FileNotFoundException
    //   2	70	231	finally
    //   70	113	231	finally
    //   113	132	231	finally
    //   132	154	231	finally
    //   154	177	231	finally
    //   184	205	231	finally
    //   205	207	231	finally
    //   213	228	231	finally
    //   232	234	231	finally
    //   236	260	231	finally
    //   269	278	231	finally
    //   278	323	231	finally
    //   323	366	231	finally
    //   371	376	231	finally
    //   386	396	231	finally
    //   399	413	231	finally
    //   418	467	231	finally
    //   467	510	231	finally
    //   515	520	231	finally
    //   530	540	231	finally
    //   545	564	231	finally
    //   564	566	231	finally
    //   371	376	379	java/io/IOException
    //   323	366	384	java/io/FileNotFoundException
    //   515	520	523	java/io/IOException
    //   467	510	528	java/io/FileNotFoundException
    //   132	154	543	java/lang/Exception
  }
  
  /* Error */
  public void zip(FileOperation.Config paramConfig, String paramString)
  {
    // Byte code:
    //   0: aconst_null
    //   1: astore_3
    //   2: aload_2
    //   3: ifnull +10 -> 13
    //   6: aload_2
    //   7: invokevirtual 410	java/lang/String:length	()I
    //   10: ifne +14 -> 24
    //   13: new 412	java/lang/IllegalArgumentException
    //   16: dup
    //   17: ldc_w 414
    //   20: invokespecial 415	java/lang/IllegalArgumentException:<init>	(Ljava/lang/String;)V
    //   23: athrow
    //   24: aload_0
    //   25: aload_1
    //   26: invokevirtual 419	moai/log/FileOperation$Config:getBegin	()Ljava/util/GregorianCalendar;
    //   29: aload_1
    //   30: invokevirtual 422	moai/log/FileOperation$Config:getEnd	()Ljava/util/GregorianCalendar;
    //   33: invokevirtual 424	moai/log/FileHandler:list	(Ljava/util/GregorianCalendar;Ljava/util/GregorianCalendar;)Ljava/util/List;
    //   36: astore 4
    //   38: new 426	java/util/zip/ZipOutputStream
    //   41: dup
    //   42: new 428	java/io/BufferedOutputStream
    //   45: dup
    //   46: new 366	java/io/FileOutputStream
    //   49: dup
    //   50: aload_2
    //   51: invokespecial 429	java/io/FileOutputStream:<init>	(Ljava/lang/String;)V
    //   54: invokespecial 432	java/io/BufferedOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   57: invokespecial 433	java/util/zip/ZipOutputStream:<init>	(Ljava/io/OutputStream;)V
    //   60: astore_2
    //   61: aload_2
    //   62: new 435	java/util/zip/ZipEntry
    //   65: dup
    //   66: ldc_w 437
    //   69: invokespecial 438	java/util/zip/ZipEntry:<init>	(Ljava/lang/String;)V
    //   72: invokevirtual 442	java/util/zip/ZipOutputStream:putNextEntry	(Ljava/util/zip/ZipEntry;)V
    //   75: aload 4
    //   77: invokeinterface 448 1 0
    //   82: astore 4
    //   84: aload 4
    //   86: invokeinterface 453 1 0
    //   91: ifeq +108 -> 199
    //   94: aload 4
    //   96: invokeinterface 457 1 0
    //   101: checkcast 162	java/lang/String
    //   104: astore_3
    //   105: new 8	moai/log/FileHandler$LineBufferedReader
    //   108: dup
    //   109: new 459	java/io/FileReader
    //   112: dup
    //   113: aload_3
    //   114: invokespecial 460	java/io/FileReader:<init>	(Ljava/lang/String;)V
    //   117: invokespecial 463	moai/log/FileHandler$LineBufferedReader:<init>	(Ljava/io/Reader;)V
    //   120: astore_3
    //   121: aload_3
    //   122: invokevirtual 468	java/io/BufferedReader:readLine	()Ljava/lang/String;
    //   125: astore 5
    //   127: aload 5
    //   129: ifnull +55 -> 184
    //   132: aload_0
    //   133: aload_1
    //   134: aload 5
    //   136: invokevirtual 470	moai/log/FileHandler:filterContent	(Lmoai/log/FileOperation$Config;Ljava/lang/String;)Z
    //   139: ifeq -18 -> 121
    //   142: aload_2
    //   143: aload 5
    //   145: invokevirtual 474	java/lang/String:getBytes	()[B
    //   148: invokevirtual 477	java/util/zip/ZipOutputStream:write	([B)V
    //   151: aload_2
    //   152: ldc 16
    //   154: invokevirtual 474	java/lang/String:getBytes	()[B
    //   157: invokevirtual 477	java/util/zip/ZipOutputStream:write	([B)V
    //   160: goto -39 -> 121
    //   163: astore_1
    //   164: aload_3
    //   165: ifnull +7 -> 172
    //   168: aload_3
    //   169: invokevirtual 478	java/io/BufferedReader:close	()V
    //   172: aload_1
    //   173: athrow
    //   174: astore_1
    //   175: aload_2
    //   176: ifnull +7 -> 183
    //   179: aload_2
    //   180: invokevirtual 479	java/util/zip/ZipOutputStream:close	()V
    //   183: return
    //   184: aload_3
    //   185: ifnull -101 -> 84
    //   188: aload_3
    //   189: invokevirtual 478	java/io/BufferedReader:close	()V
    //   192: goto -108 -> 84
    //   195: astore_3
    //   196: goto -112 -> 84
    //   199: aload_2
    //   200: invokevirtual 482	java/util/zip/ZipOutputStream:closeEntry	()V
    //   203: aload_2
    //   204: ifnull -21 -> 183
    //   207: aload_2
    //   208: invokevirtual 479	java/util/zip/ZipOutputStream:close	()V
    //   211: return
    //   212: astore_1
    //   213: return
    //   214: astore_1
    //   215: aconst_null
    //   216: astore_2
    //   217: aload_2
    //   218: ifnull +7 -> 225
    //   221: aload_2
    //   222: invokevirtual 479	java/util/zip/ZipOutputStream:close	()V
    //   225: aload_1
    //   226: athrow
    //   227: astore_3
    //   228: goto -56 -> 172
    //   231: astore_1
    //   232: return
    //   233: astore_2
    //   234: goto -9 -> 225
    //   237: astore_1
    //   238: goto -21 -> 217
    //   241: astore_1
    //   242: aload_3
    //   243: astore_2
    //   244: goto -69 -> 175
    //   247: astore_1
    //   248: aconst_null
    //   249: astore_3
    //   250: goto -86 -> 164
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	253	0	this	FileHandler
    //   0	253	1	paramConfig	FileOperation.Config
    //   0	253	2	paramString	String
    //   1	188	3	localObject1	Object
    //   195	1	3	localIOException1	IOException
    //   227	16	3	localIOException2	IOException
    //   249	1	3	localObject2	Object
    //   36	59	4	localObject3	Object
    //   125	19	5	str	String
    // Exception table:
    //   from	to	target	type
    //   121	127	163	finally
    //   132	160	163	finally
    //   61	84	174	java/io/IOException
    //   84	105	174	java/io/IOException
    //   172	174	174	java/io/IOException
    //   199	203	174	java/io/IOException
    //   188	192	195	java/io/IOException
    //   207	211	212	java/io/IOException
    //   38	61	214	finally
    //   168	172	227	java/io/IOException
    //   179	183	231	java/io/IOException
    //   221	225	233	java/io/IOException
    //   61	84	237	finally
    //   84	105	237	finally
    //   168	172	237	finally
    //   172	174	237	finally
    //   188	192	237	finally
    //   199	203	237	finally
    //   38	61	241	java/io/IOException
    //   105	121	247	finally
  }
  
  static class LineBufferedReader
    extends BufferedReader
  {
    public LineBufferedReader(Reader paramReader)
    {
      super();
    }
    
    public String readLine()
      throws IOException
    {
      StringBuilder localStringBuilder = new StringBuilder();
      int j;
      for (int i = super.read();; i = j)
      {
        j = super.read();
        if (j < 0) {
          break;
        }
        if ((i == 13) && (j == 10)) {
          return localStringBuilder.toString();
        }
        localStringBuilder.append((char)i);
      }
      if (i >= 0) {
        localStringBuilder.append((char)i);
      }
      if (localStringBuilder.length() == 0) {
        return null;
      }
      return localStringBuilder.toString();
    }
  }
  
  static final class LogData
  {
    private static final int MAX_POOL_SIZE = 128;
    private static final int THROWABLE_ESTIMATED = 256;
    private static final int TRIFLE_SIZE = 25;
    private static LogData sPool;
    private static int sPoolSize = 0;
    private static final Object sPoolSync = new Object();
    int level;
    long logTime;
    String msg;
    private LogData next;
    String tag;
    long threadId;
    String threadName;
    Throwable throwable;
    
    private static LogData obtain()
    {
      synchronized (sPoolSync)
      {
        if (sPool != null)
        {
          LogData localLogData = sPool;
          sPool = localLogData.next;
          localLogData.next = null;
          sPoolSize -= 1;
          return localLogData;
        }
        return new LogData();
      }
    }
    
    private static LogData obtain(int paramInt, String paramString1, String paramString2, Throwable paramThrowable)
    {
      LogData localLogData = obtain();
      localLogData.level = paramInt;
      localLogData.tag = paramString1;
      localLogData.msg = paramString2;
      localLogData.throwable = paramThrowable;
      paramString1 = Thread.currentThread();
      localLogData.threadId = paramString1.getId();
      localLogData.threadName = paramString1.getName();
      localLogData.logTime = System.currentTimeMillis();
      return localLogData;
    }
    
    public static LogData obtain(LogData paramLogData)
    {
      return obtain(paramLogData.level, paramLogData.tag, paramLogData.msg, paramLogData.throwable);
    }
    
    public void recycle()
    {
      synchronized (sPoolSync)
      {
        if (sPoolSize < 128)
        {
          this.level = 0;
          this.tag = null;
          this.msg = null;
          this.throwable = null;
          this.threadId = 0L;
          this.threadName = null;
          this.logTime = 0L;
          this.next = sPool;
          sPool = this;
          sPoolSize += 1;
        }
        return;
      }
    }
    
    public int sizeEstimated()
    {
      int k = 0;
      int i;
      int j;
      if (this.tag == null)
      {
        i = 0;
        if (this.msg != null) {
          break label47;
        }
        j = 0;
        label20:
        if (this.throwable != null) {
          break label58;
        }
      }
      for (;;)
      {
        return j + (i + 25) + k;
        i = this.tag.length();
        break;
        label47:
        j = this.msg.length();
        break label20;
        label58:
        k = 256;
      }
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     moai.log.FileHandler
 * JD-Core Version:    0.7.0.1
 */