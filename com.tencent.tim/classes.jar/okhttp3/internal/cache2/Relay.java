package okhttp3.internal.cache2;

import java.io.File;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.channels.FileChannel;
import okhttp3.internal.Util;
import okio.Buffer;
import okio.ByteString;
import okio.Source;
import okio.Timeout;

final class Relay
{
  private static final long FILE_HEADER_SIZE = 32L;
  static final ByteString PREFIX_CLEAN = ByteString.encodeUtf8("OkHttp cache v1\n");
  static final ByteString PREFIX_DIRTY = ByteString.encodeUtf8("OkHttp DIRTY :(\n");
  private static final int SOURCE_FILE = 2;
  private static final int SOURCE_UPSTREAM = 1;
  final Buffer buffer = new Buffer();
  final long bufferMaxSize;
  boolean complete;
  RandomAccessFile file;
  private final ByteString metadata;
  int sourceCount;
  Source upstream;
  final Buffer upstreamBuffer = new Buffer();
  long upstreamPos;
  Thread upstreamReader;
  
  private Relay(RandomAccessFile paramRandomAccessFile, Source paramSource, long paramLong1, ByteString paramByteString, long paramLong2)
  {
    this.file = paramRandomAccessFile;
    this.upstream = paramSource;
    if (paramSource == null) {}
    for (boolean bool = true;; bool = false)
    {
      this.complete = bool;
      this.upstreamPos = paramLong1;
      this.metadata = paramByteString;
      this.bufferMaxSize = paramLong2;
      return;
    }
  }
  
  public static Relay edit(File paramFile, Source paramSource, ByteString paramByteString, long paramLong)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    paramSource = new Relay(paramFile, paramSource, 0L, paramByteString, paramLong);
    paramFile.setLength(0L);
    paramSource.writeHeader(PREFIX_DIRTY, -1L, -1L);
    return paramSource;
  }
  
  public static Relay read(File paramFile)
    throws IOException
  {
    paramFile = new RandomAccessFile(paramFile, "rw");
    FileOperator localFileOperator = new FileOperator(paramFile.getChannel());
    Buffer localBuffer = new Buffer();
    localFileOperator.read(0L, localBuffer, 32L);
    if (!localBuffer.readByteString(PREFIX_CLEAN.size()).equals(PREFIX_CLEAN)) {
      throw new IOException("unreadable cache file");
    }
    long l1 = localBuffer.readLong();
    long l2 = localBuffer.readLong();
    localBuffer = new Buffer();
    localFileOperator.read(32L + l1, localBuffer, l2);
    return new Relay(paramFile, null, l1, localBuffer.readByteString(), 0L);
  }
  
  private void writeHeader(ByteString paramByteString, long paramLong1, long paramLong2)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(paramByteString);
    localBuffer.writeLong(paramLong1);
    localBuffer.writeLong(paramLong2);
    if (localBuffer.size() != 32L) {
      throw new IllegalArgumentException();
    }
    new FileOperator(this.file.getChannel()).write(0L, localBuffer, 32L);
  }
  
  private void writeMetadata(long paramLong)
    throws IOException
  {
    Buffer localBuffer = new Buffer();
    localBuffer.write(this.metadata);
    new FileOperator(this.file.getChannel()).write(32L + paramLong, localBuffer, this.metadata.size());
  }
  
  void commit(long paramLong)
    throws IOException
  {
    writeMetadata(paramLong);
    this.file.getChannel().force(false);
    writeHeader(PREFIX_CLEAN, paramLong, this.metadata.size());
    this.file.getChannel().force(false);
    try
    {
      this.complete = true;
      Util.closeQuietly(this.upstream);
      this.upstream = null;
      return;
    }
    finally {}
  }
  
  boolean isClosed()
  {
    return this.file == null;
  }
  
  public ByteString metadata()
  {
    return this.metadata;
  }
  
  public Source newSource()
  {
    try
    {
      if (this.file == null) {
        return null;
      }
      this.sourceCount += 1;
      return new RelaySource();
    }
    finally {}
  }
  
  class RelaySource
    implements Source
  {
    private FileOperator fileOperator = new FileOperator(Relay.this.file.getChannel());
    private long sourcePos;
    private final Timeout timeout = new Timeout();
    
    RelaySource() {}
    
    public void close()
      throws IOException
    {
      RandomAccessFile localRandomAccessFile = null;
      if (this.fileOperator == null) {}
      for (;;)
      {
        return;
        this.fileOperator = null;
        synchronized (Relay.this)
        {
          Relay localRelay2 = Relay.this;
          localRelay2.sourceCount -= 1;
          if (Relay.this.sourceCount == 0)
          {
            localRandomAccessFile = Relay.this.file;
            Relay.this.file = null;
          }
          if (localRandomAccessFile == null) {
            continue;
          }
          Util.closeQuietly(localRandomAccessFile);
          return;
        }
      }
    }
    
    /* Error */
    public long read(Buffer paramBuffer, long paramLong)
      throws IOException
    {
      // Byte code:
      //   0: aload_0
      //   1: getfield 46	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   4: ifnonnull +13 -> 17
      //   7: new 65	java/lang/IllegalStateException
      //   10: dup
      //   11: ldc 67
      //   13: invokespecial 70	java/lang/IllegalStateException:<init>	(Ljava/lang/String;)V
      //   16: athrow
      //   17: aload_0
      //   18: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   21: astore 9
      //   23: aload 9
      //   25: monitorenter
      //   26: aload_0
      //   27: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   30: lstore 7
      //   32: aload_0
      //   33: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   36: getfield 75	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   39: lstore 5
      //   41: lload 7
      //   43: lload 5
      //   45: lcmp
      //   46: ifne +113 -> 159
      //   49: aload_0
      //   50: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   53: getfield 79	okhttp3/internal/cache2/Relay:complete	Z
      //   56: ifeq +10 -> 66
      //   59: aload 9
      //   61: monitorexit
      //   62: ldc2_w 80
      //   65: lreturn
      //   66: aload_0
      //   67: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   70: getfield 85	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   73: ifnull +23 -> 96
      //   76: aload_0
      //   77: getfield 29	okhttp3/internal/cache2/Relay$RelaySource:timeout	Lokio/Timeout;
      //   80: aload_0
      //   81: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   84: invokevirtual 89	okio/Timeout:waitUntilNotified	(Ljava/lang/Object;)V
      //   87: goto -61 -> 26
      //   90: astore_1
      //   91: aload 9
      //   93: monitorexit
      //   94: aload_1
      //   95: athrow
      //   96: aload_0
      //   97: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   100: invokestatic 95	java/lang/Thread:currentThread	()Ljava/lang/Thread;
      //   103: putfield 85	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   106: iconst_1
      //   107: istore 4
      //   109: aload 9
      //   111: monitorexit
      //   112: iload 4
      //   114: iconst_2
      //   115: if_icmpne +125 -> 240
      //   118: lload_2
      //   119: lload 5
      //   121: aload_0
      //   122: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   125: lsub
      //   126: invokestatic 101	java/lang/Math:min	(JJ)J
      //   129: lstore_2
      //   130: aload_0
      //   131: getfield 46	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   134: ldc2_w 102
      //   137: aload_0
      //   138: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   141: ladd
      //   142: aload_1
      //   143: lload_2
      //   144: invokevirtual 106	okhttp3/internal/cache2/FileOperator:read	(JLokio/Buffer;J)V
      //   147: aload_0
      //   148: aload_0
      //   149: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   152: lload_2
      //   153: ladd
      //   154: putfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   157: lload_2
      //   158: lreturn
      //   159: lload 5
      //   161: aload_0
      //   162: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   165: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   168: invokevirtual 116	okio/Buffer:size	()J
      //   171: lsub
      //   172: lstore 7
      //   174: aload_0
      //   175: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   178: lload 7
      //   180: lcmp
      //   181: ifge +12 -> 193
      //   184: iconst_2
      //   185: istore 4
      //   187: aload 9
      //   189: monitorexit
      //   190: goto -78 -> 112
      //   193: lload_2
      //   194: lload 5
      //   196: aload_0
      //   197: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   200: lsub
      //   201: invokestatic 101	java/lang/Math:min	(JJ)J
      //   204: lstore_2
      //   205: aload_0
      //   206: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   209: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   212: aload_1
      //   213: aload_0
      //   214: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   217: lload 7
      //   219: lsub
      //   220: lload_2
      //   221: invokevirtual 120	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
      //   224: pop
      //   225: aload_0
      //   226: aload_0
      //   227: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   230: lload_2
      //   231: ladd
      //   232: putfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   235: aload 9
      //   237: monitorexit
      //   238: lload_2
      //   239: lreturn
      //   240: aload_0
      //   241: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   244: getfield 124	okhttp3/internal/cache2/Relay:upstream	Lokio/Source;
      //   247: aload_0
      //   248: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   251: getfield 127	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
      //   254: aload_0
      //   255: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   258: getfield 130	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   261: invokeinterface 132 4 0
      //   266: lstore 7
      //   268: lload 7
      //   270: ldc2_w 80
      //   273: lcmp
      //   274: ifne +47 -> 321
      //   277: aload_0
      //   278: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   281: lload 5
      //   283: invokevirtual 136	okhttp3/internal/cache2/Relay:commit	(J)V
      //   286: aload_0
      //   287: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   290: astore_1
      //   291: aload_1
      //   292: monitorenter
      //   293: aload_0
      //   294: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   297: aconst_null
      //   298: putfield 85	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   301: aload_0
      //   302: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   305: invokevirtual 139	java/lang/Object:notifyAll	()V
      //   308: aload_1
      //   309: monitorexit
      //   310: ldc2_w 80
      //   313: lreturn
      //   314: astore 9
      //   316: aload_1
      //   317: monitorexit
      //   318: aload 9
      //   320: athrow
      //   321: lload 7
      //   323: lload_2
      //   324: invokestatic 101	java/lang/Math:min	(JJ)J
      //   327: lstore_2
      //   328: aload_0
      //   329: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   332: getfield 127	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
      //   335: aload_1
      //   336: lconst_0
      //   337: lload_2
      //   338: invokevirtual 120	okio/Buffer:copyTo	(Lokio/Buffer;JJ)Lokio/Buffer;
      //   341: pop
      //   342: aload_0
      //   343: aload_0
      //   344: getfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   347: lload_2
      //   348: ladd
      //   349: putfield 72	okhttp3/internal/cache2/Relay$RelaySource:sourcePos	J
      //   352: aload_0
      //   353: getfield 46	okhttp3/internal/cache2/Relay$RelaySource:fileOperator	Lokhttp3/internal/cache2/FileOperator;
      //   356: ldc2_w 102
      //   359: lload 5
      //   361: ladd
      //   362: aload_0
      //   363: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   366: getfield 127	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
      //   369: invokevirtual 143	okio/Buffer:clone	()Lokio/Buffer;
      //   372: lload 7
      //   374: invokevirtual 146	okhttp3/internal/cache2/FileOperator:write	(JLokio/Buffer;J)V
      //   377: aload_0
      //   378: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   381: astore_1
      //   382: aload_1
      //   383: monitorenter
      //   384: aload_0
      //   385: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   388: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   391: aload_0
      //   392: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   395: getfield 127	okhttp3/internal/cache2/Relay:upstreamBuffer	Lokio/Buffer;
      //   398: lload 7
      //   400: invokevirtual 149	okio/Buffer:write	(Lokio/Buffer;J)V
      //   403: aload_0
      //   404: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   407: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   410: invokevirtual 116	okio/Buffer:size	()J
      //   413: aload_0
      //   414: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   417: getfield 130	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   420: lcmp
      //   421: ifle +31 -> 452
      //   424: aload_0
      //   425: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   428: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   431: aload_0
      //   432: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   435: getfield 110	okhttp3/internal/cache2/Relay:buffer	Lokio/Buffer;
      //   438: invokevirtual 116	okio/Buffer:size	()J
      //   441: aload_0
      //   442: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   445: getfield 130	okhttp3/internal/cache2/Relay:bufferMaxSize	J
      //   448: lsub
      //   449: invokevirtual 152	okio/Buffer:skip	(J)V
      //   452: aload_0
      //   453: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   456: astore 9
      //   458: aload 9
      //   460: aload 9
      //   462: getfield 75	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   465: lload 7
      //   467: ladd
      //   468: putfield 75	okhttp3/internal/cache2/Relay:upstreamPos	J
      //   471: aload_1
      //   472: monitorexit
      //   473: aload_0
      //   474: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   477: astore_1
      //   478: aload_1
      //   479: monitorenter
      //   480: aload_0
      //   481: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   484: aconst_null
      //   485: putfield 85	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   488: aload_0
      //   489: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   492: invokevirtual 139	java/lang/Object:notifyAll	()V
      //   495: aload_1
      //   496: monitorexit
      //   497: lload_2
      //   498: lreturn
      //   499: astore 9
      //   501: aload_1
      //   502: monitorexit
      //   503: aload 9
      //   505: athrow
      //   506: astore 9
      //   508: aload_1
      //   509: monitorexit
      //   510: aload 9
      //   512: athrow
      //   513: astore 9
      //   515: aload_0
      //   516: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   519: astore_1
      //   520: aload_1
      //   521: monitorenter
      //   522: aload_0
      //   523: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   526: aconst_null
      //   527: putfield 85	okhttp3/internal/cache2/Relay:upstreamReader	Ljava/lang/Thread;
      //   530: aload_0
      //   531: getfield 21	okhttp3/internal/cache2/Relay$RelaySource:this$0	Lokhttp3/internal/cache2/Relay;
      //   534: invokevirtual 139	java/lang/Object:notifyAll	()V
      //   537: aload_1
      //   538: monitorexit
      //   539: aload 9
      //   541: athrow
      //   542: astore 9
      //   544: aload_1
      //   545: monitorexit
      //   546: aload 9
      //   548: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	549	0	this	RelaySource
      //   0	549	1	paramBuffer	Buffer
      //   0	549	2	paramLong	long
      //   107	79	4	i	int
      //   39	321	5	l1	long
      //   30	436	7	l2	long
      //   21	215	9	localRelay1	Relay
      //   314	5	9	localObject1	Object
      //   456	5	9	localRelay2	Relay
      //   499	5	9	localObject2	Object
      //   506	5	9	localObject3	Object
      //   513	27	9	localObject4	Object
      //   542	5	9	localObject5	Object
      // Exception table:
      //   from	to	target	type
      //   26	41	90	finally
      //   49	62	90	finally
      //   66	87	90	finally
      //   91	94	90	finally
      //   96	106	90	finally
      //   109	112	90	finally
      //   159	184	90	finally
      //   187	190	90	finally
      //   193	238	90	finally
      //   293	310	314	finally
      //   316	318	314	finally
      //   480	497	499	finally
      //   501	503	499	finally
      //   384	452	506	finally
      //   452	473	506	finally
      //   508	510	506	finally
      //   240	268	513	finally
      //   277	286	513	finally
      //   321	384	513	finally
      //   510	513	513	finally
      //   522	539	542	finally
      //   544	546	542	finally
    }
    
    public Timeout timeout()
    {
      return this.timeout;
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.internal.cache2.Relay
 * JD-Core Version:    0.7.0.1
 */