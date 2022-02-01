package com.squareup.okhttp;

import com.squareup.okhttp.internal.DiskLruCache;
import com.squareup.okhttp.internal.DiskLruCache.Editor;
import com.squareup.okhttp.internal.DiskLruCache.Snapshot;
import com.squareup.okhttp.internal.InternalCache;
import com.squareup.okhttp.internal.Util;
import com.squareup.okhttp.internal.http.CacheRequest;
import com.squareup.okhttp.internal.http.OkHeaders;
import com.squareup.okhttp.internal.http.StatusLine;
import com.squareup.okhttp.internal.io.FileSystem;
import java.io.Closeable;
import java.io.File;
import java.io.IOException;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.util.Iterator;
import java.util.List;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class Cache
{
  private static final int ENTRY_BODY = 1;
  private static final int ENTRY_COUNT = 2;
  private static final int ENTRY_METADATA = 0;
  private static final int VERSION = 201105;
  private final DiskLruCache cache;
  private int hitCount;
  final InternalCache internalCache = new Cache.1(this);
  private int networkCount;
  private int requestCount;
  private int writeAbortCount;
  private int writeSuccessCount;
  
  public Cache(File paramFile, long paramLong)
  {
    this(paramFile, paramLong, FileSystem.SYSTEM);
  }
  
  Cache(File paramFile, long paramLong, FileSystem paramFileSystem)
  {
    this.cache = DiskLruCache.create(paramFileSystem, paramFile, 201105, 2, paramLong);
  }
  
  private void abortQuietly(DiskLruCache.Editor paramEditor)
  {
    if (paramEditor != null) {}
    try
    {
      paramEditor.abort();
      return;
    }
    catch (IOException paramEditor) {}
  }
  
  /* Error */
  private CacheRequest put(Response paramResponse)
    throws IOException
  {
    // Byte code:
    //   0: aload_1
    //   1: invokevirtual 119	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   4: invokevirtual 125	com/squareup/okhttp/Request:method	()Ljava/lang/String;
    //   7: astore_2
    //   8: aload_1
    //   9: invokevirtual 119	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   12: invokevirtual 125	com/squareup/okhttp/Request:method	()Ljava/lang/String;
    //   15: invokestatic 131	com/squareup/okhttp/internal/http/HttpMethod:invalidatesCache	(Ljava/lang/String;)Z
    //   18: ifeq +13 -> 31
    //   21: aload_0
    //   22: aload_1
    //   23: invokevirtual 119	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   26: invokespecial 83	com/squareup/okhttp/Cache:remove	(Lcom/squareup/okhttp/Request;)V
    //   29: aconst_null
    //   30: areturn
    //   31: aload_2
    //   32: ldc 133
    //   34: invokevirtual 139	java/lang/String:equals	(Ljava/lang/Object;)Z
    //   37: ifeq -8 -> 29
    //   40: aload_1
    //   41: invokestatic 145	com/squareup/okhttp/internal/http/OkHeaders:hasVaryAll	(Lcom/squareup/okhttp/Response;)Z
    //   44: ifne -15 -> 29
    //   47: new 12	com/squareup/okhttp/Cache$Entry
    //   50: dup
    //   51: aload_1
    //   52: invokespecial 148	com/squareup/okhttp/Cache$Entry:<init>	(Lcom/squareup/okhttp/Response;)V
    //   55: astore_2
    //   56: aload_0
    //   57: getfield 61	com/squareup/okhttp/Cache:cache	Lcom/squareup/okhttp/internal/DiskLruCache;
    //   60: aload_1
    //   61: invokevirtual 119	com/squareup/okhttp/Response:request	()Lcom/squareup/okhttp/Request;
    //   64: invokestatic 152	com/squareup/okhttp/Cache:urlToKey	(Lcom/squareup/okhttp/Request;)Ljava/lang/String;
    //   67: invokevirtual 156	com/squareup/okhttp/internal/DiskLruCache:edit	(Ljava/lang/String;)Lcom/squareup/okhttp/internal/DiskLruCache$Editor;
    //   70: astore_1
    //   71: aload_1
    //   72: ifnull -43 -> 29
    //   75: aload_2
    //   76: aload_1
    //   77: invokevirtual 159	com/squareup/okhttp/Cache$Entry:writeTo	(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   80: new 6	com/squareup/okhttp/Cache$CacheRequestImpl
    //   83: dup
    //   84: aload_0
    //   85: aload_1
    //   86: invokespecial 162	com/squareup/okhttp/Cache$CacheRequestImpl:<init>	(Lcom/squareup/okhttp/Cache;Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   89: astore_2
    //   90: aload_2
    //   91: areturn
    //   92: astore_1
    //   93: aconst_null
    //   94: astore_1
    //   95: aload_0
    //   96: aload_1
    //   97: invokespecial 164	com/squareup/okhttp/Cache:abortQuietly	(Lcom/squareup/okhttp/internal/DiskLruCache$Editor;)V
    //   100: aconst_null
    //   101: areturn
    //   102: astore_2
    //   103: goto -8 -> 95
    //   106: astore_1
    //   107: aconst_null
    //   108: areturn
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	109	0	this	Cache
    //   0	109	1	paramResponse	Response
    //   7	84	2	localObject	Object
    //   102	1	2	localIOException	IOException
    // Exception table:
    //   from	to	target	type
    //   56	71	92	java/io/IOException
    //   75	90	102	java/io/IOException
    //   21	29	106	java/io/IOException
  }
  
  private static int readInt(BufferedSource paramBufferedSource)
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
  
  private void remove(Request paramRequest)
    throws IOException
  {
    this.cache.remove(urlToKey(paramRequest));
  }
  
  private void trackConditionalCacheHit()
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
  private void trackResponse(com.squareup.okhttp.internal.http.CacheStrategy paramCacheStrategy)
  {
    // Byte code:
    //   0: aload_0
    //   1: monitorenter
    //   2: aload_0
    //   3: aload_0
    //   4: getfield 210	com/squareup/okhttp/Cache:requestCount	I
    //   7: iconst_1
    //   8: iadd
    //   9: putfield 210	com/squareup/okhttp/Cache:requestCount	I
    //   12: aload_1
    //   13: getfield 216	com/squareup/okhttp/internal/http/CacheStrategy:networkRequest	Lcom/squareup/okhttp/Request;
    //   16: ifnull +16 -> 32
    //   19: aload_0
    //   20: aload_0
    //   21: getfield 218	com/squareup/okhttp/Cache:networkCount	I
    //   24: iconst_1
    //   25: iadd
    //   26: putfield 218	com/squareup/okhttp/Cache:networkCount	I
    //   29: aload_0
    //   30: monitorexit
    //   31: return
    //   32: aload_1
    //   33: getfield 222	com/squareup/okhttp/internal/http/CacheStrategy:cacheResponse	Lcom/squareup/okhttp/Response;
    //   36: ifnull -7 -> 29
    //   39: aload_0
    //   40: aload_0
    //   41: getfield 208	com/squareup/okhttp/Cache:hitCount	I
    //   44: iconst_1
    //   45: iadd
    //   46: putfield 208	com/squareup/okhttp/Cache:hitCount	I
    //   49: goto -20 -> 29
    //   52: astore_1
    //   53: aload_0
    //   54: monitorexit
    //   55: aload_1
    //   56: athrow
    // Local variable table:
    //   start	length	slot	name	signature
    //   0	57	0	this	Cache
    //   0	57	1	paramCacheStrategy	com.squareup.okhttp.internal.http.CacheStrategy
    // Exception table:
    //   from	to	target	type
    //   2	29	52	finally
    //   32	49	52	finally
  }
  
  private void update(Response paramResponse1, Response paramResponse2)
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
  
  private static String urlToKey(Request paramRequest)
  {
    return Util.md5Hex(paramRequest.urlString());
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
  
  Response get(Request paramRequest)
  {
    Object localObject = urlToKey(paramRequest);
    try
    {
      localObject = this.cache.get((String)localObject);
      if (localObject == null) {
        return null;
      }
      try
      {
        Entry localEntry = new Entry(((DiskLruCache.Snapshot)localObject).getSource(0));
        localObject = localEntry.response(paramRequest, (DiskLruCache.Snapshot)localObject);
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
  
  public File getDirectory()
  {
    return this.cache.getDirectory();
  }
  
  public int getHitCount()
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
  
  public long getMaxSize()
  {
    return this.cache.getMaxSize();
  }
  
  public int getNetworkCount()
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
  
  public int getRequestCount()
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
  
  public long getSize()
    throws IOException
  {
    return this.cache.size();
  }
  
  public int getWriteAbortCount()
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
  
  public int getWriteSuccessCount()
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
  
  public void initialize()
    throws IOException
  {
    this.cache.initialize();
  }
  
  public boolean isClosed()
  {
    return this.cache.isClosed();
  }
  
  public Iterator<String> urls()
    throws IOException
  {
    return new Cache.2(this);
  }
  
  final class CacheRequestImpl
    implements CacheRequest
  {
    private Sink body;
    private Sink cacheOut;
    private boolean done;
    private final DiskLruCache.Editor editor;
    
    public CacheRequestImpl(DiskLruCache.Editor paramEditor)
      throws IOException
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
        Cache.access$908(Cache.this);
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
    private final String contentLength;
    private final String contentType;
    private final DiskLruCache.Snapshot snapshot;
    
    public CacheResponseBody(DiskLruCache.Snapshot paramSnapshot, String paramString1, String paramString2)
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
    private final int code;
    private final Handshake handshake;
    private final String message;
    private final Protocol protocol;
    private final String requestMethod;
    private final Headers responseHeaders;
    private final String url;
    private final Headers varyHeaders;
    
    public Entry(Response paramResponse)
    {
      this.url = paramResponse.request().urlString();
      this.varyHeaders = OkHeaders.varyHeaders(paramResponse);
      this.requestMethod = paramResponse.request().method();
      this.protocol = paramResponse.protocol();
      this.code = paramResponse.code();
      this.message = paramResponse.message();
      this.responseHeaders = paramResponse.headers();
      this.handshake = paramResponse.handshake();
    }
    
    public Entry(Source paramSource)
      throws IOException
    {
      try
      {
        BufferedSource localBufferedSource1 = Okio.buffer(paramSource);
        this.url = localBufferedSource1.readUtf8LineStrict();
        this.requestMethod = localBufferedSource1.readUtf8LineStrict();
        Object localObject = new Headers.Builder();
        int k = Cache.readInt(localBufferedSource1);
        int i = 0;
        while (i < k)
        {
          ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        this.varyHeaders = ((Headers.Builder)localObject).build();
        localObject = StatusLine.parse(localBufferedSource1.readUtf8LineStrict());
        this.protocol = ((StatusLine)localObject).protocol;
        this.code = ((StatusLine)localObject).code;
        this.message = ((StatusLine)localObject).message;
        localObject = new Headers.Builder();
        k = Cache.readInt(localBufferedSource1);
        i = j;
        while (i < k)
        {
          ((Headers.Builder)localObject).addLenient(localBufferedSource1.readUtf8LineStrict());
          i += 1;
        }
        this.responseHeaders = ((Headers.Builder)localObject).build();
        if (isHttps())
        {
          localObject = localBufferedSource1.readUtf8LineStrict();
          if (((String)localObject).length() > 0) {
            throw new IOException("expected \"\" but was \"" + (String)localObject + "\"");
          }
        }
      }
      finally
      {
        paramSource.close();
      }
      for (this.handshake = Handshake.get(localBufferedSource2.readUtf8LineStrict(), readCertificateList(localBufferedSource2), readCertificateList(localBufferedSource2));; this.handshake = null)
      {
        paramSource.close();
        return;
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
      //   1: invokestatic 98	com/squareup/okhttp/Cache:access$1000	(Lokio/BufferedSource;)I
      //   4: istore_3
      //   5: iload_3
      //   6: iconst_m1
      //   7: if_icmpne +11 -> 18
      //   10: invokestatic 170	java/util/Collections:emptyList	()Ljava/util/List;
      //   13: astore 4
      //   15: aload 4
      //   17: areturn
      //   18: ldc 172
      //   20: invokestatic 178	java/security/cert/CertificateFactory:getInstance	(Ljava/lang/String;)Ljava/security/cert/CertificateFactory;
      //   23: astore 6
      //   25: new 180	java/util/ArrayList
      //   28: dup
      //   29: iload_3
      //   30: invokespecial 183	java/util/ArrayList:<init>	(I)V
      //   33: astore 5
      //   35: iconst_0
      //   36: istore_2
      //   37: aload 5
      //   39: astore 4
      //   41: iload_2
      //   42: iload_3
      //   43: if_icmpge -28 -> 15
      //   46: aload_1
      //   47: invokeinterface 91 1 0
      //   52: astore 4
      //   54: new 185	okio/Buffer
      //   57: dup
      //   58: invokespecial 186	okio/Buffer:<init>	()V
      //   61: astore 7
      //   63: aload 7
      //   65: aload 4
      //   67: invokestatic 192	okio/ByteString:decodeBase64	(Ljava/lang/String;)Lokio/ByteString;
      //   70: invokevirtual 196	okio/Buffer:write	(Lokio/ByteString;)Lokio/Buffer;
      //   73: pop
      //   74: aload 5
      //   76: aload 6
      //   78: aload 7
      //   80: invokevirtual 200	okio/Buffer:inputStream	()Ljava/io/InputStream;
      //   83: invokevirtual 204	java/security/cert/CertificateFactory:generateCertificate	(Ljava/io/InputStream;)Ljava/security/cert/Certificate;
      //   86: invokeinterface 210 2 0
      //   91: pop
      //   92: iload_2
      //   93: iconst_1
      //   94: iadd
      //   95: istore_2
      //   96: goto -59 -> 37
      //   99: astore_1
      //   100: new 80	java/io/IOException
      //   103: dup
      //   104: aload_1
      //   105: invokevirtual 213	java/security/cert/CertificateException:getMessage	()Ljava/lang/String;
      //   108: invokespecial 140	java/io/IOException:<init>	(Ljava/lang/String;)V
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
        paramBufferedSink.writeDecimalLong(paramList.size());
        paramBufferedSink.writeByte(10);
        int j = paramList.size();
        int i = 0;
        while (i < j)
        {
          paramBufferedSink.writeUtf8(ByteString.of(((Certificate)paramList.get(i)).getEncoded()).base64());
          paramBufferedSink.writeByte(10);
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
      return (this.url.equals(paramRequest.urlString())) && (this.requestMethod.equals(paramRequest.method())) && (OkHeaders.varyMatches(paramResponse, this.varyHeaders, paramRequest));
    }
    
    public Response response(Request paramRequest, DiskLruCache.Snapshot paramSnapshot)
    {
      paramRequest = this.responseHeaders.get("Content-Type");
      String str = this.responseHeaders.get("Content-Length");
      Request localRequest = new Request.Builder().url(this.url).method(this.requestMethod, null).headers(this.varyHeaders).build();
      return new Response.Builder().request(localRequest).protocol(this.protocol).code(this.code).message(this.message).headers(this.responseHeaders).body(new Cache.CacheResponseBody(paramSnapshot, paramRequest, str)).handshake(this.handshake).build();
    }
    
    public void writeTo(DiskLruCache.Editor paramEditor)
      throws IOException
    {
      int j = 0;
      paramEditor = Okio.buffer(paramEditor.newSink(0));
      paramEditor.writeUtf8(this.url);
      paramEditor.writeByte(10);
      paramEditor.writeUtf8(this.requestMethod);
      paramEditor.writeByte(10);
      paramEditor.writeDecimalLong(this.varyHeaders.size());
      paramEditor.writeByte(10);
      int k = this.varyHeaders.size();
      int i = 0;
      while (i < k)
      {
        paramEditor.writeUtf8(this.varyHeaders.name(i));
        paramEditor.writeUtf8(": ");
        paramEditor.writeUtf8(this.varyHeaders.value(i));
        paramEditor.writeByte(10);
        i += 1;
      }
      paramEditor.writeUtf8(new StatusLine(this.protocol, this.code, this.message).toString());
      paramEditor.writeByte(10);
      paramEditor.writeDecimalLong(this.responseHeaders.size());
      paramEditor.writeByte(10);
      k = this.responseHeaders.size();
      i = j;
      while (i < k)
      {
        paramEditor.writeUtf8(this.responseHeaders.name(i));
        paramEditor.writeUtf8(": ");
        paramEditor.writeUtf8(this.responseHeaders.value(i));
        paramEditor.writeByte(10);
        i += 1;
      }
      if (isHttps())
      {
        paramEditor.writeByte(10);
        paramEditor.writeUtf8(this.handshake.cipherSuite());
        paramEditor.writeByte(10);
        writeCertList(paramEditor, this.handshake.peerCertificates());
        writeCertList(paramEditor, this.handshake.localCertificates());
      }
      paramEditor.close();
    }
  }
}


/* Location:           L:\local\mybackup\temp\qq_apk\com.tencent.tim\classes5.jar
 * Qualified Name:     com.squareup.okhttp.Cache
 * JD-Core Version:    0.7.0.1
 */