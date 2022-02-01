package okhttp3;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Iterator;
import java.util.List;
import javax.annotation.Nullable;
import okhttp3.internal.Util;
import okhttp3.internal.cache.CacheRequest;
import okhttp3.internal.cache.DiskLruCache;
import okhttp3.internal.cache.DiskLruCache.Editor;
import okhttp3.internal.cache.DiskLruCache.Snapshot;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http.StatusLine;
import okhttp3.internal.io.FileSystem;
import okhttp3.internal.platform.Platform;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
  implements Closeable, Flushable
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new Cache.1(this);
  private int networkCount;
  private int requestCount;
  int writeAbortCount;
  int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(@Nullable DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  public static String key(HttpUrl paramHttpUrl)
  {
    return ByteString.encodeUtf8(paramHttpUrl.toString()).md5().hex();
  }
  
  static int readInt(BufferedSource paramBufferedSource)
    throws IOException
  {
    long l;
    try
    {
      l = paramBufferedSource.readDecimalLong();
      paramBufferedSource = paramBufferedSource.readUtf8LineStrict();
      if ((l < 0L) || (l > 2147483647L) || (!paramBufferedSource.isEmpty())) {
        throw new IOException("expected an int but was \"" + l + paramBufferedSource + "\"");
      }
    }
    catch (NumberFormatException paramBufferedSource)
    {
      throw new IOException(paramBufferedSource.getMessage());
    }
    return (int)l;
  }
  
  public void close()
    throws IOException
  {
    this.cache.close();
  }
  
  public void delete()
    throws IOException
  {
    this.cache.delete();
  }
  
  public File directory()
  {
    return this.cache.getDirectory();
  }
  
  public void evictAll()
    throws IOException
  {
    this.cache.evictAll();
  }
  
  public void flush()
    throws IOException
  {
    this.cache.flush();
  }
  
  @Nullable
  Response get(Request paramRequest)
  {
    Object localObject = key(paramRequest.url());
    try
    {
      localObject = this.cache.get((String)localObject);
      if (localObject == null) {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        localObject = localEntry.response((DiskLruCache.Snapshot)localObject);
        if (!localEntry.matches(paramRequest, (Response)localObject))
        {
          Util.closeQuietly(((Response)localObject).body());
          return null;
        }
      }
      catch (IOException paramRequest)
      {
        Util.closeQuietly((Closeable)localObject);
        return null;
      }
      return localObject;
    }
    catch (IOException paramRequest) {}
    return null;
  }
  
  public int hitCount()
  {
    try
    {
      int i = this.hitCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public long maxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int networkCount()
  {
    try
    {
      int i = this.networkCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  @Nullable
  CacheRequest put(Response paramResponse)
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 221	okhttp3/Response:request	()Lokhttp3/Request;
    //   4: invokevirtual 224	okhttp3/Request:method	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 221	okhttp3/Response:request	()Lokhttp3/Request;
    //   12: invokevirtual 224	okhttp3/Request:method	()Ljava/lang/String;
    //   15: invokestatic 230	okhttp3/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 221	okhttp3/Response:request	()Lokhttp3/Request;
    //   26: invokevirtual 234	okhttp3/Cache:remove	(Lokhttp3/Request;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 236
    //   34: invokevirtual 240	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 246	okhttp3/internal/http/HttpHeaders:hasVaryAll	(Lokhttp3/Response;)Z
    //   44: ifne -15 -> 29
    //   47: new 16	okhttp3/Cache$Entry
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 249	okhttp3/Cache$Entry:<init>	(Lokhttp3/Response;)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 65	okhttp3/Cache:cache	Lokhttp3/internal/cache/DiskLruCache;
    //   60: aload_1
    //   61: invokevirtual 221	okhttp3/Response:request	()Lokhttp3/Request;
    //   64: invokevirtual 165	okhttp3/Request:url	()Lokhttp3/HttpUrl;
    //   67: invokestatic 167	okhttp3/Cache:key	(Lokhttp3/HttpUrl;)Ljava/lang/String;
    //   70: invokevirtual 253	okhttp3/internal/cache/DiskLruCache:edit	(Ljava/lang/String;)Lokhttp3/internal/cache/DiskLruCache$Editor;
    //   73: astore_1
    //   74: aload_1
    //   75: ifnull -46 -> 29
    //   78: aload_2
    //   79: aload_1
    //   80: invokevirtual 256	okhttp3/Cache$Entry:writeTo	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   83: new 10	okhttp3/Cache$CacheRequestImpl
    //   86: dup
    //   87: aload_0
    //   88: aload_1
    //   89: invokespecial 259	okhttp3/Cache$CacheRequestImpl:<init>	(Lokhttp3/Cache;Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   92: astore_2
    //   93: aload_2
    //   94: areturn
    //   95: astore_1
    //   96: aconst_null
    //   97: astore_1
    //   98: aload_0
    //   99: aload_1
    //   100: invokespecial 261	okhttp3/Cache:abortQuietly	(Lokhttp3/internal/cache/DiskLruCache$Editor;)V
    //   103: aconst_null
    //   104: areturn
    //   105: astore_2
    //   106: goto -8 -> 98
    //   109: astore_1
    //   110: aconst_null
    //   111: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	112	0	this	Cache
    //   0	112	1	paramResponse	Response
    //   7	87	2	localObject	Object
    //   105	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   56	74	95	java/io/IOException
    //   78	93	105	java/io/IOException
    //   21	29	109	java/io/IOException
  }
  
  void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(key(paramRequest.url()));
  }
  
  public int requestCount()
  {
    try
    {
      int i = this.requestCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public long size()
    throws IOException
  {
    return this.cache.size();
  }
  
  void trackConditionalCacheHit()
  {
    try
    {
      this.hitCount += 1;
      return;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  /* Error */
  void trackResponse(okhttp3.internal.cache.CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 265	okhttp3/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 265	okhttp3/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 277	okhttp3/internal/cache/CacheStrategy:networkRequest	Lokhttp3/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 215	okhttp3/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 215	okhttp3/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 281	okhttp3/internal/cache/CacheStrategy:cacheResponse	Lokhttp3/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 203	okhttp3/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 203	okhttp3/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	okhttp3.internal.cache.CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  void update(Response paramResponse1, Response paramResponse2)
  {
    Entry localEntry = new Entry(paramResponse2);
    paramResponse2 = ((CacheResponseBody)paramResponse1.body()).snapshot;
    paramResponse1 = null;
    try
    {
      paramResponse2 = paramResponse2.edit();
      if (paramResponse2 != null)
      {
        paramResponse1 = paramResponse2;
        localEntry.writeTo(paramResponse2);
        paramResponse1 = paramResponse2;
        paramResponse2.commit();
      }
      return;
    }
    catch (IOException paramResponse2)
    {
      abortQuietly(paramResponse1);
    }
  }
  
  public Iterator<String> urls()
    throws IOException
  {
    return new Cache.2(this);
  }
  
  public int writeAbortCount()
  {
    try
    {
      int i = this.writeAbortCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  public int writeSuccessCount()
  {
    try
    {
      int i = this.writeSuccessCount;
      return i;
    }
    finally
    {
      localObject = finally;
      throw localObject;
    }
  }
  
  final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    boolean done;
    private final DiskLruCache.Editor editor;
    
    CacheRequestImpl(DiskLruCache.Editor paramEditor)
    {
      this.editor = paramEditor;
      this.cacheOut = paramEditor.newSink(1);
      this.body = new Cache.CacheRequestImpl.1(this, this.cacheOut, Cache.this, paramEditor);
    }
    
    public void abort()
    {
      synchronized (Cache.this)
      {
        if (this.done) {
          return;
        }
        this.done = true;
        Cache localCache2 = Cache.this;
        localCache2.writeAbortCount += 1;
        Util.closeQuietly(this.cacheOut);
        try
        {
          this.editor.abort();
          return;
        }
        catch (IOException localIOException) {}
      }
    }
    
    public Sink body()
    {
      return this.body;
    }
  }
  
  static class CacheResponseBody
    extends ResponseBody
  {
    private final BufferedSource bodySource;
    @Nullable
    private final String contentLength;
    @Nullable
    private final String contentType;
    final DiskLruCache.Snapshot snapshot;
    
    CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
    {
      this.snapshot = paramSnapshot;
      this.contentType = paramString1;
      this.contentLength = paramString2;
      this.bodySource = Okio.buffer(new Cache.CacheResponseBody.1(this, paramSnapshot.getSource(1), paramSnapshot));
    }
    
    public long contentLength()
    {
      long l = -1L;
      try
      {
        if (this.contentLength != null) {
          l = Long.parseLong(this.contentLength);
        }
        return l;
      }
      catch (NumberFormatException localNumberFormatException) {}
      return -1L;
    }
    
    public MediaType contentType()
    {
      if (this.contentType != null) {
        return MediaType.parse(this.contentType);
      }
      return null;
    }
    
    public BufferedSource source()
    {
      return this.bodySource;
    }
  }
  
  static final class Entry
  {
    private static final String RECEIVED_MILLIS = Platform.get().getPrefix() + "-Received-Millis";
    private static final String SENT_MILLIS = Platform.get().getPrefix() + "-Sent-Millis";
    private final int code;
    @Nullable
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final long receivedResponseMillis;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final long sentRequestMillis;
    private final String url;
    private final Headers varyHeaders;
    
    Entry(Response paramResponse)
    {
      this.url = paramResponse.request().url().toString();
      this.varyHeaders = HttpHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
      this.sentRequestMillis = paramResponse.sentRequestAtMillis();
      this.receivedResponseMillis = paramResponse.receivedResponseAtMillis();
    }
    
    Entry(Source paramSource)
      throws IOException
    {
      for (;;)
      {
        try
        {
          BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
          this.url = localBufferedSource1.readUtf8LineStrict();
          this.requestMethod = localBufferedSource1.readUtf8LineStrict();
          localObject1 = new Headers.Builder();
          int k = Cache.readInt(localBufferedSource1);
          int i = 0;
          if (i < k)
          {
            ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
            i += 1;
            continue;
          }
          this.varyHeaders = ((Headers.Builder)localObject1).build();
          localObject1 = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
          this.protocol = ((StatusLine)localObject1).protocol;
          this.code = ((StatusLine)localObject1).code;
          this.message = ((StatusLine)localObject1).message;
          localObject1 = new Headers.Builder();
          k = Cache.readInt(localBufferedSource1);
          i = j;
          if (i < k)
          {
            ((Headers.Builder)localObject1).addLenient(localBufferedSource1.readUtf8LineStrict());
            i += 1;
            continue;
          }
          localObject2 = ((Headers.Builder)localObject1).get(SENT_MILLIS);
          localObject3 = ((Headers.Builder)localObject1).get(RECEIVED_MILLIS);
          ((Headers.Builder)localObject1).removeAll(SENT_MILLIS);
          ((Headers.Builder)localObject1).removeAll(RECEIVED_MILLIS);
          if (localObject2 != null)
          {
            l1 = Long.parseLong((String)localObject2);
            this.sentRequestMillis = l1;
            l1 = l2;
            if (localObject3 != null) {
              l1 = Long.parseLong((String)localObject3);
            }
            this.receivedResponseMillis = l1;
            this.responseHeaders = ((Headers.Builder)localObject1).build();
            if (!isHttps()) {
              break label414;
            }
            localObject1 = localBufferedSource1.readUtf8LineStrict();
            if (((String)localObject1).length() <= 0) {
              break;
            }
            throw new IOException("expected \"\" but was \"" + (String)localObject1 + "\"");
          }
        }
        finally
        {
          paramSource.close();
        }
        long l1 = 0L;
      }
      Object localObject1 = CipherSuite.forJavaName(localBufferedSource2.readUtf8LineStrict());
      Object localObject2 = readCertificateList(localBufferedSource2);
      Object localObject3 = readCertificateList(localBufferedSource2);
      TlsVersion localTlsVersion;
      if (!localBufferedSource2.exhausted()) {
        localTlsVersion = TlsVersion.forJavaName(localBufferedSource2.readUtf8LineStrict());
      }
      label414:
      for (this.handshake = Handshake.get(localTlsVersion, (CipherSuite)localObject1, (List)localObject2, (List)localObject3);; this.handshake = null)
      {
        paramSource.close();
        return;
        localTlsVersion = TlsVersion.SSL_3_0;
        break;
      }
    }
    
    private boolean isHttps()
    {
      return this.url.startsWith("https://");
    }
    
    /* Error */
    private List<Certificate> readCertificateList(BufferedSource paramBufferedSource)
      throws IOException
    {
      // Byte code:
      //   0: aload_1
      //   1: invokestatic 146	okhttp3/Cache:readInt	(Lokio/BufferedSource;)I
      //   4: istore_3
      //   5: iload_3
      //   6: iconst_m1
      //   7: if_icmpne +11 -> 18
      //   10: invokestatic 237	java/util/Collections:emptyList	()Ljava/util/List;
      //   13: astore 4
      //   15: aload 4
      //   17: areturn
      //   18: ldc 239
      //   20: invokestatic 245	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   23: astore 6
      //   25: new 247	java/util/ArrayList
      //   28: dup
      //   29: iload_3
      //   30: invokespecial 250	java/util/ArrayList:<init>	(I)V
      //   33: astore 5
      //   35: iconst_0
      //   36: istore_2
      //   37: aload 5
      //   39: astore 4
      //   41: iload_2
      //   42: iload_3
      //   43: if_icmpge -28 -> 15
      //   46: aload_1
      //   47: invokeinterface 139 1 0
      //   52: astore 4
      //   54: new 252	okio/Buffer
      //   57: dup
      //   58: invokespecial 253	okio/Buffer:<init>	()V
      //   61: astore 7
      //   63: aload 7
      //   65: aload 4
      //   67: invokestatic 259	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
      //   70: invokevirtual 263	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
      //   73: pop
      //   74: aload 5
      //   76: aload 6
      //   78: aload 7
      //   80: invokevirtual 267	okio/Buffer:inputStream	()Ljava/io/InputStream;
      //   83: invokevirtual 271	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   86: invokeinterface 277 2 0
      //   91: pop
      //   92: iload_2
      //   93: iconst_1
      //   94: iadd
      //   95: istore_2
      //   96: goto -59 -> 37
      //   99: astore_1
      //   100: new 128	java/io/IOException
      //   103: dup
      //   104: aload_1
      //   105: invokevirtual 280	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
      //   108: invokespecial 190	java/io/IOException:<init>	(Ljava/lang/String;)V
      //   111: athrow
      // Local variable table:
      //   start	length	slot	name	signature
      //   0	112	0	this	Entry
      //   0	112	1	paramBufferedSource	BufferedSource
      //   36	60	2	i	int
      //   4	40	3	j	int
      //   13	53	4	localObject	Object
      //   33	42	5	localArrayList	java.util.ArrayList
      //   23	54	6	localCertificateFactory	java.security.cert.CertificateFactory
      //   61	18	7	localBuffer	okio.Buffer
      // Exception table:
      //   from	to	target	type
      //   18	35	99	java/security/cert/CertificateException
      //   46	92	99	java/security/cert/CertificateException
    }
    
    private void writeCertList(BufferedSink paramBufferedSink, List<Certificate> paramList)
      throws IOException
    {
      try
      {
        paramBufferedSink.writeDecimalLong(paramList.size()).writeByte(10);
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64()).writeByte(10);
          i += 1;
        }
        return;
      }
      catch (CertificateEncodingException paramBufferedSink)
      {
        throw new IOException(paramBufferedSink.getMessage());
      }
    }
    
    public boolean matches(Request paramRequest, Response paramResponse)
    {
      return (this.url.equals(paramRequest.url().toString())) && (this.requestMethod.equals(paramRequest.method())) && (HttpHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }
    
    public Response response(DiskLruCache.Snapshot paramSnapshot)
    {
      String str1 = this.responseHeaders.get("Content-Type");
      String str2 = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, str1, str2)).handshake(this.handshake).sentRequestAtMillis(this.sentRequestMillis).receivedResponseAtMillis(this.receivedResponseMillis).build();
    }
    
    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      int j = 0;
      paramEditor = Okio.buffer(paramEditor.newSink(0));
      paramEditor.writeUtf8(this.url).writeByte(10);
      paramEditor.writeUtf8(this.requestMethod).writeByte(10);
      paramEditor.writeDecimalLong(this.varyHeaders.size()).writeByte(10);
      int k = this.varyHeaders.size();
      int i = 0;
      while (i < k)
      {
        paramEditor.writeUtf8(this.varyHeaders.name(i)).writeUtf8(": ").writeUtf8(this.varyHeaders.value(i)).writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString()).writeByte(10);
      paramEditor.writeDecimalLong(this.responseHeaders.size() + 2).writeByte(10);
      k = this.responseHeaders.size();
      i = j;
      while (i < k)
      {
        paramEditor.writeUtf8(this.responseHeaders.name(i)).writeUtf8(": ").writeUtf8(this.responseHeaders.value(i)).writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(SENT_MILLIS).writeUtf8(": ").writeDecimalLong(this.sentRequestMillis).writeByte(10);
      paramEditor.writeUtf8(RECEIVED_MILLIS).writeUtf8(": ").writeDecimalLong(this.receivedResponseMillis).writeByte(10);
      if (isHttps())
      {
        paramEditor.writeByte(10);
        paramEditor.writeUtf8(this.handshake.cipherSuite().javaName()).writeByte(10);
        writeCertList(paramEditor, this.handshake.peerCertificates());
        writeCertList(paramEditor, this.handshake.localCertificates());
        paramEditor.writeUtf8(this.handshake.tlsVersion().javaName()).writeByte(10);
      }
      paramEditor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes14.jar
 * Qualified Name:     okhttp3.Cache
 * JD-Core Version:    0.7.0.1
 */